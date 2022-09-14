package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class y1 extends p1<y5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;

    /* loaded from: classes6.dex */
    public static class a extends l1<y5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String b;
        public String c;
        public boolean d;
        public String e;
        public String f;

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
                    return;
                }
            }
            this.d = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(s1 s1Var) {
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
        this.b = ".vert";
        this.c = ".frag";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: f */
    public b7<j1> a(String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, k3Var, aVar)) == null) {
            return null;
        }
        return (b7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: g */
    public void c(n1 n1Var, String str, k3 k3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, n1Var, str, k3Var, aVar) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: h */
    public y5 d(n1 n1Var, String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, n1Var, str, k3Var, aVar)) == null) {
            String str3 = null;
            if (aVar != null) {
                String str4 = aVar.b;
                if (str4 == null) {
                    str4 = null;
                }
                str2 = aVar.c;
                if (str2 == null) {
                    str2 = null;
                }
                str3 = str4;
            } else {
                str2 = null;
            }
            if (str3 == null && str.endsWith(this.c)) {
                str3 = str.substring(0, str.length() - this.c.length()) + this.b;
            }
            if (str2 == null && str.endsWith(this.b)) {
                str2 = str.substring(0, str.length() - this.b.length()) + this.c;
            }
            k3 b = str3 == null ? k3Var : b(str3);
            if (str2 != null) {
                k3Var = b(str2);
            }
            String o = b.o();
            String o2 = b.equals(k3Var) ? o : k3Var.o();
            if (aVar != null) {
                if (aVar.e != null) {
                    o = aVar.e + o;
                }
                if (aVar.f != null) {
                    o2 = aVar.f + o2;
                }
            }
            y5 y5Var = new y5(o, o2);
            if ((aVar == null || aVar.d) && !y5Var.o()) {
                n1Var.p().b("ShaderProgram " + str + " failed to compile:\n" + y5Var.l());
            }
            return y5Var;
        }
        return (y5) invokeLLLL.objValue;
    }
}
