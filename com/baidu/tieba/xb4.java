package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes8.dex */
public class xb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;

    /* loaded from: classes8.dex */
    public static class a implements Comparator<xb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(xb4 xb4Var, xb4 xb4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, xb4Var, xb4Var2)) == null) {
                return (int) (xb4Var.a - xb4Var2.a);
            }
            return invokeLL.intValue;
        }
    }

    public xb4() {
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

    public static long[] a(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xb4Var)) == null) {
            if (xb4Var == null) {
                return null;
            }
            return new long[]{xb4Var.a, xb4Var.b};
        }
        return (long[]) invokeL.objValue;
    }

    public boolean b(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, xb4Var)) == null) {
            long j = this.a;
            if (j <= xb4Var.b) {
                long j2 = this.b;
                long j3 = xb4Var.a;
                if (j2 >= j3) {
                    this.a = Math.min(j, j3);
                    this.b = Math.max(this.b, xb4Var.b);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
