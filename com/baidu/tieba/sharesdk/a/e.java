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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> bcE;
    private ShareEntity hdB;
    private com.baidu.tieba.sharesdk.b.b hdM;
    private WbShareHandler hdN;
    private WbShareCallback hdO;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.bcE = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.hdB, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.hdB, aVar.ot());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.hdM != null) {
                    e.this.hdM.bJ(6, 3);
                }
                e.this.uU(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.hdM = bVar;
        this.hdO = wbShareCallback;
        this.hdN = new WbShareHandler(activity);
        if (this.hdN != null) {
            this.hdN.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.hdN == null) {
            uU(2);
            if (bVar != null) {
                bVar.bJ(6, 2);
                return;
            }
            return;
        }
        this.hdB = shareEntity;
        this.hdM = bVar;
        String yF = shareEntity.yF();
        if (hr(shareEntity.sb())) {
            a(this.hdB, vu(shareEntity.sb()));
        } else if (!TextUtils.isEmpty(yF) && (yF.startsWith("http://") || yF.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.jA().a(yF, 10, this.bcE, 0, 0, getPageId(), new Object[0]);
        } else if (i(shareEntity.getImageUri())) {
            a(this.hdB, h(shareEntity.getImageUri()));
        } else {
            a(this.hdB, bAd());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.hdB == null || this.hdN == null || !(this.context instanceof Activity)) {
            if (this.hdM != null) {
                this.hdM.bJ(6, 2);
            }
            uU(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = bAe();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = w(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.hdN.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = vw(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = vw(str);
        webpageObject.description = vw(str2);
        webpageObject.actionUrl = vw(str3);
        return webpageObject;
    }

    private TextObject bAe() {
        if (this.hdB == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = vw(this.hdB.getTitle());
        textObject.text = vw(this.hdB.topic) + vw(this.hdB.getContent());
        return textObject;
    }

    private ImageObject w(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(d(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String vw(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void H(Intent intent) {
        if (this.hdN != null && this.hdO != null) {
            this.hdN.doResultIntent(intent, this.hdO);
        }
    }

    public void onWbShareSuccess() {
        if (this.hdM != null) {
            this.hdM.bJ(6, 1);
        }
        uU(1);
    }

    public void onWbShareCancel() {
        if (this.hdM != null) {
            this.hdM.bJ(6, 3);
        }
        uU(3);
    }

    public void onWbShareFail() {
        if (this.hdM != null) {
            this.hdM.bJ(6, 2);
        }
        uU(2);
    }
}
