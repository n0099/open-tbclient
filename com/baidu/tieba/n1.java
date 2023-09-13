package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.i5;
import com.baidu.tieba.n1.a;
import com.baidu.tieba.q7;
import com.baidu.tieba.u6;
import com.baidu.tieba.w1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes7.dex */
public abstract class n1<P extends a> extends i1<a4, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u6<q7.b<String, p4>> b;
    public a c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: g */
    public void c(g1 g1Var, String str, d3 d3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, g1Var, str, d3Var, p) == null) {
        }
    }

    public abstract p4 h(d3 d3Var, P p);

    /* loaded from: classes7.dex */
    public static class a extends e1<a4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public w1.b b;

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
            w1.b bVar = new w1.b();
            this.b = bVar;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Linear;
            bVar.g = textureFilter;
            bVar.f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.Repeat;
            bVar.i = textureWrap;
            bVar.h = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(l1 l1Var) {
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
        this.b = new u6<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [V, com.baidu.tieba.p4] */
    @Override // com.baidu.tieba.h1
    /* renamed from: f */
    public u6<c1> a(String str, d3 d3Var, P p) {
        InterceptResult invokeLLL;
        w1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, d3Var, p)) == null) {
            u6<c1> u6Var = new u6<>();
            ?? h = h(d3Var, p);
            if (h == 0) {
                return u6Var;
            }
            q7.b<String, p4> bVar2 = new q7.b<>();
            bVar2.a = str;
            bVar2.b = h;
            synchronized (this.b) {
                this.b.a(bVar2);
            }
            if (p != null) {
                bVar = p.b;
            } else {
                bVar = this.c.b;
            }
            u6.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                u6<w4> u6Var2 = it.next().i;
                if (u6Var2 != null) {
                    u6.b<w4> it2 = u6Var2.iterator();
                    while (it2.hasNext()) {
                        u6Var.a(new c1(it2.next().a, Texture.class, bVar));
                    }
                }
            }
            return u6Var;
        }
        return (u6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: i */
    public a4 d(g1 g1Var, String str, d3 d3Var, P p) {
        InterceptResult invokeLLLL;
        p4 p4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, g1Var, str, d3Var, p)) == null) {
            synchronized (this.b) {
                p4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        p4Var = this.b.get(i).b;
                        this.b.h(i);
                    }
                }
            }
            if (p4Var == null) {
                return null;
            }
            a4 a4Var = new a4(p4Var, new i5.a(g1Var));
            Iterator<b7> it = a4Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return a4Var;
        }
        return (a4) invokeLLLL.objValue;
    }
}
