package com.baidu.wallet.core.beans;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class BeanConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String API_GET_FP = "/odp/wireless/sdk/init";
    public static final String API_HCE_QUERY_TRANSLIST = "/o2o/0/hce/0/trans_query/0";
    public static final String API_PAY_RESULT_CALLBACK_FOR_PHONECHARGE = "/ebbp/nologin/query/payresult/promotin";
    public static final String API_SEND_BFB_SMS = "/_u/wireless/send_sms/";
    public static final int AUTHLEVEL_CLIENT = 1;
    public static final int AUTHLEVEL_PUBLIC = 0;
    public static final int AUTHLEVEL_USER = 2;
    public static final String BANK_CREDIT = "credit";
    public static final String BANK_DEBIT = "debit";
    public static final String BANK_TYPE = "bank_type";
    public static final int BEAN_ID_FOR_NEW_INIT = 786;
    public static final int BEAN_ID_GET_FP = 530;
    public static String CHANNEL_ID = "tieba";
    public static final String CHANNEL_ID_BDMAP = "bdmap";
    public static final String CHANNEL_ID_BROWSER = "browser";
    public static final String CHANNEL_ID_HI = "hi";
    public static final String CHANNEL_ID_IQIYI = "iqiyi";
    public static final String CHANNEL_ID_KUANG = "baiduapp";
    public static final String CHANNEL_ID_LVYOU = "bdtravel";
    public static final String CHANNEL_ID_NAVI = "navi";
    public static final String CHANNEL_ID_NUOMI = "nuomi";
    public static final String CHANNEL_ID_NUOMI_LIAN = "bainuolian";
    public static final String CHANNEL_ID_SHOU_ZHU_YOU_XI = "shouzhuyouxi";
    public static final String CHANNEL_ID_SIMPLIFY = "simplify";
    public static final String CHANNEL_ID_TIE_BA = "tieba";
    public static final String CHANNEL_ID_WAIMAI = "waimai";
    public static final String CHANNEL_ID_WALLET_APP = "walletapp";
    public static final String CHANNEL_ID_WEISHI = "weishi";
    public static final String CHANNEL_ID_YIPINGTAI = "yipingtai";
    public static final String CHANNEL_ID_YUN = "bdcloud";
    public static final boolean DEBUG = false;
    public static final String DOMAIN_CHANGE_SWITCH_KEY = "wallet_sdk_domain_change_key";
    public static final String DOMAIN_CHANGE_SWITCH_NAME_ONLINE = "wallet_sdk_domain_change_name_online";
    public static final String DOMAIN_CHANGE_SWITCH_NAME_QA = "wallet_sdk_domain_change_name_qa";
    public static final String DOMAIN_CONFIG_KEY = "wallet_sdk_domain_config_key";
    public static final String DOMAIN_CONFIG_NAME_ONLINE = "wallet_sdk_domain_config_name_online";
    public static final String DOMAIN_CONFIG_NAME_QA = "wallet_sdk_domain_config_name_qa";
    public static boolean ENABLE_SAFE_KEYBOARD = false;
    public static final String ENCODE_GBK = "gbk";
    public static final String ENCODE_UTF_8 = "UTF-8";
    public static final String EV_BEAN_EXECUT_ERR_CONTENT = "ev_bean_execut_err_content";
    public static final String EV_LOGIN_SUCCESS = "ev_login_seccuss";
    public static final boolean FLAG_SECURE_SWITCH = true;
    public static final int HAS_MOBILE_PASSWORD_FALSE = 0;
    public static final int HAS_MOBILE_PASSWORD_TRUE = 1;
    public static final String HTTP_REQUEST_TYPE_PAY_BEAN = "pay bean http request";
    public static final String HTTP_REQUEST_TYPE_UPLOAD_BEAN = "upload bean http request";
    public static final boolean IS_SEARCHBOX_PLUGIN = false;
    public static final String KEY_CREATE_TIME_STAMP = "createTime";
    public static final String KEY_HAS_NEW_BALANCE = "hasNewBalance";
    public static final String KEY_LOGIN_TYPE = "login_type";
    public static final String KEY_PASSPORT_LOGIN = "login";
    public static final String KEY_PASSPORT_REG = "reg";
    public static final String KEY_TOEKN_VALUE = "token_value";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_TOKEN_TYPE = "token_type";
    public static final int METHOD_HTTP_GET = 0;
    public static final int METHOD_HTTP_POST = 1;
    public static final boolean MONKEY = false;
    public static final String PREFERENCES_HOME_TAB = "_home_tab_preference";
    public static final String PREFERENCES_NAME = "com.baidu.wallet.preferences_name";
    public static final String REQUEST_ID_TRANSFER = "request_id_transfer";
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    public static String SDK_VERSION = "";
    public static String VERSION_NO = "8.8.1.47";
    public static final String WEB_VIEW_CACHE_TAG = "WebViewCacheManager";
    public static boolean needActAnimation = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-55283088, "Lcom/baidu/wallet/core/beans/BeanConstants;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-55283088, "Lcom/baidu/wallet/core/beans/BeanConstants;");
        }
    }

    public BeanConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }
}
