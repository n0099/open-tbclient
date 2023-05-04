package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
public class uh9 extends qh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public xh9 k;
    public WbShareHandler l;
    public WbShareCallback m;
    public final bg<tm> n;

    public final String H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends bg<tm> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uh9 a;

        public a(uh9 uh9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uh9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uh9Var;
        }

        @Override // com.baidu.tieba.bg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.a.k != null) {
                    this.a.k.c1(6, 3);
                }
                this.a.t(3, 6);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.bg
        public void onLoaded(tm tmVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tmVar, str, i) == null) {
                super.onLoaded((a) tmVar, str, i);
                if (tmVar != null) {
                    Bitmap p = tmVar.p();
                    uh9 uh9Var = this.a;
                    uh9Var.Q(uh9Var.e, p);
                    return;
                }
                uh9 uh9Var2 = this.a;
                uh9Var2.Q(uh9Var2.e, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uh9(Activity activity, xh9 xh9Var, WbShareCallback wbShareCallback) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, xh9Var, wbShareCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e) {
            BdLog.e(e);
        }
        this.b = activity;
        this.k = xh9Var;
        this.m = wbShareCallback;
        WbShareHandler wbShareHandler = new WbShareHandler(activity);
        this.l = wbShareHandler;
        if (wbShareHandler != null) {
            wbShareHandler.registerApp();
        }
    }

    public final ImageObject I(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap)) == null) {
            ImageObject imageObject = new ImageObject();
            imageObject.setThumbImage(k(bitmap, 120));
            imageObject.setImageObject(bitmap);
            return imageObject;
        }
        return (ImageObject) invokeL.objValue;
    }

    @Override // com.baidu.tieba.qh9
    public void n(Intent intent) {
        WbShareHandler wbShareHandler;
        WbShareCallback wbShareCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, intent) == null) && (wbShareHandler = this.l) != null && (wbShareCallback = this.m) != null) {
            wbShareHandler.doResultIntent(intent, wbShareCallback);
            if (intent != null && intent.getExtras() == null) {
                this.m.onWbShareSuccess();
            }
        }
    }

    public final WebpageObject J(Bitmap bitmap, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, bitmap, str, str2, str3)) == null) {
            if (bitmap == null) {
                return null;
            }
            WebpageObject webpageObject = new WebpageObject();
            webpageObject.setThumbImage(bitmap);
            webpageObject.identify = Utility.generateGUID();
            webpageObject.title = H(str);
            webpageObject.description = H(str2);
            webpageObject.actionUrl = H(str3);
            return webpageObject;
        }
        return (WebpageObject) invokeLLLL.objValue;
    }

    public final WebpageObject K(byte[] bArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bArr, str)) == null) {
            if (bArr == null) {
                return null;
            }
            WebpageObject webpageObject = new WebpageObject();
            webpageObject.thumbData = bArr;
            webpageObject.identify = Utility.generateGUID();
            webpageObject.title = "";
            webpageObject.description = "";
            webpageObject.actionUrl = H(str);
            return webpageObject;
        }
        return (WebpageObject) invokeLL.objValue;
    }

    public final TextObject L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.e == null) {
                return null;
            }
            TextObject textObject = new TextObject();
            textObject.title = H(this.e.getTitle());
            textObject.text = H(this.e.topic) + H(this.e.getContent());
            return textObject;
        }
        return (TextObject) invokeV.objValue;
    }

    public final WebpageObject M(WeiboMultiMessage weiboMultiMessage, ShareEntity shareEntity, Bitmap bitmap) {
        InterceptResult invokeLLL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, weiboMultiMessage, shareEntity, bitmap)) == null) {
            byte[] bArr2 = null;
            if (weiboMultiMessage != null && shareEntity != null) {
                String linkUrl = shareEntity.getLinkUrl();
                if (TextUtils.isEmpty(linkUrl)) {
                    return null;
                }
                if (weiboMultiMessage.textObject != null) {
                    ImageObject imageObject = weiboMultiMessage.imageObject;
                    if (imageObject != null && (bArr = imageObject.thumbData) != null) {
                        bArr2 = bArr;
                    } else if (bitmap != null) {
                        bArr2 = BitmapHelper.Bitmap2Bytes(k(bitmap, 120), 100);
                    }
                    return K(bArr2, linkUrl);
                } else if (bitmap != null) {
                    return J(k(bitmap, 120), shareEntity.getTitle(), shareEntity.getContent(), linkUrl);
                }
            }
            return null;
        }
        return (WebpageObject) invokeLLL.objValue;
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            xh9 xh9Var = this.k;
            if (xh9Var != null) {
                xh9Var.c1(6, 3);
            }
            t(3, 6);
        }
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            xh9 xh9Var = this.k;
            if (xh9Var != null) {
                xh9Var.c1(6, 2);
            }
            t(2, 6);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            xh9 xh9Var = this.k;
            if (xh9Var != null) {
                xh9Var.c1(6, 1);
            }
            t(1, 6);
        }
    }

    public final void Q(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, shareEntity, bitmap) == null) {
            if (this.e != null && this.l != null && (this.b instanceof Activity)) {
                WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
                if (!TextUtils.isEmpty(shareEntity.getContent()) || !TextUtils.isEmpty(shareEntity.topic)) {
                    weiboMultiMessage.textObject = L();
                }
                if (bitmap != null) {
                    weiboMultiMessage.imageObject = I(bitmap);
                }
                WebpageObject M = M(weiboMultiMessage, shareEntity, bitmap);
                if (M != null) {
                    weiboMultiMessage.mediaObject = M;
                }
                this.l.shareMessage(weiboMultiMessage, false);
                return;
            }
            xh9 xh9Var = this.k;
            if (xh9Var != null) {
                xh9Var.c1(6, 2);
            }
            t(2, 6);
        }
    }

    @Override // com.baidu.tieba.wh9
    public void a(ShareEntity shareEntity, xh9 xh9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, shareEntity, xh9Var) == null) {
            if (shareEntity != null && this.l != null) {
                this.e = shareEntity;
                this.k = xh9Var;
                tm q = q(shareEntity);
                if (q != null && q.p() != null) {
                    Q(this.e, q.p());
                    return;
                }
                String imgUrl = shareEntity.getImgUrl();
                if (p(shareEntity.getLocalFile())) {
                    Q(this.e, i(shareEntity.getLocalFile()));
                    return;
                } else if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                    cg.h().k(imgUrl, 10, this.n, 0, 0, j(), new Object[0]);
                    return;
                } else if (o(shareEntity.getImageUri())) {
                    Q(this.e, h(shareEntity.getImageUri()));
                    return;
                } else {
                    Q(this.e, e());
                    return;
                }
            }
            t(2, 6);
            if (xh9Var != null) {
                xh9Var.c1(6, 2);
            }
        }
    }
}
