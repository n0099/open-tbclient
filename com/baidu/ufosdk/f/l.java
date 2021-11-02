package com.baidu.ufosdk.f;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.material.internal.ManufacturerUtils;
/* loaded from: classes10.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f56697a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2041467517, "Lcom/baidu/ufosdk/f/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2041467517, "Lcom/baidu/ufosdk/f/l;");
        }
    }

    public static int a() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f56697a == 0) {
                String str = Build.MODEL;
                String str2 = Build.MANUFACTURER;
                String str3 = Build.BRAND;
                if (str != null) {
                    str = str.toLowerCase();
                }
                if (str2 != null) {
                    str2 = str2.toLowerCase();
                }
                if (str3 != null) {
                    str3 = str3.toLowerCase();
                }
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    if (str.contains(RomUtils.MANUFACTURER_XIAOMI) || str2.contains(RomUtils.MANUFACTURER_XIAOMI) || str3.contains(RomUtils.MANUFACTURER_XIAOMI)) {
                        i2 = 2;
                    } else if (str.contains(ManufacturerUtils.SAMSUNG) || str2.contains(ManufacturerUtils.SAMSUNG) || str3.contains(ManufacturerUtils.SAMSUNG)) {
                        i2 = 3;
                    } else if (str.contains(RomUtils.MANUFACTURER_HUAWEI) || str2.contains(RomUtils.MANUFACTURER_HUAWEI) || str3.contains(RomUtils.MANUFACTURER_HUAWEI)) {
                        i2 = 4;
                    } else if (str.contains(RomUtils.MANUFACTURER_VIVO) || str2.contains(RomUtils.MANUFACTURER_VIVO) || str3.contains(RomUtils.MANUFACTURER_VIVO)) {
                        i2 = 5;
                    } else if (str.contains(RomUtils.MANUFACTURER_OPPO) || str2.contains(RomUtils.MANUFACTURER_OPPO) || str3.contains(RomUtils.MANUFACTURER_OPPO)) {
                        i2 = 6;
                    } else if (str.contains("meizu") || str2.contains("meizu") || str3.contains("meizu")) {
                        i2 = 7;
                    }
                    f56697a = i2;
                }
                f56697a = 1;
            }
            return f56697a;
        }
        return invokeV.intValue;
    }
}
