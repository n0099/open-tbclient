package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class my5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r9 a;
    public BdTypeListView b;
    public final List<jn> c;
    public ly5 d;
    public iy5 e;
    public gy5 f;
    public hy5 g;

    public my5(r9 r9Var, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r9Var, bdTypeListView, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new ArrayList();
        this.a = r9Var;
        this.b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                iy5 iy5Var = new iy5((TbPageContext) this.a, cz5.c);
                this.e = iy5Var;
                this.c.add(iy5Var);
            } else {
                ly5 ly5Var = new ly5((TbPageContext) this.a, cz5.c);
                this.d = ly5Var;
                this.c.add(ly5Var);
            }
            this.f = new gy5((TbPageContext) this.a, oy5.a);
            this.g = new hy5((TbPageContext) this.a, py5.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.a(this.c);
        }
    }

    public void b(zu5 zu5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zu5Var) == null) {
            ly5 ly5Var = this.d;
            if (ly5Var != null) {
                ly5Var.u(zu5Var);
            }
            iy5 iy5Var = this.e;
            if (iy5Var != null) {
                iy5Var.u(zu5Var);
            }
        }
    }

    public void c(List<wn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeListView = this.b) != null) {
            bdTypeListView.setData(list);
        }
    }
}
