package com.baidu.webkit.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes2.dex */
public final class NetWorkUtils implements INoProGuard {
    private static final int CELL_2G = 2;
    private static final int CELL_3G = 3;
    private static final int CELL_4G = 4;
    private static final int CELL_UNKNOWN = 1;
    private static final int CHINA_MOBILE = 1;
    private static final int CHINA_TELECOM = 2;
    private static final int CHINA_UNICOM = 3;
    private static final int CONNECTION_UNKNOWN = 0;
    private static final int ETHERNET = 101;
    private static final int NEW_TYPE = 999;
    private static final int OTHER_OPERATOR = 99;
    private static final int UNKNOWN_OPERATOR = 0;
    private static final int WIFI = 100;
    private static int sConnectionType = 0;
    private static int sOperatorType = 0;
    private static boolean sIsOnline = false;

    public static boolean getIsOnline() {
        return sIsOnline;
    }

    public static int getNetWorkType() {
        return sConnectionType;
    }

    public static int getOperatorType() {
        return sOperatorType;
    }

    @SuppressLint({"HardwareIds"})
    public static void onNetWorkChanged(Context context, NetworkInfo networkInfo) {
        String str;
        if (networkInfo == null) {
            sConnectionType = 0;
            sIsOnline = false;
        } else if (networkInfo.getState() != NetworkInfo.State.CONNECTED) {
            sConnectionType = 0;
            sIsOnline = false;
        } else {
            sIsOnline = true;
            if (networkInfo.getType() == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        sConnectionType = 2;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        sConnectionType = 3;
                        break;
                    case 13:
                        sConnectionType = 4;
                        break;
                    default:
                        sConnectionType = 1;
                        break;
                }
            } else if (networkInfo.getType() == 1) {
                sConnectionType = 100;
            } else if (networkInfo.getType() == 9) {
                sConnectionType = 101;
            } else {
                sConnectionType = 999;
            }
        }
        try {
        } catch (Throwable th) {
            sOperatorType = 99;
        }
        if (context == null) {
            sOperatorType = 99;
            return;
        }
        if (CommonUtils.checkPhonePermission(context)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
            if (telephonyManager == null) {
                return;
            }
            try {
                str = telephonyManager.getSubscriberId();
            } catch (SecurityException e) {
                sOperatorType = 99;
                str = null;
            }
            if (str != null) {
                if (str.startsWith("46000") || str.startsWith("46002")) {
                    sOperatorType = 1;
                } else if (str.startsWith("46001")) {
                    sOperatorType = 3;
                } else if (str.startsWith("46003")) {
                    sOperatorType = 2;
                } else {
                    sOperatorType = 99;
                }
            }
        }
        Log.d("linhua01", "network changed: " + sConnectionType + BaseRequestAction.SPLITE + sOperatorType);
    }
}
