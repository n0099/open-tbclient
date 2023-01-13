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
/* loaded from: classes5.dex */
public class j77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<ln> b;
    public eo c;
    public i77 d;
    public n77 e;
    public h77 f;
    public l77 g;
    public k77 h;
    public m77 i;
    public o77 j;

    public j77(TbPageContext tbPageContext, eo eoVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, eoVar};
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
        this.c = eoVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            i77 i77Var = new i77(this.a);
            this.d = i77Var;
            i77Var.v(this.c);
            this.b.add(this.d);
            n77 n77Var = new n77(this.a);
            this.e = n77Var;
            n77Var.v(this.c);
            this.b.add(this.e);
            h77 h77Var = new h77(this.a);
            this.f = h77Var;
            h77Var.v(this.c);
            this.b.add(this.f);
            l77 l77Var = new l77(this.a);
            this.g = l77Var;
            l77Var.v(this.c);
            this.b.add(this.g);
            k77 k77Var = new k77(this.a);
            this.h = k77Var;
            k77Var.v(this.c);
            this.b.add(this.h);
            m77 m77Var = new m77(this.a);
            this.i = m77Var;
            m77Var.v(this.c);
            this.b.add(this.i);
            o77 o77Var = new o77(this.a);
            this.j = o77Var;
            o77Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (eoVar = this.c) != null) {
            eoVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<yn> list) {
        eo eoVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (eoVar = this.c) != null) {
            eoVar.setData(list);
            b();
        }
    }

    public void d(vq4 vq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vq4Var) == null) {
            for (ln lnVar : this.b) {
                if (lnVar instanceof g77) {
                    ((g77) lnVar).u(vq4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (ln lnVar : this.b) {
                lnVar.setPageId(bdUniqueId);
            }
        }
    }
}
