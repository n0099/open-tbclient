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
import b.a.r0.q2.c;
import b.a.r0.z2.z;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
/* loaded from: classes9.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements b.a.r0.q1.o.l.h, CountDownTextView.c, View.OnClickListener, b.a.r0.q1.o.l.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public o D;
    public Animation.AnimationListener E;
    public Animation.AnimationListener F;

    /* renamed from: f  reason: collision with root package name */
    public View f53555f;

    /* renamed from: g  reason: collision with root package name */
    public View f53556g;

    /* renamed from: h  reason: collision with root package name */
    public View f53557h;

    /* renamed from: i  reason: collision with root package name */
    public View f53558i;
    public View j;
    public View k;
    public Animation l;
    public Animation m;
    public b.a.r0.q2.c mFloatVideoContainer;
    public TextView mTagName;
    public HeadImageView mUserIcon;
    public TextView mUsername;
    public FrameLayout mVideoAggContainer;
    public FrameLayout mVideoContainer;
    public TextView mVideoTitle;
    public VideoMiddlePageAdCard n;
    public int o;
    public TextView p;
    public TextView q;
    public b.a.r0.x0.r1.a r;
    public boolean s;
    public ViewGroup t;
    public b.a.r0.z2.m0.f u;
    public b.a.r0.z2.m0.g v;
    public VideoNetworkStateTipView w;
    public int x;
    public b.a.r0.x0.z2.c y;
    public b.a.r0.q1.o.l.f z;

    /* loaded from: classes9.dex */
    public class a implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.x0.r1.a f53559e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53560f;

        public a(VideoMiddlePageAdView videoMiddlePageAdView, b.a.r0.x0.r1.a aVar) {
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
            this.f53560f = videoMiddlePageAdView;
            this.f53559e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                b.a.r0.x0.r1.a aVar = this.f53559e;
                if (aVar != null) {
                    aVar.cancel();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f53560f;
                videoMiddlePageAdView.M(!videoMiddlePageAdView.s ? 1 : 0);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements c.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53561a;

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
            this.f53561a = videoMiddlePageAdView;
        }

        @Override // b.a.r0.q2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f53561a;
                videoMiddlePageAdView.J(1, videoMiddlePageAdView.mFloatVideoContainer.B0());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements c.b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53562a;

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
            this.f53562a = videoMiddlePageAdView;
        }

        @Override // b.a.r0.q2.c.b0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f53562a;
                videoMiddlePageAdView.K(1, videoMiddlePageAdView.mFloatVideoContainer.B0());
                this.f53562a.C = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53563e;

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
            this.f53563e = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                b.a.q0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.e() || this.f53563e.n == null) {
                    return false;
                }
                b.a.e.e.p.a.a(this.f53563e.n.adCollect());
                ((Vibrator) this.f53563e.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdCard f53564e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53565f;

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
            this.f53565f = videoMiddlePageAdView;
            this.f53564e = videoMiddlePageAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f53565f.n == null || this.f53565f.n.getAdFacadeData() == null || this.f53565f.n.getAdFacadeData().w() == null) {
                    str = null;
                    str2 = null;
                } else {
                    AdvertAppInfo w = this.f53565f.n.getAdFacadeData().w();
                    str2 = w.getDownloadId();
                    str = w.e4;
                }
                int e2 = z.e(this.f53565f.mContext, this.f53564e.getButtonScheme(), str2, str);
                if (this.f53565f.v != null) {
                    this.f53565f.v.a(false);
                }
                if (this.f53565f.afterClickSchemeListener != null) {
                    this.f53565f.afterClickSchemeListener.a(e2, null);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53566e;

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
            this.f53566e = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            b.a.r0.q2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f53566e.mFloatVideoContainer) == null || cVar.I0() == null) {
                return;
            }
            VideoMiddlePageAdView videoMiddlePageAdView = this.f53566e;
            videoMiddlePageAdView.A = (int) TimeUnit.MILLISECONDS.toSeconds(videoMiddlePageAdView.mFloatVideoContainer.I0().getDuration());
        }
    }

    /* loaded from: classes9.dex */
    public class g implements c.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53567a;

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
            this.f53567a = videoMiddlePageAdView;
        }

        @Override // b.a.r0.q2.c.v
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f53567a.D == null) {
                return;
            }
            if (z) {
                this.f53567a.D.g(0);
            } else {
                this.f53567a.D.g(1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53568e;

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
            this.f53568e = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f53568e.w.setHasAgreeToPlay(true);
                this.f53568e.mFloatVideoContainer.n1(false);
                this.f53568e.w.showPlayTips();
                if (this.f53568e.n == null || this.f53568e.n.video == null) {
                    return;
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f53568e;
                videoMiddlePageAdView.mFloatVideoContainer.d2(videoMiddlePageAdView.n.video.video_url, "");
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53569a;

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
            this.f53569a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.f53569a.f53557h != null) {
                    this.f53569a.f53557h.setVisibility(8);
                }
                if (this.f53569a.f53558i != null) {
                    this.f53569a.f53558i.setVisibility(8);
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
                if (this.f53569a.f53557h != null) {
                    this.f53569a.f53557h.setVisibility(0);
                }
                if (this.f53569a.f53558i != null) {
                    this.f53569a.f53558i.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53570a;

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
            this.f53570a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.f53570a.f53557h != null) {
                    this.f53570a.f53557h.setVisibility(0);
                }
                if (this.f53570a.f53558i != null) {
                    this.f53570a.f53558i.setVisibility(0);
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
                if (this.f53570a.f53557h != null) {
                    this.f53570a.f53557h.setVisibility(8);
                }
                if (this.f53570a.f53558i != null) {
                    this.f53570a.f53558i.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53571a;

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
            this.f53571a = videoMiddlePageAdView;
        }

        @Override // b.a.r0.q2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // b.a.r0.q2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements c.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53572a;

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
            this.f53572a = videoMiddlePageAdView;
        }

        @Override // b.a.r0.q2.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // b.a.r0.q2.c.g0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f53572a.n != null && this.f53572a.n.video != null && this.f53572a.n.video.video_height.intValue() > this.f53572a.n.video.video_width.intValue()) {
                    this.f53572a.mFloatVideoContainer.M1(false, true);
                } else {
                    this.f53572a.mFloatVideoContainer.M1(false, true);
                }
                if (this.f53572a.z != null) {
                    this.f53572a.z.h(this.f53572a);
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f53572a;
                videoMiddlePageAdView.O(1 ^ (videoMiddlePageAdView.s ? 1 : 0));
                this.f53572a.B = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements c.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53573a;

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
            this.f53573a = videoMiddlePageAdView;
        }

        @Override // b.a.r0.q2.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f53573a;
                videoMiddlePageAdView.mFloatVideoContainer.d2(videoMiddlePageAdView.n.video.video_url, "");
                if (this.f53573a.z != null) {
                    this.f53573a.z.h(this.f53573a);
                }
                this.f53573a.O(1);
                this.f53573a.B = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53574e;

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
            this.f53574e = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53574e.mFloatVideoContainer.a1();
                if (this.f53574e.v != null) {
                    this.f53574e.v.e();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f53574e;
                videoMiddlePageAdView.I(!videoMiddlePageAdView.s ? 1 : 0);
                this.f53574e.C = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f53575a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f53576b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f53577c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f53578d;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f53579e;

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
                this.f53579e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f53579e.f53576b.removeCallbacks(this.f53579e.f53577c);
                    this.f53579e.g(2);
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
            this.f53578d = videoMiddlePageAdView;
            this.f53575a = -1;
            this.f53577c = new a(this);
            this.f53576b = new Handler();
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f53576b.removeCallbacks(this.f53577c);
                this.f53576b.postDelayed(this.f53577c, 3000L);
            }
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = this.f53575a;
                if (i2 == i3) {
                    return i3;
                }
                this.f53578d.k.setVisibility(8);
                this.f53578d.j.setVisibility(8);
                this.f53578d.Q(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.f53575a;
                if (i2 == i3) {
                    return i3;
                }
                this.f53578d.k.setVisibility(0);
                this.f53578d.j.setVisibility(0);
                this.f53578d.Q(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.f53575a;
                if (i2 == i3) {
                    return i3;
                }
                this.f53578d.k.setVisibility(0);
                this.f53578d.j.setVisibility(0);
                b.a.r0.q2.c cVar = this.f53578d.mFloatVideoContainer;
                if (cVar != null) {
                    cVar.O0();
                }
                if (i3 != 3 || this.f53578d.n.autoPlay) {
                    this.f53578d.Q(false);
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
                    this.f53575a = d(i2);
                    c();
                } else if (i2 == 1) {
                    this.f53575a = d(i2);
                    this.f53576b.removeCallbacks(this.f53577c);
                } else if (i2 == 2) {
                    this.f53575a = f(i2);
                } else if (i2 != 3) {
                    this.f53575a = f(i2);
                } else {
                    this.f53575a = e(i2);
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
        this.B = false;
        this.C = true;
        this.E = new i(this);
        this.F = new j(this);
        this.B = false;
        this.C = true;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.middle_page_video_ad_layout, (ViewGroup) null);
        this.f53555f = inflate;
        this.mVideoAggContainer = (FrameLayout) inflate.findViewById(R.id.video_agg_container);
        this.f53556g = this.f53555f.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) this.f53555f.findViewById(R.id.video_container);
        this.mVideoContainer = frameLayout;
        b.a.r0.q2.c cVar = new b.a.r0.q2.c(this.mContext, frameLayout, false);
        this.mFloatVideoContainer = cVar;
        cVar.O1(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.mFloatVideoContainer.K1(new f(this));
        this.mFloatVideoContainer.p1(new g(this));
        this.mFloatVideoContainer.f22803e.setOnTouchListener(null);
        this.mVideoTitle = (TextView) this.f53555f.findViewById(R.id.title);
        HeadImageView headImageView = (HeadImageView) this.f53555f.findViewById(R.id.user_icon);
        this.mUserIcon = headImageView;
        headImageView.setIsRound(true);
        this.mUserIcon.setDefaultBgResource(R.color.CAM_X0205);
        this.mUserIcon.setDefaultResource(R.drawable.icon_default_avatar100);
        this.mTagName = (TextView) this.f53555f.findViewById(R.id.ad_tag);
        this.mUsername = (TextView) this.f53555f.findViewById(R.id.user_name);
        this.p = (TextView) this.f53555f.findViewById(R.id.ad_operate_title);
        this.q = (TextView) this.f53555f.findViewById(R.id.ad_operate_button);
        this.t = (FrameLayout) this.f53555f.findViewById(R.id.tail_frame_container);
        b.a.r0.z2.m0.f fVar = new b.a.r0.z2.m0.f(this.mContext.getPageActivity(), this.t);
        this.u = fVar;
        fVar.f28232a = 1;
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) this.f53555f.findViewById(R.id.network_state_tip);
        this.w = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new h(this));
        this.f53557h = this.f53555f.findViewById(R.id.video_agg_container_foreground);
        this.j = this.f53555f.findViewById(R.id.user_container_foreground);
        this.k = this.f53555f.findViewById(R.id.title_foreground);
        this.f53558i = this.f53555f.findViewById(R.id.operate_area_foreground);
        this.f53557h.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.f53558i.setOnClickListener(this);
        this.mVideoContainer.setOnClickListener(this);
        this.mVideoAggContainer.setOnClickListener(this);
        this.mFloatVideoContainer.H1(this);
        this.mVideoTitle.setOnClickListener(this);
        this.mUserIcon.setOnClickListener(this);
        this.mUsername.setOnClickListener(this);
        this.o = b.a.e.e.p.l.k(this.mContext.getPageActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoAggContainer.getLayoutParams();
        layoutParams.height = (int) (this.o * 0.5625f);
        this.mVideoAggContainer.setLayoutParams(layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.7f);
        this.l = alphaAnimation;
        alphaAnimation.setDuration(500L);
        this.l.setAnimationListener(this.F);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.7f, 0.0f);
        this.m = alphaAnimation2;
        alphaAnimation2.setDuration(500L);
        this.m.setAnimationListener(this.E);
        this.f53555f.setOnClickListener(this);
        this.D = new o(this);
    }

    public final void A(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2, b.a.r0.x0.r1.a aVar) {
        VideoInfo videoInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, videoMiddlePageAdCard, i2, aVar) == null) || videoMiddlePageAdCard == null || (videoInfo = videoMiddlePageAdCard.video) == null) {
            return;
        }
        this.x = i2;
        this.s = this.n.autoPlay;
        this.B = false;
        Integer num = videoInfo.video_duration;
        if (num != null && num.intValue() > 0) {
            this.A = videoMiddlePageAdCard.video.video_duration.intValue();
        }
        if (this.mFloatVideoContainer.T0()) {
            K(!videoMiddlePageAdCard.autoPlay ? 1 : 0, this.mFloatVideoContainer.B0());
            this.C = true;
        }
        this.mFloatVideoContainer.k2();
        this.mFloatVideoContainer.s1(true);
        this.mFloatVideoContainer.v1(false);
        this.mFloatVideoContainer.t1(true);
        this.mFloatVideoContainer.M1(false, true);
        this.mFloatVideoContainer.L1(i2);
        this.mFloatVideoContainer.y1(new k(this));
        this.mFloatVideoContainer.G1(new l(this));
        this.mFloatVideoContainer.A1(new m(this));
        this.mFloatVideoContainer.o1(false);
        this.mFloatVideoContainer.q0();
        this.mFloatVideoContainer.I1(new n(this));
        this.mFloatVideoContainer.J1(new a(this, aVar));
        this.mFloatVideoContainer.S1(videoMiddlePageAdCard.video.thumbnail_url);
        this.mFloatVideoContainer.Y1(videoMiddlePageAdCard.video.video_url, "");
        this.mFloatVideoContainer.D1(new b(this));
        this.mFloatVideoContainer.B1(new c(this));
        this.mFloatVideoContainer.a1();
        this.mFloatVideoContainer.a2();
        if (videoMiddlePageAdCard.autoPlay) {
            if (this.w.isShowNetworkTips()) {
                this.mFloatVideoContainer.c2(false);
                this.w.showNetWorkTips();
                this.mFloatVideoContainer.n1(true);
                this.mFloatVideoContainer.U0(videoMiddlePageAdCard.video.video_url, "");
            } else {
                this.mFloatVideoContainer.n1(false);
                this.mFloatVideoContainer.c2(false);
                this.w.hide();
                this.mFloatVideoContainer.i2(videoMiddlePageAdCard.video.video_url, "", null, new Object[0]);
            }
            b.a.r0.z2.m0.g gVar = this.v;
            if (gVar != null) {
                gVar.a(true);
            }
            if (i2 == 0) {
                this.f53557h.setVisibility(8);
                this.f53558i.setVisibility(8);
            } else {
                this.f53557h.startAnimation(this.m);
                this.f53558i.startAnimation(this.m);
            }
            if (i2 == 0) {
                this.D.g(3);
                return;
            } else {
                this.D.g(0);
                return;
            }
        }
        this.w.hide();
        this.mFloatVideoContainer.c2(true);
        this.D.g(3);
        if (b.a.e.e.p.j.x() && videoMiddlePageAdCard.waitConfirm) {
            this.f53557h.startAnimation(this.m);
            this.f53558i.startAnimation(this.m);
            return;
        }
        this.f53557h.setVisibility(0);
        this.f53558i.setVisibility(0);
    }

    public final boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                int intValue = this.n.video.video_width.intValue();
                return intValue <= 0 || ((float) this.n.video.video_height.intValue()) / ((float) intValue) < 1.0f;
            } catch (NumberFormatException unused) {
                return true;
            }
        }
        return invokeV.booleanValue;
    }

    public final void D() {
        TbPageContext tbPageContext;
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (tbPageContext = this.mContext) == null || tbPageContext.getPageActivity() == null || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.getAdFacadeData() == null || TextUtils.isEmpty(this.n.getScheme())) {
            return;
        }
        String scheme = this.n.getScheme();
        AdvertAppInfo w = this.n.getAdFacadeData().w();
        int f2 = z.o(this.n.getScheme()) ? z.f(this.mContext.getPageActivity(), scheme) : 0;
        b.a.r0.q1.o.a aVar = this.afterClickSchemeListener;
        if (aVar != null) {
            aVar.a(f2, null);
        }
        b.a.r0.z2.m0.g gVar = this.v;
        if (gVar != null) {
            gVar.a(false);
        }
        if (f2 == 1000) {
            return;
        }
        String m2 = z.m(scheme);
        if (this.mFloatVideoContainer.T0() && w != null && b.a.r0.a.h().x()) {
            z.e(this.mContext, m2, w.getDownloadId(), w.e4);
            return;
        }
        AdWebVideoActivity.setStaticInfo(w, this.n.getAdFacadeData().f2725g != null ? this.n.getAdFacadeData().f2725g.e() : 0, "DETAIL");
        Bundle bundle = new Bundle();
        bundle.putString("video_url", this.n.video.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.n.video.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.A);
        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.n.tailFrame.e());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, this.n.getAdFacadeData().w().getDownloadId());
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(this.mContext.getPageActivity(), "", m2, true, true, true, bundle));
    }

    public final void I(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || this.B) {
            return;
        }
        int k2 = this.n.getAdFacadeData().k();
        b.a.f.d adFacadeData = this.n.getAdFacadeData();
        int i3 = this.A;
        b.a.r0.z2.l0.e.b().d(b.a.r0.z2.l0.g.m(adFacadeData, 34, k2, i2, i3, i3, -1));
        this.B = true;
    }

    public final void J(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        b.a.r0.z2.l0.e.b().d(b.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 33, this.n.getAdFacadeData().k(), i2, this.A, b.a.r0.r.i.a.a(i3), -1));
    }

    public final void K(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        b.a.r0.z2.l0.e.b().d(b.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 32, this.n.getAdFacadeData().k(), i2, this.A, b.a.r0.r.i.a.a(i3), -1));
    }

    public final void M(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        b.a.r0.z2.l0.e.b().d(b.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 36, this.n.getAdFacadeData().k(), i2, this.A, b.a.r0.r.i.a.a(this.mFloatVideoContainer.B0()), -1));
    }

    public final void O(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || !this.C) {
            return;
        }
        b.a.r0.z2.l0.e.b().d(b.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 31, this.n.getAdFacadeData().k(), i2, this.A, 0, -1));
        this.C = false;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!B()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mVideoAggContainer.getLayoutParams();
                layoutParams.height = (int) (this.o * 0.875f);
                this.mVideoAggContainer.setLayoutParams(layoutParams);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mVideoAggContainer.getLayoutParams();
            layoutParams2.height = (int) (this.o * 0.5625f);
            this.mVideoAggContainer.setLayoutParams(layoutParams2);
        }
    }

    public final void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921317);
            CustomMessage customMessage = new CustomMessage(2921317);
            if (z) {
                customMessage.setExtra("high");
            } else {
                customMessage.setExtra("low");
            }
            customResponsedMessage.setmOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    public final void R(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, videoMiddlePageAdCard) == null) {
            b.a.r0.z2.m0.g b2 = this.u.b(videoMiddlePageAdCard.tailFrame, this.v);
            this.v = b2;
            if (b2 != null) {
                z(this.n.getAdFacadeData());
                this.v.j(this.mContext);
                this.v.m(this);
                this.v.d(videoMiddlePageAdCard.tailFrame);
                this.v.i(this.n);
                this.v.f();
            }
        }
    }

    public b.a.r0.x0.r1.a getAutoPlayCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.r : (b.a.r0.x0.r1.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f53555f : (View) invokeV.objValue;
    }

    @Override // b.a.r0.q1.o.l.j
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mFloatVideoContainer.T0() : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            View view2 = this.f53557h;
            if (view == view2 && view2.getVisibility() == 0) {
                b.a.r0.x0.z2.c cVar = this.y;
                if (cVar != null) {
                    cVar.onVideoContainerForegroundClick(this.mPosition);
                    return;
                }
                return;
            }
            View view3 = this.f53558i;
            if (view == view3 && view3.getVisibility() == 0) {
                b.a.r0.x0.z2.c cVar2 = this.y;
                if (cVar2 != null) {
                    cVar2.onVideoContainerForegroundClick(this.mPosition);
                }
            } else if (view != this.k && view != this.j) {
                if (view.getId() != R.id.video_container && view.getId() != R.id.video_agg_container && view.getId() != R.id.float_video_container) {
                    if (this.n.getAdFacadeData() == null || this.n.getAdFacadeData().w() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str = this.n.getAdFacadeData().w().getDownloadId();
                        str2 = this.n.getAdFacadeData().w().e4;
                    }
                    int e2 = z.e(this.mContext, this.n.getScheme(), str, str2);
                    b.a.r0.q1.o.a aVar = this.afterClickSchemeListener;
                    if (aVar != null) {
                        aVar.a(e2, null);
                    }
                    b.a.r0.z2.m0.g gVar = this.v;
                    if (gVar != null) {
                        gVar.a(false);
                        return;
                    }
                    return;
                }
                D();
            } else if (this.f53557h.getVisibility() == 0) {
                b.a.r0.x0.z2.c cVar3 = this.y;
                if (cVar3 != null) {
                    cVar3.onVideoContainerForegroundClick(this.mPosition);
                }
            } else {
                this.D.g(0);
            }
        }
    }

    @Override // b.a.r0.q1.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            recycleVideo();
            View view = this.f53557h;
            if (view != null) {
                view.clearAnimation();
            }
            View view2 = this.f53558i;
            if (view2 != null) {
                view2.clearAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
    public void onTimeout(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, view) == null) {
            this.r.a(this.x);
        }
    }

    @Override // b.a.r0.q1.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && isPlaying()) {
            this.mFloatVideoContainer.W0();
            K(!this.s ? 1 : 0, this.mFloatVideoContainer.B0());
            this.C = true;
        }
    }

    public void recycleVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            b.a.r0.q2.c cVar = this.mFloatVideoContainer;
            if (cVar != null) {
                cVar.v0();
            }
            this.B = false;
            this.C = true;
        }
    }

    @Override // b.a.r0.q1.o.l.h
    public void setAutoPlayCallBack(b.a.r0.x0.r1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.r = aVar;
        }
    }

    @Override // b.a.r0.q1.o.l.h
    public void setCurrentPlayCallBack(b.a.r0.q1.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) {
            this.z = fVar;
        }
    }

    @Override // b.a.r0.q1.o.l.h
    public void setOnVideoContainerForegroundClickListener(b.a.r0.x0.z2.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.y = cVar;
        }
    }

    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    @Override // b.a.r0.q1.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (b.a.r0.r.i.a.a(this.mFloatVideoContainer.B0()) < this.A && this.mFloatVideoContainer.T0()) {
                K(!this.s ? 1 : 0, this.mFloatVideoContainer.B0());
            }
            stopVideo();
            this.v.a(false);
        }
    }

    public void stopVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mFloatVideoContainer.k2();
            TextView textView = this.mVideoTitle;
            if (textView != null) {
                textView.setVisibility(0);
            }
            o oVar = this.D;
            if (oVar != null) {
                oVar.g(2);
            }
            this.B = false;
            this.C = true;
        }
    }

    public final void z(b.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, dVar) == null) || dVar == null) {
            return;
        }
        int i2 = !this.s ? 1 : 0;
        b.a.r0.z2.l0.c m2 = b.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 303, this.n.getAdFacadeData().k(), i2, this.n.video.video_duration.intValue(), 0, -1);
        b.a.r0.z2.m0.g gVar = this.v;
        if (gVar != null) {
            gVar.l(m2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onChangeSkinType(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, videoMiddlePageAdCard, i2) == null) {
            this.mVideoTitle.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.mTagName.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.p.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
            this.q.setTextColor(this.mContext.getResources().getColor(R.color.cp_cont_i_alpha70));
            SkinManager.setBackgroundResource(this.q, R.drawable.btn_rouned_corner_bg_shape);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void onUpdateCardView(VideoMiddlePageAdCard videoMiddlePageAdCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, videoMiddlePageAdCard) == null) {
            this.n = videoMiddlePageAdCard;
            P();
            this.mVideoTitle.setText(videoMiddlePageAdCard.threadTitle);
            this.mUsername.setText(videoMiddlePageAdCard.userName);
            if (!StringUtils.isNull(videoMiddlePageAdCard.userPortrait) && videoMiddlePageAdCard.userPortrait.startsWith("http")) {
                this.mUserIcon.startLoad(videoMiddlePageAdCard.userPortrait, 10, false);
            } else {
                this.mUserIcon.startLoad(videoMiddlePageAdCard.userPortrait, 12, false);
            }
            this.mUserIcon.setOnLongClickListener(new d(this));
            this.mTagName.setText(videoMiddlePageAdCard.tagName);
            this.p.setText(videoMiddlePageAdCard.operateData.f28093a);
            this.q.setText(videoMiddlePageAdCard.operateData.f28094b);
            this.q.setOnClickListener(new e(this, videoMiddlePageAdCard));
            A(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
            R(videoMiddlePageAdCard);
            onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
