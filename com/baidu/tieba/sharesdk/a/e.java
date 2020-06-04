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
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eoJ;
    private ShareEntity kZU;
    private com.baidu.tieba.sharesdk.b.b laj;
    private WbShareHandler lak;
    private WbShareCallback lal;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.eoJ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.kZU, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.kZU, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.laj != null) {
                    e.this.laj.cP(6, 3);
                }
                e.this.cQ(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.laj = bVar;
        this.lal = wbShareCallback;
        this.lak = new WbShareHandler(activity);
        if (this.lak != null) {
            this.lak.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lak == null) {
            cQ(2, 6);
            if (bVar != null) {
                bVar.cP(6, 2);
                return;
            }
            return;
        }
        this.kZU = shareEntity;
        this.laj = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.kZU, a.getRawBitmap());
            return;
        }
        String aOP = shareEntity.aOP();
        if (xw(shareEntity.cZD())) {
            a(this.kZU, LV(shareEntity.cZD()));
        } else if (!TextUtils.isEmpty(aOP) && (aOP.startsWith("http://") || aOP.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.kX().a(aOP, 10, this.eoJ, 0, 0, getPageId(), new Object[0]);
        } else if (t(shareEntity.getImageUri())) {
            a(this.kZU, A(shareEntity.getImageUri()));
        } else {
            a(this.kZU, cZJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.kZU == null || this.lak == null || !(this.context instanceof Activity)) {
            if (this.laj != null) {
                this.laj.cP(6, 2);
            }
            cQ(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = cZL();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = I(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.lak.shareMessage(weiboMultiMessage, false);
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
                bArr = BitmapHelper.Bitmap2Bytes(g(bitmap, 120), 100);
            }
            return c(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(g(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
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
        webpageObject.actionUrl = LX(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = LX(str);
        webpageObject.description = LX(str2);
        webpageObject.actionUrl = LX(str3);
        return webpageObject;
    }

    private TextObject cZL() {
        if (this.kZU == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = LX(this.kZU.getTitle());
        textObject.text = LX(this.kZU.topic) + LX(this.kZU.getContent());
        return textObject;
    }

    private ImageObject I(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(g(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String LX(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void J(Intent intent) {
        if (this.lak != null && this.lal != null) {
            this.lak.doResultIntent(intent, this.lal);
            if (intent != null && intent.getExtras() == null) {
                this.lal.onWbShareSuccess();
                cR(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.laj != null) {
            this.laj.cP(6, 1);
        }
        cQ(1, 6);
    }

    public void onWbShareCancel() {
        if (this.laj != null) {
            this.laj.cP(6, 3);
        }
        cQ(3, 6);
    }

    public void onWbShareFail() {
        if (this.laj != null) {
            this.laj.cP(6, 2);
        }
        cQ(2, 6);
    }
}
