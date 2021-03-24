package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.domain.DomainConfig;
/* loaded from: classes5.dex */
public class ScanCodeConstant {
    public static final String API_CLOSE_SCANCODE = "/_u/o2o/b2c/close";
    public static final String API_CREATE_SCANCODE = "/o2o/0/b2c/0/create_code/0";
    public static final String API_OPEN_SCANCODE = "/_u/o2o/b2c/open";
    public static final String API_QUERY_SCANCODE_RESULT = "/o2o/0/b2c/0/query_trans_by_paycode/0";
    public static final String API_QUERY_SCANCODE_RESULT_PUSH = "/smf_sub";
    public static final String API_SCANCODE_CREATE_TOKEN = "/_u/otp/createo2otoken/";
    public static final String API_SCANCODE_PAY = "/_u/o2o/b2c/pay";
    public static final String API_SCANCODE_SEND_SMS_PAY = "/_u/o2o/b2c/send_sms";
    public static final int B_SAO_C_NORMAL_AUTH_SERVICE_TYPE = 1039;
    public static final int CHANGE_TO_ONLINE = 65235;
    public static final String EV_SCANCODE_REFRESH_CODE = "ev_scancode_refresh_code";
    public static final int INVALIDATE_OTP_TOKEN = 65312;
    public static final int LACKBALANCE = 20220;
    public static final int LACKBALANCE_NEW_VERSION = 60500;
    public static final int NEED_MOBILEPWD = 65237;
    public static final String NEED_ROLLPOLING_QUERY_RESULT = "2";
    public static final int NEED_VARIFY = 65242;
    public static final int NEED_VARIFY_1 = 65238;
    public static final int NONBINDCARDCODE = 65232;
    public static final int NONOPENSCANCODE = 65233;
    public static final String OPENSCANCODEKEY = "openScanCodeKey";
    public static final int OPEN_PROCESS_NEED_VARIFY = 65242;
    public static final int ORDERPAYINGCODE_NO_PHONE_NUM = 65226;
    public static final int ORDERPAYINGCODE_PWD = 65222;
    public static final int ORDERPAYINGCODE_PWD_SMS = 65225;
    public static final int ORDERPAYINGCODE_SMS = 65224;
    public static final String ORDER_INFO_KEY = "ORDER_INFO_KEY";
    public static final int OVER_LIMIT_BIND_CARD = 65243;
    public static final int OVER_LIMIT_III_NOT_BIND_CARD = 65240;
    public static final int OVER_LIMIT_NOT_BIND_CARD = 65241;
    public static final int PASSWORD1TIMESERRORCODE = 15414;
    public static final int PASSWORD2TIMESERRORCODE = 15432;
    public static final int PAYSUCESSCODE = 65215;
    public static final int QUERYSUCESS = 0;
    public static final int REAL_NAME_VERIFING = 65239;
    public static final String REFRESHEVENTKEY = "refreshEventkey";
    public static final String SCANCODEFROMKEY = "scancodefromkey";
    public static final int SCANCODE_SMS_CHECK_ERROR = 69563;
    public static final int SETTINGPWDCODE = 65231;
    public static final int UPDATE_KEY = 65316;

    public static String getScancodeHelpUrl(Context context) {
        return DomainConfig.getInstance().getAppPayHost() + "/content/mywallet/o2o/b2c/help.html?titlebar=no&sdk=yes";
    }

    public static String getScancodeRuleUrl(Context context) {
        return DebugConfig.getInstance().getFixedWalletHttpsHostForH5() + "/content/mywallet/o2o/b2c/rules.html?titlebar=no";
    }
}
