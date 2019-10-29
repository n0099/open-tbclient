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
/* loaded from: classes6.dex */
public class e extends a {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cIV;
    private com.baidu.tieba.sharesdk.b.b iXJ;
    private WbShareHandler iXK;
    private WbShareCallback iXL;
    private ShareEntity iXy;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.cIV = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.iXy, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.iXy, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.iXJ != null) {
                    e.this.iXJ.cl(6, 3);
                }
                e.this.zf(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.iXJ = bVar;
        this.iXL = wbShareCallback;
        this.iXK = new WbShareHandler(activity);
        if (this.iXK != null) {
            this.iXK.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iXK == null) {
            zf(2);
            if (bVar != null) {
                bVar.cl(6, 2);
                return;
            }
            return;
        }
        this.iXy = shareEntity;
        this.iXJ = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.getRawBitmap() != null) {
            a(this.iXy, a.getRawBitmap());
            return;
        }
        String ahf = shareEntity.ahf();
        if (oY(shareEntity.ckE())) {
            a(this.iXy, Dq(shareEntity.ckE()));
        } else if (!TextUtils.isEmpty(ahf) && (ahf.startsWith("http://") || ahf.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.fT().a(ahf, 10, this.cIV, 0, 0, getPageId(), new Object[0]);
        } else if (t(shareEntity.getImageUri())) {
            a(this.iXy, s(shareEntity.getImageUri()));
        } else {
            a(this.iXy, ckI());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.iXy == null || this.iXK == null || !(this.context instanceof Activity)) {
            if (this.iXJ != null) {
                this.iXJ.cl(6, 2);
            }
            zf(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = ckJ();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = D(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.iXK.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Ds(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Ds(str);
        webpageObject.description = Ds(str2);
        webpageObject.actionUrl = Ds(str3);
        return webpageObject;
    }

    private TextObject ckJ() {
        if (this.iXy == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Ds(this.iXy.getTitle());
        textObject.text = Ds(this.iXy.topic) + Ds(this.iXy.getContent());
        return textObject;
    }

    private ImageObject D(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(e(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Ds(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void ai(Intent intent) {
        if (this.iXK != null && this.iXL != null) {
            this.iXK.doResultIntent(intent, this.iXL);
            if (intent != null && intent.getExtras() == null) {
                this.iXL.onWbShareSuccess();
                zg(1);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.iXJ != null) {
            this.iXJ.cl(6, 1);
        }
        zf(1);
    }

    public void onWbShareCancel() {
        if (this.iXJ != null) {
            this.iXJ.cl(6, 3);
        }
        zf(3);
    }

    public void onWbShareFail() {
        if (this.iXJ != null) {
            this.iXJ.cl(6, 2);
        }
        zf(2);
    }
}
