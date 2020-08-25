package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes19.dex */
public class VideoCloudSetting {
    private static final String DEFAULT_ERROR_LOG_CLOSE_ALL = "close_all";
    private static final String DEFAULT_ERROR_LOG_ENABLE_ALL = "enable_all";
    private static final int DEFAULT_VIDEO_FORMAT_COLLECT_PERCENT_VALUE = 0;
    private static final long HOUR_MILLISECOND = 3600000;
    public static final String PREF_KEY_BLACK_DEVICE_LIST = "video_black_devices_list_for_hardware_decoder";
    public static final String PREF_KEY_CYBER_CORE_VERSION = "video_cyber_core_version";
    public static final String PREF_KEY_CYBER_FEED_PLAY_COUNT = "cyber_feed_play_count";
    public static final String PREF_KEY_CYBER_PLAY_COUNT = "cyber_play_count";
    public static final String PREF_KEY_CYBER_PREDOWNLOAD_ENABLE_VERSION = "video_pre_down_enable_ver";
    public static final String PREF_KEY_CYBER_SDK_VERSION = "video_cyber_sdk_version";
    public static final String PREF_KEY_DECODE_MODE = "video_decode_mode";
    public static final String PREF_KEY_DELETE_VIDEO_CACHE_INTERVAL = "delete_video_cache_interval";
    public static final String PREF_KEY_ENABLE_CYBER_VERSION = "video_error_log_cyber_version";
    public static final String PREF_KEY_ENABLE_HOST = "video_error_log_enable_host";
    public static final String PREF_KEY_FILE_CACHE_ENABLE = "video_file_cache_enable";
    public static final String PREF_KEY_MINIMUM_FREE_SPACE = "minimum_free_space";
    public static final String PREF_KEY_MP4_WHITE_DEVICE_LIST = "video_hw_mp4_white_devces_list";
    public static final String PREF_KEY_PCDN_FORBIDDEN = "pcdn_forbidden";
    public static final String PREF_KEY_SESSION_LOG_COLLECT_PERCENT = "session_log_collect_percent";
    public static final String PREF_KEY_SPRING_FESTIVAL_SWITCH = "spring_festival_switch";
    public static final String PREF_KEY_VIDEO_BLACK_URL_LIST_FOR_FILE_CACHE = "video_black_url_list_for_file_cache";
    public static final String PREF_KEY_VIDEO_CACHE_SIZE = "video_cache_size";
    public static final String PREF_KEY_VIDEO_FORMAT_COLLECT_PERCENT = "video_fmt_c_p";
    public static final String PREF_KEY_VIDEO_LAST_UPLAOD_DAY = "video_error_log_last_upload_day";
    public static final String PREF_KEY_VIDEO_LOG_HW_DECODER_EXCEPTION_ENABLE = "video_log_hw_decoder_exception_enable";
    public static final String PREF_KEY_ZEUS_VIDEO_PRELOAD_ENABLE_VERSION = "video_zeus_preload_enable_ver";
    public static final String PREF_NAME = "video_cfg_";
    private static final int SETTING_CYBER_VERSION = 0;
    private static final int SETTING_HOST = 1;
    public static final String TAG = "VideoCloudSettings";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public enum MatchedType {
        FAILED,
        AND_NEED_CHECK_NEXT,
        OR_NEED_CHECK_NEXT,
        SUCCESS
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class VideoCloudSettingItem {
        public boolean mIsCloseAll;
        public boolean mIsEnableAll;
        public int mType;
        public String[] mSubItems = null;
        public boolean mIsAdd = true;

        private boolean illegibilityMatch(String str, String str2, String str3, String str4) {
            String[] split = str.split(str3);
            String[] split2 = str2.split(str3);
            if (split.length != split2.length) {
                return false;
            }
            int length = split.length;
            for (int i = 0; i < length; i++) {
                if (TextUtils.isEmpty(split[i]) || TextUtils.isEmpty(split2[i])) {
                    if (!TextUtils.isEmpty(split2[i]) || !TextUtils.isEmpty(split[i])) {
                        return false;
                    }
                } else if (!split2[i].equals(str4) && !split2[i].equals(split[i])) {
                    return false;
                }
            }
            return true;
        }

        private boolean parseLogicalSymbol(String str) {
            return TextUtils.isEmpty(str) || !str.toLowerCase().equals("or");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseSettingItem(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_CLOSE_ALL)) {
                this.mIsCloseAll = true;
                this.mIsEnableAll = false;
            } else if (str.equals(VideoCloudSetting.DEFAULT_ERROR_LOG_ENABLE_ALL)) {
                this.mIsEnableAll = true;
                this.mIsCloseAll = false;
            } else if (!str.contains(str2)) {
                this.mSubItems = parseSubItems(str, str3);
            } else {
                if (str2.endsWith("|")) {
                    str2 = EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR;
                }
                String[] split = str.split(str2);
                if (split.length == 2) {
                    this.mSubItems = parseSubItems(split[0], str3);
                    this.mIsAdd = parseLogicalSymbol(split[1]);
                }
            }
        }

        private String[] parseSubItems(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (str.contains(str2)) {
                    String[] split = str.split(str2);
                    int length = split.length;
                    for (int i = 0; i < length; i++) {
                        if (TextUtils.isEmpty(split[i])) {
                            split[i] = null;
                        }
                    }
                    return split;
                } else if (!TextUtils.isEmpty(str)) {
                    return new String[]{str};
                }
            }
            return null;
        }

        public boolean find(String str) {
            if (this.mIsEnableAll) {
                return true;
            }
            if (!TextUtils.isEmpty(str) && this.mSubItems != null) {
                int length = this.mSubItems.length;
                for (int i = 0; i < length; i++) {
                    if (str.equals(this.mSubItems[i])) {
                        return true;
                    }
                    if (this.mType == 0 && illegibilityMatch(str, this.mSubItems[i], "\\.", "*")) {
                        return true;
                    }
                }
            }
            return false;
        }

        public MatchedType match(String str) {
            if (this.mIsCloseAll) {
                return MatchedType.FAILED;
            }
            boolean find = find(str);
            return this.mIsAdd ? find ? MatchedType.AND_NEED_CHECK_NEXT : MatchedType.FAILED : find ? MatchedType.SUCCESS : MatchedType.OR_NEED_CHECK_NEXT;
        }

        public void print() {
            Log.d(VideoCloudSetting.TAG, "print =start= mType:" + this.mType);
            Log.d(VideoCloudSetting.TAG, "print mIsEnableAll:" + this.mIsEnableAll + " mIsCloseAll:" + this.mIsCloseAll + " isAdd:" + this.mIsAdd);
            if (this.mSubItems != null) {
                int length = this.mSubItems.length;
                for (int i = 0; i < length; i++) {
                    Log.d(VideoCloudSetting.TAG, "mSubItems: [" + i + "] = " + this.mSubItems[i]);
                }
            }
        }

        public void setType(int i) {
            this.mType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes19.dex */
    public static class VideoSettings {
        private SparseArray<VideoCloudSettingItem> mItems = new SparseArray<>();

        public boolean canErrorLogUpload(String str) {
            MatchedType matchedType;
            String str2;
            boolean z = false;
            boolean z2 = true;
            MatchedType matchedType2 = MatchedType.FAILED;
            int i = 0;
            while (true) {
                if (i >= this.mItems.size()) {
                    matchedType = matchedType2;
                    break;
                }
                VideoCloudSettingItem videoCloudSettingItem = this.mItems.get(i);
                if (videoCloudSettingItem.mType == 0) {
                    str2 = str;
                } else {
                    if (videoCloudSettingItem.mType == 1 && !videoCloudSettingItem.mIsCloseAll) {
                        videoCloudSettingItem.mIsEnableAll = true;
                    }
                    str2 = "";
                }
                matchedType = videoCloudSettingItem.match(str2);
                Log.d(VideoCloudSetting.TAG, "i:" + i + " type:" + videoCloudSettingItem.mType + " checkStr:" + str2 + " matchedType:" + matchedType);
                if (matchedType != MatchedType.SUCCESS) {
                    if (matchedType == MatchedType.FAILED) {
                        break;
                    }
                    i++;
                    matchedType2 = matchedType;
                } else {
                    z = true;
                    break;
                }
            }
            if (matchedType == MatchedType.AND_NEED_CHECK_NEXT) {
                Log.d(VideoCloudSetting.TAG, "canErrorLogUpload AND_NEED_CHECK_NEXT");
            } else {
                z2 = z;
            }
            Log.d(VideoCloudSetting.TAG, "canErrorLogUpload canUpload:" + z2);
            return z2;
        }

        public SparseArray<VideoCloudSettingItem> getItems() {
            return this.mItems;
        }
    }

    public static boolean canUploadVideoErrorLog() {
        VideoSettings createVideoSetting;
        String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_SDK_VERSION, null);
        Log.d(TAG, "hasCyberSdkVersion called :" + videoCfgValue);
        if (TextUtils.isEmpty(videoCfgValue) || (createVideoSetting = createVideoSetting()) == null) {
            return false;
        }
        return createVideoSetting.canErrorLogUpload(videoCfgValue);
    }

    private static VideoSettings createVideoSetting() {
        String videoCfgValue = getVideoCfgValue(PREF_KEY_ENABLE_CYBER_VERSION, DEFAULT_ERROR_LOG_CLOSE_ALL);
        VideoCloudSettingItem videoCloudSettingItem = new VideoCloudSettingItem();
        videoCloudSettingItem.setType(0);
        if (TextUtils.isEmpty(videoCfgValue)) {
            videoCfgValue = DEFAULT_ERROR_LOG_CLOSE_ALL;
        }
        videoCloudSettingItem.parseSettingItem(videoCfgValue, "|", ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        String videoCfgValue2 = getVideoCfgValue(PREF_KEY_ENABLE_HOST, DEFAULT_ERROR_LOG_ENABLE_ALL);
        VideoCloudSettingItem videoCloudSettingItem2 = new VideoCloudSettingItem();
        videoCloudSettingItem2.setType(1);
        if (TextUtils.isEmpty(videoCfgValue2)) {
            videoCfgValue2 = DEFAULT_ERROR_LOG_ENABLE_ALL;
        }
        videoCloudSettingItem2.parseSettingItem(videoCfgValue2, "|", ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        Log.d(TAG, "createVideoSetting videoEnableSdkVersion:" + videoCfgValue + " hostsStr:" + videoCfgValue2);
        VideoSettings videoSettings = new VideoSettings();
        videoSettings.getItems().put(0, videoCloudSettingItem);
        videoSettings.getItems().put(1, videoCloudSettingItem2);
        return videoSettings;
    }

    private static String formatNowDate() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date(System.currentTimeMillis()));
    }

    public static String getCyberSdkVersion() {
        String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_SDK_VERSION, null);
        return TextUtils.isEmpty(videoCfgValue) ? "0" : videoCfgValue;
    }

    public static int getFeedVideoPvCount() {
        int i = 0;
        String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_FEED_PLAY_COUNT, null);
        Log.d(TAG, "getFeedVideoPvCount feedCountStr " + videoCfgValue);
        if (videoCfgValue != null) {
            try {
                i = Integer.parseInt(videoCfgValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "getFeedVideoPvCount count " + i);
        return i;
    }

    private static SharedPreferences getPrefs() {
        Context context = WebKitFactory.getContext();
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(PREF_NAME, 0);
    }

    public static String getVideoCfgValue(String str, String str2) {
        SharedPreferences prefs = getPrefs();
        if (prefs == null) {
            return null;
        }
        return prefs.getString(str, str2);
    }

    public static int getVideoPvCount() {
        int i = 0;
        String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_PLAY_COUNT, null);
        Log.d(TAG, "getVideoPvCount countStr " + videoCfgValue);
        if (videoCfgValue != null) {
            try {
                i = Integer.parseInt(videoCfgValue);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, "getVideoPvCount count " + i);
        return i;
    }

    public static boolean hasCyberSdkVersion() {
        return !TextUtils.isEmpty(getVideoCfgValue(PREF_KEY_CYBER_SDK_VERSION, null));
    }

    public static void initLastUploadDay() {
        if (TextUtils.isEmpty(getVideoCfgValue(PREF_KEY_VIDEO_LAST_UPLAOD_DAY, null))) {
            updateLastUploadTime();
        }
    }

    public static boolean isErrorLogTimePassedEnough() {
        String videoCfgValue = getVideoCfgValue(PREF_KEY_VIDEO_LAST_UPLAOD_DAY, null);
        if (TextUtils.isEmpty(videoCfgValue)) {
            return false;
        }
        String formatNowDate = formatNowDate();
        Log.d(TAG, "isErrorLogTimePassedEnough called nowDay:" + formatNowDate + " lastUploadDay:" + videoCfgValue);
        return !formatNowDate.equals(videoCfgValue);
    }

    public static void removeVideoCfgValue(String str) {
        SharedPreferences prefs = getPrefs();
        if (prefs == null) {
            return;
        }
        SharedPreferences.Editor edit = prefs.edit();
        edit.remove(str);
        edit.apply();
    }

    public static void saveVideoSettingToCfg() {
        String GetCloudSettingsValue = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_ENABLE_CYBER_VERSION);
        String GetCloudSettingsValue2 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_ENABLE_HOST);
        String GetCloudSettingsValue3 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_VIDEO_BLACK_URL_LIST_FOR_FILE_CACHE);
        String GetCloudSettingsValue4 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_DECODE_MODE);
        String GetCloudSettingsValue5 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_FILE_CACHE_ENABLE);
        String GetCloudSettingsValue6 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_BLACK_DEVICE_LIST);
        String GetCloudSettingsValue7 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_VIDEO_CACHE_SIZE);
        String GetCloudSettingsValue8 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_DELETE_VIDEO_CACHE_INTERVAL);
        String GetCloudSettingsValue9 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_MINIMUM_FREE_SPACE);
        String GetCloudSettingsValue10 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_VIDEO_LOG_HW_DECODER_EXCEPTION_ENABLE);
        String GetCloudSettingsValue11 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_MP4_WHITE_DEVICE_LIST);
        String GetCloudSettingsValue12 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_VIDEO_FORMAT_COLLECT_PERCENT);
        String GetCloudSettingsValue13 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_CYBER_PREDOWNLOAD_ENABLE_VERSION);
        String GetCloudSettingsValue14 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_ZEUS_VIDEO_PRELOAD_ENABLE_VERSION);
        String GetCloudSettingsValue15 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_SPRING_FESTIVAL_SWITCH);
        String GetCloudSettingsValue16 = WebSettingsGlobalBlink.GetCloudSettingsValue("pcdn_forbidden");
        String GetCloudSettingsValue17 = WebSettingsGlobalBlink.GetCloudSettingsValue(PREF_KEY_SESSION_LOG_COLLECT_PERCENT);
        Log.d(TAG, "saveVideoSettingToCfg logEnableCyberVersion:" + GetCloudSettingsValue + " logEnableHost:" + GetCloudSettingsValue2);
        Log.d(TAG, "VideoBlackUrlForFileCache = " + GetCloudSettingsValue3);
        Log.d(TAG, "videoBlackDevicesList = " + GetCloudSettingsValue6);
        Log.d(TAG, "videoCacheSize = " + GetCloudSettingsValue7);
        Log.d(TAG, "videoCacheInterval = " + GetCloudSettingsValue8);
        Log.d(TAG, "videoCacheFreeSpace = " + GetCloudSettingsValue9);
        Log.d(TAG, "videoLogHwDecoderExceptionEnable = " + GetCloudSettingsValue10);
        Log.d(TAG, "videoMp4DeviceWhiteList = " + GetCloudSettingsValue11);
        Log.d(TAG, "videoFormatCollectPercent = " + GetCloudSettingsValue12);
        Log.d(TAG, "springFestivalSwitch = " + GetCloudSettingsValue15);
        Log.d(TAG, "pcdnForbidden = " + GetCloudSettingsValue16);
        Log.d(TAG, "sessionLogCollectPercent = " + GetCloudSettingsValue17);
        if (GetCloudSettingsValue != null) {
            setVideoCfgValue(PREF_KEY_ENABLE_CYBER_VERSION, GetCloudSettingsValue);
        } else {
            Log.d(TAG, "saveVideoSettingToCfg remove PREF_KEY_ENABLE_CYBER_VERSION");
            removeVideoCfgValue(PREF_KEY_ENABLE_CYBER_VERSION);
        }
        if (GetCloudSettingsValue2 != null) {
            setVideoCfgValue(PREF_KEY_ENABLE_HOST, GetCloudSettingsValue2);
        } else {
            Log.d(TAG, "saveVideoSettingToCfg remove PREF_KEY_ENABLE_HOST");
            removeVideoCfgValue(PREF_KEY_ENABLE_HOST);
        }
        if (GetCloudSettingsValue4 != null) {
            setVideoCfgValue(PREF_KEY_DECODE_MODE, GetCloudSettingsValue4);
        } else {
            removeVideoCfgValue(PREF_KEY_DECODE_MODE);
        }
        if (GetCloudSettingsValue5 != null) {
            setVideoCfgValue(PREF_KEY_FILE_CACHE_ENABLE, GetCloudSettingsValue5);
        } else {
            removeVideoCfgValue(PREF_KEY_FILE_CACHE_ENABLE);
        }
        if (GetCloudSettingsValue3 != null) {
            setVideoCfgValue(PREF_KEY_VIDEO_BLACK_URL_LIST_FOR_FILE_CACHE, GetCloudSettingsValue3);
        } else {
            Log.d(TAG, "saveVideoSettingToCfg remove PREF_KEY_VIDEO_BLACK_URL_LIST");
            removeVideoCfgValue(PREF_KEY_VIDEO_BLACK_URL_LIST_FOR_FILE_CACHE);
        }
        if (GetCloudSettingsValue6 != null) {
            setVideoCfgValue(PREF_KEY_BLACK_DEVICE_LIST, GetCloudSettingsValue6);
        } else {
            removeVideoCfgValue(PREF_KEY_BLACK_DEVICE_LIST);
        }
        if (GetCloudSettingsValue7 != null) {
            setVideoCfgValue(PREF_KEY_VIDEO_CACHE_SIZE, GetCloudSettingsValue7);
        } else {
            removeVideoCfgValue(PREF_KEY_VIDEO_CACHE_SIZE);
        }
        if (GetCloudSettingsValue8 != null) {
            setVideoCfgValue(PREF_KEY_DELETE_VIDEO_CACHE_INTERVAL, GetCloudSettingsValue8);
        } else {
            removeVideoCfgValue(PREF_KEY_DELETE_VIDEO_CACHE_INTERVAL);
        }
        if (GetCloudSettingsValue9 != null) {
            setVideoCfgValue(PREF_KEY_MINIMUM_FREE_SPACE, GetCloudSettingsValue9);
        } else {
            removeVideoCfgValue(PREF_KEY_MINIMUM_FREE_SPACE);
        }
        if (GetCloudSettingsValue10 != null) {
            setVideoCfgValue(PREF_KEY_VIDEO_LOG_HW_DECODER_EXCEPTION_ENABLE, GetCloudSettingsValue10);
        } else {
            removeVideoCfgValue(PREF_KEY_VIDEO_LOG_HW_DECODER_EXCEPTION_ENABLE);
        }
        if (GetCloudSettingsValue11 != null) {
            setVideoCfgValue(PREF_KEY_MP4_WHITE_DEVICE_LIST, GetCloudSettingsValue11);
        } else {
            removeVideoCfgValue(PREF_KEY_MP4_WHITE_DEVICE_LIST);
        }
        if (GetCloudSettingsValue12 != null) {
            setVideoCfgValue(PREF_KEY_VIDEO_FORMAT_COLLECT_PERCENT, GetCloudSettingsValue12);
        } else {
            removeVideoCfgValue(PREF_KEY_VIDEO_FORMAT_COLLECT_PERCENT);
        }
        if (GetCloudSettingsValue13 != null) {
            setVideoCfgValue(PREF_KEY_CYBER_PREDOWNLOAD_ENABLE_VERSION, GetCloudSettingsValue13);
        } else {
            removeVideoCfgValue(PREF_KEY_CYBER_PREDOWNLOAD_ENABLE_VERSION);
        }
        if (GetCloudSettingsValue14 != null) {
            setVideoCfgValue(PREF_KEY_ZEUS_VIDEO_PRELOAD_ENABLE_VERSION, GetCloudSettingsValue14);
        } else {
            removeVideoCfgValue(PREF_KEY_ZEUS_VIDEO_PRELOAD_ENABLE_VERSION);
        }
        if (GetCloudSettingsValue15 != null) {
            setVideoCfgValue(PREF_KEY_SPRING_FESTIVAL_SWITCH, GetCloudSettingsValue15);
        } else {
            removeVideoCfgValue(PREF_KEY_SPRING_FESTIVAL_SWITCH);
        }
        if (GetCloudSettingsValue16 != null) {
            setVideoCfgValue("pcdn_forbidden", GetCloudSettingsValue16);
        } else {
            removeVideoCfgValue("pcdn_forbidden");
        }
        if (GetCloudSettingsValue17 != null) {
            setVideoCfgValue(PREF_KEY_SESSION_LOG_COLLECT_PERCENT, GetCloudSettingsValue17);
        } else {
            removeVideoCfgValue(PREF_KEY_SESSION_LOG_COLLECT_PERCENT);
        }
    }

    public static void setVideoCfgValue(String str, String str2) {
        SharedPreferences prefs = getPrefs();
        if (prefs == null) {
            return;
        }
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void updateLastUploadTime() {
        setVideoCfgValue(PREF_KEY_VIDEO_LAST_UPLAOD_DAY, formatNowDate());
    }
}
