package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w1 extends b2<y3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends l1<y3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;
        public k3 d;

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
    public w1(s1 s1Var) {
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
    /* renamed from: d */
    public b7<j1> a(String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, k3Var, aVar)) == null) {
            if (aVar != null && aVar.b != null) {
                b7<j1> b7Var = new b7<>();
                b7Var.a(new j1(aVar.b, c4.class));
                return b7Var;
            }
            return null;
        }
        return (b7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b2
    /* renamed from: e */
    public y3 c(n1 n1Var, String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLLL;
        k3 k3Var2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, n1Var, str, k3Var, aVar)) == null) {
            y3 y3Var = new y3();
            if (aVar != null && (str2 = aVar.b) != null) {
                y3Var.f(k3Var, (c4) n1Var.j(str2, c4.class), aVar.c);
            } else if (aVar != null && (k3Var2 = aVar.d) != null) {
                y3Var.a(k3Var, k3Var2);
            } else {
                y3Var.a(k3Var, k3Var.i());
            }
            return y3Var;
        }
        return (y3) invokeLLLL.objValue;
    }
}
