package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.svg.SvgPureType;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.bz9;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.titan.sdk.verifier.ApkSignatureSchemeV2Verifier;
import java.lang.ref.WeakReference;
import tbclient.McnAdInfo;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
/* loaded from: classes8.dex */
public class xz9 implements uz9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public int A0;
    public TextView B;
    public float B0;
    public TextView C;
    public int C0;
    public SwitchImageView D;
    public boolean D0;
    public SwitchImageView E;
    public boolean E0;
    public OperableVideoMediaControllerView F;
    public View.OnClickListener F0;
    public OperableVideoNetworkStateTipView G;
    public we0 G0;
    public OperableVideoShareView H;
    public McnAdInfo H0;
    public ImageView I;
    public boolean I0;
    public View J;
    public r J0;
    public VideoGestureView K;
    public long K0;
    public View L;
    public bz9.c L0;
    public OperableVideoErrorView M;
    public CustomMessageListener M0;
    public WeakReference<Context> N;
    public boolean N0;
    public View O;
    public SeekBar.OnSeekBarChangeListener O0;
    public TextView P;
    public GestureDetector.SimpleOnGestureListener P0;
    public TextView Q;
    public View.OnTouchListener Q0;
    public TextView R;
    public TbVideoViewSet.b R0;
    public Context S;
    public final CustomMessageListener S0;

    /* renamed from: T  reason: collision with root package name */
    public View f1186T;
    public final CustomMessageListener T0;
    public ViewGroup U;
    public BdUniqueId V;
    public boolean W;
    public boolean X;
    public String Y;
    public String Z;
    public int a;
    public long a0;
    public int b;
    public gz9 b0;
    public int c;
    public boolean c0;
    public int d;
    public pz9 d0;
    public int e;
    public ThreadData e0;
    public int f;
    public String f0;
    public int g;
    public boolean g0;
    public int h;
    public boolean h0;
    public int i;
    public String i0;
    public int j;
    public boolean j0;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean r0;
    public Runnable s;
    public float s0;
    public TbVideoViewContainer t;
    public float t0;
    public TbImageView u;
    public GestureDetector u0;
    public View v;
    public int v0;
    public TBLottieAnimationView w;
    public int[] w0;
    public ImageView x;
    public int x0;
    public ImageView y;
    public boolean y0;
    public PercentSizeView z;
    public int z0;

    /* loaded from: classes8.dex */
    public interface r {
        void a(int i, int i2);
    }

    public void D0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? R.layout.operable_video_container : invokeV.intValue;
    }

    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.uz9
    public void onScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
    }

    @Override // com.baidu.tieba.uz9
    public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, onClickListener) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

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

        public a(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.U.setScaleX(1.0f);
                this.a.U.setScaleY(1.0f);
                this.a.U.setTranslationX(0.0f);
                this.a.U.setTranslationY(0.0f);
                this.a.H.setScaleX(1.0f);
                this.a.H.setScaleY(1.0f);
                this.a.U.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                if (!this.a.y0) {
                    this.a.a0();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            }
        }

        public b(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                xz9 xz9Var = this.a;
                xz9Var.x0(xz9Var.f);
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds18));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb_pressed));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) && seekBar != null && seekBar.getProgress() < seekBar.getMax()) {
                seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                seekBar.setThumb(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.operable_video_seekbar_thumb));
                if (!this.a.t.getControl().isPlaying()) {
                    this.a.t.getControl().S(this.a.R0);
                }
                this.a.Y();
                if (this.a.g0) {
                    StatisticItem param = new StatisticItem("c13355").param("tid", this.a.Z).param("fid", this.a.a0);
                    int i2 = 1;
                    if (this.a.X) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    StatisticItem param2 = param.param("obj_type", i);
                    if (!this.a.c0) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param2.param("obj_locate", i2));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public c(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048579, this, motionEvent)) != null) {
                return invokeL.booleanValue;
            }
            this.a.q = 0;
            xz9 xz9Var = this.a;
            if (xz9Var.c0) {
                xz9Var.X((Activity) xz9Var.S, true);
            }
            return super.onDown(motionEvent);
        }

        public final void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.z0 == i2 && this.a.A0 == i) {
                    return;
                }
                xz9 xz9Var = this.a;
                if (xz9Var.z0 - i2 <= 0 && i2 >= this.a.s0 / 6.0f) {
                    z = false;
                } else {
                    z = true;
                }
                xz9Var.y0 = z;
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.U.getLayoutParams();
                if (i2 != this.a.z0) {
                    int i3 = this.a.x0 - i2;
                    int i4 = (int) (i3 * this.a.B0);
                    if (i4 < this.a.C0) {
                        i4 = this.a.C0;
                        i3 = (int) (i4 / this.a.B0);
                    }
                    if (i4 != this.a.C0) {
                        layoutParams.height = i3;
                        layoutParams.width = i4;
                        this.a.U.setLayoutParams(layoutParams);
                    }
                    this.a.z0 = i2;
                    xz9 xz9Var2 = this.a;
                    xz9Var2.U.setTranslationY(xz9Var2.z0);
                }
                if (i != this.a.z0) {
                    this.a.A0 = i;
                    xz9 xz9Var3 = this.a;
                    xz9Var3.U.setTranslationX(xz9Var3.A0 + ((this.a.t0 - layoutParams.width) / 2.0f));
                }
                this.a.L.setAlpha((layoutParams.width - this.a.C0) / (this.a.t0 - this.a.C0));
                if (this.a.H.getVisibility() == 0) {
                    float f = this.a.s0 / 6.0f;
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
                    xz9.z(this.a, 1000);
                    z = true;
                } else {
                    xz9.y(this.a, 1000);
                    z = false;
                }
                int duration = this.a.t.getControl().getDuration();
                if (this.a.v0 < 0) {
                    this.a.v0 = 0;
                } else if (this.a.v0 > duration) {
                    this.a.v0 = duration;
                }
                String str = StringHelper.stringForVideoTime(this.a.v0) + " / " + StringHelper.stringForVideoTime(duration);
                VideoGestureView videoGestureView = this.a.K;
                if (videoGestureView != null) {
                    videoGestureView.b(z, str);
                }
                xz9 xz9Var = this.a;
                xz9Var.F.setCurrentDuration(xz9Var.v0, false);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
                if (this.a.t.getControl().isPlaying()) {
                    xz9 xz9Var = this.a;
                    int i = xz9Var.p;
                    int i2 = xz9Var.d;
                    if (i != i2 && i != xz9Var.e && i != xz9Var.n) {
                        if (i == xz9Var.f) {
                            xz9Var.x0(i2);
                        }
                    } else {
                        xz9 xz9Var2 = this.a;
                        xz9Var2.x0(xz9Var2.f);
                        this.a.Y();
                    }
                } else {
                    xz9 xz9Var3 = this.a;
                    int i3 = xz9Var3.p;
                    int i4 = xz9Var3.g;
                    if (i3 == i4) {
                        xz9Var3.x0(xz9Var3.h);
                    } else if (i3 == (i4 | 1)) {
                        xz9Var3.x0(xz9Var3.h | 1);
                    } else {
                        int i5 = xz9Var3.h;
                        if (i3 == i5) {
                            xz9Var3.x0(i4);
                        } else if (i3 == (i5 | 1)) {
                            xz9Var3.x0(i4 | 1);
                        } else {
                            xz9Var3.x0(xz9Var3.b);
                            this.a.startPlay();
                            this.a.s0();
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
                    xz9 xz9Var = this.a;
                    if (xz9Var.p == xz9Var.f) {
                        xz9Var.x0(xz9Var.g);
                    } else {
                        xz9Var.x0(xz9Var.h);
                    }
                    this.a.D0(R.id.video_pause);
                    return true;
                }
                xz9 xz9Var2 = this.a;
                int i = xz9Var2.p;
                int i2 = xz9Var2.g;
                if (i != i2 && i != (i2 | 1)) {
                    int i3 = xz9Var2.h;
                    if (i != i3 && i != (i3 | 1)) {
                        return true;
                    }
                    xz9 xz9Var3 = this.a;
                    xz9Var3.x0(xz9Var3.d);
                    this.a.t.getControl().S(this.a.R0);
                    this.a.D0(R.id.video_play);
                    return true;
                }
                xz9 xz9Var4 = this.a;
                xz9Var4.x0(xz9Var4.f);
                this.a.Y();
                this.a.t.getControl().S(this.a.R0);
                this.a.D0(R.id.video_play);
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
                if (!this.a.k0(motionEvent)) {
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                Context context = this.a.S;
                if ((context instanceof BaseFragmentActivity) && ((BaseFragmentActivity) context).isSwipeBackEnabled()) {
                    ((BaseFragmentActivity) this.a.S).disableSwipeJustOnce();
                } else {
                    Context context2 = this.a.S;
                    if ((context2 instanceof BaseActivity) && ((BaseActivity) context2).isSwipeBackEnabled()) {
                        ((BaseActivity) this.a.S).disableSwipeJustOnce();
                    }
                }
                xz9 xz9Var = this.a;
                if (xz9Var.X && xz9Var.l0()) {
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
                            xz9 xz9Var2 = this.a;
                            xz9Var2.x0(xz9Var2.l);
                        }
                        this.a.q = 4;
                        xz9 xz9Var3 = this.a;
                        xz9Var3.r = xz9Var3.p;
                        xz9 xz9Var4 = this.a;
                        xz9Var4.p = xz9Var4.k;
                        xz9Var4.x0 = xz9Var4.U.getMeasuredHeight();
                        xz9 xz9Var5 = this.a;
                        xz9Var5.B0 = xz9Var5.t0 / this.a.x0;
                        xz9 xz9Var6 = this.a;
                        xz9Var6.C0 = (int) (xz9Var6.f1186T.getWidth() * 1.2f);
                        a(rawX, rawY);
                    }
                } else {
                    xz9 xz9Var7 = this.a;
                    int i4 = xz9Var7.p;
                    boolean z = true;
                    if (i4 == xz9Var7.d || i4 == xz9Var7.f || i4 == (i = xz9Var7.g) || i4 == (i2 = xz9Var7.h) || i4 == xz9Var7.k || i4 == (i | 1) || i4 == (i2 | 1)) {
                        int i5 = this.a.q;
                        boolean z2 = false;
                        if (i5 != 0) {
                            if (i5 != 1) {
                                if (i5 != 2) {
                                    if (i5 == 3) {
                                        b(f);
                                    }
                                } else {
                                    xz9 xz9Var8 = this.a;
                                    VideoGestureView videoGestureView = xz9Var8.K;
                                    Context context3 = xz9Var8.S;
                                    if (f2 <= 0.0f) {
                                        z = false;
                                    }
                                    videoGestureView.a(context3, z);
                                }
                            } else {
                                xz9 xz9Var9 = this.a;
                                VideoGestureView videoGestureView2 = xz9Var9.K;
                                Context context4 = xz9Var9.S;
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
                                xz9 xz9Var10 = this.a;
                                xz9Var10.v0 = xz9Var10.t.getControl().getCurrentPosition();
                                b(f);
                            } else if (motionEvent.getX() < this.a.U.getWidth() / 2) {
                                this.a.q = 2;
                                xz9 xz9Var11 = this.a;
                                VideoGestureView videoGestureView3 = xz9Var11.K;
                                Context context5 = xz9Var11.S;
                                if (f2 > 0.0f) {
                                    z2 = true;
                                }
                                videoGestureView3.a(context5, z2);
                            } else {
                                this.a.q = 1;
                                xz9 xz9Var12 = this.a;
                                VideoGestureView videoGestureView4 = xz9Var12.K;
                                Context context6 = xz9Var12.S;
                                if (f2 > 0.0f) {
                                    z2 = true;
                                }
                                videoGestureView4.c(context6, z2);
                            }
                            xz9 xz9Var13 = this.a;
                            int i7 = xz9Var13.p;
                            int i8 = xz9Var13.k;
                            if (i7 != i8) {
                                if ((i7 & 1) > 0) {
                                    xz9Var13.k = i8 | 1;
                                } else {
                                    xz9Var13.k = i8 & (-2);
                                }
                                xz9 xz9Var14 = this.a;
                                xz9Var14.x0(xz9Var14.k);
                            }
                        }
                    }
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public d(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                    xz9 xz9Var = this.a;
                    if (xz9Var.p == xz9Var.k) {
                        if (xz9Var.q == 4) {
                            this.a.Z();
                            this.a.z0 = 0;
                            this.a.A0 = 0;
                        } else {
                            xz9 xz9Var2 = this.a;
                            xz9Var2.p = -1;
                            if (xz9Var2.q != 3) {
                                if (this.a.r != -1) {
                                    xz9 xz9Var3 = this.a;
                                    xz9Var3.x0(xz9Var3.r);
                                    this.a.r = -1;
                                } else if (this.a.t.getControl().isPlaying()) {
                                    xz9 xz9Var4 = this.a;
                                    xz9Var4.x0(xz9Var4.d);
                                } else {
                                    xz9 xz9Var5 = this.a;
                                    xz9Var5.x0(xz9Var5.g);
                                }
                            } else {
                                xz9 xz9Var6 = this.a;
                                xz9Var6.F.setCurrentDuration(xz9Var6.v0, true);
                                if (this.a.v0 <= this.a.t.getControl().getDuration()) {
                                    if (!this.a.t.getControl().isPlaying()) {
                                        this.a.t.getControl().S(this.a.R0);
                                    }
                                    xz9 xz9Var7 = this.a;
                                    xz9Var7.x0(xz9Var7.d);
                                }
                            }
                        }
                        xz9 xz9Var8 = this.a;
                        if (xz9Var8.g0) {
                            String str = null;
                            if (xz9Var8.q == 1) {
                                str = "c13361";
                            } else if (this.a.q == 2) {
                                str = "c13346";
                            } else if (this.a.q == 3) {
                                str = "c13362";
                            }
                            if (!ei.isEmpty(str)) {
                                TiebaStatic.log(new StatisticItem(str).param("tid", this.a.Z).param("fid", this.a.a0));
                            }
                        }
                        this.a.q = 0;
                        return true;
                    }
                }
                return this.a.u0.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public e(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.r0) {
                    xz9 xz9Var = this.a;
                    xz9Var.x0(xz9Var.o);
                    this.a.r0 = false;
                } else {
                    xz9 xz9Var2 = this.a;
                    xz9Var2.x0(xz9Var2.b);
                }
                this.a.B0();
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.t.a();
                this.a.z0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(xz9 xz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, Integer.valueOf(i)};
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
            this.a = xz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage.getCmd() != 2000994 || !(customResponsedMessage instanceof NetWorkChangedMessage)) {
                return;
            }
            this.a.stopPlay();
        }
    }

    /* loaded from: classes8.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(xz9 xz9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, Integer.valueOf(i)};
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
            this.a = xz9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921821) {
                this.a.j0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public h(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xz9 xz9Var = this.a;
                xz9Var.x0(xz9Var.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements bz9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public i(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // com.baidu.tieba.bz9.c
        public void a(int i, int i2) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.a.K0 <= 0) {
                    this.a.K0 = i2;
                }
                if (this.a.m0()) {
                    xz9 xz9Var = this.a;
                    if (!xz9Var.X && !xz9Var.c0 && xz9Var.I0) {
                        if (ve0.b().a(this.a.H0.jump_url)) {
                            return;
                        }
                        long j = i2;
                        boolean z2 = true;
                        if (j >= this.a.H0.ad_start_time.longValue() * 1000 && j < this.a.H0.ad_end_time.longValue() * 1000) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (this.a.K0 < (this.a.H0.ad_start_time.longValue() * 1000) + 1000) {
                            z2 = false;
                        }
                        if (this.a.G0 == null) {
                            xz9 xz9Var2 = this.a;
                            xz9Var2.G0 = new we0(xz9Var2.S);
                        }
                        if (z) {
                            if (!this.a.G0.b()) {
                                ue0 ue0Var = new ue0();
                                ue0Var.b = this.a.H0.card_title;
                                ue0Var.c = this.a.H0.button_title;
                                ue0Var.d = this.a.H0.jump_url;
                                ue0Var.a = this.a.H0.pic_url;
                                ue0Var.f = String.valueOf(this.a.a0);
                                xz9 xz9Var3 = this.a;
                                ue0Var.e = xz9Var3.Z;
                                ue0Var.g = xz9Var3.h0();
                                if (z2) {
                                    this.a.G0.e(ue0Var, (ViewGroup) this.a.f1186T);
                                } else {
                                    this.a.G0.d(ue0Var, (ViewGroup) this.a.f1186T);
                                }
                            }
                        } else if (this.a.G0.b()) {
                            this.a.G0.a();
                        }
                    }
                }
                if (this.a.J0 != null) {
                    this.a.J0.a(i, i2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

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

        public j(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
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

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public k(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public l(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p0();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends jz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ xz9 b;

        public m(xz9 xz9Var, TiebaPlusInfo tiebaPlusInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, tiebaPlusInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz9Var;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tieba.jz5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            TbPageContext<?> currentPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                super.onClick(view2);
                if (StringUtils.isNotNull(this.a.app_power) && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(this.b.S)) != null) {
                    UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{this.a.app_power});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends jz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ xz9 b;

        public n(xz9 xz9Var, TiebaPlusInfo tiebaPlusInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, tiebaPlusInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz9Var;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tieba.jz5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            TbPageContext<?> currentPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                super.onClick(view2);
                if (StringUtils.isNotNull(this.a.app_privacy) && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(this.b.S)) != null) {
                    UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{this.a.app_privacy});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends jz5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TiebaPlusInfo a;
        public final /* synthetic */ xz9 b;

        public o(xz9 xz9Var, TiebaPlusInfo tiebaPlusInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, tiebaPlusInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = xz9Var;
            this.a = tiebaPlusInfo;
        }

        @Override // com.baidu.tieba.jz5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            TbPageContext<?> currentPageContext;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                super.onClick(view2);
                if (StringUtils.isNotNull(this.a.app_effect) && (currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(this.b.S)) != null) {
                    UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{this.a.app_effect});
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

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

        public p(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
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
                this.a.T();
                if (!this.a.W) {
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<xz9> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(int i, xz9 xz9Var) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), xz9Var};
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
            this.a = new WeakReference<>(xz9Var);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            xz9 xz9Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || (xz9Var = this.a.get()) == null) {
                return;
            }
            xz9Var.q0(customResponsedMessage);
        }
    }

    public xz9(Context context, View view2) {
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
        this.s = new h(this);
        this.N = null;
        this.c0 = false;
        this.g0 = true;
        this.h0 = false;
        this.j0 = true;
        this.r0 = false;
        this.w0 = new int[2];
        this.z0 = 0;
        this.A0 = 0;
        this.D0 = false;
        this.E0 = false;
        this.F0 = null;
        this.I0 = false;
        this.K0 = -1L;
        this.L0 = new i(this);
        this.M0 = new q(2921683, this);
        this.O0 = new b(this);
        this.P0 = new c(this);
        this.Q0 = new d(this);
        this.R0 = new e(this);
        this.S0 = new f(this, 2000994);
        this.T0 = new g(this, 2921821);
        if (context != null && view2 != null) {
            this.S = context;
            this.b0 = new gz9((Activity) context);
            this.f1186T = view2;
            this.s0 = BdUtilHelper.getEquipmentHeight(this.S);
            this.t0 = BdUtilHelper.getEquipmentWidth(this.S);
            i0();
        }
    }

    public final void A0(SpannableString spannableString) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, spannableString) != null) || this.R == null) {
            return;
        }
        if (TextUtils.isEmpty(spannableString)) {
            this.R.setVisibility(8);
            return;
        }
        this.R.setVisibility(4);
        this.R.setText(spannableString);
    }

    @Override // com.baidu.tieba.uz9
    public void changeRenderViewMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.t.getControl().w(i2);
        }
    }

    public void d0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                this.b0.i(true);
            } else {
                this.b0.i(false);
            }
        }
    }

    public void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                this.b0.j();
            } else {
                this.b0.k();
            }
        }
    }

    public boolean k0(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, motionEvent)) == null) {
            return this.c0;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.uz9
    public void setAfterClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, onClickListener) == null) {
            this.F0 = onClickListener;
        }
    }

    @Override // com.baidu.tieba.uz9
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.f0 = str;
        }
    }

    @Override // com.baidu.tieba.uz9
    public void setStageType(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
            this.i0 = str;
        }
    }

    @Override // com.baidu.tieba.uz9
    public void setStatistic(pz9 pz9Var) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, pz9Var) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getControl() != null) {
            this.d0 = pz9Var;
            this.t.getControl().setVideoStatData(pz9Var);
        }
    }

    @Override // com.baidu.tieba.uz9
    public void setUniqueId(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, bdUniqueId) == null) {
            this.V = bdUniqueId;
        }
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.I0 = z;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.E0 = z;
        }
    }

    public static /* synthetic */ int y(xz9 xz9Var, int i2) {
        int i3 = xz9Var.v0 + i2;
        xz9Var.v0 = i3;
        return i3;
    }

    public static /* synthetic */ int z(xz9 xz9Var, int i2) {
        int i3 = xz9Var.v0 - i2;
        xz9Var.v0 = i3;
        return i3;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048613, this, i2, i3, obj)) == null) {
            x0(this.m);
            return false;
        }
        return invokeIIL.booleanValue;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048614, this, i2, i3, obj)) == null) {
            if (i2 == 3 || i2 == 904) {
                C0();
            }
            if (i2 == 701) {
                this.j0 = true;
                B0();
                return false;
            } else if (i2 == 702) {
                C0();
                return false;
            } else {
                return false;
            }
        }
        return invokeIIL.booleanValue;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.j0) {
                this.w.setAlpha(1.0f);
                this.w.setVisibility(0);
                this.x.setVisibility(8);
            } else {
                this.w.setVisibility(8);
                this.x.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null && this.j0) {
                tBLottieAnimationView.loop(true);
                this.w.setMinAndMaxFrame(14, 80);
                this.w.playAnimation();
            }
        }
    }

    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
            if (isVideoCardMute) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                VideoAudioHelper.muteAudioFocus(this.N, true);
                cq5.b().l(true);
                this.D.setState(0);
            } else {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                VideoAudioHelper.muteAudioFocus(this.N, false);
                cq5.b().l(false);
            }
            TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            j0();
            if (this.W) {
                if (this.c0) {
                    Context context = this.S;
                    if (context instanceof Activity) {
                        X((Activity) context, true);
                    }
                }
                if (this.X) {
                    this.t.getControl().setVideoScalingMode(0);
                } else {
                    this.t.getControl().setVideoScalingMode(2);
                }
                this.t.getControl().S(this.R0);
            }
        }
    }

    @Override // com.baidu.tieba.uz9
    public boolean onVolumeUp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (TbSingleton.getInstance().isVideoCardMute() && this.t.getControl().isPlaying() && !VideoAudioHelper.isBGMPlaying() && !cq5.b().j() && !VideoAudioHelper.isPlayVoicePlaying) {
                this.t.getControl().setVolume(1.0f, 1.0f);
                this.D.setState(0);
                TbSingleton.getInstance().setVideoCardMute(false);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (TbSingleton.getInstance().getVideoCover() != null && TbSingleton.getInstance().getVideoCover().c() && StringUtils.equalsIgnoreNull(TbSingleton.getInstance().getVideoCover().b(), this.Y)) {
                this.u.setImageBitmap(TbSingleton.getInstance().getVideoCover().a());
            }
            TbSingleton.getInstance().setVideoCover(null);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            x0(this.n);
            this.F.t();
            f0();
        }
    }

    public void E0() {
        pz9 pz9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (pz9Var = this.d0) != null) {
            pz9 b2 = pz9Var.b();
            b2.a = this.f0;
            ez9.e(b2.m, "", "1", b2, this.t.getControl().getPcdnState());
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.N0 && TbSingleton.getInstance().getVideoCover() != null) {
                this.N0 = false;
                SafeHandler.getInst().post(new l(this));
                return;
            }
            this.N0 = false;
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.p;
            if (i2 == this.e || i2 == this.n) {
                x0(this.d);
            }
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.s);
            SafeHandler.getInst().postDelayed(this.s, this.a);
        }
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b0(true);
        }
    }

    @Override // com.baidu.tieba.uz9
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.t.getControl().getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.uz9
    public View getMainView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.U;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.uz9
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.c0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uz9
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (!this.W && !this.t.getControl().isPlaying()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.X && this.c0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.H0 != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.uz9
    public boolean onBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.c0) {
                Z();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void onCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            x0(this.i);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.s);
        }
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921387, this.Y);
            CustomMessage customMessage = new CustomMessage(2921387);
            customMessage.setTag(this.V);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.U.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.U.setSystemUiVisibility(4);
            } else {
                this.U.setSystemUiVisibility(5894);
            }
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.W = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            this.t.getControl().T();
            this.F.q();
            x0(this.b);
            MessageManager.getInstance().unRegisterListener(this.S0);
            MessageManager.getInstance().unRegisterListener(this.T0);
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.F.t();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.clearAnimation();
                this.w.animate().alpha(0.0f).setDuration(200L).setListener(new p(this)).start();
            }
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (TbSingleton.getInstance().isVideoCardMute()) {
                this.t.getControl().setVolume(0.0f, 0.0f);
                this.D.setState(1);
                return;
            }
            this.t.getControl().setVolume(1.0f, 1.0f);
            this.D.setState(0);
            cq5.b().l(true);
        }
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.E0) {
                return false;
            }
            if (UbsABTestHelper.isVideoTabAutoPlay() && "video_tab".equals(this.f0)) {
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
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && !this.h0) {
            int i2 = this.p;
            if (i2 != this.g && (i2 != this.h || this.t.getControl().isPlaying())) {
                if (this.p == this.i) {
                    F0();
                    x0(this.i);
                    return;
                }
                F0();
                return;
            }
            F0();
            x0(this.g);
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.X && !"video_tab".equals(this.f0)) {
                this.f = 104;
                this.g = 8290;
            } else {
                this.f = 232;
                this.g = 8418;
            }
            if (this.c0) {
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

    public void W() {
        float dimension;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.G.a(this.X, this.c0);
            this.H.e(this.X, this.c0);
            Context context = this.S;
            if (context != null && context.getResources() != null) {
                if (this.X) {
                    dimension = this.S.getResources().getDimension(R.dimen.tbds44);
                } else if (this.c0) {
                    dimension = this.S.getResources().getDimension(R.dimen.tbds78);
                } else {
                    dimension = this.S.getResources().getDimension(R.dimen.tbds44);
                }
                int i3 = (int) dimension;
                if ("video_tab".equals(this.f0)) {
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

    public void z0() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048639, this) == null) && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            this.U.addView(this.t, 0);
            this.t.setLayoutParams(layoutParams);
            this.F.setPlayer(this.t.getControl());
            this.t.getControl().setContinuePlayEnable(true);
            this.t.getControl().setOperableVideoContainer(this);
            this.t.getControl().setOnSurfaceDestroyedListener(this);
            this.t.getControl().setVideoStatData(this.d0);
            this.t.getControl().setThreadDataForStatistic(this.e0);
            this.t.getControl().getMediaProgressObserver().j(this.L0);
        }
    }

    public final void X(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048586, this, activity, z) == null) && activity != null && activity.getWindow() != null) {
            if (this.X && (TbSingleton.getInstance().isNotchScreen(activity) || TbSingleton.getInstance().isCutoutScreen(activity))) {
                ViewGroup viewGroup = this.U;
                if (viewGroup == null) {
                    return;
                }
                if (z) {
                    viewGroup.setPadding(0, BdUtilHelper.getStatusBarHeight((Activity) this.S), 0, 0);
                } else {
                    viewGroup.setPadding(0, 0, 0, 0);
                }
            } else if (z) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                y0();
            } else {
                WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
                attributes2.flags &= -1025;
                activity.getWindow().setAttributes(attributes2);
                this.U.setSystemUiVisibility(0);
            }
        }
    }

    public final void Z() {
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
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!this.X) {
                a0();
            } else if (this.p == this.k) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.addListener(new a(this));
                if (!this.y0) {
                    float width = this.f1186T.getWidth() / this.U.getWidth();
                    float height = this.f1186T.getHeight() / this.U.getHeight();
                    this.U.setPivotX(0.0f);
                    this.U.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.U, "ScaleX", 1.0f, width);
                    objectAnimator = ObjectAnimator.ofFloat(this.U, "ScaleY", 1.0f, height);
                    ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width);
                    ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height);
                    ViewGroup viewGroup = this.U;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup, "TranslationX", viewGroup.getTranslationX(), this.w0[0]);
                    ViewGroup viewGroup2 = this.U;
                    ofFloat5 = ObjectAnimator.ofFloat(viewGroup2, "TranslationY", viewGroup2.getTranslationY(), this.w0[1]);
                    View view2 = this.L;
                    ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(view2, Key.ALPHA, view2.getAlpha(), 0.0f);
                    OperableVideoShareView operableVideoShareView = this.H;
                    ofFloat6 = ObjectAnimator.ofFloat(operableVideoShareView, Key.ALPHA, operableVideoShareView.getAlpha(), 0.0f);
                    ofFloat2 = ofFloat7;
                    objectAnimator2 = ofFloat9;
                    ofFloat3 = ofFloat8;
                } else {
                    float width2 = this.t0 / this.U.getWidth();
                    float height2 = this.x0 / this.U.getHeight();
                    this.U.setPivotX(0.0f);
                    this.U.setPivotY(0.0f);
                    ofFloat = ObjectAnimator.ofFloat(this.U, "ScaleX", 1.0f, width2);
                    ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.U, "ScaleY", 1.0f, height2);
                    ofFloat2 = ObjectAnimator.ofFloat(this.H, "ScaleX", 1.0f, 1.0f / width2);
                    ofFloat3 = ObjectAnimator.ofFloat(this.H, "ScaleY", 1.0f, 1.0f / height2);
                    ViewGroup viewGroup3 = this.U;
                    ofFloat4 = ObjectAnimator.ofFloat(viewGroup3, "TranslationX", viewGroup3.getTranslationX(), 0.0f);
                    ViewGroup viewGroup4 = this.U;
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
                        this.t.getControl().S(this.R0);
                        x0(this.d);
                    }
                }
            } else {
                a0();
            }
        }
    }

    public void b0(boolean z) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && this.f1186T != null && this.U != null && (tbVideoViewContainer = this.t) != null && tbVideoViewContainer.getControl() != null) {
            Context context = this.S;
            if (context != null) {
                BdUtilHelper.hideSoftKeyPad(context, this.f1186T);
            }
            int i2 = 1;
            if (this.c0) {
                if (this.L.getParent() instanceof ViewGroup) {
                    ((ViewGroup) this.L.getParent()).removeView(this.L);
                }
                if ((this.U.getParent() instanceof ViewGroup) && (this.f1186T instanceof ViewGroup)) {
                    this.c0 = false;
                    this.h0 = true;
                    ((ViewGroup) this.U.getParent()).removeView(this.U);
                    ((ViewGroup) this.f1186T).addView(this.U);
                    this.h0 = false;
                    X((Activity) this.S, this.c0);
                }
                if (!this.X && z) {
                    this.b0.l();
                }
            } else {
                if (this.S != null) {
                    if (!this.X && z) {
                        this.b0.l();
                    }
                    if (this.S instanceof Activity) {
                        this.U.getLocationOnScreen(this.w0);
                        View findViewById = ((Activity) this.S).findViewById(16908290);
                        if (findViewById instanceof ViewGroup) {
                            View childAt = ((ViewGroup) findViewById).getChildAt(0);
                            if (childAt instanceof ViewGroup) {
                                this.h0 = true;
                                ((ViewGroup) this.f1186T).removeAllViews();
                                if (this.L == null) {
                                    View view2 = new View(this.S);
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
                                viewGroup.addView(this.U);
                                this.h0 = false;
                                this.c0 = true;
                                X((Activity) this.S, true);
                                we0 we0Var = this.G0;
                                if (we0Var != null && we0Var.b()) {
                                    this.G0.a();
                                }
                            }
                        }
                    }
                }
                TbSingleton.getInstance().setIsJumpFromVideoMiddleView(false);
                if (this.g0) {
                    StatisticItem param = new StatisticItem("c13360").param("tid", this.Z).param("fid", this.a0);
                    if (!this.X) {
                        i2 = 2;
                    }
                    TiebaStatic.log(param.param("obj_type", i2));
                }
            }
            U();
            W();
            if (this.t.getControl().isPlaying()) {
                x0(this.d);
            } else {
                x0(this.p);
            }
            this.E.b();
            o0(this.c0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048611, this, view2) != null) || view2 == null) {
            return;
        }
        int id = view2.getId();
        D0(id);
        if (id == R.id.video_mute) {
            c0();
        } else if (id != R.id.video_full_screen && id != R.id.video_full_screen_back) {
            int i5 = 1;
            int i6 = 2;
            if (id == R.id.video_replay) {
                x0(this.b);
                startPlay();
                if (this.g0) {
                    StatisticItem param = new StatisticItem("c13345").param("tid", this.Z).param("fid", this.a0);
                    if (this.X) {
                        i4 = 1;
                    } else {
                        i4 = 2;
                    }
                    StatisticItem param2 = param.param("obj_type", i4);
                    if (!this.c0) {
                        i5 = 2;
                    }
                    TiebaStatic.log(param2.param("obj_locate", i5));
                }
                s0();
            } else if (id == R.id.video_play) {
                int i7 = this.p;
                if (i7 != this.b && i7 != this.c && i7 != this.o) {
                    x0(this.f);
                    Y();
                    this.t.getControl().S(this.R0);
                } else {
                    startPlay();
                }
                if (this.g0) {
                    StatisticItem param3 = new StatisticItem("c13344").param("tid", this.Z).param("fid", this.a0);
                    if (this.X) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    StatisticItem param4 = param3.param("obj_type", i3);
                    if (this.c0) {
                        i6 = 1;
                    }
                    TiebaStatic.log(param4.param("obj_source", i6).param("obj_locate", 1));
                }
                s0();
            } else if (id == R.id.video_pause) {
                x0(this.g);
                r0();
                this.t.getControl().pause();
                if (this.g0) {
                    StatisticItem param5 = new StatisticItem("c13344").param("tid", this.Z).param("fid", this.a0);
                    if (this.X) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    StatisticItem param6 = param5.param("obj_type", i2);
                    if (!this.c0) {
                        i5 = 2;
                    }
                    TiebaStatic.log(param6.param("obj_source", i5).param("obj_locate", 2));
                }
            } else if (id == R.id.obfuscated_res_0x7f091cd9) {
                x0(this.b);
                startPlay();
            } else if (id == R.id.obfuscated_res_0x7f091f3a) {
                x0(this.b);
                startPlay();
            }
        } else {
            Z();
        }
    }

    @Override // com.baidu.tieba.uz9
    public void setData(ThreadData threadData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, threadData) == null) && threadData != null && threadData.getThreadVideoInfo() != null) {
            this.K0 = -1L;
            we0 we0Var = this.G0;
            if (we0Var != null) {
                we0Var.c();
            }
            if (StringHelper.equals(this.Y, threadData.getThreadVideoInfo().video_url)) {
                return;
            }
            stopPlay();
            if (threadData.getThreadVideoInfo().is_vertical.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.X = z;
            this.Y = threadData.getThreadVideoInfo().video_url;
            this.Z = threadData.getTid();
            threadData.getThreadVideoInfo().video_length.intValue();
            threadData.getThreadVideoInfo().video_duration.intValue();
            this.a0 = threadData.getFid();
            this.H0 = threadData.getThreadVideoInfo().mcn_ad_card;
            U();
            W();
            x0(this.b);
            int intValue = threadData.getThreadVideoInfo().video_duration.intValue() * 1000;
            this.F.m(intValue);
            this.F.setPlayer(this.t.getControl());
            this.C.setText(StringHelper.stringForVideoTime(intValue));
            this.A.setText(String.format(this.S.getResources().getString(R.string.play_count_new), StringHelper.numFormatOverWan(threadData.getThreadVideoInfo().play_count.intValue())));
            this.G.setVideoLength(threadData.getThreadVideoInfo().video_length.intValue());
            this.G.setVideoDuration(threadData.getThreadVideoInfo().video_duration.intValue());
            this.G.setTid(this.Z);
            this.e0 = threadData;
            this.t.getControl().setThreadDataForStatistic(threadData);
            this.B.setVisibility(8);
            this.u.setPlaceHolder(3);
            this.u.setImageBitmap(null);
            if (TbadkCoreApplication.getInst().getAutoPlaySwitch() != 2 && TbadkCoreApplication.getInst().getAutoPlaySwitch() != 1) {
                this.u.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            } else if (!ei.isEmpty(threadData.getThreadVideoInfo().first_frame_thumbnail)) {
                this.u.startLoad(threadData.getThreadVideoInfo().first_frame_thumbnail, 10, false);
            } else {
                this.u.startLoad(threadData.getThreadVideoInfo().thumbnail_url, 10, false);
            }
            this.H.setShareData(threadData);
            w0(threadData);
            t0(threadData);
            A0(threadData.videoBottomPlaceInfo);
        }
    }

    public final void w0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, threadData) == null) {
            TextView textView = this.P;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (threadData != null && !ListUtils.isEmpty(threadData.getRichAbstractList())) {
                for (PbContent pbContent : threadData.getRichAbstractList()) {
                    if (pbContent != null) {
                        TiebaPlusInfo tiebaPlusInfo = pbContent.tiebaplus_info;
                        if (pbContent.type.intValue() == 35 && tiebaPlusInfo != null && this.P != null) {
                            StringBuilder sb = new StringBuilder();
                            if (StringUtils.isNotNull(tiebaPlusInfo.title)) {
                                sb.append(tiebaPlusInfo.title);
                                sb.append(" | ");
                            }
                            if (StringUtils.isNotNull(tiebaPlusInfo.app_version)) {
                                sb.append(String.format(TbadkCoreApplication.getInst().getString(R.string.app_version), tiebaPlusInfo.app_version));
                                sb.append(" | ");
                            }
                            if (StringUtils.isNotNull(tiebaPlusInfo.app_company)) {
                                sb.append(tiebaPlusInfo.app_company);
                                sb.append(" | ");
                            }
                            if (sb.length() == 0) {
                                return;
                            }
                            int length = sb.length() - 1;
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.app_permission));
                            int length2 = sb.length();
                            sb.append(" | ");
                            int length3 = sb.length() - 1;
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f115c));
                            int length4 = sb.length();
                            sb.append(" | ");
                            int length5 = sb.length() - 1;
                            sb.append(TbadkCoreApplication.getInst().getString(R.string.product_function));
                            int length6 = sb.length();
                            SpannableString spannableString = new SpannableString(sb);
                            if (length < 0) {
                                length = 0;
                            }
                            spannableString.setSpan(new m(this, tiebaPlusInfo), length, length2, 17);
                            if (length3 < 0) {
                                length3 = 0;
                            }
                            spannableString.setSpan(new n(this, tiebaPlusInfo), length3, length4, 17);
                            if (length5 < 0) {
                                length5 = 0;
                            }
                            spannableString.setSpan(new o(this, tiebaPlusInfo), length5, length6, 17);
                            this.P.setVisibility(0);
                            EMManager.from(this.P).setTextColor(R.color.CAM_X0619);
                            this.P.setMovementMethod(LinkMovementMethod.getInstance());
                            this.P.setHintTextColor(0);
                            this.P.setText(spannableString);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void x0(int i2) {
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
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            r0();
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
            this.j0 = z;
            this.w.clearAnimation();
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (this.j0) {
                i5 = 0;
            } else {
                i5 = 8;
            }
            tBLottieAnimationView.setVisibility(i5);
            if (!this.j0) {
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
                this.F.t();
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

    public void i0() {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048600, this) != null) || (context = this.S) == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(g0(), (ViewGroup) null);
        this.U = viewGroup;
        View view2 = this.f1186T;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(viewGroup);
        }
        this.N = new WeakReference<>(TbadkCoreApplication.getInst());
        this.u = (TbImageView) this.U.findViewById(R.id.video_thumbnail);
        this.v = this.U.findViewById(R.id.black_mask);
        this.w = (TBLottieAnimationView) this.U.findViewById(R.id.video_loading);
        this.x = (ImageView) this.U.findViewById(R.id.video_play);
        this.z = (PercentSizeView) this.U.findViewById(R.id.video_media_controller_mask);
        this.y = (ImageView) this.U.findViewById(R.id.video_pause);
        this.A = (TextView) this.U.findViewById(R.id.video_play_count);
        this.B = (TextView) this.U.findViewById(R.id.video_play_flag);
        this.C = (TextView) this.U.findViewById(R.id.video_duration);
        this.D = (SwitchImageView) this.U.findViewById(R.id.video_mute);
        this.E = (SwitchImageView) this.U.findViewById(R.id.video_full_screen);
        this.F = (OperableVideoMediaControllerView) this.U.findViewById(R.id.video_media_controller);
        this.G = (OperableVideoNetworkStateTipView) this.U.findViewById(R.id.video_network_state_tip);
        this.H = (OperableVideoShareView) this.U.findViewById(R.id.video_share_view);
        this.J = this.U.findViewById(R.id.video_back_btn_mask);
        this.I = (ImageView) this.U.findViewById(R.id.video_full_screen_back);
        this.K = (VideoGestureView) this.U.findViewById(R.id.video_gesture);
        this.M = (OperableVideoErrorView) this.U.findViewById(R.id.video_error_layout);
        this.O = this.U.findViewById(R.id.bottom_area_layout);
        this.P = (TextView) this.U.findViewById(R.id.policy_info);
        this.Q = (TextView) this.U.findViewById(R.id.ad_label);
        this.R = (TextView) this.U.findViewById(R.id.bottom_info_place);
        this.H.setVideoContainer(this);
        this.w.addAnimatorListener(new j(this));
        this.w.setAnimation(R.raw.lotti_video_loading);
        this.x.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_play44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.x.setOnClickListener(this);
        this.D.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_sound24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_silent24_svg, R.color.CAM_X0101));
        this.D.setState(1);
        this.D.setOnClickListener(this);
        this.u.clearCornerFlag();
        this.u.setDrawCorner(false);
        this.u.setPlaceHolder(3);
        HomeGroupUbsUIHelper.handleImgMask(this.v);
        this.F.setOnSeekBarChangeListener(this.O0);
        this.z.setHeightPercent(0.583f);
        this.z.setBackgroundResource(R.drawable.video_mask_bg);
        this.E.setSvgStateImage(new SvgPureType(R.drawable.ic_icon_pure_video_fullscreen24_svg, R.color.CAM_X0101), new SvgPureType(R.drawable.ic_icon_pure_video_smallscreen24_svg, R.color.CAM_X0101));
        this.E.setState(0);
        this.E.setOnClickListener(this);
        this.y.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_video_pause44, SkinManager.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL));
        this.y.setOnClickListener(this);
        this.I.setOnClickListener(this);
        TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.S);
        this.t = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setTryUseViewInSet(true);
        z0();
        this.G.setPlayViewOnClickListener(this);
        this.U.setOnClickListener(null);
        this.U.setOnTouchListener(this.Q0);
        this.H.setOnTouchListener(this.Q0);
        this.M.setOutOnClickListener(this);
        this.u0 = new GestureDetector(this.S, this.P0);
        x0(this.b);
        EMManager.from(this.v).setMaskBackGround(R.array.Mask_X003);
        EMManager.from(this.A).setTextShadow(R.array.S_O_X001);
        EMManager.from(this.C).setTextShadow(R.array.S_O_X001);
        View view3 = this.O;
        if (view3 != null) {
            EMManager.from(view3).setMaskBackGround(R.array.Mask_X001);
        }
        if (this.S instanceof BaseFragmentActivity) {
            MessageManager.getInstance().unRegisterListener(2921683);
            ((BaseFragmentActivity) this.S).registerListener(this.M0);
        }
    }

    @Override // com.baidu.tieba.uz9
    public boolean onBackground(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
            if (z) {
                this.D0 = isPlaying();
                this.w.cancelAnimation();
                int i2 = this.p;
                if (i2 == this.d || i2 == this.e || i2 == this.f || i2 == this.b || i2 == this.n || i2 == this.o || i2 == this.c) {
                    stopPlay();
                }
                int i3 = this.p | 1;
                this.p = i3;
                int i4 = i3 & (-8193);
                this.p = i4;
                x0(i4);
            } else {
                int i5 = this.p;
                if (i5 == this.b || i5 == this.c || i5 == this.o || i5 == this.m) {
                    if (this.D0) {
                        startPlay();
                        s0();
                        return false;
                    }
                    return false;
                }
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public final void t0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, threadData) == null) {
            TextView textView = this.Q;
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (threadData != null && !ListUtils.isEmpty(threadData.getRichAbstractList())) {
                for (PbContent pbContent : threadData.getRichAbstractList()) {
                    if (pbContent.tiebaplus_info != null) {
                        if (this.Q != null && threadData.getShowAdSubscript()) {
                            this.Q.setVisibility(0);
                            EMManager.from(this.Q).setTextColor(R.color.CAM_X0619);
                            this.Q.setShadowLayer(UtilHelper.getDimenPixelSize(R.dimen.tbds25), 0.0f, UtilHelper.getDimenPixelSize(R.dimen.tbds2), SkinManager.getColor(R.color.CAM_X0607));
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void q0(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048621, this, customResponsedMessage) == null) && ei.isEquals(this.Y, (String) customResponsedMessage.getData()) && TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && TbSingleton.getInstance().getVideoCover() != null) {
            SafeHandler.getInst().post(new k(this));
        }
    }

    @Override // com.baidu.tieba.uz9
    public void startPlay() {
        Context context;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            ViewGroup viewGroup = this.U;
            if (viewGroup == null) {
                context = null;
            } else {
                context = viewGroup.getContext();
            }
            if ((context instanceof Activity) && context != TbadkCoreApplication.getInst().getCurrentActivity()) {
                this.W = true;
            } else if (StringUtils.isNull(this.Y)) {
            } else {
                MessageManager.getInstance().registerListener(this.S0);
                MessageManager.getInstance().registerListener(this.T0);
                if (n0()) {
                    x0(this.j);
                    return;
                }
                this.W = true;
                if (this.t.getControl().isPlaying()) {
                    return;
                }
                TbVideoViewContainer d2 = TbVideoViewSet.c().d(this.Y);
                if (d2 == null) {
                    this.t.a();
                    TbVideoViewContainer tbVideoViewContainer = new TbVideoViewContainer(this.S);
                    this.t = tbVideoViewContainer;
                    tbVideoViewContainer.getControl().setTryUseViewInSet(true);
                    z0();
                    if (BdNetTypeUtil.isNetWorkAvailable()) {
                        this.t.getControl().setVideoPath(this.Y, this.Z);
                        this.t.getControl().setStageType(this.i0);
                        B0();
                        if (this.g0) {
                            E0();
                        }
                    }
                } else {
                    TbVideoViewContainer tbVideoViewContainer2 = this.t;
                    if (tbVideoViewContainer2 == d2) {
                        tbVideoViewContainer2.a();
                        z0();
                    } else {
                        if (!TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && !TbSingleton.getInstance().getIsJumpFromVideoMiddleView().booleanValue()) {
                            this.t.a();
                            d2.a();
                            this.t = d2;
                        } else {
                            this.t.a();
                            this.t = new TbVideoViewContainer(this.S);
                            TbVideoViewSet.c().e(this.Y);
                            this.r0 = true;
                            TbSingleton.getInstance().setIsJumpFromVideoMiddleView(false);
                        }
                        this.t.getControl().setTryUseViewInSet(true);
                        z0();
                        p0();
                    }
                    this.t.getControl().H();
                    onPrepared();
                    C0();
                    if (this.g0) {
                        E0();
                    }
                }
                if (this.g0) {
                    StatisticItem param = new StatisticItem("c13357").param("tid", this.Z).param("fid", this.a0);
                    int i3 = 2;
                    if (this.X) {
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
        }
    }

    @Override // com.baidu.tieba.uz9
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.W = false;
            TBLottieAnimationView tBLottieAnimationView = this.w;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
            if (this.t.getParent() == this.U && (this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof kz9)) {
                if (this.t.getControl().isPlaying()) {
                    this.t.getControl().T();
                } else {
                    this.t.getControl().stopPlayback();
                }
            }
            if (TbSingleton.getInstance().getIsNeedReuseVideoPlayer() && !TbSingleton.getInstance().getIsOutNeedReuseVideoPlayer() && this.Y != null && (this.t.getControl() instanceof TbVideoView) && (this.t.getControl().getPlayer() instanceof kz9)) {
                this.t.getControl().Q();
                if (this.u != null) {
                    p0();
                }
                ((kz9) this.t.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
                TbVideoViewSet.c().e(this.Y);
                this.r0 = true;
            }
            this.t.a();
            this.F.q();
            if (this.r0) {
                x0(this.o);
                this.r0 = false;
            } else {
                x0(this.b);
            }
            MessageManager.getInstance().unRegisterListener(this.S0);
            MessageManager.getInstance().unRegisterListener(this.T0);
        }
    }
}
