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
/* loaded from: classes23.dex */
public class e extends a {
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eRm;
    private ShareEntity mcC;
    private com.baidu.tieba.sharesdk.b.b mcR;
    private WbShareHandler mcS;
    private WbShareCallback mcT;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.eRm = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.mcC, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.mcC, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.mcR != null) {
                    e.this.mcR.dj(6, 3);
                }
                e.this.dk(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.mcR = bVar;
        this.mcT = wbShareCallback;
        this.mcS = new WbShareHandler(activity);
        if (this.mcS != null) {
            this.mcS.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.mcS == null) {
            dk(2, 6);
            if (bVar != null) {
                bVar.dj(6, 2);
                return;
            }
            return;
        }
        this.mcC = shareEntity;
        this.mcR = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.mcC, a.getRawBitmap());
            return;
        }
        String bdu = shareEntity.bdu();
        if (BI(shareEntity.dwv())) {
            a(this.mcC, QD(shareEntity.dwv()));
        } else if (!TextUtils.isEmpty(bdu) && (bdu.startsWith("http://") || bdu.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.c.mR().a(bdu, 10, this.eRm, 0, 0, getPageId(), new Object[0]);
        } else if (u(shareEntity.getImageUri())) {
            a(this.mcC, A(shareEntity.getImageUri()));
        } else {
            a(this.mcC, dwC());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.mcC == null || this.mcS == null || !(this.context instanceof Activity)) {
            if (this.mcR != null) {
                this.mcR.dj(6, 2);
            }
            dk(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dwE();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = K(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.mcS.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = QF(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = QF(str);
        webpageObject.description = QF(str2);
        webpageObject.actionUrl = QF(str3);
        return webpageObject;
    }

    private TextObject dwE() {
        if (this.mcC == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = QF(this.mcC.getTitle());
        textObject.text = QF(this.mcC.topic) + QF(this.mcC.getContent());
        return textObject;
    }

    private ImageObject K(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(h(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String QF(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void M(Intent intent) {
        if (this.mcS != null && this.mcT != null) {
            this.mcS.doResultIntent(intent, this.mcT);
            if (intent != null && intent.getExtras() == null) {
                this.mcT.onWbShareSuccess();
                dl(1, 6);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.mcR != null) {
            this.mcR.dj(6, 1);
        }
        dk(1, 6);
    }

    public void onWbShareCancel() {
        if (this.mcR != null) {
            this.mcR.dj(6, 3);
        }
        dk(3, 6);
    }

    public void onWbShareFail() {
        if (this.mcR != null) {
            this.mcR.dj(6, 2);
        }
        dk(2, 6);
    }
}
