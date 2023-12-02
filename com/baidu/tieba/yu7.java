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
import com.baidu.tieba.dv7;
import com.baidu.tieba.nda;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class yu7 extends nl6<dv7> implements zu7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dv7 A;
    public int B;
    public ev7 C;
    public gea D;
    public gea E;
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
    public nda y;
    public TbPageContext<?> z;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: G */
    public void j(dv7 dv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dv7Var) == null) {
        }
    }

    @Override // com.baidu.tieba.nl6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01f6 : invokeV.intValue;
    }

    /* loaded from: classes9.dex */
    public class a implements nda.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu7 a;

        public a(yu7 yu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu7Var;
        }

        @Override // com.baidu.tieba.nda.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.N0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.nda.t
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

    /* loaded from: classes9.dex */
    public class b implements nda.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu7 a;

        public b(yu7 yu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu7Var;
        }

        @Override // com.baidu.tieba.nda.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                yu7 yu7Var = this.a;
                yu7Var.onClick(yu7Var.i);
            }
        }

        @Override // com.baidu.tieba.nda.c0
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                yu7 yu7Var = this.a;
                if (yu7Var.M) {
                    str = "1";
                } else {
                    str = "2";
                }
                yu7Var.N(str);
                yu7 yu7Var2 = this.a;
                yu7Var2.onClick(yu7Var2.j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements nda.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu7 a;

        public c(yu7 yu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu7Var;
        }

        @Override // com.baidu.tieba.nda.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    yu7 yu7Var = this.a;
                    nda ndaVar = yu7Var.y;
                    dv7 dv7Var = yu7Var.A;
                    ndaVar.w1(dv7Var.n.d, dv7Var.b);
                    this.a.l.setVisibility(8);
                    this.a.N("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                yu7 yu7Var2 = this.a;
                yu7Var2.onClick(yu7Var2.j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements nda.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu7 a;

        public d(yu7 yu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu7Var;
        }

        @Override // com.baidu.tieba.nda.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        yu7 yu7Var = this.a;
                        yu7Var.k.startAnimation(yu7Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    yu7 yu7Var2 = this.a;
                    yu7Var2.k.startAnimation(yu7Var2.K);
                }
            }
        }

        @Override // com.baidu.tieba.nda.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    yu7 yu7Var = this.a;
                    yu7Var.k.startAnimation(yu7Var.J);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu7 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ yu7 c;

        public e(yu7 yu7Var, xu7 xu7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var, xu7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yu7Var;
            this.a = xu7Var;
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

    /* loaded from: classes9.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xu7 a;
        public final /* synthetic */ yu7 b;

        public f(yu7 yu7Var, xu7 xu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var, xu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yu7Var;
            this.a = xu7Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                dv7 dv7Var = this.b.A;
                if (dv7Var != null && dv7Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                xu7 xu7Var = this.a;
                if (xu7Var != null) {
                    xu7Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g implements nda.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yu7 a;

        public g(yu7 yu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yu7Var;
        }

        @Override // com.baidu.tieba.nda.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yu7(TbPageContext<?> tbPageContext, boolean z) {
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
        this.i = (FrameLayout) i3.findViewById(R.id.obfuscated_res_0x7f0929a4);
        FrameLayout frameLayout = (FrameLayout) i3.findViewById(R.id.video_container);
        this.j = frameLayout;
        nda ndaVar = new nda(tbPageContext, frameLayout, false);
        this.y = ndaVar;
        ndaVar.m1("2005");
        this.k = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f092685);
        this.l = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f0909b9);
        this.m = (FrameLayout) i3.findViewById(R.id.obfuscated_res_0x7f09184d);
        this.n = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09184f);
        this.o = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09184e);
        this.p = (HeadImageView) i3.findViewById(R.id.obfuscated_res_0x7f092928);
        this.q = (TextView) i3.findViewById(R.id.user_name);
        this.r = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f090310);
        this.w = (LinearLayout) i3.findViewById(R.id.thread_info_commont_container);
        this.x = (LinearLayout) i3.findViewById(R.id.obfuscated_res_0x7f090182);
        this.s = (TextView) i3.findViewById(R.id.thread_info_commont_num);
        this.t = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f092618);
        this.u = (ImageView) i3.findViewById(R.id.thread_info_commont_img);
        this.v = (ImageView) i3.findViewById(R.id.obfuscated_res_0x7f092617);
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
        this.C = new ev7(this.z, this);
        this.J = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.K = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    public boolean K(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return this.y.X0(i);
        }
        return invokeI.booleanValue;
    }

    public void Q(dv7 dv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, dv7Var) != null) || dv7Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(dv7Var.d));
    }

    public String T(String str) {
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

    @Override // com.baidu.tieba.zu7
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.baidu.tieba.zu7
    public void x(boolean z) {
        dv7 dv7Var;
        dv7.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048599, this, z) == null) && (dv7Var = this.A) != null && (bVar = dv7Var.m) != null) {
            bVar.e = z;
            O(dv7Var);
        }
    }

    public final Animation E() {
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

    @Override // com.baidu.tieba.zu7
    public void u() {
        dv7 dv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (dv7Var = this.A) == null) {
            return;
        }
        boolean z = !dv7Var.h;
        dv7Var.h = z;
        if (z) {
            dv7Var.e++;
        } else {
            dv7Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(E());
        }
        R(this.A);
    }

    public final void F(dv7 dv7Var, int i, xu7 xu7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dv7Var, i, xu7Var) == null) && dv7Var != null && dv7Var.n != null) {
            this.y.D1();
            this.y.d1(true);
            this.y.f1(new a(this));
            this.y.j1(new b(this));
            this.y.h1(new c(this));
            this.y.c1(false);
            gea geaVar = new gea();
            this.D = geaVar;
            geaVar.c = dv7Var.b;
            geaVar.d = dv7Var.a;
            geaVar.e = TbadkCoreApplication.getCurrentAccount();
            gea geaVar2 = new gea();
            this.E = geaVar2;
            geaVar2.c = dv7Var.b;
            geaVar2.d = dv7Var.a;
            geaVar2.e = TbadkCoreApplication.getCurrentAccount();
            if (this.N) {
                StatisticItem statisticItem = new StatisticItem("c12590");
                statisticItem.param("tid", dv7Var.b);
                statisticItem.param("nid", dv7Var.c);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, dv7Var.c());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", dv7Var.a);
                statisticItem.param("obj_locate", i);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(statisticItem);
                gea geaVar3 = this.D;
                geaVar3.g = "auto_midpage";
                geaVar3.a = "13";
                geaVar3.i = "1";
                gea geaVar4 = this.E;
                geaVar4.g = "auto_midpage";
                geaVar4.a = "auto_midpage";
                geaVar4.i = "1";
            } else {
                gea geaVar5 = this.D;
                geaVar5.i = "frs_bavideotab";
                geaVar5.a = "12";
                gea geaVar6 = this.E;
                geaVar6.i = "frs_bavideotab";
                geaVar6.a = "frs_bavideotab";
            }
            dv7.c cVar = dv7Var.n;
            if (cVar != null) {
                gea geaVar7 = this.D;
                String str = cVar.c;
                geaVar7.m = str;
                this.E.m = str;
            }
            this.y.D0().setVideoStatData(this.D);
            this.y.q0();
            this.y.g1(new d(this));
            this.y.k1(new e(this, xu7Var, i));
            this.y.l1(new f(this, xu7Var));
            this.y.q1(dv7Var.n.j);
            this.y.s1(dv7Var.n.d, dv7Var.b);
            this.y.r1(dv7Var.l);
            this.y.i1(new g(this));
            this.y.T0();
            this.y.t1();
            if (dv7Var.s) {
                onClick(this.j);
                this.I = false;
                this.y.B1(dv7Var.n.d, dv7Var.b, null, new Object[0]);
            }
            this.I = false;
        }
    }

    public void H(dv7 dv7Var, int i, xu7 xu7Var) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, dv7Var, i, xu7Var) == null) && dv7Var != null && dv7Var.n != null) {
            this.A = dv7Var;
            this.M = dv7Var.s;
            this.k.setVisibility(0);
            this.k.setText(dv7Var.l);
            this.l.setVisibility(0);
            this.l.setText(StringHelper.stringForVideoTime(dv7Var.n.e * 1000));
            long j = dv7Var.n.h;
            if (j == 0) {
                format = this.z.getString(R.string.obfuscated_res_0x7f0f182f);
            } else {
                format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f182e), T(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
            }
            this.n.setText(format);
            this.m.setVisibility(8);
            F(dv7Var, i, xu7Var);
            P(dv7Var);
            k(this.z, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void I(Configuration configuration) {
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
        dv7.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view2) == null) {
            if (f() != null) {
                view2.setTag(this);
                f().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != i()) {
                    if (view2 == this.o) {
                        dv7 dv7Var = this.A;
                        if (dv7Var != null && dv7Var.n != null) {
                            this.m.setVisibility(8);
                            this.y.a1();
                            nda ndaVar = this.y;
                            dv7 dv7Var2 = this.A;
                            ndaVar.w1(dv7Var2.n.d, dv7Var2.b);
                            N("2");
                            return;
                        }
                        return;
                    } else if (view2 == this.r) {
                        dv7 dv7Var3 = this.A;
                        if (!dv7Var3.m.e) {
                            this.C.c(dv7Var3);
                            return;
                        }
                        return;
                    } else if (view2 == this.x) {
                        xo5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(c());
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
            dv7 dv7Var4 = this.A;
            if (dv7Var4 != null && (bVar = dv7Var4.m) != null && !TextUtils.isEmpty(bVar.a)) {
                if (TbadkCoreApplication.isLogin() && this.A.m.a.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.z.getPageActivity()).createNormalConfig(JavaTypesHelper.toLong(this.A.m.a, 0L), z, this.A.m.f)));
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            M();
            ev7 ev7Var = this.C;
            if (ev7Var != null) {
                ev7Var.b();
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || !isPlaying()) {
            return;
        }
        this.y.P0();
    }

    public void M() {
        nda ndaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (ndaVar = this.y) != null) {
            ndaVar.v0();
        }
    }

    public void S() {
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

    public final void N(String str) {
        dv7 dv7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (dv7Var = this.A) != null && dv7Var.n != null) {
            if ("1".equals(str) || "2".equals(str)) {
                vda.e(this.A.n.c, "", str, this.E, this.y.D0().getPcdnState());
            }
        }
    }

    public void O(dv7 dv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, dv7Var) == null) && dv7Var != null && dv7Var.m != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(dv7Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(dv7Var.m.a)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
            }
            if (dv7Var.m.e) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                this.r.setCompoundDrawables(null, null, null, null);
                this.r.setText(this.z.getString(R.string.relate_forum_is_followed));
                return;
            }
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5), BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5));
            this.r.setCompoundDrawables(drawable, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02f4));
        }
    }

    public void P(dv7 dv7Var) {
        dv7.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, dv7Var) == null) && dv7Var != null && (bVar = dv7Var.m) != null) {
            TextView textView = this.q;
            if (TextUtils.isEmpty(bVar.c)) {
                str = dv7Var.m.b;
            } else {
                str = dv7Var.m.c;
            }
            textView.setText(str);
            this.p.startLoad(dv7Var.m.d, 12, false);
            this.p.setShowV(dv7Var.m.f);
            this.p.setIsBigV(dv7Var.m.f);
            O(dv7Var);
            R(dv7Var);
            Q(dv7Var);
        }
    }

    public void R(dv7 dv7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, dv7Var) != null) || dv7Var == null) {
            return;
        }
        if (dv7Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(dv7Var.e));
    }

    @Override // com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        boolean z;
        dv7.b bVar;
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
                dv7 dv7Var = this.A;
                if (dv7Var != null && (bVar = dv7Var.m) != null) {
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
                dv7 dv7Var2 = this.A;
                if (dv7Var2 != null) {
                    if (dv7Var2.h) {
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
