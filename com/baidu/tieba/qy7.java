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
public class qy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<in> b;
    public bo c;
    public py7 d;
    public uy7 e;
    public oy7 f;
    public sy7 g;
    public ry7 h;
    public ty7 i;
    public vy7 j;

    public qy7(TbPageContext tbPageContext, bo boVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, boVar};
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
        this.c = boVar;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = new ArrayList();
            py7 py7Var = new py7(this.a);
            this.d = py7Var;
            py7Var.x(this.c);
            this.b.add(this.d);
            uy7 uy7Var = new uy7(this.a);
            this.e = uy7Var;
            uy7Var.x(this.c);
            this.b.add(this.e);
            oy7 oy7Var = new oy7(this.a);
            this.f = oy7Var;
            oy7Var.x(this.c);
            this.b.add(this.f);
            sy7 sy7Var = new sy7(this.a);
            this.g = sy7Var;
            sy7Var.x(this.c);
            this.b.add(this.g);
            ry7 ry7Var = new ry7(this.a);
            this.h = ry7Var;
            ry7Var.x(this.c);
            this.b.add(this.h);
            ty7 ty7Var = new ty7(this.a);
            this.i = ty7Var;
            ty7Var.x(this.c);
            this.b.add(this.i);
            vy7 vy7Var = new vy7(this.a);
            this.j = vy7Var;
            vy7Var.x(this.c);
            this.b.add(this.j);
            this.c.addAdapters(this.b);
        }
    }

    public void b() {
        bo boVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (boVar = this.c) != null) {
            boVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void c(List<vn> list) {
        bo boVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (boVar = this.c) != null) {
            boVar.setData(list);
            b();
        }
    }

    public void d(vz4 vz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, vz4Var) == null) {
            for (in inVar : this.b) {
                if (inVar instanceof ny7) {
                    ((ny7) inVar).u(vz4Var);
                }
            }
        }
    }

    public void e(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bdUniqueId) == null) {
            for (in inVar : this.b) {
                inVar.setPageId(bdUniqueId);
            }
        }
    }
}
