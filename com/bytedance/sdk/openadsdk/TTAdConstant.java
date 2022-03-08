package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes7.dex */
public class TTAdConstant {
    public static final long AD_MAX_EVENT_TIME = 600000;
    public static final int AD_TYPE_COMMON_VIDEO = 0;
    public static final int AD_TYPE_LIVE = 3;
    public static final int AD_TYPE_PLAYABLE = 2;
    public static final int AD_TYPE_PLAYABLE_VIDEO = 1;
    public static final int AD_TYPE_UNKNOWN = -1;
    public static final String APP_NAME = "open_news";
    public static final String BRANCH = "v4000";
    public static final int BUILD_IN_MODULE_VERSION_CODE = 4022;
    public static final String BUILD_IN_MODULE_VERSION_NAME = "4.0.2.2";
    public static final String BUILT_IN_PLUGIN_NAME = "com.byted.pangle";
    public static final String C_H = "1559fe48f";
    public static final String DEFAULT_AUTO_TO_LIVE_REWARD_LIVE_TEXT = "5s后将为你自动打开抖音\n在抖音观看直播\n可提前5s获得奖励哦";
    public static final int DEFAULT_ENDCARD_CLOSE_TIME = -1;
    public static final int DEFAULT_LIVE_FANS = -1;
    public static final int DEFAULT_LIVE_SHOW_TIME = 60;
    public static final int DEFAULT_LIVE_SHOW_TIME_MAX = 300;
    public static final int DEFAULT_LIVE_SHOW_TIME_MINIMUM = 1;
    public static final int DEFAULT_LIVE_WATCH = -1;
    public static final int DEFAULT_PLAYABLE_CLOSE_TIME = -1;
    public static final int DEFAULT_REWARD_LIVE_STYLE = 1;
    public static final String DEFAULT_REWARD_LIVE_TEXT = "去抖音观看直播\n可提前5s获得奖励哦";
    public static final int DEFAULT_REWARD_LIVE_TYPE = 1;
    public static final int DEFAULT_REWARD_VIDEO_WATCHING = 100;
    public static final int DOWNLOAD_TYPE_NO_POPUP = 0;
    public static final int DOWNLOAD_TYPE_POPUP = 1;
    public static final int FALLBACK_TYPE_DOWNLOAD = 2;
    public static final int FALLBACK_TYPE_LANDING_PAGE = 1;
    public static final int FULL_INTERACTION_MARGIN = 20;
    public static final float FULL_INTERACTION_TYPE_DEFAULT = 100.0f;
    public static final int HORIZONTAL = 2;
    public static final int IMAGE_MODE_GROUP_IMG = 4;
    public static final int IMAGE_MODE_LARGE_IMG = 3;
    public static final int IMAGE_MODE_LIVE = 166;
    public static final int IMAGE_MODE_SMALL_IMG = 2;
    public static final int IMAGE_MODE_UNKNOWN = -1;
    public static final int IMAGE_MODE_VERTICAL_IMG = 16;
    public static final int IMAGE_MODE_VIDEO = 5;
    public static final int IMAGE_MODE_VIDEO_VERTICAL = 15;
    public static final int INTERACTION_TYPE_BROWSER = 2;
    public static final int INTERACTION_TYPE_DIAL = 5;
    public static final int INTERACTION_TYPE_DOWNLOAD = 4;
    public static final int INTERACTION_TYPE_LANDING_PAGE = 3;
    public static final int INTERACTION_TYPE_UNKNOWN = -1;
    public static final boolean IS_P = true;
    public static final String KEY_S_C = "_s_c";
    public static final Long LIVE_REWARD_TIME = 5000L;
    public static final String MULTI_PROCESS_DATA = "multi_process_data";
    public static final String MULTI_PROCESS_MATERIALMETA = "multi_process_materialmeta";
    public static final int NETWORK_STATE_2G = 2;
    public static final int NETWORK_STATE_3G = 3;
    public static final int NETWORK_STATE_4G = 5;
    public static final int NETWORK_STATE_5G = 6;
    public static final int NETWORK_STATE_MOBILE = 1;
    public static final int NETWORK_STATE_WIFI = 4;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final String PANGLE_INIT_START_TIME = "_pangle_init_start_time";
    public static final int PLAYABEL_DEFAULT_DURATION_TIME = 20;
    public static final int PLAYABLE_DEFAULT_ENDCARD_CLOSE_TIME = -1;
    public static final int PLAYABLE_DEFAULT_FULL_CLOSE_TIME = 5;
    public static final int PLAYABLE_DEFAULT_REWARD_CLOSE_TIME = 20;
    public static final int PLAYABLE_REWARD_TYPE = 0;
    public static final int PLAYABLE_REWARD_TYPE_NO = 1;
    public static final int PLUGIN_UPDATE = 2;
    public static final int PLUGIN_WIFI_UPDATE = 1;
    public static final int REQ_TYPE_LOAD = 3;
    public static final int REQ_TYPE_PRELOAD = 1;
    public static final int REQ_TYPE_SDK_PRELOAD = 2;
    public static final int REQ_TYPE_UNKNOWN = -1;
    public static final int REWARD_BROWSE_TYPE_LANDING = 1;
    public static final int REWARD_BROWSE_TYPE_MIX = 2;
    public static final int REWARD_BROWSE_TYPE_NO = 0;
    public static final int REWARD_LIVE_AUTO_POP_UPS_STYLE = 3;
    public static final int REWARD_LIVE_DIALOG_MIN_SHOW_TIME = 3;
    public static final int REWARD_LIVE_POP_UPS_STYLE = 2;
    public static final int REWARD_REWARD_CLOSE_TIME = 10;
    public static final int REWARD_REWARD_START_TIME = 5;
    public static final int REWARD_TO_LIVE_TYPE = 2;
    public static final int SDK_VERSION_CODE = 4022;
    public static final String SDK_VERSION_NAME = "4.0.2.2";
    public static final int SPLASH_BUTTON_TYPE_DOWNLOAD_BAR = 2;
    public static final int SPLASH_BUTTON_TYPE_FULL_SCREEN = 1;
    public static final int STYLE_SIZE_RADIO_16_9 = 1777;
    public static final int STYLE_SIZE_RADIO_1_1 = 1000;
    public static final int STYLE_SIZE_RADIO_2_3 = 666;
    public static final int STYLE_SIZE_RADIO_3_2 = 1500;
    public static final int STYLE_SIZE_RADIO_9_16 = 562;
    public static final float STYLE_SIZE_RADIO_FULL = 100.0f;
    public static final String S_C = "main";
    public static final String TAG = "TT_AD_SDK";
    public static final int TITLE_BAR_THEME_DARK = 1;
    public static final int TITLE_BAR_THEME_LIGHT = 0;
    public static final int TITLE_BAR_THEME_NO_TITLE_BAR = -1;
    public static final int VERTICAL = 1;
    public static final int VIDEO_CLOSE_COMPLETE = 4;
    public static final int VIDEO_CLOSE_FEED_CLICK_CLOSE = 1;
    public static final int VIDEO_CLOSE_FULL_REWARD_CLICK_SKIP = 2;
    public static final int VIDEO_CLOSE_FULL_REWARD_STUCK = 3;
    public static final int VIDEO_CLOSE_PLAYER_ERROR = 5;
    public static final int VIDEO_CLOSE_TIME_OUT = 6;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface DOWNLOAD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface NATIVE_AD_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface NETWORK_STATE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface ORIENTATION_STATE {
    }

    /* loaded from: classes7.dex */
    public enum RitScenes {
        CUSTOMIZE_SCENES("customize_scenes"),
        HOME_OPEN_BONUS("home_open_bonus"),
        HOME_SVIP_BONUS("home_svip_bonus"),
        HOME_GET_PROPS("home_get_props"),
        HOME_TRY_PROPS("home_try_props"),
        HOME_GET_BONUS("home_get_bonus"),
        HOME_GIFT_BONUS("home_gift_bonus"),
        GAME_START_BONUS("game_start_bonus"),
        GAME_REDUCE_WAITING("geme_reduce_waiting"),
        GAME_MORE_KLLKRTUNITIES(TTAdConstant.b("game_more_kllkrtunities")),
        GAME_FINISH_REWARDS("game_finish_rewards"),
        GAME_GIFT_BONUS("game_gift_bonus");
        
        public final String a;

        RitScenes(String str) {
            this.a = str;
        }

        public String getScenesName() {
            return this.a;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface SPLASH_BUTTON_TYPE {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface TITLE_BAR_THEME {
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", RomUtils.MANUFACTURER_OPPO) : "";
    }

    public static int getBuildInVersion() {
        return 4022;
    }
}
