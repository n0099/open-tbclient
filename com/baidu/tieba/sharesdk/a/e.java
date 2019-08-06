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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> cvQ;
    private WbShareHandler iVA;
    private WbShareCallback iVB;
    private ShareEntity iVo;
    private com.baidu.tieba.sharesdk.b.b iVz;

    public e(Activity activity, com.baidu.tieba.sharesdk.b.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.cvQ = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.iVo, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.iVo, aVar.nK());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.iVz != null) {
                    e.this.iVz.cs(6, 3);
                }
                e.this.Au(3);
            }
        };
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.context = activity;
        this.iVz = bVar;
        this.iVB = wbShareCallback;
        this.iVA = new WbShareHandler(activity);
        if (this.iVA != null) {
            this.iVA.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.iVA == null) {
            Au(2);
            if (bVar != null) {
                bVar.cs(6, 2);
                return;
            }
            return;
        }
        this.iVo = shareEntity;
        this.iVz = bVar;
        com.baidu.adp.widget.ImageView.a a = a(shareEntity);
        if (a != null && a.nK() != null) {
            a(this.iVo, a.nK());
            return;
        }
        String acV = shareEntity.acV();
        if (pD(shareEntity.cmd())) {
            a(this.iVo, El(shareEntity.cmd()));
        } else if (!TextUtils.isEmpty(acV) && (acV.startsWith("http://") || acV.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX))) {
            com.baidu.adp.lib.f.c.iE().a(acV, 10, this.cvQ, 0, 0, getPageId(), new Object[0]);
        } else if (w(shareEntity.getImageUri())) {
            a(this.iVo, v(shareEntity.getImageUri()));
        } else {
            a(this.iVo, cmh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.iVo == null || this.iVA == null || !(this.context instanceof Activity)) {
            if (this.iVz != null) {
                this.iVz.cs(6, 2);
            }
            Au(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
            weiboMultiMessage.textObject = cmi();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = F(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        this.iVA.shareMessage(weiboMultiMessage, false);
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
        webpageObject.actionUrl = En(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = En(str);
        webpageObject.description = En(str2);
        webpageObject.actionUrl = En(str3);
        return webpageObject;
    }

    private TextObject cmi() {
        if (this.iVo == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = En(this.iVo.getTitle());
        textObject.text = En(this.iVo.topic) + En(this.iVo.getContent());
        return textObject;
    }

    private ImageObject F(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(f(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String En(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void ac(Intent intent) {
        if (this.iVA != null && this.iVB != null) {
            this.iVA.doResultIntent(intent, this.iVB);
            if (intent != null && intent.getExtras() == null) {
                this.iVB.onWbShareSuccess();
                Av(1);
            }
        }
    }

    public void onWbShareSuccess() {
        if (this.iVz != null) {
            this.iVz.cs(6, 1);
        }
        Au(1);
    }

    public void onWbShareCancel() {
        if (this.iVz != null) {
            this.iVz.cs(6, 3);
        }
        Au(3);
    }

    public void onWbShareFail() {
        if (this.iVz != null) {
            this.iVz.cs(6, 2);
        }
        Au(2);
    }
}
