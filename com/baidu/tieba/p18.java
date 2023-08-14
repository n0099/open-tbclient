package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class p18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<lm> b;
    public en c;
    public o18 d;
    public t18 e;
    public n18 f;
    public r18 g;
    public q18 h;
    public s18 i;
    public u18 j;

    public p18(TbPageContext tbPageContext, en enVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, enVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.c = enVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            o18 o18Var = new o18(this.a);
            this.d = o18Var;
            o18Var.x(this.c);
            this.b.add(this.d);
            t18 t18Var = new t18(this.a);
            this.e = t18Var;
            t18Var.x(this.c);
            this.b.add(this.e);
            n18 n18Var = new n18(this.a);
            this.f = n18Var;
            n18Var.x(this.c);
            this.b.add(this.f);
            r18 r18Var = new r18(this.a);
            this.g = r18Var;
            r18Var.x(this.c);
            this.b.add(this.g);
            q18 q18Var = new q18(this.a);
            this.h = q18Var;
            q18Var.x(this.c);
            this.b.add(this.h);
            s18 s18Var = new s18(this.a);
            this.i = s18Var;
            s18Var.x(this.c);
            this.b.add(this.i);
            u18 u18Var = new u18(this.a);
            this.j = u18Var;
            u18Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        en enVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (enVar = this.c) != null) {
            enVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<ym> list) {
        en enVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (enVar = this.c) != null) {
            enVar.setData(list);
            b();
        }
    }

    public void d(mz4 mz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, mz4Var) == null) {
            for (lm lmVar : this.b) {
                if (lmVar instanceof m18) {
                    ((m18) lmVar).u(mz4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (lm lmVar : this.b) {
                lmVar.setPageId(bdUniqueId);
            }
        }
    }
}
