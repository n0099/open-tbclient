package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.m.b;
import c.a.q0.d1.j;
import c.a.r0.y2.e0.c;
import c.a.r0.y2.l0.d;
import c.a.r0.y2.l0.e;
import c.a.r0.y2.m;
import c.a.r0.y2.m0.a;
import c.a.r0.y2.m0.f;
import c.a.r0.y2.m0.g;
import c.a.r0.y2.w;
import c.a.r0.y2.z;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.widget.AdEnhanceButtonView;
import com.baidu.tieba.recapp.widget.CountDownTextView;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
/* loaded from: classes7.dex */
public class AdVideoFlowView extends RelativeLayout implements m, View.OnClickListener, TbCyberVideoView.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable A;
    public Drawable B;
    public Drawable C;
    public TbPageContext<BaseFragmentActivity> D;
    public AdvertAppInfo E;
    public AdCard F;
    public String G;
    public int H;
    public boolean I;
    public VideoItemModel J;
    public boolean K;
    public ViewGroup L;
    public g M;
    public f N;
    public c.a.r0.y2.i0.b.g O;
    public j P;
    public int Q;
    public int R;
    public c.a S;
    public int T;
    public Handler U;
    public boolean V;
    public boolean W;

    /* renamed from: e  reason: collision with root package name */
    public View f56492e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56493f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56494g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56495h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f56496i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f56497j;
    public ImageView k;
    public ImageView l;
    public LinearLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public TbCyberVideoView p;
    public ImageView q;
    public TbImageView r;
    public TextView s;
    public AdTagTextView t;
    public FrameLayout u;
    public FrameLayout v;
    public AdEnhanceButtonView w;
    public VideoMiddleNiaiControllerView x;
    public Drawable y;
    public Drawable z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdVideoFlowView(Context context) {
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
        this.Q = -1;
        this.R = 0;
        this.U = new Handler();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ad_video_flow, this);
        this.f56492e = inflate;
        this.f56493f = (ImageView) inflate.findViewById(R.id.back_btn);
        this.q = (ImageView) this.f56492e.findViewById(R.id.play_btn);
        this.f56494g = (TextView) this.f56492e.findViewById(R.id.like_text);
        this.f56496i = (TextView) this.f56492e.findViewById(R.id.share_text);
        this.f56495h = (TextView) this.f56492e.findViewById(R.id.comment_text);
        this.f56497j = (ImageView) this.f56492e.findViewById(R.id.like_img);
        this.l = (ImageView) this.f56492e.findViewById(R.id.share_img);
        this.k = (ImageView) this.f56492e.findViewById(R.id.comment_img);
        this.m = (LinearLayout) this.f56492e.findViewById(R.id.like_container);
        this.o = (LinearLayout) this.f56492e.findViewById(R.id.share_container);
        this.n = (LinearLayout) this.f56492e.findViewById(R.id.comment_container);
        this.r = (TbImageView) this.f56492e.findViewById(R.id.user_head_img);
        this.s = (TextView) this.f56492e.findViewById(R.id.user_name);
        this.t = (AdTagTextView) this.f56492e.findViewById(R.id.ad_content);
        this.u = (FrameLayout) this.f56492e.findViewById(R.id.enhance_area_container);
        this.v = (FrameLayout) this.f56492e.findViewById(R.id.enhance_area_placeholder);
        this.L = (ViewGroup) this.f56492e.findViewById(R.id.tail_frame_container);
        TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) this.f56492e.findViewById(R.id.video_view);
        this.p = tbCyberVideoView;
        tbCyberVideoView.setStageType(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
        this.p.setContinuePlayEnable(true);
        this.p.setVideoStatusChangeListener(this);
        this.w = new AdEnhanceButtonView(context, this.u, this.v);
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = (VideoMiddleNiaiControllerView) this.f56492e.findViewById(R.id.media_controller);
        this.x = videoMiddleNiaiControllerView;
        videoMiddleNiaiControllerView.setPlayer(this.p);
        this.x.setLoading(true);
        this.m.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.f56493f.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.p.setOnCompletionListener(new CyberPlayerManager.OnCompletionListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdVideoFlowView f56498e;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f56498e = this;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f56498e.Q = 3;
                    this.f56498e.t(34, -1);
                    if (this.f56498e.M != null) {
                        this.f56498e.M.e();
                    }
                }
            }
        });
    }

    private int getVideoControllerStyle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            int i2 = this.H;
            return (i2 == 3 || i2 == 4) ? 1 : 0;
        }
        return invokeV.intValue;
    }

    public final void l(boolean z) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (videoMiddleNiaiControllerView = this.x) == null) {
            return;
        }
        videoMiddleNiaiControllerView.setBottomBarShow(z, getVideoControllerStyle());
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f56492e == null || this.K) {
            return;
        }
        this.K = true;
        TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.f56492e.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.D.getResources().getDimensionPixelOffset(R.dimen.tbds396), this.D.getResources().getDimensionPixelOffset(R.dimen.tbds396));
        layoutParams.addRule(13);
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_big_photo);
        View view = this.f56492e;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(tBLottieAnimationView, layoutParams);
        }
        tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener(this, tBLottieAnimationView) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TBLottieAnimationView f56503e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ AdVideoFlowView f56504f;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, tBLottieAnimationView};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56504f = this;
                this.f56503e = tBLottieAnimationView;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    if (this.f56504f.f56492e instanceof RelativeLayout) {
                        ((RelativeLayout) this.f56504f.f56492e).removeView(this.f56503e);
                    }
                    this.f56504f.K = false;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                }
            }
        });
        tBLottieAnimationView.playAnimation();
    }

    public final void n() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) {
            String str = this.F.scheme;
            if (z.B(this.E, str)) {
                i2 = 3;
            } else {
                i2 = z.e(this.D, str, this.E.Q4() ? this.F.getDownloadId() : this.F.adId, this.F.getExtInfo());
            }
            if (i2 == 0) {
                return;
            }
            if (z.p(i2)) {
                d.e(this.E, i2);
            } else {
                d.m(this.E);
            }
            c.a.r0.p1.o.h.c.h(c.a.r0.p1.o.h.c.e(this.E));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            new w(this.E, this.F.closeInfo, this.D.getPageActivity(), getRootView(), 80, PlaceId.VIDEO_FLOW).q();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            g gVar = this.M;
            if (gVar instanceof a) {
                ((a) gVar).x();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (view.getId() == R.id.like_container) {
                p();
            } else if (view.getId() == R.id.share_container) {
                q();
            } else if (view.getId() == R.id.back_btn) {
                TbPageContext<BaseFragmentActivity> tbPageContext = this.D;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return;
                }
                this.D.getPageActivity().finish();
            } else if (view.getId() == R.id.video_view) {
                r();
            } else if (view.getId() == R.id.enhance_area_container || view.getId() == R.id.ad_content || view.getId() == R.id.user_head_img || view.getId() == R.id.user_name) {
                n();
            }
        }
    }

    @Override // c.a.r0.y2.m
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.R = 0;
            stopPlay();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDetachedFromWindow();
            g gVar = this.M;
            if (gVar instanceof a) {
                ((a) gVar).C();
            }
        }
    }

    public void onPageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                this.V = true;
                j jVar = new j(10000L, 1000L);
                this.P = jVar;
                jVar.q(new j.b(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ AdVideoFlowView f56505a;

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
                        this.f56505a = this;
                    }

                    @Override // c.a.q0.d1.j.b
                    public void onCountDown(long j2, long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                            this.f56505a.w.update((int) (j2 - j3));
                        }
                    }

                    @Override // c.a.q0.d1.j.b
                    public void onCountDownFinish(long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        }
                    }
                });
                this.P.r();
                this.w.update(0);
                return;
            }
            j jVar2 = this.P;
            if (jVar2 != null) {
                jVar2.s();
            }
            this.w.resetAnim();
            this.w.bindData(this.E);
            this.p.stopPlayback();
            this.p.seekTo(0);
        }
    }

    @Override // c.a.r0.y2.m
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            s();
            t(34, 1);
        }
    }

    @Override // c.a.r0.y2.m
    public void onPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.I = true;
            this.R = 0;
            if (z && this.W) {
                startPlay();
                return;
            }
            s();
            t(34, 1);
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onStatusChange(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING && (videoMiddleNiaiControllerView3 = this.x) != null) {
                videoMiddleNiaiControllerView3.setLoading(false);
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView2 = this.x) != null) {
                videoMiddleNiaiControllerView2.setLoading(false);
            }
            if (videoStatus != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || (videoMiddleNiaiControllerView = this.x) == null) {
                return;
            }
            videoMiddleNiaiControllerView.setLoading(true);
        }
    }

    @Override // c.a.r0.y2.m
    public void onUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.R = 0;
            this.W = z;
            if (this.I) {
                if (z) {
                    startPlay();
                    return;
                }
                s();
                t(34, 1);
            }
        }
    }

    @Override // c.a.r0.y2.m
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    @Override // c.a.r0.y2.m
    public void onViewDoubleClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // c.a.r0.y2.m
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public final void p() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (videoItemModel = this.J) == null || videoItemModel.getVideoItemData() == null) {
            return;
        }
        VideoItemData videoItemData = this.J.getVideoItemData();
        String str = TextUtils.equals(videoItemData.is_agreed, "1") ? "0" : "1";
        videoItemData.is_agreed = str;
        if (TextUtils.equals(str, "1")) {
            m();
        }
        int i2 = TextUtils.equals(videoItemData.is_agreed, "1") ? 1 : -1;
        this.f56497j.setImageDrawable(TextUtils.equals(videoItemData.is_agreed, "1") ? this.z : this.A);
        this.f56494g.setText(String.valueOf(b.e(String.valueOf(this.f56494g.getText()), 0) + i2));
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.F.getTitle();
            shareItem.D = this.F.getTitle();
            shareItem.t = this.F.getShareLink();
            shareItem.F = 3;
            shareItem.f48110f = true;
            String imageUrl = this.F.getImageUrl();
            Uri parse = imageUrl == null ? null : Uri.parse(imageUrl);
            if (parse != null) {
                shareItem.v = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.D.getPageActivity(), shareItem, true, true);
            shareDialogConfig.showDisLike = true;
            shareDialogConfig.disLikeListener = new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdVideoFlowView f56500e;

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
                    this.f56500e = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f56500e.o();
                    }
                }
            };
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            c.a.r0.e0.f.b().k(shareDialogConfig);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.R = 1;
            if (this.p.isPlaying()) {
                s();
                t(32, 0);
                this.q.setVisibility(0);
                return;
            }
            startPlay();
            this.q.setVisibility(8);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TbCyberVideoView tbCyberVideoView = this.p;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.pause();
            }
            l(false);
            this.Q = 2;
        }
    }

    public void setData(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, advertAppInfo) == null) || advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.e4;
        if (iLegoAdvert instanceof AdCard) {
            this.E = advertAppInfo;
            AdCard adCard = (AdCard) iLegoAdvert;
            this.F = adCard;
            if (adCard.videoInfo == null) {
                return;
            }
            this.r.startLoad(adCard.userImage, 30, false);
            this.s.setText(this.F.userName);
            this.t.setText(this.F.threadTitle);
            String str = this.F.videoInfo.video_url;
            this.G = str;
            this.p.setVideoPath(str);
            this.w.bindData(advertAppInfo);
            u();
        }
    }

    @Override // c.a.r0.y2.m
    public void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{drawable, drawable2, drawable3, drawable4, drawable5, drawable6}) == null) {
            this.y = drawable;
            this.z = drawable3;
            this.A = drawable4;
            this.B = drawable5;
            this.C = drawable6;
        }
    }

    @Override // c.a.r0.y2.m
    public void setPageChangeHandler(c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, aVar, i2) == null) {
            this.S = aVar;
            this.T = i2;
        }
    }

    public void setPageContext(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, tbPageContext) == null) {
            this.D = tbPageContext;
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            g gVar = this.M;
            if (gVar != null) {
                gVar.f();
            }
            l(true);
            if (this.p != null) {
                if (TbVideoViewSet.d().e(this.G) == null || TbVideoViewSet.d().e(this.G) != this.p) {
                    this.p.setVideoPath(this.G);
                }
                if (this.Q == -1) {
                    this.p.start(null);
                    t(31, -1);
                    this.x.resetProgress();
                    if (!this.V) {
                        onPageSelected(true);
                    }
                } else {
                    this.p.resumePlay(null);
                    if (this.Q != 3) {
                        t(33, -1);
                    }
                }
                this.U.postDelayed(new Runnable(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ AdVideoFlowView f56499e;

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
                        this.f56499e = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f56499e.x.showProgress();
                        }
                    }
                }, 200L);
                this.Q = 1;
            }
        }
    }

    public final void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            TbCyberVideoView tbCyberVideoView = this.p;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.stopPlayback();
            }
            this.Q = -1;
        }
    }

    public final void t(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) || this.E == null || this.F.videoInfo == null) {
            return;
        }
        e.b().d(c.a.r0.y2.l0.g.l(this.E, i2, 0, this.R, this.F.videoInfo.video_duration.intValue(), this.p.getCurrentPosition(), i3));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.O = this.F.tailFrame;
            if (this.N == null) {
                f fVar = new f(this.D.getPageActivity(), this.L);
                this.N = fVar;
                fVar.f29633a = 2;
            }
            g b2 = this.N.b(this.O, this.M);
            this.M = b2;
            if (b2 != null) {
                b2.j(this.D);
                this.M.i(this.F);
                g gVar = this.M;
                if (gVar instanceof a) {
                    ((a) gVar).z(true);
                }
                this.M.g(this.E);
                this.M.d(this.O);
                this.M.f();
                this.M.k(new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ AdVideoFlowView f56501e;

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
                        this.f56501e = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f56501e.startPlay();
                            this.f56501e.t(102, 1);
                        }
                    }
                });
                this.M.m(new CountDownTextView.c(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ AdVideoFlowView f56502e;

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
                        this.f56502e = this;
                    }

                    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
                    public void onTimeout(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f56502e.S != null) {
                                this.f56502e.S.a(this.f56502e.T);
                            }
                            this.f56502e.M.f();
                        }
                    }
                });
            }
        }
    }

    @Override // c.a.r0.y2.m
    public void updateTiebaData(int i2, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048604, this, i2, videoItemModel) == null) {
            this.H = i2;
            this.J = videoItemModel;
            v();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.x.initProgressUIType(getVideoControllerStyle());
            this.q.setImageDrawable(this.y);
            this.f56493f.setVisibility(8);
            this.f56495h.setTextColor(c.a.r0.j3.c.a(SkinManager.getColor(R.color.CAM_X0104), c.a.q0.s.u.a.a(R.string.A_X03)));
            this.k.setImageDrawable(this.B);
            this.l.setImageDrawable(this.C);
            Drawable drawable = this.A;
            VideoItemModel videoItemModel = this.J;
            if (videoItemModel != null && videoItemModel.getVideoItemData() != null) {
                drawable = TextUtils.equals(this.J.getVideoItemData().is_agreed, "1") ? this.z : this.A;
            }
            this.f56497j.setImageDrawable(drawable);
            c.a.r0.y2.i0.b.e eVar = this.F.threadInfo;
            int i2 = eVar.f29501a;
            VideoItemData videoItemData = this.J.getVideoItemData();
            if (videoItemData != null) {
                i2 = TextUtils.equals(videoItemData.is_agreed, "1") ? eVar.f29501a + 1 : eVar.f29501a;
            }
            this.f56494g.setText(String.valueOf(i2));
            this.f56495h.setText(String.valueOf(eVar.f29503c));
            this.f56496i.setText(String.valueOf(eVar.f29502b));
        }
    }
}
