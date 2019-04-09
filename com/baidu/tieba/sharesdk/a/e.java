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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cmm;
    private ShareEntity iuY;
    private com.baidu.tieba.sharesdk.b.b ivj;
    private WbShareHandler ivk;
    private WbShareCallback ivl;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.cmm = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.iuY, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.iuY, aVar.oy());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.ivj != null) {
                    e.this.ivj.cf(6, 3);
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
        this.ivj = bVar;
        this.ivl = wbShareCallback;
        this.ivk = new WbShareHandler(activity);
        if (this.ivk != null) {
            this.ivk.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.ivk == null) {
            yF(2);
            if (bVar != null) {
                bVar.cf(6, 2);
                return;
            }
            return;
        }
        this.iuY = shareEntity;
        this.ivj = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.oy() != null) {
            a(this.iuY, a.oy());
            return;
        }
        String Xk = shareEntity.Xk();
        if (od(shareEntity.caN())) {
            a(this.iuY, BZ(shareEntity.caN()));
        } else if (!TextUtils.isEmpty(Xk) && (Xk.startsWith("http://") || Xk.startsWith("https://"))) {
            com.baidu.adp.lib.f.c.jB().a(Xk, 10, this.cmm, 0, 0, getPageId(), new Object[0]);
        } else if (q(shareEntity.getImageUri())) {
            a(this.iuY, p(shareEntity.getImageUri()));
        } else {
            a(this.iuY, caR());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.iuY == null || this.ivk == null || !(this.context instanceof Activity)) {
            if (this.ivj != null) {
                this.ivj.cf(6, 2);
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
        this.ivk.shareMessage(weiboMultiMessage, false);
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
        if (this.iuY == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Cb(this.iuY.getTitle());
        textObject.text = Cb(this.iuY.topic) + Cb(this.iuY.getContent());
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
        if (this.ivk != null && this.ivl != null) {
            this.ivk.doResultIntent(intent, this.ivl);
        }
    }

    public void onWbShareSuccess() {
        if (this.ivj != null) {
            this.ivj.cf(6, 1);
        }
        yF(1);
    }

    public void onWbShareCancel() {
        if (this.ivj != null) {
            this.ivj.cf(6, 3);
        }
        yF(3);
    }

    public void onWbShareFail() {
        if (this.ivj != null) {
            this.ivj.cf(6, 2);
        }
        yF(2);
    }
}
