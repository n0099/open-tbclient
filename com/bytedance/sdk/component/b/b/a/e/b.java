package com.bytedance.sdk.component.b.b.a.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b f28378a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f28379b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f28380c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f28381d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f28382e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f28383f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ b[] f28384h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public final int f28385g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-952269872, "Lcom/bytedance/sdk/component/b/b/a/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-952269872, "Lcom/bytedance/sdk/component/b/b/a/e/b;");
                return;
            }
        }
        f28378a = new b("NO_ERROR", 0, 0);
        f28379b = new b("PROTOCOL_ERROR", 1, 1);
        f28380c = new b("INTERNAL_ERROR", 2, 2);
        f28381d = new b("FLOW_CONTROL_ERROR", 3, 3);
        f28382e = new b("REFUSED_STREAM", 4, 7);
        b bVar = new b("CANCEL", 5, 8);
        f28383f = bVar;
        f28384h = new b[]{f28378a, f28379b, f28380c, f28381d, f28382e, bVar};
    }

    public b(String str, int i2, int i3) {
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
        this.f28385g = i3;
    }

    public static b a(int i2) {
        InterceptResult invokeI;
        b[] values;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            for (b bVar : values()) {
                if (bVar.f28385g == i2) {
                    return bVar;
                }
            }
            return null;
        }
        return (b) invokeI.objValue;
    }

    public static b valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
    }

    public static b[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (b[]) f28384h.clone() : (b[]) invokeV.objValue;
    }
}
