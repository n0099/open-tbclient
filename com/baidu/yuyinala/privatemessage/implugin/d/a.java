package com.baidu.yuyinala.privatemessage.implugin.d;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes11.dex */
public class a {
    private static String mzU = "";
    private static String paD = "";
    private static String paE = "";
    private static String mDisplayName = "";

    public static String getBDUSS() {
        return SapiAccountManager.getInstance().getSession("bduss");
    }

    public static String ejT() {
        return SapiAccountManager.getInstance().getSession("uid");
    }

    public static String getDisplayName() {
        return TextUtils.isEmpty(mDisplayName) ? SapiAccountManager.getInstance().getSession(SapiAccountManager.SESSION_DISPLAYNAME) : mDisplayName;
    }
}
