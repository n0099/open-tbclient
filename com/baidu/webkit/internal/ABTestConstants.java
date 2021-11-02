package com.baidu.webkit.internal;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.IABTestInterface;
/* loaded from: classes11.dex */
public final class ABTestConstants implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADBLOCK2_ON = 1;
    public static final int ADBLOCK3_ON = 4;
    public static final int ADBLOCK4_ON = 8;
    public static final String ADBLOCK_MF30_OPT_CODE = "adblock_mf30_opt";
    public static final int ADBLOCK_MF30_OPT_DEFAULT = 1;
    public static final boolean ADD_REDIRECT_STATUS = true;
    public static final String AD_FILTER_RULE_V2 = "ad_filter_rule_v2";
    public static final int ASYNC_INVOKE_METHOD_DEFAULT = 0;
    public static final int ASYNC_INVOKE_METHOD_DISABLE = 0;
    public static final String ASYNC_INVOKE_METHOD_KEY = "async_invoke_method";
    public static final String BACKUP_DNS_JOB_DELAY_TIME = "backup_dns_job_delay_time";
    public static final String BACKUP_LANDING_JOB_DELAY_TIME = "backup_landing_job_delay";
    public static final int CANCEL_DELAY_TIME_DEFAULT = 5000;
    public static final String CFG_FILE_UTIL_OPT_SWITCH_KEY = "cfg_file_util_opt_switch";
    public static final int CHARACTER_LIMIT_FS_OPT_DEFAULT = 0;
    public static final String CHARACTER_LIMIT_FS_OPT_KEY = "character_limit_firstscreen_opt";
    public static final String CHECK_PREFETCH_BY_ADFILTER = "check_prefetch_by_adfilter_enable";
    public static final String CLOUD_ELEMENT_FS_OPT_DEFAULT = "false";
    public static final String CLOUD_ELEMENT_FS_OPT_DISABLE = "false";
    public static final String CLOUD_ELEMENT_FS_OPT_ENABLE = "true";
    public static final String CLOUD_ELEMENT_FS_OPT_KEY = "cloud_element_firstscreen_opt";
    public static final String CODECACHE_SIZE_KEY = "codecache_size_setting";
    public static final int CODECACHE_SIZE_LIMIT_DEFAULT = 0;
    public static final String DOM_PARSER_OPT_KEY = "dom_parser_opt";
    public static final int DOM_PARSER_OPT_VALUE_DEFAULT = 0;
    public static final int DOM_PARSER_OPT_VALUE_DISABLE = 2;
    public static final int DOM_PARSER_OPT_VALUE_ENABLE = 1;
    public static final String DOUBLE_LOG_ENABLED = "double_log_enabled";
    public static final int DO_NOT_UPLOAD = 3;
    public static final String DULI_CRASHPAD_5_AND_ABOVE = "duli_crashpad_5_and_above";
    public static final boolean DULI_CRASHPAD_5_AND_ABOVE_DEFAULT_VALUE = true;
    public static final String ENABLE_DECODED_IMAGE_BYTE_LIMIT = "enable_decoded_image_byte_limit";
    public static final boolean ENABLE_DECODED_IMAGE_BYTE_LIMIT_DEFAULT_VALUE = false;
    public static final String ENABLE_MEM_MULTI_MAX = "enable_mem_multi_max";
    public static final boolean ENABLE_MEM_MULTI_MAX_DEFAULT_VALUE = true;
    public static final String ENABLE_QUIC_PRECONNECT_KEY = "enable_use_quic_preconnect";
    public static final int FID_TIME_DELAY_DEFAULT = 0;
    public static final String FID_USB_DELAY_KEY = "fid_usb_delay_time";
    public static final String FIRSTSCREEN_ELEMENT_OPT_DEFAULT = "false";
    public static final String FIRSTSCREEN_ELEMENT_OPT_DISABLE = "false";
    public static final String FIRSTSCREEN_ELEMENT_OPT_KEY = "firstscreen_element_opt";
    public static final boolean FIRSTSCREEN_IMAGE_PAINT_ALLTYPE_DEFAULT = true;
    public static final String FIRSTSCREEN_IMAGE_PAINT_ALLTYPE_KEY = "firstscreen_image_paint_alltype";
    public static final boolean FSP_RESOLVED_DEFAULT = false;
    public static final String FSP_RESOLVED_KEY = "fsp_resolved_enable";
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
    public static final String IPV6_HTTPDNS_ENV = "ipv6_httpdns_env";
    public static final String IPV6_TIMEOUT = "zeus_ipv6_timeout";
    public static final boolean JS_JAVA_POST_MESSAGE_DEFAULT = false;
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
    public static final String MAIN_HTTPCACHE_SIZE_KEY = "main_httpcache_size_setting";
    public static final String MAX_FATAL_ALLOCATION_FAILURE_SIZE = "max_fatal_allocation_failure_size";
    public static final int MAX_FATAL_ALLOCATION_FAILURE_SIZE_DEFAULT = 10000000;
    public static final int MAX_LINK_CONCURRENCY_DEFAULT = 4;
    public static final int MF_ON = 2;
    public static final String MULTIPLE_CONTAINER_KEY = "main_browser_frame_multi_container";
    public static final String MULTIPLE_PROCESS_KEY = "multiple_process";
    public static final String MULTIPLE_PROCESS_LOG = "multiple_process_log";
    public static final String MULTIPLE_PROCESS_STRONG_BINDING_KEY = "multiple_process_strong_binding";
    public static final String NATIVE_HTTPDNS_ENABLED = "native_httpdns_enabled";
    public static final String NET_CHANGE_NOTIFY_ENABLE = "net_change_notify_enable";
    public static final String NET_INJECT_ENABLE_KEY = "net_inject_enable";
    public static final String NET_INJECT_USE_NET = "net_inject_use_net";
    public static final int NOSTATE_PREFETCH_WEBCACHE_DEFAULT = 2;
    public static final String NO_ZEUS_UNDER_5 = "no_zeus_under_5";
    public static final boolean NO_ZEUS_UNDER_5_DEFAULT_VALUE = true;
    public static final boolean NSP_MULTI_PROCESS_DISABLE_DEFAULT = false;
    public static final String NSP_MULTI_PROCESS_DISABLE_KEY = "nsp_multi_process_disable";
    public static final boolean OPTIMIZED_PACKAGE_INFO_DEFAULT = false;
    public static final int PARSER_TIME_LIMIT_DEFAULT = 500;
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
    public static final String PREFETCH_REUSE_AGE_DEFAULT_VALUE = "300";
    public static final String PREFETCH_REUSE_AGE_KEY = "prefetch_reuse_age";
    public static final boolean PREFETCH_SUBRESOURCE_FOR_LINK_PREFETCH_DEFAULT = false;
    public static final String PREFETCH_SUBRESOURCE_FOR_LINK_PREFETCH_KEY = "prefetch_subresource_for_link_prefetch";
    public static final String PRE_INIT_WEBVIEW = "preinit_webview_enable";
    public static final int PRE_INIT_WEBVIEW_VALUE_CLOSE = 0;
    public static final int PRE_INIT_WEBVIEW_VALUE_DEFAULT = 0;
    public static final int PRE_INIT_WEBVIEW_VALUE_OPEN = 1;
    public static final String QUIC_DEFAULT_OPEN = "quic_default_open";
    public static final int RESULTPAGE_CRITICALSR_TIMEDOUT_DEFAULT = -1;
    public static final String RESULTPAGE_CRITICALSR_TIMEDOUT_KEY = "zeus_rp_criticalsr_timedout";
    public static final String RETRY_QUIC_PRECONNECT_KEY = "retry_quic_preconnect";
    public static final String SEARCH_FRAME_QUIC = "search_frame_quic";
    public static final String SHOULD_RESET_DOWNLOAD_ZEUS = "should_reset_zeus_ab_test_value";
    public static final boolean SHOULD_RESET_DOWNLOAD_ZEUS_DISABLE = false;
    public static final String SOCKET_GROUP_NUMBER = "socket_group_number";
    public static final String STREAMING_ON_PRELOAD = "streaming_on_preload";
    public static final boolean STREAMING_ON_PRELOAD_DEFAULT_VALUE = false;
    public static final String SWAN_HTTPCACHE_SIZE_KEY = "swan_httpcache_size_setting";
    public static final String T7_V10_BLACK_LIST = "t7_v10_black_list";
    public static final boolean T7_V10_BLACK_LIST_DEFAULT_VALUE = false;
    public static final String UNUSED_IDLE_SOCKET_TIMEOUT_KEY = "unused_idle_socket_timeout";
    public static final int UPLOAD_ALWAYS = 3;
    public static final int UPLOAD_TO_KERNEL_AND_UBC_SERVER = 2;
    public static final int UPLOAD_TO_KERNEL_SERVER = 0;
    public static final int UPLOAD_TO_UBC_SERVER = 1;
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
    public static final int ZEUS_DECODEED_IMAGE_BUF_DEFAULT = 24;
    public static final String ZEUS_DECODEED_IMAGE_BUF_KEY = "decoded_image_buf";
    public static final int ZEUS_DECODEED_IMAGE_BUF_MAX = 64;
    public static final boolean ZEUS_DRAG_AND_DROP_DISABLE_VALUE = false;
    public static final boolean ZEUS_DRAG_AND_DROP_ENABLE_VALUE = true;
    public static final String ZEUS_DRAG_AND_DROP_KEY = "zeus_drag_and_drop_enabled";
    public static final int ZEUS_FRAME_STACK_THRESHOLD_DEFAULT = 200;
    public static final String ZEUS_FRAME_STACK_THRESHOLD_KEY = "zeus_frame_stack_threshold";
    public static final int ZEUS_FRAME_THRESHOLD_DEFAULT = 30;
    public static final String ZEUS_FRAME_THRESHOLD_KEY = "zeus_frame_threshold";
    public static final int ZEUS_FRAME_TRACE_CLOSE = 0;
    public static final String ZEUS_FRAME_TRACE_KEY = "zeus_frame_trace";
    public static final int ZEUS_FRAME_TRACE_OPEN = 1;
    public static final int ZEUS_FRAME_TRACE_OPEN_STACK = 3;
    public static final int ZEUS_FRAME_TRACE_OPEN_WIFI = 2;
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
    public static final boolean ZEUS_INIT_WEBKIT_ASYNC_DISABLE_VALUE = false;
    public static final String ZEUS_INIT_WEBKIT_ASYNC_KEY = "zeus_init_webkit_async";
    public static final String ZEUS_JS_JAVA_POST_MESSAGE_KEY = "js_java_post_message";
    public static final boolean ZEUS_LCP_IMAGE_TIME_DEFAULT = true;
    public static final String ZEUS_LCP_IMAGE_TIME_KEY = "zeus_lcp_image_time";
    public static final boolean ZEUS_LCP_TIME_DEFAULT = true;
    public static final String ZEUS_LCP_TIME_KEY = "zeus_lcp_time";
    public static final String ZEUS_LOADINGRESOURCE_MEMORYCACHE = "zeus_loading_res_mc";
    public static final boolean ZEUS_LOADINGRESOURCE_MEMORYCACHE_DEFAULT = false;
    public static final boolean ZEUS_LOADINGRESOURCE_MEMORYCACHE_DISABLE = false;
    public static final boolean ZEUS_LOADINGRESOURCE_MEMORYCACHE_ENABLE = true;
    public static final int ZEUS_LONG_TASK_DISABLE = 0;
    public static final int ZEUS_LONG_TASK_ENABLE = 1;
    public static final String ZEUS_LONG_TASK_KEY = "zeus-long-task";
    public static final String ZEUS_MAIN_RESOURCE_PREFETCH_WEBCACHE = "zeus_prefetch_wc_main";
    public static final boolean ZEUS_MAIN_RESOURCE_PREFETCH_WEBCACHE_DEFAULT = false;
    public static final int ZEUS_MAX_MEM_PREPAINT_PC_DEFAULT = 40;
    public static final String ZEUS_MAX_MEM_PREPAINT_PC_KEY = "max_mem_prepaint_pc";
    public static final int ZEUS_MAX_MEM_PREPAINT_PC_MAX = 50;
    public static final String ZEUS_NET_LOG_LEVEL_KEY = "zeus_net_log_level";
    public static final String ZEUS_NOSTATE_PREFETCH_CANCEL_DELAY = "cancel_delay_time";
    public static final String ZEUS_NOSTATE_PREFETCH_MAX_LINK_CONCURRENCY = "max_link_concurrency";
    public static final String ZEUS_NOSTATE_PREFETCH_WEBCACHE = "nostate_prefetch_webcache";
    public static final boolean ZEUS_NO_STATE_PREFETCH_WC_DISABLE_VALUE = false;
    public static final boolean ZEUS_NO_STATE_PREFETCH_WC_ENABLE_VALUE = true;
    public static final String ZEUS_NO_STATE_PREFETCH_WC_KEY = "zeus_no_state_prefetch_wc";
    public static final String ZEUS_NR_TRACE_KEY = "zeus_nr_trace";
    public static final int ZEUS_NR_TRACE_KEY_CLOSE = 0;
    public static final int ZEUS_NR_TRACE_KEY_OPEN = 1;
    public static final int ZEUS_NR_TRACE_KEY_OPEN_ONLY_NATIVE = 2;
    public static final String ZEUS_NSP_REDIRECT_STATUS = "nsp_add_redirect_status";
    public static final String ZEUS_OPTIMIZED_PACKAGE_INFO_KEY = "zeus_optimized_package_info";
    public static final String ZEUS_PAGE_JUMP_JUDGE = "zeus_page_jump_judge";
    public static final String ZEUS_PARSER_TIME_LIMIT = "parser_time_limit";
    public static final boolean ZEUS_PRECONNECT_SUBRESOURCE_DEFAULT_VALUE = false;
    public static final String ZEUS_PRECONNECT_SUBRESOURCE_KEY = "zeus_preconnect_subresource";
    public static final String ZEUS_PREFETCH_SUBRESOURCE_BY_WEBCACHE = "zeus_prefetch_subresource_by_webcache";
    public static final boolean ZEUS_PREFETCH_SUBRESOURCE_BY_WEBCACHE_DISABLE_VALUE = false;
    public static final boolean ZEUS_PREFETCH_SUBRESOURCE_BY_WEBCACHE_ENABLE_VALUE = true;
    public static final String ZEUS_PS_KEY = "zeus_ps";
    public static final String ZEUS_PS_LOG_UPLOAD_SERVER = "zeus_ps_log_upload_server";
    public static final String ZEUS_PS_SERIALIZATION_KEY = "zeus_ps_serialization";
    public static final String ZEUS_PS_UPLOAD_DELAY_KEY = "zeus_ps_upload_delay";
    public static final boolean ZEUS_RESOURCE_PREFETCH_DEFAULT = false;
    public static final boolean ZEUS_RESOURCE_PREFETCH_DISABLE = false;
    public static final boolean ZEUS_RESOURCE_PREFETCH_ENABLE = true;
    public static final String ZEUS_RESOURCE_PREFETCH_KEY = "zeus_resource_prefetch";
    public static final String ZEUS_RESOURCE_PRESCAN_NUMBER = "zeus_resource_prescan_number";
    public static final int ZEUS_RESOURCE_PRESCAN_NUMBER_DEFAULT = 3;
    public static final String ZEUS_RESOURCE_RECORD_TYPE_KEY = "zeus_resource_record_type";
    public static final String ZEUS_SKELETON_VIEW_ENABLE = "search_skeleton_ab_switch";
    public static final int ZEUS_STAGING_BUF_DEFAULT = 24;
    public static final String ZEUS_STAGING_BUF_KEY = "max_staging_buf";
    public static final int ZEUS_STAGING_BUF_MAX = 32;
    public static final String ZEUS_TOUCH_MODE = "zeus_touch_mode";
    public static final int ZEUS_TOUCH_MODE_KEY_CLOSE = 0;
    public static final int ZEUS_TOUCH_MODE_KEY_OPEN = 1;
    public static final boolean ZEUS_UKM_DISABLE_VALUE = false;
    public static final boolean ZEUS_UKM_ENABLE_VALUE = true;
    public static final String ZEUS_UKM_KEY = "zeus_ukm";
    public static final boolean ZEUS_UKM_MEMORY_DISABLE_VALUE = false;
    public static final boolean ZEUS_UKM_MEMORY_ENABLE_VALUE = true;
    public static final String ZEUS_UKM_MEMORY_KEY = "zeus_ukm_memory";
    public static final boolean ZEUS_UMA_DISABLE_VALUE = false;
    public static final boolean ZEUS_UMA_ENABLE_VALUE = true;
    public static final String ZEUS_UMA_KEY = "zeus_uma";
    public static final String ZEUS_USE_OLD_DITING_FEATURES = "zeus_old_diting_features";
    public static final boolean ZEUS_USE_OLD_DITING_FEATURES_DEFAULT = false;
    public static final boolean ZEUS_WEBCACHE_FROM_PROXY_DISABLE_VALUE = false;
    public static final boolean ZEUS_WEBCACHE_FROM_PROXY_ENABLE_VALUE = true;
    public static final String ZEUS_WEBCACHE_FROM_PROXY_KEY = "webcache_from_proxy";
    public transient /* synthetic */ FieldHolder $fh;

    public ABTestConstants() {
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

    public static final int getAdBlockAndMfOpt(IABTestInterface iABTestInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iABTestInterface)) == null) {
            if (iABTestInterface == null) {
                return 1;
            }
            return iABTestInterface.getSwitch(ADBLOCK_MF30_OPT_CODE, 1);
        }
        return invokeL.intValue;
    }

    public static boolean isAdBlock2On(IABTestInterface iABTestInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, iABTestInterface)) == null) ? (getAdBlockAndMfOpt(iABTestInterface) & 1) > 0 : invokeL.booleanValue;
    }

    public static boolean isAdBlock3On(IABTestInterface iABTestInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, iABTestInterface)) == null) ? (getAdBlockAndMfOpt(iABTestInterface) & 4) > 0 : invokeL.booleanValue;
    }

    public static boolean isAdBlock4On(IABTestInterface iABTestInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iABTestInterface)) == null) ? iABTestInterface != null && iABTestInterface.getSwitch(IBLOCK_OPT_KEY, 1) == 1 : invokeL.booleanValue;
    }

    public static boolean isMagicFilterOn(IABTestInterface iABTestInterface) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iABTestInterface)) == null) ? (getAdBlockAndMfOpt(iABTestInterface) & 2) > 0 : invokeL.booleanValue;
    }
}
