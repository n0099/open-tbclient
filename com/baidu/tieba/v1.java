package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u6;
import com.baidu.tieba.v3;
import com.baidu.tieba.w1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class v1 extends u1<v3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v3.c b;

    /* loaded from: classes8.dex */
    public static class a extends e1<v3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean b;

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
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(l1 l1Var) {
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
    /* renamed from: d */
    public u6<c1> a(String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, d3Var, aVar)) == null) {
            d3 i = d3Var.i();
            if (aVar != null) {
                this.b = new v3.c(d3Var, i, aVar.b);
            } else {
                this.b = new v3.c(d3Var, i, false);
            }
            u6<c1> u6Var = new u6<>();
            u6.b<v3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                v3.c.p next = it.next();
                w1.b bVar = new w1.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                u6Var.a(new c1(next.a, Texture.class, bVar));
            }
            return u6Var;
        }
        return (u6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u1
    /* renamed from: e */
    public v3 c(g1 g1Var, String str, d3 d3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, g1Var, str, d3Var, aVar)) == null) {
            u6.b<v3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                v3.c.p next = it.next();
                next.b = (Texture) g1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            v3 v3Var = new v3(this.b);
            this.b = null;
            return v3Var;
        }
        return (v3) invokeLLLL.objValue;
    }
}
