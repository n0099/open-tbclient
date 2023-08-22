package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tbadk.switchs.QqShareH5Switch;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class l7a extends k7a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Tencent k;
    public int l;
    public IUiListener m;
    public final BdResourceCallback<EmotionShareLoaderProc.EmotionShare> n;
    public BdResourceCallback<BdImage> o;

    /* loaded from: classes6.dex */
    public class b extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l7a a;

        /* loaded from: classes6.dex */
        public class a extends BdAsyncTask<BdImage, Void, Bitmap> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Bitmap doInBackground(BdImage... bdImageArr) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bdImageArr)) == null) {
                    if (bdImageArr.length > 0 && bdImageArr[0] != null) {
                        Bitmap rawBitmap = bdImageArr[0].getRawBitmap();
                        l7a l7aVar = this.a.a;
                        return l7aVar.u(rawBitmap, l7aVar.e, true);
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
                    super.onPostExecute((a) bitmap);
                    l7a l7aVar = this.a.a;
                    l7aVar.I(l7aVar.e, l7aVar.m);
                }
            }
        }

        public b(l7a l7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l7aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                super.onLoaded((b) bdImage, str, i);
                if (bdImage != null) {
                    a aVar = new a(this);
                    aVar.setPriority(3);
                    aVar.execute(bdImage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends BdResourceCallback<EmotionShareLoaderProc.EmotionShare> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l7a a;

        public a(l7a l7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l7aVar;
        }

        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onCancelled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                super.onCancelled(str);
                l7a l7aVar = this.a;
                l7aVar.t(3, l7aVar.l);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, emotionShare, str, i) == null) {
                super.onLoaded(emotionShare, str, i);
                if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                    l7a l7aVar = this.a;
                    l7aVar.J(emotionShare.path, l7aVar.m);
                    return;
                }
                l7a l7aVar2 = this.a;
                l7aVar2.t(2, l7aVar2.l);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements IUiListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public r7a a;
        public final /* synthetic */ l7a b;

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            }
        }

        public c(l7a l7aVar, r7a r7aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l7aVar, r7aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = l7aVar;
            this.a = r7aVar;
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                FileHelper.deleteFile(new File(k7a.h + k7a.i));
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                r7a r7aVar = this.a;
                if (r7aVar != null) {
                    r7aVar.X0(this.b.l, 3);
                }
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                r7a r7aVar = this.a;
                if (r7aVar != null) {
                    r7aVar.X0(this.b.l, 1);
                }
                l7a l7aVar = this.b;
                l7aVar.t(1, l7aVar.l);
                a();
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, uiError) == null) {
                r7a r7aVar = this.a;
                if (r7aVar != null) {
                    r7aVar.X0(this.b.l, 2);
                }
                if (uiError != null) {
                    str = uiError.errorMessage;
                } else {
                    str = null;
                }
                l7a l7aVar = this.b;
                l7aVar.D(2, str, l7aVar.l);
                a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l7a(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.l = 8;
        this.n = new a(this);
        this.o = new b(this);
        this.k = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void H(ShareEntity shareEntity, r7a r7aVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, shareEntity, r7aVar) != null) || shareEntity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Iterator<ResolveInfo> it = this.b.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                if (TextUtils.equals("com.tencent.mobileqq", next.activityInfo.packageName)) {
                    str = next.activityInfo.name;
                    break;
                }
            } else {
                str = "";
                break;
            }
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.SUBJECT", shareEntity.getTitle());
        intent2.putExtra("android.intent.extra.TEXT", shareEntity.getContent());
        intent2.setClassName("com.tencent.mobileqq", str);
        intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
        if (t7a.startActivity(this.b, intent2)) {
            if (r7aVar != null) {
                r7aVar.X0(this.l, 1);
                return;
            }
            return;
        }
        if (r7aVar != null) {
            r7aVar.X0(this.l, 2);
        }
        t(2, this.l);
    }

    public final void I(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareEntity, iUiListener) == null) && shareEntity != null && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("title", shareEntity.getTitle());
            if (shareEntity.getReadCount() >= 0) {
                if (shareEntity.getReadCount() < 10000) {
                    bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f13ac));
                } else {
                    bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.getReadCount()) + this.b.getString(R.string.obfuscated_res_0x7f0f13ab));
                }
            } else {
                bundle.putString("summary", shareEntity.getContent());
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            bundle.putInt("req_type", 1);
            if (shareEntity.getIsVideoThread() && !StringUtils.isNull(shareEntity.getImgUrl()) && !shareEntity.getImgUrl().startsWith("http")) {
                bundle.putString("imageLocalUrl", shareEntity.getImgUrl());
            } else {
                bundle.putString("imageUrl", shareEntity.getImgUrl());
            }
            this.k.shareToQQ((Activity) this.b, bundle, iUiListener);
        }
    }

    public final void K(ShareEntity shareEntity, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, shareEntity, iUiListener) == null) && shareEntity != null && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("title", t7a.a(this.b));
            if (!StringUtils.isNull(shareEntity.getTitle())) {
                bundle.putString("summary", shareEntity.getTitle());
            } else if (!StringUtils.isNull(shareEntity.getContent())) {
                bundle.putString("summary", shareEntity.getContent());
            } else {
                bundle.putString("summary", this.b.getString(R.string.obfuscated_res_0x7f0f13ac));
            }
            bundle.putString("targetUrl", shareEntity.getLinkUrl());
            if (!StringUtils.isNull(shareEntity.getImgUrl())) {
                bundle.putString("imageUrl", shareEntity.getImgUrl());
            } else {
                bundle.putString("imageUrl", "http://tb3.bdstatic.com/public/img/fcf10e29473417fa5e0d4a1e6.fcf10e29.png");
            }
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID, "1111264064");
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE, "3");
            bundle.putString(QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH, "pages/pb/pb?tid=" + shareEntity.getTid());
            bundle.putInt("req_type", 7);
            this.k.shareToQQ((Activity) this.b, bundle, iUiListener);
        }
    }

    public final void J(String str, IUiListener iUiListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, iUiListener) == null) && !TextUtils.isEmpty(str) && iUiListener != null) {
            Bundle bundle = new Bundle();
            bundle.putString("imageLocalUrl", str);
            bundle.putInt("req_type", 5);
            bundle.putInt("cflag", 2);
            this.k.shareToQQ((Activity) this.b, bundle, iUiListener);
        }
    }

    @Override // com.baidu.tieba.q7a
    public void a(ShareEntity shareEntity, r7a r7aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, shareEntity, r7aVar) == null) {
            if (shareEntity != null && this.k != null) {
                this.e = shareEntity;
                Context context = this.b;
                if (context != null && (context instanceof Activity)) {
                    this.m = new c(this, r7aVar);
                    if (!QqShareH5Switch.isOn() && !StringUtils.isNull(shareEntity.getTid()) && !"0".equals(shareEntity.getTid())) {
                        K(shareEntity, this.m);
                        return;
                    }
                    String imgUrl = shareEntity.getImgUrl();
                    if (p(shareEntity.getLocalFile())) {
                        J(shareEntity.getLocalFile(), this.m);
                        return;
                    } else if (shareEntity.getShareType() != 0 && !TextUtils.isEmpty(imgUrl) && (imgUrl.startsWith("http://") || imgUrl.startsWith("https://"))) {
                        BdResourceLoader.getInstance().loadResource(imgUrl, 34, this.n, 0, 0, j(), new Object[0]);
                        return;
                    } else if (!TextUtils.isEmpty(shareEntity.getLinkUrl()) && !TextUtils.isEmpty(shareEntity.getTitle())) {
                        if (this.e.getIsVideoThread()) {
                            BdResourceLoader.getInstance().loadResource(shareEntity.getImgUrl(), 10, this.o, 0, 0, j(), new Object[0]);
                            return;
                        } else {
                            I(shareEntity, this.m);
                            return;
                        }
                    } else if (o(shareEntity.getImageUri())) {
                        J(shareEntity.getImageUri().getPath(), this.m);
                        return;
                    } else {
                        H(shareEntity, r7aVar);
                        return;
                    }
                }
                t(2, this.l);
                if (r7aVar != null) {
                    r7aVar.X0(0, 2);
                    return;
                }
                return;
            }
            t(2, this.l);
            if (r7aVar != null) {
                r7aVar.X0(0, 2);
            }
        }
    }
}
