package com.baidu.tieba;

import com.baidu.tieba.k7;
import com.baidu.tieba.o6;
import com.baidu.tieba.v4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class u4 extends c1<t4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o6<k7.b<String, v4<t4>>> b;

    /* loaded from: classes7.dex */
    public static class a extends y0<t4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public o6<w4<?>> b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: g */
    public void c(a1 a1Var, String str, x2 x2Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, a1Var, str, x2Var, aVar) == null) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u4(f1 f1Var) {
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
        this.b = new o6<>();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.baidu.tieba.v4, V] */
    @Override // com.baidu.tieba.b1
    /* renamed from: f */
    public o6<w0> a(String str, x2 x2Var, a aVar) {
        InterceptResult invokeLLL;
        o6<v4.a> b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, x2Var, aVar)) == null) {
            ?? r0 = (v4) new c7().d(v4.class, x2Var);
            synchronized (this.b) {
                k7.b<String, v4<t4>> bVar = new k7.b<>();
                bVar.a = str;
                bVar.b = r0;
                this.b.a(bVar);
                b = r0.b();
            }
            o6<w0> o6Var = new o6<>();
            o6.b<v4.a> it = b.iterator();
            while (it.hasNext()) {
                v4.a next = it.next();
                if (!b(next.a).c()) {
                    next.a = x2Var.i().a(s0.d.a(next.a).g()).j();
                }
                Class<T> cls = next.b;
                if (cls == t4.class) {
                    o6Var.a(new w0(next.a, cls, aVar));
                } else {
                    o6Var.a(new w0(next.a, cls));
                }
            }
            return o6Var;
        }
        return (o6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.c1
    /* renamed from: h */
    public t4 d(a1 a1Var, String str, x2 x2Var, a aVar) {
        InterceptResult invokeLLLL;
        v4<t4> v4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, a1Var, str, x2Var, aVar)) == null) {
            synchronized (this.b) {
                int i = 0;
                while (true) {
                    if (i < this.b.b) {
                        k7.b<String, v4<t4>> bVar = this.b.get(i);
                        if (bVar.a.equals(str)) {
                            v4Var = bVar.b;
                            this.b.h(i);
                            break;
                        }
                        i++;
                    } else {
                        v4Var = null;
                        break;
                    }
                }
            }
            v4Var.d.a(a1Var, v4Var);
            if (aVar != null) {
                o6<w4<?>> o6Var = aVar.b;
                if (o6Var != null) {
                    o6.b<w4<?>> it = o6Var.iterator();
                    while (it.hasNext()) {
                        it.next().b(a1Var, v4Var);
                    }
                }
                v4Var.d.f(aVar.b);
            }
            return v4Var.d;
        }
        return (t4) invokeLLLL.objValue;
    }
}
