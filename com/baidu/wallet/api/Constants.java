package com.baidu.wallet.api;

import com.baidu.wallet.core.beans.BeanConstants;
/* loaded from: classes5.dex */
public final class Constants {
    public static final String BDL_KEY_BANKINFO_EXTRA = "baidu.wallet.listbankcard.extra";
    public static final String BDL_KEY_BINDCARD_EXTRA = "baidu.wallet.bindcard.extra";
    public static final String BDL_KEY_BINDCATEGORY = "baidu.wallet.bindcard.category";
    public static final String BDL_KEY_BINDFORPWD = "baidu.wallet.bindcard.pwd";
    public static final String BDL_KEY_BIZTYPE = "baidu.wallet.lightapp.biztype";
    public static final String BDL_KEY_FROM = "baidu.wallet.from";
    public static final int BIZ_RN_AUTH = 12;
    public static final int BIZ_UNBIND_CARD = 11;
    public static final int CHECK_PWD_CANCLE = 2;
    public static final int CHECK_PWD_NO_PWD = 1;
    public static final int CHECK_PWD_OTHER_ERROR = 3;
    public static final int CHECK_PWD_SUCCESS = 0;
    public static final float DISABLE_ALPHA_VALUE = 0.4f;
    public static final String EVT_CLOSE = "QRScanCodeActivity.evt_close";
    public static final int FAILED = -1;
    public static final String HALF_SCREEN_PWD_VERIFY = "half_screen_pwd_verify";
    public static final String INTERFACE_ID_KEY = "interface_id";
    public static final String JUMP_URL = "jump_url";
    public static final String KEY_CREATE_TIME_STAMP = "createTime";
    public static final String KEY_HAS_NEW_BALANCE = "hasNewBalance";
    public static final String KEY_ORDERINFO_DESCARRAY = "orderInfoDescArray";
    public static final String KEY_OUTER_RESPONSE = "response_data";
    public static final String KEY_OUTER_SERVICEID = "service_id";
    public static final String KEY_REMOTE_APP_NAME = "key_remote_app_name";
    public static final String KEY_REMOTE_PKG_NAME = "key_remote_pkg_name";
    public static final String KEY_REMOTE_PKG_VER = "key_remote_pkg_ver";
    public static final String KEY_REMOTE_WHERE_TO_BACK = "key_remote_where_to_back";
    public static final String LONG_TITLE = "long_title";
    public static final String NO = "0";
    public static final String ONLY_ICONS = "only_icons";
    public static final String ORDERTYPE_FLAG = "order_type";
    public static final String ORDER_LIST_TITLE = "order_list_title";
    public static final int PAY_STATUS_CANCEL = 2;
    public static final int PAY_STATUS_ERROR = 6;
    public static final int PAY_STATUS_LOGIN_ERROR = 5;
    public static final int PAY_STATUS_NOSUPPORT = 3;
    public static final int PAY_STATUS_PAYING = 1;
    public static final int PAY_STATUS_SUCCESS = 0;
    public static final int PAY_STATUS_TOKEN_INVALID = 4;
    public static final int SUCCESS = 0;
    public static final String TOKEN_VALUE_KEY = "tokenValue";
    public static final String USER_TYPE_KEY = "userType";
    public static String WALLET_VERSION_NO = BeanConstants.VERSION_NO;
    public static final String YES = "1";

    /* loaded from: classes5.dex */
    public enum InterfaceId {
        init,
        startWallet,
        initWallet,
        doPay,
        doRemotePay,
        accessWalletService,
        lbsPayWallet,
        doNFCBusCardCharge,
        directCallThirdPay,
        walletScanCode,
        walletTraffic,
        walletBindCard
    }
}
