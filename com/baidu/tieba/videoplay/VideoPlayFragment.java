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
import com.baidu.tbadk.core.message.HistoryMessage;
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
import com.baidu.tbadk.switchs.DisableZanSwitch;
import com.baidu.tbadk.util.SimpleMessageListener;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.R;
import com.baidu.tieba.aaa;
import com.baidu.tieba.baa;
import com.baidu.tieba.bba;
import com.baidu.tieba.c55;
import com.baidu.tieba.caa;
import com.baidu.tieba.dj9;
import com.baidu.tieba.dx4;
import com.baidu.tieba.dx5;
import com.baidu.tieba.fy9;
import com.baidu.tieba.ij9;
import com.baidu.tieba.j55;
import com.baidu.tieba.j7a;
import com.baidu.tieba.j9;
import com.baidu.tieba.jd7;
import com.baidu.tieba.jy9;
import com.baidu.tieba.ka5;
import com.baidu.tieba.l55;
import com.baidu.tieba.ll9;
import com.baidu.tieba.m39;
import com.baidu.tieba.m75;
import com.baidu.tieba.mr5;
import com.baidu.tieba.n55;
import com.baidu.tieba.n75;
import com.baidu.tieba.n95;
import com.baidu.tieba.n9a;
import com.baidu.tieba.nf5;
import com.baidu.tieba.o5a;
import com.baidu.tieba.o75;
import com.baidu.tieba.o9a;
import com.baidu.tieba.oi9;
import com.baidu.tieba.ow9;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
import com.baidu.tieba.play.cyberPlayer.TbVideoViewSet;
import com.baidu.tieba.pr6;
import com.baidu.tieba.q9;
import com.baidu.tieba.qe5;
import com.baidu.tieba.qx4;
import com.baidu.tieba.ri9;
import com.baidu.tieba.rr5;
import com.baidu.tieba.taa;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tg;
import com.baidu.tieba.u9a;
import com.baidu.tieba.ui;
import com.baidu.tieba.vi;
import com.baidu.tieba.video.ActivityItemData;
import com.baidu.tieba.video.UserItemData;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.tieba.videoplay.danmu.DanmuPostDraftManager;
import com.baidu.tieba.videoplay.danmu.VideoDanmuController;
import com.baidu.tieba.videoplay.fragment.AbsVideoChannelFragment;
import com.baidu.tieba.videoplay.fragment.VideoVerticalPageFragment;
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.tieba.wg;
import com.baidu.tieba.x9a;
import com.baidu.tieba.xi9;
import com.baidu.tieba.y16;
import com.baidu.tieba.y9a;
import com.baidu.tieba.z26;
import com.baidu.tieba.zaa;
import com.baidu.tieba.zi9;
import com.baidu.tieba.zx9;
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
/* loaded from: classes8.dex */
public class VideoPlayFragment extends BaseFragment implements z26.b, zaa, OnStatusChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public int A0;
    public final CustomMessageListener A1;
    public ImageView B;
    public boolean B0;
    public final CustomMessageListener B1;
    public RelativeLayout C;
    public int C0;
    public final CustomMessageListener C1;
    public ImageView D;
    public String D0;
    public final CustomMessageListener D1;
    public LinearLayout E;
    public String E0;
    public final CustomMessageListener E1;
    public TextView F;
    public String F0;
    @NonNull
    public final BarManageResultListener F1;
    public ImageView G;
    public l55 G0;
    public final CustomMessageListener G1;
    public LinearLayout H;
    public n55 H0;
    public final VideoDanmuController.b H1;
    public BarImageView I;
    public ForumManageModel I0;
    public View.OnTouchListener I1;
    public ImageView J;
    public dx4 J0;
    public View.OnLongClickListener J1;
    public TextView K;
    public qe5 K0;
    public oi9.c K1;
    public ExpandableTextView L;
    public BdUniqueId L0;
    public TbImageView.f L1;
    public TextView M;
    public String M0;
    public SeekBar.OnSeekBarChangeListener M1;
    public View N;
    public boolean N0;
    public View.OnClickListener N1;
    public View O;
    public boolean O0;
    public View.OnClickListener O1;
    public View P;
    public RelativeLayout.LayoutParams P0;
    public View.OnClickListener P1;
    public EMTextView Q;
    public OnStatusChangedListener.VideoStatus Q0;
    public View.OnClickListener Q1;
    public EMTextView R;
    public String R0;
    public View.OnClickListener R1;
    public EMTextView S;
    public boolean S0;
    public Animation.AnimationListener S1;

    /* renamed from: T  reason: collision with root package name */
    public EMTextView f1176T;
    public boolean T0;
    public Runnable T1;
    public EMTextView U;
    public boolean U0;
    public Runnable U1;
    public TBSpecificationBtn V;
    public int V0;
    public x9a.b V1;
    public TextView W;
    public int W0;
    public GestureDetectorCompat W1;
    public View X;
    public taa X0;
    public VideoDanmuController.c X1;
    public LinearLayout Y;
    public aaa Y0;
    public View.OnClickListener Y1;
    public LinearLayout Z;
    public oi9.c Z0;
    public View.OnClickListener Z1;
    public int a;
    public LinearLayout a0;
    public i1 a1;
    public n55.e a2;
    public boolean b;
    public VideoItemData b0;
    public bba b1;
    public n55.e b2;
    public BdUniqueId c;
    public VideoItemModel c0;
    public o9a c1;
    public n55.e c2;
    public int d;
    public TextView d0;
    public AlertDialog d1;
    public n55.e d2;
    public int e;
    public VideoMiddleNiaiControllerView e0;
    public RelativeLayout e1;
    public Runnable e2;
    public View f;
    public boolean f0;
    public boolean f1;
    public ij9 f2;
    public View g;
    public AlphaAnimation g0;
    public TiePlusEventController g1;
    public CustomMessageListener g2;
    public RelativeLayout h;
    public Rect h0;
    public boolean h1;
    public CustomMessageListener h2;
    public TbVideoViewContainer i;
    public boolean i0;
    public y16 i1;
    public VideoDanmuController j;
    public ImageView j0;
    public boolean j1;
    public x9a k;
    public View k1;
    public TbImageView l;
    public View l1;
    public View m;
    public boolean m1;
    public ImageView n;
    public boolean n1;
    public ImageView o;
    public ObjectAnimator o1;
    public View p;
    public ObjectAnimator p1;
    public HeadImageView q;
    public o5a q1;
    public TBLottieAnimationView r;
    public ImageView r0;
    public boolean r1;
    public TBLottieAnimationView s;
    public ImageView s0;
    public n9a s1;
    public boolean t;
    public TextView t0;
    public int t1;
    public LinearLayout u;
    public View u0;
    public boolean u1;
    public LinearLayout v;
    public TextView v0;
    public final TbVideoViewSet.b v1;
    public LinearLayout w;
    public RelativeLayout.LayoutParams w0;
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

    /* loaded from: classes8.dex */
    public interface i1 {
        void a();

        void onStart();
    }

    public String a4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<String> d4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* renamed from: com.baidu.tieba.videoplay.VideoPlayFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0492a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0492a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    if (this.a.a.getActivity() == null) {
                        return;
                    }
                    this.a.a.U3();
                    this.a.a.m1 = true;
                    this.a.a.getActivity().finish();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.FALSE));
                    this.a.a.T4(1.0f);
                    this.a.a.E4();
                    this.a.a.f.setBackground(null);
                    this.a.a.e1.setVisibility(0);
                    this.a.a.e1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    super.onAnimationStart(animator);
                    if (this.a.a.w0 != null) {
                        this.a.a.w0.removeRule(14);
                    }
                }
            }
        }

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
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2921612 || this.a.getPageContext() == null) {
                return;
            }
            Configuration configuration = this.a.getPageContext().getPageActivity().getResources().getConfiguration();
            if (configuration != null && configuration.orientation == 2) {
                return;
            }
            int j = vi.j(this.a.f.getContext());
            if (this.a.isResumed() && this.a.f0) {
                if (this.a.a == 1) {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    VideoItemData videoItemData2 = videoPlayFragment2.b0;
                    if (videoItemData2 != null && videoItemData2.thread_id != null && videoPlayFragment2.getActivity() != null && (this.a.getActivity() instanceof VideoPlayActivity)) {
                        VideoPlayFragment videoPlayFragment3 = this.a;
                        if (ui.isEquals(videoPlayFragment3.b0.thread_id, ((VideoPlayActivity) videoPlayFragment3.getActivity()).v1()) && ((VideoPlayActivity) this.a.getActivity()).u1() != null) {
                            VideoPlayFragment videoPlayFragment4 = this.a;
                            videoPlayFragment4.h0 = ((VideoPlayActivity) videoPlayFragment4.getActivity()).u1();
                        }
                    }
                } else if (this.a.a == 7 && (videoItemData = (videoPlayFragment = this.a).b0) != null && videoItemData.thread_id != null && videoPlayFragment.getActivity() != null && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                    VideoPlayFragment videoPlayFragment5 = this.a;
                    if (ui.isEquals(videoPlayFragment5.b0.thread_id, ((FrsVideoTabPlayActivity) videoPlayFragment5.getActivity()).y1()) && ((FrsVideoTabPlayActivity) this.a.getActivity()).x1() != null) {
                        VideoPlayFragment videoPlayFragment6 = this.a;
                        videoPlayFragment6.h0 = ((FrsVideoTabPlayActivity) videoPlayFragment6.getActivity()).x1();
                    }
                }
                if ((this.a.a == 1 || this.a.a == 7) && this.a.h0 != null) {
                    VideoPlayFragment videoPlayFragment7 = this.a;
                    videoPlayFragment7.x0 = videoPlayFragment7.h0.right - this.a.h0.left;
                    VideoPlayFragment videoPlayFragment8 = this.a;
                    videoPlayFragment8.y0 = videoPlayFragment8.h0.bottom - this.a.h0.top;
                    VideoPlayFragment videoPlayFragment9 = this.a;
                    videoPlayFragment9.z0 = videoPlayFragment9.h0.left;
                    VideoPlayFragment videoPlayFragment10 = this.a;
                    videoPlayFragment10.A0 = videoPlayFragment10.h0.top;
                    if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                        VideoPlayFragment videoPlayFragment11 = this.a;
                        videoPlayFragment11.m4(videoPlayFragment11.i, this.a.l, this.a.e1, this.a.w0.leftMargin, this.a.z0, this.a.w0.topMargin, this.a.A0, this.a.w0.width, this.a.x0, this.a.w0.height, this.a.y0, j, this.a.y0, 0, this.a.A0, new C0492a(this));
                    }
                } else if (this.a.getActivity() != null) {
                    this.a.getActivity().finish();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l0 implements n55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes8.dex */
        public class a implements c55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c55 a;
            public final /* synthetic */ l0 b;

            public a(l0 l0Var, c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var, c55Var};
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
                this.a = c55Var;
            }

            @Override // com.baidu.tieba.c55.e
            public void onClick(c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
                    this.a.dismiss();
                    VideoPlayFragment videoPlayFragment = this.b.a;
                    if (videoPlayFragment.b0 == null) {
                        return;
                    }
                    ForumManageModel forumManageModel = videoPlayFragment.I0;
                    VideoPlayFragment videoPlayFragment2 = this.b.a;
                    VideoItemData videoItemData = videoPlayFragment2.b0;
                    forumManageModel.q0(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.B0, null, false);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements c55.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c55 a;

            public b(l0 l0Var, c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var, c55Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c55Var;
            }

            @Override // com.baidu.tieba.c55.e
            public void onClick(c55 c55Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, c55Var) == null) {
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

        @Override // com.baidu.tieba.n55.e
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G0.dismiss();
                c55 c55Var = new c55(this.a.getActivity());
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    c55Var.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    c55Var.setMessageId(R.string.del_thread_confirm);
                }
                c55Var.setPositiveButton(R.string.obfuscated_res_0x7f0f058f, new a(this, c55Var));
                c55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0584, new b(this, c55Var));
                c55Var.setCancelable(true);
                c55Var.create(this.a.getPageContext());
                c55Var.show();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes8.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q a;

            public a(q qVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = qVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.a.i0 = true;
                    if (this.a.a.w0 != null) {
                        this.a.a.w0.addRule(14);
                    }
                }
            }
        }

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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            RelativeLayout.LayoutParams c4 = this.a.c4();
            VideoPlayFragment videoPlayFragment = this.a;
            videoPlayFragment.s5(videoPlayFragment.i, this.a.l, this.a.z0, c4.leftMargin, this.a.A0, c4.topMargin, this.a.x0, c4.width, this.a.y0, c4.height, new a(this));
        }
    }

    /* loaded from: classes8.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes8.dex */
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
                    this.a.a.f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    this.a.a.e1.setBackground(null);
                    this.a.a.e1.setVisibility(8);
                    this.a.a.i0 = true;
                    if (this.a.a.w0 != null) {
                        this.a.a.w0.addRule(14);
                    }
                    this.a.a.U4(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.a.f.setBackground(null);
                    super.onAnimationStart(animator);
                    this.a.a.e1.setVisibility(0);
                    if (this.a.a.l != null) {
                        this.a.a.l.setVisibility(8);
                    }
                    this.a.a.e1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
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
                int j = vi.j(this.a.f.getContext());
                RelativeLayout.LayoutParams c4 = this.a.c4();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.m4(videoPlayFragment.i, this.a.l, this.a.e1, this.a.z0, c4.leftMargin, this.a.A0, c4.topMargin, this.a.x0, c4.width, this.a.y0, c4.height, this.a.y0, j, this.a.A0, 0, new a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements VideoDanmuController.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ThreadData a;
            public final /* synthetic */ u b;

            public a(u uVar, ThreadData threadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {uVar, threadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = uVar;
                this.a = threadData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.getContext() == null) {
                    return;
                }
                this.b.a.b0.parseProto(this.a);
                this.b.a.b0.reGenerateTitle();
                VideoPlayFragment videoPlayFragment = this.b.a;
                videoPlayFragment.b0.threadData = this.a;
                videoPlayFragment.Z4();
                this.b.a.a5();
                VideoItemData videoItemData = this.b.a.b0;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    VideoPlayFragment videoPlayFragment2 = this.b.a;
                    videoPlayFragment2.c5(videoPlayFragment2.b0, videoPlayFragment2.b1, this.b.a.j);
                    VideoPlayFragment videoPlayFragment3 = this.b.a;
                    videoPlayFragment3.d5(videoPlayFragment3.b0.video_url);
                    if (this.b.a.b0.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.b.a.b0.author_info.user_id)) {
                        this.b.a.B0 = true;
                    }
                    this.b.a.R3();
                    VideoPlayFragment videoPlayFragment4 = this.b.a;
                    videoPlayFragment4.setUserVisibleHint(videoPlayFragment4.f0);
                }
            }
        }

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
            this.a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.videoplay.danmu.VideoDanmuController.c
        public boolean a(@Nullable ThreadData threadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
                wg.a().post(new a(this, threadData));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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

        public static void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                SimpleMessageListener.f(2001457, null);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (videoItemData = (videoPlayFragment = this.a).b0) != null && videoItemData.thread_id != null) {
                TiebaPlusConfigData.dealFireLinkWithTid(videoPlayFragment.getPageContext(), this.a.b0.thread_id);
                int i = 7;
                if (this.a.a != 1 && this.a.a != 2) {
                    if (this.a.a != 3) {
                        int unused = this.a.a;
                    }
                } else {
                    i = 6;
                }
                TiebaPlusConfigData.addClickStatsForFireLink(i);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isPrimary() && this.a.f0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zi9)) {
                zi9 zi9Var = (zi9) customResponsedMessage.getData();
                SeekBar seekBar = this.a.e0.getSeekBar();
                int i = zi9Var.a;
                if (i == 1) {
                    seekBar.setProgress(zi9Var.b);
                    this.a.e0.n(seekBar, zi9Var.b, true);
                } else if (i == 2) {
                    this.a.e0.o(seekBar);
                } else if (i == 3) {
                    this.a.e0.p(seekBar);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SimpleMessageListener.b<BarManageResultListener.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public b(VideoPlayFragment videoPlayFragment) {
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, aVar) != null) || aVar == null) {
                return;
            }
            ThreadData threadData = this.a.b0.threadData;
            if (threadData != null && aVar.d()) {
                int i = d1.a[aVar.c().ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i == 4) {
                                threadData.setAddedGood(false);
                            }
                        } else {
                            threadData.setAddedGood(true);
                        }
                    } else {
                        threadData.setMadeTop(false);
                    }
                } else {
                    threadData.setMadeTop(true);
                }
            }
            this.a.showToast(aVar.b());
        }
    }

    /* loaded from: classes8.dex */
    public class b0 extends j9 {
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

        @Override // com.baidu.tieba.j9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.I0.getLoadDataMode() == 0) {
                if (this.a.p4()) {
                    if ((obj instanceof ForumManageModel.b) && this.a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.g(this.a.getPageContext(), Pair.create(Boolean.valueOf(bVar.a), bVar.b));
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

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zx9)) {
                AgreeData agreeData = ((zx9) customResponsedMessage.getData()).b;
                if (this.a.b0 != null && agreeData != null) {
                    String str = agreeData.nid;
                    String str2 = "0";
                    if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                        BaijiahaoData baijiahaoData = this.a.b0.baijiahaoData;
                        if (baijiahaoData != null && TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                            this.a.b0.agree_num = String.valueOf(agreeData.agreeNum);
                            VideoItemData videoItemData = this.a.b0;
                            if (agreeData.hasAgree) {
                                str2 = "1";
                            }
                            videoItemData.is_agreed = str2;
                            this.a.M3();
                            return;
                        }
                        return;
                    }
                    String str3 = agreeData.threadId;
                    String str4 = this.a.b0.thread_id;
                    if (!"0".equals(str3) && !TextUtils.isEmpty(str3) && TextUtils.equals(str3, str4)) {
                        this.a.b0.agree_num = String.valueOf(agreeData.agreeNum);
                        VideoItemData videoItemData2 = this.a.b0;
                        if (agreeData.hasAgree) {
                            str2 = "1";
                        }
                        videoItemData2.is_agreed = str2;
                        this.a.M3();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(VideoPlayFragment videoPlayFragment, int i) {
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
                boolean m = ((caa) this.a.Y0.b().p(28)).h().m();
                if (booleanValue) {
                    this.a.K3(false);
                } else if (m) {
                    this.a.K3(true);
                } else {
                    this.a.l4();
                }
                ((caa) this.a.Y0.b().p(28)).h().setEmotionClick(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c0 implements dx4.a {
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

        @Override // com.baidu.tieba.dx4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.J0 != null) {
                        this.a.J0.h(z2);
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
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
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
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                if (this.a.p1 == null) {
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.p1 = videoPlayFragment.f4(1.0f, 1.0f, 1.0f, 100L);
                }
                this.a.p1.start();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements VideoDanmuController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public d(VideoPlayFragment videoPlayFragment) {
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
        public boolean a(@Nullable jy9 jy9Var, @Nullable m39 m39Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jy9Var, m39Var)) == null) {
                if (this.a.j != null) {
                    this.a.j.P("c14478");
                }
                if (jy9Var == null) {
                    return false;
                }
                this.a.h4(jy9Var.O(), true);
                MessageManager.getInstance().registerStickyMode(2921648);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921648, m39Var));
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class e implements View.OnTouchListener {
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

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return this.a.W1.onTouchEvent(motionEvent);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class e0 implements n55.c {
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

        @Override // com.baidu.tieba.n55.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.k4();
            }
        }
    }

    /* loaded from: classes8.dex */
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
            BdUniqueId tag;
            int statusBarHeight;
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.T0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.c.getId() == tag.getId() && (customResponsedMessage.getData() instanceof Float) && this.a.b0 != null) {
                float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
                float f = 0.0f;
                if (floatValue >= 0.0f && floatValue <= 1.0f) {
                    int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds562);
                    int b4 = this.a.b4();
                    int e = tg.e(this.a.b0.video_height, 0);
                    int e2 = tg.e(this.a.b0.video_width, 0);
                    if (e != 0 && e2 != 0) {
                        f = (e * 1.0f) / e2;
                    }
                    if (e > e2) {
                        return;
                    }
                    int l = vi.l(this.a.f.getContext());
                    float f2 = l * f;
                    int g = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds166);
                    if (f > 1.0f) {
                        i = (int) (dimenPixelSize + ((b4 - dimenPixelSize) * floatValue));
                        i2 = (int) (i / f);
                        float f3 = 1.0f - floatValue;
                        statusBarHeight = (int) (UtilHelper.getStatusBarHeight() * f3);
                        this.a.P0.topMargin = (int) (((b4 - g) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f3) + (f3 * (dimenPixelSize - g) * 0.5f));
                    } else {
                        float f4 = dimenPixelSize;
                        float f5 = 1.0f - floatValue;
                        statusBarHeight = (int) (((b4 - f2) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f5));
                        this.a.P0.topMargin = (int) (((b4 - g) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f5) + (f5 * (dimenPixelSize - g) * 0.5f));
                        i = (int) (f4 + ((f2 - f4) * floatValue));
                        i2 = l;
                    }
                    this.a.w0.height = i;
                    this.a.w0.width = i2;
                    this.a.w0.topMargin = statusBarHeight;
                    this.a.B.requestLayout();
                    this.a.i.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view2)) != null) {
                return invokeL.booleanValue;
            }
            this.a.m5();
            this.a.f.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    /* loaded from: classes8.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            this.a.G0 = null;
            this.a.H0 = null;
        }
    }

    /* loaded from: classes8.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (!this.a.T0) {
                    return;
                }
                if (bool.booleanValue() || !this.a.C4()) {
                    this.a.startPlay();
                    this.a.E4();
                    return;
                }
                this.a.startPlay();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements oi9.c {
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

        @Override // com.baidu.tieba.oi9.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) && this.a.Z0 != null) {
                this.a.Z0.a(i, i2);
                if (!this.a.j1) {
                    return;
                }
                this.a.H4(i2, i);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.a data = updateAttentionMessage.getData();
            VideoItemData videoItemData = this.a.b0;
            if (videoItemData != null && (userItemData = videoItemData.author_info) != null && !StringUtils.isNull(userItemData.user_id) && data != null && this.a.b0.author_info.user_id.equals(data.c)) {
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.a.L0)) ? false : false;
                if (data.i != null) {
                    return;
                }
                if (!data.a) {
                    if (z && !"0".equals(this.a.b0.author_info.is_follow)) {
                        vi.P(this.a.getActivity(), R.string.attention_fail);
                        VideoPlayFragment videoPlayFragment = this.a;
                        videoPlayFragment.b0.author_info.is_follow = "0";
                        videoPlayFragment.N3();
                        return;
                    }
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.b0.author_info.is_follow = "0";
                    videoPlayFragment2.N3();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.a.b0));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.b0.author_info.is_follow = "1";
                    videoPlayFragment3.N3();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.a.E0)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.T0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (!this.a.C4()) {
                        return;
                    }
                    this.a.startPlay();
                    return;
                }
                this.a.x5();
                this.a.E4();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

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

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.a.C.setVisibility(8);
                this.a.i.getControl().setCanShowPause(true);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.r5(true);
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.T0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.a.T0) {
                this.a.T0 = false;
                if (this.a.s1 != null) {
                    this.a.s1.d(this.a.T0);
                }
                if (this.a.j != null) {
                    this.a.j.a0();
                    if (this.a.C4()) {
                        this.a.j.V();
                    }
                }
                this.a.b1.b0(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements SeekBar.OnSeekBarChangeListener {
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

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                this.a.X3(true);
                EMTextView eMTextView = this.a.f1176T;
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
                this.a.S0 = true;
                if (this.a.e0 != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.a.e0;
                    if (this.a.a != 4 && this.a.a != 3) {
                        i = 0;
                    }
                    videoMiddleNiaiControllerView.setBottomBarShow(false, i);
                }
                this.a.t5();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.a.isResumed() && this.a.f0) {
                    this.a.e0.setLoading(true);
                }
                this.a.S0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(null);
                    this.a.X3(false);
                    if (!this.a.i.getControl().isPlaying()) {
                        this.a.i.getControl().start();
                        this.a.B.setVisibility(8);
                    }
                    if (!this.a.T0 && (!this.a.isResumed() || !this.a.f0)) {
                        this.a.E4();
                    }
                    wg.a().removeCallbacks(this.a.e2);
                    wg.a().postDelayed(this.a.e2, 3000L);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i0 implements n55.e {
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

        @Override // com.baidu.tieba.n55.e
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.G0 != null) {
                    this.a.G0.dismiss();
                }
                this.a.r5(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            UserItemData userItemData;
            boolean z;
            String str;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z2 = true;
                if (view2.getId() == R.id.portrait_container && (videoItemData = this.a.b0) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
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
                if (videoItemData2 != null && (userItemData = videoItemData2.author_info) != null) {
                    long g = tg.g(userItemData.user_id, 0L);
                    long g2 = tg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                    if (g != g2) {
                        z2 = false;
                    }
                    if (g == 0 && g2 == 0) {
                        z = false;
                    } else {
                        z = z2;
                    }
                    String str2 = this.a.b0.author_info.portrait;
                    PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(this.a.getActivity());
                    if (this.a.a != 3 && this.a.a != 4) {
                        str = PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE;
                    } else {
                        str = PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL;
                    }
                    PersonPolymericActivityConfig createNormalConfig = personPolymericActivityConfig.createNormalConfig(g, z, false, true, str);
                    createNormalConfig.setPortrait(str2);
                    createNormalConfig.setSourceTid(this.a.b0.thread_id);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                    StatisticItem statisticItem2 = new StatisticItem("c12798");
                    statisticItem2.param("tid", this.a.b0.thread_id);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem2);
                    this.a.Z3(5);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j0 implements n55.e {
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

        @Override // com.baidu.tieba.n55.e
        public void onClick() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.a.getContext())) {
                    if (this.a.G0 != null) {
                        this.a.G0.dismiss();
                        return;
                    }
                    return;
                }
                if (this.a.G0 != null) {
                    this.a.G0.dismiss();
                }
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                if (str != null && str.equals(videoItemData.mark_id)) {
                    z = true;
                } else {
                    z = false;
                }
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.a.b0.thread_id);
                markData.setPostId(this.a.b0.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.a.b0.thread_id);
                markData.setForumId(this.a.b0.forum_id);
                if (this.a.J0 != null) {
                    this.a.J0.i(markData);
                    if (!z) {
                        this.a.J0.a();
                    } else {
                        this.a.J0.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements TbVideoViewSet.b {
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

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null && this.a.i.getControl() != null) {
                VideoPlayFragment videoPlayFragment = this.a;
                if (videoPlayFragment.b0 != null) {
                    videoPlayFragment.i.getControl().setVideoPath(this.a.M0, this.a.b0.thread_id);
                }
            }
        }

        @Override // com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.i != null && this.a.i.getControl() != null) {
                this.a.i.a();
                this.a.i.getControl().setStageType("2005");
                this.a.i.getControl().setLocateSource("v_mid_page");
                this.a.i.getControl().setContinuePlayEnable(true);
                if (this.a.w0 != null) {
                    this.a.l.setLayoutParams(this.a.w0);
                    if (this.a.h != null && this.a.i != null) {
                        this.a.h.addView(this.a.i, 0, this.a.w0);
                    }
                } else {
                    this.a.a5();
                }
                this.a.b5();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k0 implements n55.e {
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

        @Override // com.baidu.tieba.n55.e
        public void onClick() {
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.G0.dismiss();
                if (!ViewHelper.checkUpIsLogin(this.a.getActivity()) || this.a.getPageContext() == null) {
                    return;
                }
                if (this.a.q1 == null && (runTask = MessageManager.getInstance().runTask(2921343, o5a.class, this.a.getContext())) != null) {
                    this.a.q1 = (o5a) runTask.getData();
                }
                if (this.a.q1 != null) {
                    VideoPlayFragment videoPlayFragment = this.a;
                    if (videoPlayFragment.b0 != null) {
                        videoPlayFragment.q1.b(this.a.getUniqueId());
                        this.a.q1.a(this.a.b0.post_id);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() != this.a.o.getId()) {
                    if (view2.getId() == this.a.n.getId()) {
                        VideoItemData videoItemData = this.a.b0;
                        if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.a.b0.thread_id));
                        }
                        this.a.getActivity().finish();
                        return;
                    } else if (view2.getId() != this.a.L.getId()) {
                        if (view2.getId() == this.a.y.getId()) {
                            if (AntiHelper.c(this.a.getPageContext(), this.a.b0)) {
                                return;
                            }
                            this.a.g4();
                            StatisticItem statisticItem = new StatisticItem("c12796");
                            statisticItem.param("tid", this.a.b0.thread_id);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            TiebaStatic.log(statisticItem);
                            this.a.Z3(2);
                            return;
                        } else if (view2.getId() == this.a.Z.getId()) {
                            VideoPlayFragment videoPlayFragment = this.a;
                            VideoItemData videoItemData2 = videoPlayFragment.b0;
                            if (videoItemData2 != null && videoItemData2.act_info != null) {
                                qx4.q(videoPlayFragment.getActivity(), this.a.b0.act_info.link_url);
                                StatisticItem statisticItem2 = new StatisticItem("c12799");
                                statisticItem2.param("tid", this.a.b0.thread_id);
                                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                TiebaStatic.log(statisticItem2);
                                return;
                            }
                            return;
                        } else if (view2.getId() == this.a.d0.getId()) {
                            String s = n95.m().s("nani_key_download_link_url", null);
                            if (!TextUtils.isEmpty(s)) {
                                UrlManager.getInstance().dealOneLink((TbPageContext) q9.a(this.a.getPageContext().getPageActivity()), new String[]{s}, true);
                                return;
                            }
                            return;
                        } else if (view2.getId() == this.a.u0.getId()) {
                            VideoPlayFragment videoPlayFragment2 = this.a;
                            if (!videoPlayFragment2.S3(videoPlayFragment2.getPageContext(), 25066)) {
                                return;
                            }
                            this.a.p5();
                            if (this.a.b0 != null) {
                                StatisticItem statisticItem3 = new StatisticItem("c13025");
                                statisticItem3.param("tid", this.a.b0.thread_id);
                                statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                statisticItem3.param("fid", this.a.b0.forum_id);
                                TiebaStatic.log(statisticItem3);
                            }
                            if (this.a.j != null) {
                                this.a.j.P("c14475");
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else {
                        this.a.g4();
                        this.a.Z3(7);
                        return;
                    }
                }
                this.a.m5();
            }
        }
    }

    /* loaded from: classes8.dex */
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
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.W3(videoPlayFragment.d);
            }
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.q5();
            StatisticItem statisticItem = new StatisticItem("c12797");
            statisticItem.param("tid", this.a.b0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.a.Z3(3);
            StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
            statisticItem2.param("tid", this.a.b0.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem2.param("obj_locate", 19);
            statisticItem2.param("nid", this.a.b0.nid);
            BaijiahaoData baijiahaoData = this.a.b0.baijiahaoData;
            if (baijiahaoData != null && !ui.isEmpty(baijiahaoData.oriUgcVid)) {
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
            if (rr5.j(this.a.getBaseFragmentActivity()) != null && rr5.j(this.a.getBaseFragmentActivity()).b() != null && rr5.j(this.a.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(rr5.j(this.a.getBaseFragmentActivity()).b().locatePage)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                return;
            }
            if (this.a.V != null && (videoItemData = (videoPlayFragment = this.a).b0) != null && videoItemData.author_info != null && videoPlayFragment.s != null) {
                qe5 qe5Var = videoPlayFragment.K0;
                VideoPlayFragment videoPlayFragment2 = this.a;
                UserItemData userItemData = videoPlayFragment2.b0.author_info;
                String str = userItemData.portrait;
                String str2 = userItemData.user_id;
                BdUniqueId bdUniqueId = videoPlayFragment2.L0;
                VideoItemData videoItemData2 = this.a.b0;
                qe5Var.j(true, str, str2, false, "6", bdUniqueId, videoItemData2.forum_id, "0", videoItemData2.thread_id);
                VideoPlayFragment videoPlayFragment3 = this.a;
                videoPlayFragment3.b0.author_info.is_follow = "1";
                videoPlayFragment3.N3();
                this.a.V.setVisibility(8);
                this.a.F4();
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
            if (this.a.a != 3 && this.a.a != 4) {
                statisticItem.param("obj_locate", 2);
                if (this.a.a == 7) {
                    statisticItem.param("obj_source", 8);
                } else {
                    statisticItem.param("obj_source", this.a.e4());
                }
            } else {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("tid", this.a.b0.thread_id);
            statisticItem.param("fid", this.a.b0.forum_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.a.Z3(6);
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.i1 != null) {
                this.a.i1.q(TiePlusStat.StatType.CLICK);
                this.a.g1.q(this.a.i1);
                this.a.g1.m(this.a.i1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

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

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, animation) == null) && this.a.l != null) {
                this.a.l.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p0 implements Runnable {
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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.a.S0) {
                this.a.P3(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(VideoPlayFragment videoPlayFragment, int i) {
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
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    vi.P(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0def);
                } else if (this.a.n5()) {
                } else {
                    this.a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            int i;
            int i2;
            int i3;
            float f;
            float f2;
            boolean z;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i4 = (int) (this.a * animatedFraction);
                int i5 = (int) (this.b * animatedFraction);
                int i6 = this.c;
                if (i6 > this.d) {
                    i = i6 - i4;
                } else {
                    i = i6 + i4;
                }
                int i7 = this.e;
                if (i7 > this.f) {
                    i2 = i7 - i5;
                } else {
                    i2 = i7 + i5;
                }
                this.g.topMargin = i2;
                this.s.w0.topMargin = i;
                int i8 = (int) (this.h * animatedFraction);
                int i9 = this.i;
                if (i9 > this.j) {
                    i3 = i9 - i8;
                } else {
                    i3 = i9 + i8;
                }
                this.s.w0.leftMargin = i3;
                this.s.w0.rightMargin = i3;
                RelativeLayout.LayoutParams layoutParams = this.g;
                layoutParams.leftMargin = i3;
                layoutParams.rightMargin = i3;
                float f4 = this.k * animatedFraction;
                float f5 = this.l * animatedFraction;
                int i10 = this.m;
                if (i10 > this.n) {
                    f = i10 - f4;
                } else {
                    f = i10 + f4;
                }
                int i11 = this.o;
                if (i11 > this.p) {
                    f2 = i11 - f5;
                    f3 = 1.0f - animatedFraction;
                    z = false;
                } else {
                    f2 = i11 + f5;
                    z = true;
                    f3 = animatedFraction;
                }
                this.s.w0.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.s.w0.height = (int) f;
                RelativeLayout.LayoutParams layoutParams2 = this.g;
                layoutParams2.height = (int) f2;
                layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.q.setLayoutParams(this.g);
                this.q.setAlpha(f3);
                if (z && f3 > 0.5f) {
                    this.s.T4((f3 - 0.5f) * 2.0f);
                } else if (!z && animatedFraction < 0.25f) {
                    this.s.T4(1.0f - (animatedFraction * 4.0f));
                }
                this.r.setLayoutParams(this.s.w0);
                this.r.requestLayout();
                this.q.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class s implements x9a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

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

        @Override // com.baidu.tieba.x9a.b
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && this.a.j != null && this.a.k != null) {
                if (z && this.a.isResumed()) {
                    this.a.j.a0();
                    if (this.a.i.getControl().isPlaying()) {
                        this.a.j.V();
                    } else {
                        this.a.j.S();
                    }
                } else {
                    this.a.j.S();
                    this.a.j.I();
                }
                this.a.k.j(z);
            }
        }
    }

    /* loaded from: classes8.dex */
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
            int i;
            int i2;
            float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i3 = (int) (this.a * animatedFraction);
                int i4 = this.b;
                if (i4 > this.c) {
                    i = i4 - i3;
                } else {
                    i = i4 + i3;
                }
                this.l.w0.topMargin = i;
                int i5 = (int) (this.d * animatedFraction);
                int i6 = this.e;
                if (i6 > this.f) {
                    i2 = i6 - i5;
                } else {
                    i2 = i6 + i5;
                }
                this.l.w0.leftMargin = i2;
                this.l.w0.rightMargin = i2;
                float f2 = animatedFraction * this.g;
                int i7 = this.h;
                if (i7 > this.i) {
                    f = i7 - f2;
                } else {
                    f = i7 + f2;
                }
                this.l.w0.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.l.w0.height = (int) f;
                this.j.setLayoutParams(this.l.w0);
                this.k.setLayoutParams(this.l.w0);
                this.j.requestLayout();
                this.k.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final dx5<String> a;
        public final /* synthetic */ VideoPlayFragment b;

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
            this.b = videoPlayFragment;
            this.a = new dx5<>(300, TimeUnit.MILLISECONDS);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.a.a("onTouchDownEvent")) {
                    return super.onDoubleTap(motionEvent);
                }
                this.b.u0(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.b.w5()) {
                    this.a.a("onTouchDownEvent");
                }
                return super.onDown(motionEvent);
            }
            return invokeL.booleanValue;
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
    }

    /* loaded from: classes8.dex */
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
                this.a.b1.Y();
                VideoPlayFragment videoPlayFragment = this.a;
                VideoItemData videoItemData = videoPlayFragment.b0;
                if (videoItemData == null) {
                    return;
                }
                videoPlayFragment.u5(videoItemData.thread_id, false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u0 implements ij9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        @Override // com.baidu.tieba.ij9
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ij9
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ij9
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ij9
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ij9
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ij9
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

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
        public boolean onError(int i, int i2, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i, i2, obj)) == null) {
                return false;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.tieba.ij9
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

        @Override // com.baidu.tieba.ij9
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ij9
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void setStatistic(dj9 dj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, dj9Var) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.baidu.tieba.ij9
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }

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

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.i != null && this.a.i.getControl() != null) {
                this.a.i.getControl().I();
                this.a.i.getControl().seekTo(0);
                if (UbsABTestHelper.isAutoPlayNextVideo() && (this.a.a == 1 || this.a.a == 2)) {
                    if (this.a.a1 != null && !this.a.T0) {
                        this.a.a1.a();
                        this.a.l.setVisibility(8);
                        this.a.i.getControl().start();
                    } else {
                        this.a.i.getControl().start();
                    }
                } else if (!UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    this.a.i.getControl().start();
                }
                this.a.J4();
                VideoPlayFragment.y3(this.a);
                if (this.a.V0 == 3) {
                    this.a.Q3();
                }
                if (!this.a.T0) {
                    if (this.a.isResumed() && this.a.f0) {
                        return;
                    }
                    this.a.E4();
                }
            }
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
                if (i == 10012 && this.a.X0 != null) {
                    this.a.X0.c();
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.a.i != null && this.a.i.getControl() != null) {
                if (this.a.e0 != null) {
                    this.a.e0.setVisibility(0);
                    if (this.a.e0.getCurProgress() == 0) {
                        this.a.e0.t();
                        return;
                    }
                    return;
                }
                this.a.e0.setVisibility(8);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(VideoPlayFragment videoPlayFragment, int i) {
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
                videoPlayFragment.i5(videoPlayFragment.B0, booleanValue);
            }
        }
    }

    /* loaded from: classes8.dex */
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
                if (this.c.d1 != null) {
                    this.c.d1.dismiss();
                }
                if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                    vi.P(this.c.getContext(), R.string.obfuscated_res_0x7f0f0def);
                    return;
                }
                ForumManageModel forumManageModel = this.c.I0;
                VideoItemData videoItemData = this.c.b0;
                forumManageModel.q0(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.a, null, this.b);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w implements bba.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bba a;
        public final /* synthetic */ VideoDanmuController b;
        public final /* synthetic */ VideoPlayFragment c;

        public w(VideoPlayFragment videoPlayFragment, bba bbaVar, VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, bbaVar, videoDanmuController};
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
            this.a = bbaVar;
            this.b = videoDanmuController;
        }

        @Override // com.baidu.tieba.bba.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.stopPlay();
                    this.c.startPlay();
                    VideoDanmuController videoDanmuController = this.b;
                    if (videoDanmuController != null) {
                        videoDanmuController.c0(this.a.L0());
                        return;
                    }
                    return;
                }
                bba bbaVar = this.a;
                if (bbaVar != null) {
                    VideoDanmuController videoDanmuController2 = this.b;
                    if (videoDanmuController2 != null) {
                        bbaVar.Q0(videoDanmuController2.G());
                    }
                    this.c.E4();
                    this.a.t0(true);
                    this.a.startPlay();
                    VideoDanmuController videoDanmuController3 = this.b;
                    if (videoDanmuController3 != null) {
                        videoDanmuController3.S();
                        this.b.T();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.d1 != null) {
                this.a.d1.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public x(VideoPlayFragment videoPlayFragment) {
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
                this.a.i.setLayoutParams(this.a.c4());
            }
        }
    }

    /* loaded from: classes8.dex */
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
                if (this.a.w0 != null) {
                    this.a.w0.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                }
                this.a.i.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y implements baa.b {
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

        @Override // com.baidu.tieba.baa.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && this.a.j != null) {
                this.a.j.W(str);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public y0(VideoPlayFragment videoPlayFragment) {
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
                if (this.a.w0 != null) {
                    this.a.w0.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                }
                this.a.i.requestLayout();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z implements aaa.d {
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

        @Override // com.baidu.tieba.aaa.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    this.a.u0.setVisibility(0);
                } else {
                    this.a.u0.setVisibility(8);
                }
                if (z) {
                    this.a.T3("");
                    if (this.a.j != null) {
                        this.a.j.P("c14476");
                    }
                } else {
                    this.a.T3(((caa) this.a.Y0.b().p(28)).g().getText().toString());
                }
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData != null && z) {
                    long g = tg.g(videoItemData.comment_num, 0L) + 1;
                    this.a.b0.comment_num = String.valueOf(g);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.X4(g, videoPlayFragment.Q);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
                this.a.L3();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z0(VideoPlayFragment videoPlayFragment, int i) {
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof fy9)) {
                fy9 fy9Var = (fy9) customResponsedMessage.getData();
                VideoItemData videoItemData = this.a.b0;
                if (videoItemData != null && (threadData = videoItemData.threadData) != null && TextUtils.equals(threadData.getTid(), fy9Var.a)) {
                    this.a.b0.threadData.setIsMarked(fy9Var.b ? 1 : 0);
                }
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
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = BdUniqueId.gen();
        this.N0 = false;
        this.O0 = false;
        this.Q0 = OnStatusChangedListener.VideoStatus.INIT;
        this.U0 = false;
        this.V0 = 1;
        this.W0 = -1;
        this.h1 = false;
        this.j1 = true;
        this.m1 = false;
        this.n1 = false;
        this.o1 = null;
        this.p1 = null;
        this.r1 = false;
        this.t1 = -1;
        this.u1 = false;
        this.v1 = new k(this);
        this.w1 = new v(this, 2921607);
        this.x1 = new g0(this, 2001115);
        this.y1 = new q0(this, 2000994);
        this.z1 = new b1(this, 2016528);
        this.A1 = new e1(this, 2921594);
        this.B1 = new f1(this, 2001011);
        this.C1 = new g1(this, 2921596);
        this.D1 = new h1(this, 2921598);
        this.E1 = new a(this, 2921612);
        this.F1 = new BarManageResultListener(new b(this));
        this.G1 = new c(this, 2921645);
        this.H1 = new d(this);
        this.I1 = new e(this);
        this.J1 = new f(this);
        this.K1 = new g(this);
        this.L1 = new h(this);
        this.M1 = new i(this);
        this.N1 = new j(this);
        this.O1 = new l(this);
        this.P1 = new m(this);
        this.Q1 = new n(this);
        this.R1 = new o(this);
        this.S1 = new p(this);
        this.T1 = new q(this);
        this.U1 = new r(this);
        this.V1 = new s(this);
        this.W1 = new GestureDetectorCompat(getContext(), new t(this));
        this.X1 = new u(this);
        this.Y1 = new a0(this);
        this.Z1 = new h0(this);
        this.a2 = new i0(this);
        this.b2 = new j0(this);
        this.c2 = new k0(this);
        this.d2 = new l0(this);
        this.e2 = new p0(this);
        this.f2 = new u0(this);
        this.g2 = new z0(this, 2921603);
        this.h2 = new a1(this, 2921635);
    }

    public void a5() {
        TbVideoViewContainer tbVideoViewContainer;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        TbVideoViewContainer tbVideoViewContainer2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getParent() == null) {
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null && TextUtils.isEmpty(videoItemData.video_height) && TextUtils.isEmpty(this.b0.video_width)) {
                return;
            }
            if (this.b0 != null) {
                this.w0 = new RelativeLayout.LayoutParams(-1, -1);
                Z4();
                Rect rect = this.h0;
                if (rect != null && !this.i0) {
                    int i2 = rect.right;
                    int i3 = rect.left;
                    this.x0 = i2 - i3;
                    int i4 = rect.bottom;
                    int i5 = rect.top;
                    this.y0 = i4 - i5;
                    RelativeLayout.LayoutParams layoutParams = this.w0;
                    layoutParams.width = i2 - i3;
                    layoutParams.height = i4 - i5;
                    layoutParams.topMargin = i5;
                    layoutParams.leftMargin = i3;
                    layoutParams.rightMargin = i3;
                } else {
                    this.w0 = c4();
                }
                int i6 = this.a;
                if (i6 != 4 && i6 != 3) {
                    this.w0.bottomMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
                } else {
                    this.w0.bottomMargin = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                }
                this.l.setLayoutParams(this.w0);
                if (this.h != null && (tbVideoViewContainer2 = this.i) != null) {
                    tbVideoViewContainer2.setId(R.id.video_controller_tag);
                    if (s4() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                        this.w0.addRule(15);
                    }
                    this.h.addView(this.i, 0, this.w0);
                }
                I3();
            }
            if (this.b0 != null) {
                dj9 dj9Var = new dj9();
                dj9Var.e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData2 = this.b0;
                dj9Var.c = videoItemData2.thread_id;
                dj9Var.t = videoItemData2.nid;
                dj9Var.d = videoItemData2.forum_id;
                dj9Var.m = videoItemData2.mMd5;
                dj9Var.k = "";
                dj9Var.f = videoItemData2.mRecomSource;
                dj9Var.l = videoItemData2.mRecomAbTag;
                dj9Var.j = 1;
                dj9Var.x = videoItemData2.getChannelMidRequestNum();
                dj9Var.y = this.b0.getChannelMidRequestVideoNum();
                BaijiahaoData baijiahaoData = this.b0.baijiahaoData;
                if (baijiahaoData != null) {
                    int i7 = baijiahaoData.oriUgcType;
                    if (i7 == 2) {
                        dj9Var.j = 3;
                    } else if (i7 == 4) {
                        dj9Var.j = 2;
                    }
                }
                dj9Var.h = this.b0.mRecomWeight;
                if (this.h0 != null) {
                    dj9Var.n = "1";
                } else {
                    dj9Var.n = "2";
                }
                int i8 = this.a;
                if (i8 == 1) {
                    dj9Var.p = "1";
                    dj9Var.a = "13";
                    dj9Var.i = this.E0;
                    dj9Var.k = this.R0;
                    dj9Var.g = this.b0.mRecomWeight;
                } else if (i8 == 2) {
                    dj9Var.a = "24";
                } else {
                    dj9Var.a = "13";
                }
                dj9Var.p = "1";
                int i9 = this.a;
                if (i9 == 3) {
                    dj9Var.a = "21";
                } else if (i9 == 4) {
                    dj9Var.a = "22";
                } else if (i9 == 7) {
                    dj9Var.a = "26";
                } else if (r4()) {
                    dj9Var.a = PayUVEventType.PAY_WAY_FAQ_ENTRANCE_CLICK;
                }
                String str = this.E0;
                dj9Var.i = str;
                String str2 = this.R0;
                dj9Var.k = str2;
                VideoItemData videoItemData3 = this.b0;
                String str3 = videoItemData3.mRecomWeight;
                dj9Var.g = str3;
                dj9Var.w = videoItemData3.mExtra;
                if (this.a == 5) {
                    dj9Var.a = "23";
                    dj9Var.p = "1";
                    dj9Var.i = str;
                    dj9Var.k = str2;
                    dj9Var.g = str3;
                }
                if (p4() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    dj9Var.i = personalPageParams.getStatPageFromIdentifier();
                }
                this.i.getControl().setVideoStatData(dj9Var);
                this.i.getControl().setLocateSource("v_mid_page");
            }
            this.i.getControl().setContinuePlayEnable(true);
        }
    }

    public final void S4(View view2, float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLF(1048607, this, view2, f2) != null) || view2 == null) {
            return;
        }
        h5(view2, 0);
        view2.setAlpha(f2);
    }

    public final void h5(View view2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048637, this, view2, i2) != null) || view2 == null) {
            return;
        }
        if (this.r1) {
            view2.setVisibility(8);
        } else {
            view2.setVisibility(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048668, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            R3();
            b5();
        }
    }

    public static /* synthetic */ int y3(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.V0;
        videoPlayFragment.V0 = i2 + 1;
        return i2;
    }

    public void O3(int i2) {
        aaa aaaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && (aaaVar = this.Y0) != null && aaaVar.b() != null) {
            this.Y0.b().y(i2);
        }
    }

    public final void O4(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048599, this, i2) == null) && (view2 = this.f) != null) {
            view2.setPadding(0, 0, 0, i2);
        }
    }

    public final void P3(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z2) == null) && (videoMiddleNiaiControllerView = this.e0) != null) {
            int i3 = this.a;
            if (i3 != 3 && i3 != 4) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            videoMiddleNiaiControllerView.setBottomBarShow(z2, i2);
        }
    }

    public final void P4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            h5(this.x, i2);
            h5(this.X, i2);
            h5(this.y, i2);
            h5(this.w, i2);
            h5(this.u, i2);
        }
    }

    public void Q4(n9a n9aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, n9aVar) == null) {
            this.s1 = n9aVar;
        }
    }

    public void V4(oi9.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, cVar) == null) {
            this.Z0 = cVar;
        }
    }

    public final void X3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            if (z2) {
                P4(8);
                this.v.setVisibility(0);
                return;
            }
            P4(0);
            this.v.setVisibility(8);
        }
    }

    public final void d5(String str) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, str) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null && str != null && !str.equals(this.M0)) {
            this.M0 = str;
        }
    }

    public final void e5(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048631, this, i2) == null) && (relativeLayout = this.h) != null) {
            relativeLayout.setPadding(0, 0, 0, i2);
        }
    }

    public void f5(taa taaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, taaVar) == null) {
            this.X0 = taaVar;
        }
    }

    public void g5(i1 i1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, i1Var) == null) {
            this.a1 = i1Var;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        x9a x9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() == R.id.obfuscated_res_0x7f09281f && (x9aVar = this.k) != null) {
                x9aVar.i();
                VideoItemData videoItemData = this.b0;
                if (videoItemData != null) {
                    this.k.e(videoItemData.thread_id, this.a);
                }
            }
        }
    }

    public final void r5(boolean z2) {
        o9a o9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048677, this, z2) == null) && (o9aVar = this.c1) != null) {
            o9aVar.c(u4());
            this.c1.d(getPageContext(), this.b0, z2);
        }
    }

    @Override // com.baidu.tieba.zaa
    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i2) == null) {
            this.W0 = i2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048653, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            p(i2, i3, intent);
        }
    }

    public boolean A4() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VideoItemData videoItemData = this.b0;
            if (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.a != 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean B4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.a;
            if (i2 != 4 && i2 != 3) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean C4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.Q0;
            if (videoStatus != OnStatusChangedListener.VideoStatus.INIT && videoStatus != OnStatusChangedListener.VideoStatus.VIDEO_PREPARED && videoStatus != OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING && videoStatus != OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void E4() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null) {
            this.i.getControl().K();
        }
    }

    public final void K4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048590, this) != null) || this.h == null) {
            return;
        }
        this.i.post(new x(this));
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            int i2 = this.a;
            if (i2 != 4 && i2 != 3) {
                O4(UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            } else {
                O4(0);
            }
        }
    }

    public final void L4() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.A != null && (imageView = this.z) != null) {
            imageView.clearAnimation();
            this.A.clearAnimation();
            this.z.setVisibility(0);
            this.A.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.zaa
    public VideoItemModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.c0;
        }
        return (VideoItemModel) invokeV.objValue;
    }

    public void V3() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && (alertDialog = this.d1) != null && alertDialog.isShowing()) {
            this.d1.dismiss();
        }
    }

    public final void b5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.i.getControl().setVideoStatusChangeListener(this);
            this.i.getControl().setOperableVideoContainer(this.f2);
        }
    }

    public final void g4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            h4(null, false);
        }
    }

    public final void i4() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && (tBLottieAnimationView = this.r) != null) {
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
        }
    }

    public void j5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048641, this) == null) && this.G0 != null && getActivity() != null && !getActivity().isFinishing()) {
            this.G0.l();
        }
    }

    public void k4() {
        l55 l55Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (l55Var = this.G0) != null && l55Var.isShowing()) {
            this.G0.dismiss();
        }
    }

    public final void k5() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048643, this) == null) && BdNetTypeUtil.isMobileNet()) {
            j7a.c().f(getContext());
        }
    }

    public boolean l5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (!TiebaPlusConfigData.isHeatingSwitchOpen()) {
                return false;
            }
            int i2 = this.a;
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            super.onResume();
            if (this.f1) {
                this.f1 = false;
                I4(1);
                startPlay();
                if (this.h0 == null) {
                    Y3();
                }
                this.U0 = false;
            }
            TiePlusEventController tiePlusEventController = this.g1;
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
            if (!this.u1 && this.T0) {
                M4();
            }
            if (this.u1) {
                this.u1 = false;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            super.onStop();
            E4();
            l4();
        }
    }

    public final boolean p4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (this.a == 6) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean q4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.B0;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            if (y4()) {
                l4();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean r4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (this.a == 8) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean s4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            int i2 = this.a;
            if (i2 != 3 && i2 != 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void stopPlay() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048682, this) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null) {
            this.i.getControl().stopPlayback();
        }
    }

    public final boolean u4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean w4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            if (p4() && !this.b) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean w5() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            if (y4()) {
                l4();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            if (w4() && q4()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void x5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048694, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.Q0 = this.i.getControl().getVideoStatus();
            } else {
                this.Q0 = OnStatusChangedListener.VideoStatus.INIT;
            }
        }
    }

    @Override // com.baidu.tieba.zaa
    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.W0;
        }
        return invokeV.intValue;
    }

    public final boolean y4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            aaa aaaVar = this.Y0;
            if (aaaVar != null && aaaVar.b() != null && this.Y0.b().x()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D4(int i2) {
        boolean z2;
        int i3;
        RelativeLayout.LayoutParams layoutParams;
        boolean z3;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 5) {
                            return;
                        }
                    }
                }
                this.r1 = true;
                P4(8);
                R4(8);
                VideoItemData videoItemData = this.b0;
                if (videoItemData != null) {
                    if (tg.e(videoItemData.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3 && this.t1 < 0 && (layoutParams2 = this.w0) != null) {
                        int i4 = layoutParams2.topMargin;
                        this.t1 = i4;
                        ValueAnimator duration = ValueAnimator.ofInt(i4, i4 - UtilHelper.getStatusBarHeight()).setDuration(500L);
                        duration.addUpdateListener(new x0(this));
                        duration.start();
                        return;
                    }
                    return;
                }
                return;
            }
            this.r1 = false;
            P4(0);
            R4(0);
            VideoItemData videoItemData2 = this.b0;
            if (videoItemData2 != null) {
                if (tg.e(videoItemData2.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 && (i3 = this.t1) >= 0 && (layoutParams = this.w0) != null) {
                    ValueAnimator duration2 = ValueAnimator.ofInt(layoutParams.topMargin, i3).setDuration(500L);
                    duration2.addUpdateListener(new y0(this));
                    duration2.start();
                    this.t1 = -1;
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        VideoItemData videoItemData;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            I3();
            K4();
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && UtilHelper.isFoldScreen()) {
                if (this.n1) {
                    if (UtilHelper.isOppoFoldLargeScreen(getContext())) {
                        this.i.getControl().setVideoScalingMode(2);
                    } else {
                        this.i.getControl().setVideoScalingMode(0);
                    }
                } else {
                    this.i.getControl().setVideoScalingMode(2);
                }
            }
            if (this.f0 && (videoItemData = this.b0) != null) {
                if (tg.e(videoItemData.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                bba bbaVar = this.b1;
                if (bbaVar != null && z2) {
                    if ((bbaVar.isFullScreen() && configuration.orientation == 1) || (!this.b1.isFullScreen() && configuration.orientation == 2)) {
                        this.h.removeView(this.i);
                        this.b1.Z(false);
                    }
                }
            }
        }
    }

    public final void F4() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (tBLottieAnimationView = this.s) != null) {
            tBLottieAnimationView.setVisibility(0);
            SkinManager.setLottieAnimation(this.s, R.raw.video_tab_attention_animation);
            if (!this.s.isAnimating()) {
                this.s.setSpeed(1.1f);
                this.s.playAnimation();
            }
        }
    }

    public final void G4() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null && this.b0 != null) {
            this.i.getControl().L();
            this.i.getControl().setVideoPath(this.M0, this.b0.thread_id);
        }
    }

    public final void N3() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null && (userItemData = videoItemData.author_info) != null && !this.B0 && (userItemData == null || !"1".equals(userItemData.is_follow))) {
                this.V.setVisibility(0);
                this.V.setClickable(true);
                return;
            }
            this.V.setVisibility(4);
            this.V.setClickable(false);
        }
    }

    public final void W4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048615, this) != null) || this.B.getVisibility() == 0) {
            return;
        }
        this.B.setVisibility(0);
        if (this.o1 == null) {
            this.o1 = f4(0.0f, 3.0f, 3.0f, 0L);
        }
        this.o1.addListener(new c1(this));
        this.o1.start();
    }

    public final int b4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            int k2 = vi.k(this.f.getContext(), UtilHelper.isFoldScreen());
            if (B4()) {
                i2 = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            } else {
                k2 -= UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                i2 = VideoMiddleNiaiControllerView.v;
            }
            return k2 - i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            super.onPause();
            x5();
            if (!this.T0) {
                E4();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !t4() && getActivity().isFinishing()) {
                U3();
                this.m1 = true;
            }
            l4();
            TiePlusEventController tiePlusEventController = this.g1;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    public final boolean t4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (this.a == 1 && this.W0 == 0) {
                return false;
            }
            if (this.a == 7 && getActivity() != null && (getActivity() instanceof FrsVideoTabPlayActivity) && this.W0 == ((FrsVideoTabPlayActivity) getActivity()).A1()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean z4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            if (UbsABTestHelper.isVideoTabAuthorABTest() && v4(1)) {
                return true;
            }
            if (UbsABTestHelper.isVideoMiddleAuthorABTest() && v4(2)) {
                return true;
            }
            if (UbsABTestHelper.isVideoMiddleAndTabAuthorABTest() && v4(3)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void H3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            View view2 = this.g;
            if (view2 != null && view2.getParent() != null) {
                return;
            }
            View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d099e, (ViewGroup) null);
            this.g = inflate;
            EMTextView eMTextView = (EMTextView) this.g.findViewById(R.id.obfuscated_res_0x7f090d7b);
            WebPManager.setPureDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090d7a), R.drawable.obfuscated_res_0x7f080c0c, R.color.CAM_X0101, null);
            eMTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0102));
            eMTextView.setText(getString(R.string.obfuscated_res_0x7f0f17ae));
            eMTextView.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.video_controller_tag);
            layoutParams.addRule(14, -1);
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            this.h.addView(this.g, layoutParams);
            u5(this.b0.thread_id, true);
            this.g.setOnClickListener(new t0(this));
        }
    }

    public final void J4() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.b0 != null) {
            dj9 dj9Var = new dj9();
            dj9Var.a = "nani_midpage";
            VideoItemData videoItemData = this.b0;
            dj9Var.c = videoItemData.thread_id;
            dj9Var.t = videoItemData.nid;
            dj9Var.d = this.b0.forum_id + "";
            dj9Var.e = TbadkCoreApplication.getCurrentAccount();
            VideoItemData videoItemData2 = this.b0;
            dj9Var.f = videoItemData2.mRecomSource;
            dj9Var.g = videoItemData2.mRecomAbTag;
            dj9Var.h = videoItemData2.mRecomWeight;
            dj9Var.i = "";
            dj9Var.k = "";
            dj9Var.m = videoItemData2.mMd5;
            dj9Var.x = videoItemData2.getChannelMidRequestNum();
            dj9Var.y = this.b0.getChannelMidRequestVideoNum();
            if (this.h0 != null) {
                dj9Var.n = "1";
            } else {
                dj9Var.n = "2";
            }
            int i2 = this.a;
            if (i2 == 1 || i2 == 2) {
                dj9Var.p = "1";
                dj9Var.a = "auto_midpage";
                dj9Var.i = "index";
            }
            ri9.e(this.b0.mMd5, "", "1", dj9Var, this.i.getControl().getPcdnState());
            int i3 = this.a;
            if (i3 != 1 && i3 != 3) {
                if (i3 != 2 && i3 != 4) {
                    if (i3 == 7) {
                        u9a.b(this.b0.mMd5);
                        return;
                    }
                    return;
                }
                u9a.a(this.b0.mMd5);
                return;
            }
            u9a.c(this.b0.mMd5);
        }
    }

    public final void n4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                aaa aaaVar = (aaa) new baa().g(getActivity(), new y(this));
                this.Y0 = aaaVar;
                if (aaaVar != null && this.b0 != null) {
                    aaaVar.s(getPageContext());
                    String str = "";
                    if (!TextUtils.isEmpty(this.b0.thread_id)) {
                        str = DanmuPostDraftManager.b.a().b(this.b0.thread_id);
                    }
                    this.Y0.t(this.b0.thread_id, this.b0.forum_id, this.b0.forum_name, str);
                    T3(str);
                    this.Y0.u(new z(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.f).addView(this.Y0.b(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048659, this) == null) {
            if (!this.m1) {
                stopPlay();
            }
            if (!getActivity().isFinishing() && (tbVideoViewContainer = this.i) != null && (tbVideoViewContainer.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof xi9)) {
                ((xi9) this.i.getControl().getPlayer()).release();
            }
            TbVideoViewContainer tbVideoViewContainer2 = this.i;
            if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null) {
                this.i.a();
                this.i.getControl().setVideoStatusChangeListener(null);
            }
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.z1);
            MessageManager.getInstance().unRegisterListener(this.g2);
            MessageManager.getInstance().unRegisterListener(this.h2);
            if (this.e2 != null) {
                wg.a().removeCallbacks(this.e2);
                this.e2 = null;
            }
            o9a o9aVar = this.c1;
            if (o9aVar != null) {
                o9aVar.b();
            }
            getLifecycle().removeObserver(this.F1);
        }
    }

    @Override // com.baidu.tieba.z26.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            if (y4()) {
                l4();
                return;
            }
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.i.getControl().E()) {
                if (this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING && this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    if (this.i.getControl().getVideoStatus() == OnStatusChangedListener.VideoStatus.VIDEO_PAUSING && !n5()) {
                        this.i.getControl().start();
                        this.B.setVisibility(8);
                        P3(true);
                        this.e0.t();
                        if (!isResumed() || !this.f0) {
                            E4();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.i.getControl().pause();
                W4();
                P3(false);
                wg.a().removeCallbacks(this.e2);
                Z3(4);
            }
        }
    }

    @Override // com.baidu.tieba.z26.b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        boolean z2;
        boolean z3;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048669, this) == null) && !w4() && !y4() && (videoItemData = this.b0) != null && (userItemData = videoItemData.author_info) != null) {
            long g2 = tg.g(userItemData.user_id, 0L);
            long g3 = tg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
            int i2 = 1;
            if (g2 == g3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (g2 == 0 && g3 == 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            y9a.a();
            String str2 = this.b0.author_info.portrait;
            PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
            int i3 = this.a;
            if (i3 != 3 && i3 != 4) {
                str = PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE;
            } else {
                str = PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL;
            }
            PersonPolymericActivityConfig createNormalConfig = personPolymericActivityConfig.createNormalConfig(g2, z3, false, true, str);
            createNormalConfig.setPortrait(str2);
            createNormalConfig.setSourceTid(this.b0.thread_id);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DRAG_TO_PERSONAL_CENTER);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", this.b0.thread_id);
            int i4 = this.a;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            i2 = 3;
                        }
                    } else {
                        i2 = 4;
                    }
                }
                statisticItem.param("obj_locate", i2);
                TiebaStatic.log(statisticItem);
            }
            i2 = 2;
            statisticItem.param("obj_locate", i2);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void H4(int i2, int i3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) && (videoItemData = this.b0) != null && videoItemData.video_url != null && i2 > videoItemData.video_duration * 1000) {
            this.j1 = false;
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_PTS);
            statisticItem.param("obj_id", this.b0.video_url);
            TiebaStatic.log(statisticItem);
        }
    }

    public final boolean S3(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048606, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Override // com.baidu.tieba.z26.b
    public void u0(float f2, float f3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048685, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.b0) != null && "0".equals(videoItemData.is_agreed)) {
            W3(this.e);
        }
    }

    public final void u5(String str, boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048687, this, str, z2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_HORIZONTAL_PLAY);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", str);
            if (z2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            statisticItem.param("obj_type", i2);
            int i3 = this.a;
            if (i3 != 3 && i3 != 4) {
                statisticItem.param("obj_locate", 1);
            } else {
                statisticItem.param("obj_locate", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void I3() {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || getContext() == null) {
            return;
        }
        if (UtilHelper.isLargeScreen(getContext())) {
            View view2 = this.g;
            if (view2 != null && (view2.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.g.getParent()).removeView(this.g);
                this.g = null;
                return;
            }
            return;
        }
        if (tg.e(this.b0.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.b0.video_duration >= 60 && z2) {
            H3();
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !t4()) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
            }
        }
    }

    public final void M4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || n5()) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.b0 != null) {
            if (this.i.getParent() == null) {
                a5();
                b5();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.e0;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.q();
            }
            if (!UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                this.i.getControl().setIsVolume0(false);
            }
            this.i.getControl().S(this.v1);
            this.e0.t();
            k5();
        }
        if (!isResumed() || !this.f0 || !C4()) {
            E4();
            if (this.B != null) {
                W4();
            }
        }
    }

    public final void N4() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && !this.N0 && (videoItemData = this.b0) != null && videoItemData.threadData != null) {
            this.N0 = true;
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = this.b0.getThreadId();
            historyMessage.threadName = this.b0.getTitle().toString();
            String str = this.b0.forum_name;
            if (str != null) {
                historyMessage.forumName = str;
            }
            if (this.b0.threadData.getFirst_post_id() != null) {
                historyMessage.postID = this.b0.threadData.getFirst_post_id();
            }
            ThreadData threadData = this.b0.threadData;
            historyMessage.isShareThread = threadData.isShareThread;
            historyMessage.threadType = threadData.getThreadType();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void Q3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && !x4() && this.A != null && this.z != null) {
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
    }

    public final boolean n5() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (j7a.c().d() || TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2 || ((i2 = this.a) != 3 && i2 != 4 && TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.a;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && BdNetTypeUtil.isMobileNet() && isResumed() && this.f0) {
                vi.R(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f17c1), 3000, false);
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048660, this) == null) {
            super.onDestroyView();
            VideoDanmuController videoDanmuController = this.j;
            if (videoDanmuController != null) {
                videoDanmuController.U();
            }
            x9a x9aVar = this.k;
            if (x9aVar != null) {
                x9aVar.f();
            }
            bba bbaVar = this.b1;
            if (bbaVar != null) {
                bbaVar.N0();
            }
            aaa aaaVar = this.Y0;
            if (aaaVar != null) {
                aaaVar.o();
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
            View view2 = this.u0;
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
            TextView textView = this.t0;
            if (textView != null) {
                textView.setOnClickListener(null);
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
                        J4();
                        M4();
                        I4(0);
                    } else {
                        E4();
                    }
                }
                VideoItemData videoItemData2 = this.b0;
                if (videoItemData2 != null && (alaInfoData = videoItemData2.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData() && this.b0.mAlaInfoData.live_status == 1) {
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
                return;
            }
            E4();
            l4();
            this.j1 = true;
        }
    }

    public final void t5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048684, this) != null) || this.b0 == null) {
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
        statisticItem.param("obj_type", e4());
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

    public final void I4(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i2) == null) && this.b0 != null && this.h0 == null) {
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

    public final void T4(float f2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048609, this, f2) == null) {
            S4(this.u, f2);
            S4(this.y, f2);
            S4(this.x, f2);
            S4(this.w, f2);
            View view2 = this.k1;
            boolean z2 = false;
            if (view2 != null) {
                view2.setVisibility(0);
                this.k1.setAlpha(f2);
            }
            View view3 = this.l1;
            if (view3 != null) {
                view3.setVisibility(0);
                this.l1.setAlpha(f2);
            }
            View view4 = this.m;
            if (view4 != null) {
                view4.setVisibility(0);
                this.m.setAlpha(f2);
            }
            if (this.g != null && (videoItemData = this.b0) != null) {
                if (tg.e(videoItemData.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
                    z2 = true;
                }
                if (this.b0.video_duration >= 60 && z2) {
                    S4(this.g, f2);
                } else {
                    h5(this.g, 8);
                }
            }
            n9a n9aVar = this.s1;
            if (n9aVar != null) {
                n9aVar.g(f2);
            }
        }
    }

    public final void U4(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            h5(this.u, i2);
            h5(this.y, i2);
            h5(this.x, i2);
            h5(this.w, i2);
            View view2 = this.k1;
            if (view2 != null) {
                view2.setVisibility(i2);
            }
            View view3 = this.l1;
            if (view3 != null) {
                view3.setVisibility(i2);
            }
            View view4 = this.m;
            if (view4 != null) {
                view4.setVisibility(i2);
            }
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null) {
                boolean z2 = false;
                if (tg.e(videoItemData.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
                    z2 = true;
                }
                if (this.b0.video_duration >= 60 && z2) {
                    h5(this.g, i2);
                } else {
                    h5(this.g, 8);
                }
            }
        }
    }

    public final void j4(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z2) == null) {
            int g2 = vi.g(getContext(), R.dimen.tbds26);
            if (this.t != z2) {
                if (this.r != null) {
                    if (z2) {
                        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.leftMargin = g2;
                            marginLayoutParams.rightMargin = g2;
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

    public final void J3(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, shareItem) == null) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_duration = Integer.valueOf(this.b0.video_duration);
            builder.play_count = Integer.valueOf(this.b0.play_count);
            VideoItemData videoItemData = this.b0;
            builder.thumbnail_url = videoItemData.thumbnail_url;
            builder.thumbnail_height = Integer.valueOf(tg.e(videoItemData.video_height, 0));
            builder.thumbnail_width = Integer.valueOf(tg.e(this.b0.video_width, 0));
            shareItem.a0.threadData.setVideoInfo(builder.build(true));
        }
    }

    public final void K3(boolean z2) {
        aaa aaaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) && (aaaVar = this.Y0) != null && aaaVar.b() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Y0.b().getLayoutParams();
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
            this.Y0.b().requestLayout();
        }
    }

    public void Z3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.z1);
            registerListener(this.g2);
            registerListener(this.h2);
            this.c1 = new o9a();
            getLifecycle().addObserver(this.F1);
            if (this.g1 == null) {
                this.g1 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.VIDEO_MOUNT, getUniqueId());
            }
        }
    }

    public final String v5(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048689, this, str)) == null) {
            if (StringHelper.getChineseAndEnglishLength(str) <= 14) {
                return str + TbadkCoreApplication.getInst().getString(R.string.bar_default_name);
            }
            return StringHelper.cutChineseAndEnglishWithEmoji(str, 12, "...") + TbadkCoreApplication.getInst().getString(R.string.bar_default_name);
        }
        return (String) invokeL.objValue;
    }

    public final void M3() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (videoItemData = this.b0) != null) {
            if ("1".equals(videoItemData.is_agreed)) {
                this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a0b, WebPManager.ResourceStateType.NORMAL));
            } else {
                this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a09, WebPManager.ResourceStateType.NORMAL));
            }
            X4(tg.g(this.b0.agree_num, 0L), this.R);
        }
    }

    public final void U3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if ((this.i.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof xi9)) {
                this.i.getControl().Q();
                ((xi9) this.i.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
            }
            TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921683, this.M0));
        }
    }

    public final void Y4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.q.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.width = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams.height = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.height = vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int e4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.E0)) {
                return 0;
            }
            String str = this.E0;
            int hashCode = str.hashCode();
            if (hashCode != 101671) {
                if (hashCode != 100346066) {
                    if (hashCode == 157161846 && str.equals("concern_tab")) {
                        c2 = 1;
                    }
                    c2 = 65535;
                }
            } else {
                if (str.equals("frs")) {
                    c2 = 2;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 == 1) {
                    return 2;
                }
                if (c2 != 2) {
                    return 7;
                }
                return 4;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final void l4() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048644, this) != null) || !y4()) {
            return;
        }
        this.Y0.b().q();
        T3(((caa) this.Y0.b().p(28)).g().getText().toString());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
        int i2 = this.a;
        if (i2 == 4 || i2 == 3) {
            e5(0);
        }
        L3();
    }

    public void o5() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
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

    public final void p5() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048672, this) != null) || y4()) {
            return;
        }
        aaa aaaVar = this.Y0;
        if (aaaVar != null && aaaVar.b() != null) {
            this.Y0.b().j();
            VideoItemData videoItemData = this.b0;
            if (videoItemData != null) {
                this.Y0.w(videoItemData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.TRUE));
        }
        int i2 = this.a;
        if (i2 == 4 || i2 == 3) {
            e5(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        L3();
    }

    public final void R3() {
        VideoItemData videoItemData;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || (videoItemData = this.b0) == null) {
            return;
        }
        this.l.N(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.b0.getTitle();
        boolean z3 = true;
        if (tg.e(this.b0.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (TextUtils.isEmpty(title) && (!z2 || this.b0.video_duration < 60)) {
            this.P.setVisibility(8);
        } else {
            if (this.b0.video_duration >= 60) {
                this.N.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(vi.g(getContext(), R.dimen.tbds31), vi.g(getContext(), R.dimen.tbds31));
                }
                layoutParams.width = vi.g(getContext(), R.dimen.tbds3);
                layoutParams.height = vi.g(getContext(), R.dimen.tbds34);
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
                o75 d2 = o75.d(this.M);
                d2.B(R.dimen.T_X08);
                d2.w(R.color.CAM_X0618);
                d2.C(R.string.F_X02);
                this.M.setText(sb.toString());
            } else {
                this.N.setVisibility(8);
            }
            this.P.setVisibility(0);
            this.L.setTextSize(vi.g(getContext(), R.dimen.T_X07));
            this.L.setTextColor(R.color.CAM_X0621);
            this.L.setLineSpacingExtra(vi.g(getContext(), R.dimen.tbds10));
            this.L.setExpandable(false);
            this.L.setTextMaxLine(3);
            this.L.setLimitLine(3);
            this.L.setOnStatusChangedListener(new m0(this));
            ExpandableTextView expandableTextView = this.L;
            VideoItemData videoItemData2 = this.b0;
            expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        X4(tg.g(this.b0.comment_num, 0L), this.Q);
        X4(tg.g(this.b0.agree_num, 0L), this.R);
        if (x4()) {
            this.S.setText(R.string.obfuscated_res_0x7f0f0c7c);
        } else {
            X4(tg.g(this.b0.share_num, 0L), this.S);
        }
        UserItemData userItemData = this.b0.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.b0.author_info.portrait.startsWith("http")) {
                this.q.N(this.b0.author_info.portrait, 10, false);
            } else {
                this.q.N(this.b0.author_info.portrait, 12, false);
            }
            if (z4() && !TextUtils.isEmpty(this.b0.author_info.auth)) {
                this.q.setShowV(true);
                this.q.setOriginatorResId(R.drawable.ic_icon_mask_videov14);
            } else {
                this.q.setShowV(false);
                this.q.setOriginatorResId(0);
            }
            if (StringUtils.isNull(this.b0.author_info.getUserShowName())) {
                this.t0.setVisibility(8);
            } else {
                this.t0.setVisibility(0);
                this.t0.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.b0.author_info.getUserShowName(), 16, "..."));
            }
        }
        AlaInfoData alaInfoData = this.b0.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            if (this.b0.mAlaInfoData.live_status != 1) {
                z3 = false;
            }
            j4(z3);
            i4();
        }
        if ("1".equals(this.b0.is_private) && this.d0.getVisibility() != 0) {
            this.a0.setVisibility(0);
        } else {
            this.a0.setVisibility(8);
        }
        if ("1".equals(this.b0.is_agreed)) {
            this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a0b, WebPManager.ResourceStateType.NORMAL));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.j0, Key.SCALE_X, 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.j0, Key.SCALE_Y, 1.3f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat2.setDuration(300L);
            ofFloat.start();
            ofFloat2.start();
        } else {
            this.j0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a09, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.b0.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.d0.getVisibility() != 0) {
            this.Z.setVisibility(8);
            this.W.setText(this.b0.act_info.activity_name);
        } else {
            this.Z.setVisibility(8);
        }
        N3();
        boolean o4 = o4();
        if (this.a == 7) {
            this.E.setVisibility(8);
        } else if (!o4) {
            if (!TextUtils.isEmpty(this.b0.forum_name)) {
                str = this.b0.forum_name;
            } else {
                ThreadData threadData = this.b0.threadData;
                if (threadData != null && !TextUtils.isEmpty(threadData.getForum_name())) {
                    str = this.b0.threadData.getForum_name();
                } else {
                    str = null;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                this.E.setVisibility(0);
                WebPManager.setPureDrawable(this.J, R.drawable.icon_pure_ba32, R.color.CAM_X0101, null);
                this.J.setVisibility(0);
                this.I.setVisibility(8);
                String v5 = v5(str);
                this.D0 = v5;
                this.K.setText(v5);
                ThreadData threadData2 = this.b0.threadData;
                if (threadData2 != null && !TextUtils.isEmpty(threadData2.getRecomReason())) {
                    this.K.setText(this.D0 + getActivity().getResources().getString(R.string.obfuscated_res_0x7f0f17cd));
                }
                this.E.setOnClickListener(new n0(this, str));
            }
        }
    }

    public final void q5() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        Uri parse;
        VideoItemData videoItemData2;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048674, this) != null) || (videoItemData = this.b0) == null) {
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
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.share_content_tpl);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl);
        VideoItemData videoItemData3 = this.b0;
        String str8 = "";
        boolean z2 = false;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        if (str7 == null) {
            parse = null;
        } else {
            parse = Uri.parse(str7);
        }
        ShareItem shareItem = new ShareItem();
        shareItem.v = str5;
        shareItem.w = format;
        if (this.b0.baijiahaoData == null) {
            shareItem.W = videoItemData2.play_count;
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
        shareItem.f0 = videoItemData4.post_id;
        shareItem.f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.g0 = userItemData2.portrait;
            shareItem.h0 = userItemData2.user_name;
            shareItem.i0 = userItemData2.getUserShowName();
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
            shareItem.R = 2;
        } else if (this.b0.getVideoType() == 2) {
            shareItem.R = 8;
        } else if (this.b0.getVideoType() == 3) {
            shareItem.R = 6;
        }
        if (parse != null) {
            shareItem.z = parse;
        }
        if (this.b0.isBjhVideo) {
            shareItem.v0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData5 = this.b0;
        originalThreadInfo.c = videoItemData5.thumbnail_url;
        originalThreadInfo.a = 3;
        originalThreadInfo.b = videoItemData5.title;
        originalThreadInfo.f = videoItemData5.thread_id;
        originalThreadInfo.p = videoItemData5.baijiahaoData;
        OriginalThreadInfo.ShareInfo generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        shareItem.a0 = generateShareInfo;
        ThreadData threadData = this.b0.threadData;
        generateShareInfo.threadData = threadData;
        if (StringUtils.isNull(threadData.getId()) && !StringUtils.isNull(str)) {
            shareItem.a0.threadData.setId(str);
        }
        if (this.b0.author_info != null) {
            shareItem.a0.threadData.getAuthor().setUserName(this.b0.author_info.user_name);
            shareItem.a0.threadData.getAuthor().setName_show(this.b0.author_info.name_show);
            shareItem.a0.threadData.getAuthor().setPortrait(this.b0.author_info.portrait);
            shareItem.a0.threadData.getAuthor().setUserId(this.b0.author_info.user_id);
        }
        J3(shareItem);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.J);
        bundle.putInt("obj_type", shareItem.R);
        bundle.putString("fid", shareItem.N);
        bundle.putString("tid", shareItem.O);
        bundle.putInt("obj_source", shareItem.s);
        shareItem.r(bundle);
        if (this.b0.isWorksInfo()) {
            shareItem.K = 11;
        }
        ThreadData threadData2 = this.b0.threadData;
        if (threadData2 != null) {
            int j2 = nf5.j(threadData2);
            UserItemData userItemData3 = this.b0.author_info;
            if (userItemData3 != null) {
                str8 = userItemData3.name_show;
            }
            shareItem.I0 = nf5.i(this.b0.threadData, j2);
            VideoItemData videoItemData6 = this.b0;
            shareItem.J0 = nf5.h(videoItemData6.threadData, j2, videoItemData6.forum_name, shareItem.W, str8, "");
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = A4();
        shareDialogConfig.disLikeListener = this.Z1;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.E0);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = q4();
        VideoItemData videoItemData7 = this.b0;
        shareDialogConfig.isManager = videoItemData7.is_manager;
        shareDialogConfig.isOriginManager = videoItemData7.is_origin_manager;
        shareDialogConfig.showHeating = l5();
        shareDialogConfig.isSelfHeating = this.B0;
        shareDialogConfig.heatingListener = this.Y1;
        ThreadData threadData3 = this.b0.threadData;
        if (threadData3 != null) {
            if (threadData3.getIsMarked() == 1) {
                z2 = true;
            }
            shareDialogConfig.isCollected = z2;
            shareDialogConfig.isMadeTop = this.b0.threadData.isMadeTop();
            shareDialogConfig.isAddedGood = this.b0.threadData.isAddedGood();
        }
        pr6.c().l(shareDialogConfig);
    }

    public final void R4(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048605, this, i2) != null) || (videoItemData = this.b0) == null) {
            return;
        }
        boolean z2 = false;
        if (tg.e(videoItemData.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
            z2 = true;
        }
        if (this.b0.video_duration >= 60 && z2) {
            h5(this.g, i2);
        } else {
            h5(this.g, 8);
        }
    }

    public final void T3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.v0.setText(R.string.obfuscated_res_0x7f0f11f9);
                DanmuPostDraftManager.b.a().c(this.b0.thread_id);
                return;
            }
            this.v0.setText(R.string.obfuscated_res_0x7f0f05f8);
            DanmuPostDraftManager.b.a().d(this.b0.thread_id, str);
        }
    }

    public final boolean v4(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048688, this, i2)) == null) {
            if (i2 == 1) {
                int i3 = this.a;
                if (i3 != 3 && i3 != 4) {
                    return false;
                }
                return true;
            } else if (i2 == 2) {
                int i4 = this.a;
                if (i4 != 1 && i4 != 2) {
                    return false;
                }
                return true;
            } else if (i2 != 3) {
                return false;
            } else {
                int i5 = this.a;
                if (i5 != 1 && i5 != 2 && i5 != 3 && i5 != 4) {
                    return false;
                }
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public final void W3(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048614, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.b0) != null) {
            int i3 = 0;
            if (i2 == this.d) {
                if ("1".equals(videoItemData.is_agreed)) {
                    if (!DisableZanSwitch.getIsOn()) {
                        VideoItemData videoItemData2 = this.b0;
                        videoItemData2.agree_num = String.valueOf(tg.e(videoItemData2.agree_num, 0) - 1);
                        this.b0.is_agreed = "0";
                    }
                    i3 = 1;
                } else {
                    if (!DisableZanSwitch.getIsOn()) {
                        VideoItemData videoItemData3 = this.b0;
                        videoItemData3.agree_num = String.valueOf(tg.e(videoItemData3.agree_num, 0) + 1);
                        this.b0.is_agreed = "1";
                    }
                    Z3(1);
                }
            } else {
                if (!DisableZanSwitch.getIsOn()) {
                    VideoItemData videoItemData4 = this.b0;
                    videoItemData4.agree_num = String.valueOf(tg.e(videoItemData4.agree_num, 0) + 1);
                    this.b0.is_agreed = "1";
                }
                Z3(1);
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
            if ("index".equals(this.E0)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            mr5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
                    statisticItem3.param("obj_source", e4());
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
            R3();
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
            zx9 zx9Var = new zx9();
            AgreeData agreeData = new AgreeData();
            String str = this.b0.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.b0.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.b0.is_agreed);
            zx9Var.b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, zx9Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.b0));
            if (!this.O0) {
                FirstPraiseToast.getInstance().show();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.Y0 != null && this.Y0.b() != null) {
                    this.Y0.b().y(i2);
                }
                if (this.H0 != null) {
                    this.H0.j();
                }
                if (this.f != null) {
                    this.r0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a10, WebPManager.ResourceStateType.NORMAL_PRESS));
                    if (x4()) {
                        i3 = R.drawable.obfuscated_res_0x7f080a0f;
                    } else {
                        i3 = R.drawable.obfuscated_res_0x7f080a11;
                    }
                    this.s0.setImageDrawable(WebPManager.getMaskDrawable(i3, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.A.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080c6c, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.B.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                    this.D.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_header40_n, ow9.a(SkinManager.getColor(R.color.CAM_X0213), 0.2f), null));
                    M3();
                    o75 d2 = o75.d(this.u0);
                    d2.o(R.string.J_X05);
                    d2.f(R.color.CAM_X0613);
                    o75 d3 = o75.d(this.f1176T);
                    d3.C(R.string.F_X02);
                    d3.w(R.color.CAM_X0101);
                    o75.d(this.U).C(R.string.F_X02);
                    o75 d4 = o75.d(this.S);
                    d4.B(R.dimen.T_X09);
                    d4.C(R.string.F_X02);
                    d4.A(R.array.S_O_X001);
                    o75 d5 = o75.d(this.R);
                    d5.B(R.dimen.T_X09);
                    d5.C(R.string.F_X02);
                    d5.A(R.array.S_O_X001);
                    o75 d6 = o75.d(this.Q);
                    d6.B(R.dimen.T_X09);
                    d6.C(R.string.F_X02);
                    d6.A(R.array.S_O_X001);
                    o75 d7 = o75.d(this.t0);
                    d7.B(R.dimen.T_X06);
                    d7.C(R.string.F_X02);
                    d7.A(R.array.S_O_X001);
                    o75 d8 = o75.d(this.V);
                    d8.o(R.string.J_X01);
                    d8.B(R.dimen.T_X09);
                    d8.w(R.color.CAM_X0101);
                    d8.C(R.string.F_X02);
                    d8.f(R.color.CAM_X0302);
                    this.U.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0101), m75.b(R.string.A_X08)));
                    this.R.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0101), m75.b(R.string.A_X03)));
                    this.S.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0101), m75.b(R.string.A_X03)));
                    this.Q.setTextColor(ow9.a(SkinManager.getColor(R.color.CAM_X0101), m75.b(R.string.A_X03)));
                }
                WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.o, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                i4();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void X4(long j2, TextView textView) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJL(1048617, this, j2, textView) != null) || textView == null) {
            return;
        }
        String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(j2);
        if (!"0".equals(numberUniformFormatExtraWithRoundVote)) {
            textView.setText(numberUniformFormatExtraWithRoundVote);
            return;
        }
        if (textView.getId() == R.id.obfuscated_res_0x7f09016b) {
            str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f17bd);
        } else if (textView.getId() == R.id.comment_num) {
            str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f17be);
        } else if (textView.getId() == R.id.share_num) {
            str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f17c0);
        } else {
            str = "";
        }
        textView.setText(str);
    }

    public final void Y3() {
        String str;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048618, this) != null) || this.b0 == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.b0.thread_id);
        statisticItem.param("nid", this.b0.nid);
        statisticItem.param("fid", this.b0.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.C0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        String str4 = "0";
        if (ui.isEmpty(this.b0.mRecomWeight)) {
            str = "0";
        } else {
            str = this.b0.mRecomWeight;
        }
        statisticItem.param("obj_param1", str);
        if (ui.isEmpty(this.b0.mRecomExtra)) {
            str2 = "0";
        } else {
            str2 = this.b0.mRecomExtra;
        }
        statisticItem.param("extra", str2);
        statisticItem.param("obj_id", this.R0);
        if (ui.isEmpty(this.b0.mRecomAbTag)) {
            str3 = "0";
        } else {
            str3 = this.b0.mRecomAbTag;
        }
        statisticItem.param("ab_tag", str3);
        if (!ui.isEmpty(this.b0.mRecomSource)) {
            str4 = this.b0.mRecomSource;
        }
        statisticItem.param("obj_source", str4);
        statisticItem.param("obj_type", this.E0);
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
            statisticItem2.param("obj_type", this.E0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.F0);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void Z4() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048621, this) == null) && (videoItemData = this.b0) != null) {
            int e2 = tg.e(videoItemData.video_height, 0);
            int e3 = tg.e(this.b0.video_width, 0);
            int b4 = b4();
            int l2 = vi.l(this.f.getContext());
            if (e2 > 0 && e3 > 0 && b4 > 0 && l2 > 0) {
                float f2 = (e2 * 1.0f) / e3;
                if (f2 > 1.0f) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    this.P0 = layoutParams;
                    layoutParams.removeRule(13);
                    this.P0.addRule(14);
                    this.P0.topMargin = (b4 - vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                    this.P0 = layoutParams2;
                    layoutParams2.removeRule(13);
                    this.P0.addRule(14);
                    this.P0.topMargin = (b4 - vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                }
                if (f2 > 1.34f) {
                    this.n1 = true;
                    if (UtilHelper.isOppoFoldLargeScreen(getContext())) {
                        this.i.getControl().setVideoScalingMode(2);
                    } else {
                        this.i.getControl().setVideoScalingMode(0);
                    }
                    this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                }
                this.n1 = false;
                this.i.getControl().setVideoScalingMode(2);
                this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return;
            }
            this.i.getControl().setVideoScalingMode(2);
            this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
    }

    public final RelativeLayout.LayoutParams c4() {
        InterceptResult invokeV;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            int b4 = b4();
            int m2 = vi.m(this.f.getContext(), UtilHelper.isFoldScreen());
            if ((UtilHelper.isFoldScreen() && UtilHelper.isLargeScreen(this.f.getContext())) || UtilHelper.getRealScreenOrientation(this.f.getContext()) != 2) {
                m2 = b4;
                b4 = m2;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b4, m2);
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && (videoItemData = this.b0) != null) {
                int e2 = tg.e(videoItemData.video_height, 0);
                int e3 = tg.e(this.b0.video_width, 0);
                if (e2 > 0 && e3 > 0 && m2 > 0 && b4 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(b4, m2);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.P0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.P0.addRule(14);
                        this.P0.topMargin = (m2 - vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                    } else {
                        float f3 = f2 * b4;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(b4, (int) f3);
                        int i2 = ((int) (m2 - f3)) / 2;
                        this.t1 = i2;
                        if (this.r1) {
                            layoutParams3.topMargin = i2 - UtilHelper.getStatusBarHeight();
                        } else {
                            layoutParams3.topMargin = i2;
                            this.t1 = -1;
                        }
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.P0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.P0.addRule(14);
                        this.P0.topMargin = (m2 - vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                        layoutParams = layoutParams3;
                    }
                    this.B.requestLayout();
                }
            }
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048681, this) != null) || n5()) {
            return;
        }
        k5();
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.b0 != null && this.i.getParent() == null) {
            a5();
            b5();
        }
        if (Build.VERSION.SDK_INT < 17 && this.l.getVisibility() == 0) {
            this.l.clearAnimation();
            this.l.startAnimation(this.g0);
        }
        TbVideoViewContainer tbVideoViewContainer2 = this.i;
        if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null && !TextUtils.isEmpty(this.M0) && this.b0 != null) {
            if (TbVideoViewSet.c().d(this.M0) == null || TbVideoViewSet.c().d(this.M0) != this.i) {
                this.i.getControl().setVideoPath(this.M0, this.b0.thread_id);
            }
            if (!UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                this.i.getControl().setIsVolume0(false);
            }
            this.i.getControl().S(this.v1);
            VideoDanmuController videoDanmuController = this.j;
            if (videoDanmuController != null) {
                videoDanmuController.b0();
            }
            this.e0.t();
            J4();
            N4();
        }
        if (!this.T0) {
            if ((!isResumed() || !this.f0) && !C4()) {
                E4();
                VideoDanmuController videoDanmuController2 = this.j;
                if (videoDanmuController2 != null) {
                    videoDanmuController2.S();
                }
                if (this.B != null) {
                    W4();
                }
            }
        }
    }

    public final void c5(VideoItemData videoItemData, bba bbaVar, VideoDanmuController videoDanmuController) {
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048627, this, videoItemData, bbaVar, videoDanmuController) == null) && bbaVar != null && bbaVar.getMainView() != null) {
            bbaVar.O0(videoItemData);
            boolean z3 = false;
            if (tg.e(videoItemData.video_height, 0) <= tg.e(videoItemData.video_width, 0)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (this.f0 && z2) {
                z3 = true;
            }
            bbaVar.b0(z3);
            bbaVar.P0(new w(this, bbaVar, videoDanmuController));
            bbaVar.getMainView().setVisibility(8);
        }
    }

    public final ObjectAnimator f4(float f2, float f3, float f4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.B, PropertyValuesHolder.ofFloat(Key.ALPHA, f2), PropertyValuesHolder.ofFloat(Key.SCALE_X, f3), PropertyValuesHolder.ofFloat(Key.SCALE_Y, f4));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void h4(String str, boolean z2) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048636, this, str, z2) != null) || this.b0 == null) {
            return;
        }
        PbCommentFloatActivityConfig createNormalCfg = new PbCommentFloatActivityConfig(getActivity()).createNormalCfg(this.b0.thread_id, str, "");
        createNormalCfg.setForumId(String.valueOf(this.b0.forum_id));
        createNormalCfg.setForumName(this.b0.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.b0.baijiahaoData);
        int i3 = this.a;
        if (i3 != 3 && i3 != 4) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        createNormalCfg.setFromPageType(i2);
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
                VideoItemData videoItemData = this.b0;
                if (videoItemData.author_info != null) {
                    videoItemData.threadData.getAuthor().setIsLike("1".equals(this.b0.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            jd7.update(this.b0.threadData);
        }
        GoPbCommentFloatListener.g();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.T0 = true;
        n9a n9aVar = this.s1;
        if (n9aVar != null) {
            n9aVar.d(true);
        }
        VideoDanmuController videoDanmuController = this.j;
        if (videoDanmuController != null) {
            videoDanmuController.S();
            this.j.I();
        }
        x5();
        this.b1.b0(!this.T0);
        o5();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
    }

    public void i5(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            V3();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                if (z2) {
                    i2 = R.string.musk_my_thread_confirm;
                } else {
                    i2 = R.string.musk_thread_confirm;
                }
                i3 = R.string.musk_my_thread_confirm_subtitle;
                i4 = R.string.obfuscated_res_0x7f0f1390;
            } else {
                i2 = R.string.del_my_thread_confirm;
                i3 = R.string.del_my_thread_confirm_subtitle;
                i4 = R.string.obfuscated_res_0x7f0f053f;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f03c9, TBAlertConfig.OperateBtnStyle.SECONDARY);
            TBAlertBuilder tBAlertBuilder = new TBAlertBuilder(TbadkCoreApplication.getInst().getCurrentActivity());
            tBAlertBuilder.w(i2);
            tBAlertBuilder.m(i3);
            tBAlertBuilder.o(true);
            tBAlertBuilder.u(aVar2, aVar);
            tBAlertBuilder.j(false);
            this.d1 = tBAlertBuilder.z();
            aVar.a(new v0(this, z2, z3));
            aVar2.a(new w0(this));
        }
    }

    public final void m4(View view2, View view3, View view4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048646, this, new Object[]{view2, view3, view4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), animatorListenerAdapter}) == null) {
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

    public final void m5() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            if (this.G0 == null) {
                this.H0 = new n55(getActivity());
                this.G0 = new l55(getPageContext(), this.H0);
                ArrayList arrayList = new ArrayList();
                j55 j55Var = new j55(getString(R.string.obfuscated_res_0x7f0f0c27), this.H0);
                boolean z2 = false;
                VideoItemData videoItemData = this.b0;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    j55Var.n(TbadkCoreApplication.getInst().getResources().getString(R.string.remove_mark));
                } else {
                    j55Var.n(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c27));
                }
                j55Var.m(this.b2);
                VideoItemData videoItemData2 = this.b0;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(j55Var);
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
                    statisticItem.param("obj_source", e4());
                    TiebaStatic.log(statisticItem);
                }
                if (A4()) {
                    j55 j55Var2 = new j55(getString(R.string.not_interested), this.H0);
                    j55Var2.m(this.a2);
                    arrayList.add(j55Var2);
                }
                if (!q4()) {
                    j55 j55Var3 = new j55(getString(R.string.report_text), this.H0);
                    j55Var3.m(this.c2);
                    arrayList.add(j55Var3);
                }
                if (this.B0) {
                    j55 j55Var4 = new j55(getString(R.string.obfuscated_res_0x7f0f053f), this.H0);
                    j55Var4.m(this.d2);
                    arrayList.add(j55Var4);
                }
                this.H0.o(new e0(this));
                this.G0.setOnDismissListener(new f0(this));
                this.H0.l(arrayList);
            }
            j5();
        }
    }

    public boolean o4() {
        InterceptResult invokeV;
        ThreadData threadData;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            VideoItemData videoItemData = this.b0;
            if (videoItemData == null || (threadData = videoItemData.threadData) == null) {
                return false;
            }
            if (videoItemData.mRichAbstractList == null && threadData.getRichAbstractList() == null) {
                return false;
            }
            this.F = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091e53);
            this.G = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092459);
            this.H = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092457);
            this.E = (LinearLayout) this.f.findViewById(R.id.recommend_layout);
            o75 d2 = o75.d(this.H);
            d2.e(R.string.A_X05);
            d2.o(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            n75 n75Var = (n75) this.H.getBackground();
            n75Var.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.H.setBackground(n75Var);
            o75 d3 = o75.d(this.F);
            d3.w(R.color.CAM_X0101);
            d3.B(R.dimen.T_X08);
            d3.C(R.string.F_X01);
            List<PbContent> list = null;
            if (TiePlusHelper.t(this.b0.mRichAbstractList) != null) {
                list = TiePlusHelper.t(this.b0.mRichAbstractList);
            }
            if (TiePlusHelper.t(this.b0.threadData.getRichAbstractList()) != null) {
                list = TiePlusHelper.t(this.b0.threadData.getRichAbstractList());
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(list, 0);
            if (pbContent == null || (tiebaPlusInfo = pbContent.tiebaplus_info) == null) {
                return false;
            }
            Integer num = pbContent.type;
            Integer num2 = tiebaPlusInfo.jump_type;
            y16 c2 = y16.c(num.intValue(), tiebaPlusInfo, this.b0.threadData);
            this.i1 = c2;
            c2.b(this.b0.threadData.statFloor);
            if (num2.intValue() != 3 && num2.intValue() != 7) {
                if (num2.intValue() == 2) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_mask_down));
                } else if (num2.intValue() == 6) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_mask_order));
                } else if (num2.intValue() == 5) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_mask_message));
                } else {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_mask_link));
                }
            } else {
                this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.icon_mask_wechat));
            }
            this.F.setText(tiebaPlusInfo.desc);
            this.H.setVisibility(0);
            this.E.setVisibility(8);
            this.H.setOnClickListener(new o0(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.I0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(new b0(this));
            dx4 c2 = dx4.c(getBaseFragmentActivity());
            this.J0 = c2;
            if (c2 != null) {
                c2.j(new c0(this));
            }
            this.K0 = new qe5(null);
            registerListener(this.x1);
            registerListener(this.y1);
            registerListener(this.A1);
            registerListener(this.B1);
            registerListener(this.C1);
            registerListener(this.D1);
            registerListener(this.w1);
            registerListener(this.E1);
            registerListener(this.G1);
            VideoItemData videoItemData = this.b0;
            boolean z2 = false;
            if (videoItemData != null && (TextUtils.equals(videoItemData.thread_id, TbSingleton.getInstance().getIsNeedShowPbCommentThreadId()) || TextUtils.equals(this.b0.thread_id, AbsVideoChannelFragment.w))) {
                h4(this.b0.highLightPostId, false);
                TbSingleton.getInstance().setIsNeedShowPbCommentThreadId(null);
                AbsVideoChannelFragment.w = null;
            }
            VideoItemData videoItemData2 = this.b0;
            if (videoItemData2 != null && !TextUtils.isEmpty(videoItemData2.highLightPostId) && (TextUtils.equals(this.b0.thread_id, TbSingleton.getInstance().getIsNeedShowPbCommentThreadId()) || TextUtils.equals(this.b0.thread_id, AbsVideoChannelFragment.w))) {
                z2 = true;
            }
            this.u1 = z2;
            if (Build.VERSION.SDK_INT >= 24 && getBaseFragmentActivity().isInMultiWindowMode()) {
                this.U0 = true;
            }
        }
    }

    @Override // com.baidu.tieba.play.OnStatusChangedListener
    public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, videoStatus) == null) {
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PREPARED) {
                Z4();
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING && (videoItemData = this.b0) != null && (TextUtils.equals(videoItemData.thread_id, TbSingleton.getInstance().getIsNeedShowPbCommentThreadId()) || TextUtils.equals(this.b0.thread_id, AbsVideoChannelFragment.w))) {
                h4(this.b0.highLightPostId, false);
                TbSingleton.getInstance().setIsNeedShowPbCommentThreadId(null);
                AbsVideoChannelFragment.w = null;
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
                i1 i1Var = this.a1;
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
                    U4(0);
                }
                if (!TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                    TbSingleton.getInstance().setEnableVideoVerticalPreload(true);
                }
                VideoDanmuController videoDanmuController = this.j;
                if (videoDanmuController != null) {
                    videoDanmuController.V();
                }
            } else {
                VideoDanmuController videoDanmuController2 = this.j;
                if (videoDanmuController2 != null) {
                    videoDanmuController2.S();
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

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        y16 y16Var;
        TbVideoViewContainer tbVideoViewContainer;
        VideoItemData videoItemData;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048680, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.f0 = z2;
            if (this.b1 != null && (videoItemData = this.b0) != null) {
                if (tg.e(videoItemData.video_height, 0) <= tg.e(this.b0.video_width, 0)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                bba bbaVar = this.b1;
                if (this.f0 && z3) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                bbaVar.b0(z4);
            }
            if (!isResumed() && this.f0 && C4()) {
                this.f1 = true;
            }
            if (isResumed() && this.f0 && (!this.U0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                I4(1);
                startPlay();
                if (this.h0 == null) {
                    Y3();
                }
                this.U0 = false;
            } else if (!this.T0) {
                L4();
                this.V0 = 1;
                E4();
                w5();
            }
            if (this.e0 != null) {
                if (this.f0 && isResumed() && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null && this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.e0.setLoading(true);
                } else {
                    this.e0.setLoading(false);
                }
            }
            if (this.f0 && !this.h1 && (y16Var = this.i1) != null && this.g1 != null) {
                y16Var.q(TiePlusStat.StatType.EXPOSE);
                this.g1.q(this.i1);
                this.h1 = true;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        RelativeLayout relativeLayout;
        TbVideoViewContainer tbVideoViewContainer;
        int i2;
        VideoItemData videoItemData;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048658, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
                this.c0 = videoItemModel;
                if (videoItemModel == null) {
                    videoItemData = null;
                } else {
                    videoItemData = videoItemModel.getVideoItemData();
                }
                this.b0 = videoItemData;
                this.h0 = (Rect) arguments.getParcelable("video_cover_rect");
                this.C0 = arguments.getInt("video_index");
                arguments.getString("page_from");
                this.E0 = arguments.getString("from");
                this.F0 = arguments.getString("video_channel_tab");
                this.R0 = arguments.getString("obj_id");
                this.c = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.a = arguments.getInt(VideoPlayActivityConfig.CURRENT_TYPE);
                this.b = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
                boolean z3 = arguments.getBoolean(VideoPlayActivityConfig.IS_SCROLLED, false);
                boolean z4 = arguments.getBoolean(VideoPlayActivityConfig.IS_NEED_SHOW_SECOND_FLOOR, false);
                if (!z3 && this.C0 == 0 && z4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.r1 = z2;
            }
            VideoItemData videoItemData2 = this.b0;
            if (videoItemData2 != null && videoItemData2.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.b0.author_info.user_id)) {
                this.B0 = true;
            }
            if (s4() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09a6, (ViewGroup) null);
            } else {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d09ab, (ViewGroup) null);
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && ((i2 = this.a) == 1 || i2 == 7)) {
                this.f.setBackground(null);
            } else {
                this.f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
            }
            this.j1 = true;
            VideoItemData videoItemData3 = this.b0;
            if (videoItemData3 != null && StringUtils.isNull(videoItemData3.video_url) && !StringUtils.isNull(this.b0.thread_id)) {
                VideoDanmuController videoDanmuController = new VideoDanmuController(getPageContext(), getUniqueId(), this.f, R.id.obfuscated_res_0x7f0927e3, this.b0, this.a);
                this.j = videoDanmuController;
                videoDanmuController.Y(this.X1);
                this.j.N();
            }
            this.f.setOnTouchListener(this.I1);
            this.f.setOnLongClickListener(this.J1);
            TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(getContext());
            this.i = tbVideoViewContainer2;
            tbVideoViewContainer2.getControl().setStageType("2005");
            this.i.getControl().getMediaProgressObserver().j(this.K1);
            TbImageView tbImageView = (TbImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0927e1);
            this.l = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.B = (ImageView) this.f.findViewById(R.id.play_btn);
            this.C = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09280a);
            this.D = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092809);
            this.l.setEvent(this.L1);
            this.h = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092823);
            a5();
            this.m = this.f.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.m.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090327);
            this.n = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091748);
            this.o = imageView2;
            imageView2.setVisibility(8);
            this.p = this.f.findViewById(R.id.portrait_container);
            LinearLayout linearLayout = (LinearLayout) this.f.findViewById(R.id.recommend_layout);
            this.E = linearLayout;
            o75 d2 = o75.d(linearLayout);
            d2.e(R.string.A_X05);
            d2.o(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            n75 n75Var = (n75) this.E.getBackground();
            n75Var.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.E.setBackground(n75Var);
            this.I = (BarImageView) this.f.findViewById(R.id.recommend_forum_avatar);
            this.J = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091da8);
            this.I.setShowOval(true);
            TextView textView = (TextView) this.f.findViewById(R.id.recommend_info_view);
            this.K = textView;
            o75 d3 = o75.d(textView);
            d3.w(R.color.CAM_X0101);
            d3.B(R.dimen.T_X08);
            d3.C(R.string.F_X01);
            HeadImageView headImageView = (HeadImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090306);
            this.q = headImageView;
            headImageView.setDefaultResource(17170445);
            this.q.setPlaceHolder(2);
            this.q.setIsRound(true);
            this.q.setBorderWidth(R.dimen.L_X02);
            this.q.setBorderColor(R.color.CAM_X0622);
            this.q.setDrawBorder(true);
            this.q.setUseNightOrDarkMask(false);
            Y4();
            this.r = (TBLottieAnimationView) this.f.findViewById(R.id.user_living_lottie);
            this.s = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0902ef);
            this.X = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090304);
            this.u = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09044b);
            this.V = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f09163d);
            ka5 ka5Var = new ka5();
            UtilHelper.addFollowUserIconStyle(ka5Var);
            ka5Var.h(R.color.CAM_X0101);
            ka5Var.n(0, 0);
            ka5Var.o(0);
            ka5Var.l(true);
            ka5Var.j(vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds145), vi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60));
            this.V.setConfig(ka5Var);
            this.V.setText(getString(R.string.obfuscated_res_0x7f0f02e5));
            this.j0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090163);
            this.L = (ExpandableTextView) this.f.findViewById(R.id.video_title);
            this.M = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0924b7);
            this.N = this.f.findViewById(R.id.obfuscated_res_0x7f0924b6);
            this.O = this.f.findViewById(R.id.obfuscated_res_0x7f0924c7);
            this.P = this.f.findViewById(R.id.obfuscated_res_0x7f092853);
            this.e0 = (VideoMiddleNiaiControllerView) this.f.findViewById(R.id.media_controller);
            this.W = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0927c4);
            this.y = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090747);
            this.Q = (EMTextView) this.f.findViewById(R.id.comment_num);
            this.r0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090751);
            this.x = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090162);
            this.v = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0915d2);
            this.w = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0920db);
            this.e1 = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0927d7);
            this.k1 = this.f.findViewById(R.id.obfuscated_res_0x7f092854);
            this.l1 = this.f.findViewById(R.id.obfuscated_res_0x7f0927d9);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !t4() && this.h0 != null) {
                U4(8);
                TbImageView tbImageView2 = this.l;
                if (tbImageView2 != null) {
                    tbImageView2.setVisibility(8);
                }
            } else {
                U4(0);
            }
            L3();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            int i3 = this.a;
            if (i3 != 4 && i3 != 3) {
                this.e0.u(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                if (s4() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds145);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
                } else {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
                }
            } else {
                this.e0.u(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            }
            this.R = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f09016b);
            this.s0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0920e5);
            this.S = (EMTextView) this.f.findViewById(R.id.share_num);
            this.f1176T = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090940);
            this.U = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090942);
            this.z = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0920e5);
            this.A = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0920e6);
            L4();
            this.Y = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0927c3);
            this.Z = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0927c6);
            this.a0 = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092827);
            this.t0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0927d4);
            this.u0 = this.f.findViewById(R.id.obfuscated_res_0x7f091d5b);
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.u0.setVisibility(0);
            } else {
                this.u0.setVisibility(8);
            }
            this.u0.setOnClickListener(this.O1);
            if (this.b0 != null) {
                this.e0.setVisibility(0);
            }
            this.e0.setPlayer(this.i.getControl());
            this.e0.setOnSeekBarChangeListener(this.M1);
            this.v0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091d5c);
            TextView textView2 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f09092b);
            this.d0 = textView2;
            textView2.setVisibility(8);
            String s2 = n95.m().s("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(s2)) {
                this.d0.setText(s2);
            }
            this.d0.setOnClickListener(this.O1);
            R3();
            this.p.setOnClickListener(this.N1);
            this.t0.setOnClickListener(this.N1);
            this.Z.setOnClickListener(this.O1);
            this.L.setHasDown();
            this.L.setOnClickListener(this.O1);
            this.n.setOnClickListener(this.O1);
            this.o.setOnClickListener(this.O1);
            this.y.setOnClickListener(this.O1);
            this.x.setOnClickListener(this.P1);
            this.w.setOnClickListener(this.Q1);
            this.V.setOnClickListener(this.R1);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.g0 = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.g0.setAnimationListener(this.S1);
            this.C.setVisibility(0);
            if (this.f0) {
                this.e0.setLoading(true);
            }
            if (this.h0 != null && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getParent() != null) {
                Rect rect = this.h0;
                int i4 = rect.right;
                int i5 = rect.left;
                this.x0 = i4 - i5;
                int i6 = rect.bottom;
                int i7 = rect.top;
                this.y0 = i6 - i7;
                this.z0 = i5;
                this.A0 = i7;
                if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    this.i.post(this.U1);
                } else {
                    this.i.post(this.T1);
                }
            } else if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                RelativeLayout relativeLayout2 = this.e1;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(0);
                    this.e1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
            }
            if (this.h0 == null && (relativeLayout = this.e1) != null) {
                ViewGroup.LayoutParams layoutParams4 = relativeLayout.getLayoutParams();
                layoutParams4.height = -1;
                layoutParams4.width = -1;
                this.e1.setVisibility(0);
                this.e1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
            }
            n4();
            if (this.f0) {
                Y3();
            }
            VideoItemData videoItemData4 = this.b0;
            if (videoItemData4 != null && (!StringUtils.isNull(videoItemData4.video_url) || !StringUtils.isNull(this.b0.thread_id))) {
                d5(this.b0.video_url);
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    VideoDanmuController videoDanmuController2 = new VideoDanmuController(getPageContext(), getUniqueId(), this.f, R.id.obfuscated_res_0x7f0927e3, this.b0, this.a);
                    this.j = videoDanmuController2;
                    videoDanmuController2.Q(this.H1);
                }
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                x9a x9aVar = new x9a(this.f, R.id.obfuscated_res_0x7f09281f);
                this.k = x9aVar;
                x9aVar.g(this);
                this.k.h(this.V1);
            }
            bba bbaVar = new bba(getPageContext(), getUniqueId(), this.h, this.a);
            this.b1 = bbaVar;
            bbaVar.setStageType("2005");
            this.b1.setUniqueId(getUniqueId());
            VideoItemData videoItemData5 = this.b0;
            if (videoItemData5 != null && videoItemData5.threadData == null) {
                videoItemData5.threadData = new ThreadData();
                VideoItemData videoItemData6 = this.b0;
                ThreadData threadData = videoItemData6.threadData;
                threadData.tid = videoItemData6.thread_id;
                threadData.threadType = 40;
                threadData.setReply_num(tg.e(videoItemData6.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(tg.e(this.b0.video_width, 0));
                builder.video_height = Integer.valueOf(tg.e(this.b0.video_height, 0));
                VideoItemData videoItemData7 = this.b0;
                builder.video_url = videoItemData7.video_url;
                builder.thumbnail_url = videoItemData7.thumbnail_url;
                builder.video_md5 = videoItemData7.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData7.isVerticalVideo);
                this.b0.threadData.setVideoInfo(builder.build(true));
            }
            VideoItemData videoItemData8 = this.b0;
            if (videoItemData8 != null) {
                c5(videoItemData8, this.b1, this.j);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                    G4();
                } else if (this.W0 != 0) {
                    G4();
                }
            }
            return this.f;
        }
        return (View) invokeLLL.objValue;
    }

    public void p(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048670, this, i2, i3, intent) == null) {
            aaa aaaVar = this.Y0;
            if (aaaVar != null) {
                aaaVar.n(i2, i3, intent);
            }
            if (intent != null && i2 == 24007) {
                int intExtra = intent.getIntExtra("extra_share_status", 2);
                int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
                if (intExtra == 1) {
                    ll9.g().m(getPageContext());
                    ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                    if (shareItem != null) {
                        statisticItem.param("tid", shareItem.O);
                        statisticItem.param("uid", shareItem.S);
                        statisticItem.param("fid", shareItem.N);
                        statisticItem.param("obj_type", intExtra2);
                        statisticItem.param("obj_locate", shareItem.M);
                    }
                    TiebaStatic.log(statisticItem);
                    if (this.a == 7) {
                        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SHARE_SUCCESS);
                        if (shareItem != null) {
                            statisticItem2.param("tid", shareItem.O);
                            statisticItem2.param("uid", shareItem.S);
                            statisticItem2.param("fid", shareItem.N);
                            statisticItem2.param("obj_type", intExtra2);
                            statisticItem2.param("obj_param1", 7);
                        }
                        TiebaStatic.log(statisticItem2);
                    }
                    if (!x4()) {
                        long g2 = tg.g(this.b0.share_num, 0L) + 1;
                        this.b0.share_num = String.valueOf(g2);
                        X4(g2, this.S);
                    }
                }
            }
        }
    }

    public final void s5(View view2, View view3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048679, this, new Object[]{view2, view3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), animatorListenerAdapter}) == null) {
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
}
