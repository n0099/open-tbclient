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
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> exy;
    private ShareEntity ltS;
    private com.baidu.tieba.sharesdk.b.b luh;
    private WbShareHandler lui;
    private WbShareCallback luj;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.exy = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.ltS, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.ltS, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.luh != null) {
                    e.this.luh.cV(6, 3);
                }
                e.this.cW(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.luh = bVar;
        this.luj = wbShareCallback;
        this.lui = new WbShareHandler(activity);
        if (this.lui != null) {
            this.lui.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lui == null) {
            cW(2, 6);
            if (bVar != null) {
                bVar.cV(6, 2);
                return;
            }
            return;
        }
        this.ltS = shareEntity;
        this.luh = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.ltS, a.getRawBitmap());
            return;
        }
        String aQl = shareEntity.aQl();
        if (xP(shareEntity.ddT())) {
            a(this.ltS, Mx(shareEntity.ddT()));
        } else if (!TextUtils.isEmpty(aQl) && (aQl.startsWith("http://") || aQl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.ln().a(aQl, 10, this.exy, 0, 0, getPageId(), new Object[0]);
        } else if (t(shareEntity.getImageUri())) {
            a(this.ltS, A(shareEntity.getImageUri()));
        } else {
            a(this.ltS, dea());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.ltS == null || this.lui == null || !(this.context instanceof Activity)) {
            if (this.luh != null) {
                this.luh.cV(6, 2);
            }
            cW(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dec();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = I(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.lui.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Mz(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Mz(str);
        webpageObject.description = Mz(str2);
        webpageObject.actionUrl = Mz(str3);
        return webpageObject;
    }

    private TextObject dec() {
        if (this.ltS == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Mz(this.ltS.getTitle());
        textObject.text = Mz(this.ltS.topic) + Mz(this.ltS.getContent());
        return textObject;
    }

    private ImageObject I(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(g(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Mz(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void J(Intent intent) {
        if (this.lui != null && this.luj != null) {
            this.lui.doResultIntent(intent, this.luj);
            if (intent != null && intent.getExtras() == null) {
                this.luj.onWbShareSuccess();
                cX(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.luh != null) {
            this.luh.cV(6, 1);
        }
        cW(1, 6);
    }

    public void onWbShareCancel() {
        if (this.luh != null) {
            this.luh.cV(6, 3);
        }
        cW(3, 6);
    }

    public void onWbShareFail() {
        if (this.luh != null) {
            this.luh.cV(6, 2);
        }
        cW(2, 6);
    }
}
