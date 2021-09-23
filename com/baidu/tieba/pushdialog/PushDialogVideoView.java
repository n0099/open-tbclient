package com.baidu.tieba.pushdialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.p2.n;
import c.a.r0.p2.o;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public c.a.q0.f1.m.i G;
    public CyberPlayerManager.OnPreparedListener H;
    public VideoLoadingProgressView.c I;
    public Runnable J;
    public CyberPlayerManager.OnCompletionListener K;
    public CyberPlayerManager.OnErrorListener L;
    public Runnable M;
    public CyberPlayerManager.OnSeekCompleteListener N;
    public Runnable O;
    public TbCyberVideoView.h P;
    public CustomMessageListener Q;
    public Handler R;
    public VideoControllerView.d S;

    /* renamed from: e  reason: collision with root package name */
    public int f56368e;

    /* renamed from: f  reason: collision with root package name */
    public int f56369f;

    /* renamed from: g  reason: collision with root package name */
    public int f56370g;

    /* renamed from: h  reason: collision with root package name */
    public int f56371h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f56372i;

    /* renamed from: j  reason: collision with root package name */
    public TbCyberVideoView f56373j;
    public c.a.r0.p2.m k;
    public ProgressBar l;
    public View m;
    public View n;
    public ImageView o;
    public TextView p;
    public TextView q;
    public String r;
    public String s;
    public TbImageView t;
    public PbVideoWifiTipLayout u;
    public boolean v;
    public int w;
    public CallStateReceiver x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56374a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PushDialogVideoView pushDialogVideoView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56374a = pushDialogVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.f56374a.pausePlay();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56375a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PushDialogVideoView pushDialogVideoView, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56375a = pushDialogVideoView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && this.f56375a.f56373j != null && this.f56375a.f56373j.isPlaying()) {
                int currentPosition = this.f56375a.f56373j.getCurrentPosition();
                int duration = this.f56375a.f56373j.getDuration();
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                if (this.f56375a.S != null) {
                    this.f56375a.S.a(currentPosition);
                }
                sendMessageDelayed(obtainMessage(1), this.f56375a.f56368e - (currentPosition % this.f56375a.f56368e));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56376a;

        public c(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56376a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            int duration;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f56376a.f56373j == null || (duration = this.f56376a.f56373j.getDuration()) <= 0 || this.f56376a.l == null) {
                return;
            }
            this.f56376a.l.setProgress((int) ((i2 * this.f56376a.getWidth()) / duration));
        }
    }

    /* loaded from: classes7.dex */
    public class d implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56377e;

        public d(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56377e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56377e.k.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56378a;

        public e(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56378a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56378a.D();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56379e;

        public f(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56379e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56379e.f56373j.getCurrentPosition() > 100) {
                    this.f56379e.v = true;
                    this.f56379e.m.setVisibility(8);
                    this.f56379e.n.setVisibility(8);
                    this.f56379e.k.c();
                    this.f56379e.t.setVisibility(8);
                    this.f56379e.showProgress();
                    return;
                }
                c.a.e.e.m.e.a().postDelayed(this.f56379e.J, 20L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56380e;

        public g(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56380e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56380e.v = false;
                this.f56380e.D = false;
                this.f56380e.w = 0;
                this.f56380e.m.setVisibility(0);
                this.f56380e.l.setVisibility(8);
                this.f56380e.l.setProgress(this.f56380e.l.getMax());
                if (this.f56380e.f56373j == null || this.f56380e.f56373j.getDuration() > 150000) {
                    this.f56380e.y(false);
                } else {
                    this.f56380e.p.setVisibility(0);
                }
                n.d().e(this.f56380e.r);
                if (this.f56380e.f56373j == null || this.f56380e.f56373j.getDuration() > 150000) {
                    return;
                }
                PushDialogVideoView pushDialogVideoView = this.f56380e;
                pushDialogVideoView.startPlay(pushDialogVideoView.r, this.f56380e.s);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56381e;

        public h(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56381e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f56381e.n.setVisibility(0);
                this.f56381e.k.b();
                if (!c.a.e.e.p.j.z()) {
                    this.f56381e.B = true;
                }
                this.f56381e.D = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56382e;

        public i(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56382e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56382e.n.setVisibility(0);
                this.f56382e.k.b();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56383e;

        public j(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56383e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f56383e.z) {
                c.a.e.e.m.e.a().postDelayed(this.f56383e.O, 200L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56384e;

        public k(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56384e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f56384e.f56373j == null || !this.f56384e.z) {
                    c.a.e.e.m.e.a().postDelayed(this.f56384e.J, 200L);
                    this.f56384e.z = false;
                } else if (this.f56384e.w != this.f56384e.f56373j.getCurrentPosition()) {
                    this.f56384e.z = false;
                    c.a.e.e.m.e.a().postDelayed(this.f56384e.J, 20L);
                } else {
                    c.a.e.e.m.e.a().postDelayed(this.f56384e.O, 200L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f56385e;

        public l(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56385e = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56385e.v = false;
                this.f56385e.D = false;
                c.a.e.e.m.e.a().removeCallbacks(this.f56385e.J);
                c.a.e.e.m.e.a().removeCallbacks(this.f56385e.M);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface m {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushDialogVideoView(Context context) {
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
        this.f56368e = 50;
        this.f56369f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new d(this);
        this.I = new e(this);
        this.J = new f(this);
        this.K = new g(this);
        this.L = new h(this);
        this.M = new i(this);
        this.N = new j(this);
        this.O = new k(this);
        this.P = new l(this);
        this.Q = new a(this, 2016503);
        this.R = new b(this, Looper.getMainLooper());
        this.S = new c(this);
        x(context);
    }

    public final void A(m mVar, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{mVar, Boolean.valueOf(z), str, str2}) == null) {
            if (this.A) {
                startPlayWithCache(str, str2);
            } else {
                startPlay(str, str2);
            }
            if (mVar != null) {
                mVar.a(z);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            startPlayWithNetCheck(this.r, this.s, null, new Object[0]);
        }
    }

    public final void D() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbCyberVideoView = this.f56373j) == null) {
            return;
        }
        if (this.D) {
            tbCyberVideoView.start();
            this.D = false;
        }
        c.a.e.e.m.e.a().removeCallbacks(this.J);
        c.a.e.e.m.e.a().postDelayed(this.J, 20L);
        c.a.e.e.m.e.a().removeCallbacks(this.M);
        int c2 = n.d().c(this.r);
        this.w = c2;
        if (c2 != 0) {
            this.f56373j.seekTo(c2);
            if (!this.C) {
                showProgress();
                c.a.e.e.m.e.a().removeCallbacks(this.J);
            }
            this.z = true;
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f56373j;
            if (tbCyberVideoView == null) {
                return 0;
            }
            return tbCyberVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public boolean isShow() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? getVisibility() == 0 : invokeV.booleanValue;
    }

    public boolean isVideoPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.f56373j;
            if (tbCyberVideoView == null) {
                return false;
            }
            return tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f56369f) {
            return;
        }
        this.f56369f = skinType;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            if (view == this.n) {
                B();
            } else if (view == this) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 2).param("tid", this.s));
                resumeOrPlayVideo();
            } else if (view == this.p) {
                startPlay(this.r, this.s);
            } else if (view == this.u.getTvPlay()) {
                this.F = true;
                this.u.setVisibility(8);
                startPlay(this.r, this.s);
            } else if (view != this.u.getTvOpenFreeData() || (tbPageContext = this.f56372i) == null) {
            } else {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            stopPlay();
            c.a.e.e.m.e.a().removeCallbacks(this.J);
            c.a.e.e.m.e.a().removeCallbacks(this.M);
            c.a.e.e.m.e.a().removeCallbacks(this.O);
            this.R.removeMessages(1);
            this.x.unregister(getContext());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.f56370g, this.f56371h);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (isVideoPlaying()) {
                this.E = true;
                pausePlay();
                return;
            }
            this.E = false;
            pausePlay();
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.E) {
            resumePlay();
        }
    }

    public void pausePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.f56373j.isPlaying() && this.y) {
                saveUpdatePosition();
            }
            this.f56373j.pause();
            setPauseState();
        }
    }

    public void resetPlayerUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            y(true);
        }
    }

    public void resumeOrPlayVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!c.a.e.e.p.j.z()) {
                c.a.e.e.p.l.J(getContext(), getContext().getString(R.string.neterror));
            } else if (this.f56373j.isPlaying()) {
                pausePlay();
            } else if (this.v) {
                resumePlay();
            } else {
                B();
            }
        }
    }

    public void resumePlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f56373j.start();
            this.t.setVisibility(8);
            this.m.setVisibility(8);
            this.k.b();
            showProgress();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    public void saveUpdatePosition() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            n.d().f(this.r, this.f56373j.getCurrentPositionSync());
        }
    }

    public void setNetworkChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && c.a.e.e.p.j.z() && this.B && !StringUtils.isNull(this.r) && !StringUtils.isNull(this.s)) {
            this.B = false;
            this.C = true;
            startPlay(this.r, this.s);
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbPageContext) == null) {
            this.f56372i = tbPageContext;
            tbPageContext.registerListener(this.Q);
        }
    }

    public void setPauseState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.k.b();
            this.o.setVisibility(0);
            this.p.setVisibility(8);
        }
    }

    public void setTbRichTextVideoInfo(c.a.q0.f1.m.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, iVar) == null) {
            this.G = iVar;
            this.q.setText(StringHelper.stringForVideoTime(iVar.b() * 1000));
        }
    }

    public void setThumbnail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.t.startLoad(str, 17, false);
        }
    }

    public void setVideoUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) {
            this.r = str;
            this.s = str2;
        }
    }

    public void setVideoViewBusiness(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, oVar) == null) {
            this.f56373j.setVideoStatData(oVar);
        }
    }

    public void showProgress() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f56373j == null) {
            return;
        }
        this.l.setVisibility(0);
        int duration = ((this.f56373j.getDuration() / 200) / 50) * 50;
        this.f56368e = duration;
        if (duration < 50) {
            this.f56368e = 50;
        } else if (duration > 500) {
            this.f56368e = 500;
        }
        this.R.removeMessages(1);
        Handler handler = this.R;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f56368e - (this.f56373j.getCurrentPosition() % this.f56368e));
    }

    public void startPlay(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            z();
            this.D = true;
            setVideoUrl(str, str2);
            this.f56373j.setVideoPath(str, str2);
            this.k.g();
            this.t.setVisibility(0);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            c.a.e.e.m.e.a().removeCallbacks(this.M);
            c.a.e.e.m.e.a().postDelayed(this.M, 60000L);
        }
    }

    public void startPlayWithCache(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            z();
            this.D = true;
            this.k.g();
            this.t.setVisibility(0);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            c.a.e.e.m.e.a().removeCallbacks(this.M);
            c.a.e.e.m.e.a().postDelayed(this.M, 60000L);
        }
    }

    public void startPlayWithNetCheck(String str, String str2, m mVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, str, str2, mVar, objArr) == null) {
            z();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.A = ((Boolean) objArr[0]).booleanValue();
            }
            if (c.a.e.e.p.j.x() && !this.F && !c.a.r0.x3.h.d().e()) {
                this.u.setVisibility(0);
                this.u.setData(this.G.b(), this.G.c());
                return;
            }
            A(mVar, true, str, str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.f56373j.isPlaying() && this.y) {
                saveUpdatePosition();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.J);
            c.a.e.e.m.e.a().removeCallbacks(this.M);
            this.f56373j.stopPlayback();
            this.v = false;
            this.D = false;
            this.w = 0;
            resetPlayerUI();
        }
    }

    public void updateBottomProgress() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.f56373j == null) {
            return;
        }
        this.l.setMax(c.a.e.e.p.l.k(getContext()));
        int duration = this.f56373j.getDuration();
        if (duration > 0) {
            if (this.p.getVisibility() == 0) {
                ProgressBar progressBar = this.l;
                progressBar.setProgress(progressBar.getMax());
                return;
            }
            this.l.setProgress((int) ((this.f56373j.getCurrentPosition() * this.l.getMax()) / duration));
        }
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
            int k2 = c.a.e.e.p.l.k(context) - c.a.e.e.p.l.g(context, R.dimen.tbds132);
            this.f56370g = k2;
            this.f56371h = (int) (k2 * 0.5625f);
            TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) findViewById(R.id.videoView);
            this.f56373j = tbCyberVideoView;
            tbCyberVideoView.setPlayMode("2");
            this.f56373j.setStageType(null);
            c.a.r0.p2.m mVar = new c.a.r0.p2.m((ViewGroup) findViewById(R.id.auto_video_loading_container));
            this.k = mVar;
            mVar.f(this.I);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pgrBottomProgress);
            this.l = progressBar;
            progressBar.setMax(this.f56370g);
            this.l.setProgress(0);
            this.m = findViewById(R.id.black_mask);
            this.n = findViewById(R.id.layout_error);
            this.o = (ImageView) findViewById(R.id.img_play);
            this.p = (TextView) findViewById(R.id.txt_replay);
            this.q = (TextView) findViewById(R.id.push_dialog_video_time);
            this.t = (TbImageView) findViewById(R.id.video_thumbnail);
            this.u = (PbVideoWifiTipLayout) findViewById(R.id.layout_wifi_tip);
            this.t.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            CallStateReceiver callStateReceiver = new CallStateReceiver();
            this.x = callStateReceiver;
            callStateReceiver.register(context);
            this.n.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.u.setOnPlayClickListener(this);
            this.u.setFreeClickListener(this);
            setOnClickListener(this);
            this.f56373j.setOnPreparedListener(this.H);
            this.f56373j.setOnCompletionListener(this.K);
            this.f56373j.setOnErrorListener(this.L);
            this.f56373j.setOnSeekCompleteListener(this.N);
            this.f56373j.setOnSurfaceDestroyedListener(this.P);
            onChangeSkinType();
        }
    }

    public final void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.p.setVisibility(8);
            this.k.b();
            this.l.setVisibility(8);
            this.n.setVisibility(8);
            this.R.removeMessages(1);
            this.t.setVisibility(z ? 0 : 8);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && c.a.e.e.p.j.x()) {
            c.a.r0.x3.h.d().g(getContext());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushDialogVideoView(Context context, AttributeSet attributeSet) {
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
        this.f56368e = 50;
        this.f56369f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new d(this);
        this.I = new e(this);
        this.J = new f(this);
        this.K = new g(this);
        this.L = new h(this);
        this.M = new i(this);
        this.N = new j(this);
        this.O = new k(this);
        this.P = new l(this);
        this.Q = new a(this, 2016503);
        this.R = new b(this, Looper.getMainLooper());
        this.S = new c(this);
        x(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushDialogVideoView(Context context, AttributeSet attributeSet, int i2) {
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
        this.f56368e = 50;
        this.f56369f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new d(this);
        this.I = new e(this);
        this.J = new f(this);
        this.K = new g(this);
        this.L = new h(this);
        this.M = new i(this);
        this.N = new j(this);
        this.O = new k(this);
        this.P = new l(this);
        this.Q = new a(this, 2016503);
        this.R = new b(this, Looper.getMainLooper());
        this.S = new c(this);
        x(context);
    }
}
