package com.baidu.ufosdk.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes13.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static TelephonyManager a;

    /* renamed from: b  reason: collision with root package name */
    public static ConnectivityManager f52072b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        NetworkInfo activeNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            String str = StringUtils.LF;
            StringBuilder sb = new StringBuilder();
            try {
                if (f52072b == null) {
                    f52072b = (ConnectivityManager) context.getSystemService("connectivity");
                }
                activeNetworkInfo = f52072b.getActiveNetworkInfo();
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName(), e2);
            }
            if (activeNetworkInfo == null) {
                com.baidu.ufosdk.f.c.d("NetworkCollector: Couldn't get NetworkInfo : " + context.getPackageName());
                return "N/A";
            }
            if (activeNetworkInfo.isConnected()) {
                sb.append("type: ");
                sb.append(activeNetworkInfo.getTypeName());
                sb.append(StringUtils.LF);
                if (activeNetworkInfo.getType() == 0) {
                    sb.append(" subType: ");
                    sb.append(activeNetworkInfo.getSubtypeName());
                    sb.append(StringUtils.LF);
                    if (a == null) {
                        a = (TelephonyManager) context.getSystemService("phone");
                    }
                    sb.append(" isRoaming: ");
                    sb.append(a.isNetworkRoaming() ? "yes" : "no");
                }
                return sb.toString();
            }
            str = "type: none\n";
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                if (f52072b == null) {
                    f52072b = (ConnectivityManager) context.getSystemService("connectivity");
                }
                NetworkInfo activeNetworkInfo = f52072b.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return !activeNetworkInfo.isConnected() ? PolyActivity.NONE_PANEL_TYPE : activeNetworkInfo.getTypeName().toUpperCase();
                }
                com.baidu.ufosdk.f.c.d("getNetworkType fail, getActiveNetworkInfo() is null.");
                return RomUtils.UNKNOWN;
            } catch (Exception e2) {
                com.baidu.ufosdk.f.c.a("getNetworkType fail,", e2);
                return RomUtils.UNKNOWN;
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String b2 = b(context);
            return (b2.contains(RomUtils.UNKNOWN) || b2.contains(PolyActivity.NONE_PANEL_TYPE)) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
