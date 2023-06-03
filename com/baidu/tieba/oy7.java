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
public class oy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public List<in> b;
    public bo c;
    public ny7 d;
    public sy7 e;
    public my7 f;
    public qy7 g;
    public py7 h;
    public ry7 i;
    public ty7 j;

    public oy7(TbPageContext tbPageContext, bo boVar) {
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
            ny7 ny7Var = new ny7(this.a);
            this.d = ny7Var;
            ny7Var.x(this.c);
            this.b.add(this.d);
            sy7 sy7Var = new sy7(this.a);
            this.e = sy7Var;
            sy7Var.x(this.c);
            this.b.add(this.e);
            my7 my7Var = new my7(this.a);
            this.f = my7Var;
            my7Var.x(this.c);
            this.b.add(this.f);
            qy7 qy7Var = new qy7(this.a);
            this.g = qy7Var;
            qy7Var.x(this.c);
            this.b.add(this.g);
            py7 py7Var = new py7(this.a);
            this.h = py7Var;
            py7Var.x(this.c);
            this.b.add(this.h);
            ry7 ry7Var = new ry7(this.a);
            this.i = ry7Var;
            ry7Var.x(this.c);
            this.b.add(this.i);
            ty7 ty7Var = new ty7(this.a);
            this.j = ty7Var;
            ty7Var.x(this.c);
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
                if (inVar instanceof ly7) {
                    ((ly7) inVar).u(vz4Var);
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
