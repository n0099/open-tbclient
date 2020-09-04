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
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eOv;
    private ShareEntity lTf;
    private com.baidu.tieba.sharesdk.b.b lTu;
    private WbShareHandler lTv;
    private WbShareCallback lTw;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.eOv = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.lTf, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.lTf, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.lTu != null) {
                    e.this.lTu.df(6, 3);
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
        this.lTu = bVar;
        this.lTw = wbShareCallback;
        this.lTv = new WbShareHandler(activity);
        if (this.lTv != null) {
            this.lTv.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lTv == null) {
            dg(2, 6);
            if (bVar != null) {
                bVar.df(6, 2);
                return;
            }
            return;
        }
        this.lTf = shareEntity;
        this.lTu = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.lTf, a.getRawBitmap());
            return;
        }
        String bcA = shareEntity.bcA();
        if (Bm(shareEntity.dsD())) {
            a(this.lTf, Qd(shareEntity.dsD()));
        } else if (!TextUtils.isEmpty(bcA) && (bcA.startsWith("http://") || bcA.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.mM().a(bcA, 10, this.eOv, 0, 0, getPageId(), new Object[0]);
        } else if (t(shareEntity.getImageUri())) {
            a(this.lTf, z(shareEntity.getImageUri()));
        } else {
            a(this.lTf, dsK());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.lTf == null || this.lTv == null || !(this.context instanceof Activity)) {
            if (this.lTu != null) {
                this.lTu.df(6, 2);
            }
            dg(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dsM();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = L(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.lTv.shareMessage(weiboMultiMessage, false);
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

    private TextObject dsM() {
        if (this.lTf == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Qf(this.lTf.getTitle());
        textObject.text = Qf(this.lTf.topic) + Qf(this.lTf.getContent());
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
        if (this.lTv != null && this.lTw != null) {
            this.lTv.doResultIntent(intent, this.lTw);
            if (intent != null && intent.getExtras() == null) {
                this.lTw.onWbShareSuccess();
                dh(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.lTu != null) {
            this.lTu.df(6, 1);
        }
        dg(1, 6);
    }

    public void onWbShareCancel() {
        if (this.lTu != null) {
            this.lTu.df(6, 3);
        }
        dg(3, 6);
    }

    public void onWbShareFail() {
        if (this.lTu != null) {
            this.lTu.df(6, 2);
        }
        dg(2, 6);
    }
}
