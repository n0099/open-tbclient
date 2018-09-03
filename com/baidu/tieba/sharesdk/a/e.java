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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aPO;
    private ShareEntity gCc;
    private com.baidu.tieba.sharesdk.b.b gCn;
    private WbShareHandler gCo;
    private WbShareCallback gCp;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.aPO = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.gCc, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.gCc, aVar.nb());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.gCn != null) {
                    e.this.gCn.bD(6, 3);
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
        this.gCn = bVar;
        this.gCp = wbShareCallback;
        this.gCo = new WbShareHandler(activity);
        if (this.gCo != null) {
            this.gCo.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gCo == null) {
            sT(2);
            if (bVar != null) {
                bVar.bD(6, 2);
                return;
            }
            return;
        }
        this.gCc = shareEntity;
        this.gCn = bVar;
        String tT = shareEntity.tT();
        if (!TextUtils.isEmpty(tT) && (tT.startsWith("http://") || tT.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.ih().a(tT, 10, this.aPO, 0, 0, getPageId(), new Object[0]);
        } else if (h(shareEntity.getImageUri())) {
            a(this.gCc, g(shareEntity.getImageUri()));
        } else {
            a(this.gCc, brv());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.gCc == null || this.gCo == null || !(this.context instanceof Activity)) {
            if (this.gCn != null) {
                this.gCn.bD(6, 2);
            }
            sT(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = brw();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = v(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.gCo.shareMessage(weiboMultiMessage, false);
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
            return d(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(d(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
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
        webpageObject.actionUrl = tp(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = tp(str);
        webpageObject.description = tp(str2);
        webpageObject.actionUrl = tp(str3);
        return webpageObject;
    }

    private TextObject brw() {
        if (this.gCc == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = tp(this.gCc.getTitle());
        textObject.text = tp(this.gCc.getContent());
        return textObject;
    }

    private ImageObject v(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(d(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String tp(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void D(Intent intent) {
        if (this.gCo != null && this.gCp != null) {
            this.gCo.doResultIntent(intent, this.gCp);
        }
    }

    public void onWbShareSuccess() {
        if (this.gCn != null) {
            this.gCn.bD(6, 1);
        }
        sT(1);
    }

    public void onWbShareCancel() {
        if (this.gCn != null) {
            this.gCn.bD(6, 3);
        }
        sT(3);
    }

    public void onWbShareFail() {
        if (this.gCn != null) {
            this.gCn.bD(6, 2);
        }
        sT(2);
    }
}
