package com.baidu.tieba;

import com.baidu.tieba.p7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r1 extends h1<e6, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: g */
    public void c(f1 f1Var, String str, c3 c3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, f1Var, str, c3Var, aVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends d1<e6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String b;
        public final p7<String, Object> c;

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
                    this((String) objArr[0], (p7) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public a(String str, p7<String, Object> p7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, p7Var};
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
            this.c = p7Var;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(k1 k1Var) {
        super(k1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: f */
    public t6<b1> a(String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, c3Var, aVar)) == null) {
            t6<b1> t6Var = new t6<>();
            if (aVar != null && (str2 = aVar.b) != null) {
                if (str2 != null) {
                    t6Var.a(new b1(str2, u3.class));
                }
            } else {
                t6Var.a(new b1(c3Var.k() + ".atlas", u3.class));
            }
            return t6Var;
        }
        return (t6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: h */
    public e6 d(f1 f1Var, String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, f1Var, str, c3Var, aVar)) == null) {
            String str2 = c3Var.k() + ".atlas";
            p7<String, Object> p7Var = null;
            if (aVar != null) {
                String str3 = aVar.b;
                if (str3 != null) {
                    str2 = str3;
                }
                p7<String, Object> p7Var2 = aVar.c;
                if (p7Var2 != null) {
                    p7Var = p7Var2;
                }
            }
            e6 i = i((u3) f1Var.j(str2, u3.class));
            if (p7Var != null) {
                p7.a<String, Object> b = p7Var.b();
                b.c();
                while (b.hasNext()) {
                    p7.b next = b.next();
                    i.a((String) next.a, next.b);
                }
            }
            i.o(c3Var);
            return i;
        }
        return (e6) invokeLLLL.objValue;
    }

    public e6 i(u3 u3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, u3Var)) == null) {
            return new e6(u3Var);
        }
        return (e6) invokeL.objValue;
    }
}
