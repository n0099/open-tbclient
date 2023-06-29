package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class o1 extends t1<q3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d1<q3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;
        public c3 d;

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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o1(k1 k1Var) {
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
    /* renamed from: d */
    public t6<b1> a(String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, c3Var, aVar)) == null) {
            if (aVar != null && aVar.b != null) {
                t6<b1> t6Var = new t6<>();
                t6Var.a(new b1(aVar.b, u3.class));
                return t6Var;
            }
            return null;
        }
        return (t6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t1
    /* renamed from: e */
    public q3 c(f1 f1Var, String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLLL;
        c3 c3Var2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, f1Var, str, c3Var, aVar)) == null) {
            q3 q3Var = new q3();
            if (aVar != null && (str2 = aVar.b) != null) {
                q3Var.f(c3Var, (u3) f1Var.j(str2, u3.class), aVar.c);
            } else if (aVar != null && (c3Var2 = aVar.d) != null) {
                q3Var.a(c3Var, c3Var2);
            } else {
                q3Var.a(c3Var, c3Var.i());
            }
            return q3Var;
        }
        return (q3) invokeLLLL.objValue;
    }
}
