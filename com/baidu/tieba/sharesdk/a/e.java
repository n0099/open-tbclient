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
/* loaded from: classes6.dex */
public class e extends a {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cIe;
    private ShareEntity iWH;
    private com.baidu.tieba.sharesdk.b.b iWS;
    private WbShareHandler iWT;
    private WbShareCallback iWU;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.cIe = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.iWH, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.iWH, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.iWS != null) {
                    e.this.iWS.cj(6, 3);
                }
                e.this.ze(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.iWS = bVar;
        this.iWU = wbShareCallback;
        this.iWT = new WbShareHandler(activity);
        if (this.iWT != null) {
            this.iWT.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iWT == null) {
            ze(2);
            if (bVar != null) {
                bVar.cj(6, 2);
                return;
            }
            return;
        }
        this.iWH = shareEntity;
        this.iWS = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.iWH, a.getRawBitmap());
            return;
        }
        String ahd = shareEntity.ahd();
        if (oY(shareEntity.ckC())) {
            a(this.iWH, Dq(shareEntity.ckC()));
        } else if (!TextUtils.isEmpty(ahd) && (ahd.startsWith("http://") || ahd.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.fT().a(ahd, 10, this.cIe, 0, 0, getPageId(), new Object[0]);
        } else if (t(shareEntity.getImageUri())) {
            a(this.iWH, s(shareEntity.getImageUri()));
        } else {
            a(this.iWH, ckG());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.iWH == null || this.iWT == null || !(this.context instanceof Activity)) {
            if (this.iWS != null) {
                this.iWS.cj(6, 2);
            }
            ze(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = ckH();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = D(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.iWT.shareMessage(weiboMultiMessage, false);
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
                bArr = BitmapHelper.Bitmap2Bytes(e(bitmap, 120), 100);
            }
            return d(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(e(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
        } else {
            return null;
        }
    }

    private WebpageObject d(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.thumbData = bArr;
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = "";
        webpageObject.description = "";
        webpageObject.actionUrl = Ds(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Ds(str);
        webpageObject.description = Ds(str2);
        webpageObject.actionUrl = Ds(str3);
        return webpageObject;
    }

    private TextObject ckH() {
        if (this.iWH == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Ds(this.iWH.getTitle());
        textObject.text = Ds(this.iWH.topic) + Ds(this.iWH.getContent());
        return textObject;
    }

    private ImageObject D(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(e(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Ds(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void ai(Intent intent) {
        if (this.iWT != null && this.iWU != null) {
            this.iWT.doResultIntent(intent, this.iWU);
            if (intent != null && intent.getExtras() == null) {
                this.iWU.onWbShareSuccess();
                zf(1);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.iWS != null) {
            this.iWS.cj(6, 1);
        }
        ze(1);
    }

    public void onWbShareCancel() {
        if (this.iWS != null) {
            this.iWS.cj(6, 3);
        }
        ze(3);
    }

    public void onWbShareFail() {
        if (this.iWS != null) {
            this.iWS.cj(6, 2);
        }
        ze(2);
    }
}
