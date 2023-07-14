package com.baidu.tieba;

import android.util.SparseIntArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class pca {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] c;
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseIntArray a;
    public final int[] b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948058619, "Lcom/baidu/tieba/pca;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948058619, "Lcom/baidu/tieba/pca;");
                return;
            }
        }
        c = new int[]{3, 8, 13};
        d = new int[]{2, 12};
        e = new int[]{20};
        f = new int[]{3, 13, 23};
    }

    public pca(String str, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, iArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = iArr;
        this.a = new SparseIntArray();
    }

    public void a(int i, int i2) {
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && i >= 0 && i2 >= 0 && (sparseIntArray = this.a) != null) {
            sparseIntArray.append(i2, i);
        }
    }

    public int b(int i) {
        InterceptResult invokeI;
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i < 0 || (sparseIntArray = this.a) == null) {
                return -1;
            }
            return sparseIntArray.get(i, -1);
        }
        return invokeI.intValue;
    }

    public void c(int i) {
        SparseIntArray sparseIntArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (sparseIntArray = this.a) != null) {
            sparseIntArray.delete(i);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            if (i < 0) {
                i = 0;
            }
            SparseIntArray sparseIntArray = this.a;
            if (sparseIntArray != null) {
                sparseIntArray.clear();
                int[] iArr = this.b;
                if (iArr != null) {
                    for (int i2 : iArr) {
                        if (i2 >= 0) {
                            this.a.append(i2 + i, i2);
                        }
                    }
                }
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e(0);
        }
    }
}
