package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.pms.utils.AbiType;
import com.baidu.tieba.co4;
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
/* loaded from: classes8.dex */
public final class sk2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String b;
    public static final Map<String, uk2> c;
    public static final sk2 d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class a implements co4.a {
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

        @Override // com.baidu.tieba.co4.a
        public final void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (sk2.a(sk2.d)) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by install=" + z + " libname=" + this.a);
                }
                if (z) {
                    sk2.d.A(this.a, ((fk4) this.b.element).i);
                    sk2 sk2Var = sk2.d;
                    String str = this.a;
                    String str2 = ((fk4) this.b.element).j;
                    Intrinsics.checkNotNullExpressionValue(str2, "soPkg.versionName");
                    sk2Var.B(str, str2);
                    sk2 sk2Var2 = sk2.d;
                    String str3 = this.a;
                    AbiType abiType = ((fk4) this.b.element).q;
                    Intrinsics.checkNotNullExpressionValue(abiType, "soPkg.abi");
                    sk2Var2.y(str3, abiType);
                    sk2.d.z(this.a, true);
                    this.c.invoke(null);
                    return;
                }
                sk2.d.z(this.a, false);
                this.c.invoke(null);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948154223, "Lcom/baidu/tieba/sk2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948154223, "Lcom/baidu/tieba/sk2;");
                return;
            }
        }
        d = new sk2();
        a = nr1.a;
        b = "swan" + File.separator + "libs" + File.separator + "so";
        c = new LinkedHashMap();
    }

    /* loaded from: classes8.dex */
    public static final class b<MsgType> implements wp3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-429551759, "Lcom/baidu/tieba/sk2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-429551759, "Lcom/baidu/tieba/sk2$b;");
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public final void a(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) && sk2.a(sk2.d)) {
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

    public sk2() {
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

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            z(ZeusWebViewPreloadClass.ZEUS_FILE_DIR, true);
        }
    }

    public final boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return !r(ZeusWebViewPreloadClass.ZEUS_FILE_DIR);
        }
        return invokeV.booleanValue;
    }

    public static final /* synthetic */ boolean a(sk2 sk2Var) {
        return a;
    }

    public final void f(String libName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, libName) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            c.remove(libName);
        }
    }

    public final uk2 j(String libName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, libName)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            return c.get(libName);
        }
        return (uk2) invokeL.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return AbiType.findById(rj3.a().getString(m(str), ""));
        }
        return (AbiType) invokeL.objValue;
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return rj3.a().getBoolean(n(str), true);
        }
        return invokeL.booleanValue;
    }

    public final long s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            return rj3.a().getLong(o(str), 0L);
        }
        return invokeL.longValue;
    }

    public final void A(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) {
            rj3.a().putLong(o(str), j);
        }
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            rj3.a().putString(p(str), str2);
        }
    }

    public final uk2 t(vk2 updater, String libName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, updater, libName)) == null) {
            Intrinsics.checkNotNullParameter(updater, "updater");
            Intrinsics.checkNotNullParameter(libName, "libName");
            uk2 j = j(libName);
            if (j == null) {
                uk2 uk2Var = new uk2(updater, libName);
                c.put(libName, uk2Var);
                return uk2Var;
            }
            return j;
        }
        return (uk2) invokeLL.objValue;
    }

    public final void y(String str, AbiType abiType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, abiType) == null) {
            rj3.a().putString(m(str), abiType.id);
        }
    }

    public final void z(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, str, z) == null) {
            rj3.a().putBoolean(n(str), z);
        }
    }

    public final void C(tk2 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            if (a) {
                Log.i("SoLibManager", "main updatePmsPkg start args: " + config);
            }
            config.e(b.a);
            vk2 vk2Var = new vk2(new km4(5), config);
            if (a) {
                Log.i("SoLibManager", "main updatePmsPkg pmsUpdateSo start requester: " + vk2Var);
            }
            ni4.o(vk2Var);
        }
    }

    public final String g(fk4 fk4Var) {
        InterceptResult invokeL;
        AbiType abiType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, fk4Var)) == null) {
            if (fk4Var != null) {
                abiType = fk4Var.q;
            } else {
                abiType = null;
            }
            if (abiType == null) {
                return "";
            }
            String str = fk4Var.p;
            Intrinsics.checkNotNullExpressionValue(str, "so.libName");
            AbiType abiType2 = fk4Var.q;
            Intrinsics.checkNotNullExpressionValue(abiType2, "so.abi");
            return h(str, abiType2, fk4Var.i);
        }
        return (String) invokeL.objValue;
    }

    public final String h(String libName, AbiType abi, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{libName, abi, Long.valueOf(j)})) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(abi, "abi");
            if (!TextUtils.isEmpty(libName) && j >= 1) {
                File i = i();
                File file = new File(i, libName + File.separator + j + File.separator + abi.id);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file.getPath();
            }
            return "";
        }
        return (String) invokeCommon.objValue;
    }

    public final boolean l(String libName, long j) {
        InterceptResult invokeLJ;
        AbiType q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, libName, j)) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            qk2 a2 = rk2.a(libName);
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

    public final void v(String libName, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, libName, j) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            SharedPreferences.Editor edit = mo4.a().edit();
            edit.putLong("swan_so_latest_update_time_" + libName, j).apply();
        }
    }

    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.baidu.tieba.fk4] */
    public final void x(String libName, Function1<? super wm3, Unit> callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, libName, callback) == null) {
            Intrinsics.checkNotNullParameter(libName, "libName");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (a) {
                Log.i("SoLibManager", "tryInstallUpdatePkg: libName=" + libName);
            }
            qk2 a2 = rk2.a(libName);
            if (a2 == null) {
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update libname=" + libName);
                }
                wm3 wm3Var = new wm3();
                wm3Var.k(16);
                wm3Var.b(2900);
                wm3Var.f("not available: so=" + a2);
                callback.invoke(wm3Var);
            } else if (a2.f()) {
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soLib unavailable update soLib=" + a2);
                }
                callback.invoke(null);
            } else {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                ?? t = aj4.i().t(libName);
                objectRef.element = t;
                if (((fk4) t) != null && ((fk4) t).a() && AbiType.currentAbi().compat(((fk4) objectRef.element).q)) {
                    AbiType q = q(libName);
                    if (l(libName, ((fk4) objectRef.element).i) && q != null && q.compat(((fk4) objectRef.element).q)) {
                        if (a) {
                            Log.i("SoLibManager", "tryInstallUpdatePkg: return by current so better then soPkg update libname=" + libName + " soPkg=" + ((fk4) objectRef.element));
                        }
                        callback.invoke(null);
                        return;
                    }
                    a2.a(((fk4) objectRef.element).a, new a(libName, objectRef, callback));
                    return;
                }
                if (a) {
                    Log.i("SoLibManager", "tryInstallUpdatePkg: return by soPkg unavailable update libname=" + libName + " soPkg=" + ((fk4) objectRef.element));
                }
                wm3 wm3Var2 = new wm3();
                wm3Var2.k(16);
                wm3Var2.b(2900);
                wm3Var2.f("invalid: pkg=" + ((fk4) objectRef.element));
                callback.invoke(wm3Var2);
            }
        }
    }
}
