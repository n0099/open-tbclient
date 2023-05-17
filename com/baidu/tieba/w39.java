package com.baidu.tieba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class w39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public TextView D;
    public float E;
    public int F;
    public lx8 G;
    public kg<cn> H;
    public Runnable I;
    public View.OnClickListener J;
    public final NavigationBar a;
    public boolean b;
    public final int c;
    public final int d;
    public TextView e;
    public View f;
    public ImageView g;
    public final View h;
    public final ImageView i;
    public final LinearLayout j;
    public LinearLayout k;
    public BarImageView l;
    public TextView m;
    public String n;
    public AlertDialog o;
    public w09 p;
    public float q;
    public PbFragment r;
    public Runnable s;
    public ImageView t;
    public boolean u;
    public PopupWindow v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w39 a;

        public a(w39 w39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.r.T5();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(w39 w39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.FALSE));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w39 a;

        public c(w39 w39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w39Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.o != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!ug.a(this.a.o, this.a.r.getPageContext().getPageActivity()))));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends kg<cn> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w39 a;

        public d(w39 w39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w39Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.kg
        public void onLoaded(cn cnVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, cnVar, str, i) == null) {
                if (cnVar != null && cnVar.j() != null) {
                    this.a.a.setBackground(cnVar.j());
                    return;
                }
                SkinManager.setBackgroundColor(this.a.a.getBarBgView(), R.color.CAM_X0208);
                this.a.a.setBackground(null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w39 a;

        public e(w39 w39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w39Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w39 a;

        public f(w39 w39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    public w39(PbFragment pbFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = UtilHelper.getDimenPixelSize(R.dimen.tbds200);
        this.d = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
        this.o = null;
        this.p = null;
        this.q = 0.33f;
        this.u = false;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = true;
        this.H = new d(this);
        this.I = new e(this);
        this.J = new f(this);
        this.r = pbFragment;
        this.w = ri.g(pbFragment.getContext(), R.dimen.tbds39);
        this.x = ri.g(pbFragment.getContext(), R.dimen.tbds54);
        this.y = ri.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f07040f);
        this.z = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        int l = ri.l(TbadkCoreApplication.getInst());
        int g = ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g2 = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070349) + ((int) (l * 0.07d));
        this.A = g2;
        if (g2 - g > 0) {
            this.A = g2 - g;
        }
        this.B = (l - (this.A * 2)) - ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.view_navigation_bar);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.h = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.i2);
        this.e = this.a.setCenterTextTitle("");
        this.i = (ImageView) this.a.getCenterImgBox();
        this.j = (LinearLayout) this.a.getCenterImgBoxLayout();
        int g3 = ri.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
        this.j.setPadding(g3, 0, g3, 0);
        SkinManager.setNavbarIconSrc(this.i, R.drawable.obfuscated_res_0x7f080a69, R.drawable.obfuscated_res_0x7f080a69);
        this.i.setVisibility(8);
        this.e.setOnClickListener(pbFragment.i2);
        this.i.setOnClickListener(pbFragment.i2);
        this.t = (ImageView) this.h.findViewById(R.id.widget_navi_back_button);
        if (this.k == null) {
            l();
        }
        m();
    }

    public void B(boolean z) {
        View view2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && (view2 = this.f) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.u = z;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (z) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            t(z);
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.b = z;
            if (this.f == null && this.g == null) {
                View addCustomView = this.a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.r.i2);
                this.f = addCustomView;
                this.g = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.x + this.w, this.y);
                layoutParams.rightMargin = this.z;
                int i = 0;
                this.f.setPadding(0, 0, this.w, 0);
                this.f.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.g, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                View view2 = this.f;
                if (!TbadkCoreApplication.isLogin()) {
                    i = 8;
                }
                view2.setVisibility(i);
            }
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            NavigationBar navigationBar = this.a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.r.getPageContext(), i);
                SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.l;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.t, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.e, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            TextView textView = this.D;
            if (textView != null) {
                p45 d2 = p45.d(textView);
                d2.w(R.color.CAM_X0105);
                d2.B(R.dimen.T_X05);
            }
            s();
            E();
            G();
        }
    }

    public void C() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (view2 = this.f) != null) {
            view2.setVisibility(8);
        }
    }

    public final void E() {
        w09 w09Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (w09Var = this.p) == null) {
            return;
        }
        w09Var.Q();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ug.c(this.v);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.s == null) {
                this.s = new c(this);
            }
            sg.a().postDelayed(this.s, 100L);
        }
    }

    public w09 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.p;
        }
        return (w09) invokeV.objValue;
    }

    public NavigationBar j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.I != null) {
                sg.a().removeCallbacks(this.I);
            }
            e();
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AlertDialog alertDialog = this.o;
            if (alertDialog != null && alertDialog.isShowing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            w09 w09Var = this.p;
            if (w09Var != null) {
                w09Var.P();
            }
            this.o = null;
            this.p = null;
            sg.a().removeCallbacks(this.s);
        }
    }

    public void D(lx8 lx8Var, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{lx8Var, str, str2, str3, Boolean.valueOf(z)}) == null) && this.r != null && this.k != null) {
            this.G = lx8Var;
            if (StringUtils.isNull(str)) {
                this.l.setVisibility(8);
                this.m.setText(R.string.obfuscated_res_0x7f0f0f51);
                this.n = null;
            } else {
                this.l.setVisibility(0);
                this.n = str;
                if (this.B < 0) {
                    this.B = ri.w(this.m.getPaint(), str);
                }
                ThreadCardUtils.cutAndSetTextByMaxLine(this.m, str, R.string.obfuscated_res_0x7f0f0730, R.dimen.tbds0, 1, this.B, false);
                rx4.c().h(str);
                this.l.N(str3, 10, false);
            }
            s();
        }
    }

    public final void F(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIII(1048581, this, absListView, i, i2, i3) != null) || !o()) {
            return;
        }
        View childAt = absListView.getChildAt(0);
        int firstVisiblePosition = (-childAt.getTop()) + (absListView.getFirstVisiblePosition() * childAt.getHeight());
        if (Math.abs(firstVisiblePosition - this.F) > this.d) {
            int i4 = this.c;
            if (firstVisiblePosition < i4) {
                this.E = (firstVisiblePosition * 1.0f) / i4;
            } else {
                this.E = 1.0f;
            }
        }
        this.F = firstVisiblePosition;
        if (this.a.getBarBgView().getAlpha() != this.E) {
            this.a.getBarBgView().setAlpha(this.E);
        }
    }

    public final void G() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (navigationBar = this.a) != null && navigationBar.getBarBgView() != null) {
            if (o()) {
                m15 taskInfoData = this.G.M().getTaskInfoData();
                this.a.getBarBgView().setBackgroundColor(wp9.f(taskInfoData.i()));
                lg.h().m(taskInfoData.o(), 10, this.H, this.r.getPageContext().getUniqueId());
                return;
            }
            SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            this.a.setBackground(null);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.D == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.D = textView;
            textView.setSingleLine();
            this.D.setEllipsize(TextUtils.TruncateAt.END);
            this.D.setIncludeFontPadding(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int g = ri.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X001);
            layoutParams.setMargins(g, 0, g, 0);
            this.D.setLayoutParams(layoutParams);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.D, (View.OnClickListener) null);
            p45 d2 = p45.d(this.D);
            d2.w(R.color.CAM_X0105);
            d2.B(R.dimen.T_X05);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if ((this.u && !TbadkCoreApplication.isLogin()) || o65.m().i("show_share", false)) {
                return;
            }
            View inflate = LayoutInflater.from(this.r.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09246c);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = ri.g(this.r.getContext(), R.dimen.obfuscated_res_0x7f0701f9);
            } else {
                layoutParams.rightMargin = ri.g(this.r.getContext(), R.dimen.obfuscated_res_0x7f0701aa);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.J);
            PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
            this.v = popupWindow;
            GreyUtil.grey(popupWindow);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.D != null && this.a != null) {
            int l = ri.l(TbadkCoreApplication.getInst());
            ViewGroup viewGroup = this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            ViewGroup viewGroup2 = this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                l -= viewGroup.getMeasuredWidth();
            }
            if (viewGroup2 != null && viewGroup2.getVisibility() == 0) {
                l -= viewGroup2.getMeasuredWidth();
            }
            this.D.setWidth(l);
        }
    }

    public void h() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (pbFragment = this.r) != null && pbFragment.P() != null && this.C) {
            this.C = false;
            StatisticItem statisticItem = new StatisticItem("c13400");
            statisticItem.param("tid", this.r.P().R1());
            statisticItem.param("fid", this.r.P().getForumId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            lx8 lx8Var = this.G;
            if (lx8Var == null || lx8Var.M() == null || this.G.M().getTaskInfoData() == null) {
                return false;
            }
            m15 taskInfoData = this.G.M().getTaskInfoData();
            if (TextUtils.isEmpty(taskInfoData.i()) || TextUtils.isEmpty(taskInfoData.o())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (alertDialog = this.o) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!ug.a(alertDialog, this.r.getPageContext().getPageActivity()))));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || this.k == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.n)) {
            p45 d2 = p45.d(this.k);
            d2.o(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.k.setBackgroundResource(0);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d06a7, (View.OnClickListener) null);
            this.k = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091a42);
            this.l = barImageView;
            barImageView.setShowOval(true);
            this.l.setShowOuterBorder(false);
            this.l.setShowInnerBorder(true);
            this.l.setStrokeWith(ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.l.setStrokeColorResId(R.color.CAM_X0401);
            this.l.setOnClickListener(this.r.i2);
            TextView textView = (TextView) this.k.findViewById(R.id.obfuscated_res_0x7f091a43);
            this.m = textView;
            textView.setOnClickListener(this.r.i2);
            if (this.k.getLayoutParams() != null && (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.A > 0 && this.B > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
                int i = this.A;
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = i;
                this.k.setLayoutParams(marginLayoutParams);
            }
            if (this.k.getVisibility() == 8) {
                this.k.setVisibility(0);
            }
            if (this.k.getAlpha() != 1.0f) {
                this.k.setAlpha(1.0f);
            }
        }
    }

    public void q(AbsListView absListView, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048596, this, absListView, i, i2, i3) == null) {
            F(absListView, i, i2, i3);
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (!this.b && z && !"".equals(this.e.getText().toString())) {
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    public void x(x09 x09Var) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, x09Var) != null) || this.r.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.r;
        this.p = new w09(pbFragment, pbFragment.i2);
        AlertDialog create = new AlertDialog.Builder(this.r.getContext(), R.style.obfuscated_res_0x7f10010a).create();
        this.o = create;
        GreyUtil.grey(create);
        boolean z17 = true;
        this.o.setCanceledOnTouchOutside(true);
        this.o.setOnDismissListener(new b(this));
        ug.i(this.o, this.r.getFragmentActivity());
        Window window = this.o.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = ri.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f100417);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.p.M());
        window.setDimAmount(this.q);
        w09 w09Var = this.p;
        boolean z18 = false;
        if (x09Var == null) {
            z = false;
        } else {
            z = x09Var.a;
        }
        w09Var.d0(z);
        w09 w09Var2 = this.p;
        if (x09Var == null) {
            z2 = false;
        } else {
            z2 = x09Var.n;
        }
        w09Var2.R(z2);
        w09 w09Var3 = this.p;
        if (x09Var == null) {
            z3 = false;
        } else {
            z3 = x09Var.e;
        }
        w09Var3.T(z3);
        w09 w09Var4 = this.p;
        if (x09Var == null) {
            z4 = false;
        } else {
            z4 = x09Var.i;
        }
        w09Var4.Y(z4);
        w09 w09Var5 = this.p;
        if (x09Var == null) {
            z5 = false;
        } else {
            z5 = x09Var.f;
        }
        w09Var5.U(z5);
        w09 w09Var6 = this.p;
        if (x09Var != null) {
            z17 = x09Var.c;
        }
        w09Var6.f0(z17);
        w09 w09Var7 = this.p;
        if (x09Var == null) {
            z6 = false;
        } else {
            z6 = x09Var.k;
        }
        w09Var7.c0(z6);
        w09 w09Var8 = this.p;
        if (x09Var == null) {
            z7 = false;
        } else {
            z7 = x09Var.l;
        }
        if (x09Var != null) {
            z8 = x09Var.t;
        } else {
            z8 = false;
        }
        w09Var8.V(z7, z8);
        if (x09Var == null) {
            this.p.a0(false, false);
            this.p.Z(false, false);
        } else {
            this.p.a0(x09Var.g, x09Var.s);
            this.p.Z(x09Var.h, x09Var.r);
        }
        if (x09Var == null) {
            z9 = false;
        } else {
            z9 = x09Var.q;
        }
        if (x09Var == null) {
            z10 = false;
        } else {
            z10 = x09Var.o;
        }
        if (x09Var == null) {
            z11 = false;
        } else {
            z11 = x09Var.d;
        }
        if (x09Var == null) {
            z12 = false;
        } else {
            z12 = x09Var.b;
        }
        if (x09Var == null) {
            z13 = false;
        } else {
            z13 = x09Var.p;
        }
        if (x09Var == null) {
            z14 = false;
        } else {
            z14 = x09Var.j;
        }
        if (x09Var == null) {
            z15 = false;
        } else {
            z15 = x09Var.m;
        }
        this.p.W(z11, z10);
        this.p.e0(z12, z9);
        this.p.b0(z14, z13);
        this.p.i0(z15);
        if (x09Var != null) {
            w09 w09Var9 = this.p;
            boolean z19 = x09Var.u;
            w09Var9.A = z19;
            if (z19) {
                w09Var9.z().setText(R.string.report_text);
                this.p.U(false);
            }
        }
        w09 w09Var10 = this.p;
        if (x09Var == null) {
            z16 = false;
        } else {
            z16 = x09Var.v;
        }
        w09Var10.S(z16);
        if (!TbSingleton.getInstance().mCanCallFans && this.r.P() != null && this.r.P().y1() != null && this.r.P().y1().O() != null && this.r.P().y1().O().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.p.x().setText(R.string.have_called_fans_short);
        }
        E();
        w09 w09Var11 = this.p;
        if (x09Var != null) {
            z18 = x09Var.w;
        }
        w09Var11.j0(z18);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.b) {
                this.e.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                t(true);
                rx4.c().h(str);
                return;
            }
            t(false);
        }
    }

    public void z(boolean z, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048605, this, z, spannableStringBuilder) == null) {
            d();
            this.D.setText(spannableStringBuilder);
            if (z) {
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(8);
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(0);
                return;
            }
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(0);
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(8);
        }
    }
}
