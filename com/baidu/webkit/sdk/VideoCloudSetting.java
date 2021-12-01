package com.baidu.webkit.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import androidx.webkit.ProxyConfig;
import com.alipay.security.mobile.module.http.model.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes12.dex */
public class VideoCloudSetting {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_ERROR_LOG_CLOSE_ALL = "close_all";
    public static final String DEFAULT_ERROR_LOG_ENABLE_ALL = "enable_all";
    public static final int DEFAULT_VIDEO_FORMAT_COLLECT_PERCENT_VALUE = 0;
    public static final long HOUR_MILLISECOND = 3600000;
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
    public static final int SETTING_CYBER_VERSION = 0;
    public static final int SETTING_HOST = 1;
    public static final String TAG = "VideoCloudSettings";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes12.dex */
    public static final class MatchedType {
        public static final /* synthetic */ MatchedType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MatchedType AND_NEED_CHECK_NEXT;
        public static final MatchedType FAILED;
        public static final MatchedType OR_NEED_CHECK_NEXT;
        public static final MatchedType SUCCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1269103743, "Lcom/baidu/webkit/sdk/VideoCloudSetting$MatchedType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1269103743, "Lcom/baidu/webkit/sdk/VideoCloudSetting$MatchedType;");
                    return;
                }
            }
            FAILED = new MatchedType("FAILED", 0);
            AND_NEED_CHECK_NEXT = new MatchedType("AND_NEED_CHECK_NEXT", 1);
            OR_NEED_CHECK_NEXT = new MatchedType("OR_NEED_CHECK_NEXT", 2);
            MatchedType matchedType = new MatchedType(c.p, 3);
            SUCCESS = matchedType;
            $VALUES = new MatchedType[]{FAILED, AND_NEED_CHECK_NEXT, OR_NEED_CHECK_NEXT, matchedType};
        }

        public MatchedType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static MatchedType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MatchedType) Enum.valueOf(MatchedType.class, str) : (MatchedType) invokeL.objValue;
        }

        public static MatchedType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MatchedType[]) $VALUES.clone() : (MatchedType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes12.dex */
    public static class VideoCloudSettingItem {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsAdd;
        public boolean mIsCloseAll;
        public boolean mIsEnableAll;
        public String[] mSubItems;
        public int mType;

        public VideoCloudSettingItem() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSubItems = null;
            this.mIsAdd = true;
        }

        private boolean illegibilityMatch(String str, String str2, String str3, String str4) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, str, str2, str3, str4)) == null) {
                String[] split = str.split(str3);
                String[] split2 = str2.split(str3);
                if (split.length != split2.length) {
                    return false;
                }
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.isEmpty(split[i2]) || TextUtils.isEmpty(split2[i2])) {
                        if (!TextUtils.isEmpty(split2[i2]) || !TextUtils.isEmpty(split[i2])) {
                            return false;
                        }
                    } else if (!split2[i2].equals(str4) && !split2[i2].equals(split[i2])) {
                        return false;
                    }
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        private boolean parseLogicalSymbol(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? TextUtils.isEmpty(str) || !str.toLowerCase().equals("or") : invokeL.booleanValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void parseSettingItem(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, str, str2, str3) == null) || TextUtils.isEmpty(str)) {
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
                    str2 = "\\|";
                }
                String[] split = str.split(str2);
                if (split.length != 2) {
                    return;
                }
                this.mSubItems = parseSubItems(split[0], str3);
                this.mIsAdd = parseLogicalSymbol(split[1]);
            }
        }

        private String[] parseSubItems(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, str2)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                if (!str.contains(str2)) {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    return new String[]{str};
                }
                String[] split = str.split(str2);
                int length = split.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (TextUtils.isEmpty(split[i2])) {
                        split[i2] = null;
                    }
                }
                return split;
            }
            return (String[]) invokeLL.objValue;
        }

        public boolean find(String str) {
            InterceptResult invokeL;
            String[] strArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (this.mIsEnableAll) {
                    return true;
                }
                if (!TextUtils.isEmpty(str) && (strArr = this.mSubItems) != null) {
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (str.equals(this.mSubItems[i2]) || (this.mType == 0 && illegibilityMatch(str, this.mSubItems[i2], EmotionResourceInfo.VERSION_NAME_SEPARATOR_REGEX, ProxyConfig.MATCH_ALL_SCHEMES))) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public MatchedType match(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                if (this.mIsCloseAll) {
                    return MatchedType.FAILED;
                }
                boolean find = find(str);
                return this.mIsAdd ? find ? MatchedType.AND_NEED_CHECK_NEXT : MatchedType.FAILED : find ? MatchedType.SUCCESS : MatchedType.OR_NEED_CHECK_NEXT;
            }
            return (MatchedType) invokeL.objValue;
        }

        public void print() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Log.d(VideoCloudSetting.TAG, "print =start= mType:" + this.mType);
                Log.d(VideoCloudSetting.TAG, "print mIsEnableAll:" + this.mIsEnableAll + " mIsCloseAll:" + this.mIsCloseAll + " isAdd:" + this.mIsAdd);
                String[] strArr = this.mSubItems;
                if (strArr != null) {
                    int length = strArr.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        Log.d(VideoCloudSetting.TAG, "mSubItems: [" + i2 + "] = " + this.mSubItems[i2]);
                    }
                }
            }
        }

        public void setType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
                this.mType = i2;
            }
        }
    }

    /* loaded from: classes12.dex */
    public static class VideoSettings {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SparseArray<VideoCloudSettingItem> mItems;

        public VideoSettings() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mItems = new SparseArray<>();
        }

        public boolean canErrorLogUpload(String str) {
            InterceptResult invokeL;
            boolean z;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                MatchedType matchedType = MatchedType.FAILED;
                boolean z2 = false;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= this.mItems.size()) {
                        break;
                    }
                    VideoCloudSettingItem videoCloudSettingItem = this.mItems.get(i2);
                    int i3 = videoCloudSettingItem.mType;
                    if (i3 == 0) {
                        str2 = str;
                    } else {
                        if (i3 == 1 && !videoCloudSettingItem.mIsCloseAll) {
                            videoCloudSettingItem.mIsEnableAll = true;
                        }
                        str2 = "";
                    }
                    MatchedType match = videoCloudSettingItem.match(str2);
                    Log.d(VideoCloudSetting.TAG, "i:" + i2 + " type:" + videoCloudSettingItem.mType + " checkStr:" + str2 + " matchedType:" + match);
                    if (match == MatchedType.SUCCESS) {
                        matchedType = match;
                        z2 = true;
                        break;
                    } else if (match == MatchedType.FAILED) {
                        matchedType = match;
                        break;
                    } else {
                        i2++;
                        matchedType = match;
                    }
                }
                if (matchedType == MatchedType.AND_NEED_CHECK_NEXT) {
                    Log.d(VideoCloudSetting.TAG, "canErrorLogUpload AND_NEED_CHECK_NEXT");
                } else {
                    z = z2;
                }
                Log.d(VideoCloudSetting.TAG, "canErrorLogUpload canUpload:".concat(String.valueOf(z)));
                return z;
            }
            return invokeL.booleanValue;
        }

        public SparseArray<VideoCloudSettingItem> getItems() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mItems : (SparseArray) invokeV.objValue;
        }
    }

    public VideoCloudSetting() {
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

    public static boolean canUploadVideoErrorLog() {
        InterceptResult invokeV;
        VideoSettings createVideoSetting;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_SDK_VERSION, null);
            Log.d(TAG, "hasCyberSdkVersion called :".concat(String.valueOf(videoCfgValue)));
            if (TextUtils.isEmpty(videoCfgValue) || (createVideoSetting = createVideoSetting()) == null) {
                return false;
            }
            return createVideoSetting.canErrorLogUpload(videoCfgValue);
        }
        return invokeV.booleanValue;
    }

    public static VideoSettings createVideoSetting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = DEFAULT_ERROR_LOG_CLOSE_ALL;
            String videoCfgValue = getVideoCfgValue(PREF_KEY_ENABLE_CYBER_VERSION, DEFAULT_ERROR_LOG_CLOSE_ALL);
            VideoCloudSettingItem videoCloudSettingItem = new VideoCloudSettingItem();
            videoCloudSettingItem.setType(0);
            if (!TextUtils.isEmpty(videoCfgValue)) {
                str = videoCfgValue;
            }
            videoCloudSettingItem.parseSettingItem(str, "|", ";");
            String str2 = DEFAULT_ERROR_LOG_ENABLE_ALL;
            String videoCfgValue2 = getVideoCfgValue(PREF_KEY_ENABLE_HOST, DEFAULT_ERROR_LOG_ENABLE_ALL);
            VideoCloudSettingItem videoCloudSettingItem2 = new VideoCloudSettingItem();
            videoCloudSettingItem2.setType(1);
            if (!TextUtils.isEmpty(videoCfgValue2)) {
                str2 = videoCfgValue2;
            }
            videoCloudSettingItem2.parseSettingItem(str2, "|", ";");
            Log.d(TAG, "createVideoSetting videoEnableSdkVersion:" + str + " hostsStr:" + str2);
            VideoSettings videoSettings = new VideoSettings();
            videoSettings.getItems().put(0, videoCloudSettingItem);
            videoSettings.getItems().put(1, videoCloudSettingItem2);
            return videoSettings;
        }
        return (VideoSettings) invokeV.objValue;
    }

    public static String formatNowDate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())) : (String) invokeV.objValue;
    }

    public static String getCyberSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_SDK_VERSION, null);
            return TextUtils.isEmpty(videoCfgValue) ? "0" : videoCfgValue;
        }
        return (String) invokeV.objValue;
    }

    public static int getFeedVideoPvCount() {
        InterceptResult invokeV;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_FEED_PLAY_COUNT, null);
            Log.d(TAG, "getFeedVideoPvCount feedCountStr ".concat(String.valueOf(videoCfgValue)));
            if (videoCfgValue != null) {
                try {
                    parseInt = Integer.parseInt(videoCfgValue);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Log.d(TAG, "getFeedVideoPvCount count ".concat(String.valueOf(parseInt)));
                return parseInt;
            }
            parseInt = 0;
            Log.d(TAG, "getFeedVideoPvCount count ".concat(String.valueOf(parseInt)));
            return parseInt;
        }
        return invokeV.intValue;
    }

    public static SharedPreferences getPrefs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            Context context = WebKitFactory.getContext();
            if (context == null) {
                return null;
            }
            return context.getSharedPreferences(PREF_NAME, 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    public static String getVideoCfgValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, str2)) == null) {
            SharedPreferences prefs = getPrefs();
            if (prefs == null) {
                return null;
            }
            return prefs.getString(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public static int getVideoPvCount() {
        InterceptResult invokeV;
        int parseInt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String videoCfgValue = getVideoCfgValue(PREF_KEY_CYBER_PLAY_COUNT, null);
            Log.d(TAG, "getVideoPvCount countStr ".concat(String.valueOf(videoCfgValue)));
            if (videoCfgValue != null) {
                try {
                    parseInt = Integer.parseInt(videoCfgValue);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                Log.d(TAG, "getVideoPvCount count ".concat(String.valueOf(parseInt)));
                return parseInt;
            }
            parseInt = 0;
            Log.d(TAG, "getVideoPvCount count ".concat(String.valueOf(parseInt)));
            return parseInt;
        }
        return invokeV.intValue;
    }

    public static boolean hasCyberSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? !TextUtils.isEmpty(getVideoCfgValue(PREF_KEY_CYBER_SDK_VERSION, null)) : invokeV.booleanValue;
    }

    public static void initLastUploadDay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && TextUtils.isEmpty(getVideoCfgValue(PREF_KEY_VIDEO_LAST_UPLAOD_DAY, null))) {
            updateLastUploadTime();
        }
    }

    public static boolean isErrorLogTimePassedEnough() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            String videoCfgValue = getVideoCfgValue(PREF_KEY_VIDEO_LAST_UPLAOD_DAY, null);
            if (TextUtils.isEmpty(videoCfgValue)) {
                return false;
            }
            String formatNowDate = formatNowDate();
            Log.d(TAG, "isErrorLogTimePassedEnough called nowDay:" + formatNowDate + " lastUploadDay:" + videoCfgValue);
            return !formatNowDate.equals(videoCfgValue);
        }
        return invokeV.booleanValue;
    }

    public static void removeVideoCfgValue(String str) {
        SharedPreferences prefs;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, null, str) == null) || (prefs = getPrefs()) == null) {
            return;
        }
        SharedPreferences.Editor edit = prefs.edit();
        edit.remove(str);
        edit.apply();
    }

    public static void saveVideoSettingToCfg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
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
            Log.d(TAG, "VideoBlackUrlForFileCache = ".concat(String.valueOf(GetCloudSettingsValue3)));
            Log.d(TAG, "videoBlackDevicesList = ".concat(String.valueOf(GetCloudSettingsValue6)));
            Log.d(TAG, "videoCacheSize = ".concat(String.valueOf(GetCloudSettingsValue7)));
            Log.d(TAG, "videoCacheInterval = ".concat(String.valueOf(GetCloudSettingsValue8)));
            Log.d(TAG, "videoCacheFreeSpace = ".concat(String.valueOf(GetCloudSettingsValue9)));
            Log.d(TAG, "videoLogHwDecoderExceptionEnable = ".concat(String.valueOf(GetCloudSettingsValue10)));
            Log.d(TAG, "videoMp4DeviceWhiteList = ".concat(String.valueOf(GetCloudSettingsValue11)));
            Log.d(TAG, "videoFormatCollectPercent = ".concat(String.valueOf(GetCloudSettingsValue12)));
            Log.d(TAG, "springFestivalSwitch = ".concat(String.valueOf(GetCloudSettingsValue15)));
            Log.d(TAG, "pcdnForbidden = ".concat(String.valueOf(GetCloudSettingsValue16)));
            Log.d(TAG, "sessionLogCollectPercent = ".concat(String.valueOf(GetCloudSettingsValue17)));
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
    }

    public static void setVideoCfgValue(String str, String str2) {
        SharedPreferences prefs;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65550, null, str, str2) == null) || (prefs = getPrefs()) == null) {
            return;
        }
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void updateLastUploadTime() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            setVideoCfgValue(PREF_KEY_VIDEO_LAST_UPLAOD_DAY, formatNowDate());
        }
    }
}
