package com.baidu.webkit.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes7.dex */
public final class NetWorkUtils implements INoProGuard {
    public static final int CELL_2G = 2;
    public static final int CELL_3G = 3;
    public static final int CELL_4G = 4;
    public static final int CELL_5G = 5;
    public static final int CELL_UNKNOWN = 1;
    public static final int CHINA_MOBILE = 1;
    public static final int CHINA_TELECOM = 2;
    public static final int CHINA_UNICOM = 3;
    public static final int CONNECTION_UNKNOWN = 0;
    public static final int ETHERNET = 101;
    public static final int NEW_TYPE = 999;
    public static final int OTHER_OPERATOR = 99;
    public static final int UNKNOWN_OPERATOR = 0;
    public static final int WIFI = 100;
    public static int sConnectionType = 0;
    public static boolean sIsOnline = true;
    public static boolean sLaunchState;
    public static boolean sNetTypeMobile;
    public static int sOperatorType;

    public static void doNetworkConnectionChanged(Context context) {
    }

    public static boolean getIsOnline() {
        return sIsOnline;
    }

    public static boolean getNetTypeIsMobile() {
        return sNetTypeMobile;
    }

    public static int getNetWorkType() {
        return sConnectionType;
    }

    public static int getOperatorType() {
        return sOperatorType;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(1:3)(2:45|(1:47)(7:49|(2:51|(5:53|55|7|8|(2:10|11)(5:13|(2:17|(1:19)(4:20|21|22|(3:24|(2:29|(1:31)(2:32|(1:34)(1:35)))|36)))|(1:40)|41|42))(1:60))(2:61|(1:63)(2:64|(1:66)(1:67)))|57|55|7|8|(0)(0)))|6|7|8|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (com.baidu.webkit.internal.utils.NetWorkUtils.sIsOnline == true) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (com.baidu.webkit.internal.utils.NetWorkUtils.sIsOnline == true) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b5, code lost:
        com.baidu.webkit.internal.utils.NetWorkUtils.sOperatorType = 99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        r7 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066 A[Catch: all -> 0x00b5, TRY_ENTER, TryCatch #1 {all -> 0x00b5, blocks: (B:35:0x0066, B:37:0x0069, B:39:0x006d, B:41:0x0073, B:45:0x007f, B:49:0x0088, B:51:0x0090, B:54:0x0099, B:56:0x00a1, B:57:0x00a4, B:59:0x00ac, B:60:0x00af, B:61:0x00b2, B:47:0x0084), top: B:70:0x0064, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069 A[Catch: all -> 0x00b5, TryCatch #1 {all -> 0x00b5, blocks: (B:35:0x0066, B:37:0x0069, B:39:0x006d, B:41:0x0073, B:45:0x007f, B:49:0x0088, B:51:0x0090, B:54:0x0099, B:56:0x00a1, B:57:0x00a4, B:59:0x00ac, B:60:0x00af, B:61:0x00b2, B:47:0x0084), top: B:70:0x0064, inners: #0 }] */
    @SuppressLint({"HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void onNetWorkChanged(Context context, NetworkInfo networkInfo) {
        int i;
        if (networkInfo == null) {
            sConnectionType = 0;
        } else if (networkInfo.getState() != NetworkInfo.State.CONNECTED) {
            sConnectionType = 0;
        } else {
            boolean z = !sIsOnline;
            sIsOnline = true;
            sNetTypeMobile = false;
            if (networkInfo.getType() == 0) {
                int subtype = networkInfo.getSubtype();
                sNetTypeMobile = true;
                if (subtype != 20) {
                    switch (subtype) {
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
                            i = 4;
                            break;
                        default:
                            sConnectionType = 1;
                            break;
                    }
                    boolean z2 = z;
                    if (context == null) {
                        sOperatorType = 99;
                        return;
                    }
                    if (sLaunchState && CommonUtils.checkPhonePermission(context)) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager == null) {
                            return;
                        }
                        String str = null;
                        try {
                            str = ApiReplaceUtil.getSubscriberId(telephonyManager);
                        } catch (SecurityException unused) {
                            sOperatorType = 99;
                        }
                        if (str != null) {
                            if (!str.startsWith("46000") && !str.startsWith("46002")) {
                                if (str.startsWith("46001")) {
                                    sOperatorType = 3;
                                } else if (str.startsWith("46003")) {
                                    sOperatorType = 2;
                                } else {
                                    sOperatorType = 99;
                                }
                            }
                            sOperatorType = 1;
                        }
                    }
                    if (z2) {
                        doNetworkConnectionChanged(context);
                    }
                    Log.d("linhua01", "network changed: " + sConnectionType + "_" + sOperatorType);
                    return;
                }
                i = 5;
            } else {
                i = networkInfo.getType() == 1 ? 100 : networkInfo.getType() == 9 ? 101 : 999;
            }
            sConnectionType = i;
            boolean z22 = z;
            if (context == null) {
            }
        }
        sIsOnline = false;
        if (context == null) {
        }
    }

    public static void setLaunchState(boolean z) {
        sLaunchState = z;
    }
}
