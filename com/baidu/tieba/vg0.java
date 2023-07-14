package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.baidu.tieba.hg0;
import com.baidu.tieba.hh0;
import com.baidu.tieba.xg0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes8.dex */
public class vg0 {
    public static /* synthetic */ Interceptable $ic;
    public static vg0 b;
    public static dh0 c;
    public transient /* synthetic */ FieldHolder $fh;
    public Boolean a;

    /* loaded from: classes8.dex */
    public class a extends xg0.c<pg0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg0.a a;

        public a(vg0 vg0Var, hg0.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg0Var, aVar};
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
        @Override // com.baidu.tieba.xg0.c
        /* renamed from: e */
        public void a(pg0 pg0Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, pg0Var, str) == null) {
                if (hg0.m()) {
                    vg0.c("loadSDK onCompleted filePath: " + str);
                }
                super.a(pg0Var, str);
                hg0.a aVar = this.a;
                if (aVar != null) {
                    aVar.onResult(true, str);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg0.c
        /* renamed from: f */
        public void b(pg0 pg0Var, Exception exc) {
            String message;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, pg0Var, exc) == null) {
                if (hg0.m()) {
                    vg0.c("loadSDK onFailed failed: " + exc);
                }
                super.b(pg0Var, exc);
                hg0.a aVar = this.a;
                if (aVar != null) {
                    if (exc == null) {
                        message = ClarityUrlList.UNKNOWN_CLARITY_KEY;
                    } else {
                        message = exc.getMessage();
                    }
                    aVar.onResult(false, message);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xg0.c
        /* renamed from: g */
        public void c(pg0 pg0Var, long j, long j2, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pg0Var, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)}) == null) {
                super.c(pg0Var, j, j2, i);
                hg0.a aVar = this.a;
                if (aVar != null) {
                    aVar.onProgress((int) j2, i);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements hh0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg0.a a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;

        public b(vg0 vg0Var, hg0.a aVar, String str, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vg0Var, aVar, str, file};
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
        @Override // com.baidu.tieba.hh0.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(int i, hh0 hh0Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, hh0Var) == null) {
                boolean z2 = false;
                if (i == 2) {
                    z = true;
                } else {
                    z = false;
                }
                if (hg0.m()) {
                    vg0.c("onLoadAssets " + z + ", state " + i);
                }
                if (this.a != null) {
                    String str = null;
                    if (!z) {
                        str = this.b;
                    }
                    if (this.c != null) {
                        hg0.s(new ig0(this.c.getAbsolutePath()));
                    }
                    if (z) {
                        boolean k0 = gg0.k0();
                        if (hg0.m()) {
                            vg0.c("loadAssets ARControllerProxy.loadSoFile " + k0);
                        }
                    }
                    z2 = z;
                    this.a.onResult(z2, str);
                }
            }
        }
    }

    public vg0() {
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
            synchronized (vg0.class) {
                if (b == null) {
                    b = new vg0();
                }
            }
        }
    }

    public static vg0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                b();
            }
            return b;
        }
        return (vg0) invokeV.objValue;
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            Log.e("DuAr_SDKLoader", "ar->" + str);
        }
    }

    public final dh0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c == null) {
                dh0 k = dh0.k();
                hg0.g();
                k.m(hg0.getContext(), "arsource", new File(ig0.a()));
                c = k;
            }
            return c;
        }
        return (dh0) invokeV.objValue;
    }

    public File f() {
        InterceptResult invokeV;
        boolean z;
        File l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (hg0.o() && g()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                l = sg0.d().h();
            } else {
                l = pg0.j(hg0.e()).l();
            }
            if (hg0.m()) {
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
            if (hg0.o() && g()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                q = d().o();
            } else {
                q = pg0.j("live").q();
            }
            if (hg0.m()) {
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
                    String[] list = hg0.getContext().getAssets().list("arsource");
                    if (list != null && list.length > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.a = Boolean.valueOf(z);
                    if (hg0.m()) {
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

    public void i(Context context, String str, File file, hg0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, context, str, file, aVar) == null) {
            String str2 = "loadAssets context=" + context + ", assetPath=" + str + ", SDcardFile=" + file;
            if (hg0.m()) {
                c(str2);
            }
            if ((context == null || TextUtils.isEmpty(str) || file == null || TextUtils.isEmpty(file.getAbsolutePath())) && aVar != null) {
                aVar.onResult(false, str2);
            }
            d().r(context, str, file, new b(this, aVar, str2, file));
        }
    }

    public void j(hg0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (hg0.m()) {
                c("loadAssets hasAssetsResource=" + g());
            }
            if (hg0.g() == null) {
                c("DuArResConfig null when loadAssets");
            } else if (TextUtils.isEmpty(ig0.a())) {
                c("DuArResConfig data empty when loadAssets");
            } else {
                i(hg0.getContext(), "arsource", new File(ig0.a()), aVar);
            }
        }
    }

    public void k(hg0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (hg0.o() && g()) {
                j(aVar);
            } else if (hg0.c() == null) {
                c("loadSDK with Downlader==null");
            } else {
                pg0.j(hg0.e()).u(hg0.getContext(), new a(this, aVar));
            }
        }
    }
}
