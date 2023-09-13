package com.baidu.tieba;

import com.badlogic.gdx.graphics.Cubemap;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k1 extends i1<Cubemap, b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.h1
    /* renamed from: f */
    public u6<c1> a(String str, d3 d3Var, b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, str, d3Var, bVar)) == null) {
            return null;
        }
        return (u6) invokeLLL.objValue;
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public f3 b;
        public Cubemap c;

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
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends e1<Cubemap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Pixmap.Format b;
        public Cubemap c;
        public f3 d;
        public Texture.TextureFilter e;
        public Texture.TextureFilter f;
        public Texture.TextureWrap g;
        public Texture.TextureWrap h;

        public b() {
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
            this.b = null;
            this.c = null;
            this.d = null;
            Texture.TextureFilter textureFilter = Texture.TextureFilter.Nearest;
            this.e = textureFilter;
            this.f = textureFilter;
            Texture.TextureWrap textureWrap = Texture.TextureWrap.ClampToEdge;
            this.g = textureWrap;
            this.h = textureWrap;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k1(l1 l1Var) {
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
        this.b = new a();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: g */
    public void c(g1 g1Var, String str, d3 d3Var, b bVar) {
        f3 f3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, g1Var, str, d3Var, bVar) == null) {
            a aVar = this.b;
            aVar.a = str;
            if (bVar != null && (f3Var = bVar.d) != null) {
                aVar.b = f3Var;
                aVar.c = bVar.c;
            } else {
                a aVar2 = this.b;
                aVar2.c = null;
                if (bVar != null) {
                    Pixmap.Format format = bVar.b;
                    aVar2.c = bVar.c;
                }
                if (str.contains(".ktx") || str.contains(".zktx")) {
                    this.b.b = new p5(d3Var, false);
                }
            }
            if (!this.b.b.isPrepared()) {
                this.b.b.prepare();
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i1
    /* renamed from: h */
    public Cubemap d(g1 g1Var, String str, d3 d3Var, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048581, this, g1Var, str, d3Var, bVar)) == null) {
            a aVar = this.b;
            if (aVar == null) {
                return null;
            }
            Cubemap cubemap = aVar.c;
            if (cubemap != null) {
                cubemap.y(aVar.b);
            } else {
                cubemap = new Cubemap(this.b.b);
            }
            if (bVar != null) {
                cubemap.l(bVar.e, bVar.f);
                cubemap.m(bVar.g, bVar.h);
            }
            return cubemap;
        }
        return (Cubemap) invokeLLLL.objValue;
    }
}
