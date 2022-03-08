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
import c.a.d.f.p.l;
import c.a.d.f.p.n;
import c.a.q0.r.r.e2;
import c.a.r0.a3.q;
import c.a.r0.a3.s;
import c.a.r0.a3.t;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public c.a.q0.e1.n.j G;
    public c.a.r0.a3.v.a H;
    public VideoLoadingProgressView.c I;
    public Runnable J;
    public Runnable K;
    public Runnable L;
    public TbVideoViewContainer.a M;
    public CustomMessageListener N;
    public Handler O;
    public VideoControllerView.d P;

    /* renamed from: e  reason: collision with root package name */
    public int f46030e;

    /* renamed from: f  reason: collision with root package name */
    public int f46031f;

    /* renamed from: g  reason: collision with root package name */
    public int f46032g;

    /* renamed from: h  reason: collision with root package name */
    public int f46033h;

    /* renamed from: i  reason: collision with root package name */
    public TbPageContext<?> f46034i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.a3.g f46035j;
    public q k;
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

    /* loaded from: classes6.dex */
    public class a implements c.a.r0.a3.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f46036e;

        public a(PushDialogVideoView pushDialogVideoView) {
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
            this.f46036e = pushDialogVideoView;
        }

        @Override // c.a.r0.a3.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.r0.a3.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.f46036e.v = false;
                this.f46036e.D = false;
                this.f46036e.w = 0;
                this.f46036e.m.setVisibility(0);
                this.f46036e.l.setVisibility(8);
                this.f46036e.l.setProgress(this.f46036e.l.getMax());
                if (this.f46036e.f46035j == null || this.f46036e.f46035j.getDuration() > 150000) {
                    this.f46036e.y(false);
                } else {
                    this.f46036e.p.setVisibility(0);
                }
                s.d().e(this.f46036e.r);
                if (this.f46036e.f46035j == null || this.f46036e.f46035j.getDuration() > 150000) {
                    return;
                }
                PushDialogVideoView pushDialogVideoView = this.f46036e;
                pushDialogVideoView.startPlay(pushDialogVideoView.r, this.f46036e.s);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                this.f46036e.n.setVisibility(0);
                this.f46036e.k.b();
                if (!l.z()) {
                    this.f46036e.B = true;
                }
                this.f46036e.D = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.f46036e.k.e();
            }
        }

        @Override // c.a.r0.a3.v.a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.f46036e.z) {
                c.a.d.f.m.e.a().postDelayed(this.f46036e.L, 200L);
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a3.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setData(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setStatistic(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.r0.a3.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements VideoLoadingProgressView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        public b(PushDialogVideoView pushDialogVideoView) {
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
            this.a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.VideoLoadingProgressView.c
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.C();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f46037e;

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
            this.f46037e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46037e.f46035j.getCurrentPosition() > 100) {
                    this.f46037e.v = true;
                    this.f46037e.m.setVisibility(8);
                    this.f46037e.n.setVisibility(8);
                    this.f46037e.k.c();
                    this.f46037e.t.setVisibility(8);
                    this.f46037e.showProgress();
                    return;
                }
                c.a.d.f.m.e.a().postDelayed(this.f46037e.J, 20L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f46038e;

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
            this.f46038e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46038e.n.setVisibility(0);
                this.f46038e.k.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f46039e;

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
            this.f46039e = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f46039e.f46035j == null || !this.f46039e.z) {
                    c.a.d.f.m.e.a().postDelayed(this.f46039e.J, 200L);
                    this.f46039e.z = false;
                } else if (this.f46039e.w != this.f46039e.f46035j.getCurrentPosition()) {
                    this.f46039e.z = false;
                    c.a.d.f.m.e.a().postDelayed(this.f46039e.J, 20L);
                } else {
                    c.a.d.f.m.e.a().postDelayed(this.f46039e.L, 200L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushDialogVideoView f46040e;

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
            this.f46040e = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46040e.v = false;
                this.f46040e.D = false;
                c.a.d.f.m.e.a().removeCallbacks(this.f46040e.J);
                c.a.d.f.m.e.a().removeCallbacks(this.f46040e.K);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PushDialogVideoView pushDialogVideoView, int i2) {
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
            this.a = pushDialogVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.a.pausePlay();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(PushDialogVideoView pushDialogVideoView, Looper looper) {
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
            this.a = pushDialogVideoView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && this.a.f46035j != null && this.a.f46035j.isPlaying()) {
                int currentPosition = this.a.f46035j.getCurrentPosition();
                int duration = this.a.f46035j.getDuration();
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                if (this.a.P != null) {
                    this.a.P.a(currentPosition);
                }
                sendMessageDelayed(obtainMessage(1), this.a.f46030e - (currentPosition % this.a.f46030e));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements VideoControllerView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

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
            this.a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i2) {
            int duration;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.a.f46035j == null || (duration = this.a.f46035j.getDuration()) <= 0 || this.a.l == null) {
                return;
            }
            this.a.l.setProgress((int) ((i2 * this.a.getWidth()) / duration));
        }
    }

    /* loaded from: classes6.dex */
    public interface j {
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
        this.f46030e = 50;
        this.f46031f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new a(this);
        this.I = new b(this);
        this.J = new c(this);
        this.K = new d(this);
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this, 2016503);
        this.O = new h(this, Looper.getMainLooper());
        this.P = new i(this);
        x(context);
    }

    public final void A(j jVar, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{jVar, Boolean.valueOf(z), str, str2}) == null) {
            if (this.A) {
                startPlayWithCache(str, str2);
            } else {
                startPlay(str, str2);
            }
            if (jVar != null) {
                jVar.a(z);
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            startPlayWithNetCheck(this.r, this.s, null, new Object[0]);
        }
    }

    public final void C() {
        c.a.r0.a3.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (gVar = this.f46035j) == null) {
            return;
        }
        if (this.D) {
            gVar.start();
            this.D = false;
        }
        c.a.d.f.m.e.a().removeCallbacks(this.J);
        c.a.d.f.m.e.a().postDelayed(this.J, 20L);
        c.a.d.f.m.e.a().removeCallbacks(this.K);
        int c2 = s.d().c(this.r);
        this.w = c2;
        if (c2 != 0) {
            this.f46035j.seekTo(c2);
            if (!this.C) {
                showProgress();
                c.a.d.f.m.e.a().removeCallbacks(this.J);
            }
            this.z = true;
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.a3.g gVar = this.f46035j;
            if (gVar == null) {
                return 0;
            }
            return gVar.getCurrentPosition();
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
            c.a.r0.a3.g gVar = this.f46035j;
            if (gVar == null) {
                return false;
            }
            return gVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void onChangeSkinType() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.f46031f) {
            return;
        }
        this.f46031f = skinType;
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
            } else if (view != this.u.getTvOpenFreeData() || (tbPageContext = this.f46034i) == null) {
            } else {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            stopPlay();
            c.a.d.f.m.e.a().removeCallbacks(this.J);
            c.a.d.f.m.e.a().removeCallbacks(this.K);
            c.a.d.f.m.e.a().removeCallbacks(this.L);
            this.O.removeMessages(1);
            this.x.unregister(getContext());
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.f46032g, this.f46033h);
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
            if (this.f46035j.isPlaying() && this.y) {
                saveUpdatePosition();
            }
            this.f46035j.pause();
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
            if (!l.z()) {
                n.K(getContext(), getContext().getString(R.string.neterror));
            } else if (this.f46035j.isPlaying()) {
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
            this.f46035j.start();
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
            s.d().update(this.r, this.f46035j.getCurrentPositionSync());
        }
    }

    public void setNetworkChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && l.z() && this.B && !StringUtils.isNull(this.r) && !StringUtils.isNull(this.s)) {
            this.B = false;
            this.C = true;
            startPlay(this.r, this.s);
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, tbPageContext) == null) {
            this.f46034i = tbPageContext;
            tbPageContext.registerListener(this.N);
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

    public void setTbRichTextVideoInfo(c.a.q0.e1.n.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jVar) == null) {
            this.G = jVar;
            this.q.setText(StringHelper.stringForVideoTime(jVar.b() * 1000));
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

    public void setVideoViewBusiness(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, tVar) == null) {
            this.f46035j.setVideoStatData(tVar);
        }
    }

    public void showProgress() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f46035j == null) {
            return;
        }
        this.l.setVisibility(0);
        int duration = ((this.f46035j.getDuration() / 200) / 50) * 50;
        this.f46030e = duration;
        if (duration < 50) {
            this.f46030e = 50;
        } else if (duration > 500) {
            this.f46030e = 500;
        }
        this.O.removeMessages(1);
        Handler handler = this.O;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f46030e - (this.f46035j.getCurrentPosition() % this.f46030e));
    }

    public void startPlay(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            z();
            this.D = true;
            setVideoUrl(str, str2);
            this.f46035j.setVideoPath(str, str2);
            this.k.g();
            this.t.setVisibility(0);
            this.o.setVisibility(8);
            this.p.setVisibility(8);
            this.n.setVisibility(8);
            c.a.d.f.m.e.a().removeCallbacks(this.K);
            c.a.d.f.m.e.a().postDelayed(this.K, 60000L);
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
            c.a.d.f.m.e.a().removeCallbacks(this.K);
            c.a.d.f.m.e.a().postDelayed(this.K, 60000L);
        }
    }

    public void startPlayWithNetCheck(String str, String str2, j jVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048603, this, str, str2, jVar, objArr) == null) {
            z();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.A = ((Boolean) objArr[0]).booleanValue();
            }
            if (l.x() && !this.F && !c.a.r0.l4.h.c().d()) {
                this.u.setVisibility(0);
                this.u.setData(this.G.b(), this.G.c());
                return;
            }
            A(jVar, true, str, str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.f46035j.isPlaying() && this.y) {
                saveUpdatePosition();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.J);
            c.a.d.f.m.e.a().removeCallbacks(this.K);
            this.f46035j.stopPlayback();
            this.v = false;
            this.D = false;
            this.w = 0;
            resetPlayerUI();
        }
    }

    public void updateBottomProgress() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.f46035j == null) {
            return;
        }
        this.l.setMax(n.k(getContext()));
        int duration = this.f46035j.getDuration();
        if (duration > 0) {
            if (this.p.getVisibility() == 0) {
                ProgressBar progressBar = this.l;
                progressBar.setProgress(progressBar.getMax());
                return;
            }
            this.l.setProgress((int) ((this.f46035j.getCurrentPosition() * this.l.getMax()) / duration));
        }
    }

    public final void x(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.cell_push_dialog_video_layout, (ViewGroup) this, true);
            int k = n.k(context) - n.f(context, R.dimen.tbds132);
            this.f46032g = k;
            this.f46033h = (int) (k * 0.5625f);
            c.a.r0.a3.g control = ((TbVideoViewContainer) findViewById(R.id.videoView)).getControl();
            this.f46035j = control;
            control.setPlayMode("2");
            this.f46035j.setStageType(null);
            q qVar = new q((ViewGroup) findViewById(R.id.auto_video_loading_container));
            this.k = qVar;
            qVar.f(this.I);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pgrBottomProgress);
            this.l = progressBar;
            progressBar.setMax(this.f46032g);
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
            this.f46035j.setOperableVideoContainer(this.H);
            this.f46035j.setOnSurfaceDestroyedListener(this.M);
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
            this.O.removeMessages(1);
            this.t.setVisibility(z ? 0 : 8);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && l.x()) {
            c.a.r0.l4.h.c().f(getContext());
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
        this.f46030e = 50;
        this.f46031f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new a(this);
        this.I = new b(this);
        this.J = new c(this);
        this.K = new d(this);
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this, 2016503);
        this.O = new h(this, Looper.getMainLooper());
        this.P = new i(this);
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
        this.f46030e = 50;
        this.f46031f = 3;
        this.v = false;
        this.w = 0;
        this.y = true;
        this.z = false;
        this.A = false;
        this.E = false;
        this.H = new a(this);
        this.I = new b(this);
        this.J = new c(this);
        this.K = new d(this);
        this.L = new e(this);
        this.M = new f(this);
        this.N = new g(this, 2016503);
        this.O = new h(this, Looper.getMainLooper());
        this.P = new i(this);
        x(context);
    }
}
