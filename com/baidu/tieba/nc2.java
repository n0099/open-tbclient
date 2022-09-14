package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.xf4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* loaded from: classes5.dex */
public final class nc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String b;
    public static final Map<String, pc2> c;
    public static final nc2 d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements xf4.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Function1 c;

        public a(String str, Ref.ObjectRef objectRef, Function1 function1) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, objectRef, function1};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = objectRef;
            this.c = function1;
        }

        @Override // com.baidu.tieba.xf4.a
        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                nc2 nc2Var = nc2.d;
                if (nc2.a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.a);
                }
                if (z) {
                    nc2.d.A(this.a, ((ac4) this.b.element).i);
                    nc2 nc2Var2 = nc2.d;
                    String str = this.a;
                    String str2 = ((ac4) this.b.element).j;
                    Intrinsics.checkNotNullExpressionValue(str2, "soPkg.versionName");
                    nc2Var2.B(str, str2);
                    nc2 nc2Var3 = nc2.d;
                    String str3 = this.a;
                    AbiType abiType = ((ac4) this.b.element).q;
                    Intrinsics.checkNotNullExpressionValue(abiType, "soPkg.abi");
                    nc2Var3.y(str3, abiType);
                    nc2.d.z(this.a, true);
                    this.c.invoke(null);
                    return;
                }
                nc2.d.z(this.a, false);
                this.c.invoke(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class b<MsgType> implements rh3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-580085682, "Lcom/baidu/tieba/nc2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-580085682, "Lcom/baidu/tieba/nc2$b;");
                    return;
                }
            }
            a = new b();
        }

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public final void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                nc2 nc2Var = nc2.d;
                if (nc2.a) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("main updatePmsPkg pmsUpdateSo end with e: ");
                    sb.append(exc);
                    sb.append(" trace=");
                    if (exc == null) {
                        exc = new Exception();
                    }
                    sb.append(Log.getStackTraceString(exc));
                    Log.i("SoLibManager", sb.toString());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947997580, "Lcom/baidu/tieba/nc2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947997580, "Lcom/baidu/tieba/nc2;");
                return;
            }
        }
        d = new nc2();
        a = ij1.a;
        b = "swan" + File.separator + "libs" + File.separator + "so";
        c = new LinkedHashMap();
    }

    public nc2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void A(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            mb3.a().putLong(o(str), j);
        }
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            mb3.a().putString(p(str), str2);
        }
    }

    public final void C(oc2 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (a) {
                Log.i("SoLibManager", "main updatePmsPkg start args: " + config);
            }
            config.e(b.a);
            qc2 qc2Var = new qc2(new fe4(5), config);
            if (a) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + qc2Var);
            }
            ia4.o(qc2Var);
        }
    }

    public final void f(String libName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, libName) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            c.remove(libName);
        }
    }

    public final String g(ac4 ac4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ac4Var)) == null) {
            if ((ac4Var != null ? ac4Var.q : null) == null) {
                return "";
            }
            String str = ac4Var.p;
            Intrinsics.checkNotNullExpressionValue(str, "so.libName");
            AbiType abiType = ac4Var.q;
            Intrinsics.checkNotNullExpressionValue(abiType, "so.abi");
            return h(str, abiType, ac4Var.i);
        }
        return (String) invokeL.objValue;
    }

    public final String h(String libName, AbiType abi, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{libName, abi, Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(abi, "abi");
            if (TextUtils.isEmpty(libName) || j < 1) {
                return "";
            }
            File i = i();
            File file = new File(i, libName + File.separator + j + File.separator + abi.id);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return (String) invokeCommon.objValue;
    }

    public final File i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "AppRuntime.getAppContext()");
            return new File(appContext.getFilesDir(), b);
        }
        return (File) invokeV.objValue;
    }

    public final pc2 j(String libName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, libName)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            return c.get(libName);
        }
        return (pc2) invokeL.objValue;
    }

    public final boolean k(String libName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, libName)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            return l(libName, s(libName));
        }
        return invokeL.booleanValue;
    }

    public final boolean l(String libName, long j) {
        InterceptResult invokeLJ;
        AbiType q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, libName, j)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            lc2 a2 = mc2.a(libName);
            if (a2 != null) {
                if (a2.f()) {
                    return true;
                }
                long s = s(libName);
                if (s > 0 && j <= s && (q = q(libName)) != null) {
                    return AbiType.currentAbi().compat(q);
                }
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public final String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            return "swan_so_installed_abi_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final String n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            return "swan_so_installed_result_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return "swan_so_installed_version_code_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            return "swan_so_installed_version_name_" + str;
        }
        return (String) invokeL.objValue;
    }

    public final AbiType q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? AbiType.findById(mb3.a().getString(m(str), "")) : (AbiType) invokeL.objValue;
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) ? mb3.a().getBoolean(n(str), true) : invokeL.booleanValue;
    }

    public final long s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) ? mb3.a().getLong(o(str), 0L) : invokeL.longValue;
    }

    public final pc2 t(qc2 updater, String libName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, updater, libName)) == null) {
            Intrinsics.checkNotNullParameter(updater, "updater");
            Intrinsics.checkNotNullParameter(libName, "libName");
            pc2 j = j(libName);
            if (j == null) {
                pc2 pc2Var = new pc2(updater, libName);
                c.put(libName, pc2Var);
                return pc2Var;
            }
            return j;
        }
        return (pc2) invokeLL.objValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            z(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, true);
        }
    }

    public final void v(String libName, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, libName, j) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            SharedPreferences.Editor edit = hg4.a().edit();
            edit.putLong("swan_so_latest_update_time_" + libName, j).apply();
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? !r(ZeusWebViewPreloadClass.ZEUS_FILE_DIR) : invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.baidu.tieba.ac4] */
    public final void x(String libName, Function1<? super re3, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, libName, callback) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + libName);
            }
            lc2 a2 = mc2.a(libName);
            if (a2 == null) {
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + libName);
                }
                re3 re3Var = new re3();
                re3Var.k(16);
                re3Var.b(2900);
                re3Var.f("not available: so=" + a2);
                callback.invoke(re3Var);
            } else if (a2.f()) {
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + a2);
                }
                callback.invoke(null);
            } else {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? t = va4.i().t(libName);
                objectRef.element = t;
                if (((ac4) t) != null && ((ac4) t).a() && AbiType.currentAbi().compat(((ac4) objectRef.element).q)) {
                    AbiType q = q(libName);
                    if (l(libName, ((ac4) objectRef.element).i) && q != null && q.compat(((ac4) objectRef.element).q)) {
                        if (a) {
                            Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + libName + " soPkg=" + ((ac4) objectRef.element));
                        }
                        callback.invoke(null);
                        return;
                    }
                    a2.a(((ac4) objectRef.element).a, new a(libName, objectRef, callback));
                    return;
                }
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + libName + " soPkg=" + ((ac4) objectRef.element));
                }
                re3 re3Var2 = new re3();
                re3Var2.k(16);
                re3Var2.b(2900);
                re3Var2.f("invalid: pkg=" + ((ac4) objectRef.element));
                callback.invoke(re3Var2);
            }
        }
    }

    public final void y(String str, AbiType abiType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, abiType) == null) {
            mb3.a().putString(m(str), abiType.id);
        }
    }

    public final void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, str, z) == null) {
            mb3.a().putBoolean(n(str), z);
        }
    }
}
