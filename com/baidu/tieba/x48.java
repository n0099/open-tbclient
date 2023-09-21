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
public class x48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<om> b;
    public hn c;
    public w48 d;
    public b58 e;
    public v48 f;
    public z48 g;
    public y48 h;
    public a58 i;
    public c58 j;

    public x48(TbPageContext tbPageContext, hn hnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hnVar};
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
        this.c = hnVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            w48 w48Var = new w48(this.a);
            this.d = w48Var;
            w48Var.x(this.c);
            this.b.add(this.d);
            b58 b58Var = new b58(this.a);
            this.e = b58Var;
            b58Var.x(this.c);
            this.b.add(this.e);
            v48 v48Var = new v48(this.a);
            this.f = v48Var;
            v48Var.x(this.c);
            this.b.add(this.f);
            z48 z48Var = new z48(this.a);
            this.g = z48Var;
            z48Var.x(this.c);
            this.b.add(this.g);
            y48 y48Var = new y48(this.a);
            this.h = y48Var;
            y48Var.x(this.c);
            this.b.add(this.h);
            a58 a58Var = new a58(this.a);
            this.i = a58Var;
            a58Var.x(this.c);
            this.b.add(this.i);
            c58 c58Var = new c58(this.a);
            this.j = c58Var;
            c58Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (hnVar = this.c) != null) {
            hnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<bn> list) {
        hn hnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (hnVar = this.c) != null) {
            hnVar.setData(list);
            b();
        }
    }

    public void d(wz4 wz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, wz4Var) == null) {
            for (om omVar : this.b) {
                if (omVar instanceof u48) {
                    ((u48) omVar).u(wz4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (om omVar : this.b) {
                omVar.setPageId(bdUniqueId);
            }
        }
    }
}
