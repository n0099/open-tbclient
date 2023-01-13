package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.view.SwitchImageView;
import com.baidu.tieba.wv4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.Date;
/* loaded from: classes7.dex */
public class yj8 {
    public static /* synthetic */ Interceptable $ic;
    public static int T0;
    public static CallStateReceiver U0;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView A;
    public boolean A0;
    public CyberPlayerManager.OnPreparedListener B;
    public boolean B0;
    public CyberPlayerManager.OnCompletionListener C;
    public boolean C0;
    public CyberPlayerManager.OnErrorListener D;
    public boolean D0;
    public ImageView E;
    public Activity E0;
    public TextView F;
    public g0 F0;
    public boolean G;
    public vk8 G0;
    public boolean H;
    public VideoLoadingProgressView.c H0;
    public boolean I;
    public Runnable I0;
    public boolean J;
    public Runnable J0;
    public View.OnClickListener K;
    public Runnable K0;
    public Animation L;
    public TbVideoViewContainer.a L0;
    public Animation M;
    public Runnable M0;
    public t N;
    public View.OnClickListener N0;
    public int O;
    public Animation.AnimationListener O0;
    public GestureDetector P;
    public Runnable P0;
    public View Q;
    public CustomMessageListener Q0;
    public View R;
    public VideoControllerView.d R0;
    public TextView S;
    public SeekBar.OnSeekBarChangeListener S0;
    public SeekBar T;
    public ImageView U;
    public ImageView V;
    public AudioManager W;
    public u X;
    public int Y;
    public int Z;
    public int a;
    public int a0;
    public boolean b;
    public int b0;
    public TbPageContext<?> c;
    public long c0;
    public View d;
    public f0 d0;
    public View e;
    public hk8 e0;
    public TbVideoViewContainer f;
    public int f0;
    public nk8 g;
    public int g0;
    public VideoListMediaControllerView h;
    public int h0;
    public ProgressBar i;
    public boolean i0;
    public View j;
    public z j0;
    public View k;
    public y k0;
    public FrameLayout l;
    public a0 l0;
    public FrameLayout.LayoutParams m;
    public b0 m0;
    public ImageView n;
    public d0 n0;
    public View o;
    public r o0;
    public View p;
    public e0 p0;
    public View q;
    public c0 q0;
    public View r;
    public w r0;
    public boolean s;
    public x s0;
    public SwitchImageView t;
    public boolean t0;
    public TextView u;
    public boolean u0;
    public TextView v;
    public boolean v0;
    public TextView w;
    public int w0;
    public String x;
    public boolean x0;
    public String y;
    public boolean y0;
    public String z;
    public boolean z0;

    /* loaded from: classes7.dex */
    public interface a0 {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface b0 {
        void onStart();

        void onStop();

        boolean onTouch(View view2, MotionEvent motionEvent);
    }

    /* loaded from: classes7.dex */
    public interface c0 {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public interface d0 {
        boolean a();

        boolean b();
    }

    /* loaded from: classes7.dex */
    public interface e0 {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes7.dex */
    public interface f0 {
        void c(int i);

        void d();

        void e();

        void onPaused();

        void onPlayEnd();

        void onPrepared();

        void onStarted();
    }

    /* loaded from: classes7.dex */
    public interface g0 {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface r {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface t {
        void a();

        void b();
    }

    /* loaded from: classes7.dex */
    public interface u {
        void a(boolean z);

        void b();
    }

    /* loaded from: classes7.dex */
    public interface v {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface w {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface x {
        void onPause();
    }

    /* loaded from: classes7.dex */
    public interface y {
        void a();
    }

    /* loaded from: classes7.dex */
    public interface z {
        void a();
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public a(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.F0 != null) {
                    this.a.F0.a();
                }
                boolean z = false;
                if (view2.getId() == this.a.k.getId()) {
                    this.a.f.getControl().stopPlayback();
                    this.a.G = false;
                    this.a.Q1();
                } else if (view2.getId() == this.a.t.getId()) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_PLAY_BTN_CLICK));
                    this.a.c1();
                    this.a.Y1();
                    if (this.a.w0 != 1) {
                        this.a.U0();
                        this.a.x0();
                    } else {
                        this.a.w0();
                    }
                    if (this.a.o0 != null) {
                        r rVar = this.a.o0;
                        if (this.a.w0 == 1) {
                            z = true;
                        }
                        rVar.a(z);
                    }
                } else if (view2.getId() == this.a.v.getId()) {
                    if (this.a.k0 != null) {
                        this.a.k0.a();
                    }
                } else if (view2.getId() == this.a.u.getId()) {
                    if (this.a.l0 != null) {
                        this.a.l0.a(false);
                    }
                    yj8 yj8Var = this.a;
                    yj8Var.M1(yj8Var.x, this.a.y);
                } else if (view2.getId() == this.a.n.getId()) {
                    if (this.a.I) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    if (this.a.s) {
                        TiebaStatic.log(new StatisticItem("c11714"));
                        TiebaStatic.log(new StatisticItem("c13262").param("tid", this.a.y).param("fid", this.a.z).param("obj_type", i).param("obj_source", 2));
                    } else {
                        TiebaStatic.log(new StatisticItem("c11710"));
                        TiebaStatic.log(new StatisticItem("c13262").param("tid", this.a.y).param("fid", this.a.z).param("obj_type", i).param("obj_source", 1));
                    }
                    if (this.a.q0 != null) {
                        this.a.q0.a();
                    }
                    if (this.a.Q0()) {
                        yj8 yj8Var2 = this.a;
                        if (yj8Var2.s) {
                            yj8Var2.z0();
                        } else {
                            yj8Var2.y0();
                        }
                        yj8 yj8Var3 = this.a;
                        yj8Var3.X1(yj8Var3.s);
                        return;
                    }
                    this.a.V1();
                } else if (view2.getId() == this.a.E.getId()) {
                    TiebaStatic.log(new StatisticItem("c11713"));
                    if (this.a.q0 != null) {
                        this.a.q0.a();
                    }
                    if (this.a.Q0()) {
                        this.a.z0();
                        this.a.X1(false);
                        return;
                    }
                    this.a.V1();
                } else if (this.a.K != null) {
                    this.a.K.onClick(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ yj8 d;

        public b(yj8 yj8Var, v vVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var, vVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = yj8Var;
            this.a = vVar;
            this.b = str;
            this.c = str2;
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                this.d.f1();
                wv4Var.dismiss();
                this.d.O1(this.a, false, this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements wv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.wv4.e
        public void onClick(wv4 wv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wv4Var) == null) {
                wv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public d(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public e(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.M0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(yj8 yj8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var, Integer.valueOf(i)};
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
            this.a = yj8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.a.T0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public g(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i) {
            TbVideoViewContainer tbVideoViewContainer;
            int duration;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && (tbVideoViewContainer = this.a.f) != null && tbVideoViewContainer.getControl() != null && (duration = this.a.f.getControl().getDuration()) > 0 && this.a.i != null) {
                this.a.i.setProgress((int) ((i * this.a.e.getWidth()) / duration));
                if (this.a.d0 != null) {
                    this.a.d0.c((this.a.f.getControl().getCurrentPosition() * 100) / duration);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            }
        }

        public h(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_VIDEO_SEEK_CLICK));
                this.a.U0();
                this.a.L1(false);
                if (this.a.o0 != null) {
                    this.a.o0.a(false);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.a.J0() != null) {
                    yj8 yj8Var = this.a;
                    yj8Var.A1(yj8Var.J0().getSeekPosition());
                    if (!this.a.D0()) {
                        this.a.Q1();
                    } else {
                        this.a.d1();
                        if (this.a.j0 != null) {
                            this.a.j0.a();
                        }
                    }
                }
                this.a.L1(true);
                this.a.u0();
                if (this.a.o0 != null) {
                    this.a.o0.a(true);
                }
                if (this.a.p0 != null) {
                    this.a.p0.onStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public i(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.m0 != null) {
                    this.a.m0.onTouch(view2, motionEvent);
                }
                boolean onTouchEvent = this.a.P.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    if (this.a.G) {
                        if (this.a.Y == 1 && this.a.b0 != 0) {
                            yj8 yj8Var = this.a;
                            if (yj8Var.b0 == 1) {
                                f = 1000.0f;
                            } else {
                                f = -1000.0f;
                            }
                            yj8Var.r0(f, false);
                            this.a.b0 = 0;
                            this.a.a0 = 0;
                        }
                        if (!this.a.f.getControl().isPlaying()) {
                            this.a.v.setVisibility(8);
                            this.a.u.setVisibility(8);
                            this.a.w.setVisibility(8);
                        }
                    }
                    this.a.V0();
                    if (this.a.m0 != null) {
                        this.a.m0.onStop();
                    }
                }
                return onTouchEvent;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j extends wq4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public j(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // com.baidu.tieba.wq4, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, activity) == null) && activity == this.a.E0) {
                MessageManager.getInstance().unRegisterListener(this.a.Q0);
                TbadkCoreApplication.getInst().unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements vk8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        @Override // com.baidu.tieba.vk8
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.vk8
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.vk8
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vk8
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vk8
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vk8
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.vk8
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void setStatistic(qk8 qk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, qk8Var) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.vk8
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }

        public k(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbVideoViewContainer tbVideoViewContainer;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (tbVideoViewContainer = this.a.f) != null && tbVideoViewContainer.getControl() != null) {
                int duration = this.a.f.getControl().getDuration();
                if (duration - getCurrentPosition() > 5000) {
                    return;
                }
                this.a.G = false;
                this.a.A0 = false;
                this.a.O = 0;
                this.a.V0();
                this.a.j.setVisibility(0);
                this.a.i.setProgress(this.a.i.getMax());
                this.a.a = 100;
                if (this.a.C != null) {
                    this.a.C.onCompletion();
                }
                this.a.w0 = 3;
                if (duration <= 150000) {
                    this.a.N0();
                    this.a.u.setVisibility(0);
                } else {
                    this.a.Y0(false);
                    this.a.L1(true);
                }
                yj8 yj8Var = this.a;
                if (!yj8Var.s && duration <= 150000) {
                    if (!yj8Var.x0) {
                        if (this.a.l0 != null) {
                            this.a.l0.a(true);
                        }
                        yj8 yj8Var2 = this.a;
                        yj8Var2.N1(yj8Var2.x, this.a.y, false);
                    } else {
                        this.a.w0 = 5;
                        this.a.f.getControl().pause();
                        this.a.f.getControl().seekTo(0);
                    }
                }
                if (this.a.d0 != null) {
                    this.a.d0.c(this.a.i.getMax());
                    this.a.d0.onPlayEnd();
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.k.setVisibility(0);
                this.a.g.b();
                this.a.w0 = 4;
                if (this.a.D != null) {
                    this.a.D.onError(i, i2, null);
                }
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.y0 = true;
                }
                if (this.a.d0 != null) {
                    this.a.d0.d();
                }
                this.a.A0 = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                if (i == 3 || i == 702 || i == 904) {
                    this.a.O0();
                    return false;
                }
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbVideoViewContainer tbVideoViewContainer;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                if (this.a.h != null && (tbVideoViewContainer = this.a.f) != null && tbVideoViewContainer.getControl() != null && this.a.f.getControl().getDuration() > 0) {
                    this.a.h.i(0, this.a.f.getControl().getDuration());
                }
                this.a.S1();
                if (this.a.d0 != null) {
                    this.a.d0.onPrepared();
                }
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !this.a.u0) {
                return;
            }
            bh.a().postDelayed(this.a.K0, 200L);
        }
    }

    /* loaded from: classes7.dex */
    public class l implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public l(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.S1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public m(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bh.a().removeCallbacks(this.a.I0);
                if (this.a.A.getVisibility() == 8) {
                    return;
                }
                if (this.a.f.getControl().getCurrentPosition() > this.a.a) {
                    this.a.O0();
                } else {
                    bh.a().postDelayed(this.a.I0, 20L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public n(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbVideoViewContainer tbVideoViewContainer = this.a.f;
                if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.a.f.getControl().isPlaying()) {
                    return;
                }
                this.a.k.setVisibility(0);
                this.a.g.b();
                if (this.a.d0 != null) {
                    this.a.d0.d();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public o(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TbVideoViewContainer tbVideoViewContainer = this.a.f;
                if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.a.u0) {
                    if (this.a.O == this.a.f.getControl().getCurrentPosition()) {
                        bh.a().postDelayed(this.a.K0, 200L);
                        return;
                    }
                    this.a.u0 = false;
                    bh.a().postDelayed(this.a.I0, 20L);
                    return;
                }
                bh.a().postDelayed(this.a.I0, 200L);
                this.a.u0 = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public p(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.G = false;
            if (this.a.I && !this.a.J) {
                bh.a().postDelayed(this.a.M0, 300L);
            }
            bh.a().removeCallbacks(this.a.I0);
            bh.a().removeCallbacks(this.a.J0);
        }
    }

    /* loaded from: classes7.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public q(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.A0 = false;
        }
    }

    /* loaded from: classes7.dex */
    public class s extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yj8 a;

        public s(yj8 yj8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yj8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yj8Var;
        }

        public /* synthetic */ s(yj8 yj8Var, i iVar) {
            this(yj8Var);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (this.a.C0) {
                    return super.onDoubleTap(motionEvent);
                }
                if (this.a.n0 != null && this.a.n0.b()) {
                    return true;
                }
                this.a.c1();
                this.a.Y1();
                if (this.a.f.getControl().isPlaying()) {
                    this.a.u0();
                } else {
                    this.a.U0();
                }
                if (this.a.o0 != null) {
                    this.a.o0.a(this.a.f.getControl().isPlaying());
                }
                return super.onDoubleTap(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (this.a.m0 != null) {
                    this.a.m0.onStart();
                }
                yj8 yj8Var = this.a;
                if (yj8Var.s && yj8Var.G) {
                    if (this.a.Y == 1) {
                        this.a.N0();
                    }
                    if (this.a.Y == 0) {
                        yj8 yj8Var2 = this.a;
                        if (yj8Var2.s) {
                            yj8Var2.B1();
                        }
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            this.a.Y = 1;
                            yj8 yj8Var3 = this.a;
                            yj8Var3.a0 = yj8Var3.f.getControl().getCurrentPosition();
                            this.a.r0(f, true);
                        } else {
                            this.a.Y = 2;
                            this.a.s0(f2);
                        }
                    } else if (this.a.Y != 1) {
                        if (this.a.Y == 2) {
                            this.a.s0(f2);
                        }
                    } else {
                        this.a.r0(f, true);
                    }
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                if (this.a.C0) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                boolean z = true;
                if (this.a.G) {
                    if (this.a.n0 == null || !this.a.n0.a()) {
                        this.a.U1();
                        if (this.a.f.getControl().isPlaying()) {
                            this.a.u0();
                        } else {
                            this.a.U0();
                        }
                        if (this.a.o0 != null) {
                            this.a.o0.a(this.a.f.getControl().isPlaying());
                        }
                    } else {
                        return true;
                    }
                } else {
                    this.a.c1();
                    this.a.Y1();
                    if (this.a.w0 != 1) {
                        this.a.U0();
                        this.a.x0();
                    } else {
                        this.a.w0();
                    }
                    if (this.a.o0 != null) {
                        r rVar = this.a.o0;
                        if (this.a.w0 != 1) {
                            z = false;
                        }
                        rVar.a(z);
                    }
                }
                return super.onSingleTapConfirmed(motionEvent);
            }
            return invokeL.booleanValue;
        }
    }

    public yj8(TbPageContext<?> tbPageContext, View view2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 100;
        this.b = false;
        this.s = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.O = 0;
        this.Y = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 60000L;
        this.f0 = 0;
        this.i0 = false;
        this.t0 = true;
        this.u0 = false;
        this.v0 = false;
        this.w0 = -1;
        this.x0 = false;
        this.B0 = true;
        this.D0 = false;
        this.G0 = new k(this);
        this.H0 = new l(this);
        this.I0 = new m(this);
        this.J0 = new n(this);
        this.K0 = new o(this);
        this.L0 = new p(this);
        this.M0 = new q(this);
        this.N0 = new a(this);
        this.O0 = new d(this);
        this.P0 = new e(this);
        this.Q0 = new f(this, 2016503);
        this.R0 = new g(this);
        this.S0 = new h(this);
        if (tbPageContext == null) {
            return;
        }
        this.c = tbPageContext;
        this.d = view2;
        this.B0 = z2;
        this.r = view2;
        this.E0 = tbPageContext.getPageActivity();
        P0();
    }

    public void A1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.O = i2;
        }
    }

    public void D1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.A.K(str, 17, false);
        }
    }

    public void E1(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, g0Var) == null) {
            this.F0 = g0Var;
        }
    }

    public void F1(int i2) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i2) == null) && (tbImageView = this.A) != null) {
            tbImageView.setDefaultBgResource(i2);
        }
    }

    public void G1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.F.setText(str);
        }
    }

    public View I0(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            return LayoutInflater.from(activity).inflate(R.layout.float_video_container, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public void I1(d0 d0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, d0Var) == null) {
            this.n0 = d0Var;
        }
    }

    public void L1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            Y1();
            if (z2) {
                this.t.setVisibility(0);
            } else {
                this.t.setVisibility(8);
            }
        }
    }

    public void h1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
            this.z = str;
        }
    }

    public void i1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) {
            this.t0 = z2;
            C1();
        }
    }

    public void j1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            this.x0 = z2;
        }
    }

    public void k1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            this.I = z2;
        }
    }

    public final void l1(int i2) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048635, this, i2) == null) && (videoListMediaControllerView = this.h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.h.setLayoutParams(layoutParams);
        }
    }

    public void n1(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, tVar) == null) {
            this.N = tVar;
        }
    }

    public void o1(u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, uVar) == null) {
            this.X = uVar;
        }
    }

    public void p1(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, wVar) == null) {
            this.r0 = wVar;
        }
    }

    public void q1(y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, yVar) == null) {
            this.k0 = yVar;
        }
    }

    public void r1(z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, zVar) == null) {
            this.j0 = zVar;
        }
    }

    public void s1(a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, a0Var) == null) {
            this.l0 = a0Var;
        }
    }

    public void t1(b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, b0Var) == null) {
            this.m0 = b0Var;
        }
    }

    public void u1(c0 c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, c0Var) == null) {
            this.q0 = c0Var;
        }
    }

    public void v1(CyberPlayerManager.OnCompletionListener onCompletionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, onCompletionListener) == null) {
            this.C = onCompletionListener;
        }
    }

    public void w1(CyberPlayerManager.OnErrorListener onErrorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, onErrorListener) == null) {
            this.D = onErrorListener;
        }
    }

    public void y1(e0 e0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, e0Var) == null) {
            this.p0 = e0Var;
        }
    }

    public void z1(String str) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048660, this, str) == null) && (tbVideoViewContainer = this.f) != null && tbVideoViewContainer.getControl() != null) {
            this.f.getControl().setStageType(str);
        }
    }

    public void H1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.x = str;
            this.y = str2;
        }
    }

    public void M1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            N1(str, str2, true);
        }
    }

    public static String F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.t0) {
                if (UtilHelper.canUseStyleImmersiveSticky() && !TbSingleton.getInstance().isNotchScreen(this.E0) && !TbSingleton.getInstance().isCutoutScreen(this.E0)) {
                    this.e.setSystemUiVisibility(4);
                    return;
                }
                return;
            }
            this.e.setSystemUiVisibility(0);
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.o != null && this.H) {
            this.M.cancel();
            this.L.cancel();
            L1(false);
            t0();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.i.setVisibility(0);
            this.H = false;
            u uVar = this.X;
            if (uVar != null) {
                uVar.b();
            }
        }
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.w0 = 5;
            bh.a().removeCallbacks(this.I0);
            bh.a().removeCallbacks(this.J0);
            bh.a().removeCallbacks(this.M0);
            this.f.getControl().stopPlayback();
            this.G = false;
            this.A0 = false;
            this.O = 0;
            X0();
        }
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048630, this) != null) || this.f.getControl().getDuration() < this.f.getControl().getCurrentPosition()) {
            return;
        }
        pk8.d().update(this.x, this.f.getControl().getCurrentPositionSync());
    }

    public void m1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && BdNetTypeUtil.isNetWorkAvailable() && this.y0 && !StringUtils.isNull(this.x) && !StringUtils.isNull(this.y)) {
            this.y0 = false;
            this.z0 = true;
            M1(this.x, this.y);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && this.o != null && !this.H && !this.D0) {
            L1(true);
            t0();
            this.o.setVisibility(0);
            this.p.setVisibility(0);
            this.i.setVisibility(8);
            this.H = true;
            u uVar = this.X;
            if (uVar != null) {
                uVar.a(false);
            }
        }
    }

    public static int K0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (context == null) {
                return 0;
            }
            try {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels - windowManager.getDefaultDisplay().getHeight();
            } catch (Exception e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static boolean L0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            if (identifier != 0) {
                boolean z2 = resources.getBoolean(identifier);
                String F0 = F0();
                if ("1".equals(F0)) {
                    return false;
                }
                if ("0".equals(F0)) {
                    return true;
                }
                return z2;
            }
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        return invokeL.booleanValue;
    }

    public void X1(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) && L0(this.E0) && (this.p.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.p.getLayoutParams();
            if (z2) {
                layoutParams.bottomMargin = K0(this.E0);
                this.p.setBackgroundDrawable(null);
            } else {
                layoutParams.bottomMargin = 0;
                this.p.setBackgroundResource(R.drawable.bg_video_shadow);
            }
            this.p.setLayoutParams(layoutParams);
        }
    }

    public final void Y0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048621, this, z2) != null) || this.o == null) {
            return;
        }
        int i2 = 0;
        this.j.setVisibility(0);
        this.v.setVisibility(8);
        this.u.setVisibility(8);
        this.w.setVisibility(8);
        this.g.b();
        N0();
        this.i.setVisibility(8);
        this.k.setVisibility(8);
        this.h.n();
        TbImageView tbImageView = this.A;
        if (!z2) {
            i2 = 8;
        }
        tbImageView.setVisibility(i2);
    }

    public final void a1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z2) == null) {
            if (z2) {
                this.A.setVisibility(0);
                N0();
                this.i.setProgress(0);
            } else {
                this.A.setVisibility(8);
                N0();
            }
            this.h.p();
            this.j.setVisibility(8);
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            this.k.setVisibility(8);
        }
    }

    public boolean b1(int i2) {
        InterceptResult invokeI;
        AudioManager audioManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            if (i2 != 4) {
                if ((i2 == 24 || i2 == 25) && (audioManager = this.W) != null && this.Z > 0 && this.T != null) {
                    int streamVolume = audioManager.getStreamVolume(3);
                    this.h0 = streamVolume;
                    int i3 = (int) ((streamVolume * 100.0d) / this.Z);
                    this.g0 = i3;
                    this.T.setProgress(i3);
                }
                return false;
            } else if (this.s) {
                if (Q0()) {
                    X1(false);
                    z0();
                    return true;
                }
                V1();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void A0(Activity activity, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048576, this, activity, z2) == null) && activity != null && activity.getWindow() != null) {
            if (z2) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags |= 1024;
                activity.getWindow().setAttributes(attributes);
                activity.getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = activity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            activity.getWindow().setAttributes(attributes2);
            activity.getWindow().clearFlags(512);
        }
    }

    public void S0(TbPageContext tbPageContext, Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, tbPageContext, configuration) == null) {
            if (!this.i0) {
                if (this.s) {
                    TiebaStatic.log(new StatisticItem("c11712"));
                } else {
                    TiebaStatic.log(new StatisticItem("c11711"));
                }
            } else {
                this.i0 = false;
            }
            if (configuration.orientation == 2) {
                y0();
            } else {
                z0();
            }
            W1();
            if (this.E0 == o9.f().b()) {
                d1();
            }
            Y1();
            w0();
            r rVar = this.o0;
            if (rVar != null) {
                rVar.a(true);
            }
        }
    }

    public void x1(boolean z2, boolean z3) {
        VideoListMediaControllerView videoListMediaControllerView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) && this.e0 != null) {
            ImageView imageView = this.n;
            if (imageView != null) {
                if (!z2 && z3) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                imageView.setVisibility(i2);
            }
            if (!z2 && z3 && (videoListMediaControllerView = this.h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams.rightMargin = zi.g(this.E0, R.dimen.tbds52);
                this.h.setLayoutParams(layoutParams);
            }
            this.e0.i(z2);
        }
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                return this.f.getControl().getCurrentPosition();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.e.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.e.setSystemUiVisibility(4);
            } else {
                this.e.setSystemUiVisibility(5894);
            }
        }
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.w0;
        }
        return invokeV.intValue;
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.G;
        }
        return invokeV.booleanValue;
    }

    public View E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !this.s;
        }
        return invokeV.booleanValue;
    }

    public ck8 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.f.getControl();
        }
        return (ck8) invokeV.objValue;
    }

    public VideoListMediaControllerView J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.h;
        }
        return (VideoListMediaControllerView) invokeV.objValue;
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.e.setVisibility(0);
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && BdNetTypeUtil.isMobileNet()) {
            t59.c().f(this.E0);
        }
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getHeight() >= this.f.getWidth()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            R1(this.x, this.y, null, new Object[0]);
        }
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.f;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                return this.f.getControl().isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.f.getControl().pause();
            this.w0 = 2;
            Z0();
        }
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            bh.a().removeCallbacks(this.P0);
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048614, this) != null) || this.o == null) {
            return;
        }
        if (this.H) {
            N0();
        } else {
            x0();
        }
    }

    public void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            this.i0 = true;
            hk8 hk8Var = this.e0;
            if (hk8Var != null) {
                hk8Var.l();
            }
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048617, this) != null) || this.o == null) {
            return;
        }
        this.M.setAnimationListener(null);
        this.L.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            Y0(true);
        }
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.w0 == 1) {
                this.t.setState(1);
            } else {
                this.t.setState(0);
            }
        }
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.g.b();
            this.v.setVisibility(8);
            this.u.setVisibility(8);
            this.w.setVisibility(8);
            Y1();
        }
    }

    public void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            d1();
            this.i.setVisibility(0);
        }
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            cz4.l().y("video_list_confirm_play_in_mobile_net", System.currentTimeMillis());
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048647, this) != null) || this.o == null) {
            return;
        }
        bh.a().removeCallbacks(this.P0);
        this.M.setAnimationListener(null);
        this.L.setAnimationListener(null);
        this.o.clearAnimation();
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            bh.a().removeCallbacks(this.P0);
            bh.a().postDelayed(this.P0, 3000L);
        }
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            x0();
            u0();
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && this.o != null && this.H) {
            L1(false);
            t0();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.i.setVisibility(0);
            this.L.setAnimationListener(this.O0);
            this.o.startAnimation(this.L);
            this.H = false;
            u uVar = this.X;
            if (uVar != null) {
                uVar.b();
            }
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            if (this.A.getVisibility() == 8 && this.G) {
                return;
            }
            this.G = true;
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.g.c();
            this.A.setVisibility(8);
            W0();
            this.h.p();
            this.i.setVisibility(0);
            CyberPlayerManager.OnPreparedListener onPreparedListener = this.B;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared();
            }
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            this.Y = 0;
            View view2 = this.Q;
            if (view2 != null && view2.getParent() != null && (this.Q.getParent() instanceof ViewGroup)) {
                try {
                    ((ViewGroup) this.Q.getParent()).removeView(this.Q);
                    this.Q = null;
                } catch (IllegalArgumentException unused) {
                }
            }
            View view3 = this.R;
            if (view3 != null && view3.getParent() != null && (this.R.getParent() instanceof ViewGroup)) {
                try {
                    ((ViewGroup) this.R.getParent()).removeView(this.R);
                    this.R = null;
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
    }

    public void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.f.getControl().isPlaying()) {
                T0();
                x xVar = this.s0;
                if (xVar != null) {
                    xVar.onPause();
                }
                f0 f0Var = this.d0;
                if (f0Var != null) {
                    f0Var.onPaused();
                }
            } else if (this.G) {
                d1();
                z zVar = this.j0;
                if (zVar != null) {
                    zVar.a();
                }
                f0 f0Var2 = this.d0;
                if (f0Var2 != null) {
                    f0Var2.e();
                }
            } else {
                Q1();
            }
        }
    }

    public void d1() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (tbVideoViewContainer = this.f) != null && tbVideoViewContainer.getControl() != null && this.h != null) {
            this.G = true;
            this.w0 = 1;
            this.f.getControl().L(null);
            int c2 = pk8.d().c(this.x);
            this.O = c2;
            this.u0 = true;
            int i2 = 100;
            if (c2 > 100) {
                int duration = this.f.getControl().getDuration();
                int i3 = this.O;
                if (duration > i3) {
                    i2 = i3;
                }
            }
            this.a = i2;
            this.g.b();
            a1(false);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            T1();
            bh.a().removeCallbacks(this.P0);
            bh.a().removeCallbacks(this.I0);
            bh.a().removeCallbacks(this.J0);
            bh.a().removeCallbacks(this.K0);
            bh.a().removeCallbacks(this.M0);
            this.e0.k();
            U0.unregister(this.E0);
        }
    }

    public final void N1(String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048600, this, str, str2, z2) == null) {
            K1();
            this.A0 = true;
            this.w0 = 0;
            H1(str, str2);
            ok8 ok8Var = new ok8();
            ok8Var.e = "ad_video_landing";
            ok8Var.d = ok8Var.a("ad_video_landing");
            ok8Var.f = ok8Var.c("1");
            this.f.getControl().setVideoModel(ok8Var);
            this.f.getControl().setVideoPath(str, str2);
            bh.a().removeCallbacks(this.J0);
            if (this.c0 > 0) {
                bh.a().postDelayed(this.J0, this.c0);
            }
            f0 f0Var = this.d0;
            if (f0Var != null) {
                f0Var.onStarted();
            }
            this.g.g();
            a1(z2);
        }
    }

    public final void O1(v vVar, boolean z2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{vVar, Boolean.valueOf(z2), str, str2}) == null) {
            if (this.v0) {
                P1(str, str2);
            } else {
                M1(str, str2);
            }
            if (vVar != null) {
                vVar.a(z2);
            }
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            View I0 = I0(this.E0);
            this.e = I0;
            I0.setOnClickListener(this.N0);
            View view2 = this.d;
            if (view2 instanceof FrameLayout) {
                ((FrameLayout) view2).addView(this.e);
            }
            this.f = new TbVideoViewContainer(this.E0);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
            ((ViewGroup) this.e).addView(this.f, 0);
            this.f.setLayoutParams(layoutParams);
            nk8 nk8Var = new nk8((ViewGroup) this.e.findViewById(R.id.auto_video_loading_container));
            this.g = nk8Var;
            nk8Var.f(this.H0);
            VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.e.findViewById(R.id.media_controller);
            this.h = videoListMediaControllerView;
            videoListMediaControllerView.setPlayer(this.f.getControl());
            ProgressBar progressBar = (ProgressBar) this.e.findViewById(R.id.pgrBottomProgress);
            this.i = progressBar;
            progressBar.setMax(zi.l(this.E0));
            this.i.setProgress(0);
            this.h.setOnSeekBarChangeListener(this.S0);
            this.h.setOnProgressUpdatedListener(this.R0);
            this.j = this.e.findViewById(R.id.black_mask);
            View findViewById = this.e.findViewById(R.id.layout_error);
            this.k = findViewById;
            findViewById.setOnClickListener(this.N0);
            this.l = (FrameLayout) this.e.findViewById(R.id.danmu_container);
            ImageView imageView = (ImageView) this.e.findViewById(R.id.img_full_screen);
            this.n = imageView;
            imageView.setOnClickListener(this.N0);
            this.o = this.e.findViewById(R.id.layout_media_controller);
            this.p = this.e.findViewById(R.id.time_show_controller);
            this.f.getControl().setContinuePlayEnable(true);
            this.f.getControl().setOperableVideoContainer(this.G0);
            this.f.getControl().setOnSurfaceDestroyedListener(this.L0);
            SwitchImageView switchImageView = (SwitchImageView) this.e.findViewById(R.id.img_play_controller);
            this.t = switchImageView;
            switchImageView.setStateImage(R.drawable.btn_card_play_video_n, R.drawable.btn_card_stop_video_n);
            this.t.setState(0);
            this.t.setOnClickListener(this.N0);
            TextView textView = (TextView) this.e.findViewById(R.id.txt_replay);
            this.u = textView;
            textView.setOnClickListener(this.N0);
            TextView textView2 = (TextView) this.e.findViewById(R.id.txt_playnext);
            this.v = textView2;
            textView2.setOnClickListener(this.N0);
            this.w = (TextView) this.e.findViewById(R.id.txt_next_video_title);
            TbImageView tbImageView = (TbImageView) this.e.findViewById(R.id.video_thumbnail);
            this.A = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.pic_video_thumbnail_place_holder);
            ImageView imageView2 = (ImageView) this.e.findViewById(R.id.img_exit);
            this.E = imageView2;
            imageView2.setOnClickListener(this.N0);
            this.F = (TextView) this.e.findViewById(R.id.video_title);
            View findViewById2 = this.e.findViewById(R.id.layout_title);
            this.q = findViewById2;
            findViewById2.setVisibility(8);
            this.L = AnimationUtils.loadAnimation(this.E0, R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
            this.M = AnimationUtils.loadAnimation(this.E0, R.anim.anim_alpha_0_to_1_duration_200_accelerate);
            this.P = new GestureDetector(this.E0, new s(this, null));
            AudioManager audioManager = (AudioManager) this.E0.getSystemService("audio");
            this.W = audioManager;
            this.Z = audioManager.getStreamMaxVolume(3);
            this.h0 = this.W.getStreamVolume(3);
            T0 = 100 / this.Z;
            this.e.setOnTouchListener(new i(this));
            hk8 hk8Var = new hk8(this.E0);
            this.e0 = hk8Var;
            if (this.B0) {
                hk8Var.j();
            }
            this.f0 = zi.g(this.E0, R.dimen.obfuscated_res_0x7f0701be);
            if (U0 == null) {
                U0 = new CallStateReceiver();
            }
            U0.register(this.E0);
            C1();
            MessageManager.getInstance().registerListener(this.Q0);
            TbadkCoreApplication.getInst().registerActivityLifecycleCallbacks(new j(this));
        }
    }

    public void P1(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            K1();
            this.A0 = true;
            this.w0 = 0;
            bh.a().removeCallbacks(this.J0);
            if (this.c0 > 0) {
                bh.a().postDelayed(this.J0, this.c0);
            }
            f0 f0Var = this.d0;
            if (f0Var != null) {
                f0Var.onStarted();
            }
            this.g.g();
            a1(true);
        }
    }

    public void R1(String str, String str2, v vVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048608, this, str, str2, vVar, objArr) == null) {
            K1();
            if (BdNetTypeUtil.isMobileNet() && !t59.c().d() && !TbSingleton.getInstance().hasAgreeToPlay()) {
                Date date = new Date(cz4.l().n("video_list_confirm_play_in_mobile_net", 0L));
                Date date2 = new Date();
                if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                    this.v0 = ((Boolean) objArr[0]).booleanValue();
                }
                if (date.getYear() == date2.getYear() && date.getMonth() == date2.getMonth() && date.getDay() == date2.getDay()) {
                    w wVar = this.r0;
                    if (wVar != null) {
                        wVar.a(true);
                        return;
                    }
                    if (!this.b) {
                        this.b = true;
                        zi.P(this.E0, R.string.play_video_mobile_tip2);
                    }
                    O1(vVar, true, str, str2);
                    return;
                }
                w wVar2 = this.r0;
                if (wVar2 != null) {
                    wVar2.a(false);
                    return;
                }
                wv4 wv4Var = new wv4(this.E0);
                wv4Var.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                wv4Var.setPositiveButton(R.string.editor_dialog_yes, new b(this, vVar, str, str2));
                wv4Var.setNegativeButton(R.string.editor_dialog_no, new c(this));
                wv4Var.create(this.c).show();
                return;
            }
            O1(vVar, true, str, str2);
            c0 c0Var = this.q0;
            if (c0Var != null) {
                c0Var.b();
            }
        }
    }

    public final void S1() {
        TbVideoViewContainer tbVideoViewContainer;
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (tbVideoViewContainer = this.f) != null && tbVideoViewContainer.getControl() != null && (videoListMediaControllerView = this.h) != null) {
            videoListMediaControllerView.p();
            this.O = pk8.d().c(this.x);
            if (this.A0) {
                this.f.getControl().setVolume(1.0f, 1.0f);
                this.f.getControl().start();
                this.A0 = false;
                bh.a().removeCallbacks(this.I0);
                bh.a().postDelayed(this.I0, 20L);
                bh.a().removeCallbacks(this.J0);
                bh.a().removeCallbacks(this.M0);
                if (this.f.getControl().E()) {
                    this.w0 = 1;
                    N0();
                }
                this.O = pk8.d().c(this.x);
                this.h.setPlayer(this.f.getControl());
                if (this.O != 0) {
                    this.u0 = true;
                }
                if (!this.z0) {
                    this.h.p();
                }
                if (!this.I && this.f.getControl().getDuration() <= 0) {
                    J0().setVisibility(4);
                }
            }
            int i2 = 100;
            if (this.O > 100) {
                int duration = this.f.getControl().getDuration();
                int i3 = this.O;
                if (duration > i3) {
                    i2 = i3;
                }
            }
            this.a = i2;
        }
    }

    public void W1() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && (tbVideoViewContainer = this.f) != null && tbVideoViewContainer.getControl() != null) {
            int l2 = zi.l(this.E0);
            if (this.s) {
                l2 = zi.j(this.E0);
            }
            this.i.setMax(l2);
            int duration = this.f.getControl().getDuration();
            if (duration > 0) {
                if (this.u.getVisibility() == 0) {
                    ProgressBar progressBar = this.i;
                    progressBar.setProgress(progressBar.getMax());
                    return;
                }
                this.i.setProgress((int) ((this.f.getControl().getCurrentPositionSync() * this.i.getMax()) / duration));
            }
        }
    }

    public void q0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048641, this) != null) || (view2 = this.r) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.e.getLayoutParams();
        this.m = layoutParams2;
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        layoutParams2.topMargin = 0;
        Activity activity = this.E0;
        if (activity != null && activity.getResources() != null && this.E0.getResources().getConfiguration() != null && this.E0.getResources().getConfiguration().orientation == 2) {
            this.e.setLayoutParams(new FrameLayout.LayoutParams(zi.j(this.E0), zi.l(this.E0)));
        } else {
            this.e.setLayoutParams(this.m);
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            this.s = true;
            this.e.setLayoutParams(new FrameLayout.LayoutParams(Integer.parseInt(rj5.c().f(this.E0)), Integer.parseInt(rj5.c().e(this.E0))));
            A0(this.E0, true);
            this.q.setVisibility(0);
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            this.l.setVisibility(8);
            this.g.b();
            this.A.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_video_narrow_white);
            l1(this.f0);
            B1();
            t tVar = this.N;
            if (tVar != null) {
                tVar.a();
            }
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            this.s = false;
            FrameLayout.LayoutParams layoutParams = this.m;
            if (layoutParams != null) {
                this.e.setLayoutParams(layoutParams);
            }
            A0(this.E0, false);
            this.q.setVisibility(8);
            this.l.setVisibility(0);
            this.g.b();
            this.A.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_video_enlarge_white);
            VideoListMediaControllerView videoListMediaControllerView = this.h;
            if (videoListMediaControllerView != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams2.leftMargin = zi.g(this.E0, R.dimen.tbds24);
                layoutParams2.rightMargin = 0;
                this.h.setLayoutParams(layoutParams2);
            }
            this.e.setSystemUiVisibility(0);
            C1();
            t tVar = this.N;
            if (tVar != null) {
                tVar.b();
            }
        }
    }

    public final void p0() {
        View view2;
        View view3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            int i2 = this.Y;
            if (i2 == 1) {
                if (this.Q == null && (view3 = this.e) != null && (view3 instanceof ViewGroup)) {
                    LayoutInflater.from(this.E0).inflate(R.layout.float_video_window_jindu, (ViewGroup) this.e, true);
                    View findViewById = this.e.findViewById(R.id.lay_jindu);
                    this.Q = findViewById;
                    this.S = (TextView) findViewById.findViewById(R.id.show_time);
                    this.V = (ImageView) this.Q.findViewById(R.id.arrow_icon);
                }
            } else if (i2 == 2 && this.R == null && (view2 = this.e) != null && (view2 instanceof ViewGroup)) {
                LayoutInflater.from(this.E0).inflate(R.layout.float_video_window_voice, (ViewGroup) this.e, true);
                View findViewById2 = this.e.findViewById(R.id.lay_voice);
                this.R = findViewById2;
                this.U = (ImageView) findViewById2.findViewById(R.id.arrow_voice_icon);
                this.T = (SeekBar) this.R.findViewById(R.id.show_voice_seekbar);
            }
        }
    }

    public final void r0(float f2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z2)}) == null) {
            if (z2) {
                if (f2 > 0.0f) {
                    this.a0 -= 1000;
                    this.b0 = 1;
                } else {
                    this.a0 += 1000;
                    this.b0 = 2;
                }
                int i2 = this.a0;
                if (i2 < 0) {
                    this.a0 = 0;
                } else if (i2 > this.f.getControl().getDuration()) {
                    this.a0 = this.f.getControl().getDuration();
                }
            }
            p0();
            String g2 = this.h.g(this.a0);
            if (f2 > 0.0f) {
                this.V.setImageResource(R.drawable.icon_kuaitui);
            } else {
                this.V.setImageResource(R.drawable.icon_kuaijin);
            }
            if (!StringUtils.isNull(g2)) {
                TextView textView = this.S;
                StringBuilder sb = new StringBuilder();
                sb.append(g2);
                sb.append("/");
                sb.append(this.h.g(this.f.getControl().getDuration()));
                textView.setText(sb);
            }
            this.h.setCurrentDuration(this.a0, !z2);
            N0();
            W1();
        }
    }

    public final void s0(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048645, this, f2) == null) {
            if (!this.G) {
                this.Y = 0;
                return;
            }
            if (T0 == 0) {
                int streamMaxVolume = this.W.getStreamMaxVolume(3);
                this.Z = streamMaxVolume;
                int i6 = 100 / streamMaxVolume;
                T0 = i6;
                if (i6 == 0) {
                    T0 = 1;
                }
            }
            p0();
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i7 > 0 && (i5 = this.g0) < 100) {
                this.g0 = i5 + 1;
            }
            int i8 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i8 < 0 && (i4 = this.g0) > 0) {
                this.g0 = i4 - 1;
            }
            if (this.g0 % T0 == 0) {
                if (i7 > 0 && (i3 = this.h0) < this.Z) {
                    this.h0 = i3 + 1;
                }
                if (i8 < 0 && (i2 = this.h0) > 0) {
                    this.h0 = i2 - 1;
                }
            }
            if (this.g0 > 0) {
                this.U.setImageResource(R.drawable.icon_shengyin_open);
            } else {
                this.U.setImageResource(R.drawable.icon_shengyin_close);
            }
            this.W.setStreamVolume(3, this.h0, 0);
            this.T.setProgress(this.g0);
        }
    }
}
