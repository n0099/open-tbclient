package com.baidu.webkit.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.sdk.Log;
/* loaded from: classes11.dex */
public final class NetWorkUtils implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1519166567, "Lcom/baidu/webkit/internal/utils/NetWorkUtils;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1519166567, "Lcom/baidu/webkit/internal/utils/NetWorkUtils;");
        }
    }

    public NetWorkUtils() {
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

    public static void doNetworkConnectionChanged(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
        }
    }

    public static boolean getIsOnline() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? sIsOnline : invokeV.booleanValue;
    }

    public static boolean getNetTypeIsMobile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sNetTypeMobile : invokeV.booleanValue;
    }

    public static int getNetWorkType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? sConnectionType : invokeV.intValue;
    }

    public static int getOperatorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? sOperatorType : invokeV.intValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:3|(1:5)(2:47|(1:49)(7:51|(2:53|(5:55|57|9|10|(2:12|13)(5:15|(2:19|(1:21)(4:22|23|24|(3:26|(2:31|(1:33)(2:34|(1:36)(1:37)))|38)))|(1:42)|43|44))(1:62))(2:63|(1:65)(2:66|(1:68)(1:69)))|59|57|9|10|(0)(0)))|8|9|10|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0022, code lost:
        if (com.baidu.webkit.internal.utils.NetWorkUtils.sIsOnline == true) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00b9, code lost:
        com.baidu.webkit.internal.utils.NetWorkUtils.sOperatorType = 99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        if (com.baidu.webkit.internal.utils.NetWorkUtils.sIsOnline == true) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r7 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a A[Catch: all -> 0x00b9, TRY_ENTER, TryCatch #1 {all -> 0x00b9, blocks: (B:37:0x006a, B:39:0x006d, B:41:0x0071, B:43:0x0077, B:47:0x0083, B:51:0x008c, B:53:0x0094, B:56:0x009d, B:58:0x00a5, B:59:0x00a8, B:61:0x00b0, B:62:0x00b3, B:63:0x00b6, B:49:0x0088), top: B:75:0x0068, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006d A[Catch: all -> 0x00b9, TryCatch #1 {all -> 0x00b9, blocks: (B:37:0x006a, B:39:0x006d, B:41:0x0071, B:43:0x0077, B:47:0x0083, B:51:0x008c, B:53:0x0094, B:56:0x009d, B:58:0x00a5, B:59:0x00a8, B:61:0x00b0, B:62:0x00b3, B:63:0x00b6, B:49:0x0088), top: B:75:0x0068, inners: #0 }] */
    @SuppressLint({"HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void onNetWorkChanged(Context context, NetworkInfo networkInfo) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(65543, null, context, networkInfo) != null) {
            return;
        }
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
                            i2 = 4;
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
                            str = telephonyManager.getSubscriberId();
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
                i2 = 5;
            } else {
                i2 = networkInfo.getType() == 1 ? 100 : networkInfo.getType() == 9 ? 101 : 999;
            }
            sConnectionType = i2;
            boolean z22 = z;
            if (context == null) {
            }
        }
        sIsOnline = false;
        if (context == null) {
        }
    }

    public static void setLaunchState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            sLaunchState = z;
        }
    }
}
