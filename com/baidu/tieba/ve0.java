package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.he0;
import com.baidu.tieba.hf0;
import com.baidu.tieba.xe0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class ve0 {
    public static /* synthetic */ Interceptable $ic;
    public static ve0 b;
    public static df0 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    /* loaded from: classes6.dex */
    public class a extends xe0.c<pe0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he0.a a;

        public a(ve0 ve0Var, he0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve0Var, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xe0.c
        /* renamed from: e */
        public void a(pe0 pe0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, pe0Var, str) == null) {
                if (he0.m()) {
                    ve0.c("loadSDK onCompleted filePath: " + str);
                }
                super.a(pe0Var, str);
                he0.a aVar = this.a;
                if (aVar != null) {
                    aVar.onResult(true, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xe0.c
        /* renamed from: f */
        public void b(pe0 pe0Var, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, pe0Var, exc) == null) {
                if (he0.m()) {
                    ve0.c("loadSDK onFailed failed: " + exc);
                }
                super.b(pe0Var, exc);
                he0.a aVar = this.a;
                if (aVar != null) {
                    aVar.onResult(false, exc == null ? "unkown" : exc.getMessage());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xe0.c
        /* renamed from: g */
        public void c(pe0 pe0Var, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pe0Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(pe0Var, j, j2, i);
                he0.a aVar = this.a;
                if (aVar != null) {
                    aVar.onProgress((int) j2, i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements hf0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he0.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;

        public b(ve0 ve0Var, he0.a aVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ve0Var, aVar, str, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = str;
            this.c = file;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
            if (r1 == false) goto L22;
         */
        @Override // com.baidu.tieba.hf0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i, hf0 hf0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hf0Var) == null) {
                boolean z = false;
                boolean z2 = i == 2;
                if (he0.m()) {
                    ve0.c("onLoadAssets " + z2 + ", state " + i);
                }
                if (this.a != null) {
                    String str = z2 ? null : this.b;
                    if (this.c != null) {
                        he0.s(new ie0(this.c.getAbsolutePath()));
                    }
                    if (z2) {
                        boolean k0 = ge0.k0();
                        if (he0.m()) {
                            ve0.c("loadAssets ARControllerProxy.loadSoFile " + k0);
                        }
                    }
                    z = z2;
                    this.a.onResult(z, str);
                }
            }
        }
    }

    public ve0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (ve0.class) {
                if (b == null) {
                    b = new ve0();
                }
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            Log.e("DuAr_SDKLoader", "ar->" + str);
        }
    }

    public static ve0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                b();
            }
            return b;
        }
        return (ve0) invokeV.objValue;
    }

    public final df0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c == null) {
                df0 k = df0.k();
                he0.g();
                k.m(he0.getContext(), "arsource", new File(ie0.a()));
                c = k;
            }
            return c;
        }
        return (df0) invokeV.objValue;
    }

    public File f() {
        InterceptResult invokeV;
        File l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            boolean z = he0.o() && g();
            if (z) {
                l = se0.d().h();
            } else {
                l = pe0.j(he0.e()).l();
            }
            if (he0.m()) {
                c("sdkPath useLocal " + z + ", SDKPath " + l);
            }
            return l;
        }
        return (File) invokeV.objValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == null) {
                this.a = Boolean.FALSE;
                try {
                    String[] list = he0.getContext().getAssets().list("arsource");
                    this.a = Boolean.valueOf(list != null && list.length > 0);
                    if (he0.m()) {
                        if (list == null) {
                            str = StringUtil.NULL_STRING;
                        } else {
                            str = "" + list.length;
                        }
                        c("hasAssetsResource: " + str);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return this.a.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = he0.o() && g();
            if (z) {
                q = d().o();
            } else {
                q = pe0.j("live").q();
            }
            if (he0.m()) {
                c("isLocal " + z + ", isSDKLoaded " + q);
            }
            return q;
        }
        return invokeV.booleanValue;
    }

    public void i(Context context, String str, File file, he0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, file, aVar) == null) {
            String str2 = "loadAssets context=" + context + ", assetPath=" + str + ", SDcardFile=" + file;
            if (he0.m()) {
                c(str2);
            }
            if ((context == null || TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(file.getAbsolutePath())) && aVar != null) {
                aVar.onResult(false, str2);
            }
            d().r(context, str, file, new b(this, aVar, str2, file));
        }
    }

    public void j(he0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (he0.m()) {
                c("loadAssets hasAssetsResource=" + g());
            }
            if (he0.g() == null) {
                c("DuArResConfig null when loadAssets");
            } else if (TextUtils.isEmpty(ie0.a())) {
                c("DuArResConfig data empty when loadAssets");
            } else {
                i(he0.getContext(), "arsource", new File(ie0.a()), aVar);
            }
        }
    }

    public void k(he0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (he0.o() && g()) {
                j(aVar);
            } else if (he0.c() == null) {
                c("loadSDK with Downlader==null");
            } else {
                pe0.j(he0.e()).u(he0.getContext(), new a(this, aVar));
            }
        }
    }
}
