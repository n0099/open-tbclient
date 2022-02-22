package com.baidu.webkit.internal;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ETAG implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EQUAL = "=";
    public static final String ITEM_SEPARATOR = "&";
    public static final String KEY_APP_ID = "appid";
    public static final String KEY_APP_VERSION = "appversion";
    public static final String KEY_BAIDU_ID = "baiduid";
    public static final String KEY_BD_USS = "bduss";
    public static final String KEY_BLOCKED_AD_COUNT = "blocked_ad_count";
    public static final String KEY_BROWSER_VERSION = "browserversion";
    public static final String KEY_BROWSING_COUNT = "browseing_count";
    public static final String KEY_B_TRAN_URL = "b_tran";
    public static final String KEY_CPU_TYPE = "cpu_type";
    public static final String KEY_CRONET_ENABLE = "cronet_enable";
    public static final String KEY_CRONET_NET_RES = "cronet_net_res";
    public static final String KEY_CRONET_NET_TIME = "cronet_net_time";
    public static final String KEY_CSS_LOADED = "css_loaded";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_DEBUG = "debug";
    public static final String KEY_DEV_PLAT = "dev_plat";
    public static final String KEY_DEV_VER = "dev_ver";
    public static final String KEY_DNS_INFO = "dns_ip";
    public static final String KEY_DNS_STATISTIC = "dns_stat";
    public static final String KEY_DOWN_TRAFFIC = "down_traffic";
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_EXTENSION = "extension";
    public static final String KEY_FEED_PROXY_AD = "feed_proxy_ad";
    public static final String KEY_FEED_VIDEO_PV_COUNT = "feed_video_pv";
    public static final String KEY_FIRST_JUMP_TYPE = "f_jump_type";
    public static final String KEY_FIRST_LAYOUT = "first_layout";
    public static final String KEY_FIRST_PAINT = "first_paint";
    public static final String KEY_FIRST_SCREEN = "first_screen";
    public static final String KEY_FREE_FLOW_ENABLE = "free_flow_enable";
    public static final String KEY_GPU_TYPE = "gpu_type";
    public static final String KEY_HN_COUNT = "history_counts";
    public static final String KEY_HTTP2_WORMHOLE = "http2_wormhole";
    public static final String KEY_HTTP_CODE = "http_code";
    public static final String KEY_HTTP_DNS_ENABLE = "http_dns";
    public static final String KEY_IS_MOBILE_SITE = "mobile_site";
    public static final String KEY_LAST_JUMP_TYPE = "l_jump_type";
    public static final String KEY_LOAD_STATISTICS = "load_statistics";
    public static final String KEY_LOCAL_DNS = "local_dns";
    public static final String KEY_MAINLINK_DIRECT = "mainlink_direct";
    public static final String KEY_MODEL = "model";
    public static final String KEY_NETWORK_RTT = "network_rtt";
    public static final String KEY_NETWORK_SPEED = "network_speed";
    public static final String KEY_NET_APN = "net_apn";
    public static final String KEY_NET_CODE = "net_code";
    public static final String KEY_NET_ERROR = "net_error";
    public static final String KEY_NET_TYPE = "net_type";
    public static final String KEY_ONE_PACKET = "one_packet";
    public static final String KEY_PACKAGE_NAME = "package_name";
    public static final String KEY_PAGE_FINISHED = "page_finished";
    public static final String KEY_PAGE_START = "page_start";
    public static final String KEY_PARSED_TOKENS = "parsed_tokens";
    public static final String KEY_PC_COUNT = "pagecache_counts";
    public static final String KEY_QUIC_ENABLED = "quic_enabled";
    public static final String KEY_QUIC_HOST = "quic_host";
    public static final String KEY_QUIC_THRESHOLD = "quic_threshold";
    public static final String KEY_RECEIVED_DATA = "received_data";
    public static final String KEY_SDK_VER = "sdk_ver";
    public static final String KEY_SEARCH_ID = "searchid";
    public static final String KEY_SEND_REQUEST = "send_request";
    public static final String KEY_SESSION_HEADER = "session_header";
    public static final String KEY_SPDY = "spdy";
    public static final String KEY_SPDY31 = "spdy31";
    public static final String KEY_SPDY_COMPRESS = "compress";
    public static final String KEY_SPDY_ENCRYPTION = "spdy_encryption";
    public static final String KEY_SPDY_HOST = "spdy_host";
    public static final String KEY_STATISTICS_SEESIONID = "session_id";
    public static final String KEY_SUB_RESOURCE_ENABLE = "sub_res_enable";
    public static final String KEY_SYS_PROXY = "sys_proxy";
    public static final String KEY_TIME_STAMP = "time_stamp";
    public static final String KEY_UPLOAD_NUM = "upload_num";
    public static final String KEY_UP_TRAFFIC = "up_traffic";
    public static final String KEY_VIDEO_CORE_VERSION = "video_core";
    public static final String KEY_VIDEO_PV_COUNT = "video_pv";
    public static final String KEY_VIDEO_SDK_VERSION = "video_sdk";
    public static final String KEY_VIDEO_STATISTICS = "video_statistics";
    public static final String KEY_WEBESSENSE = "webessense";
    public static final String KEY_WEBKIT_BUILTIN = "webkit_builtin";
    public static final String KEY_WISE_LANDING_TYPE = "wise_landing_type";
    public static final String KEY_WORMHOLE_ENABLE = "wormhole_enable";
    public static final String KEY_ZEUS_STATE = "zeus_state";
    public static final String KEY_ZEUS_VER = "zeus_ver";
    public transient /* synthetic */ FieldHolder $fh;

    public ETAG() {
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
}
