package com.baidu.tieba;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.fx9;
import com.baidu.tieba.tj7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oj7 extends ln6<tj7> implements pj7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tj7 A;
    public int B;
    public uj7 C;
    public yx9 D;
    public yx9 E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public Animation J;
    public Animation K;
    public ScaleAnimation L;
    public boolean M;
    public boolean N;
    public FrameLayout i;
    public FrameLayout j;
    public TextView k;
    public TextView l;
    public FrameLayout m;
    public TextView n;
    public TextView o;
    public HeadImageView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public ImageView u;
    public ImageView v;
    public LinearLayout w;
    public LinearLayout x;
    public fx9 y;
    public TbPageContext<?> z;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln6
    /* renamed from: E */
    public void i(tj7 tj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tj7Var) == null) {
        }
    }

    @Override // com.baidu.tieba.ln6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01e9 : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements fx9.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj7 a;

        public a(oj7 oj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj7Var;
        }

        @Override // com.baidu.tieba.fx9.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.N0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.fx9.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.y.N0()) {
                    this.a.l.setVisibility(8);
                }
                if (this.a.I) {
                    this.a.y.D1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fx9.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj7 a;

        public b(oj7 oj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj7Var;
        }

        @Override // com.baidu.tieba.fx9.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                oj7 oj7Var = this.a;
                oj7Var.onClick(oj7Var.i);
            }
        }

        @Override // com.baidu.tieba.fx9.c0
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                oj7 oj7Var = this.a;
                if (oj7Var.M) {
                    str = "1";
                } else {
                    str = "2";
                }
                oj7Var.L(str);
                oj7 oj7Var2 = this.a;
                oj7Var2.onClick(oj7Var2.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements fx9.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj7 a;

        public c(oj7 oj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj7Var;
        }

        @Override // com.baidu.tieba.fx9.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    oj7 oj7Var = this.a;
                    fx9 fx9Var = oj7Var.y;
                    tj7 tj7Var = oj7Var.A;
                    fx9Var.w1(tj7Var.n.d, tj7Var.b);
                    this.a.l.setVisibility(8);
                    this.a.L("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                oj7 oj7Var2 = this.a;
                oj7Var2.onClick(oj7Var2.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements fx9.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj7 a;

        public d(oj7 oj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj7Var;
        }

        @Override // com.baidu.tieba.fx9.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        oj7 oj7Var = this.a;
                        oj7Var.k.startAnimation(oj7Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    oj7 oj7Var2 = this.a;
                    oj7Var2.k.startAnimation(oj7Var2.K);
                }
            }
        }

        @Override // com.baidu.tieba.fx9.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    oj7 oj7Var = this.a;
                    oj7Var.k.startAnimation(oj7Var.J);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nj7 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ oj7 c;

        public e(oj7 oj7Var, nj7 nj7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj7Var, nj7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = oj7Var;
            this.a = nj7Var;
            this.b = i;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.H) {
                    this.c.I = true;
                    this.c.G = false;
                }
                if (this.a != null && !this.c.H) {
                    this.a.a(this.b);
                    this.c.y.T0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nj7 a;
        public final /* synthetic */ oj7 b;

        public f(oj7 oj7Var, nj7 nj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj7Var, nj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oj7Var;
            this.a = nj7Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                tj7 tj7Var = this.b.A;
                if (tj7Var != null && tj7Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                nj7 nj7Var = this.a;
                if (nj7Var != null) {
                    nj7Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements fx9.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oj7 a;

        public g(oj7 oj7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oj7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oj7Var;
        }

        @Override // com.baidu.tieba.fx9.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oj7(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = true;
        this.N = z;
        View h = h();
        this.z = tbPageContext;
        this.i = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f0928c8);
        FrameLayout frameLayout = (FrameLayout) h.findViewById(R.id.video_container);
        this.j = frameLayout;
        fx9 fx9Var = new fx9(tbPageContext, frameLayout, false);
        this.y = fx9Var;
        fx9Var.m1("2005");
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09258f);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090970);
        this.m = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f091788);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09178a);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091789);
        this.p = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f09284e);
        this.q = (TextView) h.findViewById(R.id.user_name);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0902e6);
        this.w = (LinearLayout) h.findViewById(R.id.thread_info_commont_container);
        this.x = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f090172);
        this.s = (TextView) h.findViewById(R.id.thread_info_commont_num);
        this.t = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092523);
        this.u = (ImageView) h.findViewById(R.id.thread_info_commont_img);
        this.v = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092522);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        h.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = BdUtilHelper.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new uj7(this.z, this);
        this.J = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.K = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    public boolean I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.y.X0(i);
        }
        return invokeI.booleanValue;
    }

    public void O(tj7 tj7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, tj7Var) != null) || tj7Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(tj7Var.d));
    }

    public String R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (str.indexOf(".") > 0) {
                return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.pj7
    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.baidu.tieba.pj7
    public void o(boolean z) {
        tj7 tj7Var;
        tj7.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && (tj7Var = this.A) != null && (bVar = tj7Var.m) != null) {
            bVar.e = z;
            M(tj7Var);
        }
    }

    public final Animation C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.L == null) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
                this.L = scaleAnimation;
                scaleAnimation.setDuration(200L);
            }
            return this.L;
        }
        return (Animation) invokeV.objValue;
    }

    @Override // com.baidu.tieba.pj7
    public void n() {
        tj7 tj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (tj7Var = this.A) == null) {
            return;
        }
        boolean z = !tj7Var.h;
        tj7Var.h = z;
        if (z) {
            tj7Var.e++;
        } else {
            tj7Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(C());
        }
        P(this.A);
    }

    public final void D(tj7 tj7Var, int i, nj7 nj7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tj7Var, i, nj7Var) == null) && tj7Var != null && tj7Var.n != null) {
            this.y.D1();
            this.y.d1(true);
            this.y.f1(new a(this));
            this.y.j1(new b(this));
            this.y.h1(new c(this));
            this.y.c1(false);
            yx9 yx9Var = new yx9();
            this.D = yx9Var;
            yx9Var.c = tj7Var.b;
            yx9Var.d = tj7Var.a;
            yx9Var.e = TbadkCoreApplication.getCurrentAccount();
            yx9 yx9Var2 = new yx9();
            this.E = yx9Var2;
            yx9Var2.c = tj7Var.b;
            yx9Var2.d = tj7Var.a;
            yx9Var2.e = TbadkCoreApplication.getCurrentAccount();
            if (this.N) {
                StatisticItem statisticItem = new StatisticItem("c12590");
                statisticItem.param("tid", tj7Var.b);
                statisticItem.param("nid", tj7Var.c);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, tj7Var.c());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", tj7Var.a);
                statisticItem.param("obj_locate", i);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(statisticItem);
                yx9 yx9Var3 = this.D;
                yx9Var3.g = "auto_midpage";
                yx9Var3.a = "13";
                yx9Var3.i = "1";
                yx9 yx9Var4 = this.E;
                yx9Var4.g = "auto_midpage";
                yx9Var4.a = "auto_midpage";
                yx9Var4.i = "1";
            } else {
                yx9 yx9Var5 = this.D;
                yx9Var5.i = "frs_bavideotab";
                yx9Var5.a = "12";
                yx9 yx9Var6 = this.E;
                yx9Var6.i = "frs_bavideotab";
                yx9Var6.a = "frs_bavideotab";
            }
            tj7.c cVar = tj7Var.n;
            if (cVar != null) {
                yx9 yx9Var7 = this.D;
                String str = cVar.c;
                yx9Var7.m = str;
                this.E.m = str;
            }
            this.y.D0().setVideoStatData(this.D);
            this.y.q0();
            this.y.g1(new d(this));
            this.y.k1(new e(this, nj7Var, i));
            this.y.l1(new f(this, nj7Var));
            this.y.q1(tj7Var.n.j);
            this.y.s1(tj7Var.n.d, tj7Var.b);
            this.y.r1(tj7Var.l);
            this.y.i1(new g(this));
            this.y.T0();
            this.y.t1();
            if (tj7Var.s) {
                onClick(this.j);
                this.I = false;
                this.y.B1(tj7Var.n.d, tj7Var.b, null, new Object[0]);
            }
            this.I = false;
        }
    }

    public void F(tj7 tj7Var, int i, nj7 nj7Var) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, tj7Var, i, nj7Var) == null) && tj7Var != null && tj7Var.n != null) {
            this.A = tj7Var;
            this.M = tj7Var.s;
            this.k.setVisibility(0);
            this.k.setText(tj7Var.l);
            this.l.setVisibility(0);
            this.l.setText(StringHelper.stringForVideoTime(tj7Var.n.e * 1000));
            long j = tj7Var.n.h;
            if (j == 0) {
                format = this.z.getString(R.string.obfuscated_res_0x7f0f1805);
            } else {
                format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f1804), R(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
            }
            this.n.setText(format);
            this.m.setVisibility(8);
            D(tj7Var, i, nj7Var);
            N(tj7Var);
            j(this.z, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void G(Configuration configuration) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) && this.y != null && this.j != null && (tbPageContext = this.z) != null && tbPageContext.getPageActivity() != null && this.z.getPageActivity().getWindow() != null && (this.z.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.z.getPageActivity().getWindow().getDecorView();
            if (this.G) {
                this.y.b1();
            }
            if (configuration.orientation == 2) {
                this.H = true;
                if (this.j.getParent() != null) {
                    if (this.j.getParent() == frameLayout) {
                        frameLayout.removeView(this.j);
                    } else {
                        ViewParent parent = this.j.getParent();
                        FrameLayout frameLayout2 = this.i;
                        if (parent == frameLayout2) {
                            frameLayout2.removeView(this.j);
                        }
                    }
                }
                if (this.j.getParent() != null) {
                    return;
                }
                frameLayout.addView(this.j);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                this.j.setLayoutParams(layoutParams);
            } else {
                this.H = false;
                if (this.j.getParent() != null) {
                    if (this.j.getParent() == frameLayout) {
                        frameLayout.removeView(this.j);
                    } else {
                        ViewParent parent2 = this.j.getParent();
                        FrameLayout frameLayout3 = this.i;
                        if (parent2 == frameLayout3) {
                            frameLayout3.removeView(this.j);
                        }
                    }
                }
                if (this.j.getParent() != null) {
                    return;
                }
                this.i.addView(this.j, 0);
                int i = this.B;
                this.j.setLayoutParams(new FrameLayout.LayoutParams(i, (int) (i * 0.5625f)));
                this.y.q0();
                this.G = true;
            }
            this.y.O0(this.z, configuration);
            this.l.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        tj7.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (e() != null) {
                view2.setTag(this);
                e().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != h()) {
                    if (view2 == this.o) {
                        tj7 tj7Var = this.A;
                        if (tj7Var != null && tj7Var.n != null) {
                            this.m.setVisibility(8);
                            this.y.a1();
                            fx9 fx9Var = this.y;
                            tj7 tj7Var2 = this.A;
                            fx9Var.w1(tj7Var2.n.d, tj7Var2.b);
                            L("2");
                            return;
                        }
                        return;
                    } else if (view2 == this.r) {
                        tj7 tj7Var3 = this.A;
                        if (!tj7Var3.m.e) {
                            this.C.c(tj7Var3);
                            return;
                        }
                        return;
                    } else if (view2 == this.x) {
                        sr5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
                        if (currentVisiblePageExtra != null) {
                            this.A.i = currentVisiblePageExtra.a();
                        }
                        this.C.d(this.A);
                        return;
                    } else {
                        return;
                    }
                } else if (this.A == null) {
                    return;
                } else {
                    PbActivityConfig pbActivityConfig = new PbActivityConfig(this.c);
                    pbActivityConfig.createNormalCfg(this.A.b, null, null);
                    if (!this.N) {
                        pbActivityConfig.setVideo_source("bavideotab");
                    } else {
                        pbActivityConfig.setVideo_source("auto_midpage");
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
                    return;
                }
            }
            boolean z = false;
            tj7 tj7Var4 = this.A;
            if (tj7Var4 != null && (bVar = tj7Var4.m) != null && !TextUtils.isEmpty(bVar.a)) {
                if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(this.A.m.a, 0L), z, this.A.m.f)));
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            K();
            uj7 uj7Var = this.C;
            if (uj7Var != null) {
                uj7Var.b();
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !isPlaying()) {
            return;
        }
        this.y.P0();
    }

    public void K() {
        fx9 fx9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (fx9Var = this.y) != null) {
            fx9Var.v0();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.m.setVisibility(8);
            this.y.D1();
            TextView textView = this.k;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
        }
    }

    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.y.N0();
        }
        return invokeV.booleanValue;
    }

    public final void L(String str) {
        tj7 tj7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (tj7Var = this.A) != null && tj7Var.n != null) {
            if ("1".equals(str) || "2".equals(str)) {
                nx9.e(this.A.n.c, "", str, this.E, this.y.D0().getPcdnState());
            }
        }
    }

    public void M(tj7 tj7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, tj7Var) == null) && tj7Var != null && tj7Var.m != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(tj7Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(tj7Var.m.a)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
            }
            if (tj7Var.m.e) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                this.r.setCompoundDrawables(null, null, null, null);
                this.r.setText(this.z.getString(R.string.relate_forum_is_followed));
                return;
            }
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5), BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5));
            this.r.setCompoundDrawables(drawable, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02e9));
        }
    }

    public void N(tj7 tj7Var) {
        tj7.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, tj7Var) == null) && tj7Var != null && (bVar = tj7Var.m) != null) {
            TextView textView = this.q;
            if (TextUtils.isEmpty(bVar.c)) {
                str = tj7Var.m.b;
            } else {
                str = tj7Var.m.c;
            }
            textView.setText(str);
            this.p.startLoad(tj7Var.m.d, 12, false);
            this.p.setShowV(tj7Var.m.f);
            this.p.setIsBigV(tj7Var.m.f);
            M(tj7Var);
            P(tj7Var);
            O(tj7Var);
        }
    }

    public void P(tj7 tj7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, tj7Var) != null) || tj7Var == null) {
            return;
        }
        if (tj7Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(tj7Var.e));
    }

    @Override // com.baidu.tieba.ln6
    public void j(TbPageContext<?> tbPageContext, int i) {
        boolean z;
        tj7.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, tbPageContext, i) == null) {
            if (this.a != i) {
                BDLayoutMode layoutMode = tbPageContext.getLayoutMode();
                if (i == 4) {
                    z = true;
                } else {
                    z = false;
                }
                layoutMode.setNightMode(z);
                tbPageContext.getLayoutMode().onModeChanged(h());
                SkinManager.setBackgroundColor(h(), R.color.CAM_X0201);
                tj7 tj7Var = this.A;
                if (tj7Var != null && (bVar = tj7Var.m) != null) {
                    if (bVar.e) {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                        this.r.setCompoundDrawables(null, null, null, null);
                    } else {
                        SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
                        Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
                        drawable.setBounds(0, 0, BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5), BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5));
                        this.r.setCompoundDrawables(drawable, null, null, null);
                    }
                }
                tj7 tj7Var2 = this.A;
                if (tj7Var2 != null) {
                    if (tj7Var2.h) {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
                    } else {
                        this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
                        SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
                    }
                }
                SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
                this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
            }
            this.a = i;
        }
    }
}
