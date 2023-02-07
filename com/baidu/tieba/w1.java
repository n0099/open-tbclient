package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.tieba.b4;
import com.baidu.tieba.i4;
import com.baidu.tieba.j2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class w1 extends v1<b4, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b4.a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v1
    /* renamed from: g */
    public void c(t1 t1Var, String str, q3 q3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, t1Var, str, q3Var, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends r1<b4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public b4.a f;
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
    public w1(y1 y1Var) {
        super(y1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((y1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u1
    /* renamed from: f */
    public h7<p1> a(String str, q3 q3Var, a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        b4.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, q3Var, aVar)) == null) {
            h7<p1> h7Var = new h7<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return h7Var;
            }
            if (aVar != null && aVar.b) {
                z = true;
            } else {
                z = false;
            }
            this.b = new b4.a(q3Var, z);
            if (aVar != null && (str2 = aVar.g) != null) {
                h7Var.a(new p1(str2, i4.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    q3 b = b(this.b.c(i));
                    j2.b bVar = new j2.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    h7Var.a(new p1(b, Texture.class, bVar));
                }
            }
            return h7Var;
        }
        return (h7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.v1
    /* renamed from: h */
    public b4 d(t1 t1Var, String str, q3 q3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, t1Var, str, q3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = q3Var.s(this.b.b[0]).h().toString();
                i4.a f = ((i4) t1Var.j(str2, i4.class)).f(str3);
                if (f != null) {
                    return new b4(q3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            h7 h7Var = new h7(length);
            for (int i = 0; i < length; i++) {
                h7Var.a(new j4((Texture) t1Var.j(this.b.c(i), Texture.class)));
            }
            return new b4(this.b, (h7<j4>) h7Var, true);
        }
        return (b4) invokeLLLL.objValue;
    }
}
