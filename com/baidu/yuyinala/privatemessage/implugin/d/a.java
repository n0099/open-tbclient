package com.baidu.yuyinala.privatemessage.implugin.d;

import android.text.TextUtils;
import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes4.dex */
public class a {
    private static String lVz = "";
    private static String oob = "";
    private static String ooc = "";
    private static String mDisplayName = "";

    public static String getBDUSS() {
        return SapiAccountManager.getInstance().getSession("bduss");
    }

    public static String ebF() {
        return SapiAccountManager.getInstance().getSession("uid");
    }

    public static String getDisplayName() {
        return TextUtils.isEmpty(mDisplayName) ? SapiAccountManager.getInstance().getSession(SapiAccountManager.SESSION_DISPLAYNAME) : mDisplayName;
    }
}
