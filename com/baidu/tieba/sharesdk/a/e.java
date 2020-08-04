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
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eDQ;
    private com.baidu.tieba.sharesdk.b.b lBA;
    private WbShareHandler lBB;
    private WbShareCallback lBC;
    private ShareEntity lBl;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.eDQ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.lBl, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.lBl, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.lBA != null) {
                    e.this.lBA.cX(6, 3);
                }
                e.this.cY(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.lBA = bVar;
        this.lBC = wbShareCallback;
        this.lBB = new WbShareHandler(activity);
        if (this.lBB != null) {
            this.lBB.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.lBB == null) {
            cY(2, 6);
            if (bVar != null) {
                bVar.cX(6, 2);
                return;
            }
            return;
        }
        this.lBl = shareEntity;
        this.lBA = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.lBl, a.getRawBitmap());
            return;
        }
        String aUh = shareEntity.aUh();
        if (yV(shareEntity.dhc())) {
            a(this.lBl, Nf(shareEntity.dhc()));
        } else if (!TextUtils.isEmpty(aUh) && (aUh.startsWith("http://") || aUh.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.ln().a(aUh, 10, this.eDQ, 0, 0, getPageId(), new Object[0]);
        } else if (t(shareEntity.getImageUri())) {
            a(this.lBl, z(shareEntity.getImageUri()));
        } else {
            a(this.lBl, dhj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.lBl == null || this.lBB == null || !(this.context instanceof Activity)) {
            if (this.lBA != null) {
                this.lBA.cX(6, 2);
            }
            cY(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dhl();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = L(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.lBB.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Nh(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Nh(str);
        webpageObject.description = Nh(str2);
        webpageObject.actionUrl = Nh(str3);
        return webpageObject;
    }

    private TextObject dhl() {
        if (this.lBl == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Nh(this.lBl.getTitle());
        textObject.text = Nh(this.lBl.topic) + Nh(this.lBl.getContent());
        return textObject;
    }

    private ImageObject L(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(g(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Nh(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void K(Intent intent) {
        if (this.lBB != null && this.lBC != null) {
            this.lBB.doResultIntent(intent, this.lBC);
            if (intent != null && intent.getExtras() == null) {
                this.lBC.onWbShareSuccess();
                cZ(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.lBA != null) {
            this.lBA.cX(6, 1);
        }
        cY(1, 6);
    }

    public void onWbShareCancel() {
        if (this.lBA != null) {
            this.lBA.cX(6, 3);
        }
        cY(3, 6);
    }

    public void onWbShareFail() {
        if (this.lBA != null) {
            this.lBA.cX(6, 2);
        }
        cY(2, 6);
    }
}
