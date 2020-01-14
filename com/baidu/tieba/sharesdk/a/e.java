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
/* loaded from: classes9.dex */
public class e extends a {
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dwc;
    private ShareEntity jUK;
    private com.baidu.tieba.sharesdk.b.b jUU;
    private WbShareHandler jUV;
    private WbShareCallback jUW;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.dwc = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.jUK, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.jUK, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.jUU != null) {
                    e.this.jUU.cC(6, 3);
                }
                e.this.BF(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.jUU = bVar;
        this.jUW = wbShareCallback;
        this.jUV = new WbShareHandler(activity);
        if (this.jUV != null) {
            this.jUV.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.jUV == null) {
            BF(2);
            if (bVar != null) {
                bVar.cC(6, 2);
                return;
            }
            return;
        }
        this.jUK = shareEntity;
        this.jUU = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.jUK, a.getRawBitmap());
            return;
        }
        String ayq = shareEntity.ayq();
        if (uh(shareEntity.cFO())) {
            a(this.jUK, In(shareEntity.cFO()));
        } else if (!TextUtils.isEmpty(ayq) && (ayq.startsWith("http://") || ayq.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.gr().a(ayq, 10, this.dwc, 0, 0, getPageId(), new Object[0]);
        } else if (v(shareEntity.getImageUri())) {
            a(this.jUK, u(shareEntity.getImageUri()));
        } else {
            a(this.jUK, cFU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.jUK == null || this.jUV == null || !(this.context instanceof Activity)) {
            if (this.jUU != null) {
                this.jUU.cC(6, 2);
            }
            BF(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = cFV();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = E(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.jUV.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Ip(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Ip(str);
        webpageObject.description = Ip(str2);
        webpageObject.actionUrl = Ip(str3);
        return webpageObject;
    }

    private TextObject cFV() {
        if (this.jUK == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Ip(this.jUK.getTitle());
        textObject.text = Ip(this.jUK.topic) + Ip(this.jUK.getContent());
        return textObject;
    }

    private ImageObject E(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(f(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Ip(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void aa(Intent intent) {
        if (this.jUV != null && this.jUW != null) {
            this.jUV.doResultIntent(intent, this.jUW);
            if (intent != null && intent.getExtras() == null) {
                this.jUW.onWbShareSuccess();
                BG(1);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.jUU != null) {
            this.jUU.cC(6, 1);
        }
        BF(1);
    }

    public void onWbShareCancel() {
        if (this.jUU != null) {
            this.jUU.cC(6, 3);
        }
        BF(3);
    }

    public void onWbShareFail() {
        if (this.jUU != null) {
            this.jUU.cC(6, 2);
        }
        BF(2);
    }
}
