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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aXF;
    private ShareEntity gRe;
    private com.baidu.tieba.sharesdk.b.b gRp;
    private WbShareHandler gRq;
    private WbShareCallback gRr;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.aXF = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.gRe, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.gRe, aVar.os());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.gRp != null) {
                    e.this.gRp.bI(6, 3);
                }
                e.this.tQ(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.gRp = bVar;
        this.gRr = wbShareCallback;
        this.gRq = new WbShareHandler(activity);
        if (this.gRq != null) {
            this.gRq.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gRq == null) {
            tQ(2);
            if (bVar != null) {
                bVar.bI(6, 2);
                return;
            }
            return;
        }
        this.gRe = shareEntity;
        this.gRp = bVar;
        String xf = shareEntity.xf();
        if (!TextUtils.isEmpty(xf) && (xf.startsWith("http://") || xf.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.jC().a(xf, 10, this.aXF, 0, 0, getPageId(), new Object[0]);
        } else if (h(shareEntity.getImageUri())) {
            a(this.gRe, g(shareEntity.getImageUri()));
        } else {
            a(this.gRe, bxp());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.gRe == null || this.gRq == null || !(this.context instanceof Activity)) {
            if (this.gRp != null) {
                this.gRp.bI(6, 2);
            }
            tQ(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = bxq();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = w(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.gRq.shareMessage(weiboMultiMessage, false);
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
                bArr = BitmapHelper.Bitmap2Bytes(d(bitmap, 120), 100);
            }
            return e(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(d(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
        } else {
            return null;
        }
    }

    private WebpageObject e(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.thumbData = bArr;
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = "";
        webpageObject.description = "";
        webpageObject.actionUrl = uy(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = uy(str);
        webpageObject.description = uy(str2);
        webpageObject.actionUrl = uy(str3);
        return webpageObject;
    }

    private TextObject bxq() {
        if (this.gRe == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = uy(this.gRe.getTitle());
        textObject.text = uy(this.gRe.getContent());
        return textObject;
    }

    private ImageObject w(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(d(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String uy(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void H(Intent intent) {
        if (this.gRq != null && this.gRr != null) {
            this.gRq.doResultIntent(intent, this.gRr);
        }
    }

    public void onWbShareSuccess() {
        if (this.gRp != null) {
            this.gRp.bI(6, 1);
        }
        tQ(1);
    }

    public void onWbShareCancel() {
        if (this.gRp != null) {
            this.gRp.bI(6, 3);
        }
        tQ(3);
    }

    public void onWbShareFail() {
        if (this.gRp != null) {
            this.gRp.bI(6, 2);
        }
        tQ(2);
    }
}
