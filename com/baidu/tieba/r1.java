package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.tieba.d4;
import com.baidu.tieba.e2;
import com.baidu.tieba.w3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class r1 extends q1<w3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public w3.a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: g */
    public void c(o1 o1Var, String str, l3 l3Var, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, o1Var, str, l3Var, aVar) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends m1<w3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;
        public boolean c;
        public Texture.TextureFilter d;
        public Texture.TextureFilter e;
        public w3.a f;
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
    public r1(t1 t1Var) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.p1
    /* renamed from: f */
    public c7<k1> a(String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLL;
        boolean z;
        String str2;
        w3.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, l3Var, aVar)) == null) {
            c7<k1> c7Var = new c7<>();
            if (aVar != null && (aVar2 = aVar.f) != null) {
                this.b = aVar2;
                return c7Var;
            }
            if (aVar != null && aVar.b) {
                z = true;
            } else {
                z = false;
            }
            this.b = new w3.a(l3Var, z);
            if (aVar != null && (str2 = aVar.g) != null) {
                c7Var.a(new k1(str2, d4.class));
            } else {
                for (int i = 0; i < this.b.d().length; i++) {
                    l3 b = b(this.b.c(i));
                    e2.b bVar = new e2.b();
                    if (aVar != null) {
                        bVar.c = aVar.c;
                        bVar.f = aVar.d;
                        bVar.g = aVar.e;
                    }
                    c7Var.a(new k1(b, Texture.class, bVar));
                }
            }
            return c7Var;
        }
        return (c7) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q1
    /* renamed from: h */
    public w3 d(o1 o1Var, String str, l3 l3Var, a aVar) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, o1Var, str, l3Var, aVar)) == null) {
            if (aVar != null && (str2 = aVar.g) != null) {
                String str3 = l3Var.s(this.b.b[0]).h().toString();
                d4.a f = ((d4) o1Var.j(str2, d4.class)).f(str3);
                if (f != null) {
                    return new w3(l3Var, f);
                }
                throw new GdxRuntimeException("Could not find font region " + str3 + " in atlas " + aVar.g);
            }
            int length = this.b.d().length;
            c7 c7Var = new c7(length);
            for (int i = 0; i < length; i++) {
                c7Var.a(new e4((Texture) o1Var.j(this.b.c(i), Texture.class)));
            }
            return new w3(this.b, (c7<e4>) c7Var, true);
        }
        return (w3) invokeLLLL.objValue;
    }
}
