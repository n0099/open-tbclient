package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
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
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
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
import com.baidu.tieba.view.expandable.ExpandableTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.b1.p.a;
import d.a.o0.h.a;
import d.a.o0.r.q.b2;
import d.a.o0.r.s.a;
import d.a.o0.r.s.l;
import d.a.p0.n2.f;
import d.a.p0.x3.e.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes4.dex */
public class VideoPlayFragment extends BaseFragment implements a.b, d.a.p0.x3.g.a.a, TbCyberVideoView.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;
    public boolean A0;
    public BarImageView B;
    public RelativeLayout.LayoutParams B0;
    public TextView C;
    public String C0;
    public ExpandableTextView D;
    public boolean D0;
    public TextView E;
    public TBLottieAnimationView E0;
    public View F;
    public boolean F0;
    public View G;
    public int G0;
    public EMTextView H;
    public int H0;
    public EMTextView I;
    public d.a.p0.x3.f.a I0;
    public EMTextView J;
    public d.a.p0.x3.e.a J0;
    public EMTextView K;
    public f.c K0;
    public EMTextView L;
    public p0 L0;
    public EMTextView M;
    public d.a.p0.x3.a M0;
    public EMTextView N;
    public CustomMessageListener N0;
    public TextView O;
    public final CustomMessageListener O0;
    public View P;
    public CustomMessageListener P0;
    public LinearLayout Q;
    public View.OnClickListener Q0;
    public LinearLayout R;
    public l.d R0;
    public LinearLayout S;
    public l.d S0;
    public VideoItemData T;
    public l.d T0;
    public VideoItemModel U;
    public l.d U0;
    public TextView V;
    public Runnable V0;
    public VideoMiddleNiaiControllerView W;
    public CyberPlayerManager.OnInfoListener W0;
    public boolean X;
    public CyberPlayerManager.OnCompletionListener X0;
    public AlphaAnimation Y;
    public CyberPlayerManager.OnPreparedListener Y0;
    public Rect Z;
    public ImageView a0;
    public ImageView b0;
    public ImageView c0;

    /* renamed from: e  reason: collision with root package name */
    public int f21782e;

    /* renamed from: f  reason: collision with root package name */
    public int f21783f;

    /* renamed from: g  reason: collision with root package name */
    public View f21784g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f21785h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21786i;
    public TextView i0;
    public View j;
    public View j0;
    public ImageView k;
    public TextView k0;
    public ImageView l;
    public RelativeLayout.LayoutParams l0;
    public View m;
    public int m0;
    public HeadImageView n;
    public int n0;
    public TBLottieAnimationView o;
    public boolean o0;
    public boolean p;
    public int p0;
    public LinearLayout q;
    public String q0;
    public LinearLayout r;
    public String r0;
    public LinearLayout s;
    public String s0;
    public LinearLayout t;
    public d.a.o0.r.s.j t0;
    public LinearLayout u;
    public d.a.o0.r.s.l u0;
    public ImageView v;
    public ForumManageModel v0;
    public ImageView w;
    public d.a.o0.h.a w0;
    public ImageView x;
    public d.a.o0.s.e.a x0;
    public RelativeLayout y;
    public BdUniqueId y0;
    public ImageView z;
    public String z0;

    /* loaded from: classes4.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21787e;

        public a(VideoPlayFragment videoPlayFragment) {
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
            this.f21787e = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f21787e.K1(true);
                EMTextView eMTextView = this.f21787e.K;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = this.f21787e.L;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.f21787e.f21785h.getDuration()));
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
                statisticItem.param("tid", this.f21787e.T.thread_id);
                statisticItem.param("fid", this.f21787e.T.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.f21787e.r0)) {
                    statisticItem.param("obj_type", 1);
                } else {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_type", this.f21787e.P1());
                if (!"a088".equals(this.f21787e.s0)) {
                    if ("a089".equals(this.f21787e.s0)) {
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
                this.f21787e.D0 = true;
                if (this.f21787e.W != null) {
                    this.f21787e.W.setBottomBarShow(false, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.f21787e.r0) ? 1 : 0);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f21787e.D0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(null);
                    this.f21787e.K1(false);
                    if (!this.f21787e.f21785h.isPlaying()) {
                        this.f21787e.f21785h.start();
                        this.f21787e.x.setVisibility(8);
                    }
                    if (!this.f21787e.isResumed() || !this.f21787e.X) {
                        this.f21787e.Z1();
                    }
                    d.a.c.e.m.e.a().postDelayed(this.f21787e.V0, 3000L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21788a;

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
            this.f21788a = videoPlayFragment;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21788a.t0.dismiss();
                if (ViewHelper.checkUpIsLogin(this.f21788a.getActivity()) && (videoItemData = (videoPlayFragment = this.f21788a).T) != null) {
                    String str = videoItemData.thread_id;
                    String str2 = videoItemData.forum_id;
                    String string = videoPlayFragment.getResources().getString(R.string.web_view_report_title);
                    String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + this.f21788a.T.post_id;
                    VideoItemData videoItemData2 = this.f21788a.T;
                    if (videoItemData2.isBjhVideo) {
                        str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                        string = "";
                    }
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f21788a.getPageContext().getPageActivity(), string, str3, true);
                    if (this.f21788a.T.isBjhVideo) {
                        tbWebViewActivityConfig.setFixTitle(true);
                    }
                    this.f21788a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21790f;

        public b(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f21790f = videoPlayFragment;
            this.f21789e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f21789e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(this.f21790f.getPageContext().getPageActivity()), new String[]{this.f21789e}, true);
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21791a;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.r.s.a f21792e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b0 f21793f;

            public a(b0 b0Var, d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21793f = b0Var;
                this.f21792e = aVar;
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21792e.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f21793f.f21791a;
                    if (videoPlayFragment.T != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.v0;
                        VideoPlayFragment videoPlayFragment2 = this.f21793f.f21791a;
                        VideoItemData videoItemData = videoPlayFragment2.T;
                        forumManageModel.R(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.o0, null);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.o0.r.s.a f21794e;

            public b(b0 b0Var, d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {b0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21794e = aVar;
            }

            @Override // d.a.o0.r.s.a.e
            public void onClick(d.a.o0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21794e.dismiss();
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
            this.f21791a = videoPlayFragment;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21791a.t0.dismiss();
                d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(this.f21791a.getActivity());
                VideoItemData videoItemData = this.f21791a.T;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(R.string.del_thread_confirm);
                }
                aVar.setPositiveButton(R.string.dialog_ok, new a(this, aVar));
                aVar.setNegativeButton(R.string.dialog_cancel, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.f21791a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21795e;

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
            this.f21795e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.portrait_container && (videoItemData = this.f21795e.T) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.f21795e;
                    if (videoPlayFragment.T.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.f21795e.T.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.f21795e.T.getThreadId());
                        UserItemData userItemData2 = this.f21795e.T.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.f21795e.T.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.f21795e.T;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null || StringUtils.isNull(userItemData.user_id)) {
                    return;
                }
                long f2 = d.a.c.e.m.b.f(this.f21795e.T.author_info.user_id, 0L);
                long f3 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = f2 == f3;
                if (f2 == 0 && f3 == 0) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f21795e.getActivity()).createNormalConfig(f2, z, false)));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.f21795e.T.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.f21795e.M1(5);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21796a;

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
            this.f21796a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21796a.T.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21797e;

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
            this.f21797e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f21797e).T) == null || videoItemData.act_info == null) {
                return;
            }
            d.a.o0.l.a.k(videoPlayFragment.getActivity(), this.f21797e.T.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.f21797e.T.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21798a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f21798a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.p0.h3.h0.e)) {
                AgreeData agreeData = ((d.a.p0.h3.h0.e) customResponsedMessage.getData()).f57972b;
                if (this.f21798a.T == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.f21798a.T.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f21798a.T.agree_num = String.valueOf(agreeData.agreeNum);
                    this.f21798a.T.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.f21798a.C1();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f21798a.T.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f21798a.T.agree_num = String.valueOf(agreeData.agreeNum);
                this.f21798a.T.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.f21798a.C1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21799e;

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
            this.f21799e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21799e.Q1(false);
                this.f21799e.M1(7);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21800e;

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
            this.f21800e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21800e.D0) {
                return;
            }
            this.f21800e.E1(true);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21801e;

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
            this.f21801e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21802e;

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
            this.f21802e = videoPlayFragment;
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
                VideoPlayFragment videoPlayFragment = this.f21802e;
                View view = videoPlayFragment.f21784g;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).removeView(videoPlayFragment.E0);
                }
                this.f21802e.A0 = false;
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
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21803e;

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
            this.f21803e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.f21803e.T;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.f21803e.T.thread_id));
                }
                this.f21803e.getActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21804e;

        public g0(VideoPlayFragment videoPlayFragment) {
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
            this.f21804e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f21804e.X && ((i2 == 3 || i2 == 904) && this.f21804e.f21786i.getVisibility() == 0)) {
                    this.f21804e.f21786i.clearAnimation();
                    this.f21804e.f21786i.startAnimation(this.f21804e.Y);
                }
                if (i2 != 10012 || this.f21804e.I0 == null) {
                    return true;
                }
                this.f21804e.I0.c();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21805e;

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
            this.f21805e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21805e.n2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21806e;

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
            this.f21806e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f21806e.f21785h) == null) {
                return;
            }
            tbCyberVideoView.Q();
            this.f21806e.f21785h.seekTo(0);
            this.f21806e.f21785h.start();
            this.f21806e.b2();
            VideoPlayFragment.v1(this.f21806e);
            if (this.f21806e.G0 == 3) {
                this.f21806e.F1();
            }
            if (this.f21806e.isResumed() && this.f21806e.X) {
                return;
            }
            this.f21806e.Z1();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21807e;

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
            this.f21807e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.f21807e.getPageContext(), this.f21807e.T)) {
                return;
            }
            this.f21807e.Q1(true);
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.f21807e.T.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.f21807e.M1(2);
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21808e;

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
            this.f21808e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f21808e.f21785h) == null) {
                return;
            }
            tbCyberVideoView.setVolume(1.0f, 1.0f);
            if (this.f21808e.W != null) {
                this.f21808e.W.setVisibility(0);
                if (this.f21808e.W.getCurProgress() == 0) {
                    this.f21808e.W.s();
                    return;
                }
                return;
            }
            this.f21808e.W.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21809e;

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
            this.f21809e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f21809e;
                videoPlayFragment.J1(videoPlayFragment.f21782e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21810e;

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
            this.f21810e = videoPlayFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f21810e.N(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                this.f21810e.k();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21811a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f21811a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = this.f21811a.T;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.f21811a.T.author_info.user_id.equals(data.f12819c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.f21811a.y0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.f12817a) {
                    if (!z || "0".equals(this.f21811a.T.author_info.is_follow)) {
                        return;
                    }
                    d.a.c.e.p.l.L(this.f21811a.getActivity(), R.string.attention_fail);
                    VideoPlayFragment videoPlayFragment = this.f21811a;
                    videoPlayFragment.T.author_info.is_follow = "0";
                    videoPlayFragment.D1();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.f21811a;
                    videoPlayFragment2.T.author_info.is_follow = "0";
                    videoPlayFragment2.D1();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.f21811a.T));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.f21811a;
                    videoPlayFragment3.T.author_info.is_follow = "1";
                    videoPlayFragment3.D1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.f21811a.r0)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f21812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21813f;

        public k0(VideoPlayFragment videoPlayFragment, GestureDetectorCompat gestureDetectorCompat) {
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
            this.f21813f = videoPlayFragment;
            this.f21812e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f21812e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21814e;

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
            this.f21814e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21814e.p2();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.f21814e.T.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f21814e.M1(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.f21814e.T.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.f21814e.T.nid);
                BaijiahaoData baijiahaoData = this.f21814e.T.baijiahaoData;
                if (baijiahaoData != null && !d.a.c.e.p.k.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.f21814e.T.baijiahaoData.oriUgcVid);
                }
                if (this.f21814e.T.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.f21814e.T.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.f21814e.T.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.f21814e.T.mRecomSource);
                statisticItem2.param("ab_tag", this.f21814e.T.mRecomAbTag);
                statisticItem2.param("weight", this.f21814e.T.mRecomWeight);
                statisticItem2.param("extra", this.f21814e.T.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (d.a.o0.j0.c.j(this.f21814e.getBaseFragmentActivity()) != null && d.a.o0.j0.c.j(this.f21814e.getBaseFragmentActivity()).a() != null && d.a.o0.j0.c.j(this.f21814e.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(d.a.o0.j0.c.j(this.f21814e.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21815e;

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
            this.f21815e = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21815e.n2();
                this.f21815e.f21784g.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21816e;

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
            this.f21816e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f21816e.getActivity())) {
                VideoPlayFragment videoPlayFragment = this.f21816e;
                if (videoPlayFragment.M != null && (videoItemData = videoPlayFragment.T) != null && videoItemData.author_info != null && videoPlayFragment.N != null) {
                    d.a.o0.s.e.a aVar = videoPlayFragment.x0;
                    VideoPlayFragment videoPlayFragment2 = this.f21816e;
                    UserItemData userItemData = videoPlayFragment2.T.author_info;
                    aVar.m(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.y0, this.f21816e.T.forum_id, "0");
                    VideoPlayFragment videoPlayFragment3 = this.f21816e;
                    videoPlayFragment3.T.author_info.is_follow = "1";
                    videoPlayFragment3.D1();
                    this.f21816e.M.setVisibility(8);
                    this.f21816e.N.setVisibility(0);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setStartOffset(1000L);
                    scaleAnimation.setDuration(300L);
                    scaleAnimation.setFillAfter(true);
                    this.f21816e.N.startAnimation(scaleAnimation);
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.f21816e.r0)) {
                    statisticItem.param("obj_locate", 1);
                } else {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_source", this.f21816e.P1());
                }
                statisticItem.param("tid", this.f21816e.T.thread_id);
                statisticItem.param("fid", this.f21816e.T.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f21816e.M1(6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21817e;

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
            this.f21817e = videoPlayFragment;
        }

        @Override // d.a.p0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f21817e.K0 == null) {
                return;
            }
            this.f21817e.K0.a(i2, i3);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21818a;

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
            this.f21818a = videoPlayFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f21818a.f21786i == null) {
                return;
            }
            this.f21818a.f21786i.setVisibility(8);
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
    public class n0 implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21819a;

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
            this.f21819a = videoPlayFragment;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f21819a.y.setVisibility(8);
                this.f21819a.f21785h.setCanShowPause(true);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21820e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ o f21821e;

            public a(o oVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {oVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21821e = oVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21821e.f21820e.isResumed() && this.f21821e.f21820e.X) {
                    this.f21821e.f21820e.startPlay();
                    this.f21821e.f21820e.Z = null;
                }
            }
        }

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
            this.f21820e = videoPlayFragment;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00ad  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int i2;
            int i3;
            float f2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = this.f21820e.f21786i.getWidth();
                int height = this.f21820e.f21786i.getHeight();
                if (height > 0 && width > 0) {
                    if (d.a.c.e.m.b.d(this.f21820e.T.video_height, 0) > 0 && d.a.c.e.m.b.d(this.f21820e.T.video_width, 0) > 0) {
                        float f3 = width;
                        float f4 = height;
                        float f5 = f3 / f4;
                        float c2 = d.a.c.e.m.b.c(this.f21820e.T.video_width, 0.0f) / d.a.c.e.m.b.c(this.f21820e.T.video_height, 0.0f);
                        if (c2 > 0.0f && Math.abs(c2 - f5) > 0.05d) {
                            if (c2 > f5) {
                                i3 = (int) (f3 / c2);
                                i2 = width;
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f21820e.m0, this.f21820e.n0);
                                layoutParams.leftMargin = this.f21820e.Z.left;
                                layoutParams.topMargin = this.f21820e.Z.top;
                                this.f21820e.f21786i.setLayoutParams(layoutParams);
                                float f6 = 1.0f;
                                if (this.f21820e.n0 > 0 || this.f21820e.m0 <= 0) {
                                    f2 = 1.0f;
                                } else {
                                    f6 = i3 / this.f21820e.n0;
                                    f2 = i2 / this.f21820e.m0;
                                }
                                this.f21820e.f21786i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f6).scaleX(f2).translationX((width / 2.0f) - (this.f21820e.Z.left + ((this.f21820e.Z.right - this.f21820e.Z.left) / 2))).translationY((height / 2.0f) - (this.f21820e.Z.top + ((this.f21820e.Z.bottom - this.f21820e.Z.top) / 2))).start();
                                this.f21820e.f21786i.postDelayed(new a(this), 200L);
                            }
                            i2 = (int) (f4 * c2);
                            i3 = height;
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f21820e.m0, this.f21820e.n0);
                            layoutParams2.leftMargin = this.f21820e.Z.left;
                            layoutParams2.topMargin = this.f21820e.Z.top;
                            this.f21820e.f21786i.setLayoutParams(layoutParams2);
                            float f62 = 1.0f;
                            if (this.f21820e.n0 > 0) {
                            }
                            f2 = 1.0f;
                            this.f21820e.f21786i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f62).scaleX(f2).translationX((width / 2.0f) - (this.f21820e.Z.left + ((this.f21820e.Z.right - this.f21820e.Z.left) / 2))).translationY((height / 2.0f) - (this.f21820e.Z.top + ((this.f21820e.Z.bottom - this.f21820e.Z.top) / 2))).start();
                            this.f21820e.f21786i.postDelayed(new a(this), 200L);
                        }
                    }
                }
                i2 = width;
                i3 = height;
                RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(this.f21820e.m0, this.f21820e.n0);
                layoutParams22.leftMargin = this.f21820e.Z.left;
                layoutParams22.topMargin = this.f21820e.Z.top;
                this.f21820e.f21786i.setLayoutParams(layoutParams22);
                float f622 = 1.0f;
                if (this.f21820e.n0 > 0) {
                }
                f2 = 1.0f;
                this.f21820e.f21786i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f622).scaleX(f2).translationX((width / 2.0f) - (this.f21820e.Z.left + ((this.f21820e.Z.right - this.f21820e.Z.left) / 2))).translationY((height / 2.0f) - (this.f21820e.Z.top + ((this.f21820e.Z.bottom - this.f21820e.Z.top) / 2))).start();
                this.f21820e.f21786i.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21822e;

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
            this.f21822e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f21822e;
                if (videoPlayFragment.H1(videoPlayFragment.getPageContext(), 11001)) {
                    this.f21822e.j0.setVisibility(8);
                    if (this.f21822e.J0 != null && this.f21822e.J0.a() != null) {
                        this.f21822e.J0.a().j();
                        VideoPlayFragment videoPlayFragment2 = this.f21822e;
                        if (videoPlayFragment2.T != null) {
                            videoPlayFragment2.J0.w(this.f21822e.T);
                        }
                    }
                    if (this.f21822e.T != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.f21822e.T.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.f21822e.T.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21823e;

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
            this.f21823e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = this.f21823e.f21786i.getWidth();
                int height = this.f21823e.f21786i.getHeight();
                if (height <= 0 || width <= 0 || (videoItemData = this.f21823e.T) == null) {
                    return;
                }
                if (d.a.c.e.m.b.d(videoItemData.video_height, 0) <= 0 || d.a.c.e.m.b.d(this.f21823e.T.video_width, 0) <= 0) {
                    return;
                }
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                float c2 = d.a.c.e.m.b.c(this.f21823e.T.video_width, 0.0f) / d.a.c.e.m.b.c(this.f21823e.T.video_height, 0.0f);
                if (c2 > 0.0f && Math.abs(c2 - f4) > 0.05d) {
                    if (c2 > f4) {
                        height = (int) (f2 / c2);
                    } else {
                        width = (int) (f3 * c2);
                    }
                }
                ViewGroup.LayoutParams layoutParams = this.f21823e.f21786i.getLayoutParams();
                layoutParams.height = height;
                layoutParams.width = width;
                this.f21823e.f21786i.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface p0 {
        void onStart();
    }

    /* loaded from: classes4.dex */
    public class q implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21824a;

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
            this.f21824a = videoPlayFragment;
        }

        @Override // d.a.p0.x3.e.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21824a.j0.setVisibility(8);
                if (z) {
                    this.f21824a.k0.setText(R.string.reply_something);
                } else {
                    this.f21824a.k0.setText(StringUtils.isNull(((d.a.p0.x3.e.c) this.f21824a.J0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                }
                VideoItemData videoItemData = this.f21824a.T;
                if (videoItemData == null || !z) {
                    return;
                }
                long f2 = d.a.c.e.m.b.f(videoItemData.comment_num, 0L) + 1;
                this.f21824a.T.comment_num = String.valueOf(f2);
                this.f21824a.H.setText(StringHelper.numberUniformFormatExtraWithRoundVote(f2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21825a;

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
            this.f21825a = videoPlayFragment;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.f21825a.v0.getLoadDataMode() == 0) {
                this.f21825a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements a.InterfaceC1192a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21826a;

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
            this.f21826a = videoPlayFragment;
        }

        @Override // d.a.o0.h.a.InterfaceC1192a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f21826a.w0 != null) {
                        this.f21826a.w0.h(z2);
                    }
                    VideoItemData videoItemData = this.f21826a.T;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.f21826a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.f21826a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.f21826a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21827e;

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
            this.f21827e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21827e.o.playAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class u implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21828a;

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
            this.f21828a = videoPlayFragment;
        }

        @Override // d.a.o0.r.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21828a.V1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21829a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f21829a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.f21829a.isResumed() && this.f21829a.X) {
                if (d.a.c.e.p.j.z()) {
                    if (this.f21829a.o2()) {
                        return;
                    }
                    this.f21829a.startPlay();
                    return;
                }
                d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21830e;

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
            this.f21830e = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f21830e.t0 = null;
                this.f21830e.u0 = null;
                if (TbSingleton.getInstance().isNotchScreen(this.f21830e.getActivity())) {
                    return;
                }
                TbSingleton.getInstance().isCutoutScreen(this.f21830e.getActivity());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21831e;

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
            this.f21831e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21831e.q2(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21832a;

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
            this.f21832a = videoPlayFragment;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f21832a.t0 != null) {
                    this.f21832a.t0.dismiss();
                }
                this.f21832a.q2(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21833a;

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
            this.f21833a = videoPlayFragment;
        }

        @Override // d.a.o0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f21833a.getContext())) {
                    if (this.f21833a.t0 != null) {
                        this.f21833a.t0.dismiss();
                        return;
                    }
                    return;
                }
                if (this.f21833a.t0 != null) {
                    this.f21833a.t0.dismiss();
                }
                VideoItemData videoItemData = this.f21833a.T;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.f21833a.T.thread_id);
                markData.setPostId(this.f21833a.T.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.f21833a.T.thread_id);
                markData.setForumId(this.f21833a.T.forum_id);
                if (this.f21833a.w0 != null) {
                    this.f21833a.w0.i(markData);
                    if (!z) {
                        this.f21833a.w0.a();
                    } else {
                        this.f21833a.w0.d();
                    }
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
        this.f21782e = 0;
        this.f21783f = 1;
        this.p = false;
        this.v0 = null;
        this.w0 = null;
        this.x0 = null;
        this.y0 = BdUniqueId.gen();
        this.A0 = false;
        this.F0 = false;
        this.G0 = 1;
        this.H0 = -1;
        this.N0 = new k(this, 2001115);
        this.O0 = new v(this, 2000994);
        this.P0 = new d0(this, 2016528);
        this.Q0 = new x(this);
        this.R0 = new y(this);
        this.S0 = new z(this);
        this.T0 = new a0(this);
        this.U0 = new b0(this);
        this.V0 = new e0(this);
        this.W0 = new g0(this);
        this.X0 = new h0(this);
        this.Y0 = new i0(this);
    }

    public static /* synthetic */ int v1(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.G0;
        videoPlayFragment.G0 = i2 + 1;
        return i2;
    }

    public final void C1() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoItemData = this.T) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.a0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.a0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.I.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.T.agree_num, 0L)));
    }

    public final void D1() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.o0 && ((userItemData = this.T.author_info) == null || !"1".equals(userItemData.is_follow))) {
                this.M.setVisibility(0);
                this.M.setClickable(true);
                this.N.setVisibility(8);
                return;
            }
            this.M.setVisibility(4);
            this.M.setClickable(false);
            this.N.setVisibility(8);
        }
    }

    public final void E1(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) || (videoMiddleNiaiControllerView = this.W) == null) {
            return;
        }
        videoMiddleNiaiControllerView.setBottomBarShow(z2, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0) ? 1 : 0);
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.w == null || this.v == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        this.v.clearAnimation();
        this.w.clearAnimation();
        this.v.setVisibility(8);
        this.w.setVisibility(0);
        this.w.startAnimation(scaleAnimation2);
        this.v.startAnimation(scaleAnimation);
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void G0(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.y;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView3 = this.W;
                if (videoMiddleNiaiControllerView3 != null) {
                    videoMiddleNiaiControllerView3.setLoading(false);
                }
                p0 p0Var = this.L0;
                if (p0Var != null) {
                    p0Var.onStart();
                }
                TbImageView tbImageView = this.f21786i;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView2 = this.W) != null) {
                videoMiddleNiaiControllerView2.setLoading(false);
            }
            if (videoStatus != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || (videoMiddleNiaiControllerView = this.W) == null) {
                return;
            }
            videoMiddleNiaiControllerView.setLoading(true);
        }
    }

    public final void G1() {
        VideoItemData videoItemData;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (videoItemData = this.T) == null) {
            return;
        }
        this.f21786i.M(videoItemData.thumbnail_url, 10, false);
        if (!StringUtils.isNull(this.T.title)) {
            str = this.T.title;
        } else {
            str = !StringUtils.isNull(this.T.abstext) ? this.T.abstext : "";
        }
        boolean z2 = d.a.c.e.m.b.d(this.T.video_height, 0) <= d.a.c.e.m.b.d(this.T.video_width, 0);
        if (StringUtils.isNull(str) && (!z2 || this.T.video_duration < 60)) {
            this.G.setVisibility(8);
        } else {
            if (z2 && this.T.video_duration >= 60) {
                this.F.setVisibility(0);
                int i2 = this.T.video_duration;
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
                d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.E);
                d2.x(R.dimen.T_X09);
                d2.t(R.color.CAM_X0621);
                this.E.setText(sb.toString());
            } else {
                this.F.setVisibility(8);
            }
            this.G.setVisibility(0);
            this.D.setTextSize(d.a.c.e.p.l.g(getContext(), R.dimen.T_X07));
            this.D.setTextColor(R.color.CAM_X0621);
            this.D.setLineSpacingExtra(d.a.c.e.p.l.g(getContext(), R.dimen.tbds10));
            this.D.setExpandable(false);
            this.D.setTextMaxLine(3);
            this.D.setLimitLine(3);
            this.D.setOnStatusChangedListener(new c0(this));
            ExpandableTextView expandableTextView = this.D;
            VideoItemData videoItemData2 = this.T;
            expandableTextView.setData(str, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        this.H.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.T.comment_num, 0L)));
        this.I.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.T.agree_num, 0L)));
        this.J.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.T.share_num, 0L)));
        UserItemData userItemData = this.T.author_info;
        if (userItemData != null) {
            if (!TextUtils.isEmpty(userItemData.bjhAvatar)) {
                this.n.M(this.T.author_info.bjhAvatar, 12, false);
            } else if (!StringUtils.isNull(this.T.author_info.portrait) && this.T.author_info.portrait.startsWith("http")) {
                this.n.M(this.T.author_info.portrait, 10, false);
            } else {
                this.n.M(this.T.author_info.portrait, 12, false);
            }
            if (StringUtils.isNull(this.T.author_info.getUserShowName())) {
                this.i0.setVisibility(8);
            } else {
                this.i0.setVisibility(0);
                this.i0.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.T.author_info.getUserShowName(), 16, StringHelper.STRING_MORE));
            }
        }
        AlaInfoData alaInfoData = this.T.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            U1(this.T.mAlaInfoData.live_status == 1);
            T1();
        }
        if ("1".equals(this.T.is_private) && this.V.getVisibility() != 0) {
            this.S.setVisibility(0);
        } else {
            this.S.setVisibility(8);
        }
        if ("1".equals(this.T.is_agreed)) {
            this.a0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.a0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.T.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.V.getVisibility() != 0) {
            this.R.setVisibility(0);
            this.O.setText(this.T.act_info.activity_name);
        } else {
            this.R.setVisibility(8);
        }
        D1();
        this.l.setVisibility(8);
        b2 b2Var = this.T.threadData;
        if (b2Var != null) {
            if (TextUtils.isEmpty(b2Var.getRecomReason())) {
                this.A.setVisibility(8);
                return;
            }
            this.A.setVisibility(0);
            this.C.setText(this.T.threadData.getRecomReason());
            this.B.M(this.T.threadData.Y0, 10, false);
        }
    }

    public final boolean H1(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.f21784g == null || this.A0) {
            return;
        }
        this.A0 = true;
        this.E0 = new TBLottieAnimationView(this.f21784g.getContext());
        if (this.B0 == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
            this.B0 = layoutParams;
            layoutParams.addRule(13);
        }
        SkinManager.setLottieAnimation(this.E0, R.raw.lottie_agree_big_photo);
        View view = this.f21784g;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(this.E0, this.B0);
        }
        this.E0.addAnimatorListener(new f0(this));
        this.E0.playAnimation();
    }

    public final void J1(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.T) != null) {
            int i3 = 0;
            if (i2 == this.f21782e) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.T;
                    videoItemData2.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData2.agree_num, 0) - 1);
                    this.T.is_agreed = "0";
                    i3 = 1;
                } else {
                    VideoItemData videoItemData3 = this.T;
                    videoItemData3.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData3.agree_num, 0) + 1);
                    this.T.is_agreed = "1";
                    I1();
                    M1(1);
                }
            } else {
                videoItemData.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData.agree_num, 0) + 1);
                this.T.is_agreed = "1";
                M1(1);
            }
            StatisticItem statisticItem = new StatisticItem("c12795");
            statisticItem.param("tid", this.T.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f21782e) {
                statisticItem.param("obj_type", i3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c12003");
            statisticItem2.param("tid", this.T.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f21782e) {
                statisticItem2.param("obj_type", i3);
            } else {
                statisticItem2.param("obj_type", 2);
            }
            if ("index".equals(this.r0)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            d.a.o0.i0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                if (i2 == this.f21782e) {
                    statisticItem3.param("obj_type", i3);
                } else {
                    statisticItem3.param("obj_type", 2);
                }
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("obj_source", P1());
                } else {
                    statisticItem3.param("obj_locate", 2);
                }
                statisticItem3.param("tid", this.T.thread_id);
                statisticItem3.param("fid", this.T.forum_id);
                if ("a088".equals(this.s0)) {
                    statisticItem3.param("obj_param1", 1);
                } else if ("a089".equals(this.s0)) {
                    statisticItem3.param("obj_param1", 2);
                }
                TiebaStatic.log(statisticItem3);
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem2);
            G1();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.T.thread_id);
            httpMessage.addParam("op_type", i3);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            BaijiahaoData baijiahaoData = this.T.baijiahaoData;
            if (baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.T.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.T.baijiahaoData.oriUgcVid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.T.baijiahaoData.oriUgcType);
            }
            if (k2 != null) {
                httpMessage.addParam("obj_source", k2.a());
            }
            sendMessage(httpMessage);
            d.a.p0.h3.h0.e eVar = new d.a.p0.h3.h0.e();
            AgreeData agreeData = new AgreeData();
            String str = this.T.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.T.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.T.is_agreed);
            eVar.f57972b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.T));
        }
    }

    public final void K1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) {
            if (z2) {
                this.r.setVisibility(8);
                this.P.setVisibility(8);
                this.s.setVisibility(8);
                this.t.setVisibility(8);
                this.q.setVisibility(8);
                this.u.setVisibility(0);
                return;
            }
            this.r.setVisibility(0);
            this.P.setVisibility(0);
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.q.setVisibility(0);
            this.u.setVisibility(8);
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.T == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.T.thread_id);
        statisticItem.param("nid", this.T.nid);
        statisticItem.param("fid", this.T.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.p0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", d.a.c.e.p.k.isEmpty(this.T.mRecomWeight) ? "0" : this.T.mRecomWeight);
        statisticItem.param("extra", d.a.c.e.p.k.isEmpty(this.T.mRecomExtra) ? "0" : this.T.mRecomExtra);
        statisticItem.param("obj_id", this.C0);
        statisticItem.param("ab_tag", d.a.c.e.p.k.isEmpty(this.T.mRecomAbTag) ? "0" : this.T.mRecomAbTag);
        statisticItem.param("obj_source", d.a.c.e.p.k.isEmpty(this.T.mRecomSource) ? "0" : this.T.mRecomSource);
        statisticItem.param("obj_type", this.r0);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.T.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.T.baijiahaoData.oriUgcVid);
            int i2 = this.T.baijiahaoData.oriUgcType;
            if (i2 == 4) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.T.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.r0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.s0);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void M1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.T.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
                statisticItem.param("obj_locate", 1);
            } else {
                statisticItem.param("obj_locate", 2);
            }
            statisticItem.param("obj_type", i2);
            if ("a088".equals(this.s0)) {
                statisticItem.param("obj_source", 1);
            } else if ("a089".equals(this.s0)) {
                statisticItem.param("obj_source", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.a.o0.b1.p.a.b
    public void N(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity())) {
            I1();
            VideoItemData videoItemData = this.T;
            if (videoItemData == null || !"0".equals(videoItemData.is_agreed)) {
                return;
            }
            J1(this.f21783f);
        }
    }

    public String N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<String> O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.p0.x3.g.a.a
    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.H0 = i2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.r0)) {
                return 0;
            }
            String str = this.r0;
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

    public final void Q1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048593, this, z2) == null) || this.T == null) {
            return;
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
        VideoItemData videoItemData = this.T;
        PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.T.forum_id));
        createNormalCfg.setForumName(this.T.forum_name);
        createNormalCfg.setVideo_source(VideoPlayActivity.FROM_VIDEO_PLAY);
        createNormalCfg.setJumpToCommentArea(z2);
        createNormalCfg.setBjhData(this.T.baijiahaoData);
        if (this.T.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            createNormalCfg.setNeedPreLoad(true);
            d.a.p0.u0.l.c(this.T.threadData);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void R1(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, intent) == null) {
            d.a.p0.x3.e.a aVar = this.J0;
            if (aVar != null) {
                aVar.n(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                d.a.p0.v2.a.g().m(getPageContext());
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
            }
        }
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            d.a.p0.x3.e.a aVar = this.J0;
            if (aVar == null || aVar.a() == null || !this.J0.a().v()) {
                return false;
            }
            this.J0.a().o();
            this.j0.setVisibility(8);
            if (!(this.J0.a().n(28) instanceof d.a.p0.x3.e.c) || ((d.a.p0.x3.e.c) this.J0.a().n(28)).g() == null || ((d.a.p0.x3.e.c) this.J0.a().n(28)).g().getText() == null) {
                return true;
            }
            this.k0.setText(StringUtils.isNull(((d.a.p0.x3.e.c) this.J0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void T1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (tBLottieAnimationView = this.o) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public final void U1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) {
            int g2 = d.a.c.e.p.l.g(getContext(), R.dimen.tbds26);
            if (this.p != z2) {
                if (this.o != null) {
                    if (z2) {
                        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            marginLayoutParams.leftMargin = g2;
                            marginLayoutParams.rightMargin = g2;
                            this.m.setLayoutParams(layoutParams);
                        }
                        this.o.setVisibility(0);
                        if (!this.o.isAnimating()) {
                            this.o.setSpeed(0.8f);
                            this.o.setRepeatCount(-1);
                            this.o.post(new t(this));
                        }
                    } else {
                        ViewGroup.LayoutParams layoutParams2 = this.m.getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                            marginLayoutParams2.leftMargin = 0;
                            marginLayoutParams2.rightMargin = 0;
                            this.m.setLayoutParams(layoutParams2);
                        }
                        this.o.setVisibility(8);
                        if (this.o.isAnimating()) {
                            this.o.cancelAnimation();
                        }
                    }
                }
                this.p = z2;
            }
        }
    }

    public void V1() {
        d.a.o0.r.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (jVar = this.t0) != null && jVar.isShowing()) {
            this.t0.dismiss();
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            d.a.p0.x3.e.a aVar = (d.a.p0.x3.e.a) new d.a.p0.x3.e.b().a(getActivity());
            this.J0 = aVar;
            if (aVar == null || this.T == null) {
                return;
            }
            aVar.s(getPageContext());
            d.a.p0.x3.e.a aVar2 = this.J0;
            VideoItemData videoItemData = this.T;
            aVar2.t(videoItemData.thread_id, videoItemData.forum_id, videoItemData.forum_name);
            this.J0.u(new q(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.f21784g).addView(this.J0.a(), layoutParams);
        }
    }

    public final boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.q0) : invokeV.booleanValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            VideoItemData videoItemData = this.T;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || !"a088".equals(this.s0)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void Z1() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (tbCyberVideoView = this.f21785h) == null) {
            return;
        }
        tbCyberVideoView.pause();
    }

    @Override // d.a.p0.x3.g.a.a
    public VideoItemModel a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.U : (VideoItemModel) invokeV.objValue;
    }

    public final void a2(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048604, this, i2) == null) && this.T != null && this.Z == null) {
            StatisticItem statisticItem = new StatisticItem("c12794");
            statisticItem.param("tid", this.T.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.T.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            statisticItem2.param("page_type", "a023");
            statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
            TiebaStatic.log(statisticItem2);
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.T == null) {
            return;
        }
        d.a.p0.n2.o oVar = new d.a.p0.n2.o();
        oVar.f60809a = VideoPlayActivity.FROM_VIDEO_PLAY;
        VideoItemData videoItemData = this.T;
        oVar.f60811c = videoItemData.thread_id;
        oVar.t = videoItemData.nid;
        oVar.f60812d = this.T.forum_id + "";
        oVar.f60813e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.T;
        oVar.f60814f = videoItemData2.mRecomSource;
        oVar.f60815g = videoItemData2.mRecomAbTag;
        oVar.f60816h = videoItemData2.mRecomWeight;
        oVar.f60817i = "";
        oVar.k = "";
        oVar.m = videoItemData2.mMd5;
        if (this.Z != null) {
            oVar.n = "1";
        } else {
            oVar.n = "2";
        }
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.q0)) {
            oVar.p = "1";
            oVar.f60809a = "auto_midpage";
            oVar.f60817i = "index";
        }
        d.a.p0.n2.h.e(this.T.mMd5, "", "1", oVar, this.f21785h.getPcdnState());
    }

    public final void c2() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || this.w == null || (imageView = this.v) == null) {
            return;
        }
        imageView.clearAnimation();
        this.w.clearAnimation();
        this.v.setVisibility(0);
        this.w.setVisibility(8);
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || o2()) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f21785h;
        if (tbCyberVideoView != null && this.x != null && this.T != null) {
            if (tbCyberVideoView.getParent() == null) {
                g2();
                h2();
            }
            if (TbVideoViewSet.d().e(this.z0) == null || TbVideoViewSet.d().e(this.z0) != this.f21785h) {
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.W;
                if (videoMiddleNiaiControllerView != null) {
                    videoMiddleNiaiControllerView.q();
                }
                this.f21785h.setVideoPath(this.z0, this.T.thread_id);
            }
            this.f21785h.W(null);
            this.W.s();
            this.x.setVisibility(8);
            m2();
        }
        if (isResumed() && this.X) {
            return;
        }
        Z1();
    }

    public final void e2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || this.N == null) {
            return;
        }
        Drawable drawable = getPageContext().getResources().getDrawable(R.drawable.icon_pure_followed);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds29), UtilHelper.getDimenPixelSize(R.dimen.tbds18));
        this.N.setCompoundDrawables(drawable, null, null, null);
    }

    public void f2(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, cVar) == null) {
            this.K0 = cVar;
        }
    }

    public void g2() {
        TbCyberVideoView tbCyberVideoView;
        TbCyberVideoView tbCyberVideoView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && (tbCyberVideoView = this.f21785h) != null && tbCyberVideoView.getParent() == null) {
            VideoItemData videoItemData = this.T;
            if (videoItemData != null) {
                int d2 = d.a.c.e.m.b.d(videoItemData.video_height, 0);
                int d3 = d.a.c.e.m.b.d(this.T.video_width, 0);
                float f2 = 0.0f;
                if (d2 != 0 && d3 != 0) {
                    f2 = (d2 * 1.0f) / d3;
                }
                if (f2 > 1.0f) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    this.l0 = layoutParams;
                    layoutParams.addRule(13);
                } else {
                    int i2 = d.a.c.e.p.l.i(this.f21784g.getContext());
                    float k2 = f2 * d.a.c.e.p.l.k(this.f21784g.getContext());
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) k2);
                    this.l0 = layoutParams2;
                    layoutParams2.addRule(14);
                    this.l0.topMargin = ((int) ((i2 - k2) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight())) / 2;
                    this.f21786i.setLayoutParams(this.l0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                    layoutParams3.removeRule(13);
                    layoutParams3.addRule(14);
                    layoutParams3.topMargin = ((i2 - d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) / 2;
                    this.x.requestLayout();
                }
                if (this.f21784g != null && (tbCyberVideoView2 = this.f21785h) != null && tbCyberVideoView2.getView() != null) {
                    ((ViewGroup) this.f21784g).addView(this.f21785h.getView(), 0, this.l0);
                }
            }
            if (this.T != null) {
                d.a.p0.n2.o oVar = new d.a.p0.n2.o();
                oVar.f60813e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData2 = this.T;
                oVar.f60811c = videoItemData2.thread_id;
                oVar.t = videoItemData2.nid;
                oVar.f60812d = videoItemData2.forum_id;
                oVar.m = videoItemData2.mMd5;
                oVar.k = "";
                oVar.f60814f = videoItemData2.mRecomSource;
                oVar.l = videoItemData2.mRecomAbTag;
                oVar.j = 1;
                BaijiahaoData baijiahaoData = videoItemData2.baijiahaoData;
                if (baijiahaoData != null) {
                    int i3 = baijiahaoData.oriUgcType;
                    if (i3 == 2) {
                        oVar.j = 3;
                    } else if (i3 == 4) {
                        oVar.j = 2;
                    }
                }
                oVar.f60816h = this.T.mRecomWeight;
                if (this.Z != null) {
                    oVar.n = "1";
                } else {
                    oVar.n = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.q0)) {
                    oVar.p = "1";
                    oVar.f60809a = "13";
                    oVar.f60817i = this.r0;
                    oVar.k = this.C0;
                    oVar.f60815g = this.T.mRecomWeight;
                } else {
                    oVar.f60809a = "14";
                }
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
                    oVar.p = "1";
                    if ("a088".equals(this.s0)) {
                        oVar.f60809a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES;
                    } else if ("a089".equals(this.s0)) {
                        oVar.f60809a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
                    }
                    oVar.f60817i = this.r0;
                    oVar.k = this.C0;
                    oVar.f60815g = this.T.mRecomWeight;
                }
                this.f21785h.setVideoStatData(oVar);
                this.f21785h.setLocateSource("v_mid_page");
            }
            this.f21785h.setContinuePlayEnable(true);
        }
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.f21785h.setOnPreparedListener(this.Y0);
            }
            this.f21785h.setOnCompletionListener(this.X0);
            this.f21785h.setOnInfoListener(this.W0);
        }
    }

    public final void i2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, str) == null) || this.f21785h == null || str == null || str.equals(this.z0)) {
            return;
        }
        this.z0 = str;
    }

    @Override // d.a.o0.b1.p.a.b
    public void j() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (videoItemData = this.T) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(userItemData.user_id, 0L);
        long f3 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = f2 == f3;
        if (f2 == 0 && f3 == 0) {
            z2 = false;
        }
        d.a.p0.x3.d.a.a();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(f2, z2, false)));
    }

    public void j2(d.a.p0.x3.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, aVar) == null) {
            this.I0 = aVar;
        }
    }

    @Override // d.a.o0.b1.p.a.b
    public void k() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && (tbCyberVideoView = this.f21785h) != null && tbCyberVideoView.M()) {
            if (this.f21785h.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.f21785h.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                if (this.f21785h.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PAUSING || o2()) {
                    return;
                }
                this.f21785h.start();
                this.x.setVisibility(8);
                E1(true);
                this.W.s();
                if (isResumed() && this.X) {
                    return;
                }
                Z1();
                return;
            }
            this.f21785h.pause();
            this.x.setVisibility(0);
            E1(false);
            d.a.c.e.m.e.a().removeCallbacks(this.V0);
            M1(4);
        }
    }

    public void k2(p0 p0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, p0Var) == null) {
            this.L0 = p0Var;
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || this.t0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.t0.l();
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && d.a.c.e.p.j.x()) {
            d.a.p0.v3.f.d().g(getContext());
        }
    }

    @Override // d.a.p0.x3.g.a.a
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.H0 : invokeV.intValue;
    }

    public final void n2() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.t0 == null) {
                this.u0 = new d.a.o0.r.s.l(getActivity());
                this.t0 = new d.a.o0.r.s.j(getPageContext(), this.u0);
                ArrayList arrayList = new ArrayList();
                d.a.o0.r.s.h hVar = new d.a.o0.r.s.h(getString(R.string.mark), this.u0);
                boolean z2 = false;
                VideoItemData videoItemData = this.T;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    hVar.n(getResources().getString(R.string.remove_mark));
                } else {
                    hVar.n(getResources().getString(R.string.mark));
                }
                hVar.m(this.S0);
                VideoItemData videoItemData2 = this.T;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(hVar);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.T.thread_id);
                    statisticItem.param("fid", this.T.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
                        statisticItem.param("obj_type", 1);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    if ("a088".equals(this.s0)) {
                        statisticItem.param("obj_param1", 1);
                    } else if ("a089".equals(this.s0)) {
                        statisticItem.param("obj_param1", 2);
                    }
                    statisticItem.param("obj_source", P1());
                    TiebaStatic.log(statisticItem);
                }
                if (Y1()) {
                    d.a.o0.r.s.h hVar2 = new d.a.o0.r.s.h(getString(R.string.not_interested), this.u0);
                    hVar2.m(this.R0);
                    arrayList.add(hVar2);
                }
                d.a.o0.r.s.h hVar3 = new d.a.o0.r.s.h(getString(R.string.report_text), this.u0);
                hVar3.m(this.T0);
                arrayList.add(hVar3);
                if (this.o0) {
                    d.a.o0.r.s.h hVar4 = new d.a.o0.r.s.h(getString(R.string.delete), this.u0);
                    hVar4.m(this.U0);
                    arrayList.add(hVar4);
                }
                this.u0.m(new u(this));
                this.t0.setOnDismissListener(new w(this));
                this.u0.k(arrayList);
            }
            l2();
        }
    }

    public final boolean o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (d.a.p0.v3.f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || (!VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0) && TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            if ((!VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && d.a.c.e.p.j.x() && isResumed() && this.X) {
                d.a.c.e.p.l.N(TbadkCoreApplication.getInst(), getResources().getString(R.string.video_no_wifi_tips), 3000);
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
                    TbSingleton.getInstance().setTipsAutoPlayInVideoChannel(true);
                } else {
                    TbSingleton.getInstance().setTipsAutoPlayInVideoMiddle(true);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.o0) {
                ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
                this.v0 = forumManageModel;
                forumManageModel.setLoadDataCallBack(new r(this));
            }
            d.a.o0.h.a c2 = d.a.o0.h.a.c(getBaseFragmentActivity());
            this.w0 = c2;
            if (c2 != null) {
                c2.j(new s(this));
            }
            this.x0 = new d.a.o0.s.e.a(null);
            registerListener(this.N0);
            registerListener(this.O0);
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.F0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048623, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            R1(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.p0.x3.e.a aVar = this.J0;
            if (aVar != null && aVar.a() != null) {
                this.J0.a().w(i2);
            }
            d.a.o0.r.s.l lVar = this.u0;
            if (lVar != null) {
                lVar.j();
            }
            if (this.f21784g != null) {
                this.b0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.c0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.w.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.x.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                this.z.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_header40_n, d.a.p0.h3.c.a(SkinManager.getColor(R.color.CAM_X0213), 0.2f), null));
                C1();
                d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(this.j0);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0614);
                d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d(this.K);
                d3.y(R.string.F_X02);
                d3.t(R.color.CAM_X0101);
                d.a.o0.r.u.c.d(this.L).y(R.string.F_X02);
                d.a.o0.r.u.c d4 = d.a.o0.r.u.c.d(this.J);
                d4.x(R.dimen.T_X09);
                d4.y(R.string.F_X02);
                d4.w(R.array.S_O_X001);
                d.a.o0.r.u.c d5 = d.a.o0.r.u.c.d(this.I);
                d5.x(R.dimen.T_X09);
                d5.y(R.string.F_X02);
                d5.w(R.array.S_O_X001);
                d.a.o0.r.u.c d6 = d.a.o0.r.u.c.d(this.H);
                d6.x(R.dimen.T_X09);
                d6.y(R.string.F_X02);
                d6.w(R.array.S_O_X001);
                d.a.o0.r.u.c d7 = d.a.o0.r.u.c.d(this.i0);
                d7.x(R.dimen.T_X06);
                d7.y(R.string.F_X02);
                d7.w(R.array.S_O_X001);
                d.a.o0.r.u.c d8 = d.a.o0.r.u.c.d(this.M);
                d8.n(R.string.J_X01);
                d8.x(R.dimen.T_X09);
                d8.t(R.color.CAM_X0101);
                d8.y(R.string.F_X02);
                d8.f(R.color.CAM_X0302);
                d.a.o0.r.u.c d9 = d.a.o0.r.u.c.d(this.N);
                d9.n(R.string.J_X01);
                d9.x(R.dimen.T_X09);
                d9.f(R.color.CAM_X0302);
                this.L.setTextColor(d.a.p0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.o0.r.u.a.a(R.string.A_X08)));
                this.I.setTextColor(d.a.p0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.o0.r.u.a.a(R.string.A_X03)));
                this.J.setTextColor(d.a.p0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.o0.r.u.a.a(R.string.A_X03)));
                this.H.setTextColor(d.a.p0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.o0.r.u.a.a(R.string.A_X03)));
            }
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            T1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.P0);
            this.M0 = new d.a.p0.x3.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048626, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            VideoItemModel videoItemModel = (VideoItemModel) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
            this.U = videoItemModel;
            this.T = videoItemModel == null ? null : videoItemModel.getVideoItemData();
            this.Z = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
            this.p0 = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
            this.q0 = arguments.getString("page_from");
            this.r0 = arguments.getString("from");
            this.s0 = arguments.getString(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB);
            this.C0 = arguments.getString("obj_id");
            VideoItemData videoItemData = this.T;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.T.author_info.user_id)) {
                this.o0 = true;
            }
            this.f21784g = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
            this.f21784g.setOnTouchListener(new k0(this, new GestureDetectorCompat(getContext(), new j0(this))));
            this.f21784g.setOnLongClickListener(new l0(this));
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.f21785h = tbCyberVideoView;
            tbCyberVideoView.setVideoStatusChangeListener(this);
            this.f21785h.setStageType("2005");
            this.f21785h.getMediaProgressObserver().j(new m0(this));
            TbImageView tbImageView = (TbImageView) this.f21784g.findViewById(R.id.video_cover);
            this.f21786i = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.x = (ImageView) this.f21784g.findViewById(R.id.play_btn);
            this.y = (RelativeLayout) this.f21784g.findViewById(R.id.video_loading_layout);
            this.z = (ImageView) this.f21784g.findViewById(R.id.video_loading_icon);
            this.f21786i.setEvent(new n0(this));
            g2();
            this.j = this.f21784g.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).topMargin = statusBarHeight;
            }
            this.k = (ImageView) this.f21784g.findViewById(R.id.back_btn);
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
                this.k.setVisibility(8);
            }
            this.l = (ImageView) this.f21784g.findViewById(R.id.more_btn);
            this.m = this.f21784g.findViewById(R.id.portrait_container);
            LinearLayout linearLayout = (LinearLayout) this.f21784g.findViewById(R.id.recommend_layout);
            this.A = linearLayout;
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(linearLayout);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            d.a.o0.r.u.b bVar = (d.a.o0.r.u.b) this.A.getBackground();
            bVar.B(SkinManager.getColor(0, R.color.CAM_X0106));
            this.A.setBackground(bVar);
            d.a.o0.r.u.c.d(this.A).e(R.string.A_X07);
            BarImageView barImageView = (BarImageView) this.f21784g.findViewById(R.id.recommend_forum_avatar);
            this.B = barImageView;
            barImageView.setShowOval(true);
            this.C = (TextView) this.f21784g.findViewById(R.id.recommend_info_view);
            HeadImageView headImageView = (HeadImageView) this.f21784g.findViewById(R.id.author_portrait);
            this.n = headImageView;
            headImageView.setDefaultResource(17170445);
            this.n.setPlaceHolder(2);
            this.n.setIsRound(true);
            this.n.setBorderWidth(R.dimen.L_X02);
            this.n.setBorderColor(R.color.CAM_X0622);
            this.n.setDrawBorder(true);
            this.o = (TBLottieAnimationView) this.f21784g.findViewById(R.id.user_living_lottie);
            this.P = (RelativeLayout) this.f21784g.findViewById(R.id.author_info_container);
            this.q = (LinearLayout) this.f21784g.findViewById(R.id.bottom_container);
            this.M = (EMTextView) this.f21784g.findViewById(R.id.love_btn);
            this.N = (EMTextView) this.f21784g.findViewById(R.id.has_love);
            e2();
            this.a0 = (ImageView) this.f21784g.findViewById(R.id.agree_img);
            this.D = (ExpandableTextView) this.f21784g.findViewById(R.id.video_title);
            this.E = (TextView) this.f21784g.findViewById(R.id.title_full_screen_text);
            this.F = this.f21784g.findViewById(R.id.title_full_screen_btn);
            this.G = this.f21784g.findViewById(R.id.video_title_layout);
            this.W = (VideoMiddleNiaiControllerView) this.f21784g.findViewById(R.id.media_controller);
            this.O = (TextView) this.f21784g.findViewById(R.id.video_activity);
            this.s = (LinearLayout) this.f21784g.findViewById(R.id.comment_container);
            this.H = (EMTextView) this.f21784g.findViewById(R.id.comment_num);
            this.b0 = (ImageView) this.f21784g.findViewById(R.id.comment_img);
            this.r = (LinearLayout) this.f21784g.findViewById(R.id.agree_container);
            this.u = (LinearLayout) this.f21784g.findViewById(R.id.ll_drag_container);
            this.t = (LinearLayout) this.f21784g.findViewById(R.id.share_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
                this.W.t(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            } else {
                this.W.t(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
            }
            this.I = (EMTextView) this.f21784g.findViewById(R.id.agree_num);
            this.c0 = (ImageView) this.f21784g.findViewById(R.id.share_img);
            this.J = (EMTextView) this.f21784g.findViewById(R.id.share_num);
            this.K = (EMTextView) this.f21784g.findViewById(R.id.drag_cur_time);
            this.L = (EMTextView) this.f21784g.findViewById(R.id.drag_total_time);
            this.v = (ImageView) this.f21784g.findViewById(R.id.share_img);
            this.w = (ImageView) this.f21784g.findViewById(R.id.share_img_changed);
            c2();
            this.Q = (LinearLayout) this.f21784g.findViewById(R.id.video_act_private_container);
            this.R = (LinearLayout) this.f21784g.findViewById(R.id.video_activity_container);
            this.S = (LinearLayout) this.f21784g.findViewById(R.id.video_private);
            this.i0 = (TextView) this.f21784g.findViewById(R.id.video_author_name);
            View findViewById = this.f21784g.findViewById(R.id.quick_reply_comment_layout);
            this.j0 = findViewById;
            findViewById.setOnClickListener(new o0(this));
            if (this.T != null) {
                this.W.setVisibility(0);
            }
            this.W.setPlayer(this.f21785h);
            this.W.setOnSeekBarChangeListener(new a(this));
            this.k0 = (TextView) this.f21784g.findViewById(R.id.quick_reply_comment_text);
            TextView textView = (TextView) this.f21784g.findViewById(R.id.download_nani_guide_txt);
            this.V = textView;
            textView.setVisibility(8);
            String p2 = d.a.o0.r.d0.b.j().p("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(p2)) {
                this.V.setText(p2);
            }
            this.V.setOnClickListener(new b(this, d.a.o0.r.d0.b.j().p("nani_key_download_link_url", null)));
            G1();
            c cVar = new c(this);
            this.m.setOnClickListener(cVar);
            this.i0.setOnClickListener(cVar);
            this.R.setOnClickListener(new d(this));
            this.D.setHasDown();
            this.D.setOnClickListener(new e(this));
            this.F.setOnClickListener(new f(this));
            this.k.setOnClickListener(new g(this));
            this.l.setOnClickListener(new h(this));
            this.s.setOnClickListener(new i(this));
            this.r.setOnClickListener(new j(this));
            this.t.setOnClickListener(new l(this));
            this.M.setOnClickListener(new m(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.Y = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.Y.setAnimationListener(new n(this));
            this.y.setVisibility(0);
            this.W.setLoading(true);
            Rect rect = this.Z;
            if (rect != null) {
                this.m0 = rect.right - rect.left;
                this.n0 = rect.bottom - rect.top;
                this.f21786i.post(new o(this));
            } else {
                this.f21786i.post(new p(this));
            }
            W1();
            if (this.X) {
                L1();
            }
            VideoItemData videoItemData2 = this.T;
            if (videoItemData2 != null && !StringUtils.isNull(videoItemData2.video_url)) {
                i2(this.T.video_url);
            }
            return this.f21784g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            stopPlay();
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.P0);
            d.a.p0.x3.e.a aVar = this.J0;
            if (aVar != null) {
                aVar.o();
            }
            if (this.V0 != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.V0);
                this.V0 = null;
            }
            d.a.p0.x3.a aVar2 = this.M0;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            super.onPause();
            Z1();
            d.a.p0.x3.e.a aVar = this.J0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.J0.a().o();
            this.j0.setVisibility(8);
            this.k0.setText(StringUtils.isNull(((d.a.p0.x3.e.c) this.J0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            super.onPrimary();
            if (isResumed() && this.X) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.T;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.X) {
                        b2();
                        d2();
                        a2(0);
                    } else {
                        Z1();
                    }
                }
                VideoItemData videoItemData2 = this.T;
                if (videoItemData2 == null || (alaInfoData = videoItemData2.mAlaInfoData) == null || !alaInfoData.isLegalYYLiveData() || this.T.mAlaInfoData.live_status != 1) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("tid", this.T.getThreadId());
                UserItemData userItemData = this.T.author_info;
                if (userItemData != null) {
                    statisticItem.addParam("obj_id", userItemData.user_id);
                    statisticItem.addParam("obj_name", this.T.author_info.user_name);
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            Z1();
            d.a.p0.x3.e.a aVar = this.J0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.J0.a().o();
            this.j0.setVisibility(8);
            this.k0.setText(StringUtils.isNull(((d.a.p0.x3.e.c) this.J0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.onResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            super.onStop();
            Z1();
            d.a.p0.x3.e.a aVar = this.J0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.J0.a().o();
            this.j0.setVisibility(8);
            this.k0.setText(StringUtils.isNull(((d.a.p0.x3.e.c) this.J0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            G1();
            h2();
        }
    }

    public final void p2() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (videoItemData = this.T) == null) {
            return;
        }
        String str3 = videoItemData.forum_id;
        String str4 = videoItemData.forum_name;
        String str5 = videoItemData.title;
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.T.baijiahaoData.oriUgcType + "&dvid=" + this.T.baijiahaoData.oriUgcVid + "&nid=" + this.T.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData.thread_id;
            str2 = "?share=9105&fr=share";
        }
        String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str7 = this.T.thumbnail_url;
        String string = getResources().getString(R.string.share_content_tpl);
        String string2 = getResources().getString(R.string.default_share_content_tpl);
        VideoItemData videoItemData3 = this.T;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str5;
        shareItem.s = format;
        if (this.T.baijiahaoData == null) {
            shareItem.R = videoItemData2.play_count;
        }
        if (this.T.isBjhVideo) {
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
        shareItem.f12843f = true;
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.r0)) {
            if ("a088".equals(this.s0)) {
                shareItem.E = 25;
                shareItem.I = 19;
            } else if ("a089".equals(this.s0)) {
                shareItem.E = 29;
                shareItem.I = 20;
            }
        } else {
            shareItem.E = 12;
            shareItem.I = 18;
        }
        if (this.T.getVideoType() == 1) {
            shareItem.M = 2;
        } else if (this.T.getVideoType() == 2) {
            shareItem.M = 8;
        } else if (this.T.getVideoType() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.T.isBjhVideo) {
            shareItem.f0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData4 = this.T;
        originalThreadInfo.f12249c = videoItemData4.thumbnail_url;
        originalThreadInfo.f12247a = 3;
        originalThreadInfo.f12248b = videoItemData4.title;
        originalThreadInfo.f12252f = videoItemData4.thread_id;
        originalThreadInfo.p = videoItemData4.baijiahaoData;
        shareItem.T = OriginalThreadInfo.ShareInfo.generateShareInfo(originalThreadInfo);
        TbadkCoreApplication.getInst().setShareItem(shareItem);
        Bundle bundle = new Bundle();
        bundle.putInt("obj_param1", shareItem.F);
        bundle.putInt("obj_type", shareItem.M);
        bundle.putString("fid", shareItem.J);
        bundle.putString("tid", shareItem.K);
        bundle.putInt("obj_source", shareItem.o);
        shareItem.k(bundle);
        ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) getActivity(), shareItem, true, true);
        shareDialogConfig.showDisLike = Y1();
        shareDialogConfig.disLikeListener = this.Q0;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        d.a.p0.e0.f.b().k(shareDialogConfig);
    }

    public final void q2(boolean z2) {
        d.a.p0.x3.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) || (aVar = this.M0) == null) {
            return;
        }
        aVar.c(X1());
        this.M0.d(getPageContext(), this.T, z2);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.X = z2;
            if (!z2 && this.J0 != null) {
                this.k0.setText(R.string.reply_something);
                this.J0.l();
            }
            if (isResumed() && this.X && (!this.F0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                a2(1);
                startPlay();
                L1();
                this.F0 = false;
                return;
            }
            c2();
            this.G0 = 1;
            Z1();
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || o2()) {
            return;
        }
        m2();
        ImageView imageView = this.x;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbCyberVideoView tbCyberVideoView = this.f21785h;
        if (tbCyberVideoView != null && this.x != null && this.T != null && tbCyberVideoView.getParent() == null) {
            g2();
            h2();
        }
        if (Build.VERSION.SDK_INT < 17 && this.f21786i.getVisibility() == 0) {
            this.f21786i.clearAnimation();
            this.f21786i.startAnimation(this.Y);
        }
        if (this.f21785h != null) {
            if (TbVideoViewSet.d().e(this.z0) == null || TbVideoViewSet.d().e(this.z0) != this.f21785h) {
                this.f21785h.setVideoPath(this.z0, this.T.thread_id);
            }
            this.f21785h.start();
            this.W.s();
            b2();
        }
        if (isResumed() && this.X) {
            return;
        }
        Z1();
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048637, this) == null) || (tbCyberVideoView = this.f21785h) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }
}
