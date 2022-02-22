package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.util.Pair;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.f1.r.b;
import c.a.t0.i.a;
import c.a.t0.s.r.e2;
import c.a.t0.s.t.a;
import c.a.t0.s.t.j;
import c.a.u0.b3.h;
import c.a.u0.p4.m.c;
import c.a.u0.p4.o.a;
import c.a.u0.p4.o.b;
import c.a.u0.p4.t.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.module.pb.BarManageResultListener;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.util.SimpleMessageListener;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.stampmission.mission.StampMission;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.danmu.DanmuPostDraftManager;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
import tbclient.VideoInfo;
/* loaded from: classes13.dex */
public class VideoPlayFragment extends BaseFragment implements b.InterfaceC0867b, c.a.u0.p4.s.b.a, TbCyberVideoView.g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COVER_ANIMINATION_TIME = 350;
    public static final int COVER_TRANSFER_TIME = 200;
    public static final int DEFAULT_OVER_DURATION_LIMIT_TIME = 15000;
    public static final int DRAG_HIDE_SEEKBAR_TIME = 3000;
    public static final int TYPE_OFFICAL_VIDEO = 14;
    public static final int TYPE_PB_VIDOE_SCHEMA = 9;
    public static final int TYPE_VIDEO_AGREE_PAGE = 11;
    public static final int TYPE_VIDEO_AT_PAGE = 10;
    public static final int TYPE_VIDEO_CHANNEL_ATTENTION = 4;
    public static final int TYPE_VIDEO_CHANNEL_RECOMMENT = 3;
    public static final int TYPE_VIDEO_CREATE_CENTER = 18;
    public static final int TYPE_VIDEO_FROM_FRS_VIDEO_TAB_PAGE = 7;
    public static final int TYPE_VIDEO_FROM_PERSONAL_PAGE = 6;
    public static final int TYPE_VIDEO_FROM_VIDEO_HOT_TOPIC = 8;
    public static final int TYPE_VIDEO_LINK = 13;
    public static final int TYPE_VIDEO_MIDDLE_ATTENTION = 2;
    public static final int TYPE_VIDEO_MIDDLE_RECOMMENT = 1;
    public static final int TYPE_VIDEO_RECOMMENT_PLAY = 5;
    public static final int TYPE_VIDEO_REPLY_PAGE = 12;
    public static final int TYPE_VIDEO_WORK_MANAGEMENT = 19;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public RelativeLayout A0;
    public TBSpecificationBtn B;
    public boolean B0;
    public TextView C;
    public TiePlusEventController C0;
    public View D;
    public boolean D0;
    public LinearLayout E;
    public c.a.t0.f1.p.b E0;
    public VideoItemModel F;
    public boolean F0;
    public TextView G;
    public View G0;
    public VideoMiddleNiaiControllerView H;
    public View H0;
    public boolean I;
    public ObjectAnimator I0;
    public AlphaAnimation J;
    public ObjectAnimator J0;
    public Rect K;
    public c.a.u0.h4.a K0;
    public boolean L;
    public final Runnable L0;
    public View M;
    public final TbVideoViewSet.b M0;
    public TextView N;
    public final CustomMessageListener N0;
    public RelativeLayout.LayoutParams O;
    public final CustomMessageListener O0;
    public int P;
    public final CustomMessageListener P0;
    public int Q;
    public final CustomMessageListener Q0;
    public int R;
    public final CustomMessageListener R0;
    public int S;
    public final CustomMessageListener S0;
    public boolean T;
    public final CustomMessageListener T0;
    public int U;
    public final CustomMessageListener U0;
    public String V;
    public final CustomMessageListener V0;
    public String W;
    @NonNull
    public final BarManageResultListener W0;
    public String X;
    public final CustomMessageListener X0;
    public PopupDialog Y;
    public final VideoDanmuController.b Y0;
    public c.a.t0.s.t.j Z;
    public View.OnClickListener Z0;
    public ForumManageModel a0;
    public View.OnClickListener a1;
    public RelativeLayout agreeContainer;
    public HeadImageView author_portrait;
    public c.a.t0.i.a b0;
    public j.d b1;
    public c.a.t0.t.e.a c0;
    public j.d c1;
    public Animation clickAnimation;
    public LinearLayout commentContainer;
    public BdUniqueId d0;
    public j.d d1;
    public EMTextView dragCurTime;
    public EMTextView dragTotalTime;

    /* renamed from: e  reason: collision with root package name */
    public int f48930e;
    public String e0;
    public j.d e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48931f;
    public RelativeLayout.LayoutParams f0;
    public Runnable f1;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f48932g;
    public TbCyberVideoView.VideoStatus g0;
    public c.a.u0.b3.v.a g1;

    /* renamed from: h  reason: collision with root package name */
    public int f48933h;
    public String h0;
    public CustomMessageListener h1;

    /* renamed from: i  reason: collision with root package name */
    public int f48934i;
    public boolean i0;
    public CustomMessageListener i1;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f48935j;
    public TbVideoViewContainer k;
    public boolean k0;
    public VideoDanmuController l;
    public c.a.u0.p4.m.c m;
    public ImageView mAgreeImg;
    public EMTextView mAgreeNum;
    public TBLottieAnimationView mAttentionLottieView;
    public TextView mAuthorNameTv;
    public ImageView mBackBtn;
    public LinearLayout mBottomContainer;
    public ImageView mCommentImg;
    public EMTextView mCommentNum;
    public LinearLayout mDragContainer;
    public TBLottieAnimationView mLiveLottieView;
    public ImageView mMoreBtn;
    public View mPortraitContainer;
    public View mRootView;
    public ImageView mShareImg;
    public EMTextView mShareNum;
    public VideoItemData mVideoData;
    public View mfullScreenView;
    public TbImageView n;
    public View o;
    public boolean p;
    public ImageView play_btn;
    public LinearLayout q;
    public boolean q0;
    public TextView r;
    public int r0;
    public ImageView s;
    public int s0;
    public LinearLayout shareContainer;
    public ImageView share_icon;
    public ImageView share_icon_changed;
    public LinearLayout t;
    public c.a.u0.p4.r.a t0;
    public BarImageView u;
    public c.a.u0.p4.o.a u0;
    public ImageView v;
    public h.c v0;
    public LinearLayout videoActivityContainer;
    public ImageView videoLoadingIcon;
    public RelativeLayout videoLoadingLayout;
    public LinearLayout video_private;
    public ExpandableTextView video_title;
    public TextView w;
    public m1 w0;
    public TextView x;
    public c.a.u0.p4.t.a x0;
    public View y;
    public c.a.u0.p4.j y0;
    public View z;
    public AlertDialog z0;

    /* loaded from: classes13.dex */
    public static class GoPbCommentFloatListener extends SimpleMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoPbCommentFloatListener(@NonNull SimpleMessageListener.b<Void> bVar) {
            super(2001457, true, bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (SimpleMessageListener.b) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static void sendMessage() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                SimpleMessageListener.sendMessage(2001457, null);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.k0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.f48932g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.a.k0) {
                this.a.k0 = false;
                this.a.l.Z();
                if (this.a.l != null && this.a.J1()) {
                    this.a.l.U();
                }
                this.a.x0.U(true);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48936e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48937f;

        /* loaded from: classes13.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a0 f48938e;

            public a(a0 a0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48938e = a0Var;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f48938e.f48937f.mRootView.setBackground(SkinManager.getColorDrawableWithClickState(c.a.u0.p4.c.CAM_X0611));
                    this.f48938e.f48937f.A0.setBackground(null);
                    this.f48938e.f48937f.A0.setVisibility(8);
                    this.f48938e.f48937f.L = true;
                    if (this.f48938e.f48937f.O != null) {
                        this.f48938e.f48937f.O.addRule(14);
                    }
                    this.f48938e.f48937f.V1(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.f48938e.f48937f.mRootView.setBackground(null);
                    super.onAnimationStart(animator);
                    this.f48938e.f48937f.A0.setVisibility(0);
                    this.f48938e.f48937f.A0.setBackground(SkinManager.getColorDrawableWithClickState(c.a.u0.p4.c.CAM_X0611));
                }
            }
        }

        public a0(VideoPlayFragment videoPlayFragment, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48937f = videoPlayFragment;
            this.f48936e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams o1 = this.f48937f.o1();
                VideoPlayFragment videoPlayFragment = this.f48937f;
                videoPlayFragment.w1(videoPlayFragment.k, this.f48937f.n, this.f48937f.A0, this.f48937f.R, o1.leftMargin, this.f48937f.S, o1.topMargin, this.f48937f.P, o1.width, this.f48937f.Q, o1.height, this.f48937f.Q, this.f48936e, this.f48937f.S, 0, new a(this));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48939e;

        public a1(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48939e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48939e.f48935j.removeView(this.f48939e.k);
                this.f48939e.x0.R();
                VideoPlayFragment videoPlayFragment = this.f48939e;
                VideoItemData videoItemData = videoPlayFragment.mVideoData;
                if (videoItemData != null) {
                    videoPlayFragment.l2(videoItemData.thread_id, false);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes13.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f48940e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48940e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    if (this.f48940e.a.getActivity() != null) {
                        this.f48940e.a.getActivity().finish();
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.FALSE));
                    this.f48940e.a.U1(1.0f);
                    this.f48940e.a.mRootView.setBackground(null);
                    this.f48940e.a.A0.setVisibility(0);
                    this.f48940e.a.A0.setBackground(SkinManager.getColorDrawableWithClickState(c.a.u0.p4.c.CAM_X0611));
                    super.onAnimationStart(animator);
                    if (this.f48940e.a.O != null) {
                        this.f48940e.a.O.removeRule(14);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921612 || this.a.getPageContext() == null) {
                return;
            }
            Configuration configuration = this.a.getPageContext().getPageActivity().getResources().getConfiguration();
            if (configuration == null || configuration.orientation != 2) {
                int i2 = c.a.d.f.p.n.i(this.a.mRootView.getContext());
                if (this.a.isResumed() && this.a.I) {
                    if (this.a.f48930e != 1) {
                        if (this.a.f48930e == 7 && (videoItemData = (videoPlayFragment = this.a).mVideoData) != null && videoItemData.thread_id != null && videoPlayFragment.getActivity() != null && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                            VideoPlayFragment videoPlayFragment2 = this.a;
                            if (c.a.d.f.p.m.isEquals(videoPlayFragment2.mVideoData.thread_id, ((FrsVideoTabPlayActivity) videoPlayFragment2.getActivity()).getStartCardTid()) && ((FrsVideoTabPlayActivity) this.a.getActivity()).getStartCardRect() != null) {
                                VideoPlayFragment videoPlayFragment3 = this.a;
                                videoPlayFragment3.K = ((FrsVideoTabPlayActivity) videoPlayFragment3.getActivity()).getStartCardRect();
                            }
                        }
                    } else {
                        VideoPlayFragment videoPlayFragment4 = this.a;
                        VideoItemData videoItemData2 = videoPlayFragment4.mVideoData;
                        if (videoItemData2 != null && videoItemData2.thread_id != null && videoPlayFragment4.getActivity() != null && (this.a.getActivity() instanceof VideoPlayActivity)) {
                            VideoPlayFragment videoPlayFragment5 = this.a;
                            if (c.a.d.f.p.m.isEquals(videoPlayFragment5.mVideoData.thread_id, ((VideoPlayActivity) videoPlayFragment5.getActivity()).getStartCardTid()) && ((VideoPlayActivity) this.a.getActivity()).getStartCardRect() != null) {
                                VideoPlayFragment videoPlayFragment6 = this.a;
                                videoPlayFragment6.K = ((VideoPlayActivity) videoPlayFragment6.getActivity()).getStartCardRect();
                            }
                        }
                    }
                    if ((this.a.f48930e == 1 || this.a.f48930e == 7) && this.a.K != null) {
                        VideoPlayFragment videoPlayFragment7 = this.a;
                        videoPlayFragment7.P = videoPlayFragment7.K.right - this.a.K.left;
                        VideoPlayFragment videoPlayFragment8 = this.a;
                        videoPlayFragment8.Q = videoPlayFragment8.K.bottom - this.a.K.top;
                        VideoPlayFragment videoPlayFragment9 = this.a;
                        videoPlayFragment9.R = videoPlayFragment9.K.left;
                        VideoPlayFragment videoPlayFragment10 = this.a;
                        videoPlayFragment10.S = videoPlayFragment10.K.top;
                        if (c.a.t0.b.d.m()) {
                            VideoPlayFragment videoPlayFragment11 = this.a;
                            videoPlayFragment11.w1(videoPlayFragment11.k, this.a.n, this.a.A0, this.a.O.leftMargin, this.a.R, this.a.O.topMargin, this.a.S, this.a.O.width, this.a.P, this.a.O.height, this.a.Q, i2, this.a.Q, 0, this.a.S, new a(this));
                        }
                    } else if (this.a.getActivity() != null) {
                        this.a.getActivity().finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48941e;

        /* loaded from: classes13.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b0 f48942e;

            public a(b0 b0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48942e = b0Var;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f48942e.f48941e.L = true;
                    if (this.f48942e.f48941e.O != null) {
                        this.f48942e.f48941e.O.addRule(14);
                    }
                }
            }
        }

        public b0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48941e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams o1 = this.f48941e.o1();
                VideoPlayFragment videoPlayFragment = this.f48941e;
                videoPlayFragment.j2(videoPlayFragment.k, this.f48941e.n, this.f48941e.R, o1.leftMargin, this.f48941e.S, o1.topMargin, this.f48941e.P, o1.width, this.f48941e.Q, o1.height, new a(this));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b1 implements c.a.u0.b3.v.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48943e;

        public b1(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48943e = videoPlayFragment;
        }

        @Override // c.a.u0.b3.v.a
        public void changeRenderViewMode(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.u0.b3.v.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f48943e.k == null || this.f48943e.k.getControl() == null) {
                return;
            }
            this.f48943e.k.getControl().monitorAndStatsAtVerticalVideoReplay();
            this.f48943e.k.getControl().seekTo(0);
            if (!c.a.t0.b.d.e() || (this.f48943e.f48930e != 1 && this.f48943e.f48930e != 2)) {
                this.f48943e.k.getControl().start();
            } else if (this.f48943e.w0 == null || this.f48943e.k0) {
                this.f48943e.k.getControl().start();
            } else {
                this.f48943e.w0.a();
                this.f48943e.n.setVisibility(8);
                this.f48943e.k.getControl().start();
            }
            this.f48943e.P1();
            VideoPlayFragment.S0(this.f48943e);
            if (this.f48943e.r0 == 3) {
                this.f48943e.g1();
            }
            if (this.f48943e.k0) {
                return;
            }
            if (this.f48943e.isResumed() && this.f48943e.I) {
                return;
            }
            this.f48943e.L1();
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, obj)) == null) {
                if (this.f48943e.I && ((i2 == 3 || i2 == 904) && this.f48943e.n.getVisibility() == 0)) {
                    this.f48943e.n.clearAnimation();
                    this.f48943e.n.startAnimation(this.f48943e.J);
                }
                if (i2 != 10012 || this.f48943e.t0 == null) {
                    return true;
                }
                this.f48943e.t0.prefetch();
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.f48943e.k == null || this.f48943e.k.getControl() == null) {
                return;
            }
            if (this.f48943e.H != null) {
                this.f48943e.H.setVisibility(0);
                if (this.f48943e.H.getCurProgress() == 0) {
                    this.f48943e.H.showProgress();
                    return;
                }
                return;
            }
            this.f48943e.H.setVisibility(8);
        }

        @Override // c.a.u0.b3.v.a
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

        @Override // c.a.u0.b3.v.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.u0.b3.v.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setData(e2 e2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, e2Var) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setStatistic(c.a.u0.b3.t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, tVar) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.u0.b3.v.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements SimpleMessageListener.b<BarManageResultListener.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public c(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        public void call(@Nullable BarManageResultListener.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            e2 e2Var = this.a.mVideoData.threadData;
            if (e2Var != null && aVar.d()) {
                int i2 = h1.a[aVar.c().ordinal()];
                if (i2 == 1) {
                    e2Var.j4(true);
                } else if (i2 == 2) {
                    e2Var.j4(false);
                } else if (i2 == 3) {
                    e2Var.w3(true);
                } else if (i2 == 4) {
                    e2Var.w3(false);
                }
            }
            this.a.showToast(aVar.b());
        }
    }

    /* loaded from: classes13.dex */
    public class c0 implements c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public c0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.u0.p4.m.c.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.l == null || this.a.m == null) {
                return;
            }
            if (!z || !this.a.isResumed()) {
                this.a.l.R();
                this.a.l.H();
            } else {
                this.a.l.Z();
                if (this.a.k.getControl().isPlaying()) {
                    this.a.l.U();
                } else {
                    this.a.l.R();
                }
            }
            this.a.m.j(z);
        }
    }

    /* loaded from: classes13.dex */
    public class c1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48945f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48946g;

        public c1(VideoPlayFragment videoPlayFragment, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48946g = videoPlayFragment;
            this.f48944e = z;
            this.f48945f = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f48946g.z0 != null) {
                    this.f48946g.z0.dismiss();
                }
                if (c.a.d.f.p.l.A()) {
                    ForumManageModel forumManageModel = this.f48946g.a0;
                    VideoItemData videoItemData = this.f48946g.mVideoData;
                    forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.f48944e, null, this.f48945f);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    return;
                }
                c.a.d.f.p.n.M(this.f48946g.getContext(), c.a.u0.p4.i.neterror);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.I && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                boolean isEmotionClick = ((c.a.u0.p4.o.c) this.a.u0.a().findToolById(28)).g().isEmotionClick();
                if (booleanValue) {
                    this.a.b1(false);
                } else if (isEmotionClick) {
                    this.a.b1(true);
                } else {
                    this.a.v1();
                }
                ((c.a.u0.p4.o.c) this.a.u0.a().findToolById(28)).g().setEmotionClick(false);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d0 implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.u0.p4.t.a f48947b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48948c;

        public d0(VideoPlayFragment videoPlayFragment, VideoDanmuController videoDanmuController, c.a.u0.p4.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, videoDanmuController, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48948c = videoPlayFragment;
            this.a = videoDanmuController;
            this.f48947b = aVar;
        }

        @Override // c.a.u0.p4.t.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f48948c.startPlay();
                    VideoDanmuController videoDanmuController = this.a;
                    if (videoDanmuController != null) {
                        videoDanmuController.b0(this.f48947b.B0());
                        return;
                    }
                    return;
                }
                c.a.u0.p4.t.a aVar = this.f48947b;
                if (aVar != null) {
                    VideoDanmuController videoDanmuController2 = this.a;
                    if (videoDanmuController2 != null) {
                        aVar.G0(videoDanmuController2.F());
                    }
                    this.f48947b.startPlay();
                    VideoDanmuController videoDanmuController3 = this.a;
                    if (videoDanmuController3 != null) {
                        videoDanmuController3.R();
                        this.a.S();
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48949e;

        public d1(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48949e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48949e.z0 == null) {
                return;
            }
            this.f48949e.z0.dismiss();
        }
    }

    /* loaded from: classes13.dex */
    public class e implements VideoDanmuController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public e(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.videoplay.danmu.VideoDanmuController.b
        public boolean a(@Nullable PostData postData, @Nullable c.a.u0.u2.r.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, postData, fVar)) == null) {
                if (this.a.l != null) {
                    this.a.l.O("c14478");
                }
                if (postData != null) {
                    this.a.s1(postData.G());
                    MessageManager.getInstance().registerStickyMode(2921648);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921648, fVar));
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class e0 implements b.InterfaceC1308b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public e0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.u0.p4.o.b.InterfaceC1308b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.l == null) {
                return;
            }
            this.a.l.V(str);
        }
    }

    /* loaded from: classes13.dex */
    public class e1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            e2 e2Var;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.u0.z3.k0.l)) {
                c.a.u0.z3.k0.l lVar = (c.a.u0.z3.k0.l) customResponsedMessage.getData();
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData == null || (e2Var = videoItemData.threadData) == null || (str = e2Var.E) == null || !str.equals(lVar.a)) {
                    return;
                }
                this.a.mVideoData.threadData.Y3(lVar.f26220b ? 1 : 0);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class f implements VideoDanmuController.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes13.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e2 f48950e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f48951f;

            public a(f fVar, e2 e2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, e2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48951f = fVar;
                this.f48950e = e2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f48951f.a.mVideoData.parseProto(this.f48950e);
                    this.f48951f.a.mVideoData.reGenerateTitle();
                    VideoPlayFragment videoPlayFragment = this.f48951f.a;
                    videoPlayFragment.mVideoData.threadData = this.f48950e;
                    videoPlayFragment.setVideoBtnAndHeightWidth();
                    VideoItemData videoItemData = this.f48951f.a.mVideoData;
                    if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.f48951f.a;
                    videoPlayFragment2.a2(videoPlayFragment2.mVideoData, videoPlayFragment2.x0, this.f48951f.a.l);
                    VideoPlayFragment videoPlayFragment3 = this.f48951f.a;
                    videoPlayFragment3.b2(videoPlayFragment3.mVideoData.video_url);
                    if (this.f48951f.a.mVideoData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.f48951f.a.mVideoData.author_info.user_id)) {
                        this.f48951f.a.T = true;
                    }
                    this.f48951f.a.h1();
                    VideoPlayFragment videoPlayFragment4 = this.f48951f.a;
                    videoPlayFragment4.setUserVisibleHint(videoPlayFragment4.I);
                }
            }
        }

        public f(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.videoplay.danmu.VideoDanmuController.c
        public boolean a(@Nullable e2 e2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2Var)) == null) {
                c.a.d.f.m.e.a().post(new a(this, e2Var));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class f0 implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public f0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.u0.p4.o.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (c.a.t0.b.d.p0()) {
                    this.a.M.setVisibility(0);
                } else {
                    this.a.M.setVisibility(8);
                }
                if (z) {
                    this.a.j1("");
                    if (this.a.l != null) {
                        this.a.l.O("c14476");
                    }
                } else {
                    this.a.j1(((c.a.u0.p4.o.c) this.a.u0.a().findToolById(28)).f().getText().toString());
                }
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData != null && z) {
                    long g2 = c.a.d.f.m.b.g(videoItemData.comment_num, 0L) + 1;
                    this.a.mVideoData.comment_num = String.valueOf(g2);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.X1(g2, videoPlayFragment.mCommentNum);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
                this.a.c1();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class f1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f1(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isPrimary() && this.a.I && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.u0.b3.p)) {
                c.a.u0.b3.p pVar = (c.a.u0.b3.p) customResponsedMessage.getData();
                SeekBar seekBar = this.a.H.getSeekBar();
                int i2 = pVar.a;
                if (i2 == 1) {
                    seekBar.setProgress(pVar.f15596b);
                    this.a.H.performOnProgressChanged(seekBar, pVar.f15596b, true);
                } else if (i2 == 2) {
                    this.a.H.performOnStartTrackingTouch(seekBar);
                } else if (i2 == 3) {
                    this.a.H.performOnStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final c.a.t0.d1.h0<String> f48952e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48953f;

        public g(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48953f = videoPlayFragment;
            this.f48952e = new c.a.t0.d1.h0<>(300, TimeUnit.MILLISECONDS);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.f48952e.a("onTouchDownEvent")) {
                    return super.onDoubleTap(motionEvent);
                }
                this.f48953f.onViewDoubleClick(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.f48953f.tryHidePlayEditor()) {
                    this.f48952e.a("onTouchDownEvent");
                }
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (!this.f48952e.a("onTouchDownEvent")) {
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
                }
                if (motionEvent.getX() - motionEvent2.getX() > 50.0f) {
                    this.f48953f.onViewDragToRight();
                    this.f48953f.mRootView.cancelLongPress();
                    return true;
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f48953f.K1();
                    this.f48953f.mRootView.cancelLongPress();
                    return true;
                } else {
                    return false;
                }
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, motionEvent)) == null) {
                if (!this.f48952e.a("onTouchDownEvent")) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                this.f48953f.onViewClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.isResumed() && this.a.I) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.showBlockDialog(videoPlayFragment.T, booleanValue);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class g1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48954e;

        public g1(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48954e = videoPlayFragment;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.f48954e.J0 == null) {
                    VideoPlayFragment videoPlayFragment = this.f48954e;
                    videoPlayFragment.J0 = videoPlayFragment.q1(1.0f, 1.0f, 1.0f, 100L);
                }
                this.f48954e.J0.start();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class h implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f48955e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48956f;

        public h(VideoPlayFragment videoPlayFragment, GestureDetectorCompat gestureDetectorCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, gestureDetectorCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48956f = videoPlayFragment;
            this.f48955e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f48955e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48957e;

        public h0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48957e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f48957e).mVideoData) == null || videoItemData.thread_id == null) {
                return;
            }
            c.a.t0.t.c.l0.b(videoPlayFragment.getPageContext(), this.f48957e.mVideoData.thread_id);
            int i2 = 7;
            if (this.f48957e.f48930e == 1 || this.f48957e.f48930e == 2) {
                i2 = 6;
            } else if (this.f48957e.f48930e != 3) {
                int unused = this.f48957e.f48930e;
            }
            c.a.t0.t.c.l0.a(i2);
        }
    }

    /* loaded from: classes13.dex */
    public static /* synthetic */ class h1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318567265, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$h1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318567265, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$h1;");
                    return;
                }
            }
            int[] iArr = new int[BarManageResultListener.OptType.values().length];
            a = iArr;
            try {
                iArr[BarManageResultListener.OptType.MAKE_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BarManageResultListener.OptType.CANCEL_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BarManageResultListener.OptType.ADD_GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BarManageResultListener.OptType.CANCEL_GOOD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class i implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48958e;

        public i(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48958e = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f48958e.e2();
                this.f48958e.mRootView.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class i0 extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public i0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.a0.getLoadDataMode() == 0) {
                if (this.a.y1()) {
                    if ((obj instanceof ForumManageModel.b) && this.a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.sendMessage(this.a.getPageContext(), Pair.create(Boolean.valueOf(bVar.a), bVar.f48362b));
                    }
                } else {
                    VideoItemData videoItemData = this.a.mVideoData;
                    if (videoItemData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, videoItemData.getThreadId()));
                    }
                }
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.u0.z3.k0.e)) {
                AgreeData agreeData = ((c.a.u0.z3.k0.e) customResponsedMessage.getData()).f26209b;
                if (this.a.mVideoData == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.a.mVideoData.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.a.mVideoData.agree_num = String.valueOf(agreeData.agreeNum);
                    this.a.mVideoData.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.a.d1();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.mVideoData.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.mVideoData.agree_num = String.valueOf(agreeData.agreeNum);
                this.a.mVideoData.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.a.d1();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class j implements h.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48959e;

        public j(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48959e = videoPlayFragment;
        }

        @Override // c.a.u0.b3.h.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f48959e.v0 == null) {
                return;
            }
            this.f48959e.v0.onProgressUpdated(i2, i3);
            if (this.f48959e.F0) {
                this.f48959e.N1(i3, i2);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class j0 implements a.InterfaceC0871a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public j0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.t0.i.a.InterfaceC0871a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.b0 != null) {
                        this.a.b0.h(z2);
                    }
                    VideoItemData videoItemData = this.a.mVideoData;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(c.a.u0.p4.i.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(c.a.u0.p4.i.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(c.a.u0.p4.i.update_mark_failed));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            int statusBarHeight;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.a.k0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.f48932g.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.a.mVideoData == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f2 = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.tbds562);
            int n1 = this.a.n1();
            int e2 = c.a.d.f.m.b.e(this.a.mVideoData.video_height, 0);
            int e3 = c.a.d.f.m.b.e(this.a.mVideoData.video_width, 0);
            if (e2 != 0 && e3 != 0) {
                f2 = (e2 * 1.0f) / e3;
            }
            if (e2 > e3) {
                return;
            }
            int k = c.a.d.f.p.n.k(this.a.mRootView.getContext());
            float f3 = k * f2;
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds166);
            if (f2 > 1.0f) {
                i2 = (int) (dimenPixelSize + ((n1 - dimenPixelSize) * floatValue));
                i3 = (int) (i2 / f2);
                float f5 = 1.0f - floatValue;
                statusBarHeight = (int) (UtilHelper.getStatusBarHeight() * f5);
                this.a.f0.topMargin = (int) (((n1 - f4) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f5) + (f5 * (dimenPixelSize - f4) * 0.5f));
            } else {
                float f6 = dimenPixelSize;
                float f7 = 1.0f - floatValue;
                statusBarHeight = (int) (((n1 - f3) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f7));
                this.a.f0.topMargin = (int) (((n1 - f4) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f7) + (f7 * (dimenPixelSize - f4) * 0.5f));
                i2 = (int) (f6 + ((f3 - f6) * floatValue));
                i3 = k;
            }
            this.a.O.height = i2;
            this.a.O.width = i3;
            this.a.O.topMargin = statusBarHeight;
            this.a.play_btn.requestLayout();
            this.a.k.requestLayout();
        }
    }

    /* loaded from: classes13.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48960e;

        public k(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48960e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48960e.k == null || this.f48960e.k.getControl() == null) {
                return;
            }
            VideoPlayFragment videoPlayFragment = this.f48960e;
            if (videoPlayFragment.mVideoData != null) {
                videoPlayFragment.k.getControl().setVideoPath(this.f48960e.e0, this.f48960e.mVideoData.thread_id);
                this.f48960e.k.getControl().prepareByPause();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48961e;

        public k0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48961e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48961e.mLiveLottieView.playAnimation();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class k1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (this.a.k0) {
                    if (bool.booleanValue() || !this.a.J1()) {
                        this.a.startPlay();
                        this.a.L1();
                        return;
                    }
                    this.a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class l implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public l(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.a.videoLoadingLayout.setVisibility(8);
                this.a.k.getControl().setCanShowPause(true);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class l0 implements j.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public l0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.t0.s.t.j.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.hideDraftDialog();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l1(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.k0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.f48932g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.J1()) {
                        this.a.startPlay();
                        return;
                    }
                    return;
                }
                this.a.m2();
                this.a.L1();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48962e;

        public m(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48962e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f48962e;
                if (videoPlayFragment.i1(videoPlayFragment.getPageContext(), 25066)) {
                    this.f48962e.g2();
                    if (this.f48962e.mVideoData != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.f48962e.mVideoData.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.f48962e.mVideoData.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.f48962e.l != null) {
                        this.f48962e.l.O("c14475");
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class m0 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48963e;

        public m0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48963e = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f48963e.Y = null;
                this.f48963e.Z = null;
            }
        }
    }

    /* loaded from: classes13.dex */
    public interface m1 {
        void a();

        void onStart();
    }

    /* loaded from: classes13.dex */
    public class n implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48964e;

        public n(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48964e = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f48964e.l1(true);
                EMTextView eMTextView = this.f48964e.dragCurTime;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = this.f48964e.dragTotalTime;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.f48964e.k.getControl().getDuration()));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                int i2 = 1;
                this.f48964e.i0 = true;
                if (this.f48964e.H != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.f48964e.H;
                    if (this.f48964e.f48930e != 4 && this.f48964e.f48930e != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        i2 = 0;
                    }
                    videoMiddleNiaiControllerView.setBottomBarShow(false, i2);
                }
                this.f48964e.k2();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.f48964e.isResumed() && this.f48964e.I) {
                    this.f48964e.H.setLoading(true);
                }
                this.f48964e.i0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(c.a.u0.p4.d.tbds12));
                    seekBar.setThumb(null);
                    this.f48964e.l1(false);
                    if (!this.f48964e.k.getControl().isPlaying()) {
                        this.f48964e.k.getControl().start();
                        this.f48964e.play_btn.setVisibility(8);
                    }
                    if (!this.f48964e.k0 && (!this.f48964e.isResumed() || !this.f48964e.I)) {
                        this.f48964e.L1();
                    }
                    c.a.d.f.m.e.a().removeCallbacks(this.f48964e.f1);
                    c.a.d.f.m.e.a().postDelayed(this.f48964e.f1, 3000L);
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48965e;

        public n0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48965e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48965e.i2(true);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48967f;

        public o(VideoPlayFragment videoPlayFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48967f = videoPlayFragment;
            this.f48966e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f48966e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f48967f.getPageContext().getPageActivity()), new String[]{this.f48966e}, true);
        }
    }

    /* loaded from: classes13.dex */
    public class o0 implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public o0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.t0.s.t.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.Y != null) {
                    this.a.Y.dismiss();
                }
                this.a.i2(false);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48968e;

        public p(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48968e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.u0.p4.f.portrait_container && (videoItemData = this.f48968e.mVideoData) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.f48968e;
                    if (videoPlayFragment.mVideoData.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.f48968e.mVideoData.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.f48968e.mVideoData.getThreadId());
                        UserItemData userItemData2 = this.f48968e.mVideoData.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.f48968e.mVideoData.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.f48968e.mVideoData;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null) {
                    return;
                }
                long g2 = c.a.d.f.m.b.g(userItemData.user_id, 0L);
                long g3 = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = (g2 == 0 && g3 == 0) ? false : g2 == g3;
                String str = this.f48968e.mVideoData.author_info.portrait;
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.f48968e.getActivity()).createNormalConfig(g2, z, false, true, (this.f48968e.f48930e == 3 || this.f48968e.f48930e == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                createNormalConfig.setPortrait(str);
                createNormalConfig.setSourceTid(this.f48968e.mVideoData.thread_id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.f48968e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.f48968e.getClickItem(5);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class p0 implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public p0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.t0.s.t.j.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    if (this.a.Y != null) {
                        this.a.Y.dismiss();
                        return;
                    }
                    return;
                }
                if (this.a.Y != null) {
                    this.a.Y.dismiss();
                }
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.a.mVideoData.thread_id);
                markData.setPostId(this.a.mVideoData.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.a.mVideoData.thread_id);
                markData.setForumId(this.a.mVideoData.forum_id);
                if (this.a.b0 != null) {
                    this.a.b0.i(markData);
                    if (!z) {
                        this.a.b0.a();
                    } else {
                        this.a.b0.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48969e;

        public q(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48969e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f48969e).mVideoData) == null || videoItemData.act_info == null) {
                return;
            }
            c.a.t0.m.a.l(videoPlayFragment.getActivity(), this.f48969e.mVideoData.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.f48969e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes13.dex */
    public class q0 implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public q0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.t0.s.t.j.d
        public void onClick() {
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Y.dismiss();
                if (ViewHelper.checkUpIsLogin(this.a.getActivity()) && this.a.getPageContext() != null) {
                    if (this.a.K0 == null && (runTask = MessageManager.getInstance().runTask(2921343, c.a.u0.h4.a.class, this.a.getContext())) != null) {
                        this.a.K0 = (c.a.u0.h4.a) runTask.getData();
                    }
                    if (this.a.K0 != null) {
                        VideoPlayFragment videoPlayFragment = this.a;
                        if (videoPlayFragment.mVideoData != null) {
                            videoPlayFragment.K0.b(this.a.getUniqueId());
                            this.a.K0.a(this.a.mVideoData.post_id);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes13.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48970e;

        public r(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48970e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48970e.r1();
                this.f48970e.getClickItem(7);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.a.mVideoData.author_info.user_id.equals(data.f41000c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.a.d0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.a) {
                    if (!z || "0".equals(this.a.mVideoData.author_info.is_follow)) {
                        return;
                    }
                    c.a.d.f.p.n.M(this.a.getActivity(), c.a.u0.p4.i.attention_fail);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment.e1();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment2.e1();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.a.mVideoData));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.e1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.a.W)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48971e;

        public s(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48971e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.f48971e.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.f48971e.mVideoData.thread_id));
                }
                this.f48971e.getActivity().finish();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class s0 implements j.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes13.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.t0.s.t.a f48972e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s0 f48973f;

            public a(s0 s0Var, c.a.t0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48973f = s0Var;
                this.f48972e = aVar;
            }

            @Override // c.a.t0.s.t.a.e
            public void onClick(c.a.t0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f48972e.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f48973f.a;
                    if (videoPlayFragment.mVideoData != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.a0;
                        VideoPlayFragment videoPlayFragment2 = this.f48973f.a;
                        VideoItemData videoItemData = videoPlayFragment2.mVideoData;
                        forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.T, null, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes13.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.t0.s.t.a f48974e;

            public b(s0 s0Var, c.a.t0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48974e = aVar;
            }

            @Override // c.a.t0.s.t.a.e
            public void onClick(c.a.t0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f48974e.dismiss();
                }
            }
        }

        public s0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // c.a.t0.s.t.j.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Y.dismiss();
                c.a.t0.s.t.a aVar = new c.a.t0.s.t.a(this.a.getActivity());
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(c.a.u0.p4.i.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(c.a.u0.p4.i.del_thread_confirm);
                }
                aVar.setPositiveButton(c.a.u0.p4.i.dialog_ok, new a(this, aVar));
                aVar.setNegativeButton(c.a.u0.p4.i.dialog_cancel, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48975e;

        public t(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48975e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48975e.e2();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class t0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public t0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.mVideoData.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes13.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48976e;

        public u(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48976e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.f48976e.getPageContext(), this.f48976e.mVideoData)) {
                return;
            }
            this.f48976e.r1();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.f48976e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.f48976e.getClickItem(2);
        }
    }

    /* loaded from: classes13.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48977e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48978f;

        public u0(VideoPlayFragment videoPlayFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48978f = videoPlayFragment;
            this.f48977e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f48978f.getContext()).createNormalCfg(this.f48977e, "")));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class v implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public v(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.k == null || this.a.k.getControl() == null) {
                return;
            }
            VideoPlayFragment videoPlayFragment = this.a;
            if (videoPlayFragment.mVideoData != null) {
                videoPlayFragment.k.getControl().setVideoPath(this.a.e0, this.a.mVideoData.thread_id);
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.k == null || this.a.k.getControl() == null) {
                return;
            }
            this.a.k.clearCallbackAndRemoveFromWindow();
            this.a.k.getControl().setStageType("2005");
            this.a.k.getControl().setLocateSource("v_mid_page");
            this.a.k.getControl().setContinuePlayEnable(true);
            if (this.a.O != null) {
                this.a.n.setLayoutParams(this.a.O);
                if (this.a.f48935j != null && this.a.k != null) {
                    this.a.f48935j.addView(this.a.k, 0, this.a.O);
                }
            } else {
                this.a.setVideoBussinessAndAddView();
            }
            this.a.Z1();
        }
    }

    /* loaded from: classes13.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48979e;

        public v0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48979e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f48979e.E0 == null) {
                return;
            }
            this.f48979e.E0.q(TiePlusStat.StatType.CLICK);
            this.f48979e.C0.statRichTextEvent(this.f48979e.E0);
            this.f48979e.C0.processClick(this.f48979e.E0);
        }
    }

    /* loaded from: classes13.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48980e;

        public w(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48980e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f48980e;
                videoPlayFragment.k1(videoPlayFragment.f48933h);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class w0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48981e;

        public w0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48981e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48981e.i0) {
                return;
            }
            this.f48981e.f1(true);
        }
    }

    /* loaded from: classes13.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48982e;

        public x(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48982e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48982e.h2();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.f48982e.mVideoData.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f48982e.getClickItem(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.f48982e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.f48982e.mVideoData.nid);
                BaijiahaoData baijiahaoData = this.f48982e.mVideoData.baijiahaoData;
                if (baijiahaoData != null && !c.a.d.f.p.m.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.f48982e.mVideoData.baijiahaoData.oriUgcVid);
                }
                if (this.f48982e.mVideoData.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.f48982e.mVideoData.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.f48982e.mVideoData.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.f48982e.mVideoData.mRecomSource);
                statisticItem2.param("ab_tag", this.f48982e.mVideoData.mRecomAbTag);
                statisticItem2.param("weight", this.f48982e.mVideoData.mRecomWeight);
                statisticItem2.param("extra", this.f48982e.mVideoData.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (c.a.t0.p0.c.j(this.f48982e.getBaseFragmentActivity()) != null && c.a.t0.p0.c.j(this.f48982e.getBaseFragmentActivity()).b() != null && c.a.t0.p0.c.j(this.f48982e.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(c.a.t0.p0.c.j(this.f48982e.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class x0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48984f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48986h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f48987i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f48988j;
        public final /* synthetic */ RelativeLayout.LayoutParams k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ int n;
        public final /* synthetic */ int o;
        public final /* synthetic */ int p;
        public final /* synthetic */ int q;
        public final /* synthetic */ int r;
        public final /* synthetic */ int s;
        public final /* synthetic */ int t;
        public final /* synthetic */ View u;
        public final /* synthetic */ View v;
        public final /* synthetic */ View w;
        public final /* synthetic */ VideoPlayFragment x;

        public x0(VideoPlayFragment videoPlayFragment, int i2, int i3, int i4, int i5, int i6, int i7, RelativeLayout.LayoutParams layoutParams, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, View view, View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), layoutParams, Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), view, view2, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i17 = newInitContext.flag;
                if ((i17 & 1) != 0) {
                    int i18 = i17 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.x = videoPlayFragment;
            this.f48983e = i2;
            this.f48984f = i3;
            this.f48985g = i4;
            this.f48986h = i5;
            this.f48987i = i6;
            this.f48988j = i7;
            this.k = layoutParams;
            this.l = i8;
            this.m = i9;
            this.n = i10;
            this.o = i11;
            this.p = i12;
            this.q = i13;
            this.r = i14;
            this.s = i15;
            this.t = i16;
            this.u = view;
            this.v = view2;
            this.w = view3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            boolean z;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i2 = (int) (this.f48983e * animatedFraction);
                int i3 = (int) (this.f48984f * animatedFraction);
                int i4 = this.f48985g;
                int i5 = i4 > this.f48986h ? i4 - i2 : i4 + i2;
                int i6 = this.f48987i;
                this.k.topMargin = i6 > this.f48988j ? i6 - i3 : i6 + i3;
                this.x.O.topMargin = i5;
                int i7 = (int) (this.l * animatedFraction);
                int i8 = this.m;
                int i9 = i8 > this.n ? i8 - i7 : i8 + i7;
                this.x.O.leftMargin = i9;
                this.x.O.rightMargin = i9;
                RelativeLayout.LayoutParams layoutParams = this.k;
                layoutParams.leftMargin = i9;
                layoutParams.rightMargin = i9;
                float f4 = this.o * animatedFraction;
                float f5 = this.p * animatedFraction;
                int i10 = this.q;
                float f6 = i10 > this.r ? i10 - f4 : i10 + f4;
                int i11 = this.s;
                if (i11 > this.t) {
                    f2 = i11 - f5;
                    f3 = 1.0f - animatedFraction;
                    z = false;
                } else {
                    f2 = i11 + f5;
                    z = true;
                    f3 = animatedFraction;
                }
                this.x.O.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.x.O.height = (int) f6;
                RelativeLayout.LayoutParams layoutParams2 = this.k;
                layoutParams2.height = (int) f2;
                layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.u.setLayoutParams(this.k);
                this.u.setAlpha(f3);
                if (z && f3 > 0.5f) {
                    this.x.U1((f3 - 0.5f) * 2.0f);
                } else if (!z && animatedFraction < 0.25f) {
                    this.x.U1(1.0f - (animatedFraction * 4.0f));
                }
                this.v.setLayoutParams(this.x.O);
                this.w.setLayoutParams(this.x.O);
                this.v.requestLayout();
                this.w.requestLayout();
                this.u.requestLayout();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f48989e;

        public y(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48989e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f48989e.getActivity())) {
                if (this.f48989e.B != null && (videoItemData = (videoPlayFragment = this.f48989e).mVideoData) != null && videoItemData.author_info != null && videoPlayFragment.mAttentionLottieView != null) {
                    c.a.t0.t.e.a aVar = videoPlayFragment.c0;
                    VideoPlayFragment videoPlayFragment2 = this.f48989e;
                    UserItemData userItemData = videoPlayFragment2.mVideoData.author_info;
                    String str = userItemData.portrait;
                    String str2 = userItemData.user_id;
                    BdUniqueId bdUniqueId = videoPlayFragment2.d0;
                    VideoItemData videoItemData2 = this.f48989e.mVideoData;
                    aVar.m(true, str, str2, false, "6", bdUniqueId, videoItemData2.forum_id, "0", videoItemData2.thread_id);
                    VideoPlayFragment videoPlayFragment3 = this.f48989e;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.e1();
                    this.f48989e.B.setVisibility(8);
                    this.f48989e.M1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.f48989e.f48930e != 3 && this.f48989e.f48930e != 4) {
                    statisticItem.param("obj_locate", 2);
                    if (this.f48989e.f48930e != 7) {
                        statisticItem.param("obj_source", this.f48989e.p1());
                    } else {
                        statisticItem.param("obj_source", 8);
                    }
                } else {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.f48989e.mVideoData.thread_id);
                statisticItem.param("fid", this.f48989e.mVideoData.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f48989e.getClickItem(6);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(VideoPlayFragment videoPlayFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.a.isResumed() && this.a.I) {
                if (c.a.d.f.p.l.z()) {
                    if (this.a.f2()) {
                        return;
                    }
                    this.a.startPlay();
                    return;
                }
                c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), c.a.u0.p4.i.neterror);
            }
        }
    }

    /* loaded from: classes13.dex */
    public class z implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public z(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.n == null) {
                return;
            }
            this.a.n.setVisibility(8);
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
            }
        }
    }

    /* loaded from: classes13.dex */
    public class z0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48990e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f48991f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f48992g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f48993h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f48994i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f48995j;
        public final /* synthetic */ int k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ View n;
        public final /* synthetic */ View o;
        public final /* synthetic */ VideoPlayFragment p;

        public z0(VideoPlayFragment videoPlayFragment, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), view, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i11 = newInitContext.flag;
                if ((i11 & 1) != 0) {
                    int i12 = i11 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.p = videoPlayFragment;
            this.f48990e = i2;
            this.f48991f = i3;
            this.f48992g = i4;
            this.f48993h = i5;
            this.f48994i = i6;
            this.f48995j = i7;
            this.k = i8;
            this.l = i9;
            this.m = i10;
            this.n = view;
            this.o = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i2 = (int) (this.f48990e * animatedFraction);
                int i3 = this.f48991f;
                this.p.O.topMargin = i3 > this.f48992g ? i3 - i2 : i3 + i2;
                int i4 = (int) (this.f48993h * animatedFraction);
                int i5 = this.f48994i;
                int i6 = i5 > this.f48995j ? i5 - i4 : i5 + i4;
                this.p.O.leftMargin = i6;
                this.p.O.rightMargin = i6;
                float f2 = animatedFraction * this.k;
                int i7 = this.l;
                float f3 = i7 > this.m ? i7 - f2 : i7 + f2;
                this.p.O.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.p.O.height = (int) f3;
                this.n.setLayoutParams(this.p.O);
                this.o.setLayoutParams(this.p.O);
                this.n.requestLayout();
                this.o.requestLayout();
            }
        }
    }

    public VideoPlayFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f48933h = 0;
        this.f48934i = 1;
        this.p = false;
        this.L = false;
        this.a0 = null;
        this.b0 = null;
        this.c0 = null;
        this.d0 = BdUniqueId.gen();
        this.g0 = TbCyberVideoView.VideoStatus.INIT;
        this.q0 = false;
        this.r0 = 1;
        this.s0 = -1;
        this.D0 = false;
        this.F0 = true;
        this.I0 = null;
        this.J0 = null;
        this.L0 = new k(this);
        this.M0 = new v(this);
        this.N0 = new g0(this, 2921607);
        this.O0 = new r0(this, 2001115);
        this.P0 = new y0(this, 2000994);
        this.Q0 = new i1(this, 2016528);
        this.R0 = new j1(this, 2921594);
        this.S0 = new k1(this, 2001011);
        this.T0 = new l1(this, 2921596);
        this.U0 = new a(this, 2921598);
        this.V0 = new b(this, 2921612);
        this.W0 = new BarManageResultListener(new c(this));
        this.X0 = new d(this, 2921645);
        this.Y0 = new e(this);
        this.Z0 = new h0(this);
        this.a1 = new n0(this);
        this.b1 = new o0(this);
        this.c1 = new p0(this);
        this.d1 = new q0(this);
        this.e1 = new s0(this);
        this.f1 = new w0(this);
        this.g1 = new b1(this);
        this.h1 = new e1(this, 2921603);
        this.i1 = new f1(this, 2921635);
    }

    public static /* synthetic */ int S0(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.r0;
        videoPlayFragment.r0 = i2 + 1;
        return i2;
    }

    public final boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int i2 = this.f48930e;
            return (i2 == 3 || i2 == 4) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f48930e == 1 && this.s0 == 0) {
                return false;
            }
            return (this.f48930e == 7 && getActivity() != null && (getActivity() instanceof FrsVideoTabPlayActivity) && this.s0 == ((FrsVideoTabPlayActivity) getActivity()).getVideoIndex()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            int i2 = this.f48930e;
            return i2 == 1 || i2 == 2 || TbSingleton.getInstance().isFromFeedVideoClick();
        }
        return invokeV.booleanValue;
    }

    public final boolean D1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 == 1) {
                int i3 = this.f48930e;
                return i3 == 3 || i3 == 4;
            } else if (i2 == 2) {
                int i4 = this.f48930e;
                return i4 == 1 || i4 == 2;
            } else if (i2 == 3) {
                int i5 = this.f48930e;
                return i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public final boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? y1() && !this.f48931f : invokeV.booleanValue;
    }

    public final boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? E1() && isHost() : invokeV.booleanValue;
    }

    public final boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.u0.p4.o.a aVar = this.u0;
            return (aVar == null || aVar.a() == null || !this.u0.a().isVisible()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (c.a.t0.b.d.E0() && D1(1)) {
                return true;
            }
            if (c.a.t0.b.d.B0() && D1(2)) {
                return true;
            }
            return c.a.t0.b.d.A0() && D1(3);
        }
        return invokeV.booleanValue;
    }

    public final boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.f48930e;
            return i2 == 4 || i2 == 3;
        }
        return invokeV.booleanValue;
    }

    public final boolean J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TbCyberVideoView.VideoStatus videoStatus = this.g0;
            return videoStatus == TbCyberVideoView.VideoStatus.INIT || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PREPARED || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void L1() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (tbVideoViewContainer = this.k) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.k.getControl().pauseWithoutMuteAudioFocus();
    }

    public final void M1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (tBLottieAnimationView = this.mAttentionLottieView) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        SkinManager.setLottieAnimation(this.mAttentionLottieView, c.a.u0.p4.h.video_tab_attention_animation);
        if (this.mAttentionLottieView.isAnimating()) {
            return;
        }
        this.mAttentionLottieView.setSpeed(1.1f);
        this.mAttentionLottieView.playAnimation();
    }

    public final void N1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) {
            VideoItemData videoItemData = this.mVideoData;
            if (!(videoItemData == null && videoItemData.video_url == null) && i2 > this.mVideoData.video_duration * 1000) {
                this.F0 = false;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_PTS);
                statisticItem.param("obj_id", this.mVideoData.video_url);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void O1(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i2) == null) && this.mVideoData != null && this.K == null) {
            StatisticItem statisticItem = new StatisticItem("c12794");
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            statisticItem2.param("page_type", "a023");
            statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
            TiebaStatic.log(statisticItem2);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.mVideoData == null) {
            return;
        }
        c.a.u0.b3.t tVar = new c.a.u0.b3.t();
        tVar.a = "nani_midpage";
        VideoItemData videoItemData = this.mVideoData;
        tVar.f15610c = videoItemData.thread_id;
        tVar.t = videoItemData.nid;
        tVar.f15611d = this.mVideoData.forum_id + "";
        tVar.f15612e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.mVideoData;
        tVar.f15613f = videoItemData2.mRecomSource;
        tVar.f15614g = videoItemData2.mRecomAbTag;
        tVar.f15615h = videoItemData2.mRecomWeight;
        tVar.f15616i = "";
        tVar.k = "";
        tVar.m = videoItemData2.mMd5;
        tVar.x = videoItemData2.getChannelMidRequestNum();
        tVar.y = this.mVideoData.getChannelMidRequestVideoNum();
        if (this.K != null) {
            tVar.n = "1";
        } else {
            tVar.n = "2";
        }
        int i2 = this.f48930e;
        if (i2 == 1 || i2 == 2) {
            tVar.p = "1";
            tVar.a = "auto_midpage";
            tVar.f15616i = "index";
        }
        c.a.u0.b3.j.e(this.mVideoData.mMd5, "", "1", tVar, this.k.getControl().getPcdnState());
        int i3 = this.f48930e;
        if (i3 == 1 || i3 == 3) {
            c.a.u0.p4.l.e.c(this.mVideoData.mMd5);
        } else if (i3 == 2 || i3 == 4) {
            c.a.u0.p4.l.e.a(this.mVideoData.mMd5);
        } else if (i3 == 7) {
            c.a.u0.p4.l.e.b(this.mVideoData.mMd5);
        }
    }

    public final void Q1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.share_icon_changed == null || (imageView = this.share_icon) == null) {
            return;
        }
        imageView.clearAnimation();
        this.share_icon_changed.clearAnimation();
        this.share_icon.setVisibility(0);
        this.share_icon_changed.setVisibility(8);
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || f2()) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.k;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.play_btn != null && this.mVideoData != null) {
            if (this.k.getParent() == null) {
                setVideoBussinessAndAddView();
                Z1();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.H;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.resetProgress();
            }
            if (!c.a.t0.b.d.D0()) {
                this.k.getControl().setIsVolume0(false);
            }
            this.k.getControl().start(this.M0);
            this.H.showProgress();
            this.play_btn.setVisibility(8);
            d2();
        }
        if (isResumed() && this.I && J1()) {
            return;
        }
        L1();
        if (this.play_btn != null) {
            W1();
        }
    }

    public final void S1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i2) == null) || (view = this.mRootView) == null) {
            return;
        }
        view.setPadding(0, 0, 0, i2);
    }

    public final void T1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.agreeContainer.setVisibility(i2);
            this.D.setVisibility(i2);
            this.commentContainer.setVisibility(i2);
            this.shareContainer.setVisibility(i2);
            this.mBottomContainer.setVisibility(i2);
        }
    }

    public final void U1(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f2) == null) {
            LinearLayout linearLayout = this.mBottomContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                this.mBottomContainer.setAlpha(f2);
            }
            LinearLayout linearLayout2 = this.commentContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
                this.commentContainer.setAlpha(f2);
            }
            RelativeLayout relativeLayout = this.agreeContainer;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                this.agreeContainer.setAlpha(f2);
            }
            LinearLayout linearLayout3 = this.shareContainer;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
                this.shareContainer.setAlpha(f2);
            }
            View view = this.G0;
            if (view != null) {
                view.setVisibility(0);
                this.G0.setAlpha(f2);
            }
            View view2 = this.H0;
            if (view2 != null) {
                view2.setVisibility(0);
                this.H0.setAlpha(f2);
            }
            View view3 = this.o;
            if (view3 != null) {
                view3.setVisibility(0);
                this.o.setAlpha(f2);
            }
            View view4 = this.mfullScreenView;
            if (view4 != null) {
                view4.setVisibility(0);
                this.mfullScreenView.setAlpha(f2);
            }
        }
    }

    public final void V1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            LinearLayout linearLayout = this.mBottomContainer;
            if (linearLayout != null) {
                linearLayout.setVisibility(i2);
            }
            LinearLayout linearLayout2 = this.commentContainer;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(i2);
            }
            RelativeLayout relativeLayout = this.agreeContainer;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(i2);
            }
            LinearLayout linearLayout3 = this.shareContainer;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(i2);
            }
            View view = this.G0;
            if (view != null) {
                view.setVisibility(i2);
            }
            View view2 = this.H0;
            if (view2 != null) {
                view2.setVisibility(i2);
            }
            View view3 = this.o;
            if (view3 != null) {
                view3.setVisibility(i2);
            }
            View view4 = this.mfullScreenView;
            if (view4 != null) {
                view4.setVisibility(i2);
            }
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.play_btn.setVisibility(0);
            if (this.I0 == null) {
                this.I0 = q1(0.0f, 3.0f, 3.0f, 0L);
            }
            this.I0.addListener(new g1(this));
            this.I0.start();
        }
    }

    public final void X1(long j2, TextView textView) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048599, this, j2, textView) == null) || textView == null) {
            return;
        }
        String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(j2);
        if (!"0".equals(numberUniformFormatExtraWithRoundVote)) {
            textView.setText(numberUniformFormatExtraWithRoundVote);
            return;
        }
        if (textView.getId() == c.a.u0.p4.f.agree_num) {
            string = TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.video_no_agree);
        } else if (textView.getId() == c.a.u0.p4.f.comment_num) {
            string = TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.video_no_comment);
        } else {
            string = textView.getId() == c.a.u0.p4.f.share_num ? TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.video_no_share) : "";
        }
        textView.setText(string);
    }

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mPortraitContainer.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.author_portrait.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds94);
                layoutParams2.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds94);
                layoutParams.height = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds94);
                layoutParams2.height = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds94);
            }
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.k.getControl().setVideoStatusChangeListener(this);
            this.k.getControl().setOperableVideoContainer(this.g1);
        }
    }

    public final void a2(VideoItemData videoItemData, c.a.u0.p4.t.a aVar, VideoDanmuController videoDanmuController) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048602, this, videoItemData, aVar, videoDanmuController) == null) || aVar == null || aVar.getMainView() == null) {
            return;
        }
        aVar.E0(videoItemData);
        boolean z2 = false;
        boolean z3 = c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(videoItemData.video_width, 0);
        if (this.I && z3) {
            z2 = true;
        }
        aVar.U(z2);
        aVar.F0(new d0(this, videoDanmuController, aVar));
        aVar.getMainView().setVisibility(8);
    }

    public final void b1(boolean z2) {
        c.a.u0.p4.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) || (aVar = this.u0) == null || aVar.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u0.a().getLayoutParams();
        int i2 = 0;
        if (!z2) {
            int i3 = this.f48930e;
            if (i3 != 4 && i3 != 3) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight() - UtilHelper.getDimenPixelSize(c.a.u0.p4.d.M_H_X004);
            } else {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
            }
        }
        layoutParams.bottomMargin = i2;
        this.u0.a().requestLayout();
    }

    public final void b2(String str) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || (tbVideoViewContainer = this.k) == null || tbVideoViewContainer.getControl() == null || str == null || str.equals(this.e0)) {
            return;
        }
        this.e0 = str;
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            int i2 = this.f48930e;
            if (i2 != 4 && i2 != 3) {
                S1(UtilHelper.getDimenPixelSize(c.a.u0.p4.d.M_H_X004));
            } else {
                S1(0);
            }
        }
    }

    public final void c2(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048606, this, i2) == null) || (relativeLayout = this.f48935j) == null) {
            return;
        }
        relativeLayout.setPadding(0, 0, 0, i2);
    }

    public void changeEditorSkinType(int i2) {
        c.a.u0.p4.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || (aVar = this.u0) == null || aVar.a() == null) {
            return;
        }
        this.u0.a().onChangeSkinType(i2);
    }

    public final void d1() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.p4.e.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.p4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        X1(c.a.d.f.m.b.g(this.mVideoData.agree_num, 0L), this.mAgreeNum);
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && c.a.d.f.p.l.x()) {
            c.a.u0.n4.h.c().f(getContext());
        }
    }

    public void dismissBlockDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (alertDialog = this.z0) != null && alertDialog.isShowing()) {
            this.z0.dismiss();
        }
    }

    public final void e1() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null && (userItemData = videoItemData.author_info) != null && !this.T && (userItemData == null || !"1".equals(userItemData.is_follow))) {
                this.B.setVisibility(0);
                this.B.setClickable(true);
                return;
            }
            this.B.setVisibility(4);
            this.B.setClickable(false);
        }
    }

    public final void e2() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.Y == null) {
                this.Z = new c.a.t0.s.t.j(getActivity());
                this.Y = new PopupDialog(getPageContext(), this.Z);
                ArrayList arrayList = new ArrayList();
                c.a.t0.s.t.g gVar = new c.a.t0.s.t.g(getString(c.a.u0.p4.i.mark), this.Z);
                boolean z2 = false;
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    gVar.m(TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.remove_mark));
                } else {
                    gVar.m(TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.mark));
                }
                gVar.l(this.c1);
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(gVar);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.mVideoData.thread_id);
                    statisticItem.param("fid", this.mVideoData.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    int i2 = this.f48930e;
                    if (i2 != 3 && i2 != 4) {
                        statisticItem.param("obj_type", 2);
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    int i3 = this.f48930e;
                    if (i3 == 3) {
                        statisticItem.param("obj_param1", 1);
                    } else if (i3 == 4) {
                        statisticItem.param("obj_param1", 2);
                    } else if (i3 == 7) {
                        statisticItem.param("obj_param1", 3);
                    }
                    statisticItem.param("obj_source", p1());
                    TiebaStatic.log(statisticItem);
                }
                if (isUEGBackDisLike()) {
                    c.a.t0.s.t.g gVar2 = new c.a.t0.s.t.g(getString(c.a.u0.p4.i.not_interested), this.Z);
                    gVar2.l(this.b1);
                    arrayList.add(gVar2);
                }
                if (!isHost()) {
                    c.a.t0.s.t.g gVar3 = new c.a.t0.s.t.g(getString(c.a.u0.p4.i.report_text), this.Z);
                    gVar3.l(this.d1);
                    arrayList.add(gVar3);
                }
                if (this.T) {
                    c.a.t0.s.t.g gVar4 = new c.a.t0.s.t.g(getString(c.a.u0.p4.i.delete), this.Z);
                    gVar4.l(this.e1);
                    arrayList.add(gVar4);
                }
                this.Z.m(new l0(this));
                this.Y.setOnDismissListener(new m0(this));
                this.Z.j(arrayList);
            }
            showDraftDialog();
        }
    }

    public final void f1(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) || (videoMiddleNiaiControllerView = this.H) == null) {
            return;
        }
        int i2 = this.f48930e;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick()) ? 1 : 0);
    }

    public final boolean f2() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (c.a.u0.n4.h.c().d() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !((i2 = this.f48930e) == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick() || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.f48930e;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && c.a.d.f.p.l.x() && isResumed() && this.I) {
                c.a.d.f.p.n.O(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.video_no_wifi_tips), 3000);
                int i4 = this.f48930e;
                if (i4 != 3 && i4 != 4) {
                    TbSingleton.getInstance().setTipsAutoPlayInVideoMiddle(true);
                } else {
                    TbSingleton.getInstance().setTipsAutoPlayInVideoChannel(true);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || F1() || this.share_icon_changed == null || this.share_icon == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        this.share_icon.clearAnimation();
        this.share_icon_changed.clearAnimation();
        this.share_icon.setVisibility(8);
        this.share_icon_changed.setVisibility(0);
        this.share_icon_changed.startAnimation(scaleAnimation2);
        this.share_icon.startAnimation(scaleAnimation);
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || G1()) {
            return;
        }
        c.a.u0.p4.o.a aVar = this.u0;
        if (aVar != null && aVar.a() != null) {
            this.u0.a().display();
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null) {
                this.u0.v(videoItemData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.TRUE));
        }
        int i2 = this.f48930e;
        if (i2 == 4 || i2 == 3) {
            c2(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        c1();
    }

    public void getClickItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i3 = this.f48930e;
            if (i3 != 3 && i3 != 4) {
                statisticItem.param("obj_locate", 2);
            } else {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("obj_type", i2);
            int i4 = this.f48930e;
            if (i4 == 3) {
                statisticItem.param("obj_source", 1);
            } else if (i4 == 4) {
                statisticItem.param("obj_source", 2);
            } else if (i4 == 7) {
                statisticItem.param("obj_source", 3);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // c.a.u0.p4.s.b.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.F : (VideoItemModel) invokeV.objValue;
    }

    public String getCurrentMediaID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.u0.p4.s.b.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.s0 : invokeV.intValue;
    }

    public List<String> getMediaIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.clickAnimation == null) {
                this.clickAnimation = AnimationUtils.loadAnimation(getContext(), c.a.u0.p4.a.scale_zoom_in_and_out_anim);
            }
            return this.clickAnimation;
        }
        return (Animation) invokeV.objValue;
    }

    public final void h1() {
        VideoItemData videoItemData;
        String b02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        this.n.startLoad(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.mVideoData.getTitle();
        boolean z2 = c.a.d.f.m.b.e(this.mVideoData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
        if (TextUtils.isEmpty(title) && (!z2 || this.mVideoData.video_duration < 60)) {
            this.A.setVisibility(8);
        } else {
            if (this.mVideoData.video_duration >= 60) {
                this.y.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), c.a.u0.p4.d.tbds31), c.a.d.f.p.n.f(getContext(), c.a.u0.p4.d.tbds31));
                }
                layoutParams.width = c.a.d.f.p.n.f(getContext(), c.a.u0.p4.d.tbds3);
                layoutParams.height = c.a.d.f.p.n.f(getContext(), c.a.u0.p4.d.tbds34);
                this.z.setLayoutParams(layoutParams);
                this.z.setBackgroundColor(getResources().getColor(c.a.u0.p4.c.CAM_X0618));
                int i2 = this.mVideoData.video_duration;
                int i3 = i2 / 3600;
                int i4 = (i2 % 3600) / 60;
                int i5 = (i2 % 3600) % 60;
                StringBuilder sb = new StringBuilder();
                if (i3 > 0) {
                    if (i3 < 10) {
                        sb.append("0");
                    }
                    sb.append(i3);
                    sb.append(":");
                }
                if (i4 > 0) {
                    if (i4 < 10) {
                        sb.append("0");
                    }
                    sb.append(i4);
                    sb.append(":");
                } else {
                    sb.append("00");
                    sb.append(":");
                }
                if (i5 > 0) {
                    if (i5 < 10) {
                        sb.append("0");
                    }
                    sb.append(i5);
                } else {
                    sb.append("00");
                }
                c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.x);
                d2.z(c.a.u0.p4.d.T_X08);
                d2.v(c.a.u0.p4.c.CAM_X0618);
                d2.A(c.a.u0.p4.i.F_X02);
                this.x.setText(sb.toString());
            } else {
                this.y.setVisibility(8);
            }
            this.A.setVisibility(0);
            this.video_title.setTextSize(c.a.d.f.p.n.f(getContext(), c.a.u0.p4.d.T_X07));
            this.video_title.setTextColor(c.a.u0.p4.c.CAM_X0621);
            this.video_title.setLineSpacingExtra(c.a.d.f.p.n.f(getContext(), c.a.u0.p4.d.tbds10));
            this.video_title.setExpandable(false);
            this.video_title.setTextMaxLine(3);
            this.video_title.setLimitLine(3);
            this.video_title.setOnStatusChangedListener(new t0(this));
            ExpandableTextView expandableTextView = this.video_title;
            VideoItemData videoItemData2 = this.mVideoData;
            expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        X1(c.a.d.f.m.b.g(this.mVideoData.comment_num, 0L), this.mCommentNum);
        X1(c.a.d.f.m.b.g(this.mVideoData.agree_num, 0L), this.mAgreeNum);
        if (F1()) {
            this.mShareNum.setText(c.a.u0.p4.i.more);
        } else {
            X1(c.a.d.f.m.b.g(this.mVideoData.share_num, 0L), this.mShareNum);
        }
        UserItemData userItemData = this.mVideoData.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.mVideoData.author_info.portrait.startsWith("http")) {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 10, false);
            } else {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 12, false);
            }
            if (H1() && !TextUtils.isEmpty(this.mVideoData.author_info.auth)) {
                this.author_portrait.setShowV(true);
                this.author_portrait.setOriginatorResId(c.a.u0.p4.e.ic_icon_mask_videov14);
            } else {
                this.author_portrait.setShowV(false);
                this.author_portrait.setOriginatorResId(0);
            }
            if (StringUtils.isNull(this.mVideoData.author_info.getUserShowName())) {
                this.mAuthorNameTv.setVisibility(8);
            } else {
                this.mAuthorNameTv.setVisibility(0);
                this.mAuthorNameTv.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.mVideoData.author_info.getUserShowName(), 16, "..."));
            }
        }
        AlaInfoData alaInfoData = this.mVideoData.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            u1(this.mVideoData.mAlaInfoData.live_status == 1);
            t1();
        }
        if ("1".equals(this.mVideoData.is_private) && this.G.getVisibility() != 0) {
            this.video_private.setVisibility(0);
        } else {
            this.video_private.setVisibility(8);
        }
        if ("1".equals(this.mVideoData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.p4.e.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAgreeImg, AnimationProperty.SCALE_X, 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mAgreeImg, AnimationProperty.SCALE_Y, 1.3f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat2.setDuration(300L);
            ofFloat.start();
            ofFloat2.start();
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.p4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.mVideoData.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.G.getVisibility() != 0) {
            this.videoActivityContainer.setVisibility(8);
            this.C.setText(this.mVideoData.act_info.activity_name);
        } else {
            this.videoActivityContainer.setVisibility(8);
        }
        e1();
        boolean initTiePlusRichTextView = initTiePlusRichTextView();
        if (this.f48930e == 7) {
            this.q.setVisibility(8);
        } else if (initTiePlusRichTextView) {
        } else {
            if (!TextUtils.isEmpty(this.mVideoData.forum_name)) {
                b02 = this.mVideoData.forum_name;
            } else {
                e2 e2Var = this.mVideoData.threadData;
                b02 = (e2Var == null || TextUtils.isEmpty(e2Var.b0())) ? null : this.mVideoData.threadData.b0();
            }
            if (TextUtils.isEmpty(b02)) {
                return;
            }
            this.q.setVisibility(0);
            WebPManager.setPureDrawable(this.v, c.a.u0.p4.e.icon_pure_ba32, c.a.u0.p4.c.CAM_X0101, null);
            this.v.setVisibility(0);
            this.u.setVisibility(8);
            String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(b02 + TbadkCoreApplication.getInst().getString(c.a.u0.p4.i.bar_default_name), 12, "...吧");
            this.V = cutChineseAndEnglishWithEmoji;
            this.w.setText(cutChineseAndEnglishWithEmoji);
            e2 e2Var2 = this.mVideoData.threadData;
            if (e2Var2 != null && !TextUtils.isEmpty(e2Var2.getRecomReason())) {
                TextView textView = this.w;
                textView.setText(this.V + getActivity().getResources().getString(c.a.u0.p4.i.video_recommend));
            }
            this.q.setOnClickListener(new u0(this, b02));
        }
    }

    public final void h2() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        e2 e2Var;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048624, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        String str3 = videoItemData.forum_id;
        String str4 = videoItemData.forum_name;
        String str5 = videoItemData.title;
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.mVideoData.baijiahaoData.oriUgcType + "&dvid=" + this.mVideoData.baijiahaoData.oriUgcVid + "&nid=" + this.mVideoData.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData.thread_id;
            str2 = "?share=9105&fr=sharewise";
        }
        String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str7 = this.mVideoData.thumbnail_url;
        String string = TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.share_content_tpl);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.default_share_content_tpl);
        VideoItemData videoItemData3 = this.mVideoData;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(c.a.u0.p4.i.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str5;
        shareItem.s = format;
        if (this.mVideoData.baijiahaoData == null) {
            shareItem.R = videoItemData2.play_count;
        }
        if (this.mVideoData.isBjhVideo) {
            shareItem.D = format;
        } else {
            shareItem.D = "";
        }
        shareItem.t = str6;
        shareItem.o = 2;
        shareItem.q = str;
        shareItem.F = 3;
        shareItem.J = str3;
        shareItem.p = str4;
        shareItem.K = str;
        VideoItemData videoItemData4 = this.mVideoData;
        shareItem.X = videoItemData4.post_id;
        shareItem.f41023f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.Y = userItemData2.portrait;
            shareItem.Z = userItemData2.user_name;
            shareItem.a0 = userItemData2.getUserShowName();
        }
        int i2 = this.f48930e;
        if (i2 == 3) {
            shareItem.E = 25;
            shareItem.I = 19;
        } else if (i2 == 4) {
            shareItem.E = 29;
            shareItem.I = 20;
        } else {
            shareItem.E = 12;
            shareItem.I = 18;
        }
        if (this.mVideoData.getVideoType() == 1) {
            shareItem.M = 2;
        } else if (this.mVideoData.getVideoType() == 2) {
            shareItem.M = 8;
        } else if (this.mVideoData.getVideoType() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.mVideoData.isBjhVideo) {
            shareItem.m0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData5 = this.mVideoData;
        originalThreadInfo.f40386c = videoItemData5.thumbnail_url;
        originalThreadInfo.a = 3;
        originalThreadInfo.f40385b = videoItemData5.title;
        originalThreadInfo.f40389f = videoItemData5.thread_id;
        originalThreadInfo.p = videoItemData5.baijiahaoData;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        if (this.mVideoData.isWorksInfo()) {
            shareItem.G = 11;
        }
        if (c.a.t0.b.d.n0() && (e2Var = this.mVideoData.threadData) != null) {
            int k2 = c.a.t0.t.g.g.k(e2Var);
            UserItemData userItemData3 = this.mVideoData.author_info;
            String str8 = userItemData3 != null ? userItemData3.name_show : "";
            shareItem.y0 = c.a.t0.t.g.g.j(this.mVideoData.threadData, k2);
            VideoItemData videoItemData6 = this.mVideoData;
            shareItem.z0 = c.a.t0.t.g.g.i(videoItemData6.threadData, k2, videoItemData6.forum_name, shareItem.R, str8, "");
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = isUEGBackDisLike();
        shareDialogConfig.disLikeListener = this.a1;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.W);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = isHost();
        VideoItemData videoItemData7 = this.mVideoData;
        shareDialogConfig.isManager = videoItemData7.is_manager;
        shareDialogConfig.isOriginManager = videoItemData7.is_origin_manager;
        shareDialogConfig.showHeating = showHeating();
        shareDialogConfig.isSelfHeating = this.T;
        shareDialogConfig.heatingListener = this.Z0;
        e2 e2Var2 = this.mVideoData.threadData;
        if (e2Var2 != null) {
            shareDialogConfig.isCollected = e2Var2.n0() == 1;
            shareDialogConfig.isMadeTop = this.mVideoData.threadData.m2();
            shareDialogConfig.isAddedGood = this.mVideoData.threadData.N1();
        }
        c.a.u0.k0.h.c().l(shareDialogConfig);
    }

    public void handleActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048625, this, i2, i3, intent) == null) {
            c.a.u0.p4.o.a aVar = this.u0;
            if (aVar != null) {
                aVar.m(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                c.a.u0.k3.a.g().m(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                if (shareItem != null) {
                    statisticItem.param("tid", shareItem.K);
                    statisticItem.param("uid", shareItem.N);
                    statisticItem.param("fid", shareItem.J);
                    statisticItem.param("obj_type", intExtra2);
                    statisticItem.param("obj_locate", shareItem.I);
                }
                TiebaStatic.log(statisticItem);
                if (this.f48930e == 7) {
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SHARE_SUCCESS);
                    if (shareItem != null) {
                        statisticItem2.param("tid", shareItem.K);
                        statisticItem2.param("uid", shareItem.N);
                        statisticItem2.param("fid", shareItem.J);
                        statisticItem2.param("obj_type", intExtra2);
                        statisticItem2.param("obj_param1", 7);
                    }
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    public boolean handleBackPress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (G1()) {
                v1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void hideDraftDialog() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048627, this) == null) && (popupDialog = this.Y) != null && popupDialog.isShowing()) {
            this.Y.dismiss();
        }
    }

    public final boolean i1(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048628, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void i2(boolean z2) {
        c.a.u0.p4.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) || (jVar = this.y0) == null) {
            return;
        }
        jVar.c(C1());
        this.y0.d(getPageContext(), this.mVideoData, z2);
    }

    public boolean initTiePlusRichTextView() {
        InterceptResult invokeV;
        e2 e2Var;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData == null || (e2Var = videoItemData.threadData) == null) {
                return false;
            }
            if (videoItemData.mRichAbstractList == null && e2Var.Y0() == null) {
                return false;
            }
            this.r = (TextView) this.mRootView.findViewById(c.a.u0.p4.f.rich_text_view);
            this.s = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.tie_plus_iamge);
            this.t = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.tie_plus_container);
            this.q = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.recommend_layout);
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.t);
            d2.e(c.a.u0.p4.i.A_X05);
            d2.n(c.a.u0.p4.i.J_X04);
            d2.f(c.a.u0.p4.c.CAM_X0106);
            c.a.t0.s.v.b bVar = (c.a.t0.s.v.b) this.t.getBackground();
            bVar.C(SkinManager.getColor(0, c.a.u0.p4.c.CAM_X0106));
            this.t.setBackground(bVar);
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.r);
            d3.v(c.a.u0.p4.c.CAM_X0101);
            d3.z(c.a.u0.p4.d.T_X08);
            d3.A(c.a.u0.p4.i.F_X01);
            List<PbContent> q2 = TiePlusHelper.q(this.mVideoData.mRichAbstractList) != null ? TiePlusHelper.q(this.mVideoData.mRichAbstractList) : null;
            if (TiePlusHelper.q(this.mVideoData.threadData.Y0()) != null) {
                q2 = TiePlusHelper.q(this.mVideoData.threadData.Y0());
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(q2, 0);
            if (pbContent == null || (tiebaPlusInfo = pbContent.tiebaplus_info) == null) {
                return false;
            }
            Integer num = pbContent.type;
            Integer num2 = tiebaPlusInfo.jump_type;
            c.a.t0.f1.p.b c2 = c.a.t0.f1.p.b.c(num.intValue(), tiebaPlusInfo, this.mVideoData.threadData);
            this.E0 = c2;
            c2.b(this.mVideoData.threadData.T1);
            if (num2.intValue() != 3 && num2.intValue() != 7) {
                if (num2.intValue() == 2) {
                    this.s.setImageDrawable(SkinManager.getDrawable(c.a.u0.p4.e.icon_mask_down));
                } else if (num2.intValue() == 6) {
                    this.s.setImageDrawable(SkinManager.getDrawable(c.a.u0.p4.e.icon_mask_order));
                } else if (num2.intValue() == 5) {
                    this.s.setImageDrawable(SkinManager.getDrawable(c.a.u0.p4.e.icon_mask_message));
                } else {
                    this.s.setImageDrawable(SkinManager.getDrawable(c.a.u0.p4.e.icon_mask_link));
                }
            } else {
                this.s.setImageDrawable(SkinManager.getDrawable(c.a.u0.p4.e.icon_mask_wechat));
            }
            this.r.setText(tiebaPlusInfo.desc);
            this.t.setVisibility(0);
            this.q.setVisibility(8);
            this.t.setOnClickListener(new v0(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.T : invokeV.booleanValue;
    }

    public boolean isUEGBackDisLike() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            VideoItemData videoItemData = this.mVideoData;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.f48930e != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.N.setText(c.a.u0.p4.i.reply_something);
                DanmuPostDraftManager.f49032b.a().c(this.mVideoData.thread_id);
                return;
            }
            this.N.setText(c.a.u0.p4.i.draft_to_replay);
            DanmuPostDraftManager.f49032b.a().d(this.mVideoData.thread_id, str);
        }
    }

    public final void j2(View view, View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), animatorListenerAdapter}) == null) {
            int max = Math.max(i2, i3);
            int i10 = max - ((i2 + i3) - max);
            int max2 = Math.max(i4, i5);
            int i11 = max2 - ((i4 + i5) - max2);
            int max3 = Math.max(i9, i8);
            ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new z0(this, i11, i4, i5, i10, i2, i3, max3 - ((i9 + i8) - max3), i8, i9, view, view2));
            ofInt.addListener(animatorListenerAdapter);
            ofInt.setTarget(view);
            ofInt.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k1(int i2) {
        VideoItemData videoItemData;
        int i3;
        c.a.t0.o0.c k2;
        BaijiahaoData baijiahaoData;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048635, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.mVideoData) != null) {
            if (i2 == this.f48933h) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.mVideoData;
                    videoItemData2.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData2.agree_num, 0) - 1);
                    this.mVideoData.is_agreed = "0";
                    i3 = 1;
                    StatisticItem statisticItem = new StatisticItem("c12795");
                    statisticItem.param("tid", this.mVideoData.thread_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (i2 != this.f48933h) {
                        statisticItem.param("obj_type", i3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c12003");
                    statisticItem2.param("tid", this.mVideoData.thread_id);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (i2 != this.f48933h) {
                        statisticItem2.param("obj_type", i3);
                    } else {
                        statisticItem2.param("obj_type", 2);
                    }
                    if ("index".equals(this.W)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                        statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                    }
                    k2 = TbPageExtraHelper.k(getContext());
                    if (k2 != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                        StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                        if (i2 == this.f48933h) {
                            statisticItem3.param("obj_type", i3);
                        } else {
                            statisticItem3.param("obj_type", 2);
                        }
                        int i4 = this.f48930e;
                        if (i4 != 3 && i4 != 4) {
                            statisticItem3.param("obj_locate", 2);
                        } else {
                            statisticItem3.param("obj_locate", 1);
                            statisticItem3.param("obj_source", p1());
                        }
                        statisticItem3.param("tid", this.mVideoData.thread_id);
                        statisticItem3.param("fid", this.mVideoData.forum_id);
                        int i5 = this.f48930e;
                        if (i5 == 3) {
                            statisticItem3.param("obj_param1", 1);
                        } else if (i5 == 4) {
                            statisticItem3.param("obj_param1", 2);
                        } else if (i5 == 7) {
                            statisticItem3.param("obj_param1", 3);
                        }
                        TiebaStatic.log(statisticItem3);
                    }
                    if (TbPageExtraHelper.m() != null) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
                    }
                    TiebaStatic.log(statisticItem2);
                    h1();
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", this.mVideoData.thread_id);
                    httpMessage.addParam("op_type", i3);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addHeader("needSig", "1");
                    baijiahaoData = this.mVideoData.baijiahaoData;
                    if (baijiahaoData != null) {
                        httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                        httpMessage.addParam("ori_ugc_nid", this.mVideoData.baijiahaoData.oriUgcNid);
                        httpMessage.addParam("ori_ugc_vid", this.mVideoData.baijiahaoData.oriUgcVid);
                        httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.mVideoData.baijiahaoData.oriUgcType);
                    }
                    if (k2 != null) {
                        httpMessage.addParam("obj_source", k2.a());
                    }
                    sendMessage(httpMessage);
                    c.a.u0.z3.k0.e eVar = new c.a.u0.z3.k0.e();
                    AgreeData agreeData = new AgreeData();
                    str = this.mVideoData.thread_id;
                    if (str != null) {
                        agreeData.threadId = str;
                    }
                    agreeData.agreeNum = Long.valueOf(this.mVideoData.agree_num).longValue();
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = "1".equals(this.mVideoData.is_agreed);
                    eVar.f26209b = agreeData;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.mVideoData));
                    if (TbadkCoreApplication.isLogin() || i3 != 0) {
                    }
                    if (TbSingleton.getInstance().showStampMissionDialog && c.a.t0.b.d.t0()) {
                        c.a.u0.w3.b.r().A(0, 3);
                        c.a.u0.w3.b.r().G();
                    }
                    c.a.u0.w3.b.r().z(StampMission.Type.LIKE_THREAD);
                    return;
                }
                VideoItemData videoItemData3 = this.mVideoData;
                videoItemData3.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData3.agree_num, 0) + 1);
                this.mVideoData.is_agreed = "1";
                getClickItem(1);
            } else {
                videoItemData.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData.agree_num, 0) + 1);
                this.mVideoData.is_agreed = "1";
                getClickItem(1);
            }
            i3 = 0;
            StatisticItem statisticItem4 = new StatisticItem("c12795");
            statisticItem4.param("tid", this.mVideoData.thread_id);
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 != this.f48933h) {
            }
            TiebaStatic.log(statisticItem4);
            StatisticItem statisticItem22 = new StatisticItem("c12003");
            statisticItem22.param("tid", this.mVideoData.thread_id);
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 != this.f48933h) {
            }
            if ("index".equals(this.W)) {
            }
            k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
            }
            if (TbPageExtraHelper.m() != null) {
            }
            TiebaStatic.log(statisticItem22);
            h1();
            HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage2.addParam("thread_id", this.mVideoData.thread_id);
            httpMessage2.addParam("op_type", i3);
            httpMessage2.addParam("obj_type", 3);
            httpMessage2.addParam("agree_type", 2);
            httpMessage2.addHeader("needSig", "1");
            baijiahaoData = this.mVideoData.baijiahaoData;
            if (baijiahaoData != null) {
            }
            if (k2 != null) {
            }
            sendMessage(httpMessage2);
            c.a.u0.z3.k0.e eVar2 = new c.a.u0.z3.k0.e();
            AgreeData agreeData2 = new AgreeData();
            str = this.mVideoData.thread_id;
            if (str != null) {
            }
            agreeData2.agreeNum = Long.valueOf(this.mVideoData.agree_num).longValue();
            agreeData2.agreeType = 2;
            agreeData2.hasAgree = "1".equals(this.mVideoData.is_agreed);
            eVar2.f26209b = agreeData2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar2));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.mVideoData));
            if (TbadkCoreApplication.isLogin()) {
            }
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || this.mVideoData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
        statisticItem.param("tid", this.mVideoData.thread_id);
        statisticItem.param("fid", this.mVideoData.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        int i2 = this.f48930e;
        if (i2 != 3 && i2 != 4) {
            statisticItem.param("obj_type", 2);
        } else {
            statisticItem.param("obj_type", 1);
        }
        statisticItem.param("obj_type", p1());
        int i3 = this.f48930e;
        if (i3 == 3) {
            statisticItem.param("obj_source", 1);
        } else if (i3 == 4) {
            statisticItem.param("obj_source", 2);
        } else if (i3 == 7) {
            statisticItem.param("obj_source", 3);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void l1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z2) == null) {
            if (z2) {
                T1(8);
                this.mDragContainer.setVisibility(0);
                return;
            }
            T1(0);
            this.mDragContainer.setVisibility(8);
        }
    }

    public final void l2(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048638, this, str, z2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_HORIZONTAL_PLAY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", str);
            statisticItem.param("obj_type", z2 ? 1 : 2);
            int i2 = this.f48930e;
            if (i2 != 3 && i2 != 4) {
                statisticItem.param("obj_locate", 1);
            } else {
                statisticItem.param("obj_locate", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048639, this) == null) || this.mVideoData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.mVideoData.thread_id);
        statisticItem.param("nid", this.mVideoData.nid);
        statisticItem.param("fid", this.mVideoData.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.U);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", c.a.d.f.p.m.isEmpty(this.mVideoData.mRecomWeight) ? "0" : this.mVideoData.mRecomWeight);
        statisticItem.param("extra", c.a.d.f.p.m.isEmpty(this.mVideoData.mRecomExtra) ? "0" : this.mVideoData.mRecomExtra);
        statisticItem.param("obj_id", this.h0);
        statisticItem.param("ab_tag", c.a.d.f.p.m.isEmpty(this.mVideoData.mRecomAbTag) ? "0" : this.mVideoData.mRecomAbTag);
        statisticItem.param("obj_source", c.a.d.f.p.m.isEmpty(this.mVideoData.mRecomSource) ? "0" : this.mVideoData.mRecomSource);
        statisticItem.param("obj_type", this.W);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.mVideoData.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.mVideoData.baijiahaoData.oriUgcVid);
            int i2 = this.mVideoData.baijiahaoData.oriUgcType;
            if (i2 == 4) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        int i3 = this.f48930e;
        if (i3 == 3 || i3 == 4) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.W);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.X);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.k;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.g0 = this.k.getControl().getVideoStatus();
            } else {
                this.g0 = TbCyberVideoView.VideoStatus.INIT;
            }
        }
    }

    public final int n1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            int screenHeight = UtilHelper.getScreenHeight(this.mRootView.getContext());
            if (I1()) {
                i2 = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            } else {
                screenHeight -= UtilHelper.getDimenPixelSize(c.a.u0.p4.d.M_H_X004);
                i2 = VideoMiddleNiaiControllerView.VERTICLE_CENTER_PADDING_BOTTOM;
            }
            return screenHeight - i2;
        }
        return invokeV.intValue;
    }

    public final RelativeLayout.LayoutParams o1() {
        InterceptResult invokeV;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            int n1 = n1();
            int k2 = c.a.d.f.p.n.k(this.mRootView.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(k2, n1);
            TbVideoViewContainer tbVideoViewContainer = this.k;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && (videoItemData = this.mVideoData) != null) {
                int e2 = c.a.d.f.m.b.e(videoItemData.video_height, 0);
                int e3 = c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
                if (e2 > 0 && e3 > 0 && n1 > 0 && k2 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(k2, n1);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.f0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.f0.addRule(14);
                        this.f0.topMargin = (n1 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds166)) / 2;
                    } else {
                        float f3 = f2 * k2;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(k2, (int) f3);
                        layoutParams3.topMargin = ((int) (n1 - f3)) / 2;
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.f0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.f0.addRule(14);
                        this.f0.topMargin = (n1 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds166)) / 2;
                        layoutParams = layoutParams3;
                    }
                    this.play_btn.requestLayout();
                }
            }
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.a0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(new i0(this));
            c.a.t0.i.a c2 = c.a.t0.i.a.c(getBaseFragmentActivity());
            this.b0 = c2;
            if (c2 != null) {
                c2.j(new j0(this));
            }
            this.c0 = new c.a.t0.t.e.a(null);
            registerListener(this.O0);
            registerListener(this.P0);
            registerListener(this.R0);
            registerListener(this.S0);
            registerListener(this.T0);
            registerListener(this.U0);
            registerListener(this.N0);
            registerListener(this.V0);
            registerListener(this.X0);
            if (TbSingleton.getInstance().getIsNeedShowPbCommentFloat() || AbsVideoChannelFragment.isShowComment) {
                r1();
                TbSingleton.getInstance().setIsNeedShowPbCommentFloat(false);
                AbsVideoChannelFragment.isShowComment = false;
            }
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.q0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048644, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            handleActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.u0 != null && this.u0.a() != null) {
                    this.u0.a().onChangeSkinType(i2);
                }
                if (this.Z != null) {
                    this.Z.i();
                }
                if (this.mRootView != null) {
                    this.mCommentImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.p4.e.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.mShareImg.setImageDrawable(WebPManager.getMaskDrawable(F1() ? c.a.u0.p4.e.icon_mask_video_more36 : c.a.u0.p4.e.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.share_icon_changed.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.p4.e.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.play_btn.setImageDrawable(WebPManager.getMaskDrawable(c.a.u0.p4.e.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                    this.videoLoadingIcon.setImageDrawable(WebPManager.getPureDrawable(c.a.u0.p4.e.icon_pure_header40_n, c.a.u0.z3.c.a(SkinManager.getColor(c.a.u0.p4.c.CAM_X0213), 0.2f), null));
                    d1();
                    c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.M);
                    d2.n(c.a.u0.p4.i.J_X05);
                    d2.f(c.a.u0.p4.c.CAM_X0613);
                    c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.dragCurTime);
                    d3.A(c.a.u0.p4.i.F_X02);
                    d3.v(c.a.u0.p4.c.CAM_X0101);
                    c.a.t0.s.v.c.d(this.dragTotalTime).A(c.a.u0.p4.i.F_X02);
                    c.a.t0.s.v.c d4 = c.a.t0.s.v.c.d(this.mShareNum);
                    d4.z(c.a.u0.p4.d.T_X09);
                    d4.A(c.a.u0.p4.i.F_X02);
                    d4.y(c.a.u0.p4.b.S_O_X001);
                    c.a.t0.s.v.c d5 = c.a.t0.s.v.c.d(this.mAgreeNum);
                    d5.z(c.a.u0.p4.d.T_X09);
                    d5.A(c.a.u0.p4.i.F_X02);
                    d5.y(c.a.u0.p4.b.S_O_X001);
                    c.a.t0.s.v.c d6 = c.a.t0.s.v.c.d(this.mCommentNum);
                    d6.z(c.a.u0.p4.d.T_X09);
                    d6.A(c.a.u0.p4.i.F_X02);
                    d6.y(c.a.u0.p4.b.S_O_X001);
                    c.a.t0.s.v.c d7 = c.a.t0.s.v.c.d(this.mAuthorNameTv);
                    d7.z(c.a.u0.p4.d.T_X06);
                    d7.A(c.a.u0.p4.i.F_X02);
                    d7.y(c.a.u0.p4.b.S_O_X001);
                    c.a.t0.s.v.c d8 = c.a.t0.s.v.c.d(this.B);
                    d8.n(c.a.u0.p4.i.J_X01);
                    d8.z(c.a.u0.p4.d.T_X09);
                    d8.v(c.a.u0.p4.c.CAM_X0101);
                    d8.A(c.a.u0.p4.i.F_X02);
                    d8.f(c.a.u0.p4.c.CAM_X0302);
                    this.dragTotalTime.setTextColor(c.a.u0.z3.c.a(SkinManager.getColor(c.a.u0.p4.c.CAM_X0101), c.a.t0.s.v.a.a(c.a.u0.p4.i.A_X08)));
                    this.mAgreeNum.setTextColor(c.a.u0.z3.c.a(SkinManager.getColor(c.a.u0.p4.c.CAM_X0101), c.a.t0.s.v.a.a(c.a.u0.p4.i.A_X03)));
                    this.mShareNum.setTextColor(c.a.u0.z3.c.a(SkinManager.getColor(c.a.u0.p4.c.CAM_X0101), c.a.t0.s.v.a.a(c.a.u0.p4.i.A_X03)));
                    this.mCommentNum.setTextColor(c.a.u0.z3.c.a(SkinManager.getColor(c.a.u0.p4.c.CAM_X0101), c.a.t0.s.v.a.a(c.a.u0.p4.i.A_X03)));
                }
                WebPManager.setPureDrawable(this.mBackBtn, c.a.u0.p4.e.icon_pure_topbar_return40, c.a.u0.p4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.mMoreBtn, c.a.u0.p4.e.icon_pure_topbar_more40, c.a.u0.p4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                t1();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.u0.p4.m.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, view) == null) {
            super.onClick(view);
            if (view.getId() != c.a.u0.p4.f.video_play_danmu_switch || (cVar = this.m) == null) {
                return;
            }
            cVar.i();
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null) {
                this.m.e(videoItemData.thread_id, this.f48930e);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.I && (videoItemData = this.mVideoData) != null) {
                boolean z2 = c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
                c.a.u0.p4.t.a aVar = this.x0;
                if (aVar == null || !z2) {
                    return;
                }
                if (!(aVar.isFullScreen() && configuration.orientation == 1) && (this.x0.isFullScreen() || configuration.orientation != 2)) {
                    return;
                }
                this.f48935j.removeView(this.k);
                this.x0.S(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.Q0);
            registerListener(this.h1);
            registerListener(this.i1);
            this.y0 = new c.a.u0.p4.j();
            getLifecycle().addObserver(this.W0);
            if (this.C0 == null) {
                this.C0 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.VIDEO_MOUNT, getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        TbVideoViewContainer tbVideoViewContainer;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048649, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
                this.F = videoItemModel;
                this.mVideoData = videoItemModel == null ? null : videoItemModel.getVideoItemData();
                this.K = (Rect) arguments.getParcelable("video_cover_rect");
                this.U = arguments.getInt("video_index");
                arguments.getString("page_from");
                this.W = arguments.getString("from");
                this.X = arguments.getString("video_channel_tab");
                this.h0 = arguments.getString("obj_id");
                this.f48932g = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.f48930e = arguments.getInt("current_type");
                this.f48931f = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            }
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mVideoData.author_info.user_id)) {
                this.T = true;
            }
            if (A1() && c.a.t0.b.d.p0()) {
                this.mRootView = layoutInflater.inflate(c.a.u0.p4.g.video_middle_page_play_view, (ViewGroup) null);
            } else {
                this.mRootView = layoutInflater.inflate(c.a.u0.p4.g.video_play_view, (ViewGroup) null);
            }
            if (c.a.t0.b.d.m() && ((i2 = this.f48930e) == 1 || i2 == 7)) {
                this.mRootView.setBackground(null);
            } else {
                this.mRootView.setBackground(SkinManager.getColorDrawableWithClickState(c.a.u0.p4.c.CAM_X0611));
            }
            this.F0 = true;
            VideoItemData videoItemData2 = this.mVideoData;
            if (videoItemData2 != null && StringUtils.isNull(videoItemData2.video_url) && !StringUtils.isNull(this.mVideoData.thread_id)) {
                VideoDanmuController videoDanmuController = new VideoDanmuController(getPageContext(), getUniqueId(), this.mRootView, c.a.u0.p4.f.video_danmu, this.mVideoData, this.f48930e);
                this.l = videoDanmuController;
                videoDanmuController.X(new f(this));
                this.l.M();
            }
            this.mRootView.setOnTouchListener(new h(this, new GestureDetectorCompat(getContext(), new g(this))));
            this.mRootView.setOnLongClickListener(new i(this));
            TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(getContext());
            this.k = tbVideoViewContainer2;
            tbVideoViewContainer2.getControl().setStageType("2005");
            this.k.getControl().getMediaProgressObserver().j(new j(this));
            TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(c.a.u0.p4.f.video_cover);
            this.n = tbImageView;
            tbImageView.setDefaultBgResource(c.a.u0.p4.c.transparent);
            this.play_btn = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.play_btn);
            this.videoLoadingLayout = (RelativeLayout) this.mRootView.findViewById(c.a.u0.p4.f.video_loading_layout);
            this.videoLoadingIcon = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.video_loading_icon);
            this.n.setEvent(new l(this));
            this.f48935j = (RelativeLayout) this.mRootView.findViewById(c.a.u0.p4.f.video_play_view_container);
            setVideoBussinessAndAddView();
            this.o = this.mRootView.findViewById(c.a.u0.p4.f.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.back_btn);
            this.mBackBtn = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.more_btn);
            this.mMoreBtn = imageView2;
            imageView2.setVisibility(8);
            this.mPortraitContainer = this.mRootView.findViewById(c.a.u0.p4.f.portrait_container);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.recommend_layout);
            this.q = linearLayout;
            c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(linearLayout);
            d2.e(c.a.u0.p4.i.A_X05);
            d2.n(c.a.u0.p4.i.J_X04);
            d2.f(c.a.u0.p4.c.CAM_X0106);
            c.a.t0.s.v.b bVar = (c.a.t0.s.v.b) this.q.getBackground();
            bVar.C(SkinManager.getColor(0, c.a.u0.p4.c.CAM_X0106));
            this.q.setBackground(bVar);
            this.u = (BarImageView) this.mRootView.findViewById(c.a.u0.p4.f.recommend_forum_avatar);
            this.v = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.recommend_avatar);
            this.u.setShowOval(true);
            TextView textView = (TextView) this.mRootView.findViewById(c.a.u0.p4.f.recommend_info_view);
            this.w = textView;
            c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(textView);
            d3.v(c.a.u0.p4.c.CAM_X0101);
            d3.z(c.a.u0.p4.d.T_X08);
            d3.A(c.a.u0.p4.i.F_X01);
            HeadImageView headImageView = (HeadImageView) this.mRootView.findViewById(c.a.u0.p4.f.author_portrait);
            this.author_portrait = headImageView;
            headImageView.setDefaultResource(17170445);
            this.author_portrait.setPlaceHolder(2);
            this.author_portrait.setIsRound(true);
            this.author_portrait.setBorderWidth(c.a.u0.p4.d.L_X02);
            this.author_portrait.setBorderColor(c.a.u0.p4.c.CAM_X0622);
            this.author_portrait.setDrawBorder(true);
            this.author_portrait.setUseNightOrDarkMask(false);
            Y1();
            this.mLiveLottieView = (TBLottieAnimationView) this.mRootView.findViewById(c.a.u0.p4.f.user_living_lottie);
            this.mAttentionLottieView = (TBLottieAnimationView) this.mRootView.findViewById(c.a.u0.p4.f.attention_lottie);
            this.D = (RelativeLayout) this.mRootView.findViewById(c.a.u0.p4.f.author_info_container);
            this.mBottomContainer = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.bottom_container);
            this.B = (TBSpecificationBtn) this.mRootView.findViewById(c.a.u0.p4.f.love_btn);
            c.a.t0.s.l0.n.a aVar = new c.a.t0.s.l0.n.a();
            UtilHelper.addFollowUserIconStyle(aVar);
            aVar.h(c.a.u0.p4.c.CAM_X0101);
            aVar.m(0, 0);
            aVar.n(0);
            aVar.k(true);
            aVar.j(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.p4.d.tbds145), c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), c.a.u0.p4.d.tbds60));
            this.B.setConfig(aVar);
            this.B.setText(getString(c.a.u0.p4.i.attention));
            this.mAgreeImg = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.agree_img);
            this.video_title = (ExpandableTextView) this.mRootView.findViewById(c.a.u0.p4.f.video_title);
            this.x = (TextView) this.mRootView.findViewById(c.a.u0.p4.f.title_full_screen_text);
            this.y = this.mRootView.findViewById(c.a.u0.p4.f.title_full_screen_btn);
            this.z = this.mRootView.findViewById(c.a.u0.p4.f.title_play_icon);
            this.A = this.mRootView.findViewById(c.a.u0.p4.f.video_title_layout);
            this.H = (VideoMiddleNiaiControllerView) this.mRootView.findViewById(c.a.u0.p4.f.media_controller);
            this.C = (TextView) this.mRootView.findViewById(c.a.u0.p4.f.video_activity);
            this.commentContainer = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.comment_container);
            this.mCommentNum = (EMTextView) this.mRootView.findViewById(c.a.u0.p4.f.comment_num);
            this.mCommentImg = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.comment_img);
            this.agreeContainer = (RelativeLayout) this.mRootView.findViewById(c.a.u0.p4.f.agree_container);
            this.mDragContainer = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.ll_drag_container);
            this.shareContainer = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.share_container);
            this.A0 = (RelativeLayout) this.mRootView.findViewById(c.a.u0.p4.f.video_background_view);
            this.G0 = this.mRootView.findViewById(c.a.u0.p4.f.video_top_obscuration_view);
            this.H0 = this.mRootView.findViewById(c.a.u0.p4.f.video_bottom_obscuration_view);
            if (c.a.t0.b.d.m() && !B1() && this.K != null) {
                V1(8);
            } else {
                V1(0);
            }
            c1();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDragContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mBottomContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.shareContainer.getLayoutParams();
            int i3 = this.f48930e;
            if (i3 != 4 && i3 != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.H.initProgressUIType(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.tbds211);
                if (A1() && c.a.t0.b.d.p0()) {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.tbds145);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.tbds158);
                } else {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.tbds123);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.tbds126);
                }
            } else {
                this.H.initProgressUIType(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(c.a.u0.p4.d.M_H_X007);
            }
            this.mAgreeNum = (EMTextView) this.mRootView.findViewById(c.a.u0.p4.f.agree_num);
            this.mShareImg = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.share_img);
            this.mShareNum = (EMTextView) this.mRootView.findViewById(c.a.u0.p4.f.share_num);
            this.dragCurTime = (EMTextView) this.mRootView.findViewById(c.a.u0.p4.f.drag_cur_time);
            this.dragTotalTime = (EMTextView) this.mRootView.findViewById(c.a.u0.p4.f.drag_total_time);
            this.share_icon = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.share_img);
            this.share_icon_changed = (ImageView) this.mRootView.findViewById(c.a.u0.p4.f.share_img_changed);
            Q1();
            this.E = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.video_act_private_container);
            this.videoActivityContainer = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.video_activity_container);
            this.video_private = (LinearLayout) this.mRootView.findViewById(c.a.u0.p4.f.video_private);
            this.mAuthorNameTv = (TextView) this.mRootView.findViewById(c.a.u0.p4.f.video_author_name);
            this.M = this.mRootView.findViewById(c.a.u0.p4.f.quick_reply_comment_layout);
            if (c.a.t0.b.d.p0()) {
                this.M.setVisibility(0);
            } else {
                this.M.setVisibility(8);
            }
            this.M.setOnClickListener(new m(this));
            if (this.mVideoData != null) {
                this.H.setVisibility(0);
            }
            this.H.setPlayer(this.k.getControl());
            this.H.setOnSeekBarChangeListener(new n(this));
            this.N = (TextView) this.mRootView.findViewById(c.a.u0.p4.f.quick_reply_comment_text);
            TextView textView2 = (TextView) this.mRootView.findViewById(c.a.u0.p4.f.download_nani_guide_txt);
            this.G = textView2;
            textView2.setVisibility(8);
            String q2 = c.a.t0.s.j0.b.k().q("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(q2)) {
                this.G.setText(q2);
            }
            this.G.setOnClickListener(new o(this, c.a.t0.s.j0.b.k().q("nani_key_download_link_url", null)));
            h1();
            p pVar = new p(this);
            this.mPortraitContainer.setOnClickListener(pVar);
            this.mAuthorNameTv.setOnClickListener(pVar);
            this.videoActivityContainer.setOnClickListener(new q(this));
            this.video_title.setHasDown();
            this.video_title.setOnClickListener(new r(this));
            this.mBackBtn.setOnClickListener(new s(this));
            this.mMoreBtn.setOnClickListener(new t(this));
            this.commentContainer.setOnClickListener(new u(this));
            this.agreeContainer.setOnClickListener(new w(this));
            this.shareContainer.setOnClickListener(new x(this));
            this.B.setOnClickListener(new y(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.J = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.J.setAnimationListener(new z(this));
            this.videoLoadingLayout.setVisibility(0);
            if (this.I) {
                this.H.setLoading(true);
            }
            if (this.K != null && (tbVideoViewContainer = this.k) != null && tbVideoViewContainer.getParent() != null) {
                Rect rect = this.K;
                int i4 = rect.right;
                int i5 = rect.left;
                this.P = i4 - i5;
                int i6 = rect.bottom;
                int i7 = rect.top;
                this.Q = i6 - i7;
                this.R = i5;
                this.S = i7;
                int i8 = c.a.d.f.p.n.i(this.mRootView.getContext());
                if (c.a.t0.b.d.m()) {
                    this.k.post(new a0(this, i8));
                } else {
                    this.k.post(new b0(this));
                }
            }
            x1();
            if (this.I) {
                m1();
            }
            VideoItemData videoItemData3 = this.mVideoData;
            if (videoItemData3 != null && !StringUtils.isNull(videoItemData3.video_url)) {
                b2(this.mVideoData.video_url);
                if (c.a.t0.b.d.p0()) {
                    VideoDanmuController videoDanmuController2 = new VideoDanmuController(getPageContext(), getUniqueId(), this.mRootView, c.a.u0.p4.f.video_danmu, this.mVideoData, this.f48930e);
                    this.l = videoDanmuController2;
                    videoDanmuController2.P(this.Y0);
                }
            }
            if (c.a.t0.b.d.p0()) {
                c.a.u0.p4.m.c cVar = new c.a.u0.p4.m.c(this.mRootView, c.a.u0.p4.f.video_play_danmu_switch);
                this.m = cVar;
                cVar.g(this);
                this.m.h(new c0(this));
            }
            c.a.u0.p4.t.a aVar2 = new c.a.u0.p4.t.a(getPageContext(), getUniqueId(), this.f48935j, this.f48930e);
            this.x0 = aVar2;
            aVar2.setStageType("2005");
            this.x0.setUniqueId(getUniqueId());
            VideoItemData videoItemData4 = this.mVideoData;
            if (videoItemData4 != null && videoItemData4.threadData == null) {
                videoItemData4.threadData = new e2();
                VideoItemData videoItemData5 = this.mVideoData;
                e2 e2Var = videoItemData5.threadData;
                e2Var.E = videoItemData5.thread_id;
                e2Var.d0 = 40;
                e2Var.s4(c.a.d.f.m.b.e(videoItemData5.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(c.a.d.f.m.b.e(this.mVideoData.video_width, 0));
                builder.video_height = Integer.valueOf(c.a.d.f.m.b.e(this.mVideoData.video_height, 0));
                VideoItemData videoItemData6 = this.mVideoData;
                builder.video_url = videoItemData6.video_url;
                builder.thumbnail_url = videoItemData6.thumbnail_url;
                builder.video_md5 = videoItemData6.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData6.isVerticalVideo);
                this.mVideoData.threadData.L4(builder.build(true));
            }
            VideoItemData videoItemData7 = this.mVideoData;
            if (videoItemData7 != null) {
                a2(videoItemData7, this.x0, this.l);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                if (c.a.t0.b.d.D0()) {
                    c.a.d.f.m.e.a().post(this.L0);
                } else if (this.s0 != 0) {
                    c.a.d.f.m.e.a().post(this.L0);
                }
            }
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            stopPlay();
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.Q0);
            MessageManager.getInstance().unRegisterListener(this.h1);
            MessageManager.getInstance().unRegisterListener(this.i1);
            if (this.f1 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.f1);
                this.f1 = null;
            }
            c.a.u0.p4.j jVar = this.y0;
            if (jVar != null) {
                jVar.b();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.L0);
            getLifecycle().removeObserver(this.W0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            super.onDestroyView();
            VideoDanmuController videoDanmuController = this.l;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            c.a.u0.p4.m.c cVar = this.m;
            if (cVar != null) {
                cVar.f();
            }
            c.a.u0.p4.t.a aVar = this.x0;
            if (aVar != null) {
                aVar.D0();
            }
            c.a.u0.p4.o.a aVar2 = this.u0;
            if (aVar2 != null) {
                aVar2.n();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.H;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.setOnSeekBarChangeListener(null);
            }
            TbImageView tbImageView = this.n;
            if (tbImageView != null) {
                tbImageView.setEvent(null);
            }
            LinearLayout linearLayout = this.commentContainer;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(null);
            }
            LinearLayout linearLayout2 = this.q;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(null);
            }
            View view = this.M;
            if (view != null) {
                view.setOnClickListener(null);
            }
            ExpandableTextView expandableTextView = this.video_title;
            if (expandableTextView != null) {
                expandableTextView.setOnStatusChangedListener(null);
            }
            TBSpecificationBtn tBSpecificationBtn = this.B;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(null);
            }
            LinearLayout linearLayout3 = this.t;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(null);
            }
            LinearLayout linearLayout4 = this.shareContainer;
            if (linearLayout4 != null) {
                linearLayout4.setOnClickListener(null);
            }
            RelativeLayout relativeLayout = this.agreeContainer;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(null);
            }
            LinearLayout linearLayout5 = this.videoActivityContainer;
            if (linearLayout5 != null) {
                linearLayout5.setOnClickListener(null);
            }
            View view2 = this.mPortraitContainer;
            if (view2 != null) {
                view2.setOnClickListener(null);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.L0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            super.onPause();
            if (!this.k0) {
                L1();
            }
            v1();
            TiePlusEventController tiePlusEventController = this.C0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            super.onPrimary();
            if (isResumed() && this.I) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.I) {
                        P1();
                        R1();
                        O1(0);
                    } else {
                        L1();
                    }
                }
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2 == null || (alaInfoData = videoItemData2.mAlaInfoData) == null || !alaInfoData.isLegalYYLiveData() || this.mVideoData.mAlaInfoData.live_status != 1) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("tid", this.mVideoData.getThreadId());
                UserItemData userItemData = this.mVideoData.author_info;
                if (userItemData != null) {
                    statisticItem.addParam("obj_id", userItemData.user_id);
                    statisticItem.addParam("obj_name", this.mVideoData.author_info.user_name);
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            L1();
            v1();
            this.F0 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            super.onResume();
            if (this.B0) {
                this.B0 = false;
                c.a.d.f.m.e.a().removeCallbacks(this.L0);
                O1(1);
                startPlay();
                m1();
                this.q0 = false;
            }
            TiePlusEventController tiePlusEventController = this.C0;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            super.onStart();
            if (this.k0) {
                R1();
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onStatusChange(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PREPARED) {
                setVideoBtnAndHeightWidth();
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.videoLoadingLayout;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2 = this.H;
                if (videoMiddleNiaiControllerView2 != null) {
                    videoMiddleNiaiControllerView2.setLoading(false);
                }
                m1 m1Var = this.w0;
                if (m1Var != null) {
                    m1Var.onStart();
                }
                TbImageView tbImageView = this.n;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                if (!TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                    TbSingleton.getInstance().setEnableVideoVerticalPreload(true);
                }
                VideoDanmuController videoDanmuController = this.l;
                if (videoDanmuController != null) {
                    videoDanmuController.U();
                }
            } else {
                VideoDanmuController videoDanmuController2 = this.l;
                if (videoDanmuController2 != null) {
                    videoDanmuController2.R();
                }
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView = this.H) != null) {
                videoMiddleNiaiControllerView.setLoading(false);
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.H != null && this.I && isResumed()) {
                this.H.setLoading(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048657, this) == null) {
            super.onStop();
            L1();
            v1();
            c.a.d.f.m.e.a().removeCallbacks(this.L0);
        }
    }

    @Override // c.a.t0.f1.r.b.InterfaceC0867b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            if (G1()) {
                v1();
                return;
            }
            TbVideoViewContainer tbVideoViewContainer = this.k;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.k.getControl().isCanShowPause()) {
                return;
            }
            if (this.k.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.k.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                if (this.k.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PAUSING || f2()) {
                    return;
                }
                this.k.getControl().start();
                this.play_btn.setVisibility(8);
                f1(true);
                this.H.showProgress();
                if (isResumed() && this.I) {
                    return;
                }
                L1();
                return;
            }
            this.k.getControl().pause();
            W1();
            f1(false);
            c.a.d.f.m.e.a().removeCallbacks(this.f1);
            getClickItem(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048659, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            h1();
            Z1();
        }
    }

    @Override // c.a.t0.f1.r.b.InterfaceC0867b
    public void onViewDoubleClick(float f2, float f3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048660, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.mVideoData) != null && "0".equals(videoItemData.is_agreed)) {
            k1(this.f48934i);
        }
    }

    @Override // c.a.t0.f1.r.b.InterfaceC0867b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048661, this) == null) || E1() || G1() || (videoItemData = this.mVideoData) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long g2 = c.a.d.f.m.b.g(userItemData.user_id, 0L);
        long g3 = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        int i2 = 1;
        boolean z2 = (g2 == 0 && g3 == 0) ? false : g2 == g3;
        c.a.u0.p4.n.a.a();
        String str = this.mVideoData.author_info.portrait;
        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
        int i3 = this.f48930e;
        PersonPolymericActivityConfig createNormalConfig = personPolymericActivityConfig.createNormalConfig(g2, z2, false, true, (i3 == 3 || i3 == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
        createNormalConfig.setPortrait(str);
        createNormalConfig.setSourceTid(this.mVideoData.thread_id);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DRAG_TO_PERSONAL_CENTER);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", this.mVideoData.thread_id);
        int i4 = this.f48930e;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    i2 = 4;
                } else if (i4 == 4) {
                    i2 = 3;
                }
            }
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
        i2 = 2;
        statisticItem.param("obj_locate", i2);
        TiebaStatic.log(statisticItem);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.W)) {
                return 0;
            }
            String str = this.W;
            int hashCode = str.hashCode();
            if (hashCode == 101671) {
                if (str.equals("frs")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 100346066) {
                if (hashCode == 157161846 && str.equals("concern_tab")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return c2 != 2 ? 7 : 4;
                }
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final ObjectAnimator q1(float f2, float f3, float f4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048663, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.play_btn, PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f3), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f4));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            s1(null);
        }
    }

    public final void s1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048665, this, str) == null) || this.mVideoData == null) {
            return;
        }
        PbCommentFloatActivityConfig pbCommentFloatActivityConfig = new PbCommentFloatActivityConfig(getActivity());
        VideoItemData videoItemData = this.mVideoData;
        PbCommentFloatActivityConfig createNormalCfg = pbCommentFloatActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mVideoData.forum_id));
        createNormalCfg.setForumName(this.mVideoData.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.mVideoData.baijiahaoData);
        int i2 = this.f48930e;
        createNormalCfg.setFromPageType((i2 == 3 || i2 == 4) ? 1 : 2);
        createNormalCfg.setFromVideoPageType(this.f48930e);
        createNormalCfg.setFromVideoPageUniqueId(this.f48932g);
        createNormalCfg.setForceInterceptStimeStat(true);
        createNormalCfg.setHighLight3sPostId(str);
        if (this.mVideoData.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            if (this.mVideoData.threadData.J() != null) {
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2.author_info != null) {
                    videoItemData2.threadData.J().setIsLike("1".equals(this.mVideoData.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            c.a.u0.e1.l.update(this.mVideoData.threadData);
        }
        GoPbCommentFloatListener.sendMessage();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.k0 = true;
        VideoDanmuController videoDanmuController = this.l;
        if (videoDanmuController != null) {
            videoDanmuController.R();
            this.l.H();
        }
        m2();
        this.x0.U(!this.k0);
        showPbCommentFloatNum();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
    }

    @Override // c.a.u0.p4.s.b.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i2) == null) {
            this.s0 = i2;
        }
    }

    public void setOnProgressUpdatedListener(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, cVar) == null) {
            this.v0 = cVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        c.a.t0.f1.p.b bVar;
        TbVideoViewContainer tbVideoViewContainer;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048668, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.I = z2;
            if (this.x0 != null && (videoItemData = this.mVideoData) != null) {
                this.x0.U(this.I && (c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0)));
            }
            if (!isResumed() && this.I && J1()) {
                this.B0 = true;
            }
            if (isResumed() && this.I && (!this.q0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                O1(1);
                startPlay();
                m1();
                this.q0 = false;
            } else if (!this.k0) {
                Q1();
                this.r0 = 1;
                L1();
                tryHidePlayEditor();
            }
            if (this.H != null) {
                if (this.I && isResumed() && (tbVideoViewContainer = this.k) != null && tbVideoViewContainer.getControl() != null && this.k.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                    this.H.setLoading(true);
                } else {
                    this.H.setLoading(false);
                }
            }
            if (!this.I || this.D0 || (bVar = this.E0) == null || this.C0 == null) {
                return;
            }
            bVar.q(TiePlusStat.StatType.EXPOSE);
            this.C0.statRichTextEvent(this.E0);
            this.D0 = true;
        }
    }

    public void setVideoBtnAndHeightWidth() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        int e2 = c.a.d.f.m.b.e(videoItemData.video_height, 0);
        int e3 = c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
        int n1 = n1();
        int k2 = c.a.d.f.p.n.k(this.mRootView.getContext());
        if (e2 <= 0 || e3 <= 0 || n1 <= 0 || k2 <= 0) {
            this.k.getControl().setVideoScalingMode(2);
            this.n.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        float f2 = (e2 * 1.0f) / e3;
        if (f2 > 1.0f) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
            this.f0 = layoutParams;
            layoutParams.removeRule(13);
            this.f0.addRule(14);
            this.f0.topMargin = (n1 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds166)) / 2;
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
            this.f0 = layoutParams2;
            layoutParams2.removeRule(13);
            this.f0.addRule(14);
            this.f0.topMargin = (n1 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds166)) / 2;
        }
        if (f2 > 1.34f) {
            this.k.getControl().setVideoScalingMode(0);
            this.n.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        this.k.getControl().setVideoScalingMode(2);
        this.n.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public void setVideoBussinessAndAddView() {
        TbVideoViewContainer tbVideoViewContainer;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        int i2;
        TbVideoViewContainer tbVideoViewContainer2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048670, this) == null) && (tbVideoViewContainer = this.k) != null && tbVideoViewContainer.getParent() == null) {
            if (this.mVideoData != null) {
                this.O = new RelativeLayout.LayoutParams(-1, -1);
                setVideoBtnAndHeightWidth();
                Rect rect = this.K;
                if (rect != null && !this.L) {
                    int i3 = rect.right;
                    int i4 = rect.left;
                    this.P = i3 - i4;
                    int i5 = rect.bottom;
                    int i6 = rect.top;
                    this.Q = i5 - i6;
                    RelativeLayout.LayoutParams layoutParams = this.O;
                    layoutParams.width = i3 - i4;
                    layoutParams.height = i5 - i6;
                    layoutParams.topMargin = i6;
                    layoutParams.leftMargin = i4;
                    layoutParams.rightMargin = i4;
                } else {
                    this.O = o1();
                }
                int i7 = this.f48930e;
                if (i7 != 4 && i7 != 3) {
                    this.O.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds60);
                } else {
                    this.O.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), c.a.u0.p4.d.tbds0);
                }
                this.n.setLayoutParams(this.O);
                if (this.f48935j != null && (tbVideoViewContainer2 = this.k) != null) {
                    tbVideoViewContainer2.setId(c.a.u0.p4.f.video_controller_tag);
                    if (A1() && c.a.t0.b.d.p0()) {
                        this.O.addRule(15);
                    }
                    this.f48935j.addView(this.k, 0, this.O);
                }
                boolean z2 = c.a.d.f.m.b.e(this.mVideoData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
                if (this.mVideoData.video_duration >= 60 && z2) {
                    View inflate = getLayoutInflater().inflate(c.a.u0.p4.g.video_full_screen, (ViewGroup) null);
                    this.mfullScreenView = inflate;
                    EMTextView eMTextView = (EMTextView) this.mfullScreenView.findViewById(c.a.u0.p4.f.full_screen_text);
                    WebPManager.setPureDrawable((ImageView) inflate.findViewById(c.a.u0.p4.f.full_screen_icon), c.a.u0.p4.e.icon_pure_video, c.a.u0.p4.c.CAM_X0101, null);
                    eMTextView.setTextColor(SkinManager.getColor(c.a.u0.p4.c.CAM_X0102));
                    eMTextView.setText(getString(c.a.u0.p4.i.video_full_screen));
                    eMTextView.setGravity(17);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(3, c.a.u0.p4.f.video_controller_tag);
                    layoutParams2.addRule(14, -1);
                    layoutParams2.topMargin = getResources().getDimensionPixelSize(c.a.u0.p4.d.M_H_X004);
                    this.f48935j.addView(this.mfullScreenView, layoutParams2);
                    l2(this.mVideoData.thread_id, true);
                    if (c.a.t0.b.d.m() && ((i2 = this.f48930e) == 1 || i2 == 7)) {
                        this.mfullScreenView.setVisibility(8);
                    } else {
                        this.mfullScreenView.setVisibility(0);
                    }
                    this.mfullScreenView.setOnClickListener(new a1(this));
                }
            }
            if (this.mVideoData != null) {
                c.a.u0.b3.t tVar = new c.a.u0.b3.t();
                tVar.f15612e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData = this.mVideoData;
                tVar.f15610c = videoItemData.thread_id;
                tVar.t = videoItemData.nid;
                tVar.f15611d = videoItemData.forum_id;
                tVar.m = videoItemData.mMd5;
                tVar.k = "";
                tVar.f15613f = videoItemData.mRecomSource;
                tVar.l = videoItemData.mRecomAbTag;
                tVar.f15617j = 1;
                tVar.x = videoItemData.getChannelMidRequestNum();
                tVar.y = this.mVideoData.getChannelMidRequestVideoNum();
                BaijiahaoData baijiahaoData = this.mVideoData.baijiahaoData;
                if (baijiahaoData != null) {
                    int i8 = baijiahaoData.oriUgcType;
                    if (i8 == 2) {
                        tVar.f15617j = 3;
                    } else if (i8 == 4) {
                        tVar.f15617j = 2;
                    }
                }
                tVar.f15615h = this.mVideoData.mRecomWeight;
                if (this.K != null) {
                    tVar.n = "1";
                } else {
                    tVar.n = "2";
                }
                int i9 = this.f48930e;
                if (i9 == 1) {
                    tVar.p = "1";
                    tVar.a = "13";
                    tVar.f15616i = this.W;
                    tVar.k = this.h0;
                    tVar.f15614g = this.mVideoData.mRecomWeight;
                } else if (i9 == 2) {
                    tVar.a = "24";
                } else {
                    tVar.a = "13";
                }
                tVar.p = "1";
                int i10 = this.f48930e;
                if (i10 == 3) {
                    tVar.a = "21";
                } else if (i10 == 4) {
                    tVar.a = "22";
                } else if (i10 == 7) {
                    tVar.a = "26";
                } else if (z1()) {
                    tVar.a = "27";
                }
                String str = this.W;
                tVar.f15616i = str;
                String str2 = this.h0;
                tVar.k = str2;
                VideoItemData videoItemData2 = this.mVideoData;
                String str3 = videoItemData2.mRecomWeight;
                tVar.f15614g = str3;
                tVar.w = videoItemData2.mExtra;
                if (this.f48930e == 5) {
                    tVar.a = "23";
                    tVar.p = "1";
                    tVar.f15616i = str;
                    tVar.k = str2;
                    tVar.f15614g = str3;
                }
                if (y1() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    tVar.f15616i = personalPageParams.getStatPageFromIdentifier();
                }
                this.k.getControl().setVideoStatData(tVar);
                this.k.getControl().setLocateSource("v_mid_page");
            }
            this.k.getControl().setContinuePlayEnable(true);
        }
    }

    public void setVideoPlayPrefetcher(c.a.u0.p4.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, aVar) == null) {
            this.t0 = aVar;
        }
    }

    public void setVideoStatusListener(m1 m1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, m1Var) == null) {
            this.w0 = m1Var;
        }
    }

    public void showBlockDialog(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            dismissBlockDialog();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                i2 = z2 ? c.a.u0.p4.i.musk_my_thread_confirm : c.a.u0.p4.i.musk_thread_confirm;
                i3 = c.a.u0.p4.i.musk_my_thread_confirm_subtitle;
                i4 = c.a.u0.p4.i.shield;
            } else {
                i2 = c.a.u0.p4.i.del_my_thread_confirm;
                i3 = c.a.u0.p4.i.del_my_thread_confirm_subtitle;
                i4 = c.a.u0.p4.i.delete;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(c.a.u0.p4.i.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            c.a.t0.s.t.m mVar = new c.a.t0.s.t.m(TbadkCoreApplication.getInst().getCurrentActivity());
            mVar.v(i2);
            mVar.l(i3);
            mVar.n(true);
            mVar.r(aVar2, aVar);
            mVar.i(false);
            this.z0 = mVar.y();
            aVar.a(new c1(this, z2, z3));
            aVar2.a(new d1(this));
        }
    }

    public long showDownloadNaniGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            LinearLayout linearLayout = this.E;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView = this.G;
            if (textView != null) {
                textView.setVisibility(0);
                return System.currentTimeMillis();
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public void showDraftDialog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || this.Y == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.Y.showDialog();
    }

    public boolean showHeating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (c.a.t0.t.c.l0.e()) {
                int i2 = this.f48930e;
                return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void showPbCommentFloatNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.mVideoData.forum_id);
            int i2 = this.f48930e;
            if (i2 == 1) {
                statisticItem.param("obj_locate", 1);
            } else if (i2 == 2) {
                statisticItem.param("obj_locate", 2);
            } else if (i2 == 3) {
                statisticItem.param("obj_locate", 3);
            } else if (i2 == 4) {
                statisticItem.param("obj_locate", 4);
            } else if (i2 == 7) {
                statisticItem.param("obj_source", 5);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || f2()) {
            return;
        }
        d2();
        ImageView imageView = this.play_btn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbVideoViewContainer tbVideoViewContainer = this.k;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.play_btn != null && this.mVideoData != null && this.k.getParent() == null) {
            setVideoBussinessAndAddView();
            Z1();
        }
        if (Build.VERSION.SDK_INT < 17 && this.n.getVisibility() == 0) {
            this.n.clearAnimation();
            this.n.startAnimation(this.J);
        }
        TbVideoViewContainer tbVideoViewContainer2 = this.k;
        if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null && !TextUtils.isEmpty(this.e0) && this.mVideoData != null) {
            if (TbVideoViewSet.d().e(this.e0) == null || TbVideoViewSet.d().e(this.e0) != this.k) {
                this.k.getControl().setVideoPath(this.e0, this.mVideoData.thread_id);
            }
            if (!c.a.t0.b.d.D0()) {
                this.k.getControl().setIsVolume0(false);
            }
            this.k.getControl().start(this.M0);
            VideoDanmuController videoDanmuController = this.l;
            if (videoDanmuController != null) {
                videoDanmuController.a0();
            }
            this.H.showProgress();
            P1();
        }
        if (this.k0) {
            return;
        }
        if ((isResumed() && this.I) || J1()) {
            return;
        }
        L1();
        VideoDanmuController videoDanmuController2 = this.l;
        if (videoDanmuController2 != null) {
            videoDanmuController2.R();
        }
        if (this.play_btn != null) {
            W1();
        }
    }

    public final void stopPlay() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || (tbVideoViewContainer = this.k) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.k.getControl().stopPlayback();
    }

    public final void t1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048680, this) == null) || (tBLottieAnimationView = this.mLiveLottieView) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, c.a.u0.p4.h.card_live_header_bg);
    }

    public boolean tryHidePlayEditor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            if (G1()) {
                v1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void u1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048682, this, z2) == null) {
            int f2 = c.a.d.f.p.n.f(getContext(), c.a.u0.p4.d.tbds26);
            if (this.p != z2) {
                if (this.mLiveLottieView != null) {
                    if (z2) {
                        ViewGroup.LayoutParams layoutParams = this.mPortraitContainer.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.leftMargin = f2;
                            marginLayoutParams.rightMargin = f2;
                            this.mPortraitContainer.setLayoutParams(layoutParams);
                        }
                        this.mLiveLottieView.setVisibility(0);
                        if (!this.mLiveLottieView.isAnimating()) {
                            this.mLiveLottieView.setSpeed(0.8f);
                            this.mLiveLottieView.setRepeatCount(-1);
                            this.mLiveLottieView.post(new k0(this));
                        }
                    } else {
                        ViewGroup.LayoutParams layoutParams2 = this.mPortraitContainer.getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                            marginLayoutParams2.leftMargin = 0;
                            marginLayoutParams2.rightMargin = 0;
                            this.mPortraitContainer.setLayoutParams(layoutParams2);
                        }
                        this.mLiveLottieView.setVisibility(8);
                        if (this.mLiveLottieView.isAnimating()) {
                            this.mLiveLottieView.cancelAnimation();
                        }
                    }
                }
                this.p = z2;
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048683, this) == null) && G1()) {
            this.u0.a().hide();
            j1(((c.a.u0.p4.o.c) this.u0.a().findToolById(28)).f().getText().toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
            int i2 = this.f48930e;
            if (i2 == 4 || i2 == 3) {
                c2(0);
            }
            c1();
        }
    }

    public final void w1(View view, View view2, View view3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048684, this, new Object[]{view, view2, view3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), animatorListenerAdapter}) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int max = Math.max(i2, i3);
            int i14 = max - ((i2 + i3) - max);
            int max2 = Math.max(i4, i5);
            int max3 = Math.max(i12, i13);
            int max4 = Math.max(i9, i8);
            int i15 = max4 - ((i8 + i9) - max4);
            int max5 = Math.max(i10, i11);
            int i16 = max5 - ((i10 + i11) - max5);
            ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
            ofInt.setDuration(150L);
            ofInt.addUpdateListener(new x0(this, max2 - ((i4 + i5) - max2), max3 - ((i12 + i13) - max3), i4, i5, i12, i13, layoutParams, i14, i2, i3, i15, i16, i8, i9, i10, i11, view3, view, view2));
            ofInt.addListener(animatorListenerAdapter);
            ofInt.setTarget(view);
            ofInt.start();
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c.a.u0.p4.o.a aVar = (c.a.u0.p4.o.a) new c.a.u0.p4.o.b().g(getActivity(), new e0(this));
                this.u0 = aVar;
                if (aVar != null && this.mVideoData != null) {
                    aVar.r(getPageContext());
                    String b2 = TextUtils.isEmpty(this.mVideoData.thread_id) ? "" : DanmuPostDraftManager.f49032b.a().b(this.mVideoData.thread_id);
                    this.u0.s(this.mVideoData.thread_id, this.mVideoData.forum_id, this.mVideoData.forum_name, b2);
                    j1(b2);
                    this.u0.t(new f0(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.mRootView).addView(this.u0.a(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.f48930e == 6 : invokeV.booleanValue;
    }

    public final boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) ? this.f48930e == 8 : invokeV.booleanValue;
    }
}
