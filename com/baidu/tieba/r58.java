package com.baidu.tieba;

import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
public class r58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext b;
    public NoNetworkView c;
    public NavigationBar d;
    public BdTypeListView e;
    public w48 f;
    public my8 g;
    public View h;
    public FrameLayout i;
    public t85 j;
    public d k;
    public AbsListView.OnScrollListener l;
    public CustomMessageListener m;

    /* loaded from: classes5.dex */
    public class a implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r58 a;

        public a(r58 r58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r58Var;
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
                    this.a.f.h();
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
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(r58 r58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r58Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921739 || !(customResponsedMessage.getData() instanceof Integer) || (num = (Integer) customResponsedMessage.getData()) == null || num.intValue() == -1) {
                return;
            }
            this.a.e.setSelection(num.intValue());
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r58 a;

        public c(r58 r58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r58Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                this.a.g();
                if (this.a.k != null) {
                    this.a.k.a(view2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a(View view2);
    }

    public r58(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        this.m = new b(this, 2921739);
        if (view2 == null) {
            return;
        }
        this.b = tbPageContext;
        this.c = (NoNetworkView) view2.findViewById(R.id.obfuscated_res_0x7f0918fc);
        this.d = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f0918fb);
        this.i = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f091283);
        this.e = (BdTypeListView) view2.findViewById(R.id.obfuscated_res_0x7f0918eb);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, (int) tbPageContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f07026c));
        View view3 = new View(tbPageContext.getPageActivity());
        this.h = view3;
        view3.setLayoutParams(layoutParams);
        this.e.addFooterView(this.h);
        this.e.setOnScrollListener(this.l);
        this.f = new w48(this.e, tbPageContext, bdUniqueId);
        this.g = new my8(this.b, 1);
    }

    public void f() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (w48Var = this.f) == null) {
            return;
        }
        w48Var.a();
    }

    public void g() {
        t85 t85Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (t85Var = this.j) == null) {
            return;
        }
        t85Var.dettachView(this.i);
        this.j = null;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.q(this.b.getPageActivity(), this.d);
            this.g.n();
            this.g.s(null);
            k(TbadkCoreApplication.getInst().getSkinType());
            this.b.registerListener(this.m);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            t85 t85Var = this.j;
            if (t85Var != null) {
                return t85Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f.b();
        }
    }

    public void k(int i) {
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
        this.g.p(i);
        t85 t85Var = this.j;
        if (t85Var != null) {
            t85Var.onChangeSkinType();
        }
        this.a = i;
    }

    public void l() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (w48Var = this.f) == null) {
            return;
        }
        w48Var.d();
    }

    public void m() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (w48Var = this.f) == null) {
            return;
        }
        w48Var.e();
    }

    public void n(boolean z) {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (w48Var = this.f) == null) {
            return;
        }
        w48Var.f(z);
    }

    public void o() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (w48Var = this.f) == null) {
            return;
        }
        w48Var.g();
    }

    public void p(c58 c58Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, c58Var) == null) || c58Var == null) {
            return;
        }
        this.f.i(c58Var.t());
        this.g.t(c58Var.w());
    }

    public void q(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.k = dVar;
        }
    }

    public void r(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.g.u(str);
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.g.r(i);
            this.g.v(6, true);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || i()) {
            return;
        }
        if (this.j == null) {
            this.j = new t85(this.b.getPageActivity(), new c(this));
        }
        this.j.attachView(this.i, false);
        this.j.p();
        this.j.onChangeSkinType();
    }

    public void u(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            this.g.v(i, z);
        }
    }

    public void v() {
        w48 w48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (w48Var = this.f) == null) {
            return;
        }
        w48Var.j();
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? s38.a().b() != 1 : invokeV.booleanValue;
    }
}
