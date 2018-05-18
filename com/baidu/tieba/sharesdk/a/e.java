package com.baidu.tieba.sharesdk.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.BaseResponse;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.Utility;
/* loaded from: classes3.dex */
public class e extends a {
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aGz;
    private ShareEntity glA;
    private com.baidu.tieba.sharesdk.b.b glL;
    private IWeiboShareAPI glM;
    private IWeiboHandler.Response glN;

    public e(Context context, com.baidu.tieba.sharesdk.b.b bVar, IWeiboHandler.Response response) {
        super(context);
        this.aGz = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.glA, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.glA, aVar.kl());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.glL != null) {
                    e.this.glL.bB(6, 3);
                }
                e.this.sz(3);
            }
        };
        this.context = context;
        this.glL = bVar;
        this.glN = response;
        this.glM = WeiboShareSDK.createWeiboAPI(getAppContext(), "3826995480");
        if (this.glM != null) {
            this.glM.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.glM == null) {
            sz(2);
            if (bVar != null) {
                bVar.bB(6, 2);
                return;
            }
            return;
        }
        this.glA = shareEntity;
        this.glL = bVar;
        String qF = shareEntity.qF();
        if (!TextUtils.isEmpty(qF) && (qF.startsWith("http://") || qF.startsWith("https://"))) {
            com.baidu.adp.lib.f.c.fp().a(qF, 10, this.aGz, 0, 0, getPageId(), new Object[0]);
        } else if (i(shareEntity.bno())) {
            a(this.glA, h(shareEntity.bno()));
        } else {
            a(this.glA, bnr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.glA == null || this.glM == null || !(this.context instanceof Activity)) {
            if (this.glL != null) {
                this.glL.bB(6, 2);
            }
            sz(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = bns();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = x(bitmap);
        }
        WebpageObject a = a(weiboMultiMessage, shareEntity, bitmap);
        if (a != null) {
            weiboMultiMessage.mediaObject = a;
        }
        SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
        sendMultiMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
        sendMultiMessageToWeiboRequest.multiMessage = weiboMultiMessage;
        Activity activity = (Activity) this.context;
        AuthInfo authInfo = new AuthInfo(this.context, "3826995480", "https://tieba.baidu.com", "invitation_write");
        Oauth2AccessToken bV = com.baidu.tieba.sharesdk.c.c.bV(getAppContext());
        this.glM.sendRequest(activity, sendMultiMessageToWeiboRequest, authInfo, bV != null ? bV.getToken() : "", new WeiboAuthListener() { // from class: com.baidu.tieba.sharesdk.a.e.2
            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onWeiboException(WeiboException weiboException) {
                if (e.this.glL != null) {
                    e.this.glL.bB(6, 2);
                }
                e.this.st(e.this.getString(d.k.share_weibosdk_auth_failed, new Object[0]));
            }

            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onComplete(Bundle bundle) {
                com.baidu.tieba.sharesdk.c.c.a(e.this.getAppContext(), Oauth2AccessToken.parseAccessToken(bundle));
                e.this.su(e.this.getString(d.k.share_weibosdk_auth_success, new Object[0]));
            }

            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onCancel() {
                if (e.this.glL != null) {
                    e.this.glL.bB(6, 3);
                }
                e.this.st(e.this.getString(d.k.share_weibosdk_auth_failed, new Object[0]));
            }
        });
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
        webpageObject.actionUrl = sx(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = sx(str);
        webpageObject.description = sx(str2);
        webpageObject.actionUrl = sx(str3);
        return webpageObject;
    }

    private TextObject bns() {
        if (this.glA == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = sx(this.glA.getTitle());
        textObject.text = sx(this.glA.getContent());
        return textObject;
    }

    private ImageObject x(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(e(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String sx(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void D(Intent intent) {
        if (this.glM != null && this.glN != null) {
            this.glM.handleWeiboResponse(intent, this.glN);
        }
    }

    public void onResponse(BaseResponse baseResponse) {
        if (baseResponse != null) {
            switch (baseResponse.errCode) {
                case 0:
                    if (this.glL != null) {
                        this.glL.bB(6, 1);
                    }
                    sz(1);
                    return;
                case 1:
                    if (this.glL != null) {
                        this.glL.bB(6, 3);
                    }
                    sz(3);
                    return;
                case 2:
                    if (this.glL != null) {
                        this.glL.bB(6, 2);
                    }
                    sz(2);
                    return;
                default:
                    if (this.glL != null) {
                        this.glL.bB(6, 2);
                    }
                    sz(2);
                    return;
            }
        }
        if (this.glL != null) {
            this.glL.bB(6, 2);
        }
        sz(2);
    }
}
