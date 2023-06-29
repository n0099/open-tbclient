package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.t6;
import com.baidu.tieba.u3;
import com.baidu.tieba.v1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class u1 extends t1<u3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u3.c b;

    /* loaded from: classes8.dex */
    public static class a extends d1<u3> {
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
    public u1(k1 k1Var) {
        super(k1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g1
    /* renamed from: d */
    public t6<b1> a(String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, c3Var, aVar)) == null) {
            c3 i = c3Var.i();
            if (aVar != null) {
                this.b = new u3.c(c3Var, i, aVar.b);
            } else {
                this.b = new u3.c(c3Var, i, false);
            }
            t6<b1> t6Var = new t6<>();
            t6.b<u3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                u3.c.p next = it.next();
                v1.b bVar = new v1.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                t6Var.a(new b1(next.a, Texture.class, bVar));
            }
            return t6Var;
        }
        return (t6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.t1
    /* renamed from: e */
    public u3 c(f1 f1Var, String str, c3 c3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, f1Var, str, c3Var, aVar)) == null) {
            t6.b<u3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                u3.c.p next = it.next();
                next.b = (Texture) f1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            u3 u3Var = new u3(this.b);
            this.b = null;
            return u3Var;
        }
        return (u3) invokeLLLL.objValue;
    }
}
