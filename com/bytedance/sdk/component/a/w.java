package com.bytedance.sdk.component.a;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class w {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final w f27706a;

    /* renamed from: b  reason: collision with root package name */
    public static final w f27707b;

    /* renamed from: c  reason: collision with root package name */
    public static final w f27708c;

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ w[] f27709d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2131109289, "Lcom/bytedance/sdk/component/a/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2131109289, "Lcom/bytedance/sdk/component/a/w;");
                return;
            }
        }
        f27706a = new w("PUBLIC", 0);
        f27707b = new w("PROTECTED", 1);
        w wVar = new w("PRIVATE", 2);
        f27708c = wVar;
        f27709d = new w[]{f27706a, f27707b, wVar};
    }

    public w(String str, int i2) {
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

    public static w a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return f27706a;
            }
            String lowerCase = str.toLowerCase();
            if (TextUtils.equals("protected", lowerCase)) {
                return f27707b;
            }
            if (TextUtils.equals(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, lowerCase)) {
                return f27708c;
            }
            return f27706a;
        }
        return (w) invokeL.objValue;
    }

    public static w valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (w) Enum.valueOf(w.class, str) : (w) invokeL.objValue;
    }

    public static w[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? (w[]) f27709d.clone() : (w[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this == f27708c ? PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE : this == f27707b ? "protected" : "public" : (String) invokeV.objValue;
    }
}
