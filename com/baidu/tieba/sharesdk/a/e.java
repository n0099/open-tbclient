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
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eax;
    private ShareEntity kGJ;
    private com.baidu.tieba.sharesdk.b.b kGY;
    private WbShareHandler kGZ;
    private WbShareCallback kHa;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.eax = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.kGJ, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.kGJ, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.kGY != null) {
                    e.this.kGY.cK(6, 3);
                }
                e.this.cL(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.kGY = bVar;
        this.kHa = wbShareCallback;
        this.kGZ = new WbShareHandler(activity);
        if (this.kGZ != null) {
            this.kGZ.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.kGZ == null) {
            cL(2, 6);
            if (bVar != null) {
                bVar.cK(6, 2);
                return;
            }
            return;
        }
        this.kGJ = shareEntity;
        this.kGY = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.kGJ, a.getRawBitmap());
            return;
        }
        String aIU = shareEntity.aIU();
        if (vQ(shareEntity.cSj())) {
            a(this.kGJ, Ki(shareEntity.cSj()));
        } else if (!TextUtils.isEmpty(aIU) && (aIU.startsWith("http://") || aIU.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.kV().a(aIU, 10, this.eax, 0, 0, getPageId(), new Object[0]);
        } else if (y(shareEntity.getImageUri())) {
            a(this.kGJ, x(shareEntity.getImageUri()));
        } else {
            a(this.kGJ, cSp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.kGJ == null || this.kGZ == null || !(this.context instanceof Activity)) {
            if (this.kGY != null) {
                this.kGY.cK(6, 2);
            }
            cL(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = cSr();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = G(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.kGZ.shareMessage(weiboMultiMessage, false);
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
            return c(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(f(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
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
        webpageObject.actionUrl = Kk(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Kk(str);
        webpageObject.description = Kk(str2);
        webpageObject.actionUrl = Kk(str3);
        return webpageObject;
    }

    private TextObject cSr() {
        if (this.kGJ == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Kk(this.kGJ.getTitle());
        textObject.text = Kk(this.kGJ.topic) + Kk(this.kGJ.getContent());
        return textObject;
    }

    private ImageObject G(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(f(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Kk(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void M(Intent intent) {
        if (this.kGZ != null && this.kHa != null) {
            this.kGZ.doResultIntent(intent, this.kHa);
            if (intent != null && intent.getExtras() == null) {
                this.kHa.onWbShareSuccess();
                cM(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.kGY != null) {
            this.kGY.cK(6, 1);
        }
        cL(1, 6);
    }

    public void onWbShareCancel() {
        if (this.kGY != null) {
            this.kGY.cK(6, 3);
        }
        cL(3, 6);
    }

    public void onWbShareFail() {
        if (this.kGY != null) {
            this.kGY.cK(6, 2);
        }
        cL(2, 6);
    }
}
