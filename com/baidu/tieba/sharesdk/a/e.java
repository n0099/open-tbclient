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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> bbU;
    private com.baidu.tieba.sharesdk.b.b hcH;
    private WbShareHandler hcI;
    private WbShareCallback hcJ;
    private ShareEntity hcw;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.bbU = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.hcw, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.hcw, aVar.op());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.hcH != null) {
                    e.this.hcH.bJ(6, 3);
                }
                e.this.uR(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", "https://passport.baidu.com", "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.hcH = bVar;
        this.hcJ = wbShareCallback;
        this.hcI = new WbShareHandler(activity);
        if (this.hcI != null) {
            this.hcI.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.hcI == null) {
            uR(2);
            if (bVar != null) {
                bVar.bJ(6, 2);
                return;
            }
            return;
        }
        this.hcw = shareEntity;
        this.hcH = bVar;
        String ys = shareEntity.ys();
        if (!TextUtils.isEmpty(ys) && (ys.startsWith("http://") || ys.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.jA().a(ys, 10, this.bbU, 0, 0, getPageId(), new Object[0]);
        } else if (i(shareEntity.getImageUri())) {
            a(this.hcw, h(shareEntity.getImageUri()));
        } else {
            a(this.hcw, bzu());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.hcw == null || this.hcI == null || !(this.context instanceof Activity)) {
            if (this.hcH != null) {
                this.hcH.bJ(6, 2);
            }
            uR(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = bzv();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = w(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.hcI.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = vg(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = vg(str);
        webpageObject.description = vg(str2);
        webpageObject.actionUrl = vg(str3);
        return webpageObject;
    }

    private TextObject bzv() {
        if (this.hcw == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = vg(this.hcw.getTitle());
        textObject.text = vg(this.hcw.topic) + vg(this.hcw.getContent());
        return textObject;
    }

    private ImageObject w(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(d(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String vg(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void H(Intent intent) {
        if (this.hcI != null && this.hcJ != null) {
            this.hcI.doResultIntent(intent, this.hcJ);
        }
    }

    public void onWbShareSuccess() {
        if (this.hcH != null) {
            this.hcH.bJ(6, 1);
        }
        uR(1);
    }

    public void onWbShareCancel() {
        if (this.hcH != null) {
            this.hcH.bJ(6, 3);
        }
        uR(1);
    }

    public void onWbShareFail() {
        if (this.hcH != null) {
            this.hcH.bJ(6, 2);
        }
        uR(2);
    }
}
