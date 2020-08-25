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
/* loaded from: classes18.dex */
public class e extends a {
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eOr;
    private ShareEntity lSQ;
    private com.baidu.tieba.sharesdk.b.b lTf;
    private WbShareHandler lTg;
    private WbShareCallback lTh;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.eOr = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.lSQ, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.lSQ, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.lTf != null) {
                    e.this.lTf.df(6, 3);
                }
                e.this.dg(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.lTf = bVar;
        this.lTh = wbShareCallback;
        this.lTg = new WbShareHandler(activity);
        if (this.lTg != null) {
            this.lTg.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lTg == null) {
            dg(2, 6);
            if (bVar != null) {
                bVar.df(6, 2);
                return;
            }
            return;
        }
        this.lSQ = shareEntity;
        this.lTf = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.lSQ, a.getRawBitmap());
            return;
        }
        String bcA = shareEntity.bcA();
        if (Bl(shareEntity.dsy())) {
            a(this.lSQ, Qd(shareEntity.dsy()));
        } else if (!TextUtils.isEmpty(bcA) && (bcA.startsWith("http://") || bcA.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.mM().a(bcA, 10, this.eOr, 0, 0, getPageId(), new Object[0]);
        } else if (t(shareEntity.getImageUri())) {
            a(this.lSQ, z(shareEntity.getImageUri()));
        } else {
            a(this.lSQ, dsF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.lSQ == null || this.lTg == null || !(this.context instanceof Activity)) {
            if (this.lTf != null) {
                this.lTf.df(6, 2);
            }
            dg(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dsH();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = L(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.lTg.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Qf(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Qf(str);
        webpageObject.description = Qf(str2);
        webpageObject.actionUrl = Qf(str3);
        return webpageObject;
    }

    private TextObject dsH() {
        if (this.lSQ == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Qf(this.lSQ.getTitle());
        textObject.text = Qf(this.lSQ.topic) + Qf(this.lSQ.getContent());
        return textObject;
    }

    private ImageObject L(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(h(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Qf(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void M(Intent intent) {
        if (this.lTg != null && this.lTh != null) {
            this.lTg.doResultIntent(intent, this.lTh);
            if (intent != null && intent.getExtras() == null) {
                this.lTh.onWbShareSuccess();
                dh(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.lTf != null) {
            this.lTf.df(6, 1);
        }
        dg(1, 6);
    }

    public void onWbShareCancel() {
        if (this.lTf != null) {
            this.lTf.df(6, 3);
        }
        dg(3, 6);
    }

    public void onWbShareFail() {
        if (this.lTf != null) {
            this.lTf.df(6, 2);
        }
        dg(2, 6);
    }
}
