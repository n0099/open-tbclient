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
import c.a.q0.f1.q.b;
import c.a.q0.i.a;
import c.a.q0.s.q.d2;
import c.a.q0.s.s.a;
import c.a.q0.s.s.i;
import c.a.r0.a4.e.a;
import c.a.r0.a4.j.a;
import c.a.r0.q2.f;
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
import com.baidu.tieba.R;
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
/* loaded from: classes7.dex */
public class VideoPlayFragment extends BaseFragment implements b.InterfaceC0665b, c.a.r0.a4.i.a.a, TbCyberVideoView.g {
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
    public VideoMiddleNiaiControllerView A;
    public final CustomMessageListener A0;
    public boolean B;
    public final CustomMessageListener B0;
    public AlphaAnimation C;
    public final CustomMessageListener C0;
    public Rect D;
    public final CustomMessageListener D0;
    public boolean E;
    public final CustomMessageListener E0;
    public View F;
    public final CustomMessageListener F0;
    public TextView G;
    public final CustomMessageListener G0;
    public RelativeLayout.LayoutParams H;
    @NonNull
    public final BarManageResultListener H0;
    public int I;
    public View.OnClickListener I0;
    public int J;
    public View.OnClickListener J0;
    public int K;
    public i.d K0;
    public int L;
    public i.d L0;
    public boolean M;
    public i.d M0;
    public int N;
    public i.d N0;
    public String O;
    public Runnable O0;
    public String P;
    public CyberPlayerManager.OnInfoListener P0;
    public String Q;
    public CyberPlayerManager.OnCompletionListener Q0;
    public PopupDialog R;
    public CyberPlayerManager.OnPreparedListener R0;
    public c.a.q0.s.s.i S;
    public CustomMessageListener S0;
    public ForumManageModel T;
    public c.a.q0.i.a U;
    public c.a.q0.t.e.a V;
    public BdUniqueId W;
    public String X;
    public boolean Y;
    public RelativeLayout.LayoutParams Z;
    public RelativeLayout.LayoutParams a0;
    public LinearLayout agree_container;
    public EMTextView agree_num;
    public HeadImageView author_portrait;
    public TbCyberVideoView.VideoStatus b0;
    public String c0;
    public Animation clickAnimation;
    public LinearLayout comment_container;
    public EMTextView comment_num;
    public EMTextView dragCurTime;
    public EMTextView dragTotalTime;

    /* renamed from: e  reason: collision with root package name */
    public int f57873e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57874f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f57875g;

    /* renamed from: h  reason: collision with root package name */
    public int f57876h;
    public EMTextView has_love;

    /* renamed from: i  reason: collision with root package name */
    public int f57877i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public RelativeLayout f57878j;
    public boolean j0;
    public TbImageView k;
    public TBLottieAnimationView k0;
    public View l;
    public boolean l0;
    public boolean m;
    public int m0;
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
    public LinearLayout n;
    public int n0;
    public BarImageView o;
    public c.a.r0.a4.h.a o0;
    public ImageView p;
    public c.a.r0.a4.e.a p0;
    public ImageView play_btn;
    public TextView q;
    public f.c q0;
    public TextView r;
    public f1 r0;
    public View s;
    public c.a.r0.a4.j.a s0;
    public LinearLayout share_container;
    public ImageView share_icon;
    public ImageView share_icon_changed;
    public EMTextView share_num;
    public View t;
    public c.a.r0.a4.a t0;
    public TBSpecificationBtn u;
    public AlertDialog u0;
    public TextView v;
    public boolean v0;
    public ImageView videoLoadingIcon;
    public RelativeLayout videoLoadingLayout;
    public LinearLayout video_activity_container;
    public LinearLayout video_private;
    public ExpandableTextView video_title;
    public View w;
    public final Runnable w0;
    public LinearLayout x;
    public final TbVideoViewSet.b x0;
    public VideoItemModel y;
    public final CustomMessageListener y0;
    public TextView z;
    public final CustomMessageListener z0;

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57879a;

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
            this.f57879a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f57879a.j0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.f57879a.f57875g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.f57879a.j0) {
                this.f57879a.j0 = false;
                this.f57879a.s0.a0(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57880a;

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
            this.f57880a = videoPlayFragment;
        }

        @Override // c.a.r0.a4.e.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f57880a.F.setVisibility(8);
                if (z) {
                    this.f57880a.G.setText(R.string.reply_something);
                } else {
                    this.f57880a.G.setText(StringUtils.isNull(((c.a.r0.a4.e.c) this.f57880a.p0.a().findToolById(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                }
                VideoItemData videoItemData = this.f57880a.mVideoData;
                if (videoItemData == null || !z) {
                    return;
                }
                long g2 = c.a.e.e.m.b.g(videoItemData.comment_num, 0L) + 1;
                this.f57880a.mVideoData.comment_num = String.valueOf(g2);
                this.f57880a.comment_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(g2));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57881a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318573992, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$a1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318573992, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$a1;");
                    return;
                }
            }
            int[] iArr = new int[BarManageResultListener.OptType.values().length];
            f57881a = iArr;
            try {
                iArr[BarManageResultListener.OptType.MAKE_TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57881a[BarManageResultListener.OptType.CANCEL_TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f57881a[BarManageResultListener.OptType.ADD_GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f57881a[BarManageResultListener.OptType.CANCEL_GOOD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57882a;

        /* loaded from: classes7.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f57883e;

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
                this.f57883e = bVar;
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
                    if (this.f57883e.f57882a.H != null) {
                        this.f57883e.f57882a.H.removeRule(14);
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
            this.f57882a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921612 || this.f57882a.getPageContext() == null) {
                return;
            }
            Configuration configuration = this.f57882a.getPageContext().getPageActivity().getResources().getConfiguration();
            if ((configuration == null || configuration.orientation != 2) && this.f57882a.isResumed() && this.f57882a.B) {
                if (this.f57882a.f57873e == 1 && this.f57882a.D != null) {
                    VideoPlayFragment videoPlayFragment = this.f57882a;
                    videoPlayFragment.j1(videoPlayFragment.mVideoView, videoPlayFragment.k, this.f57882a.H.leftMargin, this.f57882a.K, this.f57882a.H.topMargin, this.f57882a.L, this.f57882a.H.width, this.f57882a.I, this.f57882a.H.height, this.f57882a.J, new a(this));
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921611));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57884e;

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
            this.f57884e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f57884e).mVideoData) == null || videoItemData.thread_id == null) {
                return;
            }
            c.a.q0.t.c.j0.b(videoPlayFragment.getPageContext(), this.f57884e.mVideoData.thread_id);
            int i2 = 7;
            if (this.f57884e.f57873e == 1 || this.f57884e.f57873e == 2) {
                i2 = 6;
            } else if (this.f57884e.f57873e != 3) {
                int unused = this.f57884e.f57873e;
            }
            c.a.q0.t.c.j0.a(i2);
        }
    }

    /* loaded from: classes7.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57885a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f57885a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.k3.i0.e)) {
                AgreeData agreeData = ((c.a.r0.k3.i0.e) customResponsedMessage.getData()).f21031b;
                if (this.f57885a.mVideoData == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.f57885a.mVideoData.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f57885a.mVideoData.agree_num = String.valueOf(agreeData.agreeNum);
                    this.f57885a.mVideoData.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.f57885a.w0();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f57885a.mVideoData.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f57885a.mVideoData.agree_num = String.valueOf(agreeData.agreeNum);
                this.f57885a.mVideoData.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.f57885a.w0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements SimpleMessageListener.b<BarManageResultListener.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57886a;

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
            this.f57886a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.util.SimpleMessageListener.b
        /* renamed from: a */
        public void call(@Nullable BarManageResultListener.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            d2 d2Var = this.f57886a.mVideoData.threadData;
            if (d2Var != null && aVar.d()) {
                int i2 = a1.f57881a[aVar.c().ordinal()];
                if (i2 == 1) {
                    d2Var.d4(true);
                } else if (i2 == 2) {
                    d2Var.d4(false);
                } else if (i2 == 3) {
                    d2Var.r3(true);
                } else if (i2 == 4) {
                    d2Var.r3(false);
                }
            }
            this.f57886a.showToast(aVar.b());
        }
    }

    /* loaded from: classes7.dex */
    public class c0 extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57887a;

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
            this.f57887a = videoPlayFragment;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.f57887a.T.getLoadDataMode() == 0) {
                if (this.f57887a.M0()) {
                    if ((obj instanceof ForumManageModel.b) && this.f57887a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.sendMessage(this.f57887a.getPageContext(), Pair.create(Boolean.valueOf(bVar.f57176a), bVar.f57177b));
                    }
                } else {
                    VideoItemData videoItemData = this.f57887a.mVideoData;
                    if (videoItemData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, videoItemData.getThreadId()));
                    }
                }
                this.f57887a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57888a;

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
            this.f57888a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            int i2;
            int mainTabBottomBarHeight;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.f57888a.j0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.f57888a.f57875g.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.f57888a.mVideoData == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f2 = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds562);
            int i3 = c.a.e.e.p.l.i(this.f57888a.mRootView.getContext());
            int e2 = c.a.e.e.m.b.e(this.f57888a.mVideoData.video_height, 0);
            int e3 = c.a.e.e.m.b.e(this.f57888a.mVideoData.video_width, 0);
            if (e2 != 0 && e3 != 0) {
                f2 = (e2 * 1.0f) / e3;
            }
            int k = c.a.e.e.p.l.k(this.f57888a.mRootView.getContext());
            float f3 = k * f2;
            if (f2 > 1.0f) {
                float f4 = dimenPixelSize;
                i2 = (int) (((i3 - dimenPixelSize) * floatValue) + f4);
                float f5 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) (UtilHelper.getStatusBarHeight() * f5);
                this.f57888a.a0.topMargin = (int) (((i3 - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) * 0.5f * floatValue) + (f5 * f4 * 0.5f));
                k = (int) (i2 / f2);
            } else {
                float f6 = dimenPixelSize;
                i2 = (int) (((f3 - f6) * floatValue) + f6);
                float f7 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) ((((i3 - f3) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f7));
                this.f57888a.a0.topMargin = (int) ((((i3 - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (f7 * f6 * 0.5f));
            }
            this.f57888a.H.height = i2;
            this.f57888a.H.width = k;
            this.f57888a.H.topMargin = mainTabBottomBarHeight;
            this.f57888a.play_btn.requestLayout();
            this.f57888a.mVideoView.requestLayout();
        }
    }

    /* loaded from: classes7.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57889e;

        public d(VideoPlayFragment videoPlayFragment) {
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
            this.f57889e = videoPlayFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f57889e.onViewDoubleClick(0.0f, 0.0f);
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
                    this.f57889e.onViewDragToRight();
                    this.f57889e.mRootView.cancelLongPress();
                    return true;
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f57889e.U0();
                    this.f57889e.mRootView.cancelLongPress();
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
                this.f57889e.onViewClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d0 implements a.InterfaceC0669a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57890a;

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
            this.f57890a = videoPlayFragment;
        }

        @Override // c.a.q0.i.a.InterfaceC0669a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f57890a.U != null) {
                        this.f57890a.U.h(z2);
                    }
                    VideoItemData videoItemData = this.f57890a.mVideoData;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.f57890a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.f57890a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.f57890a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57891a;

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
            this.f57891a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (this.f57891a.j0) {
                    if (bool.booleanValue() || !this.f57891a.T0()) {
                        this.f57891a.startPlay();
                        this.f57891a.V0();
                        return;
                    }
                    this.f57891a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f57892e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57893f;

        public e(VideoPlayFragment videoPlayFragment, GestureDetectorCompat gestureDetectorCompat) {
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
            this.f57893f = videoPlayFragment;
            this.f57892e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f57892e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57894e;

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
            this.f57894e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57894e.mLiveLottieView.playAnimation();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57895a;

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
            this.f57895a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f57895a.j0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.f57895a.f57875g.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f57895a.T0()) {
                        this.f57895a.startPlay();
                        return;
                    }
                    return;
                }
                this.f57895a.k1();
                this.f57895a.V0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57896e;

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
            this.f57896e = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f57896e.f1();
                this.f57896e.mRootView.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f0 implements i.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57897a;

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
            this.f57897a = videoPlayFragment;
        }

        @Override // c.a.q0.s.s.i.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57897a.hideDraftDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface f1 {
        void a();

        void onStart();
    }

    /* loaded from: classes7.dex */
    public class g implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57898e;

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
            this.f57898e = videoPlayFragment;
        }

        @Override // c.a.r0.q2.f.c
        public void onProgressUpdated(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f57898e.q0 == null) {
                return;
            }
            this.f57898e.q0.onProgressUpdated(i2, i3);
        }
    }

    /* loaded from: classes7.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57899a;

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
            this.f57899a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.f57899a.isResumed() && this.f57899a.B) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                VideoPlayFragment videoPlayFragment = this.f57899a;
                videoPlayFragment.showBlockDialog(videoPlayFragment.M, booleanValue);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57900a;

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
            this.f57900a = videoPlayFragment;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f57900a.videoLoadingLayout.setVisibility(8);
                this.f57900a.mVideoView.setCanShowPause(true);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h0 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57901e;

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
            this.f57901e = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f57901e.R = null;
                this.f57901e.S = null;
                if (TbSingleton.getInstance().isNotchScreen(this.f57901e.getActivity())) {
                    return;
                }
                TbSingleton.getInstance().isCutoutScreen(this.f57901e.getActivity());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57902e;

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
            this.f57902e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f57902e;
                if (videoPlayFragment.B0(videoPlayFragment.getPageContext(), CyberPlayerManager.MEDIA_INFO_DISABLE_FILECACHE)) {
                    this.f57902e.F.setVisibility(8);
                    if (this.f57902e.p0 != null && this.f57902e.p0.a() != null) {
                        this.f57902e.p0.a().display();
                        VideoPlayFragment videoPlayFragment2 = this.f57902e;
                        if (videoPlayFragment2.mVideoData != null) {
                            videoPlayFragment2.p0.w(this.f57902e.mVideoData);
                        }
                    }
                    if (this.f57902e.mVideoData != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.f57902e.mVideoData.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.f57902e.mVideoData.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57903e;

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
            this.f57903e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57903e.i1(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57904e;

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
            this.f57904e = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f57904e.E0(true);
                EMTextView eMTextView = this.f57904e.dragCurTime;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = this.f57904e.dragTotalTime;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.f57904e.mVideoView.getDuration()));
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
                statisticItem.param("tid", this.f57904e.mVideoData.thread_id);
                statisticItem.param("fid", this.f57904e.mVideoData.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.f57904e.f57873e != 3 && this.f57904e.f57873e != 4) {
                    statisticItem.param("obj_type", 2);
                } else {
                    statisticItem.param("obj_type", 1);
                }
                statisticItem.param("obj_type", this.f57904e.H0());
                if (this.f57904e.f57873e != 3) {
                    if (this.f57904e.f57873e == 4) {
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
                this.f57904e.i0 = true;
                if (this.f57904e.A != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.f57904e.A;
                    if (this.f57904e.f57873e != 4 && this.f57904e.f57873e != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
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
                this.f57904e.i0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(null);
                    this.f57904e.E0(false);
                    if (!this.f57904e.mVideoView.isPlaying()) {
                        this.f57904e.mVideoView.start();
                        this.f57904e.play_btn.setVisibility(8);
                    }
                    if (!this.f57904e.j0 && (!this.f57904e.isResumed() || !this.f57904e.B)) {
                        this.f57904e.V0();
                    }
                    c.a.e.e.m.e.a().postDelayed(this.f57904e.O0, 3000L);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57905a;

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
            this.f57905a = videoPlayFragment;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f57905a.R != null) {
                    this.f57905a.R.dismiss();
                }
                this.f57905a.i1(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57906e;

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
            this.f57906e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoPlayFragment videoPlayFragment;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = (videoPlayFragment = this.f57906e).mVideoView) == null || videoPlayFragment.mVideoData == null) {
                return;
            }
            tbCyberVideoView.setVideoPath(videoPlayFragment.X, this.f57906e.mVideoData.thread_id);
            this.f57906e.mVideoView.prepareByPause();
        }
    }

    /* loaded from: classes7.dex */
    public class k0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57907a;

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
            this.f57907a = videoPlayFragment;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f57907a.getContext())) {
                    if (this.f57907a.R != null) {
                        this.f57907a.R.dismiss();
                        return;
                    }
                    return;
                }
                if (this.f57907a.R != null) {
                    this.f57907a.R.dismiss();
                }
                VideoItemData videoItemData = this.f57907a.mVideoData;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.f57907a.mVideoData.thread_id);
                markData.setPostId(this.f57907a.mVideoData.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.f57907a.mVideoData.thread_id);
                markData.setForumId(this.f57907a.mVideoData.forum_id);
                if (this.f57907a.U != null) {
                    this.f57907a.U.i(markData);
                    if (!z) {
                        this.f57907a.U.a();
                    } else {
                        this.f57907a.U.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57909f;

        public l(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f57909f = videoPlayFragment;
            this.f57908e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f57908e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) c.a.e.a.j.a(this.f57909f.getPageContext().getPageActivity()), new String[]{this.f57908e}, true);
        }
    }

    /* loaded from: classes7.dex */
    public class l0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57910a;

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
            this.f57910a = videoPlayFragment;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57910a.R.dismiss();
                if (!ViewHelper.checkUpIsLogin(this.f57910a.getActivity()) || this.f57910a.getPageContext() == null || (videoItemData = this.f57910a.mVideoData) == null) {
                    return;
                }
                String str = videoItemData.thread_id;
                String str2 = videoItemData.forum_id;
                String string = TbadkCoreApplication.getInst().getResources().getString(R.string.web_view_report_title);
                String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + this.f57910a.mVideoData.post_id;
                VideoItemData videoItemData2 = this.f57910a.mVideoData;
                if (videoItemData2.isBjhVideo) {
                    str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                    string = "";
                }
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f57910a.getPageContext().getPageActivity(), string, str3, true);
                if (this.f57910a.mVideoData.isBjhVideo) {
                    tbWebViewActivityConfig.setFixTitle(true);
                }
                this.f57910a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57911e;

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
            this.f57911e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.portrait_container && (videoItemData = this.f57911e.mVideoData) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.f57911e;
                    if (videoPlayFragment.mVideoData.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.f57911e.mVideoData.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.f57911e.mVideoData.getThreadId());
                        UserItemData userItemData2 = this.f57911e.mVideoData.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.f57911e.mVideoData.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.f57911e.mVideoData;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null || StringUtils.isNull(userItemData.user_id)) {
                    return;
                }
                long g2 = c.a.e.e.m.b.g(this.f57911e.mVideoData.author_info.user_id, 0L);
                long g3 = c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f57911e.getActivity()).createNormalConfig(g2, (g2 == 0 && g3 == 0) ? false : g2 == g3, false, true, (this.f57911e.f57873e == 3 || this.f57911e.f57873e == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE)));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.f57911e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.f57911e.getClickItem(5);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m0 implements i.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57912a;

        /* loaded from: classes7.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.s.s.a f57913e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ m0 f57914f;

            public a(m0 m0Var, c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57914f = m0Var;
                this.f57913e = aVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f57913e.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f57914f.f57912a;
                    if (videoPlayFragment.mVideoData != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.T;
                        VideoPlayFragment videoPlayFragment2 = this.f57914f.f57912a;
                        VideoItemData videoItemData = videoPlayFragment2.mVideoData;
                        forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.M, null, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.q0.s.s.a f57915e;

            public b(m0 m0Var, c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57915e = aVar;
            }

            @Override // c.a.q0.s.s.a.e
            public void onClick(c.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f57915e.dismiss();
                }
            }
        }

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
            this.f57912a = videoPlayFragment;
        }

        @Override // c.a.q0.s.s.i.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f57912a.R.dismiss();
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.f57912a.getActivity());
                VideoItemData videoItemData = this.f57912a.mVideoData;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(R.string.del_thread_confirm);
                }
                aVar.setPositiveButton(R.string.dialog_ok, new a(this, aVar));
                aVar.setNegativeButton(R.string.dialog_cancel, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.f57912a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57916e;

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
            this.f57916e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f57916e).mVideoData) == null || videoItemData.act_info == null) {
                return;
            }
            c.a.q0.m.a.k(videoPlayFragment.getActivity(), this.f57916e.mVideoData.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.f57916e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes7.dex */
    public class n0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57917a;

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
            this.f57917a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f57917a.mVideoData.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57918e;

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
            this.f57918e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57918e.I0();
                this.f57918e.getClickItem(7);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57919e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57920f;

        public o0(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f57920f = videoPlayFragment;
            this.f57919e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f57920f.getContext()).createNormalCfg(this.f57919e, "")));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57921e;

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
            this.f57921e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57921e.f57878j.removeView(this.f57921e.mVideoView);
                this.f57921e.s0.X();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57922a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f57922a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = this.f57922a.mVideoData;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.f57922a.mVideoData.author_info.user_id.equals(data.f48113c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.f57922a.W)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.f48111a) {
                    if (!z || "0".equals(this.f57922a.mVideoData.author_info.is_follow)) {
                        return;
                    }
                    c.a.e.e.p.l.L(this.f57922a.getActivity(), R.string.attention_fail);
                    VideoPlayFragment videoPlayFragment = this.f57922a;
                    videoPlayFragment.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment.x0();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.f57922a;
                    videoPlayFragment2.mVideoData.author_info.is_follow = "0";
                    videoPlayFragment2.x0();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.f57922a.mVideoData));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.f57922a;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.x0();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.f57922a.P)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57923e;

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
            this.f57923e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.f57923e.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.f57923e.mVideoData.thread_id));
                }
                this.f57923e.getActivity().finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57924e;

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
            this.f57924e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f57924e.i0) {
                return;
            }
            this.f57924e.y0(true);
        }
    }

    /* loaded from: classes7.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57925e;

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
            this.f57925e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57925e.f1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57926e;

        public r0(VideoPlayFragment videoPlayFragment) {
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
            this.f57926e = videoPlayFragment;
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
                VideoPlayFragment videoPlayFragment = this.f57926e;
                View view = videoPlayFragment.mRootView;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).removeView(videoPlayFragment.k0);
                }
                this.f57926e.Y = false;
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

    /* loaded from: classes7.dex */
    public class s implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57927e;

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
            this.f57927e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.f57927e.getPageContext(), this.f57927e.mVideoData)) {
                return;
            }
            this.f57927e.I0();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.f57927e.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.f57927e.getClickItem(2);
        }
    }

    /* loaded from: classes7.dex */
    public class s0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f57928e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57929f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f57930g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f57931h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ int f57932i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ int f57933j;
        public final /* synthetic */ int k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ View n;
        public final /* synthetic */ View o;
        public final /* synthetic */ VideoPlayFragment p;

        public s0(VideoPlayFragment videoPlayFragment, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, View view, View view2) {
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
            this.f57928e = i2;
            this.f57929f = i3;
            this.f57930g = i4;
            this.f57931h = i5;
            this.f57932i = i6;
            this.f57933j = i7;
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
                int i2 = (int) (this.f57928e * animatedFraction);
                int i3 = this.f57929f;
                this.p.H.topMargin = i3 > this.f57930g ? i3 - i2 : i3 + i2;
                int i4 = (int) (this.f57931h * animatedFraction);
                int i5 = this.f57932i;
                int i6 = i5 > this.f57933j ? i5 - i4 : i5 + i4;
                this.p.H.leftMargin = i6;
                this.p.H.rightMargin = i6;
                float f2 = animatedFraction * this.k;
                int i7 = this.l;
                float f3 = i7 > this.m ? i7 - f2 : i7 + f2;
                this.p.H.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.p.H.height = (int) f3;
                this.n.setLayoutParams(this.p.H);
                this.o.setLayoutParams(this.p.H);
                this.n.requestLayout();
                this.o.requestLayout();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57934e;

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
            this.f57934e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f57934e;
                videoPlayFragment.D0(videoPlayFragment.f57876h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t0 implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57935e;

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
            this.f57935e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f57935e.B && ((i2 == 3 || i2 == 904) && this.f57935e.k.getVisibility() == 0)) {
                    this.f57935e.k.clearAnimation();
                    this.f57935e.k.startAnimation(this.f57935e.C);
                }
                if (i2 != 10012 || this.f57935e.o0 == null) {
                    return true;
                }
                this.f57935e.o0.prefetch();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57936e;

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
            this.f57936e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57936e.h1();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.f57936e.mVideoData.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f57936e.getClickItem(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.f57936e.mVideoData.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.f57936e.mVideoData.nid);
                BaijiahaoData baijiahaoData = this.f57936e.mVideoData.baijiahaoData;
                if (baijiahaoData != null && !c.a.e.e.p.k.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.f57936e.mVideoData.baijiahaoData.oriUgcVid);
                }
                if (this.f57936e.mVideoData.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.f57936e.mVideoData.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.f57936e.mVideoData.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.f57936e.mVideoData.mRecomSource);
                statisticItem2.param("ab_tag", this.f57936e.mVideoData.mRecomAbTag);
                statisticItem2.param("weight", this.f57936e.mVideoData.mRecomWeight);
                statisticItem2.param("extra", this.f57936e.mVideoData.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (c.a.q0.n0.c.j(this.f57936e.getBaseFragmentActivity()) != null && c.a.q0.n0.c.j(this.f57936e.getBaseFragmentActivity()).b() != null && c.a.q0.n0.c.j(this.f57936e.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(c.a.q0.n0.c.j(this.f57936e.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u0 implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57937e;

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
            this.f57937e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f57937e.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.monitorAndStatsAtVerticalVideoReplay();
            this.f57937e.mVideoView.seekTo(0);
            if (c.a.q0.b.d.e()) {
                if (this.f57937e.r0 != null && !this.f57937e.j0) {
                    this.f57937e.r0.a();
                    this.f57937e.k.setVisibility(8);
                    this.f57937e.mVideoView.start();
                } else {
                    this.f57937e.mVideoView.start();
                }
            } else {
                this.f57937e.mVideoView.start();
            }
            this.f57937e.X0();
            VideoPlayFragment.q0(this.f57937e);
            if (this.f57937e.m0 == 3) {
                this.f57937e.z0();
            }
            if (this.f57937e.j0) {
                return;
            }
            if (this.f57937e.isResumed() && this.f57937e.B) {
                return;
            }
            this.f57937e.V0();
        }
    }

    /* loaded from: classes7.dex */
    public class v implements TbVideoViewSet.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57938a;

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
            this.f57938a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            VideoPlayFragment videoPlayFragment;
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = (videoPlayFragment = this.f57938a).mVideoView) == null || videoPlayFragment.mVideoData == null) {
                return;
            }
            tbCyberVideoView.setVideoPath(videoPlayFragment.X, this.f57938a.mVideoData.thread_id);
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            TbCyberVideoView tbCyberVideoView;
            TbCyberVideoView tbCyberVideoView2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (tbCyberVideoView = this.f57938a.mVideoView) == null) {
                return;
            }
            tbCyberVideoView.clearCallbackAndRemoveFromWindow();
            this.f57938a.mVideoView.setStageType("2005");
            this.f57938a.mVideoView.setLocateSource("v_mid_page");
            this.f57938a.mVideoView.setContinuePlayEnable(true);
            if (this.f57938a.H != null) {
                this.f57938a.k.setLayoutParams(this.f57938a.H);
                if (this.f57938a.f57878j != null && (tbCyberVideoView2 = this.f57938a.mVideoView) != null && tbCyberVideoView2.getView() != null) {
                    this.f57938a.f57878j.addView(this.f57938a.mVideoView.getView(), 0, this.f57938a.H);
                }
            } else {
                this.f57938a.setVideoBussinessAndAddView();
            }
            this.f57938a.c1();
        }
    }

    /* loaded from: classes7.dex */
    public class v0 implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57939e;

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
            this.f57939e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                VideoPlayFragment videoPlayFragment = this.f57939e;
                if (videoPlayFragment.mVideoView != null) {
                    if (videoPlayFragment.A != null) {
                        this.f57939e.A.setVisibility(0);
                        if (this.f57939e.A.getCurProgress() == 0) {
                            this.f57939e.A.showProgress();
                            return;
                        }
                        return;
                    }
                    this.f57939e.A.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57940e;

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
            this.f57940e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f57940e.getActivity())) {
                if (this.f57940e.u != null && (videoItemData = (videoPlayFragment = this.f57940e).mVideoData) != null && videoItemData.author_info != null && videoPlayFragment.has_love != null) {
                    c.a.q0.t.e.a aVar = videoPlayFragment.V;
                    VideoPlayFragment videoPlayFragment2 = this.f57940e;
                    UserItemData userItemData = videoPlayFragment2.mVideoData.author_info;
                    aVar.m(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.W, this.f57940e.mVideoData.forum_id, "0");
                    VideoPlayFragment videoPlayFragment3 = this.f57940e;
                    videoPlayFragment3.mVideoData.author_info.is_follow = "1";
                    videoPlayFragment3.x0();
                    this.f57940e.u.setVisibility(8);
                    this.f57940e.has_love.setVisibility(0);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setStartOffset(1000L);
                    scaleAnimation.setDuration(300L);
                    scaleAnimation.setFillAfter(true);
                    this.f57940e.has_love.startAnimation(scaleAnimation);
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.f57940e.f57873e != 3 && this.f57940e.f57873e != 4) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_source", this.f57940e.H0());
                } else {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.f57940e.mVideoData.thread_id);
                statisticItem.param("fid", this.f57940e.mVideoData.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f57940e.getClickItem(6);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f57941e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f57942f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57943g;

        public w0(VideoPlayFragment videoPlayFragment, boolean z, boolean z2) {
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
            this.f57943g = videoPlayFragment;
            this.f57941e = z;
            this.f57942f = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f57943g.u0 != null) {
                    this.f57943g.u0.dismiss();
                }
                if (c.a.e.e.p.j.A()) {
                    ForumManageModel forumManageModel = this.f57943g.T;
                    VideoItemData videoItemData = this.f57943g.mVideoData;
                    forumManageModel.S(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.f57941e, null, this.f57942f);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    return;
                }
                c.a.e.e.p.l.L(this.f57943g.getContext(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class x implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57944a;

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
            this.f57944a = videoPlayFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f57944a.k == null) {
                return;
            }
            this.f57944a.k.setVisibility(8);
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

    /* loaded from: classes7.dex */
    public class x0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57945e;

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
            this.f57945e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f57945e.u0 == null) {
                return;
            }
            this.f57945e.u0.dismiss();
        }
    }

    /* loaded from: classes7.dex */
    public class y implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57946e;

        /* loaded from: classes7.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ y f57947e;

            public a(y yVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {yVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f57947e = yVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.f57947e.f57946e.E = true;
                    if (this.f57947e.f57946e.H != null) {
                        this.f57947e.f57946e.H.addRule(14);
                    }
                }
            }
        }

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
            this.f57946e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams G0 = this.f57946e.G0();
                VideoPlayFragment videoPlayFragment = this.f57946e;
                videoPlayFragment.j1(videoPlayFragment.mVideoView, videoPlayFragment.k, this.f57946e.K, G0.leftMargin, this.f57946e.L, G0.topMargin, this.f57946e.I, G0.width, this.f57946e.J, G0.height, new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57948a;

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
            this.f57948a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d2 d2Var;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.r0.k3.i0.l)) {
                c.a.r0.k3.i0.l lVar = (c.a.r0.k3.i0.l) customResponsedMessage.getData();
                VideoItemData videoItemData = this.f57948a.mVideoData;
                if (videoItemData == null || (d2Var = videoItemData.threadData) == null || (str = d2Var.E) == null || !str.equals(lVar.f21046a)) {
                    return;
                }
                this.f57948a.mVideoData.threadData.S3(lVar.f21047b ? 1 : 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57949a;

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
            this.f57949a = videoPlayFragment;
        }

        @Override // c.a.r0.a4.j.a.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f57949a.startPlay();
                } else if (this.f57949a.s0 != null) {
                    this.f57949a.s0.startPlay();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f57950a;

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
            this.f57950a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.f57950a.isResumed() && this.f57950a.B) {
                if (c.a.e.e.p.j.z()) {
                    if (this.f57950a.g1()) {
                        return;
                    }
                    this.f57950a.startPlay();
                    return;
                }
                c.a.e.e.p.l.L(TbadkCoreApplication.getInst(), R.string.neterror);
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
        this.f57876h = 0;
        this.f57877i = 1;
        this.m = false;
        this.E = false;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = BdUniqueId.gen();
        this.Y = false;
        this.b0 = TbCyberVideoView.VideoStatus.INIT;
        this.l0 = false;
        this.m0 = 1;
        this.n0 = -1;
        this.w0 = new k(this);
        this.x0 = new v(this);
        this.y0 = new g0(this, 2921607);
        this.z0 = new p0(this, 2001115);
        this.A0 = new z0(this, 2000994);
        this.B0 = new b1(this, 2016528);
        this.C0 = new c1(this, 2921594);
        this.D0 = new d1(this, 2001011);
        this.E0 = new e1(this, 2921596);
        this.F0 = new a(this, 2921598);
        this.G0 = new b(this, 2921612);
        this.H0 = new BarManageResultListener(new c(this));
        this.I0 = new b0(this);
        this.J0 = new i0(this);
        this.K0 = new j0(this);
        this.L0 = new k0(this);
        this.M0 = new l0(this);
        this.N0 = new m0(this);
        this.O0 = new q0(this);
        this.P0 = new t0(this);
        this.Q0 = new u0(this);
        this.R0 = new v0(this);
        this.S0 = new y0(this, 2921603);
    }

    public static /* synthetic */ int q0(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.m0;
        videoPlayFragment.m0 = i2 + 1;
        return i2;
    }

    public final void A0() {
        VideoItemData videoItemData;
        String Z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        this.k.startLoad(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.mVideoData.getTitle();
        boolean z2 = c.a.e.e.m.b.e(this.mVideoData.video_height, 0) <= c.a.e.e.m.b.e(this.mVideoData.video_width, 0);
        if (TextUtils.isEmpty(title) && (!z2 || this.mVideoData.video_duration < 60)) {
            this.t.setVisibility(8);
        } else {
            if (z2 && this.mVideoData.video_duration >= 60) {
                this.s.setVisibility(0);
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
                c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.r);
                d2.z(R.dimen.T_X09);
                d2.v(R.color.CAM_X0621);
                this.r.setText(sb.toString());
            } else {
                this.s.setVisibility(8);
            }
            this.t.setVisibility(0);
            this.video_title.setTextSize(c.a.e.e.p.l.g(getContext(), R.dimen.T_X07));
            this.video_title.setTextColor(R.color.CAM_X0621);
            this.video_title.setLineSpacingExtra(c.a.e.e.p.l.g(getContext(), R.dimen.tbds10));
            this.video_title.setExpandable(false);
            this.video_title.setTextMaxLine(3);
            this.video_title.setLimitLine(3);
            this.video_title.setOnStatusChangedListener(new n0(this));
            ExpandableTextView expandableTextView = this.video_title;
            VideoItemData videoItemData2 = this.mVideoData;
            expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        this.comment_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(c.a.e.e.m.b.g(this.mVideoData.comment_num, 0L)));
        this.agree_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(c.a.e.e.m.b.g(this.mVideoData.agree_num, 0L)));
        if (R0()) {
            this.share_num.setText(R.string.more);
        } else {
            this.share_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(c.a.e.e.m.b.g(this.mVideoData.share_num, 0L)));
        }
        UserItemData userItemData = this.mVideoData.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.mVideoData.author_info.portrait.startsWith("http")) {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 10, false);
            } else {
                this.author_portrait.startLoad(this.mVideoData.author_info.portrait, 12, false);
            }
            if (S0() && !TextUtils.isEmpty(this.mVideoData.author_info.auth)) {
                this.author_portrait.setShowV(true);
                this.author_portrait.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
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
            if (!StringUtils.isNull(this.mVideoData.forum_name) && this.f57873e != 7 && c.a.q0.b.d.g0()) {
                this.mBarName.setVisibility(0);
                TextView textView = this.mBarName;
                textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.mVideoData.forum_name + TbadkCoreApplication.getInst().getString(R.string.bar_default_name), 16, "..."));
            } else {
                this.mBarName.setVisibility(8);
            }
        }
        AlaInfoData alaInfoData = this.mVideoData.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            K0(this.mVideoData.mAlaInfoData.live_status == 1);
            J0();
        }
        if ("1".equals(this.mVideoData.is_private) && this.z.getVisibility() != 0) {
            this.video_private.setVisibility(0);
        } else {
            this.video_private.setVisibility(8);
        }
        if ("1".equals(this.mVideoData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.mVideoData.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.z.getVisibility() != 0) {
            this.video_activity_container.setVisibility(8);
            this.v.setText(this.mVideoData.act_info.activity_name);
        } else {
            this.video_activity_container.setVisibility(8);
        }
        x0();
        if (this.f57873e == 7) {
            this.n.setVisibility(8);
        } else if (c.a.q0.b.d.d0()) {
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
            WebPManager.setPureDrawable(this.p, R.drawable.icon_pure_ba32, R.color.CAM_X0101, null);
            this.p.setVisibility(0);
            this.o.setVisibility(8);
            String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(Z + TbadkCoreApplication.getInst().getString(R.string.bar_default_name), 12, "...吧");
            this.O = cutChineseAndEnglishWithEmoji;
            this.q.setText(cutChineseAndEnglishWithEmoji);
            d2 d2Var2 = this.mVideoData.threadData;
            if (d2Var2 != null && !TextUtils.isEmpty(d2Var2.getRecomReason())) {
                TextView textView2 = this.q;
                textView2.setText(this.O + getActivity().getResources().getString(R.string.video_recommend));
            }
            this.n.setOnClickListener(new o0(this, Z));
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

    public final boolean B0(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.mRootView == null || this.Y) {
            return;
        }
        this.Y = true;
        this.k0 = new TBLottieAnimationView(this.mRootView.getContext());
        if (this.Z == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
            this.Z = layoutParams;
            layoutParams.addRule(13);
        }
        SkinManager.setLottieAnimation(this.k0, R.raw.lottie_agree_big_photo);
        View view = this.mRootView;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(this.k0, this.Z);
        }
        this.k0.addAnimatorListener(new r0(this));
        this.k0.playAnimation();
    }

    public final void D0(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.mVideoData) != null) {
            int i3 = 0;
            if (i2 == this.f57876h) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.mVideoData;
                    videoItemData2.agree_num = String.valueOf(c.a.e.e.m.b.e(videoItemData2.agree_num, 0) - 1);
                    this.mVideoData.is_agreed = "0";
                    i3 = 1;
                } else {
                    VideoItemData videoItemData3 = this.mVideoData;
                    videoItemData3.agree_num = String.valueOf(c.a.e.e.m.b.e(videoItemData3.agree_num, 0) + 1);
                    this.mVideoData.is_agreed = "1";
                    C0();
                    getClickItem(1);
                }
            } else {
                videoItemData.agree_num = String.valueOf(c.a.e.e.m.b.e(videoItemData.agree_num, 0) + 1);
                this.mVideoData.is_agreed = "1";
                getClickItem(1);
            }
            StatisticItem statisticItem = new StatisticItem("c12795");
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f57876h) {
                statisticItem.param("obj_type", i3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c12003");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f57876h) {
                statisticItem2.param("obj_type", i3);
            } else {
                statisticItem2.param("obj_type", 2);
            }
            if ("index".equals(this.P)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            c.a.q0.m0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                if (i2 == this.f57876h) {
                    statisticItem3.param("obj_type", i3);
                } else {
                    statisticItem3.param("obj_type", 2);
                }
                int i4 = this.f57873e;
                if (i4 != 3 && i4 != 4) {
                    statisticItem3.param("obj_locate", 2);
                } else {
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("obj_source", H0());
                }
                statisticItem3.param("tid", this.mVideoData.thread_id);
                statisticItem3.param("fid", this.mVideoData.forum_id);
                int i5 = this.f57873e;
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
            A0();
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
            c.a.r0.k3.i0.e eVar = new c.a.r0.k3.i0.e();
            AgreeData agreeData = new AgreeData();
            String str = this.mVideoData.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.mVideoData.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.mVideoData.is_agreed);
            eVar.f21031b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.mVideoData));
        }
    }

    public final void E0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z2) == null) {
            if (z2) {
                this.agree_container.setVisibility(8);
                this.w.setVisibility(8);
                this.comment_container.setVisibility(8);
                this.share_container.setVisibility(8);
                this.mBottomContainer.setVisibility(8);
                this.mDragContainer.setVisibility(0);
                return;
            }
            this.agree_container.setVisibility(0);
            this.w.setVisibility(0);
            this.comment_container.setVisibility(0);
            this.share_container.setVisibility(0);
            this.mBottomContainer.setVisibility(0);
            this.mDragContainer.setVisibility(8);
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.mVideoData == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.mVideoData.thread_id);
        statisticItem.param("nid", this.mVideoData.nid);
        statisticItem.param("fid", this.mVideoData.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.N);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", c.a.e.e.p.k.isEmpty(this.mVideoData.mRecomWeight) ? "0" : this.mVideoData.mRecomWeight);
        statisticItem.param("extra", c.a.e.e.p.k.isEmpty(this.mVideoData.mRecomExtra) ? "0" : this.mVideoData.mRecomExtra);
        statisticItem.param("obj_id", this.c0);
        statisticItem.param("ab_tag", c.a.e.e.p.k.isEmpty(this.mVideoData.mRecomAbTag) ? "0" : this.mVideoData.mRecomAbTag);
        statisticItem.param("obj_source", c.a.e.e.p.k.isEmpty(this.mVideoData.mRecomSource) ? "0" : this.mVideoData.mRecomSource);
        statisticItem.param("obj_type", this.P);
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
        int i3 = this.f57873e;
        if (i3 == 3 || i3 == 4) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.mVideoData.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.P);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.Q);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final RelativeLayout.LayoutParams G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int screenHeight = UtilHelper.getScreenHeight(this.mRootView.getContext());
            int k2 = c.a.e.e.p.l.k(this.mRootView.getContext());
            if ("video_channel_tab".equals(this.P)) {
                screenHeight -= TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(k2, screenHeight);
            if (this.mVideoView == null) {
                return layoutParams;
            }
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null) {
                int e2 = c.a.e.e.m.b.e(videoItemData.video_height, 0);
                int e3 = c.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                if (e2 > 0 && e3 > 0 && screenHeight > 0 && k2 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(k2, screenHeight);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.a0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.a0.addRule(14);
                        this.a0.topMargin = (screenHeight - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) / 2;
                    } else {
                        float f3 = f2 * k2;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(k2, (int) f3);
                        layoutParams3.topMargin = ((int) (screenHeight - f3)) / 2;
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.a0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.a0.addRule(14);
                        this.a0.topMargin = (screenHeight - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) / 2;
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
    public final int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.P)) {
                return 0;
            }
            String str = this.P;
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

    public final void I0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.mVideoData == null) {
            return;
        }
        PbCommentFloatActivityConfig pbCommentFloatActivityConfig = new PbCommentFloatActivityConfig(getActivity());
        VideoItemData videoItemData = this.mVideoData;
        PbCommentFloatActivityConfig createNormalCfg = pbCommentFloatActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.mVideoData.forum_id));
        createNormalCfg.setForumName(this.mVideoData.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.mVideoData.baijiahaoData);
        int i2 = this.f57873e;
        createNormalCfg.setFromPageType((i2 == 3 || i2 == 4) ? 1 : 2);
        createNormalCfg.setFromVideoPageType(this.f57873e);
        createNormalCfg.setFromVideoPageUniqueId(this.f57875g);
        createNormalCfg.setForceInterceptStimeStat(true);
        if (this.mVideoData.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            if (this.mVideoData.threadData.J() != null) {
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2.author_info != null) {
                    videoItemData2.threadData.J().setIsLike("1".equals(this.mVideoData.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            c.a.r0.x0.l.c(this.mVideoData.threadData);
        }
        GoPbCommentFloatListener.sendMessage();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.j0 = true;
        k1();
        this.s0.a0(!this.j0);
        showPbCommentFloatNum();
    }

    public final void J0() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (tBLottieAnimationView = this.mLiveLottieView) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public final void K0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) {
            int g2 = c.a.e.e.p.l.g(getContext(), R.dimen.tbds26);
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
                            this.mLiveLottieView.post(new e0(this));
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

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c.a.r0.a4.e.a aVar = (c.a.r0.a4.e.a) new c.a.r0.a4.e.b().a(getActivity());
                this.p0 = aVar;
                if (aVar != null && this.mVideoData != null) {
                    aVar.s(getPageContext());
                    this.p0.t(this.mVideoData.thread_id, this.mVideoData.forum_id, this.mVideoData.forum_name);
                    this.p0.u(new a0(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.mRootView).addView(this.p0.a(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f57873e == 6 : invokeV.booleanValue;
    }

    public final boolean N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f57873e == 8 : invokeV.booleanValue;
    }

    public final boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i2 = this.f57873e;
            return i2 == 1 || i2 == 2 || TbSingleton.getInstance().isFromFeedVideoClick();
        }
        return invokeV.booleanValue;
    }

    public final boolean P0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            if (i2 == 1) {
                int i3 = this.f57873e;
                return i3 == 3 || i3 == 4;
            } else if (i2 == 2) {
                int i4 = this.f57873e;
                return i4 == 1 || i4 == 2;
            } else if (i2 == 3) {
                int i5 = this.f57873e;
                return i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public final boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? M0() && !this.f57874f : invokeV.booleanValue;
    }

    public final boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? Q0() && isHost() : invokeV.booleanValue;
    }

    public final boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (c.a.q0.b.d.e0() && P0(1)) {
                return true;
            }
            if (c.a.q0.b.d.b0() && P0(2)) {
                return true;
            }
            return c.a.q0.b.d.a0() && P0(3);
        }
        return invokeV.booleanValue;
    }

    public final boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            TbCyberVideoView.VideoStatus videoStatus = this.b0;
            return videoStatus == TbCyberVideoView.VideoStatus.INIT || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PREPARED || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public final void U0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void V0() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (tbCyberVideoView = this.mVideoView) == null) {
            return;
        }
        tbCyberVideoView.pauseWithoutMuteAudioFocus();
    }

    public final void W0(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && this.mVideoData != null && this.D == null) {
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

    public final void X0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.mVideoData == null) {
            return;
        }
        c.a.r0.q2.o oVar = new c.a.r0.q2.o();
        oVar.f23997a = "nani_midpage";
        VideoItemData videoItemData = this.mVideoData;
        oVar.f23999c = videoItemData.thread_id;
        oVar.t = videoItemData.nid;
        oVar.f24000d = this.mVideoData.forum_id + "";
        oVar.f24001e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.mVideoData;
        oVar.f24002f = videoItemData2.mRecomSource;
        oVar.f24003g = videoItemData2.mRecomAbTag;
        oVar.f24004h = videoItemData2.mRecomWeight;
        oVar.f24005i = "";
        oVar.k = "";
        oVar.m = videoItemData2.mMd5;
        if (this.D != null) {
            oVar.n = "1";
        } else {
            oVar.n = "2";
        }
        int i2 = this.f57873e;
        if (i2 == 1 || i2 == 2) {
            oVar.p = "1";
            oVar.f23997a = "auto_midpage";
            oVar.f24005i = "index";
        }
        c.a.r0.q2.h.e(this.mVideoData.mMd5, "", "1", oVar, this.mVideoView.getPcdnState());
        int i3 = this.f57873e;
        if (i3 == 1 || i3 == 3) {
            c.a.r0.a4.c.e.b(this.mVideoData.mMd5);
        } else if (i3 == 2 || i3 == 4) {
            c.a.r0.a4.c.e.a(this.mVideoData.mMd5);
        }
    }

    public final void Y0() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.share_icon_changed == null || (imageView = this.share_icon) == null) {
            return;
        }
        imageView.clearAnimation();
        this.share_icon_changed.clearAnimation();
        this.share_icon.setVisibility(0);
        this.share_icon_changed.setVisibility(8);
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || g1()) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.mVideoView;
        if (tbCyberVideoView != null && this.play_btn != null && this.mVideoData != null) {
            if (tbCyberVideoView.getParent() == null) {
                setVideoBussinessAndAddView();
                c1();
            }
            if (TbVideoViewSet.d().e(this.X) == null || TbVideoViewSet.d().e(this.X) != this.mVideoView) {
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.A;
                if (videoMiddleNiaiControllerView != null) {
                    videoMiddleNiaiControllerView.resetProgress();
                }
                this.mVideoView.setVideoPath(this.X, this.mVideoData.thread_id);
            }
            this.mVideoView.start(this.x0);
            this.A.showProgress();
            this.play_btn.setVisibility(8);
            e1();
        }
        if (isResumed() && this.B && T0()) {
            return;
        }
        V0();
        ImageView imageView = this.play_btn;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.has_love == null) {
            return;
        }
        Drawable drawable = getPageContext().getResources().getDrawable(R.drawable.icon_pure_followed);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds29), UtilHelper.getDimenPixelSize(R.dimen.tbds18));
        this.has_love.setCompoundDrawables(drawable, null, null, null);
    }

    public final void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.mPortraitContainer.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.author_portrait.getLayoutParams();
            if (!c.a.q0.b.d.g0()) {
                if (layoutParams != null) {
                    layoutParams.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                    layoutParams2.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                    layoutParams.height = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                    layoutParams2.height = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                }
            } else if (layoutParams == null || layoutParams2 == null) {
            } else {
                layoutParams.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                layoutParams2.width = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                layoutParams.height = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                layoutParams2.height = c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
            }
        }
    }

    public final void c1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.mVideoView.setVideoStatusChangeListener(this);
            this.mVideoView.setOnPreparedListener(this.R0);
            this.mVideoView.setOnCompletionListener(this.Q0);
            this.mVideoView.setOnInfoListener(this.P0);
        }
    }

    public final void d1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || this.mVideoView == null || str == null || str.equals(this.X)) {
            return;
        }
        this.X = str;
    }

    public void dismissBlockDialog() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (alertDialog = this.u0) != null && alertDialog.isShowing()) {
            this.u0.dismiss();
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && c.a.e.e.p.j.x()) {
            c.a.r0.y3.h.d().g(getContext());
        }
    }

    public final void f1() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            if (this.R == null) {
                this.S = new c.a.q0.s.s.i(getActivity());
                this.R = new PopupDialog(getPageContext(), this.S);
                ArrayList arrayList = new ArrayList();
                c.a.q0.s.s.f fVar = new c.a.q0.s.s.f(getString(R.string.mark), this.S);
                boolean z2 = false;
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    fVar.m(TbadkCoreApplication.getInst().getResources().getString(R.string.remove_mark));
                } else {
                    fVar.m(TbadkCoreApplication.getInst().getResources().getString(R.string.mark));
                }
                fVar.l(this.L0);
                VideoItemData videoItemData2 = this.mVideoData;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(fVar);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.mVideoData.thread_id);
                    statisticItem.param("fid", this.mVideoData.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    int i2 = this.f57873e;
                    if (i2 != 3 && i2 != 4) {
                        statisticItem.param("obj_type", 2);
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    int i3 = this.f57873e;
                    if (i3 == 3) {
                        statisticItem.param("obj_param1", 1);
                    } else if (i3 == 4) {
                        statisticItem.param("obj_param1", 2);
                    }
                    statisticItem.param("obj_source", H0());
                    TiebaStatic.log(statisticItem);
                }
                if (isUEGBackDisLike()) {
                    c.a.q0.s.s.f fVar2 = new c.a.q0.s.s.f(getString(R.string.not_interested), this.S);
                    fVar2.l(this.K0);
                    arrayList.add(fVar2);
                }
                if (!isHost()) {
                    c.a.q0.s.s.f fVar3 = new c.a.q0.s.s.f(getString(R.string.report_text), this.S);
                    fVar3.l(this.M0);
                    arrayList.add(fVar3);
                }
                if (this.M) {
                    c.a.q0.s.s.f fVar4 = new c.a.q0.s.s.f(getString(R.string.delete), this.S);
                    fVar4.l(this.N0);
                    arrayList.add(fVar4);
                }
                this.S.m(new f0(this));
                this.R.setOnDismissListener(new h0(this));
                this.S.k(arrayList);
            }
            showDraftDialog();
        }
    }

    public final boolean g1() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (c.a.r0.y3.h.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !((i2 = this.f57873e) == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick() || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.f57873e;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && c.a.e.e.p.j.x() && isResumed() && this.B) {
                c.a.e.e.p.l.N(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(R.string.video_no_wifi_tips), 3000);
                int i4 = this.f57873e;
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

    public void getClickItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i3 = this.f57873e;
            if (i3 != 3 && i3 != 4) {
                statisticItem.param("obj_locate", 2);
            } else {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("obj_type", i2);
            int i4 = this.f57873e;
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

    @Override // c.a.r0.a4.i.a.a
    public VideoItemModel getCurrentData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.y : (VideoItemModel) invokeV.objValue;
    }

    public String getCurrentMediaID() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.r0.a4.i.a.a
    public int getFragmentIndex() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.n0 : invokeV.intValue;
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
                this.clickAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.scale_zoom_in_and_out_anim);
            }
            return this.clickAnimation;
        }
        return (Animation) invokeV.objValue;
    }

    public final void h1() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (videoItemData = this.mVideoData) == null) {
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
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.share_content_tpl);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        VideoItemData videoItemData3 = this.mVideoData;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
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
        shareItem.f48139f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.W = userItemData2.portrait;
            shareItem.X = userItemData2.user_name;
            shareItem.Y = userItemData2.getUserShowName();
        }
        int i2 = this.f57873e;
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
        originalThreadInfo.f47434c = videoItemData5.thumbnail_url;
        originalThreadInfo.f47432a = 3;
        originalThreadInfo.f47433b = videoItemData5.title;
        originalThreadInfo.f47437f = videoItemData5.thread_id;
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
        shareDialogConfig.disLikeListener = this.J0;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.P);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = isHost();
        VideoItemData videoItemData6 = this.mVideoData;
        shareDialogConfig.isManager = videoItemData6.is_manager;
        shareDialogConfig.isOriginManager = videoItemData6.is_origin_manager;
        shareDialogConfig.showHeating = showHeating();
        shareDialogConfig.isSelfHeating = this.M;
        shareDialogConfig.heatingListener = this.I0;
        d2 d2Var = this.mVideoData.threadData;
        if (d2Var != null) {
            shareDialogConfig.isCollected = d2Var.l0() == 1;
            shareDialogConfig.isMadeTop = this.mVideoData.threadData.i2();
            shareDialogConfig.isAddedGood = this.mVideoData.threadData.J1();
        }
        c.a.r0.f0.f.b().k(shareDialogConfig);
    }

    public void handleActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048617, this, i2, i3, intent) == null) {
            c.a.r0.a4.e.a aVar = this.p0;
            if (aVar != null) {
                aVar.n(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                c.a.r0.y2.a.g().m(getPageContext());
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
                if (this.f57873e == 7) {
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
            c.a.r0.a4.e.a aVar = this.p0;
            if (aVar == null || aVar.a() == null || !this.p0.a().isVisible()) {
                return false;
            }
            this.p0.a().hide();
            this.F.setVisibility(8);
            if (!(this.p0.a().findToolById(28) instanceof c.a.r0.a4.e.c) || ((c.a.r0.a4.e.c) this.p0.a().findToolById(28)).g() == null || ((c.a.r0.a4.e.c) this.p0.a().findToolById(28)).g().getText() == null) {
                return true;
            }
            this.G.setText(StringUtils.isNull(((c.a.r0.a4.e.c) this.p0.a().findToolById(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void hideDraftDialog() {
        PopupDialog popupDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (popupDialog = this.R) != null && popupDialog.isShowing()) {
            this.R.dismiss();
        }
    }

    public final void i1(boolean z2) {
        c.a.r0.a4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048620, this, z2) == null) || (aVar = this.t0) == null) {
            return;
        }
        aVar.c(O0());
        this.t0.d(getPageContext(), this.mVideoData, z2);
    }

    public final boolean isHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public boolean isUEGBackDisLike() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            VideoItemData videoItemData = this.mVideoData;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.f57873e != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void j1(View view, View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048623, this, new Object[]{view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), animatorListenerAdapter}) == null) {
            int max = Math.max(i2, i3);
            int i10 = max - ((i2 + i3) - max);
            int max2 = Math.max(i4, i5);
            int i11 = max2 - ((i4 + i5) - max2);
            int max3 = Math.max(i9, i8);
            ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new s0(this, i11, i4, i5, i10, i2, i3, max3 - ((i9 + i8) - max3), i8, i9, view, view2));
            ofInt.addListener(animatorListenerAdapter);
            ofInt.setTarget(view);
            ofInt.start();
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            TbCyberVideoView tbCyberVideoView = this.mVideoView;
            if (tbCyberVideoView != null) {
                this.b0 = tbCyberVideoView.getVideoStatus();
            } else {
                this.b0 = TbCyberVideoView.VideoStatus.INIT;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.T = forumManageModel;
            forumManageModel.setLoadDataCallBack(new c0(this));
            c.a.q0.i.a c2 = c.a.q0.i.a.c(getBaseFragmentActivity());
            this.U = c2;
            if (c2 != null) {
                c2.j(new d0(this));
            }
            this.V = new c.a.q0.t.e.a(null);
            registerListener(this.z0);
            registerListener(this.A0);
            registerListener(this.C0);
            registerListener(this.D0);
            registerListener(this.E0);
            registerListener(this.F0);
            registerListener(this.y0);
            registerListener(this.G0);
            if (TbSingleton.getInstance().getIsNeedShowPbCommentFloat() || AbsVideoChannelFragment.isShowComment) {
                I0();
                TbSingleton.getInstance().setIsNeedShowPbCommentFloat(false);
                AbsVideoChannelFragment.isShowComment = false;
            }
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.l0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048626, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            handleActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.p0 != null && this.p0.a() != null) {
                    this.p0.a().onChangeSkinType(i2);
                }
                if (this.S != null) {
                    this.S.j();
                }
                if (this.mRootView != null) {
                    this.mCommentImg.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.mShareImg.setImageDrawable(WebPManager.getMaskDrawable(R0() ? R.drawable.icon_mask_video_more36 : R.drawable.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.share_icon_changed.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.play_btn.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                    this.videoLoadingIcon.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_header40_n, c.a.r0.k3.c.a(SkinManager.getColor(R.color.CAM_X0213), 0.2f), null));
                    w0();
                    c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(this.F);
                    d2.n(R.string.J_X01);
                    d2.f(R.color.CAM_X0614);
                    c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(this.dragCurTime);
                    d3.A(R.string.F_X02);
                    d3.v(R.color.CAM_X0101);
                    c.a.q0.s.u.c.d(this.dragTotalTime).A(R.string.F_X02);
                    c.a.q0.s.u.c d4 = c.a.q0.s.u.c.d(this.share_num);
                    d4.z(R.dimen.T_X09);
                    d4.A(R.string.F_X02);
                    d4.y(R.array.S_O_X001);
                    c.a.q0.s.u.c d5 = c.a.q0.s.u.c.d(this.agree_num);
                    d5.z(R.dimen.T_X09);
                    d5.A(R.string.F_X02);
                    d5.y(R.array.S_O_X001);
                    c.a.q0.s.u.c d6 = c.a.q0.s.u.c.d(this.comment_num);
                    d6.z(R.dimen.T_X09);
                    d6.A(R.string.F_X02);
                    d6.y(R.array.S_O_X001);
                    c.a.q0.s.u.c d7 = c.a.q0.s.u.c.d(this.mAuthorNameTv);
                    d7.z(R.dimen.T_X06);
                    d7.A(R.string.F_X02);
                    d7.y(R.array.S_O_X001);
                    c.a.q0.s.u.c d8 = c.a.q0.s.u.c.d(this.mBarName);
                    d8.z(R.dimen.T_X09);
                    d8.A(R.string.F_X01);
                    d8.v(R.color.CAM_X0619);
                    d8.y(R.array.S_O_X001);
                    c.a.q0.s.u.c d9 = c.a.q0.s.u.c.d(this.u);
                    d9.n(R.string.J_X01);
                    d9.z(R.dimen.T_X09);
                    d9.v(R.color.CAM_X0101);
                    d9.A(R.string.F_X02);
                    d9.f(R.color.CAM_X0302);
                    c.a.q0.s.u.c d10 = c.a.q0.s.u.c.d(this.has_love);
                    d10.n(R.string.J_X01);
                    d10.z(R.dimen.T_X09);
                    d10.f(R.color.CAM_X0302);
                    this.dragTotalTime.setTextColor(c.a.r0.k3.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.q0.s.u.a.a(R.string.A_X08)));
                    this.agree_num.setTextColor(c.a.r0.k3.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.q0.s.u.a.a(R.string.A_X03)));
                    this.share_num.setTextColor(c.a.r0.k3.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.q0.s.u.a.a(R.string.A_X03)));
                    this.comment_num.setTextColor(c.a.r0.k3.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.q0.s.u.a.a(R.string.A_X03)));
                }
                WebPManager.setPureDrawable(this.mBackBtn, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.mMoreBtn, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                J0();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.B && (videoItemData = this.mVideoData) != null) {
                boolean z2 = c.a.e.e.m.b.e(videoItemData.video_height, 0) <= c.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                c.a.r0.a4.j.a aVar = this.s0;
                if (aVar == null || !z2) {
                    return;
                }
                if (!(aVar.isFullScreen() && configuration.orientation == 1) && (this.s0.isFullScreen() || configuration.orientation != 2)) {
                    return;
                }
                this.f57878j.removeView(this.mVideoView);
                this.s0.Y(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.B0);
            registerListener(this.S0);
            this.t0 = new c.a.r0.a4.a();
            getLifecycle().addObserver(this.H0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048630, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            boolean z2 = false;
            if (arguments != null) {
                VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
                this.y = videoItemModel;
                this.mVideoData = videoItemModel == null ? null : videoItemModel.getVideoItemData();
                this.D = (Rect) arguments.getParcelable("video_cover_rect");
                this.N = arguments.getInt("video_index");
                arguments.getString("page_from");
                this.P = arguments.getString("from");
                this.Q = arguments.getString("video_channel_tab");
                this.c0 = arguments.getString("obj_id");
                this.f57875g = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.f57873e = arguments.getInt("current_type");
                this.f57874f = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            }
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.mVideoData.author_info.user_id)) {
                this.M = true;
            }
            this.mRootView = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
            this.mRootView.setOnTouchListener(new e(this, new GestureDetectorCompat(getContext(), new d(this))));
            this.mRootView.setOnLongClickListener(new f(this));
            TbCyberVideoView tbCyberVideoView2 = new TbCyberVideoView(getContext());
            this.mVideoView = tbCyberVideoView2;
            tbCyberVideoView2.setStageType("2005");
            this.mVideoView.getMediaProgressObserver().j(new g(this));
            TbImageView tbImageView = (TbImageView) this.mRootView.findViewById(R.id.video_cover);
            this.k = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.play_btn = (ImageView) this.mRootView.findViewById(R.id.play_btn);
            this.videoLoadingLayout = (RelativeLayout) this.mRootView.findViewById(R.id.video_loading_layout);
            this.videoLoadingIcon = (ImageView) this.mRootView.findViewById(R.id.video_loading_icon);
            this.k.setEvent(new h(this));
            this.f57878j = (RelativeLayout) this.mRootView.findViewById(R.id.video_play_view_container);
            setVideoBussinessAndAddView();
            this.l = this.mRootView.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.l.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.back_btn);
            this.mBackBtn = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.mRootView.findViewById(R.id.more_btn);
            this.mMoreBtn = imageView2;
            imageView2.setVisibility(8);
            this.mPortraitContainer = this.mRootView.findViewById(R.id.portrait_container);
            LinearLayout linearLayout = (LinearLayout) this.mRootView.findViewById(R.id.recommend_layout);
            this.n = linearLayout;
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(linearLayout);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            c.a.q0.s.u.b bVar = (c.a.q0.s.u.b) this.n.getBackground();
            bVar.C(SkinManager.getColor(0, R.color.CAM_X0106));
            this.n.setBackground(bVar);
            this.o = (BarImageView) this.mRootView.findViewById(R.id.recommend_forum_avatar);
            this.p = (ImageView) this.mRootView.findViewById(R.id.recommend_avatar);
            this.o.setShowOval(true);
            TextView textView = (TextView) this.mRootView.findViewById(R.id.recommend_info_view);
            this.q = textView;
            c.a.q0.s.u.c d3 = c.a.q0.s.u.c.d(textView);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            HeadImageView headImageView = (HeadImageView) this.mRootView.findViewById(R.id.author_portrait);
            this.author_portrait = headImageView;
            headImageView.setDefaultResource(17170445);
            this.author_portrait.setPlaceHolder(2);
            this.author_portrait.setIsRound(true);
            this.author_portrait.setBorderWidth(R.dimen.L_X02);
            this.author_portrait.setBorderColor(R.color.CAM_X0622);
            this.author_portrait.setDrawBorder(true);
            this.author_portrait.setUseNightOrDarkMask(false);
            b1();
            this.mLiveLottieView = (TBLottieAnimationView) this.mRootView.findViewById(R.id.user_living_lottie);
            this.w = (RelativeLayout) this.mRootView.findViewById(R.id.author_info_container);
            this.mBottomContainer = (LinearLayout) this.mRootView.findViewById(R.id.bottom_container);
            this.u = (TBSpecificationBtn) this.mRootView.findViewById(R.id.love_btn);
            c.a.q0.s.f0.n.a aVar = new c.a.q0.s.f0.n.a();
            UtilHelper.addFollowUserIconStyle(aVar);
            aVar.h(R.color.CAM_X0101);
            aVar.m(0, 0);
            aVar.n(0);
            aVar.k(true);
            aVar.j(c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds145), c.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60));
            this.u.setConfig(aVar);
            this.u.setText(getString(R.string.attention));
            this.has_love = (EMTextView) this.mRootView.findViewById(R.id.has_love);
            a1();
            this.mAgreeImg = (ImageView) this.mRootView.findViewById(R.id.agree_img);
            this.video_title = (ExpandableTextView) this.mRootView.findViewById(R.id.video_title);
            this.r = (TextView) this.mRootView.findViewById(R.id.title_full_screen_text);
            this.s = this.mRootView.findViewById(R.id.title_full_screen_btn);
            this.t = this.mRootView.findViewById(R.id.video_title_layout);
            this.A = (VideoMiddleNiaiControllerView) this.mRootView.findViewById(R.id.media_controller);
            this.v = (TextView) this.mRootView.findViewById(R.id.video_activity);
            this.comment_container = (LinearLayout) this.mRootView.findViewById(R.id.comment_container);
            this.comment_num = (EMTextView) this.mRootView.findViewById(R.id.comment_num);
            this.mCommentImg = (ImageView) this.mRootView.findViewById(R.id.comment_img);
            this.agree_container = (LinearLayout) this.mRootView.findViewById(R.id.agree_container);
            this.mDragContainer = (LinearLayout) this.mRootView.findViewById(R.id.ll_drag_container);
            this.share_container = (LinearLayout) this.mRootView.findViewById(R.id.share_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDragContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mBottomContainer.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.share_container.getLayoutParams();
            int i2 = this.f57873e;
            if (i2 != 4 && i2 != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.A.initProgressUIType(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
            } else {
                this.A.initProgressUIType(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            }
            this.agree_num = (EMTextView) this.mRootView.findViewById(R.id.agree_num);
            this.mShareImg = (ImageView) this.mRootView.findViewById(R.id.share_img);
            this.share_num = (EMTextView) this.mRootView.findViewById(R.id.share_num);
            this.dragCurTime = (EMTextView) this.mRootView.findViewById(R.id.drag_cur_time);
            this.dragTotalTime = (EMTextView) this.mRootView.findViewById(R.id.drag_total_time);
            this.share_icon = (ImageView) this.mRootView.findViewById(R.id.share_img);
            this.share_icon_changed = (ImageView) this.mRootView.findViewById(R.id.share_img_changed);
            Y0();
            this.x = (LinearLayout) this.mRootView.findViewById(R.id.video_act_private_container);
            this.video_activity_container = (LinearLayout) this.mRootView.findViewById(R.id.video_activity_container);
            this.video_private = (LinearLayout) this.mRootView.findViewById(R.id.video_private);
            this.mAuthorNameTv = (TextView) this.mRootView.findViewById(R.id.video_author_name);
            this.mBarName = (TextView) this.mRootView.findViewById(R.id.video_bar_name);
            View findViewById = this.mRootView.findViewById(R.id.quick_reply_comment_layout);
            this.F = findViewById;
            findViewById.setOnClickListener(new i(this));
            if (this.mVideoData != null) {
                this.A.setVisibility(0);
            }
            this.A.setPlayer(this.mVideoView);
            this.A.setOnSeekBarChangeListener(new j(this));
            this.G = (TextView) this.mRootView.findViewById(R.id.quick_reply_comment_text);
            TextView textView2 = (TextView) this.mRootView.findViewById(R.id.download_nani_guide_txt);
            this.z = textView2;
            textView2.setVisibility(8);
            String p2 = c.a.q0.s.d0.b.j().p("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(p2)) {
                this.z.setText(p2);
            }
            this.z.setOnClickListener(new l(this, c.a.q0.s.d0.b.j().p("nani_key_download_link_url", null)));
            A0();
            m mVar = new m(this);
            this.mPortraitContainer.setOnClickListener(mVar);
            this.mAuthorNameTv.setOnClickListener(mVar);
            this.video_activity_container.setOnClickListener(new n(this));
            this.video_title.setHasDown();
            this.video_title.setOnClickListener(new o(this));
            this.s.setOnClickListener(new p(this));
            this.mBackBtn.setOnClickListener(new q(this));
            this.mMoreBtn.setOnClickListener(new r(this));
            this.comment_container.setOnClickListener(new s(this));
            this.agree_container.setOnClickListener(new t(this));
            this.share_container.setOnClickListener(new u(this));
            this.u.setOnClickListener(new w(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.C = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.C.setAnimationListener(new x(this));
            this.videoLoadingLayout.setVisibility(0);
            if (this.B) {
                this.A.setLoading(true);
            }
            if (this.D != null && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getParent() != null) {
                Rect rect = this.D;
                int i3 = rect.right;
                int i4 = rect.left;
                this.I = i3 - i4;
                int i5 = rect.bottom;
                int i6 = rect.top;
                this.J = i5 - i6;
                this.K = i4;
                this.L = i6;
                this.mVideoView.post(new y(this));
            }
            L0();
            if (this.B) {
                F0();
            }
            VideoItemData videoItemData2 = this.mVideoData;
            if (videoItemData2 != null && !StringUtils.isNull(videoItemData2.video_url)) {
                d1(this.mVideoData.video_url);
            }
            c.a.r0.a4.j.a aVar2 = new c.a.r0.a4.j.a(getContext(), this.f57878j);
            this.s0 = aVar2;
            aVar2.setStageType("2005");
            this.s0.setUniqueId(getUniqueId());
            VideoItemData videoItemData3 = this.mVideoData;
            if (videoItemData3 != null && videoItemData3.threadData == null) {
                videoItemData3.threadData = new d2();
                VideoItemData videoItemData4 = this.mVideoData;
                d2 d2Var = videoItemData4.threadData;
                d2Var.E = videoItemData4.thread_id;
                d2Var.i0 = 40;
                d2Var.m4(c.a.e.e.m.b.e(videoItemData4.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(c.a.e.e.m.b.e(this.mVideoData.video_width, 0));
                builder.video_height = Integer.valueOf(c.a.e.e.m.b.e(this.mVideoData.video_height, 0));
                VideoItemData videoItemData5 = this.mVideoData;
                builder.video_url = videoItemData5.video_url;
                builder.thumbnail_url = videoItemData5.thumbnail_url;
                builder.video_md5 = videoItemData5.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData5.isVerticalVideo);
                this.mVideoData.threadData.F4(builder.build(true));
            }
            VideoItemData videoItemData6 = this.mVideoData;
            if (videoItemData6 != null) {
                this.s0.setData(videoItemData6.threadData);
                boolean z3 = c.a.e.e.m.b.e(this.mVideoData.video_height, 0) <= c.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                c.a.r0.a4.j.a aVar3 = this.s0;
                if (this.B && z3) {
                    z2 = true;
                }
                aVar3.a0(z2);
                this.s0.F0(new z(this));
                this.s0.getMainView().setVisibility(8);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                c.a.e.e.m.e.a().post(this.w0);
            }
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            stopPlay();
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.B0);
            c.a.r0.a4.j.a aVar = this.s0;
            if (aVar != null) {
                aVar.E0();
            }
            MessageManager.getInstance().unRegisterListener(this.S0);
            c.a.r0.a4.e.a aVar2 = this.p0;
            if (aVar2 != null) {
                aVar2.o();
            }
            if (this.O0 != null) {
                c.a.e.e.m.e.a().removeCallbacks(this.O0);
                this.O0 = null;
            }
            c.a.r0.a4.a aVar3 = this.t0;
            if (aVar3 != null) {
                aVar3.b();
            }
            c.a.e.e.m.e.a().removeCallbacks(this.w0);
            getLifecycle().removeObserver(this.H0);
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.A;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.setOnSeekBarChangeListener(null);
            }
            TbImageView tbImageView = this.k;
            if (tbImageView != null) {
                tbImageView.setEvent(null);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onPause();
            if (!this.j0) {
                V0();
            }
            c.a.r0.a4.e.a aVar = this.p0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.p0.a().hide();
            this.F.setVisibility(8);
            this.G.setText(StringUtils.isNull(((c.a.r0.a4.e.c) this.p0.a().findToolById(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            super.onPrimary();
            if (isResumed() && this.B) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.mVideoData;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.B) {
                        X0();
                        Z0();
                        W0(0);
                    } else {
                        V0();
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
            V0();
            c.a.r0.a4.e.a aVar = this.p0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.p0.a().hide();
            this.F.setVisibility(8);
            this.G.setText(StringUtils.isNull(((c.a.r0.a4.e.c) this.p0.a().findToolById(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.onResume();
            if (this.v0) {
                this.v0 = false;
                c.a.e.e.m.e.a().removeCallbacks(this.w0);
                W0(1);
                startPlay();
                F0();
                this.l0 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onStart();
            if (this.j0) {
                Z0();
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onStatusChange(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.videoLoadingLayout;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2 = this.A;
                if (videoMiddleNiaiControllerView2 != null) {
                    videoMiddleNiaiControllerView2.setLoading(false);
                }
                f1 f1Var = this.r0;
                if (f1Var != null) {
                    f1Var.onStart();
                }
                TbImageView tbImageView = this.k;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
                if (!TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                    TbSingleton.getInstance().setEnableVideoVerticalPreload(true);
                }
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView = this.A) != null) {
                videoMiddleNiaiControllerView.setLoading(false);
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.A != null && this.B && isResumed()) {
                this.A.setLoading(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.onStop();
            V0();
            c.a.r0.a4.e.a aVar = this.p0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.p0.a().hide();
            this.F.setVisibility(8);
            this.G.setText(StringUtils.isNull(((c.a.r0.a4.e.c) this.p0.a().findToolById(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
            c.a.e.e.m.e.a().removeCallbacks(this.w0);
        }
    }

    @Override // c.a.q0.f1.q.b.InterfaceC0665b
    public void onViewClick() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.isCanShowPause()) {
            if (this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                if (this.mVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PAUSING || g1()) {
                    return;
                }
                this.mVideoView.start();
                this.play_btn.setVisibility(8);
                y0(true);
                this.A.showProgress();
                if (isResumed() && this.B) {
                    return;
                }
                V0();
                return;
            }
            this.mVideoView.pause();
            this.play_btn.setVisibility(0);
            y0(false);
            c.a.e.e.m.e.a().removeCallbacks(this.O0);
            getClickItem(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            A0();
            c1();
        }
    }

    @Override // c.a.q0.f1.q.b.InterfaceC0665b
    public void onViewDoubleClick(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity())) {
            C0();
            VideoItemData videoItemData = this.mVideoData;
            if (videoItemData == null || !"0".equals(videoItemData.is_agreed)) {
                return;
            }
            D0(this.f57877i);
        }
    }

    @Override // c.a.q0.f1.q.b.InterfaceC0665b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || Q0() || (videoItemData = this.mVideoData) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long g2 = c.a.e.e.m.b.g(userItemData.user_id, 0L);
        long g3 = c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = (g2 == 0 && g3 == 0) ? false : g2 == g3;
        c.a.r0.a4.d.a.a();
        MessageManager messageManager = MessageManager.getInstance();
        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
        int i2 = this.f57873e;
        messageManager.sendMessage(new CustomMessage(2002001, personPolymericActivityConfig.createNormalConfig(g2, z2, false, true, (i2 == 3 || i2 == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE)));
    }

    @Override // c.a.r0.a4.i.a.a
    public void setFragmentIndex(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            this.n0 = i2;
        }
    }

    public void setOnProgressUpdatedListener(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, cVar) == null) {
            this.q0 = cVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        TbCyberVideoView tbCyberVideoView;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.B = z2;
            if (this.s0 != null && (videoItemData = this.mVideoData) != null) {
                this.s0.a0(this.B && (c.a.e.e.m.b.e(videoItemData.video_height, 0) <= c.a.e.e.m.b.e(this.mVideoData.video_width, 0)));
            }
            if (!z2 && this.p0 != null) {
                this.G.setText(R.string.reply_something);
                this.p0.l();
            }
            if (!isResumed() && this.B) {
                this.v0 = true;
            }
            if (isResumed() && this.B && (!this.l0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                W0(1);
                startPlay();
                F0();
                this.l0 = false;
            } else if (!this.j0) {
                Y0();
                this.m0 = 1;
                V0();
            }
            if (this.A != null) {
                if (this.B && isResumed() && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                    this.A.setLoading(true);
                } else {
                    this.A.setLoading(false);
                }
            }
        }
    }

    public void setVideoBussinessAndAddView() {
        TbCyberVideoView tbCyberVideoView;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        TbCyberVideoView tbCyberVideoView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && (tbCyberVideoView = this.mVideoView) != null && tbCyberVideoView.getParent() == null) {
            if (this.mVideoData != null) {
                this.H = new RelativeLayout.LayoutParams(-1, -1);
                int e2 = c.a.e.e.m.b.e(this.mVideoData.video_height, 0);
                int e3 = c.a.e.e.m.b.e(this.mVideoData.video_width, 0);
                int screenHeight = UtilHelper.getScreenHeight(this.mRootView.getContext());
                int k2 = c.a.e.e.p.l.k(this.mRootView.getContext());
                if ("video_channel_tab".equals(this.P)) {
                    screenHeight -= TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                }
                if (e2 <= 0 || e3 <= 0 || screenHeight <= 0 || k2 <= 0) {
                    this.mVideoView.setVideoScalingMode(2);
                    this.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
                } else {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.a0 = layoutParams;
                        layoutParams.removeRule(13);
                        this.a0.addRule(14);
                        this.a0.topMargin = (screenHeight - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) / 2;
                    } else {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.play_btn.getLayoutParams();
                        this.a0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.a0.addRule(14);
                        this.a0.topMargin = (screenHeight - c.a.e.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) / 2;
                    }
                    if (f2 > 1.34f) {
                        this.mVideoView.setVideoScalingMode(0);
                        this.k.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    } else {
                        this.mVideoView.setVideoScalingMode(2);
                        this.k.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
                Rect rect = this.D;
                if (rect != null && !this.E) {
                    int i2 = rect.right;
                    int i3 = rect.left;
                    this.I = i2 - i3;
                    int i4 = rect.bottom;
                    int i5 = rect.top;
                    this.J = i4 - i5;
                    RelativeLayout.LayoutParams layoutParams3 = this.H;
                    layoutParams3.width = i2 - i3;
                    layoutParams3.height = i4 - i5;
                    layoutParams3.topMargin = i5;
                    layoutParams3.leftMargin = i3;
                    layoutParams3.rightMargin = i3;
                } else {
                    this.H = G0();
                }
                this.k.setLayoutParams(this.H);
                if (this.f57878j != null && (tbCyberVideoView2 = this.mVideoView) != null && tbCyberVideoView2.getView() != null) {
                    this.f57878j.addView(this.mVideoView.getView(), 0, this.H);
                }
            }
            if (this.mVideoData != null) {
                c.a.r0.q2.o oVar = new c.a.r0.q2.o();
                oVar.f24001e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData = this.mVideoData;
                oVar.f23999c = videoItemData.thread_id;
                oVar.t = videoItemData.nid;
                oVar.f24000d = videoItemData.forum_id;
                oVar.m = videoItemData.mMd5;
                oVar.k = "";
                oVar.f24002f = videoItemData.mRecomSource;
                oVar.l = videoItemData.mRecomAbTag;
                oVar.f24006j = 1;
                BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
                if (baijiahaoData != null) {
                    int i6 = baijiahaoData.oriUgcType;
                    if (i6 == 2) {
                        oVar.f24006j = 3;
                    } else if (i6 == 4) {
                        oVar.f24006j = 2;
                    }
                }
                oVar.f24004h = this.mVideoData.mRecomWeight;
                if (this.D != null) {
                    oVar.n = "1";
                } else {
                    oVar.n = "2";
                }
                int i7 = this.f57873e;
                if (i7 == 1) {
                    oVar.p = "1";
                    oVar.f23997a = "13";
                    oVar.f24005i = this.P;
                    oVar.k = this.c0;
                    oVar.f24003g = this.mVideoData.mRecomWeight;
                } else if (i7 == 2) {
                    oVar.f23997a = "24";
                } else {
                    oVar.f23997a = "13";
                }
                oVar.p = "1";
                int i8 = this.f57873e;
                if (i8 == 3) {
                    oVar.f23997a = "21";
                } else if (i8 == 4) {
                    oVar.f23997a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
                } else if (i8 == 7) {
                    oVar.f23997a = "26";
                } else if (N0()) {
                    oVar.f23997a = "27";
                }
                String str = this.P;
                oVar.f24005i = str;
                String str2 = this.c0;
                oVar.k = str2;
                String str3 = this.mVideoData.mRecomWeight;
                oVar.f24003g = str3;
                if (this.f57873e == 5) {
                    oVar.f23997a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR;
                    oVar.p = "1";
                    oVar.f24005i = str;
                    oVar.k = str2;
                    oVar.f24003g = str3;
                }
                if (M0() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    oVar.f24005i = personalPageParams.getStatPageFromIdentifier();
                }
                this.mVideoView.setVideoStatData(oVar);
                this.mVideoView.setLocateSource("v_mid_page");
            }
            this.mVideoView.setContinuePlayEnable(true);
        }
    }

    public void setVideoPlayPrefetcher(c.a.r0.a4.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, aVar) == null) {
            this.o0 = aVar;
        }
    }

    public void setVideoStatusListener(f1 f1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, f1Var) == null) {
            this.r0 = f1Var;
        }
    }

    public void showBlockDialog(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048648, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            dismissBlockDialog();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                i2 = z2 ? R.string.musk_my_thread_confirm : R.string.musk_thread_confirm;
                i3 = R.string.musk_my_thread_confirm_subtitle;
                i4 = R.string.shield;
            } else {
                i2 = R.string.del_my_thread_confirm;
                i3 = R.string.del_my_thread_confirm_subtitle;
                i4 = R.string.delete;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a(R.string.cancel, TBAlertConfig.OperateBtnStyle.SECONDARY);
            c.a.q0.s.s.l lVar = new c.a.q0.s.s.l(TbadkCoreApplication.getInst().getCurrentActivity());
            lVar.p(i2);
            lVar.j(i3);
            lVar.l(true);
            lVar.o(aVar2, aVar);
            lVar.g(false);
            this.u0 = lVar.s();
            aVar.a(new w0(this, z2, z3));
            aVar2.a(new x0(this));
        }
    }

    public long showDownloadNaniGuide() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            LinearLayout linearLayout = this.x;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView = this.z;
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
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || this.R == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.R.showDialog();
    }

    public boolean showHeating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (c.a.q0.t.c.j0.e()) {
                int i2 = this.f57873e;
                return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void showPbCommentFloatNum() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM);
            statisticItem.param("tid", this.mVideoData.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.mVideoData.forum_id);
            int i2 = this.f57873e;
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
        if (!(interceptable == null || interceptable.invokeV(1048653, this) == null) || g1()) {
            return;
        }
        e1();
        ImageView imageView = this.play_btn;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbCyberVideoView tbCyberVideoView = this.mVideoView;
        if (tbCyberVideoView != null && this.play_btn != null && this.mVideoData != null && tbCyberVideoView.getParent() == null) {
            setVideoBussinessAndAddView();
            c1();
        }
        if (Build.VERSION.SDK_INT < 17 && this.k.getVisibility() == 0) {
            this.k.clearAnimation();
            this.k.startAnimation(this.C);
        }
        if (this.mVideoView != null && !TextUtils.isEmpty(this.X) && this.mVideoData != null) {
            if (TbVideoViewSet.d().e(this.X) == null || TbVideoViewSet.d().e(this.X) != this.mVideoView) {
                this.mVideoView.setVideoPath(this.X, this.mVideoData.thread_id);
            }
            this.mVideoView.start(this.x0);
            this.A.showProgress();
            X0();
        }
        if (this.j0) {
            return;
        }
        if ((isResumed() && this.B) || T0()) {
            return;
        }
        V0();
        ImageView imageView2 = this.play_btn;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048654, this) == null) || (tbCyberVideoView = this.mVideoView) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final void w0() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048655, this) == null) || (videoItemData = this.mVideoData) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.mAgreeImg.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.agree_num.setText(StringHelper.numberUniformFormatExtraWithRoundVote(c.a.e.e.m.b.g(this.mVideoData.agree_num, 0L)));
    }

    public final void x0() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            if (!this.M && ((userItemData = this.mVideoData.author_info) == null || !"1".equals(userItemData.is_follow))) {
                this.u.setVisibility(0);
                this.u.setClickable(true);
                this.has_love.setVisibility(8);
                return;
            }
            this.u.setVisibility(4);
            this.u.setClickable(false);
            this.has_love.setVisibility(8);
        }
    }

    public final void y0(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048657, this, z2) == null) || (videoMiddleNiaiControllerView = this.A) == null) {
            return;
        }
        int i2 = this.f57873e;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick()) ? 1 : 0);
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048658, this) == null) || R0() || this.share_icon_changed == null || this.share_icon == null) {
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
}
