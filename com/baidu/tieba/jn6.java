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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.frs.servicearea.ServiceAreaView;
import com.baidu.tieba.frs.shrinkhead.LogicField;
import com.baidu.tieba.frs.vc.FrsTopView;
import com.baidu.tieba.frs.view.FrsHeaderVideoImageShadeView;
import com.baidu.tieba.frs.view.HotRankEntryView;
import com.baidu.tieba.frs.voiceroom.view.FrsVoiceRoomListLayout;
import com.baidu.tieba.lv4;
import com.baidu.tieba.mf8;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.AdapterLinearLayout;
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
import tbclient.SignActivityInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class jn6 extends ex6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A0;
    public CustomMessageListener A1;
    public View B0;
    public CustomMessageListener B1;
    public View C0;
    public CustomMessageListener C1;
    public boolean D0;
    public CustomMessageListener D1;
    public LinearLayout E0;
    public CustomMessageListener E1;
    public View F0;
    public View G0;
    public View H0;
    public View I0;
    public View J0;
    public TbImageView K0;
    public TextView L0;
    public ImageView M0;
    public TBLottieAnimationView N0;
    public TbImageView O0;
    public boolean P0;
    public TextView Q0;
    public final View R0;
    public final HeadImageView S0;
    public final TextView T0;
    public final View U0;
    public final ImageView V0;
    public final TextView W0;
    public HotRankEntryView X0;
    public List<xn> Y0;
    public x66 Z0;
    public int a1;
    public long b1;
    public ScheduledExecutorService c1;
    public boolean d1;
    public boolean e1;
    public boolean f1;
    public CountDownTimer g1;
    public boolean h1;
    @NonNull
    public final hu6 i1;
    @NonNull
    public final lu6 j1;
    public TbVideoView k1;
    public TbImageView l1;
    public View m1;
    public View n1;
    public TBLottieAnimationView o1;
    public TextView p1;
    public TBLottieAnimationView q1;
    public View r1;
    public View s1;
    public View t1;
    public RelativeLayout u0;
    public View u1;
    public TextView v0;
    public FrsHeaderVideoImageShadeView v1;
    public TextView w0;
    public boolean w1;
    public String x0;
    public boolean x1;
    public ArrayList<TbImageView> y0;
    public MessageRedDotView y1;
    public rl6 z0;
    public FrsViewData z1;

    @Override // com.baidu.tieba.ex6
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jn6 b;

        /* loaded from: classes5.dex */
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
                            jn6 jn6Var = this.a.b;
                            jn6Var.D1(jn6Var.I.activity_msg, this.a.b.I.countdown_time.intValue());
                        }
                    } else if (this.a.b.G.getVisibility() == 0) {
                        this.a.b.m1();
                    }
                }
            }
        }

        public i(jn6 jn6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jn6Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ah.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ jn6 c;

        public a(jn6 jn6Var, xs4 xs4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, xs4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jn6Var;
            this.a = xs4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.n1.getVisibility() == 0) {
                    this.c.k1.start();
                    return;
                }
                dw6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    bw6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ jn6 c;

        public b(jn6 jn6Var, xs4 xs4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, xs4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jn6Var;
            this.a = xs4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                dw6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    bw6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ jn6 c;

        public c(jn6 jn6Var, xs4 xs4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, xs4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jn6Var;
            this.a = xs4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null && !jn5.a(this.c.a.getPageActivity(), this.a.f()) && !TextUtils.isEmpty(this.a.e())) {
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
                    bw6.d(this.b, 1, this.c.b.getUniqueId());
                }
                dw6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.l(), 1));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(jn6 jn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) {
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements lv4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        public e(jn6 jn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn6Var;
        }

        @Override // com.baidu.tieba.lv4.e
        public void onClick(lv4 lv4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, lv4Var) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.a.getPageActivity(), this.a.h0, "exp_acce", 2);
                memberPayActivityConfig.setSceneId("4004001000");
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                lv4Var.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        public f(jn6 jn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                ch.d(this.a.O, this.a.a.getPageActivity());
                this.a.b.c = false;
                sp4.s(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0601), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        public g(jn6 jn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    ch.c(this.a.O);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ jn6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(jn6 jn6Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, Long.valueOf(j), Long.valueOf(j2), str};
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
            this.b = jn6Var;
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
            if (this.b.S != null && !this.b.i()) {
                this.b.S.s(this.b.H);
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

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(jn6 jn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, Integer.valueOf(i)};
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
            this.a = jn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof zr4)) {
                zr4 zr4Var = (zr4) customResponsedMessage.getData();
                this.a.E1(zr4Var);
                this.a.t1(zr4Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(jn6 jn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, Integer.valueOf(i)};
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
            this.a = jn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && mw6.m(this.a.z1)) {
                this.a.C1();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(jn6 jn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, Integer.valueOf(i)};
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
            this.a = jn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (mw6.m(this.a.z1) && this.a.k1.getVisibility() == 0) {
                        this.a.C1();
                    }
                    this.a.x1 = false;
                } else if (intValue == 2 && mw6.m(this.a.z1)) {
                    if (!this.a.x1) {
                        jn6 jn6Var = this.a;
                        jn6Var.H(jn6Var.z1.getForum(), this.a.z1);
                    }
                    this.a.x1 = false;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(jn6 jn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, Integer.valueOf(i)};
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
            this.a = jn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.w1 = true;
                if (intValue == 1) {
                    if (!FrsFragment.s2 && mw6.m(this.a.z1)) {
                        jn6 jn6Var = this.a;
                        jn6Var.H(jn6Var.z1.getForum(), this.a.z1);
                    }
                } else if (intValue == 2) {
                    if (mw6.m(this.a.z1)) {
                        jn6 jn6Var2 = this.a;
                        jn6Var2.H(jn6Var2.z1.getForum(), this.a.z1);
                    }
                } else if (intValue == 3) {
                    jn6 jn6Var3 = this.a;
                    jn6Var3.H(jn6Var3.z1.getForum(), this.a.z1);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(jn6 jn6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, Integer.valueOf(i)};
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
            this.a = jn6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            jn6 jn6Var = this.a;
            jn6Var.Z1(jn6Var.z1);
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRankInfoData a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ jn6 c;

        public o(jn6 jn6Var, FrsGameRankInfoData frsGameRankInfoData, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, frsGameRankInfoData, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jn6Var;
            this.a = frsGameRankInfoData;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null) {
                UrlManager.getInstance().dealOneLink(this.c.a, new String[]{this.a.rankLink});
                this.c.N0.pauseAnimation();
                this.c.N0.setFrame(Cea708Decoder.COMMAND_DSW);
                this.c.Y1(this.b, this.a, "c15056");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements rl6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jn6 a;

        public p(jn6 jn6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jn6Var;
        }

        @Override // com.baidu.tieba.rl6
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                lw6.d(this.a.b, this.a.z1, threadData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ jn6 c;

        public q(jn6 jn6Var, xs4 xs4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, xs4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jn6Var;
            this.a = xs4Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.l1.setVisibility(8);
                    this.c.n1.setVisibility(8);
                    this.c.u1();
                    this.c.Q1(this.a, 0);
                    bw6.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.C1();
                    bw6.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.C1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.V1();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements mf8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xs4 a;
        public final /* synthetic */ jn6 b;

        public r(jn6 jn6Var, xs4 xs4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jn6Var, xs4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jn6Var;
            this.a = xs4Var;
        }

        @Override // com.baidu.tieba.mf8.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.Q1(this.a, i2);
        }
    }

    public jn6(FrsFragment frsFragment, String str, String str2, int i2) {
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
        this.D0 = false;
        this.a1 = -1;
        this.b1 = 1000L;
        this.h1 = false;
        this.i1 = gu6.a();
        this.A1 = new j(this, 2921679);
        this.B1 = new k(this, 2921681);
        this.C1 = new l(this, 2921680);
        this.D1 = new m(this, 2921682);
        this.E1 = new n(this, 2921721);
        this.y0 = new ArrayList<>();
        this.h0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        yi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        yi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        yi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07024d);
        this.V = str;
        this.W = str2;
        View p1 = p1();
        this.d = p1;
        this.i1.c(frsFragment, p1);
        this.j1 = this.i1.e();
        this.u0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0906fd);
        this.v = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090db6);
        this.w = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090db9);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090db7);
        this.x = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.x.setDefaultBgResource(R.color.transparent);
        this.x.setDefaultResource(R.drawable.obfuscated_res_0x7f080f9f);
        this.B0 = this.d.findViewById(R.id.obfuscated_res_0x7f090dd4);
        this.k1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f0925f7);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0925f1);
        this.l1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.l1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f9f);
        this.l1.setDefaultResource(R.drawable.obfuscated_res_0x7f080f9f);
        this.l1.setPlaceHolder(2);
        this.m1 = this.d.findViewById(R.id.obfuscated_res_0x7f0925f6);
        this.n1 = this.d.findViewById(R.id.obfuscated_res_0x7f0925f5);
        this.o1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0925f4);
        this.C0 = this.d.findViewById(R.id.obfuscated_res_0x7f090c2b);
        this.U = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090bbc);
        gu6.d(this.B0, this.C0);
        this.r1 = gu6.b(this.d);
        this.s1 = this.d.findViewById(R.id.obfuscated_res_0x7f090db8);
        this.t1 = this.d.findViewById(R.id.obfuscated_res_0x7f0914a5);
        this.p1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0924eb);
        this.q1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0914f0);
        this.u1 = this.d.findViewById(R.id.obfuscated_res_0x7f0925f2);
        this.v1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f0925f0);
        this.E0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091306);
        int l2 = this.i1.l(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090dcf);
        this.F0 = findViewById;
        findViewById.setVisibility(l2);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f091f26);
        this.H0 = this.d.findViewById(R.id.obfuscated_res_0x7f09032f);
        this.y = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f091f27);
        this.z = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090b18);
        this.F = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0926d5);
        this.B = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090c54);
        this.I0 = this.d.findViewById(R.id.obfuscated_res_0x7f090c4b);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f090c4c);
        this.D = this.d.findViewById(R.id.obfuscated_res_0x7f091f2b);
        this.E = this.d.findViewById(R.id.obfuscated_res_0x7f091f2a);
        this.h = (List) this.i1.a(LogicField.LIKE_BTN);
        this.i = (List) this.i1.a(LogicField.SIGN_BTN);
        this.N = (ImageView) o1().a(LogicField.SPEED_ICON);
        this.v0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09158a);
        this.w0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091af7);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091380);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091378);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0914f7);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0914f6);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09158f);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091afd);
        this.n = (TextView) this.d.findViewById(R.id.forum_name);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090420);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b99);
        this.P = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.P.setPageId(this.b.getUniqueId());
        this.P.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f02ec));
        this.P.setStrokeWith(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.P.setShowOval(true);
        this.P.setPlaceHolder(1);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.d.findViewById(R.id.obfuscated_res_0x7f091c76);
        this.y1 = messageRedDotView;
        messageRedDotView.setThreeDotMode(2);
        this.y1.setEnterForumStyle(true);
        this.y1.setVisibility(8);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f091379);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d9d);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09179e);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090da7);
        this.u = this.d.findViewById(R.id.obfuscated_res_0x7f090da8);
        this.R0 = this.d.findViewById(R.id.obfuscated_res_0x7f090be6);
        this.T0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090be7);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090be8);
        this.S0 = headImageView;
        headImageView.setIsRound(true);
        this.S0.setDrawBorder(true);
        this.S0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.S0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.U0 = this.d.findViewById(R.id.obfuscated_res_0x7f090be5);
        this.V0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090be4);
        this.W0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090be3);
        WebPManager.setPureDrawable(this.V0, R.drawable.obfuscated_res_0x7f080817, R.color.CAM_X0101, null);
        this.K = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0354, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0322, (ViewGroup) null);
        this.X0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090b97);
        this.m.setVisibility(8);
        this.G = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f090737);
        this.o0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090dc2);
        this.J0 = this.d.findViewById(R.id.obfuscated_res_0x7f090cb0);
        TbImageView tbImageView3 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090caf);
        this.K0 = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.K0.setConrers(15);
        this.K0.setRadiusById(R.string.J_X05);
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb3);
        this.L0 = textView;
        textView.getPaint().setStrokeWidth(0.5f);
        this.L0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.M0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb1);
        this.N0 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090cb2);
        this.O0 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cae);
        this.N0.setImageAssetsFolder("lottie_frs_game_rank_guide");
        this.N0.setAnimation(R.raw.lottie_frs_game_rank_guide);
        this.N0.setRepeatMode(1);
        this.N0.setMinAndMaxFrame(57, Cea708Decoder.COMMAND_DSW);
        MessageManager.getInstance().registerListener(this.A1);
        MessageManager.getInstance().registerListener(this.B1);
        MessageManager.getInstance().registerListener(this.C1);
        MessageManager.getInstance().registerListener(this.D1);
        MessageManager.getInstance().registerListener(this.E1);
    }

    public void G1(lv4 lv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, lv4Var) == null) {
            lv4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f037c, new d(this));
        }
    }

    public void H1(lv4 lv4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, lv4Var) == null) {
            lv4Var.setPositiveButton(R.string.open_now, new e(this));
        }
    }

    @Override // com.baidu.tieba.ex6
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.i1.g(z);
        }
    }

    public final boolean v1(xs4 xs4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, xs4Var)) == null) {
            if (xs4Var == null || StringUtils.isNull(xs4Var.c()) || StringUtils.isNull(xs4Var.h())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ex6
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            super.x(z);
            qm6 qm6Var = this.A;
            if (qm6Var != null) {
                qm6Var.k(z);
            }
        }
    }

    public final void D1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048582, this, str, j2) == null) {
            this.H = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.c1 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new i(this, str), j2, TimeUnit.SECONDS);
        }
    }

    public final void A1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        FrsGameRankInfoData frsGameRankInfoData = frsViewData.frsGameRankInfoData;
        if (frsGameRankInfoData == null) {
            this.J0.setVisibility(8);
            this.E.setVisibility(8);
            this.F0.setVisibility(this.i1.l(LogicField.ROUND_CORNER_STYLE));
            this.P.setUseStrokeColorInt(false);
            this.O0.setVisibility(8);
            this.N0.pauseAnimation();
            return;
        }
        this.J0.setVisibility(0);
        View view2 = this.E;
        if (this.y.getVisibility() == 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        view2.setVisibility(i2);
        Y1(frsViewData, frsGameRankInfoData, "c15055");
        this.F0.setVisibility(8);
        int b2 = gm7.b(frsGameRankInfoData.rankColor);
        if (gm7.a(b2)) {
            this.P.setUseStrokeColorInt(false);
        } else {
            this.P.setStrokeColorInt(b2);
            this.P.setUseStrokeColorInt(true);
        }
        if (!this.N0.isAnimating() && !this.P0) {
            int i3 = frsGameRankInfoData.showType;
            if (i3 < 0) {
                this.N0.setRepeatCount(-1);
                this.N0.o();
                this.P0 = true;
            } else if (i3 > 0) {
                this.N0.setRepeatCount(i3);
                this.N0.o();
                this.P0 = true;
            } else {
                this.N0.setFrame(Cea708Decoder.COMMAND_DSW);
            }
        }
        this.K0.K(frsGameRankInfoData.icon, 10, false);
        if (TextUtils.isEmpty(frsGameRankInfoData.rankIcon)) {
            this.O0.setVisibility(8);
        } else {
            this.O0.setVisibility(0);
            this.O0.K(frsGameRankInfoData.rankIcon, 10, false);
        }
        this.L0.setText(frsGameRankInfoData.rankName + "#" + frsGameRankInfoData.rankScore);
        this.J0.setOnClickListener(new o(this, frsGameRankInfoData, frsViewData));
    }

    public final void n1(wq8 wq8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, wq8Var) == null) && wq8Var != null && this.z1 != null && !this.h1) {
            this.h1 = true;
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (wq8Var.getType() != 1) {
                if (wq8Var.getType() == 2) {
                    i2 = 7;
                } else if (wq8Var.getType() == 3) {
                    i2 = 8;
                } else if (wq8Var.getType() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", wq8Var.c());
            ForumData forum = this.z1.getForum();
            if (forum != null) {
                statisticItem.param("fid", forum.getId());
                statisticItem.param("fname", forum.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
            }
            if (wq8Var.getType() == 1) {
                statisticItem.param("tid", wq8Var.m());
                statisticItem.param("thread_type", wq8Var.n());
            }
            if (StringUtils.isNull(wq8Var.q())) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (YYLiveUtil.isYYLiveLink(wq8Var.p())) {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            } else {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, "");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    @Override // com.baidu.tieba.ex6
    public void B(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.l0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.l0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0a40);
                if (f2 >= 1.0f) {
                    i2 = this.b0;
                } else {
                    i2 = this.b0 + 1;
                }
                FrsViewData S0 = this.b.S0();
                if (S0 != null && S0.getForum() != null) {
                    S0.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ae8, Integer.valueOf(i2)));
            } else {
                this.i1.d(this.b0, this.X);
                this.j.setText(this.X);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0ae8, Integer.valueOf(this.b0)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, q1(this.b0)));
            if (this.l0) {
                if (f2 >= 1.0f) {
                    Y(this.k, this.n0, f2);
                } else {
                    W(this.k, this.n0, f2);
                }
            } else {
                Y(this.k, this.n0, f2);
            }
            this.n0 = f2;
        }
    }

    public final void j1(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (relativeLayout = this.v) != null && relativeLayout.getLayoutParams() != null) {
            if (this.X0.getVisibility() == 0) {
                g2 = yi.g(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = yi.g(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.X0.getLayoutParams()).topMargin = (yi.g(this.a.getPageActivity(), R.dimen.tbds226) + yi.u(this.a.getPageActivity())) - yi.g(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                g2 = yi.g(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.A0) {
                g2 -= yi.g(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.A0) {
                if (mw6.m(this.z1)) {
                    g2 = P1(z, z2);
                } else {
                    g2 = J1(z, z2);
                }
            }
            if (this.J0.getVisibility() == 0) {
                g2 += yi.g(this.a.getPageActivity(), R.dimen.tbds125);
            }
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            if (layoutParams.height != g2) {
                layoutParams.height = g2;
                this.v.setLayoutParams(layoutParams);
            }
        }
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean T1 = T1();
            this.A0 = T1;
            this.i1.f(T1);
            if (this.A0) {
                this.w.setVisibility(8);
                if (mw6.m(this.z1)) {
                    this.B0.setVisibility(4);
                } else {
                    this.B0.setVisibility(0);
                }
                this.C0.setVisibility(0);
            } else {
                this.B0.setVisibility(8);
                this.C0.setVisibility(8);
                this.w.setVisibility(0);
                this.x.setOnClickListener(null);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.c0));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.d0));
            }
            this.i1.i(this.c0, this.d0);
            this.i1.d(this.b0, this.X);
            ArrayList<hs4> arrayList = this.R;
            if (arrayList != null && arrayList.size() > 0) {
                this.V = UtilHelper.getFixedText(this.V, 7);
            } else if (this.m0) {
                this.V = UtilHelper.getFixedText(this.V, 6);
            }
            String d0 = ik6.d0(this.V);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(d0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(d0);
            }
            this.i1.j(this.x0, d0);
            F1();
            D();
            z1(TbadkCoreApplication.getInst().getSkinType());
            I1();
            A1(this.z1);
            k1();
        }
    }

    @Override // com.baidu.tieba.ex6
    public void T() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && this.a1 != -1 && (frsViewData = this.z1) != null && frsViewData.forumRule != null && frsViewData.getUserData() != null && this.B != null) {
            if (this.z1.getUserData().getIs_manager() == 1) {
                if (this.z1.forumRule.has_forum_rule.intValue() != 1 && this.z1.forumRule.audit_status.intValue() == 0) {
                    string = this.a.getString(R.string.frs_top_forum_rules_setting);
                    str = "key_forum_rule_first_show_frs_manager";
                } else {
                    return;
                }
            } else {
                string = this.a.getString(R.string.frs_top_forum_rules_setting_has_pass);
                str = "key_forum_rule_first_show_frs";
            }
            View view2 = null;
            if (this.B.getmTopViews() != null && this.B.getmTopViews().size() > 0 && (this.B.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
                AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.B.getmTopViews().get(0);
                if (this.a1 < adapterLinearLayout.getChildCount()) {
                    view2 = adapterLinearLayout.getChildAt(this.a1);
                }
            }
            if (this.Z0 == null && view2 != null) {
                x66 x66Var = new x66(this.a, view2);
                this.Z0 = x66Var;
                x66Var.L(R.drawable.bg_tip_blue_up_left);
                this.Z0.o(16);
                this.Z0.x(true);
                this.Z0.P(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
                this.Z0.Q(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
                this.Z0.M(true);
                this.Z0.n(4000);
                if (!this.Z0.i() && !this.b.y3()) {
                    this.Z0.S(string, str);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ex6
    public void V() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            PopupWindow popupWindow = this.O;
            if (popupWindow == null) {
                this.O = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0810, (ViewGroup) null);
                this.O.setContentView(contentView);
                GreyUtil.grey(this.O);
                contentView.setOnClickListener(new f(this));
                this.O.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070299));
                this.O.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070306));
                this.O.setBackgroundDrawable(new BitmapDrawable());
                this.O.setOutsideTouchable(true);
                this.O.setTouchInterceptor(new g(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091579), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091ff0), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0921c1), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.N.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.O;
            ch.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.N.getWidth() / 2), iArr[1] + this.N.getWidth());
            this.O.update();
        }
    }

    public final void m1() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || this.I == null) {
            return;
        }
        CountDownTimer countDownTimer = this.g1;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.g1.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        boolean z3 = true;
        if ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis < 0) {
            z = true;
        } else {
            z = false;
        }
        this.d1 = z;
        if (this.I.activity_time.intValue() - currentTimeMillis <= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.e1 = z2;
        if ((this.I.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis > 0) {
            z3 = false;
        }
        this.f1 = z3;
        boolean z4 = this.d1;
        if (z4) {
            this.G.setVisibility(8);
            return;
        }
        if (this.e1 && !z4) {
            X1(this.I.activity_msg, 1000 * ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis), this.b1);
        }
        if (!this.e1 && this.f1) {
            this.G.setVisibility(0);
            this.G.setText(this.I.countdown_msg);
            SignActivityInfo signActivityInfo = this.I;
            D1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (!this.f1) {
            SignActivityInfo signActivityInfo2 = this.I;
            D1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis);
        }
    }

    @Override // com.baidu.tieba.ex6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.B.i(this.a1);
        }
    }

    public final void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l1.setVisibility(0);
            Q1(null, -1);
            u1();
            TbVideoView tbVideoView = this.k1;
            if (tbVideoView != null) {
                tbVideoView.Q();
            }
            this.k1.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.ex6
    public void D() {
        FrsViewData frsViewData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b != null && (frsViewData = this.z1) != null) {
            List<xn> showTopThreadList = frsViewData.getShowTopThreadList();
            if (showTopThreadList.size() > 2) {
                z = true;
            } else {
                z = false;
            }
            this.D0 = z;
            S1(showTopThreadList, this.z1.getBusinessPromot());
        }
    }

    @Override // com.baidu.tieba.ex6
    public void E() {
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (vw6Var = this.S) != null) {
            vw6Var.q(this.e0);
        }
    }

    @Override // com.baidu.tieba.ex6
    public void F() {
        vw6 vw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (vw6Var = this.S) != null) {
            vw6Var.s(this.H);
        }
    }

    public void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.P.K(this.x0, 10, false);
        }
    }

    public void K1() {
        uw6 uw6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (uw6Var = this.T) != null) {
            uw6Var.n();
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.x0);
            this.a0.getMedias().add(mediaData);
        }
    }

    @Override // com.baidu.tieba.ex6
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.h0 != 0) {
                SkinManager.setImageResource(this.N, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.N, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    @Override // com.baidu.tieba.ex6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.i1.k(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.ex6
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            SignActivityInfo signActivityInfo = this.I;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex6
    public SignActivityInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.I;
        }
        return (SignActivityInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex6
    public void n() {
        x66 x66Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048622, this) == null) && (x66Var = this.Z0) != null) {
            x66Var.h();
            this.a1 = -1;
        }
    }

    @NonNull
    public hu6 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.i1;
        }
        return (hu6) invokeV.objValue;
    }

    public View p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0348, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex6
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.A0;
        }
        return invokeV.booleanValue;
    }

    public final LinearGradientView r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.G3() != null) {
                View D = this.b.G3().D();
                if (D instanceof LinearGradientView) {
                    return (LinearGradientView) D;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex6
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final void u1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048633, this) == null) && (tBLottieAnimationView = this.o1) != null) {
            tBLottieAnimationView.setVisibility(8);
            if (this.o1.isAnimating()) {
                this.o1.cancelAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.ex6
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.w();
            if (mw6.m(this.z1)) {
                C1();
            }
            qm6 qm6Var = this.A;
            if (qm6Var != null) {
                qm6Var.j();
            }
        }
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            FrsTopView frsTopView = this.B;
            if (frsTopView != null && frsTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null && serviceAreaView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ex6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            qm6 qm6Var = this.A;
            if (qm6Var != null) {
                qm6Var.l();
            }
            if (FrsFragment.s2 && mw6.m(this.z1)) {
                FrsFragment.s2 = false;
                H(this.z1.getForum(), this.z1);
            }
        }
    }

    public final int y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            int l2 = yi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.k1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    public final void E1(zr4 zr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zr4Var) != null) || zr4Var == null) {
            return;
        }
        if (!zr4Var.e()) {
            if (this.p1.getVisibility() != 8) {
                this.p1.setVisibility(8);
            }
            if (this.q1.getVisibility() != 8) {
                this.q1.setVisibility(8);
                if (this.q1.isAnimating()) {
                    this.q1.cancelAnimation();
                }
            }
        } else if (zr4Var.d() < zr4Var.b()) {
            this.p1.setText(R.string.surprise_in_drop_down);
            N1();
        } else if (zr4Var.d() < zr4Var.c()) {
            this.p1.setText(R.string.surprise_continue_drop_down);
            N1();
        } else {
            this.p1.setText(R.string.surprise_when_release_hand);
            this.q1.setVisibility(4);
            if (this.q1.isAnimating()) {
                this.q1.cancelAnimation();
            }
        }
    }

    public final void R1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.T0.setText(str);
                    this.S0.K(forumData.getManagers().get(0).portrait, 12, false);
                    this.R0.setVisibility(0);
                } else {
                    this.R0.setVisibility(8);
                }
                if (this.U0.getVisibility() == 0) {
                    this.U0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.R0.getVisibility() == 0) {
                this.R0.setVisibility(8);
            }
            if (this.U0.getVisibility() == 8) {
                this.U0.setVisibility(0);
            }
        }
    }

    public final void z1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048642, this, i2) == null) && (frsViewData = this.z1) != null && (forum = frsViewData.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && (themeElement = themeColorInfo.day) != null && (themeElement2 = themeColorInfo.night) != null && (themeElement3 = themeColorInfo.dark) != null) {
            if (i2 == 4) {
                themeElement = themeElement3;
            } else if (i2 == 1) {
                themeElement = themeElement2;
            }
            this.j1.b(themeElement);
            this.i1.b(themeElement);
            if (!this.A0) {
                LinearGradientView r1 = r1();
                LinearGradientView linearGradientView = this.w;
                if (linearGradientView != null && r1 != null) {
                    ThemeElement themeElement4 = themeColorInfo.day;
                    String str = themeElement4.light_color;
                    String str2 = themeElement4.dark_color;
                    ThemeElement themeElement5 = themeColorInfo.night;
                    String str3 = themeElement5.light_color;
                    String str4 = themeElement5.dark_color;
                    ThemeElement themeElement6 = themeColorInfo.dark;
                    linearGradientView.setGradientColor(str, str2, str3, str4, themeElement6.light_color, themeElement6.dark_color);
                }
                TbImageView tbImageView = this.x;
                if (tbImageView != null) {
                    tbImageView.K(themeElement.pattern_image, 10, false);
                }
            }
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.setThemeFontColor(gm7.b(themeElement.common_color));
            }
            if (this.B != null) {
                this.B.setUrlAndColor(forum.getTopIcon(), gm7.b(themeElement.common_color));
            }
        }
    }

    @Override // com.baidu.tieba.ex6
    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.P.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.X0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.R0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.U0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.i1.h(onClickListener);
        }
    }

    public final void L1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            int g2 = yi.g(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.F0.getVisibility() != 0) {
                g2 -= yi.g(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.t1.getLayoutParams()).topMargin = i2 - g2;
        }
    }

    @Override // com.baidu.tieba.ex6
    public void H(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048589, this, forumData, frsViewData) != null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.x1 = true;
        if (mw6.m(this.z1)) {
            C1();
        }
        this.V = forumData.getName();
        this.W = forumData.getId();
        this.c0 = forumData.getMember_num();
        this.d0 = forumData.getPost_num();
        forumData.getTag_color();
        this.x0 = forumData.getImage_url();
        this.X = forumData.getLevelName();
        this.b0 = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.e0 = forumData.getSignData().miss_sign_num;
        }
        this.f0 = forumData.getCurScore();
        this.g0 = forumData.getLevelupScore();
        this.R = forumData.getBadgeData();
        this.Y = forumData.getAccelerateContent();
        this.m0 = forumData.isBrandForum;
        this.z1 = frsViewData;
        if (!StringUtils.isNull(this.W) && !StringUtils.isNull(this.V)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.z1;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.z1.getHotUserRankData().hot_user != null && this.z1.getHotUserRankData().hot_user.size() >= 3) {
            this.y.setHasHotRankList(true);
        } else {
            this.y.setHasHotRankList(false);
        }
        int l2 = this.i1.l(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.z1;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.y.a()) {
            z = false;
        }
        if (l2 == 0 && z) {
            this.y.setVisibility(0);
            this.G0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.y;
            FrsViewData frsViewData4 = this.z1;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.y.setVisibility(8);
            this.G0.setVisibility(8);
        }
        this.a0 = new ThreadData();
        M1();
        B1();
        if (this.z1.getActivityHeadData() != null && this.z1.getActivityHeadData().a() != null) {
            ArrayList<xs4> b2 = this.z1.getActivityHeadData().b();
            xs4 xs4Var = null;
            if (!ListUtils.isEmpty(b2)) {
                xs4Var = b2.get(0);
            }
            this.Q0 = gu6.c(this.d, v1(xs4Var));
            if (this.A0 && this.z1.getActivityHeadData().a().h) {
                this.Q0.setVisibility(0);
            } else {
                this.Q0.setVisibility(8);
            }
        }
        R1(forumData);
        if (frsViewData != null) {
            this.I = frsViewData.mSignActivityInfo;
            m1();
        }
        this.z1 = frsViewData;
        Z1(frsViewData);
    }

    public final void S1(List<xn> list, wq8 wq8Var) {
        ForumData forumData;
        ForumData forumData2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048602, this, list, wq8Var) != null) || this.B == null) {
            return;
        }
        this.Y0 = list;
        FrsViewData frsViewData = this.z1;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.z1.getVoiceRoomData().a().size() > 0) {
            this.F.setVisibility(0);
            this.F.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.z1.getVoiceRoomData().a())) {
                if (this.z1.getVoiceRoomData().a().size() > 5) {
                    this.F.setShowMore(true);
                } else {
                    this.F.setShowMore(false);
                }
            }
            this.F.a(this.z1.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.F.setVisibility(8);
            }
        }
        UserData userData = null;
        if (wq8Var != null) {
            this.A = new qm6(this.a.getPageActivity());
            this.z.setVisibility(0);
            this.z.addView(this.A.f());
            FrsViewData frsViewData2 = this.z1;
            if (frsViewData2 != null) {
                forumData2 = frsViewData2.getForum();
            } else {
                forumData2 = null;
            }
            qm6 qm6Var = this.A;
            FrsViewData frsViewData3 = this.z1;
            if (frsViewData3 != null && !frsViewData3.isFromCache) {
                z = false;
            } else {
                z = true;
            }
            qm6Var.e(forumData2, wq8Var, z);
            n1(wq8Var);
        } else {
            this.z.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.F;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.I0.setVisibility(8);
        } else {
            this.I0.setVisibility(this.i1.l(LogicField.TOP_DIVIDER));
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.Y3()) {
            this.B.setVisibility(0);
            this.B.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.z1;
            if (frsViewData4 != null) {
                forumData = frsViewData4.getForum();
            } else {
                forumData = null;
            }
            FrsViewData frsViewData5 = this.z1;
            if (frsViewData5 != null) {
                userData = frsViewData5.getUserData();
            }
            this.B.setForum(this.W, this.V, forumData, userData, this.b.q3());
            if (list.size() > 0 && (list.get(0) instanceof fr8)) {
                this.a1 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof fr8)) {
                this.a1 = 1;
            } else {
                this.a1 = -1;
            }
            this.B.setDatas(list, wq8Var);
            if (this.z0 == null) {
                this.z0 = new p(this);
            }
            this.B.setStatListener(this.z0);
            return;
        }
        this.B.setVisibility(8);
    }

    public final void I1() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.a != null && (frsViewData = this.z1) != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                this.p0 = new nr6(this.a, this.z1.liveFuseForumDataList);
                if (this.z1.getForum() != null) {
                    this.p0.i(this.z1.getForum().getId(), this.z1.getForum().getName());
                }
                View f2 = this.p0.f();
                this.I0.setVisibility(8);
                this.o0.setVisibility(0);
                this.o0.removeAllViews();
                this.o0.addView(f2);
                this.p0.d();
                return;
            }
            this.o0.setVisibility(8);
        }
    }

    public final boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            FrsViewData frsViewData = this.z1;
            if (frsViewData == null) {
                return false;
            }
            xs4 xs4Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                xs4Var = new xs4();
                xs4Var.q("");
                xs4Var.p(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                xs4Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (xs4Var == null) {
                return false;
            }
            if (v1(xs4Var)) {
                W1(frsViewData, xs4Var);
            } else {
                U1(frsViewData, xs4Var);
            }
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(xs4Var.l(), 0));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ex6
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.u();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.O;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.O.dismiss();
            }
            n();
            qm6 qm6Var = this.A;
            if (qm6Var != null) {
                qm6Var.i();
            }
            CountDownTimer countDownTimer = this.g1;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.g1 = null;
            }
            this.N0.cancelAnimation();
            this.i1.onDestory();
            MessageManager.getInstance().unRegisterListener(this.A1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.E1);
        }
    }

    public final int J1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int g2 = yi.g(this.a.getPageActivity(), R.dimen.tbds782);
            int s1 = s1(z, z2);
            L1(g2);
            int i2 = g2 + s1;
            this.x.setVisibility(0);
            this.k1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.x.getLayoutParams()).bottomMargin = s1;
            ((RelativeLayout.LayoutParams) this.B0.getLayoutParams()).bottomMargin = s1;
            if (s1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = yi.g(this.a.getPageActivity(), R.dimen.tbds782) - yi.g(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = yi.g(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void U1(FrsViewData frsViewData, xs4 xs4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, frsViewData, xs4Var) == null) && this.x != null && xs4Var != null) {
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                StatisticItem statisticItem = new StatisticItem("c13326");
                statisticItem.param("fid", frsViewData.getForum().getId());
                statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                TiebaStatic.log(statisticItem);
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                bw6.e(frsViewData, 1, this.b.getUniqueId());
            }
            this.x.K(xs4Var.d(), 10, false);
            this.x.setOnClickListener(new c(this, xs4Var, frsViewData));
        }
    }

    public final void W1(FrsViewData frsViewData, xs4 xs4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, frsViewData, xs4Var) == null) {
            this.l1.setVisibility(0);
            Q1(null, -1);
            this.l1.K(xs4Var.c(), 10, false);
            if (this.k1.getVisibility() != 0) {
                this.k1.setVisibility(0);
            }
            this.k1.setVideoPath(xs4Var.h());
            this.k1.setVolume(0.0f, 0.0f);
            this.k1.setVideoScalingMode(0);
            this.k1.I(true);
            this.k1.setLooping(false);
            this.k1.setVideoStatusChangeListener(new q(this, xs4Var, frsViewData));
            this.k1.getMediaProgressObserver().j(new r(this, xs4Var));
            if (bw6.f()) {
                this.n1.setVisibility(8);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && !this.z1.isFromCache && (this.w1 || (!frsFragment.V3() && !this.b.U3() && !this.b.z3()))) {
                    this.k1.start();
                }
            } else {
                this.n1.setVisibility(0);
            }
            this.l1.setOnClickListener(new a(this, xs4Var, frsViewData));
            this.k1.setOnClickListener(new b(this, xs4Var, frsViewData));
            FrsFragment frsFragment2 = this.b;
            if (frsFragment2 != null) {
                bw6.e(frsViewData, 2, frsFragment2.getUniqueId());
            }
        }
    }

    public final int s1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<xn> list;
        List<sr8> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                rr8 rr8Var = this.z1.serviceAreaData;
                if (rr8Var != null && (list2 = rr8Var.b) != null && list2.size() == 1) {
                    i2 = 0 + yi.g(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + yi.g(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.Y0) != null) {
                i2 += Math.min(list.size(), 2) * yi.g(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.z.getVisibility() == 0) {
                i2 += yi.g(this.a.getPageActivity(), R.dimen.tbds231);
            }
            if (z2 || z || this.z.getVisibility() == 0) {
                return i2 + yi.g(this.a.getPageActivity(), R.dimen.tbds45);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            TextView textView = this.p1;
            if (textView != null && textView.getVisibility() == 8) {
                this.p1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.q1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.q1.getVisibility() == 4) {
                    this.q1.setVisibility(0);
                    if (this.q1.isAnimating()) {
                        this.q1.cancelAnimation();
                    }
                    this.q1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.q1.setRepeatCount(-1);
                    this.q1.playAnimation();
                }
            }
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int l2 = yi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.l1.setLayoutParams(layoutParams);
            this.l1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m1.getLayoutParams();
            layoutParams2.width = l2;
            layoutParams2.height = i2;
            this.m1.setLayoutParams(layoutParams2);
        }
    }

    public final void V1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (tBLottieAnimationView = this.o1) != null) {
            if (tBLottieAnimationView.getVisibility() == 8 || this.o1.getVisibility() == 4) {
                this.o1.setVisibility(0);
                if (this.o1.isAnimating()) {
                    this.o1.cancelAnimation();
                }
                this.o1.setAnimation(R.raw.lotti_video_loading);
                this.o1.setRepeatCount(-1);
                this.o1.playAnimation();
            }
        }
    }

    public final void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            boolean w1 = w1();
            boolean x1 = x1();
            if (!TextUtils.isEmpty(this.V)) {
                ov6 c2 = nv6.d().c(this.V);
                if (c2 == null) {
                    c2 = new ov6(this.D0, w1);
                } else {
                    c2.d(this.D0);
                    c2.e(w1);
                }
                nv6.d().e(this.V, c2);
            }
            l1(w1, x1);
            j1(w1, x1);
        }
    }

    public final int P1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int y1 = y1();
            O1();
            int s1 = s1(z, z2);
            this.u1.setVisibility(0);
            this.v1.setVisibility(0);
            int g2 = yi.g(this.a.getPageActivity(), R.dimen.tbds96);
            int i2 = s1 + y1 + g2;
            this.x.setVisibility(8);
            this.k1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (y1 - yi.g(this.a.getPageActivity(), R.dimen.tbds282)) + g2;
            L1(y1 + g2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void l1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.b.G3() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E0.getLayoutParams();
        if (!z && !z2) {
            this.E0.setVisibility(0);
            this.G0.setVisibility(8);
            this.H0.setVisibility(this.i1.l(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = yi.g(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.E0.setVisibility(0);
            this.G0.setVisibility(this.i1.l(LogicField.SERVICE_AREA));
            layoutParams.topMargin = yi.g(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.G3().t(z, z2);
    }

    public final void Q1(xs4 xs4Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, xs4Var, i2) == null) {
            if (i2 == -1) {
                b2 = bw6.c(this.z1);
            } else {
                b2 = bw6.b(xs4Var, i2);
            }
            if (!StringUtils.isNull(b2)) {
                int b3 = gm7.b(b2);
                this.v1.setGradientColors(0, b3);
                this.u1.setBackgroundColor(b3);
            }
        }
    }

    @Override // com.baidu.tieba.ex6
    @SuppressLint({"ResourceAsColor"})
    public void S(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, view2, z) == null) {
            if (this.h0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) != null && !z) {
                    View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0689, (ViewGroup) null);
                    TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09076f);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091387);
                    TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091ff8);
                    SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090999), R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                    SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
                    lv4 lv4Var = new lv4(this.a.getPageActivity());
                    lv4Var.setContentView(inflate);
                    I(textView, textView2);
                    if (!TextUtils.isEmpty(this.Y) && !TextUtils.isEmpty(this.Y.trim())) {
                        textView3.setVisibility(0);
                        textView3.setText(this.Y);
                    } else {
                        textView3.setVisibility(8);
                    }
                    lv4Var.setButtonTextColor(R.color.CAM_X0305);
                    G1(lv4Var);
                    H1(lv4Var);
                    lv4Var.create(this.a);
                    lv4Var.show();
                    return;
                }
                return;
            }
            this.c.removeCallbacks(this.r0);
            if (this.J == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.J = popupWindow;
                popupWindow.setContentView(this.K);
                GreyUtil.grey(this.J);
                this.J.setBackgroundDrawable(new BitmapDrawable());
                this.J.setOutsideTouchable(true);
                this.J.setFocusable(true);
                this.J.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027d));
                this.J.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a));
            }
            this.L = (TextView) this.K.findViewById(R.id.obfuscated_res_0x7f09076e);
            this.M = (TextView) this.K.findViewById(R.id.obfuscated_res_0x7f091386);
            SkinManager.setBackgroundResource(this.K.findViewById(R.id.obfuscated_res_0x7f090996), R.drawable.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.K.findViewById(R.id.obfuscated_res_0x7f090995), R.color.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.L, R.color.common_color_10047, 1);
            SkinManager.setViewTextColor(this.M, R.color.CAM_X0111, 1);
            I(this.L, this.M);
            if (this.J.isShowing()) {
                ch.d(this.J, this.a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] - this.J.getHeight() <= 50) {
                ch.d(this.J, this.a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.J;
            ch.m(popupWindow2, this.d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.J.update();
            this.c.postDelayed(this.r0, 2000L);
        }
    }

    public final void X1(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.H = true;
            this.g1 = new h(this, j2, j3, str).start();
            if (this.S != null && !i()) {
                this.S.s(this.H);
            }
        }
    }

    public final void Y1(FrsViewData frsViewData, FrsGameRankInfoData frsGameRankInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048611, this, frsViewData, frsGameRankInfoData, str) == null) && frsGameRankInfoData != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.itemInfo != null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("fname", frsViewData.getForum().getName());
            statisticItem.param("obj_id", frsViewData.itemInfo.id.intValue());
            statisticItem.param("obj_name", frsViewData.itemInfo.name);
            statisticItem.param("obj_param1", frsGameRankInfoData.rankName);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Z1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, frsViewData) == null) {
            if (frsViewData != null && frsViewData.getUserData() != null) {
                if (frsViewData.getUserData().getIs_manager() == 1 && frsViewData.getBaWuNoticeNum() > 0) {
                    this.y1.setVisibility(0);
                    this.y1.f(frsViewData.getBaWuNoticeNum());
                    return;
                }
                this.y1.setVisibility(8);
                return;
            }
            this.y1.setVisibility(8);
        }
    }

    public final int[] q1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
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

    public final void t1(zr4 zr4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, zr4Var) == null) && zr4Var != null && zr4Var.b() != 0.0f) {
            float d2 = zr4Var.d() / ((zr4Var.b() * 40.0f) / 70.0f);
            float d3 = zr4Var.d() / zr4Var.b();
            this.p1.setAlpha(d2);
            this.q1.setAlpha(d2);
            this.r1.setAlpha(1.0f - d2);
            float f2 = 1.0f - d3;
            this.s1.setAlpha(f2);
            this.m1.setAlpha(f2);
        }
    }

    @Override // com.baidu.tieba.ex6
    public void c(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.i1.onChangeSkinType(i2);
            tq4 layoutMode = this.a.getLayoutMode();
            if (i2 == 1) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.d);
            this.a.getLayoutMode().k(this.K);
            this.a.getLayoutMode().k(this.m);
            SkinManager.setBackgroundResource(this.K, R.drawable.icon_frs_experience_number);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f08059b);
            rw4 d2 = rw4.d(this.F0);
            d2.m(1);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.G0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.H0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.C, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.I0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.u0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.o0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.v0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.w0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.T0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.W0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            rw4 d3 = rw4.d(this.p1);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X09);
            rw4 d4 = rw4.d(this.G);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0101);
            rw4 d5 = rw4.d(this.J0);
            d5.m(1);
            d5.n(R.string.J_X07);
            d5.f(R.color.black_alpha40);
            rw4 d6 = rw4.d(this.L0);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.M0, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
            BarImageView barImageView = this.P;
            if (barImageView != null) {
                barImageView.setBorderWidth(yi.g(this.a.getPageActivity(), R.dimen.tbds1));
                this.P.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.P.setStrokeColorResId(R.color.CAM_X0201);
                this.P.setPlaceHolder(1);
                this.P.invalidate();
            }
            HeadImageView headImageView = this.S0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.Q;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
            LinearGradientView linearGradientView = this.w;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.U;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i2);
            }
            Iterator<TbImageView> it = this.y0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            Z();
            L(this.k0 ? 1 : 0);
            K1();
            z1(i2);
            j1(w1(), x1());
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.B;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            qm6 qm6Var = this.A;
            if (qm6Var != null) {
                qm6Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.X0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            nr6 nr6Var = this.p0;
            if (nr6Var != null) {
                nr6Var.h();
            }
        }
    }
}
