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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cuu;
    private ShareEntity iNO;
    private com.baidu.tieba.sharesdk.b.b iNZ;
    private WbShareHandler iOa;
    private WbShareCallback iOb;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.cuu = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.iNO, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.iNO, aVar.ns());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.iNZ != null) {
                    e.this.iNZ.cm(6, 3);
                }
                e.this.zM(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.iNZ = bVar;
        this.iOb = wbShareCallback;
        this.iOa = new WbShareHandler(activity);
        if (this.iOa != null) {
            this.iOa.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iOa == null) {
            zM(2);
            if (bVar != null) {
                bVar.cm(6, 2);
                return;
            }
            return;
        }
        this.iNO = shareEntity;
        this.iNZ = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.ns() != null) {
            a(this.iNO, a.ns());
            return;
        }
        String abS = shareEntity.abS();
        if (pn(shareEntity.ciT())) {
            a(this.iNO, Dv(shareEntity.ciT()));
        } else if (!TextUtils.isEmpty(abS) && (abS.startsWith("http://") || abS.startsWith("https://"))) {
            com.baidu.adp.lib.f.c.iv().a(abS, 10, this.cuu, 0, 0, getPageId(), new Object[0]);
        } else if (w(shareEntity.getImageUri())) {
            a(this.iNO, v(shareEntity.getImageUri()));
        } else {
            a(this.iNO, ciX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.iNO == null || this.iOa == null || !(this.context instanceof Activity)) {
            if (this.iNZ != null) {
                this.iNZ.cm(6, 2);
            }
            zM(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = ciY();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = F(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.iOa.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = Dx(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = Dx(str);
        webpageObject.description = Dx(str2);
        webpageObject.actionUrl = Dx(str3);
        return webpageObject;
    }

    private TextObject ciY() {
        if (this.iNO == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = Dx(this.iNO.getTitle());
        textObject.text = Dx(this.iNO.topic) + Dx(this.iNO.getContent());
        return textObject;
    }

    private ImageObject F(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(f(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String Dx(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void aa(Intent intent) {
        if (this.iOa != null && this.iOb != null) {
            this.iOa.doResultIntent(intent, this.iOb);
            if (intent != null && intent.getExtras() == null) {
                zN(1);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.iNZ != null) {
            this.iNZ.cm(6, 1);
        }
        zM(1);
    }

    public void onWbShareCancel() {
        if (this.iNZ != null) {
            this.iNZ.cm(6, 3);
        }
        zM(3);
    }

    public void onWbShareFail() {
        if (this.iNZ != null) {
            this.iNZ.cm(6, 2);
        }
        zM(2);
    }
}
