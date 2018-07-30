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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aPR;
    private ShareEntity gBZ;
    private com.baidu.tieba.sharesdk.b.b gCk;
    private WbShareHandler gCl;
    private WbShareCallback gCm;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.aPR = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.gBZ, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.gBZ, aVar.nb());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.gCk != null) {
                    e.this.gCk.bD(6, 3);
                }
                e.this.sT(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.gCk = bVar;
        this.gCm = wbShareCallback;
        this.gCl = new WbShareHandler(activity);
        if (this.gCl != null) {
            this.gCl.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gCl == null) {
            sT(2);
            if (bVar != null) {
                bVar.bD(6, 2);
                return;
            }
            return;
        }
        this.gBZ = shareEntity;
        this.gCk = bVar;
        String tU = shareEntity.tU();
        if (!TextUtils.isEmpty(tU) && (tU.startsWith("http://") || tU.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.ih().a(tU, 10, this.aPR, 0, 0, getPageId(), new Object[0]);
        } else if (h(shareEntity.getImageUri())) {
            a(this.gBZ, g(shareEntity.getImageUri()));
        } else {
            a(this.gBZ, bru());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.gBZ == null || this.gCl == null || !(this.context instanceof Activity)) {
            if (this.gCk != null) {
                this.gCk.bD(6, 2);
            }
            sT(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = brv();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = v(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.gCl.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = tl(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = tl(str);
        webpageObject.description = tl(str2);
        webpageObject.actionUrl = tl(str3);
        return webpageObject;
    }

    private TextObject brv() {
        if (this.gBZ == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = tl(this.gBZ.getTitle());
        textObject.text = tl(this.gBZ.getContent());
        return textObject;
    }

    private ImageObject v(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(e(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String tl(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void D(Intent intent) {
        if (this.gCl != null && this.gCm != null) {
            this.gCl.doResultIntent(intent, this.gCm);
        }
    }

    public void onWbShareSuccess() {
        if (this.gCk != null) {
            this.gCk.bD(6, 1);
        }
        sT(1);
    }

    public void onWbShareCancel() {
        if (this.gCk != null) {
            this.gCk.bD(6, 3);
        }
        sT(3);
    }

    public void onWbShareFail() {
        if (this.gCk != null) {
            this.gCk.bD(6, 2);
        }
        sT(2);
    }
}
