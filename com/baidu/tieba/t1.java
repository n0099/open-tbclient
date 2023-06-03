package com.baidu.tieba;

import com.badlogic.gdx.graphics.Texture;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.s6;
import com.baidu.tieba.t3;
import com.baidu.tieba.u1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t1 extends s1<t3, a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public t3.c b;

    /* loaded from: classes7.dex */
    public static class a extends c1<t3> {
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
    public t1(j1 j1Var) {
        super(j1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f1
    /* renamed from: d */
    public s6<a1> a(String str, b3 b3Var, a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, b3Var, aVar)) == null) {
            b3 i = b3Var.i();
            if (aVar != null) {
                this.b = new t3.c(b3Var, i, aVar.b);
            } else {
                this.b = new t3.c(b3Var, i, false);
            }
            s6<a1> s6Var = new s6<>();
            s6.b<t3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                t3.c.p next = it.next();
                u1.b bVar = new u1.b();
                bVar.b = next.f;
                bVar.c = next.e;
                bVar.f = next.g;
                bVar.g = next.h;
                s6Var.a(new a1(next.a, Texture.class, bVar));
            }
            return s6Var;
        }
        return (s6) invokeLLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s1
    /* renamed from: e */
    public t3 c(e1 e1Var, String str, b3 b3Var, a aVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, e1Var, str, b3Var, aVar)) == null) {
            s6.b<t3.c.p> it = this.b.a().iterator();
            while (it.hasNext()) {
                t3.c.p next = it.next();
                next.b = (Texture) e1Var.j(next.a.j().replaceAll("\\\\", "/"), Texture.class);
            }
            t3 t3Var = new t3(this.b);
            this.b = null;
            return t3Var;
        }
        return (t3) invokeLLLL.objValue;
    }
}
