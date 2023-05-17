package com.baidu.webkit.sdk.abtest;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.IABTestInterface;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes8.dex */
public class ABTestSDK implements INoProGuard {
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

    public static int getPreinitWebviewEnableValue() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, preinit_webview_enable default value: 0");
            return 0;
        }
        int i = iABTestInterface.getSwitch(ZEUS_PREINIT_WEBVIEW_ENABLE, 0);
        Log.v(LOG_TAG, "[zeus-abtest] preinit_webview_enable current abtest value: ".concat(String.valueOf(i)));
        return i;
    }

    public static String getRawSwitches() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null || iABTestInterface.getRawSwitch() == null) {
            return null;
        }
        return sABTest.getRawSwitch().toString();
    }

    public static int getZeusInitOptValue() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus_init_opt default value: 0");
            return 0;
        }
        int i = iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0);
        Log.v(LOG_TAG, "[zeus-abtest] zeus_init_opt current abtest value: ".concat(String.valueOf(i)));
        return i;
    }

    public static int getZeusLongTaskValue() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus-long-task default value: 0");
            return 0;
        }
        int i = iABTestInterface.getSwitch(ZEUS_LONG_TASK, 0);
        Log.v(LOG_TAG, "[zeus-abtest] zeus-long-task current abtest value: ".concat(String.valueOf(i)));
        return i;
    }

    public static boolean isEnableUseQuicPreconnectEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, enable_use_quic_preconnect default value: false");
            return false;
        }
        boolean z = iABTestInterface.getSwitch(ZEUS_ENABLE_USE_QUIC_PRECONNECT, false);
        Log.v(LOG_TAG, "[zeus-abtest] enable_use_quic_preconnect current abtest value: ".concat(String.valueOf(z)));
        return z;
    }

    public static boolean isIpv6HttpdnsEnvEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, ipv6_httpdns_env default value: false");
            return false;
        }
        boolean z = iABTestInterface.getSwitch(ZEUS_IPV6_HTTPDNS_ENV, false);
        Log.v(LOG_TAG, "[zeus-abtest] ipv6_httpdns_env current abtest value: ".concat(String.valueOf(z)));
        return z;
    }

    public static boolean isMultipleProcessEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, multiple_process default value: false");
            return false;
        }
        boolean z = iABTestInterface.getSwitch(ZEUS_MULTIPLE_PROCESS, false);
        Log.v(LOG_TAG, "[zeus-abtest] multiple_process current abtest value: ".concat(String.valueOf(z)));
        return z;
    }

    public static boolean isOptPreInitWebviewValueCloseEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        return iABTestInterface == null || iABTestInterface.getSwitch(ZEUS_PREINIT_WEBVIEW_ENABLE, 0) == 0;
    }

    public static boolean isOptPreInitWebviewValueOpenEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_PREINIT_WEBVIEW_ENABLE, 0) == 1;
    }

    public static boolean isOptZeusInitOptCloseEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        return iABTestInterface == null || iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0) == 0;
    }

    public static boolean isOptZeusInitOptStartBrowserAloneEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0) == 1;
    }

    public static boolean isOptZeusInitOptStartBrowserAloneTaskEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_INIT_OPT, 0) == 2;
    }

    public static boolean isOptZeusLongTaskDisableEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        return iABTestInterface == null || iABTestInterface.getSwitch(ZEUS_LONG_TASK, 0) == 0;
    }

    public static boolean isOptZeusLongTaskEnableEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        return iABTestInterface != null && iABTestInterface.getSwitch(ZEUS_LONG_TASK, 0) == 1;
    }

    public static boolean isReady() {
        return sABTest != null;
    }

    public static boolean isShouldResetZeusAbTestValueEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, should_reset_zeus_ab_test_value default value: false");
            return false;
        }
        boolean z = iABTestInterface.getSwitch(ZEUS_SHOULD_RESET_ZEUS_AB_TEST_VALUE, false);
        Log.v(LOG_TAG, "[zeus-abtest] should_reset_zeus_ab_test_value current abtest value: ".concat(String.valueOf(z)));
        return z;
    }

    public static boolean isZeusNetworkChangeNotifierEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus_network_change_notifier default value: true");
            return true;
        }
        boolean z = iABTestInterface.getSwitch(ZEUS_NETWORK_CHANGE_NOTIFIER, true);
        Log.v(LOG_TAG, "[zeus-abtest] zeus_network_change_notifier current abtest value: ".concat(String.valueOf(z)));
        return z;
    }

    public static boolean isZeusOptimizedPackageInfoEnabled() {
        IABTestInterface iABTestInterface = sABTest;
        if (iABTestInterface == null) {
            Log.v(LOG_TAG, "[zeus-abtest] ABTest is not ready, zeus_optimized_package_info default value: false");
            return false;
        }
        boolean z = iABTestInterface.getSwitch(ZEUS_OPTIMIZED_PACKAGE_INFO, false);
        Log.v(LOG_TAG, "[zeus-abtest] zeus_optimized_package_info current abtest value: ".concat(String.valueOf(z)));
        return z;
    }

    public static void setABTestInterface(IABTestInterface iABTestInterface) {
        sABTest = iABTestInterface;
    }
}
