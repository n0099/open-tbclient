package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qx5 {
    public static /* synthetic */ Interceptable $ic;
    public static final float u;
    public static final float[] v;
    public static final float[] w;
    public static final float[] x;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TbPageContext<?> b;
    public View c;
    public TbImageView d;
    public TextView e;
    public RelativeLayout f;
    public TextView g;
    public LinearLayout h;
    public HeadImageView i;
    public int[] j;
    public ThreadData k;
    public kw5 l;
    public wx5 m;
    public String n;
    public String o;
    public boolean p;
    public AlphaAnimation q;
    public boolean r;
    public boolean s;
    public View.OnClickListener t;

    /* loaded from: classes6.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx5 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        public a(qx5 qx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx5Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.s = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) != null) {
                return;
            }
            this.a.s = true;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ qx5 b;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(qx5 qx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qx5Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z && this.b.p && !this.b.s) {
                if (!StringUtils.isNull(this.a) && this.a.equals(str)) {
                    return;
                }
                qx5 qx5Var = this.b;
                qx5Var.d.startAnimation(qx5Var.q);
                this.a = str;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx5 a;

        public c(qx5 qx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    yi.N(this.a.b.getPageActivity(), this.a.b.getPageActivity().getString(R.string.no_network_guide));
                } else if (this.a.l != null && this.a.l.d != null && this.a.m != null) {
                    this.a.m.a(this.a.l);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948107227, "Lcom/baidu/tieba/qx5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948107227, "Lcom/baidu/tieba/qx5;");
                return;
            }
        }
        float dimension = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        u = dimension;
        v = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, dimension, dimension};
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension};
        x = new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimension, dimension, 0.0f, 0.0f};
    }

    public qx5(TbPageContext<?> tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.j = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.p = false;
        this.r = true;
        this.s = false;
        BdUniqueId.gen();
        this.t = new c(this);
        this.b = tbPageContext;
        this.o = str;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d087d, (ViewGroup) null, false);
        this.c = inflate;
        this.d = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090f49);
        this.e = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09240f);
        this.f = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091d08);
        this.g = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09241d);
        this.h = (LinearLayout) this.c.findViewById(R.id.obfuscated_res_0x7f09241e);
        HeadImageView headImageView = (HeadImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09107f);
        this.i = headImageView;
        headImageView.setIsRound(true);
        this.i.setBorderWidth(yi.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.c.setOnClickListener(this.t);
        this.d.setBorderSurroundContent(true);
        this.d.setDrawBorder(true);
        this.d.setBorderWidth(yi.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
        int l = ((yi.l(tbPageContext.getPageActivity()) - tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12)) - (tbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 2;
        layoutParams.width = l;
        layoutParams.height = l;
        this.f.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.q = alphaAnimation;
        alphaAnimation.setDuration(200L);
        this.q.setAnimationListener(new a(this));
    }

    public void i(kw5 kw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kw5Var) == null) {
            j(kw5Var, -1);
        }
    }

    public void l(wx5 wx5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, wx5Var) == null) {
            this.m = wx5Var;
        }
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void j(kw5 kw5Var, int i) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, kw5Var, i) == null) {
            if (kw5Var != null && (threadData = kw5Var.d) != null && threadData.getThreadAlaInfo() != null) {
                h().setVisibility(0);
                this.l = kw5Var;
                this.k = kw5Var.d;
                int i2 = kw5Var.a;
                if (!TextUtils.isEmpty(kw5Var.c)) {
                    String str = kw5Var.c;
                } else {
                    String str2 = kw5Var.b;
                }
                Object tag = this.d.getTag();
                if (this.r) {
                    this.p = true;
                    this.r = false;
                } else if ((tag instanceof String) && !StringUtils.isNull(this.k.getThreadAlaInfo().cover) && !((String) tag).equals(this.k.getThreadAlaInfo().cover)) {
                    this.p = true;
                } else if (!StringUtils.isNull(this.n) && !StringUtils.isNull(this.k.getThreadAlaInfo().cover) && !this.n.equals(this.k.getThreadAlaInfo().cover)) {
                    this.p = true;
                } else {
                    this.p = false;
                }
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.j);
                String str3 = this.k.getThreadAlaInfo().cover;
                this.n = str3;
                this.d.setTag(str3);
                if (kw5Var.f) {
                    this.d.setConrers(5);
                    gradientDrawable.setCornerRadii(w);
                    this.d.setPlaceHolder(3);
                } else if (kw5Var.g) {
                    this.d.setConrers(10);
                    gradientDrawable.setCornerRadii(x);
                    this.d.setPlaceHolder(3);
                } else if (kw5Var.h) {
                    this.d.setConrers(15);
                    gradientDrawable.setCornerRadii(v);
                    this.d.setPlaceHolder(3);
                }
                this.d.setRadius((int) u);
                this.d.K(this.k.getThreadAlaInfo().cover, 10, false);
                this.h.setBackgroundDrawable(gradientDrawable);
                this.d.setEvent(new b(this));
                this.e.setText(this.b.getPageActivity().getResources().getString(R.string.obfuscated_res_0x7f0f0a82, StringHelper.numberUniformFormatExtraWithRound(this.k.getThreadAlaInfo().audience_count)));
                if (this.k.getAuthor() != null) {
                    String name_show = this.k.getAuthor().getName_show();
                    if (!StringUtils.isNull(name_show)) {
                        this.g.setText(name_show);
                    }
                    this.i.K(this.k.getAuthor().getPortrait(), 12, false);
                }
                k(this.b, TbadkCoreApplication.getInst().getSkinType());
                if (kw5Var.d.getThreadAlaInfo().user_info != null) {
                    StatisticItem.make("c14718").param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_id", kw5Var.getThreadData().getThreadAlaInfo().user_info.ala_id).param("obj_locate", k56.f(this.o)).eventStat();
                    return;
                }
                return;
            }
            h().setVisibility(4);
        }
    }

    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.a != i) {
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
            if (i == 1) {
                this.i.setBorderColor(this.b.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.i.setBorderColor(this.b.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.b.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.b.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.b.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.e.setCompoundDrawablePadding(this.b.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.a = i;
        }
    }
}
