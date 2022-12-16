package com.baidu.webkit.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ConectivityUtils implements INoProGuard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String APN_3GNET = "3gnet";
    public static final String APN_3GWAP = "3gwap";
    public static final String APN_CMNET = "cmnet";
    public static final String APN_CMWAP = "cmwap";
    public static final String APN_CTNET = "ctnet";
    public static final String APN_CTWAP = "ctwap";
    public static final String APN_UNINET = "uninet";
    public static final String APN_UNIWAP = "uniwap";
    public static final String APN_UNKNOWN = "unknown";
    public static final String APN_WIFI = "wifi";
    public static final String LOG_TAG = "ConectivityUtils";
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_5G = "5g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    public static final Uri PREFERRED_APN_URI;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1318558460, "Lcom/baidu/webkit/internal/ConectivityUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1318558460, "Lcom/baidu/webkit/internal/ConectivityUtils;");
                return;
            }
        }
        PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
    }

    public ConectivityUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getNetType(Context context) {
        InterceptResult invokeL;
        Context applicationContext;
        ConnectivityManager connectivityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return "unknown";
            }
            try {
                applicationContext = context.getApplicationContext();
                connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (connectivityManager == null) {
                return "unknown";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo == null || !networkInfo.isConnected()) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                return (networkInfo2 == null || !networkInfo2.isConnected()) ? "unknown" : "wifi";
            } else if (isFastMobileNetwork(applicationContext)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                return telephonyManager.getNetworkType() == 13 ? "4g" : telephonyManager.getNetworkType() == 20 ? "5g" : "3g";
            } else {
                return "2g";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean isFastMobileNetwork(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            int networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
            if (networkType != 3 && networkType != 20 && networkType != 5 && networkType != 6) {
                switch (networkType) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        switch (networkType) {
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                                break;
                            default:
                                return false;
                        }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
