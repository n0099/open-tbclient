package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cml;
    private ShareEntity iuX;
    private com.baidu.tieba.sharesdk.b.b ivi;
    private WbShareHandler ivj;
    private WbShareCallback ivk;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.cml = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.iuX, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.iuX, aVar.oy());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.ivi != null) {
                    e.this.ivi.cf(6, 3);
                }
                e.this.yF(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.ivi = bVar;
        this.ivk = wbShareCallback;
        this.ivj = new WbShareHandler(activity);
        if (this.ivj != null) {
            this.ivj.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.ivj == null) {
            yF(2);
            if (bVar != null) {
                bVar.cf(6, 2);
                return;
            }
            return;
        }
        this.iuX = shareEntity;
        this.ivi = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.oy() != null) {
            a(this.iuX, a.oy());
            return;
        }
        String Xk = shareEntity.Xk();
        if (od(shareEntity.caN())) {
            a(this.iuX, BZ(shareEntity.caN()));
        } else if (!TextUtils.isEmpty(Xk) && (Xk.startsWith("http://") || Xk.startsWith("https://"))) {
            com.baidu.adp.lib.f.c.jB().a(Xk, 10, this.cml, 0, 0, getPageId(), new Object[0]);
        } else if (q(shareEntity.getImageUri())) {
            a(this.iuX, p(shareEntity.getImageUri()));
        } else {
            a(this.iuX, caR());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.iuX == null || this.ivj == null || !(this.context instanceof Activity)) {
            if (this.ivi != null) {
                this.ivi.cf(6, 2);
            }
            yF(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = caS();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = E(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.ivj.shareMessage(weiboMultiMessage, false);
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
            return e(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(e(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
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
        webpageObject.actionUrl = Cb(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Cb(str);
        webpageObject.description = Cb(str2);
        webpageObject.actionUrl = Cb(str3);
        return webpageObject;
    }

    private TextObject caS() {
        if (this.iuX == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Cb(this.iuX.getTitle());
        textObject.text = Cb(this.iuX.topic) + Cb(this.iuX.getContent());
        return textObject;
    }

    private ImageObject E(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(e(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Cb(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void X(Intent intent) {
        if (this.ivj != null && this.ivk != null) {
            this.ivj.doResultIntent(intent, this.ivk);
        }
    }

    public void onWbShareSuccess() {
        if (this.ivi != null) {
            this.ivi.cf(6, 1);
        }
        yF(1);
    }

    public void onWbShareCancel() {
        if (this.ivi != null) {
            this.ivi.cf(6, 3);
        }
        yF(3);
    }

    public void onWbShareFail() {
        if (this.ivi != null) {
            this.ivi.cf(6, 2);
        }
        yF(2);
    }
}
