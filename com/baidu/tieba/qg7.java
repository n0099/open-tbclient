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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.FrsBannerHeaderData;
import com.baidu.tbadk.core.data.FrsGameRankInfoData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.BitmapHelper;
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
import com.baidu.tieba.frs.FrsFragment;
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
import com.baidu.tieba.oi9;
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
/* loaded from: classes7.dex */
public class qg7 extends bs7 {
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
    public CustomMessageListener E1;
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
    public List<vn> V0;
    public or6 W0;
    public int X0;
    public long Y0;
    public ScheduledExecutorService Z0;
    public boolean a1;
    public boolean b1;
    public boolean c1;
    public CountDownTimer d1;
    public boolean e1;
    @NonNull
    public final vn7 f1;
    @NonNull
    public final zn7 g1;
    public TbVideoView h1;
    public TbImageView i1;
    public View j1;
    public View k1;
    public TBLottieAnimationView l1;
    public TextView m1;
    public TBLottieAnimationView n1;
    public View o1;
    public View p1;
    public View q1;
    public RelativeLayout r0;
    public View r1;
    public TextView s0;
    public FrsHeaderVideoImageShadeView s1;
    public TextView t0;
    public boolean t1;
    public String u0;
    public boolean u1;
    public ArrayList<TbImageView> v0;
    public MessageRedDotView v1;
    public ye7 w0;
    public FrsViewData w1;
    public boolean x0;
    public FrsBannerHeaderView x1;
    public View y0;
    public FrsGroupChatSignGuideView y1;
    public View z0;
    public HeaderComponentNoHeaderController z1;

    @Override // com.baidu.tieba.bs7
    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qg7 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.G != null) {
                    if (this.a.b.G.getVisibility() == 8) {
                        this.a.b.G.setVisibility(0);
                        this.a.b.G.setText(this.a.a);
                        if (this.a.b.I != null) {
                            qg7 qg7Var = this.a.b;
                            qg7Var.E1(qg7Var.I.activity_msg, this.a.b.I.countdown_time.intValue());
                        }
                    } else if (this.a.b.G.getVisibility() == 0) {
                        this.a.b.k1();
                    }
                }
            }
        }

        public g(qg7 qg7Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qg7Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wg.a().post(new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ qg7 c;

        public a(qg7 qg7Var, k25 k25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, k25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qg7Var;
            this.a = k25Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.c.k1.getVisibility() == 0) {
                    this.c.h1.start();
                    return;
                }
                wq7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    uq7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ qg7 c;

        public b(qg7 qg7Var, k25 k25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, k25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qg7Var;
            this.a = k25Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                wq7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                if (this.c.b != null) {
                    uq7.d(this.b, 2, this.c.b.getUniqueId());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ qg7 c;

        public c(qg7 qg7Var, k25 k25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, k25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qg7Var;
            this.a = k25Var;
            this.b = frsViewData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.c.a != null && !h16.a(this.c.a.getPageActivity(), this.a.f()) && !TextUtils.isEmpty(this.a.e())) {
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
                    uq7.d(this.b, 1, this.c.b.getUniqueId());
                }
                if (ui.isEquals(TbadkCoreApplication.getInst().getPackageName(), this.a.g()) && !StringUtils.isNull(this.a.i()) && this.c.b.getPageContext() != null) {
                    UrlManager.getInstance().dealOneLink(this.c.b.getPageContext(), new String[]{this.a.i()});
                } else {
                    wq7.b(this.c.a, this.a.i(), this.a.e(), this.a.g());
                }
                ThirdStatisticHelper.sendReq((String) ListUtils.getItem(this.a.l(), 1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        public d(qg7 qg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qg7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getPageActivity() != null) {
                yg.d(this.a.M, this.a.a.getPageActivity());
                this.a.b.c = false;
                qx4.x(this.a.a.getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f06db), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/tbeanrights?type=7&_client_version=" + TbConfig.getVersion() + "&nohead=1", true, true, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        public e(qg7 qg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qg7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (motionEvent.getAction() == 4) {
                    yg.c(this.a.M);
                    this.a.b.c = false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class f extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ qg7 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(qg7 qg7Var, long j, long j2, String str) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, Long.valueOf(j), Long.valueOf(j2), str};
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
            this.b = qg7Var;
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
            if (this.b.Q != null && !this.b.j()) {
                this.b.Q.s(this.b.H, this.b.y1());
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

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(qg7 qg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, Integer.valueOf(i)};
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
            this.a = qg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof l15)) {
                l15 l15Var = (l15) customResponsedMessage.getData();
                this.a.F1(l15Var);
                this.a.s1(l15Var);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(qg7 qg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, Integer.valueOf(i)};
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
            this.a = qg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && fr7.m(this.a.w1)) {
                this.a.D1();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(qg7 qg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, Integer.valueOf(i)};
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
            this.a = qg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                if (intValue == 1) {
                    if (fr7.m(this.a.w1) && this.a.h1.getVisibility() == 0) {
                        this.a.D1();
                    }
                    this.a.u1 = false;
                } else if (intValue == 2 && fr7.m(this.a.w1)) {
                    if (!this.a.u1) {
                        qg7 qg7Var = this.a;
                        qg7Var.J(qg7Var.w1.getForum(), this.a.w1);
                    }
                    this.a.u1 = false;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(qg7 qg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, Integer.valueOf(i)};
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
            this.a = qg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                int intValue = ((Integer) customResponsedMessage.getData()).intValue();
                this.a.t1 = true;
                if (intValue == 1) {
                    if (!FrsFragment.x2 && fr7.m(this.a.w1)) {
                        qg7 qg7Var = this.a;
                        qg7Var.J(qg7Var.w1.getForum(), this.a.w1);
                    }
                } else if (intValue == 2) {
                    if (fr7.m(this.a.w1)) {
                        qg7 qg7Var2 = this.a;
                        qg7Var2.J(qg7Var2.w1.getForum(), this.a.w1);
                    }
                } else if (intValue == 3) {
                    qg7 qg7Var3 = this.a;
                    qg7Var3.J(qg7Var3.w1.getForum(), this.a.w1);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(qg7 qg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, Integer.valueOf(i)};
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
            this.a = qg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            qg7 qg7Var = this.a;
            qg7Var.a2(qg7Var.w1);
        }
    }

    /* loaded from: classes7.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsGameRankInfoData a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ qg7 c;

        public m(qg7 qg7Var, FrsGameRankInfoData frsGameRankInfoData, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, frsGameRankInfoData, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qg7Var;
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
                this.c.Z1(this.b, this.a, "c15056");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements ye7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qg7 a;

        public n(qg7 qg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qg7Var;
        }

        @Override // com.baidu.tieba.ye7
        public void a(ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
                er7.d(this.a.b, this.a.w1, threadData);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements OnStatusChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;
        public final /* synthetic */ FrsViewData b;
        public final /* synthetic */ qg7 c;

        public o(qg7 qg7Var, k25 k25Var, FrsViewData frsViewData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, k25Var, frsViewData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = qg7Var;
            this.a = k25Var;
            this.b = frsViewData;
        }

        @Override // com.baidu.tieba.play.OnStatusChangedListener
        public void onStatusChange(OnStatusChangedListener.VideoStatus videoStatus) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, videoStatus) == null) {
                if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_PLAYING) {
                    this.c.i1.setVisibility(8);
                    this.c.k1.setVisibility(8);
                    this.c.t1();
                    this.c.Q1(this.a, 0);
                    uq7.l("c14592", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.VIDEO_COMPLETE) {
                    this.c.D1();
                    uq7.l("c14593", this.b);
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_ERROR) {
                    this.c.D1();
                } else if (videoStatus == OnStatusChangedListener.VideoStatus.INTERNAL_VIDEO_BUFFERING_BUFFER) {
                    this.c.W1();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p implements oi9.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k25 a;
        public final /* synthetic */ qg7 b;

        public p(qg7 qg7Var, k25 k25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qg7Var, k25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qg7Var;
            this.a = k25Var;
        }

        @Override // com.baidu.tieba.oi9.c
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.b.Q1(this.a, i2);
        }
    }

    public qg7(FrsFragment frsFragment, String str, String str2, int i2) {
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
        this.e1 = false;
        this.f1 = un7.a();
        this.A1 = new h(this, 2921679);
        this.B1 = new i(this, 2921681);
        this.C1 = new j(this, 2921680);
        this.D1 = new k(this, 2921682);
        this.E1 = new l(this, 2921721);
        this.v0 = new ArrayList<>();
        this.c0 = i2;
        this.c = new Handler();
        this.b = frsFragment;
        this.a = frsFragment.getPageContext();
        vi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0701d5);
        vi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07026a);
        vi.g(frsFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07036f);
        this.f1089T = str;
        this.U = str2;
        View n1 = n1();
        this.d = n1;
        this.f1.c(frsFragment, n1);
        this.g1 = this.f1.e();
        this.r0 = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f09079d);
        this.v = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ed6);
        this.w = (LinearGradientView) this.d.findViewById(R.id.obfuscated_res_0x7f090ed9);
        TbImageView tbImageView = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090ed7);
        this.x = tbImageView;
        tbImageView.setPageId(this.b.getUniqueId());
        this.x.setDefaultBgResource(R.color.transparent);
        this.x.setDefaultResource(R.drawable.obfuscated_res_0x7f081172);
        this.y0 = this.d.findViewById(R.id.obfuscated_res_0x7f090ef8);
        this.h1 = (TbVideoView) this.d.findViewById(R.id.obfuscated_res_0x7f0927ff);
        TbImageView tbImageView2 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f0927f9);
        this.i1 = tbImageView2;
        tbImageView2.setPageId(this.b.getUniqueId());
        this.i1.setDefaultBgResource(R.drawable.obfuscated_res_0x7f081172);
        this.i1.setDefaultResource(R.drawable.obfuscated_res_0x7f081172);
        this.i1.setPlaceHolder(2);
        this.j1 = this.d.findViewById(R.id.obfuscated_res_0x7f0927fe);
        this.k1 = this.d.findViewById(R.id.obfuscated_res_0x7f0927fd);
        this.l1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f0927fc);
        this.z0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d3f);
        this.S = (FrsLikeRecommendLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090cd0);
        un7.d(this.y0, this.z0);
        this.o1 = un7.b(this.d);
        this.p1 = this.d.findViewById(R.id.obfuscated_res_0x7f090ed8);
        this.q1 = this.d.findViewById(R.id.obfuscated_res_0x7f0915ea);
        this.m1 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0926d6);
        this.n1 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f091638);
        this.r1 = this.d.findViewById(R.id.obfuscated_res_0x7f0927fa);
        this.s1 = (FrsHeaderVideoImageShadeView) this.d.findViewById(R.id.obfuscated_res_0x7f0927f8);
        this.B0 = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091440);
        int l2 = this.f1.l(LogicField.ROUND_CORNER_STYLE);
        View findViewById = this.d.findViewById(R.id.obfuscated_res_0x7f090ef2);
        this.C0 = findViewById;
        findViewById.setVisibility(l2);
        this.D0 = this.d.findViewById(R.id.obfuscated_res_0x7f0920b8);
        this.E0 = this.d.findViewById(R.id.obfuscated_res_0x7f090335);
        this.y = (ServiceAreaView) this.d.findViewById(R.id.obfuscated_res_0x7f0920ba);
        this.z = (FrameLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090c22);
        this.F = (FrsVoiceRoomListLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0928da);
        this.B = (FrsTopView) this.d.findViewById(R.id.obfuscated_res_0x7f090d68);
        this.F0 = this.d.findViewById(R.id.obfuscated_res_0x7f090d5f);
        this.C = this.d.findViewById(R.id.obfuscated_res_0x7f090d60);
        this.D = this.d.findViewById(R.id.obfuscated_res_0x7f0920be);
        this.E = this.d.findViewById(R.id.obfuscated_res_0x7f0920bd);
        this.h = (List) this.f1.a(LogicField.LIKE_BTN);
        this.i = (List) this.f1.a(LogicField.SIGN_BTN);
        this.L = (ImageView) m1().a(LogicField.SPEED_ICON);
        this.s0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916dd);
        this.t0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091c5c);
        this.j = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0914ba);
        this.s = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0914b2);
        this.k = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09163f);
        this.l = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f09163e);
        this.e = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f0916e2);
        this.f = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f091c62);
        this.n = (TextView) this.d.findViewById(R.id.forum_name);
        this.o = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f09047d);
        BarImageView barImageView = (BarImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cad);
        this.N = barImageView;
        barImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.N.setPageId(this.b.getUniqueId());
        this.N.setContentDescription(frsFragment.getResources().getString(R.string.obfuscated_res_0x7f0f031d));
        this.N.setStrokeWith(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds4));
        this.N.setShowOval(true);
        this.N.setPlaceHolder(1);
        MessageRedDotView messageRedDotView = (MessageRedDotView) this.d.findViewById(R.id.obfuscated_res_0x7f091de4);
        this.v1 = messageRedDotView;
        messageRedDotView.setThreeDotMode(2);
        this.v1.setEnterForumStyle(true);
        this.v1.setVisibility(8);
        this.r = this.d.findViewById(R.id.obfuscated_res_0x7f0914b3);
        this.q = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ebd);
        this.p = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f091909);
        this.t = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090ec7);
        this.u = this.d.findViewById(R.id.obfuscated_res_0x7f090ec8);
        this.O0 = this.d.findViewById(R.id.obfuscated_res_0x7f090cfa);
        this.Q0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cfb);
        HeadImageView headImageView = (HeadImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cfc);
        this.P0 = headImageView;
        headImageView.setIsRound(true);
        this.P0.setDrawBorder(true);
        this.P0.setDefaultResource(R.drawable.icon_default_avatar100);
        this.P0.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.R0 = this.d.findViewById(R.id.obfuscated_res_0x7f090cf9);
        this.S0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090cf8);
        this.T0 = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cf7);
        WebPManager.setPureDrawable(this.S0, R.drawable.obfuscated_res_0x7f0809ac, R.color.CAM_X0101, null);
        this.K = LayoutInflater.from(frsFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d038e, (ViewGroup) null);
        this.m = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d035c, (ViewGroup) null);
        this.U0 = (HotRankEntryView) this.d.findViewById(R.id.obfuscated_res_0x7f090cab);
        this.m.setVisibility(8);
        this.G = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f0907db);
        this.m0 = (ViewGroup) this.d.findViewById(R.id.obfuscated_res_0x7f090ee2);
        this.G0 = this.d.findViewById(R.id.obfuscated_res_0x7f090dc4);
        TbImageView tbImageView3 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090dc3);
        this.H0 = tbImageView3;
        tbImageView3.setDrawCorner(true);
        this.H0.setConrers(15);
        this.H0.setRadiusById(R.string.J_X05);
        TextView textView = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090dc7);
        this.I0 = textView;
        textView.getPaint().setStrokeWidth(0.5f);
        this.I0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.J0 = (ImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090dc5);
        this.K0 = (TBLottieAnimationView) this.d.findViewById(R.id.obfuscated_res_0x7f090dc6);
        this.L0 = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f090dc2);
        this.K0.setImageAssetsFolder("lottie_frs_game_rank_guide");
        this.K0.setAnimation(R.raw.lottie_frs_game_rank_guide);
        this.K0.setRepeatMode(1);
        this.K0.setMinAndMaxFrame(57, Cea708Decoder.COMMAND_DSW);
        this.x1 = (FrsBannerHeaderView) this.d.findViewById(R.id.obfuscated_res_0x7f090c39);
        this.y1 = (FrsGroupChatSignGuideView) this.d.findViewById(R.id.obfuscated_res_0x7f090c8c);
        MessageManager.getInstance().registerListener(this.A1);
        MessageManager.getInstance().registerListener(this.B1);
        MessageManager.getInstance().registerListener(this.C1);
        MessageManager.getInstance().registerListener(this.D1);
        MessageManager.getInstance().registerListener(this.E1);
    }

    public final boolean u1(k25 k25Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, k25Var)) == null) {
            if (k25Var == null || StringUtils.isNull(k25Var.c()) || StringUtils.isNull(k25Var.h())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.bs7
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.f1.g(z);
        }
    }

    @Override // com.baidu.tieba.bs7
    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            super.z(z);
            xf7 xf7Var = this.A;
            if (xf7Var != null) {
                xf7Var.k(z);
            }
        }
    }

    public final void E1(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j2) == null) {
            this.H = false;
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.Z0 = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new g(this, str), j2, TimeUnit.SECONDS);
        }
    }

    @Override // com.baidu.tieba.bs7
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xf7 xf7Var = this.A;
            if (xf7Var != null) {
                xf7Var.l();
            }
            if (FrsFragment.x2 && fr7.m(this.w1)) {
                FrsFragment.x2 = false;
                J(this.w1.getForum(), this.w1);
            }
        }
    }

    public final void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.i1.setVisibility(0);
            Q1(null, -1);
            t1();
            TbVideoView tbVideoView = this.h1;
            if (tbVideoView != null) {
                tbVideoView.T();
            }
            this.h1.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.bs7
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.B.i(this.X0);
        }
    }

    @Override // com.baidu.tieba.bs7
    public void F() {
        FrsViewData frsViewData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.b != null && (frsViewData = this.w1) != null) {
            List<vn> showTopThreadList = frsViewData.getShowTopThreadList();
            if (showTopThreadList.size() > 2) {
                z = true;
            } else {
                z = false;
            }
            this.A0 = z;
            S1(showTopThreadList, this.w1.getBusinessPromot());
        }
    }

    @Override // com.baidu.tieba.bs7
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            or7 or7Var = this.Q;
            if (or7Var != null) {
                or7Var.q(this.b0);
            }
            r1(true);
        }
    }

    public void G1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.N.N(this.u0, 10, false);
        }
    }

    @Override // com.baidu.tieba.bs7
    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            or7 or7Var = this.Q;
            if (or7Var != null) {
                or7Var.s(this.H, y1());
            }
            r1(false);
        }
    }

    public void J1() {
        nr7 nr7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && (nr7Var = this.R) != null) {
            nr7Var.n();
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.x1.setVisibility(8);
            this.E.setVisibility(8);
            this.C0.setVisibility(this.f1.l(LogicField.ROUND_CORNER_STYLE));
        }
    }

    public void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MediaData mediaData = new MediaData();
            mediaData.setType(3);
            mediaData.setPic(this.u0);
            this.X.getMedias().add(mediaData);
        }
    }

    public final String T1() {
        InterceptResult invokeV;
        d25 d25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            if (!this.d0 && this.e0 && (d25Var = this.f0) != null) {
                return d25Var.b();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs7
    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            if (this.c0 != 0) {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_orange);
            } else {
                SkinManager.setImageResource(this.L, R.drawable.icon_sml_speed_gray);
            }
        }
    }

    @Override // com.baidu.tieba.bs7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.f1.k(LogicField.BRAND_LABEL, 0);
            this.o.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.bs7
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

    @Override // com.baidu.tieba.bs7
    public SignActivityInfo l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.I;
        }
        return (SignActivityInfo) invokeV.objValue;
    }

    @NonNull
    public vn7 m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.f1;
        }
        return (vn7) invokeV.objValue;
    }

    public View n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0382, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs7
    public void p() {
        or6 or6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (or6Var = this.W0) != null) {
            or6Var.h();
            this.X0 = -1;
        }
    }

    public final LinearGradientView p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            FrsFragment frsFragment = this.b;
            if (frsFragment != null && frsFragment.T3() != null) {
                View D = this.b.T3().D();
                if (D instanceof LinearGradientView) {
                    return (LinearGradientView) D;
                }
            }
            return null;
        }
        return (LinearGradientView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bs7
    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.x0;
        }
        return invokeV.booleanValue;
    }

    public final void t1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048632, this) == null) && (tBLottieAnimationView = this.l1) != null) {
            tBLottieAnimationView.setVisibility(8);
            if (this.l1.isAnimating()) {
                this.l1.cancelAnimation();
            }
        }
    }

    @Override // com.baidu.tieba.bs7
    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            FrsTopView frsTopView = this.B;
            if (frsTopView != null && frsTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null && serviceAreaView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            int l2 = vi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.h1.setLayoutParams(layoutParams);
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bs7
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            super.y();
            if (fr7.m(this.w1)) {
                D1();
            }
            xf7 xf7Var = this.A;
            if (xf7Var != null) {
                xf7Var.j();
            }
        }
    }

    public final boolean y1() {
        InterceptResult invokeV;
        d25 d25Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (!this.d0 && this.e0 && (d25Var = this.f0) != null && !TextUtils.isEmpty(d25Var.c())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A1(int i2) {
        FrsViewData frsViewData;
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) && (frsViewData = this.w1) != null && (forum = frsViewData.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && (themeElement = themeColorInfo.day) != null && themeColorInfo.night != null && (themeElement2 = themeColorInfo.dark) != null) {
            if (i2 == 4) {
                themeElement = themeElement2;
            }
            this.g1.b(themeElement);
            this.f1.b(themeElement);
            if (!this.x0) {
                LinearGradientView p1 = p1();
                LinearGradientView linearGradientView = this.w;
                if (linearGradientView != null && p1 != null) {
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
                    tbImageView.N(themeElement.pattern_image, 10, false);
                }
            }
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.setThemeFontColor(zo8.b(themeElement.common_color));
            }
            if (this.B != null) {
                this.B.setUrlAndColor(forum.getTopIcon(), zo8.b(themeElement.common_color));
            }
        }
    }

    public final void F1(l15 l15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, l15Var) != null) || l15Var == null) {
            return;
        }
        if (!l15Var.e()) {
            if (this.m1.getVisibility() != 8) {
                this.m1.setVisibility(8);
            }
            if (this.n1.getVisibility() != 8) {
                this.n1.setVisibility(8);
                if (this.n1.isAnimating()) {
                    this.n1.cancelAnimation();
                }
            }
        } else if (l15Var.d() < l15Var.b()) {
            this.m1.setText(R.string.surprise_in_drop_down);
            N1();
        } else if (l15Var.d() < l15Var.c()) {
            this.m1.setText(R.string.surprise_continue_drop_down);
            N1();
        } else {
            this.m1.setText(R.string.surprise_when_release_hand);
            this.n1.setVisibility(4);
            if (this.n1.isAnimating()) {
                this.n1.cancelAnimation();
            }
        }
    }

    public final void R1(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, forumData) == null) {
            if (forumData.getManagers() != null && forumData.getManagers().size() > 0) {
                String str = forumData.getManagers().get(0).show_name;
                if (TextUtils.isEmpty(str)) {
                    str = forumData.getManagers().get(0).name;
                }
                if (!TextUtils.isEmpty(str)) {
                    this.Q0.setText(str);
                    this.P0.N(forumData.getManagers().get(0).portrait, 12, false);
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

    public final void r1(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048629, this, z) == null) && this.y1 != null) {
            String T1 = T1();
            if (!z && !TextUtils.isEmpty(T1)) {
                this.y1.d(T1);
                if (this.f0 != null) {
                    TiebaStatic.log(new StatisticItem("c15205").param("obj_type", 1).param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", this.U).param("fname", this.f1089T).param("room_id", this.f0.a()));
                    return;
                }
                return;
            }
            this.y1.a();
        }
    }

    public final void B1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, frsViewData) != null) || frsViewData == null) {
            return;
        }
        FrsGameRankInfoData frsGameRankInfoData = frsViewData.frsGameRankInfoData;
        if (frsGameRankInfoData == null) {
            this.G0.setVisibility(8);
            this.E.setVisibility(8);
            this.C0.setVisibility(this.f1.l(LogicField.ROUND_CORNER_STYLE));
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
        Z1(frsViewData, frsGameRankInfoData, "c15055");
        this.C0.setVisibility(8);
        int b2 = zo8.b(frsGameRankInfoData.rankColor);
        if (zo8.a(b2)) {
            this.N.setUseStrokeColorInt(false);
        } else {
            this.N.setStrokeColorInt(b2);
            this.N.setUseStrokeColorInt(true);
        }
        if (!this.K0.isAnimating() && !this.M0) {
            int i3 = frsGameRankInfoData.showType;
            if (i3 < 0) {
                this.K0.setRepeatCount(-1);
                this.K0.u();
                this.M0 = true;
            } else if (i3 > 0) {
                this.K0.setRepeatCount(i3);
                this.K0.u();
                this.M0 = true;
            } else {
                this.K0.setFrame(Cea708Decoder.COMMAND_DSW);
            }
        }
        this.H0.N(frsGameRankInfoData.icon, 10, false);
        if (TextUtils.isEmpty(frsGameRankInfoData.rankIcon)) {
            this.L0.setVisibility(8);
        } else {
            this.L0.setVisibility(0);
            this.L0.N(frsGameRankInfoData.rankIcon, 10, false);
        }
        this.I0.setText(frsGameRankInfoData.rankName + "#" + frsGameRankInfoData.rankScore);
        this.G0.setOnClickListener(new m(this, frsGameRankInfoData, frsViewData));
    }

    public final void l1(tw9 tw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, tw9Var) == null) && tw9Var != null && this.w1 != null && !this.e1) {
            this.e1 = true;
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a006");
            statisticItem.param(TiebaStatic.Params.OBJ_ISAD, "1");
            int i2 = 6;
            if (tw9Var.getType() != 1) {
                if (tw9Var.getType() == 2) {
                    i2 = 7;
                } else if (tw9Var.getType() == 3) {
                    i2 = 8;
                } else if (tw9Var.getType() == 4) {
                    i2 = 21;
                }
            }
            statisticItem.param(TiebaStatic.Params.OBJ_FLOOR, 1);
            statisticItem.param(TiebaStatic.Params.OBJ_AD_LOCATE, i2);
            statisticItem.param("obj_id", tw9Var.c());
            ForumData forum = this.w1.getForum();
            if (forum != null) {
                statisticItem.param("fid", forum.getId());
                statisticItem.param("fname", forum.getName());
                statisticItem.param(TiebaStatic.Params.FIRST_DIR, forum.getFirst_class());
                statisticItem.param(TiebaStatic.Params.SECOND_DIR, forum.getSecond_class());
            }
            if (tw9Var.getType() == 1) {
                statisticItem.param("tid", tw9Var.m());
                statisticItem.param("thread_type", tw9Var.n());
            }
            if (StringUtils.isNull(tw9Var.q())) {
                statisticItem.param("obj_type", 1);
            } else {
                statisticItem.param("obj_type", 2);
            }
            if (YYLiveUtil.isYYLiveLink(tw9Var.p())) {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            } else {
                statisticItem.param(TiebaStatic.YYParams.YYLIVEID, "");
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            boolean U1 = U1();
            this.x0 = U1;
            this.f1.f(U1);
            if (this.x0) {
                this.w.setVisibility(8);
                if (fr7.m(this.w1)) {
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
            this.f1.i(this.Z, this.a0);
            this.f1.d(this.Y, this.V);
            ArrayList<t15> arrayList = this.P;
            if (arrayList != null && arrayList.size() > 0) {
                this.f1089T = UtilHelper.getFixedText(this.f1089T, 7);
            } else if (this.k0) {
                this.f1089T = UtilHelper.getFixedText(this.f1089T, 6);
            }
            String f0 = od7.f0(this.f1089T);
            TextView textView3 = this.g;
            if (textView3 != null) {
                textView3.setText(f0);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setText(f0);
            }
            this.f1.j(this.u0, f0);
            G1();
            F();
            A1(TbadkCoreApplication.getInst().getSkinType());
            H1();
            FrsViewData frsViewData = this.w1;
            if (frsViewData.frsBannerHeaderData != null) {
                z1(frsViewData);
            } else {
                B1(frsViewData);
            }
            i1();
        }
    }

    public final void H1() {
        FrsViewData frsViewData;
        View f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.a != null && (frsViewData = this.w1) != null && !ListUtils.isEmpty(frsViewData.liveFuseForumDataList)) {
                List<LiveFuseForumData> list = this.w1.liveFuseForumDataList;
                if (list.size() == 1 && list.get(0).type.intValue() == 7 && list.get(0).novel != null) {
                    HeaderComponentNoHeaderController headerComponentNoHeaderController = new HeaderComponentNoHeaderController(this.a, list.get(0));
                    this.z1 = headerComponentNoHeaderController;
                    f2 = headerComponentNoHeaderController.e();
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.leftMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    layoutParams.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
                    f2.setLayoutParams(layoutParams);
                    this.z1.h();
                } else {
                    this.n0 = new cl7(this.a, list);
                    if (this.w1.getForum() != null) {
                        this.n0.i(this.w1.getForum().getId(), this.w1.getForum().getName());
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

    @Override // com.baidu.tieba.bs7
    public void U() {
        View contentView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            PopupWindow popupWindow = this.M;
            if (popupWindow == null) {
                this.M = new PopupWindow(this.a.getPageActivity());
                contentView = LayoutInflater.from(this.a.getContext()).inflate(R.layout.obfuscated_res_0x7f0d08a1, (ViewGroup) null);
                this.M.setContentView(contentView);
                GreyUtil.grey(this.M);
                contentView.setOnClickListener(new d(this));
                this.M.setWidth(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0703b1));
                this.M.setHeight(this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07041a));
                this.M.setBackgroundDrawable(new BitmapDrawable());
                this.M.setOutsideTouchable(true);
                this.M.setTouchInterceptor(new e(this));
            } else {
                contentView = popupWindow.getContentView();
            }
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f0916cb), R.color.CAM_X0101, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f092192), R.color.CAM_X0305, 1);
            SkinManager.setViewTextColor((TextView) contentView.findViewById(R.id.obfuscated_res_0x7f092391), R.color.CAM_X0101, 1);
            int[] iArr = new int[2];
            this.L.getLocationOnScreen(iArr);
            PopupWindow popupWindow2 = this.M;
            yg.m(popupWindow2, this.d, 0, (iArr[0] - (popupWindow2.getWidth() / 2)) + (this.L.getWidth() / 2), iArr[1] + this.L.getWidth());
            this.M.update();
        }
    }

    public final void k1() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048620, this) != null) || this.I == null) {
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
            Y1(this.I.activity_msg, 1000 * ((this.I.activity_time.intValue() + this.I.activity_duration.intValue()) - currentTimeMillis), this.Y0);
        }
        if (!this.b1 && this.c1) {
            this.G.setVisibility(0);
            this.G.setText(this.I.countdown_msg);
            SignActivityInfo signActivityInfo = this.I;
            E1(signActivityInfo.activity_msg, signActivityInfo.activity_time.intValue() - currentTimeMillis);
        }
        if (!this.c1) {
            SignActivityInfo signActivityInfo2 = this.I;
            E1(signActivityInfo2.countdown_msg, (signActivityInfo2.activity_time.intValue() - this.I.countdown_time.intValue()) - currentTimeMillis);
        }
    }

    @Override // com.baidu.tieba.bs7
    public void D(boolean z, float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Float.valueOf(f2)}) == null) {
            this.j0 = z;
            Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_frs_signin_bar_down);
            if (cashBitmap == null || this.j == null || this.k == null || this.s == null || cashBitmap.getWidth() <= 0) {
                return;
            }
            if (this.j0) {
                this.j.setText(R.string.obfuscated_res_0x7f0f0b66);
                if (f2 >= 1.0f) {
                    i2 = this.Y;
                } else {
                    i2 = this.Y + 1;
                }
                FrsViewData c1 = this.b.c1();
                if (c1 != null && c1.getForum() != null) {
                    c1.getForum().setUser_level(i2);
                }
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c10, Integer.valueOf(i2)));
            } else {
                this.f1.d(this.Y, this.V);
                this.j.setText(this.V);
                this.s.setText(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c10, Integer.valueOf(this.Y)));
            }
            this.k.setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, o1(this.Y)));
            if (this.j0) {
                if (f2 >= 1.0f) {
                    X(this.k, this.l0, f2);
                } else {
                    V(this.k, this.l0, f2);
                }
            } else {
                X(this.k, this.l0, f2);
            }
            this.l0 = f2;
        }
    }

    public final void h1(boolean z, boolean z2) {
        RelativeLayout relativeLayout;
        int g2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && (relativeLayout = this.v) != null && relativeLayout.getLayoutParams() != null) {
            if (this.U0.getVisibility() == 0) {
                g2 = vi.g(this.a.getPageActivity(), R.dimen.tbds704);
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = vi.g(this.a.getPageActivity(), R.dimen.tbds384);
                ((RelativeLayout.LayoutParams) this.U0.getLayoutParams()).topMargin = (vi.g(this.a.getPageActivity(), R.dimen.tbds226) + vi.u(this.a.getPageActivity())) - vi.g(this.a.getPageActivity(), R.dimen.tbds72);
            } else {
                g2 = vi.g(this.a.getPageActivity(), R.dimen.tbds600);
            }
            if (!z && !z2 && !this.x0) {
                g2 -= vi.g(this.a.getPageActivity(), R.dimen.tbds80);
            } else if (this.x0) {
                if (fr7.m(this.w1)) {
                    g2 = P1(z, z2);
                } else {
                    g2 = I1(z, z2);
                }
            }
            if (this.G0.getVisibility() == 0 || this.x1.getVisibility() == 0) {
                g2 += vi.g(this.a.getPageActivity(), R.dimen.tbds125);
            }
            ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
            if (layoutParams.height != g2) {
                layoutParams.height = g2;
                this.v.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.baidu.tieba.bs7
    public void I(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, onClickListener) == null) {
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
            this.f1.h(onClickListener);
        }
    }

    public final void L1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            int g2 = vi.g(this.a.getPageActivity(), R.dimen.tbds130);
            if (this.C0.getVisibility() != 0) {
                g2 -= vi.g(this.a.getPageActivity(), R.dimen.tbds32);
            }
            ((RelativeLayout.LayoutParams) this.q1.getLayoutParams()).topMargin = i2 - g2;
        }
    }

    public final int I1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int g2 = vi.g(this.a.getPageActivity(), R.dimen.tbds782);
            int q1 = q1(z, z2);
            L1(g2);
            int i2 = g2 + q1;
            this.x.setVisibility(0);
            this.h1.setVisibility(8);
            ((RelativeLayout.LayoutParams) this.x.getLayoutParams()).bottomMargin = q1;
            ((RelativeLayout.LayoutParams) this.y0.getLayoutParams()).bottomMargin = q1;
            if (q1 != 0) {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = vi.g(this.a.getPageActivity(), R.dimen.tbds782) - vi.g(this.a.getPageActivity(), R.dimen.tbds282);
            } else {
                ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = vi.g(this.a.getPageActivity(), R.dimen.tbds493);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void V1(FrsViewData frsViewData, k25 k25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048606, this, frsViewData, k25Var) == null) && this.x != null && k25Var != null) {
            if (frsViewData != null && frsViewData.getForum() != null && !TextUtils.isEmpty(frsViewData.getForum().getId()) && frsViewData.getActivityHeadData() != null && !TextUtils.isEmpty(frsViewData.getActivityHeadData().c())) {
                StatisticItem statisticItem = new StatisticItem("c13326");
                statisticItem.param("fid", frsViewData.getForum().getId());
                statisticItem.param("obj_id", frsViewData.getActivityHeadData().c());
                TiebaStatic.log(statisticItem);
                if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                    statisticItem.param("ab_tag", TbadkCoreApplication.getInst().getAdAdSense().k);
                }
                uq7.e(frsViewData, 1, this.b.getUniqueId());
            }
            this.x.N(k25Var.d(), 10, false);
            this.x.setOnClickListener(new c(this, k25Var, frsViewData));
        }
    }

    public final void X1(FrsViewData frsViewData, k25 k25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, frsViewData, k25Var) == null) {
            this.i1.setVisibility(0);
            Q1(null, -1);
            this.i1.N(k25Var.c(), 10, false);
            if (this.h1.getVisibility() != 0) {
                this.h1.setVisibility(0);
            }
            this.h1.setVideoPath(k25Var.h());
            this.h1.setVolume(0.0f, 0.0f);
            this.h1.setVideoScalingMode(0);
            this.h1.J(true);
            this.h1.setLooping(false);
            this.h1.setVideoStatusChangeListener(new o(this, k25Var, frsViewData));
            this.h1.getMediaProgressObserver().j(new p(this, k25Var));
            if (uq7.f()) {
                this.k1.setVisibility(8);
                FrsFragment frsFragment = this.b;
                if (frsFragment != null && !this.w1.isFromCache && (this.t1 || (!frsFragment.j4() && !this.b.i4() && !this.b.L3()))) {
                    this.h1.start();
                }
            } else {
                this.k1.setVisibility(0);
            }
            this.i1.setOnClickListener(new a(this, k25Var, frsViewData));
            this.h1.setOnClickListener(new b(this, k25Var, frsViewData));
            FrsFragment frsFragment2 = this.b;
            if (frsFragment2 != null) {
                uq7.e(frsViewData, 2, frsFragment2.getUniqueId());
            }
        }
    }

    public final int q1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        List<vn> list;
        List<px9> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048628, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z2) {
                ox9 ox9Var = this.w1.serviceAreaData;
                if (ox9Var != null && (list2 = ox9Var.b) != null && list2.size() == 1) {
                    i2 = 0 + vi.g(this.a.getPageActivity(), R.dimen.tbds83);
                } else {
                    i2 = 0 + vi.g(this.a.getPageActivity(), R.dimen.tbds84);
                }
            }
            if (z && (list = this.V0) != null) {
                i2 += Math.min(list.size(), 2) * vi.g(this.a.getPageActivity(), R.dimen.tbds83);
            }
            if (this.z.getVisibility() == 0) {
                i2 += vi.g(this.a.getPageActivity(), R.dimen.tbds231);
            }
            if (z2 || z || this.z.getVisibility() == 0) {
                return i2 + vi.g(this.a.getPageActivity(), R.dimen.tbds45);
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    @Override // com.baidu.tieba.bs7
    public void J(ForumData forumData, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, forumData, frsViewData) != null) || forumData == null) {
            return;
        }
        boolean z = true;
        this.u1 = true;
        if (fr7.m(this.w1)) {
            D1();
        }
        this.f1089T = forumData.getName();
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
        this.w1 = frsViewData;
        if (!StringUtils.isNull(this.U) && !StringUtils.isNull(this.f1089T)) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        FrsViewData frsViewData2 = this.w1;
        if (frsViewData2 != null && frsViewData2.getHotUserRankData() != null && this.w1.getHotUserRankData().hot_user != null && this.w1.getHotUserRankData().hot_user.size() >= 3) {
            this.y.setHasHotRankList(true);
        } else {
            this.y.setHasHotRankList(false);
        }
        int l2 = this.f1.l(LogicField.SERVICE_AREA);
        FrsViewData frsViewData3 = this.w1;
        if ((frsViewData3 == null || frsViewData3.serviceAreaData == null) && !this.y.a()) {
            z = false;
        }
        if (l2 == 0 && z) {
            this.y.setVisibility(0);
            this.D0.setVisibility(0);
            ServiceAreaView serviceAreaView = this.y;
            FrsViewData frsViewData4 = this.w1;
            serviceAreaView.setData(frsViewData4.serviceAreaData, frsViewData4);
        } else {
            this.y.setVisibility(8);
            this.D0.setVisibility(8);
        }
        this.X = new ThreadData();
        M1();
        C1();
        if (this.w1.getActivityHeadData() != null && this.w1.getActivityHeadData().a() != null) {
            ArrayList<k25> b2 = this.w1.getActivityHeadData().b();
            k25 k25Var = null;
            if (!ListUtils.isEmpty(b2)) {
                k25Var = b2.get(0);
            }
            this.N0 = un7.c(this.d, u1(k25Var));
            if (this.x0 && this.w1.getActivityHeadData().a().h) {
                this.N0.setVisibility(0);
            } else {
                this.N0.setVisibility(8);
            }
        }
        R1(forumData);
        if (frsViewData != null) {
            this.I = frsViewData.mSignActivityInfo;
            k1();
        }
        this.w1 = frsViewData;
        a2(frsViewData);
    }

    public final void S1(List<vn> list, tw9 tw9Var) {
        ForumData forumData;
        ForumData forumData2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048602, this, list, tw9Var) != null) || this.B == null) {
            return;
        }
        this.V0 = list;
        FrsViewData frsViewData = this.w1;
        if (frsViewData != null && frsViewData.getVoiceRoomData() != null && this.w1.getVoiceRoomData().a().size() > 0) {
            this.F.setVisibility(0);
            this.F.setPageContext(this.a);
            if (!ListUtils.isEmpty(this.w1.getVoiceRoomData().a())) {
                if (this.w1.getVoiceRoomData().a().size() > 5) {
                    this.F.setShowMore(true);
                } else {
                    this.F.setShowMore(false);
                }
            }
            this.F.a(this.w1.getVoiceRoomData());
        } else {
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null && frsVoiceRoomListLayout.getVisibility() == 0) {
                this.F.setVisibility(8);
            }
        }
        UserData userData = null;
        if (tw9Var != null) {
            this.A = new xf7(this.a.getPageActivity());
            this.z.setVisibility(0);
            this.z.addView(this.A.f());
            FrsViewData frsViewData2 = this.w1;
            if (frsViewData2 != null) {
                forumData2 = frsViewData2.getForum();
            } else {
                forumData2 = null;
            }
            xf7 xf7Var = this.A;
            FrsViewData frsViewData3 = this.w1;
            if (frsViewData3 != null && !frsViewData3.isFromCache) {
                z = false;
            } else {
                z = true;
            }
            xf7Var.e(forumData2, tw9Var, z);
            l1(tw9Var);
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
                this.F0.setVisibility(this.f1.l(LogicField.TOP_DIVIDER));
            }
        }
        FrsFragment frsFragment = this.b;
        if (frsFragment != null && frsFragment.m4()) {
            this.B.setVisibility(0);
            this.B.setFragmentUniqueId(this.b.getUniqueId());
            FrsViewData frsViewData4 = this.w1;
            if (frsViewData4 != null) {
                forumData = frsViewData4.getForum();
            } else {
                forumData = null;
            }
            FrsViewData frsViewData5 = this.w1;
            if (frsViewData5 != null) {
                userData = frsViewData5.getUserData();
            }
            this.B.setForum(this.U, this.f1089T, forumData, userData, this.b.getFrom());
            if (list.size() > 0 && (list.get(0) instanceof cx9)) {
                this.X0 = 0;
            } else if (list.size() > 1 && (list.get(1) instanceof cx9)) {
                this.X0 = 1;
            } else {
                this.X0 = -1;
            }
            this.B.setDatas(list, tw9Var);
            if (this.w0 == null) {
                this.w0 = new n(this);
            }
            this.B.setStatListener(this.w0);
            return;
        }
        this.B.setVisibility(8);
    }

    public final void N1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            TextView textView = this.m1;
            if (textView != null && textView.getVisibility() == 8) {
                this.m1.setVisibility(0);
            }
            TBLottieAnimationView tBLottieAnimationView = this.n1;
            if (tBLottieAnimationView != null) {
                if (tBLottieAnimationView.getVisibility() == 8 || this.n1.getVisibility() == 4) {
                    this.n1.setVisibility(0);
                    if (this.n1.isAnimating()) {
                        this.n1.cancelAnimation();
                    }
                    this.n1.setAnimation("frs_video_head_drag_hint_lottie.json");
                    this.n1.setRepeatCount(-1);
                    this.n1.playAnimation();
                }
            }
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            int l2 = vi.l(this.a.getPageActivity());
            int i2 = (l2 * 9) / 16;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i1.getLayoutParams();
            layoutParams.width = l2;
            layoutParams.height = i2;
            this.i1.setLayoutParams(layoutParams);
            this.i1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.j1.getLayoutParams();
            layoutParams2.width = l2;
            layoutParams2.height = i2;
            this.j1.setLayoutParams(layoutParams2);
        }
    }

    public final void W1() {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && (tBLottieAnimationView = this.l1) != null) {
            if (tBLottieAnimationView.getVisibility() == 8 || this.l1.getVisibility() == 4) {
                this.l1.setVisibility(0);
                if (this.l1.isAnimating()) {
                    this.l1.cancelAnimation();
                }
                this.l1.setAnimation(R.raw.lotti_video_loading);
                this.l1.setRepeatCount(-1);
                this.l1.playAnimation();
            }
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            boolean v1 = v1();
            boolean w1 = w1();
            if (!TextUtils.isEmpty(this.f1089T)) {
                eq7 c2 = dq7.d().c(this.f1089T);
                if (c2 == null) {
                    c2 = new eq7(this.A0, v1);
                } else {
                    c2.d(this.A0);
                    c2.e(v1);
                }
                dq7.d().e(this.f1089T, c2);
            }
            j1(v1, w1);
            h1(v1, w1);
        }
    }

    public final int P1(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int x1 = x1();
            O1();
            int q1 = q1(z, z2);
            this.r1.setVisibility(0);
            this.s1.setVisibility(0);
            int g2 = vi.g(this.a.getPageActivity(), R.dimen.tbds96);
            int i2 = q1 + x1 + g2;
            this.x.setVisibility(8);
            this.h1.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.t.getLayoutParams()).topMargin = (x1 - vi.g(this.a.getPageActivity(), R.dimen.tbds282)) + g2;
            L1(x1 + g2);
            return i2;
        }
        return invokeCommon.intValue;
    }

    public final void j1(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || this.b.T3() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B0.getLayoutParams();
        if (!z && !z2) {
            this.B0.setVisibility(0);
            this.D0.setVisibility(8);
            this.E0.setVisibility(this.f1.l(LogicField.BANNER_AND_BOTTOM_VIEW));
            layoutParams.topMargin = vi.g(this.a.getPageActivity(), R.dimen.tbds50);
        } else {
            this.B0.setVisibility(0);
            this.D0.setVisibility(this.f1.l(LogicField.SERVICE_AREA));
            layoutParams.topMargin = vi.g(this.a.getPageActivity(), R.dimen.tbds55);
        }
        this.b.T3().t(z, z2);
    }

    public final void Q1(k25 k25Var, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048600, this, k25Var, i2) == null) {
            if (i2 == -1) {
                b2 = uq7.c(this.w1);
            } else {
                b2 = uq7.b(k25Var, i2);
            }
            if (!StringUtils.isNull(b2)) {
                int b3 = zo8.b(b2);
                this.s1.setGradientColors(0, b3);
                this.r1.setBackgroundColor(b3);
            }
        }
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            FrsViewData frsViewData = this.w1;
            if (frsViewData == null) {
                return false;
            }
            k25 k25Var = null;
            if (frsViewData.getStar() != null && !StringUtils.isNull(frsViewData.getStar().a())) {
                k25Var = new k25();
                k25Var.q("");
                k25Var.p(frsViewData.getStar().a());
            } else if (frsViewData.getActivityHeadData() != null && ListUtils.getCount(frsViewData.getActivityHeadData().b()) >= 1) {
                k25Var = frsViewData.getActivityHeadData().b().get(0);
            }
            if (k25Var == null) {
                return false;
            }
            if (u1(k25Var)) {
                X1(frsViewData, k25Var);
            } else {
                V1(frsViewData, k25Var);
            }
            ThirdStatisticHelper.sendReq((String) ListUtils.getItem(k25Var.l(), 0));
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.bs7
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.w();
            Handler handler = this.c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            PopupWindow popupWindow = this.M;
            if (popupWindow != null && popupWindow.isShowing()) {
                this.M.dismiss();
            }
            p();
            xf7 xf7Var = this.A;
            if (xf7Var != null) {
                xf7Var.i();
            }
            CountDownTimer countDownTimer = this.d1;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.d1 = null;
            }
            this.K0.cancelAnimation();
            this.f1.onDestory();
            MessageManager.getInstance().unRegisterListener(this.A1);
            MessageManager.getInstance().unRegisterListener(this.B1);
            MessageManager.getInstance().unRegisterListener(this.C1);
            MessageManager.getInstance().unRegisterListener(this.D1);
            MessageManager.getInstance().unRegisterListener(this.E1);
        }
    }

    public final void Y1(String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.H = true;
            this.d1 = new f(this, j2, j3, str).start();
            if (this.Q != null && !j()) {
                this.Q.s(this.H, y1());
            }
        }
    }

    public final void Z1(FrsViewData frsViewData, FrsGameRankInfoData frsGameRankInfoData, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048612, this, frsViewData, frsGameRankInfoData, str) == null) && frsGameRankInfoData != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.itemInfo != null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("fid", frsViewData.getForum().getId());
            statisticItem.param("fname", frsViewData.getForum().getName());
            statisticItem.param("obj_id", frsViewData.itemInfo.id.intValue());
            statisticItem.param("obj_name", frsViewData.itemInfo.name);
            statisticItem.param("obj_param1", frsGameRankInfoData.rankName);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void a2(FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, frsViewData) == null) {
            if (frsViewData != null && frsViewData.getUserData() != null) {
                if (frsViewData.getUserData().getIs_manager() == 1 && frsViewData.getBaWuNoticeNum() > 0) {
                    this.v1.setVisibility(0);
                    this.v1.f(frsViewData.getBaWuNoticeNum());
                    return;
                }
                this.v1.setVisibility(8);
                return;
            }
            this.v1.setVisibility(8);
        }
    }

    public final int[] o1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
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

    public final void s1(l15 l15Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, l15Var) == null) && l15Var != null && l15Var.b() != 0.0f) {
            float d2 = l15Var.d() / ((l15Var.b() * 40.0f) / 70.0f);
            float d3 = l15Var.d() / l15Var.b();
            this.m1.setAlpha(d2);
            this.n1.setAlpha(d2);
            this.o1.setAlpha(1.0f - d2);
            float f2 = 1.0f - d3;
            this.p1.setAlpha(f2);
            this.j1.setAlpha(f2);
        }
    }

    public final void z1(FrsViewData frsViewData) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, frsViewData) == null) {
            if (frsViewData == null) {
                K1();
                return;
            }
            FrsBannerHeaderData frsBannerHeaderData = frsViewData.frsBannerHeaderData;
            if (frsBannerHeaderData == null) {
                K1();
                return;
            }
            this.x1.setData(frsBannerHeaderData);
            if (frsViewData.getForum() != null) {
                this.x1.setForumInfo(frsViewData.getForum().getId(), frsViewData.getForum().getName());
            }
            View view2 = this.E;
            if (this.y.getVisibility() == 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            view2.setVisibility(i2);
            this.C0.setVisibility(8);
            this.x1.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.bs7
    public void c(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i2) == null) {
            this.f1.onChangeSkinType(i2);
            d05 layoutMode = this.a.getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(this.d);
            this.a.getLayoutMode().k(this.K);
            this.a.getLayoutMode().k(this.m);
            SkinManager.setBackgroundResource(this.K, R.drawable.icon_frs_experience_number);
            SkinManager.setBackgroundResource(this.k, R.drawable.obfuscated_res_0x7f0806c0);
            o75 d2 = o75.d(this.C0);
            d2.n(1);
            d2.o(R.string.J_X14);
            d2.f(R.color.CAM_X0204);
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
            o75 d3 = o75.d(this.m1);
            d3.w(R.color.CAM_X0101);
            d3.B(R.dimen.T_X09);
            o75 d4 = o75.d(this.G);
            d4.C(R.string.F_X01);
            d4.w(R.color.CAM_X0101);
            o75 d5 = o75.d(this.G0);
            d5.n(1);
            d5.o(R.string.J_X07);
            d5.f(R.color.black_alpha40);
            o75 d6 = o75.d(this.I0);
            d6.C(R.string.F_X01);
            d6.w(R.color.CAM_X0101);
            WebPManager.setPureDrawable(this.J0, R.drawable.icon_pure_arrow12_right, R.color.CAM_X0618, null);
            FrsBannerHeaderView frsBannerHeaderView = this.x1;
            if (frsBannerHeaderView != null) {
                frsBannerHeaderView.g();
            }
            BarImageView barImageView = this.N;
            if (barImageView != null) {
                barImageView.setBorderWidth(vi.g(this.a.getPageActivity(), R.dimen.tbds1));
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
            FrsGroupChatSignGuideView frsGroupChatSignGuideView = this.y1;
            if (frsGroupChatSignGuideView != null) {
                frsGroupChatSignGuideView.c();
            }
            Iterator<TbImageView> it = this.v0.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
            Y();
            M(this.i0 ? 1 : 0);
            J1();
            A1(i2);
            h1(v1(), w1());
            ServiceAreaView serviceAreaView = this.y;
            if (serviceAreaView != null) {
                serviceAreaView.b(i2);
            }
            FrsTopView frsTopView = this.B;
            if (frsTopView != null) {
                frsTopView.h(i2);
            }
            xf7 xf7Var = this.A;
            if (xf7Var != null) {
                xf7Var.h(i2);
            }
            HotRankEntryView hotRankEntryView = this.U0;
            if (hotRankEntryView != null) {
                hotRankEntryView.b(i2);
            }
            FrsVoiceRoomListLayout frsVoiceRoomListLayout = this.F;
            if (frsVoiceRoomListLayout != null) {
                frsVoiceRoomListLayout.onChangeSkinType(this.a, i2);
            }
            cl7 cl7Var = this.n0;
            if (cl7Var != null) {
                cl7Var.h();
            }
            HeaderComponentNoHeaderController headerComponentNoHeaderController = this.z1;
            if (headerComponentNoHeaderController != null) {
                headerComponentNoHeaderController.g();
            }
        }
    }
}
