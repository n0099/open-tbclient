package com.baidu.tieba.videoplay;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
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
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
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
import d.a.p0.d1.p.a;
import d.a.p0.i.a;
import d.a.p0.s.q.b2;
import d.a.p0.s.s.a;
import d.a.p0.s.s.l;
import d.a.q0.n2.f;
import d.a.q0.x3.e.a;
import d.a.q0.x3.i.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class VideoPlayFragment extends BaseFragment implements a.b, d.a.q0.x3.h.a.a, TbCyberVideoView.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public d.a.p0.t.e.a A0;
    public RelativeLayout B;
    public BdUniqueId B0;
    public ImageView C;
    public String C0;
    public LinearLayout D;
    public boolean D0;
    public BarImageView E;
    public RelativeLayout.LayoutParams E0;
    public TextView F;
    public RelativeLayout.LayoutParams F0;
    public ExpandableTextView G;
    public boolean G0;
    public TextView H;
    public String H0;
    public View I;
    public boolean I0;
    public View J;
    public boolean J0;
    public EMTextView K;
    public TBLottieAnimationView K0;
    public EMTextView L;
    public boolean L0;
    public EMTextView M;
    public int M0;
    public EMTextView N;
    public int N0;
    public EMTextView O;
    public d.a.q0.x3.g.a O0;
    public EMTextView P;
    public d.a.q0.x3.e.a P0;
    public EMTextView Q;
    public f.c Q0;
    public TextView R;
    public u0 R0;
    public View S;
    public d.a.q0.x3.a S0;
    public LinearLayout T;
    public d.a.q0.x3.i.a T0;
    public LinearLayout U;
    public CustomMessageListener U0;
    public LinearLayout V;
    public final CustomMessageListener V0;
    public VideoItemData W;
    public CustomMessageListener W0;
    public VideoItemModel X;
    public CustomMessageListener X0;
    public TextView Y;
    public CustomMessageListener Y0;
    public VideoMiddleNiaiControllerView Z;
    public CustomMessageListener Z0;
    public boolean a0;
    public CustomMessageListener a1;
    public AlphaAnimation b0;
    public View.OnClickListener b1;
    public Rect c0;
    public l.d c1;
    public l.d d1;

    /* renamed from: e  reason: collision with root package name */
    public int f21911e;
    public l.d e1;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f21912f;
    public l.d f1;

    /* renamed from: g  reason: collision with root package name */
    public int f21913g;
    public Runnable g1;

    /* renamed from: h  reason: collision with root package name */
    public int f21914h;
    public CyberPlayerManager.OnInfoListener h1;

    /* renamed from: i  reason: collision with root package name */
    public View f21915i;
    public ImageView i0;
    public CyberPlayerManager.OnCompletionListener i1;
    public RelativeLayout j;
    public ImageView j0;
    public CyberPlayerManager.OnPreparedListener j1;
    public TbCyberVideoView k;
    public ImageView k0;
    public TbImageView l;
    public TextView l0;
    public View m;
    public TextView m0;
    public ImageView n;
    public View n0;
    public ImageView o;
    public TextView o0;
    public View p;
    public RelativeLayout.LayoutParams p0;
    public HeadImageView q;
    public int q0;
    public TBLottieAnimationView r;
    public int r0;
    public boolean s;
    public boolean s0;
    public LinearLayout t;
    public int t0;
    public LinearLayout u;
    public String u0;
    public LinearLayout v;
    public String v0;
    public LinearLayout w;
    public d.a.p0.s.s.j w0;
    public LinearLayout x;
    public d.a.p0.s.s.l x0;
    public ImageView y;
    public ForumManageModel y0;
    public ImageView z;
    public d.a.p0.i.a z0;

    /* loaded from: classes4.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21916e;

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
            this.f21916e = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21916e.B2();
                this.f21916e.f21915i.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a0 implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21917a;

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
            this.f21917a = videoPlayFragment;
        }

        @Override // d.a.p0.s.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21917a.i2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21918e;

        public b(VideoPlayFragment videoPlayFragment) {
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
            this.f21918e = videoPlayFragment;
        }

        @Override // d.a.q0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f21918e.Q0 == null) {
                return;
            }
            this.f21918e.Q0.a(i2, i3);
        }
    }

    /* loaded from: classes4.dex */
    public class b0 implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21919e;

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
            this.f21919e = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f21919e.w0 = null;
                this.f21919e.x0 = null;
                if (TbSingleton.getInstance().isNotchScreen(this.f21919e.getActivity())) {
                    return;
                }
                TbSingleton.getInstance().isCutoutScreen(this.f21919e.getActivity());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21920a;

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
            this.f21920a = videoPlayFragment;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                this.f21920a.B.setVisibility(8);
                this.f21920a.k.setCanShowPause(true);
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
    public class c0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21921e;

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
            this.f21921e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21921e.F2(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21922e;

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
            this.f21922e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f21922e;
                if (videoPlayFragment.W1(videoPlayFragment.getPageContext(), 11001)) {
                    this.f21922e.n0.setVisibility(8);
                    if (this.f21922e.P0 != null && this.f21922e.P0.a() != null) {
                        this.f21922e.P0.a().j();
                        VideoPlayFragment videoPlayFragment2 = this.f21922e;
                        if (videoPlayFragment2.W != null) {
                            videoPlayFragment2.P0.w(this.f21922e.W);
                        }
                    }
                    if (this.f21922e.W != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.f21922e.W.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.f21922e.W.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d0 implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21923a;

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
            this.f21923a = videoPlayFragment;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f21923a.w0 != null) {
                    this.f21923a.w0.dismiss();
                }
                this.f21923a.F2(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21924e;

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
            this.f21924e = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f21924e.Z1(true);
                EMTextView eMTextView = this.f21924e.N;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = this.f21924e.O;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.f21924e.k.getDuration()));
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
                statisticItem.param("tid", this.f21924e.W.thread_id);
                statisticItem.param("fid", this.f21924e.W.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (this.f21924e.f21911e != 3 && this.f21924e.f21911e != 4) {
                    statisticItem.param("obj_type", 2);
                } else {
                    statisticItem.param("obj_type", 1);
                }
                statisticItem.param("obj_type", this.f21924e.e2());
                if (this.f21924e.f21911e != 3) {
                    if (this.f21924e.f21911e == 4) {
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
                this.f21924e.I0 = true;
                if (this.f21924e.Z != null) {
                    VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.f21924e.Z;
                    if (this.f21924e.f21911e != 4 && this.f21924e.f21911e != 3) {
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
                this.f21924e.I0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(null);
                    this.f21924e.Z1(false);
                    if (!this.f21924e.k.isPlaying()) {
                        this.f21924e.k.start();
                        this.f21924e.A.setVisibility(8);
                    }
                    if (!this.f21924e.J0 && (!this.f21924e.isResumed() || !this.f21924e.a0)) {
                        this.f21924e.m2();
                    }
                    d.a.d.e.m.e.a().postDelayed(this.f21924e.g1, 3000L);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e0 implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21925a;

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
            this.f21925a = videoPlayFragment;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f21925a.getContext())) {
                    if (this.f21925a.w0 != null) {
                        this.f21925a.w0.dismiss();
                        return;
                    }
                    return;
                }
                if (this.f21925a.w0 != null) {
                    this.f21925a.w0.dismiss();
                }
                VideoItemData videoItemData = this.f21925a.W;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.f21925a.W.thread_id);
                markData.setPostId(this.f21925a.W.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.f21925a.W.thread_id);
                markData.setForumId(this.f21925a.W.forum_id);
                if (this.f21925a.z0 != null) {
                    this.f21925a.z0.i(markData);
                    if (!z) {
                        this.f21925a.z0.a();
                    } else {
                        this.f21925a.z0.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21926e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21927f;

        public f(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f21927f = videoPlayFragment;
            this.f21926e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f21926e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.d.a.j.a(this.f21927f.getPageContext().getPageActivity()), new String[]{this.f21926e}, true);
        }
    }

    /* loaded from: classes4.dex */
    public class f0 implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21928a;

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
            this.f21928a = videoPlayFragment;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21928a.w0.dismiss();
                if (ViewHelper.checkUpIsLogin(this.f21928a.getActivity()) && (videoItemData = (videoPlayFragment = this.f21928a).W) != null) {
                    String str = videoItemData.thread_id;
                    String str2 = videoItemData.forum_id;
                    String string = videoPlayFragment.getResources().getString(R.string.web_view_report_title);
                    String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + this.f21928a.W.post_id;
                    VideoItemData videoItemData2 = this.f21928a.W;
                    if (videoItemData2.isBjhVideo) {
                        str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                        string = "";
                    }
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f21928a.getPageContext().getPageActivity(), string, str3, true);
                    if (this.f21928a.W.isBjhVideo) {
                        tbWebViewActivityConfig.setFixTitle(true);
                    }
                    this.f21928a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21929e;

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
            this.f21929e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserItemData userItemData;
            VideoItemData videoItemData;
            AlaInfoData alaInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.portrait_container && (videoItemData = this.f21929e.W) != null && (alaInfoData = videoItemData.mAlaInfoData) != null && alaInfoData.isLegalYYLiveData()) {
                    VideoPlayFragment videoPlayFragment = this.f21929e;
                    if (videoPlayFragment.W.mAlaInfoData.live_status == 1) {
                        YYLiveUtil.jumpYYLiveRoom(videoPlayFragment.getPageContext(), this.f21929e.W.mAlaInfoData);
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_CLICK);
                        statisticItem.addParam("tid", this.f21929e.W.getThreadId());
                        UserItemData userItemData2 = this.f21929e.W.author_info;
                        if (userItemData2 != null) {
                            statisticItem.addParam("obj_id", userItemData2.user_id);
                            statisticItem.addParam("obj_name", this.f21929e.W.author_info.user_name);
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                }
                VideoItemData videoItemData2 = this.f21929e.W;
                if (videoItemData2 == null || (userItemData = videoItemData2.author_info) == null || StringUtils.isNull(userItemData.user_id)) {
                    return;
                }
                long f2 = d.a.d.e.m.b.f(this.f21929e.W.author_info.user_id, 0L);
                long f3 = d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = f2 == f3;
                if (f2 == 0 && f3 == 0) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f21929e.getActivity()).createNormalConfig(f2, z, false)));
                StatisticItem statisticItem2 = new StatisticItem("c12798");
                statisticItem2.param("tid", this.f21929e.W.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
                this.f21929e.b2(5);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21930a;

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
            this.f21930a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.q0.h3.h0.e)) {
                AgreeData agreeData = ((d.a.q0.h3.h0.e) customResponsedMessage.getData()).f58547b;
                if (this.f21930a.W == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.f21930a.W.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f21930a.W.agree_num = String.valueOf(agreeData.agreeNum);
                    this.f21930a.W.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.f21930a.R1();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f21930a.W.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f21930a.W.agree_num = String.valueOf(agreeData.agreeNum);
                this.f21930a.W.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.f21930a.R1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21931e;

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
            this.f21931e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f21931e).W) == null || videoItemData.act_info == null) {
                return;
            }
            d.a.p0.m.a.k(videoPlayFragment.getActivity(), this.f21931e.W.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.f21931e.W.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class h0 implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21932a;

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.p0.s.s.a f21933e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ h0 f21934f;

            public a(h0 h0Var, d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21934f = h0Var;
                this.f21933e = aVar;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21933e.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f21934f.f21932a;
                    if (videoPlayFragment.W != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.y0;
                        VideoPlayFragment videoPlayFragment2 = this.f21934f.f21932a;
                        VideoItemData videoItemData = videoPlayFragment2.W;
                        forumManageModel.R(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.s0, null);
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
            public final /* synthetic */ d.a.p0.s.s.a f21935e;

            public b(h0 h0Var, d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {h0Var, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21935e = aVar;
            }

            @Override // d.a.p0.s.s.a.e
            public void onClick(d.a.p0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21935e.dismiss();
                }
            }
        }

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
            this.f21932a = videoPlayFragment;
        }

        @Override // d.a.p0.s.s.l.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21932a.w0.dismiss();
                d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f21932a.getActivity());
                VideoItemData videoItemData = this.f21932a.W;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(R.string.del_thread_confirm);
                }
                aVar.setPositiveButton(R.string.dialog_ok, new a(this, aVar));
                aVar.setNegativeButton(R.string.dialog_cancel, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.f21932a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21936e;

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
            this.f21936e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21936e.f2();
                this.f21936e.b2(7);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i0 implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21937a;

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
            this.f21937a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21937a.W.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21938e;

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
            this.f21938e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21938e.j.removeView(this.f21938e.k);
                this.f21938e.T0.T();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21939e;

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
            this.f21939e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21939e.I0) {
                return;
            }
            this.f21939e.T1(true);
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21940a;

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
            this.f21940a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = this.f21940a.W;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.f21940a.W.author_info.user_id.equals(data.f12868c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.f21940a.B0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.f12866a) {
                    if (!z || "0".equals(this.f21940a.W.author_info.is_follow)) {
                        return;
                    }
                    d.a.d.e.p.l.L(this.f21940a.getActivity(), R.string.attention_fail);
                    VideoPlayFragment videoPlayFragment = this.f21940a;
                    videoPlayFragment.W.author_info.is_follow = "0";
                    videoPlayFragment.S1();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.f21940a;
                    videoPlayFragment2.W.author_info.is_follow = "0";
                    videoPlayFragment2.S1();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.f21940a.W));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.f21940a;
                    videoPlayFragment3.W.author_info.is_follow = "1";
                    videoPlayFragment3.S1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.f21940a.u0)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21941e;

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
            this.f21941e = videoPlayFragment;
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
                VideoPlayFragment videoPlayFragment = this.f21941e;
                View view = videoPlayFragment.f21915i;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).removeView(videoPlayFragment.K0);
                }
                this.f21941e.D0 = false;
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
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21942e;

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
            this.f21942e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.f21942e.W;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.f21942e.W.thread_id));
                }
                this.f21942e.getActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l0 implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21943e;

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
            this.f21943e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f21943e.a0 && ((i2 == 3 || i2 == 904) && this.f21943e.l.getVisibility() == 0)) {
                    this.f21943e.l.clearAnimation();
                    this.f21943e.l.startAnimation(this.f21943e.b0);
                }
                if (i2 != 10012 || this.f21943e.O0 == null) {
                    return true;
                }
                this.f21943e.O0.c();
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21944e;

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
            this.f21944e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21944e.B2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m0 implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21945e;

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
            this.f21945e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f21945e.k) == null) {
                return;
            }
            tbCyberVideoView.Q();
            this.f21945e.k.seekTo(0);
            if (d.a.p0.b.d.f()) {
                if (this.f21945e.R0 != null && !this.f21945e.J0) {
                    this.f21945e.R0.a();
                    this.f21945e.l.setVisibility(8);
                    this.f21945e.k.start();
                } else {
                    this.f21945e.k.start();
                }
            } else {
                this.f21945e.k.start();
            }
            this.f21945e.o2();
            VideoPlayFragment.J1(this.f21945e);
            if (this.f21945e.M0 == 3) {
                this.f21945e.U1();
            }
            if (this.f21945e.J0) {
                return;
            }
            if (this.f21945e.isResumed() && this.f21945e.a0) {
                return;
            }
            this.f21945e.m2();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21946e;

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
            this.f21946e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.f21946e.getPageContext(), this.f21946e.W)) {
                return;
            }
            this.f21946e.f2();
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.f21946e.W.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.f21946e.b2(2);
        }
    }

    /* loaded from: classes4.dex */
    public class n0 implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21947e;

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
            this.f21947e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f21947e.k) == null) {
                return;
            }
            tbCyberVideoView.setVolume(1.0f, 1.0f);
            if (this.f21947e.Z != null) {
                this.f21947e.Z.setVisibility(0);
                if (this.f21947e.Z.getCurProgress() == 0) {
                    this.f21947e.Z.s();
                    return;
                }
                return;
            }
            this.f21947e.Z.setVisibility(8);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21948e;

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
            this.f21948e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f21948e;
                videoPlayFragment.Y1(videoPlayFragment.f21913g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21949a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f21949a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            int i2;
            int mainTabBottomBarHeight;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || !this.f21949a.J0 || customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || (tag = customResponsedMessage.getOrginalMessage().getTag()) == null || this.f21949a.f21912f.getId() != tag.getId() || !(customResponsedMessage.getData() instanceof Float) || this.f21949a.W == null) {
                return;
            }
            float floatValue = ((Float) customResponsedMessage.getData()).floatValue();
            float f2 = 0.0f;
            if (floatValue < 0.0f || floatValue > 1.0f) {
                return;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds562);
            int i3 = d.a.d.e.p.l.i(this.f21949a.f21915i.getContext());
            int d2 = d.a.d.e.m.b.d(this.f21949a.W.video_height, 0);
            int d3 = d.a.d.e.m.b.d(this.f21949a.W.video_width, 0);
            if (d2 != 0 && d3 != 0) {
                f2 = (d2 * 1.0f) / d3;
            }
            float k = d.a.d.e.p.l.k(this.f21949a.f21915i.getContext()) * f2;
            if (f2 > 1.0f) {
                float f3 = dimenPixelSize;
                i2 = (int) (((i3 - dimenPixelSize) * floatValue) + f3);
                float f4 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) (UtilHelper.getStatusBarHeight() * f4);
                this.f21949a.F0.topMargin = (int) (((i3 - d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) * 0.5f * floatValue) + (f4 * f3 * 0.5f));
            } else {
                float f5 = dimenPixelSize;
                i2 = (int) (((k - f5) * floatValue) + f5);
                float f6 = 1.0f - floatValue;
                mainTabBottomBarHeight = (int) ((((i3 - k) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (UtilHelper.getStatusBarHeight() * f6));
                this.f21949a.F0.topMargin = (int) ((((i3 - d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) * 0.5f * floatValue) + (f6 * f5 * 0.5f));
            }
            this.f21949a.p0.height = i2;
            this.f21949a.p0.topMargin = mainTabBottomBarHeight;
            this.f21949a.A.requestLayout();
            this.f21949a.k.requestLayout();
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21950e;

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
            this.f21950e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21950e.E2();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.f21950e.W.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f21950e.b2(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.f21950e.W.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.f21950e.W.nid);
                BaijiahaoData baijiahaoData = this.f21950e.W.baijiahaoData;
                if (baijiahaoData != null && !d.a.d.e.p.k.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.f21950e.W.baijiahaoData.oriUgcVid);
                }
                if (this.f21950e.W.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.f21950e.W.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.f21950e.W.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.f21950e.W.mRecomSource);
                statisticItem2.param("ab_tag", this.f21950e.W.mRecomAbTag);
                statisticItem2.param("weight", this.f21950e.W.mRecomWeight);
                statisticItem2.param("extra", this.f21950e.W.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (d.a.p0.l0.c.j(this.f21950e.getBaseFragmentActivity()) != null && d.a.p0.l0.c.j(this.f21950e.getBaseFragmentActivity()).b() != null && d.a.p0.l0.c.j(this.f21950e.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(d.a.p0.l0.c.j(this.f21950e.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21951a;

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
            this.f21951a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean)) {
                Boolean bool = (Boolean) customResponsedMessage.getData();
                if (this.f21951a.T0 != null && this.f21951a.T0.C()) {
                    this.f21951a.T0.v0(bool.booleanValue());
                }
                if (this.f21951a.J0) {
                    if (bool.booleanValue() || !this.f21951a.G0) {
                        this.f21951a.startPlay();
                        this.f21951a.m2();
                        return;
                    }
                    this.f21951a.startPlay();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21952e;

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
            this.f21952e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f21952e.getActivity())) {
                VideoPlayFragment videoPlayFragment = this.f21952e;
                if (videoPlayFragment.P != null && (videoItemData = videoPlayFragment.W) != null && videoItemData.author_info != null && videoPlayFragment.Q != null) {
                    d.a.p0.t.e.a aVar = videoPlayFragment.A0;
                    VideoPlayFragment videoPlayFragment2 = this.f21952e;
                    UserItemData userItemData = videoPlayFragment2.W.author_info;
                    aVar.m(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.B0, this.f21952e.W.forum_id, "0");
                    VideoPlayFragment videoPlayFragment3 = this.f21952e;
                    videoPlayFragment3.W.author_info.is_follow = "1";
                    videoPlayFragment3.S1();
                    this.f21952e.P.setVisibility(8);
                    this.f21952e.Q.setVisibility(0);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setStartOffset(1000L);
                    scaleAnimation.setDuration(300L);
                    scaleAnimation.setFillAfter(true);
                    this.f21952e.Q.startAnimation(scaleAnimation);
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (this.f21952e.f21911e != 3 && this.f21952e.f21911e != 4) {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_source", this.f21952e.e2());
                } else {
                    statisticItem.param("obj_locate", 1);
                }
                statisticItem.param("tid", this.f21952e.W.thread_id);
                statisticItem.param("fid", this.f21952e.W.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f21952e.b2(6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21953a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q0(VideoPlayFragment videoPlayFragment, int i2) {
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
            this.f21953a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f21953a.J0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.f21953a.f21912f.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921596 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    if (this.f21953a.G0) {
                        this.f21953a.startPlay();
                        return;
                    }
                    return;
                }
                VideoPlayFragment videoPlayFragment = this.f21953a;
                videoPlayFragment.G0 = videoPlayFragment.k.isPlaying();
                this.f21953a.m2();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class r implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21954a;

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
            this.f21954a = videoPlayFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f21954a.l == null) {
                return;
            }
            this.f21954a.l.setVisibility(8);
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
    public class r0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21955a;

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
            this.f21955a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId tag;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.f21955a.J0 && customResponsedMessage != null && customResponsedMessage.getOrginalMessage() != null && (tag = customResponsedMessage.getOrginalMessage().getTag()) != null && this.f21955a.f21912f.getId() == tag.getId() && customResponsedMessage.getCmd() == 2921598 && this.f21955a.J0) {
                this.f21955a.J0 = false;
                this.f21955a.T0.X(!this.f21955a.J0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21956e;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ s f21957e;

            public a(s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21957e = sVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21957e.f21956e.isResumed() && this.f21957e.f21956e.a0) {
                    this.f21957e.f21956e.startPlay();
                    this.f21957e.f21956e.c0 = null;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21956e = videoPlayFragment;
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
                int width = this.f21956e.l.getWidth();
                int height = this.f21956e.l.getHeight();
                if (height > 0 && width > 0) {
                    if (d.a.d.e.m.b.d(this.f21956e.W.video_height, 0) > 0 && d.a.d.e.m.b.d(this.f21956e.W.video_width, 0) > 0) {
                        float f3 = width;
                        float f4 = height;
                        float f5 = f3 / f4;
                        float c2 = d.a.d.e.m.b.c(this.f21956e.W.video_width, 0.0f) / d.a.d.e.m.b.c(this.f21956e.W.video_height, 0.0f);
                        if (c2 > 0.0f && Math.abs(c2 - f5) > 0.05d) {
                            if (c2 > f5) {
                                i3 = (int) (f3 / c2);
                                i2 = width;
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f21956e.q0, this.f21956e.r0);
                                layoutParams.leftMargin = this.f21956e.c0.left;
                                layoutParams.topMargin = this.f21956e.c0.top;
                                this.f21956e.l.setLayoutParams(layoutParams);
                                float f6 = 1.0f;
                                if (this.f21956e.r0 > 0 || this.f21956e.q0 <= 0) {
                                    f2 = 1.0f;
                                } else {
                                    f6 = i3 / this.f21956e.r0;
                                    f2 = i2 / this.f21956e.q0;
                                }
                                this.f21956e.l.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f6).scaleX(f2).translationX((width / 2.0f) - (this.f21956e.c0.left + ((this.f21956e.c0.right - this.f21956e.c0.left) / 2))).translationY((height / 2.0f) - (this.f21956e.c0.top + ((this.f21956e.c0.bottom - this.f21956e.c0.top) / 2))).start();
                                this.f21956e.l.postDelayed(new a(this), 200L);
                            }
                            i2 = (int) (f4 * c2);
                            i3 = height;
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f21956e.q0, this.f21956e.r0);
                            layoutParams2.leftMargin = this.f21956e.c0.left;
                            layoutParams2.topMargin = this.f21956e.c0.top;
                            this.f21956e.l.setLayoutParams(layoutParams2);
                            float f62 = 1.0f;
                            if (this.f21956e.r0 > 0) {
                            }
                            f2 = 1.0f;
                            this.f21956e.l.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f62).scaleX(f2).translationX((width / 2.0f) - (this.f21956e.c0.left + ((this.f21956e.c0.right - this.f21956e.c0.left) / 2))).translationY((height / 2.0f) - (this.f21956e.c0.top + ((this.f21956e.c0.bottom - this.f21956e.c0.top) / 2))).start();
                            this.f21956e.l.postDelayed(new a(this), 200L);
                        }
                    }
                }
                i2 = width;
                i3 = height;
                RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(this.f21956e.q0, this.f21956e.r0);
                layoutParams22.leftMargin = this.f21956e.c0.left;
                layoutParams22.topMargin = this.f21956e.c0.top;
                this.f21956e.l.setLayoutParams(layoutParams22);
                float f622 = 1.0f;
                if (this.f21956e.r0 > 0) {
                }
                f2 = 1.0f;
                this.f21956e.l.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f622).scaleX(f2).translationX((width / 2.0f) - (this.f21956e.c0.left + ((this.f21956e.c0.right - this.f21956e.c0.left) / 2))).translationY((height / 2.0f) - (this.f21956e.c0.top + ((this.f21956e.c0.bottom - this.f21956e.c0.top) / 2))).start();
                this.f21956e.l.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class s0 extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21958e;

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
            this.f21958e = videoPlayFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f21958e.O(0.0f, 0.0f);
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
                    this.f21958e.j();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
                this.f21958e.k();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class t implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21959e;

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
            this.f21959e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = this.f21959e.l.getWidth();
                int height = this.f21959e.l.getHeight();
                if (height <= 0 || width <= 0 || (videoItemData = this.f21959e.W) == null) {
                    return;
                }
                if (d.a.d.e.m.b.d(videoItemData.video_height, 0) <= 0 || d.a.d.e.m.b.d(this.f21959e.W.video_width, 0) <= 0) {
                    return;
                }
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                float c2 = d.a.d.e.m.b.c(this.f21959e.W.video_width, 0.0f) / d.a.d.e.m.b.c(this.f21959e.W.video_height, 0.0f);
                if (c2 > 0.0f && Math.abs(c2 - f4) > 0.05d) {
                    if (c2 > f4) {
                        height = (int) (f2 / c2);
                    } else {
                        width = (int) (f3 * c2);
                    }
                }
                ViewGroup.LayoutParams layoutParams = this.f21959e.l.getLayoutParams();
                layoutParams.height = height;
                layoutParams.width = width;
                this.f21959e.l.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class t0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f21960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21961f;

        public t0(VideoPlayFragment videoPlayFragment, GestureDetectorCompat gestureDetectorCompat) {
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
            this.f21961f = videoPlayFragment;
            this.f21960e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f21960e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class u implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21962a;

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
            this.f21962a = videoPlayFragment;
        }

        @Override // d.a.q0.x3.i.a.c
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (!z) {
                    this.f21962a.startPlay();
                } else if (this.f21962a.T0 != null) {
                    this.f21962a.T0.startPlay();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface u0 {
        void a();

        void onStart();
    }

    /* loaded from: classes4.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21963a;

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
            this.f21963a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError() && this.f21963a.isResumed() && this.f21963a.a0) {
                if (d.a.d.e.p.j.z()) {
                    if (this.f21963a.C2()) {
                        return;
                    }
                    this.f21963a.startPlay();
                    return;
                }
                d.a.d.e.p.l.L(TbadkCoreApplication.getInst(), R.string.neterror);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class w implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21964a;

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
            this.f21964a = videoPlayFragment;
        }

        @Override // d.a.q0.x3.e.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21964a.n0.setVisibility(8);
                if (z) {
                    this.f21964a.o0.setText(R.string.reply_something);
                } else {
                    this.f21964a.o0.setText(StringUtils.isNull(((d.a.q0.x3.e.c) this.f21964a.P0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                }
                VideoItemData videoItemData = this.f21964a.W;
                if (videoItemData == null || !z) {
                    return;
                }
                long f2 = d.a.d.e.m.b.f(videoItemData.comment_num, 0L) + 1;
                this.f21964a.W.comment_num = String.valueOf(f2);
                this.f21964a.K.setText(StringHelper.numberUniformFormatExtraWithRoundVote(f2));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class x extends d.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21965a;

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
            this.f21965a = videoPlayFragment;
        }

        @Override // d.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.f21965a.y0.getLoadDataMode() == 0) {
                this.f21965a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class y implements a.InterfaceC1202a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21966a;

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
            this.f21966a = videoPlayFragment;
        }

        @Override // d.a.p0.i.a.InterfaceC1202a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f21966a.z0 != null) {
                        this.f21966a.z0.h(z2);
                    }
                    VideoItemData videoItemData = this.f21966a.W;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.f21966a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.f21966a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.f21966a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21967e;

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
            this.f21967e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21967e.r.playAnimation();
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
        this.f21913g = 0;
        this.f21914h = 1;
        this.s = false;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = BdUniqueId.gen();
        this.D0 = false;
        this.G0 = true;
        this.L0 = false;
        this.M0 = 1;
        this.N0 = -1;
        this.U0 = new k(this, 2001115);
        this.V0 = new v(this, 2000994);
        this.W0 = new g0(this, 2016528);
        this.X0 = new o0(this, 2921594);
        this.Y0 = new p0(this, 2001011);
        this.Z0 = new q0(this, 2921596);
        this.a1 = new r0(this, 2921598);
        this.b1 = new c0(this);
        this.c1 = new d0(this);
        this.d1 = new e0(this);
        this.e1 = new f0(this);
        this.f1 = new h0(this);
        this.g1 = new j0(this);
        this.h1 = new l0(this);
        this.i1 = new m0(this);
        this.j1 = new n0(this);
    }

    public static /* synthetic */ int J1(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.M0;
        videoPlayFragment.M0 = i2 + 1;
        return i2;
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.a.d.e.p.j.x()) {
            d.a.q0.v3.h.d().g(getContext());
        }
    }

    public final void B2() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.w0 == null) {
                this.x0 = new d.a.p0.s.s.l(getActivity());
                this.w0 = new d.a.p0.s.s.j(getPageContext(), this.x0);
                ArrayList arrayList = new ArrayList();
                d.a.p0.s.s.h hVar = new d.a.p0.s.s.h(getString(R.string.mark), this.x0);
                boolean z2 = false;
                VideoItemData videoItemData = this.W;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    hVar.n(getResources().getString(R.string.remove_mark));
                } else {
                    hVar.n(getResources().getString(R.string.mark));
                }
                hVar.m(this.d1);
                VideoItemData videoItemData2 = this.W;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(hVar);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.W.thread_id);
                    statisticItem.param("fid", this.W.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    int i2 = this.f21911e;
                    if (i2 != 3 && i2 != 4) {
                        statisticItem.param("obj_type", 2);
                    } else {
                        statisticItem.param("obj_type", 1);
                    }
                    int i3 = this.f21911e;
                    if (i3 == 3) {
                        statisticItem.param("obj_param1", 1);
                    } else if (i3 == 4) {
                        statisticItem.param("obj_param1", 2);
                    }
                    statisticItem.param("obj_source", e2());
                    TiebaStatic.log(statisticItem);
                }
                if (l2()) {
                    d.a.p0.s.s.h hVar2 = new d.a.p0.s.s.h(getString(R.string.not_interested), this.x0);
                    hVar2.m(this.c1);
                    arrayList.add(hVar2);
                }
                d.a.p0.s.s.h hVar3 = new d.a.p0.s.s.h(getString(R.string.report_text), this.x0);
                hVar3.m(this.e1);
                arrayList.add(hVar3);
                if (this.s0) {
                    d.a.p0.s.s.h hVar4 = new d.a.p0.s.s.h(getString(R.string.delete), this.x0);
                    hVar4.m(this.f1);
                    arrayList.add(hVar4);
                }
                this.x0.m(new a0(this));
                this.w0.setOnDismissListener(new b0(this));
                this.x0.k(arrayList);
            }
            z2();
        }
    }

    public final boolean C2() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (d.a.q0.v3.h.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || !((i2 = this.f21911e) == 3 || i2 == 4 || !TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            int i3 = this.f21911e;
            if (((i3 != 3 && i3 != 4) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && d.a.d.e.p.j.x() && isResumed() && this.a0) {
                d.a.d.e.p.l.N(TbadkCoreApplication.getInst(), getResources().getString(R.string.video_no_wifi_tips), 3000);
                int i4 = this.f21911e;
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

    public void D2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_SHOW_PB_FLOAT_NUM);
            statisticItem.param("tid", this.W.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("fid", this.W.forum_id);
            int i2 = this.f21911e;
            if (i2 == 1) {
                statisticItem.param("obj_locate", 1);
            } else if (i2 == 2) {
                statisticItem.param("obj_locate", 2);
            } else if (i2 == 3) {
                statisticItem.param("obj_locate", 3);
            } else if (i2 == 4) {
                statisticItem.param("obj_locate", 4);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            d.a.q0.x3.e.a aVar = this.P0;
            if (aVar == null || aVar.a() == null || !this.P0.a().v()) {
                return false;
            }
            this.P0.a().o();
            this.n0.setVisibility(8);
            if (!(this.P0.a().n(28) instanceof d.a.q0.x3.e.c) || ((d.a.q0.x3.e.c) this.P0.a().n(28)).g() == null || ((d.a.q0.x3.e.c) this.P0.a().n(28)).g().getText() == null) {
                return true;
            }
            this.o0.setText(StringUtils.isNull(((d.a.q0.x3.e.c) this.P0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void E2() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (videoItemData = this.W) == null) {
            return;
        }
        String str3 = videoItemData.forum_id;
        String str4 = videoItemData.forum_name;
        String str5 = videoItemData.title;
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.W.baijiahaoData.oriUgcType + "&dvid=" + this.W.baijiahaoData.oriUgcVid + "&nid=" + this.W.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData.thread_id;
            str2 = "?share=9105&fr=sharewise";
        }
        String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str7 = this.W.thumbnail_url;
        String string = getResources().getString(R.string.share_content_tpl);
        String string2 = getResources().getString(R.string.default_share_content_tpl);
        VideoItemData videoItemData3 = this.W;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str5;
        shareItem.s = format;
        if (this.W.baijiahaoData == null) {
            shareItem.R = videoItemData2.play_count;
        }
        if (this.W.isBjhVideo) {
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
        shareItem.f12892f = true;
        int i2 = this.f21911e;
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
        if (this.W.getVideoType() == 1) {
            shareItem.M = 2;
        } else if (this.W.getVideoType() == 2) {
            shareItem.M = 8;
        } else if (this.W.getVideoType() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.W.isBjhVideo) {
            shareItem.g0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData4 = this.W;
        originalThreadInfo.f12279c = videoItemData4.thumbnail_url;
        originalThreadInfo.f12277a = 3;
        originalThreadInfo.f12278b = videoItemData4.title;
        originalThreadInfo.f12282f = videoItemData4.thread_id;
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
        shareDialogConfig.showDisLike = l2();
        shareDialogConfig.disLikeListener = this.b1;
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        d.a.q0.e0.f.b().k(shareDialogConfig);
    }

    public final void F2(boolean z2) {
        d.a.q0.x3.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) || (aVar = this.S0) == null) {
            return;
        }
        aVar.c(k2());
        this.S0.d(getPageContext(), this.W, z2);
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.g
    public void L0(TbCyberVideoView.VideoStatus videoStatus) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, videoStatus) == null) {
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                RelativeLayout relativeLayout = this.B;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView3 = this.Z;
                if (videoMiddleNiaiControllerView3 != null) {
                    videoMiddleNiaiControllerView3.setLoading(false);
                }
                u0 u0Var = this.R0;
                if (u0Var != null) {
                    u0Var.onStart();
                }
                TbImageView tbImageView = this.l;
                if (tbImageView != null) {
                    tbImageView.setVisibility(8);
                }
            }
            if (videoStatus == TbCyberVideoView.VideoStatus.VIDEO_PAUSING && (videoMiddleNiaiControllerView2 = this.Z) != null) {
                videoMiddleNiaiControllerView2.setLoading(false);
            }
            if (videoStatus != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING || (videoMiddleNiaiControllerView = this.Z) == null) {
                return;
            }
            videoMiddleNiaiControllerView.setLoading(true);
        }
    }

    @Override // d.a.p0.d1.p.a.b
    public void O(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity())) {
            X1();
            VideoItemData videoItemData = this.W;
            if (videoItemData == null || !"0".equals(videoItemData.is_agreed)) {
                return;
            }
            Y1(this.f21914h);
        }
    }

    @Override // d.a.q0.x3.h.a.a
    public void Q(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.N0 = i2;
        }
    }

    public final void R1() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (videoItemData = this.W) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.i0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.i0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.L.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.d.e.m.b.f(this.W.agree_num, 0L)));
    }

    public final void S1() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (!this.s0 && ((userItemData = this.W.author_info) == null || !"1".equals(userItemData.is_follow))) {
                this.P.setVisibility(0);
                this.P.setClickable(true);
                this.Q.setVisibility(8);
                return;
            }
            this.P.setVisibility(4);
            this.P.setClickable(false);
            this.Q.setVisibility(8);
        }
    }

    public final void T1(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z2) == null) || (videoMiddleNiaiControllerView = this.Z) == null) {
            return;
        }
        int i2 = this.f21911e;
        videoMiddleNiaiControllerView.setBottomBarShow(z2, (i2 == 3 || i2 == 4) ? 1 : 0);
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.z == null || this.y == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        this.y.clearAnimation();
        this.z.clearAnimation();
        this.y.setVisibility(8);
        this.z.setVisibility(0);
        this.z.startAnimation(scaleAnimation2);
        this.y.startAnimation(scaleAnimation);
    }

    public final void V1() {
        VideoItemData videoItemData;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (videoItemData = this.W) == null) {
            return;
        }
        this.l.M(videoItemData.thumbnail_url, 10, false);
        if (!StringUtils.isNull(this.W.title)) {
            str = this.W.title;
        } else {
            str = !StringUtils.isNull(this.W.abstext) ? this.W.abstext : "";
        }
        boolean z2 = d.a.d.e.m.b.d(this.W.video_height, 0) <= d.a.d.e.m.b.d(this.W.video_width, 0);
        if (StringUtils.isNull(str) && (!z2 || this.W.video_duration < 60)) {
            this.J.setVisibility(8);
        } else {
            if (z2 && this.W.video_duration >= 60) {
                this.I.setVisibility(0);
                int i2 = this.W.video_duration;
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
                d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.H);
                d2.x(R.dimen.T_X09);
                d2.t(R.color.CAM_X0621);
                this.H.setText(sb.toString());
            } else {
                this.I.setVisibility(8);
            }
            this.J.setVisibility(0);
            this.G.setTextSize(d.a.d.e.p.l.g(getContext(), R.dimen.T_X07));
            this.G.setTextColor(R.color.CAM_X0621);
            this.G.setLineSpacingExtra(d.a.d.e.p.l.g(getContext(), R.dimen.tbds10));
            this.G.setExpandable(false);
            this.G.setTextMaxLine(3);
            this.G.setLimitLine(3);
            this.G.setOnStatusChangedListener(new i0(this));
            ExpandableTextView expandableTextView = this.G;
            VideoItemData videoItemData2 = this.W;
            expandableTextView.setData(str, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        this.K.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.d.e.m.b.f(this.W.comment_num, 0L)));
        this.L.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.d.e.m.b.f(this.W.agree_num, 0L)));
        this.M.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.d.e.m.b.f(this.W.share_num, 0L)));
        UserItemData userItemData = this.W.author_info;
        if (userItemData != null) {
            if (!TextUtils.isEmpty(userItemData.bjhAvatar)) {
                this.q.M(this.W.author_info.bjhAvatar, 12, false);
            } else if (!StringUtils.isNull(this.W.author_info.portrait) && this.W.author_info.portrait.startsWith("http")) {
                this.q.M(this.W.author_info.portrait, 10, false);
            } else {
                this.q.M(this.W.author_info.portrait, 12, false);
            }
            if (StringUtils.isNull(this.W.author_info.getUserShowName())) {
                this.l0.setVisibility(8);
            } else {
                this.l0.setVisibility(0);
                this.l0.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.W.author_info.getUserShowName(), 16, StringHelper.STRING_MORE));
            }
            if (!StringUtils.isNull(this.W.forum_name) && d.a.p0.b.d.k0()) {
                this.m0.setVisibility(0);
                TextView textView = this.m0;
                textView.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.W.forum_name + TbadkCoreApplication.getInst().getString(R.string.bar_default_name), 16, StringHelper.STRING_MORE));
            } else {
                this.m0.setVisibility(8);
            }
        }
        AlaInfoData alaInfoData = this.W.mAlaInfoData;
        if (alaInfoData != null && alaInfoData.isLegalYYLiveData()) {
            h2(this.W.mAlaInfoData.live_status == 1);
            g2();
        }
        if ("1".equals(this.W.is_private) && this.Y.getVisibility() != 0) {
            this.V.setVisibility(0);
        } else {
            this.V.setVisibility(8);
        }
        if ("1".equals(this.W.is_agreed)) {
            this.i0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.i0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.W.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.Y.getVisibility() != 0) {
            this.U.setVisibility(0);
            this.R.setText(this.W.act_info.activity_name);
        } else {
            this.U.setVisibility(8);
        }
        S1();
        b2 b2Var = this.W.threadData;
        if (b2Var != null) {
            if (TextUtils.isEmpty(b2Var.getRecomReason())) {
                this.D.setVisibility(8);
                return;
            }
            this.D.setVisibility(0);
            this.F.setText(this.W.threadData.getRecomReason());
            this.E.M(this.W.threadData.Y0, 10, false);
        }
    }

    public final boolean W1(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f21915i == null || this.D0) {
            return;
        }
        this.D0 = true;
        this.K0 = new TBLottieAnimationView(this.f21915i.getContext());
        if (this.E0 == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
            this.E0 = layoutParams;
            layoutParams.addRule(13);
        }
        SkinManager.setLottieAnimation(this.K0, R.raw.lottie_agree_big_photo);
        View view = this.f21915i;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(this.K0, this.E0);
        }
        this.K0.addAnimatorListener(new k0(this));
        this.K0.playAnimation();
    }

    public final void Y1(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.W) != null) {
            int i3 = 0;
            if (i2 == this.f21913g) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.W;
                    videoItemData2.agree_num = String.valueOf(d.a.d.e.m.b.d(videoItemData2.agree_num, 0) - 1);
                    this.W.is_agreed = "0";
                    i3 = 1;
                } else {
                    VideoItemData videoItemData3 = this.W;
                    videoItemData3.agree_num = String.valueOf(d.a.d.e.m.b.d(videoItemData3.agree_num, 0) + 1);
                    this.W.is_agreed = "1";
                    X1();
                    b2(1);
                }
            } else {
                videoItemData.agree_num = String.valueOf(d.a.d.e.m.b.d(videoItemData.agree_num, 0) + 1);
                this.W.is_agreed = "1";
                b2(1);
            }
            StatisticItem statisticItem = new StatisticItem("c12795");
            statisticItem.param("tid", this.W.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f21913g) {
                statisticItem.param("obj_type", i3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c12003");
            statisticItem2.param("tid", this.W.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f21913g) {
                statisticItem2.param("obj_type", i3);
            } else {
                statisticItem2.param("obj_type", 2);
            }
            if ("index".equals(this.u0)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            d.a.p0.k0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                if (i2 == this.f21913g) {
                    statisticItem3.param("obj_type", i3);
                } else {
                    statisticItem3.param("obj_type", 2);
                }
                int i4 = this.f21911e;
                if (i4 != 3 && i4 != 4) {
                    statisticItem3.param("obj_locate", 2);
                } else {
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("obj_source", e2());
                }
                statisticItem3.param("tid", this.W.thread_id);
                statisticItem3.param("fid", this.W.forum_id);
                int i5 = this.f21911e;
                if (i5 == 3) {
                    statisticItem3.param("obj_param1", 1);
                } else if (i5 == 4) {
                    statisticItem3.param("obj_param1", 2);
                }
                TiebaStatic.log(statisticItem3);
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem2);
            V1();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.W.thread_id);
            httpMessage.addParam("op_type", i3);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            BaijiahaoData baijiahaoData = this.W.baijiahaoData;
            if (baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.W.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.W.baijiahaoData.oriUgcVid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.W.baijiahaoData.oriUgcType);
            }
            if (k2 != null) {
                httpMessage.addParam("obj_source", k2.a());
            }
            sendMessage(httpMessage);
            d.a.q0.h3.h0.e eVar = new d.a.q0.h3.h0.e();
            AgreeData agreeData = new AgreeData();
            String str = this.W.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.W.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.W.is_agreed);
            eVar.f58547b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.W));
        }
    }

    public final void Z1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z2) == null) {
            if (z2) {
                this.u.setVisibility(8);
                this.S.setVisibility(8);
                this.v.setVisibility(8);
                this.w.setVisibility(8);
                this.t.setVisibility(8);
                this.x.setVisibility(0);
                return;
            }
            this.u.setVisibility(0);
            this.S.setVisibility(0);
            this.v.setVisibility(0);
            this.w.setVisibility(0);
            this.t.setVisibility(0);
            this.x.setVisibility(8);
        }
    }

    public final void a2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.W == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.W.thread_id);
        statisticItem.param("nid", this.W.nid);
        statisticItem.param("fid", this.W.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.t0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", d.a.d.e.p.k.isEmpty(this.W.mRecomWeight) ? "0" : this.W.mRecomWeight);
        statisticItem.param("extra", d.a.d.e.p.k.isEmpty(this.W.mRecomExtra) ? "0" : this.W.mRecomExtra);
        statisticItem.param("obj_id", this.H0);
        statisticItem.param("ab_tag", d.a.d.e.p.k.isEmpty(this.W.mRecomAbTag) ? "0" : this.W.mRecomAbTag);
        statisticItem.param("obj_source", d.a.d.e.p.k.isEmpty(this.W.mRecomSource) ? "0" : this.W.mRecomSource);
        statisticItem.param("obj_type", this.u0);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.W.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.W.baijiahaoData.oriUgcVid);
            int i2 = this.W.baijiahaoData.oriUgcType;
            if (i2 == 4) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        int i3 = this.f21911e;
        if (i3 == 3 || i3 == 4) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.W.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.u0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.v0);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void b2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.W.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            int i3 = this.f21911e;
            if (i3 != 3 && i3 != 4) {
                statisticItem.param("obj_locate", 2);
            } else {
                statisticItem.param("obj_locate", 1);
            }
            statisticItem.param("obj_type", i2);
            int i4 = this.f21911e;
            if (i4 == 3) {
                statisticItem.param("obj_source", 1);
            } else if (i4 == 4) {
                statisticItem.param("obj_source", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // d.a.q0.x3.h.a.a
    public VideoItemModel c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.X : (VideoItemModel) invokeV.objValue;
    }

    public String c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<String> d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.u0)) {
                return 0;
            }
            String str = this.u0;
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

    public final void f2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.W == null) {
            return;
        }
        PbCommentFloatActivityConfig pbCommentFloatActivityConfig = new PbCommentFloatActivityConfig(getActivity());
        VideoItemData videoItemData = this.W;
        PbCommentFloatActivityConfig createNormalCfg = pbCommentFloatActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.W.forum_id));
        createNormalCfg.setForumName(this.W.forum_name);
        createNormalCfg.setVideo_source("nani_midpage");
        createNormalCfg.setBjhData(this.W.baijiahaoData);
        int i2 = this.f21911e;
        createNormalCfg.setFromPageType((i2 == 3 || i2 == 4) ? 1 : 2);
        createNormalCfg.setFromVideoPageType(this.f21911e);
        createNormalCfg.setFromVideoPageUniqueId(this.f21912f);
        if (this.W.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            if (this.W.threadData.H() != null) {
                VideoItemData videoItemData2 = this.W;
                if (videoItemData2.author_info != null) {
                    videoItemData2.threadData.H().setIsLike("1".equals(this.W.author_info.is_follow));
                }
            }
            createNormalCfg.setNeedPreLoad(true);
            d.a.q0.u0.l.c(this.W.threadData);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createNormalCfg));
        this.J0 = true;
        this.G0 = this.k.isPlaying();
        this.T0.X(!this.J0);
        D2();
    }

    public final void g2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (tBLottieAnimationView = this.r) == null) {
            return;
        }
        SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
    }

    public final void h2(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            int g2 = d.a.d.e.p.l.g(getContext(), R.dimen.tbds26);
            if (this.s != z2) {
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
                            this.r.post(new z(this));
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
                this.s = z2;
            }
        }
    }

    public void i2() {
        d.a.p0.s.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && (jVar = this.w0) != null && jVar.isShowing()) {
            this.w0.dismiss();
        }
    }

    @Override // d.a.p0.d1.p.a.b
    public void j() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (videoItemData = this.W) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long f2 = d.a.d.e.m.b.f(userItemData.user_id, 0L);
        long f3 = d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = f2 == f3;
        if (f2 == 0 && f3 == 0) {
            z2 = false;
        }
        d.a.q0.x3.d.a.a();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(f2, z2, false)));
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            d.a.q0.x3.e.a aVar = (d.a.q0.x3.e.a) new d.a.q0.x3.e.b().a(getActivity());
            this.P0 = aVar;
            if (aVar == null || this.W == null) {
                return;
            }
            aVar.s(getPageContext());
            d.a.q0.x3.e.a aVar2 = this.P0;
            VideoItemData videoItemData = this.W;
            aVar2.t(videoItemData.thread_id, videoItemData.forum_id, videoItemData.forum_name);
            this.P0.u(new w(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.f21915i).addView(this.P0.a(), layoutParams);
        }
    }

    @Override // d.a.p0.d1.p.a.b
    public void k() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (tbCyberVideoView = this.k) != null && tbCyberVideoView.M()) {
            if (this.k.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_BUFFERING && this.k.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PLAYING) {
                if (this.k.getVideoStatus() != TbCyberVideoView.VideoStatus.VIDEO_PAUSING || C2()) {
                    return;
                }
                this.k.start();
                this.A.setVisibility(8);
                T1(true);
                this.Z.s();
                if (isResumed() && this.a0) {
                    return;
                }
                m2();
                return;
            }
            this.k.pause();
            this.A.setVisibility(0);
            T1(false);
            d.a.d.e.m.e.a().removeCallbacks(this.g1);
            b2(4);
        }
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            int i2 = this.f21911e;
            return i2 == 1 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            VideoItemData videoItemData = this.W;
            return (videoItemData == null || (sparseArray = videoItemData.feedBackReasonMap) == null || sparseArray.size() == 0 || this.f21911e != 3) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void m2() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (tbCyberVideoView = this.k) == null) {
            return;
        }
        tbCyberVideoView.pause();
    }

    @Override // d.a.q0.x3.h.a.a
    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.N0 : invokeV.intValue;
    }

    public final void n2(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048612, this, i2) == null) && this.W != null && this.c0 == null) {
            StatisticItem statisticItem = new StatisticItem("c12794");
            statisticItem.param("tid", this.W.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.W.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            statisticItem2.param("page_type", "a023");
            statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
            TiebaStatic.log(statisticItem2);
        }
    }

    public final void o2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || this.W == null) {
            return;
        }
        d.a.q0.n2.o oVar = new d.a.q0.n2.o();
        oVar.f61423a = "nani_midpage";
        VideoItemData videoItemData = this.W;
        oVar.f61425c = videoItemData.thread_id;
        oVar.t = videoItemData.nid;
        oVar.f61426d = this.W.forum_id + "";
        oVar.f61427e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.W;
        oVar.f61428f = videoItemData2.mRecomSource;
        oVar.f61429g = videoItemData2.mRecomAbTag;
        oVar.f61430h = videoItemData2.mRecomWeight;
        oVar.f61431i = "";
        oVar.k = "";
        oVar.m = videoItemData2.mMd5;
        if (this.c0 != null) {
            oVar.n = "1";
        } else {
            oVar.n = "2";
        }
        int i2 = this.f21911e;
        if (i2 == 1 || i2 == 2) {
            oVar.p = "1";
            oVar.f61423a = "auto_midpage";
            oVar.f61431i = "index";
        }
        d.a.q0.n2.h.e(this.W.mMd5, "", "1", oVar, this.k.getPcdnState());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.s0) {
                ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
                this.y0 = forumManageModel;
                forumManageModel.setLoadDataCallBack(new x(this));
            }
            d.a.p0.i.a c2 = d.a.p0.i.a.c(getBaseFragmentActivity());
            this.z0 = c2;
            if (c2 != null) {
                c2.j(new y(this));
            }
            this.A0 = new d.a.p0.t.e.a(null);
            registerListener(this.U0);
            registerListener(this.V0);
            registerListener(this.X0);
            registerListener(this.Y0);
            registerListener(this.Z0);
            registerListener(this.a1);
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.L0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048615, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            r0(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.q0.x3.e.a aVar = this.P0;
            if (aVar != null && aVar.a() != null) {
                this.P0.a().w(i2);
            }
            d.a.p0.s.s.l lVar = this.x0;
            if (lVar != null) {
                lVar.j();
            }
            if (this.f21915i != null) {
                this.j0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.k0.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.z.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.A.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                this.C.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_header40_n, d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0213), 0.2f), null));
                R1();
                d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(this.n0);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0614);
                d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(this.N);
                d3.y(R.string.F_X02);
                d3.t(R.color.CAM_X0101);
                d.a.p0.s.u.c.d(this.O).y(R.string.F_X02);
                d.a.p0.s.u.c d4 = d.a.p0.s.u.c.d(this.M);
                d4.x(R.dimen.T_X09);
                d4.y(R.string.F_X02);
                d4.w(R.array.S_O_X001);
                d.a.p0.s.u.c d5 = d.a.p0.s.u.c.d(this.L);
                d5.x(R.dimen.T_X09);
                d5.y(R.string.F_X02);
                d5.w(R.array.S_O_X001);
                d.a.p0.s.u.c d6 = d.a.p0.s.u.c.d(this.K);
                d6.x(R.dimen.T_X09);
                d6.y(R.string.F_X02);
                d6.w(R.array.S_O_X001);
                d.a.p0.s.u.c d7 = d.a.p0.s.u.c.d(this.l0);
                d7.x(R.dimen.T_X06);
                d7.y(R.string.F_X02);
                d7.w(R.array.S_O_X001);
                d.a.p0.s.u.c d8 = d.a.p0.s.u.c.d(this.m0);
                d8.x(R.dimen.T_X09);
                d8.y(R.string.F_X01);
                d8.t(R.color.CAM_X0619);
                d8.w(R.array.S_O_X001);
                d.a.p0.s.u.c d9 = d.a.p0.s.u.c.d(this.P);
                d9.n(R.string.J_X01);
                d9.x(R.dimen.T_X09);
                d9.t(R.color.CAM_X0101);
                d9.y(R.string.F_X02);
                d9.f(R.color.CAM_X0302);
                d.a.p0.s.u.c d10 = d.a.p0.s.u.c.d(this.Q);
                d10.n(R.string.J_X01);
                d10.x(R.dimen.T_X09);
                d10.f(R.color.CAM_X0302);
                this.O.setTextColor(d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.p0.s.u.a.a(R.string.A_X08)));
                this.L.setTextColor(d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.p0.s.u.a.a(R.string.A_X03)));
                this.M.setTextColor(d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.p0.s.u.a.a(R.string.A_X03)));
                this.K.setTextColor(d.a.q0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.p0.s.u.a.a(R.string.A_X03)));
            }
            WebPManager.setPureDrawable(this.n, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.o, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            g2();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.a0) {
                boolean z2 = d.a.d.e.m.b.d(this.W.video_height, 0) <= d.a.d.e.m.b.d(this.W.video_width, 0);
                d.a.q0.x3.i.a aVar = this.T0;
                if (aVar == null || !z2) {
                    return;
                }
                if (!(aVar.C() && configuration.orientation == 1) && (this.T0.C() || configuration.orientation != 2)) {
                    return;
                }
                this.j.removeView(this.k);
                this.T0.U(false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.W0);
            this.S0 = new d.a.q0.x3.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048619, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            VideoItemModel videoItemModel = (VideoItemModel) arguments.get("video_data");
            this.X = videoItemModel;
            this.W = videoItemModel == null ? null : videoItemModel.getVideoItemData();
            this.c0 = (Rect) arguments.getParcelable("video_cover_rect");
            this.t0 = arguments.getInt("video_index");
            arguments.getString("page_from");
            this.u0 = arguments.getString("from");
            this.v0 = arguments.getString("video_channel_tab");
            this.H0 = arguments.getString("obj_id");
            this.f21912f = (BdUniqueId) arguments.getSerializable(VideoPlayActivityConfig.ACTIVITY_PAGE_UNIQUEID);
            this.f21911e = arguments.getInt("current_type");
            VideoItemData videoItemData = this.W;
            boolean z2 = true;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.W.author_info.user_id)) {
                this.s0 = true;
            }
            this.f21915i = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
            this.f21915i.setOnTouchListener(new t0(this, new GestureDetectorCompat(getContext(), new s0(this))));
            this.f21915i.setOnLongClickListener(new a(this));
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.k = tbCyberVideoView;
            tbCyberVideoView.setVideoStatusChangeListener(this);
            this.k.setStageType("2005");
            this.k.getMediaProgressObserver().j(new b(this));
            TbImageView tbImageView = (TbImageView) this.f21915i.findViewById(R.id.video_cover);
            this.l = tbImageView;
            tbImageView.setDefaultBgResource(R.color.transparent);
            this.A = (ImageView) this.f21915i.findViewById(R.id.play_btn);
            this.B = (RelativeLayout) this.f21915i.findViewById(R.id.video_loading_layout);
            this.C = (ImageView) this.f21915i.findViewById(R.id.video_loading_icon);
            this.l.setEvent(new c(this));
            u2();
            this.m = this.f21915i.findViewById(R.id.top_container);
            int statusBarHeight = UtilHelper.getStatusBarHeight();
            if (this.m.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.m.getLayoutParams()).topMargin = statusBarHeight;
            }
            ImageView imageView = (ImageView) this.f21915i.findViewById(R.id.back_btn);
            this.n = imageView;
            imageView.setVisibility(8);
            ImageView imageView2 = (ImageView) this.f21915i.findViewById(R.id.more_btn);
            this.o = imageView2;
            imageView2.setVisibility(8);
            this.j = (RelativeLayout) this.f21915i.findViewById(R.id.video_play_view_container);
            this.p = this.f21915i.findViewById(R.id.portrait_container);
            LinearLayout linearLayout = (LinearLayout) this.f21915i.findViewById(R.id.recommend_layout);
            this.D = linearLayout;
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(linearLayout);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            d.a.p0.s.u.b bVar = (d.a.p0.s.u.b) this.D.getBackground();
            bVar.B(SkinManager.getColor(0, R.color.CAM_X0106));
            this.D.setBackground(bVar);
            d.a.p0.s.u.c.d(this.D).e(R.string.A_X07);
            BarImageView barImageView = (BarImageView) this.f21915i.findViewById(R.id.recommend_forum_avatar);
            this.E = barImageView;
            barImageView.setShowOval(true);
            this.F = (TextView) this.f21915i.findViewById(R.id.recommend_info_view);
            HeadImageView headImageView = (HeadImageView) this.f21915i.findViewById(R.id.author_portrait);
            this.q = headImageView;
            headImageView.setDefaultResource(17170445);
            this.q.setPlaceHolder(2);
            this.q.setIsRound(true);
            this.q.setBorderWidth(R.dimen.L_X02);
            this.q.setBorderColor(R.color.CAM_X0622);
            this.q.setDrawBorder(true);
            t2();
            this.r = (TBLottieAnimationView) this.f21915i.findViewById(R.id.user_living_lottie);
            this.S = (RelativeLayout) this.f21915i.findViewById(R.id.author_info_container);
            this.t = (LinearLayout) this.f21915i.findViewById(R.id.bottom_container);
            this.P = (EMTextView) this.f21915i.findViewById(R.id.love_btn);
            this.Q = (EMTextView) this.f21915i.findViewById(R.id.has_love);
            r2();
            this.i0 = (ImageView) this.f21915i.findViewById(R.id.agree_img);
            this.G = (ExpandableTextView) this.f21915i.findViewById(R.id.video_title);
            this.H = (TextView) this.f21915i.findViewById(R.id.title_full_screen_text);
            this.I = this.f21915i.findViewById(R.id.title_full_screen_btn);
            this.J = this.f21915i.findViewById(R.id.video_title_layout);
            this.Z = (VideoMiddleNiaiControllerView) this.f21915i.findViewById(R.id.media_controller);
            this.R = (TextView) this.f21915i.findViewById(R.id.video_activity);
            this.v = (LinearLayout) this.f21915i.findViewById(R.id.comment_container);
            this.K = (EMTextView) this.f21915i.findViewById(R.id.comment_num);
            this.j0 = (ImageView) this.f21915i.findViewById(R.id.comment_img);
            this.u = (LinearLayout) this.f21915i.findViewById(R.id.agree_container);
            this.x = (LinearLayout) this.f21915i.findViewById(R.id.ll_drag_container);
            this.w = (LinearLayout) this.f21915i.findViewById(R.id.share_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            int i2 = this.f21911e;
            if (i2 != 4 && i2 != 3) {
                this.Z.t(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
            } else {
                this.Z.t(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            }
            this.L = (EMTextView) this.f21915i.findViewById(R.id.agree_num);
            this.k0 = (ImageView) this.f21915i.findViewById(R.id.share_img);
            this.M = (EMTextView) this.f21915i.findViewById(R.id.share_num);
            this.N = (EMTextView) this.f21915i.findViewById(R.id.drag_cur_time);
            this.O = (EMTextView) this.f21915i.findViewById(R.id.drag_total_time);
            this.y = (ImageView) this.f21915i.findViewById(R.id.share_img);
            this.z = (ImageView) this.f21915i.findViewById(R.id.share_img_changed);
            p2();
            this.T = (LinearLayout) this.f21915i.findViewById(R.id.video_act_private_container);
            this.U = (LinearLayout) this.f21915i.findViewById(R.id.video_activity_container);
            this.V = (LinearLayout) this.f21915i.findViewById(R.id.video_private);
            this.l0 = (TextView) this.f21915i.findViewById(R.id.video_author_name);
            this.m0 = (TextView) this.f21915i.findViewById(R.id.video_bar_name);
            View findViewById = this.f21915i.findViewById(R.id.quick_reply_comment_layout);
            this.n0 = findViewById;
            findViewById.setOnClickListener(new d(this));
            if (this.W != null) {
                this.Z.setVisibility(0);
            }
            this.Z.setPlayer(this.k);
            this.Z.setOnSeekBarChangeListener(new e(this));
            this.o0 = (TextView) this.f21915i.findViewById(R.id.quick_reply_comment_text);
            TextView textView = (TextView) this.f21915i.findViewById(R.id.download_nani_guide_txt);
            this.Y = textView;
            textView.setVisibility(8);
            String p2 = d.a.p0.s.d0.b.j().p("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(p2)) {
                this.Y.setText(p2);
            }
            this.Y.setOnClickListener(new f(this, d.a.p0.s.d0.b.j().p("nani_key_download_link_url", null)));
            V1();
            g gVar = new g(this);
            this.p.setOnClickListener(gVar);
            this.l0.setOnClickListener(gVar);
            this.U.setOnClickListener(new h(this));
            this.G.setHasDown();
            this.G.setOnClickListener(new i(this));
            this.I.setOnClickListener(new j(this));
            this.n.setOnClickListener(new l(this));
            this.o.setOnClickListener(new m(this));
            this.v.setOnClickListener(new n(this));
            this.u.setOnClickListener(new o(this));
            this.w.setOnClickListener(new p(this));
            this.P.setOnClickListener(new q(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.b0 = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.b0.setAnimationListener(new r(this));
            this.B.setVisibility(0);
            this.Z.setLoading(true);
            Rect rect = this.c0;
            if (rect != null) {
                this.q0 = rect.right - rect.left;
                this.r0 = rect.bottom - rect.top;
                this.l.post(new s(this));
            } else {
                this.l.post(new t(this));
            }
            j2();
            if (this.a0) {
                a2();
            }
            VideoItemData videoItemData2 = this.W;
            if (videoItemData2 != null && !StringUtils.isNull(videoItemData2.video_url)) {
                w2(this.W.video_url);
            }
            d.a.q0.x3.i.a aVar = new d.a.q0.x3.i.a(getContext(), this.j);
            this.T0 = aVar;
            aVar.setStageType("2005");
            this.T0.setUniqueId(getUniqueId());
            VideoItemData videoItemData3 = this.W;
            if (videoItemData3 != null && videoItemData3.threadData == null) {
                videoItemData3.threadData = new b2();
                VideoItemData videoItemData4 = this.W;
                b2 b2Var = videoItemData4.threadData;
                b2Var.A = videoItemData4.thread_id;
                b2Var.Z = 40;
                b2Var.U3(d.a.d.e.m.b.d(videoItemData4.comment_num, 0));
                VideoInfo.Builder builder = new VideoInfo.Builder();
                builder.video_width = Integer.valueOf(d.a.d.e.m.b.d(this.W.video_width, 0));
                builder.video_height = Integer.valueOf(d.a.d.e.m.b.d(this.W.video_height, 0));
                VideoItemData videoItemData5 = this.W;
                builder.video_url = videoItemData5.video_url;
                builder.thumbnail_url = videoItemData5.thumbnail_url;
                builder.video_md5 = videoItemData5.mMd5;
                builder.is_vertical = Integer.valueOf(videoItemData5.isVerticalVideo);
                this.W.threadData.m4(builder.build(true));
            }
            VideoItemData videoItemData6 = this.W;
            if (videoItemData6 != null) {
                this.T0.setData(videoItemData6.threadData);
                this.T0.X((this.a0 && (d.a.d.e.m.b.d(this.W.video_height, 0) <= d.a.d.e.m.b.d(this.W.video_width, 0))) ? false : false);
                this.T0.H0(new u(this));
                this.T0.E().setVisibility(8);
            }
            return this.f21915i;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            stopPlay();
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.W0);
            d.a.q0.x3.i.a aVar = this.T0;
            if (aVar != null) {
                aVar.G0();
            }
            d.a.q0.x3.e.a aVar2 = this.P0;
            if (aVar2 != null) {
                aVar2.o();
            }
            if (this.g1 != null) {
                d.a.d.e.m.e.a().removeCallbacks(this.g1);
                this.g1 = null;
            }
            d.a.q0.x3.a aVar3 = this.S0;
            if (aVar3 != null) {
                aVar3.b();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            super.onPause();
            if (!this.J0) {
                m2();
            }
            d.a.q0.x3.e.a aVar = this.P0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.P0.a().o();
            this.n0.setVisibility(8);
            this.o0.setText(StringUtils.isNull(((d.a.q0.x3.e.c) this.P0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        AlaInfoData alaInfoData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            super.onPrimary();
            if (isResumed() && this.a0) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.W;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.video_url)) {
                    if (this.a0) {
                        o2();
                        q2();
                        n2(0);
                    } else {
                        m2();
                    }
                }
                VideoItemData videoItemData2 = this.W;
                if (videoItemData2 == null || (alaInfoData = videoItemData2.mAlaInfoData) == null || !alaInfoData.isLegalYYLiveData() || this.W.mAlaInfoData.live_status != 1) {
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_YY_PORTRAIT_IN_VIDEO_LIST_SHOW);
                statisticItem.addParam("tid", this.W.getThreadId());
                UserItemData userItemData = this.W.author_info;
                if (userItemData != null) {
                    statisticItem.addParam("obj_id", userItemData.user_id);
                    statisticItem.addParam("obj_name", this.W.author_info.user_name);
                }
                TiebaStatic.log(statisticItem);
                return;
            }
            m2();
            d.a.q0.x3.e.a aVar = this.P0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.P0.a().o();
            this.n0.setVisibility(8);
            this.o0.setText(StringUtils.isNull(((d.a.q0.x3.e.c) this.P0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            super.onStart();
            if (this.J0) {
                q2();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onStop();
            m2();
            d.a.q0.x3.e.a aVar = this.P0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.P0.a().o();
            this.n0.setVisibility(8);
            this.o0.setText(StringUtils.isNull(((d.a.q0.x3.e.c) this.P0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            V1();
            v2();
        }
    }

    public final void p2() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048626, this) == null) || this.z == null || (imageView = this.y) == null) {
            return;
        }
        imageView.clearAnimation();
        this.z.clearAnimation();
        this.y.setVisibility(0);
        this.z.setVisibility(8);
    }

    public final void q2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048627, this) == null) || C2()) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.k;
        if (tbCyberVideoView != null && this.A != null && this.W != null) {
            if (tbCyberVideoView.getParent() == null) {
                u2();
                v2();
            }
            if (TbVideoViewSet.d().e(this.C0) == null || TbVideoViewSet.d().e(this.C0) != this.k) {
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.Z;
                if (videoMiddleNiaiControllerView != null) {
                    videoMiddleNiaiControllerView.q();
                }
                this.k.setVideoPath(this.C0, this.W.thread_id);
            }
            this.k.V(null);
            this.Z.s();
            this.A.setVisibility(8);
            A2();
        }
        if (isResumed() && this.a0 && this.G0) {
            return;
        }
        m2();
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    public void r0(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048628, this, i2, i3, intent) == null) {
            d.a.q0.x3.e.a aVar = this.P0;
            if (aVar != null) {
                aVar.n(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                d.a.q0.v2.a.g().m(getPageContext());
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

    public final void r2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || this.Q == null) {
            return;
        }
        Drawable drawable = getPageContext().getResources().getDrawable(R.drawable.icon_pure_followed);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds29), UtilHelper.getDimenPixelSize(R.dimen.tbds18));
        this.Q.setCompoundDrawables(drawable, null, null, null);
    }

    public void s2(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, cVar) == null) {
            this.Q0 = cVar;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.a0 = z2;
            if (this.T0 != null && (videoItemData = this.W) != null) {
                this.T0.X(this.a0 && (d.a.d.e.m.b.d(videoItemData.video_height, 0) <= d.a.d.e.m.b.d(this.W.video_width, 0)));
            }
            if (!z2 && this.P0 != null) {
                this.o0.setText(R.string.reply_something);
                this.P0.l();
            }
            if (isResumed() && this.a0 && (!this.L0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                n2(1);
                startPlay();
                a2();
                this.L0 = false;
            } else if (!this.J0) {
                p2();
                this.M0 = 1;
                m2();
            }
            if (VideoPlayActivity.mIsNeedShowCommentFloat && z2) {
                f2();
                VideoPlayActivity.mIsNeedShowCommentFloat = false;
            }
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || C2()) {
            return;
        }
        A2();
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TbCyberVideoView tbCyberVideoView = this.k;
        if (tbCyberVideoView != null && this.A != null && this.W != null && tbCyberVideoView.getParent() == null) {
            u2();
            v2();
        }
        if (Build.VERSION.SDK_INT < 17 && this.l.getVisibility() == 0) {
            this.l.clearAnimation();
            this.l.startAnimation(this.b0);
        }
        if (this.k != null && !TextUtils.isEmpty(this.C0) && this.W != null) {
            if (TbVideoViewSet.d().e(this.C0) == null || TbVideoViewSet.d().e(this.C0) != this.k) {
                this.k.setVideoPath(this.C0, this.W.thread_id);
            }
            this.k.start();
            this.Z.s();
            o2();
        }
        if (this.J0) {
            return;
        }
        if ((isResumed() && this.a0) || this.G0) {
            return;
        }
        m2();
        ImageView imageView2 = this.A;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048633, this) == null) || (tbCyberVideoView = this.k) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }

    public final void t2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.q.getLayoutParams();
            if (!d.a.p0.b.d.k0()) {
                if (layoutParams != null) {
                    layoutParams.width = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                    layoutParams2.width = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                    layoutParams.height = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                    layoutParams2.height = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds94);
                }
            } else if (layoutParams == null || layoutParams2 == null) {
            } else {
                layoutParams.width = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                layoutParams2.width = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                layoutParams.height = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
                layoutParams2.height = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds104);
            }
        }
    }

    public void u2() {
        TbCyberVideoView tbCyberVideoView;
        TbCyberVideoView tbCyberVideoView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048635, this) == null) && (tbCyberVideoView = this.k) != null && tbCyberVideoView.getParent() == null) {
            VideoItemData videoItemData = this.W;
            if (videoItemData != null) {
                int d2 = d.a.d.e.m.b.d(videoItemData.video_height, 0);
                int d3 = d.a.d.e.m.b.d(this.W.video_width, 0);
                float f2 = 0.0f;
                if (d2 != 0 && d3 != 0) {
                    f2 = (d2 * 1.0f) / d3;
                }
                if (f2 > 1.0f) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    this.p0 = layoutParams;
                    layoutParams.addRule(14);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
                    this.F0 = layoutParams2;
                    layoutParams2.removeRule(13);
                    this.F0.addRule(14);
                    this.F0.topMargin = (d.a.d.e.p.l.i(this.f21915i.getContext()) - d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) / 2;
                    this.A.requestLayout();
                } else {
                    int i2 = d.a.d.e.p.l.i(this.f21915i.getContext());
                    float k2 = f2 * d.a.d.e.p.l.k(this.f21915i.getContext());
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, (int) k2);
                    this.p0 = layoutParams3;
                    layoutParams3.topMargin = ((int) ((i2 - k2) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight())) / 2;
                    this.p0.addRule(14);
                    this.l.setLayoutParams(this.p0);
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.A.getLayoutParams();
                    this.F0 = layoutParams4;
                    layoutParams4.removeRule(13);
                    this.F0.addRule(14);
                    this.F0.topMargin = ((i2 - d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds203)) - TbadkCoreApplication.getInst().getMainTabBottomBarHeight()) / 2;
                    this.A.requestLayout();
                }
                if (this.j != null && (tbCyberVideoView2 = this.k) != null && tbCyberVideoView2.getView() != null) {
                    this.j.addView(this.k.getView(), 0, this.p0);
                }
            }
            if (this.W != null) {
                d.a.q0.n2.o oVar = new d.a.q0.n2.o();
                oVar.f61427e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData2 = this.W;
                oVar.f61425c = videoItemData2.thread_id;
                oVar.t = videoItemData2.nid;
                oVar.f61426d = videoItemData2.forum_id;
                oVar.m = videoItemData2.mMd5;
                oVar.k = "";
                oVar.f61428f = videoItemData2.mRecomSource;
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
                oVar.f61430h = this.W.mRecomWeight;
                if (this.c0 != null) {
                    oVar.n = "1";
                } else {
                    oVar.n = "2";
                }
                int i4 = this.f21911e;
                if (i4 == 1) {
                    oVar.p = "1";
                    oVar.f61423a = "13";
                    oVar.f61431i = this.u0;
                    oVar.k = this.H0;
                    oVar.f61429g = this.W.mRecomWeight;
                } else if (i4 == 2) {
                    oVar.f61423a = "24";
                } else {
                    oVar.f61423a = "13";
                }
                oVar.p = "1";
                int i5 = this.f21911e;
                if (i5 == 3) {
                    oVar.f61423a = "21";
                } else if (i5 == 4) {
                    oVar.f61423a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
                }
                String str = this.u0;
                oVar.f61431i = str;
                String str2 = this.H0;
                oVar.k = str2;
                String str3 = this.W.mRecomWeight;
                oVar.f61429g = str3;
                if (this.f21911e == 5) {
                    oVar.f61423a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR;
                    oVar.p = "1";
                    oVar.f61431i = str;
                    oVar.k = str2;
                    oVar.f61429g = str3;
                }
                this.k.setVideoStatData(oVar);
                this.k.setLocateSource("v_mid_page");
            }
            this.k.setContinuePlayEnable(true);
        }
    }

    public final void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.k.setOnPreparedListener(this.j1);
            }
            this.k.setOnCompletionListener(this.i1);
            this.k.setOnInfoListener(this.h1);
        }
    }

    public final void w2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048637, this, str) == null) || this.k == null || str == null || str.equals(this.C0)) {
            return;
        }
        this.C0 = str;
    }

    public void x2(d.a.q0.x3.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, aVar) == null) {
            this.O0 = aVar;
        }
    }

    public void y2(u0 u0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, u0Var) == null) {
            this.R0 = u0Var;
        }
    }

    public void z2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048640, this) == null) || this.w0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.w0.l();
    }
}
