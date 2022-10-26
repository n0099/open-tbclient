package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.play.operableVideoView.OperableVideoErrorView;
import com.baidu.tieba.play.operableVideoView.OperableVideoMediaControllerView;
import com.baidu.tieba.play.operableVideoView.OperableVideoNetworkStateTipView;
import com.baidu.tieba.play.operableVideoView.OperableVideoShareView;
import com.baidu.tieba.play.operableVideoView.PercentSizeView;
import com.baidu.tieba.play.operableVideoView.VideoGestureView;
import com.baidu.tieba.view.SwitchImageView;
import com.baidu.tieba.xa8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
/* loaded from: classes5.dex */
public class sb8 implements pb8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View.OnClickListener A0;
    public TextView B;
    public ie0 B0;
    public TextView C;
    public McnAdInfo C0;
    public SwitchImageView D;
    public boolean D0;
    public SwitchImageView E;
    public l E0;
    public OperableVideoMediaControllerView F;
    public long F0;
    public OperableVideoNetworkStateTipView G;
    public xa8.c G0;
    public OperableVideoShareView H;
    public CustomMessageListener H0;
    public ImageView I;
    public SeekBar.OnSeekBarChangeListener I0;
    public View J;
    public GestureDetector.SimpleOnGestureListener J0;
    public VideoGestureView K;
    public View.OnTouchListener K0;
    public View L;
    public TbVideoViewSet.b L0;
    public OperableVideoErrorView M;
    public final CustomMessageListener M0;
    public WeakReference N;
    public Context O;
    public View P;
    public ViewGroup Q;
    public BdUniqueId R;
    public boolean S;
    public boolean T;
    public String U;
    public String V;
    public long W;
    public bb8 X;
    public boolean Y;
    public kb8 Z;
    public int a;
    public ThreadData a0;
    public int b;
    public String b0;
    public int c;
    public boolean c0;
    public int d;
    public boolean d0;
    public int e;
    public String e0;
    public int f;
    public boolean f0;
    public int g;
    public boolean g0;
    public int h;
    public float h0;
    public int i;
    public float i0;
    public int j;
    public GestureDetector j0;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int q0;
    public int r;
    public int[] r0;
    public Runnable s;
    public int s0;
    public TbVideoViewContainer t;
    public boolean t0;
    public TbImageView u;
    public int u0;
    public View v;
    public int v0;
    public TBLottieAnimationView w;
    public float w0;
    public ImageView x;
    public int x0;
    public ImageView y;
    public boolean y0;
    public PercentSizeView z;
    public boolean z0;

    /* loaded from: classes5.dex */
    public interface l {
        void a(int i, int i2);
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? R.layout.obfuscated_res_0x7f0d0690 : invokeV.intValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.pb8
    public void onScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    @Override // com.baidu.tieba.pb8
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, onClickListener) == null) {
        }
    }

    public void t0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        public a(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g0) {
                    sb8 sb8Var = this.a;
                    sb8Var.o0(sb8Var.o);
                    this.a.g0 = false;
                } else {
                    sb8 sb8Var2 = this.a;
                    sb8Var2.o0(sb8Var2.b);
                }
                this.a.r0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.t.a();
                this.a.q0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(sb8 sb8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var, Integer.valueOf(i)};
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
            this.a = sb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            this.a.stopPlay();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        public c(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sb8 sb8Var = this.a;
                sb8Var.o0(sb8Var.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements xa8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        public d(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // com.baidu.tieba.xa8.c
        public void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.F0 <= 0) {
                    this.a.F0 = i2;
                }
                if (this.a.h0()) {
                    sb8 sb8Var = this.a;
                    if (!sb8Var.T && !sb8Var.Y && sb8Var.D0) {
                        if (he0.b().a(this.a.C0.jump_url)) {
                            return;
                        }
                        long j = i2;
                        boolean z2 = true;
                        if (j >= this.a.C0.ad_start_time.longValue() * 1000 && j < this.a.C0.ad_end_time.longValue() * 1000) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (this.a.F0 < (this.a.C0.ad_start_time.longValue() * 1000) + 1000) {
                            z2 = false;
                        }
                        if (this.a.B0 == null) {
                            sb8 sb8Var2 = this.a;
                            sb8Var2.B0 = new ie0(sb8Var2.O);
                        }
                        if (z) {
                            if (!this.a.B0.c()) {
                                ge0 ge0Var = new ge0();
                                ge0Var.b = this.a.C0.card_title;
                                ge0Var.c = this.a.C0.button_title;
                                ge0Var.d = this.a.C0.jump_url;
                                ge0Var.a = this.a.C0.pic_url;
                                ge0Var.f = String.valueOf(this.a.W);
                                sb8 sb8Var3 = this.a;
                                ge0Var.e = sb8Var3.V;
                                ge0Var.g = sb8Var3.b0();
                                if (z2) {
                                    this.a.B0.f(ge0Var, (ViewGroup) this.a.P);
                                } else {
                                    this.a.B0.e(ge0Var, (ViewGroup) this.a.P);
                                }
                            }
                        } else if (this.a.B0.c()) {
                            this.a.B0.a();
                        }
                    }
                }
                if (this.a.E0 != null) {
                    this.a.E0.a(i, i2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public e(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sb8 sb8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var, Integer.valueOf(i)};
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
            this.a = sb8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && ej.isEquals(this.a.U, (String) customResponsedMessage.getData()) && UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                this.a.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                TbSingleton.getInstance().setVideoCurrentFrame(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public g(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.w.setVisibility(8);
                this.a.x.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.O();
                if (!this.a.S) {
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }

        public h(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.Q.setScaleX(1.0f);
                this.a.Q.setScaleY(1.0f);
                this.a.Q.setTranslationX(0.0f);
                this.a.Q.setTranslationY(0.0f);
                this.a.H.setScaleX(1.0f);
                this.a.H.setScaleY(1.0f);
                this.a.Q.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (!this.a.t0) {
                    this.a.U();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            }
        }

        public i(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                sb8 sb8Var = this.a;
                sb8Var.o0(sb8Var.f);
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e94));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) && seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f080e93));
                if (!this.a.t.getControl().isPlaying()) {
                    this.a.t.getControl().P(this.a.L0);
                }
                this.a.S();
                if (this.a.c0) {
                    StatisticItem param = new StatisticItem("c13355").param("tid", this.a.V).param("fid", this.a.W);
                    int i2 = 1;
                    if (this.a.T) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    StatisticItem param2 = param.param("obj_type", i);
                    if (!this.a.Y) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param2.param("obj_locate", i2));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        public j(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            this.a.q = 0;
            sb8 sb8Var = this.a;
            if (sb8Var.Y) {
                sb8Var.R((Activity) sb8Var.O, true);
            }
            return super.onDown(motionEvent);
        }

        public final void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.u0 == i2 && this.a.v0 == i) {
                    return;
                }
                sb8 sb8Var = this.a;
                if (sb8Var.u0 - i2 <= 0 && i2 >= this.a.h0 / 6.0f) {
                    z = false;
                } else {
                    z = true;
                }
                sb8Var.t0 = z;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.Q.getLayoutParams();
                if (i2 != this.a.u0) {
                    int i3 = this.a.s0 - i2;
                    int i4 = (int) (i3 * this.a.w0);
                    if (i4 < this.a.x0) {
                        i4 = this.a.x0;
                        i3 = (int) (i4 / this.a.w0);
                    }
                    if (i4 != this.a.x0) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        this.a.Q.setLayoutParams(layoutParams);
                    }
                    this.a.u0 = i2;
                    sb8 sb8Var2 = this.a;
                    sb8Var2.Q.setTranslationY(sb8Var2.u0);
                }
                if (i != this.a.u0) {
                    this.a.v0 = i;
                    sb8 sb8Var3 = this.a;
                    sb8Var3.Q.setTranslationX(sb8Var3.v0 + ((this.a.i0 - layoutParams.width) / 2.0f));
                }
                this.a.L.setAlpha((layoutParams.width - this.a.x0) / (this.a.i0 - this.a.x0));
                if (this.a.H.getVisibility() == 0) {
                    float f = this.a.h0 / 6.0f;
                    float f2 = (f - i2) / f;
                    if (f2 < 0.0f) {
                        f2 = 0.0f;
                    }
                    this.a.H.setAlpha(f2);
                }
            }
        }

        public final void b(float f) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                if (f > 0.0f) {
                    sb8 sb8Var = this.a;
                    sb8Var.q0 -= 1000;
                    z = true;
                } else {
                    this.a.q0 += 1000;
                    z = false;
                }
                int duration = this.a.t.getControl().getDuration();
                if (this.a.q0 < 0) {
                    this.a.q0 = 0;
                } else if (this.a.q0 > duration) {
                    this.a.q0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.a.q0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.a.K;
                if (videoGestureView != null) {
                    videoGestureView.b(z, str);
                }
                sb8 sb8Var2 = this.a;
                sb8Var2.F.setCurrentDuration(sb8Var2.q0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    sb8 sb8Var = this.a;
                    int i = sb8Var.p;
                    int i2 = sb8Var.d;
                    if (i != i2 && i != sb8Var.e && i != sb8Var.n) {
                        if (i == sb8Var.f) {
                            sb8Var.o0(i2);
                        }
                    } else {
                        sb8 sb8Var2 = this.a;
                        sb8Var2.o0(sb8Var2.f);
                        this.a.S();
                    }
                } else {
                    sb8 sb8Var3 = this.a;
                    int i3 = sb8Var3.p;
                    int i4 = sb8Var3.g;
                    if (i3 == i4) {
                        sb8Var3.o0(sb8Var3.h);
                    } else if (i3 == (i4 | 1)) {
                        sb8Var3.o0(sb8Var3.h | 1);
                    } else {
                        int i5 = sb8Var3.h;
                        if (i3 == i5) {
                            sb8Var3.o0(i4);
                        } else if (i3 == (i5 | 1)) {
                            sb8Var3.o0(i4 | 1);
                        } else {
                            sb8Var3.o0(sb8Var3.b);
                            this.a.startPlay();
                            this.a.l0();
                        }
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    this.a.t.getControl().pause();
                    sb8 sb8Var = this.a;
                    if (sb8Var.p == sb8Var.f) {
                        sb8Var.o0(sb8Var.g);
                    } else {
                        sb8Var.o0(sb8Var.h);
                    }
                    this.a.t0(R.id.obfuscated_res_0x7f092534);
                    return true;
                }
                sb8 sb8Var2 = this.a;
                int i = sb8Var2.p;
                int i2 = sb8Var2.g;
                if (i != i2 && i != (i2 | 1)) {
                    int i3 = sb8Var2.h;
                    if (i != i3 && i != (i3 | 1)) {
                        return true;
                    }
                    sb8 sb8Var3 = this.a;
                    sb8Var3.o0(sb8Var3.d);
                    this.a.t.getControl().P(this.a.L0);
                    this.a.t0(R.id.obfuscated_res_0x7f092541);
                    return true;
                }
                sb8 sb8Var4 = this.a;
                sb8Var4.o0(sb8Var4.f);
                this.a.S();
                this.a.t.getControl().P(this.a.L0);
                this.a.t0(R.id.obfuscated_res_0x7f092541);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (!this.a.f0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                Context context = this.a.O;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.a.O).disableSwipeJustOnce();
                } else {
                    Context context2 = this.a.O;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.a.O).disableSwipeJustOnce();
                    }
                }
                sb8 sb8Var = this.a;
                if (sb8Var.T && sb8Var.g0()) {
                    int rawX = (int) (motionEvent2.getRawX() - motionEvent.getRawX());
                    int rawY = (int) (motionEvent2.getRawY() - motionEvent.getRawY());
                    int i3 = this.a.q;
                    if (i3 != 0) {
                        if (i3 == 4) {
                            a(rawX, rawY);
                        }
                    } else if (rawY > 0 && Math.abs(rawY) - Math.abs(rawX) > 0) {
                        if (this.a.t.getControl().isPlaying()) {
                            this.a.t.getControl().pause();
                            sb8 sb8Var2 = this.a;
                            sb8Var2.o0(sb8Var2.l);
                        }
                        this.a.q = 4;
                        sb8 sb8Var3 = this.a;
                        sb8Var3.r = sb8Var3.p;
                        sb8 sb8Var4 = this.a;
                        sb8Var4.p = sb8Var4.k;
                        sb8Var4.s0 = sb8Var4.Q.getMeasuredHeight();
                        sb8 sb8Var5 = this.a;
                        sb8Var5.w0 = sb8Var5.i0 / this.a.s0;
                        sb8 sb8Var6 = this.a;
                        sb8Var6.x0 = (int) (sb8Var6.P.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    sb8 sb8Var7 = this.a;
                    int i4 = sb8Var7.p;
                    boolean z = true;
                    if (i4 == sb8Var7.d || i4 == sb8Var7.f || i4 == (i = sb8Var7.g) || i4 == (i2 = sb8Var7.h) || i4 == sb8Var7.k || i4 == (i | 1) || i4 == (i2 | 1)) {
                        int i5 = this.a.q;
                        boolean z2 = false;
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 == 3) {
                                        b(f);
                                    }
                                } else {
                                    sb8 sb8Var8 = this.a;
                                    VideoGestureView videoGestureView = sb8Var8.K;
                                    Context context3 = sb8Var8.O;
                                    if (f2 <= 0.0f) {
                                        z = false;
                                    }
                                    videoGestureView.a(context3, z);
                                }
                            } else {
                                sb8 sb8Var9 = this.a;
                                VideoGestureView videoGestureView2 = sb8Var9.K;
                                Context context4 = sb8Var9.O;
                                int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                                if (i6 <= 0) {
                                    z = false;
                                }
                                videoGestureView2.c(context4, z);
                                if (i6 > 0) {
                                    this.a.onVolumeUp();
                                }
                            }
                        } else {
                            if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                                this.a.q = 3;
                                sb8 sb8Var10 = this.a;
                                sb8Var10.q0 = sb8Var10.t.getControl().getCurrentPosition();
                                b(f);
                            } else if (motionEvent.getX() < this.a.Q.getWidth() / 2) {
                                this.a.q = 2;
                                sb8 sb8Var11 = this.a;
                                VideoGestureView videoGestureView3 = sb8Var11.K;
                                Context context5 = sb8Var11.O;
                                if (f2 > 0.0f) {
                                    z2 = true;
                                }
                                videoGestureView3.a(context5, z2);
                            } else {
                                this.a.q = 1;
                                sb8 sb8Var12 = this.a;
                                VideoGestureView videoGestureView4 = sb8Var12.K;
                                Context context6 = sb8Var12.O;
                                if (f2 > 0.0f) {
                                    z2 = true;
                                }
                                videoGestureView4.c(context6, z2);
                            }
                            sb8 sb8Var13 = this.a;
                            int i7 = sb8Var13.p;
                            int i8 = sb8Var13.k;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    sb8Var13.k = i8 | 1;
                                } else {
                                    sb8Var13.k = i8 & (-2);
                                }
                                sb8 sb8Var14 = this.a;
                                sb8Var14.o0(sb8Var14.k);
                            }
                        }
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sb8 a;

        public k(sb8 sb8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sb8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sb8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    sb8 sb8Var = this.a;
                    if (sb8Var.p == sb8Var.k) {
                        if (sb8Var.q == 4) {
                            this.a.T();
                            this.a.u0 = 0;
                            this.a.v0 = 0;
                        } else {
                            sb8 sb8Var2 = this.a;
                            sb8Var2.p = -1;
                            if (sb8Var2.q != 3) {
                                if (this.a.r != -1) {
                                    sb8 sb8Var3 = this.a;
                                    sb8Var3.o0(sb8Var3.r);
                                    this.a.r = -1;
                                } else if (this.a.t.getControl().isPlaying()) {
                                    sb8 sb8Var4 = this.a;
                                    sb8Var4.o0(sb8Var4.d);
                                } else {
                                    sb8 sb8Var5 = this.a;
                                    sb8Var5.o0(sb8Var5.g);
                                }
                            } else {
                                sb8 sb8Var6 = this.a;
                                sb8Var6.F.setCurrentDuration(sb8Var6.q0, true);
                                if (this.a.q0 <= this.a.t.getControl().getDuration()) {
                                    if (!this.a.t.getControl().isPlaying()) {
                                        this.a.t.getControl().P(this.a.L0);
                                    }
                                    sb8 sb8Var7 = this.a;
                                    sb8Var7.o0(sb8Var7.d);
                                }
                            }
                        }
                        sb8 sb8Var8 = this.a;
                        if (sb8Var8.c0) {
                            String str = null;
                            if (sb8Var8.q == 1) {
                                str = "c13361";
                            } else if (this.a.q == 2) {
                                str = "c13346";
                            } else if (this.a.q == 3) {
                                str = "c13362";
                            }
                            if (!ej.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.a.V).param("fid", this.a.W));
                            }
                        }
                        this.a.q = 0;
                        return true;
                    }
                }
                return this.a.j0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    public sb8(Context context, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3000;
        this.b = 8211;
        this.c = 19;
        this.d = 0;
        this.e = 4;
        this.f = 232;
        this.g = 8416;
        this.h = 0;
        this.i = 513;
        this.j = ApkSignatureSchemeV2Verifier.SIGNATURE_RSA_PKCS1_V1_5_WITH_SHA256;
        this.k = 2048;
        this.l = 0;
        this.m = 4099;
        this.n = 0;
        this.o = 1;
        this.p = 8211;
        this.q = 0;
        this.r = -1;
        this.s = new c(this);
        this.N = null;
        this.Y = false;
        this.c0 = true;
        this.d0 = false;
        this.f0 = true;
        this.g0 = false;
        this.r0 = new int[2];
        this.u0 = 0;
        this.v0 = 0;
        this.y0 = false;
        this.z0 = false;
        this.A0 = null;
        this.D0 = false;
        this.F0 = -1L;
        this.G0 = new d(this);
        this.H0 = new f(this, 2921683);
        this.I0 = new i(this);
        this.J0 = new j(this);
        this.K0 = new k(this);
        this.L0 = new a(this);
        this.M0 = new b(this, 2000994);
        if (context != null && view2 != null) {
            this.O = context;
            this.X = new bb8((Activity) context);
            this.P = view2;
            this.h0 = fj.i(this.O);
            this.i0 = fj.k(this.O);
            d0();
        }
    }

    public void X(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            if (z) {
                this.X.i(true);
            } else {
                this.X.i(false);
            }
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            if (z) {
                this.X.j();
            } else {
                this.X.k();
            }
        }
    }

    @Override // com.baidu.tieba.pb8
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.t.getControl().v(i2);
        }
    }

    public boolean f0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            return this.Y;
        }
        return invokeL.booleanValue;
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.D0 = z;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.z0 = z;
        }
    }

    @Override // com.baidu.tieba.pb8
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, onClickListener) == null) {
            this.A0 = onClickListener;
        }
    }

    @Override // com.baidu.tieba.pb8
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.b0 = str;
        }
    }

    @Override // com.baidu.tieba.pb8
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            this.e0 = str;
        }
    }

    @Override // com.baidu.tieba.pb8
    public void setStatistic(kb8 kb8Var) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, kb8Var) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getControl() != null) {
            this.Z = kb8Var;
            this.t.getControl().setVideoStatData(kb8Var);
        }
    }

    @Override // com.baidu.tieba.pb8
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bdUniqueId) == null) {
            this.R = bdUniqueId;
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048612, this, i2, i3, obj)) == null) {
            o0(this.m);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i2, i3, obj)) == null) {
            if (i2 == 3 || i2 == 904) {
                s0();
            }
            if (i2 == 701) {
                this.f0 = true;
                r0();
                return false;
            } else if (i2 == 702) {
                s0();
                return false;
            } else {
                return false;
            }
        }
        return invokeIIL.booleanValue;
    }

    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.p;
            if (i2 == this.e || i2 == this.n) {
                o0(this.d);
            }
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            hh.a().removeCallbacks(this.s);
            hh.a().postDelayed(this.s, this.a);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            V(true);
        }
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.U;
        }
        return (String) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.T && this.Y) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb8
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.t.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.pb8
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.Q;
        }
        return (View) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.C0 != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb8
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.Y;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.pb8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (!this.S && !this.t.getControl().isPlaying()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            hh.a().removeCallbacks(this.s);
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.U);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.R);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    @Override // com.baidu.tieba.pb8
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (this.Y) {
                T();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            o0(this.i);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.Q.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.Q.setSystemUiVisibility(4);
            } else {
                this.Q.setSystemUiVisibility(5894);
            }
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            o0(this.n);
            this.F.p();
            Z();
        }
    }

    public void u0() {
        kb8 kb8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (kb8Var = this.Z) != null) {
            kb8 b2 = kb8Var.b();
            b2.a = this.b0;
            za8.e(b2.m, "", "1", b2, this.t.getControl().getPcdnState());
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.T && !"video_tab".equals(this.b0)) {
                this.f = 104;
                this.g = 8290;
            } else {
                this.f = 232;
                this.g = 8418;
            }
            if (this.Y) {
                this.b |= 1024;
                this.o |= 8192;
                this.d |= 1024;
                this.e |= 1024;
                this.n |= 1024;
                this.f |= 1024;
                this.g |= 1024;
                this.h |= 1024;
                this.i |= 1024;
                this.j |= 1024;
                this.p |= 1024;
                return;
            }
            this.b &= -1025;
            this.o &= -1025;
            this.d &= -1025;
            this.e &= -1025;
            this.n &= -1025;
            this.f &= -1025;
            this.g &= -1025;
            this.h &= -1025;
            this.i &= -1025;
            this.j &= -1025;
            this.p &= -1025;
        }
    }

    public void Q() {
        float dimension;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.G.a(this.T, this.Y);
            this.H.e(this.T, this.Y);
            Context context = this.O;
            if (context != null && context.getResources() != null) {
                if (this.T) {
                    dimension = this.O.getResources().getDimension(R.dimen.tbds44);
                } else if (this.Y) {
                    dimension = this.O.getResources().getDimension(R.dimen.tbds78);
                } else {
                    dimension = this.O.getResources().getDimension(R.dimen.tbds44);
                }
                int i3 = (int) dimension;
                if ("video_tab".equals(this.b0)) {
                    i2 = 0;
                } else {
                    i2 = i3;
                }
                this.A.setPadding(0, 0, i2, 0);
                SwitchImageView switchImageView = this.E;
                switchImageView.setPadding(switchImageView.getPaddingLeft(), 0, i3, 0);
                this.D.setPadding(i3, 0, 0, 0);
            }
        }
    }

    public void q0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.Q.addView(this.t, 0);
            this.t.setLayoutParams(layoutParams);
            this.F.setPlayer(this.t.getControl());
            this.t.getControl().setContinuePlayEnable(true);
            this.t.getControl().setOperableVideoContainer(this);
            this.t.getControl().setOnSurfaceDestroyedListener(this);
            this.t.getControl().setVideoStatData(this.Z);
            this.t.getControl().setThreadDataForStatistic(this.a0);
            this.t.getControl().getMediaProgressObserver().j(this.G0);
        }
    }

    public final void R(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048579, this, activity, z) == null) && activity != null && activity.getWindow() != null) {
            if (this.T && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                ViewGroup viewGroup = this.Q;
                if (viewGroup == null) {
                    return;
                }
                if (z) {
                    viewGroup.setPadding(0, fj.s((Activity) this.O), 0, 0);
                } else {
                    viewGroup.setPadding(0, 0, 0, 0);
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                p0();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.Q.setSystemUiVisibility(0);
            }
        }
    }

    public final void T() {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        ObjectAnimator ofFloat3;
        ObjectAnimator ofFloat4;
        ObjectAnimator ofFloat5;
        ObjectAnimator ofFloat6;
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (!this.T) {
                U();
            } else if (this.p == this.k) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new h(this));
                if (!this.t0) {
                    float width = this.P.getWidth() / this.Q.getWidth();
                    float height = this.P.getHeight() / this.Q.getHeight();
                    this.Q.setPivotX(0.0f);
                    this.Q.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.Q, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.Q, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.Q;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.r0[0]);
                    ViewGroup viewGroup2 = this.Q;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.r0[1]);
                    View view2 = this.L;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view2, Key.ALPHA, view2.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, Key.ALPHA, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.i0 / this.Q.getWidth();
                    float height2 = this.s0 / this.Q.getHeight();
                    this.Q.setPivotX(0.0f);
                    this.Q.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.Q, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.Q, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.Q;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.Q;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup4, "TranslationY", viewGroup4.getTranslationY(), 0.0f);
                    OperableVideoShareView operableVideoShareView2 = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView2, Key.ALPHA, operableVideoShareView2.getAlpha(), 1.0f);
                    objectAnimator = ofFloat10;
                    objectAnimator2 = null;
                }
                if (objectAnimator2 != null) {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(objectAnimator2).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                } else {
                    animatorSet.play(ofFloat).with(objectAnimator).with(ofFloat4).with(ofFloat5).with(ofFloat6).with(ofFloat2).with(ofFloat3);
                }
                animatorSet.start();
                int i2 = this.r;
                if (i2 != -1) {
                    this.p = i2;
                    this.r = -1;
                    if (i2 != this.l && i2 != this.f && i2 != this.d) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        this.t.getControl().P(this.L0);
                        o0(this.d);
                    }
                }
            } else {
                U();
            }
        }
    }

    public void d0() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || (context = this.O) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(a0(), (ViewGroup) null);
        this.Q = viewGroup;
        View view2 = this.P;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(viewGroup);
        }
        this.N = new WeakReference(TbadkCoreApplication.getInst());
        this.u = (TbImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092573);
        this.v = this.Q.findViewById(R.id.obfuscated_res_0x7f0903ac);
        this.w = (TBLottieAnimationView) this.Q.findViewById(R.id.obfuscated_res_0x7f092528);
        this.x = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092541);
        this.z = (PercentSizeView) this.Q.findViewById(R.id.obfuscated_res_0x7f09252d);
        this.y = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f092534);
        this.A = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092543);
        this.B = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092545);
        this.C = (TextView) this.Q.findViewById(R.id.obfuscated_res_0x7f092508);
        this.D = (SwitchImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09252f);
        this.E = (SwitchImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09250d);
        this.F = (OperableVideoMediaControllerView) this.Q.findViewById(R.id.obfuscated_res_0x7f09252c);
        this.G = (OperableVideoNetworkStateTipView) this.Q.findViewById(R.id.obfuscated_res_0x7f092531);
        this.H = (OperableVideoShareView) this.Q.findViewById(R.id.obfuscated_res_0x7f092557);
        this.J = this.Q.findViewById(R.id.obfuscated_res_0x7f0924f8);
        this.I = (ImageView) this.Q.findViewById(R.id.obfuscated_res_0x7f09250e);
        this.K = (VideoGestureView) this.Q.findViewById(R.id.obfuscated_res_0x7f092510);
        this.M = (OperableVideoErrorView) this.Q.findViewById(R.id.obfuscated_res_0x7f09250a);
        this.H.setVideoContainer(this);
        this.w.addAnimatorListener(new e(this));
        this.w.setAnimation(R.raw.obfuscated_res_0x7f11001b);
        this.x.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.x.setOnClickListener(this);
        this.D.setSvgStateImage(new SvgPureType(R.drawable.obfuscated_res_0x7f080639, R.color.CAM_X0101), new SvgPureType(R.drawable.obfuscated_res_0x7f080637, R.color.CAM_X0101));
        this.D.setState(1);
        this.D.setOnClickListener(this);
        this.u.t();
        this.u.setDrawCorner(false);
        this.u.setPlaceHolder(3);
        HomeGroupUbsUIHelper.handleImgMask(this.v, R.color.CAM_X0601);
        this.F.setOnSeekBarChangeListener(this.I0);
        this.z.setHeightPercent(0.583f);
        this.z.setBackgroundResource(R.drawable.obfuscated_res_0x7f081299);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.obfuscated_res_0x7f080630, R.color.CAM_X0101), new SvgPureType(R.drawable.obfuscated_res_0x7f080638, R.color.CAM_X0101));
        this.E.setState(0);
        this.E.setOnClickListener(this);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080a44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.I.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.O);
        this.t = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setTryUseViewInSet(true);
        q0();
        this.G.setPlayViewOnClickListener(this);
        this.Q.setOnClickListener(null);
        this.Q.setOnTouchListener(this.K0);
        this.H.setOnTouchListener(this.K0);
        this.M.setOutOnClickListener(this);
        this.j0 = new GestureDetector(this.O, this.J0);
        o0(this.b);
        nv4.d(this.v).s(R.array.Mask_X003);
        nv4.d(this.A).y(R.array.S_O_X001);
        nv4.d(this.C).y(R.array.S_O_X001);
        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
            Context context2 = this.O;
            if (context2 instanceof BaseFragmentActivity) {
                ((BaseFragmentActivity) context2).registerListener(this.H0);
            }
        }
    }

    public void V(boolean z) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z) == null) && this.P != null && this.Q != null && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getControl() != null) {
            Context context = this.O;
            if (context != null) {
                fj.x(context, this.P);
            }
            int i2 = 1;
            if (this.Y) {
                if (this.L.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.L.getParent()).removeView(this.L);
                }
                if ((this.Q.getParent() instanceof ViewGroup) && (this.P instanceof ViewGroup)) {
                    this.Y = false;
                    this.d0 = true;
                    ((ViewGroup) this.Q.getParent()).removeView(this.Q);
                    ((ViewGroup) this.P).addView(this.Q);
                    this.d0 = false;
                    R((Activity) this.O, this.Y);
                }
                if (!this.T && z) {
                    this.X.l();
                }
            } else {
                if (this.O != null) {
                    if (!this.T && z) {
                        this.X.l();
                    }
                    if (this.O instanceof Activity) {
                        this.Q.getLocationOnScreen(this.r0);
                        View findViewById = ((Activity) this.O).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.d0 = true;
                                ((ViewGroup) this.P).removeAllViews();
                                if (this.L == null) {
                                    View view2 = new View(this.O);
                                    this.L = view2;
                                    view2.setClickable(true);
                                    this.L.setBackgroundColor(SkinManager.getColor(R.color.black_alpha100));
                                    this.L.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (this.L.getParent() instanceof ViewGroup) {
                                    ((ViewGroup) this.L.getParent()).removeView(this.L);
                                }
                                this.L.setAlpha(1.0f);
                                ViewGroup viewGroup = (ViewGroup) childAt;
                                viewGroup.addView(this.L);
                                viewGroup.addView(this.Q);
                                this.d0 = false;
                                this.Y = true;
                                R((Activity) this.O, true);
                                ie0 ie0Var = this.B0;
                                if (ie0Var != null && ie0Var.c()) {
                                    this.B0.a();
                                }
                            }
                        }
                    }
                }
                if (this.c0) {
                    StatisticItem param = new StatisticItem("c13360").param("tid", this.V).param("fid", this.W);
                    if (!this.T) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param.param("obj_type", i2));
                }
            }
            P();
            Q();
            if (this.t.getControl().isPlaying()) {
                o0(this.d);
            } else {
                o0(this.p);
            }
            this.E.f();
            j0(this.Y);
        }
    }

    public void o0(int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            k0();
            if (this.p == this.k) {
                this.r = i2;
                return;
            }
            this.p = i2;
            TbImageView tbImageView = this.u;
            int i19 = 0;
            if ((i2 & 1) > 0) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            tbImageView.setVisibility(i3);
            View view2 = this.v;
            if ((i2 & 2) > 0) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            view2.setVisibility(i4);
            if ((i2 & 4) > 0) {
                z = true;
            } else {
                z = false;
            }
            this.f0 = z;
            this.w.clearAnimation();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (this.f0) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            tBLottieAnimationView.setVisibility(i5);
            if (!this.f0) {
                this.w.cancelAnimation();
            } else {
                this.w.setAlpha(1.0f);
            }
            ImageView imageView = this.x;
            if ((i2 & 8192) > 0) {
                i6 = 0;
            } else {
                i6 = 8;
            }
            imageView.setVisibility(i6);
            ImageView imageView2 = this.y;
            if ((i2 & 8) > 0) {
                i7 = 0;
            } else {
                i7 = 8;
            }
            imageView2.setVisibility(i7);
            TextView textView = this.A;
            int i20 = i2 & 16;
            if (i20 > 0) {
                i8 = 0;
            } else {
                i8 = 8;
            }
            textView.setVisibility(i8);
            TextView textView2 = this.C;
            if (i20 > 0) {
                i9 = 0;
            } else {
                i9 = 8;
            }
            textView2.setVisibility(i9);
            SwitchImageView switchImageView = this.D;
            if ((i2 & 32) > 0) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            switchImageView.setVisibility(i10);
            SwitchImageView switchImageView2 = this.E;
            if ((i2 & 64) > 0) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            switchImageView2.setVisibility(i11);
            OperableVideoMediaControllerView operableVideoMediaControllerView = this.F;
            int i21 = i2 & 128;
            if (i21 > 0) {
                i12 = 0;
            } else {
                i12 = 8;
            }
            operableVideoMediaControllerView.setVisibility(i12);
            PercentSizeView percentSizeView = this.z;
            if (i21 > 0) {
                i13 = 0;
            } else {
                i13 = 8;
            }
            percentSizeView.setVisibility(i13);
            if (this.F.getVisibility() == 0) {
                this.F.p();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.G;
            if ((i2 & 256) > 0) {
                i14 = 0;
            } else {
                i14 = 8;
            }
            operableVideoNetworkStateTipView.setVisibility(i14);
            OperableVideoShareView operableVideoShareView = this.H;
            if ((i2 & 512) > 0) {
                i15 = 0;
            } else {
                i15 = 8;
            }
            operableVideoShareView.setVisibility(i15);
            if (this.H.getVisibility() == 0) {
                this.H.setAlpha(1.0f);
            }
            ImageView imageView3 = this.I;
            int i22 = i2 & 1024;
            if (i22 > 0) {
                i16 = 0;
            } else {
                i16 = 8;
            }
            imageView3.setVisibility(i16);
            View view3 = this.J;
            if (i22 > 0) {
                i17 = 0;
            } else {
                i17 = 8;
            }
            view3.setVisibility(i17);
            VideoGestureView videoGestureView = this.K;
            if ((i2 & 2048) > 0) {
                i18 = 0;
            } else {
                i18 = 8;
            }
            videoGestureView.setVisibility(i18);
            OperableVideoErrorView operableVideoErrorView = this.M;
            if ((i2 & 4096) <= 0) {
                i19 = 8;
            }
            operableVideoErrorView.setVisibility(i19);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048610, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        t0(id);
        if (id == R.id.obfuscated_res_0x7f09252f) {
            W();
        } else if (id != R.id.obfuscated_res_0x7f09250d && id != R.id.obfuscated_res_0x7f09250e) {
            int i5 = 1;
            int i6 = 2;
            if (id == R.id.obfuscated_res_0x7f092550) {
                o0(this.b);
                startPlay();
                if (this.c0) {
                    StatisticItem param = new StatisticItem("c13345").param("tid", this.V).param("fid", this.W);
                    if (this.T) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    StatisticItem param2 = param.param("obj_type", i4);
                    if (!this.Y) {
                        i5 = 2;
                    }
                    TiebaStatic.log(param2.param("obj_locate", i5));
                }
                l0();
            } else if (id == R.id.obfuscated_res_0x7f092541) {
                int i7 = this.p;
                if (i7 != this.b && i7 != this.c && i7 != this.o) {
                    o0(this.f);
                    S();
                    this.t.getControl().P(this.L0);
                } else {
                    startPlay();
                }
                if (this.c0) {
                    StatisticItem param3 = new StatisticItem("c13344").param("tid", this.V).param("fid", this.W);
                    if (this.T) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    StatisticItem param4 = param3.param("obj_type", i3);
                    if (this.Y) {
                        i6 = 1;
                    }
                    TiebaStatic.log(param4.param("obj_source", i6).param("obj_locate", 1));
                }
                l0();
            } else if (id == R.id.obfuscated_res_0x7f092534) {
                o0(this.g);
                k0();
                this.t.getControl().pause();
                if (this.c0) {
                    StatisticItem param5 = new StatisticItem("c13344").param("tid", this.V).param("fid", this.W);
                    if (this.T) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    StatisticItem param6 = param5.param("obj_type", i2);
                    if (!this.Y) {
                        i5 = 2;
                    }
                    TiebaStatic.log(param6.param("obj_source", i5).param("obj_locate", 2));
                }
            } else if (id == R.id.obfuscated_res_0x7f0919e6) {
                o0(this.b);
                startPlay();
            } else if (id == R.id.obfuscated_res_0x7f091c07) {
                o0(this.b);
                startPlay();
            }
        } else {
            T();
        }
    }

    @Override // com.baidu.tieba.pb8
    public void setData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.F0 = -1L;
            ie0 ie0Var = this.B0;
            if (ie0Var != null) {
                ie0Var.d();
            }
            if (StringHelper.equals(this.U, threadData.getThreadVideoInfo().video_url)) {
                return;
            }
            stopPlay();
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.T = z;
            this.U = threadData.getThreadVideoInfo().video_url;
            this.V = threadData.getTid();
            threadData.getThreadVideoInfo().video_length.intValue();
            threadData.getThreadVideoInfo().video_duration.intValue();
            this.W = threadData.getFid();
            this.C0 = threadData.getThreadVideoInfo().mcn_ad_card;
            P();
            Q();
            o0(this.b);
            int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
            this.F.j(intValue);
            this.F.setPlayer(this.t.getControl());
            this.C.setText(StringHelper.stringForVideoTime(intValue));
            this.A.setText(String.format(this.O.getResources().getString(R.string.obfuscated_res_0x7f0f0ebb), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
            this.G.setVideoLength(threadData.getThreadVideoInfo().video_length.intValue());
            this.G.setVideoDuration(threadData.getThreadVideoInfo().video_duration.intValue());
            this.G.setTid(this.V);
            this.a0 = threadData;
            this.t.getControl().setThreadDataForStatistic(threadData);
            this.B.setVisibility(8);
            this.u.setPlaceHolder(3);
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
                this.u.L(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            } else {
                this.u.setImageBitmap(null);
                if (!ej.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                    this.u.L(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
                } else {
                    this.u.L(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
                }
            }
            this.H.setShareData(threadData);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                ui5.e(this.N, true);
                ja5.b().l(true);
                this.D.setState(0);
            } else {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                ui5.e(this.N, false);
                ja5.b().l(false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            e0();
            if (this.S) {
                if (this.Y) {
                    Context context = this.O;
                    if (context instanceof Activity) {
                        R((Activity) context, true);
                    }
                }
                if (this.T) {
                    this.t.getControl().setVideoScalingMode(0);
                } else {
                    this.t.getControl().setVideoScalingMode(2);
                }
                this.t.getControl().P(this.L0);
            }
        }
    }

    @Override // com.baidu.tieba.pb8
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.t.getControl().isPlaying() && !ui5.c() && !ja5.b().j()) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                this.D.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.f0) {
                this.w.setAlpha(1.0f);
                this.w.setVisibility(0);
                this.x.setVisibility(8);
            } else {
                this.w.setVisibility(8);
                this.x.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null && this.f0) {
                tBLottieAnimationView.loop(true);
                this.w.setMinAndMaxFrame(14, 80);
                this.w.playAnimation();
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.F.p();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.w.animate().alpha(0.0f).setDuration(200L).setListener(new g(this)).start();
            }
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                return;
            }
            this.t.getControl().setVolume(1.0f, 1.0f);
            this.D.setState(0);
            ja5.b().l(true);
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.z0) {
                return false;
            }
            if (UbsABTestHelper.isVideoTabAutoPlay() && "video_tab".equals(this.b0)) {
                return BdNetTypeUtil.isMobileNet();
            }
            OperableVideoNetworkStateTipView operableVideoNetworkStateTipView = this.G;
            if (operableVideoNetworkStateTipView == null || !operableVideoNetworkStateTipView.d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.play.TbVideoViewContainer.a
    public void onSurfaceDestroyed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && !this.d0) {
            int i2 = this.p;
            if (i2 != this.g && (i2 != this.h || this.t.getControl().isPlaying())) {
                if (this.p == this.i) {
                    v0();
                    o0(this.i);
                    return;
                }
                v0();
                return;
            }
            v0();
            o0(this.g);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.S = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.t.getControl().Q();
            this.F.n();
            o0(this.b);
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }

    @Override // com.baidu.tieba.pb8
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            if (z) {
                this.y0 = isPlaying();
                this.w.cancelAnimation();
                int i2 = this.p;
                if (i2 == this.d || i2 == this.e || i2 == this.f || i2 == this.b || i2 == this.n || i2 == this.o || i2 == this.c) {
                    stopPlay();
                }
                int i3 = this.p | 1;
                this.p = i3;
                int i4 = i3 & (-8193);
                this.p = i4;
                o0(i4);
            } else {
                int i5 = this.p;
                if (i5 == this.b || i5 == this.c || i5 == this.o || i5 == this.m) {
                    if (this.y0) {
                        startPlay();
                        l0();
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // com.baidu.tieba.pb8
    public void startPlay() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || StringUtils.isNull(this.U)) {
            return;
        }
        MessageManager.getInstance().registerListener(this.M0);
        if (i0()) {
            o0(this.j);
            return;
        }
        this.S = true;
        if (this.t.getControl().isPlaying()) {
            return;
        }
        TbVideoViewContainer d2 = TbVideoViewSet.c().d(this.U);
        if (d2 == null) {
            this.t.a();
            if (!StringUtils.isNull(this.t.getControl().getOriginUrl()) || UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.O);
                this.t = tbVideoViewContainer;
                tbVideoViewContainer.getControl().setTryUseViewInSet(true);
            }
            q0();
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                this.t.getControl().setVideoPath(this.U, this.V);
                this.t.getControl().setStageType(this.e0);
                r0();
                if (this.c0) {
                    u0();
                }
            }
        } else {
            TbVideoViewContainer tbVideoViewContainer2 = this.t;
            if (tbVideoViewContainer2 == d2) {
                tbVideoViewContainer2.a();
                q0();
            } else {
                if (UbsABTestHelper.isFeedVideoImmersionTransition() && (TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() || TbSingleton.getInstance().getIsJumpFromVideoMiddleView().booleanValue())) {
                    this.t.a();
                    this.t = new TbVideoViewContainer(this.O);
                    TbVideoViewSet.c().e(this.U);
                    this.g0 = true;
                    TbSingleton.getInstance().setIsJumpFromVideoMiddleView(false);
                } else {
                    this.t.a();
                    d2.a();
                    this.t = d2;
                }
                this.t.getControl().setTryUseViewInSet(true);
                q0();
                if (TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
            }
            this.t.getControl().G();
            onPrepared();
            s0();
            if (this.c0) {
                u0();
            }
        }
        if (this.c0) {
            StatisticItem param = new StatisticItem("c13357").param("tid", this.V).param("fid", this.W);
            int i3 = 2;
            if (this.T) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            StatisticItem param2 = param.param("obj_type", i2);
            if (TbSingleton.getInstance().isVideoCardMute()) {
                i3 = 1;
            }
            TiebaStatic.log(param2.param("obj_source", i3).param("obj_locate", 1));
        }
    }

    @Override // com.baidu.tieba.pb8
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            this.S = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            if ((this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof eb8)) {
                if (this.t.getControl().isPlaying()) {
                    this.t.getControl().Q();
                } else {
                    this.t.getControl().stopPlayback();
                }
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && TbSingleton.getInstance().getIsNeedReuseVideoPlayer() && !TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && this.U != null && (this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof eb8)) {
                this.t.getControl().O();
                if (this.u != null && TbSingleton.getInstance().getVideoCurrentFrame() != null) {
                    this.u.setImageBitmap(TbSingleton.getInstance().getVideoCurrentFrame());
                    TbSingleton.getInstance().setVideoCurrentFrame(null);
                }
                ((eb8) this.t.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
                TbVideoViewSet.c().e(this.U);
                this.g0 = true;
            }
            this.t.a();
            this.F.n();
            if (this.g0) {
                o0(this.o);
                this.g0 = false;
            } else {
                o0(this.b);
            }
            MessageManager.getInstance().unRegisterListener(this.M0);
        }
    }
}
