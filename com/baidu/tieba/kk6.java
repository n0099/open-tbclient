package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
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
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tieba.na8;
import com.baidu.tieba.nu4;
import com.baidu.tieba.play.OnStatusChangedListener;
import com.baidu.tieba.play.TbVideoView;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.view.AdapterLinearLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public class kk6 extends fu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View A0;
    public boolean B0;
    public LinearLayout C0;
    public View D0;
    public View E0;
    public View F0;
    public View G0;
    public TextView H0;
    public final View I0;
    public final HeadImageView J0;
    public final TextView K0;
    public final View L0;
    public final ImageView M0;
    public final TextView N0;
    public HotRankEntryView O0;
    public List<Cdo> P0;
    public x36 Q0;
    public int R0;
    public long S0;
    public ScheduledExecutorService T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;
    public CountDownTimer X0;
    public boolean Y0;
    @NonNull
    public final kr6 Z0;
    @NonNull
    public final or6 a1;
    public TbVideoView b1;
    public TbImageView c1;
    public View d1;
    public View e1;
    public TBLottieAnimationView f1;
    public TextView g1;
    public TBLottieAnimationView h1;
    public View i1;
    public View j1;
    public View k1;
    public View l1;
    public FrsHeaderVideoImageShadeView m1;
    public boolean n1;
    public boolean o1;
    public MessageRedDotView p1;
    public FrsViewData q1;
    public CustomMessageListener r1;
    public RelativeLayout s0;
    public CustomMessageListener s1;
    public TextView t0;
    public CustomMessageListener t1;
    public TextView u0;
    public CustomMessageListener u1;
    public String v0;
    public CustomMessageListener v1;
    public ArrayList<TbImageView> w0;
    public si6 x0;
    public boolean y0;
    public View z0;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kk6 c;

        public a(kk6 kk6Var, as4 as4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, as4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kk6Var;
            this.a = as4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                gt6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    et6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kk6 c;

        public b(kk6 kk6Var, as4 as4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, as4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kk6Var;
            this.a = as4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.c.a == null || yk5.a(this.c.a.getPageActivity(), this.a.f()) || TextUtils.isEmpty(this.a.e())) {
                return;
            }
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
                et6.d(this.b, 1, this.c.b.getUniqueId());
            }
            gt6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.l(), 1));
        }
    }

    /* loaded from: classes4.dex */
    public class c implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(kk6 kk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        public d(kk6 kk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk6Var;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.a.a.getPageActivity(), this.a.f0, "exp_acce", 2);
            memberPayActivityConfig.setSceneId("4004001000");
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_FRS, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            nu4Var.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        public e(kk6 kk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.a.getPageActivity() == null) {
                return;
            }
            ih.d(this.a.M, this.a.a.getPageActivity());
            this.a.b.c = false;
            yo4.s(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f05ed), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        public f(kk6 kk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk6Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    ih.c(this.a.M);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class g extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kk6 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(kk6 kk6Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, Long.valueOf(j), Long.valueOf(j2), str};
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
            this.b = kk6Var;
            this.a = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.F = false;
                if (this.b.E != null) {
                    this.b.E.setVisibility(8);
                }
                if (this.b.Q == null || this.b.i()) {
                    return;
                }
                this.b.Q.s(this.b.F);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || this.b.E == null) {
                return;
            }
            this.b.E.setVisibility(0);
            EMTextView eMTextView = this.b.E;
            eMTextView.setText(this.a + (j / 1000) + "s");
        }
    }

    /* loaded from: classes4.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ kk6 b;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public a(h hVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b.E == null) {
                    return;
                }
                if (this.a.b.E.getVisibility() == 8) {
                    this.a.b.E.setVisibility(0);
                    this.a.b.E.setText(this.a.a);
                    if (this.a.b.G != null) {
                        kk6 kk6Var = this.a.b;
                        kk6Var.y1(kk6Var.G.activity_msg, this.a.b.G.countdown_time.intValue());
                    }
                } else if (this.a.b.E.getVisibility() == 0) {
                    this.a.b.i1();
                }
            }
        }

        public h(kk6 kk6Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kk6Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gh.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(kk6 kk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, Integer.valueOf(i)};
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
            this.a = kk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cr4)) {
                cr4 cr4Var = (cr4) customResponsedMessage.getData();
                this.a.z1(cr4Var);
                this.a.p1(cr4Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(kk6 kk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, Integer.valueOf(i)};
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
            this.a = kk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && nt6.m(this.a.q1)) {
                this.a.x1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(kk6 kk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, Integer.valueOf(i)};
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
            this.a = kk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (nt6.m(this.a.q1) && this.a.b1.getVisibility() == 0) {
                        this.a.x1();
                    }
                    this.a.o1 = false;
                } else if (intValue == 2 && nt6.m(this.a.q1)) {
                    if (!this.a.o1) {
                        kk6 kk6Var = this.a;
                        kk6Var.H(kk6Var.q1.getForum(), this.a.q1);
                    }
                    this.a.o1 = false;
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(kk6 kk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, Integer.valueOf(i)};
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
            this.a = kk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.n1 = true;
                if (intValue == 1) {
                    if (FrsFragment.p2 || !nt6.m(this.a.q1)) {
                        return;
                    }
                    kk6 kk6Var = this.a;
                    kk6Var.H(kk6Var.q1.getForum(), this.a.q1);
                } else if (intValue == 2) {
                    if (nt6.m(this.a.q1)) {
                        kk6 kk6Var2 = this.a;
                        kk6Var2.H(kk6Var2.q1.getForum(), this.a.q1);
                    }
                } else if (intValue == 3) {
                    kk6 kk6Var3 = this.a;
                    kk6Var3.H(kk6Var3.q1.getForum(), this.a.q1);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(kk6 kk6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, Integer.valueOf(i)};
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
            this.a = kk6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            kk6 kk6Var = this.a;
            kk6Var.T1(kk6Var.q1);
        }
    }

    /* loaded from: classes4.dex */
    public class n implements si6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kk6 a;

        public n(kk6 kk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kk6Var;
        }

        @Override // com.baidu.tieba.si6
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                mt6.d(this.a.b, this.a.q1, threadData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class o implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kk6 c;

        public o(kk6 kk6Var, as4 as4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, as4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kk6Var;
            this.a = as4Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.c1.setVisibility(8);
                    this.c.e1.setVisibility(8);
                    this.c.q1();
                    this.c.L1(this.a, 0);
                    et6.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.x1();
                    et6.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.x1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.Q1();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class p implements na8.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as4 a;
        public final /* synthetic */ kk6 b;

        public p(kk6 kk6Var, as4 as4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, as4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kk6Var;
            this.a = as4Var;
        }

        @Override // com.baidu.tieba.na8.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.b.L1(this.a, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as4 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ kk6 c;

        public q(kk6 kk6Var, as4 as4Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kk6Var, as4Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kk6Var;
            this.a = as4Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.e1.getVisibility() == 0) {
                    this.c.b1.start();
                    return;
                }
                gt6.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    et6.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    public kk6(FrsFragment frsFragment, String str, String str2, int i2) {
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
        this.B0 = false;
        this.R0 = -1;
        this.S0 = 1000L;
        this.Y0 = false;
        this.Z0 = jr6.a();
        this.r1 = new i(this, 2921679);
        this.s1 = new j(this, 2921681);
        this.t1 = new k(this, 2921680);
        this.u1 = new l(this, 2921682);
        this.v1 = new m(this, 2921721);
        this.w0 = new ArrayList<>();
        this.f0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        ej.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        ej.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        ej.f(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07024d);
        this.T = str;
        this.U = str2;
        View l1 = l1();
        this.d = l1;
        this.Z0.c(frsFragment, l1);
        this.a1 = this.Z0.e();
        this.s0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0906d3);
        this.u = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d38);
        this.v = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090d3b);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090d39);
        this.w = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.w.setDefaultBgResource(R.color.transparent);
        this.w.setDefaultResource(R.drawable.obfuscated_res_0x7f080f39);
        this.z0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d56);
        this.b1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f092534);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09252e);
        this.c1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.c1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f080f39);
        this.c1.setDefaultResource(R.drawable.obfuscated_res_0x7f080f39);
        this.c1.setPlaceHolder(2);
        this.d1 = this.d.findViewById(R.id.obfuscated_res_0x7f092533);
        this.e1 = this.d.findViewById(R.id.obfuscated_res_0x7f092532);
        this.f1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f092531);
        this.A0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bf2);
        this.S = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090b83);
        jr6.d(this.z0, this.A0);
        this.i1 = jr6.b(this.d);
        this.j1 = this.d.findViewById(R.id.obfuscated_res_0x7f090d3a);
        this.k1 = this.d.findViewById(R.id.obfuscated_res_0x7f09140d);
        this.g1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092429);
        this.h1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f091457);
        this.l1 = this.d.findViewById(R.id.obfuscated_res_0x7f09252f);
        this.m1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f09252d);
        this.C0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091273);
        int l2 = this.Z0.l(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090d51);
        this.D0 = findViewById;
        findViewById.setVisibility(l2);
        this.E0 = this.d.findViewById(R.id.obfuscated_res_0x7f091e66);
        this.F0 = this.d.findViewById(R.id.obfuscated_res_0x7f090320);
        this.x = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f091e67);
        this.y = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090adf);
        this.D = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f092612);
        this.A = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090c1b);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f090c12);
        this.B = this.d.findViewById(R.id.obfuscated_res_0x7f090c13);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f091e6a);
        this.h = (List) this.Z0.a(LogicField.LIKE_BTN);
        this.i = (List) this.Z0.a(LogicField.SIGN_BTN);
        this.L = (ImageView) k1().a(LogicField.SPEED_ICON);
        this.t0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0914f0);
        this.u0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091a42);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0912ea);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0912e2);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09145e);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09145d);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0914f5);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091a48);
        this.n = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090a8e);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090409);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090b60);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f02e6));
        this.N.setStrokeWith(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.d.findViewById(R.id.obfuscated_res_0x7f091bbd);
        this.p1 = messageRedDotView;
        messageRedDotView.setThreeDotMode(2);
        this.p1.setEnterForumStyle(true);
        this.p1.setVisibility(8);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f0912e3);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d21);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0916fd);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090d2a);
        this.I0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bad);
        this.K0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090bae);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090baf);
        this.J0 = headImageView;
        headImageView.setIsRound(true);
        this.J0.setDrawBorder(true);
        this.J0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.J0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.L0 = this.d.findViewById(R.id.obfuscated_res_0x7f090bac);
        this.M0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090bab);
        this.N0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090baa);
        WebPManager.setPureDrawable(this.M0, R.drawable.obfuscated_res_0x7f0807ea, R.color.CAM_X0101, null);
        this.I = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d034c, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d031a, (ViewGroup) null);
        this.O0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090b5e);
        this.m.setVisibility(8);
        new ys6(this.a);
        this.E = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f090707);
        this.m0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090d44);
        MessageManager.getInstance().registerListener(this.r1);
        MessageManager.getInstance().registerListener(this.s1);
        MessageManager.getInstance().registerListener(this.t1);
        MessageManager.getInstance().registerListener(this.u1);
        MessageManager.getInstance().registerListener(this.v1);
    }

    public void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.N.K(this.v0, 10, false);
        }
    }

    @Override // com.baidu.tieba.fu6
    public void B(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.j0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.j0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f09ef);
                if (f2 >= 1.0f) {
                    i2 = this.Z;
                } else {
                    i2 = this.Z + 1;
                }
                FrsViewData O0 = this.b.O0();
                if (O0 != null && O0.getForum() != null) {
                    O0.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a96, Integer.valueOf(i2)));
            } else {
                this.Z0.d(this.Z, this.V);
                this.j.setText(this.V);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0a96, Integer.valueOf(this.Z)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, m1(this.Z)));
            if (!this.j0) {
                Y(this.k, this.l0, f2);
            } else if (f2 >= 1.0f) {
                Y(this.k, this.l0, f2);
            } else {
                W(this.k, this.l0, f2);
            }
            this.l0 = f2;
        }
    }

    public void B1(nu4 nu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nu4Var) == null) {
            nu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new c(this));
        }
    }

    @Override // com.baidu.tieba.fu6
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.A.i(this.R0);
        }
    }

    public void C1(nu4 nu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, nu4Var) == null) {
            nu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0d13, new d(this));
        }
    }

    @Override // com.baidu.tieba.fu6
    public void D() {
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.b == null || (frsViewData = this.q1) == null) {
            return;
        }
        List<Cdo> showTopThreadList = frsViewData.getShowTopThreadList();
        this.B0 = showTopThreadList.size() > 2;
        N1(showTopThreadList, this.q1.getBusinessPromot());
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            FrsViewData frsViewData = this.q1;
            if (frsViewData != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                this.n0 = new po6(this.a);
                if (this.q1.getForum() != null) {
                    this.n0.j(this.q1.getForum().getId(), this.q1.getForum().getName());
                }
                this.n0.e(this.q1.liveFuseForumDataList);
                View g2 = this.n0.g();
                if (g2 != null) {
                    this.m0.setVisibility(0);
                    this.m0.removeAllViews();
                    this.m0.addView(g2);
                    this.n0.d();
                    this.G0.setVisibility(8);
                    return;
                }
                this.m0.setVisibility(8);
                return;
            }
            this.m0.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.fu6
    public void E() {
        wt6 wt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (wt6Var = this.Q) == null) {
            return;
        }
        wt6Var.q(this.c0);
    }

    public final int E1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int f2 = ej.f(this.a.getPageActivity(), R.dimen.tbds782);
            int o1 = o1(z, z2);
            G1(f2);
            int i2 = f2 + o1;
            this.w.setVisibility(0);
            this.b1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.w.getLayoutParams()).bottomMargin = o1;
            ((RelativeLayout.LayoutParams) this.z0.getLayoutParams()).bottomMargin = o1;
            if (o1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = ej.f(this.a.getPageActivity(), R.dimen.tbds782) - ej.f(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = ej.f(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.fu6
    public void F() {
        wt6 wt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (wt6Var = this.Q) == null) {
            return;
        }
        wt6Var.s(this.F);
    }

    public void F1() {
        vt6 vt6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (vt6Var = this.R) == null) {
            return;
        }
        vt6Var.n();
    }

    @Override // com.baidu.tieba.fu6
    public void G(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onClickListener) == null) {
            this.N.setOnClickListener(onClickListener);
            this.n.setOnClickListener(onClickListener);
            this.r.setOnClickListener(onClickListener);
            HotRankEntryView hotRankEntryView = this.O0;
            if (hotRankEntryView != null) {
                hotRankEntryView.setOnClickListener(onClickListener);
            }
            View view2 = this.I0;
            if (view2 != null) {
                view2.setOnClickListener(onClickListener);
            }
            View view3 = this.L0;
            if (view3 != null) {
                view3.setOnClickListener(onClickListener);
            }
            this.Z0.h(onClickListener);
        }
    }

    public final void G1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            int f2 = ej.f(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.D0.getVisibility() != 0) {
                f2 -= ej.f(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.k1.getLayoutParams()).topMargin = i2 - f2;
        }
    }

    @Override // com.baidu.tieba.fu6
    public void H(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, forumData, frsViewData) == null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.o1 = true;
        if (nt6.m(this.q1)) {
            x1();
        }
        this.T = forumData.getName();
        this.U = forumData.getId();
        this.a0 = forumData.getMember_num();
        this.b0 = forumData.getPost_num();
        forumData.getTag_color();
        this.v0 = forumData.getImage_url();
        this.V = forumData.getLevelName();
        this.Z = forumData.getUser_level();
        if (forumData.getSignData() != null) {
            int i2 = forumData.getSignData().count_sign_num;
            this.c0 = forumData.getSignData().miss_sign_num;
        }
        this.d0 = forumData.getCurScore();
        this.e0 = forumData.getLevelupScore();
        this.P = forumData.getBadgeData();
        this.W = forumData.getAccelerateContent();
        this.k0 = forumData.isBrandForum;
        this.q1 = frsViewData;
        if (!StringUtils.isNull(this.U) && !StringUtils.isNull(this.T)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.q1;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.q1.getHotUserRankData().hot_user != null && this.q1.getHotUserRankData().hot_user.size() >= 3) {
            this.x.setHasHotRankList(true);
        } else {
            this.x.setHasHotRankList(false);
        }
        int l2 = this.Z0.l(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.q1;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.x.a()) {
            z = false;
        }
        if (l2 == 0 && z) {
            this.x.setVisibility(0);
            this.E0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.x;
            FrsViewData frsViewData4 = this.q1;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.x.setVisibility(8);
            this.E0.setVisibility(8);
        }
        this.Y = new ThreadData();
        H1();
        w1();
        if (this.q1.getActivityHeadData() != null && this.q1.getActivityHeadData().a() != null) {
            ArrayList<as4> b2 = this.q1.getActivityHeadData().b();
            this.H0 = jr6.c(this.d, r1(ListUtils.isEmpty(b2) ? null : b2.get(0)));
            if (this.y0 && this.q1.getActivityHeadData().a().h) {
                this.H0.setVisibility(0);
            } else {
                this.H0.setVisibility(8);
            }
        }
        M1(forumData);
        if (frsViewData != null) {
            this.G = frsViewData.mSignActivityInfo;
            i1();
        }
        this.q1 = frsViewData;
        T1(frsViewData);
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.v0);
            this.Y.getMedias().add(mediaData);
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TextView textView = this.g1;
            if (textView != null && textView.getVisibility() == 8) {
                this.g1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.h1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.h1.getVisibility() == 4) {
                    this.h1.setVisibility(0);
                    if (this.h1.isAnimating()) {
                        this.h1.cancelAnimation();
                    }
                    this.h1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.h1.setRepeatCount(-1);
                    this.h1.playAnimation();
                }
            }
        }
    }

    public final void J1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            int k2 = ej.k(this.a.getPageActivity());
            int i2 = (k2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c1.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.c1.setLayoutParams(layoutParams);
            this.c1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d1.getLayoutParams();
            layoutParams2.width = k2;
            layoutParams2.height = i2;
            this.d1.setLayoutParams(layoutParams2);
        }
    }

    public final int K1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int u1 = u1();
            J1();
            int o1 = o1(z, z2);
            this.l1.setVisibility(0);
            this.m1.setVisibility(0);
            int f2 = ej.f(this.a.getPageActivity(), R.dimen.tbds96);
            int i2 = o1 + u1 + f2;
            this.w.setVisibility(8);
            this.b1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (u1 - ej.f(this.a.getPageActivity(), R.dimen.tbds282)) + f2;
            G1(u1 + f2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void L1(as4 as4Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048594, this, as4Var, i2) == null) {
            if (i2 == -1) {
                b2 = et6.c(this.q1);
            } else {
                b2 = et6.b(as4Var, i2);
            }
            if (StringUtils.isNull(b2)) {
                return;
            }
            int b3 = bh7.b(b2);
            this.m1.setGradientColors(0, b3);
            this.l1.setBackgroundColor(b3);
        }
    }

    public final void M1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.K0.setText(str);
                    this.J0.K(forumData.getManagers().get(0).portrait, 12, false);
                    this.I0.setVisibility(0);
                } else {
                    this.I0.setVisibility(8);
                }
                if (this.L0.getVisibility() == 0) {
                    this.L0.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.I0.getVisibility() == 0) {
                this.I0.setVisibility(8);
            }
            if (this.L0.getVisibility() == 8) {
                this.L0.setVisibility(0);
            }
        }
    }

    public final void N1(List<Cdo> list, ul8 ul8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, list, ul8Var) == null) || this.A == null) {
            return;
        }
        this.P0 = list;
        FrsViewData frsViewData = this.q1;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.q1.getVoiceRoomData().a().size() > 0) {
            this.D.setVisibility(0);
            this.D.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.q1.getVoiceRoomData().a())) {
                if (this.q1.getVoiceRoomData().a().size() > 5) {
                    this.D.setShowMore(true);
                } else {
                    this.D.setShowMore(false);
                }
            }
            this.D.a(this.q1.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.D.setVisibility(8);
            }
        }
        if (ul8Var != null) {
            this.z = new rj6(this.a.getPageActivity());
            this.y.setVisibility(0);
            this.y.addView(this.z.f());
            FrsViewData frsViewData2 = this.q1;
            ForumData forum = frsViewData2 != null ? frsViewData2.getForum() : null;
            rj6 rj6Var = this.z;
            FrsViewData frsViewData3 = this.q1;
            rj6Var.e(forum, ul8Var, frsViewData3 == null || frsViewData3.isFromCache);
            j1(ul8Var);
        } else {
            this.y.setVisibility(8);
        }
        FrsVoiceRoomListLayout frsVoiceRoomListLayout2 = this.D;
        if (frsVoiceRoomListLayout2 != null && frsVoiceRoomListLayout2.getVisibility() == 0) {
            this.G0.setVisibility(8);
        } else {
            this.G0.setVisibility(this.Z0.l(LogicField.TOP_DIVIDER));
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.W3()) {
            this.A.setVisibility(0);
            this.A.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.q1;
            ForumData forum2 = frsViewData4 != null ? frsViewData4.getForum() : null;
            FrsViewData frsViewData5 = this.q1;
            this.A.setForum(this.U, this.T, forum2, frsViewData5 != null ? frsViewData5.getUserData() : null, this.b.o3());
            if (list.size() > 0 && (list.get(0) instanceof dm8)) {
                this.R0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof dm8)) {
                this.R0 = 1;
            } else {
                this.R0 = -1;
            }
            this.A.setDatas(list, ul8Var);
            if (this.x0 == null) {
                this.x0 = new n(this);
            }
            this.A.setStatListener(this.x0);
            return;
        }
        this.A.setVisibility(8);
    }

    public final boolean O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            FrsViewData frsViewData = this.q1;
            if (frsViewData == null) {
                return false;
            }
            as4 as4Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                as4Var = new as4();
                as4Var.q("");
                as4Var.p(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                as4Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (as4Var != null) {
                if (r1(as4Var)) {
                    R1(frsViewData, as4Var);
                } else {
                    P1(frsViewData, as4Var);
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(as4Var.l(), 0));
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void P1(FrsViewData frsViewData, as4 as4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, frsViewData, as4Var) == null) || this.w == null || as4Var == null) {
            return;
        }
        if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
            StatisticItem statisticItem = new StatisticItem("c13326");
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
            TiebaStatic.log(statisticItem);
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
            }
            et6.e(frsViewData, 1, this.b.getUniqueId());
        }
        this.w.K(as4Var.d(), 10, false);
        this.w.setOnClickListener(new b(this, as4Var, frsViewData));
    }

    public final void Q1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || (tBLottieAnimationView = this.f1) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() == 8 || this.f1.getVisibility() == 4) {
            this.f1.setVisibility(0);
            if (this.f1.isAnimating()) {
                this.f1.cancelAnimation();
            }
            this.f1.setAnimation(R.raw.obfuscated_res_0x7f11001b);
            this.f1.setRepeatCount(-1);
            this.f1.playAnimation();
        }
    }

    public final void R1(FrsViewData frsViewData, as4 as4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, frsViewData, as4Var) == null) {
            this.c1.setVisibility(0);
            L1(null, -1);
            this.c1.K(as4Var.c(), 10, false);
            if (this.b1.getVisibility() != 0) {
                this.b1.setVisibility(0);
            }
            this.b1.setVideoPath(as4Var.h());
            this.b1.setVolume(0.0f, 0.0f);
            this.b1.setVideoScalingMode(0);
            this.b1.I(true);
            this.b1.setLooping(false);
            this.b1.setVideoStatusChangeListener(new o(this, as4Var, frsViewData));
            this.b1.getMediaProgressObserver().j(new p(this, as4Var));
            if (et6.f()) {
                this.e1.setVisibility(8);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && !this.q1.isFromCache && (this.n1 || (!frsFragment.T3() && !this.b.S3() && !this.b.x3()))) {
                    this.b1.start();
                }
            } else {
                this.e1.setVisibility(0);
            }
            this.c1.setOnClickListener(new q(this, as4Var, frsViewData));
            this.b1.setOnClickListener(new a(this, as4Var, frsViewData));
            FrsFragment frsFragment2 = this.b;
            if (frsFragment2 != null) {
                et6.e(frsViewData, 2, frsFragment2.getUniqueId());
            }
        }
    }

    @Override // com.baidu.tieba.fu6
    @SuppressLint({"ResourceAsColor"})
    public void S(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048601, this, view2, z) == null) {
            if (this.f0 == 0 && TbadkCoreApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
                if (TbadkCoreApplication.getInst().getIntentClass(MemberPayActivityConfig.class) == null || z) {
                    return;
                }
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0662, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09073f);
                TextView textView2 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0912f1);
                TextView textView3 = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091f31);
                SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090964), R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView2, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(textView3, R.color.CAM_X0105, 1);
                nu4 nu4Var = new nu4(this.a.getPageActivity());
                nu4Var.setContentView(inflate);
                I(textView, textView2);
                if (!TextUtils.isEmpty(this.W) && !TextUtils.isEmpty(this.W.trim())) {
                    textView3.setVisibility(0);
                    textView3.setText(this.W);
                } else {
                    textView3.setVisibility(8);
                }
                nu4Var.setButtonTextColor(R.color.CAM_X0305);
                B1(nu4Var);
                C1(nu4Var);
                nu4Var.create(this.a);
                nu4Var.show();
                return;
            }
            this.c.removeCallbacks(this.p0);
            if (this.H == null) {
                PopupWindow popupWindow = new PopupWindow(this.a.getPageActivity());
                this.H = popupWindow;
                popupWindow.setContentView(this.I);
                this.H.setBackgroundDrawable(new BitmapDrawable());
                this.H.setOutsideTouchable(true);
                this.H.setFocusable(true);
                this.H.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07027d));
                this.H.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a));
            }
            this.J = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f09073e);
            this.K = (TextView) this.I.findViewById(R.id.obfuscated_res_0x7f0912f0);
            SkinManager.setBackgroundResource(this.I.findViewById(R.id.obfuscated_res_0x7f090961), R.drawable.icon_frs_experience_number);
            SkinManager.setViewTextColor((TextView) this.I.findViewById(R.id.obfuscated_res_0x7f090960), R.color.CAM_X0111, 1);
            SkinManager.setViewTextColor(this.J, R.color.common_color_10047, 1);
            SkinManager.setViewTextColor(this.K, R.color.CAM_X0111, 1);
            I(this.J, this.K);
            if (this.H.isShowing()) {
                ih.d(this.H, this.a.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] - this.H.getHeight() <= 50) {
                ih.d(this.H, this.a.getPageActivity());
                return;
            }
            PopupWindow popupWindow2 = this.H;
            ih.m(popupWindow2, this.d, 0, iArr[0], iArr[1] - popupWindow2.getHeight());
            this.H.update();
            this.c.postDelayed(this.p0, 2000L);
        }
    }

    public final void S1(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.F = true;
            this.X0 = new g(this, j2, j3, str).start();
            if (this.Q == null || i()) {
                return;
            }
            this.Q.s(this.F);
        }
    }

    @Override // com.baidu.tieba.fu6
    public void T() {
        FrsViewData frsViewData;
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.R0 == -1 || (frsViewData = this.q1) == null || frsViewData.forumRule == null || frsViewData.getUserData() == null || this.A == null) {
            return;
        }
        if (this.q1.getUserData().getIs_manager() == 1) {
            if (this.q1.forumRule.has_forum_rule.intValue() == 1 || this.q1.forumRule.audit_status.intValue() != 0) {
                return;
            }
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0772);
            str = "key_forum_rule_first_show_frs_manager";
        } else {
            string = this.a.getString(R.string.obfuscated_res_0x7f0f0773);
            str = "key_forum_rule_first_show_frs";
        }
        View view2 = null;
        if (this.A.getmTopViews() != null && this.A.getmTopViews().size() > 0 && (this.A.getmTopViews().get(0) instanceof AdapterLinearLayout)) {
            AdapterLinearLayout adapterLinearLayout = (AdapterLinearLayout) this.A.getmTopViews().get(0);
            if (this.R0 < adapterLinearLayout.getChildCount()) {
                view2 = adapterLinearLayout.getChildAt(this.R0);
            }
        }
        if (this.Q0 != null || view2 == null) {
            return;
        }
        x36 x36Var = new x36(this.a, view2);
        this.Q0 = x36Var;
        x36Var.q0(R.drawable.obfuscated_res_0x7f0802f5);
        this.Q0.T(16);
        this.Q0.c0(true);
        this.Q0.u0(UtilHelper.getDimenPixelSize(R.dimen.tbds128));
        this.Q0.v0(UtilHelper.getDimenPixelSize(R.dimen.tbds_10));
        this.Q0.r0(true);
        this.Q0.S(4000);
        if (this.Q0.O() || this.b.w3()) {
            return;
        }
        this.Q0.x0(string, str);
    }

    public final void T1(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, frsViewData) == null) {
            if (frsViewData != null && frsViewData.getUserData() != null) {
                if (frsViewData.getUserData().getIs_manager() == 1 && frsViewData.getBaWuNoticeNum() > 0) {
                    this.p1.setVisibility(0);
                    this.p1.f(frsViewData.getBaWuNoticeNum());
                    return;
                }
                this.p1.setVisibility(8);
                return;
            }
            this.p1.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.fu6
    public void V() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d07e2, (ViewGroup) null);
                this.M.setContentView(contentView);
                contentView.setOnClickListener(new e(this));
                this.M.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070299));
                this.M.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070306));
                this.M.setBackgroundDrawable(new BitmapDrawable());
                this.M.setOutsideTouchable(true);
                this.M.setTouchInterceptor(new f(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0914df), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f091f29), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0920f2), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            ih.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    @Override // com.baidu.tieba.fu6
    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
        }
    }

    @Override // com.baidu.tieba.fu6
    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.f0 != 0) {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    @Override // com.baidu.tieba.fu6
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.Z0.k(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.fu6
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i2) == null) {
            this.Z0.onChangeSkinType(i2);
            this.a.getLayoutMode().l(i2 == 1);
            this.a.getLayoutMode().k(this.d);
            this.a.getLayoutMode().k(this.I);
            this.a.getLayoutMode().k(this.m);
            SkinManager.setBackgroundResource(this.I, R.drawable.icon_frs_experience_number);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f08058f);
            hv4 d2 = hv4.d(this.D0);
            d2.m(1);
            d2.n(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.E0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.F0, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0624);
            SkinManager.setBackgroundColor(this.G0, R.color.CAM_X0201);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0101);
            SkinManager.setBackgroundColor(this.t, R.color.black_alpha0);
            SkinManager.setBackgroundColor(this.s0, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.s, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.t0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.u0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.K0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.N0, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            hv4 d3 = hv4.d(this.g1);
            d3.v(R.color.CAM_X0101);
            d3.z(R.dimen.T_X09);
            hv4 d4 = hv4.d(this.E);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0101);
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(ej.f(this.a.getPageActivity(), R.dimen.tbds1));
                this.N.setBorderColor(SkinManager.getColor(R.color.CAM_X0603));
                this.N.setStrokeColorResId(R.color.CAM_X0201);
                this.N.setPlaceHolder(1);
                this.N.invalidate();
            }
            HeadImageView headImageView = this.J0;
            if (headImageView != null) {
                headImageView.invalidate();
            }
            UserIconBox userIconBox = this.O;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null) {
                linearGradientView.a(i2);
            }
            FrsLikeRecommendLayout frsLikeRecommendLayout = this.S;
            if (frsLikeRecommendLayout != null) {
                frsLikeRecommendLayout.onChangeSkinType(this.a, i2);
            }
            Iterator<TbImageView> it = this.w0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            Z();
            L(this.i0 ? 1 : 0);
            F1();
            v1(i2);
            f1(s1(), t1());
            ServiceAreaView serviceAreaView = this.x;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.A;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            rj6 rj6Var = this.z;
            if (rj6Var != null) {
                rj6Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.O0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.D;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            po6 po6Var = this.n0;
            if (po6Var != null) {
                po6Var.i();
            }
        }
    }

    @Override // com.baidu.tieba.fu6
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            SignActivityInfo signActivityInfo = this.G;
            if (signActivityInfo != null) {
                return String.valueOf(signActivityInfo.activity_id);
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public final void f1(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int f2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (relativeLayout = this.u) == null || relativeLayout.getLayoutParams() == null) {
            return;
        }
        if (this.O0.getVisibility() == 0) {
            f2 = ej.f(this.a.getPageActivity(), R.dimen.tbds704);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = ej.f(this.a.getPageActivity(), R.dimen.tbds384);
            ((RelativeLayout.LayoutParams) this.O0.getLayoutParams()).topMargin = (ej.f(this.a.getPageActivity(), R.dimen.tbds226) + ej.s(this.a.getPageActivity())) - ej.f(this.a.getPageActivity(), R.dimen.tbds72);
        } else {
            f2 = ej.f(this.a.getPageActivity(), R.dimen.tbds600);
        }
        if (!z && !z2 && !this.y0) {
            f2 -= ej.f(this.a.getPageActivity(), R.dimen.tbds80);
        } else if (this.y0) {
            if (nt6.m(this.q1)) {
                f2 = K1(z, z2);
            } else {
                f2 = E1(z, z2);
            }
        }
        ViewGroup.LayoutParams layoutParams = this.u.getLayoutParams();
        if (layoutParams.height != f2) {
            layoutParams.height = f2;
            this.u.setLayoutParams(layoutParams);
        }
    }

    public final void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            boolean s1 = s1();
            boolean t1 = t1();
            if (!TextUtils.isEmpty(this.T)) {
                rs6 c2 = qs6.d().c(this.T);
                if (c2 == null) {
                    c2 = new rs6(this.B0, s1);
                } else {
                    c2.d(this.B0);
                    c2.e(s1);
                }
                qs6.d().e(this.T, c2);
            }
            h1(s1, t1);
            f1(s1, t1);
        }
    }

    public final void h1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.b.E3() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C0.getLayoutParams();
        if (!z && !z2) {
            this.C0.setVisibility(0);
            this.E0.setVisibility(8);
            this.F0.setVisibility(this.Z0.l(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = ej.f(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.C0.setVisibility(0);
            this.E0.setVisibility(this.Z0.l(LogicField.SERVICE_AREA));
            layoutParams.topMargin = ej.f(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.E3().u(z, z2);
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || this.G == null) {
            return;
        }
        CountDownTimer countDownTimer = this.X0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.X0.onFinish();
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        this.U0 = ((long) (this.G.activity_time.intValue() + this.G.activity_duration.intValue())) - currentTimeMillis < 0;
        this.V0 = ((long) this.G.activity_time.intValue()) - currentTimeMillis <= 0;
        this.W0 = ((long) (this.G.activity_time.intValue() - this.G.countdown_time.intValue())) - currentTimeMillis <= 0;
        boolean z = this.U0;
        if (z) {
            this.E.setVisibility(8);
            return;
        }
        if (this.V0 && !z) {
            S1(this.G.activity_msg, 1000 * ((this.G.activity_time.intValue() + this.G.activity_duration.intValue()) - currentTimeMillis), this.S0);
        }
        if (!this.V0 && this.W0) {
            this.E.setVisibility(0);
            this.E.setText(this.G.countdown_msg);
            SignActivityInfo signActivityInfo = this.G;
            y1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (this.W0) {
            return;
        }
        SignActivityInfo signActivityInfo2 = this.G;
        y1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.G.countdown_time.intValue()) - currentTimeMillis);
    }

    public final void j1(ul8 ul8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, ul8Var) == null) || ul8Var == null || this.q1 == null || this.Y0) {
            return;
        }
        this.Y0 = true;
        StatisticItem statisticItem = new StatisticItem("common_exp");
        statisticItem.param("page_type", "a006");
        statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
        int i2 = 6;
        if (ul8Var.getType() != 1) {
            if (ul8Var.getType() == 2) {
                i2 = 7;
            } else if (ul8Var.getType() == 3) {
                i2 = 8;
            } else if (ul8Var.getType() == 4) {
                i2 = 21;
            }
        }
        statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
        statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
        statisticItem.param("obj_id", ul8Var.c());
        ForumData forum = this.q1.getForum();
        if (forum != null) {
            statisticItem.param("fid", forum.getId());
            statisticItem.param("fname", forum.getName());
            statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
            statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
        }
        if (ul8Var.getType() == 1) {
            statisticItem.param("tid", ul8Var.m());
            statisticItem.param("thread_type", ul8Var.n());
        }
        if (StringUtils.isNull(ul8Var.q())) {
            statisticItem.param("obj_type", 1);
        } else {
            statisticItem.param("obj_type", 2);
        }
        if (YYLiveUtil.isYYLiveLink(ul8Var.p())) {
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        } else {
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, "");
        }
        TiebaStatic.log(statisticItem);
    }

    @Override // com.baidu.tieba.fu6
    public SignActivityInfo k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.G : (SignActivityInfo) invokeV.objValue;
    }

    @NonNull
    public kr6 k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.Z0 : (kr6) invokeV.objValue;
    }

    public View l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0340, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final int[] m1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) ? i2 <= 3 ? new int[]{-8331843, -10499102} : i2 <= 9 ? new int[]{-10499102, -154262} : i2 <= 15 ? new int[]{-154262, -148180} : new int[]{-148180, -100818} : (int[]) invokeI.objValue;
    }

    @Override // com.baidu.tieba.fu6
    public void n() {
        x36 x36Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (x36Var = this.Q0) == null) {
            return;
        }
        x36Var.N();
        this.R0 = -1;
    }

    public final LinearGradientView n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.E3() != null) {
                View E = this.b.E3().E();
                if (E instanceof LinearGradientView) {
                    return (LinearGradientView) E;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    public final int o1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<Cdo> list;
        List<qm8> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                pm8 pm8Var = this.q1.serviceAreaData;
                if (pm8Var != null && (list2 = pm8Var.b) != null && list2.size() == 1) {
                    i2 = 0 + ej.f(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + ej.f(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.P0) != null) {
                i2 += Math.min(list.size(), 2) * ej.f(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.y.getVisibility() == 0) {
                i2 += ej.f(this.a.getPageActivity(), R.dimen.tbds231);
            }
            return (z2 || z || this.y.getVisibility() == 0) ? i2 + ej.f(this.a.getPageActivity(), R.dimen.tbds45) : i2;
        }
        return invokeCommon.intValue;
    }

    public final void p1(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048623, this, cr4Var) == null) || cr4Var == null || cr4Var.b() == 0.0f) {
            return;
        }
        float d2 = cr4Var.d() / ((cr4Var.b() * 40.0f) / 70.0f);
        float d3 = cr4Var.d() / cr4Var.b();
        this.g1.setAlpha(d2);
        this.h1.setAlpha(d2);
        this.i1.setAlpha(1.0f - d2);
        float f2 = 1.0f - d3;
        this.j1.setAlpha(f2);
        this.d1.setAlpha(f2);
    }

    @Override // com.baidu.tieba.fu6
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.y0 : invokeV.booleanValue;
    }

    public final void q1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048625, this) == null) || (tBLottieAnimationView = this.f1) == null) {
            return;
        }
        tBLottieAnimationView.setVisibility(8);
        if (this.f1.isAnimating()) {
            this.f1.cancelAnimation();
        }
    }

    public final boolean r1(as4 as4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, as4Var)) == null) ? (as4Var == null || StringUtils.isNull(as4Var.c()) || StringUtils.isNull(as4Var.h())) ? false : true : invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.fu6
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.F : invokeV.booleanValue;
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            FrsTopView frsTopView = this.A;
            return frsTopView != null && frsTopView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            ServiceAreaView serviceAreaView = this.x;
            return serviceAreaView != null && serviceAreaView.getVisibility() == 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.fu6
    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            super.u();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            n();
            rj6 rj6Var = this.z;
            if (rj6Var != null) {
                rj6Var.i();
            }
            CountDownTimer countDownTimer = this.X0;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.X0 = null;
            }
            MessageManager.getInstance().unRegisterListener(this.r1);
            MessageManager.getInstance().unRegisterListener(this.s1);
            MessageManager.getInstance().unRegisterListener(this.t1);
            MessageManager.getInstance().unRegisterListener(this.u1);
            MessageManager.getInstance().unRegisterListener(this.v1);
        }
    }

    public final int u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            int k2 = ej.k(this.a.getPageActivity());
            int i2 = (k2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b1.getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.b1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fu6
    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.Z0.g(z);
        }
    }

    public final void v1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        ThemeElement themeElement3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048633, this, i2) == null) || (frsViewData = this.q1) == null || (forum = frsViewData.getForum()) == null || (themeColorInfo = forum.getThemeColorInfo()) == null || (themeElement = themeColorInfo.day) == null || (themeElement2 = themeColorInfo.night) == null || (themeElement3 = themeColorInfo.dark) == null) {
            return;
        }
        if (i2 == 4) {
            themeElement = themeElement3;
        } else if (i2 == 1) {
            themeElement = themeElement2;
        }
        this.a1.b(themeElement);
        this.Z0.b(themeElement);
        if (!this.y0) {
            LinearGradientView n1 = n1();
            LinearGradientView linearGradientView = this.v;
            if (linearGradientView != null && n1 != null) {
                ThemeElement themeElement4 = themeColorInfo.day;
                String str = themeElement4.light_color;
                String str2 = themeElement4.dark_color;
                ThemeElement themeElement5 = themeColorInfo.night;
                String str3 = themeElement5.light_color;
                String str4 = themeElement5.dark_color;
                ThemeElement themeElement6 = themeColorInfo.dark;
                linearGradientView.setGradientColor(str, str2, str3, str4, themeElement6.light_color, themeElement6.dark_color);
            }
            TbImageView tbImageView = this.w;
            if (tbImageView != null) {
                tbImageView.K(themeElement.pattern_image, 10, false);
            }
        }
        ServiceAreaView serviceAreaView = this.x;
        if (serviceAreaView != null) {
            serviceAreaView.setThemeFontColor(bh7.b(themeElement.common_color));
        }
        if (this.A != null) {
            this.A.setUrlAndColor(forum.getTopIcon(), bh7.b(themeElement.common_color));
        }
    }

    @Override // com.baidu.tieba.fu6
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            super.w();
            if (nt6.m(this.q1)) {
                x1();
            }
            rj6 rj6Var = this.z;
            if (rj6Var != null) {
                rj6Var.j();
            }
        }
    }

    public void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            boolean O1 = O1();
            this.y0 = O1;
            this.Z0.f(O1);
            if (this.y0) {
                this.v.setVisibility(8);
                if (nt6.m(this.q1)) {
                    this.z0.setVisibility(4);
                } else {
                    this.z0.setVisibility(0);
                }
                this.A0.setVisibility(0);
            } else {
                this.z0.setVisibility(8);
                this.A0.setVisibility(8);
                this.v.setVisibility(0);
                this.w.setOnClickListener(null);
            }
            TextView textView = this.e;
            if (textView != null) {
                textView.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.a0));
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                textView2.setText(StringHelper.numberUniformFormatExtraWithRoundInt(this.b0));
            }
            this.Z0.i(this.a0, this.b0);
            this.Z0.d(this.Z, this.V);
            ArrayList<kr4> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.T = UtilHelper.getFixedText(this.T, 7);
            } else if (this.k0) {
                this.T = UtilHelper.getFixedText(this.T, 6);
            }
            String c0 = jh6.c0(this.T);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(c0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(c0);
            }
            this.Z0.j(this.v0, c0);
            A1();
            D();
            v1(TbadkCoreApplication.getInst().getSkinType());
            D1();
            g1();
        }
    }

    @Override // com.baidu.tieba.fu6
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            super.x(z);
            rj6 rj6Var = this.z;
            if (rj6Var != null) {
                rj6Var.k(z);
            }
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.c1.setVisibility(0);
            L1(null, -1);
            q1();
            TbVideoView tbVideoView = this.b1;
            if (tbVideoView != null) {
                tbVideoView.Q();
            }
            this.b1.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.fu6
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            rj6 rj6Var = this.z;
            if (rj6Var != null) {
                rj6Var.l();
            }
            if (FrsFragment.p2 && nt6.m(this.q1)) {
                FrsFragment.p2 = false;
                H(this.q1.getForum(), this.q1);
            }
        }
    }

    public final void y1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048639, this, str, j2) == null) {
            this.F = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.T0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new h(this, str), j2, TimeUnit.SECONDS);
        }
    }

    public final void z1(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048640, this, cr4Var) == null) || cr4Var == null) {
            return;
        }
        if (!cr4Var.e()) {
            if (this.g1.getVisibility() != 8) {
                this.g1.setVisibility(8);
            }
            if (this.h1.getVisibility() != 8) {
                this.h1.setVisibility(8);
                if (this.h1.isAnimating()) {
                    this.h1.cancelAnimation();
                }
            }
        } else if (cr4Var.d() < cr4Var.b()) {
            this.g1.setText(R.string.obfuscated_res_0x7f0f124b);
            I1();
        } else if (cr4Var.d() < cr4Var.c()) {
            this.g1.setText(R.string.obfuscated_res_0x7f0f124a);
            I1();
        } else {
            this.g1.setText(R.string.obfuscated_res_0x7f0f124c);
            this.h1.setVisibility(4);
            if (this.h1.isAnimating()) {
                this.h1.cancelAnimation();
            }
        }
    }
}
