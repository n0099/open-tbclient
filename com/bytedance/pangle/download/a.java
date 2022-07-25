package com.bytedance.pangle.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
/* loaded from: classes4.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.bytedance.pangle.download.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class EnumC0278a {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC0278a a;
        public static final EnumC0278a b;
        public static final EnumC0278a c;
        public static final EnumC0278a d;
        public static final EnumC0278a e;
        public static final EnumC0278a f;
        public static final EnumC0278a g;
        public static final /* synthetic */ EnumC0278a[] i;
        public transient /* synthetic */ FieldHolder $fh;
        public final int h;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2091513578, "Lcom/bytedance/pangle/download/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2091513578, "Lcom/bytedance/pangle/download/a$a;");
                    return;
                }
            }
            a = new EnumC0278a(RomUtils.UNKNOWN, 0, -1);
            b = new EnumC0278a(HlsPlaylistParser.METHOD_NONE, 1, 0);
            c = new EnumC0278a("MOBILE", 2, 1);
            d = new EnumC0278a("MOBILE_2G", 3, 2);
            e = new EnumC0278a("MOBILE_3G", 4, 3);
            f = new EnumC0278a("WIFI", 5, 4);
            EnumC0278a enumC0278a = new EnumC0278a("MOBILE_4G", 6, 5);
            g = enumC0278a;
            i = new EnumC0278a[]{a, b, c, d, e, f, enumC0278a};
        }

        public EnumC0278a(String str, int i2, int i3) {
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
            this.h = i3;
        }

        public static EnumC0278a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0278a) Enum.valueOf(EnumC0278a.class, str) : (EnumC0278a) invokeL.objValue;
        }

        public static EnumC0278a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0278a[]) i.clone() : (EnumC0278a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1012231117, "Lcom/bytedance/pangle/download/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1012231117, "Lcom/bytedance/pangle/download/a;");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static EnumC0278a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    int type = activeNetworkInfo.getType();
                    if (1 == type) {
                        return EnumC0278a.f;
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
                                return EnumC0278a.e;
                            case 4:
                            case 7:
                            case 11:
                            default:
                                return EnumC0278a.c;
                            case 13:
                                return EnumC0278a.g;
                        }
                    }
                    return EnumC0278a.c;
                }
                return EnumC0278a.b;
            } catch (Throwable unused) {
                return EnumC0278a.c;
            }
        }
        return (EnumC0278a) invokeL.objValue;
    }
}
