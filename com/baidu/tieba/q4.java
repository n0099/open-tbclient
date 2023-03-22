package com.baidu.tieba;

import com.baidu.tieba.g7;
import com.baidu.tieba.k6;
import com.baidu.tieba.r4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q4 extends y0<p4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k6<g7.b<String, r4<p4>>> b;

    /* loaded from: classes5.dex */
    public static class a extends u0<p4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public k6<s4<?>> b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: g */
    public void c(w0 w0Var, String str, t2 t2Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, w0Var, str, t2Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q4(b1 b1Var) {
        super(b1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new k6<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [V, com.baidu.tieba.r4] */
    @Override // com.baidu.tieba.x0
    /* renamed from: f */
    public k6<s0> a(String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLL;
        k6<r4.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, t2Var, aVar)) == null) {
            ?? r0 = (r4) new y6().d(r4.class, t2Var);
            synchronized (this.b) {
                g7.b<String, r4<p4>> bVar = new g7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            k6<s0> k6Var = new k6<>();
            k6.b<r4.a> it = b.iterator();
            while (it.hasNext()) {
                r4.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = t2Var.i().a(o0.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == p4.class) {
                    k6Var.a(new s0(next.a, cls, aVar));
                } else {
                    k6Var.a(new s0(next.a, cls));
                }
            }
            return k6Var;
        }
        return (k6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: h */
    public p4 d(w0 w0Var, String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLLL;
        r4<p4> r4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, w0Var, str, t2Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        g7.b<String, r4<p4>> bVar = this.b.get(i);
                        if (bVar.a.equals(str)) {
                            r4Var = bVar.b;
                            this.b.h(i);
                            break;
                        }
                        i++;
                    } else {
                        r4Var = null;
                        break;
                    }
                }
            }
            r4Var.d.a(w0Var, r4Var);
            if (aVar != null) {
                k6<s4<?>> k6Var = aVar.b;
                if (k6Var != null) {
                    k6.b<s4<?>> it = k6Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(w0Var, r4Var);
                    }
                }
                r4Var.d.f(aVar.b);
            }
            return r4Var.d;
        }
        return (p4) invokeLLLL.objValue;
    }
}
