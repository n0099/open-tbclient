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
import c.a.o0.e1.r.b;
import c.a.o0.h.a;
import c.a.o0.r.t.a;
import c.a.o0.r.t.l;
import c.a.p0.c3.h;
import c.a.p0.p4.d.c;
import c.a.p0.p4.f.a;
import c.a.p0.p4.f.b;
import c.a.p0.p4.k.a;
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
import com.baidu.tieba.play.TbVideoView;
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
/* loaded from: classes6.dex */
public class VideoPlayFragment extends BaseFragment implements b.InterfaceC0807b, c.a.p0.p4.j.b.a, TbCyberVideoView.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public boolean A0;
    public final VideoDanmuController.b A1;
    public ImageView B;
    public int B0;
    public View.OnClickListener B1;
    public RelativeLayout C;
    public String C0;
    public View.OnClickListener C1;
    public ImageView D;
    public String D0;
    public l.d D1;
    public LinearLayout E;
    public String E0;
    public l.d E1;
    public TextView F;
    public c.a.o0.r.t.j F0;
    public l.d F1;
    public ImageView G;
    public c.a.o0.r.t.l G0;
    public l.d G1;
    public LinearLayout H;
    public ForumManageModel H0;
    public Runnable H1;
    public BarImageView I;
    public c.a.o0.h.a I0;
    public c.a.p0.c3.w.a I1;
    public ImageView J;
    public c.a.o0.s.e.a J0;
    public CustomMessageListener J1;
    public TextView K;
    public BdUniqueId K0;
    public CustomMessageListener K1;
    public ExpandableTextView L;
    public String L0;
    public TextView M;
    public RelativeLayout.LayoutParams M0;
    public View N;
    public TbCyberVideoView.VideoStatus N0;
    public View O;
    public String O0;
    public View P;
    public boolean P0;
    public EMTextView Q;
    public boolean Q0;
    public EMTextView R;
    public boolean R0;
    public EMTextView S;
    public int S0;
    public EMTextView T;
    public int T0;
    public EMTextView U;
    public c.a.p0.p4.i.a U0;
    public TBSpecificationBtn V;
    public c.a.p0.p4.f.a V0;
    public TextView W;
    public h.c W0;
    public View X;
    public m1 X0;
    public LinearLayout Y;
    public c.a.p0.p4.k.a Y0;
    public LinearLayout Z;
    public c.a.p0.p4.a Z0;
    public int a;
    public AlertDialog a1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36581b;
    public RelativeLayout b1;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f36582c;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public int f36583d;
    public TiePlusEventController d1;

    /* renamed from: e  reason: collision with root package name */
    public int f36584e;
    public boolean e1;

    /* renamed from: f  reason: collision with root package name */
    public View f36585f;
    public c.a.o0.e1.p.c f1;

    /* renamed from: g  reason: collision with root package name */
    public View f36586g;
    public LinearLayout g0;
    public boolean g1;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f36587h;
    public VideoItemData h0;
    public View h1;
    public TbVideoViewContainer i;
    public VideoItemModel i0;
    public View i1;
    public VideoDanmuController j;
    public TextView j0;
    public boolean j1;
    public c.a.p0.p4.d.c k;
    public VideoMiddleNiaiControllerView k0;
    public ObjectAnimator k1;
    public TbImageView l;
    public boolean l0;
    public ObjectAnimator l1;
    public View m;
    public AlphaAnimation m0;
    public c.a.p0.h4.a m1;
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

        public static void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                SimpleMessageListener.c(2001457, null);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.Q0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.f36582c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.a.Q0) {
                this.a.Q0 = false;
                this.a.j.Z();
                if (this.a.j != null && this.a.s3()) {
                    this.a.j.U();
                }
                this.a.Y0.W(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f36588b;

        /* loaded from: classes6.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a0 a;

            public a(a0 a0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {a0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = a0Var;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    super.onAnimationEnd(animator);
                    this.a.f36588b.f36585f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                    this.a.f36588b.b1.setBackground(null);
                    this.a.f36588b.b1.setVisibility(8);
                    this.a.f36588b.o0 = true;
                    if (this.a.f36588b.v0 != null) {
                        this.a.f36588b.v0.addRule(14);
                    }
                    this.a.f36588b.E3(0);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    this.a.f36588b.f36585f.setBackground(null);
                    super.onAnimationStart(animator);
                    this.a.f36588b.b1.setVisibility(0);
                    if (this.a.f36588b.l != null) {
                        this.a.f36588b.l.setVisibility(8);
                    }
                    this.a.f36588b.b1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                }
            }
        }

        public a0(VideoPlayFragment videoPlayFragment, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36588b = videoPlayFragment;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams S2 = this.f36588b.S2();
                VideoPlayFragment videoPlayFragment = this.f36588b;
                videoPlayFragment.c3(videoPlayFragment.i, this.f36588b.l, this.f36588b.b1, this.f36588b.y0, S2.leftMargin, this.f36588b.z0, S2.topMargin, this.f36588b.w0, S2.width, this.f36588b.x0, S2.height, this.f36588b.x0, this.a, this.f36588b.z0, 0, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a1 implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f36587h.removeView(this.a.i);
                this.a.Y0.T();
                VideoPlayFragment videoPlayFragment = this.a;
                VideoItemData videoItemData = videoPlayFragment.h0;
                if (videoItemData != null) {
                    videoPlayFragment.d4(videoItemData.thread_id, false);
                }
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
                        this.a.a.K2();
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
                    this.a.a.D3(1.0f);
                    this.a.a.u3();
                    this.a.a.f36585f.setBackground(null);
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
                int i = c.a.d.f.p.n.i(this.a.f36585f.getContext());
                if (this.a.isResumed() && this.a.l0) {
                    if (this.a.a != 1) {
                        if (this.a.a == 7 && (videoItemData = (videoPlayFragment = this.a).h0) != null && videoItemData.thread_id != null && videoPlayFragment.getActivity() != null && (this.a.getActivity() instanceof FrsVideoTabPlayActivity)) {
                            VideoPlayFragment videoPlayFragment2 = this.a;
                            if (c.a.d.f.p.m.isEquals(videoPlayFragment2.h0.thread_id, ((FrsVideoTabPlayActivity) videoPlayFragment2.getActivity()).getStartCardTid()) && ((FrsVideoTabPlayActivity) this.a.getActivity()).getStartCardRect() != null) {
                                VideoPlayFragment videoPlayFragment3 = this.a;
                                videoPlayFragment3.n0 = ((FrsVideoTabPlayActivity) videoPlayFragment3.getActivity()).getStartCardRect();
                            }
                        }
                    } else {
                        VideoPlayFragment videoPlayFragment4 = this.a;
                        VideoItemData videoItemData2 = videoPlayFragment4.h0;
                        if (videoItemData2 != null && videoItemData2.thread_id != null && videoPlayFragment4.getActivity() != null && (this.a.getActivity() instanceof VideoPlayActivity)) {
                            VideoPlayFragment videoPlayFragment5 = this.a;
                            if (c.a.d.f.p.m.isEquals(videoPlayFragment5.h0.thread_id, ((VideoPlayActivity) videoPlayFragment5.getActivity()).getStartCardTid()) && ((VideoPlayActivity) this.a.getActivity()).getStartCardRect() != null) {
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
                            videoPlayFragment11.c3(videoPlayFragment11.i, this.a.l, this.a.b1, this.a.v0.leftMargin, this.a.y0, this.a.v0.topMargin, this.a.z0, this.a.v0.width, this.a.w0, this.a.v0.height, this.a.x0, i, this.a.x0, 0, this.a.z0, new a(this));
                        }
                    } else if (this.a.getActivity() != null) {
                        this.a.getActivity().finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a extends AnimatorListenerAdapter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b0 a;

            public a(b0 b0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = b0Var;
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams S2 = this.a.S2();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.b4(videoPlayFragment.i, this.a.l, this.a.y0, S2.leftMargin, this.a.z0, S2.topMargin, this.a.w0, S2.width, this.a.x0, S2.height, new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b1 implements c.a.p0.c3.w.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public b1(VideoPlayFragment videoPlayFragment) {
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

        @Override // c.a.p0.c3.w.a
        public void changeRenderViewMode(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public int getCurrentPosition() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // c.a.p0.c3.w.a
        public View getMainView() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (View) invokeV.objValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isFullScreen() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean isPlaying() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public boolean onBackPress() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
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
            this.a.y3();
            VideoPlayFragment.r2(this.a);
            if (this.a.S0 == 3) {
                this.a.G2();
            }
            if (this.a.Q0) {
                return;
            }
            if (this.a.isResumed() && this.a.l0) {
                return;
            }
            this.a.u3();
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

        @Override // c.a.p0.c3.w.a
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

        @Override // c.a.p0.c3.w.a
        public boolean onVolumeUp() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.p0.c3.w.a
        public void setAfterClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setData(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, threadData) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setFrom(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setJumpToPbClickListener(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStageType(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setStatistic(c.a.p0.c3.u uVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, uVar) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void setUniqueId(BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, bdUniqueId) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void startPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            }
        }

        @Override // c.a.p0.c3.w.a
        public void stopPlay() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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
            ThreadData threadData = this.a.h0.threadData;
            if (threadData != null && aVar.d()) {
                int i = h1.a[aVar.c().ordinal()];
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

        @Override // c.a.p0.p4.d.c.b
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
    public class c1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f36589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f36590c;

        public c1(VideoPlayFragment videoPlayFragment, boolean z, boolean z2) {
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
            this.f36590c = videoPlayFragment;
            this.a = z;
            this.f36589b = z2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f36590c.a1 != null) {
                    this.f36590c.a1.dismiss();
                }
                if (c.a.d.f.p.l.A()) {
                    ForumManageModel forumManageModel = this.f36590c.H0;
                    VideoItemData videoItemData = this.f36590c.h0;
                    forumManageModel.U(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, this.a, null, this.f36589b);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    return;
                }
                c.a.d.f.p.n.M(this.f36590c.getContext(), R.string.obfuscated_res_0x7f0f0c15);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.l0 && (customResponsedMessage.getData() instanceof Boolean)) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                boolean p = ((c.a.p0.p4.f.c) this.a.V0.a().n(28)).g().p();
                if (booleanValue) {
                    this.a.A2(false);
                } else if (p) {
                    this.a.A2(true);
                } else {
                    this.a.b3();
                }
                ((c.a.p0.p4.f.c) this.a.V0.a().n(28)).g().setEmotionClick(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.p4.k.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoDanmuController f36591b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f36592c;

        public d0(VideoPlayFragment videoPlayFragment, c.a.p0.p4.k.a aVar, VideoDanmuController videoDanmuController) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, aVar, videoDanmuController};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36592c = videoPlayFragment;
            this.a = aVar;
            this.f36591b = videoDanmuController;
        }

        @Override // c.a.p0.p4.k.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.a.stopPlay();
                    this.f36592c.startPlay();
                    VideoDanmuController videoDanmuController = this.f36591b;
                    if (videoDanmuController != null) {
                        videoDanmuController.b0(this.a.D0());
                        return;
                    }
                    return;
                }
                c.a.p0.p4.k.a aVar = this.a;
                if (aVar != null) {
                    VideoDanmuController videoDanmuController2 = this.f36591b;
                    if (videoDanmuController2 != null) {
                        aVar.I0(videoDanmuController2.F());
                    }
                    this.f36592c.u3();
                    this.a.startPlay();
                    VideoDanmuController videoDanmuController3 = this.f36591b;
                    if (videoDanmuController3 != null) {
                        videoDanmuController3.R();
                        this.f36591b.S();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d1 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public d1(VideoPlayFragment videoPlayFragment) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.a1 == null) {
                return;
            }
            this.a.a1.dismiss();
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
        public boolean a(@Nullable PostData postData, @Nullable c.a.p0.w2.i.f fVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, postData, fVar)) == null) {
                if (this.a.j != null) {
                    this.a.j.O("c14478");
                }
                if (postData != null) {
                    this.a.X2(postData.G());
                    MessageManager.getInstance().registerStickyMode(2921648);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921648, fVar));
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e0 implements b.InterfaceC1280b {
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

        @Override // c.a.p0.p4.f.b.InterfaceC1280b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.a.j == null) {
                return;
            }
            this.a.j.V(str);
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
            ThreadData threadData;
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.a4.k0.l)) {
                c.a.p0.a4.k0.l lVar = (c.a.p0.a4.k0.l) customResponsedMessage.getData();
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData == null || (threadData = videoItemData.threadData) == null || (str = threadData.tid) == null || !str.equals(lVar.a)) {
                    return;
                }
                this.a.h0.threadData.setIsMarked(lVar.f12245b ? 1 : 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements VideoDanmuController.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ThreadData a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ f f36593b;

            public a(f fVar, ThreadData threadData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, threadData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36593b = fVar;
                this.a = threadData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f36593b.a.h0.parseProto(this.a);
                    this.f36593b.a.h0.reGenerateTitle();
                    VideoPlayFragment videoPlayFragment = this.f36593b.a;
                    videoPlayFragment.h0.threadData = this.a;
                    videoPlayFragment.J3();
                    this.f36593b.a.K3();
                    VideoItemData videoItemData = this.f36593b.a.h0;
                    if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.f36593b.a;
                    videoPlayFragment2.M3(videoPlayFragment2.h0, videoPlayFragment2.Y0, this.f36593b.a.j);
                    VideoPlayFragment videoPlayFragment3 = this.f36593b.a;
                    videoPlayFragment3.N3(videoPlayFragment3.h0.video_url);
                    if (this.f36593b.a.h0.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.f36593b.a.h0.author_info.user_id)) {
                        this.f36593b.a.A0 = true;
                    }
                    this.f36593b.a.H2();
                    VideoPlayFragment videoPlayFragment4 = this.f36593b.a;
                    videoPlayFragment4.setUserVisibleHint(videoPlayFragment4.l0);
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
                c.a.d.f.m.e.a().post(new a(this, threadData));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // c.a.p0.p4.f.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    this.a.t0.setVisibility(0);
                } else {
                    this.a.t0.setVisibility(8);
                }
                if (z) {
                    this.a.J2("");
                    if (this.a.j != null) {
                        this.a.j.O("c14476");
                    }
                } else {
                    this.a.J2(((c.a.p0.p4.f.c) this.a.V0.a().n(28)).f().getText().toString());
                }
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData != null && z) {
                    long g2 = c.a.d.f.m.b.g(videoItemData.comment_num, 0L) + 1;
                    this.a.h0.comment_num = String.valueOf(g2);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.H3(g2, videoPlayFragment.Q);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
                this.a.B2();
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.isPrimary() && this.a.l0 && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.c3.q)) {
                c.a.p0.c3.q qVar = (c.a.p0.c3.q) customResponsedMessage.getData();
                SeekBar seekBar = this.a.k0.getSeekBar();
                int i = qVar.a;
                if (i == 1) {
                    seekBar.setProgress(qVar.f13490b);
                    this.a.k0.k(seekBar, qVar.f13490b, true);
                } else if (i == 2) {
                    this.a.k0.l(seekBar);
                } else if (i == 3) {
                    this.a.k0.m(seekBar);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.o0.c1.g0<String> a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f36594b;

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
            this.f36594b = videoPlayFragment;
            this.a = new c.a.o0.c1.g0<>(300, TimeUnit.MILLISECONDS);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (!this.a.a("onTouchDownEvent")) {
                    return super.onDoubleTap(motionEvent);
                }
                this.f36594b.K(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                if (this.f36594b.e4()) {
                    this.a.a("onTouchDownEvent");
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
                if (!this.a.a("onTouchDownEvent")) {
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
                }
                if (motionEvent.getX() - motionEvent2.getX() > 50.0f) {
                    this.f36594b.onViewDragToRight();
                    this.f36594b.f36585f.cancelLongPress();
                    return true;
                } else if (motionEvent2.getX() - motionEvent.getX() > 50.0f) {
                    this.f36594b.t3();
                    this.f36594b.f36585f.cancelLongPress();
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
                this.f36594b.onViewClick();
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean) && this.a.isResumed() && this.a.l0) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.R3(videoPlayFragment.A0, booleanValue);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g1 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public g1(VideoPlayFragment videoPlayFragment) {
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
                    videoPlayFragment.l1 = videoPlayFragment.V2(1.0f, 1.0f, 1.0f, 100L);
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

    /* loaded from: classes6.dex */
    public class h implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GestureDetectorCompat a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f36595b;

        public h(VideoPlayFragment videoPlayFragment, GestureDetectorCompat gestureDetectorCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, gestureDetectorCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36595b = videoPlayFragment;
            this.a = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.a.onTouchEvent(motionEvent) : invokeLL.booleanValue;
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
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.a).h0) == null || videoItemData.thread_id == null) {
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

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class i implements View.OnLongClickListener {
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

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.a.V3();
                this.a.f36585f.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.a.H0.getLoadDataMode() == 0) {
                if (this.a.f3()) {
                    if ((obj instanceof ForumManageModel.b) && this.a.getPageContext() != null) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        VideoVerticalPageFragment.OnDeleteSelfPostListener.d(this.a.getPageContext(), Pair.create(Boolean.valueOf(bVar.a), bVar.f36156b));
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

    /* loaded from: classes6.dex */
    public class i1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i1(VideoPlayFragment videoPlayFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.a4.k0.e)) {
                AgreeData agreeData = ((c.a.p0.a4.k0.e) customResponsedMessage.getData()).f12234b;
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
                    this.a.C2();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.a.h0.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.a.h0.agree_num = String.valueOf(agreeData.agreeNum);
                this.a.h0.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.a.C2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements h.c {
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

        @Override // c.a.p0.c3.h.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || this.a.W0 == null) {
                return;
            }
            this.a.W0.a(i, i2);
            if (this.a.g1) {
                this.a.w3(i2, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j0 implements a.InterfaceC0810a {
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

        @Override // c.a.o0.h.a.InterfaceC0810a
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
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cc));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f80));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.obfuscated_res_0x7f0f1486));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j1(VideoPlayFragment videoPlayFragment, int i) {
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.a.Q0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.a.f36582c.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.a.h0 == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f2 = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds562);
            int R2 = this.a.R2();
            int e2 = c.a.d.f.m.b.e(this.a.h0.video_height, 0);
            int e3 = c.a.d.f.m.b.e(this.a.h0.video_width, 0);
            if (e2 != 0 && e3 != 0) {
                f2 = (e2 * 1.0f) / e3;
            }
            if (e2 > e3) {
                return;
            }
            int k = c.a.d.f.p.n.k(this.a.f36585f.getContext());
            float f3 = k * f2;
            int f4 = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds166);
            if (f2 > 1.0f) {
                i = (int) (dimenPixelSize + ((R2 - dimenPixelSize) * floatValue));
                i2 = (int) (i / f2);
                float f5 = 1.0f - floatValue;
                statusBarHeight = (int) (UtilHelper.getStatusBarHeight() * f5);
                this.a.M0.topMargin = (int) (((R2 - f4) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f5) + (f5 * (dimenPixelSize - f4) * 0.5f));
            } else {
                float f6 = dimenPixelSize;
                float f7 = 1.0f - floatValue;
                statusBarHeight = (int) (((R2 - f3) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f7));
                this.a.M0.topMargin = (int) (((R2 - f4) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f7) + (f7 * (dimenPixelSize - f4) * 0.5f));
                i = (int) (f6 + ((f3 - f6) * floatValue));
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

    /* loaded from: classes6.dex */
    public class k0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.r.playAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k1(VideoPlayFragment videoPlayFragment, int i) {
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
                    if (bool.booleanValue() || !this.a.s3()) {
                        this.a.startPlay();
                        this.a.u3();
                        return;
                    }
                    this.a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
    public class l0 implements l.c {
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

        @Override // c.a.o0.r.t.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a3();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l1 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l1(VideoPlayFragment videoPlayFragment, int i) {
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.Q0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.a.f36582c.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.a.s3()) {
                        this.a.startPlay();
                        return;
                    }
                    return;
                }
                this.a.f4();
                this.a.u3();
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.a;
                if (videoPlayFragment.I2(videoPlayFragment.getPageContext(), 25066)) {
                    this.a.Y3();
                    if (this.a.h0 != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.a.h0.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.a.h0.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                    if (this.a.j != null) {
                        this.a.j.O("c14475");
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 implements DialogInterface.OnDismissListener {
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
    public interface m1 {
        void a();

        void onStart();
    }

    /* loaded from: classes6.dex */
    public class n implements SeekBar.OnSeekBarChangeListener {
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

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && z) {
                this.a.N2(true);
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
                this.a.c4();
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
                    this.a.N2(false);
                    if (!this.a.i.getControl().isPlaying()) {
                        this.a.i.getControl().start();
                        this.a.B.setVisibility(8);
                    }
                    if (!this.a.Q0 && (!this.a.isResumed() || !this.a.l0)) {
                        this.a.u3();
                    }
                    c.a.d.f.m.e.a().removeCallbacks(this.a.H1);
                    c.a.d.f.m.e.a().postDelayed(this.a.H1, 3000L);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public n0(VideoPlayFragment videoPlayFragment) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.a4(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f36596b;

        public o(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f36596b = videoPlayFragment;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.a)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) c.a.d.a.j.a(this.f36596b.getPageContext().getPageActivity()), new String[]{this.a}, true);
        }
    }

    /* loaded from: classes6.dex */
    public class o0 implements l.d {
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

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.F0 != null) {
                    this.a.F0.dismiss();
                }
                this.a.a4(false);
            }
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
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f0918a5 && (videoItemData = this.a.h0) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
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
                long g2 = c.a.d.f.m.b.g(userItemData.user_id, 0L);
                long g3 = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = (g2 == 0 && g3 == 0) ? false : g2 == g3;
                String str = this.a.h0.author_info.portrait;
                PersonPolymericActivityConfig createNormalConfig = new PersonPolymericActivityConfig(this.a.getActivity()).createNormalConfig(g2, z, false, true, (this.a.a == 3 || this.a.a == 4) ? PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_CHANNEL : PersonPolymericActivityConfig.VIDEO_PERSON_FROM_VIDEO_MIDDLE);
                createNormalConfig.setPortrait(str);
                createNormalConfig.setSourceTid(this.a.h0.thread_id);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalConfig));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.a.h0.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.a.P2(5);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p0 implements l.d {
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

        @Override // c.a.o0.r.t.l.d
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

    /* loaded from: classes6.dex */
    public class q implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.a).h0) == null || videoItemData.act_info == null) {
                return;
            }
            c.a.o0.l.a.l(videoPlayFragment.getActivity(), this.a.h0.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.a.h0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes6.dex */
    public class q0 implements l.d {
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

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            CustomResponsedMessage runTask;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.dismiss();
                if (ViewHelper.checkUpIsLogin(this.a.getActivity()) && this.a.getPageContext() != null) {
                    if (this.a.m1 == null && (runTask = MessageManager.getInstance().runTask(2921343, c.a.p0.h4.a.class, this.a.getContext())) != null) {
                        this.a.m1 = (c.a.p0.h4.a) runTask.getData();
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

    /* loaded from: classes6.dex */
    public class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.W2();
                this.a.P2(7);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r0(VideoPlayFragment videoPlayFragment, int i) {
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
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.a.h0.author_info.user_id.equals(data.f30338c)) {
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
                    c.a.d.f.p.n.M(this.a.getActivity(), R.string.obfuscated_res_0x7f0f02a5);
                    VideoPlayFragment videoPlayFragment = this.a;
                    videoPlayFragment.h0.author_info.is_follow = "0";
                    videoPlayFragment.D2();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    videoPlayFragment2.h0.author_info.is_follow = "0";
                    videoPlayFragment2.D2();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.a.h0));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.h0.author_info.is_follow = "1";
                    videoPlayFragment3.D2();
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
    public class s implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.a.h0.thread_id));
                }
                this.a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class s0 implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        /* loaded from: classes6.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.o0.r.t.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ s0 f36597b;

            public a(s0 s0Var, c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36597b = s0Var;
                this.a = aVar;
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.a.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f36597b.a;
                    if (videoPlayFragment.h0 != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.H0;
                        VideoPlayFragment videoPlayFragment2 = this.f36597b.a;
                        VideoItemData videoItemData = videoPlayFragment2.h0;
                        forumManageModel.U(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.A0, null, false);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.o0.r.t.a a;

            public b(s0 s0Var, c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {s0Var, aVar};
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

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.a.dismiss();
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

        @Override // c.a.o0.r.t.l.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.F0.dismiss();
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getActivity());
                VideoItemData videoItemData = this.a.h0;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(R.string.obfuscated_res_0x7f0f048d);
                } else {
                    aVar.setMessageId(R.string.obfuscated_res_0x7f0f048c);
                }
                aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, new a(this, aVar));
                aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.V3();
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class u implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.a.getPageContext(), this.a.h0)) {
                return;
            }
            this.a.W2();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.a.h0.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.a.P2(2);
        }
    }

    /* loaded from: classes6.dex */
    public class u0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f36598b;

        public u0(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f36598b = videoPlayFragment;
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f36598b.getContext()).createNormalCfg(this.a, "")));
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
                if (this.a.f36587h != null && this.a.i != null) {
                    this.a.f36587h.addView(this.a.i, 0, this.a.v0);
                }
            } else {
                this.a.K3();
            }
            this.a.L3();
        }
    }

    /* loaded from: classes6.dex */
    public class v0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

        public v0(VideoPlayFragment videoPlayFragment) {
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f1 == null) {
                return;
            }
            this.a.f1.q(TiePlusStat.StatType.CLICK);
            this.a.d1.g(this.a.f1);
            this.a.d1.e(this.a.f1);
        }
    }

    /* loaded from: classes6.dex */
    public class w implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPlayFragment a;

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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.a;
                videoPlayFragment.M2(videoPlayFragment.f36583d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w0 implements Runnable {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.P0) {
                return;
            }
            this.a.F2(true);
        }
    }

    /* loaded from: classes6.dex */
    public class x implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.Z3();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.a.h0.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.a.P2(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.a.h0.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.a.h0.nid);
                BaijiahaoData baijiahaoData = this.a.h0.baijiahaoData;
                if (baijiahaoData != null && !c.a.d.f.p.m.isEmpty(baijiahaoData.oriUgcVid)) {
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
                if (c.a.o0.o0.c.j(this.a.getBaseFragmentActivity()) != null && c.a.o0.o0.c.j(this.a.getBaseFragmentActivity()).b() != null && c.a.o0.o0.c.j(this.a.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(c.a.o0.o0.c.j(this.a.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f36599b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f36600c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f36601d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f36603f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ RelativeLayout.LayoutParams f36604g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f36605h;
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

        public x0(VideoPlayFragment videoPlayFragment, int i, int i2, int i3, int i4, int i5, int i6, RelativeLayout.LayoutParams layoutParams, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), layoutParams, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), view, view2};
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
            this.f36599b = i2;
            this.f36600c = i3;
            this.f36601d = i4;
            this.f36602e = i5;
            this.f36603f = i6;
            this.f36604g = layoutParams;
            this.f36605h = i7;
            this.i = i8;
            this.j = i9;
            this.k = i10;
            this.l = i11;
            this.m = i12;
            this.n = i13;
            this.o = i14;
            this.p = i15;
            this.q = view;
            this.r = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f2;
            boolean z;
            float f3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = (int) (this.a * animatedFraction);
                int i2 = (int) (this.f36599b * animatedFraction);
                int i3 = this.f36600c;
                int i4 = i3 > this.f36601d ? i3 - i : i3 + i;
                int i5 = this.f36602e;
                this.f36604g.topMargin = i5 > this.f36603f ? i5 - i2 : i5 + i2;
                this.s.v0.topMargin = i4;
                int i6 = (int) (this.f36605h * animatedFraction);
                int i7 = this.i;
                int i8 = i7 > this.j ? i7 - i6 : i7 + i6;
                this.s.v0.leftMargin = i8;
                this.s.v0.rightMargin = i8;
                RelativeLayout.LayoutParams layoutParams = this.f36604g;
                layoutParams.leftMargin = i8;
                layoutParams.rightMargin = i8;
                float f4 = this.k * animatedFraction;
                float f5 = this.l * animatedFraction;
                int i9 = this.m;
                float f6 = i9 > this.n ? i9 - f4 : i9 + f4;
                int i10 = this.o;
                if (i10 > this.p) {
                    f2 = i10 - f5;
                    f3 = 1.0f - animatedFraction;
                    z = false;
                } else {
                    f2 = i10 + f5;
                    z = true;
                    f3 = animatedFraction;
                }
                this.s.v0.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.s.v0.height = (int) f6;
                RelativeLayout.LayoutParams layoutParams2 = this.f36604g;
                layoutParams2.height = (int) f2;
                layoutParams2.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.q.setLayoutParams(this.f36604g);
                this.q.setAlpha(f3);
                if (z && f3 > 0.5f) {
                    this.s.D3((f3 - 0.5f) * 2.0f);
                } else if (!z && animatedFraction < 0.25f) {
                    this.s.D3(1.0f - (animatedFraction * 4.0f));
                }
                this.r.setLayoutParams(this.s.v0);
                this.r.requestLayout();
                this.q.requestLayout();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y implements View.OnClickListener {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.a.getActivity())) {
                if (this.a.V != null && (videoItemData = (videoPlayFragment = this.a).h0) != null && videoItemData.author_info != null && videoPlayFragment.s != null) {
                    c.a.o0.s.e.a aVar = videoPlayFragment.J0;
                    VideoPlayFragment videoPlayFragment2 = this.a;
                    UserItemData userItemData = videoPlayFragment2.h0.author_info;
                    String str = userItemData.portrait;
                    String str2 = userItemData.user_id;
                    BdUniqueId bdUniqueId = videoPlayFragment2.K0;
                    VideoItemData videoItemData2 = this.a.h0;
                    aVar.m(true, str, str2, false, "6", bdUniqueId, videoItemData2.forum_id, "0", videoItemData2.thread_id);
                    VideoPlayFragment videoPlayFragment3 = this.a;
                    videoPlayFragment3.h0.author_info.is_follow = "1";
                    videoPlayFragment3.D2();
                    this.a.V.setVisibility(8);
                    this.a.v3();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.a.a != 3 && this.a.a != 4) {
                    statisticItem.param("obj_locate", 2);
                    if (this.a.a != 7) {
                        statisticItem.param("obj_source", this.a.U2());
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
                this.a.P2(6);
            }
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.a.isResumed() && this.a.l0) {
                if (c.a.d.f.p.l.z()) {
                    if (this.a.W3()) {
                        return;
                    }
                    this.a.startPlay();
                    return;
                }
                c.a.d.f.p.n.M(TbadkCoreApplication.getInst(), R.string.obfuscated_res_0x7f0f0c15);
            }
        }
    }

    /* loaded from: classes6.dex */
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
    public class z0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f36606b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f36607c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f36608d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f36609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f36610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f36611g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f36612h;
        public final /* synthetic */ int i;
        public final /* synthetic */ View j;
        public final /* synthetic */ View k;
        public final /* synthetic */ VideoPlayFragment l;

        public z0(VideoPlayFragment videoPlayFragment, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {videoPlayFragment, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), view, view2};
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
            this.f36606b = i2;
            this.f36607c = i3;
            this.f36608d = i4;
            this.f36609e = i5;
            this.f36610f = i6;
            this.f36611g = i7;
            this.f36612h = i8;
            this.i = i9;
            this.j = view;
            this.k = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                int i = (int) (this.a * animatedFraction);
                int i2 = this.f36606b;
                this.l.v0.topMargin = i2 > this.f36607c ? i2 - i : i2 + i;
                int i3 = (int) (this.f36608d * animatedFraction);
                int i4 = this.f36609e;
                int i5 = i4 > this.f36610f ? i4 - i3 : i4 + i3;
                this.l.v0.leftMargin = i5;
                this.l.v0.rightMargin = i5;
                float f2 = animatedFraction * this.f36611g;
                int i6 = this.f36612h;
                float f3 = i6 > this.i ? i6 - f2 : i6 + f2;
                this.l.v0.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.l.v0.height = (int) f3;
                this.j.setLayoutParams(this.l.v0);
                this.k.setLayoutParams(this.l.v0);
                this.j.requestLayout();
                this.k.requestLayout();
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
        this.f36583d = 0;
        this.f36584e = 1;
        this.t = false;
        this.o0 = false;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = BdUniqueId.gen();
        this.N0 = TbCyberVideoView.VideoStatus.INIT;
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
        this.q1 = new r0(this, 2001115);
        this.r1 = new y0(this, 2000994);
        this.s1 = new i1(this, 2016528);
        this.t1 = new j1(this, 2921594);
        this.u1 = new k1(this, 2001011);
        this.v1 = new l1(this, 2921596);
        this.w1 = new a(this, 2921598);
        this.x1 = new b(this, 2921612);
        this.y1 = new BarManageResultListener(new c(this));
        this.z1 = new d(this, 2921645);
        this.A1 = new e(this);
        this.B1 = new h0(this);
        this.C1 = new n0(this);
        this.D1 = new o0(this);
        this.E1 = new p0(this);
        this.F1 = new q0(this);
        this.G1 = new s0(this);
        this.H1 = new w0(this);
        this.I1 = new b1(this);
        this.J1 = new e1(this, 2921603);
        this.K1 = new f1(this, 2921635);
    }

    public static /* synthetic */ int r2(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.S0;
        videoPlayFragment.S0 = i2 + 1;
        return i2;
    }

    public final void A2(boolean z2) {
        c.a.p0.p4.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) || (aVar = this.V0) == null || aVar.a() == null) {
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

    public final void A3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || W3()) {
            return;
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.h0 != null) {
            if (this.i.getParent() == null) {
                K3();
                L3();
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
            T3();
        }
        if (isResumed() && this.l0 && s3()) {
            return;
        }
        u3();
        if (this.B != null) {
            G3();
        }
    }

    public final void B2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.a;
            if (i2 != 4 && i2 != 3) {
                B3(UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            } else {
                B3(0);
            }
        }
    }

    public final void B3(int i2) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (view = this.f36585f) == null) {
            return;
        }
        view.setPadding(0, 0, 0, i2);
    }

    public final void C2() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoItemData = this.h0) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080830, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082e, WebPManager.ResourceStateType.NORMAL));
        }
        H3(c.a.d.f.m.b.g(this.h0.agree_num, 0L), this.R);
    }

    public final void C3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.x.setVisibility(i2);
            this.X.setVisibility(i2);
            this.y.setVisibility(i2);
            this.w.setVisibility(i2);
            this.u.setVisibility(i2);
        }
    }

    public final void D2() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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

    public final void D3(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f2) == null) {
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
            View view = this.h1;
            if (view != null) {
                view.setVisibility(0);
                this.h1.setAlpha(f2);
            }
            View view2 = this.i1;
            if (view2 != null) {
                view2.setVisibility(0);
                this.i1.setAlpha(f2);
            }
            View view3 = this.m;
            if (view3 != null) {
                view3.setVisibility(0);
                this.m.setAlpha(f2);
            }
            View view4 = this.f36586g;
            if (view4 != null) {
                view4.setVisibility(0);
                this.f36586g.setAlpha(f2);
            }
        }
    }

    public void E2(int i2) {
        c.a.p0.p4.f.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) || (aVar = this.V0) == null || aVar.a() == null) {
            return;
        }
        this.V0.a().w(i2);
    }

    public final void E3(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
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
            View view = this.h1;
            if (view != null) {
                view.setVisibility(i2);
            }
            View view2 = this.i1;
            if (view2 != null) {
                view2.setVisibility(i2);
            }
            View view3 = this.m;
            if (view3 != null) {
                view3.setVisibility(i2);
            }
            View view4 = this.f36586g;
            if (view4 != null) {
                view4.setVisibility(i2);
            }
        }
    }

    public final void F2(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z2) == null) || (videoMiddleNiaiControllerView = this.k0) == null) {
            return;
        }
        int i2 = this.a;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick()) ? 1 : 0);
    }

    public void F3(h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cVar) == null) {
            this.W0 = cVar;
        }
    }

    public final void G2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || n3() || this.A == null || this.z == null) {
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

    public final void G3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.B.setVisibility(0);
            if (this.k1 == null) {
                this.k1 = V2(0.0f, 3.0f, 3.0f, 0L);
            }
            this.k1.addListener(new g1(this));
            this.k1.start();
        }
    }

    public final void H2() {
        VideoItemData videoItemData;
        String forum_name;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (videoItemData = this.h0) == null) {
            return;
        }
        this.l.J(videoItemData.thumbnail_url, 10, false);
        SpannableStringBuilder title = this.h0.getTitle();
        boolean z2 = c.a.d.f.m.b.e(this.h0.video_height, 0) <= c.a.d.f.m.b.e(this.h0.video_width, 0);
        if (TextUtils.isEmpty(title) && (!z2 || this.h0.video_duration < 60)) {
            this.P.setVisibility(8);
        } else {
            if (this.h0.video_duration >= 60) {
                this.N.setVisibility(0);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = new LinearLayout.LayoutParams(c.a.d.f.p.n.f(getContext(), R.dimen.tbds31), c.a.d.f.p.n.f(getContext(), R.dimen.tbds31));
                }
                layoutParams.width = c.a.d.f.p.n.f(getContext(), R.dimen.tbds3);
                layoutParams.height = c.a.d.f.p.n.f(getContext(), R.dimen.tbds34);
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
                c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.M);
                d2.z(R.dimen.T_X08);
                d2.v(R.color.CAM_X0618);
                d2.A(R.string.F_X02);
                this.M.setText(sb.toString());
            } else {
                this.N.setVisibility(8);
            }
            this.P.setVisibility(0);
            this.L.setTextSize(c.a.d.f.p.n.f(getContext(), R.dimen.T_X07));
            this.L.setTextColor(R.color.CAM_X0621);
            this.L.setLineSpacingExtra(c.a.d.f.p.n.f(getContext(), R.dimen.tbds10));
            this.L.setExpandable(false);
            this.L.setTextMaxLine(3);
            this.L.setLimitLine(3);
            this.L.setOnStatusChangedListener(new t0(this));
            ExpandableTextView expandableTextView = this.L;
            VideoItemData videoItemData2 = this.h0;
            expandableTextView.setData(title, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        H3(c.a.d.f.m.b.g(this.h0.comment_num, 0L), this.Q);
        H3(c.a.d.f.m.b.g(this.h0.agree_num, 0L), this.R);
        if (n3()) {
            this.S.setText(R.string.obfuscated_res_0x7f0f0aca);
        } else {
            H3(c.a.d.f.m.b.g(this.h0.share_num, 0L), this.S);
        }
        UserItemData userItemData = this.h0.author_info;
        if (userItemData != null) {
            if (!StringUtils.isNull(userItemData.portrait) && this.h0.author_info.portrait.startsWith("http")) {
                this.q.J(this.h0.author_info.portrait, 10, false);
            } else {
                this.q.J(this.h0.author_info.portrait, 12, false);
            }
            if (p3() && !TextUtils.isEmpty(this.h0.author_info.auth)) {
                this.q.setShowV(true);
                this.q.setOriginatorResId(R.drawable.obfuscated_res_0x7f0805f6);
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
            Z2(this.h0.mAlaInfoData.live_status == 1);
            Y2();
        }
        if ("1".equals(this.h0.is_private) && this.j0.getVisibility() != 0) {
            this.g0.setVisibility(0);
        } else {
            this.g0.setVisibility(8);
        }
        if ("1".equals(this.h0.is_agreed)) {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080830, WebPManager.ResourceStateType.NORMAL));
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.p0, AnimationProperty.SCALE_X, 1.3f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.p0, AnimationProperty.SCALE_Y, 1.3f, 1.0f);
            ofFloat.setDuration(300L);
            ofFloat2.setDuration(300L);
            ofFloat.start();
            ofFloat2.start();
        } else {
            this.p0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f08082e, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.h0.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.j0.getVisibility() != 0) {
            this.Z.setVisibility(8);
            this.W.setText(this.h0.act_info.activity_name);
        } else {
            this.Z.setVisibility(8);
        }
        D2();
        boolean e3 = e3();
        if (this.a == 7) {
            this.E.setVisibility(8);
        } else if (e3) {
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
            WebPManager.setPureDrawable(this.J, R.drawable.obfuscated_res_0x7f0808dd, R.color.CAM_X0101, null);
            this.J.setVisibility(0);
            this.I.setVisibility(8);
            String cutChineseAndEnglishWithEmoji = StringHelper.cutChineseAndEnglishWithEmoji(forum_name + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02cb), 12, "...吧");
            this.C0 = cutChineseAndEnglishWithEmoji;
            this.K.setText(cutChineseAndEnglishWithEmoji);
            ThreadData threadData2 = this.h0.threadData;
            if (threadData2 != null && !TextUtils.isEmpty(threadData2.getRecomReason())) {
                TextView textView = this.K;
                textView.setText(this.C0 + getActivity().getResources().getString(R.string.obfuscated_res_0x7f0f14ea));
            }
            this.E.setOnClickListener(new u0(this, forum_name));
        }
    }

    public final void H3(long j2, TextView textView) {
        String string;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJL(1048591, this, j2, textView) == null) || textView == null) {
            return;
        }
        String numberUniformFormatExtraWithRoundVote = StringHelper.numberUniformFormatExtraWithRoundVote(j2);
        if (!"0".equals(numberUniformFormatExtraWithRoundVote)) {
            textView.setText(numberUniformFormatExtraWithRoundVote);
            return;
        }
        if (textView.getId() == R.id.obfuscated_res_0x7f090159) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14db);
        } else if (textView.getId() == R.id.obfuscated_res_0x7f09068e) {
            string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14dc);
        } else {
            string = textView.getId() == R.id.obfuscated_res_0x7f091cca ? TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14de) : "";
        }
        textView.setText(string);
    }

    public final boolean I2(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048592, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void I3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.q.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.width = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams.height = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                layoutParams2.height = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds94);
            }
        }
    }

    public final void J2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                this.u0.setText(R.string.obfuscated_res_0x7f0f0f95);
                DanmuPostDraftManager.f36659b.a().c(this.h0.thread_id);
                return;
            }
            this.u0.setText(R.string.obfuscated_res_0x7f0f04ff);
            DanmuPostDraftManager.f36659b.a().d(this.h0.thread_id, str);
        }
    }

    public void J3() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (videoItemData = this.h0) == null) {
            return;
        }
        int e2 = c.a.d.f.m.b.e(videoItemData.video_height, 0);
        int e3 = c.a.d.f.m.b.e(this.h0.video_width, 0);
        int R2 = R2();
        int k2 = c.a.d.f.p.n.k(this.f36585f.getContext());
        if (e2 <= 0 || e3 <= 0 || R2 <= 0 || k2 <= 0) {
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
            this.M0.topMargin = (R2 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
            this.M0 = layoutParams2;
            layoutParams2.removeRule(13);
            this.M0.addRule(14);
            this.M0.topMargin = (R2 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
        }
        if (f2 > 1.34f) {
            this.i.getControl().setVideoScalingMode(0);
            this.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return;
        }
        this.i.getControl().setVideoScalingMode(2);
        this.l.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    @Override // c.a.o0.e1.r.b.InterfaceC0807b
    public void K(float f2, float f3) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.h0) != null && "0".equals(videoItemData.is_agreed)) {
            M2(this.f36584e);
        }
    }

    public final void K2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if ((this.i.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof c.a.p0.c3.o)) {
                ((TbVideoView) this.i.getControl()).M();
                ((c.a.p0.c3.o) this.i.getControl().getPlayer()).detachKLayerToCache("video_reuse_player");
            }
            TbSingleton.getInstance().setIsOutNeedReuseVideoPlayer(true);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921679, this.L0));
        }
    }

    public void K3() {
        TbVideoViewContainer tbVideoViewContainer;
        VideoRecommentPlayActivityConfig.PersonalPageParams personalPageParams;
        TbVideoViewContainer tbVideoViewContainer2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getParent() == null) {
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null && TextUtils.isEmpty(videoItemData.video_height) && TextUtils.isEmpty(this.h0.video_width)) {
                return;
            }
            if (this.h0 != null) {
                this.v0 = new RelativeLayout.LayoutParams(-1, -1);
                J3();
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
                    this.v0 = S2();
                }
                int i6 = this.a;
                if (i6 != 4 && i6 != 3) {
                    this.v0.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
                } else {
                    this.v0.bottomMargin = c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds0);
                }
                this.l.setLayoutParams(this.v0);
                if (this.f36587h != null && (tbVideoViewContainer2 = this.i) != null) {
                    tbVideoViewContainer2.setId(R.id.obfuscated_res_0x7f09231d);
                    if (i3() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                        this.v0.addRule(15);
                    }
                    this.f36587h.addView(this.i, 0, this.v0);
                }
                boolean z2 = c.a.d.f.m.b.e(this.h0.video_height, 0) <= c.a.d.f.m.b.e(this.h0.video_width, 0);
                if (this.h0.video_duration >= 60 && z2) {
                    View inflate = getLayoutInflater().inflate(R.layout.obfuscated_res_0x7f0d087e, (ViewGroup) null);
                    this.f36586g = inflate;
                    EMTextView eMTextView = (EMTextView) this.f36586g.findViewById(R.id.obfuscated_res_0x7f090c06);
                    WebPManager.setPureDrawable((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090c05), R.drawable.obfuscated_res_0x7f0809ce, R.color.CAM_X0101, null);
                    eMTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0102));
                    eMTextView.setText(getString(R.string.obfuscated_res_0x7f0f14ce));
                    eMTextView.setGravity(17);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams2.addRule(3, R.id.obfuscated_res_0x7f09231d);
                    layoutParams2.addRule(14, -1);
                    layoutParams2.topMargin = getResources().getDimensionPixelSize(R.dimen.M_H_X004);
                    this.f36587h.addView(this.f36586g, layoutParams2);
                    d4(this.h0.thread_id, true);
                    if (UbsABTestHelper.isFeedVideoImmersionTransition() && !j3()) {
                        this.f36586g.setVisibility(8);
                    } else {
                        this.f36586g.setVisibility(0);
                    }
                    this.f36586g.setOnClickListener(new a1(this));
                }
            }
            if (this.h0 != null) {
                c.a.p0.c3.u uVar = new c.a.p0.c3.u();
                uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData2 = this.h0;
                uVar.f13504c = videoItemData2.thread_id;
                uVar.t = videoItemData2.nid;
                uVar.f13505d = videoItemData2.forum_id;
                uVar.m = videoItemData2.mMd5;
                uVar.k = "";
                uVar.f13507f = videoItemData2.mRecomSource;
                uVar.l = videoItemData2.mRecomAbTag;
                uVar.j = 1;
                uVar.x = videoItemData2.getChannelMidRequestNum();
                uVar.y = this.h0.getChannelMidRequestVideoNum();
                BaijiahaoData baijiahaoData = this.h0.baijiahaoData;
                if (baijiahaoData != null) {
                    int i7 = baijiahaoData.oriUgcType;
                    if (i7 == 2) {
                        uVar.j = 3;
                    } else if (i7 == 4) {
                        uVar.j = 2;
                    }
                }
                uVar.f13509h = this.h0.mRecomWeight;
                if (this.n0 != null) {
                    uVar.n = "1";
                } else {
                    uVar.n = "2";
                }
                int i8 = this.a;
                if (i8 == 1) {
                    uVar.p = "1";
                    uVar.a = "13";
                    uVar.i = this.D0;
                    uVar.k = this.O0;
                    uVar.f13508g = this.h0.mRecomWeight;
                } else if (i8 == 2) {
                    uVar.a = "24";
                } else {
                    uVar.a = "13";
                }
                uVar.p = "1";
                int i9 = this.a;
                if (i9 == 3) {
                    uVar.a = "21";
                } else if (i9 == 4) {
                    uVar.a = "22";
                } else if (i9 == 7) {
                    uVar.a = "26";
                } else if (h3()) {
                    uVar.a = "27";
                }
                String str = this.D0;
                uVar.i = str;
                String str2 = this.O0;
                uVar.k = str2;
                VideoItemData videoItemData3 = this.h0;
                String str3 = videoItemData3.mRecomWeight;
                uVar.f13508g = str3;
                uVar.w = videoItemData3.mExtra;
                if (this.a == 5) {
                    uVar.a = "23";
                    uVar.p = "1";
                    uVar.i = str;
                    uVar.k = str2;
                    uVar.f13508g = str3;
                }
                if (f3() && (personalPageParams = VideoRecommentPlayActivityConfig.bigPersonalPageParams) != null) {
                    uVar.i = personalPageParams.getStatPageFromIdentifier();
                }
                this.i.getControl().setVideoStatData(uVar);
                this.i.getControl().setLocateSource("v_mid_page");
            }
            this.i.getControl().setContinuePlayEnable(true);
        }
    }

    public void L2() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (alertDialog = this.a1) != null && alertDialog.isShowing()) {
            this.a1.dismiss();
        }
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.i.getControl().setVideoStatusChangeListener(this);
            this.i.getControl().setOperableVideoContainer(this.I1);
        }
    }

    @Override // c.a.p0.p4.j.b.a
    public void M(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.T0 = i2;
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
    public final void M2(int i2) {
        VideoItemData videoItemData;
        int i3;
        c.a.o0.n0.c currentVisiblePageExtra;
        BaijiahaoData baijiahaoData;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.h0) != null) {
            if (i2 == this.f36583d) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.h0;
                    videoItemData2.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData2.agree_num, 0) - 1);
                    this.h0.is_agreed = "0";
                    i3 = 1;
                    StatisticItem statisticItem = new StatisticItem("c12795");
                    statisticItem.param("tid", this.h0.thread_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (i2 != this.f36583d) {
                        statisticItem.param("obj_type", i3);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem("c12003");
                    statisticItem2.param("tid", this.h0.thread_id);
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (i2 != this.f36583d) {
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
                        if (i2 == this.f36583d) {
                            statisticItem3.param("obj_type", i3);
                        } else {
                            statisticItem3.param("obj_type", 2);
                        }
                        int i4 = this.a;
                        if (i4 != 3 && i4 != 4) {
                            statisticItem3.param("obj_locate", 2);
                        } else {
                            statisticItem3.param("obj_locate", 1);
                            statisticItem3.param("obj_source", U2());
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
                    H2();
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
                    c.a.p0.a4.k0.e eVar = new c.a.p0.a4.k0.e();
                    AgreeData agreeData = new AgreeData();
                    str = this.h0.thread_id;
                    if (str != null) {
                        agreeData.threadId = str;
                    }
                    agreeData.agreeNum = Long.valueOf(this.h0.agree_num).longValue();
                    agreeData.agreeType = 2;
                    agreeData.hasAgree = "1".equals(this.h0.is_agreed);
                    eVar.f12234b = agreeData;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.h0));
                    if (TbadkCoreApplication.isLogin() || i3 != 0) {
                    }
                    if (TbSingleton.getInstance().showStampMissionDialog && UbsABTestHelper.isStampMissionDialogABTestB()) {
                        c.a.p0.x3.b.r().A(0, 3);
                        c.a.p0.x3.b.r().G();
                    }
                    c.a.p0.x3.b.r().z(StampMission.Type.LIKE_THREAD);
                    return;
                }
                VideoItemData videoItemData3 = this.h0;
                videoItemData3.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData3.agree_num, 0) + 1);
                this.h0.is_agreed = "1";
                P2(1);
            } else {
                videoItemData.agree_num = String.valueOf(c.a.d.f.m.b.e(videoItemData.agree_num, 0) + 1);
                this.h0.is_agreed = "1";
                P2(1);
            }
            i3 = 0;
            StatisticItem statisticItem4 = new StatisticItem("c12795");
            statisticItem4.param("tid", this.h0.thread_id);
            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 != this.f36583d) {
            }
            TiebaStatic.log(statisticItem4);
            StatisticItem statisticItem22 = new StatisticItem("c12003");
            statisticItem22.param("tid", this.h0.thread_id);
            statisticItem22.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 != this.f36583d) {
            }
            if ("index".equals(this.D0)) {
            }
            currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getContext());
            if (currentVisiblePageExtra != null) {
            }
            if (TbPageExtraHelper.getPrePageKey() != null) {
            }
            TiebaStatic.log(statisticItem22);
            H2();
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
            c.a.p0.a4.k0.e eVar2 = new c.a.p0.a4.k0.e();
            AgreeData agreeData2 = new AgreeData();
            str = this.h0.thread_id;
            if (str != null) {
            }
            agreeData2.agreeNum = Long.valueOf(this.h0.agree_num).longValue();
            agreeData2.agreeType = 2;
            agreeData2.hasAgree = "1".equals(this.h0.is_agreed);
            eVar2.f12234b = agreeData2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar2));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.h0));
            if (TbadkCoreApplication.isLogin()) {
            }
        }
    }

    public final void M3(VideoItemData videoItemData, c.a.p0.p4.k.a aVar, VideoDanmuController videoDanmuController) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048603, this, videoItemData, aVar, videoDanmuController) == null) || aVar == null || aVar.getMainView() == null) {
            return;
        }
        aVar.G0(videoItemData);
        boolean z2 = false;
        boolean z3 = c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(videoItemData.video_width, 0);
        if (this.l0 && z3) {
            z2 = true;
        }
        aVar.W(z2);
        aVar.H0(new d0(this, aVar, videoDanmuController));
        aVar.getMainView().setVisibility(8);
    }

    public final void N2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z2) == null) {
            if (z2) {
                C3(8);
                this.v.setVisibility(0);
                return;
            }
            C3(0);
            this.v.setVisibility(8);
        }
    }

    public final void N3(String str) {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, str) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null || str == null || str.equals(this.L0)) {
            return;
        }
        this.L0 = str;
    }

    public final void O2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.h0 == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.h0.thread_id);
        statisticItem.param("nid", this.h0.nid);
        statisticItem.param("fid", this.h0.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.B0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", c.a.d.f.p.m.isEmpty(this.h0.mRecomWeight) ? "0" : this.h0.mRecomWeight);
        statisticItem.param("extra", c.a.d.f.p.m.isEmpty(this.h0.mRecomExtra) ? "0" : this.h0.mRecomExtra);
        statisticItem.param("obj_id", this.O0);
        statisticItem.param("ab_tag", c.a.d.f.p.m.isEmpty(this.h0.mRecomAbTag) ? "0" : this.h0.mRecomAbTag);
        statisticItem.param("obj_source", c.a.d.f.p.m.isEmpty(this.h0.mRecomSource) ? "0" : this.h0.mRecomSource);
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

    public final void O3(int i2) {
        RelativeLayout relativeLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || (relativeLayout = this.f36587h) == null) {
            return;
        }
        relativeLayout.setPadding(0, 0, 0, i2);
    }

    public void P2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
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

    public void P3(c.a.p0.p4.i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, aVar) == null) {
            this.U0 = aVar;
        }
    }

    public String Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void Q3(m1 m1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, m1Var) == null) {
            this.X0 = m1Var;
        }
    }

    public final int R2() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            int i3 = c.a.d.f.p.n.i(this.f36585f.getContext());
            if (r3()) {
                i2 = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            } else {
                i3 -= UtilHelper.getDimenPixelSize(R.dimen.M_H_X004);
                i2 = VideoMiddleNiaiControllerView.u;
            }
            return i3 - i2;
        }
        return invokeV.intValue;
    }

    public void R3(boolean z2, boolean z3) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            L2();
            if (TbadkCoreApplication.getInst().getCurrentActivity() == null) {
                return;
            }
            if (z3) {
                i2 = z2 ? R.string.obfuscated_res_0x7f0f0b0f : R.string.obfuscated_res_0x7f0f0b11;
                i3 = R.string.obfuscated_res_0x7f0f0b10;
                i4 = R.string.obfuscated_res_0x7f0f1152;
            } else {
                i2 = R.string.obfuscated_res_0x7f0f0487;
                i3 = R.string.obfuscated_res_0x7f0f0488;
                i4 = R.string.obfuscated_res_0x7f0f048e;
            }
            TBAlertConfig.a aVar = new TBAlertConfig.a(i4, TBAlertConfig.OperateBtnStyle.MAIN);
            TBAlertConfig.a aVar2 = new TBAlertConfig.a((int) R.string.obfuscated_res_0x7f0f036c, TBAlertConfig.OperateBtnStyle.SECONDARY);
            c.a.o0.r.t.o oVar = new c.a.o0.r.t.o(TbadkCoreApplication.getInst().getCurrentActivity());
            oVar.v(i2);
            oVar.l(i3);
            oVar.n(true);
            oVar.r(aVar2, aVar);
            oVar.i(false);
            this.a1 = oVar.y();
            aVar.a(new c1(this, z2, z3));
            aVar2.a(new d1(this));
        }
    }

    public final RelativeLayout.LayoutParams S2() {
        InterceptResult invokeV;
        RelativeLayout.LayoutParams layoutParams;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            int R2 = R2();
            int k2 = c.a.d.f.p.n.k(this.f36585f.getContext());
            if (UtilHelper.getRealScreenOrientation(this.f36585f.getContext()) == 2) {
                layoutParams = new RelativeLayout.LayoutParams(R2, k2);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(k2, R2);
            }
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && (videoItemData = this.h0) != null) {
                int e2 = c.a.d.f.m.b.e(videoItemData.video_height, 0);
                int e3 = c.a.d.f.m.b.e(this.h0.video_width, 0);
                if (e2 > 0 && e3 > 0 && R2 > 0 && k2 > 0) {
                    float f2 = (e2 * 1.0f) / e3;
                    if (f2 > 1.0f) {
                        layoutParams = new RelativeLayout.LayoutParams(k2, R2);
                        layoutParams.addRule(14);
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.M0 = layoutParams2;
                        layoutParams2.removeRule(13);
                        this.M0.addRule(14);
                        this.M0.topMargin = (R2 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                    } else {
                        float f3 = f2 * k2;
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(k2, (int) f3);
                        layoutParams3.topMargin = ((int) (R2 - f3)) / 2;
                        layoutParams3.addRule(14);
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
                        this.M0 = layoutParams4;
                        layoutParams4.removeRule(13);
                        this.M0.addRule(14);
                        this.M0.topMargin = (R2 - c.a.d.f.p.n.f(TbadkCoreApplication.getInst(), R.dimen.tbds166)) / 2;
                        layoutParams = layoutParams3;
                    }
                    this.B.requestLayout();
                }
            }
            return layoutParams;
        }
        return (RelativeLayout.LayoutParams) invokeV.objValue;
    }

    public void S3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || this.F0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.F0.m();
    }

    public List<String> T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    public final void T3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && c.a.d.f.p.l.x()) {
            c.a.p0.n4.h.c().f(getContext());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int U2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
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

    public boolean U3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (TiebaPlusConfigData.isHeatingSwitchOpen()) {
                int i2 = this.a;
                return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final ObjectAnimator V2(float f2, float f3, float f4, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048620, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Long.valueOf(j2)})) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.B, PropertyValuesHolder.ofFloat(AnimationProperty.OPACITY, f2), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_X, f3), PropertyValuesHolder.ofFloat(AnimationProperty.SCALE_Y, f4));
            ofPropertyValuesHolder.setDuration(j2);
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeCommon.objValue;
    }

    public final void V3() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.F0 == null) {
                this.G0 = new c.a.o0.r.t.l(getActivity());
                this.F0 = new c.a.o0.r.t.j(getPageContext(), this.G0);
                ArrayList arrayList = new ArrayList();
                c.a.o0.r.t.h hVar = new c.a.o0.r.t.h(getString(R.string.obfuscated_res_0x7f0f0a7f), this.G0);
                boolean z2 = false;
                VideoItemData videoItemData = this.h0;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    hVar.n(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f80));
                } else {
                    hVar.n(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0a7f));
                }
                hVar.m(this.E1);
                VideoItemData videoItemData2 = this.h0;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(hVar);
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
                    statisticItem.param("obj_source", U2());
                    TiebaStatic.log(statisticItem);
                }
                if (q3()) {
                    c.a.o0.r.t.h hVar2 = new c.a.o0.r.t.h(getString(R.string.obfuscated_res_0x7f0f0c74), this.G0);
                    hVar2.m(this.D1);
                    arrayList.add(hVar2);
                }
                if (!g3()) {
                    c.a.o0.r.t.h hVar3 = new c.a.o0.r.t.h(getString(R.string.obfuscated_res_0x7f0f0fa2), this.G0);
                    hVar3.m(this.F1);
                    arrayList.add(hVar3);
                }
                if (this.A0) {
                    c.a.o0.r.t.h hVar4 = new c.a.o0.r.t.h(getString(R.string.obfuscated_res_0x7f0f048e), this.G0);
                    hVar4.m(this.G1);
                    arrayList.add(hVar4);
                }
                this.G0.m(new l0(this));
                this.F0.setOnDismissListener(new m0(this));
                this.G0.j(arrayList);
            }
            S3();
        }
    }

    @Override // c.a.p0.p4.j.b.a
    public VideoItemModel W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.i0 : (VideoItemModel) invokeV.objValue;
    }

    public final void W2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            X2(null);
        }
    }

    public final boolean W3() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (c.a.p0.n4.h.c().d() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !((i2 = this.a) == 3 || i2 == 4 || TbSingleton.getInstance().isFromFeedVideoClick() || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.a;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && c.a.d.f.p.l.x() && isResumed() && this.l0) {
                c.a.d.f.p.n.O(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14df), 3000);
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

    public final void X2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, str) == null) || this.h0 == null) {
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
        createNormalCfg.setFromVideoPageUniqueId(this.f36582c);
        createNormalCfg.setForceInterceptStimeStat(true);
        createNormalCfg.setHighLight3sPostId(str);
        if (this.h0.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            if (this.h0.threadData.getAuthor() != null) {
                VideoItemData videoItemData2 = this.h0;
                if (videoItemData2.author_info != null) {
                    videoItemData2.threadData.getAuthor().setIsLike("1".equals(this.h0.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            c.a.p0.f1.l.update(this.h0.threadData);
        }
        GoPbCommentFloatListener.d();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.Q0 = true;
        VideoDanmuController videoDanmuController = this.j;
        if (videoDanmuController != null) {
            videoDanmuController.R();
            this.j.H();
        }
        f4();
        this.Y0.W(!this.Q0);
        X3();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
    }

    public void X3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
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

    public final void Y2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || (tBLottieAnimationView = this.r) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public final void Y3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048628, this) == null) || o3()) {
            return;
        }
        c.a.p0.p4.f.a aVar = this.V0;
        if (aVar != null && aVar.a() != null) {
            this.V0.a().j();
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null) {
                this.V0.v(videoItemData);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.TRUE));
        }
        int i2 = this.a;
        if (i2 == 4 || i2 == 3) {
            O3(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        }
        B2();
    }

    public final void Z2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z2) == null) {
            int f2 = c.a.d.f.p.n.f(getContext(), R.dimen.tbds26);
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
                            this.r.post(new k0(this));
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

    public final void Z3() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        ThreadData threadData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (videoItemData = this.h0) == null) {
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
        String string = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f110f);
        String string2 = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047a);
        VideoItemData videoItemData3 = this.h0;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f047b));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str5;
        shareItem.s = format;
        if (this.h0.baijiahaoData == null) {
            shareItem.R = videoItemData2.play_count;
        }
        if (this.h0.isBjhVideo) {
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
        VideoItemData videoItemData4 = this.h0;
        shareItem.X = videoItemData4.post_id;
        shareItem.f30356f = true;
        UserItemData userItemData2 = videoItemData4.author_info;
        if (userItemData2 != null) {
            shareItem.Y = userItemData2.portrait;
            shareItem.Z = userItemData2.user_name;
            shareItem.a0 = userItemData2.getUserShowName();
        }
        int i2 = this.a;
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
        if (this.h0.getVideoType() == 1) {
            shareItem.M = 2;
        } else if (this.h0.getVideoType() == 2) {
            shareItem.M = 8;
        } else if (this.h0.getVideoType() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.h0.isBjhVideo) {
            shareItem.m0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData5 = this.h0;
        originalThreadInfo.f29823c = videoItemData5.thumbnail_url;
        originalThreadInfo.a = 3;
        originalThreadInfo.f29822b = videoItemData5.title;
        originalThreadInfo.f29826f = videoItemData5.thread_id;
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
        if (this.h0.isWorksInfo()) {
            shareItem.G = 11;
        }
        if (UbsABTestHelper.isShareH5CardOptimizeABTestA() && (threadData = this.h0.threadData) != null) {
            int k2 = c.a.o0.s.g.g.k(threadData);
            UserItemData userItemData3 = this.h0.author_info;
            String str8 = userItemData3 != null ? userItemData3.name_show : "";
            shareItem.y0 = c.a.o0.s.g.g.j(this.h0.threadData, k2);
            VideoItemData videoItemData6 = this.h0;
            shareItem.z0 = c.a.o0.s.g.g.i(videoItemData6.threadData, k2, videoItemData6.forum_name, shareItem.R, str8, "");
        }
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = q3();
        shareDialogConfig.disLikeListener = this.C1;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        shareDialogConfig.setPrePage(this.D0);
        shareDialogConfig.isFromImmersionVideo = true;
        shareDialogConfig.isHost = g3();
        VideoItemData videoItemData7 = this.h0;
        shareDialogConfig.isManager = videoItemData7.is_manager;
        shareDialogConfig.isOriginManager = videoItemData7.is_origin_manager;
        shareDialogConfig.showHeating = U3();
        shareDialogConfig.isSelfHeating = this.A0;
        shareDialogConfig.heatingListener = this.B1;
        ThreadData threadData2 = this.h0.threadData;
        if (threadData2 != null) {
            shareDialogConfig.isCollected = threadData2.getIsMarked() == 1;
            shareDialogConfig.isMadeTop = this.h0.threadData.isMadeTop();
            shareDialogConfig.isAddedGood = this.h0.threadData.isAddedGood();
        }
        c.a.p0.l0.h.c().l(shareDialogConfig);
    }

    public void a3() {
        c.a.o0.r.t.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048631, this) == null) && (jVar = this.F0) != null && jVar.isShowing()) {
            this.F0.dismiss();
        }
    }

    public final void a4(boolean z2) {
        c.a.p0.p4.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048632, this, z2) == null) || (aVar = this.Z0) == null) {
            return;
        }
        aVar.c(k3());
        this.Z0.d(getPageContext(), this.h0, z2);
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && o3()) {
            this.V0.a().o();
            J2(((c.a.p0.p4.f.c) this.V0.a().n(28)).f().getText().toString());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921646, Boolean.FALSE));
            int i2 = this.a;
            if (i2 == 4 || i2 == 3) {
                O3(0);
            }
            B2();
        }
    }

    public final void b4(View view, View view2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, AnimatorListenerAdapter animatorListenerAdapter) {
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

    public final void c3(View view, View view2, View view3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, AnimatorListenerAdapter animatorListenerAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048635, this, new Object[]{view, view2, view3, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), animatorListenerAdapter}) == null) {
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
            ofInt.addUpdateListener(new x0(this, max2 - ((i4 + i5) - max2), max3 - ((i12 + i13) - max3), i4, i5, i12, i13, layoutParams, i14, i2, i3, i15, i16, i8, i9, i10, i11, view3, view));
            ofInt.addListener(animatorListenerAdapter);
            ofInt.setTarget(view);
            ofInt.start();
        }
    }

    public final void c4() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || this.h0 == null) {
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
        statisticItem.param("obj_type", U2());
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

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c.a.p0.p4.f.a aVar = (c.a.p0.p4.f.a) new c.a.p0.p4.f.b().g(getActivity(), new e0(this));
                this.V0 = aVar;
                if (aVar != null && this.h0 != null) {
                    aVar.r(getPageContext());
                    String b2 = TextUtils.isEmpty(this.h0.thread_id) ? "" : DanmuPostDraftManager.f36659b.a().b(this.h0.thread_id);
                    this.V0.s(this.h0.thread_id, this.h0.forum_id, this.h0.forum_name, b2);
                    J2(b2);
                    this.V0.t(new f0(this));
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(12);
                    ((RelativeLayout) this.f36585f).addView(this.V0.a(), layoutParams);
                }
            } finally {
                TTIStats.record("VideoPlayFragment.initEditor", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void d4(String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048638, this, str, z2) == null) {
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

    public boolean e3() {
        InterceptResult invokeV;
        ThreadData threadData;
        TiebaPlusInfo tiebaPlusInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            VideoItemData videoItemData = this.h0;
            if (videoItemData == null || (threadData = videoItemData.threadData) == null) {
                return false;
            }
            if (videoItemData.mRichAbstractList == null && threadData.getRichAbstractList() == null) {
                return false;
            }
            this.F = (TextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091a99);
            this.G = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091fe9);
            this.H = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091fe7);
            this.E = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091a13);
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.H);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            c.a.o0.r.v.b bVar = (c.a.o0.r.v.b) this.H.getBackground();
            bVar.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.H.setBackground(bVar);
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.F);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            List<PbContent> q2 = TiePlusHelper.q(this.h0.mRichAbstractList) != null ? TiePlusHelper.q(this.h0.mRichAbstractList) : null;
            if (TiePlusHelper.q(this.h0.threadData.getRichAbstractList()) != null) {
                q2 = TiePlusHelper.q(this.h0.threadData.getRichAbstractList());
            }
            PbContent pbContent = (PbContent) ListUtils.getItem(q2, 0);
            if (pbContent == null || (tiebaPlusInfo = pbContent.tiebaplus_info) == null) {
                return false;
            }
            Integer num = pbContent.type;
            Integer num2 = tiebaPlusInfo.jump_type;
            c.a.o0.e1.p.c c2 = c.a.o0.e1.p.c.c(num.intValue(), tiebaPlusInfo, this.h0.threadData);
            this.f1 = c2;
            c2.b(this.h0.threadData.statFloor);
            if (num2.intValue() != 3 && num2.intValue() != 7) {
                if (num2.intValue() == 2) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807d7));
                } else if (num2.intValue() == 6) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080802));
                } else if (num2.intValue() == 5) {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080800));
                } else {
                    this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f0807fd));
                }
            } else {
                this.G.setImageDrawable(SkinManager.getDrawable(R.drawable.obfuscated_res_0x7f080839));
            }
            this.F.setText(tiebaPlusInfo.desc);
            this.H.setVisibility(0);
            this.E.setVisibility(8);
            this.H.setOnClickListener(new v0(this));
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean e4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (o3()) {
                b3();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.a == 6 : invokeV.booleanValue;
    }

    public final void f4() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null) {
                this.N0 = this.i.getControl().getVideoStatus();
            } else {
                this.N0 = TbCyberVideoView.VideoStatus.INIT;
            }
        }
    }

    public final boolean g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.A0 : invokeV.booleanValue;
    }

    public final boolean h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.a == 8 : invokeV.booleanValue;
    }

    public final boolean i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            int i2 = this.a;
            return (i2 == 3 || i2 == 4) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (this.a == 1 && this.T0 == 0) {
                return false;
            }
            return (this.a == 7 && getActivity() != null && (getActivity() instanceof FrsVideoTabPlayActivity) && this.T0 == ((FrsVideoTabPlayActivity) getActivity()).getVideoIndex()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            int i2 = this.a;
            return i2 == 1 || i2 == 2 || TbSingleton.getInstance().isFromFeedVideoClick();
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.p0.p4.j.b.a
    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.T0 : invokeV.intValue;
    }

    public void l0(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048649, this, i2, i3, intent) == null) {
            c.a.p0.p4.f.a aVar = this.V0;
            if (aVar != null) {
                aVar.m(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                c.a.p0.k3.a.g().m(getPageContext());
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
                if (this.a == 7) {
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

    public final boolean l3(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048650, this, i2)) == null) {
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

    public final boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? f3() && !this.f36581b : invokeV.booleanValue;
    }

    public final boolean n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? m3() && g3() : invokeV.booleanValue;
    }

    public final boolean o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            c.a.p0.p4.f.a aVar = this.V0;
            return (aVar == null || aVar.a() == null || !this.V0.a().v()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, bundle) == null) {
            super.onActivityCreated(bundle);
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.H0 = forumManageModel;
            forumManageModel.setLoadDataCallBack(new i0(this));
            c.a.o0.h.a c2 = c.a.o0.h.a.c(getBaseFragmentActivity());
            this.I0 = c2;
            if (c2 != null) {
                c2.j(new j0(this));
            }
            this.J0 = new c.a.o0.s.e.a(null);
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
                W2();
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
        if (interceptable == null || interceptable.invokeIIL(1048655, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            l0(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                super.onChangeSkinType(i2);
                if (this.V0 != null && this.V0.a() != null) {
                    this.V0.a().w(i2);
                }
                if (this.G0 != null) {
                    this.G0.i();
                }
                if (this.f36585f != null) {
                    this.q0.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080834, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.r0.setImageDrawable(WebPManager.getMaskDrawable(n3() ? R.drawable.obfuscated_res_0x7f080833 : R.drawable.obfuscated_res_0x7f080835, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.A.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f080a1e, WebPManager.ResourceStateType.NORMAL_PRESS));
                    this.B.setImageDrawable(WebPManager.getMaskDrawable((int) R.drawable.obfuscated_res_0x7f0809de, WebPManager.ResourceStateType.NORMAL));
                    this.D.setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f08090d, c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0213), 0.2f), null));
                    C2();
                    c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.t0);
                    d2.n(R.string.J_X05);
                    d2.f(R.color.CAM_X0613);
                    c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.T);
                    d3.A(R.string.F_X02);
                    d3.v(R.color.CAM_X0101);
                    c.a.o0.r.v.c.d(this.U).A(R.string.F_X02);
                    c.a.o0.r.v.c d4 = c.a.o0.r.v.c.d(this.S);
                    d4.z(R.dimen.T_X09);
                    d4.A(R.string.F_X02);
                    d4.y(R.array.S_O_X001);
                    c.a.o0.r.v.c d5 = c.a.o0.r.v.c.d(this.R);
                    d5.z(R.dimen.T_X09);
                    d5.A(R.string.F_X02);
                    d5.y(R.array.S_O_X001);
                    c.a.o0.r.v.c d6 = c.a.o0.r.v.c.d(this.Q);
                    d6.z(R.dimen.T_X09);
                    d6.A(R.string.F_X02);
                    d6.y(R.array.S_O_X001);
                    c.a.o0.r.v.c d7 = c.a.o0.r.v.c.d(this.s0);
                    d7.z(R.dimen.T_X06);
                    d7.A(R.string.F_X02);
                    d7.y(R.array.S_O_X001);
                    c.a.o0.r.v.c d8 = c.a.o0.r.v.c.d(this.V);
                    d8.n(R.string.J_X01);
                    d8.z(R.dimen.T_X09);
                    d8.v(R.color.CAM_X0101);
                    d8.A(R.string.F_X02);
                    d8.f(R.color.CAM_X0302);
                    this.U.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.o0.r.v.a.a(R.string.A_X08)));
                    this.R.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.o0.r.v.a.a(R.string.A_X03)));
                    this.S.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.o0.r.v.a.a(R.string.A_X03)));
                    this.Q.setTextColor(c.a.p0.a4.c.a(SkinManager.getColor(R.color.CAM_X0101), c.a.o0.r.v.a.a(R.string.A_X03)));
                }
                WebPManager.setPureDrawable(this.n, R.drawable.obfuscated_res_0x7f0809bd, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                WebPManager.setPureDrawable(this.o, R.drawable.obfuscated_res_0x7f0809b9, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
                Y2();
            } finally {
                TTIStats.record("VideoPlayFragment.onChangeSkinType", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        c.a.p0.p4.d.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, view) == null) {
            super.onClick(view);
            if (view.getId() != R.id.obfuscated_res_0x7f092364 || (cVar = this.k) == null) {
                return;
            }
            cVar.i();
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
        if (interceptable == null || interceptable.invokeL(1048658, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.l0 && (videoItemData = this.h0) != null) {
                boolean z2 = c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(this.h0.video_width, 0);
                c.a.p0.p4.k.a aVar = this.Y0;
                if (aVar == null || !z2) {
                    return;
                }
                if (!(aVar.isFullScreen() && configuration.orientation == 1) && (this.Y0.isFullScreen() || configuration.orientation != 2)) {
                    return;
                }
                this.f36587h.removeView(this.i);
                this.Y0.U(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.s1);
            registerListener(this.J1);
            registerListener(this.K1);
            this.Z0 = new c.a.p0.p4.a();
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048660, this, layoutInflater, viewGroup, bundle)) == null) {
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
                this.f36582c = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
                this.a = arguments.getInt("current_type");
                this.f36581b = arguments.getBoolean(VideoPlayActivityConfig.IS_SHARE_THREAD, false);
            }
            VideoItemData videoItemData = this.h0;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.h0.author_info.user_id)) {
                this.A0 = true;
            }
            if (i3() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.f36585f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0886, (ViewGroup) null);
            } else {
                this.f36585f = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d088e, (ViewGroup) null);
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && ((i2 = this.a) == 1 || i2 == 7)) {
                this.f36585f.setBackground(null);
            } else {
                this.f36585f.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
            }
            this.g1 = true;
            VideoItemData videoItemData2 = this.h0;
            if (videoItemData2 != null && StringUtils.isNull(videoItemData2.video_url) && !StringUtils.isNull(this.h0.thread_id)) {
                VideoDanmuController videoDanmuController = new VideoDanmuController(getPageContext(), getUniqueId(), this.f36585f, R.id.obfuscated_res_0x7f092320, this.h0, this.a);
                this.j = videoDanmuController;
                videoDanmuController.X(new f(this));
                this.j.M();
            }
            this.f36585f.setOnTouchListener(new h(this, new GestureDetectorCompat(getContext(), new g(this))));
            this.f36585f.setOnLongClickListener(new i(this));
            TbVideoViewContainer tbVideoViewContainer2 = new TbVideoViewContainer(getContext());
            this.i = tbVideoViewContainer2;
            tbVideoViewContainer2.getControl().setStageType("2005");
            this.i.getControl().getMediaProgressObserver().j(new j(this));
            TbImageView tbImageView = (TbImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f09231e);
            this.l = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.B = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091855);
            this.C = (RelativeLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092342);
            this.D = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092341);
            this.l.setEvent(new l(this));
            this.f36587h = (RelativeLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092369);
            K3();
            this.m = this.f36585f.findViewById(R.id.obfuscated_res_0x7f0920ad);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.m.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0902f1);
            this.n = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f09143c);
            this.o = imageView2;
            imageView2.setVisibility(8);
            this.p = this.f36585f.findViewById(R.id.obfuscated_res_0x7f0918a5);
            LinearLayout linearLayout = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091a13);
            this.E = linearLayout;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(linearLayout);
            d2.e(R.string.A_X05);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            c.a.o0.r.v.b bVar = (c.a.o0.r.v.b) this.E.getBackground();
            bVar.B(SkinManager.getColor(0, (int) R.color.CAM_X0106));
            this.E.setBackground(bVar);
            this.I = (BarImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091a00);
            this.J = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0919ed);
            this.I.setShowOval(true);
            TextView textView = (TextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091a0f);
            this.K = textView;
            c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(textView);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X08);
            d3.A(R.string.F_X01);
            HeadImageView headImageView = (HeadImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0902d9);
            this.q = headImageView;
            headImageView.setDefaultResource(17170445);
            this.q.setPlaceHolder(2);
            this.q.setIsRound(true);
            this.q.setBorderWidth(R.dimen.L_X02);
            this.q.setBorderColor(R.color.CAM_X0622);
            this.q.setDrawBorder(true);
            this.q.setUseNightOrDarkMask(false);
            I3();
            this.r = (TBLottieAnimationView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0922b9);
            this.s = (TBLottieAnimationView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0902c3);
            this.X = (RelativeLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0902d7);
            this.u = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0903bb);
            this.V = (TBSpecificationBtn) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091351);
            c.a.o0.r.l0.n.a aVar = new c.a.o0.r.l0.n.a();
            UtilHelper.addFollowUserIconStyle(aVar);
            aVar.h(R.color.CAM_X0101);
            aVar.m(0, 0);
            aVar.n(0);
            aVar.k(true);
            aVar.j(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds145), c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds60));
            this.V.setConfig(aVar);
            this.V.setText(getString(R.string.obfuscated_res_0x7f0f029b));
            this.p0 = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f090151);
            this.L = (ExpandableTextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092394);
            this.M = (TextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092043);
            this.N = this.f36585f.findViewById(R.id.obfuscated_res_0x7f092042);
            this.O = this.f36585f.findViewById(R.id.obfuscated_res_0x7f092053);
            this.P = this.f36585f.findViewById(R.id.obfuscated_res_0x7f092397);
            this.k0 = (VideoMiddleNiaiControllerView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0913c0);
            this.W = (TextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092300);
            this.y = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f090682);
            this.Q = (EMTextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f09068e);
            this.q0 = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f09068c);
            this.x = (RelativeLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f090150);
            this.v = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0912f1);
            this.w = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091cb7);
            this.b1 = (RelativeLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092314);
            this.h1 = this.f36585f.findViewById(R.id.obfuscated_res_0x7f092398);
            this.i1 = this.f36585f.findViewById(R.id.obfuscated_res_0x7f092316);
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !j3() && this.n0 != null) {
                E3(8);
                TbImageView tbImageView2 = this.l;
                if (tbImageView2 != null) {
                    tbImageView2.setVisibility(8);
                }
            } else {
                E3(0);
            }
            B2();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.v.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            int i3 = this.a;
            if (i3 != 4 && i3 != 3 && !TbSingleton.getInstance().isFromFeedVideoClick()) {
                this.k0.q(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                if (i3() && UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
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
            this.R = (EMTextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f090159);
            this.r0 = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091cbe);
            this.S = (EMTextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091cca);
            this.T = (EMTextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f090832);
            this.U = (EMTextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f090834);
            this.z = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091cbe);
            this.A = (ImageView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f091cbf);
            z3();
            this.Y = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f0922ff);
            this.Z = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092302);
            this.g0 = (LinearLayout) this.f36585f.findViewById(R.id.obfuscated_res_0x7f09236d);
            this.s0 = (TextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f092311);
            this.t0 = this.f36585f.findViewById(R.id.obfuscated_res_0x7f09199e);
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                this.t0.setVisibility(0);
            } else {
                this.t0.setVisibility(8);
            }
            this.t0.setOnClickListener(new m(this));
            if (this.h0 != null) {
                this.k0.setVisibility(0);
            }
            this.k0.setPlayer(this.i.getControl());
            this.k0.setOnSeekBarChangeListener(new n(this));
            this.u0 = (TextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f09199f);
            TextView textView2 = (TextView) this.f36585f.findViewById(R.id.obfuscated_res_0x7f090826);
            this.j0 = textView2;
            textView2.setVisibility(8);
            String q2 = c.a.o0.r.j0.b.k().q("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(q2)) {
                this.j0.setText(q2);
            }
            this.j0.setOnClickListener(new o(this, c.a.o0.r.j0.b.k().q("nani_key_download_link_url", null)));
            H2();
            p pVar = new p(this);
            this.p.setOnClickListener(pVar);
            this.s0.setOnClickListener(pVar);
            this.Z.setOnClickListener(new q(this));
            this.L.setHasDown();
            this.L.setOnClickListener(new r(this));
            this.n.setOnClickListener(new s(this));
            this.o.setOnClickListener(new t(this));
            this.y.setOnClickListener(new u(this));
            this.x.setOnClickListener(new w(this));
            this.w.setOnClickListener(new x(this));
            this.V.setOnClickListener(new y(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.m0 = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.m0.setAnimationListener(new z(this));
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
                int i8 = c.a.d.f.p.n.i(this.f36585f.getContext());
                if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                    this.i.post(new a0(this, i8));
                } else {
                    this.i.post(new b0(this));
                }
            } else if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                RelativeLayout relativeLayout = this.b1;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                    this.b1.setBackground(SkinManager.getColorDrawableWithClickState(R.color.CAM_X0611));
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921665, Boolean.TRUE));
            }
            d3();
            if (this.l0) {
                O2();
            }
            VideoItemData videoItemData3 = this.h0;
            if (videoItemData3 != null && (!StringUtils.isNull(videoItemData3.video_url) || !StringUtils.isNull(this.h0.thread_id))) {
                N3(this.h0.video_url);
                if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                    VideoDanmuController videoDanmuController2 = new VideoDanmuController(getPageContext(), getUniqueId(), this.f36585f, R.id.obfuscated_res_0x7f092320, this.h0, this.a);
                    this.j = videoDanmuController2;
                    videoDanmuController2.P(this.A1);
                }
            }
            if (UbsABTestHelper.isShowVideoPlayDanmuABTest()) {
                c.a.p0.p4.d.c cVar = new c.a.p0.p4.d.c(this.f36585f, R.id.obfuscated_res_0x7f092364);
                this.k = cVar;
                cVar.g(this);
                this.k.h(new c0(this));
            }
            c.a.p0.p4.k.a aVar2 = new c.a.p0.p4.k.a(getPageContext(), getUniqueId(), this.f36587h, this.a);
            this.Y0 = aVar2;
            aVar2.setStageType("2005");
            this.Y0.setUniqueId(getUniqueId());
            VideoItemData videoItemData4 = this.h0;
            if (videoItemData4 != null && videoItemData4.threadData == null) {
                videoItemData4.threadData = new ThreadData();
                VideoItemData videoItemData5 = this.h0;
                ThreadData threadData = videoItemData5.threadData;
                threadData.tid = videoItemData5.thread_id;
                threadData.threadType = 40;
                threadData.setReply_num(c.a.d.f.m.b.e(videoItemData5.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(c.a.d.f.m.b.e(this.h0.video_width, 0));
                builder.video_height = Integer.valueOf(c.a.d.f.m.b.e(this.h0.video_height, 0));
                VideoItemData videoItemData6 = this.h0;
                builder.video_url = videoItemData6.video_url;
                builder.thumbnail_url = videoItemData6.thumbnail_url;
                builder.video_md5 = videoItemData6.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData6.isVerticalVideo);
                this.h0.threadData.setVideoInfo(builder.build(true));
            }
            VideoItemData videoItemData7 = this.h0;
            if (videoItemData7 != null) {
                M3(videoItemData7, this.Y0, this.j);
            }
            if (TbSingleton.getInstance().isEnableVideoVerticalPreload()) {
                if (UbsABTestHelper.isVideoSetUrlAgainABTest()) {
                    c.a.d.f.m.e.a().post(this.n1);
                } else if (this.T0 != 0) {
                    c.a.d.f.m.e.a().post(this.n1);
                }
            }
            return this.f36585f;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            if (!this.j1) {
                stopPlay();
            }
            if (!getActivity().isFinishing() && (tbVideoViewContainer = this.i) != null && (tbVideoViewContainer.getControl() instanceof TbVideoView) && (this.i.getControl().getPlayer() instanceof c.a.p0.c3.o)) {
                ((c.a.p0.c3.o) this.i.getControl().getPlayer()).release();
            }
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.s1);
            MessageManager.getInstance().unRegisterListener(this.J1);
            MessageManager.getInstance().unRegisterListener(this.K1);
            if (this.H1 != null) {
                c.a.d.f.m.e.a().removeCallbacks(this.H1);
                this.H1 = null;
            }
            c.a.p0.p4.a aVar = this.Z0;
            if (aVar != null) {
                aVar.b();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.n1);
            getLifecycle().removeObserver(this.y1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048662, this) == null) {
            super.onDestroyView();
            VideoDanmuController videoDanmuController = this.j;
            if (videoDanmuController != null) {
                videoDanmuController.T();
            }
            c.a.p0.p4.d.c cVar = this.k;
            if (cVar != null) {
                cVar.f();
            }
            c.a.p0.p4.k.a aVar = this.Y0;
            if (aVar != null) {
                aVar.F0();
            }
            c.a.p0.p4.f.a aVar2 = this.V0;
            if (aVar2 != null) {
                aVar2.n();
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
            View view = this.t0;
            if (view != null) {
                view.setOnClickListener(null);
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
            View view2 = this.p;
            if (view2 != null) {
                view2.setOnClickListener(null);
            }
            c.a.d.f.m.e.a().removeCallbacks(this.n1);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048663, this) == null) {
            super.onPause();
            if (!this.Q0) {
                u3();
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition() && !j3() && getActivity().isFinishing() && this.n0 != null) {
                K2();
                this.j1 = true;
            }
            b3();
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
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            super.onPrimary();
            if (isResumed() && this.l0) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.h0;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.l0) {
                        y3();
                        A3();
                        x3(0);
                    } else {
                        u3();
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
            u3();
            b3();
            this.g1 = true;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048665, this) == null) {
            super.onResume();
            if (this.c1) {
                this.c1 = false;
                c.a.d.f.m.e.a().removeCallbacks(this.n1);
                x3(1);
                startPlay();
                O2();
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
        if (interceptable == null || interceptable.invokeV(1048666, this) == null) {
            super.onStart();
            if (this.Q0) {
                A3();
            }
        }
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void onStatusChange(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PREPARED) {
                J3();
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.C;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2 = this.k0;
                if (videoMiddleNiaiControllerView2 != null) {
                    videoMiddleNiaiControllerView2.setLoading(false);
                }
                m1 m1Var = this.X0;
                if (m1Var != null) {
                    m1Var.onStart();
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
                    E3(0);
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
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView = this.k0) != null) {
                videoMiddleNiaiControllerView.setLoading(false);
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.k0 != null && this.l0 && isResumed()) {
                this.k0.setLoading(true);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048668, this) == null) {
            super.onStop();
            u3();
            b3();
            c.a.d.f.m.e.a().removeCallbacks(this.n1);
        }
    }

    @Override // c.a.o0.e1.r.b.InterfaceC0807b
    public void onViewClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048669, this) == null) {
            if (o3()) {
                b3();
                return;
            }
            TbVideoViewContainer tbVideoViewContainer = this.i;
            if (tbVideoViewContainer == null || tbVideoViewContainer.getControl() == null || !this.i.getControl().l()) {
                return;
            }
            if (this.i.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.i.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                if (this.i.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PAUSING || W3()) {
                    return;
                }
                this.i.getControl().start();
                this.B.setVisibility(8);
                F2(true);
                this.k0.p();
                if (isResumed() && this.l0) {
                    return;
                }
                u3();
                return;
            }
            this.i.getControl().pause();
            G3();
            F2(false);
            c.a.d.f.m.e.a().removeCallbacks(this.H1);
            P2(4);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048670, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            H2();
            L3();
        }
    }

    @Override // c.a.o0.e1.r.b.InterfaceC0807b
    public void onViewDragToRight() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048671, this) == null) || m3() || o3() || (videoItemData = this.h0) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long g2 = c.a.d.f.m.b.g(userItemData.user_id, 0L);
        long g3 = c.a.d.f.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L);
        int i2 = 1;
        boolean z2 = (g2 == 0 && g3 == 0) ? false : g2 == g3;
        c.a.p0.p4.e.a.a();
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

    public final boolean p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (UbsABTestHelper.isVideoTabAuthorABTest() && l3(1)) {
                return true;
            }
            if (UbsABTestHelper.isVideoMiddleAuthorABTest() && l3(2)) {
                return true;
            }
            return UbsABTestHelper.isVideoMiddleAndTabAuthorABTest() && l3(3);
        }
        return invokeV.booleanValue;
    }

    public boolean q3() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            VideoItemData videoItemData = this.h0;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.a != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean r3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            int i2 = this.a;
            return i2 == 4 || i2 == 3;
        }
        return invokeV.booleanValue;
    }

    public final boolean s3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            TbCyberVideoView.VideoStatus videoStatus = this.N0;
            return videoStatus == TbCyberVideoView.VideoStatus.INIT || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PREPARED || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        c.a.o0.e1.p.c cVar;
        TbVideoViewContainer tbVideoViewContainer;
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.l0 = z2;
            if (this.Y0 != null && (videoItemData = this.h0) != null) {
                this.Y0.W(this.l0 && (c.a.d.f.m.b.e(videoItemData.video_height, 0) <= c.a.d.f.m.b.e(this.h0.video_width, 0)));
            }
            if (!isResumed() && this.l0 && s3()) {
                this.c1 = true;
            }
            if (isResumed() && this.l0 && (!this.R0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                x3(1);
                startPlay();
                O2();
                this.R0 = false;
            } else if (!this.Q0) {
                z3();
                this.S0 = 1;
                u3();
                e4();
            }
            if (this.k0 != null) {
                if (this.l0 && isResumed() && (tbVideoViewContainer = this.i) != null && tbVideoViewContainer.getControl() != null && this.i.getControl().getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                    this.k0.setLoading(true);
                } else {
                    this.k0.setLoading(false);
                }
            }
            if (!this.l0 || this.e1 || (cVar = this.f1) == null || this.d1 == null) {
                return;
            }
            cVar.q(TiePlusStat.StatType.EXPOSE);
            this.d1.g(this.f1);
            this.e1 = true;
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048677, this) == null) || W3()) {
            return;
        }
        T3();
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbVideoViewContainer tbVideoViewContainer = this.i;
        if (tbVideoViewContainer != null && tbVideoViewContainer.getControl() != null && this.B != null && this.h0 != null && this.i.getParent() == null) {
            K3();
            L3();
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
            y3();
        }
        if (this.Q0) {
            return;
        }
        if ((isResumed() && this.l0) || s3()) {
            return;
        }
        u3();
        VideoDanmuController videoDanmuController2 = this.j;
        if (videoDanmuController2 != null) {
            videoDanmuController2.R();
        }
        if (this.B != null) {
            G3();
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

    public final void t3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048679, this) == null) && TbSingleton.getInstance().isFromFeedVideoClick()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921612));
        }
    }

    public final void u3() {
        TbVideoViewContainer tbVideoViewContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048680, this) == null) || (tbVideoViewContainer = this.i) == null || tbVideoViewContainer.getControl() == null) {
            return;
        }
        this.i.getControl().q();
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            if (o3()) {
                b3();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v3() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048682, this) == null) || (tBLottieAnimationView = this.s) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(0);
        SkinManager.setLottieAnimation(this.s, R.raw.obfuscated_res_0x7f110052);
        if (this.s.isAnimating()) {
            return;
        }
        this.s.setSpeed(1.1f);
        this.s.playAnimation();
    }

    public final void w3(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048683, this, i2, i3) == null) {
            VideoItemData videoItemData = this.h0;
            if (!(videoItemData == null && videoItemData.video_url == null) && i2 > this.h0.video_duration * 1000) {
                this.g1 = false;
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_FROM_VIDEO_MIDDLE_PTS);
                statisticItem.param("obj_id", this.h0.video_url);
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public final void x3(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048684, this, i2) == null) && this.h0 != null && this.n0 == null) {
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

    public final void y3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048685, this) == null) || this.h0 == null) {
            return;
        }
        c.a.p0.c3.u uVar = new c.a.p0.c3.u();
        uVar.a = "nani_midpage";
        VideoItemData videoItemData = this.h0;
        uVar.f13504c = videoItemData.thread_id;
        uVar.t = videoItemData.nid;
        uVar.f13505d = this.h0.forum_id + "";
        uVar.f13506e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.h0;
        uVar.f13507f = videoItemData2.mRecomSource;
        uVar.f13508g = videoItemData2.mRecomAbTag;
        uVar.f13509h = videoItemData2.mRecomWeight;
        uVar.i = "";
        uVar.k = "";
        uVar.m = videoItemData2.mMd5;
        uVar.x = videoItemData2.getChannelMidRequestNum();
        uVar.y = this.h0.getChannelMidRequestVideoNum();
        if (this.n0 != null) {
            uVar.n = "1";
        } else {
            uVar.n = "2";
        }
        int i2 = this.a;
        if (i2 == 1 || i2 == 2) {
            uVar.p = "1";
            uVar.a = "auto_midpage";
            uVar.i = "index";
        }
        c.a.p0.c3.j.e(this.h0.mMd5, "", "1", uVar, this.i.getControl().getPcdnState());
        int i3 = this.a;
        if (i3 == 1 || i3 == 3) {
            c.a.p0.p4.c.e.c(this.h0.mMd5);
        } else if (i3 == 2 || i3 == 4) {
            c.a.p0.p4.c.e.a(this.h0.mMd5);
        } else if (i3 == 7) {
            c.a.p0.p4.c.e.b(this.h0.mMd5);
        }
    }

    public final void z3() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || this.A == null || (imageView = this.z) == null) {
            return;
        }
        imageView.clearAnimation();
        this.A.clearAnimation();
        this.z.setVisibility(0);
        this.A.setVisibility(8);
    }
}
