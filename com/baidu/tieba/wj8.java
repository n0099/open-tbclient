package com.baidu.tieba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
/* loaded from: classes6.dex */
public class wj8 extends rj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public yj8 l;
    public IWXAPI m;
    public d n;
    public final sg<EmotionShareLoaderProc.EmotionShare> o;
    public final c p;

    /* loaded from: classes6.dex */
    public class a extends sg<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj8 a;

        public a(wj8 wj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj8Var;
        }

        @Override // com.baidu.tieba.sg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.a.p.onCancelled(str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sg
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null) {
                    wj8 wj8Var = this.a;
                    if (wj8Var.h0(wj8Var.e, emotionShare)) {
                        return;
                    }
                }
                this.a.p.onLoaded((in) null, str, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<Bitmap, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj8 a;

        public b(wj8 wj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                    wj8 wj8Var = this.a;
                    return wj8Var.v(bitmapArr[0], wj8Var.e, false);
                }
                return null;
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
                super.onPostExecute((b) bitmap);
                wj8 wj8Var = this.a;
                wj8Var.n0(wj8Var.e, bitmap);
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class c extends sg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj8 a;

        public c(wj8 wj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wj8Var;
        }

        public /* synthetic */ c(wj8 wj8Var, a aVar) {
            this(wj8Var);
        }

        @Override // com.baidu.tieba.sg
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.a.l != null) {
                    this.a.l.b1(this.a.k, 3);
                }
                wj8 wj8Var = this.a;
                wj8Var.u(3, wj8Var.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inVar, str, i) == null) {
                super.onLoaded((c) inVar, str, i);
                if (inVar == null) {
                    this.a.p0();
                    return;
                }
                Bitmap p = inVar.p();
                if (!TextUtils.isEmpty(this.a.e.getLinkUrl())) {
                    if (this.a.k == 2) {
                        wj8 wj8Var = this.a;
                        wj8Var.o0(wj8Var.e, p);
                        return;
                    }
                    String tid = this.a.e.getTid();
                    int typeShareToSmallApp = this.a.e.getTypeShareToSmallApp();
                    if ((typeShareToSmallApp == 2 || typeShareToSmallApp == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && this.a.e.canShareBySmartApp && !WeChatShareSmallAppToH5Switch.isOn()) {
                        wj8 wj8Var2 = this.a;
                        wj8Var2.k0(wj8Var2.e, p);
                        return;
                    }
                    wj8 wj8Var3 = this.a;
                    wj8Var3.o0(wj8Var3.e, p);
                } else if (!TextUtils.isEmpty(this.a.e.getVideoUrl())) {
                    wj8 wj8Var4 = this.a;
                    wj8Var4.m0(wj8Var4.e, p);
                } else if (!TextUtils.isEmpty(this.a.e.getContent())) {
                    this.a.p0();
                } else {
                    wj8 wj8Var5 = this.a;
                    wj8Var5.i0(wj8Var5.e, p);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wj8 this$0;

        public d(wj8 wj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = wj8Var;
        }

        public /* synthetic */ d(wj8 wj8Var, a aVar) {
            this(wj8Var);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (this.this$0.l != null) {
                        this.this$0.l.b1(this.this$0.k, 1);
                    }
                    wj8 wj8Var = this.this$0;
                    wj8Var.u(1, wj8Var.k);
                } else if (intExtra == -2) {
                    if (this.this$0.l != null) {
                        this.this$0.l.b1(this.this$0.k, 3);
                    }
                    wj8 wj8Var2 = this.this$0;
                    wj8Var2.u(3, wj8Var2.k);
                } else {
                    this.this$0.s0(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (this.this$0.l != null) {
                        this.this$0.l.b1(this.this$0.k, 2);
                    }
                    wj8 wj8Var3 = this.this$0;
                    wj8Var3.u(2, wj8Var3.k);
                }
                this.this$0.a0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wj8(Context context, int i) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
        this.p = new c(this, null);
        this.b = context.getApplicationContext();
        this.k = i;
        this.m = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    public final boolean f0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, shareEntity, emotionShare)) == null) {
            if (shareEntity != null && this.m != null && emotionShare != null && emotionShare.image != null && !StringUtils.isNull(emotionShare.path)) {
                WXEmojiObject wXEmojiObject = new WXEmojiObject();
                wXEmojiObject.emojiPath = emotionShare.path;
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXEmojiObject;
                wXMediaMessage.thumbData = T(emotionShare.image.p());
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = W("imageShare");
                req.message = wXMediaMessage;
                req.scene = V();
                this.m.sendReq(req);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void g0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null && bitmap != null) {
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiData = U(bitmap, 512, false);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = T(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("imageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
        }
    }

    public final void i0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            if (c0(wXImageObject, bitmap)) {
                return;
            }
            wXImageObject.imageData = ri.d().a(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = T(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("imageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
        }
    }

    public final void m0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = T(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("videoShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
        }
    }

    public final void n0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = T(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("webpageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
        }
    }

    public final void s0(int i, String str) {
        ShareEntity shareEntity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048603, this, i, str) == null) && (shareEntity = this.e) != null && !StringUtils.isNull(shareEntity.getImgUrl())) {
            fy4.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.e.getImgUrl());
        }
    }

    public final String W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str == null) {
                return String.valueOf(System.currentTimeMillis());
            }
            return str + System.currentTimeMillis();
        }
        return (String) invokeL.objValue;
    }

    public boolean Y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            if (this.m.getWXAppSupportAPI() >= 654314752) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bitmap i = i(str);
            if (i == null) {
                i = e();
            }
            if (i != null) {
                i0(this.e, i);
            } else {
                l0(this.e);
            }
        }
    }

    @Override // com.baidu.tieba.rj8
    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bdUniqueId) == null) {
            super.t(bdUniqueId);
            d0();
        }
    }

    public byte[] T(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmap)) == null) {
            try {
                Bitmap k = k(bitmap, 120);
                if (k == null) {
                    k = e();
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                k.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeL.objValue;
    }

    public final void l0(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, shareEntity) == null) && shareEntity != null && this.m != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("textShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
        }
    }

    public byte[] U(Bitmap bitmap, int i, boolean z) {
        InterceptResult invokeCommon;
        Bitmap k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                if (z) {
                    k = f(R.drawable.obfuscated_res_0x7f080da6);
                } else {
                    k = k(bitmap, i);
                }
                if (k == null) {
                    k = f(R.drawable.obfuscated_res_0x7f080da6);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                k.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public final int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i = this.k;
            if (i == 3) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            FileHelper.deleteFile(new File(rj8.h + rj8.j));
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.b != null) {
            this.n = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.b.registerReceiver(this.n, intentFilter);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Bitmap e = e();
            if (e != null) {
                i0(this.e, e);
            } else {
                l0(this.e);
            }
        }
    }

    public final void r0() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (context = this.b) != null && (dVar = this.n) != null) {
            context.unregisterReceiver(dVar);
        }
    }

    @Override // com.baidu.tieba.rj8
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            r0();
            super.s();
        }
    }

    public byte[] Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Bitmap f = f(R.drawable.obfuscated_res_0x7f080da6);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                f.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xj8
    public void a(ShareEntity shareEntity, yj8 yj8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, shareEntity, yj8Var) == null) {
            if (shareEntity != null && this.m != null) {
                this.e = shareEntity;
                this.l = yj8Var;
                this.k = shareEntity.getShareTo();
                if (!this.m.isWXAppInstalled()) {
                    yj8 yj8Var2 = this.l;
                    if (yj8Var2 != null) {
                        yj8Var2.b1(this.k, 2);
                    }
                    BdToast.b(d(), d().getText(R.string.obfuscated_res_0x7f0f11c9)).i();
                    return;
                }
                in r = r(shareEntity);
                if (r != null && r.p() != null) {
                    if (this.e.getShareType() == 2) {
                        g0(this.e, r.p());
                        return;
                    } else {
                        i0(this.e, r.p());
                        return;
                    }
                } else if (q(shareEntity.getLocalFile())) {
                    q0(shareEntity.getLocalFile());
                    return;
                } else {
                    String imgUrl = shareEntity.getImgUrl();
                    if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        if (this.e.getShareType() != 0) {
                            tg.h().k(imgUrl, 34, this.o, 0, 0, j(), new Object[0]);
                            return;
                        } else {
                            tg.h().k(imgUrl, 10, this.p, 0, 0, j(), new Object[0]);
                            return;
                        }
                    } else if (p(shareEntity.getImageUri())) {
                        q0(shareEntity.getImageUri().getPath());
                        return;
                    } else {
                        p0();
                        return;
                    }
                }
            }
            u(2, this.k);
            if (yj8Var != null) {
                yj8Var.b1(0, 2);
            }
        }
    }

    public String b0(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, context, file)) == null) {
            if (file != null && file.exists()) {
                Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                context.grantUriPermission("com.tencent.mm", uriForFile, 1);
                return uriForFile.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean c0(WXImageObject wXImageObject, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, wXImageObject, bitmap)) == null) {
            Context context = this.b;
            if (context != null && wXImageObject != null && bitmap != null && Y(context) && X()) {
                try {
                    e0(wXImageObject, FileHelper.saveFileAsPNG(rj8.h, rj8.j, bitmap, 100), bitmap);
                    return true;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e0(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, wXImageObject, str, bitmap) == null) {
            wXImageObject.setImagePath(b0(this.b, new File(str)));
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = T(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("imageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
        }
    }

    public final boolean h0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, shareEntity, emotionShare)) == null) {
            if (this.k != 2 && this.e.getShareType() != 1) {
                return f0(shareEntity, emotionShare);
            }
            return j0(shareEntity, emotionShare);
        }
        return invokeLL.booleanValue;
    }

    public final void o0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, shareEntity, bitmap) == null) {
            if (shareEntity.getIsVideoThread()) {
                b bVar = new b(this);
                bVar.setPriority(3);
                bVar.execute(bitmap);
                return;
            }
            n0(this.e, bitmap);
        }
    }

    public final boolean j0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        in inVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, shareEntity, emotionShare)) == null) {
            if (shareEntity == null || this.m == null || emotionShare == null || StringUtils.isNull(emotionShare.path) || (inVar = emotionShare.image) == null || inVar.p() == null) {
                return false;
            }
            WXImageObject wXImageObject = new WXImageObject();
            wXImageObject.setImagePath(emotionShare.path);
            if (c0(wXImageObject, emotionShare.image.p())) {
                return false;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = T(emotionShare.image.p());
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("imageShare");
            req.message = wXMediaMessage;
            req.scene = V();
            this.m.sendReq(req);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void k0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
            wXMiniProgramObject.webpageUrl = shareEntity.getLinkUrl();
            wXMiniProgramObject.miniprogramType = 0;
            wXMiniProgramObject.userName = "gh_213e5678c5bf";
            if (shareEntity.getTypeShareToSmallApp() != 2 && shareEntity.getTypeShareToSmallApp() != 4) {
                String tid = shareEntity.getTid();
                wXMiniProgramObject.path = "/pages/pb/pb?tid=" + tid;
            } else {
                String str = shareEntity.getfName();
                if (xi.isEmpty(str)) {
                    str = "";
                }
                String encode = URLEncoder.encode(str);
                wXMiniProgramObject.path = "/pages/frs/frs?kw=" + encode;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
            String title = shareEntity.getTitle();
            if (StringUtils.isNull(title)) {
                title = shareEntity.getContent();
            }
            wXMediaMessage.title = title;
            wXMediaMessage.description = shareEntity.getContent();
            if ("https://tb5.bdstatic.com/yunying/tieba_logo.jpg".equals(shareEntity.getImgUrl())) {
                wXMediaMessage.thumbData = t0(bitmap, true);
            } else {
                wXMediaMessage.thumbData = t0(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = W("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.m.sendReq(req);
        }
    }

    public byte[] t0(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048605, this, bitmap, z)) == null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!z && bitmap != null) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    double length = byteArray.length / 1024;
                    if (length <= 125.0d) {
                        return byteArray;
                    }
                    while (length > 125.0d) {
                        Double valueOf = Double.valueOf(length / 125.0d);
                        Double valueOf2 = Double.valueOf(width / Math.sqrt(valueOf.doubleValue()));
                        Double valueOf3 = Double.valueOf(height / Math.sqrt(valueOf.doubleValue()));
                        width = valueOf2.intValue();
                        height = valueOf3.intValue();
                        bitmap = l(bitmap, width, height);
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                        byteArray = byteArrayOutputStream2.toByteArray();
                        length = byteArray.length / 1024;
                    }
                    byteArrayOutputStream.close();
                    if (bitmap == null) {
                        return Z();
                    }
                    return byteArray;
                }
                return Z();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }
}
