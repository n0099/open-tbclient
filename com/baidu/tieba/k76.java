package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.ala.widget.multicolumn.BdMultiColumnListView;
import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.y45;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes5.dex */
public class k76 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o76 A;
    public a76 B;
    public ac7 C;
    public NavigationBar D;
    public TbPageContext a;
    public int b;
    public l76 c;
    public boolean d;
    public BdUniqueId e;
    public View f;
    public View g;
    public TextView h;
    public TextView i;
    public BdTypeMultiColumnListView j;
    public PopupWindow k;
    public View l;
    public TextView m;
    public TextView n;
    public View o;
    public String p;
    public boolean q;
    public z45 r;
    public PbListView s;
    public NoNetworkView t;
    public View u;
    public TextView v;
    public TextView w;
    public TextView x;
    public View y;
    public View z;

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k76 a;

        public a(k76 k76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921342);
                customResponsedMessage.setmOrginalMessage(new CustomMessage(2001627, this.a.a.getUniqueId()));
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k76 a;

        public b(k76 k76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.r();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k76 a;

        public c(k76 k76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k76Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                this.a.C.b(view2, motionEvent);
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k76 a;

        public d(k76 k76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.s(1);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k76 a;

        public e(k76 k76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.s(2);
        }
    }

    /* loaded from: classes5.dex */
    public class f implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k76 a;

        public f(k76 k76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k76Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k76 a;

        public g(k76 k76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                TiebaStatic.log(new StatisticItem("c12573").param("fid", this.a.p));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdMultiColumnListView.OnScrollToBottomListener a;

        public h(k76 k76Var, BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k76Var, onScrollToBottomListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = onScrollToBottomListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (onScrollToBottomListener = this.a) != null) {
                onScrollToBottomListener.onScrollToBottom();
            }
        }
    }

    public k76(TbPageContext tbPageContext, boolean z, BdUniqueId bdUniqueId, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), bdUniqueId, str, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = -1;
        this.q = false;
        this.a = tbPageContext;
        this.d = z;
        this.e = bdUniqueId;
        this.p = str;
        this.q = z2;
    }

    public final void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            u(i);
            lg.d(this.k, this.a.getPageActivity());
            l76 l76Var = this.c;
            if (l76Var != null) {
                l76Var.a(i);
            }
        }
    }

    public void v(q36 q36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, q36Var) == null) {
            this.B.b(q36Var);
        }
    }

    public void x(l76 l76Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, l76Var) == null) {
            this.c = l76Var;
        }
    }

    public void y(y45.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, gVar) == null) {
            this.r.f(gVar);
        }
    }

    public void z(BdMultiColumnListView.OnScrollToBottomListener onScrollToBottomListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onScrollToBottomListener) == null) {
            this.j.setOnSrollToBottomListener(onScrollToBottomListener);
            this.s.E(new h(this, onScrollToBottomListener));
        }
    }

    public void A() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (pbListView = this.s) != null) {
            if (pbListView.c().getParent() == null) {
                this.j.setNextPage(this.s);
            }
            this.s.F(this.a.getResources().getString(R.string.load_more));
            this.s.g();
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.A == null) {
                o76 o76Var = new o76(this.a.getPageActivity());
                this.A = o76Var;
                o76Var.a();
                this.A.f(new g(this));
            }
            if (this.A.c().getParent() == null) {
                this.j.setNextPage(this.A);
            }
        }
    }

    public void B() {
        PbListView pbListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (pbListView = this.s) != null) {
            if (pbListView.c().getParent() == null) {
                this.j.setNextPage(this.s);
            }
            this.s.Q();
            this.s.S();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j.completePullRefresh();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.j != null && BdNetTypeUtil.isNetWorkAvailable()) {
            this.j.startPullRefresh();
        }
    }

    public BdTypeMultiColumnListView i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.j;
        }
        return (BdTypeMultiColumnListView) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.D;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            SkinManager.setViewTextColor(this.v, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.x, (int) R.color.CAM_X0109);
            SkinManager.setBackgroundResource(this.y, R.color.CAM_X0204);
            SkinManager.setBackgroundResource(this.z, R.color.CAM_X0204);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            D();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n();
            SkinManager.setBackgroundResource(this.l, R.drawable.bg_ala_frs_game_live_sort_panel);
            SkinManager.setBackgroundResource(this.m, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.n, R.drawable.ala_frs_game_live_sort_selecor);
            SkinManager.setBackgroundResource(this.o, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0106);
            int[] iArr = new int[2];
            this.i.getLocationOnScreen(iArr);
            int height = ((View) this.i.getParent()).getHeight() - this.i.getHeight();
            if (iArr[1] - this.k.getHeight() <= 50) {
                lg.d(this.k, this.a.getPageActivity());
                return;
            }
            lg.m(this.k, this.f, 0, (iArr[0] - (this.i.getWidth() / 2)) - this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8), iArr[1] + this.i.getHeight() + height);
            this.k.update();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (this.l == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00f7, (ViewGroup) null);
                this.l = inflate;
                this.m = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c2b);
                this.n = (TextView) this.l.findViewById(R.id.obfuscated_res_0x7f090c2c);
                this.o = this.l.findViewById(R.id.obfuscated_res_0x7f090c34);
                this.m.setOnClickListener(new d(this));
                this.n.setOnClickListener(new e(this));
            }
            if (this.k == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.k = popupWindow;
                popupWindow.setContentView(this.l);
                GreyUtil.grey(this.k);
                this.k.setWidth(-2);
                this.k.setHeight(-2);
                this.k.setAnimationStyle(16973826);
                this.k.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.popup_window_transparent));
                this.k.setOutsideTouchable(true);
                this.k.setFocusable(true);
                this.k.setTouchable(true);
                this.k.setOnDismissListener(new f(this));
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.u == null) {
                View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00f5, (ViewGroup) null);
                this.u = inflate;
                this.v = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090c2e);
                this.w = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090c2f);
                this.x = (TextView) this.u.findViewById(R.id.obfuscated_res_0x7f090c30);
                this.y = this.u.findViewById(R.id.obfuscated_res_0x7f090c31);
                this.z = this.u.findViewById(R.id.obfuscated_res_0x7f090c32);
            }
            p();
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d00fc, (ViewGroup) null);
            this.f = inflate;
            if (this.q) {
                NavigationBar navigationBar = (NavigationBar) inflate.findViewById(R.id.view_navigation_bar);
                this.D = navigationBar;
                navigationBar.setVisibility(0);
                this.D.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
                this.D.showBottomLine(true);
                this.D.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            this.g = this.f.findViewById(R.id.obfuscated_res_0x7f090c35);
            this.h = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090c2d);
            this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090c33);
            BdTypeMultiColumnListView bdTypeMultiColumnListView = (BdTypeMultiColumnListView) this.f.findViewById(R.id.obfuscated_res_0x7f091495);
            this.j = bdTypeMultiColumnListView;
            bdTypeMultiColumnListView.setColumnDiv((int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be));
            this.t = (NoNetworkView) this.f.findViewById(R.id.obfuscated_res_0x7f0926dd);
            z45 z45Var = new z45(this.a);
            this.r = z45Var;
            z45Var.a0(this.e);
            this.j.setPullRefresh(this.r);
            PbListView pbListView = new PbListView(this.a.getPageActivity());
            this.s = pbListView;
            pbListView.a();
            this.B = new a76(this.a, this.j);
            this.i.setOnClickListener(new b(this));
            if (this.d) {
                this.C = new ac7(this.a.getPageActivity(), this.e, this.d);
                this.j.setOnTouchListener(new c(this));
            }
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (this.b != i) {
                this.b = i;
            }
            NavigationBar navigationBar = this.D;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.a, i);
            }
            NavigationBar navigationBar2 = this.D;
            if (navigationBar2 != null) {
                navigationBar2.onChangeSkinType(this.a, i);
                this.D.setmBackImageViewBg(R.drawable.icon_return_bg_s, R.drawable.icon_return_bg);
            }
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            this.j.setContentBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            this.i.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_gamefrs_arrow_n), (Drawable) null);
        }
    }

    public void t(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && this.h != null) {
            this.h.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f074f, StringHelper.numberUniformFormatExtra(i)));
            if (i <= 1) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
            }
        }
    }

    public void u(int i) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            if (i == 1) {
                TextView textView2 = this.i;
                if (textView2 != null) {
                    textView2.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0753));
                }
            } else if (i == 2 && (textView = this.i) != null) {
                textView.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0754));
            }
        }
    }

    public void w(List<hn> list, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{list, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (list == null) {
                list = new LinkedList<>();
            }
            if (z2) {
                m();
                this.g.setVisibility(8);
                View view2 = this.u;
                if (view2 != null) {
                    this.j.removeHeaderView(view2);
                    this.j.addHeaderView(this.u);
                }
                this.B.c(list);
                this.j.setNextPage(null);
                return;
            }
            View view3 = this.u;
            if (view3 != null) {
                this.j.removeHeaderView(view3);
            }
            if (list.size() == 0) {
                this.g.setVisibility(8);
                this.B.c(list);
                this.j.setNextPage(null);
                return;
            }
            this.g.setVisibility(0);
            this.B.c(list);
            if (z) {
                A();
            } else {
                C();
            }
        }
    }
}
