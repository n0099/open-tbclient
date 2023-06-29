package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class q1 extends h1<q5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: f */
    public t6<b1> a(String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, c3Var, aVar)) == null) {
            return null;
        }
        return (t6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: g */
    public void c(f1 f1Var, String str, c3 c3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, f1Var, str, c3Var, aVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends d1<q5> {
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
    public q1(k1 k1Var) {
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
        this.b = ".vert";
        this.c = ".frag";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: h */
    public q5 d(f1 f1Var, String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        c3 b;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, f1Var, str, c3Var, aVar)) == null) {
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
                b = c3Var;
            } else {
                b = b(str3);
            }
            if (str2 != null) {
                c3Var = b(str2);
            }
            String o2 = b.o();
            if (b.equals(c3Var)) {
                o = o2;
            } else {
                o = c3Var.o();
            }
            if (aVar != null) {
                if (aVar.e != null) {
                    o2 = aVar.e + o2;
                }
                if (aVar.f != null) {
                    o = aVar.f + o;
                }
            }
            q5 q5Var = new q5(o2, o);
            if ((aVar == null || aVar.d) && !q5Var.o()) {
                f1Var.p().b("ShaderProgram " + str + " failed to compile:\n" + q5Var.l());
            }
            return q5Var;
        }
        return (q5) invokeLLLL.objValue;
    }
}
