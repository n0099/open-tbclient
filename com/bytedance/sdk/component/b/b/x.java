package com.bytedance.sdk.component.b.b;

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
/* loaded from: classes6.dex */
public final class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final x f28549a;

    /* renamed from: b  reason: collision with root package name */
    public static final x f28550b;

    /* renamed from: c  reason: collision with root package name */
    public static final x f28551c;

    /* renamed from: d  reason: collision with root package name */
    public static final x f28552d;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ x[] f28553f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final String f28554e;

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
        f28549a = new x("HTTP_1_0", 0, "http/1.0");
        f28550b = new x("HTTP_1_1", 1, "http/1.1");
        f28551c = new x("SPDY_3", 2, "spdy/3.1");
        x xVar = new x("HTTP_2", 3, Config.EVENT_NATIVE_VIEW_HIERARCHY);
        f28552d = xVar;
        f28553f = new x[]{f28549a, f28550b, f28551c, xVar};
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
        this.f28554e = str2;
    }

    public static x a(String str) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str.equals(f28549a.f28554e)) {
                return f28549a;
            }
            if (str.equals(f28550b.f28554e)) {
                return f28550b;
            }
            if (str.equals(f28552d.f28554e)) {
                return f28552d;
            }
            if (str.equals(f28551c.f28554e)) {
                return f28551c;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (x[]) f28553f.clone() : (x[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f28554e : (String) invokeV.objValue;
    }
}
