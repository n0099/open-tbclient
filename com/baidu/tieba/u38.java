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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.WindowSwitchMessage;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class u38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TBSpecificationBtn B;
    public boolean C;
    public ox7 D;
    public String E;
    public TextView F;
    public CustomMessageListener G;
    public CustomMessageListener H;
    public Runnable I;
    public View.OnClickListener J;
    public final NavigationBar a;
    public boolean b;
    public TextView c;
    public View d;
    public ImageView e;
    public final View f;
    public final ImageView g;
    public final LinearLayout h;
    public LinearLayout i;
    public BarImageView j;
    public TextView k;
    public String l;
    public AlertDialog m;
    public z08 n;
    public float o;
    public PbFragment p;
    public Runnable q;
    public ImageView r;
    public boolean s;
    public PopupWindow t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u38 a;

        public a(u38 u38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p.J5();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(u38 u38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u38Var, Integer.valueOf(i)};
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
            this.a = u38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof kr8) || !((kr8) customResponsedMessage.getData()).b) {
                return;
            }
            this.a.C = true;
            u38 u38Var = this.a;
            u38Var.L(u38Var.C);
        }
    }

    /* loaded from: classes6.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(u38 u38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u38Var, Integer.valueOf(i)};
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
            this.a = u38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                if (this.a.A != null) {
                    if (booleanValue && !this.a.C) {
                        this.a.A.setVisibility(0);
                        TbPageTag l = be5.l(this.a.p.getContext());
                        if (this.a.D != null && l != null) {
                            p38.a("c14277", this.a.E, this.a.D.S(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    } else {
                        this.a.A.setVisibility(4);
                    }
                    u38 u38Var = this.a;
                    u38Var.L(u38Var.C);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(u38 u38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u38Var};
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

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u38 a;

        public e(u38 u38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.m != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!ch.a(this.a.m, this.a.p.getPageContext().getPageActivity()))));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u38 a;

        public f(u38 u38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u38 a;

        public g(u38 u38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {u38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = u38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q();
            }
        }
    }

    public u38(PbFragment pbFragment, View view2) {
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
        this.m = null;
        this.n = null;
        this.o = 0.33f;
        this.s = false;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.C = false;
        this.G = new b(this, 2001437);
        this.H = new c(this, 2921599);
        this.I = new f(this);
        this.J = new g(this);
        this.p = pbFragment;
        this.u = yi.g(pbFragment.getContext(), R.dimen.tbds39);
        this.v = yi.g(pbFragment.getContext(), R.dimen.tbds54);
        this.w = yi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f070306);
        this.x = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds_6);
        int l = yi.l(TbadkCoreApplication.getInst());
        int g2 = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070231) + ((int) (l * 0.07d));
        this.y = g3;
        if (g3 - g2 > 0) {
            this.y = g3 - g2;
        }
        this.z = (l - (this.y * 2)) - yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f092613);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.f = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.j2);
        this.c = this.a.setCenterTextTitle("");
        this.g = (ImageView) this.a.getCenterImgBox();
        this.h = (LinearLayout) this.a.getCenterImgBoxLayout();
        int g4 = yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
        this.h.setPadding(g4, 0, g4, 0);
        SkinManager.setNavbarIconSrc(this.g, R.drawable.obfuscated_res_0x7f0808d7, R.drawable.obfuscated_res_0x7f0808d7);
        this.g.setVisibility(8);
        this.c.setOnClickListener(pbFragment.j2);
        this.g.setOnClickListener(pbFragment.j2);
        this.r = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0926cf);
        if (this.i == null) {
            s();
        }
        t();
        pbFragment.registerListener(this.G);
        pbFragment.registerListener(this.H);
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.s = z;
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (z) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            A(z);
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.r.setVisibility(0);
            A(z);
            if (TbadkCoreApplication.isLogin()) {
                View view2 = this.d;
                if (view2 != null) {
                    view2.setVisibility(0);
                    return;
                }
                return;
            }
            View view3 = this.d;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
    }

    public void J(boolean z) {
        View view2;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (view2 = this.d) != null) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            view2.setVisibility(i);
        }
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!this.b && z && !"".equals(this.c.getText().toString())) {
                this.c.setVisibility(0);
            } else {
                this.c.setVisibility(8);
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if ((this.s && !TbadkCoreApplication.isLogin()) || py4.k().h("show_share", false)) {
                return;
            }
            View inflate = LayoutInflater.from(this.p.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08aa, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0902d1);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092260);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = yi.g(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701f9);
            } else {
                layoutParams.rightMargin = yi.g(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701aa);
            }
            textView.setText(R.string.obfuscated_res_0x7f0f11b7);
            textView.setOnClickListener(this.J);
            PopupWindow popupWindow = new PopupWindow(inflate, -2, -2);
            this.t = popupWindow;
            GreyUtil.grey(popupWindow);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && this.F == null) {
            TextView textView = new TextView(TbadkCoreApplication.getInst());
            this.F = textView;
            textView.setSingleLine();
            this.F.setEllipsize(TextUtils.TruncateAt.END);
            this.F.setIncludeFontPadding(true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(yi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708f2), -2);
            layoutParams.setMargins(yi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X001), 0, 0, 0);
            this.F.setLayoutParams(layoutParams);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.F, (View.OnClickListener) null);
            pw4 d2 = pw4.d(this.F);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
        }
    }

    public void F(a18 a18Var) {
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
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, a18Var) != null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new z08(pbFragment, pbFragment.j2);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.m = create;
        GreyUtil.grey(create);
        boolean z16 = true;
        this.m.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        ch.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = yi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f9);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.y());
        window.setDimAmount(this.o);
        if (WindowGreySwitch.getIsOn()) {
            u9.b(window.getDecorView());
        }
        z08 z08Var = this.n;
        boolean z17 = false;
        if (a18Var == null) {
            z = false;
        } else {
            z = a18Var.a;
        }
        z08Var.Q(z);
        z08 z08Var2 = this.n;
        if (a18Var == null) {
            z2 = false;
        } else {
            z2 = a18Var.n;
        }
        z08Var2.D(z2);
        z08 z08Var3 = this.n;
        if (a18Var == null) {
            z3 = false;
        } else {
            z3 = a18Var.e;
        }
        z08Var3.F(z3);
        z08 z08Var4 = this.n;
        if (a18Var == null) {
            z4 = false;
        } else {
            z4 = a18Var.i;
        }
        z08Var4.L(z4);
        z08 z08Var5 = this.n;
        if (a18Var == null) {
            z5 = false;
        } else {
            z5 = a18Var.f;
        }
        z08Var5.G(z5);
        z08 z08Var6 = this.n;
        if (a18Var != null) {
            z16 = a18Var.c;
        }
        z08Var6.S(z16);
        z08 z08Var7 = this.n;
        if (a18Var == null) {
            z6 = false;
        } else {
            z6 = a18Var.k;
        }
        z08Var7.P(z6);
        z08 z08Var8 = this.n;
        if (a18Var == null) {
            z7 = false;
        } else {
            z7 = a18Var.l;
        }
        z08Var8.H(z7, a18Var.t);
        if (a18Var == null) {
            this.n.N(false, false);
            this.n.M(false, false);
        } else {
            this.n.N(a18Var.g, a18Var.s);
            this.n.M(a18Var.h, a18Var.r);
        }
        if (a18Var == null) {
            z8 = false;
        } else {
            z8 = a18Var.q;
        }
        if (a18Var == null) {
            z9 = false;
        } else {
            z9 = a18Var.o;
        }
        if (a18Var == null) {
            z10 = false;
        } else {
            z10 = a18Var.d;
        }
        if (a18Var == null) {
            z11 = false;
        } else {
            z11 = a18Var.b;
        }
        if (a18Var == null) {
            z12 = false;
        } else {
            z12 = a18Var.p;
        }
        if (a18Var == null) {
            z13 = false;
        } else {
            z13 = a18Var.j;
        }
        if (a18Var == null) {
            z14 = false;
        } else {
            z14 = a18Var.m;
        }
        this.n.I(z10, z9);
        this.n.R(z11, z8);
        this.n.O(z13, z12);
        this.n.U(z14);
        if (a18Var != null) {
            z08 z08Var9 = this.n;
            boolean z18 = a18Var.u;
            z08Var9.w = z18;
            if (z18) {
                z08Var9.m().setText(R.string.obfuscated_res_0x7f0f104a);
                this.n.G(false);
            }
        }
        z08 z08Var10 = this.n;
        if (a18Var == null) {
            z15 = false;
        } else {
            z15 = a18Var.v;
        }
        z08Var10.E(z15);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.K() != null && this.p.K().S1() != null && this.p.K().S1().S() != null && this.p.K().S1().S().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.k().setText(R.string.obfuscated_res_0x7f0f085f);
        }
        N();
        z08 z08Var11 = this.n;
        if (a18Var != null) {
            z17 = a18Var.w;
        }
        z08Var11.V(z17);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.b) {
                this.c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03e1, UtilHelper.getFixedBarText(str, 7, false)));
                A(true);
                br4.c().h(str);
                return;
            }
            A(false);
        }
    }

    public final void L(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048587, this, z) != null) || (tBSpecificationBtn = this.B) == null) {
            return;
        }
        if (z) {
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0666));
            ((oz4) this.B.getStyleConfig()).t(R.color.CAM_X0109);
            return;
        }
        tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f02b1));
    }

    public void H(boolean z, SpannableStringBuilder spannableStringBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, spannableStringBuilder) == null) {
            this.F.setText(spannableStringBuilder);
            if (z) {
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(8);
                this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(0);
                return;
            }
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER).setVisibility(0);
            this.a.getViewGroup(NavigationBar.ControlAlign.HORIZONTAL_CENTER).setVisibility(8);
        }
    }

    public void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            NavigationBar.ControlAlign controlAlign = NavigationBar.ControlAlign.HORIZONTAL_RIGHT;
            this.b = z;
            if (this.d == null && this.e == null) {
                View addCustomView = this.a.addCustomView(controlAlign, R.layout.obfuscated_res_0x7f0d0643, this.p.j2);
                this.d = addCustomView;
                this.e = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f091685);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.v + this.u, this.w);
                layoutParams.rightMargin = this.x;
                int i = 0;
                this.d.setPadding(0, 0, this.u, 0);
                this.d.setLayoutParams(layoutParams);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.e, R.drawable.icon_pure_topbar_more44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                View view2 = this.d;
                if (!TbadkCoreApplication.isLogin()) {
                    i = 8;
                }
                view2.setVisibility(i);
            }
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            NavigationBar navigationBar = this.a;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.p.getPageContext(), i);
                SkinManager.setBackgroundColor(this.a.getBarBgView(), R.color.CAM_X0208);
            }
            BarImageView barImageView = this.j;
            if (barImageView != null) {
                barImageView.invalidate();
            }
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080a40, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080a3c, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            TextView textView = this.F;
            if (textView != null) {
                pw4 d2 = pw4.d(textView);
                d2.v(R.color.CAM_X0105);
                d2.z(R.dimen.T_X05);
            }
            z();
            N();
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.a.onChangeSkinType(this.p.getPageContext(), i);
            this.a.getBackground().mutate().setAlpha(0);
            this.a.getTopCoverBgView().setBackgroundResource(R.drawable.obfuscated_res_0x7f0802ca);
            this.a.getTopCoverBgView().setVisibility(0);
            this.a.getBarBgView().setBackgroundColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha85));
            this.c.setTextColor(TbadkCoreApplication.getInst().getResources().getColor(R.color.CAM_X0111));
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080a3c, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080a40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    public void K() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (view2 = this.d) != null) {
            view2.setVisibility(8);
        }
    }

    public final void N() {
        z08 z08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (z08Var = this.n) == null) {
            return;
        }
        z08Var.C();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ch.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            ah.a().postDelayed(this.q, 100L);
        }
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.A;
        }
        return (View) invokeV.objValue;
    }

    public z08 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (z08) invokeV.objValue;
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public NavigationBar p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.a;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.I != null) {
                ah.a().removeCallbacks(this.I);
            }
            j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.r.setVisibility(0);
            A(false);
            View view2 = this.d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            AlertDialog alertDialog = this.m;
            if (alertDialog != null && alertDialog.isShowing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            z08 z08Var = this.n;
            if (z08Var != null) {
                z08Var.B();
            }
            this.m = null;
            this.n = null;
            ah.a().removeCallbacks(this.q);
        }
    }

    public void M(ox7 ox7Var, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{ox7Var, str, str2, str3, Boolean.valueOf(z)}) == null) && this.p != null && this.i != null) {
            this.D = ox7Var;
            this.E = str2;
            if (StringUtils.isNull(str)) {
                this.j.setVisibility(8);
                this.k.setText("贴吧动态");
                this.l = null;
            } else {
                this.j.setVisibility(0);
                this.l = str;
                ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.obfuscated_res_0x7f0f067b, R.dimen.tbds0, 1, this.z, false);
                br4.c().h(str);
                this.j.K(str3, 10, false);
            }
            View view2 = this.A;
            if (view2 != null && this.D != null) {
                view2.setTag(R.id.obfuscated_res_0x7f090aac, str);
                this.A.setTag(R.id.obfuscated_res_0x7f090a97, str2);
                this.A.setTag(R.id.obfuscated_res_0x7f0921ed, this.D.S());
                this.C = z;
            }
            z();
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (alertDialog = this.m) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!ch.a(alertDialog, this.p.getPageContext().getPageActivity()))));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || this.i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            pw4 d2 = pw4.d(this.i);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.i.setBackgroundResource(0);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d063e, (View.OnClickListener) null);
            this.i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091898);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(this.p.j2);
            TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091899);
            this.k = textView;
            textView.setOnClickListener(this.p.j2);
            if (this.i.getLayoutParams() != null && (this.i.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.y > 0 && this.z > 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.i.getLayoutParams();
                int i = this.y;
                marginLayoutParams.leftMargin = i;
                marginLayoutParams.rightMargin = i;
                this.i.setLayoutParams(marginLayoutParams);
            }
            if (this.i.getVisibility() == 8) {
                this.i.setVisibility(0);
            }
            if (this.i.getAlpha() != 1.0f) {
                this.i.setAlpha(1.0f);
            }
        }
    }
}
