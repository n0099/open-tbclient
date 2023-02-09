package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.data.UserVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.r38;
import com.baidu.tieba.view.FollowUserSpinnerBtn;
import com.baidu.tieba.view.GodRecommendLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.BaijiahaoInfo;
/* loaded from: classes6.dex */
public class un8 {
    public static /* synthetic */ Interceptable $ic;
    public static final int b0;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadPendantView A;
    public RelativeLayout B;
    public GodRecommendLayout C;
    public ImageView D;
    public TBLottieAnimationView E;
    public AnimatorSet F;
    public View G;
    public View.OnClickListener H;
    public ViewGroup I;
    public View J;
    public TextView K;
    public ImageView L;
    public View M;
    public TextView N;
    public ImageView O;
    public r38 P;
    public boolean Q;
    public AnimatorSet R;
    public ValueAnimator S;
    public ObjectAnimator T;
    public ObjectAnimator U;
    public qm8 V;
    public boolean W;
    public boolean X;
    public FollowUserSpinnerBtn.b Y;
    public r38.b Z;
    public TbPageContext a;
    public View.OnClickListener a0;
    public boolean b;
    public View c;
    public UserData d;
    public i77 e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public UserIconBox j;
    public FrameLayout k;
    public TextView l;
    public TextView m;
    public FrameLayout n;
    public TextView o;
    public TextView p;
    public FrameLayout q;
    public TextView r;
    public TextView s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public FollowUserSpinnerBtn w;
    public TBSpecificationBtn x;
    public TbImageView y;
    public ImageView z;

    /* loaded from: classes6.dex */
    public class a implements FollowUserSpinnerBtn.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public a(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // com.baidu.tieba.view.FollowUserSpinnerBtn.b
        public void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !ViewHelper.checkUpIsLogin(this.a.a.getPageActivity())) {
                return;
            }
            this.a.W = z2;
            this.a.X = false;
            if (z) {
                this.a.C.setCouldStatistic(true);
                if (this.a.d != null) {
                    this.a.P.i(this.a.d.getPortrait(), 0);
                }
            } else {
                this.a.C.setCouldStatistic(false);
                this.a.Q = false;
                this.a.J();
                if (this.a.R != null) {
                    this.a.R.start();
                }
            }
            if (z && !z2) {
                TiebaStatic.log(new StatisticItem("c13900"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements r38.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public b(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // com.baidu.tieba.r38.b
        public void a(rn8 rn8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, rn8Var, i) == null) {
                int i2 = 1;
                if (rn8Var != null && i == 0) {
                    this.a.C.setData(rn8Var.a());
                    if (!this.a.X) {
                        this.a.Q = true;
                        this.a.J();
                        if (this.a.R != null) {
                            this.a.R.start();
                        }
                    }
                    StatisticItem statisticItem = new StatisticItem("c13901");
                    if (!this.a.W) {
                        i2 = 2;
                    }
                    TiebaStatic.log(statisticItem.param("obj_type", i2));
                } else if (i == 1) {
                    BdToast.b(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(R.string.god_get_error)).k();
                } else if (i == 3) {
                    BdToast.b(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(R.string.god_get_refresh_error)).k();
                } else {
                    BdToast.b(this.a.a.getPageActivity(), this.a.a.getPageActivity().getText(R.string.god_get_limit_error)).k();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public c(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.P != null && this.a.d != null) {
                    this.a.X = true;
                    this.a.P.h(this.a.d.getPortrait());
                }
                TiebaStatic.log(new StatisticItem("c13904"));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public d(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * un8.b0;
                ViewGroup.LayoutParams layoutParams = this.a.C.getLayoutParams();
                if (this.a.Q) {
                    layoutParams.height = (int) floatValue;
                } else {
                    layoutParams.height = (int) (un8.b0 - floatValue);
                }
                if (this.a.V != null) {
                    qm8 qm8Var = this.a.V;
                    if (!this.a.Q) {
                        floatValue = -floatValue;
                    }
                    qm8Var.b((int) floatValue);
                }
                this.a.C.setLayoutParams(layoutParams);
                this.a.C.h();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public e(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                super.onAnimationEnd(animator);
                ViewGroup.LayoutParams layoutParams = this.a.C.getLayoutParams();
                if (this.a.Q) {
                    layoutParams.height = un8.b0;
                } else {
                    layoutParams.height = 0;
                }
                this.a.C.setLayoutParams(layoutParams);
                if (this.a.V != null) {
                    this.a.V.a(this.a.Q);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaijiahaoInfo a;
        public final /* synthetic */ un8 b;

        public f(un8 un8Var, BaijiahaoInfo baijiahaoInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var, baijiahaoInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = un8Var;
            this.a = baijiahaoInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Layout layout;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (layout = this.b.g.getLayout()) != null) {
                int lineCount = layout.getLineCount();
                if (lineCount > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
                    this.b.h.setVisibility(0);
                    return;
                }
                if (!this.b.b) {
                    this.b.g.setEnabled(false);
                } else {
                    BaijiahaoInfo baijiahaoInfo = this.a;
                    if (baijiahaoInfo != null && !dj.isEmpty(baijiahaoInfo.auth_desc)) {
                        this.b.g.setEnabled(false);
                    }
                }
                this.b.h.setVisibility(8);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ un8 a;

        public g(un8 un8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {un8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = un8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.E.playAnimation();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948216874, "Lcom/baidu/tieba/un8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948216874, "Lcom/baidu/tieba/un8;");
                return;
            }
        }
        b0 = ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds648);
    }

    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.M;
        }
        return (View) invokeV.objValue;
    }

    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.J;
        }
        return (View) invokeV.objValue;
    }

    public UserIconBox C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (UserIconBox) invokeV.objValue;
    }

    public TextView D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public View E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AnimatorSet animatorSet = this.F;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            TBLottieAnimationView tBLottieAnimationView = this.E;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            AnimatorSet animatorSet2 = this.R;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            r38 r38Var = this.P;
            if (r38Var != null) {
                r38Var.g();
            }
        }
    }

    public FollowUserSpinnerBtn r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.w;
        }
        return (FollowUserSpinnerBtn) invokeV.objValue;
    }

    public FrameLayout s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.n;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public FrameLayout t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.k;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public FrameLayout u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.q;
        }
        return (FrameLayout) invokeV.objValue;
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.x;
        }
        return (View) invokeV.objValue;
    }

    public HeadPendantView w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.A;
        }
        return (HeadPendantView) invokeV.objValue;
    }

    public ImageView x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.h;
        }
        return (ImageView) invokeV.objValue;
    }

    public TextView y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.g;
        }
        return (TextView) invokeV.objValue;
    }

    public TbImageView z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.y;
        }
        return (TbImageView) invokeV.objValue;
    }

    public un8(TbPageContext tbPageContext, boolean z, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z), onClickListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.Y = new a(this);
        this.Z = new b(this);
        this.a0 = new c(this);
        this.a = tbPageContext;
        this.b = z;
        this.H = onClickListener;
        G();
        F();
    }

    public void K(qm8 qm8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, qm8Var) == null) {
            this.V = qm8Var;
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.i.setVisibility(0);
            } else {
                this.i.setVisibility(8);
            }
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.w.i(z);
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.A.n(str);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.S = ofFloat;
            ofFloat.addUpdateListener(new d(this));
            this.S.setDuration(260L);
            this.S.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.C, Key.ALPHA, 0.0f);
            this.T = ofFloat2;
            ofFloat2.setDuration(240L);
            this.T.setInterpolator(new LinearInterpolator());
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.w.getArrow(), "rotation", 0.0f);
            this.U = ofFloat3;
            ofFloat3.setDuration(100L);
            AnimatorSet animatorSet = new AnimatorSet();
            this.R = animatorSet;
            animatorSet.addListener(new e(this));
            this.R.play(this.S).with(this.T).with(this.U);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0742, (ViewGroup) null);
            this.c = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091a9d);
            this.f = textView;
            textView.setOnClickListener(this.H);
            TextView textView2 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a8b);
            this.g = textView2;
            textView2.setAlpha(0.85f);
            this.g.setOnClickListener(this.H);
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a64);
            this.h = imageView;
            imageView.setOnClickListener(this.H);
            UserIconBox userIconBox = (UserIconBox) this.c.findViewById(R.id.obfuscated_res_0x7f091a65);
            this.j = userIconBox;
            userIconBox.setOnClickListener(this.H);
            this.j.setAutoChangedStyle(false);
            this.l = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a5b);
            FrameLayout frameLayout = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091a5a);
            this.k = frameLayout;
            frameLayout.setOnClickListener(this.H);
            TextView textView3 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a5d);
            this.m = textView3;
            textView3.setAlpha(0.8f);
            this.u = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a59);
            this.i = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a5c);
            this.o = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a53);
            FrameLayout frameLayout2 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091a52);
            this.n = frameLayout2;
            frameLayout2.setOnClickListener(this.H);
            TextView textView4 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a54);
            this.p = textView4;
            textView4.setAlpha(0.8f);
            this.v = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a51);
            this.r = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a60);
            FrameLayout frameLayout3 = (FrameLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091a5f);
            this.q = frameLayout3;
            frameLayout3.setOnClickListener(this.H);
            TextView textView5 = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091a61);
            this.s = textView5;
            textView5.setAlpha(0.8f);
            this.t = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a5e);
            FollowUserSpinnerBtn followUserSpinnerBtn = (FollowUserSpinnerBtn) this.c.findViewById(R.id.obfuscated_res_0x7f0919e5);
            this.w = followUserSpinnerBtn;
            followUserSpinnerBtn.e(this.H);
            this.w.setOpenListener(this.Y);
            TBSpecificationBtn tBSpecificationBtn = (TBSpecificationBtn) this.c.findViewById(R.id.obfuscated_res_0x7f091a4d);
            this.x = tBSpecificationBtn;
            tBSpecificationBtn.setOnClickListener(this.H);
            p45 p45Var = new p45();
            p45Var.q(R.color.CAM_X0101);
            p45Var.g(ej.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds62));
            p45Var.v(R.drawable.ic_icon_pure_personalba_gift24_svg, TBSpecificationButtonConfig.IconType.SVG);
            this.x.setConfig(p45Var);
            TbImageView tbImageView = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a9f);
            this.y = tbImageView;
            tbImageView.setOnClickListener(this.H);
            this.z = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a9e);
            HeadPendantView headPendantView = (HeadPendantView) this.c.findViewById(R.id.obfuscated_res_0x7f091a62);
            this.A = headPendantView;
            headPendantView.setHasPendantStyle();
            this.A.setDefalutResid(R.drawable.pic_mycenter_avatar_def_i);
            this.A.getHeadView().setIsRound(true);
            this.A.getHeadView().setDrawBorder(false);
            this.A.getHeadView().setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.A.setOnClickListener(this.H);
            this.A.setBigVDimenSize(R.dimen.tbds57);
            this.A.setAuthIconType(3);
            this.A.setShowSimpleIcon(false);
            this.A.setBigVIconResId(R.drawable.ic_icon_mask_shen20_n);
            View findViewById = this.c.findViewById(R.id.obfuscated_res_0x7f091a66);
            this.G = findViewById;
            findViewById.setAlpha(0.33f);
            GodRecommendLayout godRecommendLayout = (GodRecommendLayout) this.c.findViewById(R.id.obfuscated_res_0x7f091cbc);
            this.C = godRecommendLayout;
            godRecommendLayout.setPageContext(this.a);
            this.C.setPageUniqueId(this.a.getUniqueId());
            this.C.setRefreshListener(this.a0);
            r38 r38Var = new r38(this.a.getUniqueId());
            this.P = r38Var;
            r38Var.j(this.Z);
            this.I = (ViewGroup) this.c.findViewById(R.id.obfuscated_res_0x7f0919fc);
            this.J = this.c.findViewById(R.id.obfuscated_res_0x7f0919fe);
            this.K = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f09046b);
            this.L = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f09046a);
            this.J.setOnClickListener(this.H);
            this.M = this.c.findViewById(R.id.obfuscated_res_0x7f0919fd);
            this.N = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f090469);
            this.O = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090468);
            this.M.setOnClickListener(this.H);
            this.D = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091a4f);
            this.E = (TBLottieAnimationView) this.c.findViewById(R.id.obfuscated_res_0x7f0914cf);
            this.B = (RelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f092639);
            H(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void H(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.t, R.drawable.ic_icon_pure_gerenba_ba_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.u, R.drawable.ic_icon_pure_gerenba_fans_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.v, R.drawable.ic_icon_pure_gerenba_concern_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.x.k();
            this.w.h(i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.h, R.drawable.ic_icon_pure_common_arrow16_n_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            this.D.setImageDrawable(new SvgMaskType(R.drawable.ic_pic_live_mine).getDrawable());
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.L, R.drawable.ic_icon_pure_personalba_shop_svg, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.O, R.drawable.obfuscated_res_0x7f08062a, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            SkinManager.setViewTextColor(this.f, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.g, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.K, R.color.CAM_X0101, 1, i);
            SkinManager.setViewTextColor(this.N, R.color.CAM_X0101, 1, i);
            SkinManager.setImageResource(this.i, R.drawable.icon_news_down_bar_one);
            SkinManager.setBackgroundResource(this.G, R.drawable.person_header_bg, i);
            this.C.h();
            UserData userData = this.d;
            if (userData != null) {
                if (userData.getSex() == 2) {
                    i2 = R.drawable.icon_mask_girl16_svg;
                } else {
                    i2 = R.drawable.icon_mask_boy16_svg;
                }
                SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, i2, SvgManager.SvgResourceStateType.NORMAL);
            }
            if (i == 4) {
                TBLottieAnimationView tBLottieAnimationView = this.E;
                if (tBLottieAnimationView != null) {
                    tBLottieAnimationView.setAnimation("live/personcenter_live_bg_black.json");
                }
                ImageView imageView = this.D;
                if (imageView != null) {
                    imageView.setImageDrawable(new SvgMaskType(R.drawable.obfuscated_res_0x7f08067c).getDrawable());
                }
            } else if (i == 1) {
                TBLottieAnimationView tBLottieAnimationView2 = this.E;
                if (tBLottieAnimationView2 != null) {
                    tBLottieAnimationView2.setAnimation("live/personcenter_live_bg_night.json");
                }
                ImageView imageView2 = this.D;
                if (imageView2 != null) {
                    imageView2.setImageDrawable(new SvgMaskType(R.drawable.obfuscated_res_0x7f08067b).getDrawable());
                }
            } else {
                TBLottieAnimationView tBLottieAnimationView3 = this.E;
                if (tBLottieAnimationView3 != null) {
                    tBLottieAnimationView3.setAnimation("live/personcenter_live_bg.json");
                }
                ImageView imageView3 = this.D;
                if (imageView3 != null) {
                    imageView3.setImageDrawable(new SvgMaskType(R.drawable.ic_pic_live_mine).getDrawable());
                }
            }
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ObjectAnimator objectAnimator = this.T;
            if (objectAnimator != null) {
                if (this.Q) {
                    objectAnimator.setFloatValues(0.0f, 1.0f);
                } else {
                    objectAnimator.setFloatValues(1.0f, 0.0f);
                }
            }
            ObjectAnimator objectAnimator2 = this.U;
            if (objectAnimator2 != null) {
                if (this.Q) {
                    objectAnimator2.setFloatValues(0.0f, 180.0f);
                } else {
                    objectAnimator2.setFloatValues(180.0f, 360.0f);
                }
            }
        }
    }

    public final void M(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 1.0f, 0.8f);
            long j = 500;
            ofFloat.setDuration(j);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(2);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 1.0f, 0.8f);
            ofFloat2.setDuration(j);
            ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat2.setRepeatCount(-1);
            ofFloat2.setRepeatMode(2);
            AnimatorSet animatorSet = new AnimatorSet();
            this.F = animatorSet;
            animatorSet.play(ofFloat).with(ofFloat2);
            this.F.start();
        }
    }

    public void q(UserData userData, i77 i77Var) {
        String intro;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, userData, i77Var) != null) || userData == null) {
            return;
        }
        this.d = userData;
        this.e = i77Var;
        if (!dj.isEmpty(userData.getName_show())) {
            this.f.setText(this.d.getName_show());
        }
        this.g.setVisibility(0);
        BaijiahaoInfo baijiahaoInfo = this.d.getBaijiahaoInfo();
        if (this.d.isNewGod() && !dj.isEmpty(this.d.getNewGodData().getFieldName())) {
            Resources resources = this.a.getResources();
            intro = resources.getString(R.string.obfuscated_res_0x7f0f0ee4, this.d.getNewGodData().getFieldName() + xp5.c(this.d.getNewGodData().isVideoGod()));
        } else if (this.d.showBazhuGrade()) {
            intro = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ee4, StringHelper.cutChineseAndEnglishWithSuffix(this.d.getBazhuGradeData().getDesc(), 32, StringHelper.STRING_MORE));
        } else {
            intro = this.d.getIntro();
            if (!dj.isEmpty(intro)) {
                intro = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f35, intro);
            } else if (this.b) {
                intro = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f0a, "o(〃'▽'〃)o");
            }
        }
        if (!dj.isEmpty(intro)) {
            this.g.setVisibility(0);
            this.g.setText(intro);
            this.g.setEnabled(true);
            gh.a().post(new f(this, baijiahaoInfo));
        } else {
            this.g.setVisibility(8);
        }
        this.j.h(this.d.getIconInfo(), 9, this.a.getResources().getDimensionPixelSize(R.dimen.tbds42), this.a.getResources().getDimensionPixelSize(R.dimen.tbds42), this.a.getResources().getDimensionPixelSize(R.dimen.tbds10), true);
        this.l.setText(StringHelper.numFormatOverWanNa(this.d.getFansNum()));
        this.r.setText(StringHelper.numFormatOverWanNa(this.d.getLike_bars()));
        this.o.setText(StringHelper.numFormatOverWanNa(this.d.getConcernNum()));
        if (this.b) {
            this.w.setVisibility(8);
            this.x.setVisibility(8);
        } else {
            this.x.setVisibility(0);
            this.w.setVisibility(0);
            this.w.setShowPullBtn(userData.isNewGod());
            this.w.setFirstUpdate(true);
            if (this.d.getHave_attention() == 1) {
                z = true;
            } else {
                z = false;
            }
            N(z);
        }
        UserVipInfoData userVipInfo = this.d.getUserVipInfo();
        if (this.d.getIsMem() > 0 && userVipInfo != null && !TextUtils.isEmpty(userVipInfo.getVipIconUrl())) {
            this.y.K(userVipInfo.getVipIconUrl(), 10, false);
            this.y.setVisibility(0);
        } else if (this.b) {
            this.y.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_crown_super_non));
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
        UserData userData2 = this.d;
        int i = R.drawable.icon_mask_boy16_svg;
        if (userData2 != null && userData2.getSex() == 2) {
            i = R.drawable.icon_mask_girl16_svg;
        }
        SvgManager.getInstance().setMaskDrawableWithDayNightModeAutoChange(this.z, i, SvgManager.SvgResourceStateType.NORMAL);
        if (this.d.getSex() == 0) {
            this.z.setVisibility(8);
        } else {
            this.z.setVisibility(0);
        }
        AlaUserInfoData alaUserData = this.d.getAlaUserData();
        if (alaUserData != null && alaUserData.live_status == 1) {
            this.E.setVisibility(0);
            this.E.loop(true);
            this.E.post(new g(this));
            this.G.setVisibility(8);
            M(this.B);
            this.D.setVisibility(0);
            this.A.setIsclearmode(true);
            this.A.m(this.d.getAvater());
        } else {
            this.A.o(this.d);
            this.D.setVisibility(8);
            this.A.setIsclearmode(false);
            this.G.setVisibility(0);
        }
        i77 i77Var2 = this.e;
        if (i77Var2 != null && i77Var2.a() && !TextUtils.isEmpty(this.e.b)) {
            this.J.setVisibility(0);
            if (this.b) {
                TiebaStatic.log(new StatisticItem("c13612").param("obj_param1", "0"));
            } else {
                TiebaStatic.log(new StatisticItem("c13612").param("obj_param1", "1"));
            }
        } else {
            this.J.setVisibility(8);
        }
        UserData userData3 = this.d;
        if (userData3 != null && userData3.getLiveRoomInfo() != null && this.d.getLiveRoomInfo().own_room_count.intValue() > 0 && !TextUtils.isEmpty(this.d.getLiveRoomInfo().jump_url) && !TextUtils.isEmpty(this.d.getLiveRoomInfo().btn_title)) {
            this.N.setText(this.d.getLiveRoomInfo().btn_title);
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
        if (this.J.getVisibility() != 0 && this.M.getVisibility() != 0) {
            this.I.setVisibility(8);
        } else {
            this.I.setVisibility(0);
        }
    }
}
