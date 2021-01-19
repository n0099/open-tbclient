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
/* loaded from: classes7.dex */
public class e extends a {
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fDG;
    private com.baidu.tieba.sharesdk.b.b naF;
    private WbShareHandler naG;
    private WbShareCallback naH;
    private ShareEntity nao;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.fDG = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.nao, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.nao, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.naF != null) {
                    e.this.naF.mo47do(6, 3);
                }
                e.this.dp(3, 6);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.naF = bVar;
        this.naH = wbShareCallback;
        this.naG = new WbShareHandler(activity);
        if (this.naG != null) {
            this.naG.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.naG == null) {
            dp(2, 6);
            if (bVar != null) {
                bVar.mo47do(6, 2);
                return;
            }
            return;
        }
        this.nao = shareEntity;
        this.naF = bVar;
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            a(this.nao, a2.getRawBitmap());
            return;
        }
        String imgUrl = shareEntity.getImgUrl();
        if (BU(shareEntity.dGP())) {
            a(this.nao, Rx(shareEntity.dGP()));
        } else if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.d.mx().a(imgUrl, 10, this.fDG, 0, 0, getPageId(), new Object[0]);
        } else if (z(shareEntity.getImageUri())) {
            a(this.nao, G(shareEntity.getImageUri()));
        } else {
            a(this.nao, dGW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.nao == null || this.naG == null || !(this.context instanceof Activity)) {
            if (this.naF != null) {
                this.naF.mo47do(6, 2);
            }
            dp(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dGY();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = L(bitmap);
        }
        WebpageObject a2 = a(weiboMultiMessage, shareEntity, bitmap);
        if (a2 != null) {
            weiboMultiMessage.mediaObject = a2;
        }
        this.naG.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Rz(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Rz(str);
        webpageObject.description = Rz(str2);
        webpageObject.actionUrl = Rz(str3);
        return webpageObject;
    }

    private TextObject dGY() {
        if (this.nao == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Rz(this.nao.getTitle());
        textObject.text = Rz(this.nao.topic) + Rz(this.nao.getContent());
        return textObject;
    }

    private ImageObject L(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(h(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Rz(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void N(Intent intent) {
        if (this.naG != null && this.naH != null) {
            this.naG.doResultIntent(intent, this.naH);
            if (intent != null && intent.getExtras() == null) {
                this.naH.onWbShareSuccess();
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.naF != null) {
            this.naF.mo47do(6, 1);
        }
        dp(1, 6);
    }

    public void onWbShareCancel() {
        if (this.naF != null) {
            this.naF.mo47do(6, 3);
        }
        dp(3, 6);
    }

    public void onWbShareFail() {
        if (this.naF != null) {
            this.naF.mo47do(6, 2);
        }
        dp(2, 6);
    }
}
