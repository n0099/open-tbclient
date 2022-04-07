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
import com.repackage.bk5;
import com.repackage.dd8;
import com.repackage.di;
import com.repackage.ed8;
import com.repackage.ga8;
import com.repackage.hg6;
import com.repackage.hr6;
import com.repackage.iw4;
import com.repackage.mi;
import com.repackage.n68;
import com.repackage.oi;
import com.repackage.op;
import com.repackage.qd7;
import com.repackage.rg5;
import com.repackage.sc7;
import com.repackage.sc8;
import com.repackage.uc8;
import com.repackage.wc8;
import java.util.concurrent.TimeUnit;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements Object, CountDownTextView.c, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Animation A;
    public VideoMiddlePageAdCard B;
    public int C;
    public TextView D;
    public TextView E;
    public hg6 F;
    public boolean G;
    public ViewGroup H;
    public dd8 I;
    public ed8 J;
    public VideoNetworkStateTipView K;
    public int L;
    public hr6 M;
    public qd7 N;
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
    public n68 y;
    public Animation z;

    /* loaded from: classes3.dex */
    public class a implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg6 a;
        public final /* synthetic */ VideoMiddlePageAdView b;

        public a(VideoMiddlePageAdView videoMiddlePageAdView, hg6 hg6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoMiddlePageAdView, hg6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoMiddlePageAdView;
            this.a = hg6Var;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, obj)) == null) {
                hg6 hg6Var = this.a;
                if (hg6Var != null) {
                    hg6Var.cancel();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.b;
                videoMiddlePageAdView.j0(!videoMiddlePageAdView.G ? 1 : 0);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements n68.z {
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

        @Override // com.repackage.n68.z
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.h0(1, videoMiddlePageAdView.y.B0());
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements n68.x {
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

        @Override // com.repackage.n68.x
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.i0(1, videoMiddlePageAdView.y.B0());
                this.a.Q = true;
            }
        }
    }

    /* loaded from: classes3.dex */
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
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                iw4 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.e() || this.a.B == null) {
                    return false;
                }
                di.a(this.a.B.adCollect());
                ((Vibrator) this.a.i.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoMiddlePageAdCard a;
        public final /* synthetic */ VideoMiddlePageAdView b;

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
            this.b = videoMiddlePageAdView;
            this.a = videoMiddlePageAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.B == null || this.b.B.getAdFacadeData() == null || this.b.B.getAdFacadeData().k() == null) {
                    str = null;
                    str2 = null;
                    str3 = null;
                } else {
                    AdvertAppInfo k = this.b.B.getAdFacadeData().k();
                    str2 = k.getDownloadId();
                    str3 = k.h;
                    str = k.t;
                }
                int e = ga8.e(this.b.i, this.a.getButtonScheme(), str2, str3, str);
                if (this.b.J != null) {
                    this.b.J.a(false);
                }
                if (this.b.k != null) {
                    this.b.k.a(e, null);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
            n68 n68Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (n68Var = this.a.y) == null || n68Var.H0() == null) {
                return;
            }
            VideoMiddlePageAdView videoMiddlePageAdView = this.a;
            videoMiddlePageAdView.O = (int) TimeUnit.MILLISECONDS.toSeconds(videoMiddlePageAdView.y.H0().getDuration());
        }
    }

    /* loaded from: classes3.dex */
    public class g implements n68.r {
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

        @Override // com.repackage.n68.r
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

    /* loaded from: classes3.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.K.setHasAgreeToPlay(true);
                this.a.y.i1(false);
                this.a.K.g();
                if (this.a.B == null || this.a.B.video == null) {
                    return;
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.y.R1(videoMiddlePageAdView.B.video.video_url, "");
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class k implements n68.t {
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

        @Override // com.repackage.n68.t
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.n68.t
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements n68.c0 {
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

        @Override // com.repackage.n68.c0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.repackage.n68.c0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.B != null && this.a.B.video != null && this.a.B.video.video_height.intValue() > this.a.B.video.video_width.intValue()) {
                    this.a.y.C1(false, true);
                } else {
                    this.a.y.C1(false, true);
                }
                if (this.a.N != null) {
                    this.a.N.a(this.a);
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.k0(1 ^ (videoMiddlePageAdView.G ? 1 : 0));
                this.a.P = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements n68.w {
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

        @Override // com.repackage.n68.w
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.y.R1(videoMiddlePageAdView.B.video.video_url, "");
                if (this.a.N != null) {
                    this.a.N.a(this.a);
                }
                this.a.k0(1);
                this.a.P = false;
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.y.X0();
                if (this.a.J != null) {
                    this.a.J.e();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.a;
                videoMiddlePageAdView.g0(!videoMiddlePageAdView.G ? 1 : 0);
                this.a.Q = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public Handler b;
        public Runnable c;
        public final /* synthetic */ VideoMiddlePageAdView d;

        /* loaded from: classes3.dex */
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
                    this.a.b.removeCallbacks(this.a.c);
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
            this.d = videoMiddlePageAdView;
            this.a = -1;
            this.c = new a(this);
            this.b = new Handler();
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.removeCallbacks(this.c);
                this.b.postDelayed(this.c, 3000L);
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
                this.d.t.setVisibility(8);
                this.d.s.setVisibility(8);
                this.d.m0(true);
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
                this.d.t.setVisibility(0);
                this.d.s.setVisibility(0);
                this.d.m0(true);
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
                this.d.t.setVisibility(0);
                this.d.s.setVisibility(0);
                n68 n68Var = this.d.y;
                if (n68Var != null) {
                    n68Var.N0();
                }
                if (i2 != 3 || this.d.B.autoPlay) {
                    this.d.m0(false);
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
                    this.b.removeCallbacks(this.c);
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0554, (ViewGroup) null);
        this.m = inflate;
        this.o = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0922ef);
        this.n = this.m.findViewById(R.id.obfuscated_res_0x7f0904f8);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f0922fc);
        this.p = frameLayout;
        n68 n68Var = new n68(this.i, frameLayout, false);
        this.y = n68Var;
        n68Var.E1("23");
        this.y.B1(new f(this));
        this.y.k1(new g(this));
        this.y.e.setOnTouchListener(null);
        this.u = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f092012);
        HeadImageView headImageView = (HeadImageView) this.m.findViewById(R.id.obfuscated_res_0x7f09228c);
        this.w = headImageView;
        headImageView.setIsRound(true);
        this.w.setDefaultBgResource(R.color.CAM_X0205);
        this.w.setDefaultResource(R.drawable.icon_default_avatar100);
        this.v = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900f0);
        this.x = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f09229c);
        this.D = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900dd);
        this.E = (TextView) this.m.findViewById(R.id.obfuscated_res_0x7f0900dc);
        this.H = (FrameLayout) this.m.findViewById(R.id.obfuscated_res_0x7f091ebf);
        dd8 dd8Var = new dd8(this.i.getPageActivity(), this.H);
        this.I = dd8Var;
        dd8Var.a = 1;
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) this.m.findViewById(R.id.obfuscated_res_0x7f09153b);
        this.K = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new h(this));
        this.q = this.m.findViewById(R.id.obfuscated_res_0x7f0922f0);
        this.s = this.m.findViewById(R.id.obfuscated_res_0x7f092280);
        this.t = this.m.findViewById(R.id.obfuscated_res_0x7f092026);
        this.r = this.m.findViewById(R.id.obfuscated_res_0x7f091606);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.y.y1(this);
        this.u.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x.setOnClickListener(this);
        this.C = oi.k(this.i.getPageActivity());
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

    public final void a0(op opVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, opVar) == null) || opVar == null) {
            return;
        }
        int i2 = !this.G ? 1 : 0;
        sc8 m2 = wc8.m(this.B.getAdFacadeData(), 303, this.B.getAdFacadeData().g(), i2, this.B.video.video_duration.intValue(), 0, -1);
        ed8 ed8Var = this.J;
        if (ed8Var != null) {
            ed8Var.l(m2);
        }
    }

    public final void b0(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2, hg6 hg6Var) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoMiddlePageAdCard, i2, hg6Var) == null) || videoMiddlePageAdCard == null || (videoInfo = videoMiddlePageAdCard.video) == null) {
            return;
        }
        this.L = i2;
        this.G = this.B.autoPlay;
        this.P = false;
        Integer num = videoInfo.video_duration;
        if (num != null && num.intValue() > 0) {
            this.O = videoMiddlePageAdCard.video.video_duration.intValue();
        }
        if (this.y.R0()) {
            i0(!videoMiddlePageAdCard.autoPlay ? 1 : 0, this.y.B0());
            this.Q = true;
        }
        this.y.Y1();
        this.y.l1(true);
        this.y.m1(true);
        this.y.C1(false, true);
        this.y.p1(new k(this));
        this.y.x1(new l(this));
        this.y.r1(new m(this));
        this.y.j1(false);
        this.y.q0();
        this.y.z1(new n(this));
        this.y.A1(new a(this, hg6Var));
        this.y.I1(videoMiddlePageAdCard.video.thumbnail_url);
        this.y.M1(videoMiddlePageAdCard.video.video_url, "");
        this.y.u1(new b(this));
        this.y.s1(new c(this));
        this.y.X0();
        this.y.O1();
        if (videoMiddlePageAdCard.autoPlay) {
            if (this.K.d()) {
                this.y.Q1(false);
                this.K.f();
                this.y.i1(true);
            } else {
                this.y.i1(false);
                this.y.Q1(false);
                this.K.b();
                this.y.W1(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
            }
            ed8 ed8Var = this.J;
            if (ed8Var != null) {
                ed8Var.a(true);
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
        this.y.Q1(true);
        this.R.g(3);
        if (mi.x() && videoMiddlePageAdCard.waitConfirm) {
            this.q.startAnimation(this.A);
            this.r.startAnimation(this.A);
            return;
        }
        this.q.setVisibility(0);
        this.r.setVisibility(0);
    }

    public final boolean c0() {
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

    public final void d0() {
        TbPageContext tbPageContext;
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (tbPageContext = this.i) == null || tbPageContext.getPageActivity() == null || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.getAdFacadeData() == null || TextUtils.isEmpty(this.B.getScheme())) {
            return;
        }
        String scheme = this.B.getScheme();
        AdvertAppInfo k2 = this.B.getAdFacadeData().k();
        int f2 = ga8.p(this.B.getScheme()) ? ga8.f(this.i.getPageActivity(), scheme) : 0;
        sc7 sc7Var = this.k;
        if (sc7Var != null) {
            sc7Var.a(f2, null);
        }
        ed8 ed8Var = this.J;
        if (ed8Var != null) {
            ed8Var.a(false);
        }
        if (f2 == 1000) {
            return;
        }
        String n2 = ga8.n(scheme);
        if (this.y.R0() && k2 != null && rg5.h().z()) {
            ga8.e(this.i, n2, k2.getDownloadId(), k2.h, k2.t);
            return;
        }
        AdWebVideoActivity.setStaticInfo(k2, this.B.getAdFacadeData().c != null ? this.B.getAdFacadeData().c.d() : 0, "DETAIL");
        Bundle bundle = new Bundle();
        bundle.putString("video_url", this.B.video.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.B.video.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.O);
        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.B.tailFrame.e());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, this.B.getAdFacadeData().k().getDownloadId());
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(this.i.getPageActivity(), "", n2, true, true, true, bundle));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: e0 */
    public void u(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2) {
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
    /* renamed from: f0 */
    public void v(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, videoMiddlePageAdCard) == null) {
            this.B = videoMiddlePageAdCard;
            l0();
            this.u.setText(videoMiddlePageAdCard.threadTitle);
            this.x.setText(videoMiddlePageAdCard.userName);
            if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith("http")) {
                this.w.K(videoMiddlePageAdCard.userPortrait, 10, false);
            } else {
                this.w.K(videoMiddlePageAdCard.userPortrait, 12, false);
            }
            this.w.setOnLongClickListener(new d(this));
            this.v.setText(videoMiddlePageAdCard.tagName);
            this.D.setText(videoMiddlePageAdCard.operateData.a);
            this.E.setText(videoMiddlePageAdCard.operateData.b);
            this.E.setOnClickListener(new e(this, videoMiddlePageAdCard));
            b0(videoMiddlePageAdCard, this.c, getAutoPlayCallBack());
            n0(videoMiddlePageAdCard);
            u(this.B, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void g0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || this.P) {
            return;
        }
        int g2 = this.B.getAdFacadeData().g();
        op adFacadeData = this.B.getAdFacadeData();
        int i3 = this.O;
        uc8.b().d(wc8.m(adFacadeData, 34, g2, i2, i3, i3, -1));
        this.P = true;
    }

    public hg6 getAutoPlayCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.F : (hg6) invokeV.objValue;
    }

    public final void h0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        uc8.b().d(wc8.m(this.B.getAdFacadeData(), 33, this.B.getAdFacadeData().g(), i2, this.O, bk5.a(i3), -1));
    }

    public final void i0(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        uc8.b().d(wc8.m(this.B.getAdFacadeData(), 32, this.B.getAdFacadeData().g(), i2, this.O, bk5.a(i3), -1));
    }

    public final void j0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        uc8.b().d(wc8.m(this.B.getAdFacadeData(), 36, this.B.getAdFacadeData().g(), i2, this.O, bk5.a(this.y.B0()), -1));
    }

    public final void k0(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (videoMiddlePageAdCard = this.B) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || !this.Q) {
            return;
        }
        uc8.b().d(wc8.m(this.B.getAdFacadeData(), 31, this.B.getAdFacadeData().g(), i2, this.O, 0, -1));
        this.Q = false;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (!c0()) {
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
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
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

    public final void n0(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, videoMiddlePageAdCard) == null) {
            ed8 b2 = this.I.b(videoMiddlePageAdCard.tailFrame, this.J);
            this.J = b2;
            if (b2 != null) {
                a0(this.B.getAdFacadeData());
                this.J.j(this.i);
                this.J.m(this);
                this.J.d(videoMiddlePageAdCard.tailFrame);
                this.J.i(this.B);
                this.J.f();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            View view3 = this.q;
            if (view2 == view3 && view3.getVisibility() == 0) {
                hr6 hr6Var = this.M;
                if (hr6Var != null) {
                    hr6Var.a(this.c);
                    return;
                }
                return;
            }
            View view4 = this.r;
            if (view2 == view4 && view4.getVisibility() == 0) {
                hr6 hr6Var2 = this.M;
                if (hr6Var2 != null) {
                    hr6Var2.a(this.c);
                }
            } else if (view2 != this.t && view2 != this.s) {
                if (view2.getId() != R.id.obfuscated_res_0x7f0922fc && view2.getId() != R.id.obfuscated_res_0x7f0922ef && view2.getId() != R.id.obfuscated_res_0x7f0909da) {
                    if (this.B.getAdFacadeData() == null || this.B.getAdFacadeData().k() == null) {
                        str = null;
                        str2 = null;
                        str3 = null;
                    } else {
                        str = this.B.getAdFacadeData().k().getDownloadId();
                        str2 = this.B.getAdFacadeData().k().h;
                        str3 = this.B.getAdFacadeData().k().t;
                    }
                    int e2 = ga8.e(this.i, this.B.getScheme(), str, str2, str3);
                    sc7 sc7Var = this.k;
                    if (sc7Var != null) {
                        sc7Var.a(e2, null);
                    }
                    ed8 ed8Var = this.J;
                    if (ed8Var != null) {
                        ed8Var.a(false);
                        return;
                    }
                    return;
                }
                d0();
            } else if (this.q.getVisibility() == 0) {
                hr6 hr6Var3 = this.M;
                if (hr6Var3 != null) {
                    hr6Var3.a(this.c);
                }
            } else {
                this.R.g(0);
            }
        }
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
    public void onTimeout(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view2) == null) {
            this.F.a(this.L);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    public void setAutoPlayCallBack(hg6 hg6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, hg6Var) == null) {
            this.F = hg6Var;
        }
    }

    public void setCurrentPlayCallBack(qd7 qd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, qd7Var) == null) {
            this.N = qd7Var;
        }
    }

    public void setOnVideoContainerForegroundClickListener(hr6 hr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, hr6Var) == null) {
            this.M = hr6Var;
        }
    }
}
