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
import com.baidu.tieba.hv9;
import com.baidu.tieba.tf7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class of7 extends cj6<tf7> implements pf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public tf7 A;
    public int B;
    public uf7 C;
    public aw9 D;
    public aw9 E;
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
    public hv9 y;
    public TbPageContext<?> z;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cj6
    /* renamed from: F */
    public void j(tf7 tf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tf7Var) == null) {
        }
    }

    @Override // com.baidu.tieba.cj6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01eb : invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements hv9.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of7 a;

        public a(of7 of7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of7Var;
        }

        @Override // com.baidu.tieba.hv9.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.N0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.hv9.t
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
    public class b implements hv9.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of7 a;

        public b(of7 of7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of7Var;
        }

        @Override // com.baidu.tieba.hv9.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                of7 of7Var = this.a;
                of7Var.onClick(of7Var.i);
            }
        }

        @Override // com.baidu.tieba.hv9.c0
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                of7 of7Var = this.a;
                if (of7Var.M) {
                    str = "1";
                } else {
                    str = "2";
                }
                of7Var.M(str);
                of7 of7Var2 = this.a;
                of7Var2.onClick(of7Var2.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements hv9.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of7 a;

        public c(of7 of7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of7Var;
        }

        @Override // com.baidu.tieba.hv9.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    of7 of7Var = this.a;
                    hv9 hv9Var = of7Var.y;
                    tf7 tf7Var = of7Var.A;
                    hv9Var.w1(tf7Var.n.d, tf7Var.b);
                    this.a.l.setVisibility(8);
                    this.a.M("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                of7 of7Var2 = this.a;
                of7Var2.onClick(of7Var2.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements hv9.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of7 a;

        public d(of7 of7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of7Var;
        }

        @Override // com.baidu.tieba.hv9.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        of7 of7Var = this.a;
                        of7Var.k.startAnimation(of7Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    of7 of7Var2 = this.a;
                    of7Var2.k.startAnimation(of7Var2.K);
                }
            }
        }

        @Override // com.baidu.tieba.hv9.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    of7 of7Var = this.a;
                    of7Var.k.startAnimation(of7Var.J);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf7 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ of7 c;

        public e(of7 of7Var, nf7 nf7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of7Var, nf7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = of7Var;
            this.a = nf7Var;
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
        public final /* synthetic */ nf7 a;
        public final /* synthetic */ of7 b;

        public f(of7 of7Var, nf7 nf7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of7Var, nf7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = of7Var;
            this.a = nf7Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                tf7 tf7Var = this.b.A;
                if (tf7Var != null && tf7Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                nf7 nf7Var = this.a;
                if (nf7Var != null) {
                    nf7Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements hv9.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ of7 a;

        public g(of7 of7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {of7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = of7Var;
        }

        @Override // com.baidu.tieba.hv9.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public of7(TbPageContext<?> tbPageContext, boolean z) {
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
        View i3 = i();
        this.z = tbPageContext;
        this.i = (FrameLayout) i3.findViewById(R.id.obfuscated_res_0x7f0928bd);
        FrameLayout frameLayout = (FrameLayout) i3.findViewById(R.id.video_container);
        this.j = frameLayout;
        hv9 hv9Var = new hv9(tbPageContext, frameLayout, false);
        this.y = hv9Var;
        hv9Var.m1("2005");
        this.k = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0925a7);
        this.l = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09097b);
        this.m = (FrameLayout) i3.findViewById(R.id.obfuscated_res_0x7f091799);
        this.n = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09179b);
        this.o = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09179a);
        this.p = (HeadImageView) i3.findViewById(R.id.obfuscated_res_0x7f092842);
        this.q = (TextView) i3.findViewById(R.id.user_name);
        this.r = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0902e8);
        this.w = (LinearLayout) i3.findViewById(R.id.thread_info_commont_container);
        this.x = (LinearLayout) i3.findViewById(R.id.obfuscated_res_0x7f09016f);
        this.s = (TextView) i3.findViewById(R.id.thread_info_commont_num);
        this.t = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09253a);
        this.u = (ImageView) i3.findViewById(R.id.thread_info_commont_img);
        this.v = (ImageView) i3.findViewById(R.id.obfuscated_res_0x7f092539);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.r.setOnClickListener(this);
        i3.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.B = BdUtilHelper.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = (int) (this.B * 0.5625f);
        this.i.setLayoutParams(layoutParams);
        this.p.setIsRound(true);
        this.C = new uf7(this.z, this);
        this.J = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.K = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    public boolean J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.y.X0(i);
        }
        return invokeI.booleanValue;
    }

    public void P(tf7 tf7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, tf7Var) != null) || tf7Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(tf7Var.d));
    }

    public String S(String str) {
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

    @Override // com.baidu.tieba.pf7
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.baidu.tieba.pf7
    public void s(boolean z) {
        tf7 tf7Var;
        tf7.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z) == null) && (tf7Var = this.A) != null && (bVar = tf7Var.m) != null) {
            bVar.e = z;
            N(tf7Var);
        }
    }

    public final Animation D() {
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

    @Override // com.baidu.tieba.pf7
    public void q() {
        tf7 tf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (tf7Var = this.A) == null) {
            return;
        }
        boolean z = !tf7Var.h;
        tf7Var.h = z;
        if (z) {
            tf7Var.e++;
        } else {
            tf7Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(D());
        }
        Q(this.A);
    }

    public final void E(tf7 tf7Var, int i, nf7 nf7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tf7Var, i, nf7Var) == null) && tf7Var != null && tf7Var.n != null) {
            this.y.D1();
            this.y.d1(true);
            this.y.f1(new a(this));
            this.y.j1(new b(this));
            this.y.h1(new c(this));
            this.y.c1(false);
            aw9 aw9Var = new aw9();
            this.D = aw9Var;
            aw9Var.c = tf7Var.b;
            aw9Var.d = tf7Var.a;
            aw9Var.e = TbadkCoreApplication.getCurrentAccount();
            aw9 aw9Var2 = new aw9();
            this.E = aw9Var2;
            aw9Var2.c = tf7Var.b;
            aw9Var2.d = tf7Var.a;
            aw9Var2.e = TbadkCoreApplication.getCurrentAccount();
            if (this.N) {
                StatisticItem statisticItem = new StatisticItem("c12590");
                statisticItem.param("tid", tf7Var.b);
                statisticItem.param("nid", tf7Var.c);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, tf7Var.c());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", tf7Var.a);
                statisticItem.param("obj_locate", i);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(statisticItem);
                aw9 aw9Var3 = this.D;
                aw9Var3.g = "auto_midpage";
                aw9Var3.a = "13";
                aw9Var3.i = "1";
                aw9 aw9Var4 = this.E;
                aw9Var4.g = "auto_midpage";
                aw9Var4.a = "auto_midpage";
                aw9Var4.i = "1";
            } else {
                aw9 aw9Var5 = this.D;
                aw9Var5.i = "frs_bavideotab";
                aw9Var5.a = "12";
                aw9 aw9Var6 = this.E;
                aw9Var6.i = "frs_bavideotab";
                aw9Var6.a = "frs_bavideotab";
            }
            tf7.c cVar = tf7Var.n;
            if (cVar != null) {
                aw9 aw9Var7 = this.D;
                String str = cVar.c;
                aw9Var7.m = str;
                this.E.m = str;
            }
            this.y.D0().setVideoStatData(this.D);
            this.y.q0();
            this.y.g1(new d(this));
            this.y.k1(new e(this, nf7Var, i));
            this.y.l1(new f(this, nf7Var));
            this.y.q1(tf7Var.n.j);
            this.y.s1(tf7Var.n.d, tf7Var.b);
            this.y.r1(tf7Var.l);
            this.y.i1(new g(this));
            this.y.T0();
            this.y.t1();
            if (tf7Var.s) {
                onClick(this.j);
                this.I = false;
                this.y.B1(tf7Var.n.d, tf7Var.b, null, new Object[0]);
            }
            this.I = false;
        }
    }

    public void G(tf7 tf7Var, int i, nf7 nf7Var) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, tf7Var, i, nf7Var) == null) && tf7Var != null && tf7Var.n != null) {
            this.A = tf7Var;
            this.M = tf7Var.s;
            this.k.setVisibility(0);
            this.k.setText(tf7Var.l);
            this.l.setVisibility(0);
            this.l.setText(StringHelper.stringForVideoTime(tf7Var.n.e * 1000));
            long j = tf7Var.n.h;
            if (j == 0) {
                format = this.z.getString(R.string.obfuscated_res_0x7f0f1803);
            } else {
                format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f1802), S(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
            }
            this.n.setText(format);
            this.m.setVisibility(8);
            E(tf7Var, i, nf7Var);
            O(tf7Var);
            k(this.z, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void H(Configuration configuration) {
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
        tf7.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            if (f() != null) {
                view2.setTag(this);
                f().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != i()) {
                    if (view2 == this.o) {
                        tf7 tf7Var = this.A;
                        if (tf7Var != null && tf7Var.n != null) {
                            this.m.setVisibility(8);
                            this.y.a1();
                            hv9 hv9Var = this.y;
                            tf7 tf7Var2 = this.A;
                            hv9Var.w1(tf7Var2.n.d, tf7Var2.b);
                            M("2");
                            return;
                        }
                        return;
                    } else if (view2 == this.r) {
                        tf7 tf7Var3 = this.A;
                        if (!tf7Var3.m.e) {
                            this.C.c(tf7Var3);
                            return;
                        }
                        return;
                    } else if (view2 == this.x) {
                        tm5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(c());
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
            tf7 tf7Var4 = this.A;
            if (tf7Var4 != null && (bVar = tf7Var4.m) != null && !TextUtils.isEmpty(bVar.a)) {
                if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(this.A.m.a, 0L), z, this.A.m.f)));
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            L();
            uf7 uf7Var = this.C;
            if (uf7Var != null) {
                uf7Var.b();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !isPlaying()) {
            return;
        }
        this.y.P0();
    }

    public void L() {
        hv9 hv9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (hv9Var = this.y) != null) {
            hv9Var.v0();
        }
    }

    public void R() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.y.N0();
        }
        return invokeV.booleanValue;
    }

    public final void M(String str) {
        tf7 tf7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (tf7Var = this.A) != null && tf7Var.n != null) {
            if ("1".equals(str) || "2".equals(str)) {
                pv9.e(this.A.n.c, "", str, this.E, this.y.D0().getPcdnState());
            }
        }
    }

    public void N(tf7 tf7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, tf7Var) == null) && tf7Var != null && tf7Var.m != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(tf7Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(tf7Var.m.a)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
            }
            if (tf7Var.m.e) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                this.r.setCompoundDrawables(null, null, null, null);
                this.r.setText(this.z.getString(R.string.relate_forum_is_followed));
                return;
            }
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5), BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5));
            this.r.setCompoundDrawables(drawable, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02ec));
        }
    }

    public void O(tf7 tf7Var) {
        tf7.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, tf7Var) == null) && tf7Var != null && (bVar = tf7Var.m) != null) {
            TextView textView = this.q;
            if (TextUtils.isEmpty(bVar.c)) {
                str = tf7Var.m.b;
            } else {
                str = tf7Var.m.c;
            }
            textView.setText(str);
            this.p.startLoad(tf7Var.m.d, 12, false);
            this.p.setShowV(tf7Var.m.f);
            this.p.setIsBigV(tf7Var.m.f);
            N(tf7Var);
            Q(tf7Var);
            P(tf7Var);
        }
    }

    public void Q(tf7 tf7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, tf7Var) != null) || tf7Var == null) {
            return;
        }
        if (tf7Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(tf7Var.e));
    }

    @Override // com.baidu.tieba.cj6
    public void k(TbPageContext<?> tbPageContext, int i) {
        boolean z;
        tf7.b bVar;
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
                tbPageContext.getLayoutMode().onModeChanged(i());
                SkinManager.setBackgroundColor(i(), R.color.CAM_X0201);
                tf7 tf7Var = this.A;
                if (tf7Var != null && (bVar = tf7Var.m) != null) {
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
                tf7 tf7Var2 = this.A;
                if (tf7Var2 != null) {
                    if (tf7Var2.h) {
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
