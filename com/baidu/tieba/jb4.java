package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class jb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public long b;

    /* loaded from: classes6.dex */
    public static class a implements Comparator<jb4> {
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
        public int compare(jb4 jb4Var, jb4 jb4Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jb4Var, jb4Var2)) == null) {
                return (int) (jb4Var.a - jb4Var2.a);
            }
            return invokeLL.intValue;
        }
    }

    public jb4() {
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

    public static long[] a(jb4 jb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jb4Var)) == null) {
            if (jb4Var == null) {
                return null;
            }
            return new long[]{jb4Var.a, jb4Var.b};
        }
        return (long[]) invokeL.objValue;
    }

    public boolean b(jb4 jb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jb4Var)) == null) {
            long j = this.a;
            if (j <= jb4Var.b) {
                long j2 = this.b;
                long j3 = jb4Var.a;
                if (j2 >= j3) {
                    this.a = Math.min(j, j3);
                    this.b = Math.max(this.b, jb4Var.b);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
