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
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j38 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public TBSpecificationBtn B;
    public boolean C;
    public dx7 D;
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
    public o08 n;
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j38 a;

        public a(j38 j38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p.J5();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j38 j38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j38Var, Integer.valueOf(i)};
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
            this.a = j38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof zq8) || !((zq8) customResponsedMessage.getData()).b) {
                return;
            }
            this.a.C = true;
            j38 j38Var = this.a;
            j38Var.L(j38Var.C);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(j38 j38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j38Var, Integer.valueOf(i)};
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
            this.a = j38Var;
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
                        TbPageTag l = ud5.l(this.a.p.getContext());
                        if (this.a.D != null && l != null) {
                            e38.a("c14277", this.a.E, this.a.D.S(), TbadkCoreApplication.getCurrentAccount(), l.locatePage);
                        }
                    } else {
                        this.a.A.setVisibility(4);
                    }
                    j38 j38Var = this.a;
                    j38Var.L(j38Var.C);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(j38 j38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j38Var};
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

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j38 a;

        public e(j38 j38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.m != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!bh.a(this.a.m, this.a.p.getPageContext().getPageActivity()))));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j38 a;

        public f(j38 j38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j38Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j38 a;

        public g(j38 j38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {j38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.q();
            }
        }
    }

    public j38(PbFragment pbFragment, View view2) {
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
        this.u = xi.g(pbFragment.getContext(), R.dimen.tbds39);
        this.v = xi.g(pbFragment.getContext(), R.dimen.tbds54);
        this.w = xi.g(pbFragment.getContext(), R.dimen.obfuscated_res_0x7f070306);
        this.x = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701b2);
        xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds_6);
        int l = xi.l(TbadkCoreApplication.getInst());
        int g2 = xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
        int g3 = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f070231) + ((int) (l * 0.07d));
        this.y = g3;
        if (g3 - g2 > 0) {
            this.y = g3 - g2;
        }
        this.z = (l - (this.y * 2)) - xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds89);
        NavigationBar navigationBar = (NavigationBar) view2.findViewById(R.id.obfuscated_res_0x7f092604);
        this.a = navigationBar;
        navigationBar.setOnClickListener(new a(this));
        this.a.hideBottomLine();
        this.f = this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, pbFragment.h2);
        this.c = this.a.setCenterTextTitle("");
        this.g = (ImageView) this.a.getCenterImgBox();
        this.h = (LinearLayout) this.a.getCenterImgBoxLayout();
        int g4 = xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
        this.h.setPadding(g4, 0, g4, 0);
        SkinManager.setNavbarIconSrc(this.g, R.drawable.obfuscated_res_0x7f0808d2, R.drawable.obfuscated_res_0x7f0808d2);
        this.g.setVisibility(8);
        this.c.setOnClickListener(pbFragment.h2);
        this.g.setOnClickListener(pbFragment.h2);
        this.r = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0926c0);
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
            if ((this.s && !TbadkCoreApplication.isLogin()) || ky4.k().h("show_share", false)) {
                return;
            }
            View inflate = LayoutInflater.from(this.p.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08a6, (ViewGroup) null);
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f0902d1);
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092253);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
            layoutParams.gravity = 5;
            if (!TbadkCoreApplication.isLogin()) {
                layoutParams.rightMargin = xi.g(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701f9);
            } else {
                layoutParams.rightMargin = xi.g(this.p.getContext(), R.dimen.obfuscated_res_0x7f0701aa);
            }
            textView.setText(R.string.obfuscated_res_0x7f0f11b1);
            textView.setOnClickListener(this.J);
            this.t = new PopupWindow(inflate, -2, -2);
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
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(xi.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0708f2), -2);
            layoutParams.setMargins(xi.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X001), 0, 0, 0);
            this.F.setLayoutParams(layoutParams);
            this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_CENTER, this.F, (View.OnClickListener) null);
            kw4 d2 = kw4.d(this.F);
            d2.v(R.color.CAM_X0105);
            d2.z(R.dimen.T_X05);
        }
    }

    public void F(p08 p08Var) {
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
        if ((interceptable != null && interceptable.invokeL(1048581, this, p08Var) != null) || this.p.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        PbFragment pbFragment = this.p;
        this.n = new o08(pbFragment, pbFragment.h2);
        AlertDialog create = new AlertDialog.Builder(this.p.getContext(), R.style.obfuscated_res_0x7f100107).create();
        this.m = create;
        boolean z16 = true;
        create.setCanceledOnTouchOutside(true);
        this.m.setOnDismissListener(new d(this));
        bh.i(this.m, this.p.getFragmentActivity());
        Window window = this.m.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = xi.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f9);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.n.y());
        window.setDimAmount(this.o);
        o08 o08Var = this.n;
        boolean z17 = false;
        if (p08Var == null) {
            z = false;
        } else {
            z = p08Var.a;
        }
        o08Var.Q(z);
        o08 o08Var2 = this.n;
        if (p08Var == null) {
            z2 = false;
        } else {
            z2 = p08Var.n;
        }
        o08Var2.D(z2);
        o08 o08Var3 = this.n;
        if (p08Var == null) {
            z3 = false;
        } else {
            z3 = p08Var.e;
        }
        o08Var3.F(z3);
        o08 o08Var4 = this.n;
        if (p08Var == null) {
            z4 = false;
        } else {
            z4 = p08Var.i;
        }
        o08Var4.L(z4);
        o08 o08Var5 = this.n;
        if (p08Var == null) {
            z5 = false;
        } else {
            z5 = p08Var.f;
        }
        o08Var5.G(z5);
        o08 o08Var6 = this.n;
        if (p08Var != null) {
            z16 = p08Var.c;
        }
        o08Var6.S(z16);
        o08 o08Var7 = this.n;
        if (p08Var == null) {
            z6 = false;
        } else {
            z6 = p08Var.k;
        }
        o08Var7.P(z6);
        o08 o08Var8 = this.n;
        if (p08Var == null) {
            z7 = false;
        } else {
            z7 = p08Var.l;
        }
        o08Var8.H(z7, p08Var.t);
        if (p08Var == null) {
            this.n.N(false, false);
            this.n.M(false, false);
        } else {
            this.n.N(p08Var.g, p08Var.s);
            this.n.M(p08Var.h, p08Var.r);
        }
        if (p08Var == null) {
            z8 = false;
        } else {
            z8 = p08Var.q;
        }
        if (p08Var == null) {
            z9 = false;
        } else {
            z9 = p08Var.o;
        }
        if (p08Var == null) {
            z10 = false;
        } else {
            z10 = p08Var.d;
        }
        if (p08Var == null) {
            z11 = false;
        } else {
            z11 = p08Var.b;
        }
        if (p08Var == null) {
            z12 = false;
        } else {
            z12 = p08Var.p;
        }
        if (p08Var == null) {
            z13 = false;
        } else {
            z13 = p08Var.j;
        }
        if (p08Var == null) {
            z14 = false;
        } else {
            z14 = p08Var.m;
        }
        this.n.I(z10, z9);
        this.n.R(z11, z8);
        this.n.O(z13, z12);
        this.n.U(z14);
        if (p08Var != null) {
            o08 o08Var9 = this.n;
            boolean z18 = p08Var.u;
            o08Var9.w = z18;
            if (z18) {
                o08Var9.m().setText(R.string.obfuscated_res_0x7f0f1044);
                this.n.G(false);
            }
        }
        o08 o08Var10 = this.n;
        if (p08Var == null) {
            z15 = false;
        } else {
            z15 = p08Var.v;
        }
        o08Var10.E(z15);
        if (!TbSingleton.getInstance().mCanCallFans && this.p.K() != null && this.p.K().S1() != null && this.p.K().S1().S() != null && this.p.K().S1().S().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.n.k().setText(R.string.obfuscated_res_0x7f0f085e);
        }
        N();
        o08 o08Var11 = this.n;
        if (p08Var != null) {
            z17 = p08Var.w;
        }
        o08Var11.V(z17);
        MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.TRUE));
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (!TextUtils.isEmpty(str) && !this.b) {
                this.c.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f03e0, UtilHelper.getFixedBarText(str, 7, false)));
                A(true);
                ar4.c().h(str);
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
            tBSpecificationBtn.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0665));
            ((jz4) this.B.getStyleConfig()).t(R.color.CAM_X0109);
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
                View addCustomView = this.a.addCustomView(controlAlign, R.layout.obfuscated_res_0x7f0d0642, this.p.h2);
                this.d = addCustomView;
                this.e = (ImageView) addCustomView.findViewById(R.id.obfuscated_res_0x7f09167e);
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
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080a3b, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080a37, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
            SkinManager.setNavbarTitleColor(this.c, R.color.CAM_X0105, R.color.s_navbar_title_color);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0105);
            TextView textView = this.F;
            if (textView != null) {
                kw4 d2 = kw4.d(textView);
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
            WebPManager.setPureDrawable(this.e, R.drawable.obfuscated_res_0x7f080a37, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.r, R.drawable.obfuscated_res_0x7f080a3b, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
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
        o08 o08Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (o08Var = this.n) == null) {
            return;
        }
        o08Var.C();
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            bh.c(this.t);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.q == null) {
                this.q = new e(this);
            }
            zg.a().postDelayed(this.q, 100L);
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

    public o08 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n;
        }
        return (o08) invokeV.objValue;
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
                zg.a().removeCallbacks(this.I);
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
            o08 o08Var = this.n;
            if (o08Var != null) {
                o08Var.B();
            }
            this.m = null;
            this.n = null;
            zg.a().removeCallbacks(this.q);
        }
    }

    public void M(dx7 dx7Var, String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{dx7Var, str, str2, str3, Boolean.valueOf(z)}) == null) && this.p != null && this.i != null) {
            this.D = dx7Var;
            this.E = str2;
            if (StringUtils.isNull(str)) {
                this.j.setVisibility(8);
                this.k.setText("贴吧动态");
                this.l = null;
            } else {
                this.j.setVisibility(0);
                this.l = str;
                ThreadCardUtils.cutAndSetTextByMaxLine(this.k, str, R.string.obfuscated_res_0x7f0f067a, R.dimen.tbds0, 1, this.z, false);
                ar4.c().h(str);
                this.j.K(str3, 10, false);
            }
            View view2 = this.A;
            if (view2 != null && this.D != null) {
                view2.setTag(R.id.obfuscated_res_0x7f090aab, str);
                this.A.setTag(R.id.obfuscated_res_0x7f090a96, str2);
                this.A.setTag(R.id.obfuscated_res_0x7f0921e0, this.D.S());
                this.C = z;
            }
            z();
        }
    }

    public void l() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (alertDialog = this.m) != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new WindowSwitchMessage(Boolean.valueOf(!bh.a(alertDialog, this.p.getPageContext().getPageActivity()))));
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048606, this) != null) || this.i == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.l)) {
            kw4 d2 = kw4.d(this.i);
            d2.n(R.string.J_X07);
            d2.f(R.color.CAM_X0209);
            return;
        }
        this.i.setBackgroundResource(0);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            LinearLayout linearLayout = (LinearLayout) this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_ABSOLUTE_CENTER, R.layout.obfuscated_res_0x7f0d063d, (View.OnClickListener) null);
            this.i = linearLayout;
            BarImageView barImageView = (BarImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f091890);
            this.j = barImageView;
            barImageView.setShowOval(true);
            this.j.setShowOuterBorder(false);
            this.j.setShowInnerBorder(true);
            this.j.setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            this.j.setStrokeColorResId(R.color.CAM_X0401);
            this.j.setOnClickListener(this.p.h2);
            TextView textView = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091891);
            this.k = textView;
            textView.setOnClickListener(this.p.h2);
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
