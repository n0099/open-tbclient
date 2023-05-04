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
/* loaded from: classes6.dex */
public class qr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<vm> b;
    public on c;
    public pr7 d;
    public ur7 e;
    public or7 f;
    public sr7 g;
    public rr7 h;
    public tr7 i;
    public vr7 j;

    public qr7(TbPageContext tbPageContext, on onVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onVar};
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
        this.c = onVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            pr7 pr7Var = new pr7(this.a);
            this.d = pr7Var;
            pr7Var.x(this.c);
            this.b.add(this.d);
            ur7 ur7Var = new ur7(this.a);
            this.e = ur7Var;
            ur7Var.x(this.c);
            this.b.add(this.e);
            or7 or7Var = new or7(this.a);
            this.f = or7Var;
            or7Var.x(this.c);
            this.b.add(this.f);
            sr7 sr7Var = new sr7(this.a);
            this.g = sr7Var;
            sr7Var.x(this.c);
            this.b.add(this.g);
            rr7 rr7Var = new rr7(this.a);
            this.h = rr7Var;
            rr7Var.x(this.c);
            this.b.add(this.h);
            tr7 tr7Var = new tr7(this.a);
            this.i = tr7Var;
            tr7Var.x(this.c);
            this.b.add(this.i);
            vr7 vr7Var = new vr7(this.a);
            this.j = vr7Var;
            vr7Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        on onVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (onVar = this.c) != null) {
            onVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<in> list) {
        on onVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (onVar = this.c) != null) {
            onVar.setData(list);
            b();
        }
    }

    public void d(qv4 qv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qv4Var) == null) {
            for (vm vmVar : this.b) {
                if (vmVar instanceof nr7) {
                    ((nr7) vmVar).u(qv4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (vm vmVar : this.b) {
                vmVar.setPageId(bdUniqueId);
            }
        }
    }
}
