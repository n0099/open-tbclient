package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.de0;
import com.baidu.tieba.df0;
import com.baidu.tieba.te0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes6.dex */
public class re0 {
    public static /* synthetic */ Interceptable $ic;
    public static re0 b;
    public static ze0 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    /* loaded from: classes6.dex */
    public class a extends te0.c<le0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de0.a a;

        public a(re0 re0Var, de0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re0Var, aVar};
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
        @Override // com.baidu.tieba.te0.c
        /* renamed from: e */
        public void a(le0 le0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, le0Var, str) == null) {
                if (de0.m()) {
                    re0.c("loadSDK onCompleted filePath: " + str);
                }
                super.a(le0Var, str);
                de0.a aVar = this.a;
                if (aVar != null) {
                    aVar.onResult(true, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.te0.c
        /* renamed from: f */
        public void b(le0 le0Var, Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, le0Var, exc) == null) {
                if (de0.m()) {
                    re0.c("loadSDK onFailed failed: " + exc);
                }
                super.b(le0Var, exc);
                de0.a aVar = this.a;
                if (aVar != null) {
                    if (exc == null) {
                        message = "unkown";
                    } else {
                        message = exc.getMessage();
                    }
                    aVar.onResult(false, message);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.te0.c
        /* renamed from: g */
        public void c(le0 le0Var, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{le0Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(le0Var, j, j2, i);
                de0.a aVar = this.a;
                if (aVar != null) {
                    aVar.onProgress((int) j2, i);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements df0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ de0.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;

        public b(re0 re0Var, de0.a aVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {re0Var, aVar, str, file};
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
        @Override // com.baidu.tieba.df0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i, df0 df0Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, df0Var) == null) {
                boolean z2 = false;
                if (i == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (de0.m()) {
                    re0.c("onLoadAssets " + z + ", state " + i);
                }
                if (this.a != null) {
                    String str = null;
                    if (!z) {
                        str = this.b;
                    }
                    if (this.c != null) {
                        de0.s(new ee0(this.c.getAbsolutePath()));
                    }
                    if (z) {
                        boolean k0 = ce0.k0();
                        if (de0.m()) {
                            re0.c("loadAssets ARControllerProxy.loadSoFile " + k0);
                        }
                    }
                    z2 = z;
                    this.a.onResult(z2, str);
                }
            }
        }
    }

    public re0() {
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
            synchronized (re0.class) {
                if (b == null) {
                    b = new re0();
                }
            }
        }
    }

    public static re0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                b();
            }
            return b;
        }
        return (re0) invokeV.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            Log.e("DuAr_SDKLoader", "ar->" + str);
        }
    }

    public final ze0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c == null) {
                ze0 k = ze0.k();
                de0.g();
                k.m(de0.getContext(), "arsource", new File(ee0.a()));
                c = k;
            }
            return c;
        }
        return (ze0) invokeV.objValue;
    }

    public File f() {
        InterceptResult invokeV;
        boolean z;
        File l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (de0.o() && g()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                l = oe0.d().h();
            } else {
                l = le0.j(de0.e()).l();
            }
            if (de0.m()) {
                c("sdkPath useLocal " + z + ", SDKPath " + l);
            }
            return l;
        }
        return (File) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        boolean z;
        boolean q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (de0.o() && g()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                q = d().o();
            } else {
                q = le0.j("live").q();
            }
            if (de0.m()) {
                c("isLocal " + z + ", isSDKLoaded " + q);
            }
            return q;
        }
        return invokeV.booleanValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.a == null) {
                this.a = Boolean.FALSE;
                try {
                    String[] list = de0.getContext().getAssets().list("arsource");
                    if (list != null && list.length > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.a = Boolean.valueOf(z);
                    if (de0.m()) {
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

    public void i(Context context, String str, File file, de0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, file, aVar) == null) {
            String str2 = "loadAssets context=" + context + ", assetPath=" + str + ", SDcardFile=" + file;
            if (de0.m()) {
                c(str2);
            }
            if ((context == null || TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(file.getAbsolutePath())) && aVar != null) {
                aVar.onResult(false, str2);
            }
            d().r(context, str, file, new b(this, aVar, str2, file));
        }
    }

    public void j(de0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (de0.m()) {
                c("loadAssets hasAssetsResource=" + g());
            }
            if (de0.g() == null) {
                c("DuArResConfig null when loadAssets");
            } else if (TextUtils.isEmpty(ee0.a())) {
                c("DuArResConfig data empty when loadAssets");
            } else {
                i(de0.getContext(), "arsource", new File(ee0.a()), aVar);
            }
        }
    }

    public void k(de0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (de0.o() && g()) {
                j(aVar);
            } else if (de0.c() == null) {
                c("loadSDK with Downlader==null");
            } else {
                le0.j(de0.e()).u(de0.getContext(), new a(this, aVar));
            }
        }
    }
}
