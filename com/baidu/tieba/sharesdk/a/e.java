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
/* loaded from: classes8.dex */
public class e extends a {
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fIn;
    private ShareEntity neV;
    private com.baidu.tieba.sharesdk.b.b nfl;
    private WbShareHandler nfm;
    private WbShareCallback nfn;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.fIn = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.neV, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.neV, aVar.getRawBitmap());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.e.c
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.nfl != null) {
                    e.this.nfl.mo41do(6, 3);
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
        this.nfl = bVar;
        this.nfn = wbShareCallback;
        this.nfm = new WbShareHandler(activity);
        if (this.nfm != null) {
            this.nfm.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.nfm == null) {
            dp(2, 6);
            if (bVar != null) {
                bVar.mo41do(6, 2);
                return;
            }
            return;
        }
        this.neV = shareEntity;
        this.nfl = bVar;
        com.baidu.adp.widget.ImageView.a a2 = a(shareEntity);
        if (a2 != null && a2.getRawBitmap() != null) {
            a(this.neV, a2.getRawBitmap());
            return;
        }
        String imgUrl = shareEntity.getImgUrl();
        if (Dg(shareEntity.dKG())) {
            a(this.neV, SF(shareEntity.dKG()));
        } else if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.e.d.mx().a(imgUrl, 10, this.fIn, 0, 0, getPageId(), new Object[0]);
        } else if (w(shareEntity.getImageUri())) {
            a(this.neV, D(shareEntity.getImageUri()));
        } else {
            a(this.neV, dKN());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.neV == null || this.nfm == null || !(this.context instanceof Activity)) {
            if (this.nfl != null) {
                this.nfl.mo41do(6, 2);
            }
            dp(2, 6);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = dKP();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = L(bitmap);
        }
        WebpageObject a2 = a(weiboMultiMessage, shareEntity, bitmap);
        if (a2 != null) {
            weiboMultiMessage.mediaObject = a2;
        }
        this.nfm.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = SH(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = SH(str);
        webpageObject.description = SH(str2);
        webpageObject.actionUrl = SH(str3);
        return webpageObject;
    }

    private TextObject dKP() {
        if (this.neV == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = SH(this.neV.getTitle());
        textObject.text = SH(this.neV.topic) + SH(this.neV.getContent());
        return textObject;
    }

    private ImageObject L(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(h(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String SH(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void N(Intent intent) {
        if (this.nfm != null && this.nfn != null) {
            this.nfm.doResultIntent(intent, this.nfn);
            if (intent != null && intent.getExtras() == null) {
                this.nfn.onWbShareSuccess();
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.nfl != null) {
            this.nfl.mo41do(6, 1);
        }
        dp(1, 6);
    }

    public void onWbShareCancel() {
        if (this.nfl != null) {
            this.nfl.mo41do(6, 3);
        }
        dp(3, 6);
    }

    public void onWbShareFail() {
        if (this.nfl != null) {
            this.nfl.mo41do(6, 2);
        }
        dp(2, 6);
    }
}
