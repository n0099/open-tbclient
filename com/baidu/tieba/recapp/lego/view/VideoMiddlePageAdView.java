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
import c.a.r0.q2.c;
import c.a.r0.z2.z;
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
/* loaded from: classes7.dex */
public class VideoMiddlePageAdView extends BaseLegoCardView<VideoMiddlePageAdCard> implements c.a.r0.q1.o.l.h, CountDownTextView.c, View.OnClickListener, c.a.r0.q1.o.l.j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public o D;
    public Animation.AnimationListener E;
    public Animation.AnimationListener F;

    /* renamed from: f  reason: collision with root package name */
    public View f56442f;

    /* renamed from: g  reason: collision with root package name */
    public View f56443g;

    /* renamed from: h  reason: collision with root package name */
    public View f56444h;

    /* renamed from: i  reason: collision with root package name */
    public View f56445i;

    /* renamed from: j  reason: collision with root package name */
    public View f56446j;
    public View k;
    public Animation l;
    public Animation m;
    public c.a.r0.q2.c mFloatVideoContainer;
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
    public c.a.r0.x0.h1.a r;
    public boolean s;
    public ViewGroup t;
    public c.a.r0.z2.m0.f u;
    public c.a.r0.z2.m0.g v;
    public VideoNetworkStateTipView w;
    public int x;
    public c.a.r0.x0.p2.c y;
    public c.a.r0.q1.o.l.f z;

    /* loaded from: classes7.dex */
    public class a implements CyberPlayerManager.OnErrorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.x0.h1.a f56447e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56448f;

        public a(VideoMiddlePageAdView videoMiddlePageAdView, c.a.r0.x0.h1.a aVar) {
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
            this.f56448f = videoMiddlePageAdView;
            this.f56447e = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                c.a.r0.x0.h1.a aVar = this.f56447e;
                if (aVar != null) {
                    aVar.cancel();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f56448f;
                videoMiddlePageAdView.N(!videoMiddlePageAdView.s ? 1 : 0);
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.d0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56449a;

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
            this.f56449a = videoMiddlePageAdView;
        }

        @Override // c.a.r0.q2.c.d0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f56449a;
                videoMiddlePageAdView.K(1, videoMiddlePageAdView.mFloatVideoContainer.B0());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements c.b0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56450a;

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
            this.f56450a = videoMiddlePageAdView;
        }

        @Override // c.a.r0.q2.c.b0
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f56450a;
                videoMiddlePageAdView.L(1, videoMiddlePageAdView.mFloatVideoContainer.B0());
                this.f56450a.C = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56451e;

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
            this.f56451e = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                c.a.q0.t.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense == null || !adAdSense.e() || this.f56451e.n == null) {
                    return false;
                }
                c.a.e.e.p.a.a(this.f56451e.n.adCollect());
                ((Vibrator) this.f56451e.mContext.getPageActivity().getSystemService("vibrator")).vibrate(TimeUnit.MILLISECONDS.toMillis(300L));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdCard f56452e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56453f;

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
            this.f56453f = videoMiddlePageAdView;
            this.f56452e = videoMiddlePageAdCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f56453f.n == null || this.f56453f.n.getAdFacadeData() == null || this.f56453f.n.getAdFacadeData().w() == null) {
                    str = null;
                    str2 = null;
                } else {
                    AdvertAppInfo w = this.f56453f.n.getAdFacadeData().w();
                    str2 = w.getDownloadId();
                    str = w.e4;
                }
                int e2 = z.e(this.f56453f.mContext, this.f56452e.getButtonScheme(), str2, str);
                if (this.f56453f.v != null) {
                    this.f56453f.v.a(false);
                }
                if (this.f56453f.afterClickSchemeListener != null) {
                    this.f56453f.afterClickSchemeListener.a(e2, null);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56454e;

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
            this.f56454e = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            c.a.r0.q2.c cVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (cVar = this.f56454e.mFloatVideoContainer) == null || cVar.I0() == null) {
                return;
            }
            VideoMiddlePageAdView videoMiddlePageAdView = this.f56454e;
            videoMiddlePageAdView.A = (int) TimeUnit.MILLISECONDS.toSeconds(videoMiddlePageAdView.mFloatVideoContainer.I0().getDuration());
        }
    }

    /* loaded from: classes7.dex */
    public class g implements c.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56455a;

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
            this.f56455a = videoMiddlePageAdView;
        }

        @Override // c.a.r0.q2.c.v
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f56455a.D == null) {
                return;
            }
            if (z) {
                this.f56455a.D.g(0);
            } else {
                this.f56455a.D.g(1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56456e;

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
            this.f56456e = videoMiddlePageAdView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56456e.w.setHasAgreeToPlay(true);
                this.f56456e.mFloatVideoContainer.n1(false);
                this.f56456e.w.showPlayTips();
                if (this.f56456e.n == null || this.f56456e.n.video == null) {
                    return;
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f56456e;
                videoMiddlePageAdView.mFloatVideoContainer.d2(videoMiddlePageAdView.n.video.video_url, "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56457a;

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
            this.f56457a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.f56457a.f56444h != null) {
                    this.f56457a.f56444h.setVisibility(8);
                }
                if (this.f56457a.f56445i != null) {
                    this.f56457a.f56445i.setVisibility(8);
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
                if (this.f56457a.f56444h != null) {
                    this.f56457a.f56444h.setVisibility(0);
                }
                if (this.f56457a.f56445i != null) {
                    this.f56457a.f56445i.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56458a;

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
            this.f56458a = videoMiddlePageAdView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                if (this.f56458a.f56444h != null) {
                    this.f56458a.f56444h.setVisibility(0);
                }
                if (this.f56458a.f56445i != null) {
                    this.f56458a.f56445i.setVisibility(0);
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
                if (this.f56458a.f56444h != null) {
                    this.f56458a.f56444h.setVisibility(8);
                }
                if (this.f56458a.f56445i != null) {
                    this.f56458a.f56445i.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements c.x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56459a;

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
            this.f56459a = videoMiddlePageAdView;
        }

        @Override // c.a.r0.q2.c.x
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.q2.c.x
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements c.g0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56460a;

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
            this.f56460a = videoMiddlePageAdView;
        }

        @Override // c.a.r0.q2.c.g0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // c.a.r0.q2.c.g0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f56460a.n != null && this.f56460a.n.video != null && this.f56460a.n.video.video_height.intValue() > this.f56460a.n.video.video_width.intValue()) {
                    this.f56460a.mFloatVideoContainer.M1(false, true);
                } else {
                    this.f56460a.mFloatVideoContainer.M1(false, true);
                }
                if (this.f56460a.z != null) {
                    this.f56460a.z.h(this.f56460a);
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f56460a;
                videoMiddlePageAdView.O(1 ^ (videoMiddlePageAdView.s ? 1 : 0));
                this.f56460a.B = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements c.a0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56461a;

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
            this.f56461a = videoMiddlePageAdView;
        }

        @Override // c.a.r0.q2.c.a0
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                VideoMiddlePageAdView videoMiddlePageAdView = this.f56461a;
                videoMiddlePageAdView.mFloatVideoContainer.d2(videoMiddlePageAdView.n.video.video_url, "");
                if (this.f56461a.z != null) {
                    this.f56461a.z.h(this.f56461a);
                }
                this.f56461a.O(1);
                this.f56461a.B = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56462e;

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
            this.f56462e = videoMiddlePageAdView;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56462e.mFloatVideoContainer.a1();
                if (this.f56462e.v != null) {
                    this.f56462e.v.e();
                }
                VideoMiddlePageAdView videoMiddlePageAdView = this.f56462e;
                videoMiddlePageAdView.J(!videoMiddlePageAdView.s ? 1 : 0);
                this.f56462e.C = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f56463a;

        /* renamed from: b  reason: collision with root package name */
        public Handler f56464b;

        /* renamed from: c  reason: collision with root package name */
        public Runnable f56465c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ VideoMiddlePageAdView f56466d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f56467e;

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
                this.f56467e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f56467e.f56464b.removeCallbacks(this.f56467e.f56465c);
                    this.f56467e.g(2);
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
            this.f56466d = videoMiddlePageAdView;
            this.f56463a = -1;
            this.f56465c = new a(this);
            this.f56464b = new Handler();
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56464b.removeCallbacks(this.f56465c);
                this.f56464b.postDelayed(this.f56465c, 3000L);
            }
        }

        public final int d(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int i3 = this.f56463a;
                if (i2 == i3) {
                    return i3;
                }
                this.f56466d.k.setVisibility(8);
                this.f56466d.f56446j.setVisibility(8);
                this.f56466d.Q(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                int i3 = this.f56463a;
                if (i2 == i3) {
                    return i3;
                }
                this.f56466d.k.setVisibility(0);
                this.f56466d.f56446j.setVisibility(0);
                this.f56466d.Q(true);
                return i2;
            }
            return invokeI.intValue;
        }

        public final int f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = this.f56463a;
                if (i2 == i3) {
                    return i3;
                }
                this.f56466d.k.setVisibility(0);
                this.f56466d.f56446j.setVisibility(0);
                c.a.r0.q2.c cVar = this.f56466d.mFloatVideoContainer;
                if (cVar != null) {
                    cVar.O0();
                }
                if (i3 != 3 || this.f56466d.n.autoPlay) {
                    this.f56466d.Q(false);
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
                    this.f56463a = d(i2);
                    c();
                } else if (i2 == 1) {
                    this.f56463a = d(i2);
                    this.f56464b.removeCallbacks(this.f56465c);
                } else if (i2 == 2) {
                    this.f56463a = f(i2);
                } else if (i2 != 3) {
                    this.f56463a = f(i2);
                } else {
                    this.f56463a = e(i2);
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
        this.f56442f = inflate;
        this.mVideoAggContainer = (FrameLayout) inflate.findViewById(R.id.video_agg_container);
        this.f56443g = this.f56442f.findViewById(R.id.card_container);
        FrameLayout frameLayout = (FrameLayout) this.f56442f.findViewById(R.id.video_container);
        this.mVideoContainer = frameLayout;
        c.a.r0.q2.c cVar = new c.a.r0.q2.c(this.mContext, frameLayout, false);
        this.mFloatVideoContainer = cVar;
        cVar.O1(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.mFloatVideoContainer.K1(new f(this));
        this.mFloatVideoContainer.p1(new g(this));
        this.mFloatVideoContainer.f23919e.setOnTouchListener(null);
        this.mVideoTitle = (TextView) this.f56442f.findViewById(R.id.title);
        HeadImageView headImageView = (HeadImageView) this.f56442f.findViewById(R.id.user_icon);
        this.mUserIcon = headImageView;
        headImageView.setIsRound(true);
        this.mUserIcon.setDefaultBgResource(R.color.CAM_X0205);
        this.mUserIcon.setDefaultResource(R.drawable.icon_default_avatar100);
        this.mTagName = (TextView) this.f56442f.findViewById(R.id.ad_tag);
        this.mUsername = (TextView) this.f56442f.findViewById(R.id.user_name);
        this.p = (TextView) this.f56442f.findViewById(R.id.ad_operate_title);
        this.q = (TextView) this.f56442f.findViewById(R.id.ad_operate_button);
        this.t = (FrameLayout) this.f56442f.findViewById(R.id.tail_frame_container);
        c.a.r0.z2.m0.f fVar = new c.a.r0.z2.m0.f(this.mContext.getPageActivity(), this.t);
        this.u = fVar;
        fVar.f29829a = 1;
        VideoNetworkStateTipView videoNetworkStateTipView = (VideoNetworkStateTipView) this.f56442f.findViewById(R.id.network_state_tip);
        this.w = videoNetworkStateTipView;
        videoNetworkStateTipView.setPlayViewOnClickListener(new h(this));
        this.f56444h = this.f56442f.findViewById(R.id.video_agg_container_foreground);
        this.f56446j = this.f56442f.findViewById(R.id.user_container_foreground);
        this.k = this.f56442f.findViewById(R.id.title_foreground);
        this.f56445i = this.f56442f.findViewById(R.id.operate_area_foreground);
        this.f56444h.setOnClickListener(this);
        this.f56446j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.f56445i.setOnClickListener(this);
        this.mVideoContainer.setOnClickListener(this);
        this.mVideoAggContainer.setOnClickListener(this);
        this.mFloatVideoContainer.H1(this);
        this.mVideoTitle.setOnClickListener(this);
        this.mUserIcon.setOnClickListener(this);
        this.mUsername.setOnClickListener(this);
        this.o = c.a.e.e.p.l.k(this.mContext.getPageActivity());
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
        this.f56442f.setOnClickListener(this);
        this.D = new o(this);
    }

    public final void A(VideoMiddlePageAdCard videoMiddlePageAdCard, int i2, c.a.r0.x0.h1.a aVar) {
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
            L(!videoMiddlePageAdCard.autoPlay ? 1 : 0, this.mFloatVideoContainer.B0());
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
            c.a.r0.z2.m0.g gVar = this.v;
            if (gVar != null) {
                gVar.a(true);
            }
            if (i2 == 0) {
                this.f56444h.setVisibility(8);
                this.f56445i.setVisibility(8);
            } else {
                this.f56444h.startAnimation(this.m);
                this.f56445i.startAnimation(this.m);
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
        if (c.a.e.e.p.j.x() && videoMiddlePageAdCard.waitConfirm) {
            this.f56444h.startAnimation(this.m);
            this.f56445i.startAnimation(this.m);
            return;
        }
        this.f56444h.setVisibility(0);
        this.f56445i.setVisibility(0);
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
        c.a.r0.q1.o.a aVar = this.afterClickSchemeListener;
        if (aVar != null) {
            aVar.a(f2, null);
        }
        c.a.r0.z2.m0.g gVar = this.v;
        if (gVar != null) {
            gVar.a(false);
        }
        if (f2 == 1000) {
            return;
        }
        String m2 = z.m(scheme);
        if (this.mFloatVideoContainer.T0() && w != null && c.a.r0.a.h().x()) {
            z.e(this.mContext, m2, w.getDownloadId(), w.e4);
            return;
        }
        AdWebVideoActivity.setStaticInfo(w, this.n.getAdFacadeData().f3278g != null ? this.n.getAdFacadeData().f3278g.e() : 0, "DETAIL");
        Bundle bundle = new Bundle();
        bundle.putString("video_url", this.n.video.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, this.n.video.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, 1.7777778f);
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, this.A);
        bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, this.n.tailFrame.e());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, this.n.getAdFacadeData().w().getDownloadId());
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(this.mContext.getPageActivity(), "", m2, true, true, true, bundle));
    }

    public final void J(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || this.B) {
            return;
        }
        int k2 = this.n.getAdFacadeData().k();
        c.a.f.d adFacadeData = this.n.getAdFacadeData();
        int i3 = this.A;
        c.a.r0.z2.l0.e.b().d(c.a.r0.z2.l0.g.m(adFacadeData, 34, k2, i2, i3, i3, -1));
        this.B = true;
    }

    public final void K(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        c.a.r0.z2.l0.e.b().d(c.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 33, this.n.getAdFacadeData().k(), i2, this.A, c.a.r0.r.i.a.a(i3), -1));
    }

    public final void L(int i2, int i3) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        c.a.r0.z2.l0.e.b().d(c.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 32, this.n.getAdFacadeData().k(), i2, this.A, c.a.r0.r.i.a.a(i3), -1));
    }

    public final void N(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null) {
            return;
        }
        c.a.r0.z2.l0.e.b().d(c.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 36, this.n.getAdFacadeData().k(), i2, this.A, c.a.r0.r.i.a.a(this.mFloatVideoContainer.B0()), -1));
    }

    public final void O(int i2) {
        VideoMiddlePageAdCard videoMiddlePageAdCard;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (videoMiddlePageAdCard = this.n) == null || videoMiddlePageAdCard.video == null || videoMiddlePageAdCard.getAdFacadeData() == null || !this.C) {
            return;
        }
        c.a.r0.z2.l0.e.b().d(c.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 31, this.n.getAdFacadeData().k(), i2, this.A, 0, -1));
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
            c.a.r0.z2.m0.g b2 = this.u.b(videoMiddlePageAdCard.tailFrame, this.v);
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

    public c.a.r0.x0.h1.a getAutoPlayCallBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.r : (c.a.r0.x0.h1.a) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View initLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f56442f : (View) invokeV.objValue;
    }

    @Override // c.a.r0.q1.o.l.j
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
            View view2 = this.f56444h;
            if (view == view2 && view2.getVisibility() == 0) {
                c.a.r0.x0.p2.c cVar = this.y;
                if (cVar != null) {
                    cVar.onVideoContainerForegroundClick(this.mPosition);
                    return;
                }
                return;
            }
            View view3 = this.f56445i;
            if (view == view3 && view3.getVisibility() == 0) {
                c.a.r0.x0.p2.c cVar2 = this.y;
                if (cVar2 != null) {
                    cVar2.onVideoContainerForegroundClick(this.mPosition);
                }
            } else if (view != this.k && view != this.f56446j) {
                if (view.getId() != R.id.video_container && view.getId() != R.id.video_agg_container && view.getId() != R.id.float_video_container) {
                    if (this.n.getAdFacadeData() == null || this.n.getAdFacadeData().w() == null) {
                        str = null;
                        str2 = null;
                    } else {
                        str = this.n.getAdFacadeData().w().getDownloadId();
                        str2 = this.n.getAdFacadeData().w().e4;
                    }
                    int e2 = z.e(this.mContext, this.n.getScheme(), str, str2);
                    c.a.r0.q1.o.a aVar = this.afterClickSchemeListener;
                    if (aVar != null) {
                        aVar.a(e2, null);
                    }
                    c.a.r0.z2.m0.g gVar = this.v;
                    if (gVar != null) {
                        gVar.a(false);
                        return;
                    }
                    return;
                }
                D();
            } else if (this.f56444h.getVisibility() == 0) {
                c.a.r0.x0.p2.c cVar3 = this.y;
                if (cVar3 != null) {
                    cVar3.onVideoContainerForegroundClick(this.mPosition);
                }
            } else {
                this.D.g(0);
            }
        }
    }

    @Override // c.a.r0.q1.o.l.j
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            recycleVideo();
            View view = this.f56444h;
            if (view != null) {
                view.clearAnimation();
            }
            View view2 = this.f56445i;
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

    @Override // c.a.r0.q1.o.l.j
    public void pausePlay() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && isPlaying()) {
            this.mFloatVideoContainer.W0();
            L(!this.s ? 1 : 0, this.mFloatVideoContainer.B0());
            this.C = true;
        }
    }

    public void recycleVideo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            c.a.r0.q2.c cVar = this.mFloatVideoContainer;
            if (cVar != null) {
                cVar.v0();
            }
            this.B = false;
            this.C = true;
        }
    }

    @Override // c.a.r0.q1.o.l.h
    public void setAutoPlayCallBack(c.a.r0.x0.h1.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, aVar) == null) {
            this.r = aVar;
        }
    }

    @Override // c.a.r0.q1.o.l.h
    public void setCurrentPlayCallBack(c.a.r0.q1.o.l.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) {
            this.z = fVar;
        }
    }

    @Override // c.a.r0.q1.o.l.h
    public void setOnVideoContainerForegroundClickListener(c.a.r0.x0.p2.c cVar) {
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

    @Override // c.a.r0.q1.o.l.j
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            if (c.a.r0.r.i.a.a(this.mFloatVideoContainer.B0()) < this.A && this.mFloatVideoContainer.T0()) {
                L(!this.s ? 1 : 0, this.mFloatVideoContainer.B0());
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

    public final void z(c.a.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, dVar) == null) || dVar == null) {
            return;
        }
        int i2 = !this.s ? 1 : 0;
        c.a.r0.z2.l0.c m2 = c.a.r0.z2.l0.g.m(this.n.getAdFacadeData(), 303, this.n.getAdFacadeData().k(), i2, this.n.video.video_duration.intValue(), 0, -1);
        c.a.r0.z2.m0.g gVar = this.v;
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
            this.p.setText(videoMiddlePageAdCard.operateData.f29680a);
            this.q.setText(videoMiddlePageAdCard.operateData.f29681b);
            this.q.setOnClickListener(new e(this, videoMiddlePageAdCard));
            A(videoMiddlePageAdCard, this.mPosition, getAutoPlayCallBack());
            R(videoMiddlePageAdCard);
            onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
