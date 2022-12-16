package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes6.dex */
public class v0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public b7<r0> b;
    public z0<r0> c;
    public x7<Class<?>, r0> d;
    public c e;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(r0 r0Var);

        void b(r0 r0Var);
    }

    /* loaded from: classes6.dex */
    public static class b implements Comparator<r0> {
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
        public int compare(r0 r0Var, r0 r0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, r0Var, r0Var2)) == null) {
                int i = r0Var.a;
                int i2 = r0Var2.a;
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

    public v0(c cVar) {
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
        b7<r0> b7Var = new b7<>(true, 16);
        this.b = b7Var;
        this.c = new z0<>(b7Var);
        this.d = new x7<>();
        this.e = cVar;
    }

    public void a(r0 r0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, r0Var) == null) {
            Class<?> cls = r0Var.getClass();
            r0 b2 = b(cls);
            if (b2 != null) {
                d(b2);
            }
            this.b.a(r0Var);
            this.d.i(cls, r0Var);
            this.b.sort(this.a);
            this.e.b(r0Var);
        }
    }

    public <T extends r0> T b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            return (T) this.d.c(cls);
        }
        return (T) invokeL.objValue;
    }

    public void d(r0 r0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, r0Var) == null) && this.b.i(r0Var, true)) {
            this.d.k(r0Var.getClass());
            this.e.a(r0Var);
        }
    }

    public z0<r0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (z0) invokeV.objValue;
    }
}
