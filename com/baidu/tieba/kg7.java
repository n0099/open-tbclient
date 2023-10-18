package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsBannerHeaderData;
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.frs.FrsBountyTaskData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.banner.adapter.FrsHeadCommonFlowAdapter;
import com.baidu.tieba.frs.banner.data.FrsHeadBannerData;
import com.baidu.tieba.frs.entelechy.view.FrsBannerHeaderView;
import com.baidu.tieba.frs.headercomponent.HeaderComponentNoHeaderController;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.FrsGroupChatSignGuideView;
import com.baidu.tieba.frs.view.FrsHeaderVideoImageShadeView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.lego.card.utils.ColorUtils;
import com.baidu.tieba.mv9;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import tbclient.FrsPage.LiveFuseForumData;
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class kg7 extends es7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public CustomMessageListener A1;
    public LinearLayout B0;
    public CustomMessageListener B1;
    public View C0;
    public CustomMessageListener C1;
    public View D0;
    public CustomMessageListener D1;
    public View E0;
    public View F0;
    public View G0;
    public TbImageView H0;
    public TextView I0;
    public ImageView J0;
    public TBLottieAnimationView K0;
    public TbImageView L0;
    public boolean M0;
    public TextView N0;
    public final View O0;
    public final HeadImageView P0;
    public final TextView Q0;
    public final View R0;
    public final ImageView S0;
    public final TextView T0;
    public HotRankEntryView U0;
    public List<yh> V0;
    public no6 W0;
    public int X0;
    public long Y0;
    public ScheduledExecutorService Z0;
    public boolean a1;
    public boolean b1;
    public boolean c1;
    public CountDownTimer d1;
    @NonNull
    public final pn7 e1;
    @NonNull
    public final tn7 f1;
    public TbVideoView g1;
    public TbImageView h1;
    public View i1;
    public View j1;
    public TBLottieAnimationView k1;
    public TextView l1;
    public TBLottieAnimationView m1;
    public View n1;
    public View o1;
    public View p1;
    public View q1;
    public RelativeLayout r0;
    public FrsHeaderVideoImageShadeView r1;
    public TextView s0;
    public boolean s1;
    public TextView t0;
    public boolean t1;
    public String u0;
    public MessageRedDotView u1;
    public ArrayList<TbImageView> v0;
    public FrsBannerHeaderView v1;
    public oe7 w0;
    public FrsGroupChatSignGuideView w1;
    public boolean x0;
    public HeaderComponentNoHeaderController x1;
    public View y0;
    public CustomMessageListener y1;
    public View z0;
    public FrsHeadBannerData.BannerType z1;

    @Override // com.baidu.tieba.es7
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kg7 b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.G != null) {
                    if (this.a.b.G.getVisibility() == 8) {
                        this.a.b.G.setVisibility(0);
                        this.a.b.G.setText(this.a.a);
                        if (this.a.b.I != null) {
                            kg7 kg7Var = this.a.b;
                            kg7Var.d2(kg7Var.I.activity_msg, this.a.b.I.countdown_time.intValue());
                        }
                    } else if (this.a.b.G.getVisibility() == 0) {
                        this.a.b.G1();
                    }
                }
            }
        }

        public i(kg7 kg7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kg7Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SafeHandler.getInst().post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kg7 c;

        public a(kg7 kg7Var, nw4 nw4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, nw4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kg7Var;
            this.a = nw4Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.h1.setVisibility(8);
                    this.c.j1.setVisibility(8);
                    this.c.R1();
                    this.c.p2(this.a, 0);
                    vq7.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.c2();
                    vq7.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.c2();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.w2();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements mv9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw4 a;
        public final /* synthetic */ kg7 b;

        public b(kg7 kg7Var, nw4 nw4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, nw4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kg7Var;
            this.a = nw4Var;
        }

        @Override // com.baidu.tieba.mv9.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.p2(this.a, i2);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kg7 c;

        public c(kg7 kg7Var, nw4 nw4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, nw4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kg7Var;
            this.a = nw4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.j1.getVisibility() == 0) {
                    this.c.g1.start();
                    return;
                }
                xq7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    vq7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kg7 c;

        public d(kg7 kg7Var, nw4 nw4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, nw4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kg7Var;
            this.a = nw4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                xq7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    vq7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nw4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kg7 c;

        public e(kg7 kg7Var, nw4 nw4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, nw4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kg7Var;
            this.a = nw4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null && !dw5.a(this.c.a.getPageActivity(), this.a.f()) && !TextUtils.isEmpty(this.a.e())) {
                FrsViewData frsViewData = this.b;
                if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(this.b.getForum().getId()) && this.b.getActivityHeadData() != null && !TextUtils.isEmpty(this.b.getActivityHeadData().c())) {
                    String id = this.b.getForum().getId();
                    String c = this.b.getActivityHeadData().c();
                    StatisticItem statisticItem = new StatisticItem("c13330");
                    statisticItem.param("fid", id);
                    statisticItem.param("obj_id", c);
                    TiebaStatic.log(statisticItem);
                    if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                        statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                    }
                    vq7.d(this.b, 1, this.c.b.getUniqueId());
                }
                if (ad.isEquals(TbadkCoreApplication.getInst().getPackageName(), this.a.g()) && !StringUtils.isNull(this.a.i()) && this.c.b.getPageContext() != null) {
                    UrlManager.getInstance().dealOneLink(this.c.b.getPageContext(), new String[]{this.a.i()});
                } else {
                    xq7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.l(), 1));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        public f(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                hb.d(this.a.M, this.a.a.getPageActivity());
                this.a.b.c = false;
                BrowserHelper.startWebActivity(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f06fa), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        public g(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    hb.c(this.a.M);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kg7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(kg7 kg7Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, Long.valueOf(j), Long.valueOf(j2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kg7Var;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.H = false;
            if (this.b.G != null) {
                this.b.G.setVisibility(8);
            }
            if (this.b.Q != null && !this.b.k()) {
                this.b.Q.s(this.b.H, this.b.X1());
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) && this.b.G != null) {
                this.b.G.setVisibility(0);
                EMTextView eMTextView = this.b.G;
                eMTextView.setText(this.a + (j / 1000) + "s");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(kg7 kg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, Integer.valueOf(i)};
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
            this.a = kg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof nv4)) {
                nv4 nv4Var = (nv4) customResponsedMessage.getData();
                this.a.e2(nv4Var);
                this.a.Q1(nv4Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(kg7 kg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, Integer.valueOf(i)};
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
            this.a = kg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && gr7.m(this.a.W)) {
                this.a.c2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(kg7 kg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, Integer.valueOf(i)};
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
            this.a = kg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (gr7.m(this.a.W) && this.a.g1.getVisibility() == 0) {
                        this.a.c2();
                    }
                    this.a.t1 = false;
                } else if (intValue == 2 && gr7.m(this.a.W)) {
                    if (!this.a.t1) {
                        kg7 kg7Var = this.a;
                        kg7Var.L(kg7Var.W.getForum(), this.a.W);
                    }
                    this.a.t1 = false;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(kg7 kg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, Integer.valueOf(i)};
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
            this.a = kg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.s1 = true;
                if (intValue == 1) {
                    if (!FrsFragment.y2 && gr7.m(this.a.W)) {
                        kg7 kg7Var = this.a;
                        kg7Var.L(kg7Var.W.getForum(), this.a.W);
                    }
                } else if (intValue == 2) {
                    if (gr7.m(this.a.W)) {
                        kg7 kg7Var2 = this.a;
                        kg7Var2.L(kg7Var2.W.getForum(), this.a.W);
                    }
                } else if (intValue == 3) {
                    kg7 kg7Var3 = this.a;
                    kg7Var3.L(kg7Var3.W.getForum(), this.a.W);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(kg7 kg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, Integer.valueOf(i)};
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
            this.a = kg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            kg7 kg7Var = this.a;
            kg7Var.A2(kg7Var.W);
        }
    }

    /* loaded from: classes6.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRankInfoData a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kg7 c;

        public o(kg7 kg7Var, FrsGameRankInfoData frsGameRankInfoData, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var, frsGameRankInfoData, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kg7Var;
            this.a = frsGameRankInfoData;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null) {
                UrlManager.getInstance().dealOneLink(this.c.a, new String[]{this.a.rankLink});
                this.c.K0.pauseAnimation();
                this.c.K0.setFrame(Cea708Decoder.COMMAND_DSW);
                this.c.z2(this.b, this.a, "c15056");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class p implements oe7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        public p(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg7Var;
        }

        @Override // com.baidu.tieba.oe7
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                fr7.d(this.a.b, this.a.W, threadData);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q extends d25 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        public q(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg7Var;
        }

        @Override // com.baidu.tieba.d25, com.baidu.tieba.b25
        public e25 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e25 e25Var = new e25();
                e25Var.c(R.drawable.obfuscated_res_0x7f0806d5);
                e25Var.g(R.drawable.obfuscated_res_0x7f0806d4);
                e25Var.d(81);
                e25Var.e(R.dimen.M_H_X003);
                e25Var.h(R.dimen.M_W_X002);
                return e25Var;
            }
            return (e25) invokeV.objValue;
        }

        @Override // com.baidu.tieba.d25, com.baidu.tieba.b25
        public h25 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                h25 h25Var = new h25();
                h25Var.a(this.a.a.getResources().getDimensionPixelSize(R.dimen.tbds198));
                return h25Var;
            }
            return (h25) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class r implements f25<FrsHeadBannerData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kg7 a;

        public r(kg7 kg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kg7Var;
        }

        @Override // com.baidu.tieba.f25
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) != null) {
                return;
            }
            this.a.I1(CommonStatisticKey.KEY_FRS_BANNER_FORUM_MOUNT_CLICK);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f25
        /* renamed from: c */
        public void a(int i, FrsHeadBannerData frsHeadBannerData) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, frsHeadBannerData) != null) || frsHeadBannerData == null) {
                return;
            }
            this.a.z1 = frsHeadBannerData.e();
            if (FrsHeadBannerData.BannerType.AD_PIC != frsHeadBannerData.e()) {
                if (FrsHeadBannerData.BannerType.FORUM_MOUNT != frsHeadBannerData.e()) {
                    return;
                }
                this.a.I1(CommonStatisticKey.KEY_FRS_BANNER_FORUM_MOUNT_SHOW);
                return;
            }
            this.a.H1(frsHeadBannerData.b());
        }
    }

    public kg7(FrsFragment frsFragment, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, str, str2, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.A0 = false;
        this.X0 = -1;
        this.Y0 = 1000L;
        this.e1 = on7.a();
        this.y1 = new j(this, 2921679);
        this.z1 = null;
        this.A1 = new k(this, 2921681);
        this.B1 = new l(this, 2921680);
        this.C1 = new m(this, 2921682);
        this.D1 = new n(this, 2921721);
        this.v0 = new ArrayList<>();
        this.c0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        BdUtilHelper.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        BdUtilHelper.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        BdUtilHelper.getDimens(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070375);
        this.f1100T = str;
        this.U = str2;
        View L1 = L1();
        this.d = L1;
        this.e1.c(frsFragment, L1);
        this.f1 = this.e1.e();
        this.r0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0907bc);
        this.v = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090f1d);
        this.w = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090f20);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090f1e);
        this.x = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.x.setDefaultBgResource(R.color.transparent);
        this.x.setDefaultResource(R.drawable.obfuscated_res_0x7f0811f4);
        this.y0 = this.d.findViewById(R.id.obfuscated_res_0x7f090f3f);
        this.g1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f0928ea);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0928e4);
        this.h1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.h1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f0811f4);
        this.h1.setDefaultResource(R.drawable.obfuscated_res_0x7f0811f4);
        this.h1.setPlaceHolder(2);
        this.i1 = this.d.findViewById(R.id.obfuscated_res_0x7f0928e9);
        this.j1 = this.d.findViewById(R.id.obfuscated_res_0x7f0928e8);
        this.k1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0928e7);
        this.z0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d7e);
        this.S = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d0f);
        on7.d(this.y0, this.z0);
        this.n1 = on7.b(this.d);
        this.o1 = this.d.findViewById(R.id.obfuscated_res_0x7f090f1f);
        this.p1 = this.d.findViewById(R.id.obfuscated_res_0x7f09164a);
        this.l1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0927be);
        this.m1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f091699);
        this.q1 = this.d.findViewById(R.id.obfuscated_res_0x7f0928e5);
        this.r1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f0928e3);
        this.B0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0914a2);
        int l2 = this.e1.l(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090f39);
        this.C0 = findViewById;
        findViewById.setVisibility(l2);
        this.D0 = this.d.findViewById(R.id.obfuscated_res_0x7f0921ad);
        this.E0 = this.d.findViewById(R.id.obfuscated_res_0x7f090336);
        this.y = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f0921af);
        this.z = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090c61);
        this.F = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0929c3);
        this.B = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090da7);
        this.F0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d9e);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f090d9f);
        this.D = this.d.findViewById(R.id.obfuscated_res_0x7f0921b3);
        this.E = this.d.findViewById(R.id.obfuscated_res_0x7f0921b2);
        this.h = (List) this.e1.a(LogicField.LIKE_BTN);
        this.i = (List) this.e1.a(LogicField.SIGN_BTN);
        this.L = (ImageView) K1().a(LogicField.SPEED_ICON);
        this.s0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09173b);
        this.t0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091d30);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09151c);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091514);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0916a0);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09169f);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091740);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091d36);
        this.n = (TextView) this.d.findViewById(R.id.forum_name);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090490);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cec);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f0324));
        this.N.setStrokeWith(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.d.findViewById(R.id.obfuscated_res_0x7f091ec2);
        this.u1 = messageRedDotView;
        messageRedDotView.setThreeDotMode(2);
        this.u1.setEnterForumStyle(true);
        this.u1.setVisibility(8);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f091515);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090f01);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0919d7);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090f0c);
        this.u = this.d.findViewById(R.id.obfuscated_res_0x7f090f0d);
        this.O0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d39);
        this.Q0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090d3a);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d3b);
        this.P0 = headImageView;
        headImageView.setIsRound(true);
        this.P0.setDrawBorder(true);
        this.P0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.P0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.R0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d38);
        this.S0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d37);
        this.T0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090d36);
        WebPManager.setPureDrawable(this.S0, R.drawable.obfuscated_res_0x7f0809d5, R.color.CAM_X0101, null);
        this.K = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03a6, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0373, (ViewGroup) null);
        this.U0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090cea);
        this.m.setVisibility(8);
        this.G = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907f9);
        this.m0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090f29);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f090e0b);
        TbImageView tbImageView3 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090e0a);
        this.H0 = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.H0.setConrers(15);
        this.H0.setRadiusById(R.string.J_X05);
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090e0e);
        this.I0 = textView;
        textView.getPaint().setStrokeWidth(0.5f);
        this.I0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.J0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090e0c);
        this.K0 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090e0d);
        this.L0 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090e09);
        this.K0.setImageAssetsFolder("lottie_frs_game_rank_guide");
        this.K0.setAnimation(R.raw.lottie_frs_game_rank_guide);
        this.K0.setRepeatMode(1);
        this.K0.setMinAndMaxFrame(57, Cea708Decoder.COMMAND_DSW);
        this.v1 = (FrsBannerHeaderView) this.d.findViewById(R.id.obfuscated_res_0x7f090c78);
        this.w1 = (FrsGroupChatSignGuideView) this.d.findViewById(R.id.obfuscated_res_0x7f090ccb);
        MessageManager.getInstance().registerListener(this.y1);
        MessageManager.getInstance().registerListener(this.A1);
        MessageManager.getInstance().registerListener(this.B1);
        MessageManager.getInstance().registerListener(this.C1);
        MessageManager.getInstance().registerListener(this.D1);
    }

    @Override // com.baidu.tieba.es7
    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            super.B(z);
            CoverFlowView<FrsHeadBannerData> coverFlowView = this.A;
            if (coverFlowView != null) {
                coverFlowView.y(z);
            }
        }
    }

    public boolean S1(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            if (i2 <= 0 || i2 >= BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean T1(nw4 nw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, nw4Var)) == null) {
            if (nw4Var == null || StringUtils.isNull(nw4Var.c()) || StringUtils.isNull(nw4Var.h())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.es7
    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.e1.g(z);
        }
    }

    public final void d2(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048621, this, str, j2) == null) {
            this.H = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.Z0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new i(this, str), j2, TimeUnit.SECONDS);
        }
    }

    @Override // com.baidu.tieba.es7
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A();
            if (gr7.m(this.W)) {
                c2();
            }
            CoverFlowView<FrsHeadBannerData> coverFlowView = this.A;
            if (coverFlowView != null) {
                coverFlowView.x();
            }
        }
    }

    public final boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null && frsLikeRecommendLayout.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.es7
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.B.i(this.X0);
        }
    }

    @Override // com.baidu.tieba.es7
    public void H() {
        FrsViewData frsViewData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.b != null && (frsViewData = this.W) != null) {
            List<yh> showTopThreadList = frsViewData.getShowTopThreadList();
            if (showTopThreadList.size() > 2) {
                z = true;
            } else {
                z = false;
            }
            this.A0 = z;
            s2(showTopThreadList, this.W.getBusinessPromot());
        }
    }

    @Override // com.baidu.tieba.es7
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            qr7 qr7Var = this.Q;
            if (qr7Var != null) {
                qr7Var.q(this.b0);
            }
            P1(true);
        }
    }

    @Override // com.baidu.tieba.es7
    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            qr7 qr7Var = this.Q;
            if (qr7Var != null) {
                qr7Var.s(this.H, X1());
            }
            P1(false);
        }
    }

    @NonNull
    public pn7 K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.e1;
        }
        return (pn7) invokeV.objValue;
    }

    public View L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d039a, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final LinearGradientView N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.s4() != null) {
                View D = this.b.s4().D();
                if (D instanceof LinearGradientView) {
                    return (LinearGradientView) D;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    public final void R1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (tBLottieAnimationView = this.k1) != null) {
            tBLottieAnimationView.setVisibility(8);
            if (this.k1.isAnimating()) {
                this.k1.cancelAnimation();
            }
        }
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            FrsTopView frsTopView = this.B;
            if (frsTopView != null && frsTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null && serviceAreaView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity());
            int i2 = (equipmentWidth * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g1.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = i2;
            this.g1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    public final boolean X1() {
        InterceptResult invokeV;
        gw4 gw4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            if (!this.d0 && this.e0 && (gw4Var = this.f0) != null && !TextUtils.isEmpty(gw4Var.c())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.es7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            boolean U1 = U1();
            boolean V1 = V1();
            B1(U1, V1);
            D1(U1, V1);
        }
    }

    @Override // com.baidu.tieba.es7
    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            if (this.c0 != 0) {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    @Override // com.baidu.tieba.es7
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.e1.k(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    public final void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.h1.setVisibility(0);
            p2(null, -1);
            R1();
            TbVideoView tbVideoView = this.g1;
            if (tbVideoView != null) {
                tbVideoView.T();
            }
            this.g1.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.es7
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            F1();
        }
    }

    @Override // com.baidu.tieba.es7
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            SignActivityInfo signActivityInfo = this.I;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.N.startLoad(this.u0, 10, false);
        }
    }

    public void i2() {
        pr7 pr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (pr7Var = this.R) != null) {
            pr7Var.t();
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.v1.setVisibility(8);
            this.E.setVisibility(8);
            this.C0.setVisibility(this.e1.l(LogicField.ROUND_CORNER_STYLE));
        }
    }

    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.u0);
            this.X.getMedias().add(mediaData);
        }
    }

    @Override // com.baidu.tieba.es7
    public SignActivityInfo m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.I;
        }
        return (SignActivityInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.es7
    public void q() {
        no6 no6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048637, this) == null) && (no6Var = this.W0) != null) {
            no6Var.h();
            this.X0 = -1;
        }
    }

    public final boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (this.s1) {
                return true;
            }
            if (!this.b.I4() && !this.b.H4()) {
                return this.b.i4();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.es7
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.x0;
        }
        return invokeV.booleanValue;
    }

    public final String t2() {
        InterceptResult invokeV;
        gw4 gw4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            if (!this.d0 && this.e0 && (gw4Var = this.f0) != null) {
                return gw4Var.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.es7
    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final void A2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, frsViewData) == null) {
            if (frsViewData != null && frsViewData.getUserData() != null) {
                if (frsViewData.getUserData().getIs_manager() == 1 && frsViewData.getBaWuNoticeNum() > 0) {
                    this.u1.setVisibility(0);
                    this.u1.refresh(frsViewData.getBaWuNoticeNum());
                    return;
                }
                this.u1.setVisibility(8);
                return;
            }
            this.u1.setVisibility(8);
        }
    }

    public final int[] M1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            if (i2 <= 3) {
                return new int[]{-8331843, -10499102};
            }
            if (i2 <= 9) {
                return new int[]{-10499102, -154262};
            }
            if (i2 <= 15) {
                return new int[]{-154262, -148180};
            }
            return new int[]{-148180, -100818};
        }
        return (int[]) invokeI.objValue;
    }

    public final void Q1(nv4 nv4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, nv4Var) == null) && nv4Var != null && nv4Var.b() != 0.0f) {
            float d2 = nv4Var.d() / ((nv4Var.b() * 40.0f) / 70.0f);
            float d3 = nv4Var.d() / nv4Var.b();
            this.l1.setAlpha(d2);
            this.m1.setAlpha(d2);
            float f2 = 1.0f - d2;
            this.n1.setAlpha(f2);
            FrsGroupChatSignGuideView frsGroupChatSignGuideView = this.w1;
            if (frsGroupChatSignGuideView != null) {
                frsGroupChatSignGuideView.setAlpha(f2);
            }
            float f3 = 1.0f - d3;
            this.o1.setAlpha(f3);
            this.i1.setAlpha(f3);
        }
    }

    public final void Y1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, frsViewData) == null) {
            if (frsViewData == null) {
                j2();
                return;
            }
            FrsBannerHeaderData frsBannerHeaderData = frsViewData.frsBannerHeaderData;
            if (frsBannerHeaderData == null) {
                j2();
                return;
            }
            this.v1.setData(frsBannerHeaderData);
            if (frsViewData.getForum() != null) {
                this.v1.setForumInfo(frsViewData.getForum().getId(), frsViewData.getForum().getName());
            }
            View view2 = this.E;
            if (this.y.getVisibility() == 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.C0.setVisibility(8);
            this.v1.setVisibility(0);
        }
    }

    public final void B1(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int dimens;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (relativeLayout = this.v) != null && relativeLayout.getLayoutParams() != null) {
            if (this.U0.getVisibility() == 0) {
                dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.U0.getLayoutParams()).topMargin = (BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds226) + BdUtilHelper.getStatusBarHeight(this.a.getPageActivity())) - BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.x0) {
                dimens -= BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.x0) {
                if (gr7.m(this.W)) {
                    dimens = o2(z, z2);
                } else {
                    dimens = h2(z, z2);
                }
            }
            if (this.G0.getVisibility() == 0 || this.v1.getVisibility() == 0) {
                dimens += BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds125);
            }
            if (E1()) {
                dimens += this.S.getCurrentHeight();
            }
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            if (layoutParams.height != dimens) {
                layoutParams.height = dimens;
                this.v.setLayoutParams(layoutParams);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null) {
                    frsFragment.Y4();
                }
            }
        }
    }

    @Override // com.baidu.tieba.es7
    public void F(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.j0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.j0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0ba7);
                if (f2 >= 1.0f) {
                    i2 = this.Y;
                } else {
                    i2 = this.Y + 1;
                }
                FrsViewData s1 = this.b.s1();
                if (s1 != null && s1.getForum() != null) {
                    s1.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c52, Integer.valueOf(i2)));
            } else {
                this.e1.d(this.Y, this.V);
                this.j.setText(this.V);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c52, Integer.valueOf(this.Y)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, M1(this.Y)));
            if (this.j0) {
                if (f2 >= 1.0f) {
                    Z(this.k, this.l0, f2);
                } else {
                    X(this.k, this.l0, f2);
                }
            } else {
                Z(this.k, this.l0, f2);
            }
            this.l0 = f2;
        }
    }

    @Override // com.baidu.tieba.es7
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            CoverFlowView<FrsHeadBannerData> coverFlowView = this.A;
            if (coverFlowView != null) {
                coverFlowView.z();
            }
            if (FrsFragment.y2 && gr7.m(this.W)) {
                FrsFragment.y2 = false;
                L(this.W.getForum(), this.W);
            }
            if (this.z1 != null && S1(this.z) && FrsHeadBannerData.BannerType.FORUM_MOUNT == this.z1) {
                I1(CommonStatisticKey.KEY_FRS_BANNER_FORUM_MOUNT_SHOW);
            }
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean U1 = U1();
            boolean V1 = V1();
            if (!TextUtils.isEmpty(this.f1100T)) {
                eq7 c2 = dq7.d().c(this.f1100T);
                if (c2 == null) {
                    c2 = new eq7(this.A0, U1);
                } else {
                    c2.d(this.A0);
                    c2.e(U1);
                }
                dq7.d().e(this.f1100T, c2);
            }
            D1(U1, V1);
            B1(U1, V1);
        }
    }

    public final CoverFlowView<FrsHeadBannerData> J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            CoverFlowView<FrsHeadBannerData> coverFlowView = new CoverFlowView<>(this.a.getPageActivity());
            q qVar = new q(this);
            coverFlowView.setCallback(new r(this));
            coverFlowView.setIndicatorNoOffet(false);
            coverFlowView.setDisableParentEvent(false);
            coverFlowView.setCoverFlowFactory(qVar);
            coverFlowView.setIndicatorVisible(0);
            coverFlowView.setIsAutoPlayDragging(false);
            coverFlowView.setPagerAdapter(new FrsHeadCommonFlowAdapter(this.a.getPageActivity()));
            coverFlowView.setAutoPlay(false);
            return coverFlowView;
        }
        return (CoverFlowView) invokeV.objValue;
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            TextView textView = this.l1;
            if (textView != null && textView.getVisibility() == 8) {
                this.l1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.m1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.m1.getVisibility() == 4) {
                    this.m1.setVisibility(0);
                    if (this.m1.isAnimating()) {
                        this.m1.cancelAnimation();
                    }
                    this.m1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.m1.setRepeatCount(-1);
                    this.m1.playAnimation();
                }
            }
        }
    }

    public final void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.a.getPageActivity());
            int i2 = (equipmentWidth * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h1.getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = i2;
            this.h1.setLayoutParams(layoutParams);
            this.h1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i1.getLayoutParams();
            layoutParams2.width = equipmentWidth;
            layoutParams2.height = i2;
            this.i1.setLayoutParams(layoutParams2);
        }
    }

    public final void w2() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048646, this) == null) && (tBLottieAnimationView = this.k1) != null) {
            if (tBLottieAnimationView.getVisibility() == 8 || this.k1.getVisibility() == 4) {
                this.k1.setVisibility(0);
                if (this.k1.isAnimating()) {
                    this.k1.cancelAnimation();
                }
                this.k1.setAnimation(R.raw.lotti_video_loading);
                this.k1.setRepeatCount(-1);
                this.k1.playAnimation();
            }
        }
    }

    public final void D1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.b.s4() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B0.getLayoutParams();
        if (!z && !z2) {
            this.B0.setVisibility(0);
            this.D0.setVisibility(8);
            this.E0.setVisibility(this.e1.l(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.B0.setVisibility(0);
            this.D0.setVisibility(this.e1.l(LogicField.SERVICE_AREA));
            layoutParams.topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds55);
        }
        if (E1()) {
            layoutParams.topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.M_H_X004);
        }
        this.b.s4().t(z, z2);
    }

    public final int O1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<yh> list;
        List<vda> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                uda udaVar = this.W.serviceAreaData;
                if (udaVar != null && (list2 = udaVar.b) != null && list2.size() == 1) {
                    i2 = 0 + BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.V0) != null) {
                i2 += Math.min(list.size(), 2) * BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.z.getVisibility() == 0) {
                i2 += BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds231);
            }
            if (z2 || z || this.z.getVisibility() == 0) {
                return i2 + BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds45);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final int h2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds782);
            int O1 = O1(z, z2);
            k2(dimens);
            int i2 = dimens + O1;
            this.x.setVisibility(0);
            this.g1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.x.getLayoutParams()).bottomMargin = O1;
            ((RelativeLayout.LayoutParams) this.y0.getLayoutParams()).bottomMargin = O1;
            if (O1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds782) - BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void v2(FrsViewData frsViewData, nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048645, this, frsViewData, nw4Var) == null) && this.x != null && nw4Var != null) {
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                StatisticItem statisticItem = new StatisticItem("c13326");
                statisticItem.param("fid", frsViewData.getForum().getId());
                statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                TiebaStatic.log(statisticItem);
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                vq7.e(frsViewData, 1, this.b.getUniqueId());
            }
            this.x.startLoad(nw4Var.d(), 10, false);
            this.x.setOnClickListener(new e(this, nw4Var, frsViewData));
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.W != null && this.g1.getVisibility() == 0) {
            if (vq7.f()) {
                this.j1.setVisibility(8);
                if (this.b != null && !this.W.isFromCache && r2()) {
                    this.g1.start();
                    return;
                }
                return;
            }
            this.j1.setVisibility(0);
        }
    }

    public final void G1() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || this.I == null) {
            return;
        }
        CountDownTimer countDownTimer = this.d1;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.d1.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        boolean z3 = true;
        if ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis < 0) {
            z = true;
        } else {
            z = false;
        }
        this.a1 = z;
        if (this.I.activity_time.intValue() - currentTimeMillis <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.b1 = z2;
        if ((this.I.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis > 0) {
            z3 = false;
        }
        this.c1 = z3;
        boolean z4 = this.a1;
        if (z4) {
            this.G.setVisibility(8);
            return;
        }
        if (this.b1 && !z4) {
            y2(this.I.activity_msg, 1000 * ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis), this.Y0);
        }
        if (!this.b1 && this.c1) {
            this.G.setVisibility(0);
            this.G.setText(this.I.countdown_msg);
            SignActivityInfo signActivityInfo = this.I;
            d2(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (!this.c1) {
            SignActivityInfo signActivityInfo2 = this.I;
            d2(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis);
        }
    }

    @Override // com.baidu.tieba.es7
    public void W() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08e7, (ViewGroup) null);
                this.M.setContentView(contentView);
                GreyUtil.grey(this.M);
                contentView.setOnClickListener(new f(this));
                this.M.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b7));
                this.M.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070420));
                this.M.setBackgroundDrawable(new BitmapDrawable());
                this.M.setOutsideTouchable(true);
                this.M.setTouchInterceptor(new g(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091729), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f092289), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f092491), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            hb.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            boolean u2 = u2();
            this.x0 = u2;
            this.e1.f(u2);
            if (this.x0) {
                this.w.setVisibility(8);
                if (gr7.m(this.W)) {
                    this.y0.setVisibility(4);
                } else {
                    this.y0.setVisibility(0);
                }
                this.z0.setVisibility(0);
            } else {
                this.y0.setVisibility(8);
                this.z0.setVisibility(8);
                this.w.setVisibility(0);
                this.x.setOnClickListener(null);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.Z));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.a0));
            }
            this.e1.i(this.Z, this.a0);
            this.e1.d(this.Y, this.V);
            ArrayList<vv4> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.f1100T = UtilHelper.getFixedText(this.f1100T, 7);
            } else if (this.k0) {
                this.f1100T = UtilHelper.getFixedText(this.f1100T, 6);
            }
            String g0 = ed7.g0(this.f1100T);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(g0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(g0);
            }
            this.e1.j(this.u0, g0);
            f2();
            H();
            Z1(TbadkCoreApplication.getInst().getSkinType());
            g2();
            FrsViewData frsViewData = this.W;
            if (frsViewData.frsBannerHeaderData != null) {
                Y1(frsViewData);
            } else {
                a2(frsViewData);
            }
            C1();
        }
    }

    public final void g2() {
        FrsViewData frsViewData;
        View f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.a != null && (frsViewData = this.W) != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                List<LiveFuseForumData> list = this.W.liveFuseForumDataList;
                if (list.size() == 1 && list.get(0).type.intValue() == 7 && list.get(0).novel != null) {
                    HeaderComponentNoHeaderController headerComponentNoHeaderController = new HeaderComponentNoHeaderController(this.a, list.get(0));
                    this.x1 = headerComponentNoHeaderController;
                    f2 = headerComponentNoHeaderController.e();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    f2.setLayoutParams(layoutParams);
                    this.x1.h();
                } else {
                    this.n0 = new bl7(this.a, list, this.W.isFromCache);
                    if (this.W.getForum() != null) {
                        this.n0.i(this.W.getForum().getId(), this.W.getForum().getName());
                    }
                    f2 = this.n0.f();
                    this.n0.d();
                }
                this.F0.setVisibility(8);
                this.m0.setVisibility(0);
                this.m0.removeAllViews();
                this.m0.addView(f2);
                return;
            }
            this.m0.setVisibility(8);
        }
    }

    public final void H1(ada adaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, adaVar) == null) && adaVar != null && this.W != null) {
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (adaVar.p() != 1) {
                if (adaVar.p() == 2) {
                    i2 = 7;
                } else if (adaVar.p() == 3) {
                    i2 = 8;
                } else if (adaVar.p() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", adaVar.c());
            ForumData forum = this.W.getForum();
            if (forum != null) {
                statisticItem.param("fid", forum.getId());
                statisticItem.param("fname", forum.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
            }
            if (adaVar.p() == 1) {
                statisticItem.param("tid", adaVar.m());
                statisticItem.param("thread_type", adaVar.n());
            }
            if (StringUtils.isNull(adaVar.r())) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (YYLiveUtil.isYYLiveLink(adaVar.q())) {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            } else {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, "");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void a2(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048616, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        FrsGameRankInfoData frsGameRankInfoData = frsViewData.frsGameRankInfoData;
        if (frsGameRankInfoData == null) {
            this.G0.setVisibility(8);
            this.E.setVisibility(8);
            this.C0.setVisibility(this.e1.l(LogicField.ROUND_CORNER_STYLE));
            this.N.setUseStrokeColorInt(false);
            this.L0.setVisibility(8);
            this.K0.pauseAnimation();
            return;
        }
        this.G0.setVisibility(0);
        View view2 = this.E;
        if (this.y.getVisibility() == 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        z2(frsViewData, frsGameRankInfoData, "c15055");
        this.C0.setVisibility(8);
        int parseColor = ColorUtils.parseColor(frsGameRankInfoData.rankColor);
        if (ColorUtils.isColorInvalid(parseColor)) {
            this.N.setUseStrokeColorInt(false);
        } else {
            this.N.setStrokeColorInt(parseColor);
            this.N.setUseStrokeColorInt(true);
        }
        if (!this.K0.isAnimating() && !this.M0) {
            int i3 = frsGameRankInfoData.showType;
            if (i3 < 0) {
                this.K0.setRepeatCount(-1);
                this.K0.postPlayAnimation();
                this.M0 = true;
            } else if (i3 > 0) {
                this.K0.setRepeatCount(i3);
                this.K0.postPlayAnimation();
                this.M0 = true;
            } else {
                this.K0.setFrame(Cea708Decoder.COMMAND_DSW);
            }
        }
        this.H0.startLoad(frsGameRankInfoData.icon, 10, false);
        if (TextUtils.isEmpty(frsGameRankInfoData.rankIcon)) {
            this.L0.setVisibility(8);
        } else {
            this.L0.setVisibility(0);
            this.L0.startLoad(frsGameRankInfoData.rankIcon, 10, false);
        }
        this.I0.setText(frsGameRankInfoData.rankName + "#" + frsGameRankInfoData.rankScore);
        this.G0.setOnClickListener(new o(this, frsGameRankInfoData, frsViewData));
    }

    public final void I1(@NonNull String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(str);
        FrsViewData frsViewData = this.W;
        String str2 = "";
        if (frsViewData != null && frsViewData.getForum() != null) {
            str2 = this.W.getForum().getId();
        }
        statisticItem.param("fid", str2);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tieba.es7
    public void K(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.U0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.O0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.R0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.e1.h(onClickListener);
        }
    }

    public final void k2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            int dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.C0.getVisibility() != 0) {
                dimens -= BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.p1.getLayoutParams()).topMargin = i2 - dimens;
        }
    }

    @Override // com.baidu.tieba.es7
    public void L(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, forumData, frsViewData) != null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.t1 = true;
        if (gr7.m(this.W)) {
            c2();
        }
        this.W = frsViewData;
        this.f1100T = forumData.getName();
        this.U = forumData.getId();
        this.Z = forumData.getMember_num();
        this.a0 = forumData.getPost_num();
        forumData.getTag_color();
        this.u0 = forumData.getImage_url();
        this.V = forumData.getLevelName();
        this.Y = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.b0 = forumData.getSignData().miss_sign_num;
            this.e0 = forumData.getSignData().showGuideToChatRoom;
            this.f0 = forumData.getSignData().chatRoomGuideData;
        }
        forumData.getCurScore();
        forumData.getLevelupScore();
        this.P = forumData.getBadgeData();
        forumData.getAccelerateContent();
        this.k0 = forumData.isBrandForum;
        this.W = frsViewData;
        if (!StringUtils.isNull(this.U) && !StringUtils.isNull(this.f1100T)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.W;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.W.getHotUserRankData().hot_user != null && this.W.getHotUserRankData().hot_user.size() >= 3) {
            this.y.setHasHotRankList(true);
        } else {
            this.y.setHasHotRankList(false);
        }
        int l2 = this.e1.l(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.W;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.y.a()) {
            z = false;
        }
        if (l2 == 0 && z) {
            this.y.setVisibility(0);
            this.D0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.y;
            FrsViewData frsViewData4 = this.W;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.y.setVisibility(8);
            this.D0.setVisibility(8);
        }
        this.X = new ThreadData();
        l2();
        b2();
        if (this.W.getActivityHeadData() != null && this.W.getActivityHeadData().a() != null) {
            ArrayList<nw4> b2 = this.W.getActivityHeadData().b();
            nw4 nw4Var = null;
            if (!ListUtils.isEmpty(b2)) {
                nw4Var = b2.get(0);
            }
            this.N0 = on7.c(this.d, T1(nw4Var));
            if (this.x0 && this.W.getActivityHeadData().a().h) {
                this.N0.setVisibility(0);
            } else {
                this.N0.setVisibility(8);
            }
        }
        q2(forumData);
        if (frsViewData != null) {
            this.I = frsViewData.mSignActivityInfo;
            G1();
        }
        this.W = frsViewData;
        A2(frsViewData);
    }

    public final void P1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && this.w1 != null) {
            String t2 = t2();
            if (!z && !TextUtils.isEmpty(t2)) {
                this.w1.d(t2);
                if (this.f0 != null) {
                    TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 1).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.U).param("fname", this.f1100T).param("room_id", this.f0.a()));
                    return;
                }
                return;
            }
            this.w1.a();
        }
    }

    public final void Z1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048613, this, i2) == null) && (frsViewData = this.W) != null && (forum = frsViewData.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && (themeElement = themeColorInfo.day) != null && themeColorInfo.night != null && (themeElement2 = themeColorInfo.dark) != null) {
            if (i2 == 4) {
                themeElement = themeElement2;
            }
            this.f1.b(themeElement);
            this.e1.b(themeElement);
            if (!this.x0) {
                LinearGradientView N1 = N1();
                LinearGradientView linearGradientView = this.w;
                if (linearGradientView != null && N1 != null) {
                    ThemeElement themeElement3 = themeColorInfo.day;
                    String str = themeElement3.light_color;
                    String str2 = themeElement3.dark_color;
                    ThemeElement themeElement4 = themeColorInfo.night;
                    String str3 = themeElement4.light_color;
                    String str4 = themeElement4.dark_color;
                    ThemeElement themeElement5 = themeColorInfo.dark;
                    linearGradientView.setGradientColor(str, str2, str3, str4, themeElement5.light_color, themeElement5.dark_color);
                }
                TbImageView tbImageView = this.x;
                if (tbImageView != null) {
                    tbImageView.startLoad(themeElement.pattern_image, 10, false);
                }
            }
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.setThemeFontColor(ColorUtils.parseColor(themeElement.common_color));
            }
            if (this.B != null) {
                this.B.setUrlAndColor(forum.getTopIcon(), ColorUtils.parseColor(themeElement.common_color));
            }
        }
    }

    public final void e2(nv4 nv4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048623, this, nv4Var) != null) || nv4Var == null) {
            return;
        }
        if (!nv4Var.e()) {
            if (this.l1.getVisibility() != 8) {
                this.l1.setVisibility(8);
            }
            if (this.m1.getVisibility() != 8) {
                this.m1.setVisibility(8);
                if (this.m1.isAnimating()) {
                    this.m1.cancelAnimation();
                }
            }
        } else if (nv4Var.d() < nv4Var.b()) {
            this.l1.setText(R.string.surprise_in_drop_down);
            m2();
        } else if (nv4Var.d() < nv4Var.c()) {
            this.l1.setText(R.string.surprise_continue_drop_down);
            m2();
        } else {
            this.l1.setText(R.string.surprise_when_release_hand);
            this.m1.setVisibility(4);
            if (this.m1.isAnimating()) {
                this.m1.cancelAnimation();
            }
        }
    }

    public final void q2(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.Q0.setText(str);
                    this.P0.startLoad(forumData.getManagers().get(0).portrait, 12, false);
                    this.O0.setVisibility(0);
                } else {
                    this.O0.setVisibility(8);
                }
                if (this.R0.getVisibility() == 0) {
                    this.R0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.O0.getVisibility() == 0) {
                this.O0.setVisibility(8);
            }
            if (this.R0.getVisibility() == 8) {
                this.R0.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.es7
    public void d(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            this.e1.onChangeSkinType(i2);
            BDLayoutMode layoutMode = this.a.getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getLayoutMode().onModeChanged(this.d);
            this.a.getLayoutMode().onModeChanged(this.K);
            this.a.getLayoutMode().onModeChanged(this.m);
            SkinManager.setBackgroundResource(this.K, R.drawable.icon_frs_experience_number);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0806d8);
            EMManager.from(this.C0).setCardType(1).setCorner(R.string.J_X14).setBackGroundColor(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.D0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.E0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.F0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.r0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.m0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.Q0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.T0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            EMManager.from(this.l1).setTextColor(R.color.CAM_X0101).setTextSize(R.dimen.T_X09);
            EMManager.from(this.G).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
            EMManager.from(this.G0).setCardType(1).setCorner(R.string.J_X07).setBackGroundColor(R.color.black_alpha40);
            EMManager.from(this.I0).setTextStyle(R.string.F_X01).setTextColor(R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.J0, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
            FrsBannerHeaderView frsBannerHeaderView = this.v1;
            if (frsBannerHeaderView != null) {
                frsBannerHeaderView.g();
            }
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds1));
                this.N.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.N.setStrokeColorResId(R.color.CAM_X0201);
                this.N.setPlaceHolder(1);
                this.N.invalidate();
            }
            HeadImageView headImageView = this.P0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.O;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
            LinearGradientView linearGradientView = this.w;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i2);
            }
            FrsGroupChatSignGuideView frsGroupChatSignGuideView = this.w1;
            if (frsGroupChatSignGuideView != null) {
                frsGroupChatSignGuideView.c();
            }
            Iterator<TbImageView> it = this.v0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            a0();
            O(this.i0 ? 1 : 0);
            i2();
            Z1(i2);
            B1(U1(), V1());
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.B;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            CoverFlowView<FrsHeadBannerData> coverFlowView = this.A;
            if (coverFlowView != null) {
                coverFlowView.v();
            }
            HotRankEntryView hotRankEntryView = this.U0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            bl7 bl7Var = this.n0;
            if (bl7Var != null) {
                bl7Var.h();
            }
            HeaderComponentNoHeaderController headerComponentNoHeaderController = this.x1;
            if (headerComponentNoHeaderController != null) {
                headerComponentNoHeaderController.g();
            }
        }
    }

    public final int o2(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int W1 = W1();
            n2();
            int O1 = O1(z, z2);
            this.q1.setVisibility(0);
            this.r1.setVisibility(0);
            int dimens = BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds96);
            int i2 = O1 + W1 + dimens;
            this.x.setVisibility(8);
            this.g1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (W1 - BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.tbds282)) + dimens;
            k2(W1 + dimens);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void x2(FrsViewData frsViewData, nw4 nw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048647, this, frsViewData, nw4Var) == null) {
            this.h1.setVisibility(0);
            p2(null, -1);
            this.h1.startLoad(nw4Var.c(), 10, false);
            if (this.g1.getVisibility() != 0) {
                this.g1.setVisibility(0);
            }
            this.g1.setVideoPath(nw4Var.h());
            this.g1.setVolume(0.0f, 0.0f);
            this.g1.setVideoScalingMode(0);
            this.g1.J(true);
            this.g1.setLooping(false);
            this.g1.setVideoStatusChangeListener(new a(this, nw4Var, frsViewData));
            this.g1.getMediaProgressObserver().j(new b(this, nw4Var));
            F1();
            this.h1.setOnClickListener(new c(this, nw4Var, frsViewData));
            this.g1.setOnClickListener(new d(this, nw4Var, frsViewData));
            FrsFragment frsFragment = this.b;
            if (frsFragment != null) {
                vq7.e(frsViewData, 2, frsFragment.getUniqueId());
            }
        }
    }

    public final void p2(nw4 nw4Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048636, this, nw4Var, i2) == null) {
            if (i2 == -1) {
                b2 = vq7.c(this.W);
            } else {
                b2 = vq7.b(nw4Var, i2);
            }
            if (!StringUtils.isNull(b2)) {
                int parseColor = ColorUtils.parseColor(b2);
                this.r1.setGradientColors(0, parseColor);
                this.q1.setBackgroundColor(parseColor);
            }
        }
    }

    public final void s2(List<yh> list, ada adaVar) {
        FrsBountyTaskData frsBountyTaskData;
        ForumData forumData;
        ForumData forumData2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048640, this, list, adaVar) != null) || this.B == null) {
            return;
        }
        this.V0 = list;
        FrsViewData frsViewData = this.W;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.W.getVoiceRoomData().a().size() > 0) {
            this.F.setVisibility(0);
            this.F.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.W.getVoiceRoomData().a())) {
                if (this.W.getVoiceRoomData().a().size() > 5) {
                    this.F.setShowMore(true);
                } else {
                    this.F.setShowMore(false);
                }
            }
            this.F.onBindDataToView(this.W.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.F.setVisibility(8);
            }
        }
        ArrayList arrayList = new ArrayList();
        UserData userData = null;
        if (adaVar != null) {
            FrsViewData frsViewData2 = this.W;
            if (frsViewData2 != null) {
                forumData2 = frsViewData2.getForum();
            } else {
                forumData2 = null;
            }
            FrsHeadBannerData frsHeadBannerData = new FrsHeadBannerData();
            frsHeadBannerData.j(FrsHeadBannerData.BannerType.AD_PIC);
            frsHeadBannerData.h(forumData2);
            frsHeadBannerData.g(adaVar);
            FrsViewData frsViewData3 = this.W;
            if (frsViewData3 != null && !frsViewData3.isFromCache) {
                z = false;
            } else {
                z = true;
            }
            frsHeadBannerData.i(z);
            arrayList.add(frsHeadBannerData);
        }
        FrsViewData frsViewData4 = this.W;
        if (frsViewData4 != null) {
            frsBountyTaskData = frsViewData4.getBountyTaskData();
        } else {
            frsBountyTaskData = null;
        }
        if (frsBountyTaskData != null) {
            FrsHeadBannerData frsHeadBannerData2 = new FrsHeadBannerData();
            frsHeadBannerData2.j(FrsHeadBannerData.BannerType.FORUM_MOUNT);
            frsHeadBannerData2.f(frsBountyTaskData);
            arrayList.add(frsHeadBannerData2);
        }
        if (!ListUtils.isEmpty(arrayList)) {
            CoverFlowView<FrsHeadBannerData> J1 = J1();
            this.A = J1;
            J1.setData(arrayList);
            this.z.removeAllViews();
            this.z.setVisibility(0);
            this.z.addView(this.A);
        } else {
            this.z.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.F;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.F0.setVisibility(8);
        } else {
            ViewGroup viewGroup = this.m0;
            if (viewGroup != null && viewGroup.getVisibility() == 0) {
                this.F0.setVisibility(8);
            } else {
                this.F0.setVisibility(this.e1.l(LogicField.TOP_DIVIDER));
            }
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.L4()) {
            this.B.setVisibility(0);
            this.B.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData5 = this.W;
            if (frsViewData5 != null) {
                forumData = frsViewData5.getForum();
            } else {
                forumData = null;
            }
            FrsViewData frsViewData6 = this.W;
            if (frsViewData6 != null) {
                userData = frsViewData6.getUserData();
            }
            this.B.setForum(this.U, this.f1100T, forumData, userData, this.b.getFrom());
            if (list.size() > 0 && (list.get(0) instanceof jda)) {
                this.X0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof jda)) {
                this.X0 = 1;
            } else {
                this.X0 = -1;
            }
            this.B.setDatas(list, adaVar);
            if (this.w0 == null) {
                this.w0 = new p(this);
            }
            this.B.setStatListener(this.w0);
            return;
        }
        this.B.setVisibility(8);
    }

    public final boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            FrsViewData frsViewData = this.W;
            if (frsViewData == null) {
                return false;
            }
            nw4 nw4Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                nw4Var = new nw4();
                nw4Var.q("");
                nw4Var.p(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                nw4Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (nw4Var == null) {
                return false;
            }
            if (T1(nw4Var)) {
                x2(frsViewData, nw4Var);
            } else {
                v2(frsViewData, nw4Var);
            }
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(nw4Var.l(), 0));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.es7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            super.y();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            q();
            CoverFlowView<FrsHeadBannerData> coverFlowView = this.A;
            if (coverFlowView != null) {
                coverFlowView.w();
            }
            CountDownTimer countDownTimer = this.d1;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d1 = null;
            }
            this.K0.cancelAnimation();
            this.e1.onDestory();
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.t();
            }
            MessageManager.getInstance().unRegisterListener(this.y1);
            MessageManager.getInstance().unRegisterListener(this.A1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.D1);
        }
    }

    public final void y2(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048649, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.H = true;
            this.d1 = new h(this, j2, j3, str).start();
            if (this.Q != null && !k()) {
                this.Q.s(this.H, X1());
            }
        }
    }

    public final void z2(FrsViewData frsViewData, FrsGameRankInfoData frsGameRankInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048651, this, frsViewData, frsGameRankInfoData, str) == null) && frsGameRankInfoData != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.itemInfo != null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("fname", frsViewData.getForum().getName());
            statisticItem.param("obj_id", frsViewData.itemInfo.id.intValue());
            statisticItem.param("obj_name", frsViewData.itemInfo.name);
            statisticItem.param("obj_param1", frsGameRankInfoData.rankName);
            TiebaStatic.log(statisticItem);
        }
    }
}
