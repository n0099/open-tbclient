package com.baidu.tieba;

import com.baidu.tieba.k7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class m1 extends c1<z5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: g */
    public void c(a1 a1Var, String str, x2 x2Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, a1Var, str, x2Var, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends y0<z5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String b;
        public final k7<String, Object> c;

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
                    this((String) objArr[0], (k7) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, k7<String, Object> k7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, k7Var};
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
            this.c = k7Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(f1 f1Var) {
        super(f1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((f1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b1
    /* renamed from: f */
    public o6<w0> a(String str, x2 x2Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, x2Var, aVar)) == null) {
            o6<w0> o6Var = new o6<>();
            if (aVar != null && (str2 = aVar.b) != null) {
                if (str2 != null) {
                    o6Var.a(new w0(str2, p3.class));
                }
            } else {
                o6Var.a(new w0(x2Var.k() + ".atlas", p3.class));
            }
            return o6Var;
        }
        return (o6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: h */
    public z5 d(a1 a1Var, String str, x2 x2Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, a1Var, str, x2Var, aVar)) == null) {
            String str2 = x2Var.k() + ".atlas";
            k7<String, Object> k7Var = null;
            if (aVar != null) {
                String str3 = aVar.b;
                if (str3 != null) {
                    str2 = str3;
                }
                k7<String, Object> k7Var2 = aVar.c;
                if (k7Var2 != null) {
                    k7Var = k7Var2;
                }
            }
            z5 i = i((p3) a1Var.j(str2, p3.class));
            if (k7Var != null) {
                k7.a<String, Object> b = k7Var.b();
                b.c();
                while (b.hasNext()) {
                    k7.b next = b.next();
                    i.a((String) next.a, next.b);
                }
            }
            i.o(x2Var);
            return i;
        }
        return (z5) invokeLLLL.objValue;
    }

    public z5 i(p3 p3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, p3Var)) == null) {
            return new z5(p3Var);
        }
        return (z5) invokeL.objValue;
    }
}
