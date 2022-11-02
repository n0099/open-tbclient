package com.baidu.tieba;

import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class z1 extends p1<m6, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: g */
    public void c(n1 n1Var, String str, k3 k3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, n1Var, str, k3Var, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends l1<m6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String b;
        public final x7<String, Object> c;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr = newInitContext.callArgs;
                    this((String) objArr[0], (x7) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, x7<String, Object> x7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, x7Var};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.b = str;
            this.c = x7Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z1(s1 s1Var) {
        super(s1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((s1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: f */
    public b7<j1> a(String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, k3Var, aVar)) == null) {
            b7<j1> b7Var = new b7<>();
            if (aVar != null && (str2 = aVar.b) != null) {
                if (str2 != null) {
                    b7Var.a(new j1(str2, c4.class));
                }
            } else {
                b7Var.a(new j1(k3Var.k() + ".atlas", c4.class));
            }
            return b7Var;
        }
        return (b7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: h */
    public m6 d(n1 n1Var, String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, n1Var, str, k3Var, aVar)) == null) {
            String str2 = k3Var.k() + ".atlas";
            x7<String, Object> x7Var = null;
            if (aVar != null) {
                String str3 = aVar.b;
                if (str3 != null) {
                    str2 = str3;
                }
                x7<String, Object> x7Var2 = aVar.c;
                if (x7Var2 != null) {
                    x7Var = x7Var2;
                }
            }
            m6 i = i((c4) n1Var.j(str2, c4.class));
            if (x7Var != null) {
                x7.a<String, Object> b = x7Var.b();
                b.c();
                while (b.hasNext()) {
                    x7.b next = b.next();
                    i.a((String) next.a, next.b);
                }
            }
            i.o(k3Var);
            return i;
        }
        return (m6) invokeLLLL.objValue;
    }

    public m6 i(c4 c4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c4Var)) == null) {
            return new m6(c4Var);
        }
        return (m6) invokeL.objValue;
    }
}
