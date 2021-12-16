package com.baidu.wallet.lightapp.base.statistics;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes13.dex */
public final class LightAppStatEvent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CALL_NATIVE_VOICE_SUCCESS = "#call_native_voice_success";
    public static final String EVENT_TYPE = "type";
    public static final String H5_NOT_LOGGED_IN_SDKHAS_LOGGED = "#H5NotLoggedIn_SDKHasLogged";
    public static final String JS_FILE_VERIFY_FAILED = "JSFileVerifyFailed";
    public static final String LIGHT_APP_BEGIN_LOAD = "#Light_App_Begin_Load";
    public static final String LIGHT_APP_BROWSER_FRAGMENT_SSL_ERROR = "#light_app_browser_fragment_ssl_error";
    public static final String LIGHT_APP_END_lOAD = "#Light_App_End_Load";
    public static final String LIGHT_APP_EVENTID_BACK = "Light_App_Back";
    public static final String LIGHT_APP_EVENTID_CALL_CAMERA = "#callCamera";
    public static final String LIGHT_APP_EVENTID_CALL_SHARE = "#callShare";
    public static final String LIGHT_APP_EVENTID_CALL_SHARE_FAIL = "#callShareFail";
    public static final String LIGHT_APP_EVENTID_CLOSE = "Light_App_Close";
    public static final String LIGHT_APP_EVENTID_CLOSE_WINDOW = "#closeWindow";
    public static final String LIGHT_APP_EVENTID_GET_CURRENT_POS = "#getCurrentPosition";
    public static final String LIGHT_APP_EVENTID_GET_CURRENT_POS_FAIL = "#getCurrentPositionFail";
    public static final String LIGHT_APP_EVENTID_GET_CURRENT_POS_NO_PERMISSION = "#getCurrentPositionNoPermission";
    public static final String LIGHT_APP_EVENTID_GET_DEVICE_INFO = "#getDeviceInfo";
    public static final String LIGHT_APP_EVENTID_GET_SHARE = "#callShare";
    public static final String LIGHT_APP_EVENTID_LOAD = "#Light_App_Load";
    public static final String LIGHT_APP_EVENTID_REFRESH = "Light_App_Refrash";
    public static final String LIGHT_APP_EVENTID_SELECT_ADDRESSBOOK_FAIL = "#selectPhonefromAdressBookFail";
    public static final String LIGHT_APP_EVENTID_SELECT_PHONE_FROM_ADDRESSBOOK = "#selectPhonefromAdressBook";
    public static final String LIGHT_APP_FILE_CHOOSER_INTENT_FAIL = "#file_chooser_intent_invalid";
    public static final String LIGHT_APP_INPUT_FILE = "#light_app_input_file";
    public static final String LIGHT_APP_INSERT_CALENDAR_NOT_AVAILABLE = "#insert_calendar_not_available";
    public static final String LIGHT_APP_NOT_HTTPS_URL = "#notHttpsUrl";
    public static final String LIGHT_APP_NOT_INTERNAL_URL = "#notInternalUr";
    public static final String LIGHT_APP_VIEW_CALENDAR_NOT_AVAILABLE = "#view_calendar_not_available";
    public static final String LIGHT_APP_WEBVIEW_CONSOLE_ERROR = "#webview_console_error";
    public static final String LIGHT_APP_WEBVIEW_ERROR = "#webview_error";
    public static final String LIGHT_APP_WEBVIEW_SHOW_ERROR = "#webview_show_error";
    public static final String LIGHT_APP_WHITE_SCREEN = "White_Screen_Detected";
    public static final String LIGHT_APP_lOAD_FAIL = "#LightApp_Load_Failed";
    public static final String LIGHT_APP_lOAD_START = "#LightApp_Load_Start";
    public static final String LIGHT_INVOKE_BDWALLET_NATIVE = "#invokeBdWalletNative";
    public static final String LIGHT_INVOKE_BDWALLET_NATIVE_FAIL_EXCEPTION = "#invokeBdWalletNativeFailException";
    public static final String LIGHT_INVOKE_BDWALLET_NATIVE_FAIL_NO_METHOD_NAME = "#invokeBdWalletNativeFailNoMethodName";
    public static final String LIGHT_INVOKE_BDWALLET_NATIVE_FAIL_OPTIONS_NULL = "#invokeBdWalletNativeFailOptionsNull";
    public static final String LIGHT_INVOKE_BDWALLET_NATIVE_INVALID_JS_FUNS = "invalid_js_funs";
    public static final String LIGHT_INVOKE_METHOD_NOT_SUPPORT = "#LightAppMethodNotSupported";
    public static final String METHOD_INVOKE_BD_WALLET_NATIVE_FAIL = "#invokeBdWalletNativeFail";
    public static final String METHOD_INVOKE_BD_WALLET_NATIVE_SUCCESS = "#invokeBdWalletNativeSuccess";
    public static final String MTD_CALL_NATIVE_PHOTO_MULTI_RESULT = "#call_native_photo_multi_result";
    public static final String OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED = "offlinecache_download_jshook_file_failed";
    public static final String PAGE_URL = "pageUrl";
    public static final String WEB_VIEW_CONSOLE = "WebViewConsole";
    public static final String WEB_VIEW_ERROR = "WebViewError";
    public static final String WEB_VIEW_HTTP_ERROR = "WebViewHttpError";
    public static final String WEB_VIEW_SSL_ERROR = "WebViewSslError";
    public transient /* synthetic */ FieldHolder $fh;

    public LightAppStatEvent() {
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
