package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import b.a.q0.f1.r.b;
import b.a.q0.i.a;
import b.a.q0.s.q.d2;
import b.a.q0.s.s.a;
import b.a.q0.s.s.i;
import b.a.r0.b4.n.a;
import b.a.r0.b4.s.a;
import b.a.r0.q2.f;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
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
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.VideoInfo;
/* loaded from: classes9.dex */
public class VideoPlayFragment extends BaseFragment implements b.InterfaceC0660b, b.a.r0.b4.r.a.a, TbCyberVideoView.g {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COVER_ANIMINATION_TIME = 350;
    public static final int COVER_TRANSFER_TIME = 200;
    public static final int DEFAULT_OVER_DURATION_LIMIT_TIME = 15000;
    public static final int DRAG_HIDE_SEEKBAR_TIME = 3000;
    public static final int TYPE_VIDEO_CHANNEL_ATTENTION = 4;
    public static final int TYPE_VIDEO_CHANNEL_RECOMMENT = 3;
    public static final int TYPE_VIDEO_FROM_FRS_VIDEO_TAB_PAGE = 7;
    public static final int TYPE_VIDEO_FROM_PERSONAL_PAGE = 6;
    public static final int TYPE_VIDEO_FROM_VIDEO_HOT_TOPIC = 8;
    public static final int TYPE_VIDEO_MIDDLE_ATTENTION = 2;
    public static final int TYPE_VIDEO_MIDDLE_RECOMMENT = 1;
    public static final int TYPE_VIDEO_RECOMMENT_PLAY = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public final CustomMessageListener A0;
    public VideoMiddleNiaiControllerView B;
    public final CustomMessageListener B0;
    public boolean C;
    public final CustomMessageListener C0;
    public AlphaAnimation D;
    public final CustomMessageListener D0;
    public Rect E;
    public final CustomMessageListener E0;
    public boolean F;
    public final CustomMessageListener F0;
    public View G;
    public final CustomMessageListener G0;
    public TextView H;
    public final CustomMessageListener H0;
    public RelativeLayout.LayoutParams I;
    @NonNull
    public final BarManageResultListener I0;
    public int J;
    public final CustomMessageListener J0;
    public int K;
    public View.OnClickListener K0;
    public int L;
    public View.OnClickListener L0;
    public int M;
    public i.d M0;
    public boolean N;
    public i.d N0;
    public int O;
    public i.d O0;
    public String P;
    public i.d P0;
    public String Q;
    public Runnable Q0;
    public String R;
    public CyberPlayerManager.OnInfoListener R0;
    public PopupDialog S;
    public CyberPlayerManager.OnCompletionListener S0;
    public b.a.q0.s.s.i T;
    public CyberPlayerManager.OnPreparedListener T0;
    public ForumManageModel U;
    public CustomMessageListener U0;
    public b.a.q0.i.a V;
    public CustomMessageListener V0;
    public b.a.q0.t.e.a W;
    public BdUniqueId X;
    public String Y;
    public boolean Z;
    public RelativeLayout.LayoutParams a0;
    public LinearLayout agree_container;
    public EMTextView agree_num;
    public HeadImageView author_portrait;
    public RelativeLayout.LayoutParams b0;
    public TbCyberVideoView.VideoStatus c0;
    public Animation clickAnimation;
    public LinearLayout comment_container;
    public EMTextView comment_num;
    public EMTextView dragCurTime;
    public EMTextView dragTotalTime;

    /* renamed from: e  reason: collision with root package name */
    public int f54901e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54902f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f54903g;

    /* renamed from: h  reason: collision with root package name */
    public int f54904h;
    public EMTextView has_love;

    /* renamed from: i  reason: collision with root package name */
    public int f54905i;
    public String i0;
    public RelativeLayout j;
    public boolean j0;
    public TbImageView k;
    public boolean k0;
    public View l;
    public TBLottieAnimationView l0;
    public boolean m;
    public boolean m0;
    public ImageView mAgreeImg;
    public TextView mAuthorNameTv;
    public ImageView mBackBtn;
    public TextView mBarName;
    public LinearLayout mBottomContainer;
    public ImageView mCommentImg;
    public LinearLayout mDragContainer;
    public TBLottieAnimationView mLiveLottieView;
    public ImageView mMoreBtn;
    public View mPortraitContainer;
    public View mRootView;
    public ImageView mShareImg;
    public VideoItemData mVideoData;
    public TbCyberVideoView mVideoView;
    public View mfullScreenView;
    public LinearLayout n;
    public int n0;
    public BarImageView o;
    public int o0;
    public ImageView p;
    public b.a.r0.b4.q.a p0;
    public ImageView play_btn;
    public TextView q;
    public b.a.r0.b4.n.a q0;
    public TextView r;
    public f.c r0;
    public View s;
    public j1 s0;
    public LinearLayout share_container;
    public ImageView share_icon;
    public ImageView share_icon_changed;
    public EMTextView share_num;
    public View t;
    public b.a.r0.b4.s.a t0;
    public View u;
    public b.a.r0.b4.j u0;
    public TBSpecificationBtn v;
    public AlertDialog v0;
    public ImageView videoLoadingIcon;
    public RelativeLayout videoLoadingLayout;
    public LinearLayout video_activity_container;
    public LinearLayout video_private;
    public ExpandableTextView video_title;
    public TextView w;
    public boolean w0;
    public View x;
    public final Runnable x0;
    public LinearLayout y;
    public final TbVideoViewSet.b y0;
    public VideoItemModel z;
    public final CustomMessageListener z0;

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54906a;

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
            this.f54906a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f54906a.k0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.f54906a.f54903g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.f54906a.k0) {
                this.f54906a.k0 = false;
                this.f54906a.t0.a0(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a0 implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54907a;

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
            this.f54907a = videoPlayFragment;
        }

        @Override // b.a.r0.b4.s.a.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f54907a.startPlay();
                } else if (this.f54907a.t0 != null) {
                    this.f54907a.t0.startPlay();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f54908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f54909f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54910g;

        public a1(VideoPlayFragment videoPlayFragment, boolean z, boolean z2) {
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
            this.f54910g = videoPlayFragment;
            this.f54908e = z;
            this.f54909f = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f54910g.v0 != null) {
                    this.f54910g.v0.dismiss();
                }
                if (b.a.e.e.p.j.A()) {
                    ForumManageModel forumManageModel = this.f54910g.U;
                    VideoItemData videoItemData = this.f54910g.mVideoData;
                    forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.f54908e, null, this.f54909f);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    return;
                }
                b.a.e.e.p.l.L(this.f54910g.getContext(), b.a.r0.b4.i.neterror);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54911a;

        /* loaded from: classes9.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f54912e;

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
                this.f54912e = bVar;
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
                    if (this.f54912e.f54911a.I != null) {
                        this.f54912e.f54911a.I.removeRule(14);
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
            this.f54911a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921612 || this.f54911a.getPageContext() == null) {
                return;
            }
            Configuration configuration = this.f54911a.getPageContext().getPageActivity().getResources().getConfiguration();
            if ((configuration == null || configuration.orientation != 2) && this.f54911a.isResumed() && this.f54911a.C) {
                if (this.f54911a.f54901e == 1 && this.f54911a.E != null) {
                    VideoPlayFragment videoPlayFragment = this.f54911a;
                    videoPlayFragment.l1(videoPlayFragment.mVideoView, videoPlayFragment.k, this.f54911a.I.leftMargin, this.f54911a.L, this.f54911a.I.topMargin, this.f54911a.M, this.f54911a.I.width, this.f54911a.J, this.f54911a.I.height, this.f54911a.K, new a(this));
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b0 implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54913a;

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
            this.f54913a = videoPlayFragment;
        }

        @Override // b.a.r0.b4.n.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f54913a.G.setVisibility(8);
                if (z) {
                    this.f54913a.H.setText(b.a.r0.b4.i.reply_something);
                } else {
                    this.f54913a.H.setText(StringUtils.isNull(((b.a.r0.b4.n.c) this.f54913a.q0.a().findToolById(28)).f().getText().toString()) ? b.a.r0.b4.i.reply_something : b.a.r0.b4.i.draft_to_replay);
                }
                VideoItemData videoItemData = this.f54913a.mVideoData;
                if (videoItemData == null || !z) {
                    return;
                }
                long g2 = b.a.e.e.m.b.g(videoItemData.comment_num, 0L) + 1;
                this.f54913a.mVideoData.comment_num = String.valueOf(g2);
                this.f54913a.comment_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(g2));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54914e;

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
            this.f54914e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f54914e.v0 == null) {
                return;
            }
            this.f54914e.v0.dismiss();
        }
    }

    /* loaded from: classes9.dex */
    public class c implements SimpleMessageListener.b<BarManageResultListener.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54915a;

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
            this.f54915a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        public void call(@Nullable BarManageResultListener.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            d2 d2Var = this.f54915a.mVideoData.threadData;
            if (d2Var != null && aVar.d()) {
                int i2 = e1.f54923a[aVar.c().ordinal()];
                if (i2 == 1) {
                    d2Var.e4(true);
                } else if (i2 == 2) {
                    d2Var.e4(false);
                } else if (i2 == 3) {
                    d2Var.r3(true);
                } else if (i2 == 4) {
                    d2Var.r3(false);
                }
            }
            this.f54915a.showToast(aVar.b());
        }
    }

    /* loaded from: classes9.dex */
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54916e;

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
            this.f54916e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f54916e).mVideoData) == null || videoItemData.thread_id == null) {
                return;
            }
            b.a.q0.t.c.k0.b(videoPlayFragment.getPageContext(), this.f54916e.mVideoData.thread_id);
            int i2 = 7;
            if (this.f54916e.f54901e == 1 || this.f54916e.f54901e == 2) {
                i2 = 6;
            } else if (this.f54916e.f54901e != 3) {
                int unused = this.f54916e.f54901e;
            }
            b.a.q0.t.c.k0.a(i2);
        }
    }

    /* loaded from: classes9.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54917a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f54917a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.l3.j0.l)) {
                b.a.r0.l3.j0.l lVar = (b.a.r0.l3.j0.l) customResponsedMessage.getData();
                VideoItemData videoItemData = this.f54917a.mVideoData;
                if (videoItemData == null || (d2Var = videoItemData.threadData) == null || (str = d2Var.E) == null || !str.equals(lVar.f20618a)) {
                    return;
                }
                this.f54917a.mVideoData.threadData.T3(lVar.f20619b ? 1 : 0);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54918a;

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
            this.f54918a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f54918a.isResumed()) {
                this.f54918a.k1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d0 extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54919a;

        public d0(VideoPlayFragment videoPlayFragment) {
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
            this.f54919a = videoPlayFragment;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.f54919a.U.getLoadDataMode() == 0) {
                if (this.f54919a.N0()) {
                    if ((obj instanceof ForumManageModel.b) && this.f54919a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.sendMessage(this.f54919a.getPageContext(), Pair.create(Boolean.valueOf(bVar.f54248a), bVar.f54249b));
                    }
                } else {
                    VideoItemData videoItemData = this.f54919a.mVideoData;
                    if (videoItemData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, videoItemData.getThreadId()));
                    }
                }
                this.f54919a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54920a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f54920a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f54920a.isPrimary() && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.q2.m)) {
                b.a.r0.q2.m mVar = (b.a.r0.q2.m) customResponsedMessage.getData();
                SeekBar seekBar = this.f54920a.B.getSeekBar();
                int i2 = mVar.f22870a;
                if (i2 == 1) {
                    seekBar.setProgress(mVar.f22871b);
                    this.f54920a.B.performOnProgressChanged(seekBar, mVar.f22871b, true);
                } else if (i2 == 2) {
                    this.f54920a.B.performOnStartTrackingTouch(seekBar);
                } else if (i2 == 3) {
                    this.f54920a.B.performOnStopTrackingTouch(seekBar);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54921e;

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
            this.f54921e = videoPlayFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f54921e.onViewDoubleClick(0.0f, 0.0f);
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
                    this.f54921e.onViewDragToRight();
                    this.f54921e.mRootView.cancelLongPress();
                    return true;
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f54921e.V0();
                    this.f54921e.mRootView.cancelLongPress();
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
                this.f54921e.onViewClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e0 implements a.InterfaceC0664a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54922a;

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
            this.f54922a = videoPlayFragment;
        }

        @Override // b.a.q0.i.a.InterfaceC0664a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f54922a.V != null) {
                        this.f54922a.V.h(z2);
                    }
                    VideoItemData videoItemData = this.f54922a.mVideoData;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.f54922a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(b.a.r0.b4.i.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.f54922a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(b.a.r0.b4.i.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.f54922a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(b.a.r0.b4.i.update_mark_failed));
            }
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class e1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f54923a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318570148, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$e1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318570148, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$e1;");
                    return;
                }
            }
            int[] iArr = new int[BarManageResultListener.OptType.values().length];
            f54923a = iArr;
            try {
                iArr[BarManageResultListener.OptType.MAKE_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54923a[BarManageResultListener.OptType.CANCEL_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54923a[BarManageResultListener.OptType.ADD_GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f54923a[BarManageResultListener.OptType.CANCEL_GOOD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f54924e;

        public f(VideoPlayFragment videoPlayFragment, GestureDetectorCompat gestureDetectorCompat) {
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
            this.f54924e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f54924e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class f0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54925e;

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
            this.f54925e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54925e.mLiveLottieView.playAnimation();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54926a;

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
            this.f54926a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.l3.j0.e)) {
                AgreeData agreeData = ((b.a.r0.l3.j0.e) customResponsedMessage.getData()).f20602b;
                if (this.f54926a.mVideoData == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.f54926a.mVideoData.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f54926a.mVideoData.agree_num = String.valueOf(agreeData.agreeNum);
                    this.f54926a.mVideoData.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.f54926a.x0();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f54926a.mVideoData.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f54926a.mVideoData.agree_num = String.valueOf(agreeData.agreeNum);
                this.f54926a.mVideoData.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.f54926a.x0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54927e;

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
            this.f54927e = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f54927e.g1();
                this.f54927e.mRootView.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54928a;

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
            this.f54928a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.f54928a.isResumed() && this.f54928a.C) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                VideoPlayFragment videoPlayFragment = this.f54928a;
                videoPlayFragment.showBlockDialog(videoPlayFragment.N, booleanValue);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54929a;

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
            this.f54929a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            int i2;
            int mainTabBottomBarHeight;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.f54929a.k0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.f54929a.f54903g.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.f54929a.mVideoData == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f2 = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(b.a.r0.b4.d.tbds562);
            int i3 = b.a.e.e.p.l.i(this.f54929a.mRootView.getContext());
            int e2 = b.a.e.e.m.b.e(this.f54929a.mVideoData.video_height, 0);
            int e3 = b.a.e.e.m.b.e(this.f54929a.mVideoData.video_width, 0);
            if (e2 != 0 && e3 != 0) {
                f2 = (e2 * 1.0f) / e3;
            }
            int k = b.a.e.e.p.l.k(this.f54929a.mRootView.getContext());
            float f3 = k * f2;
            if (f2 > 1.0f) {
                float f4 = dimenPixelSize;
                i2 = (int) (((i3 - dimenPixelSize) * floatValue) + f4);
                float f5 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) (UtilHelper.getStatusBarHeight() * f5);
                this.f54929a.b0.topMargin = (int) (((i3 - b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds203)) * 0.5f * floatValue) + (f5 * f4 * 0.5f));
                k = (int) (i2 / f2);
            } else {
                float f6 = dimenPixelSize;
                i2 = (int) (((f3 - f6) * floatValue) + f6);
                float f7 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) ((((i3 - f3) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f7));
                this.f54929a.b0.topMargin = (int) ((((i3 - b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds203)) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (f7 * f6 * 0.5f));
            }
            this.f54929a.I.height = i2;
            this.f54929a.I.width = k;
            this.f54929a.I.topMargin = mainTabBottomBarHeight;
            this.f54929a.play_btn.requestLayout();
            this.f54929a.mVideoView.requestLayout();
        }
    }

    /* loaded from: classes9.dex */
    public class h implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54930e;

        public h(VideoPlayFragment videoPlayFragment) {
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
            this.f54930e = videoPlayFragment;
        }

        @Override // b.a.r0.q2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f54930e.r0 == null) {
                return;
            }
            this.f54930e.r0.onProgressUpdated(i2, i3);
        }
    }

    /* loaded from: classes9.dex */
    public class h0 implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54931a;

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
            this.f54931a = videoPlayFragment;
        }

        @Override // b.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54931a.hideDraftDialog();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54932a;

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
            this.f54932a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (this.f54932a.k0) {
                    if (bool.booleanValue() || !this.f54932a.U0()) {
                        this.f54932a.startPlay();
                        this.f54932a.W0();
                        return;
                    }
                    this.f54932a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54933a;

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
            this.f54933a = videoPlayFragment;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f54933a.videoLoadingLayout.setVisibility(8);
                this.f54933a.mVideoView.setCanShowPause(true);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i0 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54934e;

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
            this.f54934e = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f54934e.S = null;
                this.f54934e.T = null;
                if (TbSingleton.getInstance().isNotchScreen(this.f54934e.getActivity())) {
                    return;
                }
                TbSingleton.getInstance().isCutoutScreen(this.f54934e.getActivity());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54935a;

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
            this.f54935a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f54935a.k0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.f54935a.f54903g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f54935a.U0()) {
                        this.f54935a.startPlay();
                        return;
                    }
                    return;
                }
                this.f54935a.m1();
                this.f54935a.W0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54936e;

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
            this.f54936e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f54936e;
                if (videoPlayFragment.C0(videoPlayFragment.getPageContext(), CyberPlayerManager.MEDIA_INFO_DISABLE_FILECACHE)) {
                    this.f54936e.G.setVisibility(8);
                    if (this.f54936e.q0 != null && this.f54936e.q0.a() != null) {
                        this.f54936e.q0.a().display();
                        VideoPlayFragment videoPlayFragment2 = this.f54936e;
                        if (videoPlayFragment2.mVideoData != null) {
                            videoPlayFragment2.q0.v(this.f54936e.mVideoData);
                        }
                    }
                    if (this.f54936e.mVideoData != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.f54936e.mVideoData.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.f54936e.mVideoData.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54937e;

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
            this.f54937e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54937e.j1(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface j1 {
        void a();

        void onStart();
    }

    /* loaded from: classes9.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54938e;

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
            this.f54938e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayFragment videoPlayFragment;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = (videoPlayFragment = this.f54938e).mVideoView) == null || videoPlayFragment.mVideoData == null) {
                return;
            }
            tbCyberVideoView.setVideoPath(videoPlayFragment.Y, this.f54938e.mVideoData.thread_id);
            this.f54938e.mVideoView.prepareByPause();
        }
    }

    /* loaded from: classes9.dex */
    public class k0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54939a;

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
            this.f54939a = videoPlayFragment;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f54939a.S != null) {
                    this.f54939a.S.dismiss();
                }
                this.f54939a.j1(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54940e;

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
            this.f54940e = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f54940e.F0(true);
                EMTextView eMTextView = this.f54940e.dragCurTime;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = this.f54940e.dragTotalTime;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.f54940e.mVideoView.getDuration()));
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
                statisticItem.param("tid", this.f54940e.mVideoData.thread_id);
                statisticItem.param("fid", this.f54940e.mVideoData.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.f54940e.f54901e != 3 && this.f54940e.f54901e != 4) {
                    statisticItem.param("obj_type", 2);
                } else {
                    statisticItem.param("obj_type", 1);
                }
                statisticItem.param("obj_type", this.f54940e.I0());
                if (this.f54940e.f54901e != 3) {
                    if (this.f54940e.f54901e == 4) {
                        statisticItem.param("obj_source", 2);
                    }
                } else {
                    statisticItem.param("obj_source", 1);
                }
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                int i2 = 1;
                this.f54940e.j0 = true;
                if (this.f54940e.B != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.f54940e.B;
                    if (this.f54940e.f54901e != 4 && this.f54940e.f54901e != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        i2 = 0;
                    }
                    videoMiddleNiaiControllerView.setBottomBarShow(false, i2);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f54940e.j0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(b.a.r0.b4.d.tbds12));
                    seekBar.setThumb(null);
                    this.f54940e.F0(false);
                    if (!this.f54940e.mVideoView.isPlaying()) {
                        this.f54940e.mVideoView.start();
                        this.f54940e.play_btn.setVisibility(8);
                    }
                    if (!this.f54940e.k0 && (!this.f54940e.isResumed() || !this.f54940e.C)) {
                        this.f54940e.W0();
                    }
                    b.a.e.e.m.e.a().removeCallbacks(this.f54940e.Q0);
                    b.a.e.e.m.e.a().postDelayed(this.f54940e.Q0, 3000L);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54941a;

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
            this.f54941a = videoPlayFragment;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f54941a.getContext())) {
                    if (this.f54941a.S != null) {
                        this.f54941a.S.dismiss();
                        return;
                    }
                    return;
                }
                if (this.f54941a.S != null) {
                    this.f54941a.S.dismiss();
                }
                VideoItemData videoItemData = this.f54941a.mVideoData;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.f54941a.mVideoData.thread_id);
                markData.setPostId(this.f54941a.mVideoData.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.f54941a.mVideoData.thread_id);
                markData.setForumId(this.f54941a.mVideoData.forum_id);
                if (this.f54941a.V != null) {
                    this.f54941a.V.i(markData);
                    if (!z) {
                        this.f54941a.V.a();
                    } else {
                        this.f54941a.V.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54942e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54943f;

        public m(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f54943f = videoPlayFragment;
            this.f54942e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f54942e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) b.a.e.a.j.a(this.f54943f.getPageContext().getPageActivity()), new String[]{this.f54942e}, true);
        }
    }

    /* loaded from: classes9.dex */
    public class m0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54944a;

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
            this.f54944a = videoPlayFragment;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54944a.S.dismiss();
                if (!ViewHelper.checkUpIsLogin(this.f54944a.getActivity()) || this.f54944a.getPageContext() == null || (videoItemData = this.f54944a.mVideoData) == null) {
                    return;
                }
                String str = videoItemData.thread_id;
                String str2 = videoItemData.forum_id;
                String string = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.b4.i.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + this.f54944a.mVideoData.post_id;
                VideoItemData videoItemData2 = this.f54944a.mVideoData;
                if (videoItemData2.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f54944a.getPageContext().getPageActivity(), string, str3, true);
                if (this.f54944a.mVideoData.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                this.f54944a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54945e;

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
            this.f54945e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == b.a.r0.b4.f.portrait_container && (videoItemData = this.f54945e.mVideoData) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.f54945e;
                    if (videoPlayFragment.mVideoData.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.f54945e.mVideoData.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.f54945e.mVideoData.getThreadId());
                        UserItemData userItemData2 = this.f54945e.mVideoData.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.f54945e.mVideoData.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.f54945e.mVideoData;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null) {
                    return;
                }
                long g2 = b.a.e.e.m.b.g(userItemData.user_id, 0L);
                long g3 = b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = (g2 == 0 && g3 == 0) ? false : g2 == g3;
                String str = this.f54945e.mVideoData.author_info.portrait;
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.f54945e.getActivity()).createNormalConfig(g2, z, false, true, (this.f54945e.f54901e == 3 || this.f54945e.f54901e == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                createNormalConfig.setPortrait(str);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.f54945e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.f54945e.getClickItem(5);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54946a;

        /* loaded from: classes9.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.q0.s.s.a f54947e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ n0 f54948f;

            public a(n0 n0Var, b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54948f = n0Var;
                this.f54947e = aVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f54947e.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f54948f.f54946a;
                    if (videoPlayFragment.mVideoData != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.U;
                        VideoPlayFragment videoPlayFragment2 = this.f54948f.f54946a;
                        VideoItemData videoItemData = videoPlayFragment2.mVideoData;
                        forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.N, null, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.q0.s.s.a f54949e;

            public b(n0 n0Var, b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {n0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54949e = aVar;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f54949e.dismiss();
                }
            }
        }

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
            this.f54946a = videoPlayFragment;
        }

        @Override // b.a.q0.s.s.i.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f54946a.S.dismiss();
                b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f54946a.getActivity());
                VideoItemData videoItemData = this.f54946a.mVideoData;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(b.a.r0.b4.i.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(b.a.r0.b4.i.del_thread_confirm);
                }
                aVar.setPositiveButton(b.a.r0.b4.i.dialog_ok, new a(this, aVar));
                aVar.setNegativeButton(b.a.r0.b4.i.dialog_cancel, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.f54946a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54950e;

        public o(VideoPlayFragment videoPlayFragment) {
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
            this.f54950e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f54950e).mVideoData) == null || videoItemData.act_info == null) {
                return;
            }
            b.a.q0.m.a.k(videoPlayFragment.getActivity(), this.f54950e.mVideoData.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.f54950e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes9.dex */
    public class o0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54951a;

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
            this.f54951a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f54951a.mVideoData.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54952e;

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
            this.f54952e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54952e.J0();
                this.f54952e.getClickItem(7);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54953a;

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
            this.f54953a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f54953a.mVideoData.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54954e;

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
            this.f54954e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54954e.j.removeView(this.f54954e.mVideoView);
                this.f54954e.t0.X();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54955e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54956f;

        public q0(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f54956f = videoPlayFragment;
            this.f54955e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f54956f.getContext()).createNormalCfg(this.f54955e, "")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54957e;

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
            this.f54957e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.f54957e.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.f54957e.mVideoData.thread_id));
                }
                this.f54957e.getActivity().finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54958a;

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
            this.f54958a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = this.f54958a.mVideoData;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.f54958a.mVideoData.author_info.user_id.equals(data.f45669c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.f54958a.X)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.f45667a) {
                    if (!z || "0".equals(this.f54958a.mVideoData.author_info.is_follow)) {
                        return;
                    }
                    b.a.e.e.p.l.L(this.f54958a.getActivity(), b.a.r0.b4.i.attention_fail);
                    VideoPlayFragment videoPlayFragment = this.f54958a;
                    videoPlayFragment.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment.y0();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.f54958a;
                    videoPlayFragment2.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment2.y0();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.f54958a.mVideoData));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.f54958a;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.y0();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.f54958a.Q)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54959e;

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
            this.f54959e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54959e.g1();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class s0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54960e;

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
            this.f54960e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f54960e.j0) {
                return;
            }
            this.f54960e.z0(true);
        }
    }

    /* loaded from: classes9.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54961e;

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
            this.f54961e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.f54961e.getPageContext(), this.f54961e.mVideoData)) {
                return;
            }
            this.f54961e.J0();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.f54961e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.f54961e.getClickItem(2);
        }
    }

    /* loaded from: classes9.dex */
    public class t0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54962e;

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
            this.f54962e = videoPlayFragment;
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
                VideoPlayFragment videoPlayFragment = this.f54962e;
                View view = videoPlayFragment.mRootView;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).removeView(videoPlayFragment.l0);
                }
                this.f54962e.Z = false;
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

    /* loaded from: classes9.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54963e;

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
            this.f54963e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f54963e;
                videoPlayFragment.E0(videoPlayFragment.f54904h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f54964e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54965f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54966g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f54967h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f54968i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ View n;
        public final /* synthetic */ View o;
        public final /* synthetic */ VideoPlayFragment p;

        public u0(VideoPlayFragment videoPlayFragment, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, View view, View view2) {
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
            this.f54964e = i2;
            this.f54965f = i3;
            this.f54966g = i4;
            this.f54967h = i5;
            this.f54968i = i6;
            this.j = i7;
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
                int i2 = (int) (this.f54964e * animatedFraction);
                int i3 = this.f54965f;
                this.p.I.topMargin = i3 > this.f54966g ? i3 - i2 : i3 + i2;
                int i4 = (int) (this.f54967h * animatedFraction);
                int i5 = this.f54968i;
                int i6 = i5 > this.j ? i5 - i4 : i5 + i4;
                this.p.I.leftMargin = i6;
                this.p.I.rightMargin = i6;
                float f2 = animatedFraction * this.k;
                int i7 = this.l;
                float f3 = i7 > this.m ? i7 - f2 : i7 + f2;
                this.p.I.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.p.I.height = (int) f3;
                this.n.setLayoutParams(this.p.I);
                this.o.setLayoutParams(this.p.I);
                this.n.requestLayout();
                this.o.requestLayout();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54969a;

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
            this.f54969a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            VideoPlayFragment videoPlayFragment;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = (videoPlayFragment = this.f54969a).mVideoView) == null || videoPlayFragment.mVideoData == null) {
                return;
            }
            tbCyberVideoView.setVideoPath(videoPlayFragment.Y, this.f54969a.mVideoData.thread_id);
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            TbCyberVideoView tbCyberVideoView;
            TbCyberVideoView tbCyberVideoView2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbCyberVideoView = this.f54969a.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.clearCallbackAndRemoveFromWindow();
            this.f54969a.mVideoView.setStageType("2005");
            this.f54969a.mVideoView.setLocateSource("v_mid_page");
            this.f54969a.mVideoView.setContinuePlayEnable(true);
            if (this.f54969a.I != null) {
                this.f54969a.k.setLayoutParams(this.f54969a.I);
                if (this.f54969a.j != null && (tbCyberVideoView2 = this.f54969a.mVideoView) != null && tbCyberVideoView2.getView() != null) {
                    this.f54969a.j.addView(this.f54969a.mVideoView.getView(), 0, this.f54969a.I);
                }
            } else {
                this.f54969a.setVideoBussinessAndAddView();
            }
            this.f54969a.d1();
        }
    }

    /* loaded from: classes9.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54970e;

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
            this.f54970e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54970e.j.removeView(this.f54970e.mVideoView);
                this.f54970e.t0.X();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54971e;

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
            this.f54971e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54971e.i1();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.f54971e.mVideoData.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f54971e.getClickItem(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.f54971e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.f54971e.mVideoData.nid);
                BaijiahaoData baijiahaoData = this.f54971e.mVideoData.baijiahaoData;
                if (baijiahaoData != null && !b.a.e.e.p.k.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.f54971e.mVideoData.baijiahaoData.oriUgcVid);
                }
                if (this.f54971e.mVideoData.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.f54971e.mVideoData.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.f54971e.mVideoData.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.f54971e.mVideoData.mRecomSource);
                statisticItem2.param("ab_tag", this.f54971e.mVideoData.mRecomAbTag);
                statisticItem2.param("weight", this.f54971e.mVideoData.mRecomWeight);
                statisticItem2.param("extra", this.f54971e.mVideoData.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (b.a.q0.n0.c.j(this.f54971e.getBaseFragmentActivity()) != null && b.a.q0.n0.c.j(this.f54971e.getBaseFragmentActivity()).b() != null && b.a.q0.n0.c.j(this.f54971e.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(b.a.q0.n0.c.j(this.f54971e.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w0 implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54972e;

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
            this.f54972e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f54972e.C && ((i2 == 3 || i2 == 904) && this.f54972e.k.getVisibility() == 0)) {
                    this.f54972e.k.clearAnimation();
                    this.f54972e.k.startAnimation(this.f54972e.D);
                }
                if (i2 != 10012 || this.f54972e.p0 == null) {
                    return true;
                }
                this.f54972e.p0.prefetch();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54973e;

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
            this.f54973e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f54973e.getActivity())) {
                if (this.f54973e.v != null && (videoItemData = (videoPlayFragment = this.f54973e).mVideoData) != null && videoItemData.author_info != null && videoPlayFragment.has_love != null) {
                    b.a.q0.t.e.a aVar = videoPlayFragment.W;
                    VideoPlayFragment videoPlayFragment2 = this.f54973e;
                    UserItemData userItemData = videoPlayFragment2.mVideoData.author_info;
                    aVar.l(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.X, this.f54973e.mVideoData.forum_id, "0");
                    VideoPlayFragment videoPlayFragment3 = this.f54973e;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.y0();
                    this.f54973e.v.setVisibility(8);
                    this.f54973e.has_love.setVisibility(0);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setStartOffset(1000L);
                    scaleAnimation.setDuration(300L);
                    scaleAnimation.setFillAfter(true);
                    this.f54973e.has_love.startAnimation(scaleAnimation);
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.f54973e.f54901e != 3 && this.f54973e.f54901e != 4) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_source", this.f54973e.I0());
                } else {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.f54973e.mVideoData.thread_id);
                statisticItem.param("fid", this.f54973e.mVideoData.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f54973e.getClickItem(6);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x0 implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54974e;

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
            this.f54974e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f54974e.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.monitorAndStatsAtVerticalVideoReplay();
            this.f54974e.mVideoView.seekTo(0);
            if (b.a.q0.b.d.e()) {
                if (this.f54974e.s0 != null && !this.f54974e.k0) {
                    this.f54974e.s0.a();
                    this.f54974e.k.setVisibility(8);
                    this.f54974e.mVideoView.start();
                } else {
                    this.f54974e.mVideoView.start();
                }
            } else {
                this.f54974e.mVideoView.start();
            }
            this.f54974e.Y0();
            VideoPlayFragment.r0(this.f54974e);
            if (this.f54974e.n0 == 3) {
                this.f54974e.A0();
            }
            if (this.f54974e.k0) {
                return;
            }
            if (this.f54974e.isResumed() && this.f54974e.C) {
                return;
            }
            this.f54974e.W0();
        }
    }

    /* loaded from: classes9.dex */
    public class y implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54975a;

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
            this.f54975a = videoPlayFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f54975a.k == null) {
                return;
            }
            this.f54975a.k.setVisibility(8);
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

    /* loaded from: classes9.dex */
    public class y0 implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54976e;

        public y0(VideoPlayFragment videoPlayFragment) {
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
            this.f54976e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoPlayFragment videoPlayFragment = this.f54976e;
                if (videoPlayFragment.mVideoView != null) {
                    if (videoPlayFragment.B != null) {
                        this.f54976e.B.setVisibility(0);
                        if (this.f54976e.B.getCurProgress() == 0) {
                            this.f54976e.B.showProgress();
                            return;
                        }
                        return;
                    }
                    this.f54976e.B.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54977e;

        /* loaded from: classes9.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ z f54978e;

            public a(z zVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {zVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f54978e = zVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f54978e.f54977e.F = true;
                    if (this.f54978e.f54977e.I != null) {
                        this.f54978e.f54977e.I.addRule(14);
                    }
                }
            }
        }

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
            this.f54977e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams H0 = this.f54977e.H0();
                VideoPlayFragment videoPlayFragment = this.f54977e;
                videoPlayFragment.l1(videoPlayFragment.mVideoView, videoPlayFragment.k, this.f54977e.L, H0.leftMargin, this.f54977e.M, H0.topMargin, this.f54977e.J, H0.width, this.f54977e.K, H0.height, new a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f54979a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f54979a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.f54979a.isResumed() && this.f54979a.C) {
                if (b.a.e.e.p.j.z()) {
                    if (this.f54979a.h1()) {
                        return;
                    }
                    this.f54979a.startPlay();
                    return;
                }
                b.a.e.e.p.l.L(TbadkCoreApplication.getInst(), b.a.r0.b4.i.neterror);
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
        this.f54904h = 0;
        this.f54905i = 1;
        this.m = false;
        this.F = false;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = BdUniqueId.gen();
        this.Z = false;
        this.c0 = TbCyberVideoView.VideoStatus.INIT;
        this.m0 = false;
        this.n0 = 1;
        this.o0 = -1;
        this.x0 = new k(this);
        this.y0 = new v(this);
        this.z0 = new g0(this, 2921607);
        this.A0 = new r0(this, 2001115);
        this.B0 = new z0(this, 2000994);
        this.C0 = new f1(this, 2016528);
        this.D0 = new g1(this, 2921594);
        this.E0 = new h1(this, 2001011);
        this.F0 = new i1(this, 2921596);
        this.G0 = new a(this, 2921598);
        this.H0 = new b(this, 2921612);
        this.I0 = new BarManageResultListener(new c(this));
        this.J0 = new d(this, 2921391);
        this.K0 = new c0(this);
        this.L0 = new j0(this);
        this.M0 = new k0(this);
        this.N0 = new l0(this);
        this.O0 = new m0(this);
        this.P0 = new n0(this);
        this.Q0 = new s0(this);
        this.R0 = new w0(this);
        this.S0 = new x0(this);
        this.T0 = new y0(this);
        this.U0 = new c1(this, 2921603);
        this.V0 = new d1(this, 2921635);
    }

    public static /* synthetic */ int r0(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.n0;
        videoPlayFragment.n0 = i2 + 1;
        return i2;
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || S0() || this.share_icon_changed == null || this.share_icon == null) {
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

    public final void B0() {
        VideoItemData videoItemData;
        String Z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        this.k.startLoad(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.mVideoData.getTitle();
        boolean z2 = b.a.e.e.m.b.e(this.mVideoData.video_height, 0) <= b.a.e.e.m.b.e(this.mVideoData.video_width, 0);
        if (!b.a.q0.b.d.e0()) {
            if (TextUtils.isEmpty(title) && (!z2 || this.mVideoData.video_duration < 60)) {
                this.u.setVisibility(8);
            } else {
                if (z2 && this.mVideoData.video_duration >= 60) {
                    this.s.setVisibility(0);
                    this.t.setBackground(getResources().getDrawable(b.a.r0.b4.e.icon_play12));
                    this.s.setBackground(getResources().getDrawable(b.a.r0.b4.e.icon_play12_bg));
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
                    b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.r);
                    d2.z(b.a.r0.b4.d.T_X09);
                    d2.v(b.a.r0.b4.c.CAM_X0621);
                    this.r.setText(sb.toString());
                } else {
                    this.s.setVisibility(8);
                }
                this.u.setVisibility(0);
                this.video_title.setTextSize(b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.T_X07));
                this.video_title.setTextColor(b.a.r0.b4.c.CAM_X0621);
                this.video_title.setLineSpacingExtra(b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.tbds10));
                this.video_title.setExpandable(false);
                this.video_title.setTextMaxLine(3);
                this.video_title.setLimitLine(3);
                this.video_title.setOnStatusChangedListener(new o0(this));
                ExpandableTextView expandableTextView = this.video_title;
                VideoItemData videoItemData2 = this.mVideoData;
                expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
            }
        } else if (TextUtils.isEmpty(title) && (!z2 || this.mVideoData.video_duration < 60)) {
            this.u.setVisibility(8);
        } else {
            if (this.mVideoData.video_duration >= 60) {
                this.s.setVisibility(0);
                this.s.setForegroundGravity(17);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.t.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.tbds31), b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.tbds31));
                }
                layoutParams.width = b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.tbds3);
                layoutParams.height = b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.tbds34);
                this.t.setLayoutParams(layoutParams);
                this.t.setBackgroundColor(getResources().getColor(b.a.r0.b4.c.CAM_X0618));
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
                b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.r);
                d3.z(b.a.r0.b4.d.T_X08);
                d3.v(b.a.r0.b4.c.CAM_X0618);
                d3.A(b.a.r0.b4.i.F_X02);
                this.r.setText(sb2.toString());
            } else {
                this.s.setVisibility(8);
            }
            this.u.setVisibility(0);
            this.video_title.setTextSize(b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.T_X07));
            this.video_title.setTextColor(b.a.r0.b4.c.CAM_X0621);
            this.video_title.setLineSpacingExtra(b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.tbds10));
            this.video_title.setExpandable(false);
            this.video_title.setTextMaxLine(3);
            this.video_title.setLimitLine(3);
            this.video_title.setOnStatusChangedListener(new p0(this));
            ExpandableTextView expandableTextView2 = this.video_title;
            VideoItemData videoItemData3 = this.mVideoData;
            expandableTextView2.setData(title, videoItemData3.isTitleExpanded, videoItemData3.mWorksInfoData);
        }
        this.comment_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(b.a.e.e.m.b.g(this.mVideoData.comment_num, 0L)));
        this.agree_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(b.a.e.e.m.b.g(this.mVideoData.agree_num, 0L)));
        if (S0()) {
            this.share_num.setText(b.a.r0.b4.i.more);
        } else {
            this.share_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(b.a.e.e.m.b.g(this.mVideoData.share_num, 0L)));
        }
        UserItemData userItemData = this.mVideoData.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.mVideoData.author_info.portrait.startsWith("http")) {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 10, false);
            } else {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 12, false);
            }
            if (T0() && !TextUtils.isEmpty(this.mVideoData.author_info.auth)) {
                this.author_portrait.setShowV(true);
                this.author_portrait.setOriginatorResId(b.a.r0.b4.e.ic_icon_mask_videov14);
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
            if (!StringUtils.isNull(this.mVideoData.forum_name) && this.f54901e != 7 && b.a.q0.b.d.h0()) {
                this.mBarName.setVisibility(0);
                TextView textView = this.mBarName;
                textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.mVideoData.forum_name + TbadkCoreApplication.getInst().getString(b.a.r0.b4.i.bar_default_name), 16, "..."));
            } else {
                this.mBarName.setVisibility(8);
            }
        }
        AlaInfoData alaInfoData = this.mVideoData.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            L0(this.mVideoData.mAlaInfoData.live_status == 1);
            K0();
        }
        if ("1".equals(this.mVideoData.is_private) && this.A.getVisibility() != 0) {
            this.video_private.setVisibility(0);
        } else {
            this.video_private.setVisibility(8);
        }
        if ("1".equals(this.mVideoData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.mVideoData.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.A.getVisibility() != 0) {
            this.video_activity_container.setVisibility(8);
            this.w.setText(this.mVideoData.act_info.activity_name);
        } else {
            this.video_activity_container.setVisibility(8);
        }
        y0();
        if (this.f54901e == 7) {
            this.n.setVisibility(8);
        } else if (b.a.q0.b.d.d0()) {
            if (!TextUtils.isEmpty(this.mVideoData.forum_name)) {
                Z = this.mVideoData.forum_name;
            } else {
                d2 d2Var = this.mVideoData.threadData;
                Z = (d2Var == null || TextUtils.isEmpty(d2Var.Z())) ? null : this.mVideoData.threadData.Z();
            }
            if (TextUtils.isEmpty(Z)) {
                return;
            }
            this.n.setVisibility(0);
            WebPManager.setPureDrawable(this.p, b.a.r0.b4.e.icon_pure_ba32, b.a.r0.b4.c.CAM_X0101, null);
            this.p.setVisibility(0);
            this.o.setVisibility(8);
            String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(Z + TbadkCoreApplication.getInst().getString(b.a.r0.b4.i.bar_default_name), 12, "...吧");
            this.P = cutChineseAndEnglishWithEmoji;
            this.q.setText(cutChineseAndEnglishWithEmoji);
            d2 d2Var2 = this.mVideoData.threadData;
            if (d2Var2 != null && !TextUtils.isEmpty(d2Var2.getRecomReason())) {
                TextView textView2 = this.q;
                textView2.setText(this.P + getActivity().getResources().getString(b.a.r0.b4.i.video_recommend));
            }
            this.n.setOnClickListener(new q0(this, Z));
        } else {
            d2 d2Var3 = this.mVideoData.threadData;
            if (d2Var3 != null) {
                if (TextUtils.isEmpty(d2Var3.getRecomReason())) {
                    this.n.setVisibility(8);
                    return;
                }
                this.n.setVisibility(0);
                this.q.setText(this.mVideoData.threadData.getRecomReason());
                this.o.startLoad(this.mVideoData.threadData.c1, 10, false);
            }
        }
    }

    public final boolean C0(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.mRootView == null || this.Z) {
            return;
        }
        this.Z = true;
        this.l0 = new TBLottieAnimationView(this.mRootView.getContext());
        if (this.a0 == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(b.a.r0.b4.d.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(b.a.r0.b4.d.tbds396));
            this.a0 = layoutParams;
            layoutParams.addRule(13);
        }
        SkinManager.setLottieAnimation(this.l0, b.a.r0.b4.h.lottie_agree_big_photo);
        View view = this.mRootView;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(this.l0, this.a0);
        }
        this.l0.addAnimatorListener(new t0(this));
        this.l0.playAnimation();
    }

    public final void E0(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.mVideoData) != null) {
            int i3 = 0;
            if (i2 == this.f54904h) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.mVideoData;
                    videoItemData2.agree_num = String.valueOf(b.a.e.e.m.b.e(videoItemData2.agree_num, 0) - 1);
                    this.mVideoData.is_agreed = "0";
                    i3 = 1;
                } else {
                    VideoItemData videoItemData3 = this.mVideoData;
                    videoItemData3.agree_num = String.valueOf(b.a.e.e.m.b.e(videoItemData3.agree_num, 0) + 1);
                    this.mVideoData.is_agreed = "1";
                    D0();
                    getClickItem(1);
                }
            } else {
                videoItemData.agree_num = String.valueOf(b.a.e.e.m.b.e(videoItemData.agree_num, 0) + 1);
                this.mVideoData.is_agreed = "1";
                getClickItem(1);
            }
            StatisticItem statisticItem = new StatisticItem("c12795");
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f54904h) {
                statisticItem.param("obj_type", i3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c12003");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f54904h) {
                statisticItem2.param("obj_type", i3);
            } else {
                statisticItem2.param("obj_type", 2);
            }
            if ("index".equals(this.Q)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            b.a.q0.m0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                if (i2 == this.f54904h) {
                    statisticItem3.param("obj_type", i3);
                } else {
                    statisticItem3.param("obj_type", 2);
                }
                int i4 = this.f54901e;
                if (i4 != 3 && i4 != 4) {
                    statisticItem3.param("obj_locate", 2);
                } else {
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("obj_source", I0());
                }
                statisticItem3.param("tid", this.mVideoData.thread_id);
                statisticItem3.param("fid", this.mVideoData.forum_id);
                int i5 = this.f54901e;
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
            B0();
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
            b.a.r0.l3.j0.e eVar = new b.a.r0.l3.j0.e();
            AgreeData agreeData = new AgreeData();
            String str = this.mVideoData.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.mVideoData.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mVideoData.is_agreed);
            eVar.f20602b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.mVideoData));
        }
    }

    public final void F0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) {
            if (z2) {
                this.agree_container.setVisibility(8);
                this.x.setVisibility(8);
                this.comment_container.setVisibility(8);
                this.share_container.setVisibility(8);
                this.mBottomContainer.setVisibility(8);
                this.mDragContainer.setVisibility(0);
                return;
            }
            this.agree_container.setVisibility(0);
            this.x.setVisibility(0);
            this.comment_container.setVisibility(0);
            this.share_container.setVisibility(0);
            this.mBottomContainer.setVisibility(0);
            this.mDragContainer.setVisibility(8);
        }
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.mVideoData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.mVideoData.thread_id);
        statisticItem.param("nid", this.mVideoData.nid);
        statisticItem.param("fid", this.mVideoData.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.O);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", b.a.e.e.p.k.isEmpty(this.mVideoData.mRecomWeight) ? "0" : this.mVideoData.mRecomWeight);
        statisticItem.param("extra", b.a.e.e.p.k.isEmpty(this.mVideoData.mRecomExtra) ? "0" : this.mVideoData.mRecomExtra);
        statisticItem.param("obj_id", this.i0);
        statisticItem.param("ab_tag", b.a.e.e.p.k.isEmpty(this.mVideoData.mRecomAbTag) ? "0" : this.mVideoData.mRecomAbTag);
        statisticItem.param("obj_source", b.a.e.e.p.k.isEmpty(this.mVideoData.mRecomSource) ? "0" : this.mVideoData.mRecomSource);
        statisticItem.param("obj_type", this.Q);
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
        int i3 = this.f54901e;
        if (i3 == 3 || i3 == 4) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.Q);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.R);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final RelativeLayout.LayoutParams H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int screenHeight = UtilHelper.getScreenHeight(this.mRootView.getContext());
            int k2 = b.a.e.e.p.l.k(this.mRootView.getContext());
            if ("video_channel_tab".equals(this.Q)) {
                screenHeight -= TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(k2, screenHeight);
            if (this.mVideoView == null) {
                return layoutParams;
            }
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null) {
                int e2 = b.a.e.e.m.b.e(videoItemData.video_height, 0);
                int e3 = b.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                if (e2 > 0 && e3 > 0 && screenHeight > 0 && k2 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(k2, screenHeight);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.b0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.b0.addRule(14);
                        this.b0.topMargin = (screenHeight - b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds203)) / 2;
                    } else {
                        float f3 = f2 * k2;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(k2, (int) f3);
                        layoutParams3.topMargin = ((int) (screenHeight - f3)) / 2;
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.b0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.b0.addRule(14);
                        this.b0.topMargin = (screenHeight - b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds203)) / 2;
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
    public final int I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.Q)) {
                return 0;
            }
            String str = this.Q;
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

    public final void J0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.mVideoData == null) {
            return;
        }
        PbCommentFloatActivityConfig pbCommentFloatActivityConfig = new PbCommentFloatActivityConfig(getActivity());
        VideoItemData videoItemData = this.mVideoData;
        PbCommentFloatActivityConfig createNormalCfg = pbCommentFloatActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mVideoData.forum_id));
        createNormalCfg.setForumName(this.mVideoData.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.mVideoData.baijiahaoData);
        int i2 = this.f54901e;
        createNormalCfg.setFromPageType((i2 == 3 || i2 == 4) ? 1 : 2);
        createNormalCfg.setFromVideoPageType(this.f54901e);
        createNormalCfg.setFromVideoPageUniqueId(this.f54903g);
        createNormalCfg.setForceInterceptStimeStat(true);
        if (this.mVideoData.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            if (this.mVideoData.threadData.J() != null) {
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2.author_info != null) {
                    videoItemData2.threadData.J().setIsLike("1".equals(this.mVideoData.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            b.a.r0.x0.l.update(this.mVideoData.threadData);
        }
        GoPbCommentFloatListener.sendMessage();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.k0 = true;
        m1();
        this.t0.a0(!this.k0);
        showPbCommentFloatNum();
    }

    public final void K0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (tBLottieAnimationView = this.mLiveLottieView) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, b.a.r0.b4.h.card_live_header_bg);
    }

    public final void L0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z2) == null) {
            int g2 = b.a.e.e.p.l.g(getContext(), b.a.r0.b4.d.tbds26);
            if (this.m != z2) {
                if (this.mLiveLottieView != null) {
                    if (z2) {
                        ViewGroup.LayoutParams layoutParams = this.mPortraitContainer.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.leftMargin = g2;
                            marginLayoutParams.rightMargin = g2;
                            this.mPortraitContainer.setLayoutParams(layoutParams);
                        }
                        this.mLiveLottieView.setVisibility(0);
                        if (!this.mLiveLottieView.isAnimating()) {
                            this.mLiveLottieView.setSpeed(0.8f);
                            this.mLiveLottieView.setRepeatCount(-1);
                            this.mLiveLottieView.post(new f0(this));
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
                this.m = z2;
            }
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                b.a.r0.b4.n.a aVar = (b.a.r0.b4.n.a) new b.a.r0.b4.n.b().a(getActivity());
                this.q0 = aVar;
                if (aVar != null && this.mVideoData != null) {
                    aVar.r(getPageContext());
                    this.q0.s(this.mVideoData.thread_id, this.mVideoData.forum_id, this.mVideoData.forum_name);
                    this.q0.t(new b0(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.mRootView).addView(this.q0.a(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f54901e == 6 : invokeV.booleanValue;
    }

    public final boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f54901e == 8 : invokeV.booleanValue;
    }

    public final boolean P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            int i2 = this.f54901e;
            return i2 == 1 || i2 == 2 || TbSingleton.getInstance().isFromFeedVideoClick();
        }
        return invokeV.booleanValue;
    }

    public final boolean Q0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (i2 == 1) {
                int i3 = this.f54901e;
                return i3 == 3 || i3 == 4;
            } else if (i2 == 2) {
                int i4 = this.f54901e;
                return i4 == 1 || i4 == 2;
            } else if (i2 == 3) {
                int i5 = this.f54901e;
                return i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public final boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? N0() && !this.f54902f : invokeV.booleanValue;
    }

    public final boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? R0() && isHost() : invokeV.booleanValue;
    }

    public final boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (b.a.q0.b.d.f0() && Q0(1)) {
                return true;
            }
            if (b.a.q0.b.d.b0() && Q0(2)) {
                return true;
            }
            return b.a.q0.b.d.a0() && Q0(3);
        }
        return invokeV.booleanValue;
    }

    public final boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            TbCyberVideoView.VideoStatus videoStatus = this.c0;
            return videoStatus == TbCyberVideoView.VideoStatus.INIT || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PREPARED || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.mVideoView;
            if (tbCyberVideoView != null) {
                tbCyberVideoView.pauseWithoutMuteAudioFocus();
            }
            b.a.q0.a.d.y().E();
        }
    }

    public final void X0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && this.mVideoData != null && this.E == null) {
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

    public final void Y0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.mVideoData == null) {
            return;
        }
        b.a.r0.q2.p pVar = new b.a.r0.q2.p();
        pVar.f22882a = "nani_midpage";
        VideoItemData videoItemData = this.mVideoData;
        pVar.f22884c = videoItemData.thread_id;
        pVar.t = videoItemData.nid;
        pVar.f22885d = this.mVideoData.forum_id + "";
        pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.mVideoData;
        pVar.f22887f = videoItemData2.mRecomSource;
        pVar.f22888g = videoItemData2.mRecomAbTag;
        pVar.f22889h = videoItemData2.mRecomWeight;
        pVar.f22890i = "";
        pVar.k = "";
        pVar.m = videoItemData2.mMd5;
        if (this.E != null) {
            pVar.n = "1";
        } else {
            pVar.n = "2";
        }
        int i2 = this.f54901e;
        if (i2 == 1 || i2 == 2) {
            pVar.p = "1";
            pVar.f22882a = "auto_midpage";
            pVar.f22890i = "index";
        }
        b.a.r0.q2.h.e(this.mVideoData.mMd5, "", "1", pVar, this.mVideoView.getPcdnState());
        int i3 = this.f54901e;
        if (i3 == 1 || i3 == 3) {
            b.a.r0.b4.l.e.b(this.mVideoData.mMd5);
        } else if (i3 == 2 || i3 == 4) {
            b.a.r0.b4.l.e.a(this.mVideoData.mMd5);
        }
    }

    public final void Z0() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.share_icon_changed == null || (imageView = this.share_icon) == null) {
            return;
        }
        imageView.clearAnimation();
        this.share_icon_changed.clearAnimation();
        this.share_icon.setVisibility(0);
        this.share_icon_changed.setVisibility(8);
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || h1()) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.mVideoView;
        if (tbCyberVideoView != null && this.play_btn != null && this.mVideoData != null) {
            if (tbCyberVideoView.getParent() == null) {
                setVideoBussinessAndAddView();
                d1();
            }
            if (TbVideoViewSet.d().e(this.Y) == null || TbVideoViewSet.d().e(this.Y) != this.mVideoView) {
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.B;
                if (videoMiddleNiaiControllerView != null) {
                    videoMiddleNiaiControllerView.resetProgress();
                }
                this.mVideoView.setVideoPath(this.Y, this.mVideoData.thread_id);
            }
            this.mVideoView.start(this.y0);
            this.B.showProgress();
            this.play_btn.setVisibility(8);
            f1();
        }
        if (isResumed() && this.C && U0()) {
            return;
        }
        W0();
        ImageView imageView = this.play_btn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.has_love == null) {
            return;
        }
        Drawable drawable = getPageContext().getResources().getDrawable(b.a.r0.b4.e.icon_pure_followed);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(b.a.r0.b4.d.tbds29), UtilHelper.getDimenPixelSize(b.a.r0.b4.d.tbds18));
        this.has_love.setCompoundDrawables(drawable, null, null, null);
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mPortraitContainer.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.author_portrait.getLayoutParams();
            if (!b.a.q0.b.d.h0()) {
                if (layoutParams != null) {
                    layoutParams.width = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds94);
                    layoutParams2.width = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds94);
                    layoutParams.height = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds94);
                    layoutParams2.height = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds94);
                }
            } else if (layoutParams == null || layoutParams2 == null) {
            } else {
                layoutParams.width = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds104);
                layoutParams2.width = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds104);
                layoutParams.height = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds104);
                layoutParams2.height = b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds104);
            }
        }
    }

    public final void d1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.mVideoView.setVideoStatusChangeListener(this);
            this.mVideoView.setOnPreparedListener(this.T0);
            this.mVideoView.setOnCompletionListener(this.S0);
            this.mVideoView.setOnInfoListener(this.R0);
        }
    }

    public void dismissBlockDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (alertDialog = this.v0) != null && alertDialog.isShowing()) {
            this.v0.dismiss();
        }
    }

    public final void e1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || this.mVideoView == null || str == null || str.equals(this.Y)) {
            return;
        }
        this.Y = str;
    }

    public final void f1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && b.a.e.e.p.j.x()) {
            b.a.r0.z3.h.d().g(getContext());
        }
    }

    public final void g1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.S == null) {
                this.T = new b.a.q0.s.s.i(getActivity());
                this.S = new PopupDialog(getPageContext(), this.T);
                ArrayList arrayList = new ArrayList();
                b.a.q0.s.s.f fVar = new b.a.q0.s.s.f(getString(b.a.r0.b4.i.mark), this.T);
                boolean z2 = false;
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    fVar.m(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.b4.i.remove_mark));
                } else {
                    fVar.m(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.b4.i.mark));
                }
                fVar.l(this.N0);
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(fVar);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.mVideoData.thread_id);
                    statisticItem.param("fid", this.mVideoData.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    int i2 = this.f54901e;
                    if (i2 != 3 && i2 != 4) {
                        statisticItem.param("obj_type", 2);
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    int i3 = this.f54901e;
                    if (i3 == 3) {
                        statisticItem.param("obj_param1", 1);
                    } else if (i3 == 4) {
                        statisticItem.param("obj_param1", 2);
                    }
                    statisticItem.param("obj_source", I0());
                    TiebaStatic.log(statisticItem);
                }
                if (isUEGBackDisLike()) {
                    b.a.q0.s.s.f fVar2 = new b.a.q0.s.s.f(getString(b.a.r0.b4.i.not_interested), this.T);
                    fVar2.l(this.M0);
                    arrayList.add(fVar2);
                }
                if (!isHost()) {
                    b.a.q0.s.s.f fVar3 = new b.a.q0.s.s.f(getString(b.a.r0.b4.i.report_text), this.T);
                    fVar3.l(this.O0);
                    arrayList.add(fVar3);
                }
                if (this.N) {
                    b.a.q0.s.s.f fVar4 = new b.a.q0.s.s.f(getString(b.a.r0.b4.i.delete), this.T);
                    fVar4.l(this.P0);
                    arrayList.add(fVar4);
                }
                this.T.l(new h0(this));
                this.S.setOnDismissListener(new i0(this));
                this.T.j(arrayList);
            }
            showDraftDialog();
        }
    }

    public void getClickItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i3 = this.f54901e;
            if (i3 != 3 && i3 != 4) {
                statisticItem.param("obj_locate", 2);
            } else {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("obj_type", i2);
            int i4 = this.f54901e;
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

    @Override // b.a.r0.b4.r.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.z : (VideoItemModel) invokeV.objValue;
    }

    public String getCurrentMediaID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.r0.b4.r.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.o0 : invokeV.intValue;
    }

    public List<String> getMediaIDs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public Animation getScaleAnimation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.clickAnimation == null) {
                this.clickAnimation = AnimationUtils.loadAnimation(getContext(), b.a.r0.b4.a.scale_zoom_in_and_out_anim);
            }
            return this.clickAnimation;
        }
        return (Animation) invokeV.objValue;
    }

    public final boolean h1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (b.a.r0.z3.h.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !((i2 = this.f54901e) == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick() || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.f54901e;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && b.a.e.e.p.j.x() && isResumed() && this.C) {
                b.a.e.e.p.l.N(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(b.a.r0.b4.i.video_no_wifi_tips), 3000);
                int i4 = this.f54901e;
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

    public void handleActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048617, this, i2, i3, intent) == null) {
            b.a.r0.b4.n.a aVar = this.q0;
            if (aVar != null) {
                aVar.m(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                b.a.r0.y2.a.g().m(getPageContext());
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
                if (this.f54901e == 7) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            b.a.r0.b4.n.a aVar = this.q0;
            if (aVar == null || aVar.a() == null || !this.q0.a().isVisible()) {
                return false;
            }
            this.q0.a().hide();
            this.G.setVisibility(8);
            if (!(this.q0.a().findToolById(28) instanceof b.a.r0.b4.n.c) || ((b.a.r0.b4.n.c) this.q0.a().findToolById(28)).f() == null || ((b.a.r0.b4.n.c) this.q0.a().findToolById(28)).f().getText() == null) {
                return true;
            }
            this.H.setText(StringUtils.isNull(((b.a.r0.b4.n.c) this.q0.a().findToolById(28)).f().getText().toString()) ? b.a.r0.b4.i.reply_something : b.a.r0.b4.i.draft_to_replay);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void hideDraftDialog() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (popupDialog = this.S) != null && popupDialog.isShowing()) {
            this.S.dismiss();
        }
    }

    public final void i1() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (videoItemData = this.mVideoData) == null) {
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
        String string = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.b4.i.share_content_tpl);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(b.a.r0.b4.i.default_share_content_tpl);
        VideoItemData videoItemData3 = this.mVideoData;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(b.a.r0.b4.i.default_share_content_tpl_suffix));
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
        shareItem.f45693f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.W = userItemData2.portrait;
            shareItem.X = userItemData2.user_name;
            shareItem.Y = userItemData2.getUserShowName();
        }
        int i2 = this.f54901e;
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
        originalThreadInfo.f45037c = videoItemData5.thumbnail_url;
        originalThreadInfo.f45035a = 3;
        originalThreadInfo.f45036b = videoItemData5.title;
        originalThreadInfo.f45040f = videoItemData5.thread_id;
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
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = isUEGBackDisLike();
        shareDialogConfig.disLikeListener = this.L0;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.Q);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = isHost();
        VideoItemData videoItemData6 = this.mVideoData;
        shareDialogConfig.isManager = videoItemData6.is_manager;
        shareDialogConfig.isOriginManager = videoItemData6.is_origin_manager;
        shareDialogConfig.showHeating = showHeating();
        shareDialogConfig.isSelfHeating = this.N;
        shareDialogConfig.heatingListener = this.K0;
        d2 d2Var = this.mVideoData.threadData;
        if (d2Var != null) {
            shareDialogConfig.isCollected = d2Var.l0() == 1;
            shareDialogConfig.isMadeTop = this.mVideoData.threadData.i2();
            shareDialogConfig.isAddedGood = this.mVideoData.threadData.J1();
        }
        b.a.r0.f0.h.c().l(shareDialogConfig);
    }

    public final boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.N : invokeV.booleanValue;
    }

    public boolean isUEGBackDisLike() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            VideoItemData videoItemData = this.mVideoData;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.f54901e != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j1(boolean z2) {
        b.a.r0.b4.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048623, this, z2) == null) || (jVar = this.u0) == null) {
            return;
        }
        jVar.c(P0());
        this.u0.d(getPageContext(), this.mVideoData, z2);
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            b.a.q0.a.d.y().N(b.a.q0.a.c.b0);
        }
    }

    public final void l1(View view, View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), animatorListenerAdapter}) == null) {
            int max = Math.max(i2, i3);
            int i10 = max - ((i2 + i3) - max);
            int max2 = Math.max(i4, i5);
            int i11 = max2 - ((i4 + i5) - max2);
            int max3 = Math.max(i9, i8);
            ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new u0(this, i11, i4, i5, i10, i2, i3, max3 - ((i9 + i8) - max3), i8, i9, view, view2));
            ofInt.addListener(animatorListenerAdapter);
            ofInt.setTarget(view);
            ofInt.start();
        }
    }

    public final void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.mVideoView;
            if (tbCyberVideoView != null) {
                this.c0 = tbCyberVideoView.getVideoStatus();
            } else {
                this.c0 = TbCyberVideoView.VideoStatus.INIT;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.U = forumManageModel;
            forumManageModel.setLoadDataCallBack(new d0(this));
            b.a.q0.i.a c2 = b.a.q0.i.a.c(getBaseFragmentActivity());
            this.V = c2;
            if (c2 != null) {
                c2.j(new e0(this));
            }
            this.W = new b.a.q0.t.e.a(null);
            registerListener(this.A0);
            registerListener(this.B0);
            registerListener(this.D0);
            registerListener(this.E0);
            registerListener(this.F0);
            registerListener(this.G0);
            registerListener(this.z0);
            registerListener(this.H0);
            registerListener(this.J0);
            if (TbSingleton.getInstance().getIsNeedShowPbCommentFloat() || AbsVideoChannelFragment.isShowComment) {
                J0();
                TbSingleton.getInstance().setIsNeedShowPbCommentFloat(false);
                AbsVideoChannelFragment.isShowComment = false;
            }
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.m0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048628, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            handleActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.q0 != null && this.q0.a() != null) {
                    this.q0.a().onChangeSkinType(i2);
                }
                if (this.T != null) {
                    this.T.i();
                }
                if (this.mRootView != null) {
                    this.mCommentImg.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.mShareImg.setImageDrawable(WebPManager.getMaskDrawable(S0() ? b.a.r0.b4.e.icon_mask_video_more36 : b.a.r0.b4.e.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.share_icon_changed.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.play_btn.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                    this.videoLoadingIcon.setImageDrawable(WebPManager.getPureDrawable(b.a.r0.b4.e.icon_pure_header40_n, b.a.r0.l3.c.a(SkinManager.getColor(b.a.r0.b4.c.CAM_X0213), 0.2f), null));
                    x0();
                    b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.G);
                    d2.n(b.a.r0.b4.i.J_X01);
                    d2.f(b.a.r0.b4.c.CAM_X0614);
                    b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.dragCurTime);
                    d3.A(b.a.r0.b4.i.F_X02);
                    d3.v(b.a.r0.b4.c.CAM_X0101);
                    b.a.q0.s.u.c.d(this.dragTotalTime).A(b.a.r0.b4.i.F_X02);
                    b.a.q0.s.u.c d4 = b.a.q0.s.u.c.d(this.share_num);
                    d4.z(b.a.r0.b4.d.T_X09);
                    d4.A(b.a.r0.b4.i.F_X02);
                    d4.y(b.a.r0.b4.b.S_O_X001);
                    b.a.q0.s.u.c d5 = b.a.q0.s.u.c.d(this.agree_num);
                    d5.z(b.a.r0.b4.d.T_X09);
                    d5.A(b.a.r0.b4.i.F_X02);
                    d5.y(b.a.r0.b4.b.S_O_X001);
                    b.a.q0.s.u.c d6 = b.a.q0.s.u.c.d(this.comment_num);
                    d6.z(b.a.r0.b4.d.T_X09);
                    d6.A(b.a.r0.b4.i.F_X02);
                    d6.y(b.a.r0.b4.b.S_O_X001);
                    b.a.q0.s.u.c d7 = b.a.q0.s.u.c.d(this.mAuthorNameTv);
                    d7.z(b.a.r0.b4.d.T_X06);
                    d7.A(b.a.r0.b4.i.F_X02);
                    d7.y(b.a.r0.b4.b.S_O_X001);
                    b.a.q0.s.u.c d8 = b.a.q0.s.u.c.d(this.mBarName);
                    d8.z(b.a.r0.b4.d.T_X09);
                    d8.A(b.a.r0.b4.i.F_X01);
                    d8.v(b.a.r0.b4.c.CAM_X0619);
                    d8.y(b.a.r0.b4.b.S_O_X001);
                    b.a.q0.s.u.c d9 = b.a.q0.s.u.c.d(this.v);
                    d9.n(b.a.r0.b4.i.J_X01);
                    d9.z(b.a.r0.b4.d.T_X09);
                    d9.v(b.a.r0.b4.c.CAM_X0101);
                    d9.A(b.a.r0.b4.i.F_X02);
                    d9.f(b.a.r0.b4.c.CAM_X0302);
                    b.a.q0.s.u.c d10 = b.a.q0.s.u.c.d(this.has_love);
                    d10.n(b.a.r0.b4.i.J_X01);
                    d10.z(b.a.r0.b4.d.T_X09);
                    d10.f(b.a.r0.b4.c.CAM_X0302);
                    this.dragTotalTime.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(b.a.r0.b4.c.CAM_X0101), b.a.q0.s.u.a.a(b.a.r0.b4.i.A_X08)));
                    this.agree_num.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(b.a.r0.b4.c.CAM_X0101), b.a.q0.s.u.a.a(b.a.r0.b4.i.A_X03)));
                    this.share_num.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(b.a.r0.b4.c.CAM_X0101), b.a.q0.s.u.a.a(b.a.r0.b4.i.A_X03)));
                    this.comment_num.setTextColor(b.a.r0.l3.c.a(SkinManager.getColor(b.a.r0.b4.c.CAM_X0101), b.a.q0.s.u.a.a(b.a.r0.b4.i.A_X03)));
                }
                WebPManager.setPureDrawable(this.mBackBtn, b.a.r0.b4.e.icon_pure_topbar_return40, b.a.r0.b4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.mMoreBtn, b.a.r0.b4.e.icon_pure_topbar_more40, b.a.r0.b4.c.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                K0();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.C && (videoItemData = this.mVideoData) != null) {
                boolean z2 = b.a.e.e.m.b.e(videoItemData.video_height, 0) <= b.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                b.a.r0.b4.s.a aVar = this.t0;
                if (aVar == null || !z2) {
                    return;
                }
                if (!(aVar.isFullScreen() && configuration.orientation == 1) && (this.t0.isFullScreen() || configuration.orientation != 2)) {
                    return;
                }
                this.j.removeView(this.mVideoView);
                this.t0.Y(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.C0);
            registerListener(this.U0);
            registerListener(this.V0);
            this.u0 = new b.a.r0.b4.j();
            getLifecycle().addObserver(this.I0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048632, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            boolean z2 = false;
            if (arguments != null) {
                VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
                this.z = videoItemModel;
                this.mVideoData = videoItemModel == null ? null : videoItemModel.getVideoItemData();
                this.E = (Rect) arguments.getParcelable("video_cover_rect");
                this.O = arguments.getInt("video_index");
                arguments.getString("page_from");
                this.Q = arguments.getString("from");
                this.R = arguments.getString("video_channel_tab");
                this.i0 = arguments.getString("obj_id");
                this.f54903g = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.f54901e = arguments.getInt("current_type");
                this.f54902f = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            }
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mVideoData.author_info.user_id)) {
                this.N = true;
            }
            this.mRootView = layoutInflater.inflate(b.a.r0.b4.g.video_play_view, (ViewGroup) null);
            this.mRootView.setOnTouchListener(new f(this, new GestureDetectorCompat(getContext(), new e(this))));
            this.mRootView.setOnLongClickListener(new g(this));
            TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(getContext());
            this.mVideoView = tbCyberVideoView2;
            tbCyberVideoView2.setStageType("2005");
            this.mVideoView.getMediaProgressObserver().j(new h(this));
            TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(b.a.r0.b4.f.video_cover);
            this.k = tbImageView;
            tbImageView.setDefaultBgResource(b.a.r0.b4.c.transparent);
            this.play_btn = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.play_btn);
            this.videoLoadingLayout = (RelativeLayout) this.mRootView.findViewById(b.a.r0.b4.f.video_loading_layout);
            this.videoLoadingIcon = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.video_loading_icon);
            this.k.setEvent(new i(this));
            this.j = (RelativeLayout) this.mRootView.findViewById(b.a.r0.b4.f.video_play_view_container);
            setVideoBussinessAndAddView();
            this.l = this.mRootView.findViewById(b.a.r0.b4.f.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.back_btn);
            this.mBackBtn = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.more_btn);
            this.mMoreBtn = imageView2;
            imageView2.setVisibility(8);
            this.mPortraitContainer = this.mRootView.findViewById(b.a.r0.b4.f.portrait_container);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.recommend_layout);
            this.n = linearLayout;
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(linearLayout);
            d2.e(b.a.r0.b4.i.A_X05);
            d2.n(b.a.r0.b4.i.J_X04);
            d2.f(b.a.r0.b4.c.CAM_X0106);
            b.a.q0.s.u.b bVar = (b.a.q0.s.u.b) this.n.getBackground();
            bVar.C(SkinManager.getColor(0, b.a.r0.b4.c.CAM_X0106));
            this.n.setBackground(bVar);
            this.o = (BarImageView) this.mRootView.findViewById(b.a.r0.b4.f.recommend_forum_avatar);
            this.p = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.recommend_avatar);
            this.o.setShowOval(true);
            TextView textView = (TextView) this.mRootView.findViewById(b.a.r0.b4.f.recommend_info_view);
            this.q = textView;
            b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(textView);
            d3.v(b.a.r0.b4.c.CAM_X0101);
            d3.z(b.a.r0.b4.d.T_X08);
            d3.A(b.a.r0.b4.i.F_X01);
            HeadImageView headImageView = (HeadImageView) this.mRootView.findViewById(b.a.r0.b4.f.author_portrait);
            this.author_portrait = headImageView;
            headImageView.setDefaultResource(17170445);
            this.author_portrait.setPlaceHolder(2);
            this.author_portrait.setIsRound(true);
            this.author_portrait.setBorderWidth(b.a.r0.b4.d.L_X02);
            this.author_portrait.setBorderColor(b.a.r0.b4.c.CAM_X0622);
            this.author_portrait.setDrawBorder(true);
            this.author_portrait.setUseNightOrDarkMask(false);
            c1();
            this.mLiveLottieView = (TBLottieAnimationView) this.mRootView.findViewById(b.a.r0.b4.f.user_living_lottie);
            this.x = (RelativeLayout) this.mRootView.findViewById(b.a.r0.b4.f.author_info_container);
            this.mBottomContainer = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.bottom_container);
            this.v = (TBSpecificationBtn) this.mRootView.findViewById(b.a.r0.b4.f.love_btn);
            b.a.q0.s.g0.n.a aVar = new b.a.q0.s.g0.n.a();
            UtilHelper.addFollowUserIconStyle(aVar);
            aVar.h(b.a.r0.b4.c.CAM_X0101);
            aVar.m(0, 0);
            aVar.n(0);
            aVar.k(true);
            aVar.j(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.b4.d.tbds145), b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.b4.d.tbds60));
            this.v.setConfig(aVar);
            this.v.setText(getString(b.a.r0.b4.i.attention));
            this.has_love = (EMTextView) this.mRootView.findViewById(b.a.r0.b4.f.has_love);
            b1();
            this.mAgreeImg = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.agree_img);
            this.video_title = (ExpandableTextView) this.mRootView.findViewById(b.a.r0.b4.f.video_title);
            this.r = (TextView) this.mRootView.findViewById(b.a.r0.b4.f.title_full_screen_text);
            this.s = this.mRootView.findViewById(b.a.r0.b4.f.title_full_screen_btn);
            this.t = this.mRootView.findViewById(b.a.r0.b4.f.title_play_icon);
            this.u = this.mRootView.findViewById(b.a.r0.b4.f.video_title_layout);
            this.B = (VideoMiddleNiaiControllerView) this.mRootView.findViewById(b.a.r0.b4.f.media_controller);
            this.w = (TextView) this.mRootView.findViewById(b.a.r0.b4.f.video_activity);
            this.comment_container = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.comment_container);
            this.comment_num = (EMTextView) this.mRootView.findViewById(b.a.r0.b4.f.comment_num);
            this.mCommentImg = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.comment_img);
            this.agree_container = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.agree_container);
            this.mDragContainer = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.ll_drag_container);
            this.share_container = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.share_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDragContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mBottomContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.share_container.getLayoutParams();
            int i2 = this.f54901e;
            if (i2 != 4 && i2 != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.B.initProgressUIType(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(b.a.r0.b4.d.tbds211);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(b.a.r0.b4.d.tbds123);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(b.a.r0.b4.d.tbds126);
            } else {
                this.B.initProgressUIType(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(b.a.r0.b4.d.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(b.a.r0.b4.d.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(b.a.r0.b4.d.M_H_X007);
            }
            this.agree_num = (EMTextView) this.mRootView.findViewById(b.a.r0.b4.f.agree_num);
            this.mShareImg = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.share_img);
            this.share_num = (EMTextView) this.mRootView.findViewById(b.a.r0.b4.f.share_num);
            this.dragCurTime = (EMTextView) this.mRootView.findViewById(b.a.r0.b4.f.drag_cur_time);
            this.dragTotalTime = (EMTextView) this.mRootView.findViewById(b.a.r0.b4.f.drag_total_time);
            this.share_icon = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.share_img);
            this.share_icon_changed = (ImageView) this.mRootView.findViewById(b.a.r0.b4.f.share_img_changed);
            Z0();
            this.y = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.video_act_private_container);
            this.video_activity_container = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.video_activity_container);
            this.video_private = (LinearLayout) this.mRootView.findViewById(b.a.r0.b4.f.video_private);
            this.mAuthorNameTv = (TextView) this.mRootView.findViewById(b.a.r0.b4.f.video_author_name);
            this.mBarName = (TextView) this.mRootView.findViewById(b.a.r0.b4.f.video_bar_name);
            View findViewById = this.mRootView.findViewById(b.a.r0.b4.f.quick_reply_comment_layout);
            this.G = findViewById;
            findViewById.setOnClickListener(new j(this));
            if (this.mVideoData != null) {
                this.B.setVisibility(0);
            }
            this.B.setPlayer(this.mVideoView);
            this.B.setOnSeekBarChangeListener(new l(this));
            this.H = (TextView) this.mRootView.findViewById(b.a.r0.b4.f.quick_reply_comment_text);
            TextView textView2 = (TextView) this.mRootView.findViewById(b.a.r0.b4.f.download_nani_guide_txt);
            this.A = textView2;
            textView2.setVisibility(8);
            String p2 = b.a.q0.s.e0.b.j().p("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(p2)) {
                this.A.setText(p2);
            }
            this.A.setOnClickListener(new m(this, b.a.q0.s.e0.b.j().p("nani_key_download_link_url", null)));
            B0();
            n nVar = new n(this);
            this.mPortraitContainer.setOnClickListener(nVar);
            this.mAuthorNameTv.setOnClickListener(nVar);
            this.video_activity_container.setOnClickListener(new o(this));
            this.video_title.setHasDown();
            this.video_title.setOnClickListener(new p(this));
            if (!b.a.q0.b.d.e0()) {
                this.s.setOnClickListener(new q(this));
            }
            this.mBackBtn.setOnClickListener(new r(this));
            this.mMoreBtn.setOnClickListener(new s(this));
            this.comment_container.setOnClickListener(new t(this));
            this.agree_container.setOnClickListener(new u(this));
            this.share_container.setOnClickListener(new w(this));
            this.v.setOnClickListener(new x(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.D = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.D.setAnimationListener(new y(this));
            this.videoLoadingLayout.setVisibility(0);
            if (this.C) {
                this.B.setLoading(true);
            }
            if (this.E != null && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getParent() != null) {
                Rect rect = this.E;
                int i3 = rect.right;
                int i4 = rect.left;
                this.J = i3 - i4;
                int i5 = rect.bottom;
                int i6 = rect.top;
                this.K = i5 - i6;
                this.L = i4;
                this.M = i6;
                this.mVideoView.post(new z(this));
            }
            M0();
            if (this.C) {
                G0();
            }
            VideoItemData videoItemData2 = this.mVideoData;
            if (videoItemData2 != null && !StringUtils.isNull(videoItemData2.video_url)) {
                e1(this.mVideoData.video_url);
            }
            b.a.r0.b4.s.a aVar2 = new b.a.r0.b4.s.a(getContext(), this.j);
            this.t0 = aVar2;
            aVar2.setStageType("2005");
            this.t0.setUniqueId(getUniqueId());
            VideoItemData videoItemData3 = this.mVideoData;
            if (videoItemData3 != null && videoItemData3.threadData == null) {
                videoItemData3.threadData = new d2();
                VideoItemData videoItemData4 = this.mVideoData;
                d2 d2Var = videoItemData4.threadData;
                d2Var.E = videoItemData4.thread_id;
                d2Var.i0 = 40;
                d2Var.n4(b.a.e.e.m.b.e(videoItemData4.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(b.a.e.e.m.b.e(this.mVideoData.video_width, 0));
                builder.video_height = Integer.valueOf(b.a.e.e.m.b.e(this.mVideoData.video_height, 0));
                VideoItemData videoItemData5 = this.mVideoData;
                builder.video_url = videoItemData5.video_url;
                builder.thumbnail_url = videoItemData5.thumbnail_url;
                builder.video_md5 = videoItemData5.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData5.isVerticalVideo);
                this.mVideoData.threadData.G4(builder.build(true));
            }
            VideoItemData videoItemData6 = this.mVideoData;
            if (videoItemData6 != null) {
                this.t0.setData(videoItemData6.threadData);
                boolean z3 = b.a.e.e.m.b.e(this.mVideoData.video_height, 0) <= b.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                b.a.r0.b4.s.a aVar3 = this.t0;
                if (this.C && z3) {
                    z2 = true;
                }
                aVar3.a0(z2);
                this.t0.F0(new a0(this));
                this.t0.getMainView().setVisibility(8);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                b.a.e.e.m.e.a().post(this.x0);
            }
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            stopPlay();
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.C0);
            b.a.r0.b4.s.a aVar = this.t0;
            if (aVar != null) {
                aVar.E0();
            }
            MessageManager.getInstance().unRegisterListener(this.U0);
            MessageManager.getInstance().unRegisterListener(this.V0);
            b.a.r0.b4.n.a aVar2 = this.q0;
            if (aVar2 != null) {
                aVar2.n();
            }
            if (this.Q0 != null) {
                b.a.e.e.m.e.a().removeCallbacks(this.Q0);
                this.Q0 = null;
            }
            b.a.r0.b4.j jVar = this.u0;
            if (jVar != null) {
                jVar.b();
            }
            b.a.e.e.m.e.a().removeCallbacks(this.x0);
            getLifecycle().removeObserver(this.I0);
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.B;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.setOnSeekBarChangeListener(null);
            }
            TbImageView tbImageView = this.k;
            if (tbImageView != null) {
                tbImageView.setEvent(null);
            }
            LinearLayout linearLayout = this.comment_container;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(null);
            }
            LinearLayout linearLayout2 = this.n;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(null);
            }
            View view = this.G;
            if (view != null) {
                view.setOnClickListener(null);
            }
            MessageManager.getInstance().unRegisterListener(this.J0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.onPause();
            if (!this.k0) {
                W0();
            }
            b.a.r0.b4.n.a aVar = this.q0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.q0.a().hide();
            this.G.setVisibility(8);
            this.H.setText(StringUtils.isNull(((b.a.r0.b4.n.c) this.q0.a().findToolById(28)).f().getText().toString()) ? b.a.r0.b4.i.reply_something : b.a.r0.b4.i.draft_to_replay);
            b.a.q0.a.d.y().E();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onPrimary();
            if (isResumed() && this.C) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.C) {
                        Y0();
                        a1();
                        X0(0);
                    } else {
                        W0();
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
            W0();
            b.a.r0.b4.n.a aVar = this.q0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.q0.a().hide();
            this.G.setVisibility(8);
            this.H.setText(StringUtils.isNull(((b.a.r0.b4.n.c) this.q0.a().findToolById(28)).f().getText().toString()) ? b.a.r0.b4.i.reply_something : b.a.r0.b4.i.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.onResume();
            k1();
            if (this.w0) {
                this.w0 = false;
                b.a.e.e.m.e.a().removeCallbacks(this.x0);
                X0(1);
                startPlay();
                G0();
                this.m0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.onStart();
            if (this.k0) {
                a1();
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onStatusChange(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.videoLoadingLayout;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2 = this.B;
                if (videoMiddleNiaiControllerView2 != null) {
                    videoMiddleNiaiControllerView2.setLoading(false);
                }
                j1 j1Var = this.s0;
                if (j1Var != null) {
                    j1Var.onStart();
                }
                TbImageView tbImageView = this.k;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                if (!TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                    TbSingleton.getInstance().setEnableVideoVerticalPreload(true);
                }
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView = this.B) != null) {
                videoMiddleNiaiControllerView.setLoading(false);
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.B != null && this.C && isResumed()) {
                this.B.setLoading(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            super.onStop();
            W0();
            b.a.r0.b4.n.a aVar = this.q0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.q0.a().hide();
            this.G.setVisibility(8);
            this.H.setText(StringUtils.isNull(((b.a.r0.b4.n.c) this.q0.a().findToolById(28)).f().getText().toString()) ? b.a.r0.b4.i.reply_something : b.a.r0.b4.i.draft_to_replay);
            b.a.e.e.m.e.a().removeCallbacks(this.x0);
        }
    }

    @Override // b.a.q0.f1.r.b.InterfaceC0660b
    public void onViewClick() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048640, this) == null) && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.isCanShowPause()) {
            if (this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                if (this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PAUSING || h1()) {
                    return;
                }
                this.mVideoView.start();
                this.play_btn.setVisibility(8);
                z0(true);
                this.B.showProgress();
                if (isResumed() && this.C) {
                    return;
                }
                W0();
                return;
            }
            this.mVideoView.pause();
            this.play_btn.setVisibility(0);
            z0(false);
            b.a.e.e.m.e.a().removeCallbacks(this.Q0);
            getClickItem(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048641, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            B0();
            d1();
        }
    }

    @Override // b.a.q0.f1.r.b.InterfaceC0660b
    public void onViewDoubleClick(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048642, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity())) {
            D0();
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData == null || !"0".equals(videoItemData.is_agreed)) {
                return;
            }
            E0(this.f54905i);
        }
    }

    @Override // b.a.q0.f1.r.b.InterfaceC0660b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048643, this) == null) || R0() || (videoItemData = this.mVideoData) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long g2 = b.a.e.e.m.b.g(userItemData.user_id, 0L);
        long g3 = b.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = (g2 == 0 && g3 == 0) ? false : g2 == g3;
        b.a.r0.b4.m.a.a();
        MessageManager messageManager = MessageManager.getInstance();
        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
        int i2 = this.f54901e;
        messageManager.sendMessage(new CustomMessage(2002001, personPolymericActivityConfig.createNormalConfig(g2, z2, false, true, (i2 == 3 || i2 == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE)));
    }

    @Override // b.a.r0.b4.r.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.o0 = i2;
        }
    }

    public void setOnProgressUpdatedListener(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, cVar) == null) {
            this.r0 = cVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        TbCyberVideoView tbCyberVideoView;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.C = z2;
            if (this.t0 != null && (videoItemData = this.mVideoData) != null) {
                this.t0.a0(this.C && (b.a.e.e.m.b.e(videoItemData.video_height, 0) <= b.a.e.e.m.b.e(this.mVideoData.video_width, 0)));
            }
            if (!z2 && this.q0 != null) {
                this.H.setText(b.a.r0.b4.i.reply_something);
                this.q0.l();
            }
            if (!isResumed() && this.C) {
                this.w0 = true;
            }
            if (isResumed() && this.C && (!this.m0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                X0(1);
                startPlay();
                G0();
                this.m0 = false;
            } else if (!this.k0) {
                Z0();
                this.n0 = 1;
                W0();
            }
            if (this.B != null) {
                if (this.C && isResumed() && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                    this.B.setLoading(true);
                } else {
                    this.B.setLoading(false);
                }
            }
        }
    }

    public void setVideoBussinessAndAddView() {
        TbCyberVideoView tbCyberVideoView;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        TbCyberVideoView tbCyberVideoView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048647, this) == null) && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getParent() == null) {
            if (this.mVideoData != null) {
                this.I = new RelativeLayout.LayoutParams(-1, -1);
                int e2 = b.a.e.e.m.b.e(this.mVideoData.video_height, 0);
                int e3 = b.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                int screenHeight = UtilHelper.getScreenHeight(this.mRootView.getContext());
                int k2 = b.a.e.e.p.l.k(this.mRootView.getContext());
                if ("video_channel_tab".equals(this.Q)) {
                    screenHeight -= TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                }
                if (e2 <= 0 || e3 <= 0 || screenHeight <= 0 || k2 <= 0) {
                    this.mVideoView.setVideoScalingMode(2);
                    this.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.b0 = layoutParams;
                        layoutParams.removeRule(13);
                        this.b0.addRule(14);
                        this.b0.topMargin = (screenHeight - b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds203)) / 2;
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.b0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.b0.addRule(14);
                        this.b0.topMargin = (screenHeight - b.a.e.e.p.l.g(TbadkCoreApplication.getInst(), b.a.r0.b4.d.tbds203)) / 2;
                    }
                    if (f2 > 1.34f) {
                        this.mVideoView.setVideoScalingMode(0);
                        this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else {
                        this.mVideoView.setVideoScalingMode(2);
                        this.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
                Rect rect = this.E;
                if (rect != null && !this.F) {
                    int i2 = rect.right;
                    int i3 = rect.left;
                    this.J = i2 - i3;
                    int i4 = rect.bottom;
                    int i5 = rect.top;
                    this.K = i4 - i5;
                    RelativeLayout.LayoutParams layoutParams3 = this.I;
                    layoutParams3.width = i2 - i3;
                    layoutParams3.height = i4 - i5;
                    layoutParams3.topMargin = i5;
                    layoutParams3.leftMargin = i3;
                    layoutParams3.rightMargin = i3;
                } else {
                    this.I = H0();
                }
                this.k.setLayoutParams(this.I);
                if (this.j != null && (tbCyberVideoView2 = this.mVideoView) != null && tbCyberVideoView2.getView() != null) {
                    this.mVideoView.getView().setId(b.a.r0.b4.f.video_controller_tag);
                    this.j.addView(this.mVideoView.getView(), 0, this.I);
                }
                boolean z2 = b.a.e.e.m.b.e(this.mVideoData.video_height, 0) <= b.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                if (b.a.q0.b.d.e0() && this.mVideoData.video_duration >= 60 && z2) {
                    View inflate = getLayoutInflater().inflate(b.a.r0.b4.g.video_full_screen, (ViewGroup) null);
                    this.mfullScreenView = inflate;
                    ImageView imageView = (ImageView) inflate.findViewById(b.a.r0.b4.f.full_screen_icon);
                    EMTextView eMTextView = (EMTextView) this.mfullScreenView.findViewById(b.a.r0.b4.f.full_screen_text);
                    WebPManager.setPureDrawable(imageView, b.a.r0.b4.e.icon_pure_video, b.a.r0.b4.c.CAM_X0101, null);
                    eMTextView.setTextColor(SkinManager.getColor(b.a.r0.b4.c.CAM_X0102));
                    imageView.setForegroundGravity(17);
                    eMTextView.setText(getString(b.a.r0.b4.i.video_full_screen));
                    eMTextView.setGravity(17);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams4.addRule(3, b.a.r0.b4.f.video_controller_tag);
                    layoutParams4.addRule(14, -1);
                    layoutParams4.topMargin = getResources().getDimensionPixelSize(b.a.r0.b4.d.M_H_X004);
                    this.j.addView(this.mfullScreenView, layoutParams4);
                    this.mfullScreenView.setOnClickListener(new v0(this));
                }
            }
            if (this.mVideoData != null) {
                b.a.r0.q2.p pVar = new b.a.r0.q2.p();
                pVar.f22886e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData = this.mVideoData;
                pVar.f22884c = videoItemData.thread_id;
                pVar.t = videoItemData.nid;
                pVar.f22885d = videoItemData.forum_id;
                pVar.m = videoItemData.mMd5;
                pVar.k = "";
                pVar.f22887f = videoItemData.mRecomSource;
                pVar.l = videoItemData.mRecomAbTag;
                pVar.j = 1;
                BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
                if (baijiahaoData != null) {
                    int i6 = baijiahaoData.oriUgcType;
                    if (i6 == 2) {
                        pVar.j = 3;
                    } else if (i6 == 4) {
                        pVar.j = 2;
                    }
                }
                pVar.f22889h = this.mVideoData.mRecomWeight;
                if (this.E != null) {
                    pVar.n = "1";
                } else {
                    pVar.n = "2";
                }
                int i7 = this.f54901e;
                if (i7 == 1) {
                    pVar.p = "1";
                    pVar.f22882a = "13";
                    pVar.f22890i = this.Q;
                    pVar.k = this.i0;
                    pVar.f22888g = this.mVideoData.mRecomWeight;
                } else if (i7 == 2) {
                    pVar.f22882a = "24";
                } else {
                    pVar.f22882a = "13";
                }
                pVar.p = "1";
                int i8 = this.f54901e;
                if (i8 == 3) {
                    pVar.f22882a = "21";
                } else if (i8 == 4) {
                    pVar.f22882a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
                } else if (i8 == 7) {
                    pVar.f22882a = "26";
                } else if (O0()) {
                    pVar.f22882a = "27";
                }
                String str = this.Q;
                pVar.f22890i = str;
                String str2 = this.i0;
                pVar.k = str2;
                String str3 = this.mVideoData.mRecomWeight;
                pVar.f22888g = str3;
                if (this.f54901e == 5) {
                    pVar.f22882a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR;
                    pVar.p = "1";
                    pVar.f22890i = str;
                    pVar.k = str2;
                    pVar.f22888g = str3;
                }
                if (N0() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    pVar.f22890i = personalPageParams.getStatPageFromIdentifier();
                }
                this.mVideoView.setVideoStatData(pVar);
                this.mVideoView.setLocateSource("v_mid_page");
            }
            this.mVideoView.setContinuePlayEnable(true);
        }
    }

    public void setVideoPlayPrefetcher(b.a.r0.b4.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, aVar) == null) {
            this.p0 = aVar;
        }
    }

    public void setVideoStatusListener(j1 j1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, j1Var) == null) {
            this.s0 = j1Var;
        }
    }

    public void showBlockDialog(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048650, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            dismissBlockDialog();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                i2 = z2 ? b.a.r0.b4.i.musk_my_thread_confirm : b.a.r0.b4.i.musk_thread_confirm;
                i3 = b.a.r0.b4.i.musk_my_thread_confirm_subtitle;
                i4 = b.a.r0.b4.i.shield;
            } else {
                i2 = b.a.r0.b4.i.del_my_thread_confirm;
                i3 = b.a.r0.b4.i.del_my_thread_confirm_subtitle;
                i4 = b.a.r0.b4.i.delete;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(b.a.r0.b4.i.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            b.a.q0.s.s.l lVar = new b.a.q0.s.s.l(TbadkCoreApplication.getInst().getCurrentActivity());
            lVar.q(i2);
            lVar.j(i3);
            lVar.l(true);
            lVar.p(aVar2, aVar);
            lVar.g(false);
            this.v0 = lVar.t();
            aVar.a(new a1(this, z2, z3));
            aVar2.a(new b1(this));
        }
    }

    public long showDownloadNaniGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            LinearLayout linearLayout = this.y;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView = this.A;
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
        if (!(interceptable == null || interceptable.invokeV(1048652, this) == null) || this.S == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.S.showDialog();
    }

    public boolean showHeating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (b.a.q0.t.c.k0.e()) {
                int i2 = this.f54901e;
                return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void showPbCommentFloatNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.mVideoData.forum_id);
            int i2 = this.f54901e;
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
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || h1()) {
            return;
        }
        f1();
        ImageView imageView = this.play_btn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbCyberVideoView tbCyberVideoView = this.mVideoView;
        if (tbCyberVideoView != null && this.play_btn != null && this.mVideoData != null && tbCyberVideoView.getParent() == null) {
            setVideoBussinessAndAddView();
            d1();
        }
        if (Build.VERSION.SDK_INT < 17 && this.k.getVisibility() == 0) {
            this.k.clearAnimation();
            this.k.startAnimation(this.D);
        }
        if (this.mVideoView != null && !TextUtils.isEmpty(this.Y) && this.mVideoData != null) {
            if (TbVideoViewSet.d().e(this.Y) == null || TbVideoViewSet.d().e(this.Y) != this.mVideoView) {
                this.mVideoView.setVideoPath(this.Y, this.mVideoData.thread_id);
            }
            this.mVideoView.start(this.y0);
            this.B.showProgress();
            Y0();
        }
        if (this.k0) {
            return;
        }
        if ((isResumed() && this.C) || U0()) {
            return;
        }
        W0();
        ImageView imageView2 = this.play_btn;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048656, this) == null) || (tbCyberVideoView = this.mVideoView) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final void x0() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048657, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(b.a.r0.b4.e.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.agree_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(b.a.e.e.m.b.g(this.mVideoData.agree_num, 0L)));
    }

    public final void y0() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            if (!this.N && ((userItemData = this.mVideoData.author_info) == null || !"1".equals(userItemData.is_follow))) {
                this.v.setVisibility(0);
                this.v.setClickable(true);
                this.has_love.setVisibility(8);
                return;
            }
            this.v.setVisibility(4);
            this.v.setClickable(false);
            this.has_love.setVisibility(8);
        }
    }

    public final void z0(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048659, this, z2) == null) || (videoMiddleNiaiControllerView = this.B) == null) {
            return;
        }
        int i2 = this.f54901e;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick()) ? 1 : 0);
    }
}
