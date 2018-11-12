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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aYt;
    private ShareEntity gSC;
    private com.baidu.tieba.sharesdk.b.b gSN;
    private WbShareHandler gSO;
    private WbShareCallback gSP;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.aYt = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.gSC, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.gSC, aVar.oq());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.gSN != null) {
                    e.this.gSN.bK(6, 3);
                }
                e.this.uj(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.gSN = bVar;
        this.gSP = wbShareCallback;
        this.gSO = new WbShareHandler(activity);
        if (this.gSO != null) {
            this.gSO.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gSO == null) {
            uj(2);
            if (bVar != null) {
                bVar.bK(6, 2);
                return;
            }
            return;
        }
        this.gSC = shareEntity;
        this.gSN = bVar;
        String xn = shareEntity.xn();
        if (!TextUtils.isEmpty(xn) && (xn.startsWith("http://") || xn.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.jA().a(xn, 10, this.aYt, 0, 0, getPageId(), new Object[0]);
        } else if (h(shareEntity.getImageUri())) {
            a(this.gSC, g(shareEntity.getImageUri()));
        } else {
            a(this.gSC, bwL());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.gSC == null || this.gSO == null || !(this.context instanceof Activity)) {
            if (this.gSN != null) {
                this.gSN.bK(6, 2);
            }
            uj(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = bwM();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = w(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.gSO.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = uC(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = uC(str);
        webpageObject.description = uC(str2);
        webpageObject.actionUrl = uC(str3);
        return webpageObject;
    }

    private TextObject bwM() {
        if (this.gSC == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = uC(this.gSC.getTitle());
        textObject.text = uC(this.gSC.getContent());
        return textObject;
    }

    private ImageObject w(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(d(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String uC(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void H(Intent intent) {
        if (this.gSO != null && this.gSP != null) {
            this.gSO.doResultIntent(intent, this.gSP);
        }
    }

    public void onWbShareSuccess() {
        if (this.gSN != null) {
            this.gSN.bK(6, 1);
        }
        uj(1);
    }

    public void onWbShareCancel() {
        if (this.gSN != null) {
            this.gSN.bK(6, 3);
        }
        uj(1);
    }

    public void onWbShareFail() {
        if (this.gSN != null) {
            this.gSN.bK(6, 2);
        }
        uj(2);
    }
}
