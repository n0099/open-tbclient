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
import com.baidu.tieba.al7;
import com.baidu.tieba.wy9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class vk7 extends no6<al7> implements wk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public al7 A;
    public int B;
    public bl7 C;
    public pz9 D;
    public pz9 E;
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
    public wy9 y;
    public TbPageContext<?> z;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.no6
    /* renamed from: E */
    public void i(al7 al7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, al7Var) == null) {
        }
    }

    @Override // com.baidu.tieba.no6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? R.layout.obfuscated_res_0x7f0d01ec : invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements wy9.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk7 a;

        public a(vk7 vk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk7Var;
        }

        @Override // com.baidu.tieba.wy9.t
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.y.N0()) {
                this.a.l.setVisibility(8);
            }
        }

        @Override // com.baidu.tieba.wy9.t
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

    /* loaded from: classes8.dex */
    public class b implements wy9.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk7 a;

        public b(vk7 vk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk7Var;
        }

        @Override // com.baidu.tieba.wy9.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
                vk7 vk7Var = this.a;
                vk7Var.onClick(vk7Var.i);
            }
        }

        @Override // com.baidu.tieba.wy9.c0
        public void b() {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.I = false;
                this.a.l.setVisibility(8);
                vk7 vk7Var = this.a;
                if (vk7Var.M) {
                    str = "1";
                } else {
                    str = "2";
                }
                vk7Var.L(str);
                vk7 vk7Var2 = this.a;
                vk7Var2.onClick(vk7Var2.j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements wy9.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk7 a;

        public c(vk7 vk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk7Var;
        }

        @Override // com.baidu.tieba.wy9.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    this.a.z.showToast(this.a.n.getText().toString());
                    vk7 vk7Var = this.a;
                    wy9 wy9Var = vk7Var.y;
                    al7 al7Var = vk7Var.A;
                    wy9Var.w1(al7Var.n.d, al7Var.b);
                    this.a.l.setVisibility(8);
                    this.a.L("2");
                } else {
                    this.a.m.setVisibility(0);
                }
                vk7 vk7Var2 = this.a;
                vk7Var2.onClick(vk7Var2.j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements wy9.u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk7 a;

        public d(vk7 vk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk7Var;
        }

        @Override // com.baidu.tieba.wy9.u
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (z) {
                    if (this.a.k.getVisibility() == 0) {
                        this.a.k.setVisibility(8);
                        vk7 vk7Var = this.a;
                        vk7Var.k.startAnimation(vk7Var.J);
                    }
                } else if (this.a.k.getVisibility() == 8) {
                    this.a.k.setVisibility(0);
                    vk7 vk7Var2 = this.a;
                    vk7Var2.k.startAnimation(vk7Var2.K);
                }
            }
        }

        @Override // com.baidu.tieba.wy9.u
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.a.y.N0()) {
                    this.a.k.setVisibility(0);
                } else if (this.a.k.getVisibility() == 0) {
                    this.a.k.setVisibility(8);
                    vk7 vk7Var = this.a;
                    vk7Var.k.startAnimation(vk7Var.J);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk7 a;
        public final /* synthetic */ int b;
        public final /* synthetic */ vk7 c;

        public e(vk7 vk7Var, uk7 uk7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk7Var, uk7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = vk7Var;
            this.a = uk7Var;
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

    /* loaded from: classes8.dex */
    public class f implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uk7 a;
        public final /* synthetic */ vk7 b;

        public f(vk7 vk7Var, uk7 uk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk7Var, uk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vk7Var;
            this.a = uk7Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                al7 al7Var = this.b.A;
                if (al7Var != null && al7Var.n != null) {
                    BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i), "extra", Integer.valueOf(i2), "url", this.b.A.n.d);
                }
                uk7 uk7Var = this.a;
                if (uk7Var != null) {
                    uk7Var.cancel();
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements wy9.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vk7 a;

        public g(vk7 vk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vk7Var;
        }

        @Override // com.baidu.tieba.wy9.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vk7(TbPageContext<?> tbPageContext, boolean z) {
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
        this.i = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f0928fb);
        FrameLayout frameLayout = (FrameLayout) h.findViewById(R.id.video_container);
        this.j = frameLayout;
        wy9 wy9Var = new wy9(tbPageContext, frameLayout, false);
        this.y = wy9Var;
        wy9Var.m1("2005");
        this.k = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0925d1);
        this.l = (TextView) h.findViewById(R.id.obfuscated_res_0x7f090968);
        this.m = (FrameLayout) h.findViewById(R.id.obfuscated_res_0x7f091791);
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091793);
        this.o = (TextView) h.findViewById(R.id.obfuscated_res_0x7f091792);
        this.p = (HeadImageView) h.findViewById(R.id.obfuscated_res_0x7f092881);
        this.q = (TextView) h.findViewById(R.id.user_name);
        this.r = (TextView) h.findViewById(R.id.obfuscated_res_0x7f0902ea);
        this.w = (LinearLayout) h.findViewById(R.id.thread_info_commont_container);
        this.x = (LinearLayout) h.findViewById(R.id.obfuscated_res_0x7f09016e);
        this.s = (TextView) h.findViewById(R.id.thread_info_commont_num);
        this.t = (TextView) h.findViewById(R.id.obfuscated_res_0x7f092564);
        this.u = (ImageView) h.findViewById(R.id.thread_info_commont_img);
        this.v = (ImageView) h.findViewById(R.id.obfuscated_res_0x7f092563);
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
        this.C = new bl7(this.z, this);
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

    public void O(al7 al7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, al7Var) != null) || al7Var == null) {
            return;
        }
        SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0106);
        this.u.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_comment));
        this.s.setText(StringHelper.numFormatOverWan(al7Var.d));
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

    @Override // com.baidu.tieba.wk7
    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.z.showToast(str);
        }
    }

    @Override // com.baidu.tieba.wk7
    public void o(boolean z) {
        al7 al7Var;
        al7.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048598, this, z) == null) && (al7Var = this.A) != null && (bVar = al7Var.m) != null) {
            bVar.e = z;
            M(al7Var);
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

    @Override // com.baidu.tieba.wk7
    public void n() {
        al7 al7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || (al7Var = this.A) == null) {
            return;
        }
        boolean z = !al7Var.h;
        al7Var.h = z;
        if (z) {
            al7Var.e++;
        } else {
            al7Var.e--;
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.startAnimation(C());
        }
        P(this.A);
    }

    public final void D(al7 al7Var, int i, uk7 uk7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, al7Var, i, uk7Var) == null) && al7Var != null && al7Var.n != null) {
            this.y.D1();
            this.y.d1(true);
            this.y.f1(new a(this));
            this.y.j1(new b(this));
            this.y.h1(new c(this));
            this.y.c1(false);
            pz9 pz9Var = new pz9();
            this.D = pz9Var;
            pz9Var.c = al7Var.b;
            pz9Var.d = al7Var.a;
            pz9Var.e = TbadkCoreApplication.getCurrentAccount();
            pz9 pz9Var2 = new pz9();
            this.E = pz9Var2;
            pz9Var2.c = al7Var.b;
            pz9Var2.d = al7Var.a;
            pz9Var2.e = TbadkCoreApplication.getCurrentAccount();
            if (this.N) {
                StatisticItem statisticItem = new StatisticItem("c12590");
                statisticItem.param("tid", al7Var.b);
                statisticItem.param("nid", al7Var.c);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, al7Var.c());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("fid", al7Var.a);
                statisticItem.param("obj_locate", i);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(statisticItem);
                pz9 pz9Var3 = this.D;
                pz9Var3.g = "auto_midpage";
                pz9Var3.a = "13";
                pz9Var3.i = "1";
                pz9 pz9Var4 = this.E;
                pz9Var4.g = "auto_midpage";
                pz9Var4.a = "auto_midpage";
                pz9Var4.i = "1";
            } else {
                pz9 pz9Var5 = this.D;
                pz9Var5.i = "frs_bavideotab";
                pz9Var5.a = "12";
                pz9 pz9Var6 = this.E;
                pz9Var6.i = "frs_bavideotab";
                pz9Var6.a = "frs_bavideotab";
            }
            al7.c cVar = al7Var.n;
            if (cVar != null) {
                pz9 pz9Var7 = this.D;
                String str = cVar.c;
                pz9Var7.m = str;
                this.E.m = str;
            }
            this.y.D0().setVideoStatData(this.D);
            this.y.q0();
            this.y.g1(new d(this));
            this.y.k1(new e(this, uk7Var, i));
            this.y.l1(new f(this, uk7Var));
            this.y.q1(al7Var.n.j);
            this.y.s1(al7Var.n.d, al7Var.b);
            this.y.r1(al7Var.l);
            this.y.i1(new g(this));
            this.y.T0();
            this.y.t1();
            if (al7Var.s) {
                onClick(this.j);
                this.I = false;
                this.y.B1(al7Var.n.d, al7Var.b, null, new Object[0]);
            }
            this.I = false;
        }
    }

    public void F(al7 al7Var, int i, uk7 uk7Var) {
        String format;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIL(1048579, this, al7Var, i, uk7Var) == null) && al7Var != null && al7Var.n != null) {
            this.A = al7Var;
            this.M = al7Var.s;
            this.k.setVisibility(0);
            this.k.setText(al7Var.l);
            this.l.setVisibility(0);
            this.l.setText(StringHelper.stringForVideoTime(al7Var.n.e * 1000));
            long j = al7Var.n.h;
            if (j == 0) {
                format = this.z.getString(R.string.obfuscated_res_0x7f0f1823);
            } else {
                format = String.format(this.z.getString(R.string.obfuscated_res_0x7f0f1822), R(String.format("%.1f", Float.valueOf(((float) j) / 1048576.0f))));
            }
            this.n.setText(format);
            this.m.setVisibility(8);
            D(al7Var, i, uk7Var);
            N(al7Var);
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
        al7.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, view2) == null) {
            if (e() != null) {
                view2.setTag(this);
                e().a(view2, this.A);
            }
            if (view2 != this.p && view2 != this.q) {
                if (view2 != this.w && view2 != this.k && view2 != h()) {
                    if (view2 == this.o) {
                        al7 al7Var = this.A;
                        if (al7Var != null && al7Var.n != null) {
                            this.m.setVisibility(8);
                            this.y.a1();
                            wy9 wy9Var = this.y;
                            al7 al7Var2 = this.A;
                            wy9Var.w1(al7Var2.n.d, al7Var2.b);
                            L("2");
                            return;
                        }
                        return;
                    } else if (view2 == this.r) {
                        al7 al7Var3 = this.A;
                        if (!al7Var3.m.e) {
                            this.C.c(al7Var3);
                            return;
                        }
                        return;
                    } else if (view2 == this.x) {
                        ms5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
            al7 al7Var4 = this.A;
            if (al7Var4 != null && (bVar = al7Var4.m) != null && !TextUtils.isEmpty(bVar.a)) {
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
            bl7 bl7Var = this.C;
            if (bl7Var != null) {
                bl7Var.b();
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
        wy9 wy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (wy9Var = this.y) != null) {
            wy9Var.v0();
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
        al7 al7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (al7Var = this.A) != null && al7Var.n != null) {
            if ("1".equals(str) || "2".equals(str)) {
                ez9.e(this.A.n.c, "", str, this.E, this.y.D0().getPcdnState());
            }
        }
    }

    public void M(al7 al7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, al7Var) == null) && al7Var != null && al7Var.m != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(al7Var.m.a) && TbadkCoreApplication.getCurrentAccount().equals(al7Var.m.a)) {
                this.r.setVisibility(8);
            } else {
                this.r.setVisibility(0);
            }
            if (al7Var.m.e) {
                SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0109);
                this.r.setCompoundDrawables(null, null, null, null);
                this.r.setText(this.z.getString(R.string.relate_forum_is_followed));
                return;
            }
            SkinManager.setViewTextColor(this.r, (int) R.color.CAM_X0302);
            Drawable drawable = SkinManager.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5), BdUtilHelper.getDimens(this.c, R.dimen.obfuscated_res_0x7f0701d5));
            this.r.setCompoundDrawables(drawable, null, null, null);
            this.r.setText(this.z.getString(R.string.obfuscated_res_0x7f0f02ea));
        }
    }

    public void N(al7 al7Var) {
        al7.b bVar;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, al7Var) == null) && al7Var != null && (bVar = al7Var.m) != null) {
            TextView textView = this.q;
            if (TextUtils.isEmpty(bVar.c)) {
                str = al7Var.m.b;
            } else {
                str = al7Var.m.c;
            }
            textView.setText(str);
            this.p.startLoad(al7Var.m.d, 12, false);
            this.p.setShowV(al7Var.m.f);
            this.p.setIsBigV(al7Var.m.f);
            M(al7Var);
            P(al7Var);
            O(al7Var);
        }
    }

    public void P(al7 al7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, al7Var) != null) || al7Var == null) {
            return;
        }
        if (al7Var.h) {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_s));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0301);
        } else {
            this.v.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_home_card_like_n));
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0106);
        }
        this.t.setText(StringHelper.numFormatOverWan(al7Var.e));
    }

    @Override // com.baidu.tieba.no6
    public void j(TbPageContext<?> tbPageContext, int i) {
        boolean z;
        al7.b bVar;
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
                al7 al7Var = this.A;
                if (al7Var != null && (bVar = al7Var.m) != null) {
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
                al7 al7Var2 = this.A;
                if (al7Var2 != null) {
                    if (al7Var2.h) {
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
