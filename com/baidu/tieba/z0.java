package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.tieba.e3;
import com.baidu.tieba.l3;
import com.baidu.tieba.m1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class z0 extends y0<e3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e3.a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: g */
    public void c(w0 w0Var, String str, t2 t2Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, w0Var, str, t2Var, aVar) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public static class a extends u0<e3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public e3.a f;
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
    public z0(b1 b1Var) {
        super(b1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x0
    /* renamed from: f */
    public k6<s0> a(String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        e3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, t2Var, aVar)) == null) {
            k6<s0> k6Var = new k6<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return k6Var;
            }
            if (aVar != null && aVar.b) {
                z = true;
            } else {
                z = false;
            }
            this.b = new e3.a(t2Var, z);
            if (aVar != null && (str2 = aVar.g) != null) {
                k6Var.a(new s0(str2, l3.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    t2 b = b(this.b.c(i));
                    m1.b bVar = new m1.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    k6Var.a(new s0(b, Texture.class, bVar));
                }
            }
            return k6Var;
        }
        return (k6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y0
    /* renamed from: h */
    public e3 d(w0 w0Var, String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, w0Var, str, t2Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = t2Var.s(this.b.b[0]).h().toString();
                l3.a f = ((l3) w0Var.j(str2, l3.class)).f(str3);
                if (f != null) {
                    return new e3(t2Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            k6 k6Var = new k6(length);
            for (int i = 0; i < length; i++) {
                k6Var.a(new m3((Texture) w0Var.j(this.b.c(i), Texture.class)));
            }
            return new e3(this.b, (k6<m3>) k6Var, true);
        }
        return (e3) invokeLLLL.objValue;
    }
}
