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
public class pq8 extends my8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbVideoFullscreenAttentionLayout S0;
    public PbNextVideoLayout T0;
    public ImageView U0;
    public ImageView V0;
    public int W0;
    public int X0;
    public boolean Y0;
    public ObjectAnimator Z0;
    public VideoPbViewModel a1;
    public int b1;
    public String c1;
    public String d1;
    public BaijiahaoData e1;
    public AbsVideoPbFragment f1;
    public View g1;
    public View h1;
    public boolean i1;
    public boolean j1;
    public ObjectAnimator k1;
    public ObjectAnimator l1;
    public Runnable m1;
    public Runnable n1;
    public Runnable o1;
    public Runnable p1;

    @Override // com.baidu.tieba.my8
    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? R.layout.obfuscated_res_0x7f0d0736 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.my8
    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq8 a;

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
                    this.a.a.X0();
                    jg.a().postDelayed(this.a.a.o1, 5000L);
                }
            }
        }

        public b(pq8 pq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.S0.b()) {
                Context context = this.a.R;
                if (this.a.W) {
                    i = R.dimen.tbds210;
                } else {
                    i = R.dimen.tbds244;
                }
                this.a.Y0 = true;
                this.a.Z0.setFloatValues(-hi.g(context, i));
                this.a.Z0.removeAllListeners();
                this.a.Z0.addListener(new a(this));
                this.a.Z0.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq8 a;

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
                    this.a.a.S0.setVisibility(8);
                }
            }
        }

        public c(pq8 pq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context context = this.a.R;
                if (this.a.W) {
                    i = R.dimen.tbds210;
                } else {
                    i = R.dimen.tbds244;
                }
                this.a.Z0.setFloatValues(hi.g(context, i));
                this.a.Z0.removeAllListeners();
                this.a.Z0.addListener(new a(this));
                this.a.Z0.start();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pq8 a;

        public a(pq8 pq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq8Var;
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
        public final /* synthetic */ pq8 a;

        public d(pq8 pq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pq8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.j1 && (this.a.R instanceof Activity)) {
                this.a.S0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pq8(Context context, View view2) {
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
        this.W0 = -1;
        this.b1 = 0;
        this.m1 = new a(this);
        this.n1 = new b(this);
        this.o1 = new c(this);
        this.p1 = new d(this);
        S();
        if (context instanceof AbsPbActivity) {
            this.a1 = (VideoPbViewModel) ViewModelProviders.of((AbsPbActivity) context).get(VideoPbViewModel.class);
            Activity activity = (Activity) context;
            if (!TbSingleton.getInstance().isNotchScreen(activity) && !TbSingleton.getInstance().isCutoutScreen(activity)) {
                z = false;
            } else {
                z = true;
            }
            this.i1 = z;
        }
        a0(true);
        b0(true);
        this.f0 = false;
    }

    @Override // com.baidu.tieba.my8
    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            Context context = this.R;
            if (context instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context).setSwipeBackEnabled(this.b0);
            }
            super.Y(z);
            X0();
            if (this.b0) {
                Q0();
            } else {
                this.S0.setVisibility(8);
            }
        }
    }

    public void Y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.T0.setIsCountDownValid(z);
        }
    }

    public void Z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.j1 = z;
        }
    }

    public void c1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            this.g1 = view2;
        }
    }

    public void d1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view2) == null) {
            this.h1 = view2;
        }
    }

    public void e1(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, absVideoPbFragment) == null) {
            this.f1 = absVideoPbFragment;
        }
    }

    @Override // com.baidu.tieba.my8
    public boolean i0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, motionEvent)) == null) {
            if (!this.b0 && motionEvent.getX() <= this.X0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.my8, com.baidu.tieba.jy8
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bdUniqueId) == null) {
            super.setUniqueId(bdUniqueId);
            this.S0.setUniqueId(bdUniqueId);
        }
    }

    @Override // com.baidu.tieba.my8
    public void A0() {
        ey8 ey8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (ey8Var = this.c0) != null) {
            ey8 b2 = ey8Var.b();
            b2.a = "pb";
            tx8.e(b2.m, "", "2", b2, this.t.getControl().getPcdnState());
        }
    }

    @Override // com.baidu.tieba.my8
    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.R();
            if (this.b0) {
                Q0();
            }
        }
    }

    public final void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            f1();
            UtilHelper.hideStatusBar((Activity) this.R, this.g1);
            this.j1 = false;
            AbsVideoPbFragment absVideoPbFragment = this.f1;
            if (absVideoPbFragment != null) {
                absVideoPbFragment.u5(false);
            }
        }
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.j1;
        }
        return invokeV.booleanValue;
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.W;
        }
        return invokeV.booleanValue;
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            X0();
            a0(false);
            b0(false);
            MessageManager.getInstance().unRegisterListener(this.L0);
            MessageManager.getInstance().unRegisterListener(this.R0);
        }
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            jg.a().removeCallbacks(this.n1);
            jg.a().removeCallbacks(this.o1);
        }
    }

    @Override // com.baidu.tieba.my8
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.t.getControl().setVolume(1.0f, 1.0f);
        }
    }

    public final void Q0() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.Y0 && !this.S0.b()) {
            this.S0.setTranslationX(0.0f);
            this.S0.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S0.getLayoutParams();
            Context context = this.R;
            if (this.W) {
                i = R.dimen.tbds248;
            } else {
                i = R.dimen.tbds428;
            }
            layoutParams.bottomMargin = hi.g(context, i);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.S0, Key.TRANSLATION_X, 0.0f);
            this.Z0 = ofFloat;
            ofFloat.setDuration(500);
            X0();
            jg.a().postDelayed(this.n1, 5000L);
        }
    }

    @Override // com.baidu.tieba.my8
    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
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

    @Override // com.baidu.tieba.my8
    public void T() {
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.G.a(this.W, this.b0);
            this.H.e(this.W, this.b0);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            if (operableVideoMediaControllerView instanceof PbVideoMediaController) {
                ((PbVideoMediaController) operableVideoMediaControllerView).q(this.W, this.b0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
            int i3 = 0;
            if (this.b0 && this.W) {
                i = hi.g(this.R, R.dimen.tbds42);
            } else {
                i = 0;
            }
            if (this.b0 && !this.W) {
                i3 = hi.g(this.R, R.dimen.tbds34);
            }
            layoutParams.bottomMargin = i;
            layoutParams.rightMargin = i3;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.U0.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.V0.getLayoutParams();
            Context context = this.R;
            if (this.b0 && !this.W) {
                i2 = R.dimen.tbds208;
            } else {
                i2 = R.dimen.tbds104;
            }
            int g = hi.g(context, i2);
            layoutParams3.leftMargin = g;
            layoutParams2.rightMargin = g;
            this.T0.b(this.W, this.b0);
        }
    }

    @Override // com.baidu.tieba.my8
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.g0();
            this.S0 = (PbVideoFullscreenAttentionLayout) this.T.findViewById(R.id.obfuscated_res_0x7f092738);
            this.T0 = (PbNextVideoLayout) this.T.findViewById(R.id.obfuscated_res_0x7f09275c);
            this.U0 = (ImageView) this.T.findViewById(R.id.obfuscated_res_0x7f092773);
            this.V0 = (ImageView) this.T.findViewById(R.id.obfuscated_res_0x7f09275b);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.U0, R.drawable.ic_icon_pure_video_up44_svg, R.color.CAM_X0101, null);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.V0, R.drawable.ic_icon_pure_video_down44_svg, R.color.CAM_X0101, null);
            this.u.s();
            this.u.setDrawCorner(false);
            this.S0.setOnClickEvent(this);
            this.U0.setOnClickListener(this);
            this.V0.setOnClickListener(this);
            this.T0.setOnClickListener(this);
            this.X0 = hi.l(this.R) / 10;
            this.H.setShareFrom(18);
        }
    }

    public final StatisticItem R0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            StatisticItem param = new StatisticItem(str).param("tid", this.Y).param("fid", this.Z).param("uid", TbadkCoreApplication.getCurrentAccount());
            BaijiahaoData baijiahaoData = this.e1;
            if (baijiahaoData != null) {
                param.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                param.param(TiebaStatic.Params.OBJ_PARAM6, this.e1.oriUgcVid);
                int i = this.e1.oriUgcType;
                if (i == 4) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 2);
                } else if (i == 2) {
                    param.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                }
            } else {
                param.param(TiebaStatic.Params.OBJ_PARAM5, 1);
            }
            Context context = this.R;
            if ((context instanceof AbsPbActivity) && ((AbsPbActivity) context).K1() != null) {
                param.param("ab_tag", ((AbsPbActivity) this.R).K1().B1()).param("obj_id", ((AbsPbActivity) this.R).K1().C1()).param("obj_source", ((AbsPbActivity) this.R).K1().D1());
            }
            return param;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.R, false, 10);
            jg.a().removeCallbacks(this.m1);
            jg.a().postDelayed(this.m1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (this.l1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h1, Key.ALPHA, 1.0f, 0.0f);
                this.l1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.l1.start();
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (this.k1 == null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.h1, Key.ALPHA, 0.0f, 1.0f);
                this.k1 = ofFloat;
                ofFloat.setDuration(200L);
            }
            this.k1.start();
        }
    }

    @Override // com.baidu.tieba.my8, com.baidu.tieba.jy8
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.p == this.k) {
                return false;
            }
            this.K.setVisibility(0);
            this.K.d(this.R, true, 10);
            jg.a().removeCallbacks(this.m1);
            jg.a().postDelayed(this.m1, 1500L);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void a1(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !gi.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 32768;
                    this.p = i2;
                    u0(i2);
                }
                int i3 = this.p;
                if (i3 == this.i) {
                    int i4 = i3 | 131072;
                    this.p = i4;
                    u0(i4);
                }
                this.f |= 32768;
                this.g |= 32768;
                this.i |= 131072;
                this.T0.setDate(threadData);
                return;
            }
            int i5 = this.p;
            if (i5 == this.f || i5 == this.g || i5 == this.i) {
                int i6 = this.p & (-32769);
                this.p = i6;
                int i7 = i6 & (-131073);
                this.p = i7;
                u0(i7);
            }
            this.f &= -32769;
            this.g &= -32769;
            this.i &= -131073;
        }
    }

    @Override // com.baidu.tieba.my8, com.baidu.tieba.jy8
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048603, this, z)) == null) {
            X0();
            this.S0.setVisibility(8);
            if (!this.i1) {
                S0();
            }
            if (z) {
                int i = this.p;
                this.W0 = i;
                if (i == this.g || ((i == this.h && !this.t.getControl().isPlaying()) || this.p == this.i)) {
                    this.W0 |= 1;
                }
                stopPlay();
            } else {
                int i2 = this.W0;
                if (i2 == -1) {
                    startPlay();
                } else if (i2 != this.d && i2 != this.f && i2 != this.e && i2 != this.n) {
                    this.F.setCurrentDuration(dy8.d().c(this.X), false);
                    u0(this.W0);
                } else {
                    startPlay();
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.my8, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        boolean z = true;
        if (id == R.id.obfuscated_res_0x7f091b84) {
            TbSingleton.getInstance().setHasAgreeToPlay(true);
        }
        super.onClick(view2);
        if (id == R.id.obfuscated_res_0x7f09075f) {
            X0();
            jg.a().post(this.o1);
        } else if (id != R.id.obfuscated_res_0x7f09275b && id != R.id.obfuscated_res_0x7f09275c) {
            if (id == R.id.obfuscated_res_0x7f092773) {
                VideoPbViewModel videoPbViewModel = this.a1;
                if (videoPbViewModel != null) {
                    videoPbViewModel.q();
                }
                TiebaStatic.log(new StatisticItem("c13594"));
            } else if (id == R.id.obfuscated_res_0x7f0919ef) {
                this.i &= -131073;
                this.p &= -131073;
                this.T0.setVisibility(8);
            }
        } else {
            VideoPbViewModel videoPbViewModel2 = this.a1;
            if (videoPbViewModel2 != null) {
                if (id != R.id.obfuscated_res_0x7f09275c) {
                    z = false;
                }
                videoPbViewModel2.p(z);
            }
            if (id == R.id.obfuscated_res_0x7f09275b) {
                TiebaStatic.log(new StatisticItem("c13595"));
            }
        }
    }

    @Override // com.baidu.tieba.my8
    public void z0(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            if (i == R.id.video_full_screen) {
                if (!isFullScreen()) {
                    TiebaStatic.log(new StatisticItem("c13598"));
                } else {
                    TiebaStatic.log(new StatisticItem("c13599"));
                }
            } else if (i == R.id.video_replay) {
                TiebaStatic.log(R0("c13602"));
            } else if (i == R.id.video_play) {
                TiebaStatic.log(new StatisticItem("c13597"));
            } else if (i == R.id.video_pause) {
                TiebaStatic.log(new StatisticItem("c13596"));
            } else if (i == R.id.obfuscated_res_0x7f09275c) {
                StatisticItem R0 = R0("c13601");
                if (this.T0.h) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                TiebaStatic.log(R0.param("obj_type", i2));
            }
        }
    }

    public void b1(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) {
            if (threadData != null && threadData.getThreadVideoInfo() != null && !gi.isEmpty(threadData.getThreadVideoInfo().video_url)) {
                int i = this.p;
                if (i == this.f || i == this.g) {
                    int i2 = this.p | 65536;
                    this.p = i2;
                    u0(i2);
                }
                this.f |= 65536;
                this.g |= 65536;
                return;
            }
            int i3 = this.p;
            if (i3 == this.f || i3 == this.g) {
                int i4 = this.p & (-65537);
                this.p = i4;
                u0(i4);
            }
            this.f &= -65537;
            this.g &= -65537;
        }
    }

    @Override // com.baidu.tieba.my8, com.baidu.tieba.jy8
    public void setData(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048606, this, threadData) != null) || threadData == null) {
            return;
        }
        this.e1 = threadData.getBaijiahaoData();
        ey8 ey8Var = new ey8();
        ey8Var.a = "6";
        ey8Var.c = threadData.getTid();
        ey8Var.d = Long.toString(threadData.getFid());
        ey8Var.e = TbadkCoreApplication.getCurrentAccount();
        Context context = this.R;
        boolean z = false;
        if (context instanceof BaseFragmentActivity) {
            Intent intent = ((BaseFragmentActivity) context).getIntent();
            if (threadData.isBjh()) {
                int intExtra = intent.getIntExtra("bjh_from", 0);
                this.b1 = intExtra;
                if (intExtra == 0) {
                    this.b1 = intent.getIntExtra("key_start_from", 0);
                }
                String stringExtra = intent.getStringExtra("last_tid");
                this.c1 = stringExtra;
                if (!StringUtils.isNull(stringExtra)) {
                    ey8Var.k = this.c1;
                }
                ey8Var.i = Integer.toString(this.b1);
            } else {
                String stringExtra2 = intent.getStringExtra(PbActivityConfig.KEY_VIDEO_SOURCE);
                this.d1 = stringExtra2;
                ey8Var.i = stringExtra2;
            }
        }
        if (threadData.getThreadVideoInfo() != null) {
            ey8Var.m = threadData.getThreadVideoInfo().video_md5;
            ey8Var.p = String.valueOf(threadData.getThreadVideoInfo().is_vertical);
        }
        setStatistic(ey8Var);
        this.Y0 = false;
        if (this.a1.c().z0()) {
            this.T0.setIsCountDownValid(true);
        } else {
            this.T0.setIsCountDownValid(false);
        }
        if (this.b0 && threadData.getThreadVideoInfo() != null) {
            boolean z2 = this.W;
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            }
            if (z2 != z) {
                X();
            }
        }
        super.setData(threadData);
        a0(!this.W);
        if (threadData.getAuthor() != null) {
            threadData.getAuthor().setIsLike(threadData.getAuthor().hadConcerned());
        }
        this.S0.setData(threadData);
    }

    @Override // com.baidu.tieba.my8
    public void u0(int i) {
        AbsVideoPbFragment absVideoPbFragment;
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            int i5 = 8;
            if (i != this.g && i != this.h && i != this.f && i != this.d) {
                X0();
                PbVideoFullscreenAttentionLayout pbVideoFullscreenAttentionLayout = this.S0;
                if (pbVideoFullscreenAttentionLayout != null) {
                    pbVideoFullscreenAttentionLayout.setVisibility(8);
                }
            }
            int i6 = this.p;
            int i7 = this.k;
            if (i6 != i7 && i == i7) {
                jg.a().removeCallbacks(this.m1);
                int i8 = this.p;
                if ((i8 & 16384) > 0) {
                    i = (i | 16384) & (-129) & (-65);
                } else if ((i8 & 128) > 0) {
                    i = (i & (-16385)) | 128 | 64;
                }
                this.k = i;
            }
            super.u0(i);
            if (!this.b0) {
                this.I.setVisibility(8);
                this.J.setVisibility(8);
                VideoPbViewModel videoPbViewModel = this.a1;
                if (videoPbViewModel != null) {
                    if ((i & 1024) > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    videoPbViewModel.w(z4);
                }
            }
            VideoPbViewModel videoPbViewModel2 = this.a1;
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
            ImageView imageView = this.U0;
            if (imageView != null) {
                if ((65536 & i) > 0) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
            ImageView imageView2 = this.V0;
            if (imageView2 != null) {
                if ((32768 & i) > 0) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView2.setVisibility(i2);
            }
            if (this.T0 != null) {
                if ((131072 & i) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                PbNextVideoLayout pbNextVideoLayout = this.T0;
                if (z) {
                    i5 = 0;
                }
                pbNextVideoLayout.setVisibility(i5);
                if (z) {
                    TiebaStatic.log(R0("c13600"));
                }
            }
            if (!this.b0 && !this.i1 && (this.R instanceof Activity)) {
                if ((i & 128) > 0) {
                    if (!this.j1) {
                        AbsVideoPbFragment absVideoPbFragment2 = this.f1;
                        if (absVideoPbFragment2 == null || !absVideoPbFragment2.N4()) {
                            g1();
                            UtilHelper.showStatusBar((Activity) this.R, this.g1);
                        }
                        this.j1 = true;
                        jg.a().removeCallbacks(this.p1);
                        jg.a().postDelayed(this.p1, 3000L);
                    }
                } else if (this.j1 || ((absVideoPbFragment = this.f1) != null && absVideoPbFragment.N4())) {
                    S0();
                }
            }
        }
    }
}
