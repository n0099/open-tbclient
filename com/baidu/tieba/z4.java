package com.baidu.tieba;

import com.baidu.tieba.a5;
import com.baidu.tieba.p7;
import com.baidu.tieba.t6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class z4 extends h1<y4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t6<p7.b<String, a5<y4>>> b;

    /* loaded from: classes8.dex */
    public static class a extends d1<y4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public t6<b5<?>> b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: g */
    public void c(f1 f1Var, String str, c3 c3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, f1Var, str, c3Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z4(k1 k1Var) {
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
        this.b = new t6<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [V, com.baidu.tieba.a5] */
    @Override // com.baidu.tieba.g1
    /* renamed from: f */
    public t6<b1> a(String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLL;
        t6<a5.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, c3Var, aVar)) == null) {
            ?? r0 = (a5) new h7().d(a5.class, c3Var);
            synchronized (this.b) {
                p7.b<String, a5<y4>> bVar = new p7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            t6<b1> t6Var = new t6<>();
            t6.b<a5.a> it = b.iterator();
            while (it.hasNext()) {
                a5.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = c3Var.i().a(x0.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == y4.class) {
                    t6Var.a(new b1(next.a, cls, aVar));
                } else {
                    t6Var.a(new b1(next.a, cls));
                }
            }
            return t6Var;
        }
        return (t6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: h */
    public y4 d(f1 f1Var, String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLLL;
        a5<y4> a5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, f1Var, str, c3Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        p7.b<String, a5<y4>> bVar = this.b.get(i);
                        if (bVar.a.equals(str)) {
                            a5Var = bVar.b;
                            this.b.h(i);
                            break;
                        }
                        i++;
                    } else {
                        a5Var = null;
                        break;
                    }
                }
            }
            a5Var.d.a(f1Var, a5Var);
            if (aVar != null) {
                t6<b5<?>> t6Var = aVar.b;
                if (t6Var != null) {
                    t6.b<b5<?>> it = t6Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(f1Var, a5Var);
                    }
                }
                a5Var.d.f(aVar.b);
            }
            return a5Var.d;
        }
        return (y4) invokeLLLL.objValue;
    }
}
