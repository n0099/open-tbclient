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
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.WeChatShareSmallAppToH5Switch;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
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
/* loaded from: classes7.dex */
public class kja extends fja {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int k;
    public mja l;
    public IWXAPI m;
    public d n;
    public final BdResourceCallback<EmotionShareLoaderProc.EmotionShare> o;
    public final c p;

    /* loaded from: classes7.dex */
    public class a extends BdResourceCallback<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kja a;

        public a(kja kjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kjaVar;
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                this.a.p.onCancelled(str);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null) {
                    kja kjaVar = this.a;
                    if (kjaVar.f0(kjaVar.e, emotionShare)) {
                        return;
                    }
                }
                this.a.p.onLoaded((BdImage) null, str, i);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Bitmap, Void, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kja a;

        public b(kja kjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kjaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bitmapArr)) == null) {
                if (bitmapArr.length > 0 && bitmapArr[0] != null) {
                    kja kjaVar = this.a;
                    return kjaVar.u(bitmapArr[0], kjaVar.e, false);
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
                kja kjaVar = this.a;
                kjaVar.l0(kjaVar.e, bitmap);
            }
        }
    }

    /* loaded from: classes7.dex */
    public final class c extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kja a;

        public c(kja kjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kjaVar;
        }

        public /* synthetic */ c(kja kjaVar, a aVar) {
            this(kjaVar);
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                super.onCancelled(str);
                if (this.a.l != null) {
                    this.a.l.j0(this.a.k, 3);
                }
                kja kjaVar = this.a;
                kjaVar.t(3, kjaVar.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdImage, str, i) == null) {
                super.onLoaded((c) bdImage, str, i);
                if (bdImage == null) {
                    this.a.n0();
                    return;
                }
                Bitmap rawBitmap = bdImage.getRawBitmap();
                if (!TextUtils.isEmpty(this.a.e.getLinkUrl())) {
                    if (this.a.k == 2) {
                        kja kjaVar = this.a;
                        kjaVar.m0(kjaVar.e, rawBitmap);
                        return;
                    }
                    String tid = this.a.e.getTid();
                    int typeShareToSmallApp = this.a.e.getTypeShareToSmallApp();
                    if ((typeShareToSmallApp == 2 || typeShareToSmallApp == 4 || (!StringUtils.isNull(tid) && !tid.equals("0"))) && this.a.e.canShareBySmartApp && !WeChatShareSmallAppToH5Switch.isOn()) {
                        kja kjaVar2 = this.a;
                        kjaVar2.i0(kjaVar2.e, rawBitmap);
                        return;
                    }
                    kja kjaVar3 = this.a;
                    kjaVar3.m0(kjaVar3.e, rawBitmap);
                } else if (!TextUtils.isEmpty(this.a.e.getVideoUrl())) {
                    kja kjaVar4 = this.a;
                    kjaVar4.k0(kjaVar4.e, rawBitmap);
                } else if (!TextUtils.isEmpty(this.a.e.getContent())) {
                    this.a.n0();
                } else {
                    kja kjaVar5 = this.a;
                    kjaVar5.g0(kjaVar5.e, rawBitmap);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kja this$0;

        public d(kja kjaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kjaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = kjaVar;
        }

        public /* synthetic */ d(kja kjaVar, a aVar) {
            this(kjaVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (this.this$0.l != null) {
                        this.this$0.l.j0(this.this$0.k, 1);
                    }
                    kja kjaVar = this.this$0;
                    kjaVar.t(1, kjaVar.k);
                } else if (intExtra == -2) {
                    if (this.this$0.l != null) {
                        this.this$0.l.j0(this.this$0.k, 3);
                    }
                    kja kjaVar2 = this.this$0;
                    kjaVar2.t(3, kjaVar2.k);
                } else {
                    this.this$0.q0(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (this.this$0.l != null) {
                        this.this$0.l.j0(this.this$0.k, 2);
                    }
                    kja kjaVar3 = this.this$0;
                    kjaVar3.t(2, kjaVar3.k);
                }
                this.this$0.Y();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kja(Context context, int i) {
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

    public final boolean d0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, shareEntity, emotionShare)) == null) {
            if (shareEntity != null && this.m != null && emotionShare != null && emotionShare.image != null && !StringUtils.isNull(emotionShare.path)) {
                WXEmojiObject wXEmojiObject = new WXEmojiObject();
                wXEmojiObject.emojiPath = emotionShare.path;
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXEmojiObject;
                wXMediaMessage.thumbData = R(emotionShare.image.getRawBitmap());
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = U("imageShare");
                req.message = wXMediaMessage;
                req.scene = T();
                this.m.sendReq(req);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void e0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null && bitmap != null) {
            WXEmojiObject wXEmojiObject = new WXEmojiObject();
            wXEmojiObject.emojiData = S(bitmap, 512, false);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXEmojiObject;
            wXMediaMessage.thumbData = R(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = U("imageShare");
            req.message = wXMediaMessage;
            req.scene = T();
            this.m.sendReq(req);
        }
    }

    public final void g0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null && bitmap != null) {
            WXImageObject wXImageObject = new WXImageObject(bitmap);
            if (a0(wXImageObject, bitmap)) {
                return;
            }
            wXImageObject.imageData = kd.d().a(bitmap, 85);
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = R(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = U("imageShare");
            req.message = wXMediaMessage;
            req.scene = T();
            this.m.sendReq(req);
        }
    }

    public final void k0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXVideoObject wXVideoObject = new WXVideoObject();
            wXVideoObject.videoUrl = shareEntity.getVideoUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = R(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = U("videoShare");
            req.message = wXMediaMessage;
            req.scene = T();
            this.m.sendReq(req);
        }
    }

    public final void l0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, shareEntity, bitmap) == null) && shareEntity != null && this.m != null) {
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            wXWebpageObject.webpageUrl = shareEntity.getLinkUrl();
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = shareEntity.getTitle();
            wXMediaMessage.description = shareEntity.getContent();
            wXMediaMessage.thumbData = R(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = U("webpageShare");
            req.message = wXMediaMessage;
            req.scene = T();
            this.m.sendReq(req);
        }
    }

    public final void q0(int i, String str) {
        ShareEntity shareEntity;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048602, this, i, str) == null) && (shareEntity = this.e) != null && !StringUtils.isNull(shareEntity.getImgUrl())) {
            Logger.addLog(Logger.SOSCAIL_SHARE, -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.e.getImgUrl());
        }
    }

    public final String U(String str) {
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

    public boolean W(Context context) {
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

    public final void o0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            Bitmap i = i(str);
            if (i == null) {
                i = e();
            }
            if (i != null) {
                g0(this.e, i);
            } else {
                j0(this.e);
            }
        }
    }

    @Override // com.baidu.tieba.fja
    public void s(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdUniqueId) == null) {
            super.s(bdUniqueId);
            b0();
        }
    }

    public byte[] R(Bitmap bitmap) {
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

    public final void j0(ShareEntity shareEntity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, shareEntity) == null) && shareEntity != null && this.m != null) {
            String content = shareEntity.getContent();
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = content;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXTextObject;
            wXMediaMessage.description = content;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = U("textShare");
            req.message = wXMediaMessage;
            req.scene = T();
            this.m.sendReq(req);
        }
    }

    public byte[] S(Bitmap bitmap, int i, boolean z) {
        InterceptResult invokeCommon;
        Bitmap k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{bitmap, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            try {
                if (z) {
                    k = f(R.drawable.obfuscated_res_0x7f080fe7);
                } else {
                    k = k(bitmap, i);
                }
                if (k == null) {
                    k = f(R.drawable.obfuscated_res_0x7f080fe7);
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

    public final int T() {
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

    public boolean V() {
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

    public final void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            FileHelper.deleteFile(new File(fja.h + fja.j));
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.b != null) {
            this.n = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.b.registerReceiver(this.n, intentFilter);
        }
    }

    public final void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            Bitmap e = e();
            if (e != null) {
                g0(this.e, e);
            } else {
                j0(this.e);
            }
        }
    }

    public final void p0() {
        Context context;
        d dVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (context = this.b) != null && (dVar = this.n) != null) {
            context.unregisterReceiver(dVar);
        }
    }

    @Override // com.baidu.tieba.fja
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            p0();
            super.r();
        }
    }

    public byte[] X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                Bitmap f = f(R.drawable.obfuscated_res_0x7f080fe7);
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

    public String Z(Context context, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, file)) == null) {
            if (file != null && file.exists()) {
                Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
                context.grantUriPermission("com.tencent.mm", uriForFile, 1);
                return uriForFile.toString();
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public final boolean a0(WXImageObject wXImageObject, Bitmap bitmap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, wXImageObject, bitmap)) == null) {
            Context context = this.b;
            if (context != null && wXImageObject != null && bitmap != null && W(context) && V()) {
                try {
                    c0(wXImageObject, FileHelper.saveFileAsPNG(fja.h, fja.j, bitmap, 100), bitmap);
                    return true;
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.lja
    public void a(ShareEntity shareEntity, mja mjaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, shareEntity, mjaVar) == null) {
            if (shareEntity != null && this.m != null) {
                this.e = shareEntity;
                this.l = mjaVar;
                this.k = shareEntity.getShareTo();
                if (!this.m.isWXAppInstalled()) {
                    mja mjaVar2 = this.l;
                    if (mjaVar2 != null) {
                        mjaVar2.j0(this.k, 2);
                    }
                    if (Fresco.hasBeenInitialized()) {
                        BdToast.makeText(d(), d().getText(R.string.obfuscated_res_0x7f0f1414)).show();
                        return;
                    }
                    return;
                }
                BdImage q = q(shareEntity);
                if (q != null && q.getRawBitmap() != null) {
                    if (this.e.getShareType() == 2) {
                        e0(this.e, q.getRawBitmap());
                        return;
                    } else {
                        g0(this.e, q.getRawBitmap());
                        return;
                    }
                } else if (p(shareEntity.getLocalFile())) {
                    o0(shareEntity.getLocalFile());
                    return;
                } else {
                    String imgUrl = shareEntity.getImgUrl();
                    if (!TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        if (this.e.getShareType() != 0) {
                            BdResourceLoader.getInstance().loadResource(imgUrl, 34, this.o, 0, 0, j(), new Object[0]);
                            return;
                        } else {
                            BdResourceLoader.getInstance().loadResource(imgUrl, 10, this.p, 0, 0, j(), new Object[0]);
                            return;
                        }
                    } else if (o(shareEntity.getImageUri())) {
                        o0(shareEntity.getImageUri().getPath());
                        return;
                    } else {
                        n0();
                        return;
                    }
                }
            }
            t(2, this.k);
            if (mjaVar != null) {
                mjaVar.j0(0, 2);
            }
        }
    }

    public final void c0(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, wXImageObject, str, bitmap) == null) {
            wXImageObject.setImagePath(Z(this.b, new File(str)));
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.mediaObject = wXImageObject;
            wXMediaMessage.thumbData = R(bitmap);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = U("imageShare");
            req.message = wXMediaMessage;
            req.scene = T();
            this.m.sendReq(req);
        }
    }

    public final boolean f0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, shareEntity, emotionShare)) == null) {
            if (this.k != 2 && this.e.getShareType() != 1) {
                return d0(shareEntity, emotionShare);
            }
            return h0(shareEntity, emotionShare);
        }
        return invokeLL.booleanValue;
    }

    public final void m0(ShareEntity shareEntity, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, shareEntity, bitmap) == null) {
            if (shareEntity.getIsVideoThread()) {
                b bVar = new b(this);
                bVar.setPriority(3);
                bVar.execute(bitmap);
                return;
            }
            l0(this.e, bitmap);
        }
    }

    public final boolean h0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        InterceptResult invokeLL;
        BdImage bdImage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, shareEntity, emotionShare)) == null) {
            if (shareEntity != null && this.m != null && emotionShare != null && !StringUtils.isNull(emotionShare.path) && (bdImage = emotionShare.image) != null && bdImage.getRawBitmap() != null) {
                WXImageObject wXImageObject = new WXImageObject();
                wXImageObject.setImagePath(emotionShare.path);
                if (a0(wXImageObject, emotionShare.image.getRawBitmap())) {
                    return true;
                }
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                wXMediaMessage.mediaObject = wXImageObject;
                wXMediaMessage.thumbData = R(emotionShare.image.getRawBitmap());
                SendMessageToWX.Req req = new SendMessageToWX.Req();
                req.transaction = U("imageShare");
                req.message = wXMediaMessage;
                req.scene = T();
                this.m.sendReq(req);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void i0(ShareEntity shareEntity, Bitmap bitmap) {
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
                if (qd.isEmpty(str)) {
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
                wXMediaMessage.thumbData = r0(bitmap, true);
            } else {
                wXMediaMessage.thumbData = r0(bitmap, false);
            }
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = U("miniProgram");
            req.message = wXMediaMessage;
            req.scene = 0;
            this.m.sendReq(req);
        }
    }

    public byte[] r0(Bitmap bitmap, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048604, this, bitmap, z)) == null) {
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
                        return X();
                    }
                    return byteArray;
                }
                return X();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (byte[]) invokeLZ.objValue;
    }
}
