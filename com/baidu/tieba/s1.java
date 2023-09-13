package com.baidu.tieba;

import com.baidu.tieba.q7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s1 extends i1<f6, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: g */
    public void c(g1 g1Var, String str, d3 d3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, g1Var, str, d3Var, aVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends e1<f6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String b;
        public final q7<String, Object> c;

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
                    this((String) objArr[0], (q7) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, q7<String, Object> q7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, q7Var};
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
            this.c = q7Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(l1 l1Var) {
        super(l1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: f */
    public u6<c1> a(String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, d3Var, aVar)) == null) {
            u6<c1> u6Var = new u6<>();
            if (aVar != null && (str2 = aVar.b) != null) {
                if (str2 != null) {
                    u6Var.a(new c1(str2, v3.class));
                }
            } else {
                u6Var.a(new c1(d3Var.k() + ".atlas", v3.class));
            }
            return u6Var;
        }
        return (u6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: h */
    public f6 d(g1 g1Var, String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, g1Var, str, d3Var, aVar)) == null) {
            String str2 = d3Var.k() + ".atlas";
            q7<String, Object> q7Var = null;
            if (aVar != null) {
                String str3 = aVar.b;
                if (str3 != null) {
                    str2 = str3;
                }
                q7<String, Object> q7Var2 = aVar.c;
                if (q7Var2 != null) {
                    q7Var = q7Var2;
                }
            }
            f6 i = i((v3) g1Var.j(str2, v3.class));
            if (q7Var != null) {
                q7.a<String, Object> b = q7Var.b();
                b.c();
                while (b.hasNext()) {
                    q7.b next = b.next();
                    i.a((String) next.a, next.b);
                }
            }
            i.o(d3Var);
            return i;
        }
        return (f6) invokeLLLL.objValue;
    }

    public f6 i(v3 v3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, v3Var)) == null) {
            return new f6(v3Var);
        }
        return (f6) invokeL.objValue;
    }
}
