package com.bytedance.pangle.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f38108b;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final String a(int i) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0 || (iArr = this.a) == null || i >= iArr.length) {
                return null;
            }
            int i2 = iArr[i];
            int a = a(this.f38108b, i2);
            StringBuilder sb = new StringBuilder(a);
            while (a != 0) {
                i2 += 2;
                sb.append((char) a(this.f38108b, i2));
                a--;
            }
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public final int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, str)) != null) {
            return invokeL.intValue;
        }
        if (str == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.a;
            if (i == iArr.length) {
                return -1;
            }
            int i2 = iArr[i];
            int a = a(this.f38108b, i2);
            if (a == str.length()) {
                int i3 = 0;
                while (i3 != a) {
                    i2 += 2;
                    if (str.charAt(i3) != a(this.f38108b, i2)) {
                        break;
                    }
                    i3++;
                }
                if (i3 == a) {
                    return i;
                }
            }
            i++;
        }
    }

    public static final int a(int[] iArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, iArr, i)) == null) {
            int i2 = iArr[i / 4];
            return (i % 4) / 2 == 0 ? i2 & 65535 : i2 >>> 16;
        }
        return invokeLI.intValue;
    }
}
