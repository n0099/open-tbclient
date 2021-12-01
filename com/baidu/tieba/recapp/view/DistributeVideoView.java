package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.j;
import c.a.d.f.p.k;
import c.a.d.f.p.l;
import c.a.q0.b.d;
import c.a.q0.b.g.b;
import c.a.q0.d1.r0;
import c.a.q0.s.s.a;
import c.a.r0.a;
import c.a.r0.h3.i0.b.g;
import c.a.r0.h3.l0.c;
import c.a.r0.h3.l0.e;
import c.a.r0.h3.m0.f;
import c.a.r0.h3.n;
import c.a.r0.h3.z;
import c.a.r0.t3.w;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoSwitchManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes11.dex */
public class DistributeVideoView extends RelativeLayout implements n {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int START_ACTION_AUTO = 1;
    public static final int START_ACTION_CLICK = 2;
    public static final int VIDEO_STYLE_FEED = 1;
    public static final int VIDEO_STYLE_WEB_PAGE = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public VideoControllerView B;
    public TbImageView C;
    public RelativeLayout D;
    public WeakReference<Context> E;
    public int F;
    public long G;
    public boolean H;
    public long I;
    public int J;
    public AdCard K;
    public String L;
    public Animation M;
    public boolean N;
    public boolean O;
    public boolean P;
    public int Q;
    public int R;
    public boolean S;
    public int T;
    public boolean U;
    public int V;
    public View.OnClickListener W;
    @NonNull
    public Handler a0;
    public CyberPlayerManager.OnPreparedListener b0;
    public CyberPlayerManager.OnInfoListener c0;
    public CyberPlayerManager.OnErrorListener d0;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f48800e;
    public CyberPlayerManager.OnCompletionListener e0;

    /* renamed from: f  reason: collision with root package name */
    public Context f48801f;
    public TbCyberVideoView.h f0;

    /* renamed from: g  reason: collision with root package name */
    public View f48802g;
    public Runnable g0;

    /* renamed from: h  reason: collision with root package name */
    public View f48803h;
    public Runnable h0;

    /* renamed from: i  reason: collision with root package name */
    public VideoInfo f48804i;
    public Runnable i0;

    /* renamed from: j  reason: collision with root package name */
    public g f48805j;

    /* renamed from: k  reason: collision with root package name */
    public f f48806k;
    public CustomMessageListener k0;
    public c.a.r0.h3.m0.g l;
    public ViewGroup m;
    public AdvertAppInfo n;
    public int o;
    public String p;
    public TbCyberVideoView q;
    public CustomMessageListener q0;
    public TBLottieAnimationView r;
    public CustomMessageListener r0;
    public ForeDrawableImageView s;
    public TextView t;
    public View u;
    public ImageView v;
    public ImageView w;
    public View x;
    public TextView y;
    public View z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = null;
        this.F = -1;
        this.G = 0L;
        this.H = false;
        this.I = 0L;
        this.J = 1;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.T = 2;
        this.V = 1;
        this.W = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48807e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48807e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f48807e.x) {
                        this.f48807e.x.setVisibility(8);
                        this.f48807e.performPlay();
                    } else if (view != this.f48807e.w && view != this.f48807e.v) {
                        if (view == this.f48807e.r || view == this.f48807e.A) {
                            this.f48807e.c0();
                        } else if (this.f48807e.K == null) {
                            this.f48807e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f48807e.jump2DownloadDetailPage();
                            this.f48807e.S();
                            if (z.q(jump2DownloadDetailPage)) {
                                this.f48807e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f48807e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 != 1001) {
                        if (i4 == 1003 && this.a.F == 1) {
                            if (this.a.G == this.a.q.getCurrentPosition()) {
                                this.a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.F == 1) {
                    } else {
                        if (!a.h().A() ? this.a.q.getCurrentPosition() <= 0 : !this.a.q.isPlaying()) {
                            this.a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.F = 1;
                        this.a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48813e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48813e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f48813e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f48813e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f48813e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f48813e.q.setVolume(0.0f, 0.0f);
                this.f48813e.a0.removeMessages(1001);
                this.f48813e.a0.sendEmptyMessage(1001);
                if (this.f48813e.H && this.f48813e.J == 1) {
                    this.f48813e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48814e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48814e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    if (i4 == 3 && this.f48814e.n != null) {
                        DistributeVideoView distributeVideoView = this.f48814e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.m4)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f48814e;
                        distributeVideoView2.i0(i6, distributeVideoView2.X(distributeVideoView2.T), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.d0 = new CyberPlayerManager.OnErrorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48815e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48815e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    this.f48815e.k0();
                    if (this.f48815e.q != null) {
                        DistributeVideoView distributeVideoView = this.f48815e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f48815e.q.getCurrentPosition());
                    }
                    this.f48815e.s.setForegroundDrawable(0);
                    this.f48815e.setLoadingAnimShow(false);
                    this.f48815e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.e0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48816e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48816e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48816e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f48816e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f48816e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f48816e.q.getDuration());
                    }
                    this.f48816e.k0();
                    if (this.f48816e.l != null) {
                        this.f48816e.l.e();
                        this.f48816e.t.setVisibility(8);
                        this.f48816e.u.setVisibility(8);
                        this.f48816e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.f0 = new TbCyberVideoView.h(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48817e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48817e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48817e.stopPlay();
                }
            }
        };
        this.g0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48818e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48818e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f48818e.f48804i == null || this.f48818e.q == null || !this.f48818e.canPlay()) {
                    return;
                }
                this.f48818e.h0(1);
            }
        };
        this.h0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48808e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48808e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48808e.Y();
                }
            }
        };
        this.i0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48811e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48811e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48811e.f0(false);
                }
            }
        };
        this.k0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.P) {
                            this.a.l0(true);
                            return;
                        } else {
                            this.a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.a.l0(true);
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.l0(true);
                    }
                }
            }
        };
        this.r0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.a.f0(true);
                }
            }
        };
        Z(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65575, this, z) == null) {
            d0();
            if (z) {
                this.r.setAlpha(1.0f);
                this.r.setVisibility(0);
                return;
            }
            this.r.setVisibility(8);
        }
    }

    public final boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (d.J()) {
                return j.z();
            }
            if (this.J == 1) {
                return w.a();
            }
            return j.z();
        }
        return invokeV.booleanValue;
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i0(2, 1, 0);
        }
    }

    public final void T(AdvertAppInfo advertAppInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo, i2, str) == null) {
            advertAppInfo.m4 = str;
            c l = c.a.r0.h3.l0.g.l(this.n, 303, i2, X(this.T), this.f48804i.video_duration.intValue(), this.R, -1);
            c.a.r0.h3.m0.g gVar = this.l;
            if (gVar != null) {
                gVar.l(l);
            }
        }
    }

    public final void U(int i2) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (advertAppInfo = this.n) == null || (videoInfo = this.f48804i) == null) {
            return;
        }
        advertAppInfo.m4 = this.p;
        c l = c.a.r0.h3.l0.g.l(advertAppInfo, 706, this.o, 1, videoInfo.video_duration.intValue(), c.a.r0.v.k.a.a(0), -1);
        boolean z = i2 == 1000;
        l.c(z ? "APP" : "URL");
        if (!z) {
            l.l(i2);
        }
        l.h("DEEPLINK");
        e.b().d(l);
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.i0);
            c.a.d.f.m.e.a().postDelayed(this.i0, 5000L);
        }
    }

    public final void W() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tBLottieAnimationView = this.r) == null) {
            return;
        }
        tBLottieAnimationView.clearAnimation();
        this.r.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48812e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48812e = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.f48812e.r.setMinFrame(0);
                    this.f48812e.r.setFrame(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f48812e.r.setVisibility(8);
                    this.f48812e.s.setVisibility(8);
                    DistributeVideoView distributeVideoView = this.f48812e;
                    distributeVideoView.l0(distributeVideoView.H);
                    if (this.f48812e.J == 1) {
                        this.f48812e.t.setVisibility(8);
                        this.f48812e.u.setVisibility(8);
                    } else {
                        this.f48812e.B.setPlayer(this.f48812e.q);
                        this.f48812e.B.initCurTimeAndDuration(0, (int) TimeUnit.SECONDS.toMillis(this.f48812e.f48804i.video_duration.intValue()));
                        this.f48812e.B.showProgress();
                        this.f48812e.e0(true);
                        c.a.d.f.m.e.a().removeCallbacks(this.f48812e.h0);
                        c.a.d.f.m.e.a().postDelayed(this.f48812e.h0, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView distributeVideoView2 = this.f48812e;
                    distributeVideoView2.G = distributeVideoView2.q.getCurrentPosition();
                    this.f48812e.f0(true);
                    this.f48812e.a0.removeMessages(1003);
                    this.f48812e.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                }
            }
        }).start();
    }

    public final int X(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? i2 == 1 ? 0 : 1 : invokeI.intValue;
    }

    public final void Y() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.N || (animation = this.M) == null) {
            return;
        }
        this.z.startAnimation(animation);
        this.N = true;
    }

    public final void Z(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) || context == null) {
            return;
        }
        this.f48801f = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
        this.f48803h = inflate;
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) inflate.findViewById(R.id.distribute_texture);
        this.q = tbCyberVideoView;
        tbCyberVideoView.setStageType(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.q.setNoBussinessStats();
        this.r = (TBLottieAnimationView) this.f48803h.findViewById(R.id.video_play);
        this.s = (ForeDrawableImageView) this.f48803h.findViewById(R.id.distribute_thumbnail);
        this.t = (TextView) this.f48803h.findViewById(R.id.distribute_count_process);
        this.u = this.f48803h.findViewById(R.id.black_mask_top);
        this.x = this.f48803h.findViewById(R.id.distribute_error_tip);
        this.y = (TextView) this.f48803h.findViewById(R.id.distribute_error_tip_text);
        this.v = (ImageView) this.f48803h.findViewById(R.id.distribute_voice_feed);
        View findViewById = this.f48803h.findViewById(R.id.distribute_control);
        this.z = findViewById;
        this.A = (ImageView) findViewById.findViewById(R.id.distribute_play_icon);
        this.w = (ImageView) this.z.findViewById(R.id.distribute_voice);
        this.B = (VideoControllerView) this.z.findViewById(R.id.distribute_process);
        FrameLayout frameLayout = (FrameLayout) this.f48803h.findViewById(R.id.tail_frame_container);
        this.m = frameLayout;
        this.f48806k = new f(context, frameLayout);
        TbImageView tbImageView = (TbImageView) this.f48803h.findViewById(R.id.bottom_picture);
        this.C = tbImageView;
        tbImageView.setVisibility(8);
        this.D = (RelativeLayout) this.f48803h.findViewById(R.id.video_container);
        this.r.setAnimation(R.raw.lotti_video_loading);
        this.r.setMinFrame(0);
        this.r.setFrame(0);
        b.h(this.u, R.drawable.video_mask_bg);
    }

    public final void a0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.f48800e) == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
        this.M = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    this.a.z.setVisibility(8);
                    this.a.N = false;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                }
            }
        });
    }

    public void autoContinue() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.O) {
            return;
        }
        continuePlay(1);
    }

    @Override // c.a.r0.h3.n
    public void autoPlay(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && R()) {
            if (i2 <= 0) {
                h0(1);
                return;
            }
            c.a.d.f.m.e.a().removeCallbacks(this.g0);
            c.a.d.f.m.e.a().postDelayed(this.g0, TimeUnit.SECONDS.toMillis(i2));
        }
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String str = this.K.scheme;
            if (!TextUtils.isEmpty(this.L)) {
                str = this.L;
            }
            if (TextUtils.isEmpty(str) || this.f48801f == null) {
                return 0;
            }
            if (z.C(this.n, str)) {
                return 3;
            }
            if (isPlaying() && a.h().z()) {
                return z.d(this.f48801f, str, this.n.getDownloadId(), this.n.j4, this.K.cmdScheme);
            }
            return z.g(this.f48801f, str, this.n, this.K.playCmdScheme);
        }
        return invokeV.intValue;
    }

    public final void c0() {
        TbPageContext<?> tbPageContext;
        TbPageContext<?> tbPageContext2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i2 = this.F;
            if (i2 == -1) {
                if (!j.z() && (tbPageContext2 = this.f48800e) != null) {
                    tbPageContext2.showToast(R.string.neterror);
                } else if (!j.H() && (tbPageContext = this.f48800e) != null) {
                    c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(tbPageContext.getPageActivity());
                    aVar.setMessageId(R.string.play_video_mobile_tip);
                    aVar.setPositiveButton(R.string.alert_yes_button, new a.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ DistributeVideoView f48809e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f48809e = this;
                        }

                        @Override // c.a.q0.s.s.a.e
                        public void onClick(c.a.q0.s.s.a aVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                aVar2.dismiss();
                                this.f48809e.performPlay();
                            }
                        }
                    });
                    aVar.setNegativeButton(R.string.cancel, new a.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ DistributeVideoView f48810e;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f48810e = this;
                        }

                        @Override // c.a.q0.s.s.a.e
                        public void onClick(c.a.q0.s.s.a aVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                aVar2.dismiss();
                            }
                        }
                    });
                    aVar.create(this.f48800e).show();
                } else {
                    performPlay();
                }
            } else if (i2 == 0) {
                stopPlay();
            } else if (i2 == 1) {
                this.O = true;
                pausePlay(0);
                if (this.J == 2) {
                    e0(true);
                }
            } else if (i2 != 2) {
            } else {
                this.O = false;
                continuePlay(2);
                if (this.J == 2) {
                    c.a.d.f.m.e.a().removeCallbacks(this.h0);
                    c.a.d.f.m.e.a().postDelayed(this.h0, TimeUnit.SECONDS.toMillis(3L));
                }
            }
        }
    }

    @Override // c.a.r0.h3.n
    public boolean canPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.i(this.f48801f);
        }
        return invokeV.booleanValue;
    }

    public void continuePlay(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048591, this, i2) == null) && this.F == 2) {
            this.T = i2;
            i0(33, X(i2), this.q.getCurrentPosition());
            this.q.getCurrentPosition();
            this.q.start();
            if (this.H) {
                r0.f(this.E, true);
            }
            setLoadingAnimShow(false);
            SkinManager.setImageResource(this.A, R.drawable.icon_video_midplay);
            this.F = 1;
        }
    }

    public final void d0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tBLottieAnimationView = this.r) == null) {
            return;
        }
        tBLottieAnimationView.setMinFrame(0);
        this.r.setFrame(0);
        this.r.cancelAnimation();
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                c.a.d.f.m.e.a().removeCallbacks(this.h0);
                Animation animation = this.M;
                if (animation != null) {
                    animation.cancel();
                }
                this.z.setVisibility(0);
                if (this.F == 1) {
                    SkinManager.setImageResource(this.A, R.drawable.icon_video_midplay);
                    return;
                } else {
                    SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
                    return;
                }
            }
            this.z.setVisibility(8);
        }
    }

    public final void f0(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (imageView = this.v) != null && this.J == 1) {
            if (z) {
                imageView.setVisibility(0);
                V();
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public final void g0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (tBLottieAnimationView = this.r) == null) {
            return;
        }
        tBLottieAnimationView.setAlpha(1.0f);
        this.r.setVisibility(0);
        this.r.loop(true);
        this.r.setMinAndMaxFrame(14, 80);
        this.r.playAnimation();
    }

    @Override // c.a.r0.h3.n
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.G : invokeV.longValue;
    }

    public VideoInfo getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f48804i : (VideoInfo) invokeV.objValue;
    }

    @Override // c.a.r0.h3.n
    public int getPlayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.F : invokeV.intValue;
    }

    @Override // c.a.r0.h3.n
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            VideoInfo videoInfo = this.f48804i;
            return videoInfo != null ? videoInfo.video_url : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.h3.n
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.T = i2;
            if (this.f48804i != null && this.F == -1) {
                if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.I) < TimeUnit.SECONDS.toSeconds(3L)) {
                    return;
                }
                c.a.r0.h3.m0.g gVar = this.l;
                if (gVar != null) {
                    gVar.f();
                }
                this.q.setVideoPath(this.f48804i.video_url);
                this.q.setVideoScalingMode(this.V);
                this.q.start();
                this.q.getCurrentPosition();
                SkinManager.setImageResource(this.A, R.drawable.icon_video_midplay);
                g0();
                this.x.setVisibility(8);
                this.s.setForegroundDrawable(0);
                this.F = 0;
                if (this.J == 1) {
                    this.t.setVisibility(0);
                    this.u.setVisibility(0);
                } else {
                    this.t.setVisibility(8);
                }
                TbPageContext<?> tbPageContext = this.f48800e;
                if (tbPageContext != null) {
                    tbPageContext.registerListener(this.r0);
                    this.f48800e.registerListener(this.k0);
                    this.f48800e.registerListener(this.q0);
                }
                i0(31, X(this.T), 0);
            }
        }
    }

    public final void i0(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048602, this, i2, i3, i4) == null) {
            j0(i2, i3, i4, -1);
        }
    }

    public void initVideoViewLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f48803h.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            if (z) {
                int k2 = l.k(getContext());
                int c2 = c.a.r0.h3.i0.c.a.c(k2);
                layoutParams.width = l.k(getContext());
                layoutParams.height = k2;
                layoutParams2.width = c2;
                layoutParams2.height = k2;
                layoutParams3.width = c2;
                layoutParams3.height = k2;
                layoutParams4.width = c2;
                layoutParams4.height = k2;
                SkinManager.setBackgroundColor(this, R.color.black_alpha100);
            } else {
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                layoutParams3.width = -1;
                layoutParams3.height = -1;
                layoutParams4.width = -1;
                layoutParams4.height = -1;
            }
            this.q.requestLayout();
        }
    }

    @Override // c.a.r0.h3.n
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getPlayStatus() != -1 : invokeV.booleanValue;
    }

    @Override // c.a.r0.h3.n
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? getPlayStatus() == 1 : invokeV.booleanValue;
    }

    public final void j0(int i2, int i3, int i4, int i5) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048606, this, i2, i3, i4, i5) == null) || (advertAppInfo = this.n) == null || (videoInfo = this.f48804i) == null) {
            return;
        }
        advertAppInfo.m4 = this.p;
        e.b().d(c.a.r0.h3.l0.g.l(advertAppInfo, i2, this.o, i3, videoInfo.video_duration.intValue(), i4, i5));
    }

    public int jump2DownloadDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? b0() : invokeV.intValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.d.f.m.e.a().removeCallbacks(this.g0);
            c.a.d.f.m.e.a().removeCallbacks(this.h0);
            c.a.d.f.m.e.a().removeCallbacks(this.i0);
            this.a0.removeMessages(1001);
            this.a0.removeMessages(1003);
            this.q.stopPlayback();
            this.F = -1;
            r0.f(this.E, false);
            f0(false);
            this.s.setForegroundDrawable(0);
            this.s.setVisibility(0);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
            this.B.resetProgress();
            this.x.setVisibility(8);
            VideoInfo videoInfo = this.f48804i;
            if (videoInfo != null) {
                this.t.setText(StringUtils.translateSecondsToString(videoInfo.video_duration.intValue()));
                this.t.setVisibility(0);
                this.u.setVisibility(0);
            }
            this.P = false;
            MessageManager.getInstance().unRegisterListener(this.r0);
            MessageManager.getInstance().unRegisterListener(this.k0);
            MessageManager.getInstance().unRegisterListener(this.q0);
        }
    }

    public final void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (z) {
                TbCyberVideoView tbCyberVideoView = this.q;
                if (tbCyberVideoView != null) {
                    tbCyberVideoView.setVolume(1.0f, 1.0f);
                }
                SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_open);
                SkinManager.setImageResource(this.v, R.drawable.icon_vedio_pronunciation_small_white);
                if (this.F == 1) {
                    r0.f(this.E, true);
                }
            } else {
                TbCyberVideoView tbCyberVideoView2 = this.q;
                if (tbCyberVideoView2 != null) {
                    tbCyberVideoView2.setVolume(0.0f, 0.0f);
                }
                SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_close);
                SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
                r0.f(this.E, false);
            }
            this.H = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onAttachedToWindow();
            if (!(this.l instanceof c.a.r0.h3.m0.a) || (adCard = this.K) == null || adCard.isDirectDownload()) {
                return;
            }
            ((c.a.r0.h3.m0.a) this.l).x();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDetachedFromWindow();
            if ((this.l instanceof c.a.r0.h3.m0.a) && (adCard = this.K) != null && !adCard.isDirectDownload()) {
                ((c.a.r0.h3.m0.a) this.l).C();
            }
            this.a0.removeCallbacksAndMessages(null);
        }
    }

    public void pausePlay(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i2) == null) && this.F == 1) {
            j0(32, X(this.T), this.q.getCurrentPosition(), i2);
            this.q.pause();
            r0.f(this.E, false);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
            this.F = 2;
        }
    }

    public void performPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            h0(2);
        }
    }

    @Override // c.a.r0.h3.n
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    public boolean resizeImage(VideoInfo videoInfo, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048615, this, videoInfo, i2, i3, i4)) == null) {
            if (videoInfo == null || this.f48803h == null) {
                return false;
            }
            int intValue = videoInfo.video_height.intValue();
            int intValue2 = videoInfo.video_width.intValue();
            if (i2 > 0 && intValue > 0 && intValue2 > 0) {
                setViewSize(this.f48803h, (intValue * i2) / intValue2, i2);
                return true;
            }
            setViewSize(this.f48803h, i3, i4);
            return true;
        }
        return invokeLIII.booleanValue;
    }

    public void setAdInfo(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, adCard) == null) {
            this.K = adCard;
        }
    }

    public void setData(VideoInfo videoInfo, int i2, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048618, this, videoInfo, i2, tbPageContext) == null) {
            if (i2 != 1 && i2 != 2) {
                BdLog.e("DistributeVideoView: invalid video style!");
                return;
            }
            this.J = i2;
            if (tbPageContext != null) {
                this.f48800e = tbPageContext;
                a0();
            }
            setData(videoInfo);
        }
    }

    public void setDownloadCallback(c.a.r0.w1.o.c cVar) {
        c.a.r0.h3.m0.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, cVar) == null) || (gVar = this.l) == null) {
            return;
        }
        gVar.h(cVar);
    }

    public void setHolderView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, view) == null) || view == null) {
            return;
        }
        this.f48802g = view;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, tbPageContext) == null) {
            this.f48800e = tbPageContext;
        }
    }

    public void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.L = str;
        }
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048624, this, advertAppInfo, i2, str) == null) {
            this.n = advertAppInfo;
            this.o = i2;
            this.p = str;
            T(advertAppInfo, i2, str);
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.U = z;
        }
    }

    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.V = i2;
            this.q.setVideoScalingMode(i2);
        }
    }

    public void setVideoTailFrameData(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, gVar) == null) {
            this.f48805j = gVar;
        }
    }

    public void setViewSize(View view, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048628, this, view, i2, i3) == null) || view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(i3, i2);
        } else {
            layoutParams.height = i2;
            layoutParams.width = i3;
        }
        view.setLayoutParams(layoutParams);
    }

    @Override // c.a.r0.h3.n
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            autoPlay(0);
        }
    }

    @Override // c.a.r0.h3.n
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            stopPlay(true);
        }
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, advertAppInfo) == null) {
            if (advertAppInfo == null) {
                advertAppInfo = this.n;
            }
            c.a.r0.h3.m0.g b2 = this.f48806k.b(this.f48805j, this.l);
            this.l = b2;
            if (b2 != null) {
                b2.j(this.f48800e);
                this.l.i(this.K);
                c.a.r0.h3.m0.g gVar = this.l;
                if (gVar instanceof c.a.r0.h3.m0.a) {
                    ((c.a.r0.h3.m0.a) gVar).z(this.U);
                }
                this.l.g(advertAppInfo);
                this.l.d(this.f48805j);
                this.l.f();
            }
        }
    }

    public void stopPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            if (this.q.getCurrentPosition() > 0 && this.F != -1 && z) {
                i0(34, X(this.T), this.q.getCurrentPosition());
            }
            k0();
        }
    }

    public void setData(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, videoInfo) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.f48804i = videoInfo;
            this.R = videoInfo.video_duration.intValue() * 1000;
            this.E = new WeakReference<>(this.f48801f.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            int k2 = l.k(this.f48801f) - l.f(this.f48801f, R.dimen.ds146);
            if (this.J == 2) {
                k2 = l.k(this.f48801f);
            }
            int intValue = this.f48804i.video_width.intValue() > 0 ? (this.f48804i.video_height.intValue() * k2) / this.f48804i.video_width.intValue() : k2;
            ViewGroup.LayoutParams layoutParams = this.f48803h.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k2;
                layoutParams.height = intValue;
                this.f48803h.setLayoutParams(layoutParams);
            }
            setOnClickListener(this.W);
            this.s.setDefaultResource(0);
            this.s.setDefaultBgResource(R.drawable.pic_use_header_40_n);
            if (!k.isEmpty(videoInfo.thumbnail_url)) {
                this.s.startLoad(videoInfo.thumbnail_url, 10, false);
            }
            this.q.setOnPreparedListener(this.b0);
            if (c.a.r0.a.h().A()) {
                this.q.setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.q.setOnErrorListener(this.d0);
            this.q.setOnCompletionListener(this.e0);
            this.q.setOnInfoListener(this.c0);
            this.q.setOnSurfaceDestroyedListener(this.f0);
            SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
            this.t.setText(StringUtils.translateSecondsToString(this.f48804i.video_duration.intValue()));
            if (this.J == 1) {
                this.H = false;
                SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
                this.v.setVisibility(8);
            } else {
                this.H = true;
                SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_open);
                this.v.setVisibility(8);
            }
            this.q.setIsVolume0(!this.H);
            this.w.setOnClickListener(this.W);
            this.v.setOnClickListener(this.W);
            this.x.setOnClickListener(this.W);
            this.x.setVisibility(8);
            SkinManager.setBackgroundColor(this.x, R.color.black_alpha80);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0101);
            if (this.J == 1) {
                this.u.setVisibility(0);
                this.t.setVisibility(0);
                return;
            }
            this.t.setVisibility(8);
            this.A.setOnClickListener(this.W);
            this.r.setOnClickListener(this.W);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.E = null;
        this.F = -1;
        this.G = 0L;
        this.H = false;
        this.I = 0L;
        this.J = 1;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.T = 2;
        this.V = 1;
        this.W = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48807e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48807e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f48807e.x) {
                        this.f48807e.x.setVisibility(8);
                        this.f48807e.performPlay();
                    } else if (view != this.f48807e.w && view != this.f48807e.v) {
                        if (view == this.f48807e.r || view == this.f48807e.A) {
                            this.f48807e.c0();
                        } else if (this.f48807e.K == null) {
                            this.f48807e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f48807e.jump2DownloadDetailPage();
                            this.f48807e.S();
                            if (z.q(jump2DownloadDetailPage)) {
                                this.f48807e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f48807e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 != 1001) {
                        if (i4 == 1003 && this.a.F == 1) {
                            if (this.a.G == this.a.q.getCurrentPosition()) {
                                this.a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.F == 1) {
                    } else {
                        if (!c.a.r0.a.h().A() ? this.a.q.getCurrentPosition() <= 0 : !this.a.q.isPlaying()) {
                            this.a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.F = 1;
                        this.a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48813e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48813e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f48813e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f48813e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f48813e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f48813e.q.setVolume(0.0f, 0.0f);
                this.f48813e.a0.removeMessages(1001);
                this.f48813e.a0.sendEmptyMessage(1001);
                if (this.f48813e.H && this.f48813e.J == 1) {
                    this.f48813e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48814e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48814e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    if (i4 == 3 && this.f48814e.n != null) {
                        DistributeVideoView distributeVideoView = this.f48814e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.m4)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f48814e;
                        distributeVideoView2.i0(i6, distributeVideoView2.X(distributeVideoView2.T), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.d0 = new CyberPlayerManager.OnErrorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48815e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48815e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    this.f48815e.k0();
                    if (this.f48815e.q != null) {
                        DistributeVideoView distributeVideoView = this.f48815e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f48815e.q.getCurrentPosition());
                    }
                    this.f48815e.s.setForegroundDrawable(0);
                    this.f48815e.setLoadingAnimShow(false);
                    this.f48815e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.e0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48816e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48816e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48816e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f48816e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f48816e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f48816e.q.getDuration());
                    }
                    this.f48816e.k0();
                    if (this.f48816e.l != null) {
                        this.f48816e.l.e();
                        this.f48816e.t.setVisibility(8);
                        this.f48816e.u.setVisibility(8);
                        this.f48816e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.f0 = new TbCyberVideoView.h(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48817e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48817e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48817e.stopPlay();
                }
            }
        };
        this.g0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48818e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48818e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f48818e.f48804i == null || this.f48818e.q == null || !this.f48818e.canPlay()) {
                    return;
                }
                this.f48818e.h0(1);
            }
        };
        this.h0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48808e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48808e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48808e.Y();
                }
            }
        };
        this.i0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48811e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48811e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48811e.f0(false);
                }
            }
        };
        this.k0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.P) {
                            this.a.l0(true);
                            return;
                        } else {
                            this.a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.a.l0(true);
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.l0(true);
                    }
                }
            }
        };
        this.r0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.a.f0(true);
                }
            }
        };
        Z(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.E = null;
        this.F = -1;
        this.G = 0L;
        this.H = false;
        this.I = 0L;
        this.J = 1;
        this.N = false;
        this.O = false;
        this.P = false;
        this.S = false;
        this.T = 2;
        this.V = 1;
        this.W = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48807e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48807e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f48807e.x) {
                        this.f48807e.x.setVisibility(8);
                        this.f48807e.performPlay();
                    } else if (view != this.f48807e.w && view != this.f48807e.v) {
                        if (view == this.f48807e.r || view == this.f48807e.A) {
                            this.f48807e.c0();
                        } else if (this.f48807e.K == null) {
                            this.f48807e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f48807e.jump2DownloadDetailPage();
                            this.f48807e.S();
                            if (z.q(jump2DownloadDetailPage)) {
                                this.f48807e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f48807e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this, r8};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        super((Looper) newInitContext2.callArgs[0]);
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i42 = message.what;
                    if (i42 != 1001) {
                        if (i42 == 1003 && this.a.F == 1) {
                            if (this.a.G == this.a.q.getCurrentPosition()) {
                                this.a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.F == 1) {
                    } else {
                        if (!c.a.r0.a.h().A() ? this.a.q.getCurrentPosition() <= 0 : !this.a.q.isPlaying()) {
                            this.a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.F = 1;
                        this.a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48813e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48813e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f48813e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f48813e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f48813e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f48813e.q.setVolume(0.0f, 0.0f);
                this.f48813e.a0.removeMessages(1001);
                this.f48813e.a0.sendEmptyMessage(1001);
                if (this.f48813e.H && this.f48813e.J == 1) {
                    this.f48813e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48814e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48814e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i42, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i42, i5, obj)) == null) {
                    if (i42 == 3 && this.f48814e.n != null) {
                        DistributeVideoView distributeVideoView = this.f48814e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.m4)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f48814e;
                        distributeVideoView2.i0(i6, distributeVideoView2.X(distributeVideoView2.T), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.d0 = new CyberPlayerManager.OnErrorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48815e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48815e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i42, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i42, i5, obj)) == null) {
                    this.f48815e.k0();
                    if (this.f48815e.q != null) {
                        DistributeVideoView distributeVideoView = this.f48815e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f48815e.q.getCurrentPosition());
                    }
                    this.f48815e.s.setForegroundDrawable(0);
                    this.f48815e.setLoadingAnimShow(false);
                    this.f48815e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.e0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48816e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48816e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48816e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f48816e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f48816e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f48816e.q.getDuration());
                    }
                    this.f48816e.k0();
                    if (this.f48816e.l != null) {
                        this.f48816e.l.e();
                        this.f48816e.t.setVisibility(8);
                        this.f48816e.u.setVisibility(8);
                        this.f48816e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.f0 = new TbCyberVideoView.h(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48817e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48817e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48817e.stopPlay();
                }
            }
        };
        this.g0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48818e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48818e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f48818e.f48804i == null || this.f48818e.q == null || !this.f48818e.canPlay()) {
                    return;
                }
                this.f48818e.h0(1);
            }
        };
        this.h0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48808e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48808e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48808e.Y();
                }
            }
        };
        this.i0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f48811e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f48811e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f48811e.f0(false);
                }
            }
        };
        this.k0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.P) {
                            this.a.l0(true);
                            return;
                        } else {
                            this.a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.a.l0(true);
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.l0(true);
                    }
                }
            }
        };
        this.r0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(r8);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this, Integer.valueOf(r8)};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i42 = newInitContext2.flag;
                    if ((i42 & 1) != 0) {
                        int i5 = i42 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.a.f0(true);
                }
            }
        };
        Z(context);
    }

    public void setData(VideoInfo videoInfo, c.a.r0.h3.i0.b.f fVar, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{videoInfo, fVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.f48804i = videoInfo;
            this.E = new WeakReference<>(this.f48801f.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f48803h.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            setOnClickListener(this.W);
            int i7 = 13;
            if (fVar != null && fVar.a()) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
                layoutParams2.width = i4;
                layoutParams2.height = i5;
                this.C.startLoad(fVar.a, 30, false);
                this.C.setVisibility(0);
                double d2 = fVar.f17753b;
                if (d2 > 0.0d) {
                    i2 = (int) (i4 * d2);
                    i3 = c.a.r0.h3.i0.c.a.b(i2);
                }
                double d3 = fVar.f17754c;
                i6 = d3 > 0.0d ? Math.min((int) (i4 * d3), i4 - i2) : 0;
                i7 = 11;
            } else {
                this.C.setVisibility(8);
                i6 = 0;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams3.width = i2;
            layoutParams3.height = i3;
            layoutParams3.rightMargin = i6;
            layoutParams3.addRule(i7);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            layoutParams4.width = i2;
            layoutParams4.height = i3;
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            layoutParams5.width = i2;
            layoutParams5.height = i3;
            this.s.setDefaultResource(0);
            this.s.setDefaultBgResource(R.drawable.pic_use_header_40_n);
            if (!k.isEmpty(videoInfo.thumbnail_url)) {
                this.s.startLoad(videoInfo.thumbnail_url, 10, false);
            }
            this.q.setOnPreparedListener(this.b0);
            if (c.a.r0.a.h().A()) {
                this.q.setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.q.setOnErrorListener(this.d0);
            this.q.setOnCompletionListener(this.e0);
            this.q.setOnInfoListener(this.c0);
            this.q.setOnSurfaceDestroyedListener(this.f0);
            SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
            this.t.setText(StringUtils.translateSecondsToString(this.f48804i.video_duration.intValue()));
            if (this.J == 1) {
                this.H = false;
                SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
                this.v.setVisibility(8);
            } else {
                this.H = true;
                SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_open);
                this.v.setVisibility(8);
            }
            this.q.setIsVolume0(!this.H);
            this.w.setOnClickListener(this.W);
            this.v.setOnClickListener(this.W);
            this.x.setOnClickListener(this.W);
            this.x.setVisibility(8);
            SkinManager.setBackgroundColor(this.x, R.color.black_alpha80);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0101);
            if (this.J == 1) {
                this.t.setVisibility(0);
                this.u.setVisibility(0);
                return;
            }
            this.t.setVisibility(8);
            this.A.setOnClickListener(this.W);
        }
    }
}
