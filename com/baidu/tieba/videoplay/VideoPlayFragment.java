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
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.WebPManager;
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
import d.a.r0.b1.p.a;
import d.a.r0.h.a;
import d.a.r0.r.q.b2;
import d.a.r0.r.s.a;
import d.a.r0.r.s.l;
import d.a.s0.n2.f;
import d.a.s0.x3.c.a;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes5.dex */
public class VideoPlayFragment extends BaseFragment implements a.b, d.a.s0.x3.d.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A;
    public boolean A0;
    public View B;
    public TBLottieAnimationView B0;
    public EMTextView C;
    public boolean C0;
    public EMTextView D;
    public int D0;
    public EMTextView E;
    public int E0;
    public EMTextView F;
    public d.a.s0.x3.c.a F0;
    public EMTextView G;
    public f.c G0;
    public EMTextView H;
    public l0 H0;
    public EMTextView I;
    public CustomMessageListener I0;
    public TextView J;
    public final CustomMessageListener J0;
    public View K;
    public CustomMessageListener K0;
    public LinearLayout L;
    public l.d L0;
    public LinearLayout M;
    public l.d M0;
    public LinearLayout N;
    public l.d N0;
    public VideoItemData O;
    public Runnable O0;
    public VideoItemModel P;
    public CyberPlayerManager.OnInfoListener P0;
    public TextView Q;
    public CyberPlayerManager.OnCompletionListener Q0;
    public VideoMiddleNiaiControllerView R;
    public CyberPlayerManager.OnPreparedListener R0;
    public boolean S;
    public boolean T;
    public AlphaAnimation U;
    public Rect V;
    public ImageView W;
    public ImageView X;
    public ImageView Y;
    public TextView Z;
    public View a0;
    public TextView b0;
    public RelativeLayout.LayoutParams c0;

    /* renamed from: e  reason: collision with root package name */
    public int f21736e;

    /* renamed from: f  reason: collision with root package name */
    public int f21737f;

    /* renamed from: g  reason: collision with root package name */
    public View f21738g;

    /* renamed from: h  reason: collision with root package name */
    public TbCyberVideoView f21739h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f21740i;
    public int i0;
    public View j;
    public int j0;
    public ImageView k;
    public boolean k0;
    public ImageView l;
    public int l0;
    public HeadImageView m;
    public boolean m0;
    public LinearLayout n;
    public String n0;
    public LinearLayout o;
    public String o0;
    public LinearLayout p;
    public String p0;
    public LinearLayout q;
    public d.a.r0.r.s.j q0;
    public LinearLayout r;
    public d.a.r0.r.s.l r0;
    public ImageView s;
    public ForumManageModel s0;
    public ImageView t;
    public d.a.r0.h.a t0;
    public ImageView u;
    public d.a.r0.s.e.a u0;
    public LinearLayout v;
    public BdUniqueId v0;
    public BarImageView w;
    public String w0;
    public TextView x;
    public boolean x0;
    public ExpandableTextView y;
    public RelativeLayout.LayoutParams y0;
    public TextView z;
    public String z0;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f21741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21742f;

        public a(VideoPlayFragment videoPlayFragment, String str) {
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
            this.f21742f = videoPlayFragment;
            this.f21741e = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || TextUtils.isEmpty(this.f21741e)) {
                return;
            }
            UrlManager.getInstance().dealOneLink((TbPageContext) d.a.c.a.j.a(this.f21742f.getPageContext().getPageActivity()), new String[]{this.f21741e}, true);
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21743e;

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
            this.f21743e = videoPlayFragment;
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
                VideoPlayFragment videoPlayFragment = this.f21743e;
                View view = videoPlayFragment.f21738g;
                if (view instanceof RelativeLayout) {
                    ((RelativeLayout) view).removeView(videoPlayFragment.B0);
                }
                this.f21743e.x0 = false;
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

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21744e;

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
            this.f21744e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoItemData videoItemData;
            UserItemData userItemData;
            UserItemData userItemData2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = this.f21744e.O) == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id)) {
                return;
            }
            VideoItemData videoItemData2 = this.f21744e.O;
            if (videoItemData2 != null && (userItemData2 = videoItemData2.author_info) != null) {
                long f2 = d.a.c.e.m.b.f(userItemData2.user_id, 0L);
                long f3 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
                boolean z = f2 == f3;
                if (f2 == 0 && f3 == 0) {
                    z = false;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f21744e.getActivity()).createNormalConfig(f2, z, false)));
                StatisticItem statisticItem = new StatisticItem("c12798");
                statisticItem.param("tid", this.f21744e.O.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
            }
            this.f21744e.K1(5);
        }
    }

    /* loaded from: classes5.dex */
    public class b0 implements CyberPlayerManager.OnInfoListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21745e;

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
            this.f21745e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
        public boolean onInfo(int i2, int i3, Object obj) {
            InterceptResult invokeIIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, obj)) == null) {
                if (this.f21745e.S) {
                    if ((i2 == 3 || i2 == 904) && this.f21745e.f21740i.getVisibility() == 0) {
                        this.f21745e.f21740i.clearAnimation();
                        this.f21745e.f21740i.startAnimation(this.f21745e.U);
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return invokeIIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21746e;

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
            this.f21746e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (videoItemData = (videoPlayFragment = this.f21746e).O) == null || videoItemData.act_info == null) {
                return;
            }
            d.a.r0.l.a.k(videoPlayFragment.getActivity(), this.f21746e.O.act_info.link_url);
            StatisticItem statisticItem = new StatisticItem("c12799");
            statisticItem.param("tid", this.f21746e.O.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements CyberPlayerManager.OnCompletionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21747e;

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
            this.f21747e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
        public void onCompletion() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f21747e.f21739h) == null) {
                return;
            }
            tbCyberVideoView.N();
            this.f21747e.f21739h.seekTo(0);
            this.f21747e.f21739h.start();
            this.f21747e.V1();
            VideoPlayFragment.t1(this.f21747e);
            if (this.f21747e.D0 == 3) {
                this.f21747e.D1();
            }
            if (this.f21747e.m0 || this.f21747e.isPrimary()) {
                return;
            }
            this.f21747e.T1();
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21748e;

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
            this.f21748e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21748e.O1(false);
                this.f21748e.K1(7);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21749a;

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
            this.f21749a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.s0.h3.h0.e)) {
                AgreeData agreeData = ((d.a.s0.h3.h0.e) customResponsedMessage.getData()).f61216b;
                if (this.f21749a.O == null || agreeData == null) {
                    return;
                }
                String str = agreeData.nid;
                if (!"0".equals(str) && !TextUtils.isEmpty(str)) {
                    BaijiahaoData baijiahaoData = this.f21749a.O.baijiahaoData;
                    if (baijiahaoData == null || !TextUtils.equals(str, baijiahaoData.oriUgcNid)) {
                        return;
                    }
                    this.f21749a.O.agree_num = String.valueOf(agreeData.agreeNum);
                    this.f21749a.O.is_agreed = agreeData.hasAgree ? "1" : "0";
                    this.f21749a.A1();
                    return;
                }
                String str2 = agreeData.threadId;
                String str3 = this.f21749a.O.thread_id;
                if ("0".equals(str2) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, str3)) {
                    return;
                }
                this.f21749a.O.agree_num = String.valueOf(agreeData.agreeNum);
                this.f21749a.O.is_agreed = agreeData.hasAgree ? "1" : "0";
                this.f21749a.A1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21750e;

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
            this.f21750e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements CyberPlayerManager.OnPreparedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21751e;

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
            this.f21751e = videoPlayFragment;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
        public void onPrepared() {
            TbCyberVideoView tbCyberVideoView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (tbCyberVideoView = this.f21751e.f21739h) == null) {
                return;
            }
            tbCyberVideoView.setVolume(1.0f, 1.0f);
            if (this.f21751e.f21739h.getDuration() < 15000 || this.f21751e.R == null) {
                this.f21751e.R.setVisibility(8);
                return;
            }
            this.f21751e.R.setVisibility(0);
            if (this.f21751e.R.getCurProgress() == 0) {
                this.f21751e.R.s();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21752e;

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
            this.f21752e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoItemData videoItemData = this.f21752e.O;
                if (videoItemData != null && !StringUtils.isNull(videoItemData.thread_id)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921321, this.f21752e.O.thread_id));
                }
                this.f21752e.getActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 extends GestureDetector.SimpleOnGestureListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21753e;

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
            this.f21753e = videoPlayFragment;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                this.f21753e.N(0.0f, 0.0f);
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent)) == null) {
                this.f21753e.l();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21754e;

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
            this.f21754e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21754e.h2();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ GestureDetectorCompat f21755e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21756f;

        public g0(VideoPlayFragment videoPlayFragment, GestureDetectorCompat gestureDetectorCompat) {
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
            this.f21756f = videoPlayFragment;
            this.f21755e = gestureDetectorCompat;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.f21755e.onTouchEvent(motionEvent) : invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21757e;

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
            this.f21757e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || AntiHelper.c(this.f21757e.getPageContext(), this.f21757e.O)) {
                return;
            }
            this.f21757e.O1(true);
            StatisticItem statisticItem = new StatisticItem("c12796");
            statisticItem.param("tid", this.f21757e.O.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem);
            this.f21757e.K1(2);
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21758e;

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
            this.f21758e = videoPlayFragment;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                this.f21758e.h2();
                this.f21758e.f21738g.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21759e;

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
            this.f21759e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f21759e;
                videoPlayFragment.H1(videoPlayFragment.f21736e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 implements f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21760a;

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
            this.f21760a = videoPlayFragment;
        }

        @Override // d.a.s0.n2.f.c
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) || this.f21760a.G0 == null) {
                return;
            }
            this.f21760a.G0.a(i2, i3);
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21761e;

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
            this.f21761e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f21761e.j2();
                StatisticItem statisticItem = new StatisticItem("c12797");
                statisticItem.param("tid", this.f21761e.O.thread_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f21761e.K1(3);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                statisticItem2.param("tid", this.f21761e.O.thread_id);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("obj_locate", 19);
                statisticItem2.param("nid", this.f21761e.O.nid);
                BaijiahaoData baijiahaoData = this.f21761e.O.baijiahaoData;
                if (baijiahaoData != null && !d.a.c.e.p.k.isEmpty(baijiahaoData.oriUgcVid)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.f21761e.O.baijiahaoData.oriUgcVid);
                }
                if (this.f21761e.O.getVideoType() == 1) {
                    statisticItem2.param("card_type", 2);
                } else if (this.f21761e.O.getVideoType() == 2) {
                    statisticItem2.param("card_type", 8);
                } else if (this.f21761e.O.getVideoType() == 3) {
                    statisticItem2.param("card_type", 6);
                }
                statisticItem2.param("recom_source", this.f21761e.O.mRecomSource);
                statisticItem2.param("ab_tag", this.f21761e.O.mRecomAbTag);
                statisticItem2.param("weight", this.f21761e.O.mRecomWeight);
                statisticItem2.param("extra", this.f21761e.O.mRecomExtra);
                statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
                if (d.a.r0.j0.c.j(this.f21761e.getBaseFragmentActivity()) != null && d.a.r0.j0.c.j(this.f21761e.getBaseFragmentActivity()).a() != null && d.a.r0.j0.c.j(this.f21761e.getBaseFragmentActivity()).b().locatePage != null && "a002".equals(d.a.r0.j0.c.j(this.f21761e.getBaseFragmentActivity()).b().locatePage)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21762e;

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
            this.f21762e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                VideoPlayFragment videoPlayFragment = this.f21762e;
                if (videoPlayFragment.F1(videoPlayFragment.getPageContext(), 11001)) {
                    this.f21762e.a0.setVisibility(8);
                    if (this.f21762e.F0 != null && this.f21762e.F0.a() != null) {
                        this.f21762e.F0.a().j();
                        VideoPlayFragment videoPlayFragment2 = this.f21762e;
                        if (videoPlayFragment2.O != null) {
                            videoPlayFragment2.F0.w(this.f21762e.O);
                        }
                    }
                    if (this.f21762e.O != null) {
                        StatisticItem statisticItem = new StatisticItem("c13025");
                        statisticItem.param("tid", this.f21762e.O.thread_id);
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", this.f21762e.O.forum_id);
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21763a;

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
            this.f21763a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserItemData userItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                UpdateAttentionMessage.a data = updateAttentionMessage.getData();
                VideoItemData videoItemData = this.f21763a.O;
                if (videoItemData == null || (userItemData = videoItemData.author_info) == null || StringUtils.isNull(userItemData.user_id) || data == null || !this.f21763a.O.author_info.user_id.equals(data.f12802c)) {
                    return;
                }
                boolean z = true;
                Message<?> message = updateAttentionMessage.getmOrginalMessage();
                z = (message == null || message.getTag() == null || !message.getTag().equals(this.f21763a.v0)) ? false : false;
                if (data.l != null) {
                    return;
                }
                if (!data.f12800a) {
                    if (!z || "0".equals(this.f21763a.O.author_info.is_follow)) {
                        return;
                    }
                    d.a.c.e.p.l.L(this.f21763a.getActivity(), R.string.attention_fail);
                    VideoPlayFragment videoPlayFragment = this.f21763a;
                    videoPlayFragment.O.author_info.is_follow = "0";
                    videoPlayFragment.B1();
                    return;
                }
                if (!updateAttentionMessage.isAttention()) {
                    VideoPlayFragment videoPlayFragment2 = this.f21763a;
                    videoPlayFragment2.O.author_info.is_follow = "0";
                    videoPlayFragment2.B1();
                } else if (z) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.f21763a.O));
                } else {
                    VideoPlayFragment videoPlayFragment3 = this.f21763a;
                    videoPlayFragment3.O.author_info.is_follow = "1";
                    videoPlayFragment3.B1();
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if ("index".equals(this.f21763a.o0)) {
                    statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                    statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements SeekBar.OnSeekBarChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21764e;

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
            this.f21764e = videoPlayFragment;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{seekBar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && z) {
                this.f21764e.I1(true);
                EMTextView eMTextView = this.f21764e.F;
                if (eMTextView != null) {
                    eMTextView.setText(StringHelper.stringForVideoTime(i2));
                }
                EMTextView eMTextView2 = this.f21764e.G;
                if (eMTextView2 != null) {
                    eMTextView2.setText("/" + StringHelper.stringForVideoTime(this.f21764e.f21739h.getDuration()));
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_PROGRESS_CLICK);
                statisticItem.param("tid", this.f21764e.O.thread_id);
                statisticItem.param("fid", this.f21764e.O.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.f21764e.o0)) {
                    statisticItem.param("obj_type", 1);
                } else {
                    statisticItem.param("obj_type", 2);
                }
                statisticItem.param("obj_type", this.f21764e.N1());
                if (!"a088".equals(this.f21764e.p0)) {
                    if ("a089".equals(this.f21764e.p0)) {
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
                this.f21764e.A0 = true;
                if (this.f21764e.R != null) {
                    this.f21764e.R.setBottomBarShow(false, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.f21764e.o0) ? 1 : 0);
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, seekBar) == null) {
                this.f21764e.A0 = false;
                if (seekBar != null) {
                    seekBar.setThumbOffset(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds12));
                    seekBar.setThumb(null);
                    this.f21764e.I1(false);
                    if (!this.f21764e.f21739h.isPlaying()) {
                        this.f21764e.f21739h.start();
                        this.f21764e.u.setVisibility(8);
                    }
                    if (!this.f21764e.m0 && !this.f21764e.isPrimary()) {
                        this.f21764e.T1();
                    }
                    d.a.c.e.m.e.a().postDelayed(this.f21764e.O0, 3000L);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21765e;

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
            this.f21765e = videoPlayFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f21765e.getActivity())) {
                VideoPlayFragment videoPlayFragment = this.f21765e;
                if (videoPlayFragment.H != null && (videoItemData = videoPlayFragment.O) != null && videoItemData.author_info != null && videoPlayFragment.I != null) {
                    d.a.r0.s.e.a aVar = videoPlayFragment.u0;
                    VideoPlayFragment videoPlayFragment2 = this.f21765e;
                    UserItemData userItemData = videoPlayFragment2.O.author_info;
                    aVar.m(true, userItemData.portrait, userItemData.user_id, false, "6", videoPlayFragment2.v0, this.f21765e.O.forum_id, "0");
                    VideoPlayFragment videoPlayFragment3 = this.f21765e;
                    videoPlayFragment3.O.author_info.is_follow = "1";
                    videoPlayFragment3.B1();
                    this.f21765e.H.setVisibility(8);
                    this.f21765e.I.setVisibility(0);
                    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setStartOffset(1000L);
                    scaleAnimation.setDuration(300L);
                    scaleAnimation.setFillAfter(true);
                    this.f21765e.I.startAnimation(scaleAnimation);
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ATTENTION_CLICK);
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.f21765e.o0)) {
                    statisticItem.param("obj_locate", 1);
                } else {
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_source", this.f21765e.N1());
                }
                statisticItem.param("tid", this.f21765e.O.thread_id);
                statisticItem.param("fid", this.f21765e.O.forum_id);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem);
                this.f21765e.K1(6);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface l0 {
        void onStart();
    }

    /* loaded from: classes5.dex */
    public class m implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21766a;

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
            this.f21766a = videoPlayFragment;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animation) == null) || this.f21766a.f21740i == null) {
                return;
            }
            this.f21766a.f21740i.setVisibility(8);
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

    /* loaded from: classes5.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21767e;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ n f21768e;

            public a(n nVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {nVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21768e = nVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f21768e.f21767e.S) {
                    this.f21768e.f21767e.startPlay();
                    this.f21768e.f21767e.V = null;
                }
            }
        }

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
            this.f21767e = videoPlayFragment;
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
                int width = this.f21767e.f21740i.getWidth();
                int height = this.f21767e.f21740i.getHeight();
                if (height > 0 && width > 0) {
                    if (d.a.c.e.m.b.d(this.f21767e.O.video_height, 0) > 0 && d.a.c.e.m.b.d(this.f21767e.O.video_width, 0) > 0) {
                        float f3 = width;
                        float f4 = height;
                        float f5 = f3 / f4;
                        float c2 = d.a.c.e.m.b.c(this.f21767e.O.video_width, 0.0f) / d.a.c.e.m.b.c(this.f21767e.O.video_height, 0.0f);
                        if (c2 > 0.0f && Math.abs(c2 - f5) > 0.05d) {
                            if (c2 > f5) {
                                i3 = (int) (f3 / c2);
                                i2 = width;
                                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f21767e.i0, this.f21767e.j0);
                                layoutParams.leftMargin = this.f21767e.V.left;
                                layoutParams.topMargin = this.f21767e.V.top;
                                this.f21767e.f21740i.setLayoutParams(layoutParams);
                                float f6 = 1.0f;
                                if (this.f21767e.j0 > 0 || this.f21767e.i0 <= 0) {
                                    f2 = 1.0f;
                                } else {
                                    f6 = i3 / this.f21767e.j0;
                                    f2 = i2 / this.f21767e.i0;
                                }
                                this.f21767e.f21740i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f6).scaleX(f2).translationX((width / 2.0f) - (this.f21767e.V.left + ((this.f21767e.V.right - this.f21767e.V.left) / 2))).translationY((height / 2.0f) - (this.f21767e.V.top + ((this.f21767e.V.bottom - this.f21767e.V.top) / 2))).start();
                                this.f21767e.f21740i.postDelayed(new a(this), 200L);
                            }
                            i2 = (int) (f4 * c2);
                            i3 = height;
                            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.f21767e.i0, this.f21767e.j0);
                            layoutParams2.leftMargin = this.f21767e.V.left;
                            layoutParams2.topMargin = this.f21767e.V.top;
                            this.f21767e.f21740i.setLayoutParams(layoutParams2);
                            float f62 = 1.0f;
                            if (this.f21767e.j0 > 0) {
                            }
                            f2 = 1.0f;
                            this.f21767e.f21740i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f62).scaleX(f2).translationX((width / 2.0f) - (this.f21767e.V.left + ((this.f21767e.V.right - this.f21767e.V.left) / 2))).translationY((height / 2.0f) - (this.f21767e.V.top + ((this.f21767e.V.bottom - this.f21767e.V.top) / 2))).start();
                            this.f21767e.f21740i.postDelayed(new a(this), 200L);
                        }
                    }
                }
                i2 = width;
                i3 = height;
                RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(this.f21767e.i0, this.f21767e.j0);
                layoutParams22.leftMargin = this.f21767e.V.left;
                layoutParams22.topMargin = this.f21767e.V.top;
                this.f21767e.f21740i.setLayoutParams(layoutParams22);
                float f622 = 1.0f;
                if (this.f21767e.j0 > 0) {
                }
                f2 = 1.0f;
                this.f21767e.f21740i.animate().setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(200L).scaleY(f622).scaleX(f2).translationX((width / 2.0f) - (this.f21767e.V.left + ((this.f21767e.V.right - this.f21767e.V.left) / 2))).translationY((height / 2.0f) - (this.f21767e.V.top + ((this.f21767e.V.bottom - this.f21767e.V.top) / 2))).start();
                this.f21767e.f21740i.postDelayed(new a(this), 200L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21769e;

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
            this.f21769e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int width = this.f21769e.f21740i.getWidth();
                int height = this.f21769e.f21740i.getHeight();
                if (height <= 0 || width <= 0 || (videoItemData = this.f21769e.O) == null) {
                    return;
                }
                if (d.a.c.e.m.b.d(videoItemData.video_height, 0) <= 0 || d.a.c.e.m.b.d(this.f21769e.O.video_width, 0) <= 0) {
                    return;
                }
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                float c2 = d.a.c.e.m.b.c(this.f21769e.O.video_width, 0.0f) / d.a.c.e.m.b.c(this.f21769e.O.video_height, 0.0f);
                if (c2 > 0.0f && Math.abs(c2 - f4) > 0.05d) {
                    if (c2 > f4) {
                        height = (int) (f2 / c2);
                    } else {
                        width = (int) (f3 * c2);
                    }
                }
                ViewGroup.LayoutParams layoutParams = this.f21769e.f21740i.getLayoutParams();
                layoutParams.height = height;
                layoutParams.width = width;
                this.f21769e.f21740i.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements a.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21770a;

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
            this.f21770a = videoPlayFragment;
        }

        @Override // d.a.s0.x3.c.a.d
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21770a.a0.setVisibility(8);
                if (z) {
                    this.f21770a.b0.setText(R.string.reply_something);
                } else {
                    this.f21770a.b0.setText(StringUtils.isNull(((d.a.s0.x3.c.c) this.f21770a.F0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
                }
                VideoItemData videoItemData = this.f21770a.O;
                if (videoItemData == null || !z) {
                    return;
                }
                long f2 = d.a.c.e.m.b.f(videoItemData.comment_num, 0L) + 1;
                this.f21770a.O.comment_num = String.valueOf(f2);
                this.f21770a.C.setText(StringHelper.numberUniformFormatExtraWithRoundVote(f2));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21771a;

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
            this.f21771a = videoPlayFragment;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && obj != null && this.f21771a.s0.getLoadDataMode() == 0) {
                this.f21771a.getActivity().finish();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements a.InterfaceC1243a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21772a;

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
            this.f21772a = videoPlayFragment;
        }

        @Override // d.a.r0.h.a.InterfaceC1243a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f21772a.t0 != null) {
                        this.f21772a.t0.h(z2);
                    }
                    VideoItemData videoItemData = this.f21772a.O;
                    if (videoItemData != null) {
                        if (z2) {
                            videoItemData.mark_id = videoItemData.post_id;
                        } else {
                            videoItemData.mark_id = null;
                        }
                    }
                    if (z2) {
                        VideoPlayFragment videoPlayFragment = this.f21772a;
                        videoPlayFragment.showToast(videoPlayFragment.getPageContext().getString(R.string.add_mark));
                        return;
                    }
                    VideoPlayFragment videoPlayFragment2 = this.f21772a;
                    videoPlayFragment2.showToast(videoPlayFragment2.getPageContext().getString(R.string.remove_mark));
                    return;
                }
                VideoPlayFragment videoPlayFragment3 = this.f21772a;
                videoPlayFragment3.showToast(videoPlayFragment3.getPageContext().getString(R.string.update_mark_failed));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements l.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21773a;

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
            this.f21773a = videoPlayFragment;
        }

        @Override // d.a.r0.r.s.l.c
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21773a.R1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21774e;

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
            this.f21774e = videoPlayFragment;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f21774e.q0 = null;
                this.f21774e.r0 = null;
                if (TbSingleton.getInstance().isNotchScreen(this.f21774e.getActivity())) {
                    return;
                }
                TbSingleton.getInstance().isCutoutScreen(this.f21774e.getActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21775a;

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
            this.f21775a = videoPlayFragment;
        }

        @Override // d.a.r0.r.s.l.d
        public void onClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f21775a.getContext())) {
                    if (this.f21775a.q0 != null) {
                        this.f21775a.q0.dismiss();
                        return;
                    }
                    return;
                }
                if (this.f21775a.q0 != null) {
                    this.f21775a.q0.dismiss();
                }
                VideoItemData videoItemData = this.f21775a.O;
                if (videoItemData == null) {
                    return;
                }
                String str = videoItemData.post_id;
                boolean z = str != null && str.equals(videoItemData.mark_id);
                MarkData markData = new MarkData();
                Date date = new Date();
                markData.setAccount(TbadkCoreApplication.getCurrentAccount());
                markData.setThreadId(this.f21775a.O.thread_id);
                markData.setPostId(this.f21775a.O.post_id);
                markData.setTime(date.getTime());
                markData.setHostMode(false);
                markData.setId(this.f21775a.O.thread_id);
                markData.setForumId(this.f21775a.O.forum_id);
                if (this.f21775a.t0 != null) {
                    this.f21775a.t0.i(markData);
                    if (!z) {
                        this.f21775a.t0.a();
                    } else {
                        this.f21775a.t0.d();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21776a;

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
            this.f21776a = videoPlayFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof NetWorkChangedMessage) && customResponsedMessage.getCmd() == 2000994 && !customResponsedMessage.hasError()) {
                if (d.a.c.e.p.j.z() || !this.f21776a.m0 || !this.f21776a.isPrimary()) {
                    this.f21776a.i2();
                } else {
                    d.a.c.e.p.l.L(TbadkCoreApplication.getInst(), R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21777a;

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
            this.f21777a = videoPlayFragment;
        }

        @Override // d.a.r0.r.s.l.d
        public void onClick() {
            VideoPlayFragment videoPlayFragment;
            VideoItemData videoItemData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21777a.q0.dismiss();
                if (ViewHelper.checkUpIsLogin(this.f21777a.getActivity()) && (videoItemData = (videoPlayFragment = this.f21777a).O) != null) {
                    String str = videoItemData.thread_id;
                    String str2 = videoItemData.forum_id;
                    String string = videoPlayFragment.getResources().getString(R.string.web_view_report_title);
                    String str3 = "http://tieba.baidu.com/mo/q/postreport?fid=" + str2 + "&tid=" + str + "&pid=" + this.f21777a.O.post_id;
                    VideoItemData videoItemData2 = this.f21777a.O;
                    if (videoItemData2.isBjhVideo) {
                        str3 = String.format(TbConfig.URL_BJH_REPORT, str, videoItemData2.post_id) + "&channelid=33840";
                        string = "";
                    }
                    TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f21777a.getPageContext().getPageActivity(), string, str3, true);
                    if (this.f21777a.O.isBjhVideo) {
                        tbWebViewActivityConfig.setFixTitle(true);
                    }
                    this.f21777a.sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class x implements l.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21778a;

        /* loaded from: classes5.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.r0.r.s.a f21779e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ x f21780f;

            public a(x xVar, d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {xVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21780f = xVar;
                this.f21779e = aVar;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21779e.dismiss();
                    VideoPlayFragment videoPlayFragment = this.f21780f.f21778a;
                    if (videoPlayFragment.O != null) {
                        ForumManageModel forumManageModel = videoPlayFragment.s0;
                        VideoPlayFragment videoPlayFragment2 = this.f21780f.f21778a;
                        VideoItemData videoItemData = videoPlayFragment2.O;
                        forumManageModel.R(videoItemData.forum_id, videoItemData.forum_name, videoItemData.thread_id, videoItemData.post_id, 0, 0, videoPlayFragment2.k0, null);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001376, Boolean.TRUE));
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d.a.r0.r.s.a f21781e;

            public b(x xVar, d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {xVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f21781e = aVar;
            }

            @Override // d.a.r0.r.s.a.e
            public void onClick(d.a.r0.r.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    this.f21781e.dismiss();
                }
            }
        }

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
            this.f21778a = videoPlayFragment;
        }

        @Override // d.a.r0.r.s.l.d
        public void onClick() {
            WorksInfoData worksInfoData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f21778a.q0.dismiss();
                d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f21778a.getActivity());
                VideoItemData videoItemData = this.f21778a.O;
                if (videoItemData != null && (worksInfoData = videoItemData.mWorksInfoData) != null && worksInfoData.isWorks) {
                    aVar.setMessageId(R.string.del_work_thread_confirm);
                } else {
                    aVar.setMessageId(R.string.del_thread_confirm);
                }
                aVar.setPositiveButton(R.string.dialog_ok, new a(this, aVar));
                aVar.setNegativeButton(R.string.dialog_cancel, new b(this, aVar));
                aVar.setCancelable(true);
                aVar.create(this.f21778a.getPageContext());
                aVar.show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class y implements ExpandableTextView.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21782a;

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
            this.f21782a = videoPlayFragment;
        }

        @Override // com.baidu.tieba.view.expandable.ExpandableTextView.e
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f21782a.O.isTitleExpanded = z;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class z implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VideoPlayFragment f21783e;

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
            this.f21783e = videoPlayFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f21783e.A0) {
                return;
            }
            this.f21783e.C1(true);
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
        this.f21736e = 0;
        this.f21737f = 1;
        this.s0 = null;
        this.t0 = null;
        this.u0 = null;
        this.v0 = BdUniqueId.gen();
        this.x0 = false;
        this.C0 = false;
        this.D0 = 1;
        this.E0 = -1;
        this.I0 = new k(this, 2001115);
        this.J0 = new v(this, 2000994);
        this.K0 = new d0(this, 2016528);
        this.L0 = new u(this);
        this.M0 = new w(this);
        this.N0 = new x(this);
        this.O0 = new z(this);
        this.P0 = new b0(this);
        this.Q0 = new c0(this);
        this.R0 = new e0(this);
    }

    public static /* synthetic */ int t1(VideoPlayFragment videoPlayFragment) {
        int i2 = videoPlayFragment.D0;
        videoPlayFragment.D0 = i2 + 1;
        return i2;
    }

    public final void A1() {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (videoItemData = this.O) == null) {
            return;
        }
        if ("1".equals(videoItemData.is_agreed)) {
            this.W.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.W.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        this.D.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.O.agree_num, 0L)));
    }

    public final void B1() {
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!this.k0 && ((userItemData = this.O.author_info) == null || !"1".equals(userItemData.is_follow))) {
                this.H.setVisibility(0);
                this.H.setClickable(true);
                this.I.setVisibility(8);
                return;
            }
            this.H.setVisibility(4);
            this.H.setClickable(false);
            this.I.setVisibility(8);
        }
    }

    public final void C1(boolean z2) {
        VideoMiddleNiaiControllerView videoMiddleNiaiControllerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) || (videoMiddleNiaiControllerView = this.R) == null) {
            return;
        }
        videoMiddleNiaiControllerView.setBottomBarShow(z2, VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0) ? 1 : 0);
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.t == null || this.s == null) {
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(300L);
        this.s.clearAnimation();
        this.t.clearAnimation();
        this.s.setVisibility(8);
        this.t.setVisibility(0);
        this.t.startAnimation(scaleAnimation2);
        this.s.startAnimation(scaleAnimation);
    }

    public final void E1() {
        VideoItemData videoItemData;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (videoItemData = this.O) == null) {
            return;
        }
        this.f21740i.M(videoItemData.thumbnail_url, 10, false);
        if (!StringUtils.isNull(this.O.title)) {
            str = this.O.title;
        } else {
            str = !StringUtils.isNull(this.O.abstext) ? this.O.abstext : "";
        }
        boolean z2 = d.a.c.e.m.b.d(this.O.video_height, 0) <= d.a.c.e.m.b.d(this.O.video_width, 0);
        if (StringUtils.isNull(str) && (!z2 || this.O.video_duration < 60)) {
            this.B.setVisibility(8);
        } else {
            if (z2 && this.O.video_duration >= 60) {
                this.A.setVisibility(0);
                int i2 = this.O.video_duration;
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
                d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.z);
                d2.x(R.dimen.T_X09);
                d2.t(R.color.CAM_X0621);
                this.z.setText(sb.toString());
            } else {
                this.A.setVisibility(8);
            }
            this.B.setVisibility(0);
            this.y.setTextSize(d.a.c.e.p.l.g(getContext(), R.dimen.T_X07));
            this.y.setTextColor(R.color.CAM_X0621);
            this.y.setLineSpacingExtra(d.a.c.e.p.l.g(getContext(), R.dimen.tbds10));
            this.y.setExpandable(false);
            this.y.setTextMaxLine(3);
            this.y.setLimitLine(3);
            this.y.setOnStatusChangedListener(new y(this));
            ExpandableTextView expandableTextView = this.y;
            VideoItemData videoItemData2 = this.O;
            expandableTextView.setData(str, videoItemData2.isTitleExpanded, videoItemData2.mWorksInfoData);
        }
        this.C.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.O.comment_num, 0L)));
        this.D.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.O.agree_num, 0L)));
        this.E.setText(StringHelper.numberUniformFormatExtraWithRoundVote(d.a.c.e.m.b.f(this.O.share_num, 0L)));
        UserItemData userItemData = this.O.author_info;
        if (userItemData != null) {
            if (!TextUtils.isEmpty(userItemData.bjhAvatar)) {
                this.m.M(this.O.author_info.bjhAvatar, 12, false);
            } else if (!StringUtils.isNull(this.O.author_info.portrait) && this.O.author_info.portrait.startsWith("http")) {
                this.m.M(this.O.author_info.portrait, 10, false);
            } else {
                this.m.M(this.O.author_info.portrait, 12, false);
            }
            if (StringUtils.isNull(this.O.author_info.getUserShowName())) {
                this.Z.setVisibility(8);
            } else {
                this.Z.setVisibility(0);
                this.Z.setText(StringHelper.cutChineseAndEnglishWithEmoji(this.O.author_info.getUserShowName(), 16, StringHelper.STRING_MORE));
            }
        }
        if ("1".equals(this.O.is_private) && this.Q.getVisibility() != 0) {
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
        if ("1".equals(this.O.is_agreed)) {
            this.W.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_gooded36, WebPManager.ResourceStateType.NORMAL));
        } else {
            this.W.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_good36, WebPManager.ResourceStateType.NORMAL));
        }
        ActivityItemData activityItemData = this.O.act_info;
        if (activityItemData != null && !StringUtils.isNull(activityItemData.activity_name) && this.Q.getVisibility() != 0) {
            this.M.setVisibility(0);
            this.J.setText(this.O.act_info.activity_name);
        } else {
            this.M.setVisibility(8);
        }
        B1();
        this.l.setVisibility(8);
        b2 b2Var = this.O.threadData;
        if (b2Var != null) {
            if (TextUtils.isEmpty(b2Var.getRecomReason())) {
                this.v.setVisibility(8);
                return;
            }
            this.v.setVisibility(0);
            this.x.setText(this.O.threadData.getRecomReason());
            this.w.M(this.O.threadData.Y0, 10, false);
        }
    }

    public final boolean F1(TbPageContext<?> tbPageContext, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public final void G1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f21738g == null || this.x0) {
            return;
        }
        this.x0 = true;
        this.B0 = new TBLottieAnimationView(this.f21738g.getContext());
        if (this.y0 == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396), TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds396));
            this.y0 = layoutParams;
            layoutParams.addRule(13);
        }
        SkinManager.setLottieAnimation(this.B0, R.raw.lottie_agree_big_photo);
        View view = this.f21738g;
        if (view instanceof RelativeLayout) {
            ((RelativeLayout) view).addView(this.B0, this.y0);
        }
        this.B0.addAnimatorListener(new a0(this));
        this.B0.playAnimation();
    }

    public final void H1(int i2) {
        VideoItemData videoItemData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i2) == null) && ViewHelper.checkUpIsLogin(getActivity()) && (videoItemData = this.O) != null) {
            int i3 = 0;
            if (i2 == this.f21736e) {
                if ("1".equals(videoItemData.is_agreed)) {
                    VideoItemData videoItemData2 = this.O;
                    videoItemData2.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData2.agree_num, 0) - 1);
                    this.O.is_agreed = "0";
                    i3 = 1;
                } else {
                    VideoItemData videoItemData3 = this.O;
                    videoItemData3.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData3.agree_num, 0) + 1);
                    this.O.is_agreed = "1";
                    G1();
                    K1(1);
                }
            } else {
                videoItemData.agree_num = String.valueOf(d.a.c.e.m.b.d(videoItemData.agree_num, 0) + 1);
                this.O.is_agreed = "1";
                K1(1);
            }
            StatisticItem statisticItem = new StatisticItem("c12795");
            statisticItem.param("tid", this.O.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f21736e) {
                statisticItem.param("obj_type", i3);
            } else {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("c12003");
            statisticItem2.param("tid", this.O.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (i2 == this.f21736e) {
                statisticItem2.param("obj_type", i3);
            } else {
                statisticItem2.param("obj_type", 2);
            }
            if ("index".equals(this.o0)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, "a023");
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, "a002");
            }
            d.a.r0.i0.c k2 = TbPageExtraHelper.k(getContext());
            if (k2 != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, k2.a());
                StatisticItem statisticItem3 = new StatisticItem(TbadkCoreStatisticKey.KEY_AGREE_SUCCESS_CLICK);
                if (i2 == this.f21736e) {
                    statisticItem3.param("obj_type", i3);
                } else {
                    statisticItem3.param("obj_type", 2);
                }
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
                    statisticItem3.param("obj_locate", 1);
                    statisticItem3.param("obj_source", N1());
                } else {
                    statisticItem3.param("obj_locate", 2);
                }
                statisticItem3.param("tid", this.O.thread_id);
                statisticItem3.param("fid", this.O.forum_id);
                if ("a088".equals(this.p0)) {
                    statisticItem3.param("obj_param1", 1);
                } else if ("a089".equals(this.p0)) {
                    statisticItem3.param("obj_param1", 2);
                }
                TiebaStatic.log(statisticItem3);
            }
            if (TbPageExtraHelper.m() != null) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.m());
            }
            TiebaStatic.log(statisticItem2);
            E1();
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PB_FLOOR_AGREE);
            httpMessage.addParam("thread_id", this.O.thread_id);
            httpMessage.addParam("op_type", i3);
            httpMessage.addParam("obj_type", 3);
            httpMessage.addParam("agree_type", 2);
            httpMessage.addHeader("needSig", "1");
            BaijiahaoData baijiahaoData = this.O.baijiahaoData;
            if (baijiahaoData != null) {
                httpMessage.addParam("ori_ugc_tid", baijiahaoData.oriUgcTid);
                httpMessage.addParam("ori_ugc_nid", this.O.baijiahaoData.oriUgcNid);
                httpMessage.addParam("ori_ugc_vid", this.O.baijiahaoData.oriUgcVid);
                httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.O.baijiahaoData.oriUgcType);
            }
            if (k2 != null) {
                httpMessage.addParam("obj_source", k2.a());
            }
            sendMessage(httpMessage);
            d.a.s0.h3.h0.e eVar = new d.a.s0.h3.h0.e();
            AgreeData agreeData = new AgreeData();
            String str = this.O.thread_id;
            if (str != null) {
                agreeData.threadId = str;
            }
            agreeData.agreeNum = Long.valueOf(this.O.agree_num).longValue();
            agreeData.agreeType = 2;
            agreeData.hasAgree = "1".equals(this.O.is_agreed);
            eVar.f61216b = agreeData;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016528, eVar));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921325, this.O));
        }
    }

    public final void I1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) {
            if (z2) {
                this.o.setVisibility(8);
                this.K.setVisibility(8);
                this.p.setVisibility(8);
                this.q.setVisibility(8);
                this.n.setVisibility(8);
                this.r.setVisibility(0);
                return;
            }
            this.o.setVisibility(0);
            this.K.setVisibility(0);
            this.p.setVisibility(0);
            this.q.setVisibility(0);
            this.n.setVisibility(0);
            this.r.setVisibility(8);
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.O == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c12590");
        statisticItem.param("tid", this.O.thread_id);
        statisticItem.param("nid", this.O.nid);
        statisticItem.param("fid", this.O.forum_id);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem.param("obj_locate", this.l0);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
        statisticItem.param("obj_param1", d.a.c.e.p.k.isEmpty(this.O.mRecomWeight) ? "0" : this.O.mRecomWeight);
        statisticItem.param("extra", d.a.c.e.p.k.isEmpty(this.O.mRecomExtra) ? "0" : this.O.mRecomExtra);
        statisticItem.param("obj_id", this.z0);
        statisticItem.param("ab_tag", d.a.c.e.p.k.isEmpty(this.O.mRecomAbTag) ? "0" : this.O.mRecomAbTag);
        statisticItem.param("obj_source", d.a.c.e.p.k.isEmpty(this.O.mRecomSource) ? "0" : this.O.mRecomSource);
        statisticItem.param("obj_type", this.o0);
        statisticItem.param(TiebaStatic.Params.IS_VERTICAL, 1);
        BaijiahaoData baijiahaoData = this.O.baijiahaoData;
        if (baijiahaoData != null) {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, this.O.baijiahaoData.oriUgcVid);
            int i2 = this.O.baijiahaoData.oriUgcType;
            if (i2 == 4) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 2);
            } else if (i2 == 2) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            }
        } else {
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.O.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", this.o0);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a088");
            statisticItem2.param("page_type", this.p0);
            TiebaStatic.log(statisticItem2);
        }
        TiebaStatic.log(statisticItem);
    }

    public void K1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_CLICK);
            statisticItem.param("tid", this.O.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
                statisticItem.param("obj_locate", 1);
            } else {
                statisticItem.param("obj_locate", 2);
            }
            statisticItem.param("obj_type", i2);
            if ("a088".equals(this.p0)) {
                statisticItem.param("obj_source", 1);
            } else if ("a089".equals(this.p0)) {
                statisticItem.param("obj_source", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public String L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<String> M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.r0.b1.p.a.b
    public void N(float f2, float f3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) && ViewHelper.checkUpIsLogin(getActivity())) {
            G1();
            VideoItemData videoItemData = this.O;
            if (videoItemData == null || !"0".equals(videoItemData.is_agreed)) {
                return;
            }
            H1(this.f21737f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("index") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            char c2 = 0;
            if (TextUtils.isEmpty(this.o0)) {
                return 0;
            }
            String str = this.o0;
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

    public final void O1(boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z2) == null) || this.O == null) {
            return;
        }
        PbActivityConfig pbActivityConfig = new PbActivityConfig(getActivity());
        VideoItemData videoItemData = this.O;
        PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(videoItemData.thread_id, videoItemData.post_id, "");
        createNormalCfg.setForumId(String.valueOf(this.O.forum_id));
        createNormalCfg.setForumName(this.O.forum_name);
        createNormalCfg.setVideo_source(VideoPlayActivity.FROM_VIDEO_PLAY);
        createNormalCfg.setJumpToCommentArea(z2);
        createNormalCfg.setBjhData(this.O.baijiahaoData);
        if (this.O.threadData != null && TbSingleton.getInstance().isPbPreloadSwitchOn()) {
            createNormalCfg.setNeedPreLoad(true);
            d.a.s0.u0.l.c(this.O.threadData);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    @Override // d.a.s0.x3.d.a.a
    public void P(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            this.E0 = i2;
        }
    }

    public void P1(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i2, i3, intent) == null) {
            d.a.s0.x3.c.a aVar = this.F0;
            if (aVar != null) {
                aVar.n(i2, i3, intent);
            }
            if (intent == null || i2 != 24007) {
                return;
            }
            int intExtra = intent.getIntExtra("extra_share_status", 2);
            int intExtra2 = intent.getIntExtra("extra_show_channel", 1);
            if (intExtra == 1) {
                d.a.s0.v2.a.g().m(getPageContext());
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

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            d.a.s0.x3.c.a aVar = this.F0;
            if (aVar == null || aVar.a() == null || !this.F0.a().v()) {
                return false;
            }
            this.F0.a().o();
            this.a0.setVisibility(8);
            if (!(this.F0.a().n(28) instanceof d.a.s0.x3.c.c) || ((d.a.s0.x3.c.c) this.F0.a().n(28)).g() == null || ((d.a.s0.x3.c.c) this.F0.a().n(28)).g().getText() == null) {
                return true;
            }
            this.b0.setText(StringUtils.isNull(((d.a.s0.x3.c.c) this.F0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
            return true;
        }
        return invokeV.booleanValue;
    }

    public void R1() {
        d.a.r0.r.s.j jVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (jVar = this.q0) != null && jVar.isShowing()) {
            this.q0.dismiss();
        }
    }

    public final void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            d.a.s0.x3.c.a aVar = (d.a.s0.x3.c.a) new d.a.s0.x3.c.b().a(getActivity());
            this.F0 = aVar;
            if (aVar == null || this.O == null) {
                return;
            }
            aVar.s(getPageContext());
            d.a.s0.x3.c.a aVar2 = this.F0;
            VideoItemData videoItemData = this.O;
            aVar2.t(videoItemData.thread_id, videoItemData.forum_id, videoItemData.forum_name);
            this.F0.u(new p(this));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            ((RelativeLayout) this.f21738g).addView(this.F0.a(), layoutParams);
        }
    }

    public final void T1() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (tbCyberVideoView = this.f21739h) == null) {
            return;
        }
        tbCyberVideoView.pause();
    }

    public final void U1(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i2) == null) && this.O != null && this.V == null) {
            StatisticItem statisticItem = new StatisticItem("c12794");
            statisticItem.param("tid", this.O.thread_id);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i2);
            TiebaStatic.log(statisticItem);
            StatisticItem statisticItem2 = new StatisticItem("common_exp");
            statisticItem2.param("tid", this.O.thread_id);
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem2.param("obj_type", i2);
            statisticItem2.param(TiebaStatic.Params.OBJ_PAGE, "a023");
            statisticItem2.param("page_type", "a023");
            statisticItem2.param(TiebaStatic.Params.IS_VERTICAL, 1);
            TiebaStatic.log(statisticItem2);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.O == null) {
            return;
        }
        d.a.s0.n2.o oVar = new d.a.s0.n2.o();
        oVar.f64043a = VideoPlayActivity.FROM_VIDEO_PLAY;
        VideoItemData videoItemData = this.O;
        oVar.f64045c = videoItemData.thread_id;
        oVar.t = videoItemData.nid;
        oVar.f64046d = this.O.forum_id + "";
        oVar.f64047e = TbadkCoreApplication.getCurrentAccount();
        VideoItemData videoItemData2 = this.O;
        oVar.f64048f = videoItemData2.mRecomSource;
        oVar.f64049g = videoItemData2.mRecomAbTag;
        oVar.f64050h = videoItemData2.mRecomWeight;
        oVar.f64051i = "";
        oVar.k = "";
        oVar.m = videoItemData2.mMd5;
        if (this.V != null) {
            oVar.n = "1";
        } else {
            oVar.n = "2";
        }
        if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.n0)) {
            oVar.p = "1";
            oVar.f64043a = "auto_midpage";
            oVar.f64051i = "index";
        }
        d.a.s0.n2.h.e(this.O.mMd5, "", "1", oVar, this.f21739h.getPcdnState());
    }

    public final void W1() {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.t == null || (imageView = this.s) == null) {
            return;
        }
        imageView.clearAnimation();
        this.t.clearAnimation();
        this.s.setVisibility(0);
        this.t.setVisibility(8);
    }

    public final void X1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || i2()) {
            return;
        }
        TbCyberVideoView tbCyberVideoView = this.f21739h;
        if (tbCyberVideoView != null && this.u != null && this.O != null) {
            if (tbCyberVideoView.getParent() == null) {
                b2();
                c2();
            }
            if (TbVideoViewSet.d().e(this.w0) == null || TbVideoViewSet.d().e(this.w0) != this.f21739h) {
                VideoMiddleNiaiControllerView videoMiddleNiaiControllerView = this.R;
                if (videoMiddleNiaiControllerView != null) {
                    videoMiddleNiaiControllerView.q();
                }
                this.f21739h.setVideoPath(this.w0, this.O.thread_id);
            }
            this.f21739h.R(null);
            this.R.s();
            this.u.setVisibility(8);
            g2();
            l0 l0Var = this.H0;
            if (l0Var != null) {
                l0Var.onStart();
            }
        }
        if (this.m0 || isPrimary()) {
            return;
        }
        T1();
    }

    public void Y1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.m0 = z2;
            setPrimary(z2);
        }
    }

    public final void Z1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.I == null) {
            return;
        }
        Drawable drawable = getPageContext().getResources().getDrawable(R.drawable.icon_pure_followed);
        drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds29), UtilHelper.getDimenPixelSize(R.dimen.tbds18));
        this.I.setCompoundDrawables(drawable, null, null, null);
    }

    @Override // d.a.s0.x3.d.a.a
    public VideoItemModel a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.P : (VideoItemModel) invokeV.objValue;
    }

    public void a2(f.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            this.G0 = cVar;
        }
    }

    public void b2() {
        TbCyberVideoView tbCyberVideoView;
        TbCyberVideoView tbCyberVideoView2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048606, this) == null) && (tbCyberVideoView = this.f21739h) != null && tbCyberVideoView.getParent() == null) {
            VideoItemData videoItemData = this.O;
            if (videoItemData != null) {
                int d2 = d.a.c.e.m.b.d(videoItemData.video_height, 0);
                int d3 = d.a.c.e.m.b.d(this.O.video_width, 0);
                float f2 = 0.0f;
                if (d2 != 0 && d3 != 0) {
                    f2 = (d2 * 1.0f) / d3;
                }
                if (f2 > 1.0f) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    this.c0 = layoutParams;
                    layoutParams.addRule(13);
                } else {
                    d.a.c.e.p.l.i(this.f21738g.getContext());
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, (int) (f2 * d.a.c.e.p.l.k(this.f21738g.getContext())));
                    this.c0 = layoutParams2;
                    layoutParams2.addRule(13);
                    this.f21740i.setLayoutParams(this.c0);
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.u.getLayoutParams();
                    layoutParams3.removeRule(13);
                    layoutParams3.addRule(13);
                    this.u.requestLayout();
                }
                if (this.f21738g != null && (tbCyberVideoView2 = this.f21739h) != null && tbCyberVideoView2.getView() != null) {
                    ((ViewGroup) this.f21738g).addView(this.f21739h.getView(), 0, this.c0);
                }
            }
            if (this.O != null) {
                d.a.s0.n2.o oVar = new d.a.s0.n2.o();
                oVar.f64047e = TbadkCoreApplication.getCurrentAccount();
                VideoItemData videoItemData2 = this.O;
                oVar.f64045c = videoItemData2.thread_id;
                oVar.t = videoItemData2.nid;
                oVar.f64046d = videoItemData2.forum_id;
                oVar.m = videoItemData2.mMd5;
                oVar.k = "";
                oVar.f64048f = videoItemData2.mRecomSource;
                oVar.l = videoItemData2.mRecomAbTag;
                oVar.j = 1;
                BaijiahaoData baijiahaoData = videoItemData2.baijiahaoData;
                if (baijiahaoData != null) {
                    int i2 = baijiahaoData.oriUgcType;
                    if (i2 == 2) {
                        oVar.j = 3;
                    } else if (i2 == 4) {
                        oVar.j = 2;
                    }
                }
                oVar.f64050h = this.O.mRecomWeight;
                if (this.V != null) {
                    oVar.n = "1";
                } else {
                    oVar.n = "2";
                }
                if (VideoPlayActivityConfig.FROM_NANI_VIDEO.equals(this.n0)) {
                    oVar.p = "1";
                    oVar.f64043a = "13";
                    oVar.f64051i = this.o0;
                    oVar.k = this.z0;
                    oVar.f64049g = this.O.mRecomWeight;
                } else {
                    oVar.f64043a = "14";
                }
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
                    oVar.p = "1";
                    if ("a088".equals(this.p0)) {
                        oVar.f64043a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_QQFAVORITES;
                    } else if ("a089".equals(this.p0)) {
                        oVar.f64043a = com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
                    }
                    oVar.f64051i = this.o0;
                    oVar.k = this.z0;
                    oVar.f64049g = this.O.mRecomWeight;
                }
                this.f21739h.setVideoStatData(oVar);
                this.f21739h.setLocateSource("v_mid_page");
            }
            this.f21739h.setContinuePlayEnable(true);
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                this.f21739h.setOnPreparedListener(this.R0);
            }
            this.f21739h.setOnCompletionListener(this.Q0);
            this.f21739h.setOnInfoListener(this.P0);
        }
    }

    public final void d2(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, str) == null) || this.f21739h == null || str == null || str.equals(this.w0)) {
            return;
        }
        this.f21739h.setVideoPath(str, this.O.thread_id);
        this.w0 = str;
    }

    public void e2(l0 l0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, l0Var) == null) {
            this.H0 = l0Var;
        }
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || this.q0 == null || getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        this.q0.l();
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048611, this) == null) && d.a.c.e.p.j.x()) {
            d.a.s0.v3.f.d().g(getContext());
        }
    }

    public final void h2() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.q0 == null) {
                this.r0 = new d.a.r0.r.s.l(getActivity());
                this.q0 = new d.a.r0.r.s.j(getPageContext(), this.r0);
                ArrayList arrayList = new ArrayList();
                d.a.r0.r.s.h hVar = new d.a.r0.r.s.h(getActivity().getString(R.string.mark), this.r0);
                boolean z2 = false;
                VideoItemData videoItemData = this.O;
                if (videoItemData != null && (str = videoItemData.post_id) != null && str.equals(videoItemData.mark_id)) {
                    z2 = true;
                }
                if (z2) {
                    hVar.n(getResources().getString(R.string.remove_mark));
                } else {
                    hVar.n(getResources().getString(R.string.mark));
                }
                hVar.m(this.L0);
                VideoItemData videoItemData2 = this.O;
                if (videoItemData2 != null && !videoItemData2.isBjhVideo) {
                    arrayList.add(hVar);
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_ACCOUNT_ADD_COLLECTION_CLICK);
                    statisticItem.param("tid", this.O.thread_id);
                    statisticItem.param("fid", this.O.forum_id);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
                        statisticItem.param("obj_type", 1);
                    } else {
                        statisticItem.param("obj_type", 2);
                    }
                    if ("a088".equals(this.p0)) {
                        statisticItem.param("obj_param1", 1);
                    } else if ("a089".equals(this.p0)) {
                        statisticItem.param("obj_param1", 2);
                    }
                    statisticItem.param("obj_source", N1());
                    TiebaStatic.log(statisticItem);
                }
                d.a.r0.r.s.h hVar2 = new d.a.r0.r.s.h(getActivity().getString(R.string.report_text), this.r0);
                hVar2.m(this.M0);
                arrayList.add(hVar2);
                d.a.r0.r.s.h hVar3 = new d.a.r0.r.s.h(getActivity().getString(R.string.delete), this.r0);
                hVar3.m(this.N0);
                if (this.k0) {
                    arrayList.add(hVar3);
                }
                this.r0.m(new s(this));
                this.q0.setOnDismissListener(new t(this));
                this.r0.k(arrayList);
            }
            f2();
        }
    }

    public final boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (d.a.s0.v3.f.d().e() || TbadkCoreApplication.getInst().getVideoAutoPlay() == 2 || (!VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0) && TbSingleton.getInstance().isTipsAutoPlayInVideoMiddle())) {
                return false;
            }
            if ((!VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0) || !TbSingleton.getInstance().isTipsAutoPlayInVideoChannel()) && d.a.c.e.p.j.x() && this.m0 && isPrimary()) {
                d.a.c.e.p.l.N(TbadkCoreApplication.getInst(), getResources().getString(R.string.video_no_wifi_tips), 3000);
                if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
                    TbSingleton.getInstance().setTipsAutoPlayInVideoChannel(true);
                } else {
                    TbSingleton.getInstance().setTipsAutoPlayInVideoMiddle(true);
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j2() {
        VideoItemData videoItemData;
        String str;
        String str2;
        String format;
        VideoItemData videoItemData2;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (videoItemData = this.O) == null) {
            return;
        }
        String str3 = videoItemData.forum_id;
        String str4 = videoItemData.forum_name;
        String str5 = videoItemData.title;
        BaijiahaoData baijiahaoData = videoItemData.baijiahaoData;
        if (baijiahaoData != null) {
            str = baijiahaoData.oriUgcTid;
            str2 = "?share=9105&fr=dshare&dtype=" + this.O.baijiahaoData.oriUgcType + "&dvid=" + this.O.baijiahaoData.oriUgcVid + "&nid=" + this.O.baijiahaoData.oriUgcNid;
        } else {
            str = videoItemData.thread_id;
            str2 = "?share=9105&fr=share";
        }
        String str6 = "http://tieba.baidu.com/p/" + str + (str2 + "&share_from=post");
        String str7 = this.O.thumbnail_url;
        String string = getResources().getString(R.string.share_content_tpl);
        String string2 = getResources().getString(R.string.default_share_content_tpl);
        VideoItemData videoItemData3 = this.O;
        if (videoItemData3.isBjhVideo && (userItemData = videoItemData3.author_info) != null) {
            format = MessageFormat.format(string2, userItemData.name_show, getResources().getString(R.string.default_share_content_tpl_suffix));
        } else {
            format = MessageFormat.format(string, str5, "");
        }
        Uri parse = str7 == null ? null : Uri.parse(str7);
        ShareItem shareItem = new ShareItem();
        shareItem.r = str5;
        shareItem.s = format;
        if (this.O.baijiahaoData == null) {
            shareItem.R = videoItemData2.play_count;
        }
        if (this.O.isBjhVideo) {
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
        shareItem.f12826f = true;
        if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
            if ("a088".equals(this.p0)) {
                shareItem.E = 25;
                shareItem.I = 19;
            } else if ("a089".equals(this.p0)) {
                shareItem.E = 29;
                shareItem.I = 20;
            }
        } else {
            shareItem.E = 12;
            shareItem.I = 18;
        }
        if (this.O.getVideoType() == 1) {
            shareItem.M = 2;
        } else if (this.O.getVideoType() == 2) {
            shareItem.M = 8;
        } else if (this.O.getVideoType() == 3) {
            shareItem.M = 6;
        }
        if (parse != null) {
            shareItem.v = parse;
        }
        if (this.O.isBjhVideo) {
            shareItem.f0 = false;
        }
        OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
        VideoItemData videoItemData4 = this.O;
        originalThreadInfo.f12232c = videoItemData4.thumbnail_url;
        originalThreadInfo.f12230a = 3;
        originalThreadInfo.f12231b = videoItemData4.title;
        originalThreadInfo.f12235f = videoItemData4.thread_id;
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
        shareDialogConfig.setIsAlaLive(false);
        shareDialogConfig.setFrom(ShareDialogConfig.From.VideoMiddlePageVertical);
        d.a.s0.e0.f.b().k(shareDialogConfig);
    }

    @Override // d.a.r0.b1.p.a.b
    public void k() {
        VideoItemData videoItemData;
        UserItemData userItemData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (videoItemData = this.O) == null || (userItemData = videoItemData.author_info) == null) {
            return;
        }
        long f2 = d.a.c.e.m.b.f(userItemData.user_id, 0L);
        long f3 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        boolean z2 = f2 == f3;
        if (f2 == 0 && f3 == 0) {
            z2 = false;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(getActivity()).createNormalConfig(f2, z2, false)));
    }

    @Override // d.a.r0.b1.p.a.b
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            if (this.f21739h.isPlaying()) {
                this.f21739h.pause();
                this.u.setVisibility(0);
                C1(false);
                d.a.c.e.m.e.a().removeCallbacks(this.O0);
                K1(4);
            } else if (i2()) {
            } else {
                this.f21739h.start();
                this.u.setVisibility(8);
                C1(true);
                this.R.s();
                if (this.m0 || isPrimary()) {
                    return;
                }
                T1();
            }
        }
    }

    @Override // d.a.s0.x3.d.a.a
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.E0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, bundle) == null) {
            super.onActivityCreated(bundle);
            if (this.k0) {
                ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
                this.s0 = forumManageModel;
                forumManageModel.setLoadDataCallBack(new q(this));
            }
            d.a.r0.h.a c2 = d.a.r0.h.a.c(getBaseFragmentActivity());
            this.t0 = c2;
            if (c2 != null) {
                c2.j(new r(this));
            }
            this.u0 = new d.a.r0.s.e.a(null);
            registerListener(this.I0);
            registerListener(this.J0);
            if (Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode()) {
                return;
            }
            this.C0 = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048619, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            P1(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            super.onChangeSkinType(i2);
            d.a.s0.x3.c.a aVar = this.F0;
            if (aVar != null && aVar.a() != null) {
                this.F0.a().w(i2);
            }
            d.a.r0.r.s.l lVar = this.r0;
            if (lVar != null) {
                lVar.j();
            }
            if (this.f21738g != null) {
                this.X.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_reply36, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.Y.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_mask_video_share36, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.t.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_share_wechat120, WebPManager.ResourceStateType.NORMAL_PRESS));
                this.u.setImageDrawable(WebPManager.getMaskDrawable(R.drawable.icon_pure_video_play208, WebPManager.ResourceStateType.NORMAL));
                A1();
                d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.a0);
                d2.n(R.string.J_X01);
                d2.f(R.color.CAM_X0614);
                d.a.r0.r.u.c d3 = d.a.r0.r.u.c.d(this.F);
                d3.y(R.string.F_X02);
                d3.t(R.color.CAM_X0101);
                d.a.r0.r.u.c.d(this.G).y(R.string.F_X02);
                d.a.r0.r.u.c d4 = d.a.r0.r.u.c.d(this.E);
                d4.x(R.dimen.T_X09);
                d4.y(R.string.F_X02);
                d4.w(R.array.S_O_X001);
                d.a.r0.r.u.c d5 = d.a.r0.r.u.c.d(this.D);
                d5.x(R.dimen.T_X09);
                d5.y(R.string.F_X02);
                d5.w(R.array.S_O_X001);
                d.a.r0.r.u.c d6 = d.a.r0.r.u.c.d(this.C);
                d6.x(R.dimen.T_X09);
                d6.y(R.string.F_X02);
                d6.w(R.array.S_O_X001);
                d.a.r0.r.u.c d7 = d.a.r0.r.u.c.d(this.Z);
                d7.x(R.dimen.T_X06);
                d7.y(R.string.F_X02);
                d7.w(R.array.S_O_X001);
                d.a.r0.r.u.c d8 = d.a.r0.r.u.c.d(this.H);
                d8.n(R.string.J_X01);
                d8.x(R.dimen.T_X09);
                d8.t(R.color.CAM_X0101);
                d8.y(R.string.F_X02);
                d8.f(R.color.CAM_X0302);
                d.a.r0.r.u.c d9 = d.a.r0.r.u.c.d(this.I);
                d9.n(R.string.J_X01);
                d9.x(R.dimen.T_X09);
                d9.f(R.color.CAM_X0302);
                this.G.setTextColor(d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.r0.r.u.a.a(R.string.A_X08)));
                this.D.setTextColor(d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.r0.r.u.a.a(R.string.A_X03)));
                this.E.setTextColor(d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.r0.r.u.a.a(R.string.A_X03)));
                this.C.setTextColor(d.a.s0.h3.c.a(SkinManager.getColor(R.color.CAM_X0101), d.a.r0.r.u.a.a(R.string.A_X03)));
            }
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_return40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(this.l, R.drawable.icon_pure_topbar_more40, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bundle) == null) {
            super.onCreate(bundle);
            registerListener(this.K0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048622, this, layoutInflater, viewGroup, bundle)) == null) {
            Bundle arguments = getArguments();
            VideoItemModel videoItemModel = (VideoItemModel) arguments.get(VideoPlayActivityConfig.VIDEO_DATA);
            this.P = videoItemModel;
            this.O = videoItemModel == null ? null : videoItemModel.getVideoItemData();
            this.V = (Rect) arguments.getParcelable(VideoPlayActivityConfig.VIDEO_COVER_RECT);
            this.l0 = arguments.getInt(VideoPlayActivityConfig.VIDEO_INDEX);
            this.n0 = arguments.getString("page_from");
            this.o0 = arguments.getString("from");
            this.p0 = arguments.getString(VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB);
            this.z0 = arguments.getString("obj_id");
            VideoItemData videoItemData = this.O;
            if (videoItemData != null && videoItemData.author_info != null && String.valueOf(TbadkCoreApplication.getCurrentAccountId()).equals(this.O.author_info.user_id)) {
                this.k0 = true;
            }
            this.f21738g = layoutInflater.inflate(R.layout.video_play_view, (ViewGroup) null);
            this.f21738g.setOnTouchListener(new g0(this, new GestureDetectorCompat(getContext(), new f0(this))));
            this.f21738g.setOnLongClickListener(new h0(this));
            TbCyberVideoView tbCyberVideoView = new TbCyberVideoView(getContext());
            this.f21739h = tbCyberVideoView;
            tbCyberVideoView.setStageType("2005");
            this.f21739h.getMediaProgressObserver().j(new i0(this));
            TbImageView tbImageView = (TbImageView) this.f21738g.findViewById(R.id.video_cover);
            this.f21740i = tbImageView;
            tbImageView.setDefaultBgResource(R.drawable.icon_video_place_holder);
            this.u = (ImageView) this.f21738g.findViewById(R.id.play_btn);
            b2();
            if (DeviceInfoUtil.isHWnova() || (!TbSingleton.getInstance().isNotchScreen(getActivity()) && !TbSingleton.getInstance().isCutoutScreen(getActivity()))) {
                this.j = this.f21738g.findViewById(R.id.top_container);
                int statusBarHeight = UtilHelper.getStatusBarHeight();
                if (this.j.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) this.j.getLayoutParams()).topMargin = statusBarHeight;
                }
            }
            this.k = (ImageView) this.f21738g.findViewById(R.id.back_btn);
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
                this.k.setVisibility(8);
            }
            this.l = (ImageView) this.f21738g.findViewById(R.id.more_btn);
            LinearLayout linearLayout = (LinearLayout) this.f21738g.findViewById(R.id.recommend_layout);
            this.v = linearLayout;
            d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(linearLayout);
            d2.n(R.string.J_X04);
            d2.f(R.color.CAM_X0106);
            d.a.r0.r.u.b bVar = (d.a.r0.r.u.b) this.v.getBackground();
            bVar.B(SkinManager.getColor(0, R.color.CAM_X0106));
            this.v.setBackground(bVar);
            d.a.r0.r.u.c.d(this.v).e(R.string.A_X07);
            BarImageView barImageView = (BarImageView) this.f21738g.findViewById(R.id.recommend_forum_avatar);
            this.w = barImageView;
            barImageView.setShowOval(true);
            this.x = (TextView) this.f21738g.findViewById(R.id.recommend_info_view);
            HeadImageView headImageView = (HeadImageView) this.f21738g.findViewById(R.id.author_portrait);
            this.m = headImageView;
            headImageView.setDefaultResource(17170445);
            this.m.setPlaceHolder(2);
            this.m.setIsRound(true);
            this.m.setBorderWidth(R.dimen.L_X02);
            this.m.setBorderColor(R.color.CAM_X0622);
            this.m.setDrawBorder(true);
            this.K = (RelativeLayout) this.f21738g.findViewById(R.id.author_info_container);
            this.n = (LinearLayout) this.f21738g.findViewById(R.id.bottom_container);
            this.H = (EMTextView) this.f21738g.findViewById(R.id.love_btn);
            this.I = (EMTextView) this.f21738g.findViewById(R.id.has_love);
            Z1();
            this.W = (ImageView) this.f21738g.findViewById(R.id.agree_img);
            this.y = (ExpandableTextView) this.f21738g.findViewById(R.id.video_title);
            this.z = (TextView) this.f21738g.findViewById(R.id.title_full_screen_text);
            this.A = this.f21738g.findViewById(R.id.title_full_screen_btn);
            this.B = this.f21738g.findViewById(R.id.video_title_layout);
            this.R = (VideoMiddleNiaiControllerView) this.f21738g.findViewById(R.id.media_controller);
            this.J = (TextView) this.f21738g.findViewById(R.id.video_activity);
            this.p = (LinearLayout) this.f21738g.findViewById(R.id.comment_container);
            this.C = (EMTextView) this.f21738g.findViewById(R.id.comment_num);
            this.X = (ImageView) this.f21738g.findViewById(R.id.comment_img);
            this.o = (LinearLayout) this.f21738g.findViewById(R.id.agree_container);
            this.r = (LinearLayout) this.f21738g.findViewById(R.id.ll_drag_container);
            this.q = (LinearLayout) this.f21738g.findViewById(R.id.share_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
            if (VideoPlayActivityConfig.FROM_VIDEO_ACCOUNT_TAB.equals(this.o0)) {
                this.R.t(1);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds109);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X007);
            } else {
                this.R.t(0);
                layoutParams.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds211);
                layoutParams2.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds123);
                layoutParams3.bottomMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds126);
            }
            this.D = (EMTextView) this.f21738g.findViewById(R.id.agree_num);
            this.Y = (ImageView) this.f21738g.findViewById(R.id.share_img);
            this.E = (EMTextView) this.f21738g.findViewById(R.id.share_num);
            this.F = (EMTextView) this.f21738g.findViewById(R.id.drag_cur_time);
            this.G = (EMTextView) this.f21738g.findViewById(R.id.drag_total_time);
            this.s = (ImageView) this.f21738g.findViewById(R.id.share_img);
            this.t = (ImageView) this.f21738g.findViewById(R.id.share_img_changed);
            W1();
            this.L = (LinearLayout) this.f21738g.findViewById(R.id.video_act_private_container);
            this.M = (LinearLayout) this.f21738g.findViewById(R.id.video_activity_container);
            this.N = (LinearLayout) this.f21738g.findViewById(R.id.video_private);
            this.Z = (TextView) this.f21738g.findViewById(R.id.video_author_name);
            View findViewById = this.f21738g.findViewById(R.id.quick_reply_comment_layout);
            this.a0 = findViewById;
            findViewById.setOnClickListener(new j0(this));
            VideoItemData videoItemData2 = this.O;
            if (videoItemData2 != null) {
                if (videoItemData2.video_duration > 15) {
                    this.R.setVisibility(0);
                } else {
                    this.R.setVisibility(8);
                }
            }
            this.R.setPlayer(this.f21739h);
            this.R.setOnSeekBarChangeListener(new k0(this));
            this.b0 = (TextView) this.f21738g.findViewById(R.id.quick_reply_comment_text);
            TextView textView = (TextView) this.f21738g.findViewById(R.id.download_nani_guide_txt);
            this.Q = textView;
            textView.setVisibility(8);
            String p2 = d.a.r0.r.d0.b.j().p("nani_key_download_txt", null);
            if (!TextUtils.isEmpty(p2)) {
                this.Q.setText(p2);
            }
            this.Q.setOnClickListener(new a(this, d.a.r0.r.d0.b.j().p("nani_key_download_link_url", null)));
            E1();
            b bVar2 = new b(this);
            this.m.setOnClickListener(bVar2);
            this.Z.setOnClickListener(bVar2);
            this.M.setOnClickListener(new c(this));
            this.y.setHasDown();
            this.y.setOnClickListener(new d(this));
            this.A.setOnClickListener(new e(this));
            this.k.setOnClickListener(new f(this));
            this.l.setOnClickListener(new g(this));
            this.p.setOnClickListener(new h(this));
            this.o.setOnClickListener(new i(this));
            this.q.setOnClickListener(new j(this));
            this.H.setOnClickListener(new l(this));
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.U = alphaAnimation;
            alphaAnimation.setDuration(350L);
            this.U.setAnimationListener(new m(this));
            Rect rect = this.V;
            if (rect != null) {
                this.i0 = rect.right - rect.left;
                this.j0 = rect.bottom - rect.top;
                this.f21740i.post(new n(this));
            } else {
                this.f21740i.post(new o(this));
            }
            S1();
            if (this.S) {
                J1();
            }
            VideoItemData videoItemData3 = this.O;
            if (videoItemData3 != null && !StringUtils.isNull(videoItemData3.video_url)) {
                d2(this.O.video_url);
            }
            return this.f21738g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            stopPlay();
            super.onDestroy();
            MessageManager.getInstance().unRegisterListener(this.K0);
            d.a.s0.x3.c.a aVar = this.F0;
            if (aVar != null) {
                aVar.o();
            }
            if (this.O0 != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.O0);
                this.O0 = null;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onPause();
            T1();
            d.a.s0.x3.c.a aVar = this.F0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.F0.a().o();
            this.a0.setVisibility(8);
            this.b0.setText(StringUtils.isNull(((d.a.s0.x3.c.c) this.F0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            super.onPrimary();
            if (this.m0 && isPrimary()) {
                if (!TbSingleton.getInstance().isNotchScreen(getActivity())) {
                    TbSingleton.getInstance().isCutoutScreen(getActivity());
                }
                VideoItemData videoItemData = this.O;
                if (videoItemData == null || StringUtils.isNull(videoItemData.video_url)) {
                    return;
                }
                this.T = true;
                if (this.S) {
                    V1();
                    X1();
                    U1(0);
                    return;
                }
                T1();
                return;
            }
            T1();
            d.a.s0.x3.c.a aVar = this.F0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.F0.a().o();
            this.a0.setVisibility(8);
            this.b0.setText(StringUtils.isNull(((d.a.s0.x3.c.c) this.F0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            super.onStop();
            T1();
            d.a.s0.x3.c.a aVar = this.F0;
            if (aVar == null || aVar.a() == null) {
                return;
            }
            this.F0.a().o();
            this.a0.setVisibility(8);
            this.b0.setText(StringUtils.isNull(((d.a.s0.x3.c.c) this.F0.a().n(28)).g().getText().toString()) ? R.string.reply_something : R.string.draft_to_replay);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            E1();
            c2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z2) == null) {
            super.setUserVisibleHint(z2);
            this.S = z2;
            if (!z2 && this.F0 != null) {
                this.b0.setText(R.string.reply_something);
                this.F0.l();
            }
            if (this.T) {
                if (this.S && (!this.C0 || Build.VERSION.SDK_INT < 24 || !getBaseFragmentActivity().isInMultiWindowMode())) {
                    U1(1);
                    startPlay();
                    J1();
                    this.C0 = false;
                    return;
                }
                W1();
                this.D0 = 1;
                T1();
            }
        }
    }

    public final void startPlay() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || i2()) {
            return;
        }
        g2();
        ImageView imageView = this.u;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT < 17 && this.f21740i.getVisibility() == 0) {
            this.f21740i.clearAnimation();
            this.f21740i.startAnimation(this.U);
        }
        if (this.f21739h != null) {
            if (TbVideoViewSet.d().e(this.w0) == null || TbVideoViewSet.d().e(this.w0) != this.f21739h) {
                this.f21739h.setVideoPath(this.w0, this.O.thread_id);
            }
            this.f21739h.start();
            this.R.s();
            V1();
        }
        if (this.m0 || isPrimary()) {
            return;
        }
        T1();
    }

    public final void stopPlay() {
        TbCyberVideoView tbCyberVideoView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048630, this) == null) || (tbCyberVideoView = this.f21739h) == null) {
            return;
        }
        tbCyberVideoView.stopPlayback();
    }
}
