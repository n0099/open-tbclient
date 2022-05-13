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
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
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
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.play.TbVideoViewContainer;
import com.baidu.tieba.play.VideoMiddleNiaiControllerView;
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
import com.repackage.a9;
import com.repackage.b78;
import com.repackage.bs4;
import com.repackage.bs7;
import com.repackage.bu8;
import com.repackage.di8;
import com.repackage.es4;
import com.repackage.f9;
import com.repackage.fm4;
import com.repackage.fs4;
import com.repackage.fv8;
import com.repackage.fz4;
import com.repackage.g78;
import com.repackage.g85;
import com.repackage.gg5;
import com.repackage.gh5;
import com.repackage.gs4;
import com.repackage.hu8;
import com.repackage.i78;
import com.repackage.iu4;
import com.repackage.kg;
import com.repackage.ki;
import com.repackage.ku8;
import com.repackage.kv8;
import com.repackage.l85;
import com.repackage.lh8;
import com.repackage.li;
import com.repackage.lu8;
import com.repackage.lv8;
import com.repackage.m78;
import com.repackage.m98;
import com.repackage.mi;
import com.repackage.ng;
import com.repackage.nr4;
import com.repackage.nu8;
import com.repackage.od5;
import com.repackage.oq8;
import com.repackage.ou8;
import com.repackage.pj8;
import com.repackage.pu8;
import com.repackage.py4;
import com.repackage.pz5;
import com.repackage.qc6;
import com.repackage.r78;
import com.repackage.ur4;
import com.repackage.wj8;
import com.repackage.wr4;
import com.repackage.xl4;
import com.repackage.xr8;
import com.repackage.xu4;
import com.repackage.yr4;
import com.repackage.z68;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import tbclient.PbContent;
import tbclient.TiebaPlusInfo;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class VideoPlayFragment extends BaseFragment implements gh5.b, kv8, OnStatusChangedListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public boolean A0;
    public final VideoDanmuController.b A1;
    public ImageView B;
    public int B0;
    public View.OnTouchListener B1;
    public RelativeLayout C;
    public String C0;
    public View.OnLongClickListener C1;
    public ImageView D;
    public String D0;
    public z68.c D1;
    public LinearLayout E;
    public String E0;
    public TbImageView.g E1;
    public TextView F;
    public wr4 F0;
    public SeekBar.OnSeekBarChangeListener F1;
    public ImageView G;
    public yr4 G0;
    public View.OnClickListener G1;
    public LinearLayout H;
    public ForumManageModel H0;
    public View.OnClickListener H1;
    public BarImageView I;
    public xl4 I0;
    public View.OnClickListener I1;
    public ImageView J;
    public py4 J0;
    public View.OnClickListener J1;
    public TextView K;
    public BdUniqueId K0;
    public View.OnClickListener K1;
    public ExpandableTextView L;
    public String L0;
    public Animation.AnimationListener L1;
    public TextView M;
    public RelativeLayout.LayoutParams M0;
    public Runnable M1;
    public View N;
    public OnStatusChangedListener.VideoStatus N0;
    public Runnable N1;
    public View O;
    public String O0;
    public ku8.b O1;
    public View P;
    public boolean P0;
    public GestureDetectorCompat P1;
    public EMTextView Q;
    public boolean Q0;
    public VideoDanmuController.c Q1;
    public EMTextView R;
    public boolean R0;
    public View.OnClickListener R1;
    public EMTextView S;
    public int S0;
    public View.OnClickListener S1;
    public EMTextView T;
    public int T0;
    public yr4.d T1;
    public EMTextView U;
    public fv8 U0;
    public yr4.d U1;
    public TBSpecificationBtn V;
    public nu8 V0;
    public yr4.d V1;
    public TextView W;
    public z68.c W0;
    public yr4.d W1;
    public View X;
    public g1 X0;
    public Runnable X1;
    public LinearLayout Y;
    public lv8 Y0;
    public r78 Y1;
    public LinearLayout Z;
    public bu8 Z0;
    public CustomMessageListener Z1;
    public int a;
    public AlertDialog a1;
    public CustomMessageListener a2;
    public boolean b;
    public RelativeLayout b1;
    public BdUniqueId c;
    public boolean c1;
    public int d;
    public TiePlusEventController d1;
    public int e;
    public boolean e1;
    public View f;
    public gg5 f1;
    public View g;
    public LinearLayout g0;
    public boolean g1;
    public RelativeLayout h;
    public VideoItemData h0;
    public View h1;
    public TbVideoViewContainer i;
    public VideoItemModel i0;
    public View i1;
    public VideoDanmuController j;
    public TextView j0;
    public boolean j1;
    public ku8 k;
    public VideoMiddleNiaiControllerView k0;
    public ObjectAnimator k1;
    public TbImageView l;
    public boolean l0;
    public ObjectAnimator l1;
    public View m;
    public AlphaAnimation m0;
    public oq8 m1;
    public ImageView n;
    public Rect n0;
    public final Runnable n1;
    public ImageView o;
    public boolean o0;
    public final TbVideoViewSet.b o1;
    public View p;
    public ImageView p0;
    public final CustomMessageListener p1;
    public HeadImageView q;
    public ImageView q0;
    public final CustomMessageListener q1;
    public TBLottieAnimationView r;
    public ImageView r0;
    public final CustomMessageListener r1;
    public TBLottieAnimationView s;
    public TextView s0;
    public final CustomMessageListener s1;
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
    @NonNull
    public final BarManageResultListener y1;
    public ImageView z;
    public int z0;
    public final CustomMessageListener z1;

    /* loaded from: classes4.dex */
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

        public static void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                SimpleMessageListener.k(2001457, null);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.Q0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.a.Q0) {
                this.a.Q0 = false;
                this.a.j.Z();
                if (this.a.j != null && this.a.w3()) {
                    this.a.j.U();
                }
                this.a.Y0.X(true);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (videoItemData = (videoPlayFragment = this.a).h0) == null || videoItemData.thread_id == null) {
                return;
            }
            TiebaPlusConfigData.dealFireLinkWithTid(videoPlayFragment.getPageContext(), this.a.h0.thread_id);
            int i = 7;
            if (this.a.a == 1 || this.a.a == 2) {
                i = 6;
            } else if (this.a.a != 3) {
                int unused = this.a.a;
            }
            TiebaPlusConfigData.addClickStatsForFireLink(i);
        }
    }

    /* loaded from: classes4.dex */
    public class a1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public a1(VideoPlayFragment videoPlayFragment) {
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
                if (this.a.l1 == null) {
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.l1 = videoPlayFragment.Z2(1.0f, 1.0f, 1.0f, 100L);
                }
                this.a.l1.start();
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

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes4.dex */
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
                        this.a.a.O2();
                        this.a.a.j1 = true;
                        this.a.a.getActivity().finish();
                    }
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.FALSE));
                    this.a.a.H3(1.0f);
                    this.a.a.y3();
                    this.a.a.f.setBackground(null);
                    this.a.a.b1.setVisibility(0);
                    this.a.a.b1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
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
                int i = mi.i(this.a.f.getContext());
                if (this.a.isResumed() && this.a.l0) {
                    if (this.a.a != 1) {
                        if (this.a.a == 7 && (videoItemData = (videoPlayFragment = this.a).h0) != null && videoItemData.thread_id != null && videoPlayFragment.getActivity() != null && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                            VideoPlayFragment videoPlayFragment2 = this.a;
                            if (li.isEquals(videoPlayFragment2.h0.thread_id, ((FrsVideoTabPlayActivity) videoPlayFragment2.getActivity()).getStartCardTid()) && ((FrsVideoTabPlayActivity) this.a.getActivity()).getStartCardRect() != null) {
                                VideoPlayFragment videoPlayFragment3 = this.a;
                                videoPlayFragment3.n0 = ((FrsVideoTabPlayActivity) videoPlayFragment3.getActivity()).getStartCardRect();
                            }
                        }
                    } else {
                        VideoPlayFragment videoPlayFragment4 = this.a;
                        VideoItemData videoItemData2 = videoPlayFragment4.h0;
                        if (videoItemData2 != null && videoItemData2.thread_id != null && videoPlayFragment4.getActivity() != null && (this.a.getActivity() instanceof VideoPlayActivity)) {
                            VideoPlayFragment videoPlayFragment5 = this.a;
                            if (li.isEquals(videoPlayFragment5.h0.thread_id, ((VideoPlayActivity) videoPlayFragment5.getActivity()).getStartCardTid()) && ((VideoPlayActivity) this.a.getActivity()).getStartCardRect() != null) {
                                VideoPlayFragment videoPlayFragment6 = this.a;
                                videoPlayFragment6.n0 = ((VideoPlayActivity) videoPlayFragment6.getActivity()).getStartCardRect();
                            }
                        }
                    }
                    if ((this.a.a == 1 || this.a.a == 7) && this.a.n0 != null) {
                        VideoPlayFragment videoPlayFragment7 = this.a;
                        videoPlayFragment7.w0 = videoPlayFragment7.n0.right - this.a.n0.left;
                        VideoPlayFragment videoPlayFragment8 = this.a;
                        videoPlayFragment8.x0 = videoPlayFragment8.n0.bottom - this.a.n0.top;
                        VideoPlayFragment videoPlayFragment9 = this.a;
                        videoPlayFragment9.y0 = videoPlayFragment9.n0.left;
                        VideoPlayFragment videoPlayFragment10 = this.a;
                        videoPlayFragment10.z0 = videoPlayFragment10.n0.top;
                        if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                            VideoPlayFragment videoPlayFragment11 = this.a;
                            videoPlayFragment11.g3(videoPlayFragment11.i, this.a.l, this.a.b1, this.a.v0.leftMargin, this.a.y0, this.a.v0.topMargin, this.a.z0, this.a.v0.width, this.a.w0, this.a.v0.height, this.a.x0, i, this.a.x0, 0, this.a.z0, new a(this));
                        }
                    } else if (this.a.getActivity() != null) {
                        this.a.getActivity().finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b0 extends a9 {
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

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.H0.getLoadDataMode() == 0) {
                if (this.a.j3()) {
                    if ((obj instanceof ForumManageModel.b) && this.a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.l(this.a.getPageContext(), Pair.create(Boolean.valueOf(bVar.a), bVar.b));
                    }
                } else {
                    VideoItemData videoItemData = this.a.h0;
                    if (videoItemData != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, videoItemData.getThreadId()));
                    }
                }
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class b1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-318573031, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$b1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-318573031, "Lcom/baidu/tieba/videoplay/VideoPlayFragment$b1;");
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

    /* loaded from: classes4.dex */
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
            ThreadData threadData = this.a.h0.threadData;
            if (threadData != null && aVar.d()) {
                int i = b1.a[aVar.c().ordinal()];
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

    /* loaded from: classes4.dex */
    public class c0 implements xl4.a {
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

        @Override // com.repackage.xl4.a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.I0 != null) {
                        this.a.I0.h(z2);
                    }
                    VideoItemData videoItemData = this.a.h0;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cf));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f9c));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f14b8));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c1(VideoPlayFragment videoPlayFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof pj8)) {
                AgreeData agreeData = ((pj8) customResponsedMessage.getData()).b;
                if (this.a.h0 == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.a.h0.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.a.h0.agree_num = String.valueOf(agreeData.agreeNum);
                    this.a.h0.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.a.G2();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.h0.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.h0.agree_num = String.valueOf(agreeData.agreeNum);
                this.a.h0.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.a.G2();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.l0 && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                boolean p = ((pu8) this.a.V0.a().n(28)).g().p();
                if (booleanValue) {
                    this.a.E2(false);
                } else if (p) {
                    this.a.E2(true);
                } else {
                    this.a.f3();
                }
                ((pu8) this.a.V0.a().n(28)).g().setEmotionClick(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class d1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d1(VideoPlayFragment videoPlayFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.a.Q0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.c.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.a.h0 == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds562);
            int V2 = this.a.V2();
            int e = kg.e(this.a.h0.video_height, 0);
            int e2 = kg.e(this.a.h0.video_width, 0);
            if (e != 0 && e2 != 0) {
                f = (e * 1.0f) / e2;
            }
            if (e > e2) {
                return;
            }
            int k = mi.k(this.a.f.getContext());
            float f2 = k * f;
            int f3 = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds166);
            if (f > 1.0f) {
                i = (int) (dimenPixelSize + ((V2 - dimenPixelSize) * floatValue));
                i2 = (int) (i / f);
                float f4 = 1.0f - floatValue;
                statusBarHeight = (int) (UtilHelper.getStatusBarHeight() * f4);
                this.a.M0.topMargin = (int) (((V2 - f3) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f4) + (f4 * (dimenPixelSize - f3) * 0.5f));
            } else {
                float f5 = dimenPixelSize;
                float f6 = 1.0f - floatValue;
                statusBarHeight = (int) (((V2 - f2) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f6));
                this.a.M0.topMargin = (int) (((V2 - f3) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f6) + (f6 * (dimenPixelSize - f3) * 0.5f));
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

    /* loaded from: classes4.dex */
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
        public boolean a(@Nullable PostData postData, @Nullable bs7 bs7Var) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, postData, bs7Var)) == null) {
                if (this.a.j != null) {
                    this.a.j.O("c14478");
                }
                if (postData != null) {
                    this.a.b3(postData.I(), true);
                    MessageManager.getInstance().registerStickyMode(2921648);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921648, bs7Var));
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements yr4.c {
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

        @Override // com.repackage.yr4.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e3();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (this.a.Q0) {
                    if (bool.booleanValue() || !this.a.w3()) {
                        this.a.startPlay();
                        this.a.y3();
                        return;
                    }
                    this.a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) ? this.a.P1.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.Q0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.w3()) {
                        this.a.startPlay();
                        return;
                    }
                    return;
                }
                this.a.j4();
                this.a.y3();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.Z3();
                this.a.f.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.isResumed() && this.a.l0) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.V3(videoPlayFragment.A0, booleanValue);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g1 {
        void a();

        void onStart();
    }

    /* loaded from: classes4.dex */
    public class h implements z68.c {
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

        @Override // com.repackage.z68.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || this.a.W0 == null) {
                return;
            }
            this.a.W0.a(i, i2);
            if (this.a.g1) {
                this.a.A3(i2, i);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.e4(true);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class i0 implements yr4.d {
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

        @Override // com.repackage.yr4.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.F0 != null) {
                    this.a.F0.dismiss();
                }
                this.a.e4(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.R2(true);
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
                this.a.P0 = true;
                if (this.a.k0 != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.a.k0;
                    if (this.a.a != 4 && this.a.a != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                        i = 0;
                    }
                    videoMiddleNiaiControllerView.setBottomBarShow(false, i);
                }
                this.a.g4();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                if (this.a.isResumed() && this.a.l0) {
                    this.a.k0.setLoading(true);
                }
                this.a.P0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(null);
                    this.a.R2(false);
                    if (!this.a.i.getControl().isPlaying()) {
                        this.a.i.getControl().start();
                        this.a.B.setVisibility(8);
                    }
                    if (!this.a.Q0 && (!this.a.isResumed() || !this.a.l0)) {
                        this.a.y3();
                    }
                    ng.a().removeCallbacks(this.a.X1);
                    ng.a().postDelayed(this.a.X1, 3000L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements yr4.d {
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

        @Override // com.repackage.yr4.d
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
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.a.h0.thread_id);
                markData.setPostId(this.a.h0.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.a.h0.thread_id);
                markData.setForumId(this.a.h0.forum_id);
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

    /* loaded from: classes4.dex */
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
            if (videoPlayFragment.h0 != null) {
                videoPlayFragment.i.getControl().setVideoPath(this.a.L0, this.a.h0.thread_id);
                this.a.i.getControl().k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements yr4.d {
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

        @Override // com.repackage.yr4.d
        public void onClick() {
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.dismiss();
                if (ViewHelper.checkUpIsLogin(this.a.getActivity()) && this.a.getPageContext() != null) {
                    if (this.a.m1 == null && (runTask = MessageManager.getInstance().runTask(2921343, oq8.class, this.a.getContext())) != null) {
                        this.a.m1 = (oq8) runTask.getData();
                    }
                    if (this.a.m1 != null) {
                        VideoPlayFragment videoPlayFragment = this.a;
                        if (videoPlayFragment.h0 != null) {
                            videoPlayFragment.m1.b(this.a.getUniqueId());
                            this.a.m1.a(this.a.h0.post_id);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (view2.getId() == R.id.obfuscated_res_0x7f0918f1 && (videoItemData = this.a.h0) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.a;
                    if (videoPlayFragment.h0.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.a.h0.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.a.h0.getThreadId());
                        UserItemData userItemData2 = this.a.h0.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.a.h0.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.a.h0;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null) {
                    return;
                }
                long g = kg.g(userItemData.user_id, 0L);
                long g2 = kg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = (g == 0 && g2 == 0) ? false : g == g2;
                String str = this.a.h0.author_info.portrait;
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.a.getActivity()).createNormalConfig(g, z, false, true, (this.a.a == 3 || this.a.a == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                createNormalConfig.setPortrait(str);
                createNormalConfig.setSourceTid(this.a.h0.thread_id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.a.h0.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.a.T2(5);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements yr4.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes4.dex */
        public class a implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nr4 a;
            public final /* synthetic */ l0 b;

            public a(l0 l0Var, nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var, nr4Var};
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
                this.a = nr4Var;
            }

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    this.a.dismiss();
                    VideoPlayFragment videoPlayFragment = this.b.a;
                    if (videoPlayFragment.h0 != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.H0;
                        VideoPlayFragment videoPlayFragment2 = this.b.a;
                        VideoItemData videoItemData = videoPlayFragment2.h0;
                        forumManageModel.U(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.A0, null, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ nr4 a;

            public b(l0 l0Var, nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {l0Var, nr4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = nr4Var;
            }

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
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

        @Override // com.repackage.yr4.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.dismiss();
                nr4 nr4Var = new nr4(this.a.getActivity());
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f049c);
                } else {
                    nr4Var.setMessageId(R.string.obfuscated_res_0x7f0f049b);
                }
                nr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f04e3, new a(this, nr4Var));
                nr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f04de, new b(this, nr4Var));
                nr4Var.setCancelable(true);
                nr4Var.create(this.a.getPageContext());
                nr4Var.show();
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.a.Z3();
                } else if (view2.getId() == this.a.n.getId()) {
                    VideoItemData videoItemData = this.a.h0;
                    if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.a.h0.thread_id));
                    }
                    this.a.getActivity().finish();
                } else if (view2.getId() == this.a.L.getId()) {
                    this.a.a3();
                    this.a.T2(7);
                } else if (view2.getId() == this.a.y.getId()) {
                    if (AntiHelper.c(this.a.getPageContext(), this.a.h0)) {
                        return;
                    }
                    this.a.a3();
                    StatisticItem statisticItem = new StatisticItem("c12796");
                    statisticItem.param("tid", this.a.h0.thread_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem);
                    this.a.T2(2);
                } else if (view2.getId() != this.a.Z.getId()) {
                    if (view2.getId() != this.a.j0.getId()) {
                        if (view2.getId() == this.a.t0.getId()) {
                            VideoPlayFragment videoPlayFragment = this.a;
                            if (videoPlayFragment.M2(videoPlayFragment.getPageContext(), 25066)) {
                                this.a.c4();
                                if (this.a.h0 != null) {
                                    StatisticItem statisticItem2 = new StatisticItem("c13025");
                                    statisticItem2.param("tid", this.a.h0.thread_id);
                                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                                    statisticItem2.param("fid", this.a.h0.forum_id);
                                    TiebaStatic.log(statisticItem2);
                                }
                                if (this.a.j != null) {
                                    this.a.j.O("c14475");
                                    return;
                                }
                                return;
                            }
                            return;
                        } else if (view2.getId() == this.a.o.getId() || view2.getId() == this.a.o.getId() || view2.getId() == this.a.o.getId()) {
                            return;
                        } else {
                            view2.getId();
                            this.a.o.getId();
                            return;
                        }
                    }
                    String q = iu4.k().q("nani_key_download_link_url", null);
                    if (TextUtils.isEmpty(q)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.getPageContext().getPageActivity()), new String[]{q}, true);
                } else {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    VideoItemData videoItemData2 = videoPlayFragment2.h0;
                    if (videoItemData2 == null || videoItemData2.act_info == null) {
                        return;
                    }
                    fm4.l(videoPlayFragment2.getActivity(), this.a.h0.act_info.link_url);
                    StatisticItem statisticItem3 = new StatisticItem("c12799");
                    statisticItem3.param("tid", this.a.h0.thread_id);
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    TiebaStatic.log(statisticItem3);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                this.a.h0.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes4.dex */
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
                videoPlayFragment.Q2(videoPlayFragment.d);
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                this.a.d4();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.a.h0.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.a.T2(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.a.h0.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.a.h0.nid);
                BaijiahaoData baijiahaoData = this.a.h0.baijiahaoData;
                if (baijiahaoData != null && !li.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.a.h0.baijiahaoData.oriUgcVid);
                }
                if (this.a.h0.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.a.h0.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.a.h0.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.a.h0.mRecomSource);
                statisticItem2.param("ab_tag", this.a.h0.mRecomAbTag);
                statisticItem2.param("weight", this.a.h0.mRecomWeight);
                statisticItem2.param("extra", this.a.h0.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (l85.j(this.a.getBaseFragmentActivity()) != null && l85.j(this.a.getBaseFragmentActivity()).b() != null && l85.j(this.a.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(l85.j(this.a.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.f1 == null) {
                return;
            }
            this.a.f1.q(TiePlusStat.StatType.CLICK);
            this.a.d1.o(this.a.f1);
            this.a.d1.m(this.a.f1);
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.a.V != null && (videoItemData = (videoPlayFragment = this.a).h0) != null && videoItemData.author_info != null && videoPlayFragment.s != null) {
                    py4 py4Var = videoPlayFragment.J0;
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    UserItemData userItemData = videoPlayFragment2.h0.author_info;
                    String str = userItemData.portrait;
                    String str2 = userItemData.user_id;
                    BdUniqueId bdUniqueId = videoPlayFragment2.K0;
                    VideoItemData videoItemData2 = this.a.h0;
                    py4Var.m(true, str, str2, false, "6", bdUniqueId, videoItemData2.forum_id, "0", videoItemData2.thread_id);
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.h0.author_info.is_follow = "1";
                    videoPlayFragment3.H2();
                    this.a.V.setVisibility(8);
                    this.a.z3();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.a.a != 3 && this.a.a != 4) {
                    statisticItem.param("obj_locate", 2);
                    if (this.a.a != 7) {
                        statisticItem.param("obj_source", this.a.Y2());
                    } else {
                        statisticItem.param("obj_source", 8);
                    }
                } else {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.a.h0.thread_id);
                statisticItem.param("fid", this.a.h0.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.a.T2(6);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.a.h0.author_info.user_id.equals(data.c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.a.K0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.a) {
                    if (!z || "0".equals(this.a.h0.author_info.is_follow)) {
                        return;
                    }
                    mi.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f02ab);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.h0.author_info.is_follow = "0";
                    videoPlayFragment.H2();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.h0.author_info.is_follow = "0";
                    videoPlayFragment2.H2();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.a.h0));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.h0.author_info.is_follow = "1";
                    videoPlayFragment3.H2();
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

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.P0) {
                return;
            }
            this.a.J2(true);
        }
    }

    /* loaded from: classes4.dex */
    public class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes4.dex */
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
                    this.a.a.o0 = true;
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
                RelativeLayout.LayoutParams W2 = this.a.W2();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.f4(videoPlayFragment.i, this.a.l, this.a.y0, W2.leftMargin, this.a.z0, W2.topMargin, this.a.w0, W2.width, this.a.x0, W2.height, new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    this.s.H3((f2 - 0.5f) * 2.0f);
                } else if (!z && animatedFraction < 0.25f) {
                    this.s.H3(1.0f - (animatedFraction * 4.0f));
                }
                this.r.setLayoutParams(this.s.v0);
                this.r.requestLayout();
                this.q.requestLayout();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes4.dex */
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
                    this.a.a.b1.setBackground(null);
                    this.a.a.b1.setVisibility(8);
                    this.a.a.o0 = true;
                    if (this.a.a.v0 != null) {
                        this.a.a.v0.addRule(14);
                    }
                    this.a.a.I3(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.a.f.setBackground(null);
                    super.onAnimationStart(animator);
                    this.a.a.b1.setVisibility(0);
                    if (this.a.a.l != null) {
                        this.a.a.l.setVisibility(8);
                    }
                    this.a.a.b1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
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
                int i = mi.i(this.a.f.getContext());
                RelativeLayout.LayoutParams W2 = this.a.W2();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.g3(videoPlayFragment.i, this.a.l, this.a.b1, this.a.y0, W2.leftMargin, this.a.z0, W2.topMargin, this.a.w0, W2.width, this.a.x0, W2.height, this.a.x0, i, this.a.z0, 0, new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class t implements ku8.b {
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

        @Override // com.repackage.ku8.b
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

    /* loaded from: classes4.dex */
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
                this.a.Y0.U();
                VideoPlayFragment videoPlayFragment = this.a;
                VideoItemData videoItemData = videoPlayFragment.h0;
                if (videoItemData != null) {
                    videoPlayFragment.h4(videoItemData.thread_id, false);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final od5<String> a;
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
            this.a = new od5<>(300, TimeUnit.MILLISECONDS);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.a.a("onTouchDownEvent")) {
                    return super.onDoubleTap(motionEvent);
                }
                this.b.K(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.b.i4()) {
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
                    this.b.x3();
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

    /* loaded from: classes4.dex */
    public class u0 implements r78 {
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

        @Override // com.repackage.r78
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.r78
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.repackage.r78
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.repackage.r78
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
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
            this.a.i.getControl().m();
            this.a.i.getControl().seekTo(0);
            if (UbsABTestHelper.isAutoPlayNextVideo() && (this.a.a == 1 || this.a.a == 2)) {
                if (this.a.X0 == null || this.a.Q0) {
                    this.a.i.getControl().start();
                } else {
                    this.a.X0.a();
                    this.a.l.setVisibility(8);
                    this.a.i.getControl().start();
                }
            } else if (!UbsABTestHelper.isFeedVideoImmersionTransition()) {
                this.a.i.getControl().start();
            }
            this.a.C3();
            VideoPlayFragment.u2(this.a);
            if (this.a.S0 == 3) {
                this.a.K2();
            }
            if (this.a.Q0) {
                return;
            }
            if (this.a.isResumed() && this.a.l0) {
                return;
            }
            this.a.y3();
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
                if (this.a.l0 && ((i == 3 || i == 904) && this.a.l.getVisibility() == 0)) {
                    this.a.l.clearAnimation();
                    this.a.l.startAnimation(this.a.m0);
                }
                if (i != 10012 || this.a.U0 == null) {
                    return true;
                }
                this.a.U0.c();
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
            if (this.a.k0 != null) {
                this.a.k0.setVisibility(0);
                if (this.a.k0.getCurProgress() == 0) {
                    this.a.k0.p();
                    return;
                }
                return;
            }
            this.a.k0.setVisibility(8);
        }

        @Override // com.repackage.r78
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

        @Override // com.repackage.r78
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.repackage.r78
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setStatistic(m78 m78Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, m78Var) == null) {
            }
        }

        @Override // com.repackage.r78
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // com.repackage.r78
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // com.repackage.r78
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (videoPlayFragment.h0 != null) {
                videoPlayFragment.i.getControl().setVideoPath(this.a.L0, this.a.h0.thread_id);
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
                this.a.O3();
            }
            this.a.P3();
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.c.a1 != null) {
                    this.c.a1.dismiss();
                }
                if (ki.A()) {
                    ForumManageModel forumManageModel = this.c.H0;
                    VideoItemData videoItemData = this.c.h0;
                    forumManageModel.U(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.a, null, this.b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    return;
                }
                mi.M(this.c.getContext(), R.string.obfuscated_res_0x7f0f0c2d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements VideoDanmuController.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes4.dex */
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
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.h0.parseProto(this.a);
                    this.b.a.h0.reGenerateTitle();
                    VideoPlayFragment videoPlayFragment = this.b.a;
                    videoPlayFragment.h0.threadData = this.a;
                    videoPlayFragment.N3();
                    this.b.a.O3();
                    VideoItemData videoItemData = this.b.a.h0;
                    if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.b.a;
                    videoPlayFragment2.Q3(videoPlayFragment2.h0, videoPlayFragment2.Y0, this.b.a.j);
                    VideoPlayFragment videoPlayFragment3 = this.b.a;
                    videoPlayFragment3.R3(videoPlayFragment3.h0.video_url);
                    if (this.b.a.h0.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.b.a.h0.author_info.user_id)) {
                        this.b.a.A0 = true;
                    }
                    this.b.a.L2();
                    VideoPlayFragment videoPlayFragment4 = this.b.a;
                    videoPlayFragment4.setUserVisibleHint(videoPlayFragment4.l0);
                }
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
                ng.a().post(new a(this, threadData));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a1 == null) {
                return;
            }
            this.a.a1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class x implements lv8.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lv8 a;
        public final /* synthetic */ VideoDanmuController b;
        public final /* synthetic */ VideoPlayFragment c;

        public x(VideoPlayFragment videoPlayFragment, lv8 lv8Var, VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, lv8Var, videoDanmuController};
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
            this.a = lv8Var;
            this.b = videoDanmuController;
        }

        @Override // com.repackage.lv8.d
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
                lv8 lv8Var = this.a;
                if (lv8Var != null) {
                    VideoDanmuController videoDanmuController2 = this.b;
                    if (videoDanmuController2 != null) {
                        lv8Var.I0(videoDanmuController2.F());
                    }
                    if (UbsABTestHelper.isFeedVideoImmersionTransition() && !this.c.n3() && this.c.n0 != null && this.c.L0 != null) {
                        TbVideoViewSet.b().d(this.c.L0);
                    }
                    this.c.y3();
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

    /* loaded from: classes4.dex */
    public class x0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x0(VideoPlayFragment videoPlayFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof wj8)) {
                wj8 wj8Var = (wj8) customResponsedMessage.getData();
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData == null || (threadData = videoItemData.threadData) == null || (str = threadData.tid) == null || !str.equals(wj8Var.a)) {
                    return;
                }
                this.a.h0.threadData.setIsMarked(wj8Var.b ? 1 : 0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements ou8.b {
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

        @Override // com.repackage.ou8.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.j == null) {
                return;
            }
            this.a.j.V(str);
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.a.isResumed() && this.a.l0) {
                if (ki.z()) {
                    if (this.a.a4()) {
                        return;
                    }
                    this.a.startPlay();
                    return;
                }
                mi.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0c2d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements nu8.d {
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

        @Override // com.repackage.nu8.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    this.a.t0.setVisibility(0);
                } else {
                    this.a.t0.setVisibility(8);
                }
                if (z) {
                    this.a.N2("");
                    if (this.a.j != null) {
                        this.a.j.O("c14476");
                    }
                } else {
                    this.a.N2(((pu8) this.a.V0.a().n(28)).f().getText().toString());
                }
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData != null && z) {
                    long g = kg.g(videoItemData.comment_num, 0L) + 1;
                    this.a.h0.comment_num = String.valueOf(g);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.L3(g, videoPlayFragment.Q);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
                this.a.F2();
            }
        }
    }

    /* loaded from: classes4.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isPrimary() && this.a.l0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof i78)) {
                i78 i78Var = (i78) customResponsedMessage.getData();
                SeekBar seekBar = this.a.k0.getSeekBar();
                int i = i78Var.a;
                if (i == 1) {
                    seekBar.setProgress(i78Var.b);
                    this.a.k0.k(seekBar, i78Var.b, true);
                } else if (i == 2) {
                    this.a.k0.l(seekBar);
                } else if (i == 3) {
                    this.a.k0.m(seekBar);
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
        this.o0 = false;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = BdUniqueId.gen();
        this.N0 = OnStatusChangedListener.VideoStatus.INIT;
        this.R0 = false;
        this.S0 = 1;
        this.T0 = -1;
        this.e1 = false;
        this.g1 = true;
        this.j1 = false;
        this.k1 = null;
        this.l1 = null;
        this.n1 = new k(this);
        this.o1 = new v(this);
        this.p1 = new g0(this, 2921607);
        this.q1 = new p0(this, 2001115);
        this.r1 = new y0(this, 2000994);
        this.s1 = new c1(this, 2016528);
        this.t1 = new d1(this, 2921594);
        this.u1 = new e1(this, 2001011);
        this.v1 = new f1(this, 2921596);
        this.w1 = new a(this, 2921598);
        this.x1 = new b(this, 2921612);
        this.y1 = new BarManageResultListener(new c(this));
        this.z1 = new d(this, 2921645);
        this.A1 = new e(this);
        this.B1 = new f(this);
        this.C1 = new g(this);
        this.D1 = new h(this);
        this.E1 = new i(this);
        this.F1 = new j(this);
        this.G1 = new l(this);
        this.H1 = new m(this);
        this.I1 = new n(this);
        this.J1 = new o(this);
        this.K1 = new p(this);
        this.L1 = new q(this);
        this.M1 = new r(this);
        this.N1 = new s(this);
        this.O1 = new t(this);
        this.P1 = new GestureDetectorCompat(getContext(), new u(this));
        this.Q1 = new w(this);
        this.R1 = new a0(this);
        this.S1 = new h0(this);
        this.T1 = new i0(this);
        this.U1 = new j0(this);
        this.V1 = new k0(this);
        this.W1 = new l0(this);
        this.X1 = new q0(this);
        this.Y1 = new u0(this);
        this.Z1 = new x0(this, 2921603);
        this.a2 = new z0(this, 2921635);
    }

    public static /* synthetic */ int u2(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.S0;
        videoPlayFragment.S0 = i2 + 1;
        return i2;
    }

    public final void A3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
            VideoItemData videoItemData = this.h0;
            if (!(videoItemData == null && videoItemData.video_url == null) && i2 > this.h0.video_duration * 1000) {
                this.g1 = false;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_PTS);
                statisticItem.param("obj_id", this.h0.video_url);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void B3(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && this.h0 != null && this.n0 == null) {
            StatisticItem statisticItem = new StatisticItem("c12794");
            statisticItem.param("tid", this.h0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.h0.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            statisticItem2.param("page_type", "a023");
            statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
            TiebaStatic.log(statisticItem2);
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.h0 == null) {
            return;
        }
        m78 m78Var = new m78();
        m78Var.a = "nani_midpage";
        VideoItemData videoItemData = this.h0;
        m78Var.c = videoItemData.thread_id;
        m78Var.t = videoItemData.nid;
        m78Var.d = this.h0.forum_id + "";
        m78Var.e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.h0;
        m78Var.f = videoItemData2.mRecomSource;
        m78Var.g = videoItemData2.mRecomAbTag;
        m78Var.h = videoItemData2.mRecomWeight;
        m78Var.i = "";
        m78Var.k = "";
        m78Var.m = videoItemData2.mMd5;
        m78Var.x = videoItemData2.getChannelMidRequestNum();
        m78Var.y = this.h0.getChannelMidRequestVideoNum();
        if (this.n0 != null) {
            m78Var.n = "1";
        } else {
            m78Var.n = "2";
        }
        int i2 = this.a;
        if (i2 == 1 || i2 == 2) {
            m78Var.p = "1";
            m78Var.a = "auto_midpage";
            m78Var.i = "index";
        }
        b78.e(this.h0.mMd5, "", "1", m78Var, this.i.getControl().getPcdnState());
        int i3 = this.a;
        if (i3 == 1 || i3 == 3) {
            hu8.c(this.h0.mMd5);
        } else if (i3 == 2 || i3 == 4) {
            hu8.a(this.h0.mMd5);
        } else if (i3 == 7) {
            hu8.b(this.h0.mMd5);
        }
    }

    public final void D2(ShareItem shareItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareItem) == null) {
            VideoInfo.Builder builder = new VideoInfo.Builder();
            builder.video_duration = Integer.valueOf(this.h0.video_duration);
            builder.play_count = Integer.valueOf(this.h0.play_count);
            VideoItemData videoItemData = this.h0;
            builder.thumbnail_url = videoItemData.thumbnail_url;
            builder.thumbnail_height = Integer.valueOf(kg.e(videoItemData.thumbnail_height, 0));
            builder.thumbnail_width = Integer.valueOf(kg.e(this.h0.thumbnail_width, 0));
            shareItem.V.threadData.setVideoInfo(builder.build(true));
        }
    }

    public final void D3() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || this.A == null || (imageView = this.z) == null) {
            return;
        }
        imageView.clearAnimation();
        this.A.clearAnimation();
        this.z.setVisibility(0);
        this.A.setVisibility(8);
    }

    public final void E2(boolean z2) {
        nu8 nu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z2) == null) || (nu8Var = this.V0) == null || nu8Var.a() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V0.a().getLayoutParams();
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
        this.V0.a().requestLayout();
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || a4()) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.h0 != null) {
            if (this.i.getParent() == null) {
                O3();
                P3();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.k0;
            if (videoMiddleNiaiControllerView != null) {
                videoMiddleNiaiControllerView.n();
            }
            if (!UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                this.i.getControl().setIsVolume0(false);
            }
            this.i.getControl().p(this.o1);
            this.k0.p();
            this.B.setVisibility(8);
            X3();
        }
        if (isResumed() && this.l0 && w3()) {
            return;
        }
        y3();
        if (this.B != null) {
            K3();
        }
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i2 = this.a;
            if (i2 != 4 && i2 != 3) {
                F3(UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            } else {
                F3(0);
            }
        }
    }

    public final void F3(int i2) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (view2 = this.f) == null) {
            return;
        }
        view2.setPadding(0, 0, 0, i2);
    }

    public final void G2() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoItemData = this.h0) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080825, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080823, WebPManager.ResourceStateType.NORMAL));
        }
        L3(kg.g(this.h0.agree_num, 0L), this.R);
    }

    public final void G3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.x.setVisibility(i2);
            this.X.setVisibility(i2);
            this.y.setVisibility(i2);
            this.w.setVisibility(i2);
            this.u.setVisibility(i2);
        }
    }

    public final void H2() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null && (userItemData = videoItemData.author_info) != null && !this.A0 && (userItemData == null || !"1".equals(userItemData.is_follow))) {
                this.V.setVisibility(0);
                this.V.setClickable(true);
                return;
            }
            this.V.setVisibility(4);
            this.V.setClickable(false);
        }
    }

    public final void H3(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048588, this, f2) == null) {
            LinearLayout linearLayout = this.u;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
                this.u.setAlpha(f2);
            }
            LinearLayout linearLayout2 = this.y;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
                this.y.setAlpha(f2);
            }
            RelativeLayout relativeLayout = this.x;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
                this.x.setAlpha(f2);
            }
            LinearLayout linearLayout3 = this.w;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
                this.w.setAlpha(f2);
            }
            View view2 = this.h1;
            if (view2 != null) {
                view2.setVisibility(0);
                this.h1.setAlpha(f2);
            }
            View view3 = this.i1;
            if (view3 != null) {
                view3.setVisibility(0);
                this.i1.setAlpha(f2);
            }
            View view4 = this.m;
            if (view4 != null) {
                view4.setVisibility(0);
                this.m.setAlpha(f2);
            }
            View view5 = this.g;
            if (view5 != null) {
                view5.setVisibility(0);
                this.g.setAlpha(f2);
            }
        }
    }

    public void I2(int i2) {
        nu8 nu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i2) == null) || (nu8Var = this.V0) == null || nu8Var.a() == null) {
            return;
        }
        this.V0.a().w(i2);
    }

    public final void I3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            LinearLayout linearLayout = this.u;
            if (linearLayout != null) {
                linearLayout.setVisibility(i2);
            }
            LinearLayout linearLayout2 = this.y;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(i2);
            }
            RelativeLayout relativeLayout = this.x;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(i2);
            }
            LinearLayout linearLayout3 = this.w;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(i2);
            }
            View view2 = this.h1;
            if (view2 != null) {
                view2.setVisibility(i2);
            }
            View view3 = this.i1;
            if (view3 != null) {
                view3.setVisibility(i2);
            }
            View view4 = this.m;
            if (view4 != null) {
                view4.setVisibility(i2);
            }
            View view5 = this.g;
            if (view5 != null) {
                view5.setVisibility(i2);
            }
        }
    }

    public final void J2(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) || (videoMiddleNiaiControllerView = this.k0) == null) {
            return;
        }
        int i2 = this.a;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick()) ? 1 : 0);
    }

    public void J3(z68.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, cVar) == null) {
            this.W0 = cVar;
        }
    }

    @Override // com.repackage.gh5.b
    public void K(float f2, float f3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.h0) != null && "0".equals(videoItemData.is_agreed)) {
            Q2(this.e);
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || r3() || this.A == null || this.z == null) {
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

    public final void K3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.B.setVisibility(0);
            if (this.k1 == null) {
                this.k1 = Z2(0.0f, 3.0f, 3.0f, 0L);
            }
            this.k1.addListener(new a1(this));
            this.k1.start();
        }
    }

    public final void L2() {
        VideoItemData videoItemData;
        String forum_name;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (videoItemData = this.h0) == null) {
            return;
        }
        this.l.K(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.h0.getTitle();
        boolean z2 = kg.e(this.h0.video_height, 0) <= kg.e(this.h0.video_width, 0);
        if (TextUtils.isEmpty(title) && (!z2 || this.h0.video_duration < 60)) {
            this.P.setVisibility(8);
        } else {
            if (this.h0.video_duration >= 60) {
                this.N.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(mi.f(getContext(), R.dimen.tbds31), mi.f(getContext(), R.dimen.tbds31));
                }
                layoutParams.width = mi.f(getContext(), R.dimen.tbds3);
                layoutParams.height = mi.f(getContext(), R.dimen.tbds34);
                this.O.setLayoutParams(layoutParams);
                this.O.setBackgroundColor(getResources().getColor(R.color.CAM_X0618));
                int i2 = this.h0.video_duration;
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
                gs4 d2 = gs4.d(this.M);
                d2.z(R.dimen.T_X08);
                d2.v(R.color.CAM_X0618);
                d2.A(R.string.F_X02);
                this.M.setText(sb.toString());
            } else {
                this.N.setVisibility(8);
            }
            this.P.setVisibility(0);
            this.L.setTextSize(mi.f(getContext(), R.dimen.T_X07));
            this.L.setTextColor(R.color.CAM_X0621);
            this.L.setLineSpacingExtra(mi.f(getContext(), R.dimen.tbds10));
            this.L.setExpandable(false);
            this.L.setTextMaxLine(3);
            this.L.setLimitLine(3);
            this.L.setOnStatusChangedListener(new m0(this));
            ExpandableTextView expandableTextView = this.L;
            VideoItemData videoItemData2 = this.h0;
            expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        L3(kg.g(this.h0.comment_num, 0L), this.Q);
        L3(kg.g(this.h0.agree_num, 0L), this.R);
        if (r3()) {
            this.S.setText(R.string.obfuscated_res_0x7f0f0ad9);
        } else {
            L3(kg.g(this.h0.share_num, 0L), this.S);
        }
        UserItemData userItemData = this.h0.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.h0.author_info.portrait.startsWith("http")) {
                this.q.K(this.h0.author_info.portrait, 10, false);
            } else {
                this.q.K(this.h0.author_info.portrait, 12, false);
            }
            if (t3() && !TextUtils.isEmpty(this.h0.author_info.auth)) {
                this.q.setShowV(true);
                this.q.setOriginatorResId(R.drawable.obfuscated_res_0x7f0805e5);
            } else {
                this.q.setShowV(false);
                this.q.setOriginatorResId(0);
            }
            if (StringUtils.isNull(this.h0.author_info.getUserShowName())) {
                this.s0.setVisibility(8);
            } else {
                this.s0.setVisibility(0);
                this.s0.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.h0.author_info.getUserShowName(), 16, StringHelper.STRING_MORE));
            }
        }
        AlaInfoData alaInfoData = this.h0.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            d3(this.h0.mAlaInfoData.live_status == 1);
            c3();
        }
        if ("1".equals(this.h0.is_private) && this.j0.getVisibility() != 0) {
            this.g0.setVisibility(0);
        } else {
            this.g0.setVisibility(8);
        }
        if ("1".equals(this.h0.is_agreed)) {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080825, WebPManager.ResourceStateType.NORMAL));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.p0, AnimationProperty.SCALE_X, 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.p0, AnimationProperty.SCALE_Y, 1.3f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat2.setDuration(300L);
            ofFloat.start();
            ofFloat2.start();
        } else {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080823, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.h0.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.j0.getVisibility() != 0) {
            this.Z.setVisibility(8);
            this.W.setText(this.h0.act_info.activity_name);
        } else {
            this.Z.setVisibility(8);
        }
        H2();
        boolean i32 = i3();
        if (this.a == 7) {
            this.E.setVisibility(8);
        } else if (i32) {
        } else {
            if (!TextUtils.isEmpty(this.h0.forum_name)) {
                forum_name = this.h0.forum_name;
            } else {
                ThreadData threadData = this.h0.threadData;
                forum_name = (threadData == null || TextUtils.isEmpty(threadData.getForum_name())) ? null : this.h0.threadData.getForum_name();
            }
            if (TextUtils.isEmpty(forum_name)) {
                return;
            }
            this.E.setVisibility(0);
            WebPManager.setPureDrawable(this.J, R.drawable.obfuscated_res_0x7f0808f4, R.color.CAM_X0101, null);
            this.J.setVisibility(0);
            this.I.setVisibility(8);
            String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(forum_name + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02d1), 12, "...吧");
            this.C0 = cutChineseAndEnglishWithEmoji;
            this.K.setText(cutChineseAndEnglishWithEmoji);
            ThreadData threadData2 = this.h0.threadData;
            if (threadData2 != null && !TextUtils.isEmpty(threadData2.getRecomReason())) {
                TextView textView = this.K;
                textView.setText(this.C0 + getActivity().getResources().getString(R.string.obfuscated_res_0x7f0f151d));
            }
            this.E.setOnClickListener(new n0(this, forum_name));
        }
    }

    public final void L3(long j2, TextView textView) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048597, this, j2, textView) == null) || textView == null) {
            return;
        }
        String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(j2);
        if (!"0".equals(numberUniformFormatExtraWithRoundVote)) {
            textView.setText(numberUniformFormatExtraWithRoundVote);
            return;
        }
        if (textView.getId() == R.id.obfuscated_res_0x7f090158) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f150e);
        } else if (textView.getId() == R.id.obfuscated_res_0x7f090692) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f150f);
        } else {
            string = textView.getId() == R.id.obfuscated_res_0x7f091d0a ? TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1511) : "";
        }
        textView.setText(string);
    }

    @Override // com.repackage.kv8
    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.T0 = i2;
        }
    }

    public final boolean M2(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.q.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.width = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams.height = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.height = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
            }
        }
    }

    public final void N2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.u0.setText(R.string.obfuscated_res_0x7f0f0fb3);
                DanmuPostDraftManager.b.a().c(this.h0.thread_id);
                return;
            }
            this.u0.setText(R.string.obfuscated_res_0x7f0f050c);
            DanmuPostDraftManager.b.a().d(this.h0.thread_id, str);
        }
    }

    public void N3() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (videoItemData = this.h0) == null) {
            return;
        }
        int e2 = kg.e(videoItemData.video_height, 0);
        int e3 = kg.e(this.h0.video_width, 0);
        int V2 = V2();
        int k2 = mi.k(this.f.getContext());
        if (e2 <= 0 || e3 <= 0 || V2 <= 0 || k2 <= 0) {
            this.i.getControl().setVideoScalingMode(2);
            this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
            return;
        }
        float f2 = (e2 * 1.0f) / e3;
        if (f2 > 1.0f) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
            this.M0 = layoutParams;
            layoutParams.removeRule(13);
            this.M0.addRule(14);
            this.M0.topMargin = (V2 - mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
            this.M0 = layoutParams2;
            layoutParams2.removeRule(13);
            this.M0.addRule(14);
            this.M0.topMargin = (V2 - mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
        }
        if (f2 > 1.34f) {
            this.i.getControl().setVideoScalingMode(0);
            this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        this.i.getControl().setVideoScalingMode(2);
        this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if ((this.i.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof g78)) {
                ((TbVideoView) this.i.getControl()).N();
                ((g78) this.i.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
            }
            TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921683, this.L0));
        }
    }

    public void O3() {
        TbVideoViewContainer tbVideoViewContainer;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        TbVideoViewContainer tbVideoViewContainer2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getParent() == null) {
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null && TextUtils.isEmpty(videoItemData.video_height) && TextUtils.isEmpty(this.h0.video_width)) {
                return;
            }
            if (this.h0 != null) {
                this.v0 = new RelativeLayout.LayoutParams(-1, -1);
                N3();
                Rect rect = this.n0;
                if (rect != null && !this.o0) {
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
                    this.v0 = W2();
                }
                int i6 = this.a;
                if (i6 != 4 && i6 != 3) {
                    this.v0.bottomMargin = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
                } else {
                    this.v0.bottomMargin = mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                }
                this.l.setLayoutParams(this.v0);
                if (this.h != null && (tbVideoViewContainer2 = this.i) != null) {
                    tbVideoViewContainer2.setId(R.id.obfuscated_res_0x7f092353);
                    if (m3() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                        this.v0.addRule(15);
                    }
                    this.h.addView(this.i, 0, this.v0);
                }
                boolean z2 = kg.e(this.h0.video_height, 0) <= kg.e(this.h0.video_width, 0);
                if (this.h0.video_duration >= 60 && z2) {
                    View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d086c, (ViewGroup) null);
                    this.g = inflate;
                    EMTextView eMTextView = (EMTextView) this.g.findViewById(R.id.obfuscated_res_0x7f090c02);
                    WebPManager.setPureDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c01), R.drawable.obfuscated_res_0x7f0809f0, R.color.CAM_X0101, null);
                    eMTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0102));
                    eMTextView.setText(getString(R.string.obfuscated_res_0x7f0f1501));
                    eMTextView.setGravity(17);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(3, R.id.obfuscated_res_0x7f092353);
                    layoutParams2.addRule(14, -1);
                    layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.h.addView(this.g, layoutParams2);
                    h4(this.h0.thread_id, true);
                    if (UbsABTestHelper.isFeedVideoImmersionTransition() && !n3()) {
                        this.g.setVisibility(8);
                    } else {
                        this.g.setVisibility(0);
                    }
                    this.g.setOnClickListener(new t0(this));
                }
            }
            if (this.h0 != null) {
                m78 m78Var = new m78();
                m78Var.e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData2 = this.h0;
                m78Var.c = videoItemData2.thread_id;
                m78Var.t = videoItemData2.nid;
                m78Var.d = videoItemData2.forum_id;
                m78Var.m = videoItemData2.mMd5;
                m78Var.k = "";
                m78Var.f = videoItemData2.mRecomSource;
                m78Var.l = videoItemData2.mRecomAbTag;
                m78Var.j = 1;
                m78Var.x = videoItemData2.getChannelMidRequestNum();
                m78Var.y = this.h0.getChannelMidRequestVideoNum();
                BaijiahaoData baijiahaoData = this.h0.baijiahaoData;
                if (baijiahaoData != null) {
                    int i7 = baijiahaoData.oriUgcType;
                    if (i7 == 2) {
                        m78Var.j = 3;
                    } else if (i7 == 4) {
                        m78Var.j = 2;
                    }
                }
                m78Var.h = this.h0.mRecomWeight;
                if (this.n0 != null) {
                    m78Var.n = "1";
                } else {
                    m78Var.n = "2";
                }
                int i8 = this.a;
                if (i8 == 1) {
                    m78Var.p = "1";
                    m78Var.a = "13";
                    m78Var.i = this.D0;
                    m78Var.k = this.O0;
                    m78Var.g = this.h0.mRecomWeight;
                } else if (i8 == 2) {
                    m78Var.a = "24";
                } else {
                    m78Var.a = "13";
                }
                m78Var.p = "1";
                int i9 = this.a;
                if (i9 == 3) {
                    m78Var.a = "21";
                } else if (i9 == 4) {
                    m78Var.a = "22";
                } else if (i9 == 7) {
                    m78Var.a = "26";
                } else if (l3()) {
                    m78Var.a = "27";
                }
                String str = this.D0;
                m78Var.i = str;
                String str2 = this.O0;
                m78Var.k = str2;
                VideoItemData videoItemData3 = this.h0;
                String str3 = videoItemData3.mRecomWeight;
                m78Var.g = str3;
                m78Var.w = videoItemData3.mExtra;
                if (this.a == 5) {
                    m78Var.a = "23";
                    m78Var.p = "1";
                    m78Var.i = str;
                    m78Var.k = str2;
                    m78Var.g = str3;
                }
                if (j3() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    m78Var.i = personalPageParams.getStatPageFromIdentifier();
                }
                this.i.getControl().setVideoStatData(m78Var);
                this.i.getControl().setLocateSource("v_mid_page");
            }
            this.i.getControl().setContinuePlayEnable(true);
        }
    }

    public void P2() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && (alertDialog = this.a1) != null && alertDialog.isShowing()) {
            this.a1.dismiss();
        }
    }

    public final void P3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.i.getControl().setVideoStatusChangeListener(this);
            this.i.getControl().setOperableVideoContainer(this.Y1);
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
    public final void Q2(int i2) {
        VideoItemData videoItemData;
        int i3;
        g85 currentVisiblePageExtra;
        BaijiahaoData baijiahaoData;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.h0) != null) {
            if (i2 == this.d) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.h0;
                    videoItemData2.agree_num = String.valueOf(kg.e(videoItemData2.agree_num, 0) - 1);
                    this.h0.is_agreed = "0";
                    i3 = 1;
                    StatisticItem statisticItem = new StatisticItem("c12795");
                    statisticItem.param("tid", this.h0.thread_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (i2 != this.d) {
                        statisticItem.param("obj_type", i3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c12003");
                    statisticItem2.param("tid", this.h0.thread_id);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (i2 != this.d) {
                        statisticItem2.param("obj_type", i3);
                    } else {
                        statisticItem2.param("obj_type", 2);
                    }
                    if ("index".equals(this.D0)) {
                        statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                        statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                    }
                    currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
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
                            statisticItem3.param("obj_source", Y2());
                        }
                        statisticItem3.param("tid", this.h0.thread_id);
                        statisticItem3.param("fid", this.h0.forum_id);
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
                    L2();
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
                    httpMessage.addParam("thread_id", this.h0.thread_id);
                    httpMessage.addParam("op_type", i3);
                    httpMessage.addParam("obj_type", 3);
                    httpMessage.addParam("agree_type", 2);
                    httpMessage.addHeader("needSig", "1");
                    baijiahaoData = this.h0.baijiahaoData;
                    if (baijiahaoData != null) {
                        httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                        httpMessage.addParam("ori_ugc_nid", this.h0.baijiahaoData.oriUgcNid);
                        httpMessage.addParam("ori_ugc_vid", this.h0.baijiahaoData.oriUgcVid);
                        httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.h0.baijiahaoData.oriUgcType);
                    }
                    if (currentVisiblePageExtra != null) {
                        httpMessage.addParam("obj_source", currentVisiblePageExtra.a());
                    }
                    sendMessage(httpMessage);
                    pj8 pj8Var = new pj8();
                    AgreeData agreeData = new AgreeData();
                    str = this.h0.thread_id;
                    if (str != null) {
                        agreeData.threadId = str;
                    }
                    agreeData.agreeNum = Long.valueOf(this.h0.agree_num).longValue();
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = "1".equals(this.h0.is_agreed);
                    pj8Var.b = agreeData;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, pj8Var));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.h0));
                    if (TbadkCoreApplication.isLogin() || i3 != 0) {
                    }
                    if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                        lh8.r().A(0, 3);
                        lh8.r().G();
                    }
                    lh8.r().z(StampMission.Type.LIKE_THREAD);
                    return;
                }
                VideoItemData videoItemData3 = this.h0;
                videoItemData3.agree_num = String.valueOf(kg.e(videoItemData3.agree_num, 0) + 1);
                this.h0.is_agreed = "1";
                T2(1);
            } else {
                videoItemData.agree_num = String.valueOf(kg.e(videoItemData.agree_num, 0) + 1);
                this.h0.is_agreed = "1";
                T2(1);
            }
            i3 = 0;
            StatisticItem statisticItem4 = new StatisticItem("c12795");
            statisticItem4.param("tid", this.h0.thread_id);
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 != this.d) {
            }
            TiebaStatic.log(statisticItem4);
            StatisticItem statisticItem22 = new StatisticItem("c12003");
            statisticItem22.param("tid", this.h0.thread_id);
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 != this.d) {
            }
            if ("index".equals(this.D0)) {
            }
            currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
            }
            TiebaStatic.log(statisticItem22);
            L2();
            HttpMessage httpMessage2 = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage2.addParam("thread_id", this.h0.thread_id);
            httpMessage2.addParam("op_type", i3);
            httpMessage2.addParam("obj_type", 3);
            httpMessage2.addParam("agree_type", 2);
            httpMessage2.addHeader("needSig", "1");
            baijiahaoData = this.h0.baijiahaoData;
            if (baijiahaoData != null) {
            }
            if (currentVisiblePageExtra != null) {
            }
            sendMessage(httpMessage2);
            pj8 pj8Var2 = new pj8();
            AgreeData agreeData2 = new AgreeData();
            str = this.h0.thread_id;
            if (str != null) {
            }
            agreeData2.agreeNum = Long.valueOf(this.h0.agree_num).longValue();
            agreeData2.agreeType = 2;
            agreeData2.hasAgree = "1".equals(this.h0.is_agreed);
            pj8Var2.b = agreeData2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, pj8Var2));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.h0));
            if (TbadkCoreApplication.isLogin()) {
            }
        }
    }

    public final void Q3(VideoItemData videoItemData, lv8 lv8Var, VideoDanmuController videoDanmuController) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048608, this, videoItemData, lv8Var, videoDanmuController) == null) || lv8Var == null || lv8Var.getMainView() == null) {
            return;
        }
        lv8Var.G0(videoItemData);
        boolean z2 = false;
        boolean z3 = kg.e(videoItemData.video_height, 0) <= kg.e(videoItemData.video_width, 0);
        if (this.l0 && z3) {
            z2 = true;
        }
        lv8Var.X(z2);
        lv8Var.H0(new x(this, lv8Var, videoDanmuController));
        lv8Var.getMainView().setVisibility(8);
    }

    public final void R2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            if (z2) {
                G3(8);
                this.v.setVisibility(0);
                return;
            }
            G3(0);
            this.v.setVisibility(8);
        }
    }

    public final void R3(String str) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, str) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null || str == null || str.equals(this.L0)) {
            return;
        }
        this.L0 = str;
    }

    public final void S2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048611, this) == null) || this.h0 == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.h0.thread_id);
        statisticItem.param("nid", this.h0.nid);
        statisticItem.param("fid", this.h0.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.B0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", li.isEmpty(this.h0.mRecomWeight) ? "0" : this.h0.mRecomWeight);
        statisticItem.param("extra", li.isEmpty(this.h0.mRecomExtra) ? "0" : this.h0.mRecomExtra);
        statisticItem.param("obj_id", this.O0);
        statisticItem.param("ab_tag", li.isEmpty(this.h0.mRecomAbTag) ? "0" : this.h0.mRecomAbTag);
        statisticItem.param("obj_source", li.isEmpty(this.h0.mRecomSource) ? "0" : this.h0.mRecomSource);
        statisticItem.param("obj_type", this.D0);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.h0.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.h0.baijiahaoData.oriUgcVid);
            int i2 = this.h0.baijiahaoData.oriUgcType;
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
            statisticItem2.param("tid", this.h0.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.D0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.E0);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void S3(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048612, this, i2) == null) || (relativeLayout = this.h) == null) {
            return;
        }
        relativeLayout.setPadding(0, 0, 0, i2);
    }

    public void T2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048613, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.h0.thread_id);
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

    public void T3(fv8 fv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, fv8Var) == null) {
            this.U0 = fv8Var;
        }
    }

    public String U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void U3(g1 g1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, g1Var) == null) {
            this.X0 = g1Var;
        }
    }

    public final int V2() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            int i3 = mi.i(this.f.getContext());
            if (v3()) {
                i2 = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            } else {
                i3 -= UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                i2 = VideoMiddleNiaiControllerView.u;
            }
            return i3 - i2;
        }
        return invokeV.intValue;
    }

    public void V3(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            P2();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                i2 = z2 ? R.string.obfuscated_res_0x7f0f0b21 : R.string.obfuscated_res_0x7f0f0b23;
                i3 = R.string.obfuscated_res_0x7f0f0b22;
                i4 = R.string.obfuscated_res_0x7f0f1175;
            } else {
                i2 = R.string.obfuscated_res_0x7f0f0496;
                i3 = R.string.obfuscated_res_0x7f0f0497;
                i4 = R.string.obfuscated_res_0x7f0f049d;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f0374, TBAlertConfig.OperateBtnStyle.SECONDARY);
            bs4 bs4Var = new bs4(TbadkCoreApplication.getInst().getCurrentActivity());
            bs4Var.v(i2);
            bs4Var.l(i3);
            bs4Var.n(true);
            bs4Var.r(aVar2, aVar);
            bs4Var.i(false);
            this.a1 = bs4Var.y();
            aVar.a(new v0(this, z2, z3));
            aVar2.a(new w0(this));
        }
    }

    @Override // com.repackage.kv8
    public VideoItemModel W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.i0 : (VideoItemModel) invokeV.objValue;
    }

    public final RelativeLayout.LayoutParams W2() {
        InterceptResult invokeV;
        RelativeLayout.LayoutParams layoutParams;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            int V2 = V2();
            int k2 = mi.k(this.f.getContext());
            if (UtilHelper.getRealScreenOrientation(this.f.getContext()) == 2) {
                layoutParams = new RelativeLayout.LayoutParams(V2, k2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(k2, V2);
            }
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && (videoItemData = this.h0) != null) {
                int e2 = kg.e(videoItemData.video_height, 0);
                int e3 = kg.e(this.h0.video_width, 0);
                if (e2 > 0 && e3 > 0 && V2 > 0 && k2 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(k2, V2);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.M0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.M0.addRule(14);
                        this.M0.topMargin = (V2 - mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                    } else {
                        float f3 = f2 * k2;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(k2, (int) f3);
                        layoutParams3.topMargin = ((int) (V2 - f3)) / 2;
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.M0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.M0.addRule(14);
                        this.M0.topMargin = (V2 - mi.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                        layoutParams = layoutParams3;
                    }
                    this.B.requestLayout();
                }
            }
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    public void W3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || this.F0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.F0.m();
    }

    public List<String> X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void X3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048623, this) == null) && ki.x()) {
            xr8.c().f(getContext());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
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

    public boolean Y3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (TiebaPlusConfigData.isHeatingSwitchOpen()) {
                int i2 = this.a;
                return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final ObjectAnimator Z2(float f2, float f3, float f4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.B, PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f3), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f4));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void Z3() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (this.F0 == null) {
                this.G0 = new yr4(getActivity());
                this.F0 = new wr4(getPageContext(), this.G0);
                ArrayList arrayList = new ArrayList();
                ur4 ur4Var = new ur4(getString(R.string.obfuscated_res_0x7f0f0a87), this.G0);
                boolean z2 = false;
                VideoItemData videoItemData = this.h0;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    ur4Var.n(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f9c));
                } else {
                    ur4Var.n(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a87));
                }
                ur4Var.m(this.U1);
                VideoItemData videoItemData2 = this.h0;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(ur4Var);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.h0.thread_id);
                    statisticItem.param("fid", this.h0.forum_id);
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
                    statisticItem.param("obj_source", Y2());
                    TiebaStatic.log(statisticItem);
                }
                if (u3()) {
                    ur4 ur4Var2 = new ur4(getString(R.string.obfuscated_res_0x7f0f0c8f), this.G0);
                    ur4Var2.m(this.T1);
                    arrayList.add(ur4Var2);
                }
                if (!k3()) {
                    ur4 ur4Var3 = new ur4(getString(R.string.obfuscated_res_0x7f0f0fc0), this.G0);
                    ur4Var3.m(this.V1);
                    arrayList.add(ur4Var3);
                }
                if (this.A0) {
                    ur4 ur4Var4 = new ur4(getString(R.string.obfuscated_res_0x7f0f049d), this.G0);
                    ur4Var4.m(this.W1);
                    arrayList.add(ur4Var4);
                }
                this.G0.m(new e0(this));
                this.F0.setOnDismissListener(new f0(this));
                this.G0.j(arrayList);
            }
            W3();
        }
    }

    public final void a3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            b3(null, false);
        }
    }

    public final boolean a4() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            if (xr8.c().d() || TbadkCoreApplication.getInst().getAutoPlaySwitch() == 2 || !((i2 = this.a) == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick() || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.a;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && ki.x() && isResumed() && this.l0) {
                mi.O(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1512), 3000);
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

    public final void b3(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048630, this, str, z2) == null) || this.h0 == null) {
            return;
        }
        PbCommentFloatActivityConfig pbCommentFloatActivityConfig = new PbCommentFloatActivityConfig(getActivity());
        VideoItemData videoItemData = this.h0;
        PbCommentFloatActivityConfig createNormalCfg = pbCommentFloatActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.h0.forum_id));
        createNormalCfg.setForumName(this.h0.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.h0.baijiahaoData);
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
        if (this.h0.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            if (this.h0.threadData.getAuthor() != null) {
                VideoItemData videoItemData2 = this.h0;
                if (videoItemData2.author_info != null) {
                    videoItemData2.threadData.getAuthor().setIsLike("1".equals(this.h0.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            qc6.update(this.h0.threadData);
        }
        GoPbCommentFloatListener.l();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.Q0 = true;
        VideoDanmuController videoDanmuController = this.j;
        if (videoDanmuController != null) {
            videoDanmuController.R();
            this.j.H();
        }
        j4();
        this.Y0.X(!this.Q0);
        b4();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
    }

    public void b4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM);
            statisticItem.param("tid", this.h0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.h0.forum_id);
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

    public final void c3() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (tBLottieAnimationView = this.r) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || s3()) {
            return;
        }
        nu8 nu8Var = this.V0;
        if (nu8Var != null && nu8Var.a() != null) {
            this.V0.a().j();
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null) {
                this.V0.v(videoItemData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.TRUE));
        }
        int i2 = this.a;
        if (i2 == 4 || i2 == 3) {
            S3(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        F2();
    }

    public final void d3(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            int f2 = mi.f(getContext(), R.dimen.tbds26);
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

    public final void d4() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        ThreadData threadData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048635, this) == null) || (videoItemData = this.h0) == null) {
            return;
        }
        String str3 = videoItemData.forum_id;
        String str4 = videoItemData.forum_name;
        String str5 = videoItemData.title;
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.h0.baijiahaoData.oriUgcType + "&dvid=" + this.h0.baijiahaoData.oriUgcVid + "&nid=" + this.h0.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData.thread_id;
            str2 = "?share=9105&fr=sharewise";
        }
        String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str7 = this.h0.thumbnail_url;
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1131);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0489);
        VideoItemData videoItemData3 = this.h0;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f048a));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.t = str5;
        shareItem.u = format;
        if (this.h0.baijiahaoData == null) {
            shareItem.T = videoItemData2.play_count;
        }
        if (this.h0.isBjhVideo) {
            shareItem.F = format;
        } else {
            shareItem.F = "";
        }
        shareItem.v = str6;
        shareItem.q = 2;
        shareItem.s = str;
        shareItem.H = 3;
        shareItem.L = str3;
        shareItem.r = str4;
        shareItem.M = str;
        VideoItemData videoItemData4 = this.h0;
        shareItem.a0 = videoItemData4.post_id;
        shareItem.f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.b0 = userItemData2.portrait;
            shareItem.c0 = userItemData2.user_name;
            shareItem.d0 = userItemData2.getUserShowName();
        }
        int i2 = this.a;
        if (i2 == 3) {
            shareItem.G = 25;
            shareItem.K = 19;
        } else if (i2 == 4) {
            shareItem.G = 29;
            shareItem.K = 20;
        } else {
            shareItem.G = 12;
            shareItem.K = 18;
        }
        if (this.h0.getVideoType() == 1) {
            shareItem.O = 2;
        } else if (this.h0.getVideoType() == 2) {
            shareItem.O = 8;
        } else if (this.h0.getVideoType() == 3) {
            shareItem.O = 6;
        }
        if (parse != null) {
            shareItem.x = parse;
        }
        if (this.h0.isBjhVideo) {
            shareItem.q0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData5 = this.h0;
        originalThreadInfo.c = videoItemData5.thumbnail_url;
        originalThreadInfo.a = 3;
        originalThreadInfo.b = videoItemData5.title;
        originalThreadInfo.f = videoItemData5.thread_id;
        originalThreadInfo.p = videoItemData5.baijiahaoData;
        OriginalThreadInfo.ShareInfo generateShareInfo = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        shareItem.V = generateShareInfo;
        VideoItemData videoItemData6 = this.h0;
        ThreadData threadData2 = videoItemData6.threadData;
        generateShareInfo.threadData = threadData2;
        if (videoItemData6.author_info != null) {
            threadData2.getAuthor().setUserName(this.h0.author_info.user_name);
            shareItem.V.threadData.getAuthor().setName_show(this.h0.author_info.name_show);
            shareItem.V.threadData.getAuthor().setPortrait(this.h0.author_info.portrait);
            shareItem.V.threadData.getAuthor().setUserId(this.h0.author_info.user_id);
        }
        D2(shareItem);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.H);
        bundle.putInt("obj_type", shareItem.O);
        bundle.putString("fid", shareItem.L);
        bundle.putString("tid", shareItem.M);
        bundle.putInt("obj_source", shareItem.q);
        shareItem.k(bundle);
        if (this.h0.isWorksInfo()) {
            shareItem.I = 11;
        }
        if (UbsABTestHelper.isShareH5CardOptimizeABTestA() && (threadData = this.h0.threadData) != null) {
            int k2 = fz4.k(threadData);
            UserItemData userItemData3 = this.h0.author_info;
            String str8 = userItemData3 != null ? userItemData3.name_show : "";
            shareItem.C0 = fz4.j(this.h0.threadData, k2);
            VideoItemData videoItemData7 = this.h0;
            shareItem.D0 = fz4.i(videoItemData7.threadData, k2, videoItemData7.forum_name, shareItem.T, str8, "");
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = u3();
        shareDialogConfig.disLikeListener = this.S1;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.D0);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = k3();
        VideoItemData videoItemData8 = this.h0;
        shareDialogConfig.isManager = videoItemData8.is_manager;
        shareDialogConfig.isOriginManager = videoItemData8.is_origin_manager;
        shareDialogConfig.showHeating = Y3();
        shareDialogConfig.isSelfHeating = this.A0;
        shareDialogConfig.heatingListener = this.R1;
        ThreadData threadData3 = this.h0.threadData;
        if (threadData3 != null) {
            shareDialogConfig.isCollected = threadData3.getIsMarked() == 1;
            shareDialogConfig.isMadeTop = this.h0.threadData.isMadeTop();
            shareDialogConfig.isAddedGood = this.h0.threadData.isAddedGood();
        }
        pz5.c().l(shareDialogConfig);
    }

    public void e3() {
        wr4 wr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && (wr4Var = this.F0) != null && wr4Var.isShowing()) {
            this.F0.dismiss();
        }
    }

    public final void e4(boolean z2) {
        bu8 bu8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z2) == null) || (bu8Var = this.Z0) == null) {
            return;
        }
        bu8Var.c(o3());
        this.Z0.d(getPageContext(), this.h0, z2);
    }

    public final void f3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048638, this) == null) && s3()) {
            this.V0.a().o();
            N2(((pu8) this.V0.a().n(28)).f().getText().toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
            int i2 = this.a;
            if (i2 == 4 || i2 == 3) {
                S3(0);
            }
            F2();
        }
    }

    public final void f4(View view2, View view3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{view2, view3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), animatorListenerAdapter}) == null) {
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

    public final void g3(View view2, View view3, View view4, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{view2, view3, view4, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), animatorListenerAdapter}) == null) {
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

    public final void g4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || this.h0 == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
        statisticItem.param("tid", this.h0.thread_id);
        statisticItem.param("fid", this.h0.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        int i2 = this.a;
        if (i2 != 3 && i2 != 4) {
            statisticItem.param("obj_type", 2);
        } else {
            statisticItem.param("obj_type", 1);
        }
        statisticItem.param("obj_type", Y2());
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

    public final void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                nu8 nu8Var = (nu8) new ou8().g(getActivity(), new y(this));
                this.V0 = nu8Var;
                if (nu8Var != null && this.h0 != null) {
                    nu8Var.r(getPageContext());
                    String b2 = TextUtils.isEmpty(this.h0.thread_id) ? "" : DanmuPostDraftManager.b.a().b(this.h0.thread_id);
                    this.V0.s(this.h0.thread_id, this.h0.forum_id, this.h0.forum_name, b2);
                    N2(b2);
                    this.V0.t(new z(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.f).addView(this.V0.a(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void h4(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048643, this, str, z2) == null) {
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

    public boolean i3() {
        InterceptResult invokeV;
        ThreadData threadData;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            VideoItemData videoItemData = this.h0;
            if (videoItemData == null || (threadData = videoItemData.threadData) == null) {
                return false;
            }
            if (videoItemData.mRichAbstractList == null && threadData.getRichAbstractList() == null) {
                return false;
            }
            this.F = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091ad7);
            this.G = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092033);
            this.H = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092031);
            this.E = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091a58);
            gs4 d2 = gs4.d(this.H);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            fs4 fs4Var = (fs4) this.H.getBackground();
            fs4Var.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.H.setBackground(fs4Var);
            gs4 d3 = gs4.d(this.F);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            List<PbContent> r2 = TiePlusHelper.r(this.h0.mRichAbstractList) != null ? TiePlusHelper.r(this.h0.mRichAbstractList) : null;
            if (TiePlusHelper.r(this.h0.threadData.getRichAbstractList()) != null) {
                r2 = TiePlusHelper.r(this.h0.threadData.getRichAbstractList());
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(r2, 0);
            if (pbContent == null || (tiebaPlusInfo = pbContent.tiebaplus_info) == null) {
                return false;
            }
            Integer num = pbContent.type;
            Integer num2 = tiebaPlusInfo.jump_type;
            gg5 c2 = gg5.c(num.intValue(), tiebaPlusInfo, this.h0.threadData);
            this.f1 = c2;
            c2.b(this.h0.threadData.statFloor);
            if (num2.intValue() != 3 && num2.intValue() != 7) {
                if (num2.intValue() == 2) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807c4));
                } else if (num2.intValue() == 6) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807f4));
                } else if (num2.intValue() == 5) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807f2));
                } else {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807ef));
                }
            } else {
                this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f08082f));
            }
            this.F.setText(tiebaPlusInfo.desc);
            this.H.setVisibility(0);
            this.E.setVisibility(8);
            this.H.setOnClickListener(new o0(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean i4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (s3()) {
                f3();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.a == 6 : invokeV.booleanValue;
    }

    public final void j4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.N0 = this.i.getControl().getVideoStatus();
            } else {
                this.N0 = OnStatusChangedListener.VideoStatus.INIT;
            }
        }
    }

    @Override // com.repackage.kv8
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.T0 : invokeV.intValue;
    }

    public final boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.A0 : invokeV.booleanValue;
    }

    public final boolean l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.a == 8 : invokeV.booleanValue;
    }

    public void m0(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048651, this, i2, i3, intent) == null) {
            nu8 nu8Var = this.V0;
            if (nu8Var != null) {
                nu8Var.m(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                m98.g().m(getPageContext());
                ShareItem shareItem = TbadkCoreApplication.getInst().getShareItem();
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_SUCCESS);
                if (shareItem != null) {
                    statisticItem.param("tid", shareItem.M);
                    statisticItem.param("uid", shareItem.P);
                    statisticItem.param("fid", shareItem.L);
                    statisticItem.param("obj_type", intExtra2);
                    statisticItem.param("obj_locate", shareItem.K);
                }
                TiebaStatic.log(statisticItem);
                if (this.a == 7) {
                    StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SHARE_SUCCESS);
                    if (shareItem != null) {
                        statisticItem2.param("tid", shareItem.M);
                        statisticItem2.param("uid", shareItem.P);
                        statisticItem2.param("fid", shareItem.L);
                        statisticItem2.param("obj_type", intExtra2);
                        statisticItem2.param("obj_param1", 7);
                    }
                    TiebaStatic.log(statisticItem2);
                }
            }
        }
    }

    public final boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            int i2 = this.a;
            return (i2 == 3 || i2 == 4) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.a == 1 && this.T0 == 0) {
                return false;
            }
            return (this.a == 7 && getActivity() != null && (getActivity() instanceof FrsVideoTabPlayActivity) && this.T0 == ((FrsVideoTabPlayActivity) getActivity()).getVideoIndex()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            int i2 = this.a;
            return i2 == 1 || i2 == 2 || TbSingleton.getInstance().isFromFeedVideoClick();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.H0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(new b0(this));
            xl4 c2 = xl4.c(getBaseFragmentActivity());
            this.I0 = c2;
            if (c2 != null) {
                c2.j(new c0(this));
            }
            this.J0 = new py4(null);
            registerListener(this.q1);
            registerListener(this.r1);
            registerListener(this.t1);
            registerListener(this.u1);
            registerListener(this.v1);
            registerListener(this.w1);
            registerListener(this.p1);
            registerListener(this.x1);
            registerListener(this.z1);
            if (TbSingleton.getInstance().getIsNeedShowPbCommentFloat() || AbsVideoChannelFragment.F) {
                b3(this.h0.highLightPostId, false);
                TbSingleton.getInstance().setIsNeedShowPbCommentFloat(false);
                AbsVideoChannelFragment.F = false;
            }
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.R0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048656, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            m0(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048657, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.V0 != null && this.V0.a() != null) {
                    this.V0.a().w(i2);
                }
                if (this.G0 != null) {
                    this.G0.i();
                }
                if (this.f != null) {
                    this.q0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082a, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.r0.setImageDrawable(WebPManager.getMaskDrawable(r3() ? R.drawable.obfuscated_res_0x7f080829 : R.drawable.obfuscated_res_0x7f08082b, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.A.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a42, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.B.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a00, WebPManager.ResourceStateType.NORMAL));
                    this.D.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f080926, di8.a(SkinManager.getColor(R.color.CAM_X0213), 0.2f), null));
                    G2();
                    gs4 d2 = gs4.d(this.t0);
                    d2.n(R.string.J_X05);
                    d2.f(R.color.CAM_X0613);
                    gs4 d3 = gs4.d(this.T);
                    d3.A(R.string.F_X02);
                    d3.v(R.color.CAM_X0101);
                    gs4.d(this.U).A(R.string.F_X02);
                    gs4 d4 = gs4.d(this.S);
                    d4.z(R.dimen.T_X09);
                    d4.A(R.string.F_X02);
                    d4.y(R.array.S_O_X001);
                    gs4 d5 = gs4.d(this.R);
                    d5.z(R.dimen.T_X09);
                    d5.A(R.string.F_X02);
                    d5.y(R.array.S_O_X001);
                    gs4 d6 = gs4.d(this.Q);
                    d6.z(R.dimen.T_X09);
                    d6.A(R.string.F_X02);
                    d6.y(R.array.S_O_X001);
                    gs4 d7 = gs4.d(this.s0);
                    d7.z(R.dimen.T_X06);
                    d7.A(R.string.F_X02);
                    d7.y(R.array.S_O_X001);
                    gs4 d8 = gs4.d(this.V);
                    d8.n(R.string.J_X01);
                    d8.z(R.dimen.T_X09);
                    d8.v(R.color.CAM_X0101);
                    d8.A(R.string.F_X02);
                    d8.f(R.color.CAM_X0302);
                    this.U.setTextColor(di8.a(SkinManager.getColor(R.color.CAM_X0101), es4.a(R.string.A_X08)));
                    this.R.setTextColor(di8.a(SkinManager.getColor(R.color.CAM_X0101), es4.a(R.string.A_X03)));
                    this.S.setTextColor(di8.a(SkinManager.getColor(R.color.CAM_X0101), es4.a(R.string.A_X03)));
                    this.Q.setTextColor(di8.a(SkinManager.getColor(R.color.CAM_X0101), es4.a(R.string.A_X03)));
                }
                WebPManager.setPureDrawable(this.n, R.drawable.obfuscated_res_0x7f0809df, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f0809db, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                c3();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view2) {
        ku8 ku8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, view2) == null) {
            super.onClick(view2);
            if (view2.getId() != R.id.obfuscated_res_0x7f092393 || (ku8Var = this.k) == null) {
                return;
            }
            ku8Var.i();
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null) {
                this.k.e(videoItemData.thread_id, this.a);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.l0 && (videoItemData = this.h0) != null) {
                boolean z2 = kg.e(videoItemData.video_height, 0) <= kg.e(this.h0.video_width, 0);
                lv8 lv8Var = this.Y0;
                if (lv8Var == null || !z2) {
                    return;
                }
                if (!(lv8Var.isFullScreen() && configuration.orientation == 1) && (this.Y0.isFullScreen() || configuration.orientation != 2)) {
                    return;
                }
                this.h.removeView(this.i);
                this.Y0.V(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.s1);
            registerListener(this.Z1);
            registerListener(this.a2);
            this.Z0 = new bu8();
            getLifecycle().addObserver(this.y1);
            if (this.d1 == null) {
                this.d1 = new TiePlusEventController(getActivity(), TiePlusStat.Locate.VIDEO_MOUNT, getUniqueId());
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        TbVideoViewContainer tbVideoViewContainer;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048661, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
                this.i0 = videoItemModel;
                this.h0 = videoItemModel == null ? null : videoItemModel.getVideoItemData();
                this.n0 = (Rect) arguments.getParcelable("video_cover_rect");
                this.B0 = arguments.getInt("video_index");
                arguments.getString("page_from");
                this.D0 = arguments.getString("from");
                this.E0 = arguments.getString("video_channel_tab");
                this.O0 = arguments.getString("obj_id");
                this.c = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.a = arguments.getInt(VideoPlayActivityConfig.CURRENT_TYPE);
                this.b = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            }
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.h0.author_info.user_id)) {
                this.A0 = true;
            }
            if (m3() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0873, (ViewGroup) null);
            } else {
                this.f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d087a, (ViewGroup) null);
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && ((i2 = this.a) == 1 || i2 == 7)) {
                this.f.setBackground(null);
            } else {
                this.f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
            }
            this.g1 = true;
            VideoItemData videoItemData2 = this.h0;
            if (videoItemData2 != null && StringUtils.isNull(videoItemData2.video_url) && !StringUtils.isNull(this.h0.thread_id)) {
                VideoDanmuController videoDanmuController = new VideoDanmuController(getPageContext(), getUniqueId(), this.f, R.id.obfuscated_res_0x7f092356, this.h0, this.a);
                this.j = videoDanmuController;
                videoDanmuController.X(this.Q1);
                this.j.M();
            }
            this.f.setOnTouchListener(this.B1);
            this.f.setOnLongClickListener(this.C1);
            TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(getContext());
            this.i = tbVideoViewContainer2;
            tbVideoViewContainer2.getControl().setStageType("2005");
            this.i.getControl().getMediaProgressObserver().j(this.D1);
            TbImageView tbImageView = (TbImageView) this.f.findViewById(R.id.obfuscated_res_0x7f092354);
            this.l = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.B = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0918a9);
            this.C = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09237b);
            this.D = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09237a);
            this.l.setEvent(this.E1);
            this.h = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092397);
            O3();
            this.m = this.f.findViewById(R.id.obfuscated_res_0x7f0920ee);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.m.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0902f5);
            this.n = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09144d);
            this.o = imageView2;
            imageView2.setVisibility(8);
            this.p = this.f.findViewById(R.id.obfuscated_res_0x7f0918f1);
            LinearLayout linearLayout = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091a58);
            this.E = linearLayout;
            gs4 d2 = gs4.d(linearLayout);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            fs4 fs4Var = (fs4) this.E.getBackground();
            fs4Var.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.E.setBackground(fs4Var);
            this.I = (BarImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091a47);
            this.J = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091a34);
            this.I.setShowOval(true);
            TextView textView = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091a54);
            this.K = textView;
            gs4 d3 = gs4.d(textView);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            HeadImageView headImageView = (HeadImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0902dc);
            this.q = headImageView;
            headImageView.setDefaultResource(17170445);
            this.q.setPlaceHolder(2);
            this.q.setIsRound(true);
            this.q.setBorderWidth(R.dimen.L_X02);
            this.q.setBorderColor(R.color.CAM_X0622);
            this.q.setDrawBorder(true);
            this.q.setUseNightOrDarkMask(false);
            M3();
            this.r = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0922f1);
            this.s = (TBLottieAnimationView) this.f.findViewById(R.id.obfuscated_res_0x7f0902c4);
            this.X = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0902da);
            this.u = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0903bf);
            this.V = (TBSpecificationBtn) this.f.findViewById(R.id.obfuscated_res_0x7f091356);
            xu4 xu4Var = new xu4();
            UtilHelper.addFollowUserIconStyle(xu4Var);
            xu4Var.h(R.color.CAM_X0101);
            xu4Var.m(0, 0);
            xu4Var.n(0);
            xu4Var.k(true);
            xu4Var.j(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds145), mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60));
            this.V.setConfig(xu4Var);
            this.V.setText(getString(R.string.obfuscated_res_0x7f0f02a2));
            this.p0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090150);
            this.L = (ExpandableTextView) this.f.findViewById(R.id.obfuscated_res_0x7f0923c3);
            this.M = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092086);
            this.N = this.f.findViewById(R.id.obfuscated_res_0x7f092085);
            this.O = this.f.findViewById(R.id.obfuscated_res_0x7f092096);
            this.P = this.f.findViewById(R.id.obfuscated_res_0x7f0923c6);
            this.k0 = (VideoMiddleNiaiControllerView) this.f.findViewById(R.id.obfuscated_res_0x7f0913ce);
            this.W = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092337);
            this.y = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090686);
            this.Q = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090692);
            this.q0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f090690);
            this.x = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09014f);
            this.v = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0912f6);
            this.w = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091cf3);
            this.b1 = (RelativeLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09234a);
            this.h1 = this.f.findViewById(R.id.obfuscated_res_0x7f0923c7);
            this.i1 = this.f.findViewById(R.id.obfuscated_res_0x7f09234c);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !n3() && this.n0 != null) {
                I3(8);
                TbImageView tbImageView2 = this.l;
                if (tbImageView2 != null) {
                    tbImageView2.setVisibility(8);
                }
            } else {
                I3(0);
            }
            F2();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            int i3 = this.a;
            if (i3 != 4 && i3 != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.k0.q(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                if (m3() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds145);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds158);
                } else {
                    layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                    layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
                }
            } else {
                this.k0.q(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            }
            this.R = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090158);
            this.r0 = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091cfc);
            this.S = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f091d0a);
            this.T = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090832);
            this.U = (EMTextView) this.f.findViewById(R.id.obfuscated_res_0x7f090834);
            this.z = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091cfc);
            this.A = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091cfd);
            D3();
            this.Y = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092336);
            this.Z = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f092339);
            this.g0 = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f09239b);
            this.s0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f092347);
            this.t0 = this.f.findViewById(R.id.obfuscated_res_0x7f0919e8);
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.t0.setVisibility(0);
            } else {
                this.t0.setVisibility(8);
            }
            this.t0.setOnClickListener(this.H1);
            if (this.h0 != null) {
                this.k0.setVisibility(0);
            }
            this.k0.setPlayer(this.i.getControl());
            this.k0.setOnSeekBarChangeListener(this.F1);
            this.u0 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0919e9);
            TextView textView2 = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f090825);
            this.j0 = textView2;
            textView2.setVisibility(8);
            String q2 = iu4.k().q("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(q2)) {
                this.j0.setText(q2);
            }
            this.j0.setOnClickListener(this.H1);
            L2();
            this.p.setOnClickListener(this.G1);
            this.s0.setOnClickListener(this.G1);
            this.Z.setOnClickListener(this.H1);
            this.L.setHasDown();
            this.L.setOnClickListener(this.H1);
            this.n.setOnClickListener(this.H1);
            this.o.setOnClickListener(this.H1);
            this.y.setOnClickListener(this.H1);
            this.x.setOnClickListener(this.I1);
            this.w.setOnClickListener(this.J1);
            this.V.setOnClickListener(this.K1);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.m0 = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.m0.setAnimationListener(this.L1);
            this.C.setVisibility(0);
            if (this.l0) {
                this.k0.setLoading(true);
            }
            if (this.n0 != null && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getParent() != null) {
                Rect rect = this.n0;
                int i4 = rect.right;
                int i5 = rect.left;
                this.w0 = i4 - i5;
                int i6 = rect.bottom;
                int i7 = rect.top;
                this.x0 = i6 - i7;
                this.y0 = i5;
                this.z0 = i7;
                if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    this.i.post(this.N1);
                } else {
                    this.i.post(this.M1);
                }
            } else if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                RelativeLayout relativeLayout = this.b1;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                    this.b1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
            }
            h3();
            if (this.l0) {
                S2();
            }
            VideoItemData videoItemData3 = this.h0;
            if (videoItemData3 != null && (!StringUtils.isNull(videoItemData3.video_url) || !StringUtils.isNull(this.h0.thread_id))) {
                R3(this.h0.video_url);
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    VideoDanmuController videoDanmuController2 = new VideoDanmuController(getPageContext(), getUniqueId(), this.f, R.id.obfuscated_res_0x7f092356, this.h0, this.a);
                    this.j = videoDanmuController2;
                    videoDanmuController2.P(this.A1);
                }
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                ku8 ku8Var = new ku8(this.f, R.id.obfuscated_res_0x7f092393);
                this.k = ku8Var;
                ku8Var.g(this);
                this.k.h(this.O1);
            }
            lv8 lv8Var = new lv8(getPageContext(), getUniqueId(), this.h, this.a);
            this.Y0 = lv8Var;
            lv8Var.setStageType("2005");
            this.Y0.setUniqueId(getUniqueId());
            VideoItemData videoItemData4 = this.h0;
            if (videoItemData4 != null && videoItemData4.threadData == null) {
                videoItemData4.threadData = new ThreadData();
                VideoItemData videoItemData5 = this.h0;
                ThreadData threadData = videoItemData5.threadData;
                threadData.tid = videoItemData5.thread_id;
                threadData.threadType = 40;
                threadData.setReply_num(kg.e(videoItemData5.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(kg.e(this.h0.video_width, 0));
                builder.video_height = Integer.valueOf(kg.e(this.h0.video_height, 0));
                VideoItemData videoItemData6 = this.h0;
                builder.video_url = videoItemData6.video_url;
                builder.thumbnail_url = videoItemData6.thumbnail_url;
                builder.video_md5 = videoItemData6.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData6.isVerticalVideo);
                this.h0.threadData.setVideoInfo(builder.build(true));
            }
            VideoItemData videoItemData7 = this.h0;
            if (videoItemData7 != null) {
                Q3(videoItemData7, this.Y0, this.j);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                    ng.a().post(this.n1);
                } else if (this.T0 != 0) {
                    ng.a().post(this.n1);
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
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            if (!this.j1) {
                stopPlay();
            }
            if (!getActivity().isFinishing() && (tbVideoViewContainer = this.i) != null && (tbVideoViewContainer.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof g78)) {
                ((g78) this.i.getControl().getPlayer()).release();
            }
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.s1);
            MessageManager.getInstance().unRegisterListener(this.Z1);
            MessageManager.getInstance().unRegisterListener(this.a2);
            if (this.X1 != null) {
                ng.a().removeCallbacks(this.X1);
                this.X1 = null;
            }
            bu8 bu8Var = this.Z0;
            if (bu8Var != null) {
                bu8Var.b();
            }
            ng.a().removeCallbacks(this.n1);
            getLifecycle().removeObserver(this.y1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            super.onDestroyView();
            VideoDanmuController videoDanmuController = this.j;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            ku8 ku8Var = this.k;
            if (ku8Var != null) {
                ku8Var.f();
            }
            lv8 lv8Var = this.Y0;
            if (lv8Var != null) {
                lv8Var.F0();
            }
            nu8 nu8Var = this.V0;
            if (nu8Var != null) {
                nu8Var.n();
            }
            VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.k0;
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
            ng.a().removeCallbacks(this.n1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            super.onPause();
            if (!this.Q0) {
                y3();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !n3() && getActivity().isFinishing()) {
                O2();
                this.j1 = true;
            }
            f3();
            TiePlusEventController tiePlusEventController = this.d1;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            super.onPrimary();
            if (isResumed() && this.l0) {
                VideoItemData videoItemData = this.h0;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.l0) {
                        C3();
                        E3();
                        B3(0);
                    } else {
                        y3();
                    }
                }
                VideoItemData videoItemData2 = this.h0;
                if (videoItemData2 == null || (alaInfoData = videoItemData2.mAlaInfoData) == null || !alaInfoData.isLegalYYLiveData() || this.h0.mAlaInfoData.live_status != 1) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("tid", this.h0.getThreadId());
                UserItemData userItemData = this.h0.author_info;
                if (userItemData != null) {
                    statisticItem.addParam("obj_id", userItemData.user_id);
                    statisticItem.addParam("obj_name", this.h0.author_info.user_name);
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            y3();
            f3();
            this.g1 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            super.onResume();
            if (this.c1) {
                this.c1 = false;
                ng.a().removeCallbacks(this.n1);
                B3(1);
                startPlay();
                S2();
                this.R0 = false;
            }
            TiePlusEventController tiePlusEventController = this.d1;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            super.onStart();
            if (this.Q0) {
                E3();
            }
        }
    }

    @Override // com.baidu.tieba.play.OnStatusChangedListener
    public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, videoStatus) == null) {
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PREPARED) {
                N3();
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.C;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2 = this.k0;
                if (videoMiddleNiaiControllerView2 != null) {
                    videoMiddleNiaiControllerView2.setLoading(false);
                }
                g1 g1Var = this.X0;
                if (g1Var != null) {
                    g1Var.onStart();
                }
                TbImageView tbImageView = this.l;
                if (tbImageView != null) {
                    if (tbImageView.getVisibility() == 0) {
                        this.l.clearAnimation();
                        this.l.startAnimation(this.m0);
                    }
                    this.l.setVisibility(8);
                }
                if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    I3(0);
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
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView = this.k0) != null) {
                videoMiddleNiaiControllerView.setLoading(false);
            }
            if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING && this.k0 != null && this.l0 && isResumed()) {
                this.k0.setLoading(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            super.onStop();
            y3();
            f3();
            ng.a().removeCallbacks(this.n1);
        }
    }

    @Override // com.repackage.gh5.b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048670, this) == null) {
            if (s3()) {
                f3();
                return;
            }
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.i.getControl().l()) {
                return;
            }
            if (this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING && this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                if (this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PAUSING || a4()) {
                    return;
                }
                this.i.getControl().start();
                this.B.setVisibility(8);
                J2(true);
                this.k0.p();
                if (isResumed() && this.l0) {
                    return;
                }
                y3();
                return;
            }
            this.i.getControl().pause();
            K3();
            J2(false);
            ng.a().removeCallbacks(this.X1);
            T2(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048671, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            L2();
            P3();
        }
    }

    @Override // com.repackage.gh5.b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048672, this) == null) || q3() || s3() || (videoItemData = this.h0) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long g2 = kg.g(userItemData.user_id, 0L);
        long g3 = kg.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        int i2 = 1;
        boolean z2 = (g2 == 0 && g3 == 0) ? false : g2 == g3;
        lu8.a();
        String str = this.h0.author_info.portrait;
        PersonPolymericActivityConfig personPolymericActivityConfig = new PersonPolymericActivityConfig(getActivity());
        int i3 = this.a;
        PersonPolymericActivityConfig createNormalConfig = personPolymericActivityConfig.createNormalConfig(g2, z2, false, true, (i3 == 3 || i3 == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
        createNormalConfig.setPortrait(str);
        createNormalConfig.setSourceTid(this.h0.thread_id);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_DRAG_TO_PERSONAL_CENTER);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", this.h0.thread_id);
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

    public final boolean p3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048673, this, i2)) == null) {
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

    public final boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? j3() && !this.b : invokeV.booleanValue;
    }

    public final boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? q3() && k3() : invokeV.booleanValue;
    }

    public final boolean s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            nu8 nu8Var = this.V0;
            return (nu8Var == null || nu8Var.a() == null || !this.V0.a().v()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        gg5 gg5Var;
        TbVideoViewContainer tbVideoViewContainer;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048677, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.l0 = z2;
            if (this.Y0 != null && (videoItemData = this.h0) != null) {
                this.Y0.X(this.l0 && (kg.e(videoItemData.video_height, 0) <= kg.e(this.h0.video_width, 0)));
            }
            if (!isResumed() && this.l0 && w3()) {
                this.c1 = true;
            }
            if (isResumed() && this.l0 && (!this.R0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                B3(1);
                startPlay();
                if (this.n0 == null) {
                    S2();
                }
                this.R0 = false;
            } else if (!this.Q0) {
                D3();
                this.S0 = 1;
                y3();
                i4();
            }
            if (this.k0 != null) {
                if (this.l0 && isResumed() && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null && this.i.getControl().getVideoStatus() != OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.k0.setLoading(true);
                } else {
                    this.k0.setLoading(false);
                }
            }
            if (!this.l0 || this.e1 || (gg5Var = this.f1) == null || this.d1 == null) {
                return;
            }
            gg5Var.q(TiePlusStat.StatType.EXPOSE);
            this.d1.o(this.f1);
            this.e1 = true;
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048678, this) == null) || a4()) {
            return;
        }
        X3();
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.h0 != null && this.i.getParent() == null) {
            O3();
            P3();
        }
        if (Build.VERSION.SDK_INT < 17 && this.l.getVisibility() == 0) {
            this.l.clearAnimation();
            this.l.startAnimation(this.m0);
        }
        TbVideoViewContainer tbVideoViewContainer2 = this.i;
        if (tbVideoViewContainer2 != null && tbVideoViewContainer2.getControl() != null && !TextUtils.isEmpty(this.L0) && this.h0 != null) {
            if (TbVideoViewSet.b().c(this.L0) == null || TbVideoViewSet.b().c(this.L0) != this.i) {
                this.i.getControl().setVideoPath(this.L0, this.h0.thread_id);
            }
            if (!UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                this.i.getControl().setIsVolume0(false);
            }
            this.i.getControl().p(this.o1);
            VideoDanmuController videoDanmuController = this.j;
            if (videoDanmuController != null) {
                videoDanmuController.a0();
            }
            this.k0.p();
            C3();
        }
        if (this.Q0) {
            return;
        }
        if ((isResumed() && this.l0) || w3()) {
            return;
        }
        y3();
        VideoDanmuController videoDanmuController2 = this.j;
        if (videoDanmuController2 != null) {
            videoDanmuController2.R();
        }
        if (this.B != null) {
            K3();
        }
    }

    public final void stopPlay() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048679, this) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.i.getControl().stopPlayback();
    }

    public final boolean t3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            if (UbsABTestHelper.isVideoTabAuthorABTest() && p3(1)) {
                return true;
            }
            if (UbsABTestHelper.isVideoMiddleAuthorABTest() && p3(2)) {
                return true;
            }
            return UbsABTestHelper.isVideoMiddleAndTabAuthorABTest() && p3(3);
        }
        return invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            if (s3()) {
                f3();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean u3() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            VideoItemData videoItemData = this.h0;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.a != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean v3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            int i2 = this.a;
            return i2 == 4 || i2 == 3;
        }
        return invokeV.booleanValue;
    }

    public final boolean w3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            OnStatusChangedListener.VideoStatus videoStatus = this.N0;
            return videoStatus == OnStatusChangedListener.VideoStatus.INIT || videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PREPARED || videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_BUFFERING || videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING;
        }
        return invokeV.booleanValue;
    }

    public final void x3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048685, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void y3() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.i.getControl().q();
    }

    public final void z3() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048687, this) == null) || (tBLottieAnimationView = this.s) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        SkinManager.setLottieAnimation(this.s, R.raw.obfuscated_res_0x7f11006b);
        if (this.s.isAnimating()) {
            return;
        }
        this.s.setSpeed(1.1f);
        this.s.playAnimation();
    }
}
