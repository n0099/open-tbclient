package com.baidu.tieba;

import com.baidu.tieba.o7;
import com.baidu.tieba.s6;
import com.baidu.tieba.z4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class y4 extends g1<x4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s6<o7.b<String, z4<x4>>> b;

    /* loaded from: classes8.dex */
    public static class a extends c1<x4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public s6<a5<?>> b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: g */
    public void c(e1 e1Var, String str, b3 b3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, e1Var, str, b3Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y4(j1 j1Var) {
        super(j1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new s6<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.tieba.z4, V] */
    @Override // com.baidu.tieba.f1
    /* renamed from: f */
    public s6<a1> a(String str, b3 b3Var, a aVar) {
        InterceptResult invokeLLL;
        s6<z4.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, b3Var, aVar)) == null) {
            ?? r0 = (z4) new g7().d(z4.class, b3Var);
            synchronized (this.b) {
                o7.b<String, z4<x4>> bVar = new o7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            s6<a1> s6Var = new s6<>();
            s6.b<z4.a> it = b.iterator();
            while (it.hasNext()) {
                z4.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = b3Var.i().a(w0.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == x4.class) {
                    s6Var.a(new a1(next.a, cls, aVar));
                } else {
                    s6Var.a(new a1(next.a, cls));
                }
            }
            return s6Var;
        }
        return (s6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: h */
    public x4 d(e1 e1Var, String str, b3 b3Var, a aVar) {
        InterceptResult invokeLLLL;
        z4<x4> z4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, e1Var, str, b3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        o7.b<String, z4<x4>> bVar = this.b.get(i);
                        if (bVar.a.equals(str)) {
                            z4Var = bVar.b;
                            this.b.h(i);
                            break;
                        }
                        i++;
                    } else {
                        z4Var = null;
                        break;
                    }
                }
            }
            z4Var.d.a(e1Var, z4Var);
            if (aVar != null) {
                s6<a5<?>> s6Var = aVar.b;
                if (s6Var != null) {
                    s6.b<a5<?>> it = s6Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(e1Var, z4Var);
                    }
                }
                z4Var.d.f(aVar.b);
            }
            return z4Var.d;
        }
        return (x4) invokeLLLL.objValue;
    }
}
