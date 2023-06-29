package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes7.dex */
public class n0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public t6<j0> b;
    public r0<j0> c;
    public p7<Class<?>, j0> d;
    public c e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(j0 j0Var);

        void b(j0 j0Var);
    }

    /* loaded from: classes6.dex */
    public static class b implements Comparator<j0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(j0 j0Var, j0 j0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, j0Var, j0Var2)) == null) {
                int i = j0Var.a;
                int i2 = j0Var2.a;
                if (i > i2) {
                    return 1;
                }
                if (i == i2) {
                    return 0;
                }
                return -1;
            }
            return invokeLL.intValue;
        }
    }

    public n0(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new b(null);
        t6<j0> t6Var = new t6<>(true, 16);
        this.b = t6Var;
        this.c = new r0<>(t6Var);
        this.d = new p7<>();
        this.e = cVar;
    }

    public void a(j0 j0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, j0Var) == null) {
            Class<?> cls = j0Var.getClass();
            j0 b2 = b(cls);
            if (b2 != null) {
                d(b2);
            }
            this.b.a(j0Var);
            this.d.i(cls, j0Var);
            this.b.sort(this.a);
            this.e.b(j0Var);
        }
    }

    public <T extends j0> T b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            return (T) this.d.c(cls);
        }
        return (T) invokeL.objValue;
    }

    public void d(j0 j0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, j0Var) == null) && this.b.i(j0Var, true)) {
            this.d.k(j0Var.getClass());
            this.e.a(j0Var);
        }
    }

    public r0<j0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (r0) invokeV.objValue;
    }
}
