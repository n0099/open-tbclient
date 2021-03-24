package com.baidu.wallet.lightapp.base;

import com.baidu.apollon.NoProguard;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
/* loaded from: classes5.dex */
public class LightappConstants implements NoProguard {
    public static final String ACCESS_WALLET_SERVICE_PARAM_EXTRA = "serviceExtra";
    public static final String ACCESS_WALLET_SERVICE_PARAM_SERVICE = "serviceId";
    public static final int CALL_CAMERA_PARAM_CALL_ID_DETECT = 2;
    public static final int CALL_CAMERA_PARAM_CALL_SYSTEM = 1;
    public static final String CALL_CAMERA_PARAM_TYPE = "type";
    public static final String DO_BIND_CARD_PARAM_ORDER_INFO = "orderInfo";
    public static final String DO_BIND_CARD_PARAM_SHOW_DIALOG = "showDialog";
    public static final String DO_PAY_PARAM_ORDER_INFO = "orderInfo";
    public static final String DO_PAY_PARAM_SHOW_DIALOG = "showDialog";
    public static final String DO_RN_AUTH_PARAM_ORDER_INFO = "orderInfo";
    public static final String ERRCODE_ACTION_WITHOUT_RESULT = "10008";
    public static final String ERRCODE_CANCEL = "10005";
    public static final String ERRCODE_HOST_NOT_AUTHORITY = "10007";
    public static final String ERRCODE_INNER_ERROR = "10003";
    public static final String ERRCODE_INTENT_NOT_AVAILABLE = "10009";
    public static final String ERRCODE_INVALID_PARAMETER = "10001";
    public static final String ERRCODE_NOT_ALLOWED_BACKGROUND = "20001";
    public static final String ERRCODE_NOT_SUPPORT = "10004";
    public static final String ERRCODE_NO_PERMISSION = "10002";
    public static final String INIT_PAY_PARAM_INIT_PARAM = "initParam";
    public static final String LIGHTAPP_ERROR_CODE_NOT_IMPLEMENT = "10004";
    public static final String LIGHT_APP_NATIVE_INVOKER_FROM_URL = "from_url";
    public static final String LIGHT_APP_NATIVE_INVOKER_METHOD_NAME = "method_name";
    public static final String LIGHT_APP_NATIVE_INVOKER_MODULE_NAME = "module_name";
    public static final String METHOD_INVOKE_BD_WALLET_NATIVE = "invokeBdWalletNative";
    public static final String[] NATIVE_METHOD_LIST = {"selectPhonefromAdressBook", LightappBusinessClient.METHOD_GET_USER_AGENT, "getDeviceInfo", LightappJsNativeClient.METHOD_CLOSE_WINDOW, LightappJsNativeClient.METHOD_GET_CURRENT_POSITION, LightappJsNativeClient.METHOD_CALL_SHARE};
    public static final String ROUTER_INVOKE_FAIL = "router_invoke_fail";
}
