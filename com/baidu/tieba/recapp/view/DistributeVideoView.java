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
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.o0.b.g.b;
import c.a.o0.b1.r0;
import c.a.o0.s.s.a;
import c.a.p0.a;
import c.a.p0.i3.v;
import c.a.p0.x2.i0.b.g;
import c.a.p0.x2.l0.c;
import c.a.p0.x2.l0.e;
import c.a.p0.x2.m0.f;
import c.a.p0.x2.n;
import c.a.p0.x2.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
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
/* loaded from: classes7.dex */
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
    public Handler a0;
    public CyberPlayerManager.OnPreparedListener b0;
    public CyberPlayerManager.OnInfoListener c0;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f56192e;

    /* renamed from: f  reason: collision with root package name */
    public Context f56193f;

    /* renamed from: g  reason: collision with root package name */
    public View f56194g;

    /* renamed from: h  reason: collision with root package name */
    public View f56195h;

    /* renamed from: i  reason: collision with root package name */
    public VideoInfo f56196i;
    public CyberPlayerManager.OnErrorListener i0;

    /* renamed from: j  reason: collision with root package name */
    public g f56197j;
    public CyberPlayerManager.OnCompletionListener j0;
    public f k;
    public TbCyberVideoView.h k0;
    public c.a.p0.x2.m0.g l;
    public Runnable l0;
    public ViewGroup m;
    public Runnable m0;
    public AdvertAppInfo n;
    public Runnable n0;
    public int o;
    public CustomMessageListener o0;
    public String p;
    public CustomMessageListener p0;
    public TbCyberVideoView q;
    public CustomMessageListener q0;
    public TBLottieAnimationView r;
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
            public final /* synthetic */ DistributeVideoView f56198e;

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
                this.f56198e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f56198e.x) {
                        this.f56198e.x.setVisibility(8);
                        this.f56198e.performPlay();
                    } else if (view != this.f56198e.w && view != this.f56198e.v) {
                        if (view == this.f56198e.r || view == this.f56198e.A) {
                            this.f56198e.c0();
                        } else if (this.f56198e.K == null) {
                            this.f56198e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f56198e.jump2DownloadDetailPage();
                            this.f56198e.S();
                            if (z.p(jump2DownloadDetailPage)) {
                                this.f56198e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f56198e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56208a;

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
                this.f56208a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 != 1001) {
                        if (i4 == 1003 && this.f56208a.F == 1) {
                            if (this.f56208a.G == this.f56208a.q.getCurrentPosition()) {
                                this.f56208a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.f56208a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.f56208a.setLoadingAnimShow(false);
                            }
                            this.f56208a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.f56208a.F == 1) {
                    } else {
                        if (!a.h().x() ? this.f56208a.q.getCurrentPosition() <= 0 : !this.f56208a.q.isPlaying()) {
                            this.f56208a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.f56208a.F = 1;
                        this.f56208a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56209e;

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
                this.f56209e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f56209e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f56209e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f56209e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f56209e.q.setVolume(0.0f, 0.0f);
                this.f56209e.a0.removeMessages(1001);
                this.f56209e.a0.sendEmptyMessage(1001);
                if (this.f56209e.H && this.f56209e.J == 1) {
                    this.f56209e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56210e;

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
                this.f56210e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    if (i4 == 3 && this.f56210e.n != null) {
                        DistributeVideoView distributeVideoView = this.f56210e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.d4)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f56210e;
                        distributeVideoView2.i0(i6, distributeVideoView2.X(distributeVideoView2.T), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.i0 = new CyberPlayerManager.OnErrorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56211e;

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
                this.f56211e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    this.f56211e.k0();
                    if (this.f56211e.q != null) {
                        DistributeVideoView distributeVideoView = this.f56211e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f56211e.q.getCurrentPosition());
                    }
                    this.f56211e.s.setForegroundDrawable(0);
                    this.f56211e.setLoadingAnimShow(false);
                    this.f56211e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.j0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56212e;

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
                this.f56212e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56212e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f56212e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f56212e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f56212e.q.getDuration());
                    }
                    this.f56212e.k0();
                    if (this.f56212e.l != null) {
                        this.f56212e.l.e();
                        this.f56212e.t.setVisibility(8);
                        this.f56212e.u.setVisibility(8);
                        this.f56212e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.k0 = new TbCyberVideoView.h(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56213e;

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
                this.f56213e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56213e.stopPlay();
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56214e;

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
                this.f56214e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f56214e.f56196i == null || this.f56214e.q == null || !this.f56214e.canPlay()) {
                    return;
                }
                this.f56214e.h0(1);
            }
        };
        this.m0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56199e;

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
                this.f56199e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56199e.Y();
                }
            }
        };
        this.n0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56203e;

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
                this.f56203e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56203e.f0(false);
                }
            }
        };
        this.o0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56204a;

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
                this.f56204a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f56204a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.f56204a.P) {
                            this.f56204a.l0(true);
                            return;
                        } else {
                            this.f56204a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.f56204a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.f56204a.l0(true);
                }
            }
        };
        this.p0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56205a;

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
                this.f56205a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.f56205a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.f56205a.l0(true);
                    }
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56206a;

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
                this.f56206a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f56206a.f0(true);
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
            if (this.J == 1) {
                return v.a();
            }
            return j.H();
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
            advertAppInfo.d4 = str;
            c l = c.a.p0.x2.l0.g.l(this.n, 303, i2, X(this.T), this.f56196i.video_duration.intValue(), this.R, -1);
            c.a.p0.x2.m0.g gVar = this.l;
            if (gVar != null) {
                gVar.l(l);
            }
        }
    }

    public final void U(int i2) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (advertAppInfo = this.n) == null || (videoInfo = this.f56196i) == null) {
            return;
        }
        advertAppInfo.d4 = this.p;
        c l = c.a.p0.x2.l0.g.l(advertAppInfo, SDKLogTypeConstants.CLOSE_GAME_TYPE, this.o, 1, videoInfo.video_duration.intValue(), c.a.p0.q.h.a.a(0), -1);
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
            c.a.e.e.m.e.a().removeCallbacks(this.n0);
            c.a.e.e.m.e.a().postDelayed(this.n0, 5000L);
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
            public final /* synthetic */ DistributeVideoView f56207e;

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
                this.f56207e = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.f56207e.r.setMinFrame(0);
                    this.f56207e.r.setFrame(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f56207e.r.setVisibility(8);
                    this.f56207e.s.setVisibility(8);
                    DistributeVideoView distributeVideoView = this.f56207e;
                    distributeVideoView.l0(distributeVideoView.H);
                    if (this.f56207e.J == 1) {
                        this.f56207e.t.setVisibility(8);
                        this.f56207e.u.setVisibility(8);
                    } else {
                        this.f56207e.B.setPlayer(this.f56207e.q);
                        this.f56207e.B.initCurTimeAndDuration(0, (int) TimeUnit.SECONDS.toMillis(this.f56207e.f56196i.video_duration.intValue()));
                        this.f56207e.B.showProgress();
                        this.f56207e.e0(true);
                        c.a.e.e.m.e.a().removeCallbacks(this.f56207e.m0);
                        c.a.e.e.m.e.a().postDelayed(this.f56207e.m0, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView distributeVideoView2 = this.f56207e;
                    distributeVideoView2.G = distributeVideoView2.q.getCurrentPosition();
                    this.f56207e.f0(true);
                    this.f56207e.a0.removeMessages(1003);
                    this.f56207e.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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
        this.f56193f = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
        this.f56195h = inflate;
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) inflate.findViewById(R.id.distribute_texture);
        this.q = tbCyberVideoView;
        tbCyberVideoView.setStageType(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.q.setNoBussinessStats();
        this.r = (TBLottieAnimationView) this.f56195h.findViewById(R.id.video_play);
        this.s = (ForeDrawableImageView) this.f56195h.findViewById(R.id.distribute_thumbnail);
        this.t = (TextView) this.f56195h.findViewById(R.id.distribute_count_process);
        this.u = this.f56195h.findViewById(R.id.black_mask_top);
        this.x = this.f56195h.findViewById(R.id.distribute_error_tip);
        this.y = (TextView) this.f56195h.findViewById(R.id.distribute_error_tip_text);
        this.v = (ImageView) this.f56195h.findViewById(R.id.distribute_voice_feed);
        View findViewById = this.f56195h.findViewById(R.id.distribute_control);
        this.z = findViewById;
        this.A = (ImageView) findViewById.findViewById(R.id.distribute_play_icon);
        this.w = (ImageView) this.z.findViewById(R.id.distribute_voice);
        this.B = (VideoControllerView) this.z.findViewById(R.id.distribute_process);
        FrameLayout frameLayout = (FrameLayout) this.f56195h.findViewById(R.id.tail_frame_container);
        this.m = frameLayout;
        this.k = new f(context, frameLayout);
        TbImageView tbImageView = (TbImageView) this.f56195h.findViewById(R.id.bottom_picture);
        this.C = tbImageView;
        tbImageView.setVisibility(8);
        this.D = (RelativeLayout) this.f56195h.findViewById(R.id.video_container);
        this.r.setAnimation(R.raw.lotti_video_loading);
        this.r.setMinFrame(0);
        this.r.setFrame(0);
        b.h(this.u, R.drawable.video_mask_bg);
    }

    public final void a0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.f56192e) == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
        this.M = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56202a;

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
                this.f56202a = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    this.f56202a.z.setVisibility(8);
                    this.f56202a.N = false;
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

    @Override // c.a.p0.x2.n
    public void autoPlay(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && R()) {
            if (i2 <= 0) {
                h0(1);
                return;
            }
            c.a.e.e.m.e.a().removeCallbacks(this.l0);
            c.a.e.e.m.e.a().postDelayed(this.l0, TimeUnit.SECONDS.toMillis(i2));
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
            if (TextUtils.isEmpty(str) || this.f56193f == null) {
                return 0;
            }
            if (z.B(this.n, str)) {
                return 3;
            }
            if (isPlaying() && a.h().w()) {
                return z.d(this.f56193f, str, this.n.getDownloadId(), this.n.a4);
            }
            return z.g(this.f56193f, str, this.n);
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
                if (!j.z() && (tbPageContext2 = this.f56192e) != null) {
                    tbPageContext2.showToast(R.string.neterror);
                } else if (!j.H() && (tbPageContext = this.f56192e) != null) {
                    c.a.o0.s.s.a aVar = new c.a.o0.s.s.a(tbPageContext.getPageActivity());
                    aVar.setMessageId(R.string.play_video_mobile_tip);
                    aVar.setPositiveButton(R.string.alert_yes_button, new a.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ DistributeVideoView f56200e;

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
                            this.f56200e = this;
                        }

                        @Override // c.a.o0.s.s.a.e
                        public void onClick(c.a.o0.s.s.a aVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                aVar2.dismiss();
                                this.f56200e.performPlay();
                            }
                        }
                    });
                    aVar.setNegativeButton(R.string.cancel, new a.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ DistributeVideoView f56201e;

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
                            this.f56201e = this;
                        }

                        @Override // c.a.o0.s.s.a.e
                        public void onClick(c.a.o0.s.s.a aVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                aVar2.dismiss();
                            }
                        }
                    });
                    aVar.create(this.f56192e).show();
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
                    c.a.e.e.m.e.a().removeCallbacks(this.m0);
                    c.a.e.e.m.e.a().postDelayed(this.m0, TimeUnit.SECONDS.toMillis(3L));
                }
            }
        }
    }

    @Override // c.a.p0.x2.n
    public boolean canPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.i(this.f56193f);
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
                r0.e(this.E, true);
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
                c.a.e.e.m.e.a().removeCallbacks(this.m0);
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

    @Override // c.a.p0.x2.n
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.G : invokeV.longValue;
    }

    public VideoInfo getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f56196i : (VideoInfo) invokeV.objValue;
    }

    @Override // c.a.p0.x2.n
    public int getPlayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.F : invokeV.intValue;
    }

    @Override // c.a.p0.x2.n
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            VideoInfo videoInfo = this.f56196i;
            return videoInfo != null ? videoInfo.video_url : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.p0.x2.n
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.T = i2;
            if (this.f56196i != null && this.F == -1) {
                if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.I) < TimeUnit.SECONDS.toSeconds(3L)) {
                    return;
                }
                c.a.p0.x2.m0.g gVar = this.l;
                if (gVar != null) {
                    gVar.f();
                }
                this.q.setVideoPath(this.f56196i.video_url);
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
                TbPageContext<?> tbPageContext = this.f56192e;
                if (tbPageContext != null) {
                    tbPageContext.registerListener(this.q0);
                    this.f56192e.registerListener(this.o0);
                    this.f56192e.registerListener(this.p0);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f56195h.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            if (z) {
                int k = l.k(getContext());
                int c2 = c.a.p0.x2.i0.c.a.c(k);
                layoutParams.width = l.k(getContext());
                layoutParams.height = k;
                layoutParams2.width = c2;
                layoutParams2.height = k;
                layoutParams3.width = c2;
                layoutParams3.height = k;
                layoutParams4.width = c2;
                layoutParams4.height = k;
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

    @Override // c.a.p0.x2.n
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getPlayStatus() != -1 : invokeV.booleanValue;
    }

    @Override // c.a.p0.x2.n
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? getPlayStatus() == 1 : invokeV.booleanValue;
    }

    public final void j0(int i2, int i3, int i4, int i5) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048606, this, i2, i3, i4, i5) == null) || (advertAppInfo = this.n) == null || (videoInfo = this.f56196i) == null) {
            return;
        }
        advertAppInfo.d4 = this.p;
        e.b().d(c.a.p0.x2.l0.g.l(advertAppInfo, i2, this.o, i3, videoInfo.video_duration.intValue(), c.a.p0.q.h.a.a(i4), i5));
    }

    public int jump2DownloadDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? b0() : invokeV.intValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            c.a.e.e.m.e.a().removeCallbacks(this.l0);
            c.a.e.e.m.e.a().removeCallbacks(this.m0);
            c.a.e.e.m.e.a().removeCallbacks(this.n0);
            this.a0.removeMessages(1001);
            this.a0.removeMessages(1003);
            this.q.stopPlayback();
            this.F = -1;
            r0.e(this.E, false);
            f0(false);
            this.s.setForegroundDrawable(0);
            this.s.setVisibility(0);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
            this.B.resetProgress();
            this.x.setVisibility(8);
            VideoInfo videoInfo = this.f56196i;
            if (videoInfo != null) {
                this.t.setText(StringUtils.translateSecondsToString(videoInfo.video_duration.intValue()));
                this.t.setVisibility(0);
                this.u.setVisibility(0);
            }
            this.P = false;
            MessageManager.getInstance().unRegisterListener(this.q0);
            MessageManager.getInstance().unRegisterListener(this.o0);
            MessageManager.getInstance().unRegisterListener(this.p0);
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
                    r0.e(this.E, true);
                }
            } else {
                TbCyberVideoView tbCyberVideoView2 = this.q;
                if (tbCyberVideoView2 != null) {
                    tbCyberVideoView2.setVolume(0.0f, 0.0f);
                }
                SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_close);
                SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
                r0.e(this.E, false);
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
            if (!(this.l instanceof c.a.p0.x2.m0.a) || (adCard = this.K) == null || adCard.isDirectDownload()) {
                return;
            }
            ((c.a.p0.x2.m0.a) this.l).x();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDetachedFromWindow();
            if (!(this.l instanceof c.a.p0.x2.m0.a) || (adCard = this.K) == null || adCard.isDirectDownload()) {
                return;
            }
            ((c.a.p0.x2.m0.a) this.l).C();
        }
    }

    public void pausePlay(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i2) == null) && this.F == 1) {
            j0(32, X(this.T), this.q.getCurrentPosition(), i2);
            this.q.pause();
            r0.e(this.E, false);
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

    @Override // c.a.p0.x2.n
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    public boolean resizeImage(VideoInfo videoInfo, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(1048615, this, videoInfo, i2, i3, i4)) == null) {
            if (videoInfo == null || this.f56195h == null) {
                return false;
            }
            int intValue = videoInfo.video_height.intValue();
            int intValue2 = videoInfo.video_width.intValue();
            if (i2 > 0 && intValue > 0 && intValue2 > 0) {
                setViewSize(this.f56195h, (intValue * i2) / intValue2, i2);
                return true;
            }
            setViewSize(this.f56195h, i3, i4);
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
                this.f56192e = tbPageContext;
                a0();
            }
            setData(videoInfo);
        }
    }

    public void setDownloadCallback(c.a.p0.o1.o.c cVar) {
        c.a.p0.x2.m0.g gVar;
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
        this.f56194g = view;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, tbPageContext) == null) {
            this.f56192e = tbPageContext;
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
            this.f56197j = gVar;
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

    @Override // c.a.p0.x2.n
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            autoPlay(0);
        }
    }

    @Override // c.a.p0.x2.n
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
            c.a.p0.x2.m0.g b2 = this.k.b(this.f56197j, this.l);
            this.l = b2;
            if (b2 != null) {
                b2.j(this.f56192e);
                this.l.i(this.K);
                c.a.p0.x2.m0.g gVar = this.l;
                if (gVar instanceof c.a.p0.x2.m0.a) {
                    ((c.a.p0.x2.m0.a) gVar).z(this.U);
                }
                this.l.g(advertAppInfo);
                this.l.d(this.f56197j);
                this.l.f();
            }
        }
    }

    public void stopPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            if (this.q.getCurrentPosition() > 0 && this.F != -1 && z) {
                int currentPosition = this.q.getCurrentPosition();
                i0(this.q.getDuration() == currentPosition ? 34 : 32, X(this.T), currentPosition);
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
            this.f56196i = videoInfo;
            this.R = videoInfo.video_duration.intValue() * 1000;
            this.E = new WeakReference<>(this.f56193f.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            int k = l.k(this.f56193f) - l.g(this.f56193f, R.dimen.ds146);
            if (this.J == 2) {
                k = l.k(this.f56193f);
            }
            int intValue = this.f56196i.video_width.intValue() > 0 ? (this.f56196i.video_height.intValue() * k) / this.f56196i.video_width.intValue() : k;
            ViewGroup.LayoutParams layoutParams = this.f56195h.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = intValue;
                this.f56195h.setLayoutParams(layoutParams);
            }
            setOnClickListener(this.W);
            this.s.setDefaultResource(0);
            this.s.setDefaultBgResource(R.drawable.pic_use_header_40_n);
            if (!k.isEmpty(videoInfo.thumbnail_url)) {
                this.s.startLoad(videoInfo.thumbnail_url, 10, false);
            }
            this.q.setOnPreparedListener(this.b0);
            if (c.a.p0.a.h().x()) {
                this.q.setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.q.setOnErrorListener(this.i0);
            this.q.setOnCompletionListener(this.j0);
            this.q.setOnInfoListener(this.c0);
            this.q.setOnSurfaceDestroyedListener(this.k0);
            SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
            this.t.setText(StringUtils.translateSecondsToString(this.f56196i.video_duration.intValue()));
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
            public final /* synthetic */ DistributeVideoView f56198e;

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
                this.f56198e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f56198e.x) {
                        this.f56198e.x.setVisibility(8);
                        this.f56198e.performPlay();
                    } else if (view != this.f56198e.w && view != this.f56198e.v) {
                        if (view == this.f56198e.r || view == this.f56198e.A) {
                            this.f56198e.c0();
                        } else if (this.f56198e.K == null) {
                            this.f56198e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f56198e.jump2DownloadDetailPage();
                            this.f56198e.S();
                            if (z.p(jump2DownloadDetailPage)) {
                                this.f56198e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f56198e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56208a;

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
                this.f56208a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 != 1001) {
                        if (i4 == 1003 && this.f56208a.F == 1) {
                            if (this.f56208a.G == this.f56208a.q.getCurrentPosition()) {
                                this.f56208a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.f56208a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.f56208a.setLoadingAnimShow(false);
                            }
                            this.f56208a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.f56208a.F == 1) {
                    } else {
                        if (!c.a.p0.a.h().x() ? this.f56208a.q.getCurrentPosition() <= 0 : !this.f56208a.q.isPlaying()) {
                            this.f56208a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.f56208a.F = 1;
                        this.f56208a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56209e;

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
                this.f56209e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f56209e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f56209e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f56209e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f56209e.q.setVolume(0.0f, 0.0f);
                this.f56209e.a0.removeMessages(1001);
                this.f56209e.a0.sendEmptyMessage(1001);
                if (this.f56209e.H && this.f56209e.J == 1) {
                    this.f56209e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56210e;

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
                this.f56210e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    if (i4 == 3 && this.f56210e.n != null) {
                        DistributeVideoView distributeVideoView = this.f56210e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.d4)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f56210e;
                        distributeVideoView2.i0(i6, distributeVideoView2.X(distributeVideoView2.T), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.i0 = new CyberPlayerManager.OnErrorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56211e;

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
                this.f56211e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    this.f56211e.k0();
                    if (this.f56211e.q != null) {
                        DistributeVideoView distributeVideoView = this.f56211e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f56211e.q.getCurrentPosition());
                    }
                    this.f56211e.s.setForegroundDrawable(0);
                    this.f56211e.setLoadingAnimShow(false);
                    this.f56211e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.j0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56212e;

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
                this.f56212e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56212e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f56212e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f56212e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f56212e.q.getDuration());
                    }
                    this.f56212e.k0();
                    if (this.f56212e.l != null) {
                        this.f56212e.l.e();
                        this.f56212e.t.setVisibility(8);
                        this.f56212e.u.setVisibility(8);
                        this.f56212e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.k0 = new TbCyberVideoView.h(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56213e;

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
                this.f56213e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56213e.stopPlay();
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56214e;

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
                this.f56214e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f56214e.f56196i == null || this.f56214e.q == null || !this.f56214e.canPlay()) {
                    return;
                }
                this.f56214e.h0(1);
            }
        };
        this.m0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56199e;

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
                this.f56199e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56199e.Y();
                }
            }
        };
        this.n0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56203e;

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
                this.f56203e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56203e.f0(false);
                }
            }
        };
        this.o0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56204a;

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
                this.f56204a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f56204a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.f56204a.P) {
                            this.f56204a.l0(true);
                            return;
                        } else {
                            this.f56204a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.f56204a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.f56204a.l0(true);
                }
            }
        };
        this.p0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56205a;

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
                this.f56205a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.f56205a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.f56205a.l0(true);
                    }
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56206a;

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
                this.f56206a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f56206a.f0(true);
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
            public final /* synthetic */ DistributeVideoView f56198e;

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
                this.f56198e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f56198e.x) {
                        this.f56198e.x.setVisibility(8);
                        this.f56198e.performPlay();
                    } else if (view != this.f56198e.w && view != this.f56198e.v) {
                        if (view == this.f56198e.r || view == this.f56198e.A) {
                            this.f56198e.c0();
                        } else if (this.f56198e.K == null) {
                            this.f56198e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f56198e.jump2DownloadDetailPage();
                            this.f56198e.S();
                            if (z.p(jump2DownloadDetailPage)) {
                                this.f56198e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f56198e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56208a;

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
                this.f56208a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i42 = message.what;
                    if (i42 != 1001) {
                        if (i42 == 1003 && this.f56208a.F == 1) {
                            if (this.f56208a.G == this.f56208a.q.getCurrentPosition()) {
                                this.f56208a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.f56208a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.f56208a.setLoadingAnimShow(false);
                            }
                            this.f56208a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.f56208a.F == 1) {
                    } else {
                        if (!c.a.p0.a.h().x() ? this.f56208a.q.getCurrentPosition() <= 0 : !this.f56208a.q.isPlaying()) {
                            this.f56208a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.f56208a.F = 1;
                        this.f56208a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56209e;

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
                this.f56209e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f56209e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f56209e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f56209e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f56209e.q.setVolume(0.0f, 0.0f);
                this.f56209e.a0.removeMessages(1001);
                this.f56209e.a0.sendEmptyMessage(1001);
                if (this.f56209e.H && this.f56209e.J == 1) {
                    this.f56209e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56210e;

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
                this.f56210e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i42, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i42, i5, obj)) == null) {
                    if (i42 == 3 && this.f56210e.n != null) {
                        DistributeVideoView distributeVideoView = this.f56210e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.d4)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f56210e;
                        distributeVideoView2.i0(i6, distributeVideoView2.X(distributeVideoView2.T), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.i0 = new CyberPlayerManager.OnErrorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56211e;

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
                this.f56211e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i42, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i42, i5, obj)) == null) {
                    this.f56211e.k0();
                    if (this.f56211e.q != null) {
                        DistributeVideoView distributeVideoView = this.f56211e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f56211e.q.getCurrentPosition());
                    }
                    this.f56211e.s.setForegroundDrawable(0);
                    this.f56211e.setLoadingAnimShow(false);
                    this.f56211e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.j0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56212e;

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
                this.f56212e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56212e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f56212e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f56212e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f56212e.q.getDuration());
                    }
                    this.f56212e.k0();
                    if (this.f56212e.l != null) {
                        this.f56212e.l.e();
                        this.f56212e.t.setVisibility(8);
                        this.f56212e.u.setVisibility(8);
                        this.f56212e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.k0 = new TbCyberVideoView.h(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56213e;

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
                this.f56213e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56213e.stopPlay();
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56214e;

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
                this.f56214e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f56214e.f56196i == null || this.f56214e.q == null || !this.f56214e.canPlay()) {
                    return;
                }
                this.f56214e.h0(1);
            }
        };
        this.m0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56199e;

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
                this.f56199e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56199e.Y();
                }
            }
        };
        this.n0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56203e;

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
                this.f56203e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56203e.f0(false);
                }
            }
        };
        this.o0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56204a;

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
                this.f56204a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f56204a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.f56204a.P) {
                            this.f56204a.l0(true);
                            return;
                        } else {
                            this.f56204a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.f56204a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.f56204a.l0(true);
                }
            }
        };
        this.p0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56205a;

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
                this.f56205a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.f56205a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.f56205a.l0(true);
                    }
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f56206a;

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
                this.f56206a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f56206a.f0(true);
                }
            }
        };
        Z(context);
    }

    public void setData(VideoInfo videoInfo, c.a.p0.x2.i0.b.f fVar, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{videoInfo, fVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.f56196i = videoInfo;
            this.E = new WeakReference<>(this.f56193f.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f56195h.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            setOnClickListener(this.W);
            int i7 = 13;
            if (fVar != null && fVar.a()) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
                layoutParams2.width = i4;
                layoutParams2.height = i5;
                this.C.startLoad(fVar.f28549a, 30, false);
                this.C.setVisibility(0);
                double d2 = fVar.f28550b;
                if (d2 > 0.0d) {
                    i2 = (int) (i4 * d2);
                    i3 = c.a.p0.x2.i0.c.a.b(i2);
                }
                double d3 = fVar.f28551c;
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
            if (c.a.p0.a.h().x()) {
                this.q.setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.q.setOnErrorListener(this.i0);
            this.q.setOnCompletionListener(this.j0);
            this.q.setOnInfoListener(this.c0);
            this.q.setOnSurfaceDestroyedListener(this.k0);
            SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
            this.t.setText(StringUtils.translateSecondsToString(this.f56196i.video_duration.intValue()));
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
