package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class ae {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ae f64665a;

    /* renamed from: b  reason: collision with root package name */
    public static final ae f64666b;

    /* renamed from: c  reason: collision with root package name */
    public static final ae f64667c;

    /* renamed from: d  reason: collision with root package name */
    public static final ae f64668d;

    /* renamed from: e  reason: collision with root package name */
    public static final ae f64669e;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ ae[] f64670g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final String f64671f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1197589528, "Lcom/bytedance/sdk/component/b/b/ae;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1197589528, "Lcom/bytedance/sdk/component/b/b/ae;");
                return;
            }
        }
        f64665a = new ae("TLS_1_3", 0, "TLSv1.3");
        f64666b = new ae("TLS_1_2", 1, "TLSv1.2");
        f64667c = new ae("TLS_1_1", 2, "TLSv1.1");
        f64668d = new ae("TLS_1_0", 3, "TLSv1");
        ae aeVar = new ae("SSL_3_0", 4, "SSLv3");
        f64669e = aeVar;
        f64670g = new ae[]{f64665a, f64666b, f64667c, f64668d, aeVar};
    }

    public ae(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f64671f = str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ae a(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 79201641) {
                if (str.equals("SSLv3")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else if (hashCode != 79923350) {
                switch (hashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
            } else {
                if (str.equals("TLSv1")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 == 4) {
                                return f64669e;
                            }
                            throw new IllegalArgumentException("Unexpected TLS version: " + str);
                        }
                        return f64668d;
                    }
                    return f64667c;
                }
                return f64666b;
            }
            return f64665a;
        }
        return (ae) invokeL.objValue;
    }

    public static ae valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (ae) Enum.valueOf(ae.class, str) : (ae) invokeL.objValue;
    }

    public static ae[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? (ae[]) f64670g.clone() : (ae[]) invokeV.objValue;
    }

    public static List<ae> a(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, strArr)) == null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(a(str));
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeL.objValue;
    }
}
