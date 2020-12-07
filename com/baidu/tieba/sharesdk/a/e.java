package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;
/* loaded from: classes24.dex */
public class e extends a {
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> fyI;
    private com.baidu.tieba.sharesdk.b.b mZO;
    private WbShareHandler mZP;
    private WbShareCallback mZQ;
    private ShareEntity mZy;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.fyI = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.mZy, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.mZy, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.mZO != null) {
                    e.this.mZO.ds(6, 3);
                }
                e.this.dt(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.mZO = bVar;
        this.mZQ = wbShareCallback;
        this.mZP = new WbShareHandler(activity);
        if (this.mZP != null) {
            this.mZP.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mZP == null) {
            dt(2, 6);
            if (bVar != null) {
                bVar.ds(6, 2);
                return;
            }
            return;
        }
        this.mZy = shareEntity;
        this.mZO = bVar;
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            a(this.mZy, a2.getRawBitmap());
            return;
        }
        String bmL = shareEntity.bmL();
        if (Di(shareEntity.dKQ())) {
            a(this.mZy, SW(shareEntity.dKQ()));
        } else if (!TextUtils.isEmpty(bmL) && (bmL.startsWith("http://") || bmL.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.mS().a(bmL, 10, this.fyI, 0, 0, getPageId(), new Object[0]);
        } else if (u(shareEntity.getImageUri())) {
            a(this.mZy, B(shareEntity.getImageUri()));
        } else {
            a(this.mZy, dKX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.mZy == null || this.mZP == null || !(this.context instanceof Activity)) {
            if (this.mZO != null) {
                this.mZO.ds(6, 2);
            }
            dt(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dKZ();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = K(bitmap);
        }
        WebpageObject a2 = a(weiboMultiMessage, shareEntity, bitmap);
        if (a2 != null) {
            weiboMultiMessage.mediaObject = a2;
        }
        this.mZP.shareMessage(weiboMultiMessage, false);
    }

    private WebpageObject a(WeiboMultiMessage weiboMultiMessage, ShareEntity shareEntity, Bitmap bitmap) {
        byte[] bArr = null;
        if (weiboMultiMessage == null || shareEntity == null) {
            return null;
        }
        String linkUrl = shareEntity.getLinkUrl();
        if (TextUtils.isEmpty(linkUrl)) {
            return null;
        }
        if (weiboMultiMessage.textObject != null) {
            if (weiboMultiMessage.imageObject != null && weiboMultiMessage.imageObject.thumbData != null) {
                bArr = weiboMultiMessage.imageObject.thumbData;
            } else if (bitmap != null) {
                bArr = BitmapHelper.Bitmap2Bytes(h(bitmap, 120), 100);
            }
            return c(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(h(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
        } else {
            return null;
        }
    }

    private WebpageObject c(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.thumbData = bArr;
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = "";
        webpageObject.description = "";
        webpageObject.actionUrl = SY(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = SY(str);
        webpageObject.description = SY(str2);
        webpageObject.actionUrl = SY(str3);
        return webpageObject;
    }

    private TextObject dKZ() {
        if (this.mZy == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = SY(this.mZy.getTitle());
        textObject.text = SY(this.mZy.topic) + SY(this.mZy.getContent());
        return textObject;
    }

    private ImageObject K(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(h(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String SY(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void M(Intent intent) {
        if (this.mZP != null && this.mZQ != null) {
            this.mZP.doResultIntent(intent, this.mZQ);
            if (intent != null && intent.getExtras() == null) {
                this.mZQ.onWbShareSuccess();
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.mZO != null) {
            this.mZO.ds(6, 1);
        }
        dt(1, 6);
    }

    public void onWbShareCancel() {
        if (this.mZO != null) {
            this.mZO.ds(6, 3);
        }
        dt(3, 6);
    }

    public void onWbShareFail() {
        if (this.mZO != null) {
            this.mZO.ds(6, 2);
        }
        dt(2, 6);
    }
}
