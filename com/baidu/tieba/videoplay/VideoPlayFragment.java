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
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.util.Pair;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.TBAlertBuilder;
import com.baidu.tbadk.core.dialog.TBAlertConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FirstPraiseToast;
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
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
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
import com.baidu.tieba.R;
import com.baidu.tieba.ab8;
import com.baidu.tieba.an8;
import com.baidu.tieba.ay8;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.e35;
import com.baidu.tieba.ed8;
import com.baidu.tieba.eh6;
import com.baidu.tieba.ej;
import com.baidu.tieba.fb8;
import com.baidu.tieba.fv4;
import com.baidu.tieba.gh;
import com.baidu.tieba.gn8;
import com.baidu.tieba.gv4;
import com.baidu.tieba.hv4;
import com.baidu.tieba.hv8;
import com.baidu.tieba.jv7;
import com.baidu.tieba.lx8;
import com.baidu.tieba.mx8;
import com.baidu.tieba.my4;
import com.baidu.tieba.n25;
import com.baidu.tieba.na8;
import com.baidu.tieba.nu4;
import com.baidu.tieba.oc5;
import com.baidu.tieba.ol8;
import com.baidu.tieba.ox4;
import com.baidu.tieba.pa8;
import com.baidu.tieba.pl5;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.q9;
import com.baidu.tieba.qm5;
import com.baidu.tieba.qo4;
import com.baidu.tieba.qy8;
import com.baidu.tieba.sx8;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tc5;
import com.baidu.tieba.ua8;
import com.baidu.tieba.uu4;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.danmu.DanmuPostDraftManager;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.tieba.vx8;
import com.baidu.tieba.vy8;
import com.baidu.tieba.w9;
import com.baidu.tieba.wa8;
import com.baidu.tieba.wu4;
import com.baidu.tieba.wx8;
import com.baidu.tieba.wy8;
import com.baidu.tieba.xt8;
import com.baidu.tieba.y36;
import com.baidu.tieba.yo4;
import com.baidu.tieba.yu4;
import com.baidu.tieba.yx8;
import com.baidu.tieba.zh5;
import com.baidu.tieba.zx8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
import tbclient.VideoInfo;
/* loaded from: classes6.dex */
public class VideoPlayFragment extends BaseFragment implements qm5.b, vy8, OnStatusChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public boolean A0;
    public final CustomMessageListener A1;
    public ImageView B;
    public int B0;
    public final CustomMessageListener B1;
    public RelativeLayout C;
    public String C0;
    @NonNull
    public final BarManageResultListener C1;
    public ImageView D;
    public String D0;
    public final CustomMessageListener D1;
    public LinearLayout E;
    public String E0;
    public final VideoDanmuController.b E1;
    public TextView F;
    public wu4 F0;
    public View.OnTouchListener F1;
    public ImageView G;
    public yu4 G0;
    public View.OnLongClickListener G1;
    public LinearLayout H;
    public ForumManageModel H0;
    public na8.c H1;
    public BarImageView I;
    public qo4 I0;
    public TbImageView.g I1;
    public ImageView J;
    public n25 J0;
    public SeekBar.OnSeekBarChangeListener J1;
    public TextView K;
    public BdUniqueId K0;
    public View.OnClickListener K1;
    public ExpandableTextView L;
    public String L0;
    public View.OnClickListener L1;
    public TextView M;
    public boolean M0;
    public View.OnClickListener M1;
    public View N;
    public RelativeLayout.LayoutParams N0;
    public View.OnClickListener N1;
    public View O;
    public OnStatusChangedListener.VideoStatus O0;
    public View.OnClickListener O1;
    public View P;
    public String P0;
    public Animation.AnimationListener P1;
    public EMTextView Q;
    public boolean Q0;
    public Runnable Q1;
    public EMTextView R;
    public boolean R0;
    public Runnable R1;
    public EMTextView S;
    public boolean S0;
    public vx8.b S1;
    public EMTextView T;
    public int T0;
    public GestureDetectorCompat T1;
    public EMTextView U;
    public int U0;
    public VideoDanmuController.c U1;
    public TBSpecificationBtn V;
    public qy8 V0;
    public View.OnClickListener V1;
    public TextView W;
    public yx8 W0;
    public View.OnClickListener W1;
    public View X;
    public na8.c X0;
    public yu4.d X1;
    public LinearLayout Y;
    public i1 Y0;
    public yu4.d Y1;
    public LinearLayout Z;
    public wy8 Z0;
    public yu4.d Z1;
    public int a;
    public LinearLayout a0;
    public mx8 a1;
    public yu4.d a2;
    public boolean b;
    public VideoItemData b0;
    public AlertDialog b1;
    public Runnable b2;
    public BdUniqueId c;
    public VideoItemModel c0;
    public RelativeLayout c1;
    public fb8 c2;
    public int d;
    public TextView d0;
    public boolean d1;
    public CustomMessageListener d2;
    public int e;
    public VideoMiddleNiaiControllerView e0;
    public TiePlusEventController e1;
    public CustomMessageListener e2;
    public View f;
    public boolean f0;
    public boolean f1;
    public View g;
    public AlphaAnimation g0;
    public pl5 g1;
    public RelativeLayout h;
    public Rect h0;
    public boolean h1;
    public TbVideoViewContainer i;
    public boolean i0;
    public View i1;
    public VideoDanmuController j;
    public ImageView j0;
    public View j1;
    public vx8 k;
    public boolean k1;
    public TbImageView l;
    public ObjectAnimator l1;
    public View m;
    public ObjectAnimator m1;
    public ImageView n;
    public xt8 n1;
    public ImageView o;
    public boolean o1;
    public View p;
    public lx8 p1;
    public HeadImageView q;
    public ImageView q0;
    public int q1;
    public TBLottieAnimationView r;
    public ImageView r0;
    public final Runnable r1;
    public TBLottieAnimationView s;
    public TextView s0;
    public final TbVideoViewSet.b s1;
    public boolean t;
    public View t0;
    public final CustomMessageListener t1;
    public LinearLayout u;
    public TextView u0;
    public final CustomMessageListener u1;
    public LinearLayout v;
    public RelativeLayout.LayoutParams v0;
    public final CustomMessageListener v1;
    public LinearLayout w;
    public int w0;
    public final CustomMessageListener w1;
    public RelativeLayout x;
    public int x0;
    public final CustomMessageListener x1;
    public LinearLayout y;
    public int y0;
    public final CustomMessageListener y1;
    public ImageView z;
    public int z0;
    public final CustomMessageListener z1;

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue(), (SimpleMessageListener.b) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public static void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                SimpleMessageListener.j(2001457, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.R0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.a.R0) {
                this.a.R0 = false;
                if (this.a.p1 != null) {
                    this.a.p1.d(this.a.R0);
                }
                if (this.a.j != null) {
                    this.a.j.Z();
                    if (this.a.l4()) {
                        this.a.j.U();
                    }
                }
                this.a.Z0.X(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (videoItemData = (videoPlayFragment = this.a).b0) == null || videoItemData.thread_id == null) {
                return;
            }
            TiebaPlusConfigData.dealFireLinkWithTid(videoPlayFragment.getPageContext(), this.a.b0.thread_id);
            int i = 7;
            if (this.a.a == 1 || this.a.a == 2) {
                i = 6;
            } else if (this.a.a != 3) {
                int unused = this.a.a;
            }
            TiebaPlusConfigData.addClickStatsForFireLink(i);
        }
    }

    /* loaded from: classes6.dex */
    public class a1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a1(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            ThreadData threadData;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof gn8)) {
                gn8 gn8Var = (gn8) customResponsedMessage.getData();
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData == null || (threadData = videoItemData.threadData) == null || (str = threadData.tid) == null || !str.equals(gn8Var.a)) {
                    return;
                }
                this.a.b0.threadData.setIsMarked(gn8Var.b ? 1 : 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    if (this.a.a.getActivity() != null) {
                        this.a.a.D3();
                        this.a.a.k1 = true;
                        this.a.a.getActivity().finish();
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.FALSE));
                    this.a.a.z4(1.0f);
                    this.a.a.n4();
                    this.a.a.f.setBackground(null);
                    this.a.a.c1.setVisibility(0);
                    this.a.a.c1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    super.onAnimationStart(animator);
                    if (this.a.a.v0 != null) {
                        this.a.a.v0.removeRule(14);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i = ej.i(this.a.f.getContext());
                if (this.a.isResumed() && this.a.f0) {
                    if (this.a.a != 1) {
                        if (this.a.a == 7 && (videoItemData = (videoPlayFragment = this.a).b0) != null && videoItemData.thread_id != null && videoPlayFragment.getActivity() != null && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                            VideoPlayFragment videoPlayFragment2 = this.a;
                            if (dj.isEquals(videoPlayFragment2.b0.thread_id, ((FrsVideoTabPlayActivity) videoPlayFragment2.getActivity()).T0()) && ((FrsVideoTabPlayActivity) this.a.getActivity()).S0() != null) {
                                VideoPlayFragment videoPlayFragment3 = this.a;
                                videoPlayFragment3.h0 = ((FrsVideoTabPlayActivity) videoPlayFragment3.getActivity()).S0();
                            }
                        }
                    } else {
                        VideoPlayFragment videoPlayFragment4 = this.a;
                        VideoItemData videoItemData2 = videoPlayFragment4.b0;
                        if (videoItemData2 != null && videoItemData2.thread_id != null && videoPlayFragment4.getActivity() != null && (this.a.getActivity() instanceof VideoPlayActivity)) {
                            VideoPlayFragment videoPlayFragment5 = this.a;
                            if (dj.isEquals(videoPlayFragment5.b0.thread_id, ((VideoPlayActivity) videoPlayFragment5.getActivity()).O0()) && ((VideoPlayActivity) this.a.getActivity()).N0() != null) {
                                VideoPlayFragment videoPlayFragment6 = this.a;
                                videoPlayFragment6.h0 = ((VideoPlayActivity) videoPlayFragment6.getActivity()).N0();
                            }
                        }
                    }
                    if ((this.a.a == 1 || this.a.a == 7) && this.a.h0 != null) {
                        VideoPlayFragment videoPlayFragment7 = this.a;
                        videoPlayFragment7.w0 = videoPlayFragment7.h0.right - this.a.h0.left;
                        VideoPlayFragment videoPlayFragment8 = this.a;
                        videoPlayFragment8.x0 = videoPlayFragment8.h0.bottom - this.a.h0.top;
                        VideoPlayFragment videoPlayFragment9 = this.a;
                        videoPlayFragment9.y0 = videoPlayFragment9.h0.left;
                        VideoPlayFragment videoPlayFragment10 = this.a;
                        videoPlayFragment10.z0 = videoPlayFragment10.h0.top;
                        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                            VideoPlayFragment videoPlayFragment11 = this.a;
                            videoPlayFragment11.V3(videoPlayFragment11.i, this.a.l, this.a.c1, this.a.v0.leftMargin, this.a.y0, this.a.v0.topMargin, this.a.z0, this.a.v0.width, this.a.w0, this.a.v0.height, this.a.x0, i, this.a.x0, 0, this.a.z0, new a(this));
                        }
                    } else if (this.a.getActivity() != null) {
                        this.a.getActivity().finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public b0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.H0.getLoadDataMode() == 0) {
                if (this.a.Y3()) {
                    if ((obj instanceof ForumManageModel.b) && this.a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.k(this.a.getPageContext(), Pair.create(Boolean.valueOf(bVar.a), bVar.b));
                    }
                } else {
                    VideoItemData videoItemData = this.a.b0;
                    if (videoItemData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, videoItemData.getThreadId()));
                    }
                }
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b1(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isPrimary() && this.a.f0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wa8)) {
                wa8 wa8Var = (wa8) customResponsedMessage.getData();
                SeekBar seekBar = this.a.e0.getSeekBar();
                int i = wa8Var.a;
                if (i == 1) {
                    seekBar.setProgress(wa8Var.b);
                    this.a.e0.k(seekBar, wa8Var.b, true);
                } else if (i == 2) {
                    this.a.e0.l(seekBar);
                } else if (i == 3) {
                    this.a.e0.m(seekBar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            ThreadData threadData = this.a.b0.threadData;
            if (threadData != null && aVar.d()) {
                int i = d1.a[aVar.c().ordinal()];
                if (i == 1) {
                    threadData.setMadeTop(true);
                } else if (i == 2) {
                    threadData.setMadeTop(false);
                } else if (i == 3) {
                    threadData.setAddedGood(true);
                } else if (i == 4) {
                    threadData.setAddedGood(false);
                }
            }
            this.a.showToast(aVar.b());
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements qo4.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.qo4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.I0 != null) {
                        this.a.I0.h(z2);
                    }
                    VideoItemData videoItemData = this.a.b0;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00d2));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0ff1));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14e5));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public c1(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
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
                if (this.a.m1 == null) {
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.m1 = videoPlayFragment.O3(1.0f, 1.0f, 1.0f, 100L);
                }
                this.a.m1.start();
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

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.f0 && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                boolean m = ((ay8) this.a.W0.a().n(28)).h().m();
                if (booleanValue) {
                    this.a.t3(false);
                } else if (m) {
                    this.a.t3(true);
                } else {
                    this.a.U3();
                }
                ((ay8) this.a.W0.a().n(28)).h().setEmotionClick(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public d0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r.playAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class d1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318571109, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$d1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318571109, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$d1;");
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

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.videoplay.danmu.VideoDanmuController.b
        public boolean a(@Nullable PostData postData, @Nullable jv7 jv7Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, postData, jv7Var)) == null) {
                if (this.a.j != null) {
                    this.a.j.O("c14478");
                }
                if (postData != null) {
                    this.a.Q3(postData.L(), true);
                    MessageManager.getInstance().registerStickyMode(2921648);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921648, jv7Var));
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements yu4.c {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.yu4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.T3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e1(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof an8)) {
                AgreeData agreeData = ((an8) customResponsedMessage.getData()).b;
                if (this.a.b0 == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.a.b0.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.a.b0.agree_num = String.valueOf(agreeData.agreeNum);
                    this.a.b0.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.a.v3();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.b0.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.b0.agree_num = String.valueOf(agreeData.agreeNum);
                this.a.b0.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.a.v3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public f(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) ? this.a.T1.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f0 implements DialogInterface.OnDismissListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.F0 = null;
                this.a.G0 = null;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f1(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.a.R0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.c.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.a.b0 == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds562);
            int K3 = this.a.K3();
            int e = dh.e(this.a.b0.video_height, 0);
            int e2 = dh.e(this.a.b0.video_width, 0);
            if (e != 0 && e2 != 0) {
                f = (e * 1.0f) / e2;
            }
            if (e > e2) {
                return;
            }
            int k = ej.k(this.a.f.getContext());
            float f2 = k * f;
            int f3 = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds166);
            if (f > 1.0f) {
                i = (int) (dimenPixelSize + ((K3 - dimenPixelSize) * floatValue));
                i2 = (int) (i / f);
                float f4 = 1.0f - floatValue;
                statusBarHeight = (int) (UtilHelper.getStatusBarHeight() * f4);
                this.a.N0.topMargin = (int) (((K3 - f3) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f4) + (f4 * (dimenPixelSize - f3) * 0.5f));
            } else {
                float f5 = dimenPixelSize;
                float f6 = 1.0f - floatValue;
                statusBarHeight = (int) (((K3 - f2) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f6));
                this.a.N0.topMargin = (int) (((K3 - f3) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f6) + (f6 * (dimenPixelSize - f3) * 0.5f));
                i = (int) (f5 + ((f2 - f5) * floatValue));
                i2 = k;
            }
            this.a.v0.height = i;
            this.a.v0.width = i2;
            this.a.v0.topMargin = statusBarHeight;
            this.a.B.requestLayout();
            this.a.i.requestLayout();
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public g(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                this.a.S4();
                this.a.f.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g0(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.isResumed() && this.a.f0) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.O4(videoPlayFragment.A0, booleanValue);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g1(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                if (this.a.R0) {
                    if (bool.booleanValue() || !this.a.l4()) {
                        this.a.startPlay();
                        this.a.n4();
                        return;
                    }
                    this.a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements na8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public h(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.na8.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || this.a.X0 == null) {
                return;
            }
            this.a.X0.a(i, i2);
            if (this.a.h1) {
                this.a.p4(i2, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public h0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.X4(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h1(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.R0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.l4()) {
                        this.a.startPlay();
                        return;
                    }
                    return;
                }
                this.a.d5();
                this.a.n4();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public i(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.C.setVisibility(8);
                this.a.i.getControl().setCanShowPause(true);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i0 implements yu4.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.F0 != null) {
                    this.a.F0.dismiss();
                }
                this.a.X4(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface i1 {
        void a();

        void onStart();
    }

    /* loaded from: classes6.dex */
    public class j implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public j(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                this.a.G3(true);
                EMTextView eMTextView = this.a.T;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i));
                }
                EMTextView eMTextView2 = this.a.U;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.a.i.getControl().getDuration()));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, seekBar) == null) {
                int i = 1;
                this.a.Q0 = true;
                if (this.a.e0 != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.a.e0;
                    if (this.a.a != 4 && this.a.a != 3) {
                        i = 0;
                    }
                    videoMiddleNiaiControllerView.setBottomBarShow(false, i);
                }
                this.a.Z4();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.a.isResumed() && this.a.f0) {
                    this.a.e0.setLoading(true);
                }
                this.a.Q0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(null);
                    this.a.G3(false);
                    if (!this.a.i.getControl().isPlaying()) {
                        this.a.i.getControl().start();
                        this.a.B.setVisibility(8);
                    }
                    if (!this.a.R0 && (!this.a.isResumed() || !this.a.f0)) {
                        this.a.n4();
                    }
                    gh.a().removeCallbacks(this.a.b2);
                    gh.a().postDelayed(this.a.b2, 3000L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements yu4.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    if (this.a.F0 != null) {
                        this.a.F0.dismiss();
                        return;
                    }
                    return;
                }
                if (this.a.F0 != null) {
                    this.a.F0.dismiss();
                }
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.a.b0.thread_id);
                markData.setPostId(this.a.b0.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.a.b0.thread_id);
                markData.setForumId(this.a.b0.forum_id);
                if (this.a.I0 != null) {
                    this.a.I0.i(markData);
                    if (!z) {
                        this.a.I0.a();
                    } else {
                        this.a.I0.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public k(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i == null || this.a.i.getControl() == null) {
                return;
            }
            VideoPlayFragment videoPlayFragment = this.a;
            if (videoPlayFragment.b0 != null) {
                videoPlayFragment.i.getControl().setVideoPath(this.a.L0, this.a.b0.thread_id);
                this.a.i.getControl().K();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public k0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.dismiss();
                if (ViewHelper.checkUpIsLogin(this.a.getActivity()) && this.a.getPageContext() != null) {
                    if (this.a.n1 == null && (runTask = MessageManager.getInstance().runTask(2921343, xt8.class, this.a.getContext())) != null) {
                        this.a.n1 = (xt8) runTask.getData();
                    }
                    if (this.a.n1 != null) {
                        VideoPlayFragment videoPlayFragment = this.a;
                        if (videoPlayFragment.b0 != null) {
                            videoPlayFragment.n1.b(this.a.getUniqueId());
                            this.a.n1.a(this.a.b0.post_id);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f091a35 && (videoItemData = this.a.b0) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.a;
                    if (videoPlayFragment.b0.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.a.b0.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.a.b0.getThreadId());
                        UserItemData userItemData2 = this.a.b0.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.a.b0.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.a.b0;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null) {
                    return;
                }
                long g = dh.g(userItemData.user_id, 0L);
                long g2 = dh.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = (g == 0 && g2 == 0) ? false : g == g2;
                String str = this.a.b0.author_info.portrait;
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.a.getActivity()).createNormalConfig(g, z, false, true, (this.a.a == 3 || this.a.a == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                createNormalConfig.setPortrait(str);
                createNormalConfig.setSourceTid(this.a.b0.thread_id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.a.b0.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.a.I3(5);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements yu4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a implements nu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nu4 a;
            public final /* synthetic */ l0 b;

            public a(l0 l0Var, nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var, nu4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = l0Var;
                this.a = nu4Var;
            }

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    this.a.dismiss();
                    VideoPlayFragment videoPlayFragment = this.b.a;
                    if (videoPlayFragment.b0 != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.H0;
                        VideoPlayFragment videoPlayFragment2 = this.b.a;
                        VideoItemData videoItemData = videoPlayFragment2.b0;
                        forumManageModel.V(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.A0, null, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements nu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nu4 a;

            public b(l0 l0Var, nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var, nu4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nu4Var;
            }

            @Override // com.baidu.tieba.nu4.e
            public void onClick(nu4 nu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                    this.a.dismiss();
                }
            }
        }

        public l0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.yu4.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.dismiss();
                nu4 nu4Var = new nu4(this.a.getActivity());
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    nu4Var.setMessageId(R.string.obfuscated_res_0x7f0f04af);
                } else {
                    nu4Var.setMessageId(R.string.obfuscated_res_0x7f0f04ae);
                }
                nu4Var.setPositiveButton(R.string.dialog_ok, new a(this, nu4Var));
                nu4Var.setNegativeButton(R.string.dialog_cancel, new b(this, nu4Var));
                nu4Var.setCancelable(true);
                nu4Var.create(this.a.getPageContext());
                nu4Var.show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public m(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == this.a.o.getId()) {
                    this.a.S4();
                } else if (view2.getId() == this.a.n.getId()) {
                    VideoItemData videoItemData = this.a.b0;
                    if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.a.b0.thread_id));
                    }
                    this.a.getActivity().finish();
                } else if (view2.getId() == this.a.L.getId()) {
                    this.a.P3();
                    this.a.I3(7);
                } else if (view2.getId() == this.a.y.getId()) {
                    if (AntiHelper.c(this.a.getPageContext(), this.a.b0)) {
                        return;
                    }
                    this.a.P3();
                    StatisticItem statisticItem = new StatisticItem("c12796");
                    statisticItem.param("tid", this.a.b0.thread_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                    this.a.I3(2);
                } else if (view2.getId() != this.a.Z.getId()) {
                    if (view2.getId() != this.a.d0.getId()) {
                        if (view2.getId() == this.a.t0.getId()) {
                            VideoPlayFragment videoPlayFragment = this.a;
                            if (videoPlayFragment.B3(videoPlayFragment.getPageContext(), 25066)) {
                                this.a.V4();
                                if (this.a.b0 != null) {
                                    StatisticItem statisticItem2 = new StatisticItem("c13025");
                                    statisticItem2.param("tid", this.a.b0.thread_id);
                                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem2.param("fid", this.a.b0.forum_id);
                                    TiebaStatic.log(statisticItem2);
                                }
                                if (this.a.j != null) {
                                    this.a.j.O("c14475");
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    String q = ox4.k().q("nani_key_download_link_url", null);
                    if (TextUtils.isEmpty(q)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) w9.a(this.a.getPageContext().getPageActivity()), new String[]{q}, true);
                } else {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    VideoItemData videoItemData2 = videoPlayFragment2.b0;
                    if (videoItemData2 == null || videoItemData2.act_info == null) {
                        return;
                    }
                    yo4.n(videoPlayFragment2.getActivity(), this.a.b0.act_info.link_url);
                    StatisticItem statisticItem3 = new StatisticItem("c12799");
                    statisticItem3.param("tid", this.a.b0.thread_id);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem3);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public m0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.b0.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public n(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.F3(videoPlayFragment.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ VideoPlayFragment b;

        public n0(VideoPlayFragment videoPlayFragment, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoPlayFragment;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.b.getContext()).createNormalCfg(this.a, "")));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public o(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.W4();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.a.b0.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.a.I3(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.a.b0.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.a.b0.nid);
                BaijiahaoData baijiahaoData = this.a.b0.baijiahaoData;
                if (baijiahaoData != null && !dj.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.a.b0.baijiahaoData.oriUgcVid);
                }
                if (this.a.b0.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.a.b0.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.a.b0.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.a.b0.mRecomSource);
                statisticItem2.param("ab_tag", this.a.b0.mRecomAbTag);
                statisticItem2.param("weight", this.a.b0.mRecomWeight);
                statisticItem2.param("extra", this.a.b0.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (tc5.j(this.a.getBaseFragmentActivity()) != null && tc5.j(this.a.getBaseFragmentActivity()).b() != null && tc5.j(this.a.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(tc5.j(this.a.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.g1 == null) {
                return;
            }
            this.a.g1.q(TiePlusStat.StatType.CLICK);
            this.a.e1.n(this.a.g1);
            this.a.e1.l(this.a.g1);
        }
    }

    /* loaded from: classes6.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public p(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                if (this.a.V != null && (videoItemData = (videoPlayFragment = this.a).b0) != null && videoItemData.author_info != null && videoPlayFragment.s != null) {
                    n25 n25Var = videoPlayFragment.J0;
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    UserItemData userItemData = videoPlayFragment2.b0.author_info;
                    String str = userItemData.portrait;
                    String str2 = userItemData.user_id;
                    BdUniqueId bdUniqueId = videoPlayFragment2.K0;
                    VideoItemData videoItemData2 = this.a.b0;
                    n25Var.m(true, str, str2, false, "6", bdUniqueId, videoItemData2.forum_id, "0", videoItemData2.thread_id);
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.b0.author_info.is_follow = "1";
                    videoPlayFragment3.w3();
                    this.a.V.setVisibility(8);
                    this.a.o4();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.a.a != 3 && this.a.a != 4) {
                    statisticItem.param("obj_locate", 2);
                    if (this.a.a != 7) {
                        statisticItem.param("obj_source", this.a.N3());
                    } else {
                        statisticItem.param("obj_source", 8);
                    }
                } else {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.a.b0.thread_id);
                statisticItem.param("fid", this.a.b0.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.a.I3(6);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.a.b0.author_info.user_id.equals(data.c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.a.K0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.a) {
                    if (!z || "0".equals(this.a.b0.author_info.is_follow)) {
                        return;
                    }
                    ej.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f02b9);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.b0.author_info.is_follow = "0";
                    videoPlayFragment.w3();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.b0.author_info.is_follow = "0";
                    videoPlayFragment2.w3();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.a.b0));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.b0.author_info.is_follow = "1";
                    videoPlayFragment3.w3();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.a.D0)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public q(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.a.l == null) {
                return;
            }
            this.a.l.setVisibility(8);
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

    /* loaded from: classes6.dex */
    public class q0 implements Runnable {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.Q0) {
                return;
            }
            this.a.y3(true);
        }
    }

    /* loaded from: classes6.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ r a;

            public a(r rVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {rVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = rVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.i0 = true;
                    if (this.a.a.v0 != null) {
                        this.a.a.v0.addRule(14);
                    }
                }
            }
        }

        public r(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams L3 = this.a.L3();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.Y4(videoPlayFragment.i, this.a.l, this.a.y0, L3.leftMargin, this.a.z0, L3.topMargin, this.a.w0, L3.width, this.a.x0, L3.height, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ RelativeLayout.LayoutParams g;
        public final /* synthetic */ int h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ int k;
        public final /* synthetic */ int l;
        public final /* synthetic */ int m;
        public final /* synthetic */ int n;
        public final /* synthetic */ int o;
        public final /* synthetic */ int p;
        public final /* synthetic */ View q;
        public final /* synthetic */ View r;
        public final /* synthetic */ VideoPlayFragment s;

        public r0(VideoPlayFragment videoPlayFragment, int i, int i2, int i3, int i4, int i5, int i6, RelativeLayout.LayoutParams layoutParams, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), layoutParams, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), view2, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i16 = newInitContext.flag;
                if ((i16 & 1) != 0) {
                    int i17 = i16 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.s = videoPlayFragment;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = layoutParams;
            this.h = i7;
            this.i = i8;
            this.j = i9;
            this.k = i10;
            this.l = i11;
            this.m = i12;
            this.n = i13;
            this.o = i14;
            this.p = i15;
            this.q = view2;
            this.r = view3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f;
            boolean z;
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = (int) (this.a * animatedFraction);
                int i2 = (int) (this.b * animatedFraction);
                int i3 = this.c;
                int i4 = i3 > this.d ? i3 - i : i3 + i;
                int i5 = this.e;
                this.g.topMargin = i5 > this.f ? i5 - i2 : i5 + i2;
                this.s.v0.topMargin = i4;
                int i6 = (int) (this.h * animatedFraction);
                int i7 = this.i;
                int i8 = i7 > this.j ? i7 - i6 : i7 + i6;
                this.s.v0.leftMargin = i8;
                this.s.v0.rightMargin = i8;
                RelativeLayout.LayoutParams layoutParams = this.g;
                layoutParams.leftMargin = i8;
                layoutParams.rightMargin = i8;
                float f3 = this.k * animatedFraction;
                float f4 = this.l * animatedFraction;
                int i9 = this.m;
                float f5 = i9 > this.n ? i9 - f3 : i9 + f3;
                int i10 = this.o;
                if (i10 > this.p) {
                    f = i10 - f4;
                    f2 = 1.0f - animatedFraction;
                    z = false;
                } else {
                    f = i10 + f4;
                    z = true;
                    f2 = animatedFraction;
                }
                this.s.v0.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.s.v0.height = (int) f5;
                RelativeLayout.LayoutParams layoutParams2 = this.g;
                layoutParams2.height = (int) f;
                layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.q.setLayoutParams(this.g);
                this.q.setAlpha(f2);
                if (z && f2 > 0.5f) {
                    this.s.z4((f2 - 0.5f) * 2.0f);
                } else if (!z && animatedFraction < 0.25f) {
                    this.s.z4(1.0f - (animatedFraction * 4.0f));
                }
                this.r.setLayoutParams(this.s.v0);
                this.r.requestLayout();
                this.q.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = sVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    this.a.a.c1.setBackground(null);
                    this.a.a.c1.setVisibility(8);
                    this.a.a.i0 = true;
                    if (this.a.a.v0 != null) {
                        this.a.a.v0.addRule(14);
                    }
                    this.a.a.A4(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.a.f.setBackground(null);
                    super.onAnimationStart(animator);
                    this.a.a.c1.setVisibility(0);
                    if (this.a.a.l != null) {
                        this.a.a.l.setVisibility(8);
                    }
                    this.a.a.c1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                }
            }
        }

        public s(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = ej.i(this.a.f.getContext());
                RelativeLayout.LayoutParams L3 = this.a.L3();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.V3(videoPlayFragment.i, this.a.l, this.a.c1, this.a.y0, L3.leftMargin, this.a.z0, L3.topMargin, this.a.w0, L3.width, this.a.x0, L3.height, this.a.x0, i, this.a.z0, 0, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;
        public final /* synthetic */ int i;
        public final /* synthetic */ View j;
        public final /* synthetic */ View k;
        public final /* synthetic */ VideoPlayFragment l;

        public s0(VideoPlayFragment videoPlayFragment, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), view2, view3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i10 = newInitContext.flag;
                if ((i10 & 1) != 0) {
                    int i11 = i10 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = videoPlayFragment;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
            this.j = view2;
            this.k = view3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = (int) (this.a * animatedFraction);
                int i2 = this.b;
                this.l.v0.topMargin = i2 > this.c ? i2 - i : i2 + i;
                int i3 = (int) (this.d * animatedFraction);
                int i4 = this.e;
                int i5 = i4 > this.f ? i4 - i3 : i4 + i3;
                this.l.v0.leftMargin = i5;
                this.l.v0.rightMargin = i5;
                float f = animatedFraction * this.g;
                int i6 = this.h;
                float f2 = i6 > this.i ? i6 - f : i6 + f;
                this.l.v0.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.l.v0.height = (int) f2;
                this.j.setLayoutParams(this.l.v0);
                this.k.setLayoutParams(this.l.v0);
                this.j.requestLayout();
                this.k.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements vx8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public t(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.vx8.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.j == null || this.a.k == null) {
                return;
            }
            if (!z || !this.a.isResumed()) {
                this.a.j.R();
                this.a.j.H();
            } else {
                this.a.j.Z();
                if (this.a.i.getControl().isPlaying()) {
                    this.a.j.U();
                } else {
                    this.a.j.R();
                }
            }
            this.a.k.j(z);
        }
    }

    /* loaded from: classes6.dex */
    public class t0 implements View.OnClickListener {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.h.removeView(this.a.i);
                this.a.Z0.U();
                VideoPlayFragment videoPlayFragment = this.a;
                VideoItemData videoItemData = videoPlayFragment.b0;
                if (videoItemData != null) {
                    videoPlayFragment.a5(videoItemData.thread_id, false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final zh5<String> a;
        public final /* synthetic */ VideoPlayFragment b;

        public u(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = videoPlayFragment;
            this.a = new zh5<>(300, TimeUnit.MILLISECONDS);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.a.a("onTouchDownEvent")) {
                    return super.onDoubleTap(motionEvent);
                }
                this.b.j0(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.b.c5()) {
                    this.a.a("onTouchDownEvent");
                }
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                if (!this.a.a("onTouchDownEvent")) {
                    return super.onFling(motionEvent, motionEvent2, f, f2);
                }
                if (motionEvent.getX() - motionEvent2.getX() > 50.0f) {
                    this.b.onViewDragToRight();
                    this.b.f.cancelLongPress();
                    return true;
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.b.f.cancelLongPress();
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
                if (!this.a.a("onTouchDownEvent")) {
                    return super.onSingleTapConfirmed(motionEvent);
                }
                this.b.onViewClick();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class u0 implements fb8 {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.fb8
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.fb8
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public boolean onBackground(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            }
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a.i == null || this.a.i.getControl() == null) {
                return;
            }
            this.a.i.getControl().H();
            this.a.i.getControl().seekTo(0);
            if (UbsABTestHelper.isAutoPlayNextVideo() && (this.a.a == 1 || this.a.a == 2)) {
                if (this.a.Y0 == null || this.a.R0) {
                    this.a.i.getControl().start();
                } else {
                    this.a.Y0.a();
                    this.a.l.setVisibility(8);
                    this.a.i.getControl().start();
                }
            } else if (!UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.a.i.getControl().start();
            }
            this.a.r4();
            VideoPlayFragment.j3(this.a);
            if (this.a.T0 == 3) {
                this.a.z3();
            }
            if (this.a.R0) {
                return;
            }
            if (this.a.isResumed() && this.a.f0) {
                return;
            }
            this.a.n4();
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i, i2, obj)) == null) {
                if (this.a.f0 && ((i == 3 || i == 904) && this.a.l.getVisibility() == 0)) {
                    this.a.l.clearAnimation();
                    this.a.l.startAnimation(this.a.g0);
                }
                if (i != 10012 || this.a.V0 == null) {
                    return true;
                }
                this.a.V0.c();
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.a.i == null || this.a.i.getControl() == null) {
                return;
            }
            if (this.a.e0 != null) {
                this.a.e0.setVisibility(0);
                if (this.a.e0.getCurProgress() == 0) {
                    this.a.e0.p();
                    return;
                }
                return;
            }
            this.a.e0.setVisibility(8);
        }

        @Override // com.baidu.tieba.fb8
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

        @Override // com.baidu.tieba.fb8
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.fb8
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setStatistic(ab8 ab8Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, ab8Var) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.fb8
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.i == null || this.a.i.getControl() == null) {
                return;
            }
            VideoPlayFragment videoPlayFragment = this.a;
            if (videoPlayFragment.b0 != null) {
                videoPlayFragment.i.getControl().setVideoPath(this.a.L0, this.a.b0.thread_id);
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.i == null || this.a.i.getControl() == null) {
                return;
            }
            this.a.i.a();
            this.a.i.getControl().setStageType("2005");
            this.a.i.getControl().setLocateSource("v_mid_page");
            this.a.i.getControl().setContinuePlayEnable(true);
            if (this.a.v0 != null) {
                this.a.l.setLayoutParams(this.a.v0);
                if (this.a.h != null && this.a.i != null) {
                    this.a.h.addView(this.a.i, 0, this.a.v0);
                }
            } else {
                this.a.G4();
            }
            this.a.H4();
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ VideoPlayFragment c;

        public v0(VideoPlayFragment videoPlayFragment, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoPlayFragment;
            this.a = z;
            this.b = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.b1 != null) {
                    this.c.b1.dismiss();
                }
                if (BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    ForumManageModel forumManageModel = this.c.H0;
                    VideoItemData videoItemData = this.c.b0;
                    forumManageModel.V(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.a, null, this.b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    return;
                }
                ej.M(this.c.getContext(), R.string.obfuscated_res_0x7f0f0c59);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w implements VideoDanmuController.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ThreadData a;
            public final /* synthetic */ w b;

            public a(w wVar, ThreadData threadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {wVar, threadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = wVar;
                this.a = threadData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.b.a.getContext() == null) {
                    return;
                }
                this.b.a.b0.parseProto(this.a);
                this.b.a.b0.reGenerateTitle();
                VideoPlayFragment videoPlayFragment = this.b.a;
                videoPlayFragment.b0.threadData = this.a;
                videoPlayFragment.F4();
                this.b.a.G4();
                VideoItemData videoItemData = this.b.a.b0;
                if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
                    return;
                }
                VideoPlayFragment videoPlayFragment2 = this.b.a;
                videoPlayFragment2.I4(videoPlayFragment2.b0, videoPlayFragment2.Z0, this.b.a.j);
                VideoPlayFragment videoPlayFragment3 = this.b.a;
                videoPlayFragment3.J4(videoPlayFragment3.b0.video_url);
                if (this.b.a.b0.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.b.a.b0.author_info.user_id)) {
                    this.b.a.A0 = true;
                }
                this.b.a.A3();
                VideoPlayFragment videoPlayFragment4 = this.b.a;
                videoPlayFragment4.setUserVisibleHint(videoPlayFragment4.f0);
            }
        }

        public w(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.videoplay.danmu.VideoDanmuController.c
        public boolean a(@Nullable ThreadData threadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
                gh.a().post(new a(this, threadData));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public w0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.b1 == null) {
                return;
            }
            this.a.b1.dismiss();
        }
    }

    /* loaded from: classes6.dex */
    public class x implements wy8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy8 a;
        public final /* synthetic */ VideoDanmuController b;
        public final /* synthetic */ VideoPlayFragment c;

        public x(VideoPlayFragment videoPlayFragment, wy8 wy8Var, VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, wy8Var, videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = videoPlayFragment;
            this.a = wy8Var;
            this.b = videoDanmuController;
        }

        @Override // com.baidu.tieba.wy8.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.stopPlay();
                    this.c.startPlay();
                    VideoDanmuController videoDanmuController = this.b;
                    if (videoDanmuController != null) {
                        videoDanmuController.b0(this.a.D0());
                        return;
                    }
                    return;
                }
                wy8 wy8Var = this.a;
                if (wy8Var != null) {
                    VideoDanmuController videoDanmuController2 = this.b;
                    if (videoDanmuController2 != null) {
                        wy8Var.I0(videoDanmuController2.F());
                    }
                    if (UbsABTestHelper.isFeedVideoImmersionTransition() && !this.c.c4() && this.c.h0 != null && this.c.L0 != null) {
                        TbVideoViewSet.c().e(this.c.L0);
                    }
                    this.c.n4();
                    this.a.n0(true);
                    this.a.startPlay();
                    VideoDanmuController videoDanmuController3 = this.b;
                    if (videoDanmuController3 != null) {
                        videoDanmuController3.R();
                        this.b.S();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public x0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                this.a.v0.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.i.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements zx8.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public y(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.zx8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.j == null) {
                return;
            }
            this.a.j.V(str);
        }
    }

    /* loaded from: classes6.dex */
    public class y0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y0(VideoPlayFragment videoPlayFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.a.isResumed() && this.a.f0) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    if (this.a.T4()) {
                        return;
                    }
                    this.a.startPlay();
                    return;
                }
                ej.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0c59);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z implements yx8.d {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.yx8.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    this.a.t0.setVisibility(0);
                } else {
                    this.a.t0.setVisibility(8);
                }
                if (z) {
                    this.a.C3("");
                    if (this.a.j != null) {
                        this.a.j.O("c14476");
                    }
                } else {
                    this.a.C3(((ay8) this.a.W0.a().n(28)).g().getText().toString());
                }
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData != null && z) {
                    long g = dh.g(videoItemData.comment_num, 0L) + 1;
                    this.a.b0.comment_num = String.valueOf(g);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.D4(g, videoPlayFragment.Q);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
                this.a.u3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public z0(VideoPlayFragment videoPlayFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPlayFragment;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                this.a.v0.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.a.i.requestLayout();
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
        this.d = 0;
        this.e = 1;
        this.t = false;
        this.i0 = false;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = BdUniqueId.gen();
        this.M0 = false;
        this.O0 = OnStatusChangedListener.VideoStatus.INIT;
        this.S0 = false;
        this.T0 = 1;
        this.U0 = -1;
        this.f1 = false;
        this.h1 = true;
        this.k1 = false;
        this.l1 = null;
        this.m1 = null;
        this.o1 = false;
        this.q1 = -1;
        this.r1 = new k(this);
        this.s1 = new v(this);
        this.t1 = new g0(this, 2921607);
        this.u1 = new p0(this, 2001115);
        this.v1 = new y0(this, 2000994);
        this.w1 = new e1(this, 2016528);
        this.x1 = new f1(this, 2921594);
        this.y1 = new g1(this, 2001011);
        this.z1 = new h1(this, 2921596);
        this.A1 = new a(this, 2921598);
        this.B1 = new b(this, 2921612);
        this.C1 = new BarManageResultListener(new c(this));
        this.D1 = new d(this, 2921645);
        this.E1 = new e(this);
        this.F1 = new f(this);
        this.G1 = new g(this);
        this.H1 = new h(this);
        this.I1 = new i(this);
        this.J1 = new j(this);
        this.K1 = new l(this);
        this.L1 = new m(this);
        this.M1 = new n(this);
        this.N1 = new o(this);
        this.O1 = new p(this);
        this.P1 = new q(this);
        this.Q1 = new r(this);
        this.R1 = new s(this);
        this.S1 = new t(this);
        this.T1 = new GestureDetectorCompat(getContext(), new u(this));
        this.U1 = new w(this);
        this.V1 = new a0(this);
        this.W1 = new h0(this);
        this.X1 = new i0(this);
        this.Y1 = new j0(this);
        this.Z1 = new k0(this);
        this.a2 = new l0(this);
        this.b2 = new q0(this);
        this.c2 = new u0(this);
        this.d2 = new a1(this, 2921603);
        this.e2 = new b1(this, 2921635);
    }

    public static /* synthetic */ int j3(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.T0;
        videoPlayFragment.T0 = i2 + 1;
        return i2;
    }

    public final void A3() {
        VideoItemData videoItemData;
        String forum_name;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoItemData = this.b0) == null) {
            return;
        }
        this.l.K(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.b0.getTitle();
        boolean z2 = dh.e(this.b0.video_height, 0) <= dh.e(this.b0.video_width, 0);
        if (TextUtils.isEmpty(title) && (!z2 || this.b0.video_duration < 60)) {
            this.P.setVisibility(8);
        } else {
            if (this.b0.video_duration >= 60) {
                this.N.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(ej.f(getContext(), R.dimen.tbds31), ej.f(getContext(), R.dimen.tbds31));
                }
                layoutParams.width = ej.f(getContext(), R.dimen.tbds3);
                layoutParams.height = ej.f(getContext(), R.dimen.tbds34);
                this.O.setLayoutParams(layoutParams);
                this.O.setBackgroundColor(getResources().getColor(R.color.CAM_X0618));
                int i2 = this.b0.video_duration;
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
                hv4 d2 = hv4.d(this.M);
                d2.z(R.dimen.T_X08);
                d2.v(R.color.CAM_X0618);
                d2.A(R.string.F_X02);
                this.M.setText(sb.toString());
            } else {
                this.N.setVisibility(8);
            }
            this.P.setVisibility(0);
            this.L.setTextSize(ej.f(getContext(), R.dimen.T_X07));
            this.L.setTextColor(R.color.CAM_X0621);
            this.L.setLineSpacingExtra(ej.f(getContext(), R.dimen.tbds10));
            this.L.setExpandable(false);
            this.L.setTextMaxLine(3);
            this.L.setLimitLine(3);
            this.L.setOnStatusChangedListener(new m0(this));
            ExpandableTextView expandableTextView = this.L;
            VideoItemData videoItemData2 = this.b0;
            expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        D4(dh.g(this.b0.comment_num, 0L), this.Q);
        D4(dh.g(this.b0.agree_num, 0L), this.R);
        if (g4()) {
            this.S.setText(R.string.obfuscated_res_0x7f0f0afd);
        } else {
            D4(dh.g(this.b0.share_num, 0L), this.S);
        }
        UserItemData userItemData = this.b0.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.b0.author_info.portrait.startsWith("http")) {
                this.q.K(this.b0.author_info.portrait, 10, false);
            } else {
                this.q.K(this.b0.author_info.portrait, 12, false);
            }
            if (i4() && !TextUtils.isEmpty(this.b0.author_info.auth)) {
                this.q.setShowV(true);
                this.q.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
            } else {
                this.q.setShowV(false);
                this.q.setOriginatorResId(0);
            }
            if (StringUtils.isNull(this.b0.author_info.getUserShowName())) {
                this.s0.setVisibility(8);
            } else {
                this.s0.setVisibility(0);
                this.s0.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.b0.author_info.getUserShowName(), 16, StringHelper.STRING_MORE));
            }
        }
        AlaInfoData alaInfoData = this.b0.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            S3(this.b0.mAlaInfoData.live_status == 1);
            R3();
        }
        if ("1".equals(this.b0.is_private) && this.d0.getVisibility() != 0) {
            this.a0.setVisibility(0);
        } else {
            this.a0.setVisibility(8);
        }
        if ("1".equals(this.b0.is_agreed)) {
            this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08084a, WebPManager.ResourceStateType.NORMAL));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.j0, Key.SCALE_X, 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.j0, Key.SCALE_Y, 1.3f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat2.setDuration(300L);
            ofFloat.start();
            ofFloat2.start();
        } else {
            this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080848, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.b0.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.d0.getVisibility() != 0) {
            this.Z.setVisibility(8);
            this.W.setText(this.b0.act_info.activity_name);
        } else {
            this.Z.setVisibility(8);
        }
        w3();
        boolean X3 = X3();
        if (this.a == 7) {
            this.E.setVisibility(8);
        } else if (X3) {
        } else {
            if (!TextUtils.isEmpty(this.b0.forum_name)) {
                forum_name = this.b0.forum_name;
            } else {
                ThreadData threadData = this.b0.threadData;
                forum_name = (threadData == null || TextUtils.isEmpty(threadData.getForum_name())) ? null : this.b0.threadData.getForum_name();
            }
            if (TextUtils.isEmpty(forum_name)) {
                return;
            }
            this.E.setVisibility(0);
            WebPManager.setPureDrawable(this.J, R.drawable.obfuscated_res_0x7f080928, R.color.CAM_X0101, null);
            this.J.setVisibility(0);
            this.I.setVisibility(8);
            String b5 = b5(forum_name);
            this.C0 = b5;
            this.K.setText(b5);
            ThreadData threadData2 = this.b0.threadData;
            if (threadData2 != null && !TextUtils.isEmpty(threadData2.getRecomReason())) {
                TextView textView = this.K;
                textView.setText(this.C0 + getActivity().getResources().getString(R.string.obfuscated_res_0x7f0f1551));
            }
            this.E.setOnClickListener(new n0(this, forum_name));
        }
    }

    public final void A4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            N4(this.u, i2);
            N4(this.y, i2);
            N4(this.x, i2);
            N4(this.w, i2);
            View view2 = this.i1;
            if (view2 != null) {
                view2.setVisibility(i2);
            }
            View view3 = this.j1;
            if (view3 != null) {
                view3.setVisibility(i2);
            }
            View view4 = this.m;
            if (view4 != null) {
                view4.setVisibility(i2);
            }
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null) {
                boolean z2 = dh.e(videoItemData.video_height, 0) <= dh.e(this.b0.video_width, 0);
                if (this.b0.video_duration >= 60 && z2) {
                    N4(this.g, i2);
                } else {
                    N4(this.g, 8);
                }
            }
        }
    }

    public final boolean B3(TbPageContext<?> tbPageContext, int i2) {
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

    public void B4(na8.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.X0 = cVar;
        }
    }

    public final void C3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.u0.setText(R.string.obfuscated_res_0x7f0f1009);
                DanmuPostDraftManager.b.a().c(this.b0.thread_id);
                return;
            }
            this.u0.setText(R.string.obfuscated_res_0x7f0f0525);
            DanmuPostDraftManager.b.a().d(this.b0.thread_id, str);
        }
    }

    public final void C4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.B.setVisibility(0);
            if (this.l1 == null) {
                this.l1 = O3(0.0f, 3.0f, 3.0f, 0L);
            }
            this.l1.addListener(new c1(this));
            this.l1.start();
        }
    }

    @Override // com.baidu.tieba.vy8
    public VideoItemModel D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.c0 : (VideoItemModel) invokeV.objValue;
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if ((this.i.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof ua8)) {
                this.i.getControl().O();
                ((ua8) this.i.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
            }
            TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921683, this.L0));
        }
    }

    public final void D4(long j2, TextView textView) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, textView) == null) || textView == null) {
            return;
        }
        String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(j2);
        if (!"0".equals(numberUniformFormatExtraWithRoundVote)) {
            textView.setText(numberUniformFormatExtraWithRoundVote);
            return;
        }
        if (textView.getId() == R.id.obfuscated_res_0x7f09015d) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1542);
        } else if (textView.getId() == R.id.obfuscated_res_0x7f090688) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1543);
        } else {
            string = textView.getId() == R.id.obfuscated_res_0x7f091e96 ? TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1545) : "";
        }
        textView.setText(string);
    }

    public void E3() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (alertDialog = this.b1) != null && alertDialog.isShowing()) {
            this.b1.dismiss();
        }
    }

    public final void E4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.q.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.width = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams.height = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.height = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
            }
        }
    }

    public final void F3(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.b0) != null) {
            int i3 = 0;
            if (i2 == this.d) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.b0;
                    videoItemData2.agree_num = String.valueOf(dh.e(videoItemData2.agree_num, 0) - 1);
                    this.b0.is_agreed = "0";
                    i3 = 1;
                } else {
                    VideoItemData videoItemData3 = this.b0;
                    videoItemData3.agree_num = String.valueOf(dh.e(videoItemData3.agree_num, 0) + 1);
                    this.b0.is_agreed = "1";
                    I3(1);
                }
            } else {
                videoItemData.agree_num = String.valueOf(dh.e(videoItemData.agree_num, 0) + 1);
                this.b0.is_agreed = "1";
                I3(1);
            }
            StatisticItem statisticItem = new StatisticItem("c12795");
            statisticItem.param("tid", this.b0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.d) {
                statisticItem.param("obj_type", i3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c12003");
            statisticItem2.param("tid", this.b0.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.d) {
                statisticItem2.param("obj_type", i3);
            } else {
                statisticItem2.param("obj_type", 2);
            }
            if ("index".equals(this.D0)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            oc5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                if (i2 == this.d) {
                    statisticItem3.param("obj_type", i3);
                } else {
                    statisticItem3.param("obj_type", 2);
                }
                int i4 = this.a;
                if (i4 != 3 && i4 != 4) {
                    statisticItem3.param("obj_locate", 2);
                } else {
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("obj_source", N3());
                }
                statisticItem3.param("tid", this.b0.thread_id);
                statisticItem3.param("fid", this.b0.forum_id);
                int i5 = this.a;
                if (i5 == 3) {
                    statisticItem3.param("obj_param1", 1);
                } else if (i5 == 4) {
                    statisticItem3.param("obj_param1", 2);
                } else if (i5 == 7) {
                    statisticItem3.param("obj_param1", 3);
                }
                TiebaStatic.log(statisticItem3);
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
            }
            TiebaStatic.log(statisticItem2);
            A3();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.b0.thread_id);
            httpMessage.addParam("op_type", i3);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            BaijiahaoData baijiahaoData = this.b0.baijiahaoData;
            if (baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.b0.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.b0.baijiahaoData.oriUgcVid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.b0.baijiahaoData.oriUgcType);
            }
            if (currentVisiblePageExtra != null) {
                httpMessage.addParam("obj_source", currentVisiblePageExtra.a());
            }
            sendMessage(httpMessage);
            an8 an8Var = new an8();
            AgreeData agreeData = new AgreeData();
            String str = this.b0.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.b0.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.b0.is_agreed);
            an8Var.b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, an8Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.b0));
            if (this.M0) {
                return;
            }
            FirstPraiseToast.getInstance().show();
        }
    }

    public void F4() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (videoItemData = this.b0) == null) {
            return;
        }
        int e2 = dh.e(videoItemData.video_height, 0);
        int e3 = dh.e(this.b0.video_width, 0);
        int K3 = K3();
        int k2 = ej.k(this.f.getContext());
        if (e2 <= 0 || e3 <= 0 || K3 <= 0 || k2 <= 0) {
            this.i.getControl().setVideoScalingMode(2);
            this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        float f2 = (e2 * 1.0f) / e3;
        if (f2 > 1.0f) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
            this.N0 = layoutParams;
            layoutParams.removeRule(13);
            this.N0.addRule(14);
            this.N0.topMargin = (K3 - ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
            this.N0 = layoutParams2;
            layoutParams2.removeRule(13);
            this.N0.addRule(14);
            this.N0.topMargin = (K3 - ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
        }
        if (f2 > 1.34f) {
            this.i.getControl().setVideoScalingMode(0);
            this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        this.i.getControl().setVideoScalingMode(2);
        this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public final void G3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) {
            if (z2) {
                v4(8);
                this.v.setVisibility(0);
                return;
            }
            v4(0);
            this.v.setVisibility(8);
        }
    }

    public void G4() {
        TbVideoViewContainer tbVideoViewContainer;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        TbVideoViewContainer tbVideoViewContainer2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getParent() == null) {
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null && TextUtils.isEmpty(videoItemData.video_height) && TextUtils.isEmpty(this.b0.video_width)) {
                return;
            }
            if (this.b0 != null) {
                this.v0 = new RelativeLayout.LayoutParams(-1, -1);
                F4();
                Rect rect = this.h0;
                if (rect != null && !this.i0) {
                    int i2 = rect.right;
                    int i3 = rect.left;
                    this.w0 = i2 - i3;
                    int i4 = rect.bottom;
                    int i5 = rect.top;
                    this.x0 = i4 - i5;
                    RelativeLayout.LayoutParams layoutParams = this.v0;
                    layoutParams.width = i2 - i3;
                    layoutParams.height = i4 - i5;
                    layoutParams.topMargin = i5;
                    layoutParams.leftMargin = i3;
                    layoutParams.rightMargin = i3;
                } else {
                    this.v0 = L3();
                }
                int i6 = this.a;
                if (i6 != 4 && i6 != 3) {
                    this.v0.bottomMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
                } else {
                    this.v0.bottomMargin = ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                }
                this.l.setLayoutParams(this.v0);
                if (this.h != null && (tbVideoViewContainer2 = this.i) != null) {
                    tbVideoViewContainer2.setId(R.id.obfuscated_res_0x7f092517);
                    if (b4() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                        this.v0.addRule(15);
                    }
                    this.h.addView(this.i, 0, this.v0);
                }
                boolean z2 = dh.e(this.b0.video_height, 0) <= dh.e(this.b0.video_width, 0);
                if (this.b0.video_duration >= 60 && z2) {
                    View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d08d2, (ViewGroup) null);
                    this.g = inflate;
                    EMTextView eMTextView = (EMTextView) this.g.findViewById(R.id.obfuscated_res_0x7f090c2e);
                    WebPManager.setPureDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c2d), R.drawable.obfuscated_res_0x7f080a33, R.color.CAM_X0101, null);
                    eMTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0102));
                    eMTextView.setText(getString(R.string.obfuscated_res_0x7f0f1535));
                    eMTextView.setGravity(17);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(3, R.id.obfuscated_res_0x7f092517);
                    layoutParams2.addRule(14, -1);
                    layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.h.addView(this.g, layoutParams2);
                    a5(this.b0.thread_id, true);
                    if (UbsABTestHelper.isFeedVideoImmersionTransition() && !c4()) {
                        this.g.setVisibility(8);
                    } else {
                        this.g.setVisibility(0);
                    }
                    this.g.setOnClickListener(new t0(this));
                }
            }
            if (this.b0 != null) {
                ab8 ab8Var = new ab8();
                ab8Var.e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData2 = this.b0;
                ab8Var.c = videoItemData2.thread_id;
                ab8Var.t = videoItemData2.nid;
                ab8Var.d = videoItemData2.forum_id;
                ab8Var.m = videoItemData2.mMd5;
                ab8Var.k = "";
                ab8Var.f = videoItemData2.mRecomSource;
                ab8Var.l = videoItemData2.mRecomAbTag;
                ab8Var.j = 1;
                ab8Var.x = videoItemData2.getChannelMidRequestNum();
                ab8Var.y = this.b0.getChannelMidRequestVideoNum();
                BaijiahaoData baijiahaoData = this.b0.baijiahaoData;
                if (baijiahaoData != null) {
                    int i7 = baijiahaoData.oriUgcType;
                    if (i7 == 2) {
                        ab8Var.j = 3;
                    } else if (i7 == 4) {
                        ab8Var.j = 2;
                    }
                }
                ab8Var.h = this.b0.mRecomWeight;
                if (this.h0 != null) {
                    ab8Var.n = "1";
                } else {
                    ab8Var.n = "2";
                }
                int i8 = this.a;
                if (i8 == 1) {
                    ab8Var.p = "1";
                    ab8Var.a = "13";
                    ab8Var.i = this.D0;
                    ab8Var.k = this.P0;
                    ab8Var.g = this.b0.mRecomWeight;
                } else if (i8 == 2) {
                    ab8Var.a = "24";
                } else {
                    ab8Var.a = "13";
                }
                ab8Var.p = "1";
                int i9 = this.a;
                if (i9 == 3) {
                    ab8Var.a = "21";
                } else if (i9 == 4) {
                    ab8Var.a = "22";
                } else if (i9 == 7) {
                    ab8Var.a = "26";
                } else if (a4()) {
                    ab8Var.a = PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK;
                }
                String str = this.D0;
                ab8Var.i = str;
                String str2 = this.P0;
                ab8Var.k = str2;
                VideoItemData videoItemData3 = this.b0;
                String str3 = videoItemData3.mRecomWeight;
                ab8Var.g = str3;
                ab8Var.w = videoItemData3.mExtra;
                if (this.a == 5) {
                    ab8Var.a = "23";
                    ab8Var.p = "1";
                    ab8Var.i = str;
                    ab8Var.k = str2;
                    ab8Var.g = str3;
                }
                if (Y3() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    ab8Var.i = personalPageParams.getStatPageFromIdentifier();
                }
                this.i.getControl().setVideoStatData(ab8Var);
                this.i.getControl().setLocateSource("v_mid_page");
            }
            this.i.getControl().setContinuePlayEnable(true);
        }
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || this.b0 == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.b0.thread_id);
        statisticItem.param("nid", this.b0.nid);
        statisticItem.param("fid", this.b0.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.B0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", dj.isEmpty(this.b0.mRecomWeight) ? "0" : this.b0.mRecomWeight);
        statisticItem.param("extra", dj.isEmpty(this.b0.mRecomExtra) ? "0" : this.b0.mRecomExtra);
        statisticItem.param("obj_id", this.P0);
        statisticItem.param("ab_tag", dj.isEmpty(this.b0.mRecomAbTag) ? "0" : this.b0.mRecomAbTag);
        statisticItem.param("obj_source", dj.isEmpty(this.b0.mRecomSource) ? "0" : this.b0.mRecomSource);
        statisticItem.param("obj_type", this.D0);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.b0.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.b0.baijiahaoData.oriUgcVid);
            int i2 = this.b0.baijiahaoData.oriUgcType;
            if (i2 == 4) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        int i3 = this.a;
        if (i3 == 3 || i3 == 4) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.b0.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.D0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.E0);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void H4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.i.getControl().setVideoStatusChangeListener(this);
            this.i.getControl().setOperableVideoContainer(this.c2);
        }
    }

    public void I3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.b0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i3 = this.a;
            if (i3 != 3 && i3 != 4) {
                statisticItem.param("obj_locate", 2);
            } else {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("obj_type", i2);
            int i4 = this.a;
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

    public final void I4(VideoItemData videoItemData, wy8 wy8Var, VideoDanmuController videoDanmuController) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, videoItemData, wy8Var, videoDanmuController) == null) || wy8Var == null || wy8Var.getMainView() == null) {
            return;
        }
        wy8Var.G0(videoItemData);
        boolean z2 = false;
        boolean z3 = dh.e(videoItemData.video_height, 0) <= dh.e(videoItemData.video_width, 0);
        if (this.f0 && z3) {
            z2 = true;
        }
        wy8Var.X(z2);
        wy8Var.H0(new x(this, wy8Var, videoDanmuController));
        wy8Var.getMainView().setVisibility(8);
    }

    public String J3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void J4(String str) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, str) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null || str == null || str.equals(this.L0)) {
            return;
        }
        this.L0 = str;
    }

    public final int K3() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            int i3 = ej.i(this.f.getContext());
            if (k4()) {
                i2 = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            } else {
                i3 -= UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                i2 = VideoMiddleNiaiControllerView.u;
            }
            return i3 - i2;
        }
        return invokeV.intValue;
    }

    public final void K4(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i2) == null) || (relativeLayout = this.h) == null) {
            return;
        }
        relativeLayout.setPadding(0, 0, 0, i2);
    }

    public final RelativeLayout.LayoutParams L3() {
        InterceptResult invokeV;
        RelativeLayout.LayoutParams layoutParams;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int K3 = K3();
            int k2 = ej.k(this.f.getContext());
            if (UtilHelper.getRealScreenOrientation(this.f.getContext()) == 2) {
                layoutParams = new RelativeLayout.LayoutParams(K3, k2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(k2, K3);
            }
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && (videoItemData = this.b0) != null) {
                int e2 = dh.e(videoItemData.video_height, 0);
                int e3 = dh.e(this.b0.video_width, 0);
                if (e2 > 0 && e3 > 0 && K3 > 0 && k2 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(k2, K3);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.N0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.N0.addRule(14);
                        this.N0.topMargin = (K3 - ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                    } else {
                        float f3 = f2 * k2;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(k2, (int) f3);
                        int i2 = ((int) (K3 - f3)) / 2;
                        this.q1 = i2;
                        if (this.o1) {
                            layoutParams3.topMargin = i2 - UtilHelper.getStatusBarHeight();
                        } else {
                            layoutParams3.topMargin = i2;
                            this.q1 = -1;
                        }
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.N0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.N0.addRule(14);
                        this.N0.topMargin = (K3 - ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                        layoutParams = layoutParams3;
                    }
                    this.B.requestLayout();
                }
            }
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    public void L4(qy8 qy8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, qy8Var) == null) {
            this.V0 = qy8Var;
        }
    }

    public List<String> M3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public void M4(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, i1Var) == null) {
            this.Y0 = i1Var;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int N3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.D0)) {
                return 0;
            }
            String str = this.D0;
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

    public final void N4(View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048604, this, view2, i2) == null) || view2 == null) {
            return;
        }
        if (this.o1) {
            view2.setVisibility(8);
        } else {
            view2.setVisibility(i2);
        }
    }

    public final ObjectAnimator O3(float f2, float f3, float f4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.B, PropertyValuesHolder.ofFloat(Key.ALPHA, f2), PropertyValuesHolder.ofFloat(Key.SCALE_X, f3), PropertyValuesHolder.ofFloat(Key.SCALE_Y, f4));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public void O4(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            E3();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                i2 = z2 ? R.string.obfuscated_res_0x7f0f0b45 : R.string.obfuscated_res_0x7f0f0b47;
                i3 = R.string.obfuscated_res_0x7f0f0b46;
                i4 = R.string.obfuscated_res_0x7f0f1194;
            } else {
                i2 = R.string.obfuscated_res_0x7f0f04a9;
                i3 = R.string.obfuscated_res_0x7f0f04aa;
                i4 = R.string.obfuscated_res_0x7f0f04b0;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0375, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
            tBAlertBuilder.t(i2);
            tBAlertBuilder.k(i3);
            tBAlertBuilder.m(true);
            tBAlertBuilder.r(aVar2, aVar);
            tBAlertBuilder.h(false);
            this.b1 = tBAlertBuilder.w();
            aVar.a(new v0(this, z2, z3));
            aVar2.a(new w0(this));
        }
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            Q3(null, false);
        }
    }

    public void P4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.F0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.F0.k();
    }

    public final void Q3(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048609, this, str, z2) == null) || this.b0 == null) {
            return;
        }
        PbCommentFloatActivityConfig pbCommentFloatActivityConfig = new PbCommentFloatActivityConfig(getActivity());
        VideoItemData videoItemData = this.b0;
        PbCommentFloatActivityConfig createNormalCfg = pbCommentFloatActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.b0.forum_id));
        createNormalCfg.setForumName(this.b0.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.b0.baijiahaoData);
        int i2 = this.a;
        createNormalCfg.setFromPageType((i2 == 3 || i2 == 4) ? 1 : 2);
        createNormalCfg.setFromVideoPageType(this.a);
        createNormalCfg.setFromVideoPageUniqueId(this.c);
        createNormalCfg.setForceInterceptStimeStat(true);
        if (z2) {
            createNormalCfg.setHighLight3sPostId(str);
        } else {
            createNormalCfg.setHighLightPostId(str);
        }
        if (this.b0.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            if (this.b0.threadData.getAuthor() != null) {
                VideoItemData videoItemData2 = this.b0;
                if (videoItemData2.author_info != null) {
                    videoItemData2.threadData.getAuthor().setIsLike("1".equals(this.b0.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            eh6.update(this.b0.threadData);
        }
        GoPbCommentFloatListener.k();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.R0 = true;
        lx8 lx8Var = this.p1;
        if (lx8Var != null) {
            lx8Var.d(true);
        }
        VideoDanmuController videoDanmuController = this.j;
        if (videoDanmuController != null) {
            videoDanmuController.R();
            this.j.H();
        }
        d5();
        this.Z0.X(!this.R0);
        U4();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
    }

    public final void Q4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && BdNetTypeUtil.isMobileNet()) {
            hv8.c().f(getContext());
        }
    }

    public final void R3() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || (tBLottieAnimationView = this.r) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public boolean R4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (TiebaPlusConfigData.isHeatingSwitchOpen()) {
                int i2 = this.a;
                return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void S3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z2) == null) {
            int f2 = ej.f(getContext(), R.dimen.tbds26);
            if (this.t != z2) {
                if (this.r != null) {
                    if (z2) {
                        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.leftMargin = f2;
                            marginLayoutParams.rightMargin = f2;
                            this.p.setLayoutParams(layoutParams);
                        }
                        this.r.setVisibility(0);
                        if (!this.r.isAnimating()) {
                            this.r.setSpeed(0.8f);
                            this.r.setRepeatCount(-1);
                            this.r.post(new d0(this));
                        }
                    } else {
                        ViewGroup.LayoutParams layoutParams2 = this.p.getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                            marginLayoutParams2.leftMargin = 0;
                            marginLayoutParams2.rightMargin = 0;
                            this.p.setLayoutParams(layoutParams2);
                        }
                        this.r.setVisibility(8);
                        if (this.r.isAnimating()) {
                            this.r.cancelAnimation();
                        }
                    }
                }
                this.t = z2;
            }
        }
    }

    public final void S4() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.F0 == null) {
                this.G0 = new yu4(getActivity());
                this.F0 = new wu4(getPageContext(), this.G0);
                ArrayList arrayList = new ArrayList();
                uu4 uu4Var = new uu4(getString(R.string.obfuscated_res_0x7f0f0aaa), this.G0);
                boolean z2 = false;
                VideoItemData videoItemData = this.b0;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    uu4Var.n(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ff1));
                } else {
                    uu4Var.n(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0aaa));
                }
                uu4Var.m(this.Y1);
                VideoItemData videoItemData2 = this.b0;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(uu4Var);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.b0.thread_id);
                    statisticItem.param("fid", this.b0.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    int i2 = this.a;
                    if (i2 != 3 && i2 != 4) {
                        statisticItem.param("obj_type", 2);
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    int i3 = this.a;
                    if (i3 == 3) {
                        statisticItem.param("obj_param1", 1);
                    } else if (i3 == 4) {
                        statisticItem.param("obj_param1", 2);
                    } else if (i3 == 7) {
                        statisticItem.param("obj_param1", 3);
                    }
                    statisticItem.param("obj_source", N3());
                    TiebaStatic.log(statisticItem);
                }
                if (j4()) {
                    uu4 uu4Var2 = new uu4(getString(R.string.obfuscated_res_0x7f0f0cbd), this.G0);
                    uu4Var2.m(this.X1);
                    arrayList.add(uu4Var2);
                }
                if (!Z3()) {
                    uu4 uu4Var3 = new uu4(getString(R.string.obfuscated_res_0x7f0f1016), this.G0);
                    uu4Var3.m(this.Z1);
                    arrayList.add(uu4Var3);
                }
                if (this.A0) {
                    uu4 uu4Var4 = new uu4(getString(R.string.obfuscated_res_0x7f0f04b0), this.G0);
                    uu4Var4.m(this.a2);
                    arrayList.add(uu4Var4);
                }
                this.G0.m(new e0(this));
                this.F0.setOnDismissListener(new f0(this));
                this.G0.j(arrayList);
            }
            P4();
        }
    }

    public void T3() {
        wu4 wu4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (wu4Var = this.F0) != null && wu4Var.isShowing()) {
            this.F0.dismiss();
        }
    }

    public final boolean T4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (hv8.c().d() || TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2 || !((i2 = this.a) == 3 || i2 == 4 || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.a;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && BdNetTypeUtil.isMobileNet() && isResumed() && this.f0) {
                ej.O(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1546), 3000);
                int i4 = this.a;
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

    public final void U3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && h4()) {
            this.W0.a().o();
            C3(((ay8) this.W0.a().n(28)).g().getText().toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
            int i2 = this.a;
            if (i2 == 4 || i2 == 3) {
                K4(0);
            }
            u3();
        }
    }

    public void U4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM);
            statisticItem.param("tid", this.b0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.b0.forum_id);
            int i2 = this.a;
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

    public final void V3(View view2, View view3, View view4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{view2, view3, view4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), animatorListenerAdapter}) == null) {
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
            ofInt.addUpdateListener(new r0(this, max2 - ((i4 + i5) - max2), max3 - ((i12 + i13) - max3), i4, i5, i12, i13, layoutParams, i14, i2, i3, i15, i16, i8, i9, i10, i11, view4, view2));
            ofInt.addListener(animatorListenerAdapter);
            ofInt.setTarget(view2);
            ofInt.start();
        }
    }

    public final void V4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || h4()) {
            return;
        }
        yx8 yx8Var = this.W0;
        if (yx8Var != null && yx8Var.a() != null) {
            this.W0.a().j();
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null) {
                this.W0.w(videoItemData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.TRUE));
        }
        int i2 = this.a;
        if (i2 == 4 || i2 == 3) {
            K4(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        u3();
    }

    public void W0(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048621, this, i2, i3, intent) == null) {
            yx8 yx8Var = this.W0;
            if (yx8Var != null) {
                yx8Var.n(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                ed8.g().m(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                if (shareItem != null) {
                    statisticItem.param("tid", shareItem.O);
                    statisticItem.param("uid", shareItem.R);
                    statisticItem.param("fid", shareItem.N);
                    statisticItem.param("obj_type", intExtra2);
                    statisticItem.param("obj_locate", shareItem.M);
                }
                TiebaStatic.log(statisticItem);
                if (this.a == 7) {
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SHARE_SUCCESS);
                    if (shareItem != null) {
                        statisticItem2.param("tid", shareItem.O);
                        statisticItem2.param("uid", shareItem.R);
                        statisticItem2.param("fid", shareItem.N);
                        statisticItem2.param("obj_type", intExtra2);
                        statisticItem2.param("obj_param1", 7);
                    }
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    public final void W3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                yx8 yx8Var = (yx8) new zx8().g(getActivity(), new y(this));
                this.W0 = yx8Var;
                if (yx8Var != null && this.b0 != null) {
                    yx8Var.s(getPageContext());
                    String b2 = TextUtils.isEmpty(this.b0.thread_id) ? "" : DanmuPostDraftManager.b.a().b(this.b0.thread_id);
                    this.W0.t(this.b0.thread_id, this.b0.forum_id, this.b0.forum_name, b2);
                    C3(b2);
                    this.W0.u(new z(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.f).addView(this.W0.a(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void W4() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || (videoItemData = this.b0) == null) {
            return;
        }
        String str3 = videoItemData.forum_id;
        String str4 = videoItemData.forum_name;
        String str5 = videoItemData.title;
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.b0.baijiahaoData.oriUgcType + "&dvid=" + this.b0.baijiahaoData.oriUgcVid + "&nid=" + this.b0.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData.thread_id;
            str2 = "?share=9105&fr=sharewise";
        }
        String str6 = TbConfig.HTTPS_PB_PREFIX + str + (str2 + "&share_from=post");
        String str7 = this.b0.thumbnail_url;
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f114e);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f049c);
        VideoItemData videoItemData3 = this.b0;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f049d));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.v = str5;
        shareItem.w = format;
        if (this.b0.baijiahaoData == null) {
            shareItem.V = videoItemData2.play_count;
        }
        if (this.b0.isBjhVideo) {
            shareItem.H = format;
        } else {
            shareItem.H = "";
        }
        shareItem.x = str6;
        shareItem.s = 2;
        shareItem.u = str;
        shareItem.J = 3;
        shareItem.N = str3;
        shareItem.t = str4;
        shareItem.O = str;
        VideoItemData videoItemData4 = this.b0;
        shareItem.c0 = videoItemData4.post_id;
        shareItem.f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.d0 = userItemData2.portrait;
            shareItem.e0 = userItemData2.user_name;
            shareItem.f0 = userItemData2.getUserShowName();
        }
        int i2 = this.a;
        if (i2 == 3) {
            shareItem.I = 25;
            shareItem.M = 19;
        } else if (i2 == 4) {
            shareItem.I = 29;
            shareItem.M = 20;
        } else {
            shareItem.I = 12;
            shareItem.M = 18;
        }
        if (this.b0.getVideoType() == 1) {
            shareItem.Q = 2;
        } else if (this.b0.getVideoType() == 2) {
            shareItem.Q = 8;
        } else if (this.b0.getVideoType() == 3) {
            shareItem.Q = 6;
        }
        if (parse != null) {
            shareItem.z = parse;
        }
        if (this.b0.isBjhVideo) {
            shareItem.s0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData5 = this.b0;
        originalThreadInfo.c = videoItemData5.thumbnail_url;
        originalThreadInfo.a = 3;
        originalThreadInfo.b = videoItemData5.title;
        originalThreadInfo.f = videoItemData5.thread_id;
        originalThreadInfo.p = videoItemData5.baijiahaoData;
        OriginalThreadInfo.ShareInfo generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        shareItem.X = generateShareInfo;
        VideoItemData videoItemData6 = this.b0;
        ThreadData threadData = videoItemData6.threadData;
        generateShareInfo.threadData = threadData;
        if (videoItemData6.author_info != null) {
            threadData.getAuthor().setUserName(this.b0.author_info.user_name);
            shareItem.X.threadData.getAuthor().setName_show(this.b0.author_info.name_show);
            shareItem.X.threadData.getAuthor().setPortrait(this.b0.author_info.portrait);
            shareItem.X.threadData.getAuthor().setUserId(this.b0.author_info.user_id);
        }
        s3(shareItem);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.J);
        bundle.putInt("obj_type", shareItem.Q);
        bundle.putString("fid", shareItem.N);
        bundle.putString("tid", shareItem.O);
        bundle.putInt("obj_source", shareItem.s);
        shareItem.k(bundle);
        if (this.b0.isWorksInfo()) {
            shareItem.K = 11;
        }
        ThreadData threadData2 = this.b0.threadData;
        if (threadData2 != null) {
            int j2 = e35.j(threadData2);
            UserItemData userItemData3 = this.b0.author_info;
            String str8 = userItemData3 != null ? userItemData3.name_show : "";
            shareItem.G0 = e35.i(this.b0.threadData, j2);
            VideoItemData videoItemData7 = this.b0;
            shareItem.H0 = e35.h(videoItemData7.threadData, j2, videoItemData7.forum_name, shareItem.V, str8, "");
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = j4();
        shareDialogConfig.disLikeListener = this.W1;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.D0);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = Z3();
        VideoItemData videoItemData8 = this.b0;
        shareDialogConfig.isManager = videoItemData8.is_manager;
        shareDialogConfig.isOriginManager = videoItemData8.is_origin_manager;
        shareDialogConfig.showHeating = R4();
        shareDialogConfig.isSelfHeating = this.A0;
        shareDialogConfig.heatingListener = this.V1;
        ThreadData threadData3 = this.b0.threadData;
        if (threadData3 != null) {
            shareDialogConfig.isCollected = threadData3.getIsMarked() == 1;
            shareDialogConfig.isMadeTop = this.b0.threadData.isMadeTop();
            shareDialogConfig.isAddedGood = this.b0.threadData.isAddedGood();
        }
        y36.c().l(shareDialogConfig);
    }

    public boolean X3() {
        InterceptResult invokeV;
        ThreadData threadData;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            VideoItemData videoItemData = this.b0;
            if (videoItemData == null || (threadData = videoItemData.threadData) == null) {
                return false;
            }
            if (videoItemData.mRichAbstractList == null && threadData.getRichAbstractList() == null) {
                return false;
            }
            this.F = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091c22);
            this.G = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0921d3);
            this.H = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0921d1);
            this.E = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091ba7);
            hv4 d2 = hv4.d(this.H);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            gv4 gv4Var = (gv4) this.H.getBackground();
            gv4Var.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.H.setBackground(gv4Var);
            hv4 d3 = hv4.d(this.F);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            List<PbContent> t2 = TiePlusHelper.t(this.b0.mRichAbstractList) != null ? TiePlusHelper.t(this.b0.mRichAbstractList) : null;
            if (TiePlusHelper.t(this.b0.threadData.getRichAbstractList()) != null) {
                t2 = TiePlusHelper.t(this.b0.threadData.getRichAbstractList());
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(t2, 0);
            if (pbContent == null || (tiebaPlusInfo = pbContent.tiebaplus_info) == null) {
                return false;
            }
            Integer num = pbContent.type;
            Integer num2 = tiebaPlusInfo.jump_type;
            pl5 c2 = pl5.c(num.intValue(), tiebaPlusInfo, this.b0.threadData);
            this.g1 = c2;
            c2.b(this.b0.threadData.statFloor);
            if (num2.intValue() != 3 && num2.intValue() != 7) {
                if (num2.intValue() == 2) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807e5));
                } else if (num2.intValue() == 6) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08080e));
                } else if (num2.intValue() == 5) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08080c));
                } else {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080809));
                }
            } else {
                this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080856));
            }
            this.F.setText(tiebaPlusInfo.desc);
            this.H.setVisibility(0);
            this.E.setVisibility(8);
            this.H.setOnClickListener(new o0(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void X4(boolean z2) {
        mx8 mx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) || (mx8Var = this.a1) == null) {
            return;
        }
        mx8Var.c(d4());
        this.a1.d(getPageContext(), this.b0, z2);
    }

    public final boolean Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.a == 6 : invokeV.booleanValue;
    }

    public final void Y4(View view2, View view3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048627, this, new Object[]{view2, view3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), animatorListenerAdapter}) == null) {
            int max = Math.max(i2, i3);
            int i10 = max - ((i2 + i3) - max);
            int max2 = Math.max(i4, i5);
            int i11 = max2 - ((i4 + i5) - max2);
            int max3 = Math.max(i9, i8);
            ValueAnimator ofInt = ValueAnimator.ofInt(i6, i7);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new s0(this, i11, i4, i5, i10, i2, i3, max3 - ((i9 + i8) - max3), i8, i9, view2, view3));
            ofInt.addListener(animatorListenerAdapter);
            ofInt.setTarget(view2);
            ofInt.start();
        }
    }

    public final boolean Z3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.A0 : invokeV.booleanValue;
    }

    public final void Z4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || this.b0 == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
        statisticItem.param("tid", this.b0.thread_id);
        statisticItem.param("fid", this.b0.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        int i2 = this.a;
        if (i2 != 3 && i2 != 4) {
            statisticItem.param("obj_type", 2);
        } else {
            statisticItem.param("obj_type", 1);
        }
        statisticItem.param("obj_type", N3());
        int i3 = this.a;
        if (i3 == 3) {
            statisticItem.param("obj_source", 1);
        } else if (i3 == 4) {
            statisticItem.param("obj_source", 2);
        } else if (i3 == 7) {
            statisticItem.param("obj_source", 3);
        }
        TiebaStatic.log(statisticItem);
    }

    public final boolean a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.a == 8 : invokeV.booleanValue;
    }

    public final void a5(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048631, this, str, z2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_HORIZONTAL_PLAY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", str);
            statisticItem.param("obj_type", z2 ? 1 : 2);
            int i2 = this.a;
            if (i2 != 3 && i2 != 4) {
                statisticItem.param("obj_locate", 1);
            } else {
                statisticItem.param("obj_locate", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean b4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            int i2 = this.a;
            return (i2 == 3 || i2 == 4) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final String b5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (StringHelper.getChineseAndEnglishLength(str) <= 14) {
                return str + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e0);
            }
            return StringHelper.cutChineseAndEnglishWithEmoji(str, 12, StringHelper.STRING_MORE) + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02e0);
        }
        return (String) invokeL.objValue;
    }

    public final boolean c4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.a == 1 && this.U0 == 0) {
                return false;
            }
            return (this.a == 7 && getActivity() != null && (getActivity() instanceof FrsVideoTabPlayActivity) && this.U0 == ((FrsVideoTabPlayActivity) getActivity()).V0()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public boolean c5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (h4()) {
                U3();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            int i2 = this.a;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public final void d5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.O0 = this.i.getControl().getVideoStatus();
            } else {
                this.O0 = OnStatusChangedListener.VideoStatus.INIT;
            }
        }
    }

    public final boolean e4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048638, this, i2)) == null) {
            if (i2 == 1) {
                int i3 = this.a;
                return i3 == 3 || i3 == 4;
            } else if (i2 == 2) {
                int i4 = this.a;
                return i4 == 1 || i4 == 2;
            } else if (i2 == 3) {
                int i5 = this.a;
                return i5 == 1 || i5 == 2 || i5 == 3 || i5 == 4;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public final boolean f4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? Y3() && !this.b : invokeV.booleanValue;
    }

    public final boolean g4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? f4() && Z3() : invokeV.booleanValue;
    }

    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (h4()) {
                U3();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean h4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            yx8 yx8Var = this.W0;
            return (yx8Var == null || yx8Var.a() == null || !this.W0.a().v()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (UbsABTestHelper.isVideoTabAuthorABTest() && e4(1)) {
                return true;
            }
            if (UbsABTestHelper.isVideoMiddleAuthorABTest() && e4(2)) {
                return true;
            }
            return UbsABTestHelper.isVideoMiddleAndTabAuthorABTest() && e4(3);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qm5.b
    public void j0(float f2, float f3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.b0) != null && "0".equals(videoItemData.is_agreed)) {
            F3(this.e);
        }
    }

    public boolean j4() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            VideoItemData videoItemData = this.b0;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.a != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            int i2 = this.a;
            return i2 == 4 || i2 == 3;
        }
        return invokeV.booleanValue;
    }

    public final boolean l4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.O0;
            return videoStatus == OnStatusChangedListener.VideoStatus.INIT || videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PREPARED || videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING || videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vy8
    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            this.U0 = i2;
        }
    }

    public void m4(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return;
                        }
                    }
                }
                this.o1 = true;
                v4(8);
                x4(8);
                VideoItemData videoItemData = this.b0;
                if (videoItemData != null) {
                    if (!(dh.e(videoItemData.video_height, 0) <= dh.e(this.b0.video_width, 0)) || this.q1 >= 0) {
                        return;
                    }
                    int i4 = this.v0.topMargin;
                    this.q1 = i4;
                    ValueAnimator duration = ValueAnimator.ofInt(i4, i4 - UtilHelper.getStatusBarHeight()).setDuration(500L);
                    duration.addUpdateListener(new x0(this));
                    duration.start();
                    return;
                }
                return;
            }
            this.o1 = false;
            v4(0);
            x4(0);
            VideoItemData videoItemData2 = this.b0;
            if (videoItemData2 != null) {
                if (!(dh.e(videoItemData2.video_height, 0) <= dh.e(this.b0.video_width, 0)) || (i3 = this.q1) < 0) {
                    return;
                }
                ValueAnimator duration2 = ValueAnimator.ofInt(this.v0.topMargin, i3).setDuration(500L);
                duration2.addUpdateListener(new z0(this));
                duration2.start();
                this.q1 = -1;
            }
        }
    }

    public final void n4() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.i.getControl().J();
    }

    public final void o4() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048651, this) == null) || (tBLottieAnimationView = this.s) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        SkinManager.setLottieAnimation(this.s, R.raw.obfuscated_res_0x7f110070);
        if (this.s.isAnimating()) {
            return;
        }
        this.s.setSpeed(1.1f);
        this.s.playAnimation();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.H0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(new b0(this));
            qo4 c2 = qo4.c(getBaseFragmentActivity());
            this.I0 = c2;
            if (c2 != null) {
                c2.j(new c0(this));
            }
            this.J0 = new n25(null);
            registerListener(this.u1);
            registerListener(this.v1);
            registerListener(this.x1);
            registerListener(this.y1);
            registerListener(this.z1);
            registerListener(this.A1);
            registerListener(this.t1);
            registerListener(this.B1);
            registerListener(this.D1);
            if (TbSingleton.getInstance().getIsNeedShowPbCommentFloat() || AbsVideoChannelFragment.E) {
                Q3(this.b0.highLightPostId, false);
                TbSingleton.getInstance().setIsNeedShowPbCommentFloat(false);
                AbsVideoChannelFragment.E = false;
            }
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.S0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048653, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            W0(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.W0 != null && this.W0.a() != null) {
                    this.W0.a().w(i2);
                }
                if (this.G0 != null) {
                    this.G0.i();
                }
                if (this.f != null) {
                    this.q0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08084f, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.r0.setImageDrawable(WebPManager.getMaskDrawable(g4() ? R.drawable.obfuscated_res_0x7f08084e : R.drawable.obfuscated_res_0x7f080850, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.A.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a88, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.B.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a43, WebPManager.ResourceStateType.NORMAL));
                    this.D.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08095f, ol8.a(SkinManager.getColor(R.color.CAM_X0213), 0.2f), null));
                    v3();
                    hv4 d2 = hv4.d(this.t0);
                    d2.n(R.string.J_X05);
                    d2.f(R.color.CAM_X0613);
                    hv4 d3 = hv4.d(this.T);
                    d3.A(R.string.F_X02);
                    d3.v(R.color.CAM_X0101);
                    hv4.d(this.U).A(R.string.F_X02);
                    hv4 d4 = hv4.d(this.S);
                    d4.z(R.dimen.T_X09);
                    d4.A(R.string.F_X02);
                    d4.y(R.array.S_O_X001);
                    hv4 d5 = hv4.d(this.R);
                    d5.z(R.dimen.T_X09);
                    d5.A(R.string.F_X02);
                    d5.y(R.array.S_O_X001);
                    hv4 d6 = hv4.d(this.Q);
                    d6.z(R.dimen.T_X09);
                    d6.A(R.string.F_X02);
                    d6.y(R.array.S_O_X001);
                    hv4 d7 = hv4.d(this.s0);
                    d7.z(R.dimen.T_X06);
                    d7.A(R.string.F_X02);
                    d7.y(R.array.S_O_X001);
                    hv4 d8 = hv4.d(this.V);
                    d8.n(R.string.J_X01);
                    d8.z(R.dimen.T_X09);
                    d8.v(R.color.CAM_X0101);
                    d8.A(R.string.F_X02);
                    d8.f(R.color.CAM_X0302);
                    this.U.setTextColor(ol8.a(SkinManager.getColor(R.color.CAM_X0101), fv4.a(R.string.A_X08)));
                    this.R.setTextColor(ol8.a(SkinManager.getColor(R.color.CAM_X0101), fv4.a(R.string.A_X03)));
                    this.S.setTextColor(ol8.a(SkinManager.getColor(R.color.CAM_X0101), fv4.a(R.string.A_X03)));
                    this.Q.setTextColor(ol8.a(SkinManager.getColor(R.color.CAM_X0101), fv4.a(R.string.A_X03)));
                }
                WebPManager.setPureDrawable(this.n, R.drawable.obfuscated_res_0x7f080a20, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f080a1c, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                R3();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        vx8 vx8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() != R.id.obfuscated_res_0x7f092559 || (vx8Var = this.k) == null) {
                return;
            }
            vx8Var.i();
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null) {
                this.k.e(videoItemData.thread_id, this.a);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.f0 && (videoItemData = this.b0) != null) {
                boolean z2 = dh.e(videoItemData.video_height, 0) <= dh.e(this.b0.video_width, 0);
                wy8 wy8Var = this.Z0;
                if (wy8Var == null || !z2) {
                    return;
                }
                if (!(wy8Var.isFullScreen() && configuration.orientation == 1) && (this.Z0.isFullScreen() || configuration.orientation != 2)) {
                    return;
                }
                this.h.removeView(this.i);
                this.Z0.V(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.w1);
            registerListener(this.d2);
            registerListener(this.e2);
            this.a1 = new mx8();
            getLifecycle().addObserver(this.C1);
            if (this.e1 == null) {
                this.e1 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.VIDEO_MOUNT, getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        RelativeLayout relativeLayout;
        TbVideoViewContainer tbVideoViewContainer;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048658, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
                this.c0 = videoItemModel;
                this.b0 = videoItemModel == null ? null : videoItemModel.getVideoItemData();
                this.h0 = (Rect) arguments.getParcelable("video_cover_rect");
                this.B0 = arguments.getInt("video_index");
                arguments.getString("page_from");
                this.D0 = arguments.getString("from");
                this.E0 = arguments.getString("video_channel_tab");
                this.P0 = arguments.getString("obj_id");
                this.c = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.a = arguments.getInt(VideoPlayActivityConfig.CURRENT_TYPE);
                this.b = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
                this.o1 = !arguments.getBoolean(VideoPlayActivityConfig.IS_SCROLLED, false) && this.B0 == 0 && arguments.getBoolean(VideoPlayActivityConfig.IS_NEED_SHOW_SECOND_FLOOR, false);
            }
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.b0.author_info.user_id)) {
                this.A0 = true;
            }
            if (b4() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08d9, (ViewGroup) null);
            } else {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d08e0, (ViewGroup) null);
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && ((i2 = this.a) == 1 || i2 == 7)) {
                this.f.setBackground(null);
            } else {
                this.f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
            }
            this.h1 = true;
            VideoItemData videoItemData2 = this.b0;
            if (videoItemData2 != null && StringUtils.isNull(videoItemData2.video_url) && !StringUtils.isNull(this.b0.thread_id)) {
                VideoDanmuController videoDanmuController = new VideoDanmuController(getPageContext(), getUniqueId(), this.f, R.id.obfuscated_res_0x7f09251a, this.b0, this.a);
                this.j = videoDanmuController;
                videoDanmuController.X(this.U1);
                this.j.M();
            }
            this.f.setOnTouchListener(this.F1);
            this.f.setOnLongClickListener(this.G1);
            TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(getContext());
            this.i = tbVideoViewContainer2;
            tbVideoViewContainer2.getControl().setStageType("2005");
            this.i.getControl().getMediaProgressObserver().j(this.H1);
            TbImageView tbImageView = (TbImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092518);
            this.l = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.B = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0919ec);
            this.C = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09253f);
            this.D = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09253e);
            this.l.setEvent(this.I1);
            this.h = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09255d);
            G4();
            this.m = this.f.findViewById(R.id.obfuscated_res_0x7f092298);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.m.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090315);
            this.n = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091557);
            this.o = imageView2;
            imageView2.setVisibility(8);
            this.p = this.f.findViewById(R.id.obfuscated_res_0x7f091a35);
            LinearLayout linearLayout = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091ba7);
            this.E = linearLayout;
            hv4 d2 = hv4.d(linearLayout);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            gv4 gv4Var = (gv4) this.E.getBackground();
            gv4Var.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.E.setBackground(gv4Var);
            this.I = (BarImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091b96);
            this.J = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091b83);
            this.I.setShowOval(true);
            TextView textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091ba3);
            this.K = textView;
            hv4 d3 = hv4.d(textView);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            HeadImageView headImageView = (HeadImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0902f6);
            this.q = headImageView;
            headImageView.setDefaultResource(17170445);
            this.q.setPlaceHolder(2);
            this.q.setIsRound(true);
            this.q.setBorderWidth(R.dimen.L_X02);
            this.q.setBorderColor(R.color.CAM_X0622);
            this.q.setDrawBorder(true);
            this.q.setUseNightOrDarkMask(false);
            E4();
            this.r = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0924b4);
            this.s = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0902de);
            this.X = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0902f4);
            this.u = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0903e1);
            this.V = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f09145c);
            my4 my4Var = new my4();
            UtilHelper.addFollowUserIconStyle(my4Var);
            my4Var.h(R.color.CAM_X0101);
            my4Var.m(0, 0);
            my4Var.n(0);
            my4Var.k(true);
            my4Var.j(ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds145), ej.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60));
            this.V.setConfig(my4Var);
            this.V.setText(getString(R.string.obfuscated_res_0x7f0f02b0));
            this.j0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090155);
            this.L = (ExpandableTextView) this.f.findViewById(R.id.obfuscated_res_0x7f09258a);
            this.M = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09222c);
            this.N = this.f.findViewById(R.id.obfuscated_res_0x7f09222b);
            this.O = this.f.findViewById(R.id.obfuscated_res_0x7f09223d);
            this.P = this.f.findViewById(R.id.obfuscated_res_0x7f09258d);
            this.e0 = (VideoMiddleNiaiControllerView) this.f.findViewById(R.id.obfuscated_res_0x7f0914d6);
            this.W = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0924fb);
            this.y = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09067c);
            this.Q = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090688);
            this.q0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090686);
            this.x = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090154);
            this.v = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0913f8);
            this.w = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091e7f);
            this.c1 = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09250e);
            this.i1 = this.f.findViewById(R.id.obfuscated_res_0x7f09258e);
            this.j1 = this.f.findViewById(R.id.obfuscated_res_0x7f092510);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !c4() && this.h0 != null) {
                A4(8);
                TbImageView tbImageView2 = this.l;
                if (tbImageView2 != null) {
                    tbImageView2.setVisibility(8);
                }
            } else {
                A4(0);
            }
            u3();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            int i3 = this.a;
            if (i3 != 4 && i3 != 3) {
                this.e0.q(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                if (b4() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds145);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
                } else {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
                }
            } else {
                this.e0.q(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            }
            this.R = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f09015d);
            this.r0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091e88);
            this.S = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f091e96);
            this.T = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090850);
            this.U = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090852);
            this.z = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091e88);
            this.A = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091e89);
            s4();
            this.Y = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0924fa);
            this.Z = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0924fd);
            this.a0 = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092561);
            this.s0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09250b);
            this.t0 = this.f.findViewById(R.id.obfuscated_res_0x7f091b39);
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.t0.setVisibility(0);
            } else {
                this.t0.setVisibility(8);
            }
            this.t0.setOnClickListener(this.L1);
            if (this.b0 != null) {
                this.e0.setVisibility(0);
            }
            this.e0.setPlayer(this.i.getControl());
            this.e0.setOnSeekBarChangeListener(this.J1);
            this.u0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091b3a);
            TextView textView2 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09083d);
            this.d0 = textView2;
            textView2.setVisibility(8);
            String q2 = ox4.k().q("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(q2)) {
                this.d0.setText(q2);
            }
            this.d0.setOnClickListener(this.L1);
            A3();
            this.p.setOnClickListener(this.K1);
            this.s0.setOnClickListener(this.K1);
            this.Z.setOnClickListener(this.L1);
            this.L.setHasDown();
            this.L.setOnClickListener(this.L1);
            this.n.setOnClickListener(this.L1);
            this.o.setOnClickListener(this.L1);
            this.y.setOnClickListener(this.L1);
            this.x.setOnClickListener(this.M1);
            this.w.setOnClickListener(this.N1);
            this.V.setOnClickListener(this.O1);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.g0 = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.g0.setAnimationListener(this.P1);
            this.C.setVisibility(0);
            if (this.f0) {
                this.e0.setLoading(true);
            }
            if (this.h0 != null && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getParent() != null) {
                Rect rect = this.h0;
                int i4 = rect.right;
                int i5 = rect.left;
                this.w0 = i4 - i5;
                int i6 = rect.bottom;
                int i7 = rect.top;
                this.x0 = i6 - i7;
                this.y0 = i5;
                this.z0 = i7;
                if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    this.i.post(this.R1);
                } else {
                    this.i.post(this.Q1);
                }
            } else if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                RelativeLayout relativeLayout2 = this.c1;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                    this.c1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
            }
            if (this.h0 == null && (relativeLayout = this.c1) != null) {
                ViewGroup.LayoutParams layoutParams4 = relativeLayout.getLayoutParams();
                layoutParams4.height = -1;
                layoutParams4.width = -1;
                this.c1.setVisibility(0);
                this.c1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
            }
            W3();
            if (this.f0) {
                H3();
            }
            VideoItemData videoItemData3 = this.b0;
            if (videoItemData3 != null && (!StringUtils.isNull(videoItemData3.video_url) || !StringUtils.isNull(this.b0.thread_id))) {
                J4(this.b0.video_url);
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    VideoDanmuController videoDanmuController2 = new VideoDanmuController(getPageContext(), getUniqueId(), this.f, R.id.obfuscated_res_0x7f09251a, this.b0, this.a);
                    this.j = videoDanmuController2;
                    videoDanmuController2.P(this.E1);
                }
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                vx8 vx8Var = new vx8(this.f, R.id.obfuscated_res_0x7f092559);
                this.k = vx8Var;
                vx8Var.g(this);
                this.k.h(this.S1);
            }
            wy8 wy8Var = new wy8(getPageContext(), getUniqueId(), this.h, this.a);
            this.Z0 = wy8Var;
            wy8Var.setStageType("2005");
            this.Z0.setUniqueId(getUniqueId());
            VideoItemData videoItemData4 = this.b0;
            if (videoItemData4 != null && videoItemData4.threadData == null) {
                videoItemData4.threadData = new ThreadData();
                VideoItemData videoItemData5 = this.b0;
                ThreadData threadData = videoItemData5.threadData;
                threadData.tid = videoItemData5.thread_id;
                threadData.threadType = 40;
                threadData.setReply_num(dh.e(videoItemData5.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(dh.e(this.b0.video_width, 0));
                builder.video_height = Integer.valueOf(dh.e(this.b0.video_height, 0));
                VideoItemData videoItemData6 = this.b0;
                builder.video_url = videoItemData6.video_url;
                builder.thumbnail_url = videoItemData6.thumbnail_url;
                builder.video_md5 = videoItemData6.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData6.isVerticalVideo);
                this.b0.threadData.setVideoInfo(builder.build(true));
            }
            VideoItemData videoItemData7 = this.b0;
            if (videoItemData7 != null) {
                I4(videoItemData7, this.Z0, this.j);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                    gh.a().post(this.r1);
                } else if (this.U0 != 0) {
                    gh.a().post(this.r1);
                }
            }
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            if (!this.k1) {
                stopPlay();
            }
            if (!getActivity().isFinishing() && (tbVideoViewContainer = this.i) != null && (tbVideoViewContainer.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof ua8)) {
                ((ua8) this.i.getControl().getPlayer()).release();
            }
            TbVideoViewContainer tbVideoViewContainer2 = this.i;
            if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null) {
                this.i.getControl().setVideoStatusChangeListener(null);
            }
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.w1);
            MessageManager.getInstance().unRegisterListener(this.d2);
            MessageManager.getInstance().unRegisterListener(this.e2);
            if (this.b2 != null) {
                gh.a().removeCallbacks(this.b2);
                this.b2 = null;
            }
            mx8 mx8Var = this.a1;
            if (mx8Var != null) {
                mx8Var.b();
            }
            gh.a().removeCallbacks(this.r1);
            getLifecycle().removeObserver(this.C1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            super.onDestroyView();
            VideoDanmuController videoDanmuController = this.j;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            vx8 vx8Var = this.k;
            if (vx8Var != null) {
                vx8Var.f();
            }
            wy8 wy8Var = this.Z0;
            if (wy8Var != null) {
                wy8Var.F0();
            }
            yx8 yx8Var = this.W0;
            if (yx8Var != null) {
                yx8Var.o();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.e0;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.setOnSeekBarChangeListener(null);
            }
            TbImageView tbImageView = this.l;
            if (tbImageView != null) {
                tbImageView.setEvent(null);
            }
            LinearLayout linearLayout = this.y;
            if (linearLayout != null) {
                linearLayout.setOnClickListener(null);
            }
            LinearLayout linearLayout2 = this.E;
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(null);
            }
            View view2 = this.t0;
            if (view2 != null) {
                view2.setOnClickListener(null);
            }
            ExpandableTextView expandableTextView = this.L;
            if (expandableTextView != null) {
                expandableTextView.setOnStatusChangedListener(null);
            }
            TBSpecificationBtn tBSpecificationBtn = this.V;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.setOnClickListener(null);
            }
            LinearLayout linearLayout3 = this.H;
            if (linearLayout3 != null) {
                linearLayout3.setOnClickListener(null);
            }
            LinearLayout linearLayout4 = this.w;
            if (linearLayout4 != null) {
                linearLayout4.setOnClickListener(null);
            }
            RelativeLayout relativeLayout = this.x;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(null);
            }
            LinearLayout linearLayout5 = this.Z;
            if (linearLayout5 != null) {
                linearLayout5.setOnClickListener(null);
            }
            View view3 = this.p;
            if (view3 != null) {
                view3.setOnClickListener(null);
            }
            gh.a().removeCallbacks(this.r1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            super.onPause();
            if (!this.R0) {
                n4();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !c4() && getActivity().isFinishing()) {
                D3();
                this.k1 = true;
            }
            U3();
            TiePlusEventController tiePlusEventController = this.e1;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            super.onPrimary();
            if (isResumed() && this.f0) {
                VideoItemData videoItemData = this.b0;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.f0) {
                        r4();
                        t4();
                        q4(0);
                    } else {
                        n4();
                    }
                }
                VideoItemData videoItemData2 = this.b0;
                if (videoItemData2 == null || (alaInfoData = videoItemData2.mAlaInfoData) == null || !alaInfoData.isLegalYYLiveData() || this.b0.mAlaInfoData.live_status != 1) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("tid", this.b0.getThreadId());
                UserItemData userItemData = this.b0.author_info;
                if (userItemData != null) {
                    statisticItem.addParam("obj_id", userItemData.user_id);
                    statisticItem.addParam("obj_name", this.b0.author_info.user_name);
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            n4();
            U3();
            this.h1 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            super.onResume();
            if (this.d1) {
                this.d1 = false;
                gh.a().removeCallbacks(this.r1);
                q4(1);
                startPlay();
                if (this.h0 == null) {
                    H3();
                }
                this.S0 = false;
            }
            TiePlusEventController tiePlusEventController = this.e1;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            super.onStart();
            if (this.R0) {
                t4();
            }
        }
    }

    @Override // com.baidu.tieba.play.OnStatusChangedListener
    public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, videoStatus) == null) {
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PREPARED) {
                F4();
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.C;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2 = this.e0;
                if (videoMiddleNiaiControllerView2 != null) {
                    videoMiddleNiaiControllerView2.setLoading(false);
                }
                i1 i1Var = this.Y0;
                if (i1Var != null) {
                    i1Var.onStart();
                }
                TbImageView tbImageView = this.l;
                if (tbImageView != null) {
                    if (tbImageView.getVisibility() == 0) {
                        this.l.clearAnimation();
                        this.l.startAnimation(this.g0);
                    }
                    this.l.setVisibility(8);
                }
                if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    A4(0);
                }
                if (!TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                    TbSingleton.getInstance().setEnableVideoVerticalPreload(true);
                }
                VideoDanmuController videoDanmuController = this.j;
                if (videoDanmuController != null) {
                    videoDanmuController.U();
                }
            } else {
                VideoDanmuController videoDanmuController2 = this.j;
                if (videoDanmuController2 != null) {
                    videoDanmuController2.R();
                }
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView = this.e0) != null) {
                videoMiddleNiaiControllerView.setLoading(false);
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING && this.e0 != null && this.f0 && isResumed()) {
                this.e0.setLoading(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            super.onStop();
            n4();
            U3();
            gh.a().removeCallbacks(this.r1);
        }
    }

    @Override // com.baidu.tieba.qm5.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            if (h4()) {
                U3();
                return;
            }
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.i.getControl().D()) {
                return;
            }
            if (this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING && this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                if (this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PAUSING || T4()) {
                    return;
                }
                this.i.getControl().start();
                this.B.setVisibility(8);
                y3(true);
                this.e0.p();
                if (isResumed() && this.f0) {
                    return;
                }
                n4();
                return;
            }
            this.i.getControl().pause();
            C4();
            y3(false);
            gh.a().removeCallbacks(this.b2);
            I3(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            A3();
            H4();
        }
    }

    @Override // com.baidu.tieba.qm5.b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048669, this) == null) || f4() || h4() || (videoItemData = this.b0) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long g2 = dh.g(userItemData.user_id, 0L);
        long g3 = dh.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        int i2 = 1;
        boolean z2 = (g2 == 0 && g3 == 0) ? false : g2 == g3;
        wx8.a();
        String str = this.b0.author_info.portrait;
        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
        int i3 = this.a;
        PersonPolymericActivityConfig createNormalConfig = personPolymericActivityConfig.createNormalConfig(g2, z2, false, true, (i3 == 3 || i3 == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
        createNormalConfig.setPortrait(str);
        createNormalConfig.setSourceTid(this.b0.thread_id);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DRAG_TO_PERSONAL_CENTER);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", this.b0.thread_id);
        int i4 = this.a;
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

    public final void p4(int i2, int i3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048670, this, i2, i3) == null) || (videoItemData = this.b0) == null || videoItemData.video_url == null || i2 <= videoItemData.video_duration * 1000) {
            return;
        }
        this.h1 = false;
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_PTS);
        statisticItem.param("obj_id", this.b0.video_url);
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tieba.vy8
    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.U0 : invokeV.intValue;
    }

    public final void q4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048672, this, i2) == null) && this.b0 != null && this.h0 == null) {
            StatisticItem statisticItem = new StatisticItem("c12794");
            statisticItem.param("tid", this.b0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.b0.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            statisticItem2.param("page_type", "a023");
            statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
            TiebaStatic.log(statisticItem2);
        }
    }

    public final void r4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048673, this) == null) || this.b0 == null) {
            return;
        }
        ab8 ab8Var = new ab8();
        ab8Var.a = "nani_midpage";
        VideoItemData videoItemData = this.b0;
        ab8Var.c = videoItemData.thread_id;
        ab8Var.t = videoItemData.nid;
        ab8Var.d = this.b0.forum_id + "";
        ab8Var.e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.b0;
        ab8Var.f = videoItemData2.mRecomSource;
        ab8Var.g = videoItemData2.mRecomAbTag;
        ab8Var.h = videoItemData2.mRecomWeight;
        ab8Var.i = "";
        ab8Var.k = "";
        ab8Var.m = videoItemData2.mMd5;
        ab8Var.x = videoItemData2.getChannelMidRequestNum();
        ab8Var.y = this.b0.getChannelMidRequestVideoNum();
        if (this.h0 != null) {
            ab8Var.n = "1";
        } else {
            ab8Var.n = "2";
        }
        int i2 = this.a;
        if (i2 == 1 || i2 == 2) {
            ab8Var.p = "1";
            ab8Var.a = "auto_midpage";
            ab8Var.i = "index";
        }
        pa8.e(this.b0.mMd5, "", "1", ab8Var, this.i.getControl().getPcdnState());
        int i3 = this.a;
        if (i3 == 1 || i3 == 3) {
            sx8.c(this.b0.mMd5);
        } else if (i3 == 2 || i3 == 4) {
            sx8.a(this.b0.mMd5);
        } else if (i3 == 7) {
            sx8.b(this.b0.mMd5);
        }
    }

    public final void s3(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, shareItem) == null) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_duration = Integer.valueOf(this.b0.video_duration);
            builder.play_count = Integer.valueOf(this.b0.play_count);
            VideoItemData videoItemData = this.b0;
            builder.thumbnail_url = videoItemData.thumbnail_url;
            builder.thumbnail_height = Integer.valueOf(dh.e(videoItemData.video_height, 0));
            builder.thumbnail_width = Integer.valueOf(dh.e(this.b0.video_width, 0));
            shareItem.X.threadData.setVideoInfo(builder.build(true));
        }
    }

    public final void s4() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048675, this) == null) || this.A == null || (imageView = this.z) == null) {
            return;
        }
        imageView.clearAnimation();
        this.A.clearAnimation();
        this.z.setVisibility(0);
        this.A.setVisibility(8);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        pl5 pl5Var;
        TbVideoViewContainer tbVideoViewContainer;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.f0 = z2;
            if (this.Z0 != null && (videoItemData = this.b0) != null) {
                this.Z0.X(this.f0 && (dh.e(videoItemData.video_height, 0) <= dh.e(this.b0.video_width, 0)));
            }
            if (!isResumed() && this.f0 && l4()) {
                this.d1 = true;
            }
            if (isResumed() && this.f0 && (!this.S0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                q4(1);
                startPlay();
                if (this.h0 == null) {
                    H3();
                }
                this.S0 = false;
            } else if (!this.R0) {
                s4();
                this.T0 = 1;
                n4();
                c5();
            }
            if (this.e0 != null) {
                if (this.f0 && isResumed() && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null && this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.e0.setLoading(true);
                } else {
                    this.e0.setLoading(false);
                }
            }
            if (!this.f0 || this.f1 || (pl5Var = this.g1) == null || this.e1 == null) {
                return;
            }
            pl5Var.q(TiePlusStat.StatType.EXPOSE);
            this.e1.n(this.g1);
            this.f1 = true;
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048677, this) == null) || T4()) {
            return;
        }
        Q4();
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.b0 != null && this.i.getParent() == null) {
            G4();
            H4();
        }
        if (Build.VERSION.SDK_INT < 17 && this.l.getVisibility() == 0) {
            this.l.clearAnimation();
            this.l.startAnimation(this.g0);
        }
        TbVideoViewContainer tbVideoViewContainer2 = this.i;
        if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null && !TextUtils.isEmpty(this.L0) && this.b0 != null) {
            if (TbVideoViewSet.c().d(this.L0) == null || TbVideoViewSet.c().d(this.L0) != this.i) {
                this.i.getControl().setVideoPath(this.L0, this.b0.thread_id);
            }
            if (!UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                this.i.getControl().setIsVolume0(false);
            }
            this.i.getControl().P(this.s1);
            VideoDanmuController videoDanmuController = this.j;
            if (videoDanmuController != null) {
                videoDanmuController.a0();
            }
            this.e0.p();
            r4();
        }
        if (this.R0) {
            return;
        }
        if ((isResumed() && this.f0) || l4()) {
            return;
        }
        n4();
        VideoDanmuController videoDanmuController2 = this.j;
        if (videoDanmuController2 != null) {
            videoDanmuController2.R();
        }
        if (this.B != null) {
            C4();
        }
    }

    public final void stopPlay() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.i.getControl().stopPlayback();
    }

    public final void t3(boolean z2) {
        yx8 yx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048679, this, z2) == null) || (yx8Var = this.W0) == null || yx8Var.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.W0.a().getLayoutParams();
        int i2 = 0;
        if (!z2) {
            int i3 = this.a;
            if (i3 != 4 && i3 != 3) {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight() - UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
            } else {
                i2 = TbadkCoreApplication.getInst().getKeyboardHeight();
            }
        }
        layoutParams.bottomMargin = i2;
        this.W0.a().requestLayout();
    }

    public final void t4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048680, this) == null) || T4()) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.b0 != null) {
            if (this.i.getParent() == null) {
                G4();
                H4();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.e0;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.n();
            }
            if (!UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                this.i.getControl().setIsVolume0(false);
            }
            this.i.getControl().P(this.s1);
            this.e0.p();
            this.B.setVisibility(8);
            Q4();
        }
        if (isResumed() && this.f0 && l4()) {
            return;
        }
        n4();
        if (this.B != null) {
            C4();
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            int i2 = this.a;
            if (i2 != 4 && i2 != 3) {
                u4(UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            } else {
                u4(0);
            }
        }
    }

    public final void u4(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048682, this, i2) == null) || (view2 = this.f) == null) {
            return;
        }
        view2.setPadding(0, 0, 0, i2);
    }

    public final void v3() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048683, this) == null) || (videoItemData = this.b0) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08084a, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080848, WebPManager.ResourceStateType.NORMAL));
        }
        D4(dh.g(this.b0.agree_num, 0L), this.R);
    }

    public final void v4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i2) == null) {
            N4(this.x, i2);
            N4(this.X, i2);
            N4(this.y, i2);
            N4(this.w, i2);
            N4(this.u, i2);
        }
    }

    public final void w3() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048685, this) == null) {
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null && (userItemData = videoItemData.author_info) != null && !this.A0 && (userItemData == null || !"1".equals(userItemData.is_follow))) {
                this.V.setVisibility(0);
                this.V.setClickable(true);
                return;
            }
            this.V.setVisibility(4);
            this.V.setClickable(false);
        }
    }

    public void w4(lx8 lx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048686, this, lx8Var) == null) {
            this.p1 = lx8Var;
        }
    }

    public void x3(int i2) {
        yx8 yx8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048687, this, i2) == null) || (yx8Var = this.W0) == null || yx8Var.a() == null) {
            return;
        }
        this.W0.a().w(i2);
    }

    public final void x4(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048688, this, i2) == null) || (videoItemData = this.b0) == null) {
            return;
        }
        boolean z2 = dh.e(videoItemData.video_height, 0) <= dh.e(this.b0.video_width, 0);
        if (this.b0.video_duration >= 60 && z2) {
            N4(this.g, i2);
        } else {
            N4(this.g, 8);
        }
    }

    public final void y3(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048689, this, z2) == null) || (videoMiddleNiaiControllerView = this.e0) == null) {
            return;
        }
        int i2 = this.a;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4) ? 1 : 0);
    }

    public final void y4(View view2, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048690, this, view2, f2) == null) || view2 == null) {
            return;
        }
        N4(view2, 0);
        view2.setAlpha(f2);
    }

    public final void z3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048691, this) == null) || g4() || this.A == null || this.z == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        this.z.clearAnimation();
        this.A.clearAnimation();
        this.z.setVisibility(8);
        this.A.setVisibility(0);
        this.A.startAnimation(scaleAnimation2);
        this.z.startAnimation(scaleAnimation);
    }

    public final void z4(float f2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048692, this, f2) == null) {
            y4(this.u, f2);
            y4(this.y, f2);
            y4(this.x, f2);
            y4(this.w, f2);
            View view2 = this.i1;
            if (view2 != null) {
                view2.setVisibility(0);
                this.i1.setAlpha(f2);
            }
            View view3 = this.j1;
            if (view3 != null) {
                view3.setVisibility(0);
                this.j1.setAlpha(f2);
            }
            View view4 = this.m;
            if (view4 != null) {
                view4.setVisibility(0);
                this.m.setAlpha(f2);
            }
            if (this.g != null && (videoItemData = this.b0) != null) {
                boolean z2 = dh.e(videoItemData.video_height, 0) <= dh.e(this.b0.video_width, 0);
                if (this.b0.video_duration >= 60 && z2) {
                    y4(this.g, f2);
                } else {
                    N4(this.g, 8);
                }
            }
            lx8 lx8Var = this.p1;
            if (lx8Var != null) {
                lx8Var.g(f2);
            }
        }
    }
}
