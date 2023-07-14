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
/* loaded from: classes6.dex */
public class lf6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l9 a;
    public BdTypeListView b;
    public final List<ln> c;
    public kf6 d;
    public hf6 e;
    public ff6 f;
    public gf6 g;

    public lf6(l9 l9Var, BdTypeListView bdTypeListView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l9Var, bdTypeListView, Boolean.valueOf(z)};
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
        this.a = l9Var;
        this.b = bdTypeListView;
        a(z);
    }

    public final void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (z) {
                hf6 hf6Var = new hf6((TbPageContext) this.a, ag6.c);
                this.e = hf6Var;
                this.c.add(hf6Var);
            } else {
                kf6 kf6Var = new kf6((TbPageContext) this.a, ag6.c);
                this.d = kf6Var;
                this.c.add(kf6Var);
            }
            this.f = new ff6((TbPageContext) this.a, nf6.a);
            this.g = new gf6((TbPageContext) this.a, of6.a);
            this.c.add(this.f);
            this.c.add(this.g);
            this.b.addAdapters(this.c);
        }
    }

    public void b(yb6 yb6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yb6Var) == null) {
            kf6 kf6Var = this.d;
            if (kf6Var != null) {
                kf6Var.u(yb6Var);
            }
            hf6 hf6Var = this.e;
            if (hf6Var != null) {
                hf6Var.u(yb6Var);
            }
        }
    }

    public void c(List<yn> list) {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) && (bdTypeListView = this.b) != null) {
            bdTypeListView.setData(list);
        }
    }
}
