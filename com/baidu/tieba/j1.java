package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.tieba.o3;
import com.baidu.tieba.v3;
import com.baidu.tieba.w1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class j1 extends i1<o3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o3.a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: g */
    public void c(g1 g1Var, String str, d3 d3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, g1Var, str, d3Var, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends e1<o3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public o3.a f;
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
    public j1(l1 l1Var) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: f */
    public u6<c1> a(String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        o3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, d3Var, aVar)) == null) {
            u6<c1> u6Var = new u6<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return u6Var;
            }
            if (aVar != null && aVar.b) {
                z = true;
            } else {
                z = false;
            }
            this.b = new o3.a(d3Var, z);
            if (aVar != null && (str2 = aVar.g) != null) {
                u6Var.a(new c1(str2, v3.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    d3 b = b(this.b.c(i));
                    w1.b bVar = new w1.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    u6Var.a(new c1(b, Texture.class, bVar));
                }
            }
            return u6Var;
        }
        return (u6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: h */
    public o3 d(g1 g1Var, String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, g1Var, str, d3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = d3Var.s(this.b.b[0]).h().toString();
                v3.a f = ((v3) g1Var.j(str2, v3.class)).f(str3);
                if (f != null) {
                    return new o3(d3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            u6 u6Var = new u6(length);
            for (int i = 0; i < length; i++) {
                u6Var.a(new w3((Texture) g1Var.j(this.b.c(i), Texture.class)));
            }
            return new o3(this.b, (u6<w3>) u6Var, true);
        }
        return (o3) invokeLLLL.objValue;
    }
}
