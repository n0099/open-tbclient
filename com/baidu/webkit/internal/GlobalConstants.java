package com.baidu.webkit.internal;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class GlobalConstants implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean CLOUD_SETTINGS_DEBUG = false;
    public static final String DEFAULT_VERSION = "10.0.0.0";
    public static final boolean EMMA_ENABLED = false;
    public static final boolean ENABLE_ADBLOCK_BADCASE_DETECT = false;
    public static final boolean ENABLE_LOG_RECORD = false;
    public static final boolean ENABLE_SEARCHBOX_FEATURES = true;
    public static final long FILE_SIZE_LIB_ZEUS_WEBVIEW_CHROMIUM = 27057988;
    public static final boolean INSPECTOR_ENABLED = false;
    public static final long INVALID_SIZE = -1;
    public static final boolean IS_FILTER_LOG_RECORD = false;
    public static final boolean JAVA2JAR_ENABLED = false;
    public static final String LIB_PLAT_SUPPORT = "libzeusplat_support.so";
    public static final String LIB_PLAT_SUPPORT_NAME = "zeusplat_support";
    public static final String LIB_ZEUS = "libcom.baidu.zeus.so";
    public static final String LIB_ZEUS_CHROMIUM = "libzeuswebviewchromium.so";
    public static final String[] LIB_ZEUS_SO;
    public static final String LIB_ZEUS_V8 = "libzeusv8.so";
    public static final String LOG_PER_TAG = "T7Perfermance";
    public static final String SDK_CFG_RELATIVE_PATH = "sdkcfg";
    public static final String SDK_CFG_RELATIVE_PATH_V2 = "sdkcfgv2";
    public static final String SEARCHBOX_PACKAGE_NAME = "com.baidu.searchbox";
    public static final boolean TEST_HOOKS_ENABLED = false;
    public static final boolean USE_ZEUS_MANAGER = false;
    public static final boolean ZEUS_DEBUG_MODE = false;
    public static final String ZEUS_LIB_LOCAL_RELATIVE_PATH = "/zeus/libs/";
    public static final String ZEUS_VERSION_NAME = "10.23.2.4";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2124641214, "Lcom/baidu/webkit/internal/GlobalConstants;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2124641214, "Lcom/baidu/webkit/internal/GlobalConstants;");
                return;
            }
        }
        LIB_ZEUS_SO = new String[]{"libcom.baidu.zeus.so", LIB_PLAT_SUPPORT, "libzeuswebviewchromium.so", LIB_ZEUS_V8};
    }

    public GlobalConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static final boolean enableSearchboxFeatures() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }
}
