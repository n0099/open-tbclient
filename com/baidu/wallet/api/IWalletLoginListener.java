package com.baidu.wallet.api;

import android.content.Context;
import java.util.Map;
/* loaded from: classes6.dex */
public interface IWalletLoginListener extends IWalletHostListener2 {
    public static final String KEY_LOGIN_TYPE = "loginType";
    @Deprecated
    public static final String KEY_PASS_BDUSS = "pass_bduss";
    public static final String KEY_PASS_DISPLAY_NAME = "pass_display_name";
    public static final String KEY_PASS_OPEN_BDUSS = "pass_open_bduss";
    public static final String KEY_PASS_STOKEN = "pass_stoken";
    public static final String KEY_PASS_UID = "pass_uid";
    public static final String KEY_PASS_UNION_ID = "pass_union_id";
    public static final String KEY_PASS_USER_NAEME = "pass_user_name";
    public static final int LOGIN_FAILED = -1;
    public static final int LOGIN_TYPE_ACCESS_TOKEN = 1;
    public static final int LOGIN_TYPE_BDUSS = 0;
    public static final int LOGIN_TYPE_OPEN_BDUSS = 2;
    public static final String LOGIN_TYPE_SMS = "sms";
    public static final int WALLET_ERROR_UNLOGIN = 5003;

    Map<String, String> getLoginData(String str);

    String getLoginStoken(String str);

    @Deprecated
    String getLoginToken();

    @Deprecated
    int getLoginType();

    void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener);

    void getOpenBduss(boolean z, ILoginBackListener iLoginBackListener, int i2);

    String getOpenLoginToken();

    void handlerWalletError(int i2);

    boolean isLogin();

    boolean isPassLogin();

    void onLoginChanaged(Context context, Map<String, String> map);
}
