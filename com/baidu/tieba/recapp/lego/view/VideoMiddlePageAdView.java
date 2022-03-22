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
import c.a.p0.c3.c;
import c.a.p0.l3.a0;
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
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements c.a.p0.b2.o.l.h, CountDownTextView.c, View.OnClickListener, c.a.p0.b2.o.l.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Animation A;
    public VideoMiddlePageAdCard B;
    public int C;
    public TextView D;
    public TextView E;
    public c.a.p0.f1.j1.a F;
    public boolean G;
    public ViewGroup H;
    public c.a.p0.l3.n0.f I;
    public c.a.p0.l3.n0.g J;
    public VideoNetworkStateTipView K;
    public int L;
    public c.a.p0.f1.t2.c M;
    public c.a.p0.b2.o.l.f N;
    public int O;
    public boolean P;
    public boolean Q;
    public o R;
    public Animation.AnimationListener S;
    public Animation.AnimationListener T;
    public View m;
    public View n;
    public FrameLayout o;
    public FrameLayout p;
    public View q;
    public View r;
    public View s;
    public View t;
    public TextView u;
    public TextView v;
    public HeadImageView w;
    public TextView x;
    public c.a.p0.c3.c y;
    public Animation z;

    /* loaded from: classes5.dex */
    public class a implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.f1.j1.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f35730b;

        public a(VideoMiddlePageAdView videoMiddlePageAdView, c.a.p0.f1.j1.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35730b = videoMiddlePageAdView;
            this.a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                c.a.p0.f1.j1.a aVar = this.a;
                if (aVar != null) {
                    aVar.cancel();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f35730b;
                videoMiddlePageAdView.j0(!videoMiddlePageAdView.G ? 1 : 0);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public b(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // c.a.p0.c3.c.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.h0(1, videoMiddlePageAdView.y.B0());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public c(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // c.a.p0.c3.c.x
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.i0(1, videoMiddlePageAdView.y.B0());
                this.a.Q = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public d(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.o0.s.c.c adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.e() || this.a.B == null) {
                    return false;
                }
                c.a.d.f.p.c.a(this.a.B.adCollect());
                ((Vibrator) this.a.i.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdCard a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f35731b;

        public e(VideoMiddlePageAdView videoMiddlePageAdView, VideoMiddlePageAdCard videoMiddlePageAdCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView, videoMiddlePageAdCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35731b = videoMiddlePageAdView;
            this.a = videoMiddlePageAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f35731b.B == null || this.f35731b.B.getAdFacadeData() == null || this.f35731b.B.getAdFacadeData().s() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    AdvertAppInfo s = this.f35731b.B.getAdFacadeData().s();
                    str2 = s.getDownloadId();
                    str3 = s.f29821h;
                    str = s.t;
                }
                int e2 = a0.e(this.f35731b.i, this.a.getButtonScheme(), str2, str3, str);
                if (this.f35731b.J != null) {
                    this.f35731b.J.a(false);
                }
                if (this.f35731b.k != null) {
                    this.f35731b.k.a(e2, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public f(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            c.a.p0.c3.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.a.y) == null || cVar.I0() == null) {
                return;
            }
            VideoMiddlePageAdView videoMiddlePageAdView = this.a;
            videoMiddlePageAdView.O = (int) TimeUnit.MILLISECONDS.toSeconds(videoMiddlePageAdView.y.I0().getDuration());
        }
    }

    /* loaded from: classes5.dex */
    public class g implements c.r {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public g(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // c.a.p0.c3.c.r
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.R == null) {
                return;
            }
            if (z) {
                this.a.R.g(0);
            } else {
                this.a.R.g(1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public h(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.K.setHasAgreeToPlay(true);
                this.a.y.m1(false);
                this.a.K.g();
                if (this.a.B == null || this.a.B.video == null) {
                    return;
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.y.c2(videoMiddlePageAdView.B.video.video_url, "");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public i(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.a.q != null) {
                    this.a.q.setVisibility(8);
                }
                if (this.a.r != null) {
                    this.a.r.setVisibility(8);
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
                if (this.a.q != null) {
                    this.a.q.setVisibility(0);
                }
                if (this.a.r != null) {
                    this.a.r.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public j(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.a.q != null) {
                    this.a.q.setVisibility(0);
                }
                if (this.a.r != null) {
                    this.a.r.setVisibility(0);
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
                if (this.a.q != null) {
                    this.a.q.setVisibility(8);
                }
                if (this.a.r != null) {
                    this.a.r.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements c.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public k(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // c.a.p0.c3.c.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.p0.c3.c.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements c.c0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public l(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // c.a.p0.c3.c.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.p0.c3.c.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.B != null && this.a.B.video != null && this.a.B.video.video_height.intValue() > this.a.B.video.video_width.intValue()) {
                    this.a.y.L1(false, true);
                } else {
                    this.a.y.L1(false, true);
                }
                if (this.a.N != null) {
                    this.a.N.h(this.a);
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.k0(1 ^ (videoMiddlePageAdView.G ? 1 : 0));
                this.a.P = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements c.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public m(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // c.a.p0.c3.c.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.y.c2(videoMiddlePageAdView.B.video.video_url, "");
                if (this.a.N != null) {
                    this.a.N.h(this.a);
                }
                this.a.k0(1);
                this.a.P = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdView a;

        public n(VideoMiddlePageAdView videoMiddlePageAdView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y.Z0();
                if (this.a.J != null) {
                    this.a.J.e();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.g0(!videoMiddlePageAdView.G ? 1 : 0);
                this.a.Q = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f35732b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f35733c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f35734d;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ o a;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f35732b.removeCallbacks(this.a.f35733c);
                    this.a.g(2);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35734d = videoMiddlePageAdView;
            this.a = -1;
            this.f35733c = new a(this);
            this.f35732b = new Handler();
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35732b.removeCallbacks(this.f35733c);
                this.f35732b.postDelayed(this.f35733c, 3000L);
            }
        }

        public final int d(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                int i2 = this.a;
                if (i == i2) {
                    return i2;
                }
                this.f35734d.t.setVisibility(8);
                this.f35734d.s.setVisibility(8);
                this.f35734d.m0(true);
                return i;
            }
            return invokeI.intValue;
        }

        public final int e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                int i2 = this.a;
                if (i == i2) {
                    return i2;
                }
                this.f35734d.t.setVisibility(0);
                this.f35734d.s.setVisibility(0);
                this.f35734d.m0(true);
                return i;
            }
            return invokeI.intValue;
        }

        public final int f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int i2 = this.a;
                if (i == i2) {
                    return i2;
                }
                this.f35734d.t.setVisibility(0);
                this.f35734d.s.setVisibility(0);
                c.a.p0.c3.c cVar = this.f35734d.y;
                if (cVar != null) {
                    cVar.O0();
                }
                if (i2 != 3 || this.f35734d.B.autoPlay) {
                    this.f35734d.m0(false);
                    return i;
                }
                return i;
            }
            return invokeI.intValue;
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (i == 0) {
                    this.a = d(i);
                    c();
                } else if (i == 1) {
                    this.a = d(i);
                    this.f35732b.removeCallbacks(this.f35733c);
                } else if (i == 2) {
                    this.a = f(i);
                } else if (i != 3) {
                    this.a = f(i);
                } else {
                    this.a = e(i);
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
        this.P = false;
        this.Q = true;
        this.S = new i(this);
        this.T = new j(this);
        this.P = false;
        this.Q = true;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0559, (ViewGroup) null);
        this.m = inflate;
        this.o = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f09230e);
        this.n = this.m.findViewById(R.id.obfuscated_res_0x7f0904f0);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f09231b);
        this.p = frameLayout;
        c.a.p0.c3.c cVar = new c.a.p0.c3.c(this.i, frameLayout, false);
        this.y = cVar;
        cVar.N1("23");
        this.y.J1(new f(this));
        this.y.o1(new g(this));
        this.y.f13458e.setOnTouchListener(null);
        this.u = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09202b);
        HeadImageView headImageView = (HeadImageView) this.m.findViewById(R.id.obfuscated_res_0x7f0922a8);
        this.w = headImageView;
        headImageView.setIsRound(true);
        this.w.setDefaultBgResource(R.color.CAM_X0205);
        this.w.setDefaultResource(R.drawable.icon_default_avatar100);
        this.v = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900eb);
        this.x = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0922bb);
        this.D = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900d9);
        this.E = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900d8);
        this.H = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f091ed3);
        c.a.p0.l3.n0.f fVar = new c.a.p0.l3.n0.f(this.i.getPageActivity(), this.H);
        this.I = fVar;
        fVar.a = 1;
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) this.m.findViewById(R.id.obfuscated_res_0x7f091540);
        this.K = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new h(this));
        this.q = this.m.findViewById(R.id.obfuscated_res_0x7f09230f);
        this.s = this.m.findViewById(R.id.obfuscated_res_0x7f09229c);
        this.t = this.m.findViewById(R.id.obfuscated_res_0x7f092041);
        this.r = this.m.findViewById(R.id.obfuscated_res_0x7f09160c);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.y.G1(this);
        this.u.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.C = c.a.d.f.p.n.k(this.i.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
        layoutParams.height = (int) (this.C * 0.5625f);
        this.o.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.z = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.z.setAnimationListener(this.T);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.A = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.A.setAnimationListener(this.S);
        this.m.setOnClickListener(this);
        this.R = new o(this);
    }

    public final void Z(c.a.e.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || dVar == null) {
            return;
        }
        int i2 = !this.G ? 1 : 0;
        c.a.p0.l3.m0.c m2 = c.a.p0.l3.m0.g.m(this.B.getAdFacadeData(), 303, this.B.getAdFacadeData().i(), i2, this.B.video.video_duration.intValue(), 0, -1);
        c.a.p0.l3.n0.g gVar = this.J;
        if (gVar != null) {
            gVar.l(m2);
        }
    }

    public final void a0(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2, c.a.p0.f1.j1.a aVar) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoMiddlePageAdCard, i2, aVar) == null) || videoMiddlePageAdCard == null || (videoInfo = videoMiddlePageAdCard.video) == null) {
            return;
        }
        this.L = i2;
        this.G = this.B.autoPlay;
        this.P = false;
        Integer num = videoInfo.video_duration;
        if (num != null && num.intValue() > 0) {
            this.O = videoMiddlePageAdCard.video.video_duration.intValue();
        }
        if (this.y.T0()) {
            i0(!videoMiddlePageAdCard.autoPlay ? 1 : 0, this.y.B0());
            this.Q = true;
        }
        this.y.j2();
        this.y.r1(true);
        this.y.u1(false);
        this.y.s1(true);
        this.y.L1(false, true);
        this.y.K1(i2);
        this.y.x1(new k(this));
        this.y.F1(new l(this));
        this.y.z1(new m(this));
        this.y.n1(false);
        this.y.q0();
        this.y.H1(new n(this));
        this.y.I1(new a(this, aVar));
        this.y.R1(videoMiddlePageAdCard.video.thumbnail_url);
        this.y.X1(videoMiddlePageAdCard.video.video_url, "");
        this.y.C1(new b(this));
        this.y.A1(new c(this));
        this.y.Z0();
        this.y.Z1();
        if (videoMiddlePageAdCard.autoPlay) {
            if (this.K.d()) {
                this.y.b2(false);
                this.K.f();
                this.y.m1(true);
            } else {
                this.y.m1(false);
                this.y.b2(false);
                this.K.b();
                this.y.h2(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
            }
            c.a.p0.l3.n0.g gVar = this.J;
            if (gVar != null) {
                gVar.a(true);
            }
            if (i2 == 0) {
                this.q.setVisibility(8);
                this.r.setVisibility(8);
            } else {
                this.q.startAnimation(this.A);
                this.r.startAnimation(this.A);
            }
            if (i2 == 0) {
                this.R.g(3);
                return;
            } else {
                this.R.g(0);
                return;
            }
        }
        this.K.b();
        this.y.b2(true);
        this.R.g(3);
        if (c.a.d.f.p.l.x() && videoMiddlePageAdCard.waitConfirm) {
            this.q.startAnimation(this.A);
            this.r.startAnimation(this.A);
            return;
        }
        this.q.setVisibility(0);
        this.r.setVisibility(0);
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                int intValue = this.B.video.video_width.intValue();
                return intValue <= 0 || ((float) this.B.video.video_height.intValue()) / ((float) intValue) < 1.0f;
            } catch (NumberFormatException unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void c0() {
        TbPageContext tbPageContext;
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.i) == null || tbPageContext.getPageActivity() == null || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.getAdFacadeData() == null || TextUtils.isEmpty(this.B.getScheme())) {
            return;
        }
        String scheme = this.B.getScheme();
        AdvertAppInfo s = this.B.getAdFacadeData().s();
        int f2 = a0.p(this.B.getScheme()) ? a0.f(this.i.getPageActivity(), scheme) : 0;
        c.a.p0.b2.o.a aVar = this.k;
        if (aVar != null) {
            aVar.a(f2, null);
        }
        c.a.p0.l3.n0.g gVar = this.J;
        if (gVar != null) {
            gVar.a(false);
        }
        if (f2 == 1000) {
            return;
        }
        String n2 = a0.n(scheme);
        if (this.y.T0() && s != null && c.a.p0.a.h().z()) {
            a0.e(this.i, n2, s.getDownloadId(), s.f29821h, s.t);
            return;
        }
        AdWebVideoActivity.setStaticInfo(s, this.B.getAdFacadeData().f2669c != null ? this.B.getAdFacadeData().f2669c.e() : 0, "DETAIL");
        Bundle bundle = new Bundle();
        bundle.putString("video_url", this.B.video.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.B.video.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.O);
        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.B.tailFrame.e());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, this.B.getAdFacadeData().s().getDownloadId());
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(this.i.getPageActivity(), "", n2, true, true, true, bundle));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: d0 */
    public void t(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, videoMiddlePageAdCard, i2) == null) {
            this.u.setTextColor(this.i.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.v.setTextColor(this.i.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.D.setTextColor(this.i.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.E.setTextColor(this.i.getResources().getColor(R.color.cp_cont_i_alpha70));
            SkinManager.setBackgroundResource(this.E, R.drawable.btn_rouned_corner_bg_shape);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: e0 */
    public void u(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoMiddlePageAdCard) == null) {
            this.B = videoMiddlePageAdCard;
            l0();
            this.u.setText(videoMiddlePageAdCard.threadTitle);
            this.x.setText(videoMiddlePageAdCard.userName);
            if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith("http")) {
                this.w.J(videoMiddlePageAdCard.userPortrait, 10, false);
            } else {
                this.w.J(videoMiddlePageAdCard.userPortrait, 12, false);
            }
            this.w.setOnLongClickListener(new d(this));
            this.v.setText(videoMiddlePageAdCard.tagName);
            this.D.setText(videoMiddlePageAdCard.operateData.a);
            this.E.setText(videoMiddlePageAdCard.operateData.f16223b);
            this.E.setOnClickListener(new e(this, videoMiddlePageAdCard));
            a0(videoMiddlePageAdCard, this.f34241c, getAutoPlayCallBack());
            o0(videoMiddlePageAdCard);
            t(this.B, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.p0.c3.c cVar = this.y;
            if (cVar != null) {
                cVar.v0();
            }
            this.P = false;
            this.Q = true;
        }
    }

    public final void g0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || this.P) {
            return;
        }
        int i3 = this.B.getAdFacadeData().i();
        c.a.e.d adFacadeData = this.B.getAdFacadeData();
        int i4 = this.O;
        c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.m(adFacadeData, 34, i3, i2, i4, i4, -1));
        this.P = true;
    }

    public c.a.p0.f1.j1.a getAutoPlayCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.F : (c.a.p0.f1.j1.a) invokeV.objValue;
    }

    public final void h0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.m(this.B.getAdFacadeData(), 33, this.B.getAdFacadeData().i(), i2, this.O, c.a.p0.x.k.a.a(i3), -1));
    }

    public final void i0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.m(this.B.getAdFacadeData(), 32, this.B.getAdFacadeData().i(), i2, this.O, c.a.p0.x.k.a.a(i3), -1));
    }

    @Override // c.a.p0.b2.o.l.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.y.T0() : invokeV.booleanValue;
    }

    public final void j0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.m(this.B.getAdFacadeData(), 36, this.B.getAdFacadeData().i(), i2, this.O, c.a.p0.x.k.a.a(this.y.B0()), -1));
    }

    public final void k0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || !this.Q) {
            return;
        }
        c.a.p0.l3.m0.e.b().d(c.a.p0.l3.m0.g.m(this.B.getAdFacadeData(), 31, this.B.getAdFacadeData().i(), i2, this.O, 0, -1));
        this.Q = false;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (!b0()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                layoutParams.height = (int) (this.C * 0.875f);
                this.o.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams2.height = (int) (this.C * 0.5625f);
            this.o.setLayoutParams(layoutParams2);
        }
    }

    public final void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
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

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.y.j2();
            TextView textView = this.u;
            if (textView != null) {
                textView.setVisibility(0);
            }
            o oVar = this.R;
            if (oVar != null) {
                oVar.g(2);
            }
            this.P = false;
            this.Q = true;
        }
    }

    public final void o0(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, videoMiddlePageAdCard) == null) {
            c.a.p0.l3.n0.g b2 = this.I.b(videoMiddlePageAdCard.tailFrame, this.J);
            this.J = b2;
            if (b2 != null) {
                Z(this.B.getAdFacadeData());
                this.J.j(this.i);
                this.J.m(this);
                this.J.d(videoMiddlePageAdCard.tailFrame);
                this.J.i(this.B);
                this.J.f();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            View view2 = this.q;
            if (view == view2 && view2.getVisibility() == 0) {
                c.a.p0.f1.t2.c cVar = this.M;
                if (cVar != null) {
                    cVar.p0(this.f34241c);
                    return;
                }
                return;
            }
            View view3 = this.r;
            if (view == view3 && view3.getVisibility() == 0) {
                c.a.p0.f1.t2.c cVar2 = this.M;
                if (cVar2 != null) {
                    cVar2.p0(this.f34241c);
                }
            } else if (view != this.t && view != this.s) {
                if (view.getId() != R.id.obfuscated_res_0x7f09231b && view.getId() != R.id.obfuscated_res_0x7f09230e && view.getId() != R.id.obfuscated_res_0x7f0909d3) {
                    if (this.B.getAdFacadeData() == null || this.B.getAdFacadeData().s() == null) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        str = this.B.getAdFacadeData().s().getDownloadId();
                        str2 = this.B.getAdFacadeData().s().f29821h;
                        str3 = this.B.getAdFacadeData().s().t;
                    }
                    int e2 = a0.e(this.i, this.B.getScheme(), str, str2, str3);
                    c.a.p0.b2.o.a aVar = this.k;
                    if (aVar != null) {
                        aVar.a(e2, null);
                    }
                    c.a.p0.l3.n0.g gVar = this.J;
                    if (gVar != null) {
                        gVar.a(false);
                        return;
                    }
                    return;
                }
                c0();
            } else if (this.q.getVisibility() == 0) {
                c.a.p0.f1.t2.c cVar3 = this.M;
                if (cVar3 != null) {
                    cVar3.p0(this.f34241c);
                }
            } else {
                this.R.g(0);
            }
        }
    }

    @Override // c.a.p0.b2.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            f0();
            View view = this.q;
            if (view != null) {
                view.clearAnimation();
            }
            View view2 = this.r;
            if (view2 != null) {
                view2.clearAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
    public void onTimeout(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, view) == null) {
            this.F.a(this.L);
        }
    }

    @Override // c.a.p0.b2.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && isPlaying()) {
            this.y.V0();
            i0(!this.G ? 1 : 0, this.y.B0());
            this.Q = true;
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    @Override // c.a.p0.b2.o.l.h
    public void setAutoPlayCallBack(c.a.p0.f1.j1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) {
            this.F = aVar;
        }
    }

    @Override // c.a.p0.b2.o.l.h
    public void setCurrentPlayCallBack(c.a.p0.b2.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, fVar) == null) {
            this.N = fVar;
        }
    }

    @Override // c.a.p0.b2.o.l.h
    public void setOnVideoContainerForegroundClickListener(c.a.p0.f1.t2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) {
            this.M = cVar;
        }
    }

    @Override // c.a.p0.b2.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (c.a.p0.x.k.a.a(this.y.B0()) < this.O && this.y.T0()) {
                i0(!this.G ? 1 : 0, this.y.B0());
            }
            n0();
            this.J.a(false);
        }
    }
}
