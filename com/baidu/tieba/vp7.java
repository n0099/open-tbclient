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
public class vp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<vm> b;
    public on c;
    public up7 d;
    public zp7 e;
    public tp7 f;
    public xp7 g;
    public wp7 h;
    public yp7 i;
    public aq7 j;

    public vp7(TbPageContext tbPageContext, on onVar) {
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
            up7 up7Var = new up7(this.a);
            this.d = up7Var;
            up7Var.x(this.c);
            this.b.add(this.d);
            zp7 zp7Var = new zp7(this.a);
            this.e = zp7Var;
            zp7Var.x(this.c);
            this.b.add(this.e);
            tp7 tp7Var = new tp7(this.a);
            this.f = tp7Var;
            tp7Var.x(this.c);
            this.b.add(this.f);
            xp7 xp7Var = new xp7(this.a);
            this.g = xp7Var;
            xp7Var.x(this.c);
            this.b.add(this.g);
            wp7 wp7Var = new wp7(this.a);
            this.h = wp7Var;
            wp7Var.x(this.c);
            this.b.add(this.h);
            yp7 yp7Var = new yp7(this.a);
            this.i = yp7Var;
            yp7Var.x(this.c);
            this.b.add(this.i);
            aq7 aq7Var = new aq7(this.a);
            this.j = aq7Var;
            aq7Var.x(this.c);
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

    public void d(av4 av4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, av4Var) == null) {
            for (vm vmVar : this.b) {
                if (vmVar instanceof sp7) {
                    ((sp7) vmVar).u(av4Var);
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
