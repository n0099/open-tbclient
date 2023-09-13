package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r1 extends i1<r5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: f */
    public u6<c1> a(String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, d3Var, aVar)) == null) {
            return null;
        }
        return (u6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: g */
    public void c(g1 g1Var, String str, d3 d3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, g1Var, str, d3Var, aVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends e1<r5> {
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
    public r1(l1 l1Var) {
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
        this.b = ".vert";
        this.c = ".frag";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: h */
    public r5 d(g1 g1Var, String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        d3 b;
        String o;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, g1Var, str, d3Var, aVar)) == null) {
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
                b = d3Var;
            } else {
                b = b(str3);
            }
            if (str2 != null) {
                d3Var = b(str2);
            }
            String o2 = b.o();
            if (b.equals(d3Var)) {
                o = o2;
            } else {
                o = d3Var.o();
            }
            if (aVar != null) {
                if (aVar.e != null) {
                    o2 = aVar.e + o2;
                }
                if (aVar.f != null) {
                    o = aVar.f + o;
                }
            }
            r5 r5Var = new r5(o2, o);
            if ((aVar == null || aVar.d) && !r5Var.o()) {
                g1Var.p().b("ShaderProgram " + str + " failed to compile:\n" + r5Var.l());
            }
            return r5Var;
        }
        return (r5) invokeLLLL.objValue;
    }
}
