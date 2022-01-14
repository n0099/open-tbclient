package com.baidu.tieba.recapp.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.m.b;
import c.a.s0.e1.o;
import c.a.s0.s.q.e2;
import c.a.t0.j3.e0.c;
import c.a.t0.j3.i0.b.e;
import c.a.t0.j3.l0.d;
import c.a.t0.j3.m;
import c.a.t0.j3.m0.f;
import c.a.t0.j3.m0.g;
import c.a.t0.j3.w;
import c.a.t0.j3.z;
import c.a.t0.k0.h;
import c.a.t0.z2.r;
import c.a.t0.z2.t;
import c.a.t0.z2.v.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.TbVideoViewContainer;
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
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes12.dex */
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
    public c.a.t0.j3.i0.b.g O;
    public o P;
    public int Q;
    public int R;
    public c.a S;
    public int T;
    public Handler U;
    public boolean V;
    public boolean W;
    public ObjectAnimator a0;
    public ObjectAnimator b0;

    /* renamed from: e  reason: collision with root package name */
    public View f47655e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f47656f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f47657g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f47658h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f47659i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f47660j;
    public ImageView k;
    public ImageView l;
    public LinearLayout m;
    public LinearLayout n;
    public LinearLayout o;
    public TbVideoViewContainer p;
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
        this.a0 = null;
        this.b0 = null;
        this.U = new Handler();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ad_video_flow, this);
        this.f47655e = inflate;
        this.f47656f = (ImageView) inflate.findViewById(R.id.back_btn);
        this.q = (ImageView) this.f47655e.findViewById(R.id.play_btn);
        this.f47657g = (TextView) this.f47655e.findViewById(R.id.like_text);
        this.f47659i = (TextView) this.f47655e.findViewById(R.id.share_text);
        this.f47658h = (TextView) this.f47655e.findViewById(R.id.comment_text);
        this.f47660j = (ImageView) this.f47655e.findViewById(R.id.like_img);
        this.l = (ImageView) this.f47655e.findViewById(R.id.share_img);
        this.k = (ImageView) this.f47655e.findViewById(R.id.comment_img);
        this.m = (LinearLayout) this.f47655e.findViewById(R.id.like_container);
        this.o = (LinearLayout) this.f47655e.findViewById(R.id.share_container);
        this.n = (LinearLayout) this.f47655e.findViewById(R.id.comment_container);
        this.r = (TbImageView) this.f47655e.findViewById(R.id.user_head_img);
        this.s = (TextView) this.f47655e.findViewById(R.id.user_name);
        this.t = (AdTagTextView) this.f47655e.findViewById(R.id.ad_content);
        this.u = (FrameLayout) this.f47655e.findViewById(R.id.enhance_area_container);
        this.v = (FrameLayout) this.f47655e.findViewById(R.id.enhance_area_placeholder);
        this.L = (ViewGroup) this.f47655e.findViewById(R.id.tail_frame_container);
        TbVideoViewContainer tbVideoViewContainer = (TbVideoViewContainer) this.f47655e.findViewById(R.id.video_view);
        this.p = tbVideoViewContainer;
        tbVideoViewContainer.getControl().setStageType("23");
        this.p.getControl().setContinuePlayEnable(true);
        this.p.getControl().setVideoStatusChangeListener(this);
        this.w = new AdEnhanceButtonView(context, this.u, this.v);
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = (VideoMiddleNiaiControllerView) this.f47655e.findViewById(R.id.media_controller);
        this.x = videoMiddleNiaiControllerView;
        videoMiddleNiaiControllerView.setPlayer(this.p.getControl());
        this.x.setLoading(true);
        this.m.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.p.setOnClickListener(this);
        this.f47656f.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.p.getControl().setOperableVideoContainer(new a(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ AdVideoFlowView f47661e;

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
                this.f47661e = this;
            }

            @Override // c.a.t0.z2.v.a
            public void changeRenderViewMode(int i4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i4) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public int getCurrentPosition() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return 0;
                }
                return invokeV.intValue;
            }

            @Override // c.a.t0.z2.v.a
            public View getMainView() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return null;
                }
                return (View) invokeV.objValue;
            }

            @Override // c.a.t0.z2.v.a
            public boolean isFullScreen() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // c.a.t0.z2.v.a
            public boolean isPlaying() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // c.a.t0.z2.v.a
            public boolean onBackPress() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // c.a.t0.z2.v.a
            public boolean onBackground(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeZ = interceptable2.invokeZ(1048582, this, z)) == null) {
                    return false;
                }
                return invokeZ.booleanValue;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048583, this, view) == null) {
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
            public void onCompletion() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                    this.f47661e.Q = 3;
                    this.f47661e.x(34, -1);
                    if (this.f47661e.M != null) {
                        this.f47661e.M.e();
                    }
                }
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
            public boolean onError(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048585, this, i4, i5, obj)) == null) {
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
            public boolean onInfo(int i4, int i5, Object obj) {
                InterceptResult invokeIIL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeIIL = interceptable2.invokeIIL(1048586, this, i4, i5, obj)) == null) {
                    return false;
                }
                return invokeIIL.booleanValue;
            }

            @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
            public void onPrepared() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048587, this) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
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

            @Override // c.a.t0.z2.v.a
            public boolean onVolumeUp() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048592, this)) == null) {
                    return false;
                }
                return invokeV.booleanValue;
            }

            @Override // c.a.t0.z2.v.a
            public void setAfterClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048593, this, onClickListener) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void setData(e2 e2Var) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048594, this, e2Var) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void setFrom(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048595, this, str) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048596, this, onClickListener) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void setStageType(String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048597, this, str) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void setStatistic(t tVar) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048598, this, tVar) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void setUniqueId(BdUniqueId bdUniqueId) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048599, this, bdUniqueId) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void startPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048600, this) == null) {
                }
            }

            @Override // c.a.t0.z2.v.a
            public void stopPlay() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048601, this) == null) {
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

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.x.initProgressUIType(getVideoControllerStyle());
            this.q.setImageDrawable(this.y);
            this.f47656f.setVisibility(8);
            this.f47658h.setTextColor(c.a.t0.w3.c.a(SkinManager.getColor(R.color.CAM_X0104), c.a.s0.s.u.a.a(R.string.A_X03)));
            this.k.setImageDrawable(this.B);
            this.l.setImageDrawable(this.C);
            Drawable drawable = this.A;
            VideoItemModel videoItemModel = this.J;
            if (videoItemModel != null && videoItemModel.getVideoItemData() != null) {
                drawable = TextUtils.equals(this.J.getVideoItemData().is_agreed, "1") ? this.z : this.A;
            }
            this.f47660j.setImageDrawable(drawable);
            e eVar = this.F.threadInfo;
            int i2 = eVar.a;
            VideoItemData videoItemData = this.J.getVideoItemData();
            if (videoItemData != null) {
                i2 = TextUtils.equals(videoItemData.is_agreed, "1") ? eVar.a + 1 : eVar.a;
            }
            this.f47657g.setText(String.valueOf(i2));
            this.f47658h.setText(String.valueOf(eVar.f18404c));
            this.f47659i.setText(String.valueOf(eVar.f18403b));
        }
    }

    public final void o(boolean z) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) || (videoMiddleNiaiControllerView = this.x) == null) {
            return;
        }
        videoMiddleNiaiControllerView.setBottomBarShow(z, getVideoControllerStyle());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAttachedToWindow();
            g gVar = this.M;
            if (gVar instanceof c.a.t0.j3.m0.a) {
                ((c.a.t0.j3.m0.a) gVar).x();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            if (view.getId() == R.id.like_container) {
                t();
            } else if (view.getId() == R.id.share_container) {
                u();
            } else if (view.getId() == R.id.back_btn) {
                TbPageContext<BaseFragmentActivity> tbPageContext = this.D;
                if (tbPageContext == null || tbPageContext.getPageActivity() == null) {
                    return;
                }
                this.D.getPageActivity().finish();
            } else if (view.getId() == R.id.video_view) {
                v();
            } else if (view.getId() == R.id.enhance_area_container || view.getId() == R.id.ad_content || view.getId() == R.id.user_head_img || view.getId() == R.id.user_name) {
                r();
            }
        }
    }

    @Override // c.a.t0.j3.m
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.R = 0;
            stopPlay();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            g gVar = this.M;
            if (gVar instanceof c.a.t0.j3.m0.a) {
                ((c.a.t0.j3.m0.a) gVar).C();
            }
        }
    }

    public void onPageSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            if (z) {
                this.V = true;
                o oVar = new o(10000L, 1000L);
                this.P = oVar;
                oVar.q(new o.b(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AdVideoFlowView a;

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

                    @Override // c.a.s0.e1.o.b
                    public void onCountDown(long j2, long j3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
                            this.a.w.update((int) (j2 - j3));
                        }
                    }

                    @Override // c.a.s0.e1.o.b
                    public void onCountDownFinish(long j2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                        }
                    }
                });
                this.P.r();
                this.w.update(0);
                return;
            }
            o oVar2 = this.P;
            if (oVar2 != null) {
                oVar2.s();
            }
            this.w.resetAnim();
            this.w.bindData(this.E);
            this.p.getControl().stopPlayback();
            this.p.getControl().seekTo(0);
        }
    }

    @Override // c.a.t0.j3.m
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            w();
            x(34, 1);
        }
    }

    @Override // c.a.t0.j3.m
    public void onPrimary(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.I = true;
            this.R = 0;
            if (z && this.W) {
                startPlay();
                return;
            }
            w();
            x(34, 1);
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onStatusChange(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, videoStatus) == null) {
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

    @Override // c.a.t0.j3.m
    public void onUserVisibleHint(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.R = 0;
            this.W = z;
            if (this.I) {
                if (z) {
                    startPlay();
                    return;
                }
                w();
                x(34, 1);
            }
        }
    }

    @Override // c.a.t0.j3.m
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
        }
    }

    @Override // c.a.t0.j3.m
    public void onViewDoubleClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
        }
    }

    @Override // c.a.t0.j3.m
    public void onViewDragToRight() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f47655e == null || this.K) {
            return;
        }
        this.K = true;
        TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.f47655e.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.D.getResources().getDimensionPixelOffset(R.dimen.tbds396), this.D.getResources().getDimensionPixelOffset(R.dimen.tbds396));
        layoutParams.addRule(13);
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.lottie_agree_big_photo);
        View view = this.f47655e;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(tBLottieAnimationView, layoutParams);
        }
        tBLottieAnimationView.addAnimatorListener(new Animator.AnimatorListener(this, tBLottieAnimationView) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ TBLottieAnimationView f47666e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ AdVideoFlowView f47667f;

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
                this.f47667f = this;
                this.f47666e = tBLottieAnimationView;
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
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    if (this.f47667f.f47655e instanceof RelativeLayout) {
                        ((RelativeLayout) this.f47667f.f47655e).removeView(this.f47666e);
                    }
                    this.f47667f.K = false;
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
        });
        tBLottieAnimationView.playAnimation();
    }

    public final ObjectAnimator q(float f2, float f3, float f4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.q, PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f3), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f4));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void r() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            String str = this.F.scheme;
            if (z.C(this.E, str)) {
                i2 = 3;
            } else {
                i2 = z.e(this.D, str, this.E.V4() ? this.F.getDownloadId() : this.F.adId, this.F.getExtInfo(), this.F.cmdScheme);
            }
            if (i2 == 0) {
                return;
            }
            if (z.q(i2)) {
                d.f(this.E, i2);
            } else {
                d.n(this.E);
            }
            c.a.t0.x1.o.h.c.h(c.a.t0.x1.o.h.c.e(this.E));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            new w(this.E, this.F.closeInfo, this.D.getPageActivity(), getRootView(), 80, PlaceId.VIDEO_FLOW).q();
        }
    }

    public void setData(@NonNull AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, advertAppInfo) == null) || advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.n4;
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
            r rVar = new r();
            rVar.f26069e = "ad_feed";
            rVar.f26068d = rVar.a("ad_feed");
            rVar.f26070f = rVar.c("1");
            this.p.getControl().setVideoModel(rVar);
            this.G = this.F.videoInfo.video_url;
            this.p.getControl().setVideoPath(this.G);
            this.w.bindData(advertAppInfo);
            z();
        }
    }

    @Override // c.a.t0.j3.m
    public void setDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{drawable, drawable2, drawable3, drawable4, drawable5, drawable6}) == null) {
            this.y = drawable;
            this.z = drawable3;
            this.A = drawable4;
            this.B = drawable5;
            this.C = drawable6;
        }
    }

    @Override // c.a.t0.j3.m
    public void setPageChangeHandler(c.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, aVar, i2) == null) {
            this.S = aVar;
            this.T = i2;
        }
    }

    public void setPageContext(TbPageContext<BaseFragmentActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContext) == null) {
            this.D = tbPageContext;
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            g gVar = this.M;
            if (gVar != null) {
                gVar.f();
            }
            o(true);
            TbVideoViewContainer tbVideoViewContainer = this.p;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null) {
                return;
            }
            if (TbVideoViewSet.d().e(this.G) == null || TbVideoViewSet.d().e(this.G) != this.p) {
                r rVar = new r();
                rVar.f26069e = "ad_feed";
                rVar.f26068d = rVar.a("ad_feed");
                rVar.f26070f = rVar.c("1");
                this.p.getControl().setVideoModel(rVar);
                this.p.getControl().setVideoPath(this.G);
            }
            if (this.Q == -1) {
                this.p.getControl().start(null);
                x(31, -1);
                this.x.resetProgress();
                if (!this.V) {
                    onPageSelected(true);
                }
            } else {
                this.p.getControl().resumePlay(null);
                if (this.Q != 3) {
                    x(33, -1);
                }
            }
            this.U.postDelayed(new Runnable(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdVideoFlowView f47662e;

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
                    this.f47662e = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f47662e.x.showProgress();
                    }
                }
            }, 200L);
            this.Q = 1;
        }
    }

    public final void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            y();
            TbVideoViewContainer tbVideoViewContainer = this.p;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.p.getControl().stopPlayback();
            }
            this.Q = -1;
        }
    }

    public final void t() {
        VideoItemModel videoItemModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (videoItemModel = this.J) == null || videoItemModel.getVideoItemData() == null) {
            return;
        }
        VideoItemData videoItemData = this.J.getVideoItemData();
        String str = TextUtils.equals(videoItemData.is_agreed, "1") ? "0" : "1";
        videoItemData.is_agreed = str;
        if (TextUtils.equals(str, "1")) {
            p();
        }
        int i2 = TextUtils.equals(videoItemData.is_agreed, "1") ? 1 : -1;
        this.f47660j.setImageDrawable(TextUtils.equals(videoItemData.is_agreed, "1") ? this.z : this.A);
        this.f47657g.setText(String.valueOf(b.e(String.valueOf(this.f47657g.getText()), 0) + i2));
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ShareItem shareItem = new ShareItem();
            shareItem.r = this.F.getTitle();
            shareItem.D = this.F.getTitle();
            shareItem.t = this.F.getShareLink();
            shareItem.F = 3;
            shareItem.f40766f = true;
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
                public final /* synthetic */ AdVideoFlowView f47663e;

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
                    this.f47663e = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f47663e.s();
                    }
                }
            };
            shareDialogConfig.setIsAlaLive(false);
            shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
            h.c().l(shareDialogConfig);
        }
    }

    @Override // c.a.t0.j3.m
    public void updateTiebaData(int i2, VideoItemModel videoItemModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048602, this, i2, videoItemModel) == null) {
            this.H = i2;
            this.J = videoItemModel;
            A();
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.R = 1;
            if (this.p.getControl().isPlaying()) {
                w();
                x(32, 0);
                y();
                return;
            }
            startPlay();
            this.q.setVisibility(8);
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            y();
            TbVideoViewContainer tbVideoViewContainer = this.p;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.p.getControl().pause();
            }
            o(false);
            this.Q = 2;
        }
    }

    public final void x(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048605, this, i2, i3) == null) || this.E == null || this.F.videoInfo == null) {
            return;
        }
        c.a.t0.j3.l0.e.b().d(c.a.t0.j3.l0.g.l(this.E, i2, 0, this.R, this.F.videoInfo.video_duration.intValue(), this.p.getControl().getCurrentPosition(), i3));
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.a0 == null) {
                this.a0 = q(0.0f, 3.0f, 3.0f, 0L);
            }
            this.a0.addListener(new Animator.AnimatorListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ AdVideoFlowView f47668e;

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
                    this.f47668e = this;
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
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        if (this.f47668e.b0 == null) {
                            AdVideoFlowView adVideoFlowView = this.f47668e;
                            adVideoFlowView.b0 = adVideoFlowView.q(1.0f, 1.0f, 1.0f, 100L);
                        }
                        this.f47668e.b0.start();
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
            });
            this.a0.start();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.O = this.F.tailFrame;
            if (this.N == null) {
                f fVar = new f(this.D.getPageActivity(), this.L);
                this.N = fVar;
                fVar.a = 2;
            }
            g b2 = this.N.b(this.O, this.M);
            this.M = b2;
            if (b2 != null) {
                b2.j(this.D);
                this.M.i(this.F);
                g gVar = this.M;
                if (gVar instanceof c.a.t0.j3.m0.a) {
                    ((c.a.t0.j3.m0.a) gVar).z(true);
                }
                this.M.g(this.E);
                this.M.d(this.O);
                this.M.f();
                this.M.k(new View.OnClickListener(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ AdVideoFlowView f47664e;

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
                        this.f47664e = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            this.f47664e.startPlay();
                            this.f47664e.x(102, 1);
                        }
                    }
                });
                this.M.m(new CountDownTextView.c(this) { // from class: com.baidu.tieba.recapp.view.AdVideoFlowView.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ AdVideoFlowView f47665e;

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
                        this.f47665e = this;
                    }

                    @Override // com.baidu.tieba.recapp.widget.CountDownTextView.c
                    public void onTimeout(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f47665e.S != null) {
                                this.f47665e.S.a(this.f47665e.T);
                            }
                            this.f47665e.M.f();
                        }
                    }
                });
            }
        }
    }
}
