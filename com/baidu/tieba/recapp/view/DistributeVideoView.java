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
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.b.g.b;
import d.a.r0.r.s.a;
import d.a.r0.z0.o0;
import d.a.s0.a;
import d.a.s0.h3.v;
import d.a.s0.w2.f0.b.f;
import d.a.s0.w2.i0.c;
import d.a.s0.w2.i0.g;
import d.a.s0.w2.j0.d;
import d.a.s0.w2.j0.e;
import d.a.s0.w2.m;
import d.a.s0.w2.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class DistributeVideoView extends RelativeLayout implements m {
    public static /* synthetic */ Interceptable $ic;
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
    public TbPageContext<?> f20581e;

    /* renamed from: f  reason: collision with root package name */
    public Context f20582f;

    /* renamed from: g  reason: collision with root package name */
    public View f20583g;

    /* renamed from: h  reason: collision with root package name */
    public View f20584h;

    /* renamed from: i  reason: collision with root package name */
    public VideoInfo f20585i;
    public CyberPlayerManager.OnErrorListener i0;
    public f j;
    public CyberPlayerManager.OnCompletionListener j0;
    public d k;
    public TbCyberVideoView.g k0;
    public e l;
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
            public final /* synthetic */ DistributeVideoView f20586e;

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
                this.f20586e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f20586e.x) {
                        this.f20586e.x.setVisibility(8);
                        this.f20586e.performPlay();
                    } else if (view != this.f20586e.w && view != this.f20586e.v) {
                        if (view == this.f20586e.r || view == this.f20586e.A) {
                            this.f20586e.c0();
                        } else if (this.f20586e.K == null) {
                            this.f20586e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f20586e.jump2DownloadDetailPage();
                            this.f20586e.S();
                            if (x.p(jump2DownloadDetailPage)) {
                                this.f20586e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f20586e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20596a;

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
                this.f20596a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 != 1001) {
                        if (i4 == 1003 && this.f20596a.F == 1) {
                            if (this.f20596a.G == this.f20596a.q.getCurrentPosition()) {
                                this.f20596a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.f20596a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.f20596a.setLoadingAnimShow(false);
                            }
                            this.f20596a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.f20596a.F == 1) {
                    } else {
                        if (!a.h().u() ? this.f20596a.q.getCurrentPosition() <= 0 : !this.f20596a.q.isPlaying()) {
                            this.f20596a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.f20596a.F = 1;
                        this.f20596a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20597e;

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
                this.f20597e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f20597e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f20597e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f20597e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f20597e.q.setVolume(0.0f, 0.0f);
                this.f20597e.a0.removeMessages(1001);
                this.f20597e.a0.sendEmptyMessage(1001);
                if (this.f20597e.H && this.f20597e.J == 1) {
                    this.f20597e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20598e;

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
                this.f20598e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    if (i4 == 3 && this.f20598e.n != null) {
                        DistributeVideoView distributeVideoView = this.f20598e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.V3)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f20598e;
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
            public final /* synthetic */ DistributeVideoView f20599e;

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
                this.f20599e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    this.f20599e.k0();
                    if (this.f20599e.q != null) {
                        DistributeVideoView distributeVideoView = this.f20599e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f20599e.q.getCurrentPosition());
                    }
                    this.f20599e.s.setForegroundDrawable(0);
                    this.f20599e.setLoadingAnimShow(false);
                    this.f20599e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.j0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20600e;

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
                this.f20600e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20600e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f20600e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f20600e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f20600e.q.getDuration());
                    }
                    this.f20600e.k0();
                    if (this.f20600e.l != null) {
                        this.f20600e.l.e();
                        this.f20600e.t.setVisibility(8);
                        this.f20600e.u.setVisibility(8);
                        this.f20600e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.k0 = new TbCyberVideoView.g(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20601e;

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
                this.f20601e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20601e.stopPlay();
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20602e;

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
                this.f20602e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f20602e.f20585i == null || this.f20602e.q == null || !this.f20602e.canPlay()) {
                    return;
                }
                this.f20602e.h0(1);
            }
        };
        this.m0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20587e;

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
                this.f20587e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20587e.Y();
                }
            }
        };
        this.n0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20591e;

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
                this.f20591e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20591e.f0(false);
                }
            }
        };
        this.o0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20592a;

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
                this.f20592a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f20592a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.f20592a.P) {
                            this.f20592a.l0(true);
                            return;
                        } else {
                            this.f20592a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.f20592a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.f20592a.l0(true);
                }
            }
        };
        this.p0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20593a;

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
                this.f20593a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.f20593a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.f20593a.l0(true);
                    }
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20594a;

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
                this.f20594a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f20594a.f0(true);
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
            advertAppInfo.V3 = str;
            c l = g.l(this.n, 303, i2, X(this.T), this.f20585i.video_duration.intValue(), this.R, -1);
            e eVar = this.l;
            if (eVar != null) {
                eVar.k(l);
            }
        }
    }

    public final void U(int i2) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (advertAppInfo = this.n) == null || (videoInfo = this.f20585i) == null) {
            return;
        }
        advertAppInfo.V3 = this.p;
        c l = g.l(advertAppInfo, SDKLogTypeConstants.CLOSE_GAME_TYPE, this.o, 1, videoInfo.video_duration.intValue(), d.a.s0.q.g.a.a(0), -1);
        boolean z = i2 == 1000;
        l.c(z ? "APP" : "URL");
        if (!z) {
            l.l(i2);
        }
        l.h("DEEPLINK");
        d.a.s0.w2.i0.e.b().d(l);
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.n0);
            d.a.c.e.m.e.a().postDelayed(this.n0, 5000L);
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
            public final /* synthetic */ DistributeVideoView f20595e;

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
                this.f20595e = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.f20595e.r.setMinFrame(0);
                    this.f20595e.r.setFrame(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f20595e.r.setVisibility(8);
                    this.f20595e.s.setVisibility(8);
                    DistributeVideoView distributeVideoView = this.f20595e;
                    distributeVideoView.l0(distributeVideoView.H);
                    if (this.f20595e.J == 1) {
                        this.f20595e.t.setVisibility(8);
                        this.f20595e.u.setVisibility(8);
                    } else {
                        this.f20595e.B.setPlayer(this.f20595e.q);
                        this.f20595e.B.p(0, (int) TimeUnit.SECONDS.toMillis(this.f20595e.f20585i.video_duration.intValue()));
                        this.f20595e.B.s();
                        this.f20595e.e0(true);
                        d.a.c.e.m.e.a().removeCallbacks(this.f20595e.m0);
                        d.a.c.e.m.e.a().postDelayed(this.f20595e.m0, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView distributeVideoView2 = this.f20595e;
                    distributeVideoView2.G = distributeVideoView2.q.getCurrentPosition();
                    this.f20595e.f0(true);
                    this.f20595e.a0.removeMessages(1003);
                    this.f20595e.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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
        this.f20582f = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.distribute_video_view, (ViewGroup) this, true);
        this.f20584h = inflate;
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) inflate.findViewById(R.id.distribute_texture);
        this.q = tbCyberVideoView;
        tbCyberVideoView.setStageType(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.q.setNoBussinessStats();
        this.r = (TBLottieAnimationView) this.f20584h.findViewById(R.id.video_play);
        this.s = (ForeDrawableImageView) this.f20584h.findViewById(R.id.distribute_thumbnail);
        this.t = (TextView) this.f20584h.findViewById(R.id.distribute_count_process);
        this.u = this.f20584h.findViewById(R.id.black_mask_top);
        this.x = this.f20584h.findViewById(R.id.distribute_error_tip);
        this.y = (TextView) this.f20584h.findViewById(R.id.distribute_error_tip_text);
        this.v = (ImageView) this.f20584h.findViewById(R.id.distribute_voice_feed);
        View findViewById = this.f20584h.findViewById(R.id.distribute_control);
        this.z = findViewById;
        this.A = (ImageView) findViewById.findViewById(R.id.distribute_play_icon);
        this.w = (ImageView) this.z.findViewById(R.id.distribute_voice);
        this.B = (VideoControllerView) this.z.findViewById(R.id.distribute_process);
        FrameLayout frameLayout = (FrameLayout) this.f20584h.findViewById(R.id.tail_frame_container);
        this.m = frameLayout;
        this.k = new d(context, frameLayout);
        TbImageView tbImageView = (TbImageView) this.f20584h.findViewById(R.id.bottom_picture);
        this.C = tbImageView;
        tbImageView.setVisibility(8);
        this.D = (RelativeLayout) this.f20584h.findViewById(R.id.video_container);
        this.r.setAnimation(R.raw.lotti_video_loading);
        this.r.setMinFrame(0);
        this.r.setFrame(0);
        b.f(this.u, R.drawable.video_mask_bg);
    }

    public final void a0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tbPageContext = this.f20581e) == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_1000);
        this.M = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20590a;

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
                this.f20590a = this;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                    this.f20590a.z.setVisibility(8);
                    this.f20590a.N = false;
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

    @Override // d.a.s0.w2.m
    public void autoPlay(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && R()) {
            if (i2 <= 0) {
                h0(1);
                return;
            }
            d.a.c.e.m.e.a().removeCallbacks(this.l0);
            d.a.c.e.m.e.a().postDelayed(this.l0, TimeUnit.SECONDS.toMillis(i2));
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
            if (TextUtils.isEmpty(str) || this.f20582f == null) {
                return 0;
            }
            if (x.B(this.n, str)) {
                return 3;
            }
            if (isPlaying() && a.h().t()) {
                return x.d(this.f20582f, str, this.n.getDownloadId(), this.n.S3);
            }
            return x.g(this.f20582f, str, this.n);
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
                if (!j.z() && (tbPageContext2 = this.f20581e) != null) {
                    tbPageContext2.showToast(R.string.neterror);
                } else if (!j.H() && (tbPageContext = this.f20581e) != null) {
                    d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(tbPageContext.getPageActivity());
                    aVar.setMessageId(R.string.play_video_mobile_tip);
                    aVar.setPositiveButton(R.string.alert_yes_button, new a.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ DistributeVideoView f20588e;

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
                            this.f20588e = this;
                        }

                        @Override // d.a.r0.r.s.a.e
                        public void onClick(d.a.r0.r.s.a aVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                aVar2.dismiss();
                                this.f20588e.performPlay();
                            }
                        }
                    });
                    aVar.setNegativeButton(R.string.cancel, new a.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: e  reason: collision with root package name */
                        public final /* synthetic */ DistributeVideoView f20589e;

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
                            this.f20589e = this;
                        }

                        @Override // d.a.r0.r.s.a.e
                        public void onClick(d.a.r0.r.s.a aVar2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                                aVar2.dismiss();
                            }
                        }
                    });
                    aVar.create(this.f20581e).show();
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
                    d.a.c.e.m.e.a().removeCallbacks(this.m0);
                    d.a.c.e.m.e.a().postDelayed(this.m0, TimeUnit.SECONDS.toMillis(3L));
                }
            }
        }
    }

    @Override // d.a.s0.w2.m
    public boolean canPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= l.i(this.f20582f);
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
                o0.e(this.E, true);
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
                d.a.c.e.m.e.a().removeCallbacks(this.m0);
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

    @Override // d.a.s0.w2.m
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.G : invokeV.longValue;
    }

    public VideoInfo getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.f20585i : (VideoInfo) invokeV.objValue;
    }

    @Override // d.a.s0.w2.m
    public int getPlayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.F : invokeV.intValue;
    }

    @Override // d.a.s0.w2.m
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            VideoInfo videoInfo = this.f20585i;
            return videoInfo != null ? videoInfo.video_url : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.s0.w2.m
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.T = i2;
            if (this.f20585i != null && this.F == -1) {
                if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.I) < TimeUnit.SECONDS.toSeconds(3L)) {
                    return;
                }
                e eVar = this.l;
                if (eVar != null) {
                    eVar.f();
                }
                this.q.setVideoPath(this.f20585i.video_url);
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
                TbPageContext<?> tbPageContext = this.f20581e;
                if (tbPageContext != null) {
                    tbPageContext.registerListener(this.q0);
                    this.f20581e.registerListener(this.o0);
                    this.f20581e.registerListener(this.p0);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f20584h.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            if (z) {
                int k = l.k(getContext());
                int c2 = d.a.s0.w2.f0.c.a.c(k);
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

    @Override // d.a.s0.w2.m
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getPlayStatus() != -1 : invokeV.booleanValue;
    }

    @Override // d.a.s0.w2.m
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? getPlayStatus() == 1 : invokeV.booleanValue;
    }

    public final void j0(int i2, int i3, int i4, int i5) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048606, this, i2, i3, i4, i5) == null) || (advertAppInfo = this.n) == null || (videoInfo = this.f20585i) == null) {
            return;
        }
        advertAppInfo.V3 = this.p;
        d.a.s0.w2.i0.e.b().d(g.l(advertAppInfo, i2, this.o, i3, videoInfo.video_duration.intValue(), d.a.s0.q.g.a.a(i4), i5));
    }

    public int jump2DownloadDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? b0() : invokeV.intValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.l0);
            d.a.c.e.m.e.a().removeCallbacks(this.m0);
            d.a.c.e.m.e.a().removeCallbacks(this.n0);
            this.a0.removeMessages(1001);
            this.a0.removeMessages(1003);
            this.q.stopPlayback();
            this.F = -1;
            o0.e(this.E, false);
            f0(false);
            this.s.setForegroundDrawable(0);
            this.s.setVisibility(0);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.A, R.drawable.icon_video_midpause);
            this.B.q();
            this.x.setVisibility(8);
            VideoInfo videoInfo = this.f20585i;
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
                    o0.e(this.E, true);
                }
            } else {
                TbCyberVideoView tbCyberVideoView2 = this.q;
                if (tbCyberVideoView2 != null) {
                    tbCyberVideoView2.setVolume(0.0f, 0.0f);
                }
                SkinManager.setImageResource(this.w, R.drawable.ad_icon_sound_close);
                SkinManager.setImageResource(this.v, R.drawable.icon_vedio_npronunciation_small_white);
                o0.e(this.E, false);
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
            if (!(this.l instanceof d.a.s0.w2.j0.a) || (adCard = this.K) == null || adCard.isDirectDownload()) {
                return;
            }
            ((d.a.s0.w2.j0.a) this.l).w();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AdCard adCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDetachedFromWindow();
            if (!(this.l instanceof d.a.s0.w2.j0.a) || (adCard = this.K) == null || adCard.isDirectDownload()) {
                return;
            }
            ((d.a.s0.w2.j0.a) this.l).B();
        }
    }

    public void pausePlay(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i2) == null) && this.F == 1) {
            j0(32, X(this.T), this.q.getCurrentPosition(), i2);
            this.q.pause();
            o0.e(this.E, false);
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

    @Override // d.a.s0.w2.m
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    public void setAdInfo(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, adCard) == null) {
            this.K = adCard;
        }
    }

    public void setData(VideoInfo videoInfo, int i2, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048617, this, videoInfo, i2, tbPageContext) == null) {
            if (i2 != 1 && i2 != 2) {
                BdLog.e("DistributeVideoView: invalid video style!");
                return;
            }
            this.J = i2;
            if (tbPageContext != null) {
                this.f20581e = tbPageContext;
                a0();
            }
            setData(videoInfo);
        }
    }

    public void setDownloadCallback(d.a.s0.n1.o.c cVar) {
        e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, cVar) == null) || (eVar = this.l) == null) {
            return;
        }
        eVar.h(cVar);
    }

    public void setHolderView(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, view) == null) || view == null) {
            return;
        }
        this.f20583g = view;
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, tbPageContext) == null) {
            this.f20581e = tbPageContext;
        }
    }

    public void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.L = str;
        }
    }

    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048623, this, advertAppInfo, i2, str) == null) {
            this.n = advertAppInfo;
            this.o = i2;
            this.p = str;
            T(advertAppInfo, i2, str);
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.U = z;
        }
    }

    public void setVideoScalingMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i2) == null) {
            this.V = i2;
            this.q.setVideoScalingMode(i2);
        }
    }

    public void setVideoTailFrameData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, fVar) == null) {
            this.j = fVar;
        }
    }

    @Override // d.a.s0.w2.m
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            autoPlay(0);
        }
    }

    @Override // d.a.s0.w2.m
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            stopPlay(true);
        }
    }

    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, advertAppInfo) == null) {
            if (advertAppInfo == null) {
                advertAppInfo = this.n;
            }
            e b2 = this.k.b(this.j, this.l);
            this.l = b2;
            if (b2 != null) {
                b2.j(this.f20581e);
                this.l.i(this.K);
                e eVar = this.l;
                if (eVar instanceof d.a.s0.w2.j0.a) {
                    ((d.a.s0.w2.j0.a) eVar).y(this.U);
                }
                this.l.g(advertAppInfo);
                this.l.d(this.j);
                this.l.f();
            }
        }
    }

    public void stopPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            if (this.q.getCurrentPosition() > 0 && this.F != -1 && z) {
                int currentPosition = this.q.getCurrentPosition();
                i0(this.q.getDuration() == currentPosition ? 34 : 32, X(this.T), currentPosition);
            }
            k0();
        }
    }

    public void setData(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, videoInfo) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.f20585i = videoInfo;
            this.R = videoInfo.video_duration.intValue() * 1000;
            this.E = new WeakReference<>(this.f20582f.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            int k = l.k(this.f20582f) - l.g(this.f20582f, R.dimen.ds146);
            if (this.J == 2) {
                k = l.k(this.f20582f);
            }
            int intValue = this.f20585i.video_width.intValue() > 0 ? (this.f20585i.video_height.intValue() * k) / this.f20585i.video_width.intValue() : k;
            ViewGroup.LayoutParams layoutParams = this.f20584h.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = intValue;
                this.f20584h.setLayoutParams(layoutParams);
            }
            setOnClickListener(this.W);
            this.s.setDefaultResource(0);
            this.s.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            if (!k.isEmpty(videoInfo.thumbnail_url)) {
                this.s.M(videoInfo.thumbnail_url, 10, false);
            }
            this.q.setOnPreparedListener(this.b0);
            if (d.a.s0.a.h().u()) {
                this.q.setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.q.setOnErrorListener(this.i0);
            this.q.setOnCompletionListener(this.j0);
            this.q.setOnInfoListener(this.c0);
            this.q.setOnSurfaceDestroyedListener(this.k0);
            SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
            this.t.setText(StringUtils.translateSecondsToString(this.f20585i.video_duration.intValue()));
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
            public final /* synthetic */ DistributeVideoView f20586e;

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
                this.f20586e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f20586e.x) {
                        this.f20586e.x.setVisibility(8);
                        this.f20586e.performPlay();
                    } else if (view != this.f20586e.w && view != this.f20586e.v) {
                        if (view == this.f20586e.r || view == this.f20586e.A) {
                            this.f20586e.c0();
                        } else if (this.f20586e.K == null) {
                            this.f20586e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f20586e.jump2DownloadDetailPage();
                            this.f20586e.S();
                            if (x.p(jump2DownloadDetailPage)) {
                                this.f20586e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f20586e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20596a;

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
                this.f20596a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i4 = message.what;
                    if (i4 != 1001) {
                        if (i4 == 1003 && this.f20596a.F == 1) {
                            if (this.f20596a.G == this.f20596a.q.getCurrentPosition()) {
                                this.f20596a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.f20596a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.f20596a.setLoadingAnimShow(false);
                            }
                            this.f20596a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.f20596a.F == 1) {
                    } else {
                        if (!d.a.s0.a.h().u() ? this.f20596a.q.getCurrentPosition() <= 0 : !this.f20596a.q.isPlaying()) {
                            this.f20596a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.f20596a.F = 1;
                        this.f20596a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20597e;

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
                this.f20597e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f20597e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f20597e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f20597e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f20597e.q.setVolume(0.0f, 0.0f);
                this.f20597e.a0.removeMessages(1001);
                this.f20597e.a0.sendEmptyMessage(1001);
                if (this.f20597e.H && this.f20597e.J == 1) {
                    this.f20597e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20598e;

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
                this.f20598e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    if (i4 == 3 && this.f20598e.n != null) {
                        DistributeVideoView distributeVideoView = this.f20598e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.V3)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f20598e;
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
            public final /* synthetic */ DistributeVideoView f20599e;

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
                this.f20599e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i4, i5, obj)) == null) {
                    this.f20599e.k0();
                    if (this.f20599e.q != null) {
                        DistributeVideoView distributeVideoView = this.f20599e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f20599e.q.getCurrentPosition());
                    }
                    this.f20599e.s.setForegroundDrawable(0);
                    this.f20599e.setLoadingAnimShow(false);
                    this.f20599e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.j0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20600e;

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
                this.f20600e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20600e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f20600e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f20600e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f20600e.q.getDuration());
                    }
                    this.f20600e.k0();
                    if (this.f20600e.l != null) {
                        this.f20600e.l.e();
                        this.f20600e.t.setVisibility(8);
                        this.f20600e.u.setVisibility(8);
                        this.f20600e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.k0 = new TbCyberVideoView.g(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20601e;

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
                this.f20601e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20601e.stopPlay();
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20602e;

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
                this.f20602e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f20602e.f20585i == null || this.f20602e.q == null || !this.f20602e.canPlay()) {
                    return;
                }
                this.f20602e.h0(1);
            }
        };
        this.m0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20587e;

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
                this.f20587e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20587e.Y();
                }
            }
        };
        this.n0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20591e;

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
                this.f20591e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20591e.f0(false);
                }
            }
        };
        this.o0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20592a;

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
                this.f20592a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f20592a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.f20592a.P) {
                            this.f20592a.l0(true);
                            return;
                        } else {
                            this.f20592a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.f20592a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.f20592a.l0(true);
                }
            }
        };
        this.p0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20593a;

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
                this.f20593a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.f20593a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.f20593a.l0(true);
                    }
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20594a;

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
                this.f20594a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f20594a.f0(true);
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
            public final /* synthetic */ DistributeVideoView f20586e;

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
                this.f20586e = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    if (view == this.f20586e.x) {
                        this.f20586e.x.setVisibility(8);
                        this.f20586e.performPlay();
                    } else if (view != this.f20586e.w && view != this.f20586e.v) {
                        if (view == this.f20586e.r || view == this.f20586e.A) {
                            this.f20586e.c0();
                        } else if (this.f20586e.K == null) {
                            this.f20586e.c0();
                        } else {
                            int jump2DownloadDetailPage = this.f20586e.jump2DownloadDetailPage();
                            this.f20586e.S();
                            if (x.p(jump2DownloadDetailPage)) {
                                this.f20586e.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.f20586e;
                        distributeVideoView.l0(!distributeVideoView.H);
                    }
                }
            }
        };
        this.a0 = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20596a;

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
                this.f20596a = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                    int i42 = message.what;
                    if (i42 != 1001) {
                        if (i42 == 1003 && this.f20596a.F == 1) {
                            if (this.f20596a.G == this.f20596a.q.getCurrentPosition()) {
                                this.f20596a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.f20596a;
                                distributeVideoView.G = distributeVideoView.q.getCurrentPosition();
                                this.f20596a.setLoadingAnimShow(false);
                            }
                            this.f20596a.a0.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.f20596a.F == 1) {
                    } else {
                        if (!d.a.s0.a.h().u() ? this.f20596a.q.getCurrentPosition() <= 0 : !this.f20596a.q.isPlaying()) {
                            this.f20596a.a0.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.f20596a.F = 1;
                        this.f20596a.W();
                    }
                }
            }
        };
        this.b0 = new CyberPlayerManager.OnPreparedListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20597e;

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
                this.f20597e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f20597e.q == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.f20597e;
                distributeVideoView.Q = distributeVideoView.q.getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.f20597e;
                distributeVideoView2.R = distributeVideoView2.q.getDuration();
                this.f20597e.q.setVolume(0.0f, 0.0f);
                this.f20597e.a0.removeMessages(1001);
                this.f20597e.a0.sendEmptyMessage(1001);
                if (this.f20597e.H && this.f20597e.J == 1) {
                    this.f20597e.l0(false);
                }
            }
        };
        this.c0 = new CyberPlayerManager.OnInfoListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20598e;

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
                this.f20598e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i42, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i42, i5, obj)) == null) {
                    if (i42 == 3 && this.f20598e.n != null) {
                        DistributeVideoView distributeVideoView = this.f20598e;
                        int i6 = (distributeVideoView.S && "DETAIL".equals(distributeVideoView.n.V3)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.f20598e;
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
            public final /* synthetic */ DistributeVideoView f20599e;

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
                this.f20599e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i42, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048576, this, i42, i5, obj)) == null) {
                    this.f20599e.k0();
                    if (this.f20599e.q != null) {
                        DistributeVideoView distributeVideoView = this.f20599e;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.T), this.f20599e.q.getCurrentPosition());
                    }
                    this.f20599e.s.setForegroundDrawable(0);
                    this.f20599e.setLoadingAnimShow(false);
                    this.f20599e.x.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }
        };
        this.j0 = new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20600e;

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
                this.f20600e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20600e.I = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.f20600e;
                    distributeVideoView.S = true;
                    if (distributeVideoView.q != null) {
                        DistributeVideoView distributeVideoView2 = this.f20600e;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.T), this.f20600e.q.getDuration());
                    }
                    this.f20600e.k0();
                    if (this.f20600e.l != null) {
                        this.f20600e.l.e();
                        this.f20600e.t.setVisibility(8);
                        this.f20600e.u.setVisibility(8);
                        this.f20600e.setLoadingAnimShow(false);
                    }
                }
            }
        };
        this.k0 = new TbCyberVideoView.g(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20601e;

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
                this.f20601e = this;
            }

            @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20601e.stopPlay();
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20602e;

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
                this.f20602e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f20602e.f20585i == null || this.f20602e.q == null || !this.f20602e.canPlay()) {
                    return;
                }
                this.f20602e.h0(1);
            }
        };
        this.m0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20587e;

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
                this.f20587e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20587e.Y();
                }
            }
        };
        this.n0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20591e;

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
                this.f20591e = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f20591e.f0(false);
                }
            }
        };
        this.o0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20592a;

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
                this.f20592a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f20592a.J == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.f20592a.P) {
                            this.f20592a.l0(true);
                            return;
                        } else {
                            this.f20592a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.f20592a;
                    distributeVideoView.P = distributeVideoView.H;
                    this.f20592a.l0(true);
                }
            }
        };
        this.p0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.16
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20593a;

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
                this.f20593a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.f20593a.J == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.f20593a.l0(true);
                    }
                }
            }
        };
        this.q0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.17
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ DistributeVideoView f20594a;

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
                this.f20594a = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) {
                    this.f20594a.f0(true);
                }
            }
        };
        Z(context);
    }

    public void setData(VideoInfo videoInfo, d.a.s0.w2.f0.b.e eVar, int i2, int i3, int i4, int i5) {
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{videoInfo, eVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.f20585i = videoInfo;
            this.E = new WeakReference<>(this.f20582f.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20584h.getLayoutParams();
            layoutParams.width = i4;
            layoutParams.height = i5;
            setOnClickListener(this.W);
            int i7 = 13;
            if (eVar != null && eVar.a()) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
                layoutParams2.width = i4;
                layoutParams2.height = i5;
                this.C.M(eVar.f69147a, 30, false);
                this.C.setVisibility(0);
                double d2 = eVar.f69148b;
                if (d2 > 0.0d) {
                    i2 = (int) (i4 * d2);
                    i3 = d.a.s0.w2.f0.c.a.b(i2);
                }
                double d3 = eVar.f69149c;
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
            this.s.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            if (!k.isEmpty(videoInfo.thumbnail_url)) {
                this.s.M(videoInfo.thumbnail_url, 10, false);
            }
            this.q.setOnPreparedListener(this.b0);
            if (d.a.s0.a.h().u()) {
                this.q.setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.q.setOnErrorListener(this.i0);
            this.q.setOnCompletionListener(this.j0);
            this.q.setOnInfoListener(this.c0);
            this.q.setOnSurfaceDestroyedListener(this.k0);
            SkinManager.setViewTextColor(this.t, R.color.cp_cont_m);
            this.t.setText(StringUtils.translateSecondsToString(this.f20585i.video_duration.intValue()));
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
