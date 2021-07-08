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
import d.a.p0.n2.n;
import d.a.p0.n2.o;
/* loaded from: classes4.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public d.a.o0.b1.m.i G;
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
    public int f20424e;

    /* renamed from: f  reason: collision with root package name */
    public int f20425f;

    /* renamed from: g  reason: collision with root package name */
    public int f20426g;

    /* renamed from: h  reason: collision with root package name */
    public int f20427h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f20428i;
    public TbCyberVideoView j;
    public d.a.p0.n2.m k;
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

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20429a;

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
            this.f20429a = pushDialogVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.f20429a.G();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20430a;

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
            this.f20430a = pushDialogVideoView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && this.f20430a.j != null && this.f20430a.j.isPlaying()) {
                int currentPosition = this.f20430a.j.getCurrentPosition();
                int duration = this.f20430a.j.getDuration();
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                if (this.f20430a.S != null) {
                    this.f20430a.S.a(currentPosition);
                }
                sendMessageDelayed(obtainMessage(1), this.f20430a.f20424e - (currentPosition % this.f20430a.f20424e));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20431a;

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
            this.f20431a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            int duration;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f20431a.j == null || (duration = this.f20431a.j.getDuration()) <= 0 || this.f20431a.l == null) {
                return;
            }
            this.f20431a.l.setProgress((int) ((i2 * this.f20431a.getWidth()) / duration));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20432e;

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
            this.f20432e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20432e.k.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20433a;

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
            this.f20433a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20433a.T();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20434e;

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
            this.f20434e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20434e.j.getCurrentPosition() > 100) {
                    this.f20434e.v = true;
                    this.f20434e.m.setVisibility(8);
                    this.f20434e.n.setVisibility(8);
                    this.f20434e.k.c();
                    this.f20434e.t.setVisibility(8);
                    this.f20434e.N();
                    return;
                }
                d.a.c.e.m.e.a().postDelayed(this.f20434e.J, 20L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20435e;

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
            this.f20435e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20435e.v = false;
                this.f20435e.D = false;
                this.f20435e.w = 0;
                this.f20435e.m.setVisibility(0);
                this.f20435e.l.setVisibility(8);
                this.f20435e.l.setProgress(this.f20435e.l.getMax());
                if (this.f20435e.j == null || this.f20435e.j.getDuration() > 150000) {
                    this.f20435e.I(false);
                } else {
                    this.f20435e.p.setVisibility(0);
                }
                n.d().e(this.f20435e.r);
                if (this.f20435e.j == null || this.f20435e.j.getDuration() > 150000) {
                    return;
                }
                PushDialogVideoView pushDialogVideoView = this.f20435e;
                pushDialogVideoView.O(pushDialogVideoView.r, this.f20435e.s);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20436e;

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
            this.f20436e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                this.f20436e.n.setVisibility(0);
                this.f20436e.k.b();
                if (!d.a.c.e.p.j.z()) {
                    this.f20436e.B = true;
                }
                this.f20436e.D = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20437e;

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
            this.f20437e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20437e.n.setVisibility(0);
                this.f20437e.k.b();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements CyberPlayerManager.OnSeekCompleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20438e;

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
            this.f20438e = pushDialogVideoView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f20438e.z) {
                d.a.c.e.m.e.a().postDelayed(this.f20438e.O, 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20439e;

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
            this.f20439e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f20439e.j == null || !this.f20439e.z) {
                    d.a.c.e.m.e.a().postDelayed(this.f20439e.J, 200L);
                    this.f20439e.z = false;
                } else if (this.f20439e.w != this.f20439e.j.getCurrentPosition()) {
                    this.f20439e.z = false;
                    d.a.c.e.m.e.a().postDelayed(this.f20439e.J, 20L);
                } else {
                    d.a.c.e.m.e.a().postDelayed(this.f20439e.O, 200L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements TbCyberVideoView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f20440e;

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
            this.f20440e = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.h
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20440e.v = false;
                this.f20440e.D = false;
                d.a.c.e.m.e.a().removeCallbacks(this.f20440e.J);
                d.a.c.e.m.e.a().removeCallbacks(this.f20440e.M);
            }
        }
    }

    /* loaded from: classes4.dex */
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
        this.f20424e = 50;
        this.f20425f = 3;
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

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            stopPlay();
            d.a.c.e.m.e.a().removeCallbacks(this.J);
            d.a.c.e.m.e.a().removeCallbacks(this.M);
            d.a.c.e.m.e.a().removeCallbacks(this.O);
            this.R.removeMessages(1);
            this.x.unregister(getContext());
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (y()) {
                this.E = true;
                G();
                return;
            }
            this.E = false;
            G();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.E) {
            K();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.j.isPlaying() && this.y) {
                L();
            }
            this.j.pause();
            setPauseState();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            I(true);
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
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

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (!d.a.c.e.p.j.z()) {
                d.a.c.e.p.l.J(getContext(), getContext().getString(R.string.neterror));
            } else if (this.j.isPlaying()) {
                G();
            } else if (this.v) {
                K();
            } else {
                R();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.j.start();
            this.t.setVisibility(8);
            this.m.setVisibility(8);
            this.k.b();
            N();
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            n.d().f(this.r, this.j.getCurrentPositionSync());
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && d.a.c.e.p.j.x()) {
            d.a.p0.v3.f.d().g(getContext());
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.j == null) {
            return;
        }
        this.l.setVisibility(0);
        int duration = ((this.j.getDuration() / 200) / 50) * 50;
        this.f20424e = duration;
        if (duration < 50) {
            this.f20424e = 50;
        } else if (duration > 500) {
            this.f20424e = 500;
        }
        this.R.removeMessages(1);
        Handler handler = this.R;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f20424e - (this.j.getCurrentPosition() % this.f20424e));
    }

    public void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            M();
            this.D = true;
            setVideoUrl(str, str2);
            this.j.setVideoPath(str, str2);
            this.k.g();
            this.t.setVisibility(0);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            d.a.c.e.m.e.a().removeCallbacks(this.M);
            d.a.c.e.m.e.a().postDelayed(this.M, 60000L);
        }
    }

    public final void P(m mVar, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{mVar, Boolean.valueOf(z), str, str2}) == null) {
            if (this.A) {
                Q(str, str2);
            } else {
                O(str, str2);
            }
            if (mVar != null) {
                mVar.a(z);
            }
        }
    }

    public void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) {
            M();
            this.D = true;
            this.k.g();
            this.t.setVisibility(0);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            d.a.c.e.m.e.a().removeCallbacks(this.M);
            d.a.c.e.m.e.a().postDelayed(this.M, 60000L);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            S(this.r, this.s, null, new Object[0]);
        }
    }

    public void S(String str, String str2, m mVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048591, this, str, str2, mVar, objArr) == null) {
            M();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.A = ((Boolean) objArr[0]).booleanValue();
            }
            if (d.a.c.e.p.j.x() && !this.F && !d.a.p0.v3.f.d().e()) {
                this.u.setVisibility(0);
                this.u.setData(this.G.b(), this.G.c());
                return;
            }
            P(mVar, true, str, str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public final void T() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tbCyberVideoView = this.j) == null) {
            return;
        }
        if (this.D) {
            tbCyberVideoView.start();
            this.D = false;
        }
        d.a.c.e.m.e.a().removeCallbacks(this.J);
        d.a.c.e.m.e.a().postDelayed(this.J, 20L);
        d.a.c.e.m.e.a().removeCallbacks(this.M);
        int c2 = n.d().c(this.r);
        this.w = c2;
        if (c2 != 0) {
            this.j.seekTo(c2);
            if (!this.C) {
                N();
                d.a.c.e.m.e.a().removeCallbacks(this.J);
            }
            this.z = true;
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.j;
            if (tbCyberVideoView == null) {
                return 0;
            }
            return tbCyberVideoView.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            if (view == this.n) {
                R();
            } else if (view == this) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 2).param("tid", this.s));
                J();
            } else if (view == this.p) {
                O(this.r, this.s);
            } else if (view == this.u.getTvPlay()) {
                this.F = true;
                this.u.setVisibility(8);
                O(this.r, this.s);
            } else if (view != this.u.getTvOpenFreeData() || (tbPageContext = this.f20428i) == null) {
            } else {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.f20426g, this.f20427h);
        }
    }

    public void setNetworkChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && d.a.c.e.p.j.z() && this.B && !StringUtils.isNull(this.r) && !StringUtils.isNull(this.s)) {
            this.B = false;
            this.C = true;
            O(this.r, this.s);
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContext) == null) {
            this.f20428i = tbPageContext;
            tbPageContext.registerListener(this.Q);
        }
    }

    public void setPauseState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.k.b();
            this.o.setVisibility(0);
            this.p.setVisibility(8);
        }
    }

    public void setTbRichTextVideoInfo(d.a.o0.b1.m.i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, iVar) == null) {
            this.G = iVar;
            this.q.setText(StringHelper.stringForVideoTime(iVar.b() * 1000));
        }
    }

    public void setThumbnail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.t.M(str, 17, false);
        }
    }

    public void setVideoUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            this.r = str;
            this.s = str2;
        }
    }

    public void setVideoViewBusiness(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, oVar) == null) {
            this.j.setVideoStatData(oVar);
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (this.j.isPlaying() && this.y) {
                L();
            }
            d.a.c.e.m.e.a().removeCallbacks(this.J);
            d.a.c.e.m.e.a().removeCallbacks(this.M);
            this.j.stopPlayback();
            this.v = false;
            this.D = false;
            this.w = 0;
            H();
        }
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
            int k2 = d.a.c.e.p.l.k(context) - d.a.c.e.p.l.g(context, R.dimen.tbds132);
            this.f20426g = k2;
            this.f20427h = (int) (k2 * 0.5625f);
            TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) findViewById(R.id.videoView);
            this.j = tbCyberVideoView;
            tbCyberVideoView.setPlayMode("2");
            this.j.setStageType(null);
            d.a.p0.n2.m mVar = new d.a.p0.n2.m((ViewGroup) findViewById(R.id.auto_video_loading_container));
            this.k = mVar;
            mVar.f(this.I);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pgrBottomProgress);
            this.l = progressBar;
            progressBar.setMax(this.f20426g);
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
            this.j.setOnPreparedListener(this.H);
            this.j.setOnCompletionListener(this.K);
            this.j.setOnErrorListener(this.L);
            this.j.setOnSeekCompleteListener(this.N);
            this.j.setOnSurfaceDestroyedListener(this.P);
            z();
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            TbCyberVideoView tbCyberVideoView = this.j;
            if (tbCyberVideoView == null) {
                return false;
            }
            return tbCyberVideoView.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void z() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f20425f) {
            return;
        }
        this.f20425f = skinType;
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
        this.f20424e = 50;
        this.f20425f = 3;
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
        this.f20424e = 50;
        this.f20425f = 3;
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
