package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class l1 extends c1<l5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.b1
    /* renamed from: f */
    public o6<w0> a(String str, x2 x2Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, x2Var, aVar)) == null) {
            return null;
        }
        return (o6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: g */
    public void c(a1 a1Var, String str, x2 x2Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, a1Var, str, x2Var, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends y0<l5> {
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
    public l1(f1 f1Var) {
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
        this.b = ".vert";
        this.c = ".frag";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: h */
    public l5 d(a1 a1Var, String str, x2 x2Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        x2 b;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, a1Var, str, x2Var, aVar)) == null) {
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
            if (str3 == null) {
                b = x2Var;
            } else {
                b = b(str3);
            }
            if (str2 != null) {
                x2Var = b(str2);
            }
            String o2 = b.o();
            if (b.equals(x2Var)) {
                o = o2;
            } else {
                o = x2Var.o();
            }
            if (aVar != null) {
                if (aVar.e != null) {
                    o2 = aVar.e + o2;
                }
                if (aVar.f != null) {
                    o = aVar.f + o;
                }
            }
            l5 l5Var = new l5(o2, o);
            if ((aVar == null || aVar.d) && !l5Var.o()) {
                a1Var.p().b("ShaderProgram " + str + " failed to compile:\n" + l5Var.l());
            }
            return l5Var;
        }
        return (l5) invokeLLLL.objValue;
    }
}
