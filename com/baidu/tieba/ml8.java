package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.ViewModelProviders;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pb.pb.main.AbsPbActivity;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbViewModel;
import com.baidu.tieba.pb.videopb.videoView.PbNextVideoLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoFullscreenAttentionLayout;
import com.baidu.tieba.pb.videopb.videoView.PbVideoMediaController;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ml8 extends jt8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout P0;
    public PbNextVideoLayout Q0;
    public ImageView R0;
    public ImageView S0;
    public int T0;
    public int U0;
    public boolean V0;
    public ObjectAnimator W0;
    public VideoPbViewModel X0;
    public int Y0;
    public String Z0;
    public String a1;
    public BaijiahaoData b1;
    public AbsVideoPbFragment c1;
    public View d1;
    public View e1;
    public boolean f1;
    public boolean g1;
    public ObjectAnimator h1;
    public ObjectAnimator i1;
    public Runnable j1;
    public Runnable k1;
    public Runnable l1;
    public Runnable m1;

    @Override // com.baidu.tieba.jt8
    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? R.layout.obfuscated_res_0x7f0d0725 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.jt8
    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml8 a;

        /* loaded from: classes5.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.T0();
                    gh.a().postDelayed(this.a.a.l1, 5000L);
                }
            }
        }

        public b(ml8 ml8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.P0.b()) {
                Context context = this.a.O;
                if (this.a.T) {
                    i = R.dimen.tbds210;
                } else {
                    i = R.dimen.tbds244;
                }
                this.a.V0 = true;
                this.a.W0.setFloatValues(-ej.g(context, i));
                this.a.W0.removeAllListeners();
                this.a.W0.addListener(new a(this));
                this.a.W0.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml8 a;

        /* loaded from: classes5.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.P0.setVisibility(8);
                }
            }
        }

        public c(ml8 ml8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context context = this.a.O;
                if (this.a.T) {
                    i = R.dimen.tbds210;
                } else {
                    i = R.dimen.tbds244;
                }
                this.a.W0.setFloatValues(ej.g(context, i));
                this.a.W0.removeAllListeners();
                this.a.W0.addListener(new a(this));
                this.a.W0.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml8 a;

        public a(ml8 ml8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.K.setVisibility(8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ml8 a;

        public d(ml8 ml8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ml8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ml8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.g1 && (this.a.O instanceof Activity)) {
                this.a.O0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ml8(Context context, View view2) {
        super(context, view2);
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (View) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.T0 = -1;
        this.Y0 = 0;
        this.j1 = new a(this);
        this.k1 = new b(this);
        this.l1 = new c(this);
        this.m1 = new d(this);
        Q();
        if (context instanceof AbsPbActivity) {
            this.X0 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            if (!TbSingleton.getInstance().isNotchScreen(activity) && !TbSingleton.getInstance().isCutoutScreen(activity)) {
                z = false;
            } else {
                z = true;
            }
            this.f1 = z;
        }
        Y(true);
        Z(true);
        this.c0 = false;
    }

    public void U0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.Q0.setIsCountDownValid(z);
        }
    }

    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.g1 = z;
        }
    }

    @Override // com.baidu.tieba.jt8
    public void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            Context context = this.O;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.Y);
            }
            super.W(z);
            T0();
            if (this.Y) {
                M0();
            } else {
                this.P0.setVisibility(8);
            }
        }
    }

    public void Y0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            this.d1 = view2;
        }
    }

    public void Z0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            this.e1 = view2;
        }
    }

    public void a1(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, absVideoPbFragment) == null) {
            this.c1 = absVideoPbFragment;
        }
    }

    @Override // com.baidu.tieba.jt8
    public boolean g0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            if (!this.Y && motionEvent.getX() <= this.U0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.jt8, com.baidu.tieba.gt8
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.P0.setUniqueId(bdUniqueId);
        }
    }

    public final void M0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.V0 && !this.P0.b()) {
            this.P0.setTranslationX(0.0f);
            this.P0.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P0.getLayoutParams();
            Context context = this.O;
            if (this.T) {
                i = R.dimen.tbds248;
            } else {
                i = R.dimen.tbds428;
            }
            layoutParams.bottomMargin = ej.g(context, i);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.P0, Key.TRANSLATION_X, 0.0f);
            this.W0 = ofFloat;
            ofFloat.setDuration(500);
            T0();
            gh.a().postDelayed(this.k1, 5000L);
        }
    }

    @Override // com.baidu.tieba.jt8
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int i = this.b & (-33);
            this.b = i;
            int i2 = this.o & (-33);
            this.o = i2;
            int i3 = this.d & (-33);
            this.d = i3;
            int i4 = this.e & (-33);
            this.e = i4;
            int i5 = this.n & (-33);
            this.n = i5;
            int i6 = this.f & (-33);
            this.f = i6;
            int i7 = this.g & (-33);
            this.g = i7;
            int i8 = this.h & (-33);
            this.h = i8;
            int i9 = this.i & (-33);
            this.i = i9;
            int i10 = this.j & (-33);
            this.j = i10;
            int i11 = this.k & (-33);
            this.k = i11;
            this.b = i | 1024;
            this.o = i2 | 1024;
            int i12 = i3 | 1024;
            this.d = i12;
            this.e = i4 & (-1025);
            this.n = i5 & (-1025);
            this.f = i6 | 1024;
            this.g = i7 | 1024;
            int i13 = i8 | 1024;
            this.h = i13;
            int i14 = i9 | 1024;
            this.i = i14;
            this.j = i10 | 1024;
            this.k = i11 & (-1025);
            this.d = i12 | 16384;
            this.h = i13 | 16384;
            this.i = i14 & (-2);
        }
    }

    @Override // com.baidu.tieba.jt8
    public void R() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).q(this.T, this.Y);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i3 = 0;
            if (this.Y && this.T) {
                i = ej.g(this.O, R.dimen.tbds42);
            } else {
                i = 0;
            }
            if (this.Y && !this.T) {
                i3 = ej.g(this.O, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = i;
            layoutParams.rightMargin = i3;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.R0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.S0.getLayoutParams();
            Context context = this.O;
            if (this.Y && !this.T) {
                i2 = R.dimen.tbds208;
            } else {
                i2 = R.dimen.tbds104;
            }
            int g = ej.g(context, i2);
            layoutParams3.leftMargin = g;
            layoutParams2.rightMargin = g;
            this.Q0.b(this.T, this.Y);
        }
    }

    @Override // com.baidu.tieba.jt8
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.e0();
            this.P0 = (PbVideoFullscreenAttentionLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f0926da);
            this.Q0 = (PbNextVideoLayout) this.Q.findViewById(R.id.obfuscated_res_0x7f0926fe);
            this.R0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092715);
            this.S0 = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f0926fd);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.R0, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.S0, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, null);
            this.u.s();
            this.u.setDrawCorner(false);
            this.P0.setOnClickEvent(this);
            this.R0.setOnClickListener(this);
            this.S0.setOnClickListener(this);
            this.Q0.setOnClickListener(this);
            this.U0 = ej.l(this.O) / 10;
            this.H.setShareFrom(18);
        }
    }

    public final StatisticItem N0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.V).param("fid", this.W).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.b1;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.b1.oriUgcVid);
                int i = this.b1.oriUgcType;
                if (i == 4) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (i == 2) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
            Context context = this.O;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).H1() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.O).H1().x1()).param("obj_id", ((AbsPbActivity) this.O).H1().y1()).param("obj_source", ((AbsPbActivity) this.O).H1().z1());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            b1();
            UtilHelper.hideStatusBar((Activity) this.O, this.d1);
            this.g1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.c1;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.t5(false);
            }
        }
    }

    @Override // com.baidu.tieba.jt8
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.P();
            if (this.Y) {
                M0();
            }
        }
    }

    public boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g1;
        }
        return invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.T;
        }
        return invokeV.booleanValue;
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T0();
            Y(false);
            Z(false);
            MessageManager.getInstance().unRegisterListener(this.I0);
            MessageManager.getInstance().unRegisterListener(this.O0);
        }
    }

    public final void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            gh.a().removeCallbacks(this.k1);
            gh.a().removeCallbacks(this.l1);
        }
    }

    @Override // com.baidu.tieba.jt8
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.baidu.tieba.jt8
    public void w0() {
        bt8 bt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (bt8Var = this.Z) != null) {
            bt8 b2 = bt8Var.b();
            b2.a = "pb";
            qs8.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
        }
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, false, 10);
            gh.a().removeCallbacks(this.j1);
            gh.a().postDelayed(this.j1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.i1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e1, Key.ALPHA, 1.0f, 0.0f);
                this.i1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.i1.start();
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.h1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e1, Key.ALPHA, 0.0f, 1.0f);
                this.h1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.h1.start();
        }
    }

    @Override // com.baidu.tieba.jt8, com.baidu.tieba.gt8
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.O, true, 10);
            gh.a().removeCallbacks(this.j1);
            gh.a().postDelayed(this.j1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void W0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !dj.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 32768;
                    this.p = i2;
                    q0(i2);
                }
                int i3 = this.p;
                if (i3 == this.i) {
                    int i4 = i3 | 131072;
                    this.p = i4;
                    q0(i4);
                }
                this.f |= 32768;
                this.g |= 32768;
                this.i |= 131072;
                this.Q0.setDate(threadData);
                return;
            }
            int i5 = this.p;
            if (i5 == this.f || i5 == this.g || i5 == this.i) {
                int i6 = this.p & (-32769);
                this.p = i6;
                int i7 = i6 & (-131073);
                this.p = i7;
                q0(i7);
            }
            this.f &= -32769;
            this.g &= -32769;
            this.i &= -131073;
        }
    }

    @Override // com.baidu.tieba.jt8, com.baidu.tieba.gt8
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            T0();
            this.P0.setVisibility(8);
            if (!this.f1) {
                O0();
            }
            if (z) {
                int i = this.p;
                this.T0 = i;
                if (i == this.g || ((i == this.h && !this.t.getControl().isPlaying()) || this.p == this.i)) {
                    this.T0 |= 1;
                }
                stopPlay();
            } else {
                int i2 = this.T0;
                if (i2 == -1) {
                    startPlay();
                } else if (i2 != this.d && i2 != this.f && i2 != this.e && i2 != this.n) {
                    this.F.setCurrentDuration(at8.d().c(this.U), false);
                    q0(this.T0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.jt8, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        boolean z = true;
        if (id == R.id.obfuscated_res_0x7f091b43) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view2);
        if (id == R.id.obfuscated_res_0x7f090746) {
            T0();
            gh.a().post(this.l1);
        } else if (id != R.id.obfuscated_res_0x7f0926fd && id != R.id.obfuscated_res_0x7f0926fe) {
            if (id == R.id.obfuscated_res_0x7f092715) {
                VideoPbViewModel videoPbViewModel = this.X0;
                if (videoPbViewModel != null) {
                    videoPbViewModel.q();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == R.id.obfuscated_res_0x7f0919ae) {
                this.i &= -131073;
                this.p &= -131073;
                this.Q0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.X0;
            if (videoPbViewModel2 != null) {
                if (id != R.id.obfuscated_res_0x7f0926fe) {
                    z = false;
                }
                videoPbViewModel2.p(z);
            }
            if (id == R.id.obfuscated_res_0x7f0926fd) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // com.baidu.tieba.jt8
    public void v0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            if (i == R.id.video_full_screen) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i == R.id.video_replay) {
                TiebaStatic.log(N0("c13602"));
            } else if (i == R.id.video_play) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i == R.id.video_pause) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i == R.id.obfuscated_res_0x7f0926fe) {
                StatisticItem N0 = N0("c13601");
                if (this.Q0.h) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                TiebaStatic.log(N0.param("obj_type", i2));
            }
        }
    }

    public void X0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !dj.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 65536;
                    this.p = i2;
                    q0(i2);
                }
                this.f |= 65536;
                this.g |= 65536;
                return;
            }
            int i3 = this.p;
            if (i3 == this.f || i3 == this.g) {
                int i4 = this.p & (-65537);
                this.p = i4;
                q0(i4);
            }
            this.f &= -65537;
            this.g &= -65537;
        }
    }

    @Override // com.baidu.tieba.jt8
    public void q0(int i) {
        AbsVideoPbFragment absVideoPbFragment;
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            int i5 = 8;
            if (i != this.g && i != this.h && i != this.f && i != this.d) {
                T0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.P0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i6 = this.p;
            int i7 = this.k;
            if (i6 != i7 && i == i7) {
                gh.a().removeCallbacks(this.j1);
                int i8 = this.p;
                if ((i8 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i8 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.q0(i);
            if (!this.Y) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.X0;
                if (videoPbViewModel != null) {
                    if ((i & 1024) > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    videoPbViewModel.w(z4);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.X0;
            if (videoPbViewModel2 != null) {
                if ((i & 128) > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                videoPbViewModel2.w(z3);
            }
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                int i9 = i & 16384;
                if (i9 <= 0 && (i & 128) <= 0) {
                    i4 = 8;
                } else {
                    i4 = 0;
                }
                operableVideoMediaControllerView.setVisibility(i4);
                PbVideoMediaController pbVideoMediaController = (PbVideoMediaController) this.F;
                if (i9 > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pbVideoMediaController.setBottomBarShow(z2);
            }
            ImageView imageView = this.R0;
            if (imageView != null) {
                if ((65536 & i) > 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
            ImageView imageView2 = this.S0;
            if (imageView2 != null) {
                if ((32768 & i) > 0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView2.setVisibility(i2);
            }
            if (this.Q0 != null) {
                if ((131072 & i) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                PbNextVideoLayout pbNextVideoLayout = this.Q0;
                if (z) {
                    i5 = 0;
                }
                pbNextVideoLayout.setVisibility(i5);
                if (z) {
                    TiebaStatic.log(N0("c13600"));
                }
            }
            if (!this.Y && !this.f1 && (this.O instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.g1) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.c1;
                        if (absVideoPbFragment2 == null || !absVideoPbFragment2.L4()) {
                            c1();
                            UtilHelper.showStatusBar((Activity) this.O, this.d1);
                        }
                        this.g1 = true;
                        gh.a().removeCallbacks(this.m1);
                        gh.a().postDelayed(this.m1, 3000L);
                    }
                } else if (this.g1 || ((absVideoPbFragment = this.c1) != null && absVideoPbFragment.L4())) {
                    O0();
                }
            }
        }
    }

    @Override // com.baidu.tieba.jt8, com.baidu.tieba.gt8
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, threadData) != null) || threadData == null) {
            return;
        }
        this.b1 = threadData.getBaijiahaoData();
        bt8 bt8Var = new bt8();
        bt8Var.a = "6";
        bt8Var.c = threadData.getTid();
        bt8Var.d = Long.toString(threadData.getFid());
        bt8Var.e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.O;
        boolean z = false;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.Y0 = intExtra;
                if (intExtra == 0) {
                    this.Y0 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.Z0 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    bt8Var.k = this.Z0;
                }
                bt8Var.i = Integer.toString(this.Y0);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.a1 = stringExtra2;
                bt8Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            bt8Var.m = threadData.getThreadVideoInfo().video_md5;
            bt8Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(bt8Var);
        this.V0 = false;
        if (this.X0.c().z0()) {
            this.Q0.setIsCountDownValid(true);
        } else {
            this.Q0.setIsCountDownValid(false);
        }
        if (this.Y && threadData.getThreadVideoInfo() != null) {
            boolean z2 = this.T;
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            }
            if (z2 != z) {
                V();
            }
        }
        super.setData(threadData);
        Y(!this.T);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        this.P0.setData(threadData);
    }
}
