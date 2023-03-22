package com.baidu.tieba;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.forumSquare.adapter.LeftAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class vu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public RelativeLayout c;
    public ForumHeaderView d;
    public NavigationBar e;
    public TextView f;
    public View g;
    public cv6 h;
    public RelativeLayout i;
    public kf5 j;
    public lf5 k;
    public NoDataView l;
    public View.OnClickListener m;
    public final TbPageContext n;
    public CustomMessageListener o;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vu6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(vu6 vu6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vu6Var, Integer.valueOf(i)};
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
            this.a = vu6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304) {
                this.a.a(TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public vu6(Context context, TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this, 2001304);
        this.a = context;
        this.n = tbPageContext;
        this.b = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d02e7, (ViewGroup) null);
        l();
        k();
    }

    public void A(BdListView.p pVar) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) && (cv6Var = this.h) != null) {
            cv6Var.v(pVar);
        }
    }

    public void B(String str) {
        ForumHeaderView forumHeaderView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && (forumHeaderView = this.d) != null) {
            forumHeaderView.setSearchHint(str);
        }
    }

    public void C(String str) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (cv6Var = this.h) != null) {
            cv6Var.x(str);
        }
    }

    public void D(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            View view2 = this.g;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public boolean F(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (z) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    p();
                    return true;
                }
                q();
                return true;
            }
            o();
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void t(List<gn> list) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, list) == null) && (cv6Var = this.h) != null) {
            cv6Var.p(list);
        }
    }

    public void w(View.OnClickListener onClickListener) {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) && (textView = this.f) != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void x(LeftAdapter.b bVar) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) && (cv6Var = this.h) != null) {
            cv6Var.t(bVar);
        }
    }

    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public void z(RecyclerView.OnScrollListener onScrollListener) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, onScrollListener) == null) && (cv6Var = this.h) != null) {
            cv6Var.u(onScrollListener);
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            h();
            i();
            j();
            cv6 cv6Var = this.h;
            if (cv6Var != null) {
                cv6Var.y(true);
                this.h.w(8);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            i();
            j();
            H(true);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            h();
            j();
            I(true);
            cv6 cv6Var = this.h;
            if (cv6Var != null) {
                cv6Var.s(8);
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            h();
            i();
            j();
            cv6 cv6Var = this.h;
            if (cv6Var != null) {
                cv6Var.f();
                this.h.s(0);
            }
        }
    }

    public Pair<Integer, Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            cv6 cv6Var = this.h;
            if (cv6Var != null) {
                return cv6Var.c();
            }
            return new Pair<>(0, 0);
        }
        return (Pair) invokeV.objValue;
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.h.d();
        }
        return (String) invokeV.objValue;
    }

    public void g() {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (cv6Var = this.h) != null) {
            cv6Var.e();
        }
    }

    public void h() {
        kf5 kf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && (kf5Var = this.j) != null) {
            kf5Var.dettachView(this.i);
            this.j = null;
        }
    }

    public void i() {
        lf5 lf5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (lf5Var = this.k) != null) {
            lf5Var.dettachView(this.i);
            this.k = null;
        }
    }

    public void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (noDataView = this.l) != null) {
            noDataView.setVisibility(8);
        }
    }

    public final void k() {
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (tbPageContext = this.n) != null) {
            tbPageContext.registerListener(this.o);
        }
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            kf5 kf5Var = this.j;
            if (kf5Var != null) {
                return kf5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            lf5 lf5Var = this.k;
            if (lf5Var != null) {
                return lf5Var.isViewAttached();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (cv6Var = this.h) != null) {
            cv6Var.j();
        }
    }

    public void p() {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (cv6Var = this.h) != null) {
            cv6Var.k();
        }
    }

    public void q() {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (cv6Var = this.h) != null) {
            cv6Var.l();
        }
    }

    public void v() {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (cv6Var = this.h) != null) {
            cv6Var.r();
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048583, this, z) != null) || m()) {
            return;
        }
        if (this.j == null) {
            kf5 kf5Var = new kf5(this.a);
            this.j = kf5Var;
            kf5Var.t(hi.g(this.a, R.dimen.obfuscated_res_0x7f070289));
        }
        this.j.onChangeSkinType();
        this.j.attachView(this.i, z);
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || n()) {
            return;
        }
        if (this.k == null) {
            lf5 lf5Var = new lf5(this.a, this.m);
            this.k = lf5Var;
            lf5Var.k(hi.g(this.a, R.dimen.obfuscated_res_0x7f070289));
        }
        this.k.attachView(this.i, z);
        this.k.p();
    }

    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            ForumHeaderView forumHeaderView = this.d;
            if (forumHeaderView != null) {
                forumHeaderView.b();
            }
            NavigationBar navigationBar = this.e;
            if (navigationBar != null && this.a != null) {
                navigationBar.onChangeSkinType(this.n, i);
            }
            cv6 cv6Var = this.h;
            if (cv6Var != null) {
                cv6Var.m(i);
            }
            kf5 kf5Var = this.j;
            if (kf5Var != null) {
                kf5Var.onChangeSkinType();
            }
            lf5 lf5Var = this.k;
            if (lf5Var != null) {
                lf5Var.onChangeSkinType();
            }
            NoDataView noDataView = this.l;
            if (noDataView != null && this.a != null) {
                noDataView.setSubTitleTextColor(R.color.CAM_X0105);
                this.l.f(this.n, i);
            }
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0105, 1);
            SkinManager.setBackgroundColor(this.b, R.color.CAM_X0205);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0207);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0207, i);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.e.setVisibility(8);
            this.d.setVisibility(8);
            this.c.setVisibility(8);
            ((LinearLayout.LayoutParams) this.i.getLayoutParams()).bottomMargin = hi.g(this.n.getPageActivity(), R.dimen.tbds22);
        }
    }

    public void c() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                i = UtilHelper.getStatusBarHeight();
            } else {
                i = 0;
            }
            int g = i + hi.g(this.a, R.dimen.tbds238);
            RelativeLayout relativeLayout = this.i;
            if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
                layoutParams.setMargins(layoutParams.leftMargin, g, layoutParams.rightMargin, layoutParams.bottomMargin);
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            NavigationBar navigationBar = (NavigationBar) this.b.findViewById(R.id.navigation_bar);
            this.e = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.e.setCenterTextTitle(this.a.getString(R.string.obfuscated_res_0x7f0f071f));
            View addCustomView = this.e.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.g = addCustomView;
            TextView textView = (TextView) addCustomView.findViewById(R.id.right_textview);
            this.f = textView;
            textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0720));
            this.c = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090b74);
            ForumHeaderView forumHeaderView = (ForumHeaderView) this.b.findViewById(R.id.obfuscated_res_0x7f090b75);
            this.d = forumHeaderView;
            forumHeaderView.setFrom(1);
            this.d.setSearchHint(TbSingleton.getInstance().getHotSearch());
            this.h = new cv6(this.n, this.b);
            this.i = (RelativeLayout) this.b.findViewById(R.id.layout_container);
            a(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void r(int i, int i2) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048604, this, i, i2) == null) && (cv6Var = this.h) != null) {
            cv6Var.n(i, i2);
        }
    }

    public void u(List<gn> list, int i) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048607, this, list, i) == null) && (cv6Var = this.h) != null) {
            cv6Var.q(list, i);
        }
    }

    public void s(String str, List<String> list, boolean z) {
        cv6 cv6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048605, this, str, list, z) == null) && (cv6Var = this.h) != null) {
            cv6Var.o(str, list, z);
        }
    }
}
