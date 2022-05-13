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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
import com.repackage.cg5;
import com.repackage.j78;
import com.repackage.ki;
import com.repackage.l78;
import com.repackage.m78;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.r78;
import com.repackage.xr8;
import com.repackage.y68;
/* loaded from: classes3.dex */
public class PushDialogVideoView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public cg5 C;
    public r78 D;
    public VideoLoadingProgressView.c E;
    public Runnable F;
    public Runnable G;
    public Runnable H;
    public TbVideoViewContainer.a I;
    public CustomMessageListener J;
    public Handler K;
    public VideoControllerView.d L;
    public int a;
    public int b;
    public int c;
    public int d;
    public TbPageContext<?> e;
    public y68 f;
    public j78 g;
    public ProgressBar h;
    public View i;
    public View j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public String n;
    public String o;
    public TbImageView p;
    public PbVideoWifiTipLayout q;
    public boolean r;
    public int s;
    public CallStateReceiver t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public class a implements r78 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        public a(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushDialogVideoView;
        }

        @Override // com.repackage.r78
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.r78
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.r78
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.r78
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
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

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                this.a.r = false;
                this.a.z = false;
                this.a.s = 0;
                this.a.i.setVisibility(0);
                this.a.h.setVisibility(8);
                this.a.h.setProgress(this.a.h.getMax());
                if (this.a.f == null || this.a.f.getDuration() > 150000) {
                    this.a.G(false);
                } else {
                    this.a.l.setVisibility(0);
                }
                l78.d().e(this.a.n);
                if (this.a.f == null || this.a.f.getDuration() > 150000) {
                    return;
                }
                PushDialogVideoView pushDialogVideoView = this.a;
                pushDialogVideoView.M(pushDialogVideoView.n, this.a.o);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.j.setVisibility(0);
                this.a.g.b();
                if (!ki.z()) {
                    this.a.x = true;
                }
                this.a.z = false;
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                this.a.g.e();
            }
        }

        @Override // com.repackage.r78
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.a.v) {
                ng.a().postDelayed(this.a.H, 200L);
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // com.repackage.r78
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setStatistic(m78 m78Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, m78Var) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.repackage.r78
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.repackage.r78
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.R();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        public c(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f.getCurrentPosition() > 100) {
                    this.a.r = true;
                    this.a.i.setVisibility(8);
                    this.a.j.setVisibility(8);
                    this.a.g.c();
                    this.a.p.setVisibility(8);
                    this.a.L();
                    return;
                }
                ng.a().postDelayed(this.a.F, 20L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        public d(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.setVisibility(0);
                this.a.g.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        public e(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushDialogVideoView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f == null || !this.a.v) {
                    ng.a().postDelayed(this.a.F, 200L);
                    this.a.v = false;
                } else if (this.a.s != this.a.f.getCurrentPosition()) {
                    this.a.v = false;
                    ng.a().postDelayed(this.a.F, 20L);
                } else {
                    ng.a().postDelayed(this.a.H, 200L);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        public f(PushDialogVideoView pushDialogVideoView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r = false;
                this.a.z = false;
                ng.a().removeCallbacks(this.a.F);
                ng.a().removeCallbacks(this.a.G);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(PushDialogVideoView pushDialogVideoView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushDialogVideoView, Integer.valueOf(i)};
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
            this.a = pushDialogVideoView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.a.E();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1 && this.a.f != null && this.a.f.isPlaying()) {
                int currentPosition = this.a.f.getCurrentPosition();
                int duration = this.a.f.getDuration();
                if (currentPosition > duration) {
                    currentPosition = duration;
                }
                if (this.a.L != null) {
                    this.a.L.a(currentPosition);
                }
                sendMessageDelayed(obtainMessage(1), this.a.a - (currentPosition % this.a.a));
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushDialogVideoView;
        }

        @Override // com.baidu.tieba.play.VideoControllerView.d
        public void a(int i) {
            int duration;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.f == null || (duration = this.a.f.getDuration()) <= 0 || this.a.h == null) {
                return;
            }
            this.a.h.setProgress((int) ((i * this.a.getWidth()) / duration));
        }
    }

    /* loaded from: classes3.dex */
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
        this.a = 50;
        this.b = 3;
        this.r = false;
        this.s = 0;
        this.u = true;
        this.v = false;
        this.w = false;
        this.A = false;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this);
        this.I = new f(this);
        this.J = new g(this, 2016503);
        this.K = new h(this, Looper.getMainLooper());
        this.L = new i(this);
        y(context);
    }

    public void A() {
        int skinType;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.b) {
            return;
        }
        this.b = skinType;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            stopPlay();
            ng.a().removeCallbacks(this.F);
            ng.a().removeCallbacks(this.G);
            ng.a().removeCallbacks(this.H);
            this.K.removeMessages(1);
            this.t.unregister(getContext());
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (z()) {
                this.A = true;
                E();
                return;
            }
            this.A = false;
            E();
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.A) {
            I();
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f.isPlaying() && this.u) {
                J();
            }
            this.f.pause();
            setPauseState();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            G(true);
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.i.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.g.b();
            this.h.setVisibility(8);
            this.j.setVisibility(8);
            this.K.removeMessages(1);
            this.p.setVisibility(z ? 0 : 8);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!ki.z()) {
                mi.K(getContext(), getContext().getString(R.string.obfuscated_res_0x7f0f0c2d));
            } else if (this.f.isPlaying()) {
                E();
            } else if (this.r) {
                I();
            } else {
                P();
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f.start();
            this.p.setVisibility(8);
            this.i.setVisibility(8);
            this.g.b();
            L();
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l78.d().update(this.n, this.f.getCurrentPositionSync());
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && ki.x()) {
            xr8.c().f(getContext());
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f == null) {
            return;
        }
        this.h.setVisibility(0);
        int duration = ((this.f.getDuration() / 200) / 50) * 50;
        this.a = duration;
        if (duration < 50) {
            this.a = 50;
        } else if (duration > 500) {
            this.a = 500;
        }
        this.K.removeMessages(1);
        Handler handler = this.K;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.a - (this.f.getCurrentPosition() % this.a));
    }

    public void M(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            K();
            this.z = true;
            setVideoUrl(str, str2);
            this.f.setVideoPath(str, str2);
            this.g.g();
            this.p.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(8);
            ng.a().removeCallbacks(this.G);
            ng.a().postDelayed(this.G, 60000L);
        }
    }

    public final void N(j jVar, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{jVar, Boolean.valueOf(z), str, str2}) == null) {
            if (this.w) {
                O(str, str2);
            } else {
                M(str, str2);
            }
            if (jVar != null) {
                jVar.a(z);
            }
        }
    }

    public void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            K();
            this.z = true;
            this.g.g();
            this.p.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(8);
            ng.a().removeCallbacks(this.G);
            ng.a().postDelayed(this.G, 60000L);
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Q(this.n, this.o, null, new Object[0]);
        }
    }

    public void Q(String str, String str2, j jVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048592, this, str, str2, jVar, objArr) == null) {
            K();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.w = ((Boolean) objArr[0]).booleanValue();
            }
            if (ki.x() && !this.B && !xr8.c().d()) {
                this.q.setVisibility(0);
                this.q.setData(this.C.b(), this.C.c());
                return;
            }
            N(jVar, true, str, str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }

    public final void R() {
        y68 y68Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (y68Var = this.f) == null) {
            return;
        }
        if (this.z) {
            y68Var.start();
            this.z = false;
        }
        ng.a().removeCallbacks(this.F);
        ng.a().postDelayed(this.F, 20L);
        ng.a().removeCallbacks(this.G);
        int c2 = l78.d().c(this.n);
        this.s = c2;
        if (c2 != 0) {
            this.f.seekTo(c2);
            if (!this.y) {
                L();
                ng.a().removeCallbacks(this.F);
            }
            this.v = true;
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            y68 y68Var = this.f;
            if (y68Var == null) {
                return 0;
            }
            return y68Var.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, view2) == null) {
            if (view2 == this.j) {
                P();
            } else if (view2 == this) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 2).param("tid", this.o));
                H();
            } else if (view2 == this.l) {
                M(this.n, this.o);
            } else if (view2 == this.q.getTvPlay()) {
                this.B = true;
                this.q.setVisibility(8);
                M(this.n, this.o);
            } else if (view2 != this.q.getTvOpenFreeData() || (tbPageContext = this.e) == null) {
            } else {
                tbPageContext.getPageActivity().finish();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048596, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.c, this.d);
        }
    }

    public void setNetworkChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && ki.z() && this.x && !StringUtils.isNull(this.n) && !StringUtils.isNull(this.o)) {
            this.x = false;
            this.y = true;
            M(this.n, this.o);
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, tbPageContext) == null) {
            this.e = tbPageContext;
            tbPageContext.registerListener(this.J);
        }
    }

    public void setPauseState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.g.b();
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        }
    }

    public void setTbRichTextVideoInfo(cg5 cg5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cg5Var) == null) {
            this.C = cg5Var;
            this.m.setText(StringHelper.stringForVideoTime(cg5Var.b() * 1000));
        }
    }

    public void setThumbnail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.p.K(str, 17, false);
        }
    }

    public void setVideoUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, str, str2) == null) {
            this.n = str;
            this.o = str2;
        }
    }

    public void setVideoViewBusiness(m78 m78Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, m78Var) == null) {
            this.f.setVideoStatData(m78Var);
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (this.f.isPlaying() && this.u) {
                J();
            }
            ng.a().removeCallbacks(this.F);
            ng.a().removeCallbacks(this.G);
            this.f.stopPlayback();
            this.r = false;
            this.z = false;
            this.s = 0;
            F();
        }
    }

    public final void y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01cf, (ViewGroup) this, true);
            int k = mi.k(context) - mi.f(context, R.dimen.tbds132);
            this.c = k;
            this.d = (int) (k * 0.5625f);
            y68 control = ((TbVideoViewContainer) findViewById(R.id.obfuscated_res_0x7f092333)).getControl();
            this.f = control;
            control.setPlayMode("2");
            this.f.setStageType(null);
            j78 j78Var = new j78((ViewGroup) findViewById(R.id.obfuscated_res_0x7f0902e5));
            this.g = j78Var;
            j78Var.f(this.E);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091871);
            this.h = progressBar;
            progressBar.setMax(this.c);
            this.h.setProgress(0);
            this.i = findViewById(R.id.obfuscated_res_0x7f090383);
            this.j = findViewById(R.id.obfuscated_res_0x7f0911de);
            this.k = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ed2);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09227f);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f0919d3);
            this.p = (TbImageView) findViewById(R.id.obfuscated_res_0x7f0923c1);
            this.q = (PbVideoWifiTipLayout) findViewById(R.id.obfuscated_res_0x7f091203);
            this.p.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            CallStateReceiver callStateReceiver = new CallStateReceiver();
            this.t = callStateReceiver;
            callStateReceiver.register(context);
            this.j.setOnClickListener(this);
            this.l.setOnClickListener(this);
            this.q.setOnPlayClickListener(this);
            this.q.setFreeClickListener(this);
            setOnClickListener(this);
            this.f.setOperableVideoContainer(this.D);
            this.f.setOnSurfaceDestroyedListener(this.I);
            A();
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            y68 y68Var = this.f;
            if (y68Var == null) {
                return false;
            }
            return y68Var.isPlaying();
        }
        return invokeV.booleanValue;
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
        this.a = 50;
        this.b = 3;
        this.r = false;
        this.s = 0;
        this.u = true;
        this.v = false;
        this.w = false;
        this.A = false;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this);
        this.I = new f(this);
        this.J = new g(this, 2016503);
        this.K = new h(this, Looper.getMainLooper());
        this.L = new i(this);
        y(context);
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
        this.a = 50;
        this.b = 3;
        this.r = false;
        this.s = 0;
        this.u = true;
        this.v = false;
        this.w = false;
        this.A = false;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
        this.H = new e(this);
        this.I = new f(this);
        this.J = new g(this, 2016503);
        this.K = new h(this, Looper.getMainLooper());
        this.L = new i(this);
        y(context);
    }
}
