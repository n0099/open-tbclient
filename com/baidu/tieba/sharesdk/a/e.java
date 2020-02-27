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
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dAi;
    private ShareEntity jVF;
    private com.baidu.tieba.sharesdk.b.b jVU;
    private WbShareHandler jVV;
    private WbShareCallback jVW;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.dAi = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.jVF, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.jVF, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.jVU != null) {
                    e.this.jVU.cD(6, 3);
                }
                e.this.cE(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.jVU = bVar;
        this.jVW = wbShareCallback;
        this.jVV = new WbShareHandler(activity);
        if (this.jVV != null) {
            this.jVV.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jVV == null) {
            cE(2, 6);
            if (bVar != null) {
                bVar.cD(6, 2);
                return;
            }
            return;
        }
        this.jVF = shareEntity;
        this.jVU = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.jVF, a.getRawBitmap());
            return;
        }
        String aAE = shareEntity.aAE();
        if (uy(shareEntity.cHr())) {
            a(this.jVF, IB(shareEntity.cHr()));
        } else if (!TextUtils.isEmpty(aAE) && (aAE.startsWith("http://") || aAE.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.gr().a(aAE, 10, this.dAi, 0, 0, getPageId(), new Object[0]);
        } else if (w(shareEntity.getImageUri())) {
            a(this.jVF, v(shareEntity.getImageUri()));
        } else {
            a(this.jVF, cHx());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.jVF == null || this.jVV == null || !(this.context instanceof Activity)) {
            if (this.jVU != null) {
                this.jVU.cD(6, 2);
            }
            cE(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = cHz();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = E(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.jVV.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = ID(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = ID(str);
        webpageObject.description = ID(str2);
        webpageObject.actionUrl = ID(str3);
        return webpageObject;
    }

    private TextObject cHz() {
        if (this.jVF == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = ID(this.jVF.getTitle());
        textObject.text = ID(this.jVF.topic) + ID(this.jVF.getContent());
        return textObject;
    }

    private ImageObject E(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(f(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String ID(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void aa(Intent intent) {
        if (this.jVV != null && this.jVW != null) {
            this.jVV.doResultIntent(intent, this.jVW);
            if (intent != null && intent.getExtras() == null) {
                this.jVW.onWbShareSuccess();
                cF(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.jVU != null) {
            this.jVU.cD(6, 1);
        }
        cE(1, 6);
    }

    public void onWbShareCancel() {
        if (this.jVU != null) {
            this.jVU.cD(6, 3);
        }
        cE(3, 6);
    }

    public void onWbShareFail() {
        if (this.jVU != null) {
            this.jVU.cD(6, 2);
        }
        cE(2, 6);
    }
}
