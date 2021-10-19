package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final x f64538a;

    /* renamed from: b  reason: collision with root package name */
    public static final x f64539b;

    /* renamed from: c  reason: collision with root package name */
    public static final x f64540c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ x[] f64541d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2131109258, "Lcom/bytedance/sdk/component/a/x;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2131109258, "Lcom/bytedance/sdk/component/a/x;");
                return;
            }
        }
        f64538a = new x("PUBLIC", 0);
        f64539b = new x("PROTECTED", 1);
        x xVar = new x("PRIVATE", 2);
        f64540c = xVar;
        f64541d = new x[]{f64538a, f64539b, xVar};
    }

    public x(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static x a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return f64538a;
            }
            String lowerCase = str.toLowerCase();
            if (TextUtils.equals("protected", lowerCase)) {
                return f64539b;
            }
            if (TextUtils.equals(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, lowerCase)) {
                return f64540c;
            }
            return f64538a;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (x[]) f64541d.clone() : (x[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this == f64540c ? PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : this == f64539b ? "protected" : "public" : (String) invokeV.objValue;
    }
}
