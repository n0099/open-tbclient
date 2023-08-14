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
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ImageView.BdImage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
/* loaded from: classes7.dex */
public class rk9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public boolean D;
    public TextView E;
    public float F;
    public int G;
    public td9 H;
    public BdResourceCallback<BdImage> I;
    public Runnable J;
    public View.OnClickListener K;
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
    public EMTextView m;
    public ImageView n;
    public String o;
    public AlertDialog p;
    public lh9 q;
    public float r;
    public PbFragment s;
    public Runnable t;
    public ImageView u;
    public boolean v;
    public PopupWindow w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk9 a;

        public a(rk9 rk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s.V5();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(rk9 rk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk9Var};
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

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk9 a;

        public c(rk9 rk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.p != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!jg.a(this.a.p, this.a.s.getPageContext().getPageActivity()))));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends BdResourceCallback<BdImage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk9 a;

        public d(rk9 rk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
        public void onLoaded(BdImage bdImage, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                if (bdImage != null && bdImage.getAsBitmapDrawable() != null) {
                    this.a.a.setBackground(bdImage.getAsBitmapDrawable());
                    return;
                }
                SkinManager.setBackgroundColor(this.a.a.getBarBgView(), R.color.CAM_X0208);
                this.a.a.setBackground(null);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk9 a;

        public e(rk9 rk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk9 a;

        public f(rk9 rk9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.k();
            }
        }
    }

    public rk9(PbFragment pbFragment, View view2) {
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
        this.p = null;
        this.q = null;
        this.r = 0.33f;
        this.v = false;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.D = true;
        this.I = new d(this);
        this.J = new e(this);
        this.K = new f(this);
        this.s = pbFragment;
        this.x = BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.tbds39);
        this.y = BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.tbds54);
        this.z = BdUtilHelper.getDimens(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f070420);
        this.A = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
        int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int dimens2 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07035a) + ((int) (equipmentWidth * 0.07d));
        this.B = dimens2;
        if (dimens2 - dimens > 0) {
            this.B = dimens2 - dimens;
        }
        this.C = (equipmentWidth - (this.B * 2)) - BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.view_navigation_bar);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.h = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.k2);
        this.e = this.a.setCenterTextTitle("");
        this.i = (ImageView) this.a.getCenterImgBox();
        this.j = (LinearLayout) this.a.getCenterImgBoxLayout();
        int dimens3 = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
        this.j.setPadding(dimens3, 0, dimens3, 0);
        SkinManager.setNavbarIconSrc(this.i, R.drawable.obfuscated_res_0x7f080aa7, R.drawable.obfuscated_res_0x7f080aa7);
        this.i.setVisibility(8);
        this.e.setOnClickListener(pbFragment.k2);
        this.i.setOnClickListener(pbFragment.k2);
        this.u = (ImageView) this.h.findViewById(R.id.widget_navi_back_button);
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
            this.v = z;
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
                View addCustomView = this.a.addCustomView(controlAlign, R.layout.nb_item_floor_more, this.s.k2);
                this.f = addCustomView;
                this.g = (ImageView) addCustomView.findViewById(R.id.navigationBarBtnMore);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.y + this.x, this.z);
                layoutParams.rightMargin = this.A;
                int i = 0;
                this.f.setPadding(0, 0, this.x, 0);
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
                navigationBar.onChangeSkinType(this.s.getPageContext(), i);
                SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.l;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.u, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.g, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.e, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.m, (int) R.color.CAM_X0105);
            this.n.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_list_arrow16_right, SkinManager.getColor(R.color.CAM_X0109), WebPManager.ResourceStateType.NORMAL_PRESS));
            TextView textView = this.E;
            if (textView != null) {
                EMManager.from(textView).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05);
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
        lh9 lh9Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || (lh9Var = this.q) == null) {
            return;
        }
        lh9Var.S();
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            jg.c(this.w);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.t == null) {
                this.t = new c(this);
            }
            SafeHandler.getInst().postDelayed(this.t, 100L);
        }
    }

    public lh9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.q;
        }
        return (lh9) invokeV.objValue;
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
            if (this.J != null) {
                SafeHandler.getInst().removeCallbacks(this.J);
            }
            e();
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            AlertDialog alertDialog = this.p;
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
            lh9 lh9Var = this.q;
            if (lh9Var != null) {
                lh9Var.R();
            }
            this.p = null;
            this.q = null;
            SafeHandler.getInst().removeCallbacks(this.t);
        }
    }

    public void D(td9 td9Var, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{td9Var, str, str2, str3, Boolean.valueOf(z)}) == null) && this.s != null && this.k != null) {
            this.H = td9Var;
            if (StringUtils.isNull(str)) {
                this.l.setVisibility(8);
                this.m.setText(R.string.obfuscated_res_0x7f0f0fc2);
                this.o = null;
            } else {
                this.l.setVisibility(0);
                this.o = str;
                if (this.C < 0) {
                    this.C = BdUtilHelper.getTextWidth(this.m.getPaint(), str);
                }
                ThreadCardUtils.cutAndSetTextByMaxLine(this.m, str, R.string.obfuscated_res_0x7f0f0774, R.dimen.tbds0, 1, this.C, false);
                b05.c().h(str);
                this.l.startLoad(str3, 10, false);
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
        if (Math.abs(firstVisiblePosition - this.G) > this.d) {
            int i4 = this.c;
            if (firstVisiblePosition < i4) {
                this.F = (firstVisiblePosition * 1.0f) / i4;
            } else {
                this.F = 1.0f;
            }
        }
        this.G = firstVisiblePosition;
        if (this.a.getBarBgView().getAlpha() != this.F) {
            this.a.getBarBgView().setAlpha(this.F);
        }
    }

    public final void G() {
        NavigationBar navigationBar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (navigationBar = this.a) != null && navigationBar.getBarBgView() != null) {
            if (o()) {
                u35 taskInfoData = this.H.O().getTaskInfoData();
                this.a.getBarBgView().setBackgroundColor(y9a.f(taskInfoData.i()));
                BdResourceLoader.getInstance().loadResource(taskInfoData.o(), 10, this.I, this.s.getPageContext().getUniqueId());
                return;
            }
            SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            this.a.setBackground(null);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.E == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.E = textView;
            textView.setSingleLine();
            this.E.setEllipsize(TextUtils.TruncateAt.END);
            this.E.setIncludeFontPadding(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimens = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_W_X001);
            layoutParams.setMargins(dimens, 0, dimens, 0);
            this.E.setLayoutParams(layoutParams);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.E, (View.OnClickListener) null);
            EMManager.from(this.E).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if ((this.v && !TbadkCoreApplication.isLogin()) || SharedPrefHelper.getInstance().getBoolean("show_share", false)) {
                return;
            }
            View inflate = LayoutInflater.from(this.s.getContext()).inflate(R.layout.tips_blue_right_up, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.arrow_up);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09255d);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = BdUtilHelper.getDimens(this.s.getContext(), R.dimen.obfuscated_res_0x7f0701f9);
            } else {
                layoutParams.rightMargin = BdUtilHelper.getDimens(this.s.getContext(), R.dimen.obfuscated_res_0x7f0701aa);
            }
            textView.setText(R.string.share_tip);
            textView.setOnClickListener(this.K);
            PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
            this.w = popupWindow;
            GreyUtil.grey(popupWindow);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.E != null && this.a != null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
            ViewGroup viewGroup = this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_RIGHT);
            ViewGroup viewGroup2 = this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_LEFT);
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                equipmentWidth -= viewGroup.getMeasuredWidth();
            }
            if (viewGroup2 != null && viewGroup2.getVisibility() == 0) {
                equipmentWidth -= viewGroup2.getMeasuredWidth();
            }
            this.E.setWidth(equipmentWidth);
        }
    }

    public void h() {
        PbFragment pbFragment;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (pbFragment = this.s) != null && pbFragment.R() != null && this.D) {
            this.D = false;
            StatisticItem statisticItem = new StatisticItem("c13400");
            statisticItem.param("tid", this.s.R().M1());
            statisticItem.param("fid", this.s.R().getForumId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            td9 td9Var = this.H;
            if (td9Var == null || td9Var.O() == null || this.H.O().getTaskInfoData() == null) {
                return false;
            }
            u35 taskInfoData = this.H.O().getTaskInfoData();
            if (TextUtils.isEmpty(taskInfoData.i()) || TextUtils.isEmpty(taskInfoData.o())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || this.k == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.o)) {
            if (UbsABTestHelper.isPbEnterForum()) {
                EMManager.from(this.k).setCorner(R.string.J_X07).setBackGroundRealColor(y9a.a(SkinManager.getColor(R.color.CAM_X0341), 0.08f));
                return;
            } else {
                EMManager.from(this.k).setCorner(R.string.J_X07).setBackGroundColor(R.color.CAM_X0209);
                return;
            }
        }
        this.k.setBackgroundResource(0);
    }

    public void g() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (alertDialog = this.p) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!jg.a(alertDialog, this.s.getPageContext().getPageActivity()))));
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d06e2, (View.OnClickListener) null);
            this.k = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091b01);
            this.l = barImageView;
            barImageView.setShowOval(true);
            this.l.setShowOuterBorder(false);
            this.l.setShowInnerBorder(true);
            this.l.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.l.setStrokeColorResId(R.color.CAM_X0401);
            this.n = (ImageView) this.k.findViewById(R.id.obfuscated_res_0x7f091b51);
            this.m = (EMTextView) this.k.findViewById(R.id.obfuscated_res_0x7f091b02);
            this.k.setOnClickListener(this.s.k2);
            if (this.k.getLayoutParams() != null && (this.k.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.B > 0 && this.C > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
                int i = this.B;
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
            if (UbsABTestHelper.isPbEnterForum()) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
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

    public void x(mh9 mh9Var) {
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
        if ((interceptable != null && interceptable.invokeL(1048603, this, mh9Var) != null) || this.s.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.s;
        this.q = new lh9(pbFragment, pbFragment.k2);
        AlertDialog create = new AlertDialog.Builder(this.s.getContext(), R.style.obfuscated_res_0x7f10010d).create();
        this.p = create;
        GreyUtil.grey(create);
        boolean z17 = true;
        this.p.setCanceledOnTouchOutside(true);
        this.p.setOnDismissListener(new b(this));
        jg.i(this.p, this.s.getFragmentActivity());
        Window window = this.p.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f10041b);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.q.O());
        window.setDimAmount(this.r);
        lh9 lh9Var = this.q;
        boolean z18 = false;
        if (mh9Var == null) {
            z = false;
        } else {
            z = mh9Var.a;
        }
        lh9Var.f0(z);
        lh9 lh9Var2 = this.q;
        if (mh9Var == null) {
            z2 = false;
        } else {
            z2 = mh9Var.n;
        }
        lh9Var2.T(z2);
        lh9 lh9Var3 = this.q;
        if (mh9Var == null) {
            z3 = false;
        } else {
            z3 = mh9Var.e;
        }
        lh9Var3.V(z3);
        lh9 lh9Var4 = this.q;
        if (mh9Var == null) {
            z4 = false;
        } else {
            z4 = mh9Var.i;
        }
        lh9Var4.a0(z4);
        lh9 lh9Var5 = this.q;
        if (mh9Var == null) {
            z5 = false;
        } else {
            z5 = mh9Var.f;
        }
        lh9Var5.W(z5);
        lh9 lh9Var6 = this.q;
        if (mh9Var != null) {
            z17 = mh9Var.c;
        }
        lh9Var6.h0(z17);
        lh9 lh9Var7 = this.q;
        if (mh9Var == null) {
            z6 = false;
        } else {
            z6 = mh9Var.k;
        }
        lh9Var7.e0(z6);
        lh9 lh9Var8 = this.q;
        if (mh9Var == null) {
            z7 = false;
        } else {
            z7 = mh9Var.l;
        }
        if (mh9Var != null) {
            z8 = mh9Var.t;
        } else {
            z8 = false;
        }
        lh9Var8.X(z7, z8);
        if (mh9Var == null) {
            this.q.c0(false, false);
            this.q.b0(false, false);
        } else {
            this.q.c0(mh9Var.g, mh9Var.s);
            this.q.b0(mh9Var.h, mh9Var.r);
        }
        if (mh9Var == null) {
            z9 = false;
        } else {
            z9 = mh9Var.q;
        }
        if (mh9Var == null) {
            z10 = false;
        } else {
            z10 = mh9Var.o;
        }
        if (mh9Var == null) {
            z11 = false;
        } else {
            z11 = mh9Var.d;
        }
        if (mh9Var == null) {
            z12 = false;
        } else {
            z12 = mh9Var.b;
        }
        if (mh9Var == null) {
            z13 = false;
        } else {
            z13 = mh9Var.p;
        }
        if (mh9Var == null) {
            z14 = false;
        } else {
            z14 = mh9Var.j;
        }
        if (mh9Var == null) {
            z15 = false;
        } else {
            z15 = mh9Var.m;
        }
        this.q.Y(z11, z10);
        this.q.g0(z12, z9);
        this.q.d0(z14, z13);
        this.q.k0(z15);
        if (mh9Var != null) {
            lh9 lh9Var9 = this.q;
            boolean z19 = mh9Var.u;
            lh9Var9.A = z19;
            if (z19) {
                lh9Var9.z().setText(R.string.report_text);
                this.q.W(false);
            }
        }
        lh9 lh9Var10 = this.q;
        if (mh9Var == null) {
            z16 = false;
        } else {
            z16 = mh9Var.v;
        }
        lh9Var10.U(z16);
        if (!TbSingleton.getInstance().mCanCallFans && this.s.R() != null && this.s.R().s1() != null && this.s.R().s1().Q() != null && this.s.R().s1().Q().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.q.x().setText(R.string.have_called_fans_short);
        }
        E();
        lh9 lh9Var11 = this.q;
        if (mh9Var != null) {
            z18 = mh9Var.w;
        }
        lh9Var11.l0(z18);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.b) {
                this.e.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 7, false)));
                t(true);
                b05.c().h(str);
                return;
            }
            t(false);
        }
    }

    public void z(boolean z, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048605, this, z, spannableStringBuilder) == null) {
            d();
            this.E.setText(spannableStringBuilder);
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
