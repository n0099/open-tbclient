package com.baidu.webkit.internal;

import com.baidu.webkit.sdk.IABTestInterface;
/* loaded from: classes11.dex */
public final class ABTestConstants implements INoProGuard {
    private static final int ADBLOCK2_ON = 1;
    private static final int ADBLOCK3_ON = 4;
    private static final int ADBLOCK4_ON = 8;
    public static final String ADBLOCK_MF30_OPT_CODE = "adblock_mf30_opt";
    public static final int ADBLOCK_MF30_OPT_DEFAULT = 1;
    public static final String AD_FILTER_RULE_V2 = "ad_filter_rule_v2";
    public static final int ASYNC_INVOKE_METHOD_DEFAULT = 0;
    public static final int ASYNC_INVOKE_METHOD_DISABLE = 0;
    public static final String ASYNC_INVOKE_METHOD_KEY = "async_invoke_method";
    public static final String BACKUP_DNS_JOB_DELAY_TIME = "backup_dns_job_delay_time";
    public static final String BACKUP_LANDING_JOB_DELAY_TIME = "backup_landing_job_delay";
    public static final String CFG_FILE_UTIL_OPT_SWITCH_KEY = "cfg_file_util_opt_switch";
    public static final int CHARACTER_LIMIT_FS_OPT_DEFAULT = 0;
    public static final String CHARACTER_LIMIT_FS_OPT_KEY = "character_limit_firstscreen_opt";
    public static final String CLOUD_ELEMENT_FS_OPT_DEFAULT = "false";
    public static final String CLOUD_ELEMENT_FS_OPT_DISABLE = "false";
    public static final String CLOUD_ELEMENT_FS_OPT_ENABLE = "true";
    public static final String CLOUD_ELEMENT_FS_OPT_KEY = "cloud_element_firstscreen_opt";
    public static final String DOM_PARSER_OPT_KEY = "dom_parser_opt";
    public static final int DOM_PARSER_OPT_VALUE_DEFAULT = 0;
    public static final int DOM_PARSER_OPT_VALUE_DISABLE = 2;
    public static final int DOM_PARSER_OPT_VALUE_ENABLE = 1;
    public static final String DULI_CRASHPAD_5_AND_ABOVE = "duli_crashpad_5_and_above";
    public static final boolean DULI_CRASHPAD_5_AND_ABOVE_DEFAULT_VALUE = false;
    public static final String ENGINE_COOKIE_USAGE = "engine_cookie_usage";
    public static final String FIRSTSCREEN_ELEMENT_OPT_DEFAULT = "false";
    public static final String FIRSTSCREEN_ELEMENT_OPT_DISABLE = "false";
    public static final String FIRSTSCREEN_ELEMENT_OPT_KEY = "firstscreen_element_opt";
    public static final boolean FSP_DIFF_FIXED_DEFAULT = true;
    public static final String FSP_DIFF_FIXED_KEY = "fsp_diff_fixed_enable";
    public static final String HIS_HIJACK_STOP_KEY = "his_buildinjs_stop_ab";
    public static final int IBLOCK_OPT_DEFAULT = 1;
    public static final String IBLOCK_OPT_KEY = "iblock_opt";
    public static final int IBLOCK_OPT_OFF = 0;
    public static final int IBLOCK_OPT_ON = 1;
    public static final boolean IMPROVE_CONTENTCACHE_DISABLE = false;
    public static final boolean IMPROVE_CONTENTCACHE_ENABLE = true;
    public static final String IMPROVE_CONTENTCACHE_KEY = "improve_contentcache";
    public static final boolean INVISIBLE_FIXED_ENABLE = true;
    public static final String INVISIBLE_FIXED_KEY = "whitescreen_invisible_fixed_enable";
    public static final String IPV6_CHECK_LIST = "zeus_ipv6_check_list";
    public static final String IPV6_CHECK_LIST_DEFAULT = "";
    public static final String IPV6_FIRST = "ipv6_first";
    public static final String IPV6_TIMEOUT = "zeus_ipv6_timeout";
    public static final String LOCATION_HREF_OPTIMIZATION_DEFAULT = "false";
    public static final String LOCATION_HREF_OPTIMIZATION_DISABLE = "false";
    public static final String LOCATION_HREF_OPTIMIZATION_KEY = "location_href_timer_opt";
    public static final String LOG_SDK_ENABLED = "log_sdk_enabled";
    public static final String MAGICFILTER_30_ENABLE_KEY = "magic_filter30_enable";
    public static final boolean MAGICFILTER_30_SWITCH_DEFAULT = false;
    public static final boolean MAGICFILTER_JS_OPT_DEFAULT = true;
    public static final boolean MAGICFILTER_JS_OPT_DISABLE = false;
    public static final boolean MAGICFILTER_JS_OPT_ENABLE = true;
    public static final String MAGICFILTER_JS_OPT_KEY = "magicfilter_js_opt";
    public static final int MAGICFILTER_VERSION_CODE_20 = 1;
    public static final int MAGICFILTER_VERSION_CODE_21 = 2;
    public static final int MAGICFILTER_VERSION_CODE_CLOSE = 0;
    public static final int MAGICFILTER_VERSION_CODE_DEFAULT = -1;
    public static final String MAGICFILTER_VERSION_CODE_KEY = "magicfilter_version";
    public static final String MAX_FATAL_ALLOCATION_FAILURE_SIZE = "max_fatal_allocation_failure_size";
    public static final int MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT = 10000000;
    private static final int MF_ON = 2;
    public static final String MULTIPLE_CONTAINER_KEY = "main_browser_frame_multi_container";
    public static final String MULTIPLE_PROCESS_KEY = "multiple_process";
    public static final String NATIVE_HTTPDNS_ENABLED = "native_httpdns_enabled";
    public static final String NET_CHANGE_NOTIFY_ENABLE = "net_change_notify_enable";
    public static final String NET_INJECT_ENABLE_KEY = "net_inject_enable";
    public static final String NET_INJECT_USE_NET = "net_inject_use_net";
    public static final String NO_ZEUS_UNDER_5 = "no_zeus_under_5";
    public static final boolean NO_ZEUS_UNDER_5_DEFAULT_VALUE = true;
    public static final int PENDING_LIMIT_FS_OPT_DEFAULT = 0;
    public static final String PENDING_LIMIT_FS_OPT_KEY = "pending_limit_firstscreen_opt";
    public static final String PHOENIX_NET_AD_FIRSTSCREEN_OPT_DEFAULT = "true";
    public static final String PHOENIX_NET_AD_FIRSTSCREEN_OPT_DISABLE = "false";
    public static final String PHOENIX_NET_AD_FIRSTSCREEN_OPT_ENABLE = "true";
    public static final String PHOENIX_NET_AD_FIRSTSCREEN_OPT_KEY = "phoenixnetad_firstscreen_opt";
    public static final String POPUP_WINDOW_OPT = "popup_window_opt";
    public static final boolean PRECREATE_CONTENT_CACHE_DISABLE = false;
    public static final boolean PRECREATE_CONTENT_CACHE_ENABLE = true;
    public static final String PRECREATE_CONTENT_CACHE_KEY = "precreate_content_cache";
    public static final String PRE_INIT_WEBVIEW = "preinit_webview_enable";
    public static final int PRE_INIT_WEBVIEW_VALUE_CLOSE = 0;
    public static final int PRE_INIT_WEBVIEW_VALUE_DEFAULT = 0;
    public static final int PRE_INIT_WEBVIEW_VALUE_OPEN = 1;
    public static final String QUIC_DEFAULT_OPEN = "quic_default_open";
    public static final boolean RESULT_PAGE_MULTILAYOUT_OPT_DEFAULT = true;
    public static final String RESULT_PAGE_MULTILAYOUT_OPT_KEY = "result_page_multilayout_opt";
    public static final String SEARCH_FRAME_QUIC = "search_frame_quic";
    public static final String SOCKET_GROUP_NUMBER = "socket_group_number";
    public static final String STREAMING_ON_PRELOAD = "streaming_on_preload";
    public static final boolean STREAMING_ON_PRELOAD_DEFAULT_VALUE = false;
    public static final String T7_V10_BLACK_LIST = "t7_v10_black_list";
    public static final boolean T7_V10_BLACK_LIST_DEFAULT_VALUE = false;
    public static final String UNUSED_IDLE_SOCKET_TIMEOUT_KEY = "unused_idle_socket_timeout";
    public static final int UPLOAD_ALWAYS = 3;
    public static final int UPLOAD_WHEN_WHITESCREEN = 2;
    public static final boolean V8_MEMCOPY_SOLUTION_DEFAULT_VALUE = false;
    public static final String V8_MEMCOPY_SOLUTION_KEY = "v8_memcopy_switcher";
    public static final boolean WATCH_VIRTUAL_MEMORY_DISABLE = false;
    public static final boolean WATCH_VIRTUAL_MEMORY_ENABLE = true;
    public static final String WATCH_VIRTUAL_MEMORY_KEY = "watch_virtual_memory";
    public static final String WEAK_NET_OPT_SWITCH_KEY = "weak_net_opt_switch";
    public static final int ZEUS_ASYNC_DRAW_DISABLE = 0;
    public static final int ZEUS_ASYNC_DRAW_ENABLE = 1;
    public static final String ZEUS_ASYNC_DRAW_KEY = "zeus_async_draw";
    public static final int ZEUS_GPU_RASTER_ANDROID8_9_ENABLE = 1;
    public static final int ZEUS_GPU_RASTER_ANDROID8_9_GMEM_ENABLE = 3;
    public static final int ZEUS_GPU_RASTER_ANDROID8_9_GMEM_HIGH_MEM_ENABLE = 4;
    public static final int ZEUS_GPU_RASTER_ANDROID9_ENABLE = 2;
    public static final int ZEUS_GPU_RASTER_DISABLE = 0;
    public static final String ZEUS_GPU_RASTER_KEY = "zeus_gpu_raster";
    public static final boolean ZEUS_ICU_DOWNLOAD_DISABLE = false;
    public static final boolean ZEUS_ICU_DOWNLOAD_ENABLE = true;
    public static final String ZEUS_ICU_DOWNLOAD_KEY = "zeus_icu_download";
    public static final int ZEUS_INIT_OPT_CLOSE = 0;
    public static final String ZEUS_INIT_OPT_KEY = "zeus_init_opt";
    public static final int ZEUS_INIT_OPT_START_BROWSER_ALONE = 1;
    public static final int ZEUS_INIT_OPT_START_BROWSER_ALONE_TASK = 2;
    public static final boolean ZEUS_INIT_WEBVIEW_PRELOAD_CLASS_DISABLE_VALUE = false;
    public static final boolean ZEUS_INIT_WEBVIEW_PRELOAD_CLASS_ENABLE_VALUE = true;
    public static final String ZEUS_INIT_WEBVIEW_PRELOAD_CLASS_KEY = "zeus_init_webview_preload_class";
    public static final int ZEUS_LONG_TASK_DISABLE = 0;
    public static final int ZEUS_LONG_TASK_ENABLE = 1;
    public static final String ZEUS_LONG_TASK_KEY = "zeus-long-task";
    public static final String ZEUS_NET_LOG_LEVEL_KEY = "zeus_net_log_level";
    public static final boolean ZEUS_RESOURCE_PREFETCH_DEFAULT = false;
    public static final boolean ZEUS_RESOURCE_PREFETCH_DISABLE = false;
    public static final boolean ZEUS_RESOURCE_PREFETCH_ENABLE = true;
    public static final String ZEUS_RESOURCE_PREFETCH_KEY = "zeus_resource_prefetch";
    public static final boolean ZEUS_RESOURCE_PRESCAN_DEFAULT = false;
    public static final boolean ZEUS_RESOURCE_PRESCAN_DISABLE = false;
    public static final boolean ZEUS_RESOURCE_PRESCAN_ENABLE = true;
    public static final String ZEUS_RESOURCE_PRESCAN_KEY = "zeus_resource_prescan";
    public static final String ZEUS_SKELETON_VIEW_ENABLE = "search_skeleton_ab_switch";

    private static final int getAdBlockAndMfOpt(IABTestInterface iABTestInterface) {
        if (iABTestInterface == null) {
            return 1;
        }
        return iABTestInterface.getSwitch(ADBLOCK_MF30_OPT_CODE, 1);
    }

    public static boolean isAdBlock2On(IABTestInterface iABTestInterface) {
        return (getAdBlockAndMfOpt(iABTestInterface) & 1) > 0;
    }

    public static boolean isAdBlock3On(IABTestInterface iABTestInterface) {
        return (getAdBlockAndMfOpt(iABTestInterface) & 4) > 0;
    }

    public static boolean isAdBlock4On(IABTestInterface iABTestInterface) {
        return iABTestInterface != null && iABTestInterface.getSwitch(IBLOCK_OPT_KEY, 1) == 1;
    }

    public static boolean isMagicFilterOn(IABTestInterface iABTestInterface) {
        return (getAdBlockAndMfOpt(iABTestInterface) & 2) > 0;
    }
}
