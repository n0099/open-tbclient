package com.baidu.tieba;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class p86 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdTypeListView b;
    public List<vm> c;
    public List<in> d;
    public r96 e;
    public v86 f;

    public p86(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView, r96 r96Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, r96Var};
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
        this.b = bdTypeListView;
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = r96Var;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o86 o86Var = new o86(this.a);
            s86 s86Var = new s86(this.a);
            t86 t86Var = new t86(this.a);
            m86 m86Var = new m86(this.a);
            r86 r86Var = new r86(this.a);
            u86 u86Var = new u86(this.a);
            q86 q86Var = new q86(this.a);
            n86 n86Var = new n86(this.a);
            this.f = new v86(this.a);
            x86 x86Var = new x86(this.a, this.e);
            w86 w86Var = new w86(this.a);
            this.c.add(o86Var);
            this.c.add(this.f);
            this.c.add(s86Var);
            this.c.add(t86Var);
            this.c.add(m86Var);
            this.c.add(r86Var);
            this.c.add(u86Var);
            this.c.add(q86Var);
            this.c.add(n86Var);
            this.c.add(x86Var);
            this.c.add(w86Var);
            this.b.addAdapters(this.c);
        }
    }

    public void b(List<in> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) && this.b != null && !ListUtils.isEmpty(list)) {
            this.d.clear();
            this.d.addAll(list);
            this.b.setData(this.d);
        }
    }

    public void c(String str) {
        v86 v86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (v86Var = this.f) != null) {
            v86Var.F(str);
        }
    }

    public void d(String str) {
        v86 v86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && (v86Var = this.f) != null) {
            v86Var.a(str);
        }
    }

    public void e(String str) {
        v86 v86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, str) == null) && (v86Var = this.f) != null) {
            v86Var.G(str);
        }
    }

    public void f(boolean z) {
        v86 v86Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048581, this, z) == null) && (v86Var = this.f) != null) {
            v86Var.H(z);
        }
    }
}
