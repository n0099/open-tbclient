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
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> frM;
    private ShareEntity mKN;
    private com.baidu.tieba.sharesdk.b.b mLc;
    private WbShareHandler mLd;
    private WbShareCallback mLe;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.frM = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.mKN, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.mKN, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.mLc != null) {
                    e.this.mLc.dn(6, 3);
                }
                e.this.m43do(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.mLc = bVar;
        this.mLe = wbShareCallback;
        this.mLd = new WbShareHandler(activity);
        if (this.mLd != null) {
            this.mLd.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mLd == null) {
            m43do(2, 6);
            if (bVar != null) {
                bVar.dn(6, 2);
                return;
            }
            return;
        }
        this.mKN = shareEntity;
        this.mLc = bVar;
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            a(this.mKN, a2.getRawBitmap());
            return;
        }
        String bkw = shareEntity.bkw();
        if (Db(shareEntity.dFQ())) {
            a(this.mKN, Sh(shareEntity.dFQ()));
        } else if (!TextUtils.isEmpty(bkw) && (bkw.startsWith("http://") || bkw.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.mS().a(bkw, 10, this.frM, 0, 0, getPageId(), new Object[0]);
        } else if (u(shareEntity.getImageUri())) {
            a(this.mKN, A(shareEntity.getImageUri()));
        } else {
            a(this.mKN, dFX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.mKN == null || this.mLd == null || !(this.context instanceof Activity)) {
            if (this.mLc != null) {
                this.mLc.dn(6, 2);
            }
            m43do(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dFZ();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = K(bitmap);
        }
        WebpageObject a2 = a(weiboMultiMessage, shareEntity, bitmap);
        if (a2 != null) {
            weiboMultiMessage.mediaObject = a2;
        }
        this.mLd.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Sj(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Sj(str);
        webpageObject.description = Sj(str2);
        webpageObject.actionUrl = Sj(str3);
        return webpageObject;
    }

    private TextObject dFZ() {
        if (this.mKN == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Sj(this.mKN.getTitle());
        textObject.text = Sj(this.mKN.topic) + Sj(this.mKN.getContent());
        return textObject;
    }

    private ImageObject K(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(h(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Sj(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void M(Intent intent) {
        if (this.mLd != null && this.mLe != null) {
            this.mLd.doResultIntent(intent, this.mLe);
            if (intent != null && intent.getExtras() == null) {
                this.mLe.onWbShareSuccess();
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.mLc != null) {
            this.mLc.dn(6, 1);
        }
        m43do(1, 6);
    }

    public void onWbShareCancel() {
        if (this.mLc != null) {
            this.mLc.dn(6, 3);
        }
        m43do(3, 6);
    }

    public void onWbShareFail() {
        if (this.mLc != null) {
            this.mLc.dn(6, 2);
        }
        m43do(2, 6);
    }
}
