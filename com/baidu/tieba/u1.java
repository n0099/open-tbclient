package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.b7;
import com.baidu.tieba.d2;
import com.baidu.tieba.p5;
import com.baidu.tieba.u1.a;
import com.baidu.tieba.x7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class u1<P extends a> extends p1<h4, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b7<x7.b<String, w4>> b;
    public a c;

    /* loaded from: classes6.dex */
    public static class a extends l1<h4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public d2.b b;

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
            d2.b bVar = new d2.b();
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
    public u1(s1 s1Var) {
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
        this.b = new b7<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.baidu.tieba.w4, V] */
    @Override // com.baidu.tieba.o1
    /* renamed from: f */
    public b7<j1> a(String str, k3 k3Var, P p) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, k3Var, p)) == null) {
            b7<j1> b7Var = new b7<>();
            ?? h = h(k3Var, p);
            if (h == 0) {
                return b7Var;
            }
            x7.b<String, w4> bVar = new x7.b<>();
            bVar.a = str;
            bVar.b = h;
            synchronized (this.b) {
                this.b.a(bVar);
            }
            d2.b bVar2 = p != null ? p.b : this.c.b;
            b7.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                b7<d5> b7Var2 = it.next().i;
                if (b7Var2 != null) {
                    b7.b<d5> it2 = b7Var2.iterator();
                    while (it2.hasNext()) {
                        b7Var.a(new j1(it2.next().a, Texture.class, bVar2));
                    }
                }
            }
            return b7Var;
        }
        return (b7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: g */
    public void c(n1 n1Var, String str, k3 k3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, n1Var, str, k3Var, p) == null) {
        }
    }

    public abstract w4 h(k3 k3Var, P p);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: i */
    public h4 d(n1 n1Var, String str, k3 k3Var, P p) {
        InterceptResult invokeLLLL;
        w4 w4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, n1Var, str, k3Var, p)) == null) {
            synchronized (this.b) {
                w4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        w4Var = this.b.get(i).b;
                        this.b.i(i);
                    }
                }
            }
            if (w4Var == null) {
                return null;
            }
            h4 h4Var = new h4(w4Var, new p5.a(n1Var));
            Iterator<i7> it = h4Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return h4Var;
        }
        return (h4) invokeLLLL.objValue;
    }
}
