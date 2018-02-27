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
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> bvY;
    private ShareEntity gPb;
    private com.baidu.tieba.sharesdk.b.b gPm;
    private IWeiboShareAPI gPn;
    private IWeiboHandler.Response gPo;

    public e(Context context, com.baidu.tieba.sharesdk.b.b bVar, IWeiboHandler.Response response) {
        super(context);
        this.bvY = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tieba.sharesdk.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                super.onLoaded((AnonymousClass1) aVar, str, i);
                if (aVar == null) {
                    e.this.a(e.this.gPb, (Bitmap) null);
                    return;
                }
                e.this.a(e.this.gPb, aVar.sh());
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.f.b
            public void onCancelled(String str) {
                super.onCancelled(str);
                if (e.this.gPm != null) {
                    e.this.gPm.cA(6, 3);
                }
                e.this.uY(3);
            }
        };
        this.context = context;
        this.gPm = bVar;
        this.gPo = response;
        this.gPn = WeiboShareSDK.createWeiboAPI(getAppContext(), "3826995480");
        if (this.gPn != null) {
            this.gPn.registerApp();
        }
    }

    @Override // com.baidu.tieba.sharesdk.b.a
    public void a(ShareEntity shareEntity, com.baidu.tieba.sharesdk.b.b bVar) {
        if (shareEntity == null || this.gPn == null) {
            uY(2);
            if (bVar != null) {
                bVar.cA(6, 2);
                return;
            }
            return;
        }
        this.gPb = shareEntity;
        this.gPm = bVar;
        String ya = shareEntity.ya();
        if (!TextUtils.isEmpty(ya) && (ya.startsWith("http://") || ya.startsWith("https://"))) {
            com.baidu.adp.lib.f.c.nm().a(ya, 10, this.bvY, 0, 0, getPageId(), new Object[0]);
        } else if (ri(ya)) {
            a(this.gPb, sk(ya));
        } else {
            a(this.gPb, bsj());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.gPb == null || this.gPn == null || !(this.context instanceof Activity)) {
            if (this.gPm != null) {
                this.gPm.cA(6, 2);
            }
            uY(2);
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        if (!TextUtils.isEmpty(shareEntity.getContent())) {
            weiboMultiMessage.textObject = bsk();
        }
        if (bitmap != null) {
            weiboMultiMessage.imageObject = t(bitmap);
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
        Oauth2AccessToken ch = com.baidu.tieba.sharesdk.c.c.ch(getAppContext());
        this.gPn.sendRequest(activity, sendMultiMessageToWeiboRequest, authInfo, ch != null ? ch.getToken() : "", new WeiboAuthListener() { // from class: com.baidu.tieba.sharesdk.a.e.2
            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onWeiboException(WeiboException weiboException) {
                if (e.this.gPm != null) {
                    e.this.gPm.cA(6, 2);
                }
                e.this.si(e.this.getString(d.j.share_weibosdk_auth_failed, new Object[0]));
            }

            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onComplete(Bundle bundle) {
                com.baidu.tieba.sharesdk.c.c.a(e.this.getAppContext(), Oauth2AccessToken.parseAccessToken(bundle));
                e.this.sj(e.this.getString(d.j.share_weibosdk_auth_success, new Object[0]));
            }

            @Override // com.sina.weibo.sdk.auth.WeiboAuthListener
            public void onCancel() {
                if (e.this.gPm != null) {
                    e.this.gPm.cA(6, 3);
                }
                e.this.si(e.this.getString(d.j.share_weibosdk_auth_failed, new Object[0]));
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
                bArr = BitmapHelper.Bitmap2Bytes(g(bitmap, 120), 100);
            }
            return d(bArr, linkUrl);
        } else if (bitmap != null) {
            return a(g(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
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
        webpageObject.actionUrl = sm(str);
        return webpageObject;
    }

    private WebpageObject a(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = sm(str);
        webpageObject.description = sm(str2);
        webpageObject.actionUrl = sm(str3);
        return webpageObject;
    }

    private TextObject bsk() {
        if (this.gPb == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = sm(this.gPb.getTitle());
        textObject.text = sm(this.gPb.getContent());
        return textObject;
    }

    private ImageObject t(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(g(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    private String sm(String str) {
        return str == null ? "" : str;
    }

    @Override // com.baidu.tieba.sharesdk.a.a
    public void F(Intent intent) {
        if (this.gPn != null && this.gPo != null) {
            this.gPn.handleWeiboResponse(intent, this.gPo);
        }
    }

    public void onResponse(BaseResponse baseResponse) {
        if (baseResponse != null) {
            switch (baseResponse.errCode) {
                case 0:
                    if (this.gPm != null) {
                        this.gPm.cA(6, 1);
                    }
                    uY(1);
                    return;
                case 1:
                    if (this.gPm != null) {
                        this.gPm.cA(6, 3);
                    }
                    uY(3);
                    return;
                case 2:
                    if (this.gPm != null) {
                        this.gPm.cA(6, 2);
                    }
                    uY(2);
                    return;
                default:
                    if (this.gPm != null) {
                        this.gPm.cA(6, 2);
                    }
                    uY(2);
                    return;
            }
        }
        if (this.gPm != null) {
            this.gPm.cA(6, 2);
        }
        uY(2);
    }
}
