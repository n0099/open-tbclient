package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class p3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f7[] a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448312394, "Lcom/baidu/tieba/p3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448312394, "Lcom/baidu/tieba/p3;");
                return;
            }
        }
        new e3(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public p3(o3 o3Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o3Var, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new u6();
        new u6();
        new e3(1.0f, 1.0f, 1.0f, 1.0f);
        int i3 = o3Var.b.b;
        if (i3 != 0) {
            float[][] fArr = new float[i3];
            int[] iArr = new int[i3];
            if (i3 > 1) {
                f7[] f7VarArr = new f7[i3];
                this.a = f7VarArr;
                int length = f7VarArr.length;
                for (int i4 = 0; i4 < length; i4++) {
                    this.a[i4] = new f7();
                }
            }
            int[] iArr2 = new int[i3];
            return;
        }
        throw new IllegalArgumentException("The specified font must contain at least one texture page.");
    }
}
