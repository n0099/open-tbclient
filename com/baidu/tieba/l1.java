package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.g5;
import com.baidu.tieba.l1.a;
import com.baidu.tieba.o7;
import com.baidu.tieba.s6;
import com.baidu.tieba.u1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class l1<P extends a> extends g1<y3, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s6<o7.b<String, n4>> b;
    public a c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: g */
    public void c(e1 e1Var, String str, b3 b3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, e1Var, str, b3Var, p) == null) {
        }
    }

    public abstract n4 h(b3 b3Var, P p);

    /* loaded from: classes6.dex */
    public static class a extends c1<y3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public u1.b b;

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
            u1.b bVar = new u1.b();
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
    public l1(j1 j1Var) {
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
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [V, com.baidu.tieba.n4] */
    @Override // com.baidu.tieba.f1
    /* renamed from: f */
    public s6<a1> a(String str, b3 b3Var, P p) {
        InterceptResult invokeLLL;
        u1.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, b3Var, p)) == null) {
            s6<a1> s6Var = new s6<>();
            ?? h = h(b3Var, p);
            if (h == 0) {
                return s6Var;
            }
            o7.b<String, n4> bVar2 = new o7.b<>();
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
            s6.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                s6<u4> s6Var2 = it.next().i;
                if (s6Var2 != null) {
                    s6.b<u4> it2 = s6Var2.iterator();
                    while (it2.hasNext()) {
                        s6Var.a(new a1(it2.next().a, Texture.class, bVar));
                    }
                }
            }
            return s6Var;
        }
        return (s6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: i */
    public y3 d(e1 e1Var, String str, b3 b3Var, P p) {
        InterceptResult invokeLLLL;
        n4 n4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, e1Var, str, b3Var, p)) == null) {
            synchronized (this.b) {
                n4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        n4Var = this.b.get(i).b;
                        this.b.h(i);
                    }
                }
            }
            if (n4Var == null) {
                return null;
            }
            y3 y3Var = new y3(n4Var, new g5.a(e1Var));
            Iterator<z6> it = y3Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return y3Var;
        }
        return (y3) invokeLLLL.objValue;
    }
}
