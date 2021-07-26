package com.baidu.tieba.recapp.lego.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.lego.model.VideoMiddlePageAdCard;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video_net_tip.VideoNetworkStateTipView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n2.c;
import d.a.q0.w2.x;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements d.a.q0.n1.o.l.h, CountDownTextView.c, View.OnClickListener, d.a.q0.n1.o.l.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public HeadImageView B;
    public TextView C;
    public d.a.q0.n2.c D;
    public Animation E;
    public Animation F;
    public VideoMiddlePageAdCard G;
    public int H;
    public TextView I;
    public TextView J;
    public d.a.q0.u0.h1.a K;
    public boolean L;
    public ViewGroup M;
    public d.a.q0.w2.j0.d N;
    public d.a.q0.w2.j0.e O;
    public VideoNetworkStateTipView P;
    public int Q;
    public d.a.q0.u0.p2.c R;
    public d.a.q0.n1.o.l.f S;
    public int T;
    public boolean U;
    public boolean V;
    public o W;
    public Animation.AnimationListener a0;
    public Animation.AnimationListener b0;
    public View r;
    public View s;
    public FrameLayout t;
    public FrameLayout u;
    public View v;
    public View w;
    public View x;
    public View y;
    public TextView z;

    /* loaded from: classes4.dex */
    public class a implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.u0.h1.a f20665e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20666f;

        public a(VideoMiddlePageAdView videoMiddlePageAdView, d.a.q0.u0.h1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20666f = videoMiddlePageAdView;
            this.f20665e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                d.a.q0.u0.h1.a aVar = this.f20665e;
                if (aVar != null) {
                    aVar.cancel();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f20666f;
                videoMiddlePageAdView.r0(!videoMiddlePageAdView.L ? 1 : 0);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20667a;

        public b(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20667a = videoMiddlePageAdView;
        }

        @Override // d.a.q0.n2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f20667a;
                videoMiddlePageAdView.o0(1, videoMiddlePageAdView.D.B0());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20668a;

        public c(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20668a = videoMiddlePageAdView;
        }

        @Override // d.a.q0.n2.c.b0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f20668a;
                videoMiddlePageAdView.p0(1, videoMiddlePageAdView.D.B0());
                this.f20668a.V = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20669e;

        public d(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20669e = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                d.a.p0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.f() || this.f20669e.G == null) {
                    return false;
                }
                d.a.d.e.p.a.a(this.f20669e.G.adCollect());
                ((Vibrator) this.f20669e.m.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdCard f20670e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20671f;

        public e(VideoMiddlePageAdView videoMiddlePageAdView, VideoMiddlePageAdCard videoMiddlePageAdCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView, videoMiddlePageAdCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20671f = videoMiddlePageAdView;
            this.f20670e = videoMiddlePageAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f20671f.G == null || this.f20671f.G.getAdFacadeData() == null || this.f20671f.G.getAdFacadeData().q() == null) {
                    str = null;
                    str2 = null;
                } else {
                    AdvertAppInfo q = this.f20671f.G.getAdFacadeData().q();
                    str2 = q.getDownloadId();
                    str = q.Y3;
                }
                int e2 = x.e(this.f20671f.m, this.f20670e.getButtonScheme(), str2, str);
                if (this.f20671f.O != null) {
                    this.f20671f.O.a(false);
                }
                if (this.f20671f.o != null) {
                    this.f20671f.o.a(e2, null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20672e;

        public f(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20672e = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            d.a.q0.n2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f20672e.D) == null || cVar.I0() == null) {
                return;
            }
            VideoMiddlePageAdView videoMiddlePageAdView = this.f20672e;
            videoMiddlePageAdView.T = (int) TimeUnit.MILLISECONDS.toSeconds(videoMiddlePageAdView.D.I0().getDuration());
        }
    }

    /* loaded from: classes4.dex */
    public class g implements c.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20673a;

        public g(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20673a = videoMiddlePageAdView;
        }

        @Override // d.a.q0.n2.c.v
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f20673a.W == null) {
                return;
            }
            if (z) {
                this.f20673a.W.g(0);
            } else {
                this.f20673a.W.g(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20674e;

        public h(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20674e = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20674e.P.setHasAgreeToPlay(true);
                this.f20674e.D.n1(false);
                this.f20674e.P.g();
                if (this.f20674e.G == null || this.f20674e.G.video == null) {
                    return;
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f20674e;
                videoMiddlePageAdView.D.d2(videoMiddlePageAdView.G.video.video_url, "");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20675a;

        public i(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20675a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.f20675a.v != null) {
                    this.f20675a.v.setVisibility(8);
                }
                if (this.f20675a.w != null) {
                    this.f20675a.w.setVisibility(8);
                }
            }
        }

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
                if (this.f20675a.v != null) {
                    this.f20675a.v.setVisibility(0);
                }
                if (this.f20675a.w != null) {
                    this.f20675a.w.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20676a;

        public j(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20676a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.f20676a.v != null) {
                    this.f20676a.v.setVisibility(0);
                }
                if (this.f20676a.w != null) {
                    this.f20676a.w.setVisibility(0);
                }
            }
        }

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
                if (this.f20676a.v != null) {
                    this.f20676a.v.setVisibility(8);
                }
                if (this.f20676a.w != null) {
                    this.f20676a.w.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20677a;

        public k(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20677a = videoMiddlePageAdView;
        }

        @Override // d.a.q0.n2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.q0.n2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements c.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20678a;

        public l(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20678a = videoMiddlePageAdView;
        }

        @Override // d.a.q0.n2.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // d.a.q0.n2.c.g0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f20678a.G != null && this.f20678a.G.video != null && this.f20678a.G.video.video_height.intValue() > this.f20678a.G.video.video_width.intValue()) {
                    this.f20678a.D.M1(false, true);
                } else {
                    this.f20678a.D.M1(false, true);
                }
                if (this.f20678a.S != null) {
                    this.f20678a.S.h(this.f20678a);
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f20678a;
                videoMiddlePageAdView.t0(1 ^ (videoMiddlePageAdView.L ? 1 : 0));
                this.f20678a.U = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements c.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20679a;

        public m(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20679a = videoMiddlePageAdView;
        }

        @Override // d.a.q0.n2.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f20679a;
                videoMiddlePageAdView.D.d2(videoMiddlePageAdView.G.video.video_url, "");
                if (this.f20679a.S != null) {
                    this.f20679a.S.h(this.f20679a);
                }
                this.f20679a.t0(1);
                this.f20679a.U = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20680e;

        public n(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20680e = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20680e.D.a1();
                if (this.f20680e.O != null) {
                    this.f20680e.O.e();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f20680e;
                videoMiddlePageAdView.n0(!videoMiddlePageAdView.L ? 1 : 0);
                this.f20680e.V = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f20681a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f20682b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f20683c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f20684d;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f20685e;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f20685e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f20685e.f20682b.removeCallbacks(this.f20685e.f20683c);
                    this.f20685e.g(2);
                }
            }
        }

        public o(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20684d = videoMiddlePageAdView;
            this.f20681a = -1;
            this.f20683c = new a(this);
            this.f20682b = new Handler();
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f20682b.removeCallbacks(this.f20683c);
                this.f20682b.postDelayed(this.f20683c, 3000L);
            }
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = this.f20681a;
                if (i2 == i3) {
                    return i3;
                }
                this.f20684d.y.setVisibility(8);
                this.f20684d.x.setVisibility(8);
                this.f20684d.w0(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.f20681a;
                if (i2 == i3) {
                    return i3;
                }
                this.f20684d.y.setVisibility(0);
                this.f20684d.x.setVisibility(0);
                this.f20684d.w0(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.f20681a;
                if (i2 == i3) {
                    return i3;
                }
                this.f20684d.y.setVisibility(0);
                this.f20684d.x.setVisibility(0);
                d.a.q0.n2.c cVar = this.f20684d.D;
                if (cVar != null) {
                    cVar.O0();
                }
                if (i3 != 3 || this.f20684d.G.autoPlay) {
                    this.f20684d.w0(false);
                    return i2;
                }
                return i2;
            }
            return invokeI.intValue;
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                if (i2 == 0) {
                    this.f20681a = d(i2);
                    c();
                } else if (i2 == 1) {
                    this.f20681a = d(i2);
                    this.f20682b.removeCallbacks(this.f20683c);
                } else if (i2 == 2) {
                    this.f20681a = f(i2);
                } else if (i2 != 3) {
                    this.f20681a = f(i2);
                } else {
                    this.f20681a = e(i2);
                    c();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoMiddlePageAdView(TbPageContext tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.U = false;
        this.V = true;
        this.a0 = new i(this);
        this.b0 = new j(this);
        this.U = false;
        this.V = true;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.r = inflate;
        this.t = (FrameLayout) inflate.findViewById(R.id.video_agg_container);
        this.s = this.r.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) this.r.findViewById(R.id.video_container);
        this.u = frameLayout;
        d.a.q0.n2.c cVar = new d.a.q0.n2.c(this.m, frameLayout, false);
        this.D = cVar;
        cVar.O1(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.D.K1(new f(this));
        this.D.p1(new g(this));
        this.D.f61348e.setOnTouchListener(null);
        this.z = (TextView) this.r.findViewById(R.id.title);
        HeadImageView headImageView = (HeadImageView) this.r.findViewById(R.id.user_icon);
        this.B = headImageView;
        headImageView.setIsRound(true);
        this.B.setDefaultBgResource(R.color.CAM_X0205);
        this.B.setDefaultResource(R.drawable.icon_default_avatar100);
        this.A = (TextView) this.r.findViewById(R.id.ad_tag);
        this.C = (TextView) this.r.findViewById(R.id.user_name);
        this.I = (TextView) this.r.findViewById(R.id.ad_operate_title);
        this.J = (TextView) this.r.findViewById(R.id.ad_operate_button);
        this.M = (FrameLayout) this.r.findViewById(R.id.tail_frame_container);
        d.a.q0.w2.j0.d dVar = new d.a.q0.w2.j0.d(this.m.getPageActivity(), this.M);
        this.N = dVar;
        dVar.f66719a = 1;
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) this.r.findViewById(R.id.network_state_tip);
        this.P = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new h(this));
        this.v = this.r.findViewById(R.id.video_agg_container_foreground);
        this.x = this.r.findViewById(R.id.user_container_foreground);
        this.y = this.r.findViewById(R.id.title_foreground);
        this.w = this.r.findViewById(R.id.operate_area_foreground);
        this.v.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.D.H1(this);
        this.z.setOnClickListener(this);
        this.B.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.H = d.a.d.e.p.l.k(this.m.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams.height = (int) (this.H * 0.5625f);
        this.t.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.E = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.E.setAnimationListener(this.b0);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.F = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.F.setAnimationListener(this.a0);
        this.r.setOnClickListener(this);
        this.W = new o(this);
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
    public void a(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.K.a(this.Q);
        }
    }

    public final void f0(d.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) || dVar == null) {
            return;
        }
        int i2 = !this.L ? 1 : 0;
        d.a.q0.w2.i0.c m2 = d.a.q0.w2.i0.g.m(this.G.getAdFacadeData(), 303, this.G.getAdFacadeData().e(), i2, this.G.video.video_duration.intValue(), 0, -1);
        d.a.q0.w2.j0.e eVar = this.O;
        if (eVar != null) {
            eVar.k(m2);
        }
    }

    public final void g0(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2, d.a.q0.u0.h1.a aVar) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, videoMiddlePageAdCard, i2, aVar) == null) || videoMiddlePageAdCard == null || (videoInfo = videoMiddlePageAdCard.video) == null) {
            return;
        }
        this.Q = i2;
        this.L = this.G.autoPlay;
        this.U = false;
        Integer num = videoInfo.video_duration;
        if (num != null && num.intValue() > 0) {
            this.T = videoMiddlePageAdCard.video.video_duration.intValue();
        }
        if (this.D.T0()) {
            p0(!videoMiddlePageAdCard.autoPlay ? 1 : 0, this.D.B0());
            this.V = true;
        }
        this.D.k2();
        this.D.s1(true);
        this.D.v1(false);
        this.D.t1(true);
        this.D.M1(false, true);
        this.D.L1(i2);
        this.D.y1(new k(this));
        this.D.G1(new l(this));
        this.D.A1(new m(this));
        this.D.o1(false);
        this.D.q0();
        this.D.I1(new n(this));
        this.D.J1(new a(this, aVar));
        this.D.S1(videoMiddlePageAdCard.video.thumbnail_url);
        this.D.Y1(videoMiddlePageAdCard.video.video_url, "");
        this.D.D1(new b(this));
        this.D.B1(new c(this));
        this.D.a1();
        this.D.a2();
        if (videoMiddlePageAdCard.autoPlay) {
            if (this.P.d()) {
                this.D.c2(false);
                this.P.f();
                this.D.n1(true);
                this.D.U0(videoMiddlePageAdCard.video.video_url, "");
            } else {
                this.D.n1(false);
                this.D.c2(false);
                this.P.b();
                this.D.i2(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
            }
            d.a.q0.w2.j0.e eVar = this.O;
            if (eVar != null) {
                eVar.a(true);
            }
            if (i2 == 0) {
                this.v.setVisibility(8);
                this.w.setVisibility(8);
            } else {
                this.v.startAnimation(this.F);
                this.w.startAnimation(this.F);
            }
            if (i2 == 0) {
                this.W.g(3);
                return;
            } else {
                this.W.g(0);
                return;
            }
        }
        this.P.b();
        this.D.c2(true);
        this.W.g(3);
        if (d.a.d.e.p.j.x() && videoMiddlePageAdCard.waitConfirm) {
            this.v.startAnimation(this.F);
            this.w.startAnimation(this.F);
            return;
        }
        this.v.setVisibility(0);
        this.w.setVisibility(0);
    }

    public d.a.q0.u0.h1.a getAutoPlayCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.K : (d.a.q0.u0.h1.a) invokeV.objValue;
    }

    public final boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                int intValue = this.G.video.video_width.intValue();
                return intValue <= 0 || ((float) this.G.video.video_height.intValue()) / ((float) intValue) < 1.0f;
            } catch (NumberFormatException unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.n1.o.l.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.D.T0() : invokeV.booleanValue;
    }

    public final void j0() {
        TbPageContext tbPageContext;
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (tbPageContext = this.m) == null || tbPageContext.getPageActivity() == null || (videoMiddlePageAdCard = this.G) == null || videoMiddlePageAdCard.getAdFacadeData() == null || TextUtils.isEmpty(this.G.getScheme())) {
            return;
        }
        String scheme = this.G.getScheme();
        AdvertAppInfo q = this.G.getAdFacadeData().q();
        int f2 = x.o(this.G.getScheme()) ? x.f(this.m.getPageActivity(), scheme) : 0;
        d.a.q0.n1.o.a aVar = this.o;
        if (aVar != null) {
            aVar.a(f2, null);
        }
        d.a.q0.w2.j0.e eVar = this.O;
        if (eVar != null) {
            eVar.a(false);
        }
        if (f2 == 1000) {
            return;
        }
        String m2 = x.m(scheme);
        if (this.D.T0() && q != null && d.a.q0.a.h().u()) {
            x.e(this.m, m2, q.getDownloadId(), q.Y3);
            return;
        }
        AdWebVideoActivity.setStaticInfo(q, this.G.getAdFacadeData().f42483g != null ? this.G.getAdFacadeData().f42483g.e() : 0, "DETAIL");
        Bundle bundle = new Bundle();
        bundle.putString("video_url", this.G.video.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.G.video.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.T);
        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.G.tailFrame.e());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, this.G.getAdFacadeData().q().getDownloadId());
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(this.m.getPageActivity(), "", m2, true, true, true, bundle));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: k0 */
    public void v(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, videoMiddlePageAdCard, i2) == null) {
            this.z.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.A.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.I.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.J.setTextColor(this.m.getResources().getColor(R.color.cp_cont_i_alpha70));
            SkinManager.setBackgroundResource(this.J, R.drawable.btn_rouned_corner_bg_shape);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: l0 */
    public void w(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoMiddlePageAdCard) == null) {
            this.G = videoMiddlePageAdCard;
            u0();
            this.z.setText(videoMiddlePageAdCard.threadTitle);
            this.C.setText(videoMiddlePageAdCard.userName);
            if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith("http")) {
                this.B.M(videoMiddlePageAdCard.userPortrait, 10, false);
            } else {
                this.B.M(videoMiddlePageAdCard.userPortrait, 12, false);
            }
            this.B.setOnLongClickListener(new d(this));
            this.A.setText(videoMiddlePageAdCard.tagName);
            this.I.setText(videoMiddlePageAdCard.operateData.f66578a);
            this.J.setText(videoMiddlePageAdCard.operateData.f66579b);
            this.J.setOnClickListener(new e(this, videoMiddlePageAdCard));
            g0(videoMiddlePageAdCard, this.f18288g, getAutoPlayCallBack());
            z0(videoMiddlePageAdCard);
            v(this.G, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d.a.q0.n2.c cVar = this.D;
            if (cVar != null) {
                cVar.v0();
            }
            this.U = false;
            this.V = true;
        }
    }

    public final void n0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (videoMiddlePageAdCard = this.G) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || this.U) {
            return;
        }
        int e2 = this.G.getAdFacadeData().e();
        d.a.e.d adFacadeData = this.G.getAdFacadeData();
        int i3 = this.T;
        d.a.q0.w2.i0.e.b().d(d.a.q0.w2.i0.g.m(adFacadeData, 34, e2, i2, i3, i3, -1));
        this.U = true;
    }

    public final void o0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) || (videoMiddlePageAdCard = this.G) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        d.a.q0.w2.i0.e.b().d(d.a.q0.w2.i0.g.m(this.G.getAdFacadeData(), 33, this.G.getAdFacadeData().e(), i2, this.T, d.a.q0.q.h.a.a(i3), -1));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view) == null) {
            View view2 = this.v;
            if (view == view2 && view2.getVisibility() == 0) {
                d.a.q0.u0.p2.c cVar = this.R;
                if (cVar != null) {
                    cVar.x0(this.f18288g);
                    return;
                }
                return;
            }
            View view3 = this.w;
            if (view == view3 && view3.getVisibility() == 0) {
                d.a.q0.u0.p2.c cVar2 = this.R;
                if (cVar2 != null) {
                    cVar2.x0(this.f18288g);
                }
            } else if (view != this.y && view != this.x) {
                if (view.getId() != R.id.video_container && view.getId() != R.id.video_agg_container && view.getId() != R.id.float_video_container) {
                    if (this.G.getAdFacadeData() == null || this.G.getAdFacadeData().q() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str = this.G.getAdFacadeData().q().getDownloadId();
                        str2 = this.G.getAdFacadeData().q().Y3;
                    }
                    int e2 = x.e(this.m, this.G.getScheme(), str, str2);
                    d.a.q0.n1.o.a aVar = this.o;
                    if (aVar != null) {
                        aVar.a(e2, null);
                    }
                    d.a.q0.w2.j0.e eVar = this.O;
                    if (eVar != null) {
                        eVar.a(false);
                        return;
                    }
                    return;
                }
                j0();
            } else if (this.v.getVisibility() == 0) {
                d.a.q0.u0.p2.c cVar3 = this.R;
                if (cVar3 != null) {
                    cVar3.x0(this.f18288g);
                }
            } else {
                this.W.g(0);
            }
        }
    }

    @Override // d.a.q0.n1.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m0();
            View view = this.v;
            if (view != null) {
                view.clearAnimation();
            }
            View view2 = this.w;
            if (view2 != null) {
                view2.clearAnimation();
            }
        }
    }

    public final void p0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048590, this, i2, i3) == null) || (videoMiddlePageAdCard = this.G) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        d.a.q0.w2.i0.e.b().d(d.a.q0.w2.i0.g.m(this.G.getAdFacadeData(), 32, this.G.getAdFacadeData().e(), i2, this.T, d.a.q0.q.h.a.a(i3), -1));
    }

    @Override // d.a.q0.n1.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && isPlaying()) {
            this.D.W0();
            p0(!this.L ? 1 : 0, this.D.B0());
            this.V = true;
        }
    }

    public final void r0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i2) == null) || (videoMiddlePageAdCard = this.G) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        d.a.q0.w2.i0.e.b().d(d.a.q0.w2.i0.g.m(this.G.getAdFacadeData(), 36, this.G.getAdFacadeData().e(), i2, this.T, d.a.q0.q.h.a.a(this.D.B0()), -1));
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.r : (View) invokeV.objValue;
    }

    @Override // d.a.q0.n1.o.l.h
    public void setAutoPlayCallBack(d.a.q0.u0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.K = aVar;
        }
    }

    @Override // d.a.q0.n1.o.l.h
    public void setCurrentPlayCallBack(d.a.q0.n1.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            this.S = fVar;
        }
    }

    @Override // d.a.q0.n1.o.l.h
    public void setOnVideoContainerForegroundClickListener(d.a.q0.u0.p2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, cVar) == null) {
            this.R = cVar;
        }
    }

    @Override // d.a.q0.n1.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (d.a.q0.q.h.a.a(this.D.B0()) < this.T && this.D.T0()) {
                p0(!this.L ? 1 : 0, this.D.B0());
            }
            x0();
            this.O.a(false);
        }
    }

    public final void t0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (videoMiddlePageAdCard = this.G) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || !this.V) {
            return;
        }
        d.a.q0.w2.i0.e.b().d(d.a.q0.w2.i0.g.m(this.G.getAdFacadeData(), 31, this.G.getAdFacadeData().e(), i2, this.T, 0, -1));
        this.V = false;
    }

    public final void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            if (!i0()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
                layoutParams.height = (int) (this.H * 0.875f);
                this.t.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            layoutParams2.height = (int) (this.H * 0.5625f);
            this.t.setLayoutParams(layoutParams2);
        }
    }

    public final void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
            CustomMessage customMessage = new CustomMessage(2921317);
            if (z) {
                customMessage.setExtra("high");
            } else {
                customMessage.setExtra(Config.EXCEPTION_MEMORY_LOW);
            }
            customResponsedMessage.setmOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.D.k2();
            TextView textView = this.z;
            if (textView != null) {
                textView.setVisibility(0);
            }
            o oVar = this.W;
            if (oVar != null) {
                oVar.g(2);
            }
            this.U = false;
            this.V = true;
        }
    }

    public final void z0(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, videoMiddlePageAdCard) == null) {
            d.a.q0.w2.j0.e b2 = this.N.b(videoMiddlePageAdCard.tailFrame, this.O);
            this.O = b2;
            if (b2 != null) {
                f0(this.G.getAdFacadeData());
                this.O.j(this.m);
                this.O.l(this);
                this.O.d(videoMiddlePageAdCard.tailFrame);
                this.O.i(this.G);
                this.O.f();
            }
        }
    }
}
