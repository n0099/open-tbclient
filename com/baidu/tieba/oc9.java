package com.baidu.tieba;

import android.content.Context;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.util.VideoAudioHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.play.CallStateMessage;
import com.baidu.tieba.play.CallStateReceiver;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoListMediaControllerView;
import com.baidu.tieba.zz4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class oc9 {
    public static /* synthetic */ Interceptable $ic;
    public static int o0;
    public static CallStateReceiver p0;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public boolean B;
    public boolean C;
    public boolean D;
    public Animation E;
    public Animation F;
    public n G;
    public int H;
    public GestureDetector I;
    public WindowManager J;
    public View K;
    public View L;
    public TextView M;
    public SeekBar N;
    public ImageView O;
    public ImageView P;
    public AudioManager Q;
    public int R;
    public int S;

    /* renamed from: T  reason: collision with root package name */
    public int f1140T;
    public int U;
    public w8a V;
    public int W;
    public int X;
    public int Y;
    public int Z;
    public TbPageContext<?> a;
    public int a0;
    public SwipeBackLayout.b b;
    public boolean b0;
    public uc9 c;
    public WeakReference<Context> c0;
    public View d;
    public boolean d0;
    public View e;
    public k9a e0;
    public TbVideoViewContainer f;
    public Runnable f0;
    public View g;
    public Runnable g0;
    public VideoListMediaControllerView h;
    public TbVideoViewContainer.a h0;
    public View i;
    public View.OnClickListener i0;
    public View j;
    public boolean j0;
    public FrameLayout k;
    public Animation.AnimationListener k0;
    public FrameLayout.LayoutParams l;
    public Animation.AnimationListener l0;
    public ImageView m;
    public Runnable m0;
    public ImageView n;
    public CustomMessageListener n0;
    public ImageView o;
    public View p;
    public int q;
    public View r;
    public boolean s;
    public ImageView t;
    public String u;
    public TbImageView v;
    public CyberPlayerManager.OnPreparedListener w;
    public sc9 x;
    public ImageView y;
    public TextView z;

    /* loaded from: classes7.dex */
    public interface n {
        void a();

        void b();
    }

    public void P0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class a implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public a(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, animation) != null) {
                return;
            }
            this.a.C = false;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public b(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(oc9 oc9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var, Integer.valueOf(i)};
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
            this.a = oc9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof CallStateMessage) && ((CallStateMessage) customResponsedMessage).getCallState() == 1) {
                this.a.m0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public d(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                boolean onTouchEvent = this.a.I.onTouchEvent(motionEvent);
                if (motionEvent.getAction() == 1) {
                    oc9 oc9Var = this.a;
                    if (oc9Var.s && oc9Var.B) {
                        if (this.a.R == 1 && this.a.U != 0) {
                            oc9 oc9Var2 = this.a;
                            if (oc9Var2.U == 1) {
                                f = 1000.0f;
                            } else {
                                f = -1000.0f;
                            }
                            oc9Var2.P(f, false);
                            this.a.U = 0;
                            this.a.f1140T = 0;
                        }
                        if (!this.a.f.getControl().isPlaying() && 8 == this.a.t.getVisibility()) {
                            this.a.t.setVisibility(0);
                        }
                    }
                    this.a.o0();
                }
                return onTouchEvent;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements k9a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        @Override // com.baidu.tieba.k9a
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.k9a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.k9a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.k9a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.k9a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.k9a
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

        @Override // com.baidu.tieba.k9a
        public void onScroll() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
        public void onSeekComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            }
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.k9a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void setStatistic(f9a f9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, f9aVar) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.k9a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }

        public e(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) != null) {
                return;
            }
            this.a.B = false;
            this.a.H = 0;
            oc9 oc9Var = this.a;
            if (oc9Var.s) {
                oc9Var.o0();
                this.a.r0();
                this.a.V();
            } else {
                oc9Var.p0();
            }
            if (this.a.x != null) {
                this.a.x.a(this.a.u);
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                this.a.j.setVisibility(0);
                this.a.g.setVisibility(8);
                return true;
            }
            return invokeIIL.booleanValue;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                SafeHandler.getInst().removeCallbacks(this.a.f0);
                SafeHandler.getInst().post(this.a.f0);
                SafeHandler.getInst().removeCallbacks(this.a.g0);
                if (this.a.f != null && this.a.f.getControl() != null && this.a.h != null) {
                    if (!this.a.b0) {
                        oc9 oc9Var = this.a;
                        if (!oc9Var.s) {
                            oc9Var.f.getControl().setVolume(0.0f, 0.0f);
                            VideoAudioHelper.muteAudioFocus(this.a.c0, false);
                            this.a.h.l(this.a.H, this.a.f.getControl().getDuration());
                            if (this.a.H != 0) {
                                this.a.f.getControl().seekTo(this.a.H);
                            }
                            if (this.a.w == null) {
                                this.a.w.onPrepared();
                                return;
                            }
                            return;
                        }
                    }
                    this.a.f.getControl().setVolume(1.0f, 1.0f);
                    VideoAudioHelper.muteAudioFocus(this.a.c0, true);
                    this.a.h.l(this.a.H, this.a.f.getControl().getDuration());
                    if (this.a.H != 0) {
                    }
                    if (this.a.w == null) {
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public f(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f.getControl().getCurrentPositionSync() <= 100) {
                    SafeHandler.getInst().postDelayed(this.a.f0, 20L);
                    return;
                }
                this.a.B = true;
                this.a.i.setVisibility(8);
                this.a.j.setVisibility(8);
                this.a.g.setVisibility(8);
                this.a.v.setVisibility(8);
                this.a.S();
                if (this.a.p != null) {
                    this.a.p.setVisibility(0);
                }
                this.a.h.t();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public g(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.setVisibility(0);
                this.a.g.setVisibility(8);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements TbVideoViewContainer.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public h(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // com.baidu.tieba.play.TbVideoViewContainer.a
        public void onSurfaceDestroyed() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.B = false;
            SafeHandler.getInst().removeCallbacks(this.a.f0);
            SafeHandler.getInst().removeCallbacks(this.a.g0);
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public i(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.j.getId()) {
                    this.a.n0();
                } else if (view2.getId() != this.a.t.getId() && view2.getId() != this.a.n.getId()) {
                    if (view2.getId() == this.a.o.getId()) {
                        oc9 oc9Var = this.a;
                        if (oc9Var.s) {
                            SwipeBackLayout.b bVar = oc9Var.b;
                            if (bVar != null) {
                                bVar.U();
                            }
                            TiebaStatic.log(new StatisticItem("c11714"));
                        } else {
                            SwipeBackLayout.b bVar2 = oc9Var.b;
                            if (bVar2 != null) {
                                bVar2.C0();
                            }
                            TiebaStatic.log(new StatisticItem("c11710"));
                        }
                        this.a.O0();
                    } else if (view2.getId() == this.a.y.getId()) {
                        TiebaStatic.log(new StatisticItem("c11713"));
                        this.a.O0();
                    } else if (view2.getId() == this.a.d.getId()) {
                        if (this.a.B || this.a.s) {
                            this.a.V();
                        }
                    } else if (view2.getId() == this.a.m.getId()) {
                        oc9 oc9Var2 = this.a;
                        if (!oc9Var2.s) {
                            if (oc9Var2.b0) {
                                this.a.f.getControl().setVolume(0.0f, 0.0f);
                                this.a.m.setImageResource(R.drawable.obfuscated_res_0x7f0804cb);
                                VideoAudioHelper.muteAudioFocus(this.a.c0, false);
                                this.a.b0 = false;
                                return;
                            }
                            this.a.f.getControl().setVolume(1.0f, 1.0f);
                            this.a.m.setImageResource(R.drawable.obfuscated_res_0x7f0804cc);
                            VideoAudioHelper.muteAudioFocus(this.a.c0, true);
                            this.a.b0 = true;
                        }
                    }
                } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    BdUtilHelper.showLongToast(this.a.a.getPageActivity(), this.a.a.getString(R.string.obfuscated_res_0x7f0f0e61));
                } else if (this.a.f.getControl().isPlaying()) {
                    this.a.m0();
                } else if (this.a.B) {
                    this.a.q0();
                } else {
                    this.a.n0();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public j(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, zz4Var) != null) {
                return;
            }
            this.a.j0 = true;
            oc9 oc9Var = this.a;
            oc9Var.M0(oc9Var.u);
            zz4Var.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class k implements zz4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.zz4.e
        public void onClick(zz4 zz4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zz4Var) == null) {
                zz4Var.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }

        public l(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, animation) != null) || this.a.p == null) {
                return;
            }
            this.a.p.setVisibility(8);
            this.a.D = false;
        }
    }

    /* loaded from: classes7.dex */
    public class m extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc9 a;

        public m(oc9 oc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc9Var;
        }

        public /* synthetic */ m(oc9 oc9Var, d dVar) {
            this(oc9Var);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                oc9 oc9Var = this.a;
                if (oc9Var.s && oc9Var.B) {
                    if (!this.a.f.getControl().isPlaying() && this.a.t.getVisibility() == 0 && this.a.R == 1) {
                        this.a.t.setVisibility(8);
                    }
                    if (this.a.R == 0) {
                        this.a.D0();
                        if (Math.abs(f) - Math.abs(f2) > 0.0f) {
                            this.a.R = 1;
                            oc9 oc9Var2 = this.a;
                            oc9Var2.f1140T = oc9Var2.f.getControl().getCurrentPositionSync();
                            this.a.P(f, true);
                        } else {
                            this.a.R = 2;
                            this.a.Q(f2);
                        }
                    } else if (this.a.R != 1) {
                        if (this.a.R == 2) {
                            this.a.Q(f2);
                        }
                    } else {
                        this.a.P(f, true);
                    }
                    return super.onScroll(motionEvent, motionEvent2, f, f2);
                }
                return super.onScroll(motionEvent, motionEvent2, f, f2);
            }
            return invokeCommon.booleanValue;
        }
    }

    public oc9(TbPageContext<?> tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = 0;
        this.s = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.H = 0;
        this.R = 0;
        this.f1140T = 0;
        this.U = 0;
        this.Y = 0;
        this.b0 = false;
        this.c0 = null;
        this.d0 = true;
        this.e0 = new e(this);
        this.f0 = new f(this);
        this.g0 = new g(this);
        this.h0 = new h(this);
        this.i0 = new i(this);
        this.j0 = false;
        this.k0 = new l(this);
        this.l0 = new a(this);
        this.m0 = new b(this);
        this.n0 = new c(this, 2016503);
        this.a = tbPageContext;
        this.c0 = new WeakReference<>(TbadkCoreApplication.getInst());
        View e0 = e0(tbPageContext);
        this.d = e0;
        if (view2 instanceof FrameLayout) {
            ((FrameLayout) view2).addView(e0);
        }
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.d.findViewById(R.id.obfuscated_res_0x7f09290a);
        this.f = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.g = this.d.findViewById(R.id.obfuscated_res_0x7f092950);
        VideoListMediaControllerView videoListMediaControllerView = (VideoListMediaControllerView) this.d.findViewById(R.id.media_controller);
        this.h = videoListMediaControllerView;
        videoListMediaControllerView.setPlayer(this.f.getControl());
        this.i = this.d.findViewById(R.id.black_mask);
        View findViewById = this.d.findViewById(R.id.layout_error);
        this.j = findViewById;
        findViewById.setOnClickListener(this.i0);
        this.k = (FrameLayout) this.d.findViewById(R.id.danmu_container);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09114f);
        this.n = imageView;
        imageView.setOnClickListener(this.i0);
        ImageView imageView2 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091159);
        this.m = imageView2;
        imageView2.setOnClickListener(this.i0);
        ImageView imageView3 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090633);
        this.o = imageView3;
        imageView3.setOnClickListener(this.i0);
        this.p = this.d.findViewById(R.id.obfuscated_res_0x7f090638);
        this.e = this.d.findViewById(R.id.obfuscated_res_0x7f091fc1);
        this.f.getControl().setOperableVideoContainer(this.e0);
        this.f.getControl().setOnSurfaceDestroyedListener(this.h0);
        ImageView imageView4 = (ImageView) this.d.findViewById(R.id.img_play);
        this.t = imageView4;
        imageView4.setOnClickListener(this.i0);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.video_thumbnail);
        this.v = tbImageView;
        tbImageView.setDefaultBgResource(R.drawable.pic_bg_video_frs);
        this.W = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity());
        this.X = b0(this.a.getPageActivity());
        ImageView imageView5 = (ImageView) this.d.findViewById(R.id.img_exit);
        this.y = imageView5;
        imageView5.setOnClickListener(this.i0);
        this.z = (TextView) this.d.findViewById(R.id.video_title);
        View findViewById2 = this.d.findViewById(R.id.layout_title);
        this.A = findViewById2;
        findViewById2.setVisibility(8);
        this.E = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_2000_accelerate);
        this.F = AnimationUtils.loadAnimation(this.a.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
        this.J = (WindowManager) this.a.getPageActivity().getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        this.I = new GestureDetector(this.a.getPageActivity(), new m(this, null));
        AudioManager audioManager = (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
        this.Q = audioManager;
        this.S = audioManager.getStreamMaxVolume(3);
        this.a0 = this.Q.getStreamVolume(3);
        o0 = 100 / this.S;
        this.d.setOnTouchListener(new d(this));
        w8a w8aVar = new w8a(this.a.getPageActivity());
        this.V = w8aVar;
        w8aVar.j();
        this.Y = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0701be);
        if (p0 == null) {
            p0 = new CallStateReceiver();
        }
        p0.register(this.a.getPageActivity());
        this.a.registerListener(this.n0);
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.d0 = z;
        }
    }

    public void B0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.H = i2;
        }
    }

    public void C0(SwipeBackLayout.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void E0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.v.startLoad(str, 17, false);
        }
    }

    public void F0(uc9 uc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, uc9Var) == null) {
            this.c = uc9Var;
        }
    }

    public void G0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            StringHelper.numberUniformFormat(j2);
        }
    }

    public void H0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    public void I0(int i2) {
        uc9 uc9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && (uc9Var = this.c) != null && i2 != uc9Var.l()) {
            this.c.w();
        }
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            if (z) {
                this.h.setVisibility(0);
                this.n.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
            this.n.setVisibility(8);
        }
    }

    public View e0(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, tbPageContext)) == null) {
            return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d01b1, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public void g0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i2) == null) && this.f.getControl().getDuration() - i2 <= 3000 && this.s) {
            S();
            View view2 = this.p;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    public void s0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i2) == null) {
            this.q = i2;
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048624, this, z) == null) {
            if (z) {
                this.d.setOnClickListener(this.i0);
            } else {
                this.d.setClickable(false);
            }
        }
    }

    public final void u0(int i2) {
        VideoListMediaControllerView videoListMediaControllerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048625, this, i2) == null) && (videoListMediaControllerView = this.h) != null && (videoListMediaControllerView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams.leftMargin = i2;
            layoutParams.rightMargin = i2;
            this.h.setLayoutParams(layoutParams);
        }
    }

    public void v0(n nVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, nVar) == null) {
            this.G = nVar;
        }
    }

    public void w0(sc9 sc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, sc9Var) == null) {
            this.x = sc9Var;
        }
    }

    public void x0(CyberPlayerManager.OnPreparedListener onPreparedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, onPreparedListener) == null) {
            this.w = onPreparedListener;
        }
    }

    public void y0(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, view2) == null) {
            this.r = view2;
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 16) {
                this.d.setSystemUiVisibility(2);
            } else if (i2 >= 16 && i2 <= 18) {
                this.d.setSystemUiVisibility(4);
            } else {
                this.d.setSystemUiVisibility(5894);
            }
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public void O0() {
        w8a w8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (w8aVar = this.V) != null) {
            w8aVar.l();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            S();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            U();
            SafeHandler.getInst().removeCallbacks(this.m0);
            if (this.d0) {
                SafeHandler.getInst().postDelayed(this.m0, 3000L);
            }
        }
    }

    public final WindowManager.LayoutParams X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.format = 1;
            layoutParams.flags = 40;
            layoutParams.gravity = 17;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public View Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.p;
        }
        return (View) invokeV.objValue;
    }

    public View a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return !this.s;
        }
        return invokeV.booleanValue;
    }

    public q8a d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.f.getControl();
        }
        return (q8a) invokeV.objValue;
    }

    public VideoListMediaControllerView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.h;
        }
        return (VideoListMediaControllerView) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.d.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.f.getControl().pause();
            z0();
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.n.setImageResource(R.drawable.icon_video_midpause);
            this.g.setVisibility(8);
            this.t.setVisibility(0);
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.e.setLayoutParams(layoutParams);
            this.o.setClickable(true);
            this.o.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = false;
                layoutParams2.addRule(11, 0);
                layoutParams2.addRule(0, R.id.obfuscated_res_0x7f090633);
                int dimension = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f);
                this.m.setPadding((int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070399) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f), dimension);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void M0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            e9a e9aVar = new e9a();
            e9aVar.e = "ad_feed";
            e9aVar.d = e9aVar.a("ad_feed");
            e9aVar.f = e9aVar.c("1");
            this.f.getControl().setVideoModel(e9aVar);
            this.f.getControl().setVideoPath(str);
            this.f.getControl().start();
            this.g.setVisibility(0);
            this.v.setVisibility(0);
            this.t.setVisibility(8);
            this.n.setImageResource(R.drawable.icon_video_midplay);
            this.j.setVisibility(8);
            SafeHandler.getInst().removeCallbacks(this.g0);
            SafeHandler.getInst().postDelayed(this.g0, 60000L);
        }
    }

    public final void Q(float f2) {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048595, this, f2) == null) {
            if (!this.f.getControl().isPlaying()) {
                this.R = 0;
                return;
            }
            N();
            int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i6 > 0 && (i5 = this.Z) < 100) {
                this.Z = i5 + 1;
            }
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i7 < 0 && (i4 = this.Z) > 0) {
                this.Z = i4 - 1;
            }
            if (this.Z % o0 == 0) {
                if (i6 > 0 && (i3 = this.a0) < this.S) {
                    this.a0 = i3 + 1;
                }
                if (i7 < 0 && (i2 = this.a0) > 0) {
                    this.a0 = i2 - 1;
                }
            }
            if (this.a0 > 0) {
                this.O.setImageResource(R.drawable.icon_shengyin_open);
            } else {
                this.O.setImageResource(R.drawable.icon_shengyin_close);
            }
            this.Q.setStreamVolume(3, this.a0, 0);
            this.N.setProgress(this.Z);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            int i2 = this.R;
            if (i2 == 1) {
                if (this.K == null) {
                    View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.float_video_window_jindu, (ViewGroup) null);
                    this.K = inflate;
                    this.M = (TextView) inflate.findViewById(R.id.show_time);
                    this.P = (ImageView) this.K.findViewById(R.id.arrow_icon);
                }
                if (this.K.getParent() == null) {
                    this.J.addView(this.K, X());
                }
            } else if (i2 == 2) {
                if (this.L == null) {
                    View inflate2 = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.float_video_window_voice, (ViewGroup) null);
                    this.L = inflate2;
                    this.O = (ImageView) inflate2.findViewById(R.id.arrow_voice_icon);
                    this.N = (SeekBar) this.L.findViewById(R.id.show_voice_seekbar);
                }
                if (this.L.getParent() == null) {
                    this.J.addView(this.L, X());
                }
            }
        }
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            if (lc9.c(this.a.getPageActivity())) {
                layoutParams.bottomMargin = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070225) + 0.5f);
            } else {
                layoutParams.bottomMargin = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201) + 0.5f);
            }
            this.e.setLayoutParams(layoutParams);
            this.o.setClickable(false);
            this.o.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.alignWithParent = true;
                int dimension = (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f);
                this.m.setPadding((int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070399) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f0701be) + 0.5f), (int) (this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07021d) + 0.5f), dimension);
                layoutParams2.addRule(11);
                this.m.setLayoutParams(layoutParams2);
            }
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            SafeHandler.getInst().removeCallbacks(this.f0);
            SafeHandler.getInst().removeCallbacks(this.g0);
            this.f.getControl().stopPlayback();
            this.B = false;
            this.H = 0;
            p0();
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.p == null) {
            return;
        }
        SafeHandler.getInst().removeCallbacks(this.m0);
        this.F.setAnimationListener(null);
        this.E.setAnimationListener(null);
        this.p.clearAnimation();
        this.D = false;
        this.C = false;
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            N0();
            SafeHandler.getInst().removeCallbacks(this.m0);
            SafeHandler.getInst().removeCallbacks(this.f0);
            SafeHandler.getInst().removeCallbacks(this.g0);
            this.V.k();
            p0.unregister(this.a.getPageActivity());
        }
    }

    public void U() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (view2 = this.p) != null && !this.C) {
            if (this.D || view2.getVisibility() != 0) {
                S();
                this.p.setVisibility(0);
                this.F.setAnimationListener(this.l0);
                this.p.startAnimation(this.F);
                this.C = true;
            }
        }
    }

    public void j0() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048614, this) == null) && (view2 = this.p) != null && !this.D && view2.getVisibility() == 0) {
            S();
            this.p.setVisibility(0);
            this.E.setAnimationListener(this.k0);
            this.p.startAnimation(this.E);
            this.D = true;
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048619, this) != null) || this.R == 0) {
            return;
        }
        this.R = 0;
        View view2 = this.K;
        if (view2 != null && view2.getParent() != null) {
            try {
                this.J.removeView(this.K);
            } catch (IllegalArgumentException unused) {
            }
        }
        View view3 = this.L;
        if (view3 != null && view3.getParent() != null) {
            try {
                this.J.removeView(this.L);
            } catch (IllegalArgumentException unused2) {
            }
        }
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.p == null) {
            return;
        }
        this.i.setVisibility(0);
        this.t.setVisibility(0);
        this.g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(4);
        this.j.setVisibility(8);
        this.h.q();
        this.v.setVisibility(0);
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.f.getControl().start();
            this.n.setImageResource(R.drawable.icon_video_midplay);
            this.v.setVisibility(8);
            this.i.setVisibility(8);
            this.g.setVisibility(8);
            this.h.t();
            this.t.setVisibility(8);
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048622, this) != null) || this.p == null) {
            return;
        }
        this.i.setVisibility(0);
        this.t.setVisibility(0);
        this.g.setVisibility(8);
        this.n.setImageResource(R.drawable.icon_video_midpause);
        this.p.setVisibility(0);
        this.j.setVisibility(8);
        this.h.q();
        this.v.setVisibility(0);
    }

    public void O() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.r == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        this.l = layoutParams;
        layoutParams.width = this.r.getWidth();
        this.l.height = this.r.getHeight();
        int[] iArr = new int[2];
        this.r.getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams2 = this.l;
        layoutParams2.topMargin = iArr[1] - this.q;
        this.d.setLayoutParams(layoutParams2);
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (BdNetTypeUtil.isMobileNet() && !this.j0) {
                zz4 zz4Var = new zz4(this.a.getPageActivity());
                zz4Var.setMessage(TbadkCoreApplication.getInst().getString(R.string.play_video_mobile_tip));
                zz4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04ca, new j(this));
                zz4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f03d3, new k(this));
                zz4Var.create(this.a).show();
                return;
            }
            M0(this.u);
        }
    }

    public final void P(float f2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Boolean.valueOf(z)}) == null) {
            if (z) {
                if (f2 > 0.0f) {
                    this.f1140T -= 1000;
                    this.U = 1;
                } else {
                    this.f1140T += 1000;
                    this.U = 2;
                }
                int i2 = this.f1140T;
                if (i2 < 0) {
                    this.f1140T = 0;
                } else if (i2 > this.f.getControl().getDuration()) {
                    this.f1140T = this.f.getControl().getDuration();
                }
            }
            N();
            String j2 = this.h.j(this.f1140T);
            if (f2 > 0.0f) {
                this.P.setImageResource(R.drawable.icon_kuaitui);
            } else {
                this.P.setImageResource(R.drawable.icon_kuaijin);
            }
            if (!StringUtils.isNull(j2)) {
                TextView textView = this.M;
                StringBuilder sb = new StringBuilder();
                sb.append(j2);
                sb.append("/");
                sb.append(this.h.j(this.f.getControl().getDuration()));
                textView.setText(sb);
            }
            this.h.setCurrentDuration(this.f1140T, !z);
        }
    }

    public final void W(BaseFragmentActivity baseFragmentActivity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, baseFragmentActivity, z) == null) && baseFragmentActivity != null && baseFragmentActivity.getWindow() != null) {
            if (z) {
                WindowManager.LayoutParams attributes = baseFragmentActivity.getWindow().getAttributes();
                attributes.flags |= 1024;
                baseFragmentActivity.getWindow().setAttributes(attributes);
                baseFragmentActivity.getWindow().addFlags(512);
                return;
            }
            WindowManager.LayoutParams attributes2 = baseFragmentActivity.getWindow().getAttributes();
            attributes2.flags &= -1025;
            baseFragmentActivity.getWindow().setAttributes(attributes2);
            baseFragmentActivity.getWindow().clearFlags(512);
            this.g.getVisibility();
        }
    }

    public int b0(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, context)) == null) {
            int i2 = 0;
            if (context == null) {
                return 0;
            }
            try {
                Display defaultDisplay = ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                i2 = displayMetrics.heightPixels;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i2 == 0) {
                return BdUtilHelper.getEquipmentHeight(context);
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public void l0(BaseFragmentActivity baseFragmentActivity, Configuration configuration) {
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, baseFragmentActivity, configuration) == null) {
            if (configuration.orientation == 2) {
                this.s = true;
                this.m.setVisibility(8);
                this.f.getControl().setVolume(1.0f, 1.0f);
                VideoAudioHelper.muteAudioFocus(this.c0, true);
                this.d.setLayoutParams(new FrameLayout.LayoutParams(this.X, this.W));
                W(baseFragmentActivity, true);
                this.A.setVisibility(0);
                t0(true);
                this.k.setVisibility(8);
                n nVar = this.G;
                if (nVar != null) {
                    nVar.a();
                }
                V();
                this.o.setImageResource(R.drawable.icon_suoxiao);
                u0(this.Y);
                D0();
                return;
            }
            this.s = false;
            this.m.setVisibility(0);
            if (this.b0) {
                this.f.getControl().setVolume(1.0f, 1.0f);
                VideoAudioHelper.muteAudioFocus(this.c0, true);
            } else {
                this.f.getControl().setVolume(0.0f, 0.0f);
                VideoAudioHelper.muteAudioFocus(this.c0, false);
            }
            FrameLayout.LayoutParams layoutParams = this.l;
            if (layoutParams != null) {
                this.d.setLayoutParams(layoutParams);
            }
            W(baseFragmentActivity, false);
            this.A.setVisibility(8);
            t0(false);
            this.k.setVisibility(0);
            n nVar2 = this.G;
            if (nVar2 != null) {
                nVar2.b();
            }
            if (!this.B && (view2 = this.p) != null) {
                view2.clearAnimation();
                this.p.setVisibility(4);
            }
            o0();
            this.o.setImageResource(R.drawable.icon_fangda);
            u0(0);
            this.d.setSystemUiVisibility(0);
        }
    }
}
