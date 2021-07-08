package com.bytedance.sdk.component.b.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final x f28659a;

    /* renamed from: b  reason: collision with root package name */
    public static final x f28660b;

    /* renamed from: c  reason: collision with root package name */
    public static final x f28661c;

    /* renamed from: d  reason: collision with root package name */
    public static final x f28662d;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ x[] f28663f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f28664e;

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
        f28659a = new x("HTTP_1_0", 0, "http/1.0");
        f28660b = new x("HTTP_1_1", 1, "http/1.1");
        f28661c = new x("SPDY_3", 2, "spdy/3.1");
        x xVar = new x("HTTP_2", 3, Config.EVENT_NATIVE_VIEW_HIERARCHY);
        f28662d = xVar;
        f28663f = new x[]{f28659a, f28660b, f28661c, xVar};
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
        this.f28664e = str2;
    }

    public static x a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.equals(f28659a.f28664e)) {
                return f28659a;
            }
            if (str.equals(f28660b.f28664e)) {
                return f28660b;
            }
            if (str.equals(f28662d.f28664e)) {
                return f28662d;
            }
            if (str.equals(f28661c.f28664e)) {
                return f28661c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (x[]) f28663f.clone() : (x[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28664e : (String) invokeV.objValue;
    }
}
