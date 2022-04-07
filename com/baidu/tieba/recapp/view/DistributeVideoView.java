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
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bk5;
import com.repackage.d78;
import com.repackage.dd8;
import com.repackage.dr4;
import com.repackage.ed8;
import com.repackage.f78;
import com.repackage.fc8;
import com.repackage.ga8;
import com.repackage.gc8;
import com.repackage.hc8;
import com.repackage.k78;
import com.repackage.kd5;
import com.repackage.mi;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.pg;
import com.repackage.rg5;
import com.repackage.sc8;
import com.repackage.uc7;
import com.repackage.uc8;
import com.repackage.uj8;
import com.repackage.wc8;
import com.repackage.yc8;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class DistributeVideoView extends RelativeLayout implements IHomeAdVideoView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Context> A;
    public int B;
    public long C;
    public boolean D;
    public long E;
    public int F;
    public AdCard G;
    public String H;
    public Animation I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public int N;
    public boolean O;
    public int P;
    public boolean Q;
    public int R;
    public View.OnClickListener S;
    @NonNull
    public Handler T;
    public k78 U;
    public TbVideoViewContainer.a V;
    public Runnable W;
    public TbPageContext<?> a;
    public Context b;
    public View c;
    public View d;
    public VideoInfo e;
    public gc8 f;
    public dd8 g;
    public Runnable g0;
    public ed8 h;
    public Runnable h0;
    public ViewGroup i;
    public CustomMessageListener i0;
    public AdvertAppInfo j;
    public CustomMessageListener j0;
    public int k;
    public CustomMessageListener k0;
    public String l;
    public Runnable l0;
    public TbVideoViewContainer m;
    public TBLottieAnimationView n;
    public ForeDrawableImageView o;
    public TextView p;
    public View q;
    public ImageView r;
    public ImageView s;
    public View t;
    public TextView u;
    public View v;
    public ImageView w;
    public VideoControllerView x;
    public TbImageView y;
    public RelativeLayout z;

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
        this.A = null;
        this.B = -1;
        this.C = 0L;
        this.D = false;
        this.E = 0L;
        this.F = 1;
        this.J = false;
        this.K = false;
        this.L = false;
        this.O = false;
        this.P = 2;
        this.R = 1;
        this.S = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
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
                    if (view2 == this.a.t) {
                        this.a.t.setVisibility(8);
                        this.a.performPlay();
                    } else if (view2 != this.a.s && view2 != this.a.r) {
                        if (view2 == this.a.n || view2 == this.a.w) {
                            this.a.d0();
                        } else if (this.a.G == null) {
                            this.a.d0();
                        } else {
                            int jump2DownloadDetailPage = this.a.jump2DownloadDetailPage();
                            this.a.T();
                            if (ga8.q(jump2DownloadDetailPage)) {
                                this.a.V(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.m0(!distributeVideoView.D);
                    }
                }
            }
        };
        this.T = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
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
                        if (i3 == 1003 && this.a.B == 1) {
                            if (this.a.C == this.a.m.getControl().getCurrentPosition()) {
                                this.a.h0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.C = distributeVideoView.m.getControl().getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.T.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.B == 1) {
                    } else {
                        if (!rg5.h().A() ? this.a.m.getControl().getCurrentPosition() <= 0 : !this.a.m.getControl().isPlaying()) {
                            this.a.T.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.B = 1;
                        this.a.X();
                        pg.a().removeCallbacks(this.a.l0);
                    }
                }
            }
        };
        this.U = new k78(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
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

            @Override // com.repackage.k78
            public void changeRenderViewMode(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                }
            }

            @Override // com.repackage.k78
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.repackage.k78
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.repackage.k78
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
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
                    this.a.E = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.O = true;
                    if (distributeVideoView.m != null && this.a.m.getControl() != null) {
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.j0(34, distributeVideoView2.Y(distributeVideoView2.P), this.a.m.getControl().getDuration());
                    }
                    this.a.l0();
                    if (this.a.h != null) {
                        this.a.h.e();
                        this.a.p.setVisibility(8);
                        this.a.q.setVisibility(8);
                        this.a.setLoadingAnimShow(false);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i3, i4, obj)) == null) {
                    this.a.l0();
                    if (this.a.m != null && this.a.m.getControl() != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.j0(36, distributeVideoView.Y(distributeVideoView.P), this.a.m.getControl().getCurrentPosition());
                    }
                    this.a.o.setForegroundDrawable(0);
                    this.a.setLoadingAnimShow(false);
                    this.a.t.setVisibility(0);
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
                        int i5 = (distributeVideoView.O && "DETAIL".equals(distributeVideoView.j.k)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.j0(i5, distributeVideoView2.Y(distributeVideoView2.P), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048587, this) == null) || this.a.m == null || this.a.m.getControl() == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.a;
                distributeVideoView.M = distributeVideoView.m.getControl().getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.a;
                distributeVideoView2.N = distributeVideoView2.m.getControl().getDuration();
                this.a.m.getControl().setVolume(0.0f, 0.0f);
                this.a.T.removeMessages(1001);
                this.a.T.sendEmptyMessage(1001);
                if (this.a.D && this.a.F == 1) {
                    this.a.m0(false);
                }
            }

            @Override // com.repackage.k78
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

            @Override // com.repackage.k78
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setStatistic(f78 f78Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, f78Var) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.repackage.k78
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.repackage.k78
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
                }
            }
        };
        this.V = new TbVideoViewContainer.a(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
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
        this.W = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null || this.a.m == null || this.a.m.getControl() == null || !this.a.canPlay()) {
                    return;
                }
                this.a.i0(1);
            }
        };
        this.g0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
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
                    this.a.Z();
                }
            }
        };
        this.h0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
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
                    this.a.g0(false);
                }
            }
        };
        this.i0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.L) {
                            this.a.m0(true);
                            return;
                        } else {
                            this.a.m0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.L = distributeVideoView.D;
                    this.a.m0(true);
                }
            }
        };
        this.j0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.F == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.m0(true);
                    }
                }
            }
        };
        this.k0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                    this.a.g0(true);
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
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
                    if (this.a.B == -1 || this.a.B == 0) {
                        this.a.h0();
                    }
                }
            }
        };
        a0(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoadingAnimShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65576, this, z) == null) {
            e0();
            if (z) {
                this.n.setAlpha(1.0f);
                this.n.setVisibility(0);
                return;
            }
            this.n.setVisibility(8);
        }
    }

    public final boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (UbsABTestHelper.isNativeVideoAdsAutoPlayABTestA()) {
                return mi.z();
            }
            if (this.F == 1) {
                return uj8.a();
            }
            return mi.z();
        }
        return invokeV.booleanValue;
    }

    public final void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            j0(2, 1, 0);
        }
    }

    public final void U(AdvertAppInfo advertAppInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, advertAppInfo, i, str) == null) {
            advertAppInfo.k = str;
            sc8 l = wc8.l(this.j, 303, i, Y(this.P), this.e.video_duration.intValue(), this.N, -1);
            ed8 ed8Var = this.h;
            if (ed8Var != null) {
                ed8Var.l(l);
            }
        }
    }

    public final void V(int i) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || (advertAppInfo = this.j) == null || (videoInfo = this.e) == null) {
            return;
        }
        advertAppInfo.k = this.l;
        sc8 l = wc8.l(advertAppInfo, 706, this.k, 1, videoInfo.video_duration.intValue(), bk5.a(0), -1);
        boolean z = i == 1000;
        l.c(z ? "APP" : "URL");
        if (!z) {
            l.l(i);
        }
        l.h("DEEPLINK");
        uc8.b().d(l);
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            pg.a().removeCallbacks(this.h0);
            pg.a().postDelayed(this.h0, 5000L);
        }
    }

    public final void X() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (tBLottieAnimationView = this.n) == null) {
            return;
        }
        tBLottieAnimationView.clearAnimation();
        this.n.animate().alpha(0.0f).setDuration(200L).setListener(new Animator.AnimatorListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.2
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
                    this.a.n.setMinFrame(0);
                    this.a.n.setFrame(0);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.n.setVisibility(8);
                    this.a.o.setVisibility(8);
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.m0(distributeVideoView.D);
                    if (this.a.F == 1) {
                        this.a.p.setVisibility(8);
                        this.a.q.setVisibility(8);
                    } else {
                        this.a.x.setPlayer(this.a.m.getControl());
                        this.a.x.m(0, (int) TimeUnit.SECONDS.toMillis(this.a.e.video_duration.intValue()));
                        this.a.x.p();
                        this.a.f0(true);
                        pg.a().removeCallbacks(this.a.g0);
                        pg.a().postDelayed(this.a.g0, TimeUnit.SECONDS.toMillis(3L));
                    }
                    DistributeVideoView distributeVideoView2 = this.a;
                    distributeVideoView2.C = distributeVideoView2.m.getControl().getCurrentPosition();
                    this.a.g0(true);
                    this.a.T.removeMessages(1003);
                    this.a.T.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
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

    public final int Y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i == 1 ? 0 : 1 : invokeI.intValue;
    }

    public final void Z() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.J || (animation = this.I) == null) {
            return;
        }
        this.v.startAnimation(animation);
        this.J = true;
    }

    public final void a0(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context) == null) || context == null) {
            return;
        }
        this.b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0241, (ViewGroup) this, true);
        this.d = inflate;
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) inflate.findViewById(R.id.obfuscated_res_0x7f0907d5);
        this.m = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.m.getControl().setNoBussinessStats();
        this.n = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f09233e);
        this.o = (ForeDrawableImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d6);
        this.p = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d0);
        this.q = this.d.findViewById(R.id.obfuscated_res_0x7f09038e);
        this.t = this.d.findViewById(R.id.obfuscated_res_0x7f0907d1);
        this.u = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d2);
        this.r = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0907d8);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f0907cf);
        this.v = findViewById;
        this.w = (ImageView) findViewById.findViewById(R.id.obfuscated_res_0x7f0907d3);
        this.s = (ImageView) this.v.findViewById(R.id.obfuscated_res_0x7f0907d7);
        this.x = (VideoControllerView) this.v.findViewById(R.id.obfuscated_res_0x7f0907d4);
        FrameLayout frameLayout = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091ebf);
        this.i = frameLayout;
        this.g = new dd8(context, frameLayout);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0903db);
        this.y = tbImageView;
        tbImageView.setVisibility(8);
        this.z = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0922fc);
        this.n.setAnimation(R.raw.obfuscated_res_0x7f110018);
        this.n.setMinFrame(0);
        this.n.setFrame(0);
        HomeGroupUbsUIHelper.handleImgMask(this.q, R.drawable.obfuscated_res_0x7f08123d);
    }

    public void autoContinue() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.K) {
            return;
        }
        continuePlay(1);
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public void autoPlay(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && S()) {
            if (i <= 0) {
                i0(1);
                return;
            }
            pg.a().removeCallbacks(this.W);
            pg.a().postDelayed(this.W, TimeUnit.SECONDS.toMillis(i));
        }
    }

    public final void b0() {
        TbPageContext<?> tbPageContext;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbPageContext = this.a) == null) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.obfuscated_res_0x7f010033);
        this.I = loadAnimation;
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
                    this.a.v.setVisibility(8);
                    this.a.J = false;
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

    public final int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            String str = this.G.scheme;
            if (!TextUtils.isEmpty(this.H)) {
                str = this.H;
            }
            if (TextUtils.isEmpty(str) || this.b == null) {
                return 0;
            }
            if (ga8.C(this.j, str)) {
                return 3;
            }
            if (isPlaying() && rg5.h().z()) {
                return ga8.d(this.b, str, this.j.getDownloadId(), this.j.h, this.G.cmdScheme);
            }
            return ga8.g(this.b, str, this.j, this.G.playCmdScheme);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public boolean canPlay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            int[] iArr = new int[2];
            getLocationInWindow(iArr);
            return !(iArr[0] == 0 && iArr[1] == 0) && (iArr[1] + getHeight()) + (-120) > 0 && iArr[1] <= oi.i(this.b);
        }
        return invokeV.booleanValue;
    }

    public void continuePlay(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && this.B == 2) {
            this.P = i;
            j0(33, Y(i), this.m.getControl().getCurrentPosition());
            this.m.getControl().getCurrentPosition();
            this.m.getControl().start();
            if (this.D) {
                kd5.f(this.A, true);
            }
            setLoadingAnimShow(false);
            SkinManager.setImageResource(this.w, R.drawable.obfuscated_res_0x7f080ac0);
            this.B = 1;
        }
    }

    public final void d0() {
        TbPageContext<?> tbPageContext;
        TbPageContext<?> tbPageContext2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i = this.B;
            if (i == -1) {
                if (!mi.z() && (tbPageContext2 = this.a) != null) {
                    tbPageContext2.showToast((int) R.string.obfuscated_res_0x7f0f0c18);
                } else if (!mi.H() && (tbPageContext = this.a) != null) {
                    dr4 dr4Var = new dr4(tbPageContext.getPageActivity());
                    dr4Var.setMessageId(R.string.obfuscated_res_0x7f0f0e50);
                    dr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f025d, new dr4.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.8
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

                        @Override // com.repackage.dr4.e
                        public void onClick(dr4 dr4Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dr4Var2) == null) {
                                dr4Var2.dismiss();
                                this.a.performPlay();
                            }
                        }
                    });
                    dr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new dr4.e(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.9
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

                        @Override // com.repackage.dr4.e
                        public void onClick(dr4 dr4Var2) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, dr4Var2) == null) {
                                dr4Var2.dismiss();
                            }
                        }
                    });
                    dr4Var.create(this.a).show();
                } else {
                    performPlay();
                }
            } else if (i == 0) {
                stopPlay();
            } else if (i == 1) {
                this.K = true;
                pausePlay(0);
                if (this.F == 2) {
                    f0(true);
                }
            } else if (i != 2) {
            } else {
                this.K = false;
                continuePlay(2);
                if (this.F == 2) {
                    pg.a().removeCallbacks(this.g0);
                    pg.a().postDelayed(this.g0, TimeUnit.SECONDS.toMillis(3L));
                }
            }
        }
    }

    public final void e0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (tBLottieAnimationView = this.n) == null) {
            return;
        }
        tBLottieAnimationView.setMinFrame(0);
        this.n.setFrame(0);
        this.n.cancelAnimation();
    }

    public final void f0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            if (z) {
                pg.a().removeCallbacks(this.g0);
                Animation animation = this.I;
                if (animation != null) {
                    animation.cancel();
                }
                this.v.setVisibility(0);
                if (this.B == 1) {
                    SkinManager.setImageResource(this.w, R.drawable.obfuscated_res_0x7f080ac0);
                    return;
                } else {
                    SkinManager.setImageResource(this.w, R.drawable.obfuscated_res_0x7f080abf);
                    return;
                }
            }
            this.v.setVisibility(8);
        }
    }

    public final void g0(boolean z) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048594, this, z) == null) && (imageView = this.r) != null && this.F == 1) {
            if (z) {
                imageView.setVisibility(0);
                W();
                return;
            }
            imageView.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public long getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.C : invokeV.longValue;
    }

    public VideoInfo getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e : (VideoInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public int getPlayStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.B : invokeV.intValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            VideoInfo videoInfo = this.e;
            return videoInfo != null ? videoInfo.video_url : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this : (View) invokeV.objValue;
    }

    public final void h0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (tBLottieAnimationView = this.n) == null) {
            return;
        }
        tBLottieAnimationView.setAlpha(1.0f);
        this.n.setVisibility(0);
        this.n.loop(true);
        this.n.setMinAndMaxFrame(14, 80);
        this.n.playAnimation();
    }

    public final void i0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.P = i;
            if (this.e != null && this.B == -1) {
                if (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - this.E) < TimeUnit.SECONDS.toSeconds(3L)) {
                    return;
                }
                ed8 ed8Var = this.h;
                if (ed8Var != null) {
                    ed8Var.f();
                }
                d78 d78Var = new d78();
                d78Var.e = "ad_feed";
                d78Var.d = d78Var.a("ad_feed");
                d78Var.f = d78Var.c("1");
                this.m.getControl().setVideoModel(d78Var);
                this.m.getControl().setVideoPath(this.e.video_url);
                this.m.getControl().setVideoScalingMode(this.R);
                this.m.getControl().start();
                this.m.getControl().getCurrentPosition();
                SkinManager.setImageResource(this.w, R.drawable.obfuscated_res_0x7f080ac0);
                pg.a().postDelayed(this.l0, 100L);
                this.t.setVisibility(8);
                this.o.setForegroundDrawable(0);
                this.B = 0;
                if (this.F == 1) {
                    this.p.setVisibility(0);
                    this.q.setVisibility(0);
                } else {
                    this.p.setVisibility(8);
                }
                TbPageContext<?> tbPageContext = this.a;
                if (tbPageContext != null) {
                    tbPageContext.registerListener(this.k0);
                    this.a.registerListener(this.i0);
                    this.a.registerListener(this.j0);
                }
                j0(31, Y(this.P), 0);
            }
        }
    }

    public void initVideoViewLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            if (z) {
                int k = oi.k(getContext());
                int c = hc8.c(k);
                layoutParams.width = oi.k(getContext());
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
            this.m.requestLayout();
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? getPlayStatus() != -1 : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? getPlayStatus() == 1 : invokeV.booleanValue;
    }

    public final void j0(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048605, this, i, i2, i3) == null) {
            k0(i, i2, i3, -1);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public int jump2DownloadDetailPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? c0() : invokeV.intValue;
    }

    public final void k0(int i, int i2, int i3, int i4) {
        AdvertAppInfo advertAppInfo;
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048607, this, i, i2, i3, i4) == null) || (advertAppInfo = this.j) == null || (videoInfo = this.e) == null) {
            return;
        }
        advertAppInfo.k = this.l;
        uc8.b().d(wc8.l(advertAppInfo, i, this.k, i2, videoInfo.video_duration.intValue(), i3, i4));
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            pg.a().removeCallbacks(this.W);
            pg.a().removeCallbacks(this.g0);
            pg.a().removeCallbacks(this.h0);
            this.T.removeMessages(1001);
            this.T.removeMessages(1003);
            this.m.getControl().stopPlayback();
            this.B = -1;
            kd5.f(this.A, false);
            g0(false);
            this.o.setForegroundDrawable(0);
            this.o.setVisibility(0);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.w, R.drawable.obfuscated_res_0x7f080abf);
            this.x.n();
            this.t.setVisibility(8);
            VideoInfo videoInfo = this.e;
            if (videoInfo != null) {
                this.p.setText(StringUtils.translateSecondsToString(videoInfo.video_duration.intValue()));
                this.p.setVisibility(0);
                this.q.setVisibility(0);
            }
            this.L = false;
            MessageManager.getInstance().unRegisterListener(this.k0);
            MessageManager.getInstance().unRegisterListener(this.i0);
            MessageManager.getInstance().unRegisterListener(this.j0);
        }
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            if (z) {
                TbVideoViewContainer tbVideoViewContainer = this.m;
                if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                    this.m.getControl().setVolume(1.0f, 1.0f);
                }
                SkinManager.setImageResource(this.s, R.drawable.obfuscated_res_0x7f0800c4);
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f080a9f);
                if (this.B == 1) {
                    kd5.f(this.A, true);
                }
            } else {
                TbVideoViewContainer tbVideoViewContainer2 = this.m;
                if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null) {
                    this.m.getControl().setVolume(0.0f, 0.0f);
                }
                SkinManager.setImageResource(this.s, R.drawable.obfuscated_res_0x7f0800c3);
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f080a9d);
                kd5.f(this.A, false);
            }
            this.D = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            super.onAttachedToWindow();
            ed8 ed8Var = this.h;
            if (!(ed8Var instanceof yc8) || this.G == null) {
                return;
            }
            ((yc8) ed8Var).x();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            super.onDetachedFromWindow();
            ed8 ed8Var = this.h;
            if ((ed8Var instanceof yc8) && this.G != null) {
                ((yc8) ed8Var).C();
            }
            this.T.removeCallbacksAndMessages(null);
        }
    }

    public void pausePlay(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i) == null) && this.B == 1) {
            k0(32, Y(this.P), this.m.getControl().getCurrentPosition(), i);
            this.m.getControl().pause();
            kd5.f(this.A, false);
            setLoadingAnimShow(true);
            SkinManager.setImageResource(this.w, R.drawable.obfuscated_res_0x7f080abf);
            this.B = 2;
        }
    }

    public void performPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            i0(2);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setAdInfo(AdCard adCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, adCard) == null) {
            this.G = adCard;
        }
    }

    public void setData(VideoInfo videoInfo, int i, TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048617, this, videoInfo, i, tbPageContext) == null) {
            if (i != 1 && i != 2) {
                BdLog.e("DistributeVideoView: invalid video style!");
                return;
            }
            this.F = i;
            if (tbPageContext != null) {
                this.a = tbPageContext;
                b0();
            }
            setData(videoInfo);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setDownloadCallback(uc7 uc7Var) {
        ed8 ed8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, uc7Var) == null) || (ed8Var = this.h) == null) {
            return;
        }
        ed8Var.h(uc7Var);
    }

    public void setHolderView(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, view2) == null) || view2 == null) {
            return;
        }
        this.c = view2;
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setPageContext(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, tbPageContext) == null) {
            this.a = tbPageContext;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setScheme(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.H = str;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setStatisticInfo(AdvertAppInfo advertAppInfo, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048623, this, advertAppInfo, i, str) == null) {
            this.j = advertAppInfo;
            this.k = i;
            this.l = str;
            U(advertAppInfo, i, str);
        }
    }

    public void setTailFrameIsMiddlePage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            this.Q = z;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setVideoScalingMode(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.R = i;
            this.m.getControl().setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setVideoTailFrameData(gc8 gc8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, gc8Var) == null) {
            this.f = gc8Var;
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            autoPlay(0);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView, com.repackage.t98
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            stopPlay(true);
        }
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void updateTailFrameView(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, advertAppInfo) == null) {
            if (advertAppInfo == null) {
                advertAppInfo = this.j;
            }
            ed8 b = this.g.b(this.f, this.h);
            this.h = b;
            if (b != null) {
                b.j(this.a);
                this.h.i(this.G);
                ed8 ed8Var = this.h;
                if (ed8Var instanceof yc8) {
                    ((yc8) ed8Var).z(this.Q);
                }
                this.h.g(advertAppInfo);
                this.h.d(this.f);
                this.h.f();
            }
        }
    }

    public void stopPlay(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            if (this.m.getControl().getCurrentPosition() > 0 && this.B != -1 && z) {
                j0(34, Y(this.P), this.m.getControl().getCurrentPosition());
            }
            l0();
        }
    }

    public void setData(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, videoInfo) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.e = videoInfo;
            this.N = videoInfo.video_duration.intValue() * 1000;
            this.A = new WeakReference<>(this.b.getApplicationContext());
            l0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            int k = oi.k(this.b) - oi.f(this.b, R.dimen.obfuscated_res_0x7f07024d);
            if (this.F == 2) {
                k = oi.k(this.b);
            }
            int intValue = this.e.video_width.intValue() > 0 ? (this.e.video_height.intValue() * k) / this.e.video_width.intValue() : k;
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = intValue;
                this.d.setLayoutParams(layoutParams);
            }
            setOnClickListener(this.S);
            this.o.setDefaultResource(0);
            this.o.setDefaultBgResource(R.drawable.pic_use_header_40_n);
            if (!ni.isEmpty(videoInfo.thumbnail_url)) {
                this.o.K(videoInfo.thumbnail_url, 10, false);
            }
            this.m.getControl().setOperableVideoContainer(this.U);
            if (rg5.h().A()) {
                d78 d78Var = new d78();
                d78Var.e = "ad_feed";
                d78Var.d = d78Var.a("ad_feed");
                d78Var.f = d78Var.c("1");
                this.m.getControl().setVideoModel(d78Var);
                this.m.getControl().setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.m.getControl().setOnSurfaceDestroyedListener(this.V);
            SkinManager.setViewTextColor(this.p, (int) R.color.cp_cont_m);
            this.p.setText(StringUtils.translateSecondsToString(this.e.video_duration.intValue()));
            if (this.F == 1) {
                this.D = false;
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f080a9d);
                this.r.setVisibility(8);
            } else {
                this.D = true;
                SkinManager.setImageResource(this.s, R.drawable.obfuscated_res_0x7f0800c4);
                this.r.setVisibility(8);
            }
            this.m.getControl().setIsVolume0(!this.D);
            this.s.setOnClickListener(this.S);
            this.r.setOnClickListener(this.S);
            this.t.setOnClickListener(this.S);
            this.t.setVisibility(8);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha80);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0101);
            if (this.F == 1) {
                this.q.setVisibility(0);
                this.p.setVisibility(0);
                return;
            }
            this.p.setVisibility(8);
            this.w.setOnClickListener(this.S);
            this.n.setOnClickListener(this.S);
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
        this.A = null;
        this.B = -1;
        this.C = 0L;
        this.D = false;
        this.E = 0L;
        this.F = 1;
        this.J = false;
        this.K = false;
        this.L = false;
        this.O = false;
        this.P = 2;
        this.R = 1;
        this.S = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
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
                    if (view2 == this.a.t) {
                        this.a.t.setVisibility(8);
                        this.a.performPlay();
                    } else if (view2 != this.a.s && view2 != this.a.r) {
                        if (view2 == this.a.n || view2 == this.a.w) {
                            this.a.d0();
                        } else if (this.a.G == null) {
                            this.a.d0();
                        } else {
                            int jump2DownloadDetailPage = this.a.jump2DownloadDetailPage();
                            this.a.T();
                            if (ga8.q(jump2DownloadDetailPage)) {
                                this.a.V(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.m0(!distributeVideoView.D);
                    }
                }
            }
        };
        this.T = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
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
                        if (i3 == 1003 && this.a.B == 1) {
                            if (this.a.C == this.a.m.getControl().getCurrentPosition()) {
                                this.a.h0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.C = distributeVideoView.m.getControl().getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.T.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.B == 1) {
                    } else {
                        if (!rg5.h().A() ? this.a.m.getControl().getCurrentPosition() <= 0 : !this.a.m.getControl().isPlaying()) {
                            this.a.T.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.B = 1;
                        this.a.X();
                        pg.a().removeCallbacks(this.a.l0);
                    }
                }
            }
        };
        this.U = new k78(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
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

            @Override // com.repackage.k78
            public void changeRenderViewMode(int i3) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i3) == null) {
                }
            }

            @Override // com.repackage.k78
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.repackage.k78
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.repackage.k78
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
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
                    this.a.E = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.O = true;
                    if (distributeVideoView.m != null && this.a.m.getControl() != null) {
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.j0(34, distributeVideoView2.Y(distributeVideoView2.P), this.a.m.getControl().getDuration());
                    }
                    this.a.l0();
                    if (this.a.h != null) {
                        this.a.h.e();
                        this.a.p.setVisibility(8);
                        this.a.q.setVisibility(8);
                        this.a.setLoadingAnimShow(false);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i3, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i3, i4, obj)) == null) {
                    this.a.l0();
                    if (this.a.m != null && this.a.m.getControl() != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.j0(36, distributeVideoView.Y(distributeVideoView.P), this.a.m.getControl().getCurrentPosition());
                    }
                    this.a.o.setForegroundDrawable(0);
                    this.a.setLoadingAnimShow(false);
                    this.a.t.setVisibility(0);
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
                        int i5 = (distributeVideoView.O && "DETAIL".equals(distributeVideoView.j.k)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.j0(i5, distributeVideoView2.Y(distributeVideoView2.P), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048587, this) == null) || this.a.m == null || this.a.m.getControl() == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.a;
                distributeVideoView.M = distributeVideoView.m.getControl().getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.a;
                distributeVideoView2.N = distributeVideoView2.m.getControl().getDuration();
                this.a.m.getControl().setVolume(0.0f, 0.0f);
                this.a.T.removeMessages(1001);
                this.a.T.sendEmptyMessage(1001);
                if (this.a.D && this.a.F == 1) {
                    this.a.m0(false);
                }
            }

            @Override // com.repackage.k78
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

            @Override // com.repackage.k78
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setStatistic(f78 f78Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, f78Var) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.repackage.k78
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.repackage.k78
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
                }
            }
        };
        this.V = new TbVideoViewContainer.a(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
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
        this.W = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null || this.a.m == null || this.a.m.getControl() == null || !this.a.canPlay()) {
                    return;
                }
                this.a.i0(1);
            }
        };
        this.g0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
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
                    this.a.Z();
                }
            }
        };
        this.h0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
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
                    this.a.g0(false);
                }
            }
        };
        this.i0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.L) {
                            this.a.m0(true);
                            return;
                        } else {
                            this.a.m0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.L = distributeVideoView.D;
                    this.a.m0(true);
                }
            }
        };
        this.j0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.F == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.m0(true);
                    }
                }
            }
        };
        this.k0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                    this.a.g0(true);
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
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
                    if (this.a.B == -1 || this.a.B == 0) {
                        this.a.h0();
                    }
                }
            }
        };
        a0(context);
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
        this.A = null;
        this.B = -1;
        this.C = 0L;
        this.D = false;
        this.E = 0L;
        this.F = 1;
        this.J = false;
        this.K = false;
        this.L = false;
        this.O = false;
        this.P = 2;
        this.R = 1;
        this.S = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.1
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
                    if (view2 == this.a.t) {
                        this.a.t.setVisibility(8);
                        this.a.performPlay();
                    } else if (view2 != this.a.s && view2 != this.a.r) {
                        if (view2 == this.a.n || view2 == this.a.w) {
                            this.a.d0();
                        } else if (this.a.G == null) {
                            this.a.d0();
                        } else {
                            int jump2DownloadDetailPage = this.a.jump2DownloadDetailPage();
                            this.a.T();
                            if (ga8.q(jump2DownloadDetailPage)) {
                                this.a.V(jump2DownloadDetailPage);
                            }
                        }
                    } else {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.m0(!distributeVideoView.D);
                    }
                }
            }
        };
        this.T = new Handler(this, Looper.getMainLooper()) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.3
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
                        if (i32 == 1003 && this.a.B == 1) {
                            if (this.a.C == this.a.m.getControl().getCurrentPosition()) {
                                this.a.h0();
                            } else {
                                DistributeVideoView distributeVideoView = this.a;
                                distributeVideoView.C = distributeVideoView.m.getControl().getCurrentPosition();
                                this.a.setLoadingAnimShow(false);
                            }
                            this.a.T.sendEmptyMessageDelayed(1003, TimeUnit.SECONDS.toMillis(3L));
                        }
                    } else if (this.a.B == 1) {
                    } else {
                        if (!rg5.h().A() ? this.a.m.getControl().getCurrentPosition() <= 0 : !this.a.m.getControl().isPlaying()) {
                            this.a.T.sendEmptyMessageDelayed(1001, TimeUnit.MILLISECONDS.toMillis(500L));
                            return;
                        }
                        this.a.B = 1;
                        this.a.X();
                        pg.a().removeCallbacks(this.a.l0);
                    }
                }
            }
        };
        this.U = new k78(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.4
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

            @Override // com.repackage.k78
            public void changeRenderViewMode(int i32) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i32) == null) {
                }
            }

            @Override // com.repackage.k78
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // com.repackage.k78
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // com.repackage.k78
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
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
                    this.a.E = System.currentTimeMillis();
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.O = true;
                    if (distributeVideoView.m != null && this.a.m.getControl() != null) {
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.j0(34, distributeVideoView2.Y(distributeVideoView2.P), this.a.m.getControl().getDuration());
                    }
                    this.a.l0();
                    if (this.a.h != null) {
                        this.a.h.e();
                        this.a.p.setVisibility(8);
                        this.a.q.setVisibility(8);
                        this.a.setLoadingAnimShow(false);
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i32, int i4, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i32, i4, obj)) == null) {
                    this.a.l0();
                    if (this.a.m != null && this.a.m.getControl() != null) {
                        DistributeVideoView distributeVideoView = this.a;
                        distributeVideoView.j0(36, distributeVideoView.Y(distributeVideoView.P), this.a.m.getControl().getCurrentPosition());
                    }
                    this.a.o.setForegroundDrawable(0);
                    this.a.setLoadingAnimShow(false);
                    this.a.t.setVisibility(0);
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
                        int i5 = (distributeVideoView.O && "DETAIL".equals(distributeVideoView.j.k)) ? 35 : 31;
                        DistributeVideoView distributeVideoView2 = this.a;
                        distributeVideoView2.j0(i5, distributeVideoView2.Y(distributeVideoView2.P), 0);
                    }
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048587, this) == null) || this.a.m == null || this.a.m.getControl() == null) {
                    return;
                }
                DistributeVideoView distributeVideoView = this.a;
                distributeVideoView.M = distributeVideoView.m.getControl().getCurrentPosition();
                DistributeVideoView distributeVideoView2 = this.a;
                distributeVideoView2.N = distributeVideoView2.m.getControl().getDuration();
                this.a.m.getControl().setVolume(0.0f, 0.0f);
                this.a.T.removeMessages(1001);
                this.a.T.sendEmptyMessage(1001);
                if (this.a.D && this.a.F == 1) {
                    this.a.m0(false);
                }
            }

            @Override // com.repackage.k78
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

            @Override // com.repackage.k78
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // com.repackage.k78
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setData(ThreadData threadData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, threadData) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setStatistic(f78 f78Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, f78Var) == null) {
                }
            }

            @Override // com.repackage.k78
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // com.repackage.k78
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // com.repackage.k78
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
                }
            }
        };
        this.V = new TbVideoViewContainer.a(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.5
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
        this.W = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.6
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
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.a.e == null || this.a.m == null || this.a.m.getControl() == null || !this.a.canPlay()) {
                    return;
                }
                this.a.i0(1);
            }
        };
        this.g0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.7
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
                    this.a.Z();
                }
            }
        };
        this.h0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.11
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
                    this.a.g0(false);
                }
            }
        };
        this.i0 = new CustomMessageListener(this, 2921398) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.12
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F == 1 && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                    if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                        if (this.a.L) {
                            this.a.m0(true);
                            return;
                        } else {
                            this.a.m0(false);
                            return;
                        }
                    }
                    DistributeVideoView distributeVideoView = this.a;
                    distributeVideoView.L = distributeVideoView.D;
                    this.a.m0(true);
                }
            }
        };
        this.j0 = new CustomMessageListener(this, 2921381) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.13
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
                if ((interceptable2 == null || interceptable2.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent) && this.a.F == 1) {
                    KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                        this.a.m0(true);
                    }
                }
            }
        };
        this.k0 = new CustomMessageListener(this, 2921418) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.14
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
                    this.a.g0(true);
                }
            }
        };
        this.l0 = new Runnable(this) { // from class: com.baidu.tieba.recapp.view.DistributeVideoView.15
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
                    if (this.a.B == -1 || this.a.B == 0) {
                        this.a.h0();
                    }
                }
            }
        };
        a0(context);
    }

    @Override // com.baidu.tieba.recapp.view.IHomeAdVideoView
    public void setData(VideoInfo videoInfo, fc8 fc8Var, int i, int i2, int i3, int i4) {
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{videoInfo, fc8Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (videoInfo == null) {
                setVisibility(8);
                return;
            }
            this.e = videoInfo;
            this.A = new WeakReference<>(this.b.getApplicationContext());
            l0();
            SkinManager.setBackgroundColor(this, R.color.CAM_X0201);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i4;
            setOnClickListener(this.S);
            int i6 = 13;
            if (fc8Var != null && fc8Var.a()) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                layoutParams2.width = i3;
                layoutParams2.height = i4;
                this.y.K(fc8Var.a, 30, false);
                this.y.setVisibility(0);
                double d = fc8Var.b;
                if (d > 0.0d) {
                    i = (int) (i3 * d);
                    i2 = hc8.b(i);
                }
                double d2 = fc8Var.c;
                i5 = d2 > 0.0d ? Math.min((int) (i3 * d2), i3 - i) : 0;
                i6 = 11;
            } else {
                this.y.setVisibility(8);
                i5 = 0;
            }
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams3.width = i;
            layoutParams3.height = i2;
            layoutParams3.rightMargin = i5;
            layoutParams3.addRule(i6);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams4.width = i;
            layoutParams4.height = i2;
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams5.width = i;
            layoutParams5.height = i2;
            this.o.setDefaultResource(0);
            this.o.setDefaultBgResource(R.drawable.pic_use_header_40_n);
            if (!ni.isEmpty(videoInfo.thumbnail_url)) {
                this.o.K(videoInfo.thumbnail_url, 10, false);
            }
            this.m.getControl().setOperableVideoContainer(this.U);
            if (rg5.h().A()) {
                d78 d78Var = new d78();
                d78Var.e = "ad_feed";
                d78Var.d = d78Var.a("ad_feed");
                d78Var.f = d78Var.c("1");
                this.m.getControl().setVideoModel(d78Var);
                this.m.getControl().setVideoPath(videoInfo.video_url);
                CyberPlayerManager.prefetch(videoInfo.video_url, null, null, PreLoadVideoSwitchManager.getInstance().getSize(), null);
            }
            this.m.getControl().setOnSurfaceDestroyedListener(this.V);
            SkinManager.setViewTextColor(this.p, (int) R.color.cp_cont_m);
            this.p.setText(StringUtils.translateSecondsToString(this.e.video_duration.intValue()));
            if (this.F == 1) {
                this.D = false;
                SkinManager.setImageResource(this.r, R.drawable.obfuscated_res_0x7f080a9d);
                this.r.setVisibility(8);
            } else {
                this.D = true;
                SkinManager.setImageResource(this.s, R.drawable.obfuscated_res_0x7f0800c4);
                this.r.setVisibility(8);
            }
            this.m.getControl().setIsVolume0(!this.D);
            this.s.setOnClickListener(this.S);
            this.r.setOnClickListener(this.S);
            this.t.setOnClickListener(this.S);
            this.t.setVisibility(8);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha80);
            SkinManager.setViewTextColor(this.u, (int) R.color.CAM_X0101);
            if (this.F == 1) {
                this.p.setVisibility(0);
                this.q.setVisibility(0);
                return;
            }
            this.p.setVisibility(8);
            this.w.setOnClickListener(this.S);
        }
    }
}
