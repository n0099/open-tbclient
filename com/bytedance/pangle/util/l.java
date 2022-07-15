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
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l b;
    public transient /* synthetic */ FieldHolder $fh;
    public SharedPreferences a;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Application appApplication = Zeus.getAppApplication();
        this.a = appApplication.getSharedPreferences(ZeusConstants.BASE_LIB_NAME + "_meta_data_sp", 0);
    }

    public static l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b == null) {
                synchronized (l.class) {
                    if (b == null) {
                        b = new l();
                    }
                }
            }
            return b;
        }
        return (l) invokeV.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            String string = this.a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
            return string;
        }
        return (String) invokeL.objValue;
    }

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            int i = this.a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
            return i;
        }
        return invokeL.intValue;
    }

    public final void a(String str, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            SharedPreferences.Editor edit = this.a.edit();
            String str2 = "INSTALLED_" + str + "-" + i;
            if (z) {
                edit.putBoolean(str2, true);
            } else {
                edit.remove(str2);
            }
            edit.apply();
        }
    }

    public final boolean a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) ? this.a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false) : invokeLI.booleanValue;
    }
}
