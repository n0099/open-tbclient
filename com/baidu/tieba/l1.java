package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.k6;
import com.baidu.tieba.l3;
import com.baidu.tieba.m1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class l1 extends k1<l3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l3.c b;

    /* loaded from: classes5.dex */
    public static class a extends u0<l3> {
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
    public l1(b1 b1Var) {
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
    /* renamed from: d */
    public k6<s0> a(String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, t2Var, aVar)) == null) {
            t2 i = t2Var.i();
            if (aVar != null) {
                this.b = new l3.c(t2Var, i, aVar.b);
            } else {
                this.b = new l3.c(t2Var, i, false);
            }
            k6<s0> k6Var = new k6<>();
            k6.b<l3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                l3.c.p next = it.next();
                m1.b bVar = new m1.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                k6Var.a(new s0(next.a, Texture.class, bVar));
            }
            return k6Var;
        }
        return (k6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k1
    /* renamed from: e */
    public l3 c(w0 w0Var, String str, t2 t2Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, w0Var, str, t2Var, aVar)) == null) {
            k6.b<l3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                l3.c.p next = it.next();
                next.b = (Texture) w0Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            l3 l3Var = new l3(this.b);
            this.b = null;
            return l3Var;
        }
        return (l3) invokeLLLL.objValue;
    }
}
