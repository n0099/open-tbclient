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
public class iz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<kn> b;
    public Cdo c;
    public hz7 d;
    public mz7 e;
    public gz7 f;
    public kz7 g;
    public jz7 h;
    public lz7 i;
    public nz7 j;

    public iz7(TbPageContext tbPageContext, Cdo cdo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, cdo};
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
        this.c = cdo;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            hz7 hz7Var = new hz7(this.a);
            this.d = hz7Var;
            hz7Var.x(this.c);
            this.b.add(this.d);
            mz7 mz7Var = new mz7(this.a);
            this.e = mz7Var;
            mz7Var.x(this.c);
            this.b.add(this.e);
            gz7 gz7Var = new gz7(this.a);
            this.f = gz7Var;
            gz7Var.x(this.c);
            this.b.add(this.f);
            kz7 kz7Var = new kz7(this.a);
            this.g = kz7Var;
            kz7Var.x(this.c);
            this.b.add(this.g);
            jz7 jz7Var = new jz7(this.a);
            this.h = jz7Var;
            jz7Var.x(this.c);
            this.b.add(this.h);
            lz7 lz7Var = new lz7(this.a);
            this.i = lz7Var;
            lz7Var.x(this.c);
            this.b.add(this.i);
            nz7 nz7Var = new nz7(this.a);
            this.j = nz7Var;
            nz7Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cdo = this.c) != null) {
            cdo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<xn> list) {
        Cdo cdo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (cdo = this.c) != null) {
            cdo.setData(list);
            b();
        }
    }

    public void d(zz4 zz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, zz4Var) == null) {
            for (kn knVar : this.b) {
                if (knVar instanceof fz7) {
                    ((fz7) knVar).u(zz4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (kn knVar : this.b) {
                knVar.setPageId(bdUniqueId);
            }
        }
    }
}
