package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class xd0 {
    public static /* synthetic */ Interceptable $ic;
    public static final je0 a;
    public static final db0 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a<T> extends BdAsyncTask<String, Object, T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public yd0<T> m;
        public zd0<T> n;

        public a(yd0<T> yd0Var, zd0<T> zd0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yd0Var, zd0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.m = null;
            this.n = null;
            this.m = yd0Var;
            this.n = zd0Var;
        }

        @Override // com.baidu.live.asynctask.BdAsyncTask
        public void q(T t) {
            zd0<T> zd0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t) == null) && (zd0Var = this.n) != null) {
                zd0Var.onReturnDataInUI(t);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.asynctask.BdAsyncTask
        /* renamed from: z */
        public T f(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                try {
                    if (this.m == null) {
                        return null;
                    }
                    return this.m.a();
                } catch (Throwable th) {
                    ie0.c(th);
                    return null;
                }
            }
            return (T) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948296389, "Lcom/baidu/tieba/xd0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948296389, "Lcom/baidu/tieba/xd0;");
                return;
            }
        }
        a = je0.a();
        b = new db0(BdAsyncTaskParallelType.SERIAL, a);
    }

    public static <T> BdAsyncTask a(yd0<T> yd0Var, zd0<T> zd0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, yd0Var, zd0Var)) == null) {
            return b(yd0Var, zd0Var, 2);
        }
        return (BdAsyncTask) invokeLL.objValue;
    }

    public static <T> BdAsyncTask b(yd0<T> yd0Var, zd0<T> zd0Var, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, yd0Var, zd0Var, i)) == null) {
            if (yd0Var != null) {
                a aVar = new a(yd0Var, zd0Var);
                aVar.v(b);
                aVar.x(a);
                aVar.w(i);
                aVar.g(new String[0]);
                return aVar;
            }
            return null;
        }
        return (BdAsyncTask) invokeLLI.objValue;
    }
}
