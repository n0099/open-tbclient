package com.bytedance.pangle.util;

import android.app.Application;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Locale;
/* loaded from: classes11.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f61527b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f61528a;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Application appApplication = Zeus.getAppApplication();
        this.f61528a = appApplication.getSharedPreferences(ZeusConstants.BASE_LIB_NAME + "_meta_data_sp", 0);
    }

    public static k a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f61527b == null) {
                synchronized (k.class) {
                    if (f61527b == null) {
                        f61527b = new k();
                    }
                }
            }
            return f61527b;
        }
        return (k) invokeV.objValue;
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            SharedPreferences.Editor edit = this.f61528a.edit();
            edit.putBoolean("OFFLINE__" + com.bytedance.pangle.i.a().f61438b.getHostVersionCode() + "_" + str, true);
            edit.apply();
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markOfflineFlag packageName=" + str + " hostUpdateVerCode= " + com.bytedance.pangle.i.a().f61438b.getHostVersionCode());
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SharedPreferences.Editor edit = this.f61528a.edit();
            edit.remove("OFFLINE__" + com.bytedance.pangle.i.a().f61438b.getHostVersionCode() + "_" + str);
            edit.apply();
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils clearOfflineFlag packageName=" + str + " hostUpdateVerCode= " + com.bytedance.pangle.i.a().f61438b.getHostVersionCode());
        }
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.f61528a.getBoolean("OFFLINE__" + com.bytedance.pangle.i.a().f61438b.getHostVersionCode() + "_" + str, false);
        }
        return invokeL.booleanValue;
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            SharedPreferences.Editor edit = this.f61528a.edit();
            edit.putBoolean("DELETED__".concat(String.valueOf(str)), true);
            edit.apply();
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markDeletedFlag packageName=".concat(String.valueOf(str)));
        }
    }

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int i2 = this.f61528a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i2);
            return i2;
        }
        return invokeL.intValue;
    }

    public final void a(String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            SharedPreferences.Editor edit = this.f61528a.edit();
            String str2 = "INSTALLED_" + str + "-" + i2;
            if (z) {
                edit.putBoolean(str2, true);
            } else {
                edit.remove(str2);
            }
            edit.apply();
        }
    }

    public final boolean a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) ? this.f61528a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i2)), false) : invokeLI.booleanValue;
    }
}
