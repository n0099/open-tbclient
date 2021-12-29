package com.bytedance.pangle.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;

        /* renamed from: b  reason: collision with root package name */
        public static final a f55111b;

        /* renamed from: c  reason: collision with root package name */
        public static final a f55112c;

        /* renamed from: d  reason: collision with root package name */
        public static final a f55113d;

        /* renamed from: e  reason: collision with root package name */
        public static final a f55114e;

        /* renamed from: f  reason: collision with root package name */
        public static final a f55115f;

        /* renamed from: g  reason: collision with root package name */
        public static final a f55116g;

        /* renamed from: i  reason: collision with root package name */
        public static final /* synthetic */ a[] f55117i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final int f55118h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2091424205, "Lcom/bytedance/pangle/download/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2091424205, "Lcom/bytedance/pangle/download/d$a;");
                    return;
                }
            }
            a = new a(RomUtils.UNKNOWN, 0, -1);
            f55111b = new a(PolyActivity.NONE_PANEL_TYPE, 1, 0);
            f55112c = new a("MOBILE", 2, 1);
            f55113d = new a("MOBILE_2G", 3, 2);
            f55114e = new a("MOBILE_3G", 4, 3);
            f55115f = new a(CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING, 5, 4);
            a aVar = new a("MOBILE_4G", 6, 5);
            f55116g = aVar;
            f55117i = new a[]{a, f55111b, f55112c, f55113d, f55114e, f55115f, aVar};
        }

        public a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f55118h = i3;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f55117i.clone() : (a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1012231024, "Lcom/bytedance/pangle/download/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1012231024, "Lcom/bytedance/pangle/download/d;");
        }
    }

    public static boolean a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnected()) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"MissingPermission"})
    public static a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return a.f55115f;
                    }
                    if (type == 0) {
                        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return a.f55114e;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                return a.f55112c;
                            case 13:
                                return a.f55116g;
                        }
                    }
                    return a.f55112c;
                }
                return a.f55111b;
            } catch (Throwable unused) {
                return a.f55112c;
            }
        }
        return (a) invokeL.objValue;
    }
}
