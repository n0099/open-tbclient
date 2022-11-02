package com.baidu.webkit.sdk.abtest;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.IABTestInterface;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes7.dex */
public class ABTestSDK implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LOG_TAG = "ABTestSDK";
    public static final int PRE_INIT_WEBVIEW_VALUE_CLOSE = 0;
    public static final int PRE_INIT_WEBVIEW_VALUE_OPEN = 1;
    public static final String ZEUS_ENABLE_USE_QUIC_PRECONNECT = "enable_use_quic_preconnect";
    public static final String ZEUS_INIT_OPT = "zeus_init_opt";
    public static final int ZEUS_INIT_OPT_CLOSE = 0;
    public static final int ZEUS_INIT_OPT_START_BROWSER_ALONE = 1;
    public static final int ZEUS_INIT_OPT_START_BROWSER_ALONE_TASK = 2;
    public static final String ZEUS_IPV6_HTTPDNS_ENV = "ipv6_httpdns_env";
    public static final String ZEUS_LONG_TASK = "zeus-long-task";
    public static final int ZEUS_LONG_TASK_DISABLE = 0;
    public static final int ZEUS_LONG_TASK_ENABLE = 1;
    public static final String ZEUS_MULTIPLE_PROCESS = "multiple_process";
    public static final String ZEUS_NETWORK_CHANGE_NOTIFIER = "zeus_network_change_notifier";
    public static final String ZEUS_OPTIMIZED_PACKAGE_INFO = "zeus_optimized_package_info";
    public static final String ZEUS_PREINIT_WEBVIEW_ENABLE = "preinit_webview_enable";
    public static final String ZEUS_SHOULD_RESET_ZEUS_AB_TEST_VALUE = "should_reset_zeus_ab_test_value";
    public static IABTestInterface sABTest;
    public transient /* synthetic */ FieldHolder $fh;

    public ABTestSDK() {
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

    public static int getPreinitWebviewEnableValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, preinit_webview_enable default value: 0");
                return 0;
            }
            int i = iABTestInterface.getSwitch(ZEUS_PREINIT_WEBVIEW_ENABLE, 0);
            Log.v(LOG_TAG, "[zeus-abtest] preinit_webview_enable current abtest value: ".concat(String.valueOf(i)));
            return i;
        }
        return invokeV.intValue;
    }

    public static String getRawSwitches() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null || iABTestInterface.getRawSwitch() == null) {
                return null;
            }
            return sABTest.getRawSwitch().toString();
        }
        return (String) invokeV.objValue;
    }

    public static int getZeusInitOptValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus_init_opt default value: 0");
                return 0;
            }
            int i = iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0);
            Log.v(LOG_TAG, "[zeus-abtest] zeus_init_opt current abtest value: ".concat(String.valueOf(i)));
            return i;
        }
        return invokeV.intValue;
    }

    public static int getZeusLongTaskValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus-long-task default value: 0");
                return 0;
            }
            int i = iABTestInterface.getSwitch(ZEUS_LONG_TASK, 0);
            Log.v(LOG_TAG, "[zeus-abtest] zeus-long-task current abtest value: ".concat(String.valueOf(i)));
            return i;
        }
        return invokeV.intValue;
    }

    public static boolean isEnableUseQuicPreconnectEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, enable_use_quic_preconnect default value: false");
                return false;
            }
            boolean z = iABTestInterface.getSwitch(ZEUS_ENABLE_USE_QUIC_PRECONNECT, false);
            Log.v(LOG_TAG, "[zeus-abtest] enable_use_quic_preconnect current abtest value: ".concat(String.valueOf(z)));
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isIpv6HttpdnsEnvEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, ipv6_httpdns_env default value: false");
                return false;
            }
            boolean z = iABTestInterface.getSwitch(ZEUS_IPV6_HTTPDNS_ENV, false);
            Log.v(LOG_TAG, "[zeus-abtest] ipv6_httpdns_env current abtest value: ".concat(String.valueOf(z)));
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMultipleProcessEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, multiple_process default value: false");
                return false;
            }
            boolean z = iABTestInterface.getSwitch(ZEUS_MULTIPLE_PROCESS, false);
            Log.v(LOG_TAG, "[zeus-abtest] multiple_process current abtest value: ".concat(String.valueOf(z)));
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptPreInitWebviewValueCloseEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            return iABTestInterface == null || iABTestInterface.getSwitch(ZEUS_PREINIT_WEBVIEW_ENABLE, 0) == 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptPreInitWebviewValueOpenEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_PREINIT_WEBVIEW_ENABLE, 0) == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptZeusInitOptCloseEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            return iABTestInterface == null || iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0) == 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptZeusInitOptStartBrowserAloneEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0) == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptZeusInitOptStartBrowserAloneTaskEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0) == 2;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptZeusLongTaskDisableEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            return iABTestInterface == null || iABTestInterface.getSwitch(ZEUS_LONG_TASK, 0) == 0;
        }
        return invokeV.booleanValue;
    }

    public static boolean isOptZeusLongTaskEnableEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_LONG_TASK, 0) == 1;
        }
        return invokeV.booleanValue;
    }

    public static boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? sABTest != null : invokeV.booleanValue;
    }

    public static boolean isShouldResetZeusAbTestValueEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, should_reset_zeus_ab_test_value default value: false");
                return false;
            }
            boolean z = iABTestInterface.getSwitch(ZEUS_SHOULD_RESET_ZEUS_AB_TEST_VALUE, false);
            Log.v(LOG_TAG, "[zeus-abtest] should_reset_zeus_ab_test_value current abtest value: ".concat(String.valueOf(z)));
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isZeusNetworkChangeNotifierEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus_network_change_notifier default value: true");
                return true;
            }
            boolean z = iABTestInterface.getSwitch(ZEUS_NETWORK_CHANGE_NOTIFIER, true);
            Log.v(LOG_TAG, "[zeus-abtest] zeus_network_change_notifier current abtest value: ".concat(String.valueOf(z)));
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean isZeusOptimizedPackageInfoEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            IABTestInterface iABTestInterface = sABTest;
            if (iABTestInterface == null) {
                Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus_optimized_package_info default value: false");
                return false;
            }
            boolean z = iABTestInterface.getSwitch(ZEUS_OPTIMIZED_PACKAGE_INFO, false);
            Log.v(LOG_TAG, "[zeus-abtest] zeus_optimized_package_info current abtest value: ".concat(String.valueOf(z)));
            return z;
        }
        return invokeV.booleanValue;
    }

    public static void setABTestInterface(IABTestInterface iABTestInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, iABTestInterface) == null) {
            sABTest = iABTestInterface;
        }
    }
}
