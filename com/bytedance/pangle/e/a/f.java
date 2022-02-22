package com.bytedance.pangle.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f53268b;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final String a(int i2) {
        InterceptResult invokeI;
        int[] iArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (i2 < 0 || (iArr = this.a) == null || i2 >= iArr.length) {
                return null;
            }
            int i3 = iArr[i2];
            int a = a(this.f53268b, i3);
            StringBuilder sb = new StringBuilder(a);
            while (a != 0) {
                i3 += 2;
                sb.append((char) a(this.f53268b, i3));
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
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 == iArr.length) {
                return -1;
            }
            int i3 = iArr[i2];
            int a = a(this.f53268b, i3);
            if (a == str.length()) {
                int i4 = 0;
                while (i4 != a) {
                    i3 += 2;
                    if (str.charAt(i4) != a(this.f53268b, i3)) {
                        break;
                    }
                    i4++;
                }
                if (i4 == a) {
                    return i2;
                }
            }
            i2++;
        }
    }

    public static final int a(int[] iArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, iArr, i2)) == null) {
            int i3 = iArr[i2 / 4];
            return (i2 % 4) / 2 == 0 ? i3 & 65535 : i3 >>> 16;
        }
        return invokeLI.intValue;
    }
}
