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
/* loaded from: classes8.dex */
public class v48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<pm> b;
    public in c;
    public u48 d;
    public z48 e;
    public t48 f;
    public x48 g;
    public w48 h;
    public y48 i;
    public a58 j;

    public v48(TbPageContext tbPageContext, in inVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, inVar};
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
        this.c = inVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            u48 u48Var = new u48(this.a);
            this.d = u48Var;
            u48Var.x(this.c);
            this.b.add(this.d);
            z48 z48Var = new z48(this.a);
            this.e = z48Var;
            z48Var.x(this.c);
            this.b.add(this.e);
            t48 t48Var = new t48(this.a);
            this.f = t48Var;
            t48Var.x(this.c);
            this.b.add(this.f);
            x48 x48Var = new x48(this.a);
            this.g = x48Var;
            x48Var.x(this.c);
            this.b.add(this.g);
            w48 w48Var = new w48(this.a);
            this.h = w48Var;
            w48Var.x(this.c);
            this.b.add(this.h);
            y48 y48Var = new y48(this.a);
            this.i = y48Var;
            y48Var.x(this.c);
            this.b.add(this.i);
            a58 a58Var = new a58(this.a);
            this.j = a58Var;
            a58Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        in inVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (inVar = this.c) != null) {
            inVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<cn> list) {
        in inVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (inVar = this.c) != null) {
            inVar.setData(list);
            b();
        }
    }

    public void d(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wz4Var) == null) {
            for (pm pmVar : this.b) {
                if (pmVar instanceof s48) {
                    ((s48) pmVar).u(wz4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (pm pmVar : this.b) {
                pmVar.setPageId(bdUniqueId);
            }
        }
    }
}
