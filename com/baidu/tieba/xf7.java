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
public class xf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<tm> b;
    public mn c;
    public wf7 d;
    public bg7 e;
    public vf7 f;
    public zf7 g;
    public yf7 h;
    public ag7 i;
    public cg7 j;

    public xf7(TbPageContext tbPageContext, mn mnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, mnVar};
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
        this.c = mnVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            wf7 wf7Var = new wf7(this.a);
            this.d = wf7Var;
            wf7Var.x(this.c);
            this.b.add(this.d);
            bg7 bg7Var = new bg7(this.a);
            this.e = bg7Var;
            bg7Var.x(this.c);
            this.b.add(this.e);
            vf7 vf7Var = new vf7(this.a);
            this.f = vf7Var;
            vf7Var.x(this.c);
            this.b.add(this.f);
            zf7 zf7Var = new zf7(this.a);
            this.g = zf7Var;
            zf7Var.x(this.c);
            this.b.add(this.g);
            yf7 yf7Var = new yf7(this.a);
            this.h = yf7Var;
            yf7Var.x(this.c);
            this.b.add(this.h);
            ag7 ag7Var = new ag7(this.a);
            this.i = ag7Var;
            ag7Var.x(this.c);
            this.b.add(this.i);
            cg7 cg7Var = new cg7(this.a);
            this.j = cg7Var;
            cg7Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        mn mnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (mnVar = this.c) != null) {
            mnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<gn> list) {
        mn mnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (mnVar = this.c) != null) {
            mnVar.setData(list);
            b();
        }
    }

    public void d(xu4 xu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, xu4Var) == null) {
            for (tm tmVar : this.b) {
                if (tmVar instanceof uf7) {
                    ((uf7) tmVar).u(xu4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (tm tmVar : this.b) {
                tmVar.setPageId(bdUniqueId);
            }
        }
    }
}
