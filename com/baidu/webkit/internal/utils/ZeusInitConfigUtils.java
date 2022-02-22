package com.baidu.webkit.internal.utils;

import android.content.SharedPreferences;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebViewFactory;
@Keep
/* loaded from: classes3.dex */
public class ZeusInitConfigUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ENGINE_CLOUDSETTINGS_DATA = "engineCloudSettingsData";
    public static final String KEY_ENGINE_CLOUDSETTINGS_TIME = "engineCloudSettingsTime";
    public static final String NAME_CLOUDDATA = "zeus_init_config";
    public static final String PREF_KEY_NO_ZEUS_UNDER_5 = "no_zeus_under_5";
    public static final String PREF_KEY_SDK_VERSION = "sdk_version";
    public static SharedPreferences mSharePrefs;
    public transient /* synthetic */ FieldHolder $fh;

    public ZeusInitConfigUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String get(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) ? getPrefs().getString(str, str2) : (String) invokeLL.objValue;
    }

    public static boolean get(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, str, z)) == null) ? getPrefs().getBoolean(str, z) : invokeLZ.booleanValue;
    }

    public static SharedPreferences getPrefs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (ZeusInitConfigUtils.class) {
                if (mSharePrefs == null) {
                    mSharePrefs = WebViewFactory.getContext().getSharedPreferences(NAME_CLOUDDATA, 0);
                }
            }
            return mSharePrefs;
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static void set(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            SharedPreferences.Editor edit = getPrefs().edit();
            edit.putString(str, str2);
            edit.apply();
        }
    }

    public static void set(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65541, null, str, z) == null) {
            SharedPreferences.Editor edit = getPrefs().edit();
            edit.putBoolean(str, z);
            edit.apply();
        }
    }
}
