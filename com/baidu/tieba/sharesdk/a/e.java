package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
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
/* loaded from: classes3.dex */
public class e extends a {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aPR;
    private ShareEntity gAR;
    private com.baidu.tieba.sharesdk.b.b gBc;
    private WbShareHandler gBd;
    private WbShareCallback gBe;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.aPR = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.gAR, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.gAR, aVar.mZ());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.gBc != null) {
                    e.this.gBc.bC(6, 3);
                }
                e.this.sV(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.gBc = bVar;
        this.gBe = wbShareCallback;
        this.gBd = new WbShareHandler(activity);
        if (this.gBd != null) {
            this.gBd.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gBd == null) {
            sV(2);
            if (bVar != null) {
                bVar.bC(6, 2);
                return;
            }
            return;
        }
        this.gAR = shareEntity;
        this.gBc = bVar;
        String uh = shareEntity.uh();
        if (!TextUtils.isEmpty(uh) && (uh.startsWith("http://") || uh.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.ig().a(uh, 10, this.aPR, 0, 0, getPageId(), new Object[0]);
        } else if (h(shareEntity.getImageUri())) {
            a(this.gAR, g(shareEntity.getImageUri()));
        } else {
            a(this.gAR, bsR());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.gAR == null || this.gBd == null || !(this.context instanceof Activity)) {
            if (this.gBc != null) {
                this.gBc.bC(6, 2);
            }
            sV(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = bsS();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = w(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.gBd.shareMessage(weiboMultiMessage, false);
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
                bArr = BitmapHelper.Bitmap2Bytes(e(bitmap, 120), 100);
            }
            return d(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(e(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
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
        webpageObject.actionUrl = tn(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = tn(str);
        webpageObject.description = tn(str2);
        webpageObject.actionUrl = tn(str3);
        return webpageObject;
    }

    private TextObject bsS() {
        if (this.gAR == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = tn(this.gAR.getTitle());
        textObject.text = tn(this.gAR.getContent());
        return textObject;
    }

    private ImageObject w(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(e(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String tn(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void D(Intent intent) {
        if (this.gBd != null && this.gBe != null) {
            this.gBd.doResultIntent(intent, this.gBe);
        }
    }

    public void onWbShareSuccess() {
        if (this.gBc != null) {
            this.gBc.bC(6, 1);
        }
        sV(1);
    }

    public void onWbShareCancel() {
        if (this.gBc != null) {
            this.gBc.bC(6, 3);
        }
        sV(3);
    }

    public void onWbShareFail() {
        if (this.gBc != null) {
            this.gBc.bC(6, 2);
        }
        sV(2);
    }
}
