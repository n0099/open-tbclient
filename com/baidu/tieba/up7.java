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
public class up7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<um> b;
    public nn c;
    public tp7 d;
    public yp7 e;
    public sp7 f;
    public wp7 g;
    public vp7 h;
    public xp7 i;
    public zp7 j;

    public up7(TbPageContext tbPageContext, nn nnVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, nnVar};
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
        this.c = nnVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            tp7 tp7Var = new tp7(this.a);
            this.d = tp7Var;
            tp7Var.x(this.c);
            this.b.add(this.d);
            yp7 yp7Var = new yp7(this.a);
            this.e = yp7Var;
            yp7Var.x(this.c);
            this.b.add(this.e);
            sp7 sp7Var = new sp7(this.a);
            this.f = sp7Var;
            sp7Var.x(this.c);
            this.b.add(this.f);
            wp7 wp7Var = new wp7(this.a);
            this.g = wp7Var;
            wp7Var.x(this.c);
            this.b.add(this.g);
            vp7 vp7Var = new vp7(this.a);
            this.h = vp7Var;
            vp7Var.x(this.c);
            this.b.add(this.h);
            xp7 xp7Var = new xp7(this.a);
            this.i = xp7Var;
            xp7Var.x(this.c);
            this.b.add(this.i);
            zp7 zp7Var = new zp7(this.a);
            this.j = zp7Var;
            zp7Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        nn nnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (nnVar = this.c) != null) {
            nnVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<hn> list) {
        nn nnVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (nnVar = this.c) != null) {
            nnVar.setData(list);
            b();
        }
    }

    public void d(zu4 zu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zu4Var) == null) {
            for (um umVar : this.b) {
                if (umVar instanceof rp7) {
                    ((rp7) umVar).u(zu4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (um umVar : this.b) {
                umVar.setPageId(bdUniqueId);
            }
        }
    }
}
