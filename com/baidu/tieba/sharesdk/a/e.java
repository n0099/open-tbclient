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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cvJ;
    private ShareEntity iUk;
    private com.baidu.tieba.sharesdk.b.b iUv;
    private WbShareHandler iUw;
    private WbShareCallback iUx;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.cvJ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.iUk, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.iUk, aVar.nK());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.iUv != null) {
                    e.this.iUv.cs(6, 3);
                }
                e.this.As(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.iUv = bVar;
        this.iUx = wbShareCallback;
        this.iUw = new WbShareHandler(activity);
        if (this.iUw != null) {
            this.iUw.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iUw == null) {
            As(2);
            if (bVar != null) {
                bVar.cs(6, 2);
                return;
            }
            return;
        }
        this.iUk = shareEntity;
        this.iUv = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.nK() != null) {
            a(this.iUk, a.nK());
            return;
        }
        String acU = shareEntity.acU();
        if (pD(shareEntity.clL())) {
            a(this.iUk, Ek(shareEntity.clL()));
        } else if (!TextUtils.isEmpty(acU) && (acU.startsWith("http://") || acU.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.iE().a(acU, 10, this.cvJ, 0, 0, getPageId(), new Object[0]);
        } else if (w(shareEntity.getImageUri())) {
            a(this.iUk, v(shareEntity.getImageUri()));
        } else {
            a(this.iUk, clP());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.iUk == null || this.iUw == null || !(this.context instanceof Activity)) {
            if (this.iUv != null) {
                this.iUv.cs(6, 2);
            }
            As(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = clQ();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = F(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.iUw.shareMessage(weiboMultiMessage, false);
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
                bArr = BitmapHelper.Bitmap2Bytes(f(bitmap, 120), 100);
            }
            return f(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(f(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
        } else {
            return null;
        }
    }

    private WebpageObject f(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.thumbData = bArr;
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = "";
        webpageObject.description = "";
        webpageObject.actionUrl = Em(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Em(str);
        webpageObject.description = Em(str2);
        webpageObject.actionUrl = Em(str3);
        return webpageObject;
    }

    private TextObject clQ() {
        if (this.iUk == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Em(this.iUk.getTitle());
        textObject.text = Em(this.iUk.topic) + Em(this.iUk.getContent());
        return textObject;
    }

    private ImageObject F(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(f(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Em(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void aa(Intent intent) {
        if (this.iUw != null && this.iUx != null) {
            this.iUw.doResultIntent(intent, this.iUx);
            if (intent != null && intent.getExtras() == null) {
                this.iUx.onWbShareSuccess();
                At(1);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.iUv != null) {
            this.iUv.cs(6, 1);
        }
        As(1);
    }

    public void onWbShareCancel() {
        if (this.iUv != null) {
            this.iUv.cs(6, 3);
        }
        As(3);
    }

    public void onWbShareFail() {
        if (this.iUv != null) {
            this.iUv.cs(6, 2);
        }
        As(2);
    }
}
