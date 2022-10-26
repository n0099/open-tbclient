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
public class s07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List b;
    public ko c;
    public r07 d;
    public w07 e;
    public q07 f;
    public u07 g;
    public t07 h;
    public v07 i;
    public x07 j;

    public s07(TbPageContext tbPageContext, ko koVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, koVar};
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
        this.c = koVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            r07 r07Var = new r07(this.a);
            this.d = r07Var;
            r07Var.v(this.c);
            this.b.add(this.d);
            w07 w07Var = new w07(this.a);
            this.e = w07Var;
            w07Var.v(this.c);
            this.b.add(this.e);
            q07 q07Var = new q07(this.a);
            this.f = q07Var;
            q07Var.v(this.c);
            this.b.add(this.f);
            u07 u07Var = new u07(this.a);
            this.g = u07Var;
            u07Var.v(this.c);
            this.b.add(this.g);
            t07 t07Var = new t07(this.a);
            this.h = t07Var;
            t07Var.v(this.c);
            this.b.add(this.h);
            v07 v07Var = new v07(this.a);
            this.i = v07Var;
            v07Var.v(this.c);
            this.b.add(this.i);
            x07 x07Var = new x07(this.a);
            this.j = x07Var;
            x07Var.v(this.c);
            this.b.add(this.j);
            this.c.a(this.b);
        }
    }

    public void b() {
        ko koVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (koVar = this.c) != null) {
            koVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List list) {
        ko koVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (koVar = this.c) != null) {
            koVar.setData(list);
            b();
        }
    }

    public void d(rp4 rp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, rp4Var) == null) {
            for (rn rnVar : this.b) {
                if (rnVar instanceof p07) {
                    ((p07) rnVar).u(rp4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (rn rnVar : this.b) {
                rnVar.setPageId(bdUniqueId);
            }
        }
    }
}
