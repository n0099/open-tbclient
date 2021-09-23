package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final x f65306a;

    /* renamed from: b  reason: collision with root package name */
    public static final x f65307b;

    /* renamed from: c  reason: collision with root package name */
    public static final x f65308c;

    /* renamed from: d  reason: collision with root package name */
    public static final x f65309d;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ x[] f65310f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f65311e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(731369250, "Lcom/bytedance/sdk/component/b/b/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(731369250, "Lcom/bytedance/sdk/component/b/b/x;");
                return;
            }
        }
        f65306a = new x("HTTP_1_0", 0, "http/1.0");
        f65307b = new x("HTTP_1_1", 1, "http/1.1");
        f65308c = new x("SPDY_3", 2, "spdy/3.1");
        x xVar = new x("HTTP_2", 3, "h2");
        f65309d = xVar;
        f65310f = new x[]{f65306a, f65307b, f65308c, xVar};
    }

    public x(String str, int i2, String str2) {
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
        this.f65311e = str2;
    }

    public static x a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.equals(f65306a.f65311e)) {
                return f65306a;
            }
            if (str.equals(f65307b.f65311e)) {
                return f65307b;
            }
            if (str.equals(f65309d.f65311e)) {
                return f65309d;
            }
            if (str.equals(f65308c.f65311e)) {
                return f65308c;
            }
            throw new IOException("Unexpected protocol: " + str);
        }
        return (x) invokeL.objValue;
    }

    public static x valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (x) Enum.valueOf(x.class, str) : (x) invokeL.objValue;
    }

    public static x[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (x[]) f65310f.clone() : (x[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65311e : (String) invokeV.objValue;
    }
}
