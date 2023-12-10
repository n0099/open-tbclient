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
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.fea;
import com.baidu.tieba.hea;
import com.baidu.tieba.l6b;
import com.baidu.tieba.mea;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.PbVideoWifiTipLayout;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoControllerView;
import com.baidu.tieba.play.VideoLoadingProgressView;
import com.baidu.tieba.play.VideoPostionCacheManager;
import com.baidu.tieba.sda;
import com.baidu.tieba.yy5;
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
    public yy5 C;
    public mea D;
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
    public sda f;
    public fea g;
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

    /* loaded from: classes7.dex */
    public interface j {
        void a(boolean z);
    }

    /* loaded from: classes7.dex */
    public class a implements mea {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushDialogVideoView a;

        @Override // com.baidu.tieba.mea
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.mea
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.mea
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.mea
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.mea
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.mea
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

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.mea
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

        @Override // com.baidu.tieba.mea
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.mea
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void setStatistic(hea heaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, heaVar) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.mea
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }

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

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
                return;
            }
            this.a.r = false;
            this.a.z = false;
            this.a.s = 0;
            this.a.i.setVisibility(0);
            this.a.h.setVisibility(8);
            this.a.h.setProgress(this.a.h.getMax());
            if (this.a.f != null && this.a.f.getDuration() <= 150000) {
                this.a.l.setVisibility(0);
            } else {
                this.a.I(false);
            }
            VideoPostionCacheManager.getInstance().remove(this.a.n);
            if (this.a.f != null && this.a.f.getDuration() <= 150000) {
                PushDialogVideoView pushDialogVideoView = this.a;
                pushDialogVideoView.O(pushDialogVideoView.n, this.a.o);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.j.setVisibility(0);
                this.a.g.b();
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.x = true;
                }
                this.a.z = false;
                return true;
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

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !this.a.v) {
                return;
            }
            SafeHandler.getInst().postDelayed(this.a.H, 200L);
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.T();
        }
    }

    /* loaded from: classes7.dex */
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
                if (this.a.f.getCurrentPosition() <= 100) {
                    SafeHandler.getInst().postDelayed(this.a.F, 20L);
                    return;
                }
                this.a.r = true;
                this.a.i.setVisibility(8);
                this.a.j.setVisibility(8);
                this.a.g.c();
                this.a.p.setVisibility(8);
                this.a.N();
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
                if (this.a.f != null && this.a.v) {
                    if (this.a.s == this.a.f.getCurrentPosition()) {
                        SafeHandler.getInst().postDelayed(this.a.H, 200L);
                        return;
                    }
                    this.a.v = false;
                    SafeHandler.getInst().postDelayed(this.a.F, 20L);
                    return;
                }
                SafeHandler.getInst().postDelayed(this.a.F, 200L);
                this.a.v = false;
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.r = false;
            this.a.z = false;
            SafeHandler.getInst().removeCallbacks(this.a.F);
            SafeHandler.getInst().removeCallbacks(this.a.G);
        }
    }

    /* loaded from: classes7.dex */
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
                this.a.G();
            }
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.f != null && (duration = this.a.f.getDuration()) > 0 && this.a.h != null) {
                this.a.h.setProgress((int) ((i * this.a.getWidth()) / duration));
            }
        }
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
        A(context);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, view2) == null) {
            if (view2 == this.j) {
                R();
            } else if (view2 == this) {
                TiebaStatic.log(new StatisticItem("c13199").param("obj_locate", 2).param("tid", this.o));
                J();
            } else if (view2 == this.l) {
                O(this.n, this.o);
            } else if (view2 == this.q.getTvPlay()) {
                this.B = true;
                this.q.setVisibility(8);
                O(this.n, this.o);
            } else if (view2 == this.q.getTvOpenFreeData() && (tbPageContext = this.e) != null) {
                tbPageContext.getPageActivity().finish();
            }
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
        A(context);
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
        A(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048598, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            setMeasuredDimension(this.c, this.d);
        }
    }

    public void setVideoUrl(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, str, str2) == null) {
            this.n = str;
            this.o = str2;
        }
    }

    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, tbPageContext) == null) {
            this.e = tbPageContext;
            tbPageContext.registerListener(this.J);
        }
    }

    public void setTbRichTextVideoInfo(yy5 yy5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, yy5Var) == null) {
            this.C = yy5Var;
            this.m.setText(StringHelper.stringForVideoTime(yy5Var.b() * 1000));
        }
    }

    public void setThumbnail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.p.startLoad(str, 17, false);
        }
    }

    public void setVideoViewBusiness(hea heaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, heaVar) == null) {
            this.f.setVideoStatData(heaVar);
        }
    }

    public final void A(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0203, (ViewGroup) this, true);
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(context) - BdUtilHelper.getDimens(context, R.dimen.tbds132);
            this.c = equipmentWidth;
            this.d = (int) (equipmentWidth * 0.5625f);
            TbVideoView control = ((TbVideoViewContainer) findViewById(R.id.obfuscated_res_0x7f092992)).getControl();
            this.f = control;
            control.setPlayMode("2");
            this.f.setStageType(null);
            fea feaVar = new fea((ViewGroup) findViewById(R.id.auto_video_loading_container));
            this.g = feaVar;
            feaVar.f(this.E);
            ProgressBar progressBar = (ProgressBar) findViewById(R.id.pgrBottomProgress);
            this.h = progressBar;
            progressBar.setMax(this.c);
            this.h.setProgress(0);
            this.i = findViewById(R.id.black_mask);
            this.j = findViewById(R.id.layout_error);
            this.k = (ImageView) findViewById(R.id.img_play);
            this.l = (TextView) findViewById(R.id.txt_replay);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091ec5);
            this.p = (TbImageView) findViewById(R.id.video_thumbnail);
            this.q = (PbVideoWifiTipLayout) findViewById(R.id.obfuscated_res_0x7f09158c);
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
            C();
        }
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            sda sdaVar = this.f;
            if (sdaVar == null) {
                return false;
            }
            return sdaVar.isPlaying();
        }
        return invokeV.booleanValue;
    }

    public void C() {
        int skinType;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (skinType = TbadkCoreApplication.getInst().getSkinType()) == this.b) {
            return;
        }
        this.b = skinType;
    }

    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (B()) {
                this.A = true;
                G();
                return;
            }
            this.A = false;
            G();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.A) {
            K();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.f.isPlaying() && this.u) {
                L();
            }
            this.f.pause();
            setPauseState();
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            I(true);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VideoPostionCacheManager.getInstance().update(this.n, this.f.getCurrentPositionSync());
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && BdNetTypeUtil.isMobileNet()) {
            l6b.c().f(getContext());
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            S(this.n, this.o, null, new Object[0]);
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            sda sdaVar = this.f;
            if (sdaVar == null) {
                return 0;
            }
            return sdaVar.getCurrentPosition();
        }
        return invokeV.intValue;
    }

    public void setPauseState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.g.b();
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            stopPlay();
            SafeHandler.getInst().removeCallbacks(this.F);
            SafeHandler.getInst().removeCallbacks(this.G);
            SafeHandler.getInst().removeCallbacks(this.H);
            this.K.removeMessages(1);
            this.t.unregister(getContext());
        }
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showLongToast(getContext(), getContext().getString(R.string.obfuscated_res_0x7f0f0e70));
            } else if (this.f.isPlaying()) {
                G();
            } else if (this.r) {
                K();
            } else {
                R();
            }
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f.start();
            this.p.setVisibility(8);
            this.i.setVisibility(8);
            this.g.b();
            N();
            this.k.setVisibility(8);
            this.l.setVisibility(8);
        }
    }

    public void setNetworkChange() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && BdNetTypeUtil.isNetWorkAvailable() && this.x && !StringUtils.isNull(this.n) && !StringUtils.isNull(this.o)) {
            this.x = false;
            this.y = true;
            O(this.n, this.o);
        }
    }

    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (this.f.isPlaying() && this.u) {
                L();
            }
            SafeHandler.getInst().removeCallbacks(this.F);
            SafeHandler.getInst().removeCallbacks(this.G);
            this.f.stopPlayback();
            this.r = false;
            this.z = false;
            this.s = 0;
            H();
        }
    }

    public final void I(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            int i2 = 0;
            this.i.setVisibility(0);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.g.b();
            this.h.setVisibility(8);
            this.j.setVisibility(8);
            this.K.removeMessages(1);
            TbImageView tbImageView = this.p;
            if (!z) {
                i2 = 8;
            }
            tbImageView.setVisibility(i2);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || this.f == null) {
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

    public final void T() {
        sda sdaVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || (sdaVar = this.f) == null) {
            return;
        }
        if (this.z) {
            sdaVar.start();
            this.z = false;
        }
        SafeHandler.getInst().removeCallbacks(this.F);
        SafeHandler.getInst().postDelayed(this.F, 20L);
        SafeHandler.getInst().removeCallbacks(this.G);
        int cachePosition = VideoPostionCacheManager.getInstance().getCachePosition(this.n);
        this.s = cachePosition;
        if (cachePosition != 0) {
            this.f.seekTo(cachePosition);
            if (!this.y) {
                N();
                SafeHandler.getInst().removeCallbacks(this.F);
            }
            this.v = true;
        }
    }

    public void O(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            M();
            this.z = true;
            setVideoUrl(str, str2);
            this.f.setVideoPath(str, str2);
            this.g.g();
            this.p.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(8);
            SafeHandler.getInst().removeCallbacks(this.G);
            SafeHandler.getInst().postDelayed(this.G, 60000L);
        }
    }

    public void Q(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, str, str2) == null) {
            M();
            this.z = true;
            this.g.g();
            this.p.setVisibility(0);
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(8);
            SafeHandler.getInst().removeCallbacks(this.G);
            SafeHandler.getInst().postDelayed(this.G, 60000L);
        }
    }

    public final void P(j jVar, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{jVar, Boolean.valueOf(z), str, str2}) == null) {
            if (this.w) {
                Q(str, str2);
            } else {
                O(str, str2);
            }
            if (jVar != null) {
                jVar.a(z);
            }
        }
    }

    public void S(String str, String str2, j jVar, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, str, str2, jVar, objArr) == null) {
            M();
            if (objArr != null && objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.w = ((Boolean) objArr[0]).booleanValue();
            }
            if (BdNetTypeUtil.isMobileNet() && !this.B && !l6b.c().d()) {
                this.q.setVisibility(0);
                this.q.setData(this.C.b(), this.C.c());
                return;
            }
            P(jVar, true, str, str2);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016517));
        }
    }
}
