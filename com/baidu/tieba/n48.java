package com.baidu.tieba;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class n48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public NoNetworkView c;
    public NavigationBar d;
    public BdTypeListView e;
    public u38 f;
    public ww8 g;
    public View h;
    public FrameLayout i;
    public n65 j;
    public c k;
    public AbsListView.OnScrollListener l;

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n48 a;

        public a(n48 n48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n48Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                if (i == 0) {
                    absListView.getChildAt(0);
                }
                if (i == 0 || i == 1) {
                    SkinManager.setBackgroundColor(this.a.d, R.color.CAM_X0204, this.a.a);
                } else {
                    SkinManager.setBackgroundColor(this.a.d, R.color.CAM_X0205, this.a.a);
                }
                if (this.a.f != null) {
                    this.a.f.d();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n48 a;

        public b(n48 n48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n48Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && pi.A()) {
                this.a.f();
                if (this.a.k != null) {
                    this.a.k.a(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(View view2);
    }

    public n48(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.l = new a(this);
        if (view2 == null) {
            return;
        }
        this.b = tbPageContext;
        this.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f0918c5);
        this.d = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0918c4);
        this.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091265);
        this.e = (BdTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f0918b4);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f07026c));
        View view3 = new View(tbPageContext.getPageActivity());
        this.h = view3;
        view3.setLayoutParams(layoutParams);
        this.e.addFooterView(this.h);
        this.e.setOnScrollListener(this.l);
        this.f = new u38(this.e, tbPageContext, bdUniqueId);
        this.g = new ww8(1);
    }

    public void e() {
        u38 u38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (u38Var = this.f) == null) {
            return;
        }
        u38Var.a();
    }

    public void f() {
        n65 n65Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (n65Var = this.j) == null) {
            return;
        }
        n65Var.dettachView(this.i);
        this.j = null;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.n(this.b.getPageActivity(), this.d);
            this.g.k();
            this.g.o(null);
            j(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            n65 n65Var = this.j;
            if (n65Var != null) {
                return n65Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.b();
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
        this.d.onChangeSkinType(this.b, i);
        SkinManager.setBackgroundColor(this.d.getBarBgView(), R.color.CAM_X0204, i);
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0204, i);
        this.f.c();
        this.c.d(this.b, i);
        this.g.m(i);
        n65 n65Var = this.j;
        if (n65Var != null) {
            n65Var.onChangeSkinType();
        }
        this.a = i;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void l(z38 z38Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, z38Var) == null) || z38Var == null) {
            return;
        }
        this.f.e(z38Var.q());
    }

    public void m(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cVar) == null) {
            this.k = cVar;
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || h()) {
            return;
        }
        if (this.j == null) {
            this.j = new n65(this.b.getPageActivity(), new b(this));
        }
        this.j.attachView(this.i, false);
        this.j.p();
        this.j.onChangeSkinType();
    }

    public void o(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.g.p(i, z);
        }
    }

    public void p() {
        u38 u38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (u38Var = this.f) == null) {
            return;
        }
        u38Var.f();
    }
}
