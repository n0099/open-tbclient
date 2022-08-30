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
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoSwitchManager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.play.VideoControllerView;
import com.baidu.tieba.ah0;
import com.baidu.tieba.bh0;
import com.baidu.tieba.e98;
import com.baidu.tieba.g98;
import com.baidu.tieba.hc8;
import com.baidu.tieba.id8;
import com.baidu.tieba.ik8;
import com.baidu.tieba.iy0;
import com.baidu.tieba.jd8;
import com.baidu.tieba.kd8;
import com.baidu.tieba.l98;
import com.baidu.tieba.pi;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.qi;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.ri;
import com.baidu.tieba.sg;
import com.baidu.tieba.ud8;
import com.baidu.tieba.vf5;
import com.baidu.tieba.wr4;
import com.baidu.tieba.yd8;
import com.baidu.tieba.zd8;
import com.baidu.tieba.zj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class DistributeVideoView extends RelativeLayout implements IHomeAdVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public long B;
    public boolean C;
    public long D;
    public int E;
    public AdCard F;
    public String G;
    public Animation H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public boolean N;
    public int O;
    public boolean P;
    public int Q;
    public View.OnClickListener R;
    @NonNull
    public Handler S;
    public l98 T;
    public TbVideoViewContainer.a U;
    public Runnable V;
    public Runnable W;
    public TbPageContext<?> a;
    public Runnable a0;
    public Context b;
    public CustomMessageListener b0;
    public View c;
    public CustomMessageListener c0;
    public View d;
    public CustomMessageListener d0;
    public VideoInfo e;
    public Runnable e0;
    public jd8 f;
    public yd8 g;
    public zd8 h;
    public ViewGroup i;
    public AdvertAppInfo j;
    public String k;
    public TbVideoViewContainer l;
    public TBLottieAnimationView m;
    public ForeDrawableImageView n;
    public TextView o;
    public View p;
    public ImageView q;
    public ImageView r;
    public View s;
    public TextView t;
    public View u;
    public ImageView v;
    public VideoControllerView w;
    public TbImageView x;
    public RelativeLayout y;
    public WeakReference<Context> z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.z = null;
        this.A = -1;
        this.B = 0L;
        this.C = false;
        this.D = 0L;
        this.E = 1;
        this.I = false;
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = 2;
        this.Q = 1;
        this.R = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    if (view2 == this.a.s) {
                        this.a.s.setVisibility(8);
                        this.a.performPlay();
                    } else if (view2 != this.a.r && view2 != this.a.q) {
                        if (view2 == this.a.m || view2 == this.a.v) {
                            this.a.c0();
                        } else if (this.a.F == null) {
                            this.a.c0();
                        } else {
                            int jump2DownloadDetailPage = this.a.jump2DownloadDetailPage();
                            this.a.T();
                            if (hc8.h(jump2DownloadDetailPage)) {
                                this.a.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.l0(!distributeVideoView.C);
                    }
                }
            }
        };
        this.S = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    int i3 = message.what;
                    if (i3 != 1001) {
                        if (i3 == 1003 && this.a.A == 1) {
                            if (this.a.B == this.a.l.getControl().getCurrentPosition()) {
                                this.a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.B = distributeVideoView.l.getControl().getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.S.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.A == 1) {
                    } else {
                        if (!zj5.a().k() ? this.a.l.getControl().getCurrentPosition() <= 0 : !this.a.l.getControl().isPlaying()) {
                            this.a.S.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.A = 1;
                        this.a.W();
                        sg.a().removeCallbacks(this.a.e0);
                    }
                }
            }
        };
        this.T = new l98(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.l98
            public void changeRenderViewMode(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.tieba.l98
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onBackground(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeZ = interceptable2.invokeZ(1048582, this, z)) == null) {
                    return false;
                }
                return invokeZ.booleanValue;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, view2) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    this.a.D = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.N = true;
                    if (distributeVideoView.l != null && this.a.l.getControl() != null) {
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.O), this.a.l.getControl().getDuration());
                    }
                    this.a.k0();
                    if (this.a.h != null) {
                        this.a.h.d();
                        this.a.o.setVisibility(8);
                        this.a.p.setVisibility(8);
                        this.a.setLoadingAnimShow(false);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i3, i4, obj)) == null) {
                    this.a.k0();
                    if (this.a.l != null && this.a.l.getControl() != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.O), this.a.l.getControl().getCurrentPosition());
                    }
                    this.a.n.setForegroundDrawable(0);
                    this.a.setLoadingAnimShow(false);
                    this.a.s.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048586, this, i3, i4, obj)) == null) {
                    if (i3 == 3 && this.a.j != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        int i5 = (distributeVideoView.N && "DETAIL".equals(distributeVideoView.j.j)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.i0(i5, distributeVideoView2.X(distributeVideoView2.O), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048587, this) == null) || this.a.l == null || this.a.l.getControl() == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.a;
                distributeVideoView.L = distributeVideoView.l.getControl().getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.a;
                distributeVideoView2.M = distributeVideoView2.l.getControl().getDuration();
                this.a.l.getControl().setVolume(0.0f, 0.0f);
                this.a.S.removeMessages(1001);
                this.a.S.sendEmptyMessage(1001);
                if (this.a.C && this.a.E == 1) {
                    this.a.l0(false);
                }
            }

            @Override // com.baidu.tieba.l98
            public void onScroll() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048588, this) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048589, this) == null) {
                }
            }

            @Override // com.baidu.tieba.play.TbVideoViewContainer.a
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048590, this) == null) {
                }
            }

            public boolean onVolumeDown() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setStatistic(g98 g98Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, g98Var) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
                }
            }
        };
        this.U = new TbVideoViewContainer.a(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.play.TbVideoViewContainer.a
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.stopPlay();
                }
            }
        };
        this.V = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null || this.a.l == null || this.a.l.getControl() == null || !this.a.canPlay()) {
                    return;
                }
                this.a.h0(1);
            }
        };
        this.W = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.Y();
                }
            }
        };
        this.a0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.f0(false);
                }
            }
        };
        this.b0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.E == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.K) {
                            this.a.l0(true);
                            return;
                        } else {
                            this.a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.K = distributeVideoView.C;
                    this.a.l0(true);
                }
            }
        };
        this.c0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.E == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.l0(true);
                    }
                }
            }
        };
        this.d0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
        this.e0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.A == -1 || this.a.A == 0) {
                        this.a.g0();
                    }
                }
            }
        };
        Z(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65576, this, z) == null) {
            d0();
            if (z) {
                this.m.setAlpha(1.0f);
                this.m.setVisibility(0);
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (UbsABTestHelper.isNativeVideoAdsAutoPlayABTestA()) {
                return pi.z();
            }
            if (this.E == 1) {
                return ik8.a();
            }
            return pi.z();
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            i0(2, 1, 0);
        }
    }

    public final void U(int i) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (advertAppInfo = this.j) == null || this.e == null) {
            return;
        }
        advertAppInfo.j = this.k;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.v(this.j.j).y(ClogBuilder.LogType.DEEP_LINK).q(String.valueOf(this.j.position + 1)).p(this.j.g);
        boolean z = i == 1000;
        clogBuilder.j(z ? "APP" : "URL");
        if (!z) {
            clogBuilder.l(String.valueOf(i));
        }
        clogBuilder.v("DEEPLINK");
        iy0.b(clogBuilder);
    }

    public final void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            sg.a().removeCallbacks(this.a0);
            sg.a().postDelayed(this.a0, 5000L);
        }
    }

    public final void W() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (tBLottieAnimationView = this.m) == null) {
            return;
        }
        tBLottieAnimationView.clearAnimation();
        this.m.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    this.a.m.setMinFrame(0);
                    this.a.m.setFrame(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.m.setVisibility(8);
                    this.a.n.setVisibility(8);
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.l0(distributeVideoView.C);
                    if (this.a.E == 1) {
                        this.a.o.setVisibility(8);
                        this.a.p.setVisibility(8);
                    } else {
                        this.a.w.setPlayer(this.a.l.getControl());
                        this.a.w.m(0, (int) TimeUnit.SECONDS.toMillis(this.a.e.video_duration.intValue()));
                        this.a.w.p();
                        this.a.e0(true);
                        sg.a().removeCallbacks(this.a.W);
                        sg.a().postDelayed(this.a.W, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView distributeVideoView2 = this.a;
                    distributeVideoView2.B = distributeVideoView2.l.getControl().getCurrentPosition();
                    this.a.f0(true);
                    this.a.S.removeMessages(1003);
                    this.a.S.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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

    public final int X(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? i == 1 ? 0 : 1 : invokeI.intValue;
    }

    public final void Y() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.I || (animation = this.H) == null) {
            return;
        }
        this.u.startAnimation(animation);
        this.I = true;
    }

    public final void Z(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, context) == null) || context == null) {
            return;
        }
        this.b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0234, (ViewGroup) this, true);
        this.d = inflate;
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) inflate.findViewById(R.id.obfuscated_res_0x7f0907d5);
        this.l = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.l.getControl().setNoBussinessStats();
        this.l.getControl().setLooping(false);
        this.m = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0924f9);
        this.n = (ForeDrawableImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d6);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d0);
        this.p = this.d.findViewById(R.id.obfuscated_res_0x7f090399);
        this.s = this.d.findViewById(R.id.obfuscated_res_0x7f0907d1);
        this.t = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d2);
        this.q = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d8);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0907cf);
        this.u = findViewById;
        this.v = (ImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f0907d3);
        this.r = (ImageView) this.u.findViewById(R.id.obfuscated_res_0x7f0907d7);
        this.w = (VideoControllerView) this.u.findViewById(R.id.obfuscated_res_0x7f0907d4);
        FrameLayout frameLayout = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09205b);
        this.i = frameLayout;
        this.g = new yd8(context, frameLayout);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0903e8);
        this.x = tbImageView;
        tbImageView.setVisibility(8);
        this.y = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0924b8);
        this.m.setAnimation(R.raw.obfuscated_res_0x7f11001b);
        this.m.setMinFrame(0);
        this.m.setFrame(0);
        HomeGroupUbsUIHelper.handleImgMask(this.p, R.drawable.obfuscated_res_0x7f081244);
    }

    public final void a0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f010033);
        this.H = loadAnimation;
        loadAnimation.setAnimationListener(new Animation.AnimationListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.10
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    this.a.u.setVisibility(8);
                    this.a.I = false;
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
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.J) {
            return;
        }
        continuePlay(1);
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public void autoPlay(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && S()) {
            if (i <= 0) {
                h0(1);
                return;
            }
            sg.a().removeCallbacks(this.V);
            sg.a().postDelayed(this.V, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String str = this.F.scheme;
            if (!TextUtils.isEmpty(this.G)) {
                str = this.G;
            }
            if (TextUtils.isEmpty(str) || this.b == null) {
                return 0;
            }
            if (bh0.n(this.j.q) ? false : ah0.b(this.b, this.j.p)) {
                return 3;
            }
            if (isPlaying() && zj5.a().j()) {
                return hc8.a(this.b, str, this.j.getDownloadId(), this.j.g, this.F.cmdScheme);
            }
            return hc8.c(this.b, str, this.j, this.F.playCmdScheme);
        }
        return invokeV.intValue;
    }

    public final void c0() {
        TbPageContext<?> tbPageContext;
        TbPageContext<?> tbPageContext2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i = this.A;
            if (i == -1) {
                if (!pi.z() && (tbPageContext2 = this.a) != null) {
                    tbPageContext2.showToast((int) R.string.obfuscated_res_0x7f0f0c40);
                } else if (!pi.H() && (tbPageContext = this.a) != null) {
                    wr4 wr4Var = new wr4(tbPageContext.getPageActivity());
                    wr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0e8d);
                    wr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0266, new wr4.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
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

                        @Override // com.baidu.tieba.wr4.e
                        public void onClick(wr4 wr4Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, wr4Var2) == null) {
                                wr4Var2.dismiss();
                                this.a.performPlay();
                            }
                        }
                    });
                    wr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0371, new wr4.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
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

                        @Override // com.baidu.tieba.wr4.e
                        public void onClick(wr4 wr4Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, wr4Var2) == null) {
                                wr4Var2.dismiss();
                            }
                        }
                    });
                    wr4Var.create(this.a).show();
                } else {
                    performPlay();
                }
            } else if (i == 0) {
                stopPlay();
            } else if (i == 1) {
                this.J = true;
                pausePlay(0);
                if (this.E == 2) {
                    e0(true);
                }
            } else if (i != 2) {
            } else {
                this.J = false;
                continuePlay(2);
                if (this.E == 2) {
                    sg.a().removeCallbacks(this.W);
                    sg.a().postDelayed(this.W, TimeUnit.SECONDS.toMillis(3L));
                }
            }
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public boolean canPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= ri.i(this.b);
        }
        return invokeV.booleanValue;
    }

    public void continuePlay(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && this.A == 2) {
            this.O = i;
            i0(33, X(i), this.l.getControl().getCurrentPosition());
            this.l.getControl().getCurrentPosition();
            this.l.getControl().start();
            if (this.C) {
                vf5.e(this.z, true);
            }
            setLoadingAnimShow(false);
            SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080b06);
            this.A = 1;
        }
    }

    public final void d0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (tBLottieAnimationView = this.m) == null) {
            return;
        }
        tBLottieAnimationView.setMinFrame(0);
        this.m.setFrame(0);
        this.m.cancelAnimation();
    }

    public final void e0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            if (z) {
                sg.a().removeCallbacks(this.W);
                Animation animation = this.H;
                if (animation != null) {
                    animation.cancel();
                }
                this.u.setVisibility(0);
                if (this.A == 1) {
                    SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080b06);
                    return;
                } else {
                    SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080b05);
                    return;
                }
            }
            this.u.setVisibility(8);
        }
    }

    public final void f0(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048593, this, z) == null) && (imageView = this.q) != null && this.E == 1) {
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
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (tBLottieAnimationView = this.m) == null) {
            return;
        }
        tBLottieAnimationView.setAlpha(1.0f);
        this.m.setVisibility(0);
        this.m.loop(true);
        this.m.setMinAndMaxFrame(14, 80);
        this.m.playAnimation();
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.B : invokeV.longValue;
    }

    public VideoInfo getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e : (VideoInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public int getPlayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.A : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            VideoInfo videoInfo = this.e;
            return videoInfo != null ? videoInfo.video_url : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            this.O = i;
            if (this.e != null && this.A == -1) {
                if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.D) < TimeUnit.SECONDS.toSeconds(3L)) {
                    return;
                }
                zd8 zd8Var = this.h;
                if (zd8Var != null) {
                    zd8Var.e();
                }
                e98 e98Var = new e98();
                e98Var.e = "ad_feed";
                e98Var.d = e98Var.a("ad_feed");
                e98Var.f = e98Var.c("1");
                this.l.getControl().setVideoModel(e98Var);
                this.l.getControl().setVideoPath(this.e.video_url);
                this.l.getControl().setVideoScalingMode(this.Q);
                this.l.getControl().start();
                this.l.getControl().getCurrentPosition();
                SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080b06);
                sg.a().postDelayed(this.e0, 100L);
                this.s.setVisibility(8);
                this.n.setForegroundDrawable(0);
                this.A = 0;
                if (this.E == 1) {
                    this.o.setVisibility(0);
                    this.p.setVisibility(0);
                } else {
                    this.o.setVisibility(8);
                }
                TbPageContext<?> tbPageContext = this.a;
                if (tbPageContext != null) {
                    tbPageContext.registerListener(this.d0);
                    this.a.registerListener(this.b0);
                    this.a.registerListener(this.c0);
                }
                i0(31, X(this.O), 0);
            }
        }
    }

    public final void i0(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048601, this, i, i2, i3) == null) {
            j0(i, i2, i3, -1);
        }
    }

    public void initVideoViewLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            if (z) {
                int k = ri.k(getContext());
                int c = kd8.c(k);
                layoutParams.width = ri.k(getContext());
                layoutParams.height = k;
                layoutParams2.width = c;
                layoutParams2.height = k;
                layoutParams3.width = c;
                layoutParams3.height = k;
                layoutParams4.width = c;
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
            this.l.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getPlayStatus() != -1 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getPlayStatus() == 1 : invokeV.booleanValue;
    }

    public final void j0(int i, int i2, int i3, int i4) {
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048605, this, i, i2, i3, i4) == null) || (advertAppInfo = this.j) == null || this.e == null) {
            return;
        }
        advertAppInfo.j = this.k;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.v(this.j.j).z(String.valueOf(i)).q(String.valueOf(this.j.position + 1)).p(this.j.g).k(String.valueOf(i2)).l(String.valueOf(Math.round(i3 / 1000.0f))).m(String.valueOf(this.e.video_duration));
        if (i4 != -1 && i == 32) {
            clogBuilder.o(String.valueOf(i4));
        }
        if (i == 34) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("duration", this.e.video_duration);
                jSONObject.put(CriusAttrConstants.POSITION, i3);
                jSONObject.put("start_type", i2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            clogBuilder.A(jSONObject.toString());
        }
        if (i == 102) {
            clogBuilder.j("replaybtn");
        }
        iy0.b(clogBuilder);
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public int jump2DownloadDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? b0() : invokeV.intValue;
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            sg.a().removeCallbacks(this.V);
            sg.a().removeCallbacks(this.W);
            sg.a().removeCallbacks(this.a0);
            this.S.removeMessages(1001);
            this.S.removeMessages(1003);
            this.l.getControl().stopPlayback();
            this.A = -1;
            vf5.e(this.z, false);
            f0(false);
            this.n.setForegroundDrawable(0);
            this.n.setVisibility(0);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080b05);
            this.w.n();
            this.s.setVisibility(8);
            VideoInfo videoInfo = this.e;
            if (videoInfo != null) {
                this.o.setText(StringUtils.translateSecondsToString(videoInfo.video_duration.intValue()));
                this.o.setVisibility(0);
                this.p.setVisibility(0);
            }
            this.K = false;
            MessageManager.getInstance().unRegisterListener(this.d0);
            MessageManager.getInstance().unRegisterListener(this.b0);
            MessageManager.getInstance().unRegisterListener(this.c0);
        }
    }

    public final void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            if (z) {
                TbVideoViewContainer tbVideoViewContainer = this.l;
                if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                    this.l.getControl().setVolume(1.0f, 1.0f);
                }
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f0800c3);
                SkinManager.setImageResource(this.q, R.drawable.obfuscated_res_0x7f080ae5);
                if (this.A == 1) {
                    vf5.e(this.z, true);
                }
            } else {
                TbVideoViewContainer tbVideoViewContainer2 = this.l;
                if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null) {
                    this.l.getControl().setVolume(0.0f, 0.0f);
                }
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f0800c2);
                SkinManager.setImageResource(this.q, R.drawable.obfuscated_res_0x7f080ae3);
                vf5.e(this.z, false);
            }
            this.C = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onDetachedFromWindow();
            this.S.removeCallbacksAndMessages(null);
        }
    }

    public void pausePlay(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && this.A == 1) {
            j0(32, X(this.O), this.l.getControl().getCurrentPosition(), i);
            this.l.getControl().pause();
            vf5.e(this.z, false);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.v, R.drawable.obfuscated_res_0x7f080b05);
            this.A = 2;
        }
    }

    public void performPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            h0(2);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setAdInfo(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, adCard) == null) {
            this.F = adCard;
        }
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048616, this, videoInfo, i, tbPageContext) == null) {
            if (i != 1 && i != 2) {
                BdLog.e("DistributeVideoView: invalid video style!");
                return;
            }
            this.E = i;
            if (tbPageContext != null) {
                this.a = tbPageContext;
                a0();
            }
            setData(videoInfo);
        }
    }

    public void setHolderView(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, view2) == null) || view2 == null) {
            return;
        }
        this.c = view2;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, tbPageContext) == null) {
            this.a = tbPageContext;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            this.G = str;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048621, this, advertAppInfo, i, str) == null) {
            this.j = advertAppInfo;
            this.k = str;
            advertAppInfo.j = str;
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.P = z;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.Q = i;
            this.l.getControl().setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setVideoTailFrameData(jd8 jd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, jd8Var) == null) {
            this.f = jd8Var;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            autoPlay(0);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.baidu.tieba.wb8
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            stopPlay(true);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, advertAppInfo) == null) {
            if (advertAppInfo == null) {
                advertAppInfo = this.j;
            }
            zd8 b = this.g.b(this.f, this.h);
            this.h = b;
            if (b != null) {
                b.h(this.a);
                this.h.g(this.F);
                zd8 zd8Var = this.h;
                if (zd8Var instanceof ud8) {
                    ((ud8) zd8Var).m(this.P);
                }
                this.h.f(advertAppInfo);
                this.h.c(this.f);
                this.h.e();
            }
        }
    }

    public void stopPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            if (this.l.getControl().getCurrentPosition() > 0 && this.A != -1 && z) {
                i0(34, X(this.O), this.l.getControl().getCurrentPosition());
            }
            k0();
        }
    }

    public void setData(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, videoInfo) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.e = videoInfo;
            videoInfo.video_duration.intValue();
            this.z = new WeakReference<>(this.b.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            int k = ri.k(this.b) - ri.f(this.b, R.dimen.obfuscated_res_0x7f07024a);
            if (this.E == 2) {
                k = ri.k(this.b);
            }
            int intValue = this.e.video_width.intValue() > 0 ? (this.e.video_height.intValue() * k) / this.e.video_width.intValue() : k;
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = intValue;
                this.d.setLayoutParams(layoutParams);
            }
            setOnClickListener(this.R);
            this.n.setDefaultResource(0);
            this.n.setDefaultBgResource(R.drawable.pic_use_header_40_n);
            if (!qi.isEmpty(videoInfo.thumbnail_url)) {
                this.n.K(videoInfo.thumbnail_url, 10, false);
            }
            this.l.getControl().setOperableVideoContainer(this.T);
            if (zj5.a().k()) {
                e98 e98Var = new e98();
                e98Var.e = "ad_feed";
                e98Var.d = e98Var.a("ad_feed");
                e98Var.f = e98Var.c("1");
                this.l.getControl().setVideoModel(e98Var);
                this.l.getControl().setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.l.getControl().setOnSurfaceDestroyedListener(this.U);
            SkinManager.setViewTextColor(this.o, (int) R.color.cp_cont_m);
            this.o.setText(StringUtils.translateSecondsToString(this.e.video_duration.intValue()));
            if (this.E == 1) {
                this.C = false;
                SkinManager.setImageResource(this.q, R.drawable.obfuscated_res_0x7f080ae3);
                this.q.setVisibility(8);
            } else {
                this.C = true;
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f0800c3);
                this.q.setVisibility(8);
            }
            this.l.getControl().setIsVolume0(!this.C);
            this.r.setOnClickListener(this.R);
            this.q.setOnClickListener(this.R);
            this.s.setOnClickListener(this.R);
            this.s.setVisibility(8);
            SkinManager.setBackgroundColor(this.s, R.color.black_alpha80);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0101);
            if (this.E == 1) {
                this.p.setVisibility(0);
                this.o.setVisibility(0);
                return;
            }
            this.o.setVisibility(8);
            this.v.setOnClickListener(this.R);
            this.m.setOnClickListener(this.R);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = null;
        this.A = -1;
        this.B = 0L;
        this.C = false;
        this.D = 0L;
        this.E = 1;
        this.I = false;
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = 2;
        this.Q = 1;
        this.R = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    if (view2 == this.a.s) {
                        this.a.s.setVisibility(8);
                        this.a.performPlay();
                    } else if (view2 != this.a.r && view2 != this.a.q) {
                        if (view2 == this.a.m || view2 == this.a.v) {
                            this.a.c0();
                        } else if (this.a.F == null) {
                            this.a.c0();
                        } else {
                            int jump2DownloadDetailPage = this.a.jump2DownloadDetailPage();
                            this.a.T();
                            if (hc8.h(jump2DownloadDetailPage)) {
                                this.a.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.l0(!distributeVideoView.C);
                    }
                }
            }
        };
        this.S = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                    int i3 = message.what;
                    if (i3 != 1001) {
                        if (i3 == 1003 && this.a.A == 1) {
                            if (this.a.B == this.a.l.getControl().getCurrentPosition()) {
                                this.a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.B = distributeVideoView.l.getControl().getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.S.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.A == 1) {
                    } else {
                        if (!zj5.a().k() ? this.a.l.getControl().getCurrentPosition() <= 0 : !this.a.l.getControl().isPlaying()) {
                            this.a.S.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.A = 1;
                        this.a.W();
                        sg.a().removeCallbacks(this.a.e0);
                    }
                }
            }
        };
        this.T = new l98(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.l98
            public void changeRenderViewMode(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.tieba.l98
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onBackground(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeZ = interceptable2.invokeZ(1048582, this, z)) == null) {
                    return false;
                }
                return invokeZ.booleanValue;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, view2) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    this.a.D = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.N = true;
                    if (distributeVideoView.l != null && this.a.l.getControl() != null) {
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.O), this.a.l.getControl().getDuration());
                    }
                    this.a.k0();
                    if (this.a.h != null) {
                        this.a.h.d();
                        this.a.o.setVisibility(8);
                        this.a.p.setVisibility(8);
                        this.a.setLoadingAnimShow(false);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i3, i4, obj)) == null) {
                    this.a.k0();
                    if (this.a.l != null && this.a.l.getControl() != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.O), this.a.l.getControl().getCurrentPosition());
                    }
                    this.a.n.setForegroundDrawable(0);
                    this.a.setLoadingAnimShow(false);
                    this.a.s.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048586, this, i3, i4, obj)) == null) {
                    if (i3 == 3 && this.a.j != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        int i5 = (distributeVideoView.N && "DETAIL".equals(distributeVideoView.j.j)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.i0(i5, distributeVideoView2.X(distributeVideoView2.O), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048587, this) == null) || this.a.l == null || this.a.l.getControl() == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.a;
                distributeVideoView.L = distributeVideoView.l.getControl().getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.a;
                distributeVideoView2.M = distributeVideoView2.l.getControl().getDuration();
                this.a.l.getControl().setVolume(0.0f, 0.0f);
                this.a.S.removeMessages(1001);
                this.a.S.sendEmptyMessage(1001);
                if (this.a.C && this.a.E == 1) {
                    this.a.l0(false);
                }
            }

            @Override // com.baidu.tieba.l98
            public void onScroll() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048588, this) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048589, this) == null) {
                }
            }

            @Override // com.baidu.tieba.play.TbVideoViewContainer.a
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048590, this) == null) {
                }
            }

            public boolean onVolumeDown() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setStatistic(g98 g98Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, g98Var) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
                }
            }
        };
        this.U = new TbVideoViewContainer.a(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.play.TbVideoViewContainer.a
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.stopPlay();
                }
            }
        };
        this.V = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null || this.a.l == null || this.a.l.getControl() == null || !this.a.canPlay()) {
                    return;
                }
                this.a.h0(1);
            }
        };
        this.W = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.Y();
                }
            }
        };
        this.a0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.f0(false);
                }
            }
        };
        this.b0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.E == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.K) {
                            this.a.l0(true);
                            return;
                        } else {
                            this.a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.K = distributeVideoView.C;
                    this.a.l0(true);
                }
            }
        };
        this.c0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.E == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.l0(true);
                    }
                }
            }
        };
        this.d0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
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
        this.e0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr2;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.A == -1 || this.a.A == 0) {
                        this.a.g0();
                    }
                }
            }
        };
        Z(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistributeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.z = null;
        this.A = -1;
        this.B = 0L;
        this.C = false;
        this.D = 0L;
        this.E = 1;
        this.I = false;
        this.J = false;
        this.K = false;
        this.N = false;
        this.O = 2;
        this.Q = 1;
        this.R = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    if (view2 == this.a.s) {
                        this.a.s.setVisibility(8);
                        this.a.performPlay();
                    } else if (view2 != this.a.r && view2 != this.a.q) {
                        if (view2 == this.a.m || view2 == this.a.v) {
                            this.a.c0();
                        } else if (this.a.F == null) {
                            this.a.c0();
                        } else {
                            int jump2DownloadDetailPage = this.a.jump2DownloadDetailPage();
                            this.a.T();
                            if (hc8.h(jump2DownloadDetailPage)) {
                                this.a.U(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.l0(!distributeVideoView.C);
                    }
                }
            }
        };
        this.S = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
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
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
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
                    int i32 = message.what;
                    if (i32 != 1001) {
                        if (i32 == 1003 && this.a.A == 1) {
                            if (this.a.B == this.a.l.getControl().getCurrentPosition()) {
                                this.a.g0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.B = distributeVideoView.l.getControl().getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.S.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.A == 1) {
                    } else {
                        if (!zj5.a().k() ? this.a.l.getControl().getCurrentPosition() <= 0 : !this.a.l.getControl().isPlaying()) {
                            this.a.S.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.A = 1;
                        this.a.W();
                        sg.a().removeCallbacks(this.a.e0);
                    }
                }
            }
        };
        this.T = new l98(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.l98
            public void changeRenderViewMode(int i32) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i32) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.baidu.tieba.l98
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onBackground(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeZ = interceptable2.invokeZ(1048582, this, z)) == null) {
                    return false;
                }
                return invokeZ.booleanValue;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, view2) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    this.a.D = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.N = true;
                    if (distributeVideoView.l != null && this.a.l.getControl() != null) {
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.i0(34, distributeVideoView2.X(distributeVideoView2.O), this.a.l.getControl().getDuration());
                    }
                    this.a.k0();
                    if (this.a.h != null) {
                        this.a.h.d();
                        this.a.o.setVisibility(8);
                        this.a.p.setVisibility(8);
                        this.a.setLoadingAnimShow(false);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i32, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i32, i4, obj)) == null) {
                    this.a.k0();
                    if (this.a.l != null && this.a.l.getControl() != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.i0(36, distributeVideoView.X(distributeVideoView.O), this.a.l.getControl().getCurrentPosition());
                    }
                    this.a.n.setForegroundDrawable(0);
                    this.a.setLoadingAnimShow(false);
                    this.a.s.setVisibility(0);
                    return true;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i32, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048586, this, i32, i4, obj)) == null) {
                    if (i32 == 3 && this.a.j != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        int i5 = (distributeVideoView.N && "DETAIL".equals(distributeVideoView.j.j)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.i0(i5, distributeVideoView2.X(distributeVideoView2.O), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048587, this) == null) || this.a.l == null || this.a.l.getControl() == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.a;
                distributeVideoView.L = distributeVideoView.l.getControl().getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.a;
                distributeVideoView2.M = distributeVideoView2.l.getControl().getDuration();
                this.a.l.getControl().setVolume(0.0f, 0.0f);
                this.a.S.removeMessages(1001);
                this.a.S.sendEmptyMessage(1001);
                if (this.a.C && this.a.E == 1) {
                    this.a.l0(false);
                }
            }

            @Override // com.baidu.tieba.l98
            public void onScroll() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048588, this) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
            public void onSeekComplete() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048589, this) == null) {
                }
            }

            @Override // com.baidu.tieba.play.TbVideoViewContainer.a
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048590, this) == null) {
                }
            }

            public boolean onVolumeDown() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.tieba.l98
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setStatistic(g98 g98Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, g98Var) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.baidu.tieba.l98
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
                }
            }
        };
        this.U = new TbVideoViewContainer.a(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.tieba.play.TbVideoViewContainer.a
            public void onSurfaceDestroyed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.stopPlay();
                }
            }
        };
        this.V = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null || this.a.l == null || this.a.l.getControl() == null || !this.a.canPlay()) {
                    return;
                }
                this.a.h0(1);
            }
        };
        this.W = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.Y();
                }
            }
        };
        this.a0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.f0(false);
                }
            }
        };
        this.b0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
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
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.E == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.K) {
                            this.a.l0(true);
                            return;
                        } else {
                            this.a.l0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.K = distributeVideoView.C;
                    this.a.l0(true);
                }
            }
        };
        this.c0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
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
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.E == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.l0(true);
                    }
                }
            }
        };
        this.d0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
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
        this.e0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DistributeVideoView a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = objArr22;
                    Object[] objArr22 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i32 = newInitContext2.flag;
                    if ((i32 & 1) != 0) {
                        int i4 = i32 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    if (this.a.A == -1 || this.a.A == 0) {
                        this.a.g0();
                    }
                }
            }
        };
        Z(context);
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setData(VideoInfo videoInfo, id8 id8Var, int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{videoInfo, id8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.e = videoInfo;
            this.z = new WeakReference<>(this.b.getApplicationContext());
            k0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            setOnClickListener(this.R);
            int i6 = 13;
            if (id8Var != null && id8Var.a()) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                layoutParams2.width = i3;
                layoutParams2.height = i4;
                this.x.K(id8Var.a, 30, false);
                this.x.setVisibility(0);
                double d = id8Var.b;
                if (d > 0.0d) {
                    i = (int) (i3 * d);
                    i2 = kd8.b(i);
                }
                double d2 = id8Var.c;
                i5 = d2 > 0.0d ? Math.min((int) (i3 * d2), i3 - i) : 0;
                i6 = 11;
            } else {
                this.x.setVisibility(8);
                i5 = 0;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            layoutParams3.rightMargin = i5;
            layoutParams3.addRule(i6);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams4.width = i;
            layoutParams4.height = i2;
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            layoutParams5.width = i;
            layoutParams5.height = i2;
            this.n.setDefaultResource(0);
            this.n.setDefaultBgResource(R.drawable.pic_use_header_40_n);
            if (!qi.isEmpty(videoInfo.thumbnail_url)) {
                this.n.K(videoInfo.thumbnail_url, 10, false);
            }
            this.l.getControl().setOperableVideoContainer(this.T);
            if (zj5.a().k()) {
                e98 e98Var = new e98();
                e98Var.e = "ad_feed";
                e98Var.d = e98Var.a("ad_feed");
                e98Var.f = e98Var.c("1");
                this.l.getControl().setVideoModel(e98Var);
                this.l.getControl().setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.l.getControl().setOnSurfaceDestroyedListener(this.U);
            SkinManager.setViewTextColor(this.o, (int) R.color.cp_cont_m);
            this.o.setText(StringUtils.translateSecondsToString(this.e.video_duration.intValue()));
            if (this.E == 1) {
                this.C = false;
                SkinManager.setImageResource(this.q, R.drawable.obfuscated_res_0x7f080ae3);
                this.q.setVisibility(8);
            } else {
                this.C = true;
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f0800c3);
                this.q.setVisibility(8);
            }
            this.l.getControl().setIsVolume0(!this.C);
            this.r.setOnClickListener(this.R);
            this.q.setOnClickListener(this.R);
            this.s.setOnClickListener(this.R);
            this.s.setVisibility(8);
            SkinManager.setBackgroundColor(this.s, R.color.black_alpha80);
            SkinManager.setViewTextColor(this.t, (int) R.color.CAM_X0101);
            if (this.E == 1) {
                this.o.setVisibility(0);
                this.p.setVisibility(0);
                return;
            }
            this.o.setVisibility(8);
            this.v.setOnClickListener(this.R);
        }
    }
}
