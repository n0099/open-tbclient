package com.bun.miitmdid;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final c f52874b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f52875c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f52876d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f52877e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f52878f;

    /* renamed from: g  reason: collision with root package name */
    public static final c f52879g;

    /* renamed from: h  reason: collision with root package name */
    public static final c f52880h;

    /* renamed from: i  reason: collision with root package name */
    public static final c f52881i;

    /* renamed from: j  reason: collision with root package name */
    public static final c f52882j;
    public static final c k;
    public static final c l;
    public static final c m;
    public static final c n;
    public static final c o;
    public static final c p;
    public static final c q;
    public static final c r;
    public static final c s;
    public static final c t;
    public static final /* synthetic */ c[] u;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2134063392, "Lcom/bun/miitmdid/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2134063392, "Lcom/bun/miitmdid/c;");
                return;
            }
        }
        c cVar = new c("UNSUPPORT", 0, -1, "unsupport");
        f52874b = cVar;
        c cVar2 = new c("HUAWEI", 1, 0, "HUAWEI");
        f52875c = cVar2;
        c cVar3 = new c("XIAOMI", 2, 1, "Xiaomi");
        f52876d = cVar3;
        c cVar4 = new c("VIVO", 3, 2, RomUtils.MANUFACTURER_VIVO);
        f52877e = cVar4;
        c cVar5 = new c("OPPO", 4, 3, RomUtils.MANUFACTURER_OPPO);
        f52878f = cVar5;
        c cVar6 = new c("MOTO", 5, 4, "motorola");
        f52879g = cVar6;
        c cVar7 = new c("LENOVO", 6, 5, "lenovo");
        f52880h = cVar7;
        c cVar8 = new c("ASUS", 7, 6, "asus");
        f52881i = cVar8;
        c cVar9 = new c(com.kuaishou.weapon.un.g.f55062j, 8, 7, ManufacturerUtils.SAMSUNG);
        f52882j = cVar9;
        c cVar10 = new c("MEIZU", 9, 8, "meizu");
        k = cVar10;
        c cVar11 = new c(RomUtils.ROM_NUBIA, 10, 10, "nubia");
        l = cVar11;
        c cVar12 = new c("ZTE", 11, 11, "ZTE");
        m = cVar12;
        c cVar13 = new c(RomTypeUtil.ROM_ONEPLUS, 12, 12, com.kuaishou.weapon.un.g.f55061i);
        n = cVar13;
        c cVar14 = new c("BLACKSHARK", 13, 13, "blackshark");
        o = cVar14;
        c cVar15 = new c("FREEMEOS", 14, 30, "freemeos");
        p = cVar15;
        c cVar16 = new c("PRIZE", 15, 32, "prize");
        q = cVar16;
        c cVar17 = new c("REALME", 16, 33, "realme");
        r = cVar17;
        c cVar18 = new c("HONOR", 17, 34, "honor");
        s = cVar18;
        c cVar19 = new c("COOLPAD", 18, 35, "coolpad");
        t = cVar19;
        u = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9, cVar10, cVar11, cVar12, cVar13, cVar14, cVar15, cVar16, cVar17, cVar18, cVar19};
    }

    public c(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str2;
    }

    public static c a(String str) {
        InterceptResult invokeL;
        c[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return f52874b;
            }
            for (c cVar : values()) {
                if (cVar.a.equalsIgnoreCase(str)) {
                    return cVar;
                }
            }
            return f52874b;
        }
        return (c) invokeL.objValue;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (c[]) u.clone() : (c[]) invokeV.objValue;
    }
}
