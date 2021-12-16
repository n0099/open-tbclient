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
import c.a.r0.f1.r.b;
import c.a.r0.i.a;
import c.a.r0.s.r.d2;
import c.a.r0.s.t.a;
import c.a.r0.s.t.i;
import c.a.s0.l4.m.c;
import c.a.s0.l4.o.a;
import c.a.s0.l4.o.b;
import c.a.s0.l4.t.a;
import c.a.s0.z2.f;
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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbConfig;
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
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
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
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
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
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
import tbclient.VideoInfo;
/* loaded from: classes12.dex */
public class VideoPlayFragment extends BaseFragment implements b.InterfaceC0814b, c.a.s0.l4.s.b.a, TbCyberVideoView.g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COVER_ANIMINATION_TIME = 350;
    public static final int COVER_TRANSFER_TIME = 200;
    public static final int DEFAULT_OVER_DURATION_LIMIT_TIME = 15000;
    public static final int DRAG_HIDE_SEEKBAR_TIME = 3000;
    public static final int TYPE_PB_VIDOE_SCHEMA = 9;
    public static final int TYPE_VIDEO_CHANNEL_ATTENTION = 4;
    public static final int TYPE_VIDEO_CHANNEL_RECOMMENT = 3;
    public static final int TYPE_VIDEO_FROM_FRS_VIDEO_TAB_PAGE = 7;
    public static final int TYPE_VIDEO_FROM_PERSONAL_PAGE = 6;
    public static final int TYPE_VIDEO_FROM_VIDEO_HOT_TOPIC = 8;
    public static final int TYPE_VIDEO_MIDDLE_ATTENTION = 2;
    public static final int TYPE_VIDEO_MIDDLE_RECOMMENT = 1;
    public static final int TYPE_VIDEO_RECOMMENT_PLAY = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public TBSpecificationBtn A;
    public TiePlusEventController A0;
    public TextView B;
    public boolean B0;
    public View C;
    public c.a.r0.f1.p.a C0;
    public LinearLayout D;
    public boolean D0;
    public VideoItemModel E;
    public ObjectAnimator E0;
    public TextView F;
    public ObjectAnimator F0;
    public VideoMiddleNiaiControllerView G;
    public final Runnable G0;
    public boolean H;
    public final TbVideoViewSet.b H0;
    public AlphaAnimation I;
    public final CustomMessageListener I0;
    public Rect J;
    public final CustomMessageListener J0;
    public boolean K;
    public final CustomMessageListener K0;
    public View L;
    public final CustomMessageListener L0;
    public TextView M;
    public final CustomMessageListener M0;
    public RelativeLayout.LayoutParams N;
    public final CustomMessageListener N0;
    public int O;
    public final CustomMessageListener O0;
    public int P;
    public final CustomMessageListener P0;
    public int Q;
    public final CustomMessageListener Q0;
    public int R;
    @NonNull
    public final BarManageResultListener R0;
    public boolean S;
    public final CustomMessageListener S0;
    public int T;
    public final VideoDanmuController.b T0;
    public String U;
    public View.OnClickListener U0;
    public String V;
    public View.OnClickListener V0;
    public String W;
    public i.d W0;
    public PopupDialog X;
    public i.d X0;
    public c.a.r0.s.t.i Y;
    public i.d Y0;
    public ForumManageModel Z;
    public i.d Z0;
    public c.a.r0.i.a a0;
    public Runnable a1;
    public RelativeLayout agreeContainer;
    public HeadImageView author_portrait;
    public c.a.r0.t.e.a b0;
    public CyberPlayerManager.OnInfoListener b1;
    public BdUniqueId c0;
    public CyberPlayerManager.OnCompletionListener c1;
    public Animation clickAnimation;
    public LinearLayout commentContainer;
    public String d0;
    public CyberPlayerManager.OnPreparedListener d1;
    public EMTextView dragCurTime;
    public EMTextView dragTotalTime;

    /* renamed from: e  reason: collision with root package name */
    public int f50425e;
    public RelativeLayout.LayoutParams e0;
    public CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50426f;
    public TbCyberVideoView.VideoStatus f0;
    public CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f50427g;
    public String g0;

    /* renamed from: h  reason: collision with root package name */
    public int f50428h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public int f50429i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f50430j;

    /* renamed from: k  reason: collision with root package name */
    public VideoDanmuController f50431k;
    public boolean k0;
    public c.a.s0.l4.m.c l;
    public TbImageView m;
    public ImageView mAgreeImg;
    public EMTextView mAgreeNum;
    public TBLottieAnimationView mAttentionLottieView;
    public TextView mAuthorNameTv;
    public ImageView mBackBtn;
    public TextView mBarName;
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
    public TbCyberVideoView mVideoView;
    public View mfullScreenView;
    public View n;
    public boolean o;
    public LinearLayout p;
    public ImageView play_btn;
    public TextView q;
    public int q0;
    public ImageView r;
    public int r0;
    public LinearLayout s;
    public c.a.s0.l4.r.a s0;
    public LinearLayout shareContainer;
    public ImageView share_icon;
    public ImageView share_icon_changed;
    public BarImageView t;
    public c.a.s0.l4.o.a t0;
    public ImageView u;
    public f.c u0;
    public TextView v;
    public o1 v0;
    public LinearLayout videoActivityContainer;
    public ImageView videoLoadingIcon;
    public RelativeLayout videoLoadingLayout;
    public LinearLayout video_private;
    public ExpandableTextView video_title;
    public TextView w;
    public c.a.s0.l4.t.a w0;
    public View x;
    public c.a.s0.l4.j x0;
    public View y;
    public AlertDialog y0;
    public View z;
    public boolean z0;

    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.i0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.f50427g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.a.i0) {
                this.a.i0 = false;
                this.a.f50431k.Z();
                if (this.a.f50431k != null && this.a.v1()) {
                    this.a.f50431k.U();
                }
                this.a.w0.a0(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class a0 implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public a0(VideoPlayFragment videoPlayFragment) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.m == null) {
                return;
            }
            this.a.m.setVisibility(8);
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

    /* loaded from: classes12.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50432e;

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
            this.f50432e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50432e.f50430j.removeView(this.f50432e.mVideoView);
                this.f50432e.w0.X();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes12.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f50433e;

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
                this.f50433e = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    super.onAnimationStart(animator);
                    if (this.f50433e.a.N != null) {
                        this.f50433e.a.N.removeRule(14);
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921612 || this.a.getPageContext() == null) {
                return;
            }
            Configuration configuration = this.a.getPageContext().getPageActivity().getResources().getConfiguration();
            if ((configuration == null || configuration.orientation != 2) && this.a.isResumed() && this.a.H) {
                if (this.a.f50425e == 1 && this.a.J != null) {
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.S1(videoPlayFragment.mVideoView, videoPlayFragment.m, this.a.N.leftMargin, this.a.Q, this.a.N.topMargin, this.a.R, this.a.N.width, this.a.O, this.a.N.height, this.a.P, new a(this));
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50434e;

        /* loaded from: classes12.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b0 f50435e;

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
                this.f50435e = b0Var;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f50435e.f50434e.K = true;
                    if (this.f50435e.f50434e.N != null) {
                        this.f50435e.f50434e.N.addRule(14);
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
            this.f50434e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams e1 = this.f50434e.e1();
                VideoPlayFragment videoPlayFragment = this.f50434e;
                videoPlayFragment.S1(videoPlayFragment.mVideoView, videoPlayFragment.m, this.f50434e.Q, e1.leftMargin, this.f50434e.R, e1.topMargin, this.f50434e.O, e1.width, this.f50434e.P, e1.height, new a(this));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b1 implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50436e;

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
            this.f50436e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f50436e.H && ((i2 == 3 || i2 == 904) && this.f50436e.m.getVisibility() == 0)) {
                    this.f50436e.m.clearAnimation();
                    this.f50436e.m.startAnimation(this.f50436e.I);
                }
                if (i2 != 10012 || this.f50436e.s0 == null) {
                    return true;
                }
                this.f50436e.s0.prefetch();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
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
            d2 d2Var = this.a.mVideoData.threadData;
            if (d2Var != null && aVar.d()) {
                int i2 = k1.a[aVar.c().ordinal()];
                if (i2 == 1) {
                    d2Var.i4(true);
                } else if (i2 == 2) {
                    d2Var.i4(false);
                } else if (i2 == 3) {
                    d2Var.v3(true);
                } else if (i2 == 4) {
                    d2Var.v3(false);
                }
            }
            this.a.showToast(aVar.b());
        }
    }

    /* loaded from: classes12.dex */
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

        @Override // c.a.s0.l4.m.c.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.f50431k == null || this.a.l == null) {
                return;
            }
            if (!z || !this.a.isResumed()) {
                this.a.f50431k.R();
                this.a.f50431k.H();
            } else {
                this.a.f50431k.Z();
                if (this.a.mVideoView.isPlaying()) {
                    this.a.f50431k.U();
                } else {
                    this.a.f50431k.R();
                }
            }
            this.a.l.j(z);
        }
    }

    /* loaded from: classes12.dex */
    public class c1 implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50437e;

        public c1(VideoPlayFragment videoPlayFragment) {
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
            this.f50437e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f50437e.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.monitorAndStatsAtVerticalVideoReplay();
            this.f50437e.mVideoView.seekTo(0);
            if (c.a.r0.b.d.e() && (this.f50437e.f50425e == 1 || this.f50437e.f50425e == 2)) {
                if (this.f50437e.v0 != null && !this.f50437e.i0) {
                    this.f50437e.v0.a();
                    this.f50437e.m.setVisibility(8);
                    this.f50437e.mVideoView.start();
                } else {
                    this.f50437e.mVideoView.start();
                }
            } else {
                this.f50437e.mVideoView.start();
            }
            this.f50437e.B1();
            VideoPlayFragment.K0(this.f50437e);
            if (this.f50437e.q0 == 3) {
                this.f50437e.X0();
            }
            if (this.f50437e.i0) {
                return;
            }
            if (this.f50437e.isResumed() && this.f50437e.H) {
                return;
            }
            this.f50437e.x1();
        }
    }

    /* loaded from: classes12.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.H && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                boolean isEmotionClick = ((c.a.s0.l4.o.c) this.a.t0.a().findToolById(28)).g().isEmotionClick();
                if (booleanValue) {
                    this.a.S0(false);
                } else if (isEmotionClick) {
                    this.a.S0(true);
                } else {
                    this.a.l1();
                }
                ((c.a.s0.l4.o.c) this.a.t0.a().findToolById(28)).g().setEmotionClick(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d0 implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoDanmuController a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.l4.t.a f50438b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50439c;

        public d0(VideoPlayFragment videoPlayFragment, VideoDanmuController videoDanmuController, c.a.s0.l4.t.a aVar) {
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
            this.f50439c = videoPlayFragment;
            this.a = videoDanmuController;
            this.f50438b = aVar;
        }

        @Override // c.a.s0.l4.t.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f50439c.startPlay();
                    VideoDanmuController videoDanmuController = this.a;
                    if (videoDanmuController != null) {
                        videoDanmuController.b0(this.f50438b.H0());
                        return;
                    }
                    return;
                }
                c.a.s0.l4.t.a aVar = this.f50438b;
                if (aVar != null) {
                    VideoDanmuController videoDanmuController2 = this.a;
                    if (videoDanmuController2 != null) {
                        aVar.M0(videoDanmuController2.F());
                    }
                    this.f50438b.startPlay();
                    VideoDanmuController videoDanmuController3 = this.a;
                    if (videoDanmuController3 != null) {
                        videoDanmuController3.R();
                        this.a.S();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d1 implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50440e;

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
            this.f50440e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoPlayFragment videoPlayFragment = this.f50440e;
                if (videoPlayFragment.mVideoView != null) {
                    if (videoPlayFragment.G != null) {
                        this.f50440e.G.setVisibility(0);
                        if (this.f50440e.G.getCurProgress() == 0) {
                            this.f50440e.G.showProgress();
                            return;
                        }
                        return;
                    }
                    this.f50440e.G.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
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
        public boolean a(@Nullable PostData postData, @Nullable c.a.s0.s2.r.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, postData, fVar)) == null) {
                if (this.a.f50431k != null) {
                    this.a.f50431k.O("c14478");
                }
                if (postData != null) {
                    this.a.i1(postData.G());
                    MessageManager.getInstance().registerStickyMode(2921648);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921648, fVar));
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class e0 implements b.InterfaceC1161b {
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

        @Override // c.a.s0.l4.o.b.InterfaceC1161b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.f50431k == null) {
                return;
            }
            this.a.f50431k.V(str);
        }
    }

    /* loaded from: classes12.dex */
    public class e1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f50442f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50443g;

        public e1(VideoPlayFragment videoPlayFragment, boolean z, boolean z2) {
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
            this.f50443g = videoPlayFragment;
            this.f50441e = z;
            this.f50442f = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f50443g.y0 != null) {
                    this.f50443g.y0.dismiss();
                }
                if (c.a.d.f.p.k.A()) {
                    ForumManageModel forumManageModel = this.f50443g.Z;
                    VideoItemData videoItemData = this.f50443g.mVideoData;
                    forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.f50441e, null, this.f50442f);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    return;
                }
                c.a.d.f.p.m.L(this.f50443g.getContext(), c.a.s0.l4.i.neterror);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements VideoDanmuController.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d2 f50444e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f50445f;

            public a(f fVar, d2 d2Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, d2Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50445f = fVar;
                this.f50444e = d2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f50445f.a.mVideoData.parseProto(this.f50444e);
                    this.f50445f.a.mVideoData.reGenerateTitle();
                    VideoItemData videoItemData = this.f50445f.a.mVideoData;
                    videoItemData.threadData = this.f50444e;
                    if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
                        return;
                    }
                    VideoPlayFragment videoPlayFragment = this.f50445f.a;
                    videoPlayFragment.K1(videoPlayFragment.mVideoData, videoPlayFragment.w0, this.f50445f.a.f50431k);
                    VideoPlayFragment videoPlayFragment2 = this.f50445f.a;
                    videoPlayFragment2.L1(videoPlayFragment2.mVideoData.video_url);
                    this.f50445f.a.Y0();
                    VideoPlayFragment videoPlayFragment3 = this.f50445f.a;
                    videoPlayFragment3.setUserVisibleHint(videoPlayFragment3.H);
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
        public boolean a(@Nullable d2 d2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
                c.a.d.f.m.e.a().post(new a(this, d2Var));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
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

        @Override // c.a.s0.l4.o.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (c.a.r0.b.d.e0()) {
                    this.a.L.setVisibility(0);
                } else {
                    this.a.L.setVisibility(8);
                }
                if (z) {
                    this.a.a1("");
                    if (this.a.f50431k != null) {
                        this.a.f50431k.O("c14476");
                    }
                } else {
                    this.a.a1(((c.a.s0.l4.o.c) this.a.t0.a().findToolById(28)).f().getText().toString());
                }
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData != null && z) {
                    long g2 = c.a.d.f.m.b.g(videoItemData.comment_num, 0L) + 1;
                    this.a.mVideoData.comment_num = String.valueOf(g2);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.H1(g2, videoPlayFragment.mCommentNum);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
                this.a.T0();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50446e;

        public f1(VideoPlayFragment videoPlayFragment) {
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
            this.f50446e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50446e.y0 == null) {
                return;
            }
            this.f50446e.y0.dismiss();
        }
    }

    /* loaded from: classes12.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50447e;

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
            this.f50447e = videoPlayFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f50447e.onViewDoubleClick(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                if (motionEvent.getX() - motionEvent2.getX() > 50.0f) {
                    this.f50447e.onViewDragToRight();
                    this.f50447e.mRootView.cancelLongPress();
                    return true;
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f50447e.w1();
                    this.f50447e.mRootView.cancelLongPress();
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
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                this.f50447e.onViewClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.isResumed() && this.a.H) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.showBlockDialog(videoPlayFragment.S, booleanValue);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(VideoPlayFragment videoPlayFragment, int i2) {
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
            d2 d2Var;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.v3.j0.l)) {
                c.a.s0.v3.j0.l lVar = (c.a.s0.v3.j0.l) customResponsedMessage.getData();
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData == null || (d2Var = videoItemData.threadData) == null || (str = d2Var.E) == null || !str.equals(lVar.a)) {
                    return;
                }
                this.a.mVideoData.threadData.X3(lVar.f24907b ? 1 : 0);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f50448e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50449f;

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
            this.f50449f = videoPlayFragment;
            this.f50448e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f50448e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50450e;

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
            this.f50450e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f50450e).mVideoData) == null || videoItemData.thread_id == null) {
                return;
            }
            c.a.r0.t.c.k0.b(videoPlayFragment.getPageContext(), this.f50450e.mVideoData.thread_id);
            int i2 = 7;
            if (this.f50450e.f50425e == 1 || this.f50450e.f50425e == 2) {
                i2 = 6;
            } else if (this.f50450e.f50425e != 3) {
                int unused = this.f50450e.f50425e;
            }
            c.a.r0.t.c.k0.a(i2);
        }
    }

    /* loaded from: classes12.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h1(VideoPlayFragment videoPlayFragment, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isPrimary() && this.a.H && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.z2.m)) {
                c.a.s0.z2.m mVar = (c.a.s0.z2.m) customResponsedMessage.getData();
                SeekBar seekBar = this.a.G.getSeekBar();
                int i2 = mVar.a;
                if (i2 == 1) {
                    seekBar.setProgress(mVar.f26397b);
                    this.a.G.performOnProgressChanged(seekBar, mVar.f26397b, true);
                } else if (i2 == 2) {
                    this.a.G.performOnStartTrackingTouch(seekBar);
                } else if (i2 == 3) {
                    this.a.G.performOnStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class i implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50451e;

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
            this.f50451e = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f50451e.N1();
                this.f50451e.mRootView.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes12.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.Z.getLoadDataMode() == 0) {
                if (this.a.n1()) {
                    if ((obj instanceof ForumManageModel.b) && this.a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.sendMessage(this.a.getPageContext(), Pair.create(Boolean.valueOf(bVar.a), bVar.f49826b));
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

    /* loaded from: classes12.dex */
    public class i1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50452e;

        public i1(VideoPlayFragment videoPlayFragment) {
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
            this.f50452e = videoPlayFragment;
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
                if (this.f50452e.F0 == null) {
                    VideoPlayFragment videoPlayFragment = this.f50452e;
                    videoPlayFragment.F0 = videoPlayFragment.g1(1.0f, 1.0f, 1.0f, 100L);
                }
                this.f50452e.F0.start();
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

    /* loaded from: classes12.dex */
    public class j implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50453e;

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
            this.f50453e = videoPlayFragment;
        }

        @Override // c.a.s0.z2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f50453e.u0 == null) {
                return;
            }
            this.f50453e.u0.onProgressUpdated(i2, i3);
            if (this.f50453e.D0) {
                this.f50453e.z1(i3, i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class j0 implements a.InterfaceC0818a {
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

        @Override // c.a.r0.i.a.InterfaceC0818a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.a0 != null) {
                        this.a.a0.h(z2);
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
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(c.a.s0.l4.i.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(c.a.s0.l4.i.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(c.a.s0.l4.i.update_mark_failed));
            }
        }
    }

    /* loaded from: classes12.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.s0.v3.j0.e)) {
                AgreeData agreeData = ((c.a.s0.v3.j0.e) customResponsedMessage.getData()).f24896b;
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
                    this.a.U0();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.mVideoData.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.mVideoData.agree_num = String.valueOf(agreeData.agreeNum);
                this.a.mVideoData.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.a.U0();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50454e;

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
            this.f50454e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayFragment videoPlayFragment;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = (videoPlayFragment = this.f50454e).mVideoView) == null || videoPlayFragment.mVideoData == null) {
                return;
            }
            tbCyberVideoView.setVideoPath(videoPlayFragment.d0, this.f50454e.mVideoData.thread_id);
            this.f50454e.mVideoView.prepareByPause();
        }
    }

    /* loaded from: classes12.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50455e;

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
            this.f50455e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f50455e.mLiveLottieView.playAnimation();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static /* synthetic */ class k1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318564382, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$k1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318564382, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$k1;");
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

    /* loaded from: classes12.dex */
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
                this.a.mVideoView.setCanShowPause(true);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class l0 implements i.c {
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

        @Override // c.a.r0.s.t.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.hideDraftDialog();
            }
        }
    }

    /* loaded from: classes12.dex */
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
            int i2;
            int mainTabBottomBarHeight;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.a.i0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.f50427g.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.a.mVideoData == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f2 = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds562);
            int i3 = c.a.d.f.p.m.i(this.a.mRootView.getContext());
            int e2 = c.a.d.f.m.b.e(this.a.mVideoData.video_height, 0);
            int e3 = c.a.d.f.m.b.e(this.a.mVideoData.video_width, 0);
            if (e2 != 0 && e3 != 0) {
                f2 = (e2 * 1.0f) / e3;
            }
            int k2 = c.a.d.f.p.m.k(this.a.mRootView.getContext());
            float f3 = k2 * f2;
            if (f2 > 1.0f) {
                float f4 = dimenPixelSize;
                i2 = (int) (((i3 - dimenPixelSize) * floatValue) + f4);
                float f5 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) (UtilHelper.getStatusBarHeight() * f5);
                this.a.e0.topMargin = (int) (((i3 - c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds203)) * 0.5f * floatValue) + (f5 * f4 * 0.5f));
                k2 = (int) (i2 / f2);
            } else {
                float f6 = dimenPixelSize;
                i2 = (int) (((f3 - f6) * floatValue) + f6);
                float f7 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) ((((i3 - f3) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f7));
                this.a.e0.topMargin = (int) ((((i3 - c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds203)) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (f7 * f6 * 0.5f));
            }
            this.a.N.height = i2;
            this.a.N.width = k2;
            this.a.N.topMargin = mainTabBottomBarHeight;
            this.a.play_btn.requestLayout();
            this.a.mVideoView.requestLayout();
        }
    }

    /* loaded from: classes12.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50456e;

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
            this.f50456e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f50456e;
                if (videoPlayFragment.Z0(videoPlayFragment.getPageContext(), 25066)) {
                    this.f50456e.P1();
                    if (this.f50456e.mVideoData != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.f50456e.mVideoData.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.f50456e.mVideoData.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.f50456e.f50431k != null) {
                        this.f50456e.f50431k.O("c14475");
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m0 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50457e;

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
            this.f50457e = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f50457e.X = null;
                this.f50457e.Y = null;
                if (TbSingleton.getInstance().isNotchScreen(this.f50457e.getActivity())) {
                    return;
                }
                TbSingleton.getInstance().isCutoutScreen(this.f50457e.getActivity());
            }
        }
    }

    /* loaded from: classes12.dex */
    public class m1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m1(VideoPlayFragment videoPlayFragment, int i2) {
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
                if (this.a.i0) {
                    if (bool.booleanValue() || !this.a.v1()) {
                        this.a.startPlay();
                        this.a.x1();
                        return;
                    }
                    this.a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50458e;

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
            this.f50458e = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f50458e.c1(true);
                EMTextView eMTextView = this.f50458e.dragCurTime;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = this.f50458e.dragTotalTime;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.f50458e.mVideoView.getDuration()));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                int i2 = 1;
                this.f50458e.h0 = true;
                if (this.f50458e.G != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.f50458e.G;
                    if (this.f50458e.f50425e != 4 && this.f50458e.f50425e != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        i2 = 0;
                    }
                    videoMiddleNiaiControllerView.setBottomBarShow(false, i2);
                }
                this.f50458e.T1();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.f50458e.isResumed() && this.f50458e.H) {
                    this.f50458e.G.setLoading(true);
                }
                this.f50458e.h0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(c.a.s0.l4.d.tbds12));
                    seekBar.setThumb(null);
                    this.f50458e.c1(false);
                    if (!this.f50458e.mVideoView.isPlaying()) {
                        this.f50458e.mVideoView.start();
                        this.f50458e.play_btn.setVisibility(8);
                    }
                    if (!this.f50458e.i0 && (!this.f50458e.isResumed() || !this.f50458e.H)) {
                        this.f50458e.x1();
                    }
                    c.a.d.f.m.e.a().removeCallbacks(this.f50458e.a1);
                    c.a.d.f.m.e.a().postDelayed(this.f50458e.a1, 3000L);
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50459e;

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
            this.f50459e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50459e.R1(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class n1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n1(VideoPlayFragment videoPlayFragment, int i2) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.i0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.f50427g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.v1()) {
                        this.a.startPlay();
                        return;
                    }
                    return;
                }
                this.a.U1();
                this.a.x1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50460e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50461f;

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
            this.f50461f = videoPlayFragment;
            this.f50460e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f50460e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f50461f.getPageContext().getPageActivity()), new String[]{this.f50460e}, true);
        }
    }

    /* loaded from: classes12.dex */
    public class o0 implements i.d {
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

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.X != null) {
                    this.a.X.dismiss();
                }
                this.a.R1(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface o1 {
        void a();

        void onStart();
    }

    /* loaded from: classes12.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50462e;

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
            this.f50462e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.s0.l4.f.portrait_container && (videoItemData = this.f50462e.mVideoData) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.f50462e;
                    if (videoPlayFragment.mVideoData.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.f50462e.mVideoData.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.f50462e.mVideoData.getThreadId());
                        UserItemData userItemData2 = this.f50462e.mVideoData.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.f50462e.mVideoData.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.f50462e.mVideoData;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null) {
                    return;
                }
                long g2 = c.a.d.f.m.b.g(userItemData.user_id, 0L);
                long g3 = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = (g2 == 0 && g3 == 0) ? false : g2 == g3;
                String str = this.f50462e.mVideoData.author_info.portrait;
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.f50462e.getActivity()).createNormalConfig(g2, z, false, true, (this.f50462e.f50425e == 3 || this.f50462e.f50425e == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                createNormalConfig.setPortrait(str);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.f50462e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.f50462e.getClickItem(5);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class p0 implements i.d {
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

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    if (this.a.X != null) {
                        this.a.X.dismiss();
                        return;
                    }
                    return;
                }
                if (this.a.X != null) {
                    this.a.X.dismiss();
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
                if (this.a.a0 != null) {
                    this.a.a0.i(markData);
                    if (!z) {
                        this.a.a0.a();
                    } else {
                        this.a.a0.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50463e;

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
            this.f50463e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f50463e).mVideoData) == null || videoItemData.act_info == null) {
                return;
            }
            c.a.r0.m.a.l(videoPlayFragment.getActivity(), this.f50463e.mVideoData.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.f50463e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes12.dex */
    public class q0 implements i.d {
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

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.X.dismiss();
                if (!ViewHelper.checkUpIsLogin(this.a.getActivity()) || this.a.getPageContext() == null || (videoItemData = this.a.mVideoData) == null) {
                    return;
                }
                String str = videoItemData.thread_id;
                String str2 = videoItemData.forum_id;
                String string = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + this.a.mVideoData.post_id;
                VideoItemData videoItemData2 = this.a.mVideoData;
                if (videoItemData2.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.a.getPageContext().getPageActivity(), string, str3, true);
                if (this.a.mVideoData.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                this.a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50464e;

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
            this.f50464e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50464e.h1();
                this.f50464e.getClickItem(7);
            }
        }
    }

    /* loaded from: classes12.dex */
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
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.a.mVideoData.author_info.user_id.equals(data.f42047c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.a.c0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.a) {
                    if (!z || "0".equals(this.a.mVideoData.author_info.is_follow)) {
                        return;
                    }
                    c.a.d.f.p.m.L(this.a.getActivity(), c.a.s0.l4.i.attention_fail);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment.V0();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment2.V0();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.a.mVideoData));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.V0();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.a.V)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50465e;

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
            this.f50465e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50465e.f50430j.removeView(this.f50465e.mVideoView);
                this.f50465e.w0.X();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class s0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes12.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.s.t.a f50466e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ s0 f50467f;

            public a(s0 s0Var, c.a.r0.s.t.a aVar) {
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
                this.f50467f = s0Var;
                this.f50466e = aVar;
            }

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f50466e.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f50467f.a;
                    if (videoPlayFragment.mVideoData != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.Z;
                        VideoPlayFragment videoPlayFragment2 = this.f50467f.a;
                        VideoItemData videoItemData = videoPlayFragment2.mVideoData;
                        forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.S, null, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes12.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.s.t.a f50468e;

            public b(s0 s0Var, c.a.r0.s.t.a aVar) {
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
                this.f50468e = aVar;
            }

            @Override // c.a.r0.s.t.a.e
            public void onClick(c.a.r0.s.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f50468e.dismiss();
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

        @Override // c.a.r0.s.t.i.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.X.dismiss();
                c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(this.a.getActivity());
                VideoItemData videoItemData = this.a.mVideoData;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(c.a.s0.l4.i.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(c.a.s0.l4.i.del_thread_confirm);
                }
                aVar.setPositiveButton(c.a.s0.l4.i.dialog_ok, new a(this, aVar));
                aVar.setNegativeButton(c.a.s0.l4.i.dialog_cancel, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50469e;

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
            this.f50469e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.f50469e.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.f50469e.mVideoData.thread_id));
                }
                this.f50469e.getActivity().finish();
            }
        }
    }

    /* loaded from: classes12.dex */
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

    /* loaded from: classes12.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50470e;

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
            this.f50470e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50470e.N1();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class u0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public u0(VideoPlayFragment videoPlayFragment) {
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

    /* loaded from: classes12.dex */
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
            VideoPlayFragment videoPlayFragment;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = (videoPlayFragment = this.a).mVideoView) == null || videoPlayFragment.mVideoData == null) {
                return;
            }
            tbCyberVideoView.setVideoPath(videoPlayFragment.d0, this.a.mVideoData.thread_id);
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            TbCyberVideoView tbCyberVideoView;
            TbCyberVideoView tbCyberVideoView2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbCyberVideoView = this.a.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.clearCallbackAndRemoveFromWindow();
            this.a.mVideoView.setStageType("2005");
            this.a.mVideoView.setLocateSource("v_mid_page");
            this.a.mVideoView.setContinuePlayEnable(true);
            if (this.a.N != null) {
                this.a.m.setLayoutParams(this.a.N);
                if (this.a.f50430j != null && (tbCyberVideoView2 = this.a.mVideoView) != null && tbCyberVideoView2.getView() != null) {
                    this.a.f50430j.addView(this.a.mVideoView.getView(), 0, this.a.N);
                }
            } else {
                this.a.setVideoBussinessAndAddView();
            }
            this.a.J1();
        }
    }

    /* loaded from: classes12.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50471e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50472f;

        public v0(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f50472f = videoPlayFragment;
            this.f50471e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f50472f.getContext()).createNormalCfg(this.f50471e, "")));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50473e;

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
            this.f50473e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.f50473e.getPageContext(), this.f50473e.mVideoData)) {
                return;
            }
            this.f50473e.h1();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.f50473e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.f50473e.getClickItem(2);
        }
    }

    /* loaded from: classes12.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50474e;

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
            this.f50474e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f50474e.C0 == null) {
                return;
            }
            this.f50474e.C0.q(TiePlusStat.StatType.CLICK);
            this.f50474e.A0.statRichTextEvent(this.f50474e.C0);
            this.f50474e.A0.processClick(this.f50474e.C0);
        }
    }

    /* loaded from: classes12.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50475e;

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
            this.f50475e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f50475e;
                videoPlayFragment.b1(videoPlayFragment.f50428h);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class x0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50476e;

        public x0(VideoPlayFragment videoPlayFragment) {
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
            this.f50476e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f50476e.h0) {
                return;
            }
            this.f50476e.W0(true);
        }
    }

    /* loaded from: classes12.dex */
    public class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50477e;

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
            this.f50477e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50477e.Q1();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.f50477e.mVideoData.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f50477e.getClickItem(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.f50477e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.f50477e.mVideoData.nid);
                BaijiahaoData baijiahaoData = this.f50477e.mVideoData.baijiahaoData;
                if (baijiahaoData != null && !c.a.d.f.p.l.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.f50477e.mVideoData.baijiahaoData.oriUgcVid);
                }
                if (this.f50477e.mVideoData.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.f50477e.mVideoData.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.f50477e.mVideoData.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.f50477e.mVideoData.mRecomSource);
                statisticItem2.param("ab_tag", this.f50477e.mVideoData.mRecomAbTag);
                statisticItem2.param("weight", this.f50477e.mVideoData.mRecomWeight);
                statisticItem2.param("extra", this.f50477e.mVideoData.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (c.a.r0.o0.c.j(this.f50477e.getBaseFragmentActivity()) != null && c.a.r0.o0.c.j(this.f50477e.getBaseFragmentActivity()).b() != null && c.a.r0.o0.c.j(this.f50477e.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(c.a.r0.o0.c.j(this.f50477e.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes12.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.a.isResumed() && this.a.H) {
                if (c.a.d.f.p.k.z()) {
                    if (this.a.O1()) {
                        return;
                    }
                    this.a.startPlay();
                    return;
                }
                c.a.d.f.p.m.L(TbadkCoreApplication.getInst(), c.a.s0.l4.i.neterror);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class z implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f50478e;

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
            this.f50478e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f50478e.getActivity())) {
                if (this.f50478e.A != null && (videoItemData = (videoPlayFragment = this.f50478e).mVideoData) != null && videoItemData.author_info != null && videoPlayFragment.mAttentionLottieView != null) {
                    c.a.r0.t.e.a aVar = videoPlayFragment.b0;
                    VideoPlayFragment videoPlayFragment2 = this.f50478e;
                    UserItemData userItemData = videoPlayFragment2.mVideoData.author_info;
                    aVar.l(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.c0, this.f50478e.mVideoData.forum_id, "0");
                    VideoPlayFragment videoPlayFragment3 = this.f50478e;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.V0();
                    this.f50478e.A.setVisibility(8);
                    this.f50478e.y1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.f50478e.f50425e != 3 && this.f50478e.f50425e != 4) {
                    statisticItem.param("obj_locate", 2);
                    if (this.f50478e.f50425e != 7) {
                        statisticItem.param("obj_source", this.f50478e.f1());
                    } else {
                        statisticItem.param("obj_source", 8);
                    }
                } else {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.f50478e.mVideoData.thread_id);
                statisticItem.param("fid", this.f50478e.mVideoData.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f50478e.getClickItem(6);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class z0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f50479e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50480f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f50481g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f50482h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f50483i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f50484j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ int f50485k;
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
            this.f50479e = i2;
            this.f50480f = i3;
            this.f50481g = i4;
            this.f50482h = i5;
            this.f50483i = i6;
            this.f50484j = i7;
            this.f50485k = i8;
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
                int i2 = (int) (this.f50479e * animatedFraction);
                int i3 = this.f50480f;
                this.p.N.topMargin = i3 > this.f50481g ? i3 - i2 : i3 + i2;
                int i4 = (int) (this.f50482h * animatedFraction);
                int i5 = this.f50483i;
                int i6 = i5 > this.f50484j ? i5 - i4 : i5 + i4;
                this.p.N.leftMargin = i6;
                this.p.N.rightMargin = i6;
                float f2 = animatedFraction * this.f50485k;
                int i7 = this.l;
                float f3 = i7 > this.m ? i7 - f2 : i7 + f2;
                this.p.N.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.p.N.height = (int) f3;
                this.n.setLayoutParams(this.p.N);
                this.o.setLayoutParams(this.p.N);
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
        this.f50428h = 0;
        this.f50429i = 1;
        this.o = false;
        this.K = false;
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.c0 = BdUniqueId.gen();
        this.f0 = TbCyberVideoView.VideoStatus.INIT;
        this.k0 = false;
        this.q0 = 1;
        this.r0 = -1;
        this.B0 = false;
        this.D0 = true;
        this.E0 = null;
        this.F0 = null;
        this.G0 = new k(this);
        this.H0 = new v(this);
        this.I0 = new g0(this, 2921607);
        this.J0 = new r0(this, 2001115);
        this.K0 = new y0(this, 2000994);
        this.L0 = new j1(this, 2016528);
        this.M0 = new l1(this, 2921594);
        this.N0 = new m1(this, 2001011);
        this.O0 = new n1(this, 2921596);
        this.P0 = new a(this, 2921598);
        this.Q0 = new b(this, 2921612);
        this.R0 = new BarManageResultListener(new c(this));
        this.S0 = new d(this, 2921645);
        this.T0 = new e(this);
        this.U0 = new h0(this);
        this.V0 = new n0(this);
        this.W0 = new o0(this);
        this.X0 = new p0(this);
        this.Y0 = new q0(this);
        this.Z0 = new s0(this);
        this.a1 = new x0(this);
        this.b1 = new b1(this);
        this.c1 = new c1(this);
        this.d1 = new d1(this);
        this.e1 = new g1(this, 2921603);
        this.f1 = new h1(this, 2921635);
    }

    public static /* synthetic */ int K0(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.q0;
        videoPlayFragment.q0 = i2 + 1;
        return i2;
    }

    public final void A1(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && this.mVideoData != null && this.J == null) {
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

    public final void B1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.mVideoData == null) {
            return;
        }
        c.a.s0.z2.p pVar = new c.a.s0.z2.p();
        pVar.a = "nani_midpage";
        VideoItemData videoItemData = this.mVideoData;
        pVar.f26406c = videoItemData.thread_id;
        pVar.t = videoItemData.nid;
        pVar.f26407d = this.mVideoData.forum_id + "";
        pVar.f26408e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.mVideoData;
        pVar.f26409f = videoItemData2.mRecomSource;
        pVar.f26410g = videoItemData2.mRecomAbTag;
        pVar.f26411h = videoItemData2.mRecomWeight;
        pVar.f26412i = "";
        pVar.f26414k = "";
        pVar.m = videoItemData2.mMd5;
        if (this.J != null) {
            pVar.n = "1";
        } else {
            pVar.n = "2";
        }
        int i2 = this.f50425e;
        if (i2 == 1 || i2 == 2) {
            pVar.p = "1";
            pVar.a = "auto_midpage";
            pVar.f26412i = "index";
        }
        c.a.s0.z2.h.e(this.mVideoData.mMd5, "", "1", pVar, this.mVideoView.getPcdnState());
        int i3 = this.f50425e;
        if (i3 == 1 || i3 == 3) {
            c.a.s0.l4.l.e.c(this.mVideoData.mMd5);
        } else if (i3 == 2 || i3 == 4) {
            c.a.s0.l4.l.e.a(this.mVideoData.mMd5);
        } else if (i3 == 7) {
            c.a.s0.l4.l.e.b(this.mVideoData.mMd5);
        }
    }

    public final void C1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.share_icon_changed == null || (imageView = this.share_icon) == null) {
            return;
        }
        imageView.clearAnimation();
        this.share_icon_changed.clearAnimation();
        this.share_icon.setVisibility(0);
        this.share_icon_changed.setVisibility(8);
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || O1()) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.mVideoView;
        if (tbCyberVideoView != null && this.play_btn != null && this.mVideoData != null) {
            if (tbCyberVideoView.getParent() == null) {
                setVideoBussinessAndAddView();
                J1();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.G;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.resetProgress();
            }
            this.mVideoView.setVideoPath(this.d0, this.mVideoData.thread_id);
            this.mVideoView.start(this.H0);
            this.G.showProgress();
            this.play_btn.setVisibility(8);
            M1();
        }
        if (isResumed() && this.H && v1()) {
            return;
        }
        x1();
        if (this.play_btn != null) {
            G1();
        }
    }

    public final void E1(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (view = this.mRootView) == null) {
            return;
        }
        view.setPadding(0, 0, 0, i2);
    }

    public final void F1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.agreeContainer.setVisibility(i2);
            this.C.setVisibility(i2);
            this.commentContainer.setVisibility(i2);
            this.shareContainer.setVisibility(i2);
            this.mBottomContainer.setVisibility(i2);
        }
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.play_btn.setVisibility(0);
            if (this.E0 == null) {
                this.E0 = g1(0.0f, 3.0f, 3.0f, 0L);
            }
            this.E0.addListener(new i1(this));
            this.E0.start();
        }
    }

    public final void H1(long j2, TextView textView) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048583, this, j2, textView) == null) || textView == null) {
            return;
        }
        String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(j2);
        if (!"0".equals(numberUniformFormatExtraWithRoundVote)) {
            textView.setText(numberUniformFormatExtraWithRoundVote);
            return;
        }
        if (textView.getId() == c.a.s0.l4.f.agree_num) {
            string = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.video_no_agree);
        } else if (textView.getId() == c.a.s0.l4.f.comment_num) {
            string = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.video_no_comment);
        } else {
            string = textView.getId() == c.a.s0.l4.f.share_num ? TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.video_no_share) : "";
        }
        textView.setText(string);
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mPortraitContainer.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.author_portrait.getLayoutParams();
            if (!c.a.r0.b.d.r0()) {
                if (layoutParams != null) {
                    layoutParams.width = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds94);
                    layoutParams2.width = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds94);
                    layoutParams.height = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds94);
                    layoutParams2.height = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds94);
                }
            } else if (layoutParams == null || layoutParams2 == null) {
            } else {
                layoutParams.width = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds104);
                layoutParams2.width = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds104);
                layoutParams.height = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds104);
                layoutParams2.height = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds104);
            }
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mVideoView.setVideoStatusChangeListener(this);
            this.mVideoView.setOnPreparedListener(this.d1);
            this.mVideoView.setOnCompletionListener(this.c1);
            this.mVideoView.setOnInfoListener(this.b1);
        }
    }

    public final void K1(VideoItemData videoItemData, c.a.s0.l4.t.a aVar, VideoDanmuController videoDanmuController) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048586, this, videoItemData, aVar, videoDanmuController) == null) || aVar == null || aVar.getMainView() == null) {
            return;
        }
        aVar.K0(videoItemData);
        boolean z2 = false;
        boolean z3 = c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(videoItemData.video_width, 0);
        if (this.H && z3) {
            z2 = true;
        }
        aVar.a0(z2);
        aVar.L0(new d0(this, videoDanmuController, aVar));
        aVar.getMainView().setVisibility(8);
    }

    public final void L1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || this.mVideoView == null || str == null || str.equals(this.d0)) {
            return;
        }
        this.d0 = str;
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && c.a.d.f.p.k.x()) {
            c.a.s0.j4.h.d().g(getContext());
        }
    }

    public final void N1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.X == null) {
                this.Y = new c.a.r0.s.t.i(getActivity());
                this.X = new PopupDialog(getPageContext(), this.Y);
                ArrayList arrayList = new ArrayList();
                c.a.r0.s.t.f fVar = new c.a.r0.s.t.f(getString(c.a.s0.l4.i.mark), this.Y);
                boolean z2 = false;
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    fVar.m(TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.remove_mark));
                } else {
                    fVar.m(TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.mark));
                }
                fVar.l(this.X0);
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(fVar);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.mVideoData.thread_id);
                    statisticItem.param("fid", this.mVideoData.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    int i2 = this.f50425e;
                    if (i2 != 3 && i2 != 4) {
                        statisticItem.param("obj_type", 2);
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    int i3 = this.f50425e;
                    if (i3 == 3) {
                        statisticItem.param("obj_param1", 1);
                    } else if (i3 == 4) {
                        statisticItem.param("obj_param1", 2);
                    } else if (i3 == 7) {
                        statisticItem.param("obj_param1", 3);
                    }
                    statisticItem.param("obj_source", f1());
                    TiebaStatic.log(statisticItem);
                }
                if (isUEGBackDisLike()) {
                    c.a.r0.s.t.f fVar2 = new c.a.r0.s.t.f(getString(c.a.s0.l4.i.not_interested), this.Y);
                    fVar2.l(this.W0);
                    arrayList.add(fVar2);
                }
                if (!isHost()) {
                    c.a.r0.s.t.f fVar3 = new c.a.r0.s.t.f(getString(c.a.s0.l4.i.report_text), this.Y);
                    fVar3.l(this.Y0);
                    arrayList.add(fVar3);
                }
                if (this.S) {
                    c.a.r0.s.t.f fVar4 = new c.a.r0.s.t.f(getString(c.a.s0.l4.i.delete), this.Y);
                    fVar4.l(this.Z0);
                    arrayList.add(fVar4);
                }
                this.Y.l(new l0(this));
                this.X.setOnDismissListener(new m0(this));
                this.Y.j(arrayList);
            }
            showDraftDialog();
        }
    }

    public final boolean O1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (c.a.s0.j4.h.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !((i2 = this.f50425e) == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick() || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.f50425e;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && c.a.d.f.p.k.x() && isResumed() && this.H) {
                c.a.d.f.p.m.N(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.video_no_wifi_tips), 3000);
                int i4 = this.f50425e;
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

    public final void P1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || t1()) {
            return;
        }
        c.a.s0.l4.o.a aVar = this.t0;
        if (aVar != null && aVar.a() != null) {
            this.t0.a().display();
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null) {
                this.t0.v(videoItemData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.TRUE));
        }
        E1(0);
    }

    public final void Q1() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        d2 d2Var;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (videoItemData = this.mVideoData) == null) {
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
        String string = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.share_content_tpl);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.default_share_content_tpl);
        VideoItemData videoItemData3 = this.mVideoData;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(c.a.s0.l4.i.default_share_content_tpl_suffix));
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
        shareItem.V = videoItemData4.post_id;
        shareItem.f42071f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.W = userItemData2.portrait;
            shareItem.X = userItemData2.user_name;
            shareItem.Y = userItemData2.getUserShowName();
        }
        int i2 = this.f50425e;
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
            shareItem.j0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData5 = this.mVideoData;
        originalThreadInfo.f41392c = videoItemData5.thumbnail_url;
        originalThreadInfo.a = 3;
        originalThreadInfo.f41391b = videoItemData5.title;
        originalThreadInfo.f41395f = videoItemData5.thread_id;
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
        if (c.a.r0.b.d.d0() && (d2Var = this.mVideoData.threadData) != null) {
            int k2 = c.a.r0.t.g.g.k(d2Var);
            UserItemData userItemData3 = this.mVideoData.author_info;
            String str8 = userItemData3 != null ? userItemData3.name_show : "";
            shareItem.v0 = c.a.r0.t.g.g.j(this.mVideoData.threadData, k2);
            VideoItemData videoItemData6 = this.mVideoData;
            shareItem.w0 = c.a.r0.t.g.g.i(videoItemData6.threadData, k2, videoItemData6.forum_name, shareItem.R, str8, "");
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = isUEGBackDisLike();
        shareDialogConfig.disLikeListener = this.V0;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.V);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = isHost();
        VideoItemData videoItemData7 = this.mVideoData;
        shareDialogConfig.isManager = videoItemData7.is_manager;
        shareDialogConfig.isOriginManager = videoItemData7.is_origin_manager;
        shareDialogConfig.showHeating = showHeating();
        shareDialogConfig.isSelfHeating = this.S;
        shareDialogConfig.heatingListener = this.U0;
        d2 d2Var2 = this.mVideoData.threadData;
        if (d2Var2 != null) {
            shareDialogConfig.isCollected = d2Var2.m0() == 1;
            shareDialogConfig.isMadeTop = this.mVideoData.threadData.l2();
            shareDialogConfig.isAddedGood = this.mVideoData.threadData.M1();
        }
        c.a.s0.k0.h.c().l(shareDialogConfig);
    }

    public final void R1(boolean z2) {
        c.a.s0.l4.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z2) == null) || (jVar = this.x0) == null) {
            return;
        }
        jVar.c(p1());
        this.x0.d(getPageContext(), this.mVideoData, z2);
    }

    public final void S0(boolean z2) {
        c.a.s0.l4.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) || (aVar = this.t0) == null || aVar.a() == null) {
            return;
        }
        ((RelativeLayout.LayoutParams) this.t0.a().getLayoutParams()).bottomMargin = z2 ? 0 : TbadkCoreApplication.getInst().getKeyboardHeight();
        this.t0.a().requestLayout();
    }

    public final void S1(View view, View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), animatorListenerAdapter}) == null) {
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

    public final void T0() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && c.a.r0.b.d.h()) {
            if (!c.a.r0.b.d.m0() && (i2 = this.f50425e) != 4 && i2 != 3) {
                E1(UtilHelper.getDimenPixelSize(c.a.s0.l4.d.M_H_X004));
            } else {
                E1(0);
            }
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.mVideoData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
        statisticItem.param("tid", this.mVideoData.thread_id);
        statisticItem.param("fid", this.mVideoData.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        int i2 = this.f50425e;
        if (i2 != 3 && i2 != 4) {
            statisticItem.param("obj_type", 2);
        } else {
            statisticItem.param("obj_type", 1);
        }
        statisticItem.param("obj_type", f1());
        int i3 = this.f50425e;
        if (i3 == 3) {
            statisticItem.param("obj_source", 1);
        } else if (i3 == 4) {
            statisticItem.param("obj_source", 2);
        } else if (i3 == 7) {
            statisticItem.param("obj_source", 3);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void U0() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.l4.e.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.l4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        H1(c.a.d.f.m.b.g(this.mVideoData.agree_num, 0L), this.mAgreeNum);
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.mVideoView;
            if (tbCyberVideoView != null) {
                this.f0 = tbCyberVideoView.getVideoStatus();
            } else {
                this.f0 = TbCyberVideoView.VideoStatus.INIT;
            }
        }
    }

    public final void V0() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            if (!this.S && ((userItemData = this.mVideoData.author_info) == null || !"1".equals(userItemData.is_follow))) {
                this.A.setVisibility(0);
                this.A.setClickable(true);
                return;
            }
            this.A.setVisibility(4);
            this.A.setClickable(false);
        }
    }

    public final void W0(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z2) == null) || (videoMiddleNiaiControllerView = this.G) == null) {
            return;
        }
        int i2 = this.f50425e;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick()) ? 1 : 0);
    }

    public final void X0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || s1() || this.share_icon_changed == null || this.share_icon == null) {
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

    public final void Y0() {
        VideoItemData videoItemData;
        d2 d2Var;
        String a02;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        this.m.startLoad(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.mVideoData.getTitle();
        boolean z2 = c.a.d.f.m.b.e(this.mVideoData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
        if (!c.a.r0.b.d.o0()) {
            if (TextUtils.isEmpty(title) && (!z2 || this.mVideoData.video_duration < 60)) {
                this.z.setVisibility(8);
            } else {
                if (z2 && this.mVideoData.video_duration >= 60) {
                    this.x.setVisibility(0);
                    this.y.setBackground(getResources().getDrawable(c.a.s0.l4.e.icon_play12));
                    this.x.setBackground(getResources().getDrawable(c.a.s0.l4.e.icon_play12_bg));
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
                    c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.w);
                    d2.z(c.a.s0.l4.d.T_X09);
                    d2.v(c.a.s0.l4.c.CAM_X0621);
                    this.w.setText(sb.toString());
                } else {
                    this.x.setVisibility(8);
                }
                this.z.setVisibility(0);
                this.video_title.setTextSize(c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.T_X07));
                this.video_title.setTextColor(c.a.s0.l4.c.CAM_X0621);
                this.video_title.setLineSpacingExtra(c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.tbds10));
                this.video_title.setExpandable(false);
                this.video_title.setTextMaxLine(3);
                this.video_title.setLimitLine(3);
                this.video_title.setOnStatusChangedListener(new t0(this));
                ExpandableTextView expandableTextView = this.video_title;
                VideoItemData videoItemData2 = this.mVideoData;
                expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
            }
        } else if (TextUtils.isEmpty(title) && (!z2 || this.mVideoData.video_duration < 60)) {
            this.z.setVisibility(8);
        } else {
            if (this.mVideoData.video_duration >= 60) {
                this.x.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.tbds31), c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.tbds31));
                }
                layoutParams.width = c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.tbds3);
                layoutParams.height = c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.tbds34);
                this.y.setLayoutParams(layoutParams);
                this.y.setBackgroundColor(getResources().getColor(c.a.s0.l4.c.CAM_X0618));
                int i6 = this.mVideoData.video_duration;
                int i7 = i6 / 3600;
                int i8 = (i6 % 3600) / 60;
                int i9 = (i6 % 3600) % 60;
                StringBuilder sb2 = new StringBuilder();
                if (i7 > 0) {
                    if (i7 < 10) {
                        sb2.append("0");
                    }
                    sb2.append(i7);
                    sb2.append(":");
                }
                if (i8 > 0) {
                    if (i8 < 10) {
                        sb2.append("0");
                    }
                    sb2.append(i8);
                    sb2.append(":");
                } else {
                    sb2.append("00");
                    sb2.append(":");
                }
                if (i9 > 0) {
                    if (i9 < 10) {
                        sb2.append("0");
                    }
                    sb2.append(i9);
                } else {
                    sb2.append("00");
                }
                c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(this.w);
                d3.z(c.a.s0.l4.d.T_X08);
                d3.v(c.a.s0.l4.c.CAM_X0618);
                d3.A(c.a.s0.l4.i.F_X02);
                this.w.setText(sb2.toString());
            } else {
                this.x.setVisibility(8);
            }
            this.z.setVisibility(0);
            this.video_title.setTextSize(c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.T_X07));
            this.video_title.setTextColor(c.a.s0.l4.c.CAM_X0621);
            this.video_title.setLineSpacingExtra(c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.tbds10));
            this.video_title.setExpandable(false);
            this.video_title.setTextMaxLine(3);
            this.video_title.setLimitLine(3);
            this.video_title.setOnStatusChangedListener(new u0(this));
            ExpandableTextView expandableTextView2 = this.video_title;
            VideoItemData videoItemData3 = this.mVideoData;
            expandableTextView2.setData(title, videoItemData3.isTitleExpanded, videoItemData3.mWorksInfoData);
        }
        H1(c.a.d.f.m.b.g(this.mVideoData.comment_num, 0L), this.mCommentNum);
        H1(c.a.d.f.m.b.g(this.mVideoData.agree_num, 0L), this.mAgreeNum);
        if (s1()) {
            this.mShareNum.setText(c.a.s0.l4.i.more);
        } else {
            H1(c.a.d.f.m.b.g(this.mVideoData.share_num, 0L), this.mShareNum);
        }
        UserItemData userItemData = this.mVideoData.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.mVideoData.author_info.portrait.startsWith("http")) {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 10, false);
            } else {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 12, false);
            }
            if (u1() && !TextUtils.isEmpty(this.mVideoData.author_info.auth)) {
                this.author_portrait.setShowV(true);
                this.author_portrait.setOriginatorResId(c.a.s0.l4.e.ic_icon_mask_videov14);
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
            if (!StringUtils.isNull(this.mVideoData.forum_name) && this.f50425e != 7 && c.a.r0.b.d.r0()) {
                this.mBarName.setVisibility(0);
                TextView textView = this.mBarName;
                textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.mVideoData.forum_name + TbadkCoreApplication.getInst().getString(c.a.s0.l4.i.bar_default_name), 16, "..."));
            } else {
                this.mBarName.setVisibility(8);
            }
        }
        AlaInfoData alaInfoData = this.mVideoData.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            k1(this.mVideoData.mAlaInfoData.live_status == 1);
            j1();
        }
        if ("1".equals(this.mVideoData.is_private) && this.F.getVisibility() != 0) {
            this.video_private.setVisibility(0);
        } else {
            this.video_private.setVisibility(8);
        }
        if ("1".equals(this.mVideoData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.l4.e.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAgreeImg, AnimationProperty.SCALE_X, 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mAgreeImg, AnimationProperty.SCALE_Y, 1.3f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat2.setDuration(300L);
            ofFloat.start();
            ofFloat2.start();
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.l4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.mVideoData.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.F.getVisibility() != 0) {
            this.videoActivityContainer.setVisibility(8);
            this.B.setText(this.mVideoData.act_info.activity_name);
        } else {
            this.videoActivityContainer.setVisibility(8);
        }
        V0();
        boolean initTiePlusRichTextView = initTiePlusRichTextView();
        if (this.f50425e == 7) {
            this.p.setVisibility(8);
        } else if (initTiePlusRichTextView || !c.a.r0.b.d.n0()) {
            if (initTiePlusRichTextView || (d2Var = this.mVideoData.threadData) == null) {
                return;
            }
            if (TextUtils.isEmpty(d2Var.getRecomReason())) {
                this.p.setVisibility(8);
                return;
            }
            this.p.setVisibility(0);
            this.v.setText(this.mVideoData.threadData.getRecomReason());
            this.t.startLoad(this.mVideoData.threadData.e1, 10, false);
        } else {
            if (!TextUtils.isEmpty(this.mVideoData.forum_name)) {
                a02 = this.mVideoData.forum_name;
            } else {
                d2 d2Var2 = this.mVideoData.threadData;
                a02 = (d2Var2 == null || TextUtils.isEmpty(d2Var2.a0())) ? null : this.mVideoData.threadData.a0();
            }
            if (TextUtils.isEmpty(a02)) {
                return;
            }
            this.p.setVisibility(0);
            WebPManager.setPureDrawable(this.u, c.a.s0.l4.e.icon_pure_ba32, c.a.s0.l4.c.CAM_X0101, null);
            this.u.setVisibility(0);
            this.t.setVisibility(8);
            String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(a02 + TbadkCoreApplication.getInst().getString(c.a.s0.l4.i.bar_default_name), 12, "...吧");
            this.U = cutChineseAndEnglishWithEmoji;
            this.v.setText(cutChineseAndEnglishWithEmoji);
            d2 d2Var3 = this.mVideoData.threadData;
            if (d2Var3 != null && !TextUtils.isEmpty(d2Var3.getRecomReason())) {
                TextView textView2 = this.v;
                textView2.setText(this.U + getActivity().getResources().getString(c.a.s0.l4.i.video_recommend));
            }
            this.p.setOnClickListener(new v0(this, a02));
        }
    }

    public final boolean Z0(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void a1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.M.setText(c.a.s0.l4.i.reply_something);
                DanmuPostDraftManager.f50525b.a().c(this.mVideoData.thread_id);
                return;
            }
            this.M.setText(c.a.s0.l4.i.draft_to_replay);
            DanmuPostDraftManager.f50525b.a().d(this.mVideoData.thread_id, str);
        }
    }

    public final void b1(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048606, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.mVideoData) != null) {
            int i3 = 0;
            if (i2 == this.f50428h) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.mVideoData;
                    videoItemData2.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData2.agree_num, 0) - 1);
                    this.mVideoData.is_agreed = "0";
                    i3 = 1;
                } else {
                    VideoItemData videoItemData3 = this.mVideoData;
                    videoItemData3.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData3.agree_num, 0) + 1);
                    this.mVideoData.is_agreed = "1";
                    getClickItem(1);
                }
            } else {
                videoItemData.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData.agree_num, 0) + 1);
                this.mVideoData.is_agreed = "1";
                getClickItem(1);
            }
            StatisticItem statisticItem = new StatisticItem("c12795");
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f50428h) {
                statisticItem.param("obj_type", i3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c12003");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f50428h) {
                statisticItem2.param("obj_type", i3);
            } else {
                statisticItem2.param("obj_type", 2);
            }
            if ("index".equals(this.V)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            c.a.r0.n0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                if (i2 == this.f50428h) {
                    statisticItem3.param("obj_type", i3);
                } else {
                    statisticItem3.param("obj_type", 2);
                }
                int i4 = this.f50425e;
                if (i4 != 3 && i4 != 4) {
                    statisticItem3.param("obj_locate", 2);
                } else {
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("obj_source", f1());
                }
                statisticItem3.param("tid", this.mVideoData.thread_id);
                statisticItem3.param("fid", this.mVideoData.forum_id);
                int i5 = this.f50425e;
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
            Y0();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.mVideoData.thread_id);
            httpMessage.addParam("op_type", i3);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            BaijiahaoData baijiahaoData = this.mVideoData.baijiahaoData;
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
            c.a.s0.v3.j0.e eVar = new c.a.s0.v3.j0.e();
            AgreeData agreeData = new AgreeData();
            String str = this.mVideoData.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.mVideoData.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mVideoData.is_agreed);
            eVar.f24896b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.mVideoData));
        }
    }

    public final void c1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z2) == null) {
            if (z2) {
                F1(8);
                this.mDragContainer.setVisibility(0);
                return;
            }
            F1(0);
            this.mDragContainer.setVisibility(8);
        }
    }

    public void changeEditorSkinType(int i2) {
        c.a.s0.l4.o.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || (aVar = this.t0) == null || aVar.a() == null) {
            return;
        }
        this.t0.a().onChangeSkinType(i2);
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || this.mVideoData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.mVideoData.thread_id);
        statisticItem.param("nid", this.mVideoData.nid);
        statisticItem.param("fid", this.mVideoData.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.T);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", c.a.d.f.p.l.isEmpty(this.mVideoData.mRecomWeight) ? "0" : this.mVideoData.mRecomWeight);
        statisticItem.param("extra", c.a.d.f.p.l.isEmpty(this.mVideoData.mRecomExtra) ? "0" : this.mVideoData.mRecomExtra);
        statisticItem.param("obj_id", this.g0);
        statisticItem.param("ab_tag", c.a.d.f.p.l.isEmpty(this.mVideoData.mRecomAbTag) ? "0" : this.mVideoData.mRecomAbTag);
        statisticItem.param("obj_source", c.a.d.f.p.l.isEmpty(this.mVideoData.mRecomSource) ? "0" : this.mVideoData.mRecomSource);
        statisticItem.param("obj_type", this.V);
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
        int i3 = this.f50425e;
        if (i3 == 3 || i3 == 4) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.V);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.W);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void dismissBlockDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (alertDialog = this.y0) != null && alertDialog.isShowing()) {
            this.y0.dismiss();
        }
    }

    public final RelativeLayout.LayoutParams e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            int screenHeight = UtilHelper.getScreenHeight(this.mRootView.getContext());
            int k2 = c.a.d.f.p.m.k(this.mRootView.getContext());
            if ("video_channel_tab".equals(this.V)) {
                screenHeight -= TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(k2, screenHeight);
            if (this.mVideoView == null) {
                return layoutParams;
            }
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null) {
                int e2 = c.a.d.f.m.b.e(videoItemData.video_height, 0);
                int e3 = c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
                if (e2 > 0 && e3 > 0 && screenHeight > 0 && k2 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(k2, screenHeight);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.e0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.e0.addRule(14);
                        this.e0.topMargin = (screenHeight - c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds203)) / 2;
                    } else {
                        float f3 = f2 * k2;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(k2, (int) f3);
                        layoutParams3.topMargin = ((int) (screenHeight - f3)) / 2;
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.e0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.e0.addRule(14);
                        this.e0.topMargin = (screenHeight - c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds203)) / 2;
                        layoutParams = layoutParams3;
                    }
                    this.play_btn.requestLayout();
                }
            }
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.V)) {
                return 0;
            }
            String str = this.V;
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

    public final ObjectAnimator g1(float f2, float f3, float f4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.play_btn, PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f3), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f4));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public void getClickItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i3 = this.f50425e;
            if (i3 != 3 && i3 != 4) {
                statisticItem.param("obj_locate", 2);
            } else {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("obj_type", i2);
            int i4 = this.f50425e;
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

    @Override // c.a.s0.l4.s.b.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.E : (VideoItemModel) invokeV.objValue;
    }

    public String getCurrentMediaID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.s0.l4.s.b.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.r0 : invokeV.intValue;
    }

    public List<String> getMediaIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.clickAnimation == null) {
                this.clickAnimation = AnimationUtils.loadAnimation(getContext(), c.a.s0.l4.a.scale_zoom_in_and_out_anim);
            }
            return this.clickAnimation;
        }
        return (Animation) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            i1(null);
        }
    }

    public void handleActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            c.a.s0.l4.o.a aVar = this.t0;
            if (aVar != null) {
                aVar.m(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                c.a.s0.i3.a.g().m(getPageContext());
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
                if (this.f50425e == 7) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (t1()) {
                l1();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void hideDraftDialog() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (popupDialog = this.X) != null && popupDialog.isShowing()) {
            this.X.dismiss();
        }
    }

    public final void i1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, str) == null) || this.mVideoData == null) {
            return;
        }
        PbCommentFloatActivityConfig pbCommentFloatActivityConfig = new PbCommentFloatActivityConfig(getActivity());
        VideoItemData videoItemData = this.mVideoData;
        PbCommentFloatActivityConfig createNormalCfg = pbCommentFloatActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mVideoData.forum_id));
        createNormalCfg.setForumName(this.mVideoData.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.mVideoData.baijiahaoData);
        int i2 = this.f50425e;
        createNormalCfg.setFromPageType((i2 == 3 || i2 == 4) ? 1 : 2);
        createNormalCfg.setFromVideoPageType(this.f50425e);
        createNormalCfg.setFromVideoPageUniqueId(this.f50427g);
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
            c.a.s0.d1.l.update(this.mVideoData.threadData);
        }
        GoPbCommentFloatListener.sendMessage();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.i0 = true;
        VideoDanmuController videoDanmuController = this.f50431k;
        if (videoDanmuController != null) {
            videoDanmuController.R();
            this.f50431k.H();
        }
        U1();
        this.w0.a0(!this.i0);
        showPbCommentFloatNum();
    }

    public boolean initTiePlusRichTextView() {
        InterceptResult invokeV;
        d2 d2Var;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData == null || (d2Var = videoItemData.threadData) == null) {
                return false;
            }
            if (videoItemData.mRichAbstractList == null && d2Var.X0() == null) {
                return false;
            }
            this.q = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.rich_text_view);
            this.r = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.tie_plus_iamge);
            this.s = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.tie_plus_container);
            this.p = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.recommend_layout);
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.s);
            d2.e(c.a.s0.l4.i.A_X05);
            d2.n(c.a.s0.l4.i.J_X04);
            d2.f(c.a.s0.l4.c.CAM_X0106);
            c.a.r0.s.v.b bVar = (c.a.r0.s.v.b) this.s.getBackground();
            bVar.C(SkinManager.getColor(0, c.a.s0.l4.c.CAM_X0106));
            this.s.setBackground(bVar);
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(this.q);
            d3.v(c.a.s0.l4.c.CAM_X0101);
            d3.z(c.a.s0.l4.d.T_X08);
            d3.A(c.a.s0.l4.i.F_X01);
            List<PbContent> q2 = TiePlusHelper.q(this.mVideoData.mRichAbstractList) != null ? TiePlusHelper.q(this.mVideoData.mRichAbstractList) : null;
            if (TiePlusHelper.q(this.mVideoData.threadData.X0()) != null) {
                q2 = TiePlusHelper.q(this.mVideoData.threadData.X0());
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(q2, 0);
            if (pbContent == null || (tiebaPlusInfo = pbContent.tiebaplus_info) == null) {
                return false;
            }
            Integer num = pbContent.type;
            Integer num2 = tiebaPlusInfo.jump_type;
            c.a.r0.f1.p.a c2 = c.a.r0.f1.p.a.c(num.intValue(), tiebaPlusInfo, this.mVideoData.threadData);
            this.C0 = c2;
            c2.b(this.mVideoData.threadData.U1);
            if (num2.intValue() != 3 && num2.intValue() != 7) {
                if (num2.intValue() == 2) {
                    this.r.setImageDrawable(SkinManager.getDrawable(c.a.s0.l4.e.icon_mask_down));
                } else if (num2.intValue() == 6) {
                    this.r.setImageDrawable(SkinManager.getDrawable(c.a.s0.l4.e.icon_mask_order));
                } else if (num2.intValue() == 5) {
                    this.r.setImageDrawable(SkinManager.getDrawable(c.a.s0.l4.e.icon_mask_message));
                } else {
                    this.r.setImageDrawable(SkinManager.getDrawable(c.a.s0.l4.e.icon_mask_link));
                }
            } else {
                this.r.setImageDrawable(SkinManager.getDrawable(c.a.s0.l4.e.icon_mask_wechat));
            }
            this.q.setText(tiebaPlusInfo.desc);
            this.s.setVisibility(0);
            this.p.setVisibility(8);
            this.s.setOnClickListener(new w0(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.S : invokeV.booleanValue;
    }

    public boolean isUEGBackDisLike() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            VideoItemData videoItemData = this.mVideoData;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.f50425e != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || (tBLottieAnimationView = this.mLiveLottieView) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, c.a.s0.l4.h.card_live_header_bg);
    }

    public final void k1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            int f2 = c.a.d.f.p.m.f(getContext(), c.a.s0.l4.d.tbds26);
            if (this.o != z2) {
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
                this.o = z2;
            }
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048630, this) == null) && t1()) {
            this.t0.a().hide();
            a1(((c.a.s0.l4.o.c) this.t0.a().findToolById(28)).f().getText().toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
            T0();
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c.a.s0.l4.o.a aVar = (c.a.s0.l4.o.a) new c.a.s0.l4.o.b().g(getActivity(), new e0(this));
                this.t0 = aVar;
                if (aVar != null && this.mVideoData != null) {
                    aVar.r(getPageContext());
                    String b2 = TextUtils.isEmpty(this.mVideoData.thread_id) ? "" : DanmuPostDraftManager.f50525b.a().b(this.mVideoData.thread_id);
                    this.t0.s(this.mVideoData.thread_id, this.mVideoData.forum_id, this.mVideoData.forum_name, b2);
                    a1(b2);
                    this.t0.t(new f0(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.mRootView).addView(this.t0.a(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.f50425e == 6 : invokeV.booleanValue;
    }

    public final boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.f50425e == 8 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.Z = forumManageModel;
            forumManageModel.setLoadDataCallBack(new i0(this));
            c.a.r0.i.a c2 = c.a.r0.i.a.c(getBaseFragmentActivity());
            this.a0 = c2;
            if (c2 != null) {
                c2.j(new j0(this));
            }
            this.b0 = new c.a.r0.t.e.a(null);
            registerListener(this.J0);
            registerListener(this.K0);
            registerListener(this.M0);
            registerListener(this.N0);
            registerListener(this.O0);
            registerListener(this.P0);
            registerListener(this.I0);
            registerListener(this.Q0);
            registerListener(this.S0);
            if (TbSingleton.getInstance().getIsNeedShowPbCommentFloat() || AbsVideoChannelFragment.isShowComment) {
                h1();
                TbSingleton.getInstance().setIsNeedShowPbCommentFloat(false);
                AbsVideoChannelFragment.isShowComment = false;
            }
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.k0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048635, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            handleActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048636, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.t0 != null && this.t0.a() != null) {
                    this.t0.a().onChangeSkinType(i2);
                }
                if (this.Y != null) {
                    this.Y.i();
                }
                if (this.mRootView != null) {
                    this.mCommentImg.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.l4.e.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.mShareImg.setImageDrawable(WebPManager.getMaskDrawable(s1() ? c.a.s0.l4.e.icon_mask_video_more36 : c.a.s0.l4.e.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.share_icon_changed.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.l4.e.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.play_btn.setImageDrawable(WebPManager.getMaskDrawable(c.a.s0.l4.e.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                    this.videoLoadingIcon.setImageDrawable(WebPManager.getPureDrawable(c.a.s0.l4.e.icon_pure_header40_n, c.a.s0.v3.c.a(SkinManager.getColor(c.a.s0.l4.c.CAM_X0213), 0.2f), null));
                    U0();
                    c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(this.L);
                    d2.n(c.a.s0.l4.i.J_X05);
                    d2.f(c.a.s0.l4.c.CAM_X0613);
                    c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(this.dragCurTime);
                    d3.A(c.a.s0.l4.i.F_X02);
                    d3.v(c.a.s0.l4.c.CAM_X0101);
                    c.a.r0.s.v.c.d(this.dragTotalTime).A(c.a.s0.l4.i.F_X02);
                    c.a.r0.s.v.c d4 = c.a.r0.s.v.c.d(this.mShareNum);
                    d4.z(c.a.s0.l4.d.T_X09);
                    d4.A(c.a.s0.l4.i.F_X02);
                    d4.y(c.a.s0.l4.b.S_O_X001);
                    c.a.r0.s.v.c d5 = c.a.r0.s.v.c.d(this.mAgreeNum);
                    d5.z(c.a.s0.l4.d.T_X09);
                    d5.A(c.a.s0.l4.i.F_X02);
                    d5.y(c.a.s0.l4.b.S_O_X001);
                    c.a.r0.s.v.c d6 = c.a.r0.s.v.c.d(this.mCommentNum);
                    d6.z(c.a.s0.l4.d.T_X09);
                    d6.A(c.a.s0.l4.i.F_X02);
                    d6.y(c.a.s0.l4.b.S_O_X001);
                    c.a.r0.s.v.c d7 = c.a.r0.s.v.c.d(this.mAuthorNameTv);
                    d7.z(c.a.s0.l4.d.T_X06);
                    d7.A(c.a.s0.l4.i.F_X02);
                    d7.y(c.a.s0.l4.b.S_O_X001);
                    c.a.r0.s.v.c d8 = c.a.r0.s.v.c.d(this.mBarName);
                    d8.z(c.a.s0.l4.d.T_X09);
                    d8.A(c.a.s0.l4.i.F_X01);
                    d8.v(c.a.s0.l4.c.CAM_X0619);
                    d8.y(c.a.s0.l4.b.S_O_X001);
                    c.a.r0.s.v.c d9 = c.a.r0.s.v.c.d(this.A);
                    d9.n(c.a.s0.l4.i.J_X01);
                    d9.z(c.a.s0.l4.d.T_X09);
                    d9.v(c.a.s0.l4.c.CAM_X0101);
                    d9.A(c.a.s0.l4.i.F_X02);
                    d9.f(c.a.s0.l4.c.CAM_X0302);
                    this.dragTotalTime.setTextColor(c.a.s0.v3.c.a(SkinManager.getColor(c.a.s0.l4.c.CAM_X0101), c.a.r0.s.v.a.a(c.a.s0.l4.i.A_X08)));
                    this.mAgreeNum.setTextColor(c.a.s0.v3.c.a(SkinManager.getColor(c.a.s0.l4.c.CAM_X0101), c.a.r0.s.v.a.a(c.a.s0.l4.i.A_X03)));
                    this.mShareNum.setTextColor(c.a.s0.v3.c.a(SkinManager.getColor(c.a.s0.l4.c.CAM_X0101), c.a.r0.s.v.a.a(c.a.s0.l4.i.A_X03)));
                    this.mCommentNum.setTextColor(c.a.s0.v3.c.a(SkinManager.getColor(c.a.s0.l4.c.CAM_X0101), c.a.r0.s.v.a.a(c.a.s0.l4.i.A_X03)));
                }
                WebPManager.setPureDrawable(this.mBackBtn, c.a.s0.l4.e.icon_pure_topbar_return40, c.a.s0.l4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.mMoreBtn, c.a.s0.l4.e.icon_pure_topbar_more40, c.a.s0.l4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                j1();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.s0.l4.m.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, view) == null) {
            super.onClick(view);
            if (view.getId() != c.a.s0.l4.f.video_play_danmu_switch || (cVar = this.l) == null) {
                return;
            }
            cVar.i();
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null) {
                this.l.e(videoItemData.thread_id, this.f50425e);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.H && (videoItemData = this.mVideoData) != null) {
                boolean z2 = c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
                c.a.s0.l4.t.a aVar = this.w0;
                if (aVar == null || !z2) {
                    return;
                }
                if (!(aVar.isFullScreen() && configuration.orientation == 1) && (this.w0.isFullScreen() || configuration.orientation != 2)) {
                    return;
                }
                this.f50430j.removeView(this.mVideoView);
                this.w0.Y(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.L0);
            registerListener(this.e1);
            registerListener(this.f1);
            this.x0 = new c.a.s0.l4.j();
            getLifecycle().addObserver(this.R0);
            if (this.A0 == null) {
                this.A0 = new TiePlusEventController(getContext(), TiePlusStat.Locate.VIDEO_MOUNT);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048640, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
                this.E = videoItemModel;
                this.mVideoData = videoItemModel == null ? null : videoItemModel.getVideoItemData();
                this.J = (Rect) arguments.getParcelable("video_cover_rect");
                this.T = arguments.getInt("video_index");
                arguments.getString("page_from");
                this.V = arguments.getString("from");
                this.W = arguments.getString("video_channel_tab");
                this.g0 = arguments.getString("obj_id");
                this.f50427g = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.f50425e = arguments.getInt("current_type");
                this.f50426f = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            }
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mVideoData.author_info.user_id)) {
                this.S = true;
            }
            this.mRootView = layoutInflater.inflate(c.a.s0.l4.g.video_play_view, (ViewGroup) null);
            this.D0 = true;
            VideoItemData videoItemData2 = this.mVideoData;
            if (videoItemData2 != null && StringUtils.isNull(videoItemData2.video_url) && !StringUtils.isNull(this.mVideoData.thread_id)) {
                VideoDanmuController videoDanmuController = new VideoDanmuController(getPageContext(), getUniqueId(), this.mRootView, c.a.s0.l4.f.video_danmu, this.mVideoData, this.f50425e);
                this.f50431k = videoDanmuController;
                videoDanmuController.X(new f(this));
                this.f50431k.M();
            }
            this.mRootView.setOnTouchListener(new h(this, new GestureDetectorCompat(getContext(), new g(this))));
            this.mRootView.setOnLongClickListener(new i(this));
            TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(getContext());
            this.mVideoView = tbCyberVideoView2;
            tbCyberVideoView2.setStageType("2005");
            this.mVideoView.getMediaProgressObserver().j(new j(this));
            TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(c.a.s0.l4.f.video_cover);
            this.m = tbImageView;
            tbImageView.setDefaultBgResource(c.a.s0.l4.c.transparent);
            this.play_btn = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.play_btn);
            this.videoLoadingLayout = (RelativeLayout) this.mRootView.findViewById(c.a.s0.l4.f.video_loading_layout);
            this.videoLoadingIcon = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.video_loading_icon);
            this.m.setEvent(new l(this));
            this.f50430j = (RelativeLayout) this.mRootView.findViewById(c.a.s0.l4.f.video_play_view_container);
            setVideoBussinessAndAddView();
            this.n = this.mRootView.findViewById(c.a.s0.l4.f.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.n.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.back_btn);
            this.mBackBtn = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.more_btn);
            this.mMoreBtn = imageView2;
            imageView2.setVisibility(8);
            this.mPortraitContainer = this.mRootView.findViewById(c.a.s0.l4.f.portrait_container);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.recommend_layout);
            this.p = linearLayout;
            c.a.r0.s.v.c d2 = c.a.r0.s.v.c.d(linearLayout);
            d2.e(c.a.s0.l4.i.A_X05);
            d2.n(c.a.s0.l4.i.J_X04);
            d2.f(c.a.s0.l4.c.CAM_X0106);
            c.a.r0.s.v.b bVar = (c.a.r0.s.v.b) this.p.getBackground();
            bVar.C(SkinManager.getColor(0, c.a.s0.l4.c.CAM_X0106));
            this.p.setBackground(bVar);
            this.t = (BarImageView) this.mRootView.findViewById(c.a.s0.l4.f.recommend_forum_avatar);
            this.u = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.recommend_avatar);
            this.t.setShowOval(true);
            TextView textView = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.recommend_info_view);
            this.v = textView;
            c.a.r0.s.v.c d3 = c.a.r0.s.v.c.d(textView);
            d3.v(c.a.s0.l4.c.CAM_X0101);
            d3.z(c.a.s0.l4.d.T_X08);
            d3.A(c.a.s0.l4.i.F_X01);
            HeadImageView headImageView = (HeadImageView) this.mRootView.findViewById(c.a.s0.l4.f.author_portrait);
            this.author_portrait = headImageView;
            headImageView.setDefaultResource(17170445);
            this.author_portrait.setPlaceHolder(2);
            this.author_portrait.setIsRound(true);
            this.author_portrait.setBorderWidth(c.a.s0.l4.d.L_X02);
            this.author_portrait.setBorderColor(c.a.s0.l4.c.CAM_X0622);
            this.author_portrait.setDrawBorder(true);
            this.author_portrait.setUseNightOrDarkMask(false);
            I1();
            this.mLiveLottieView = (TBLottieAnimationView) this.mRootView.findViewById(c.a.s0.l4.f.user_living_lottie);
            this.mAttentionLottieView = (TBLottieAnimationView) this.mRootView.findViewById(c.a.s0.l4.f.attention_lottie);
            this.C = (RelativeLayout) this.mRootView.findViewById(c.a.s0.l4.f.author_info_container);
            this.mBottomContainer = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.bottom_container);
            this.A = (TBSpecificationBtn) this.mRootView.findViewById(c.a.s0.l4.f.love_btn);
            c.a.r0.s.i0.n.a aVar = new c.a.r0.s.i0.n.a();
            UtilHelper.addFollowUserIconStyle(aVar);
            aVar.h(c.a.s0.l4.c.CAM_X0101);
            aVar.m(0, 0);
            aVar.n(0);
            aVar.k(true);
            aVar.j(c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.l4.d.tbds145), c.a.d.f.p.m.f(TbadkCoreApplication.getInst().getContext(), c.a.s0.l4.d.tbds60));
            this.A.setConfig(aVar);
            this.A.setText(getString(c.a.s0.l4.i.attention));
            this.mAgreeImg = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.agree_img);
            this.video_title = (ExpandableTextView) this.mRootView.findViewById(c.a.s0.l4.f.video_title);
            this.w = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.title_full_screen_text);
            this.x = this.mRootView.findViewById(c.a.s0.l4.f.title_full_screen_btn);
            this.y = this.mRootView.findViewById(c.a.s0.l4.f.title_play_icon);
            this.z = this.mRootView.findViewById(c.a.s0.l4.f.video_title_layout);
            this.G = (VideoMiddleNiaiControllerView) this.mRootView.findViewById(c.a.s0.l4.f.media_controller);
            this.B = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.video_activity);
            this.commentContainer = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.comment_container);
            this.mCommentNum = (EMTextView) this.mRootView.findViewById(c.a.s0.l4.f.comment_num);
            this.mCommentImg = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.comment_img);
            this.agreeContainer = (RelativeLayout) this.mRootView.findViewById(c.a.s0.l4.f.agree_container);
            this.mDragContainer = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.ll_drag_container);
            this.shareContainer = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.share_container);
            T0();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDragContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mBottomContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.shareContainer.getLayoutParams();
            int i2 = this.f50425e;
            if (i2 != 4 && i2 != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.G.initProgressUIType(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds211);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds123);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds126);
            } else {
                this.G.initProgressUIType(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(c.a.s0.l4.d.M_H_X007);
            }
            this.mAgreeNum = (EMTextView) this.mRootView.findViewById(c.a.s0.l4.f.agree_num);
            this.mShareImg = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.share_img);
            this.mShareNum = (EMTextView) this.mRootView.findViewById(c.a.s0.l4.f.share_num);
            this.dragCurTime = (EMTextView) this.mRootView.findViewById(c.a.s0.l4.f.drag_cur_time);
            this.dragTotalTime = (EMTextView) this.mRootView.findViewById(c.a.s0.l4.f.drag_total_time);
            this.share_icon = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.share_img);
            this.share_icon_changed = (ImageView) this.mRootView.findViewById(c.a.s0.l4.f.share_img_changed);
            C1();
            this.D = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.video_act_private_container);
            this.videoActivityContainer = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.video_activity_container);
            this.video_private = (LinearLayout) this.mRootView.findViewById(c.a.s0.l4.f.video_private);
            this.mAuthorNameTv = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.video_author_name);
            this.mBarName = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.video_bar_name);
            this.L = this.mRootView.findViewById(c.a.s0.l4.f.quick_reply_comment_layout);
            if (c.a.r0.b.d.e0()) {
                this.L.setVisibility(0);
            } else {
                this.L.setVisibility(8);
            }
            this.L.setOnClickListener(new m(this));
            if (this.mVideoData != null) {
                this.G.setVisibility(0);
            }
            this.G.setPlayer(this.mVideoView);
            this.G.setOnSeekBarChangeListener(new n(this));
            this.M = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.quick_reply_comment_text);
            TextView textView2 = (TextView) this.mRootView.findViewById(c.a.s0.l4.f.download_nani_guide_txt);
            this.F = textView2;
            textView2.setVisibility(8);
            String p2 = c.a.r0.s.g0.b.j().p("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(p2)) {
                this.F.setText(p2);
            }
            this.F.setOnClickListener(new o(this, c.a.r0.s.g0.b.j().p("nani_key_download_link_url", null)));
            Y0();
            p pVar = new p(this);
            this.mPortraitContainer.setOnClickListener(pVar);
            this.mAuthorNameTv.setOnClickListener(pVar);
            this.videoActivityContainer.setOnClickListener(new q(this));
            this.video_title.setHasDown();
            this.video_title.setOnClickListener(new r(this));
            if (!c.a.r0.b.d.o0()) {
                this.x.setOnClickListener(new s(this));
            }
            this.mBackBtn.setOnClickListener(new t(this));
            this.mMoreBtn.setOnClickListener(new u(this));
            this.commentContainer.setOnClickListener(new w(this));
            this.agreeContainer.setOnClickListener(new x(this));
            this.shareContainer.setOnClickListener(new y(this));
            this.A.setOnClickListener(new z(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.I = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.I.setAnimationListener(new a0(this));
            this.videoLoadingLayout.setVisibility(0);
            if (this.H) {
                this.G.setLoading(true);
            }
            if (this.J != null && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getParent() != null) {
                Rect rect = this.J;
                int i3 = rect.right;
                int i4 = rect.left;
                this.O = i3 - i4;
                int i5 = rect.bottom;
                int i6 = rect.top;
                this.P = i5 - i6;
                this.Q = i4;
                this.R = i6;
                this.mVideoView.post(new b0(this));
            }
            m1();
            if (this.H) {
                d1();
            }
            VideoItemData videoItemData3 = this.mVideoData;
            if (videoItemData3 != null && !StringUtils.isNull(videoItemData3.video_url)) {
                L1(this.mVideoData.video_url);
                if (c.a.r0.b.d.e0()) {
                    VideoDanmuController videoDanmuController2 = new VideoDanmuController(getPageContext(), getUniqueId(), this.mRootView, c.a.s0.l4.f.video_danmu, this.mVideoData, this.f50425e);
                    this.f50431k = videoDanmuController2;
                    videoDanmuController2.P(this.T0);
                }
            }
            if (c.a.r0.b.d.e0()) {
                c.a.s0.l4.m.c cVar = new c.a.s0.l4.m.c(this.mRootView, c.a.s0.l4.f.video_play_danmu_switch);
                this.l = cVar;
                cVar.g(this);
                this.l.h(new c0(this));
            }
            c.a.s0.l4.t.a aVar2 = new c.a.s0.l4.t.a(getPageContext(), getUniqueId(), this.f50430j, this.f50425e);
            this.w0 = aVar2;
            aVar2.setStageType("2005");
            this.w0.setUniqueId(getUniqueId());
            VideoItemData videoItemData4 = this.mVideoData;
            if (videoItemData4 != null && videoItemData4.threadData == null) {
                videoItemData4.threadData = new d2();
                VideoItemData videoItemData5 = this.mVideoData;
                d2 d2Var = videoItemData5.threadData;
                d2Var.E = videoItemData5.thread_id;
                d2Var.d0 = 40;
                d2Var.r4(c.a.d.f.m.b.e(videoItemData5.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(c.a.d.f.m.b.e(this.mVideoData.video_width, 0));
                builder.video_height = Integer.valueOf(c.a.d.f.m.b.e(this.mVideoData.video_height, 0));
                VideoItemData videoItemData6 = this.mVideoData;
                builder.video_url = videoItemData6.video_url;
                builder.thumbnail_url = videoItemData6.thumbnail_url;
                builder.video_md5 = videoItemData6.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData6.isVerticalVideo);
                this.mVideoData.threadData.K4(builder.build(true));
            }
            VideoItemData videoItemData7 = this.mVideoData;
            if (videoItemData7 != null) {
                K1(videoItemData7, this.w0, this.f50431k);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                c.a.d.f.m.e.a().post(this.G0);
            }
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            stopPlay();
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.L0);
            MessageManager.getInstance().unRegisterListener(this.e1);
            MessageManager.getInstance().unRegisterListener(this.f1);
            if (this.a1 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.a1);
                this.a1 = null;
            }
            c.a.s0.l4.j jVar = this.x0;
            if (jVar != null) {
                jVar.b();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.G0);
            getLifecycle().removeObserver(this.R0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            super.onDestroyView();
            VideoDanmuController videoDanmuController = this.f50431k;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            c.a.s0.l4.m.c cVar = this.l;
            if (cVar != null) {
                cVar.f();
            }
            c.a.s0.l4.t.a aVar = this.w0;
            if (aVar != null) {
                aVar.J0();
            }
            c.a.s0.l4.o.a aVar2 = this.t0;
            if (aVar2 != null) {
                aVar2.n();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.G;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.setOnSeekBarChangeListener(null);
            }
            TbImageView tbImageView = this.m;
            if (tbImageView != null) {
                tbImageView.setEvent(null);
            }
            LinearLayout linearLayout = this.commentContainer;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(null);
            }
            LinearLayout linearLayout2 = this.p;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(null);
            }
            View view = this.L;
            if (view != null) {
                view.setOnClickListener(null);
            }
            ExpandableTextView expandableTextView = this.video_title;
            if (expandableTextView != null) {
                expandableTextView.setOnStatusChangedListener(null);
            }
            TBSpecificationBtn tBSpecificationBtn = this.A;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(null);
            }
            LinearLayout linearLayout3 = this.s;
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
            c.a.d.f.m.e.a().removeCallbacks(this.G0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            super.onPause();
            if (!this.i0) {
                x1();
            }
            l1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            super.onPrimary();
            if (isResumed() && this.H) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.H) {
                        B1();
                        D1();
                        A1(0);
                    } else {
                        x1();
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
            x1();
            l1();
            this.D0 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048645, this) == null) {
            super.onResume();
            if (this.z0) {
                this.z0 = false;
                c.a.d.f.m.e.a().removeCallbacks(this.G0);
                A1(1);
                startPlay();
                d1();
                this.k0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048646, this) == null) {
            super.onStart();
            if (this.i0) {
                D1();
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onStatusChange(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.videoLoadingLayout;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2 = this.G;
                if (videoMiddleNiaiControllerView2 != null) {
                    videoMiddleNiaiControllerView2.setLoading(false);
                }
                o1 o1Var = this.v0;
                if (o1Var != null) {
                    o1Var.onStart();
                }
                TbImageView tbImageView = this.m;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                if (!TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                    TbSingleton.getInstance().setEnableVideoVerticalPreload(true);
                }
                VideoDanmuController videoDanmuController = this.f50431k;
                if (videoDanmuController != null) {
                    videoDanmuController.U();
                }
            } else {
                VideoDanmuController videoDanmuController2 = this.f50431k;
                if (videoDanmuController2 != null) {
                    videoDanmuController2.R();
                }
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView = this.G) != null) {
                videoMiddleNiaiControllerView.setLoading(false);
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.G != null && this.H && isResumed()) {
                this.G.setLoading(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            super.onStop();
            x1();
            l1();
            c.a.d.f.m.e.a().removeCallbacks(this.G0);
        }
    }

    @Override // c.a.r0.f1.r.b.InterfaceC0814b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            if (t1()) {
                l1();
                return;
            }
            TbCyberVideoView tbCyberVideoView = this.mVideoView;
            if (tbCyberVideoView == null || !tbCyberVideoView.isCanShowPause()) {
                return;
            }
            if (this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                if (this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PAUSING || O1()) {
                    return;
                }
                this.mVideoView.start();
                this.play_btn.setVisibility(8);
                W0(true);
                this.G.showProgress();
                if (isResumed() && this.H) {
                    return;
                }
                x1();
                return;
            }
            this.mVideoView.pause();
            G1();
            W0(false);
            c.a.d.f.m.e.a().removeCallbacks(this.a1);
            getClickItem(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048650, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            Y0();
            J1();
        }
    }

    @Override // c.a.r0.f1.r.b.InterfaceC0814b
    public void onViewDoubleClick(float f2, float f3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048651, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.mVideoData) != null && "0".equals(videoItemData.is_agreed)) {
            b1(this.f50429i);
        }
    }

    @Override // c.a.r0.f1.r.b.InterfaceC0814b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048652, this) == null) || r1() || t1() || (videoItemData = this.mVideoData) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long g2 = c.a.d.f.m.b.g(userItemData.user_id, 0L);
        long g3 = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = (g2 == 0 && g3 == 0) ? false : g2 == g3;
        c.a.s0.l4.n.a.a();
        String str = this.mVideoData.author_info.portrait;
        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
        int i2 = this.f50425e;
        PersonPolymericActivityConfig createNormalConfig = personPolymericActivityConfig.createNormalConfig(g2, z2, false, true, (i2 == 3 || i2 == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
        createNormalConfig.setPortrait(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
    }

    public final boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            int i2 = this.f50425e;
            return i2 == 1 || i2 == 2 || TbSingleton.getInstance().isFromFeedVideoClick();
        }
        return invokeV.booleanValue;
    }

    public final boolean q1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048654, this, i2)) == null) {
            if (i2 == 1) {
                int i3 = this.f50425e;
                return i3 == 3 || i3 == 4;
            } else if (i2 == 2) {
                int i4 = this.f50425e;
                return i4 == 1 || i4 == 2;
            } else if (i2 == 3) {
                int i5 = this.f50425e;
                return i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public final boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? n1() && !this.f50426f : invokeV.booleanValue;
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? r1() && isHost() : invokeV.booleanValue;
    }

    @Override // c.a.s0.l4.s.b.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            this.r0 = i2;
        }
    }

    public void setOnProgressUpdatedListener(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, cVar) == null) {
            this.u0 = cVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        c.a.r0.f1.p.a aVar;
        TbCyberVideoView tbCyberVideoView;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.H = z2;
            if (this.w0 != null && (videoItemData = this.mVideoData) != null) {
                this.w0.a0(this.H && (c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0)));
            }
            if (!isResumed() && this.H && v1()) {
                this.z0 = true;
            }
            if (isResumed() && this.H && (!this.k0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                A1(1);
                startPlay();
                d1();
                this.k0 = false;
            } else if (!this.i0) {
                C1();
                this.q0 = 1;
                x1();
            }
            if (this.G != null) {
                if (this.H && isResumed() && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                    this.G.setLoading(true);
                } else {
                    this.G.setLoading(false);
                }
            }
            if (!this.H || this.B0 || (aVar = this.C0) == null || this.A0 == null) {
                return;
            }
            aVar.q(TiePlusStat.StatType.EXPOSE);
            this.A0.statRichTextEvent(this.C0);
            this.B0 = true;
        }
    }

    public void setVideoBussinessAndAddView() {
        TbCyberVideoView tbCyberVideoView;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        TbCyberVideoView tbCyberVideoView2;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048660, this) == null) && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getParent() == null) {
            if (this.mVideoData != null) {
                this.N = new RelativeLayout.LayoutParams(-1, -1);
                int e2 = c.a.d.f.m.b.e(this.mVideoData.video_height, 0);
                int e3 = c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
                int screenHeight = UtilHelper.getScreenHeight(this.mRootView.getContext());
                int k2 = c.a.d.f.p.m.k(this.mRootView.getContext());
                if ("video_channel_tab".equals(this.V)) {
                    screenHeight -= TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                }
                if (e2 <= 0 || e3 <= 0 || screenHeight <= 0 || k2 <= 0) {
                    this.mVideoView.setVideoScalingMode(2);
                    this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.e0 = layoutParams;
                        layoutParams.removeRule(13);
                        this.e0.addRule(14);
                        this.e0.topMargin = (screenHeight - c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds203)) / 2;
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.e0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.e0.addRule(14);
                        this.e0.topMargin = (screenHeight - c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds203)) / 2;
                    }
                    if (f2 > 1.34f) {
                        this.mVideoView.setVideoScalingMode(0);
                        this.m.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else {
                        this.mVideoView.setVideoScalingMode(2);
                        this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
                Rect rect = this.J;
                if (rect != null && !this.K) {
                    int i3 = rect.right;
                    int i4 = rect.left;
                    this.O = i3 - i4;
                    int i5 = rect.bottom;
                    int i6 = rect.top;
                    this.P = i5 - i6;
                    RelativeLayout.LayoutParams layoutParams3 = this.N;
                    layoutParams3.width = i3 - i4;
                    layoutParams3.height = i5 - i6;
                    layoutParams3.topMargin = i6;
                    layoutParams3.leftMargin = i4;
                    layoutParams3.rightMargin = i4;
                } else {
                    this.N = e1();
                }
                if (c.a.r0.b.d.h()) {
                    if (!c.a.r0.b.d.m0() && (i2 = this.f50425e) != 4 && i2 != 3) {
                        this.N.bottomMargin = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds60);
                    } else {
                        this.N.bottomMargin = c.a.d.f.p.m.f(TbadkCoreApplication.getInst(), c.a.s0.l4.d.tbds0);
                    }
                }
                this.m.setLayoutParams(this.N);
                if (this.f50430j != null && (tbCyberVideoView2 = this.mVideoView) != null && tbCyberVideoView2.getView() != null) {
                    this.mVideoView.getView().setId(c.a.s0.l4.f.video_controller_tag);
                    this.f50430j.addView(this.mVideoView.getView(), 0, this.N);
                }
                boolean z2 = c.a.d.f.m.b.e(this.mVideoData.video_height, 0) <= c.a.d.f.m.b.e(this.mVideoData.video_width, 0);
                if (c.a.r0.b.d.o0() && this.mVideoData.video_duration >= 60 && z2) {
                    View inflate = getLayoutInflater().inflate(c.a.s0.l4.g.video_full_screen, (ViewGroup) null);
                    this.mfullScreenView = inflate;
                    EMTextView eMTextView = (EMTextView) this.mfullScreenView.findViewById(c.a.s0.l4.f.full_screen_text);
                    WebPManager.setPureDrawable((ImageView) inflate.findViewById(c.a.s0.l4.f.full_screen_icon), c.a.s0.l4.e.icon_pure_video, c.a.s0.l4.c.CAM_X0101, null);
                    eMTextView.setTextColor(SkinManager.getColor(c.a.s0.l4.c.CAM_X0102));
                    eMTextView.setText(getString(c.a.s0.l4.i.video_full_screen));
                    eMTextView.setGravity(17);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(3, c.a.s0.l4.f.video_controller_tag);
                    layoutParams4.addRule(14, -1);
                    layoutParams4.topMargin = getResources().getDimensionPixelSize(c.a.s0.l4.d.M_H_X004);
                    this.f50430j.addView(this.mfullScreenView, layoutParams4);
                    this.mfullScreenView.setOnClickListener(new a1(this));
                }
            }
            if (this.mVideoData != null) {
                c.a.s0.z2.p pVar = new c.a.s0.z2.p();
                pVar.f26408e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData = this.mVideoData;
                pVar.f26406c = videoItemData.thread_id;
                pVar.t = videoItemData.nid;
                pVar.f26407d = videoItemData.forum_id;
                pVar.m = videoItemData.mMd5;
                pVar.f26414k = "";
                pVar.f26409f = videoItemData.mRecomSource;
                pVar.l = videoItemData.mRecomAbTag;
                pVar.f26413j = 1;
                BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
                if (baijiahaoData != null) {
                    int i7 = baijiahaoData.oriUgcType;
                    if (i7 == 2) {
                        pVar.f26413j = 3;
                    } else if (i7 == 4) {
                        pVar.f26413j = 2;
                    }
                }
                pVar.f26411h = this.mVideoData.mRecomWeight;
                if (this.J != null) {
                    pVar.n = "1";
                } else {
                    pVar.n = "2";
                }
                int i8 = this.f50425e;
                if (i8 == 1) {
                    pVar.p = "1";
                    pVar.a = "13";
                    pVar.f26412i = this.V;
                    pVar.f26414k = this.g0;
                    pVar.f26410g = this.mVideoData.mRecomWeight;
                } else if (i8 == 2) {
                    pVar.a = "24";
                } else {
                    pVar.a = "13";
                }
                pVar.p = "1";
                int i9 = this.f50425e;
                if (i9 == 3) {
                    pVar.a = "21";
                } else if (i9 == 4) {
                    pVar.a = "22";
                } else if (i9 == 7) {
                    pVar.a = "26";
                } else if (o1()) {
                    pVar.a = "27";
                }
                String str = this.V;
                pVar.f26412i = str;
                String str2 = this.g0;
                pVar.f26414k = str2;
                String str3 = this.mVideoData.mRecomWeight;
                pVar.f26410g = str3;
                if (this.f50425e == 5) {
                    pVar.a = "23";
                    pVar.p = "1";
                    pVar.f26412i = str;
                    pVar.f26414k = str2;
                    pVar.f26410g = str3;
                }
                if (n1() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    pVar.f26412i = personalPageParams.getStatPageFromIdentifier();
                }
                this.mVideoView.setVideoStatData(pVar);
                this.mVideoView.setLocateSource("v_mid_page");
            }
            this.mVideoView.setContinuePlayEnable(true);
        }
    }

    public void setVideoPlayPrefetcher(c.a.s0.l4.r.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048661, this, aVar) == null) {
            this.s0 = aVar;
        }
    }

    public void setVideoStatusListener(o1 o1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048662, this, o1Var) == null) {
            this.v0 = o1Var;
        }
    }

    public void showBlockDialog(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048663, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            dismissBlockDialog();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                i2 = z2 ? c.a.s0.l4.i.musk_my_thread_confirm : c.a.s0.l4.i.musk_thread_confirm;
                i3 = c.a.s0.l4.i.musk_my_thread_confirm_subtitle;
                i4 = c.a.s0.l4.i.shield;
            } else {
                i2 = c.a.s0.l4.i.del_my_thread_confirm;
                i3 = c.a.s0.l4.i.del_my_thread_confirm_subtitle;
                i4 = c.a.s0.l4.i.delete;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(c.a.s0.l4.i.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            c.a.r0.s.t.l lVar = new c.a.r0.s.t.l(TbadkCoreApplication.getInst().getCurrentActivity());
            lVar.q(i2);
            lVar.j(i3);
            lVar.l(true);
            lVar.p(aVar2, aVar);
            lVar.g(false);
            this.y0 = lVar.t();
            aVar.a(new e1(this, z2, z3));
            aVar2.a(new f1(this));
        }
    }

    public long showDownloadNaniGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            LinearLayout linearLayout = this.D;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView = this.F;
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
        if (!(interceptable == null || interceptable.invokeV(1048665, this) == null) || this.X == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.X.showDialog();
    }

    public boolean showHeating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            if (c.a.r0.t.c.k0.e()) {
                int i2 = this.f50425e;
                return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void showPbCommentFloatNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.mVideoData.forum_id);
            int i2 = this.f50425e;
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
        if (!(interceptable == null || interceptable.invokeV(1048668, this) == null) || O1()) {
            return;
        }
        M1();
        ImageView imageView = this.play_btn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbCyberVideoView tbCyberVideoView = this.mVideoView;
        if (tbCyberVideoView != null && this.play_btn != null && this.mVideoData != null && tbCyberVideoView.getParent() == null) {
            setVideoBussinessAndAddView();
            J1();
        }
        if (Build.VERSION.SDK_INT < 17 && this.m.getVisibility() == 0) {
            this.m.clearAnimation();
            this.m.startAnimation(this.I);
        }
        if (this.mVideoView != null && !TextUtils.isEmpty(this.d0) && this.mVideoData != null) {
            if (TbVideoViewSet.d().e(this.d0) == null || TbVideoViewSet.d().e(this.d0) != this.mVideoView) {
                this.mVideoView.setVideoPath(this.d0, this.mVideoData.thread_id);
            }
            this.mVideoView.start(this.H0);
            VideoDanmuController videoDanmuController = this.f50431k;
            if (videoDanmuController != null) {
                videoDanmuController.a0();
            }
            this.G.showProgress();
            B1();
        }
        if (this.i0) {
            return;
        }
        if ((isResumed() && this.H) || v1()) {
            return;
        }
        x1();
        VideoDanmuController videoDanmuController2 = this.f50431k;
        if (videoDanmuController2 != null) {
            videoDanmuController2.R();
        }
        if (this.play_btn != null) {
            G1();
        }
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || (tbCyberVideoView = this.mVideoView) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            c.a.s0.l4.o.a aVar = this.t0;
            return (aVar == null || aVar.a() == null || !this.t0.a().isVisible()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (c.a.r0.b.d.p0() && q1(1)) {
                return true;
            }
            if (c.a.r0.b.d.l0() && q1(2)) {
                return true;
            }
            return c.a.r0.b.d.k0() && q1(3);
        }
        return invokeV.booleanValue;
    }

    public final boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            TbCyberVideoView.VideoStatus videoStatus = this.f0;
            return videoStatus == TbCyberVideoView.VideoStatus.INIT || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PREPARED || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048673, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void x1() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048674, this) == null) || (tbCyberVideoView = this.mVideoView) == null) {
            return;
        }
        tbCyberVideoView.pauseWithoutMuteAudioFocus();
    }

    public final void y1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || (tBLottieAnimationView = this.mAttentionLottieView) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        SkinManager.setLottieAnimation(this.mAttentionLottieView, c.a.s0.l4.h.video_tab_attention_animation);
        if (this.mAttentionLottieView.isAnimating()) {
            return;
        }
        this.mAttentionLottieView.setSpeed(1.1f);
        this.mAttentionLottieView.playAnimation();
    }

    public final void z1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048676, this, i2, i3) == null) {
            VideoItemData videoItemData = this.mVideoData;
            if (!(videoItemData == null && videoItemData.video_url == null) && i2 > this.mVideoData.video_duration * 1000) {
                this.D0 = false;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_PTS);
                statisticItem.param("obj_id", this.mVideoData.video_url);
                TiebaStatic.log(statisticItem);
            }
        }
    }
}
