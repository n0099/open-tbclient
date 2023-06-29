package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.h5;
import com.baidu.tieba.m1.a;
import com.baidu.tieba.p7;
import com.baidu.tieba.t6;
import com.baidu.tieba.v1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class m1<P extends a> extends h1<z3, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t6<p7.b<String, o4>> b;
    public a c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: g */
    public void c(f1 f1Var, String str, c3 c3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, f1Var, str, c3Var, p) == null) {
        }
    }

    public abstract o4 h(c3 c3Var, P p);

    /* loaded from: classes6.dex */
    public static class a extends d1<z3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public v1.b b;

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
            v1.b bVar = new v1.b();
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
    public m1(k1 k1Var) {
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
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [V, com.baidu.tieba.o4] */
    @Override // com.baidu.tieba.g1
    /* renamed from: f */
    public t6<b1> a(String str, c3 c3Var, P p) {
        InterceptResult invokeLLL;
        v1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, c3Var, p)) == null) {
            t6<b1> t6Var = new t6<>();
            ?? h = h(c3Var, p);
            if (h == 0) {
                return t6Var;
            }
            p7.b<String, o4> bVar2 = new p7.b<>();
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
            t6.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                t6<v4> t6Var2 = it.next().i;
                if (t6Var2 != null) {
                    t6.b<v4> it2 = t6Var2.iterator();
                    while (it2.hasNext()) {
                        t6Var.a(new b1(it2.next().a, Texture.class, bVar));
                    }
                }
            }
            return t6Var;
        }
        return (t6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: i */
    public z3 d(f1 f1Var, String str, c3 c3Var, P p) {
        InterceptResult invokeLLLL;
        o4 o4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, f1Var, str, c3Var, p)) == null) {
            synchronized (this.b) {
                o4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        o4Var = this.b.get(i).b;
                        this.b.h(i);
                    }
                }
            }
            if (o4Var == null) {
                return null;
            }
            z3 z3Var = new z3(o4Var, new h5.a(f1Var));
            Iterator<a7> it = z3Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return z3Var;
        }
        return (z3) invokeLLLL.objValue;
    }
}
