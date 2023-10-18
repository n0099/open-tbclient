package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes7.dex */
public class o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public r2<k0> b;
    public s0<k0> c;
    public a3<Class<?>, k0> d;
    public c e;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(k0 k0Var);

        void b(k0 k0Var);
    }

    /* loaded from: classes7.dex */
    public static class b implements Comparator<k0> {
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
        public int compare(k0 k0Var, k0 k0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, k0Var, k0Var2)) == null) {
                int i = k0Var.a;
                int i2 = k0Var2.a;
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

    public o0(c cVar) {
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
        r2<k0> r2Var = new r2<>(true, 16);
        this.b = r2Var;
        this.c = new s0<>(r2Var);
        this.d = new a3<>();
        this.e = cVar;
    }

    public void a(k0 k0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, k0Var) == null) {
            Class<?> cls = k0Var.getClass();
            k0 b2 = b(cls);
            if (b2 != null) {
                d(b2);
            }
            this.b.a(k0Var);
            this.d.h(cls, k0Var);
            this.b.sort(this.a);
            this.e.b(k0Var);
        }
    }

    public <T extends k0> T b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) {
            return (T) this.d.b(cls);
        }
        return (T) invokeL.objValue;
    }

    public void d(k0 k0Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, k0Var) == null) && this.b.g(k0Var, true)) {
            this.d.j(k0Var.getClass());
            this.e.a(k0Var);
        }
    }

    public s0<k0> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (s0) invokeV.objValue;
    }
}
