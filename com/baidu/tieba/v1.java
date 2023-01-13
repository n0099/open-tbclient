package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.baidu.tieba.c7;
import com.baidu.tieba.e2;
import com.baidu.tieba.q5;
import com.baidu.tieba.v1.a;
import com.baidu.tieba.y7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class v1<P extends a> extends q1<i4, P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c7<y7.b<String, x4>> b;
    public a c;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: g */
    public void c(o1 o1Var, String str, l3 l3Var, P p) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, o1Var, str, l3Var, p) == null) {
        }
    }

    public abstract x4 h(l3 l3Var, P p);

    /* loaded from: classes6.dex */
    public static class a extends m1<i4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public e2.b b;

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
            e2.b bVar = new e2.b();
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
    public v1(t1 t1Var) {
        super(t1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((t1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new c7<>();
        this.c = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.baidu.tieba.x4, V] */
    @Override // com.baidu.tieba.p1
    /* renamed from: f */
    public c7<k1> a(String str, l3 l3Var, P p) {
        InterceptResult invokeLLL;
        e2.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, l3Var, p)) == null) {
            c7<k1> c7Var = new c7<>();
            ?? h = h(l3Var, p);
            if (h == 0) {
                return c7Var;
            }
            y7.b<String, x4> bVar2 = new y7.b<>();
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
            c7.b<ModelMaterial> it = h.c.iterator();
            while (it.hasNext()) {
                c7<e5> c7Var2 = it.next().i;
                if (c7Var2 != null) {
                    c7.b<e5> it2 = c7Var2.iterator();
                    while (it2.hasNext()) {
                        c7Var.a(new k1(it2.next().a, Texture.class, bVar));
                    }
                }
            }
            return c7Var;
        }
        return (c7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: i */
    public i4 d(o1 o1Var, String str, l3 l3Var, P p) {
        InterceptResult invokeLLLL;
        x4 x4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048582, this, o1Var, str, l3Var, p)) == null) {
            synchronized (this.b) {
                x4Var = null;
                for (int i = 0; i < this.b.b; i++) {
                    if (this.b.get(i).a.equals(str)) {
                        x4Var = this.b.get(i).b;
                        this.b.h(i);
                    }
                }
            }
            if (x4Var == null) {
                return null;
            }
            i4 i4Var = new i4(x4Var, new q5.a(o1Var));
            Iterator<j7> it = i4Var.h().iterator();
            while (it.hasNext()) {
                if (it.next() instanceof Texture) {
                    it.remove();
                }
            }
            return i4Var;
        }
        return (i4) invokeLLLL.objValue;
    }
}
