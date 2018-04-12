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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> aGy;
    private com.baidu.tieba.sharesdk.b.b gkI;
    private IWeiboShareAPI gkJ;
    private IWeiboHandler.Response gkK;
    private ShareEntity gkx;

    public e(Context context, com.baidu.tieba.sharesdk.b.b bVar, IWeiboHandler.Response response) {
        super(context);
        this.aGy = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.gkx, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.gkx, aVar.km());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.gkI != null) {
                    e.this.gkI.bC(6, 3);
                }
                e.this.sB(3);
            }
        };
        this.context = context;
        this.gkI = bVar;
        this.gkK = response;
        this.gkJ = WeiboShareSDK.createWeiboAPI(getAppContext(), "3826995480");
        if (this.gkJ != null) {
            this.gkJ.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gkJ == null) {
            sB(2);
            if (bVar != null) {
                bVar.bC(6, 2);
                return;
            }
            return;
        }
        this.gkx = shareEntity;
        this.gkI = bVar;
        String qG = shareEntity.qG();
        if (!TextUtils.isEmpty(qG) && (qG.startsWith("http://") || qG.startsWith("https://"))) {
            com.baidu.adp.lib.f.c.fp().a(qG, 10, this.aGy, 0, 0, getPageId(), new Object[0]);
        } else if (i(shareEntity.bnq())) {
            a(this.gkx, h(shareEntity.bnq()));
        } else {
            a(this.gkx, bnt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.gkx == null || this.gkJ == null || !(this.context instanceof Activity)) {
            if (this.gkI != null) {
                this.gkI.bC(6, 2);
            }
            sB(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = bnu();
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
        this.gkJ.sendRequest(activity, sendMultiMessageToWeiboRequest, authInfo, bV != null ? bV.getToken() : "", new WeiboAuthListener() { // from class: com.baidu.tieba.sharesdk.a.e.2
            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onWeiboException(WeiboException weiboException) {
                if (e.this.gkI != null) {
                    e.this.gkI.bC(6, 2);
                }
                e.this.sp(e.this.getString(d.k.share_weibosdk_auth_failed, new Object[0]));
            }

            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onComplete(Bundle bundle) {
                com.baidu.tieba.sharesdk.c.c.a(e.this.getAppContext(), Oauth2AccessToken.parseAccessToken(bundle));
                e.this.sq(e.this.getString(d.k.share_weibosdk_auth_success, new Object[0]));
            }

            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onCancel() {
                if (e.this.gkI != null) {
                    e.this.gkI.bC(6, 3);
                }
                e.this.sp(e.this.getString(d.k.share_weibosdk_auth_failed, new Object[0]));
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
        webpageObject.actionUrl = su(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = su(str);
        webpageObject.description = su(str2);
        webpageObject.actionUrl = su(str3);
        return webpageObject;
    }

    private TextObject bnu() {
        if (this.gkx == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = su(this.gkx.getTitle());
        textObject.text = su(this.gkx.getContent());
        return textObject;
    }

    private ImageObject x(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(e(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String su(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void D(Intent intent) {
        if (this.gkJ != null && this.gkK != null) {
            this.gkJ.handleWeiboResponse(intent, this.gkK);
        }
    }

    public void onResponse(BaseResponse baseResponse) {
        if (baseResponse != null) {
            switch (baseResponse.errCode) {
                case 0:
                    if (this.gkI != null) {
                        this.gkI.bC(6, 1);
                    }
                    sB(1);
                    return;
                case 1:
                    if (this.gkI != null) {
                        this.gkI.bC(6, 3);
                    }
                    sB(3);
                    return;
                case 2:
                    if (this.gkI != null) {
                        this.gkI.bC(6, 2);
                    }
                    sB(2);
                    return;
                default:
                    if (this.gkI != null) {
                        this.gkI.bC(6, 2);
                    }
                    sB(2);
                    return;
            }
        }
        if (this.gkI != null) {
            this.gkI.bC(6, 2);
        }
        sB(2);
    }
}
