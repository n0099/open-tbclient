package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.tieba.c4;
import com.baidu.tieba.d2;
import com.baidu.tieba.v3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class q1 extends p1<v3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v3.a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: g */
    public void c(n1 n1Var, String str, k3 k3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, n1Var, str, k3Var, aVar) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends l1<v3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public v3.a f;
        public String g;

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
            this.b = false;
            this.c = false;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.d = textureFilter;
            this.e = textureFilter;
            this.f = null;
            this.g = null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(s1 s1Var) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o1
    /* renamed from: f */
    public b7<j1> a(String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        v3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, k3Var, aVar)) == null) {
            b7<j1> b7Var = new b7<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return b7Var;
            }
            if (aVar != null && aVar.b) {
                z = true;
            } else {
                z = false;
            }
            this.b = new v3.a(k3Var, z);
            if (aVar != null && (str2 = aVar.g) != null) {
                b7Var.a(new j1(str2, c4.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    k3 b = b(this.b.c(i));
                    d2.b bVar = new d2.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    b7Var.a(new j1(b, Texture.class, bVar));
                }
            }
            return b7Var;
        }
        return (b7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: h */
    public v3 d(n1 n1Var, String str, k3 k3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, n1Var, str, k3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = k3Var.s(this.b.b[0]).h().toString();
                c4.a f = ((c4) n1Var.j(str2, c4.class)).f(str3);
                if (f != null) {
                    return new v3(k3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            b7 b7Var = new b7(length);
            for (int i = 0; i < length; i++) {
                b7Var.a(new d4((Texture) n1Var.j(this.b.c(i), Texture.class)));
            }
            return new v3(this.b, (b7<d4>) b7Var, true);
        }
        return (v3) invokeLLLL.objValue;
    }
}
