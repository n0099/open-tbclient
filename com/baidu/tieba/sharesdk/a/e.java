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
/* loaded from: classes11.dex */
public class e extends a {
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dAJ;
    private com.baidu.tieba.sharesdk.b.b jXK;
    private WbShareHandler jXL;
    private WbShareCallback jXM;
    private ShareEntity jXv;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.dAJ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.jXv, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.jXv, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.jXK != null) {
                    e.this.jXK.cE(6, 3);
                }
                e.this.cF(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.jXK = bVar;
        this.jXM = wbShareCallback;
        this.jXL = new WbShareHandler(activity);
        if (this.jXL != null) {
            this.jXL.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jXL == null) {
            cF(2, 6);
            if (bVar != null) {
                bVar.cE(6, 2);
                return;
            }
            return;
        }
        this.jXv = shareEntity;
        this.jXK = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.jXv, a.getRawBitmap());
            return;
        }
        String aAJ = shareEntity.aAJ();
        if (uz(shareEntity.cHO())) {
            a(this.jXv, IC(shareEntity.cHO()));
        } else if (!TextUtils.isEmpty(aAJ) && (aAJ.startsWith("http://") || aAJ.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.gr().a(aAJ, 10, this.dAJ, 0, 0, getPageId(), new Object[0]);
        } else if (w(shareEntity.getImageUri())) {
            a(this.jXv, v(shareEntity.getImageUri()));
        } else {
            a(this.jXv, cHU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.jXv == null || this.jXL == null || !(this.context instanceof Activity)) {
            if (this.jXK != null) {
                this.jXK.cE(6, 2);
            }
            cF(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = cHW();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = E(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.jXL.shareMessage(weiboMultiMessage, false);
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
                bArr = BitmapHelper.Bitmap2Bytes(f(bitmap, 120), 100);
            }
            return d(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(f(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
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
        webpageObject.actionUrl = IE(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = IE(str);
        webpageObject.description = IE(str2);
        webpageObject.actionUrl = IE(str3);
        return webpageObject;
    }

    private TextObject cHW() {
        if (this.jXv == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = IE(this.jXv.getTitle());
        textObject.text = IE(this.jXv.topic) + IE(this.jXv.getContent());
        return textObject;
    }

    private ImageObject E(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(f(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String IE(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void aa(Intent intent) {
        if (this.jXL != null && this.jXM != null) {
            this.jXL.doResultIntent(intent, this.jXM);
            if (intent != null && intent.getExtras() == null) {
                this.jXM.onWbShareSuccess();
                cG(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.jXK != null) {
            this.jXK.cE(6, 1);
        }
        cF(1, 6);
    }

    public void onWbShareCancel() {
        if (this.jXK != null) {
            this.jXK.cE(6, 3);
        }
        cF(3, 6);
    }

    public void onWbShareFail() {
        if (this.jXK != null) {
            this.jXK.cE(6, 2);
        }
        cF(2, 6);
    }
}
