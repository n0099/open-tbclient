package com.baidu.tieba;

import com.baidu.tieba.d8;
import com.baidu.tieba.h7;
import com.baidu.tieba.o5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n5 extends v1<m5, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h7<d8.b<String, o5<m5>>> b;

    /* loaded from: classes5.dex */
    public static class a extends r1<m5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public h7<p5<?>> b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v1
    /* renamed from: g */
    public void c(t1 t1Var, String str, q3 q3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, t1Var, str, q3Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n5(y1 y1Var) {
        super(y1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((y1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new h7<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [V, com.baidu.tieba.o5] */
    @Override // com.baidu.tieba.u1
    /* renamed from: f */
    public h7<p1> a(String str, q3 q3Var, a aVar) {
        InterceptResult invokeLLL;
        h7<o5.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, q3Var, aVar)) == null) {
            ?? r0 = (o5) new v7().d(o5.class, q3Var);
            synchronized (this.b) {
                d8.b<String, o5<m5>> bVar = new d8.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            h7<p1> h7Var = new h7<>();
            h7.b<o5.a> it = b.iterator();
            while (it.hasNext()) {
                o5.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = q3Var.i().a(l1.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == m5.class) {
                    h7Var.a(new p1(next.a, cls, aVar));
                } else {
                    h7Var.a(new p1(next.a, cls));
                }
            }
            return h7Var;
        }
        return (h7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v1
    /* renamed from: h */
    public m5 d(t1 t1Var, String str, q3 q3Var, a aVar) {
        InterceptResult invokeLLLL;
        o5<m5> o5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, t1Var, str, q3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        d8.b<String, o5<m5>> bVar = this.b.get(i);
                        if (bVar.a.equals(str)) {
                            o5Var = bVar.b;
                            this.b.h(i);
                            break;
                        }
                        i++;
                    } else {
                        o5Var = null;
                        break;
                    }
                }
            }
            o5Var.d.a(t1Var, o5Var);
            if (aVar != null) {
                h7<p5<?>> h7Var = aVar.b;
                if (h7Var != null) {
                    h7.b<p5<?>> it = h7Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(t1Var, o5Var);
                    }
                }
                o5Var.d.f(aVar.b);
            }
            return o5Var.d;
        }
        return (m5) invokeLLLL.objValue;
    }
}
