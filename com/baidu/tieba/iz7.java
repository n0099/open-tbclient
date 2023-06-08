package com.baidu.tieba;

import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.ala.LiveRoomClosedQueryMessage;
import com.baidu.tieba.cp9;
import com.baidu.tieba.e18;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.lw6;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.uz;
import com.baidu.tieba.w95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.Anti;
import tbclient.App;
import tbclient.BannerList;
import tbclient.BlockPopInfo;
import tbclient.DiscoverHotForum;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.UserFollowLive;
import tbclient.SimpleForum;
import tbclient.ThreadInfo;
import tbclient.Zan;
/* loaded from: classes6.dex */
public class iz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public z08 F;
    public BdUniqueId G;
    public SmartBubbleAnimatedView H;
    public HomePageYoungsterTopView I;
    public int J;
    public BdUniqueId K;
    public uz.a L;
    public ThreadInfo M;
    public cp9 N;
    public dz7 O;
    public PollingModel P;
    public tf5 Q;
    public RecyclerView.OnScrollListener R;
    public View.OnTouchListener S;

    /* renamed from: T  reason: collision with root package name */
    public lw6.b f1132T;
    public final cp9.b U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;
    public final CustomMessageListener Y;
    public final Runnable Z;
    public final long a;
    public CustomMessageListener a0;
    public final fz7 b;
    public CustomMessageListener b0;
    public q0 c;
    public CustomMessageListener c0;
    public final List<vn> d;
    public CustomMessageListener d0;
    public DataRes.Builder e;
    public String e0;
    public int f;
    public int f0;
    public boolean g;
    public Runnable g0;
    public boolean h;
    public hz7 h0;
    public int i;
    public CustomMessageListener i0;
    public final TbPageContext<?> j;
    public CustomMessageListener j0;
    public final BdTypeRecyclerView k;
    public CustomMessageListener k0;
    public final BigdaySwipeRefreshLayout l;
    public CustomMessageListener l0;
    public final PersonalizePageView m;
    public CustomMessageListener m0;
    public final o08 n;
    public CustomMessageListener n0;
    public int o;
    public ez7 o0;
    public ff7 p;
    public CustomMessageListener p0;
    public final b18 q;
    public final e18.c q0;
    public ay9 r;
    public jb r0;
    public ks5 s;
    public CustomMessageListener s0;
    public qw7 t;
    public CustomMessageListener t0;
    public lw6 u;
    public CustomMessageListener u0;
    public boolean v;
    public final jb v0;
    public si9 w;
    public CustomMessageListener w0;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes6.dex */
    public interface q0 {
        void a(boolean z);

        void b(int i, uv5 uv5Var, int i2);

        void c();

        void d(int i, int i2, uv5 uv5Var, int i3);

        void onError(int i, String str);
    }

    /* loaded from: classes6.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e0 a;

            public a(e0 e0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {e0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = e0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.n.l();
                    if (!this.a.a.z && this.a.a.A) {
                        this.a.a.w.n(this.a.a.x, this.a.a.y, this.a.a.v, true);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<vn> h = this.a.n.h();
                if (!ListUtils.isEmpty(h)) {
                    for (vn vnVar : h) {
                        if (vnVar instanceof wo6) {
                            wo6 wo6Var = (wo6) vnVar;
                            if (wo6Var.j != 0 && (threadData = wo6Var.a) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                wo6Var.j = imageWidthAndHeight[0];
                                wo6Var.k = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                wg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements mw5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ iz7 b;

        /* loaded from: classes6.dex */
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
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.m != null) {
                    this.a.b.m.C0();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements MessageQueue.IdleHandler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ h a;

            public b(h hVar) {
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

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    try {
                        if (this.a.b.m != null) {
                            this.a.b.m.C0();
                            return false;
                        }
                        return false;
                    } catch (Exception e) {
                        BdLog.e(e);
                        return false;
                    }
                }
                return invokeV.booleanValue;
            }
        }

        public h(iz7 iz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iz7Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mw5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                if (dataRes != null) {
                    h18.c().h(new a(this));
                }
                if (this.a && !h18.c().e()) {
                    Looper.myQueue().addIdleHandler(new b(this));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class q implements hz7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ q b;

            public a(q qVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {qVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = qVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.b.a.k.getHandler() == null) {
                    return;
                }
                this.b.a.k.requestFocusFromTouch();
                if (this.a > this.b.a.k.getCount() - 1) {
                    return;
                }
                this.b.a.k.setSelection(this.a);
            }
        }

        public q(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.hz7
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.g0 == null) {
                    this.a.g0 = new a(this, i);
                }
                this.a.k.removeCallbacks(this.a.g0);
                this.a.k.post(this.a.g0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements PollingModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public a(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tbadk.core.leveiconlivepolling.PollingModel.d
        public void onSuccess(List<AlaLiveInfo> list) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, list) == null) && this.a.k != null && this.a.q != null && this.a.n != null && this.a.P != null) {
                UserFollowLive.Builder builder = new UserFollowLive.Builder();
                builder._switch = 1;
                builder.user_follow_live = TbSingleton.getInstance().getLiveIndexSecondFloor();
                this.a.q.l(this.a.d, builder.build(true));
                this.a.n.z(this.a.d);
                if (this.a.w != null && this.a.A) {
                    this.a.w.n(this.a.x, this.a.y, this.a.v, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a0 implements ez7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public a0(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.ez7
        public void a(DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, builder) != null) {
                return;
            }
            this.a.L0(builder);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public b(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
                return (CustomResponsedMessage) invokeL.objValue;
            }
            ThreadCardViewHolder h0 = this.a.h0();
            if (h0 != null && h0.a() != null) {
                return new CustomResponsedMessage<>(2016323, Boolean.valueOf(h0.a().p(new uz.a(6))));
            }
            return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
        }
    }

    /* loaded from: classes6.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder h0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (h0 = this.a.h0()) != null && h0.a() != null) {
                    h0.a().p(new uz.a(3));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c0 implements e18.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        @Override // com.baidu.tieba.e18.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c0(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.e18.c
        public void a(x08 x08Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, x08Var) == null) && this.a.k != null && this.a.q != null && this.a.q.p(this.a.d, x08Var, this.a.k.getFirstVisiblePosition(), this.a.k.getLastVisiblePosition()) && this.a.O != null) {
                this.a.n.z(this.a.d);
                this.a.O.c();
                if (x08Var != null && !TextUtils.isEmpty(x08Var.a())) {
                    this.a.o0(x08Var.a());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public d(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d0 extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(iz7 iz7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            e48 e48Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof BlessHttpResponseMessage) {
                BlessHttpResponseMessage blessHttpResponseMessage = (BlessHttpResponseMessage) responsedMessage;
                j = blessHttpResponseMessage.userPkId;
                j2 = blessHttpResponseMessage.pkID;
            } else if (responsedMessage instanceof BlessSocketResponseMessage) {
                BlessSocketResponseMessage blessSocketResponseMessage = (BlessSocketResponseMessage) responsedMessage;
                j = blessSocketResponseMessage.userPkId;
                j2 = blessSocketResponseMessage.pkID;
            } else {
                j = 0;
                j2 = 0;
            }
            if (j2 == 0 && responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestBlessMessage)) {
                j2 = ((RequestBlessMessage) responsedMessage.getOrginalMessage().getExtra()).pk_id.longValue();
            }
            if (j2 == 0) {
                return;
            }
            for (vn vnVar : this.a.d) {
                if ((vnVar instanceof d48) && (e48Var = ((d48) vnVar).X) != null && j2 == e48Var.b) {
                    e48Var.c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public e(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.l == null) {
                return;
            }
            w95.i k0 = this.a.k0();
            if (this.a.l.u() && k0 != null && !PermissionUtil.isBrowseMode()) {
                this.a.l.z(k0);
            } else {
                this.a.l.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public f(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                if (this.a.e != null && this.a.e.thread_list != null && !this.a.q0()) {
                    i = this.a.e.thread_list.size();
                } else {
                    i = 0;
                }
                this.a.c.b(i, this.a.X(true), 0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921758) {
                if (customResponsedMessage.getData() == null) {
                    this.a.X0(null);
                } else if (customResponsedMessage.getData() instanceof qw7) {
                    this.a.X0((qw7) customResponsedMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g extends ix5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public g(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ix5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes a = h18.c().a();
                this.a.C0(a);
                return a;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public g0(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.u != null) {
                    this.a.u.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof u35)) {
                u35 u35Var = (u35) customResponsedMessage.getData();
                if (u35Var.a != 1) {
                    return;
                }
                int l = vi.l(TbadkCoreApplication.getInst());
                int j = vi.j(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.a.K);
                requestGetMyPostNetMessage.setParams(tg.g(u35Var.c, 0L), 0L, 0L, l, j, f, i);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i extends ix5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ iz7 b;

        public i(iz7 iz7Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iz7Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.ix5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                b55.d();
                try {
                    b55.c("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i0 extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(iz7 iz7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            GetMyPostResIdl getMyPostResIdl;
            tbclient.GetMyPost.DataRes dataRes;
            ThreadInfo threadInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) responsedMessage).getResponseData();
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    getMyPostResIdl = ((GetMyPostSocketResponseMessage) responsedMessage).getResponseData();
                } else {
                    getMyPostResIdl = null;
                }
                if (getMyPostResIdl != null && (dataRes = getMyPostResIdl.data) != null && (threadInfo = dataRes.thread_info) != null) {
                    this.a.M = threadInfo;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends ix5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ iz7 b;

        public j(iz7 iz7Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iz7Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.ix5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                b55.d();
                try {
                    b55.c("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && uf5.g(TbadkCoreApplication.getInst(), 1)) {
                iz7 iz7Var = this.a;
                iz7Var.Q = uf5.i(iz7Var.j, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, 0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public k(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.t.d(i) != 1 && this.a.p != null) {
                this.a.p.d();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k0 implements lw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        @Override // com.baidu.tieba.lw6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.lw6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public k0(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.lw6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.v = false;
            }
        }

        @Override // com.baidu.tieba.lw6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.v = true;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData) && this.a.e != null && ListUtils.getCount(this.a.e.thread_list) != 0 && (threadData = (ThreadData) customResponsedMessage.getData()) != null && threadData.getPraise() != null && threadData.getId() != null && ListUtils.getCount(this.a.e.thread_list) != 0) {
                for (int i = 0; i < this.a.e.thread_list.size(); i++) {
                    ThreadInfo threadInfo = this.a.e.thread_list.get(i);
                    if (threadInfo != null && threadInfo.id.longValue() == tg.g(threadData.getId(), -1L)) {
                        ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
                        Zan.Builder builder2 = new Zan.Builder(builder.zan);
                        builder2.num = Integer.valueOf((int) threadData.getPraise().getNum());
                        builder.zan = builder2.build(true);
                        this.a.e.thread_list.set(i, builder.build(true));
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l0 implements cp9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        @Override // com.baidu.tieba.cp9.b
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public l0(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        @Override // com.baidu.tieba.cp9.b
        public void a(fp9 fp9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, fp9Var) == null) && this.a.k != null && this.a.q != null) {
                this.a.q.r(this.a.d, fp9Var, this.a.k.getFirstVisiblePosition());
                this.a.n.z(this.a.d);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage.getOrginalMessage() instanceof LiveRoomClosedQueryMessage)) {
                return;
            }
            List<Long> ids = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getIds();
            List<Object> originData = ((LiveRoomClosedQueryMessage) customResponsedMessage.getOrginalMessage()).getOriginData();
            if (!ListUtils.isEmpty(this.a.d) && !ListUtils.isEmpty(ids) && !ListUtils.isEmpty(originData)) {
                for (int i = 0; i < originData.size(); i++) {
                    if ((originData.get(i) instanceof ThreadData) && (threadData = (ThreadData) originData.get(i)) != null && threadData.getThreadAlaInfo() != null && ids.contains(Long.valueOf(threadData.getThreadAlaInfo().live_id))) {
                        this.a.d.remove(threadData);
                    }
                }
                if (this.a.n != null) {
                    this.a.n.z(new ArrayList(this.a.d));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof no6)) {
                no6 no6Var = (no6) customResponsedMessage.getData();
                this.a.c1(no6Var.a(), no6Var.b());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.a.e != null && !ListUtils.isEmpty(this.a.e.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().c)) {
                    o18.b(this.a.e, updateAttentionMessage, this.a.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.k != null) {
                this.a.w.y();
                this.a.A = false;
                this.a.l.setRefreshing(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && this.a.e != null && this.a.e.hot_recomforum != null && !ListUtils.isEmpty(this.a.e.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.a.e.hot_recomforum);
                if (customResponsedMessage.getCmd() == 2001335) {
                    z = true;
                } else {
                    z = false;
                }
                if (!xu7.c(builder, longValue, z)) {
                    return;
                }
                this.a.e.hot_recomforum = builder.build(true);
                this.a.L0(new DataRes.Builder(this.a.e.build(true)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.k == null) {
                return;
            }
            this.a.e0();
        }
    }

    /* loaded from: classes6.dex */
    public class p extends ix5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ iz7 b;

        public p(iz7 iz7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = iz7Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.ix5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b55.d();
                we<String> f = b55.f(this.b.e0, TbadkCoreApplication.getCurrentAccount());
                if (f != null) {
                    f.e(this.b.e0, Integer.toString(this.a), com.heytap.mcssdk.constant.a.g);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Integer) {
                    ((Integer) data).intValue();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class r extends ix5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        public r(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ix5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                b55.d();
                we<String> f = b55.f(this.a.e0, TbadkCoreApplication.getCurrentAccount());
                if (f != null) {
                    return f.get(this.a.e0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class s implements mw5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz7 a;

        public s(iz7 iz7Var, hz7 hz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, hz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mw5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            hz7 hz7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (hz7Var = this.a) != null) {
                hz7Var.a(tg.e(str, 0));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F != null) {
                TbSingleton.getInstance().isAddBanner = false;
                this.a.d.remove(this.a.F);
                this.a.n.z(new ArrayList(this.a.d));
                n95.m().A("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f0(customResponsedMessage);
                if (this.a.w != null && this.a.A) {
                    this.a.w.n(this.a.x, this.a.y, this.a.v, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class v extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public final /* synthetic */ iz7 d;

        public v(iz7 iz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = iz7Var;
            this.a = -1;
            this.b = 0;
            this.c = false;
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.b > i) {
                    this.c = true;
                }
                this.b = i;
                int i3 = (i2 + i) - 1;
                if (!this.c && this.a != i3) {
                    this.a = i3;
                    this.d.G0(i3);
                }
                if (this.c && this.a != i) {
                    this.a = i;
                    this.d.G0(i);
                }
                this.d.f0 = i;
                this.d.x = i;
                this.d.y = i3;
                ThreadCardViewHolder h0 = this.d.h0();
                if (h0 != null && h0.a() != null) {
                    h0.a().p(this.d.L);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (this.d.s == null) {
                    this.d.s = new ks5();
                    this.d.s.a(1005);
                    this.d.s.e = 1;
                }
                if (i == 0) {
                    gz7.b(this.d.k);
                    this.d.s.e();
                    zn6.b().d(true);
                    d56.c().h("page_recommend", "show_");
                    lw9.g().h(this.d.G, false);
                    this.c = false;
                    if (this.d.w != null && this.d.A && !this.d.z) {
                        this.d.w.m(this.d.x, this.d.y, this.d.v, 1);
                        this.d.w.p(2);
                        this.d.w.q(true);
                        return;
                    }
                    return;
                }
                this.d.s.d();
                if (i == 1) {
                    if (this.d.p != null) {
                        this.d.p.d();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921418));
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, recyclerView, i, i2) == null) {
                int i4 = 0;
                if (recyclerView != null && (recyclerView instanceof BdRecyclerView)) {
                    BdRecyclerView bdRecyclerView = (BdRecyclerView) recyclerView;
                    i4 = bdRecyclerView.getFirstVisiblePosition();
                    i3 = bdRecyclerView.getLastVisiblePosition();
                } else {
                    i3 = 0;
                }
                a(i4, (i3 - i4) + 1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.f0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ iz7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.f = iz7Var;
            this.a = "";
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
                if (TextUtils.equals(jSONObject.optString("roomInfo"), "roomInfo")) {
                    this.a = jSONObject.optString("roomId", "");
                    this.b = jSONObject.optString("tid", "");
                    this.c = jSONObject.optString("fid", "");
                    this.d = jSONObject.optString("liveId", "");
                    this.e = jSONObject.optString("sid", "");
                } else if ((this.a != null && TextUtils.equals(jSONObject.optString("roomId"), this.a)) || ((this.d != null && TextUtils.equals(jSONObject.optString("liveId"), this.d)) || (this.e != null && TextUtils.equals(jSONObject.optString("sid"), this.e)))) {
                    try {
                        jSONObject.put("tid", this.b);
                        jSONObject.put("fid", this.c);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    this.f.f0(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.e != null && ListUtils.getCount(this.a.e.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                n18.a(str, this.a.d);
                n18.c(str, this.a.e, this.a.o0);
                if (this.a.n != null) {
                    this.a.n.z(new ArrayList(this.a.d));
                }
                if (this.a.w != null && this.a.A) {
                    this.a.w.n(this.a.x, this.a.y, this.a.v, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(iz7 iz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iz7Var, Integer.valueOf(i)};
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
            this.a = iz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                n18.b(this.a.d, this.a.e, this.a.o0, this.a.n);
            }
        }
    }

    public iz7(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, o08 o08Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout, PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, o08Var, bigdaySwipeRefreshLayout, personalizePageView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = new LinkedList();
        this.f = 1;
        this.g = false;
        this.h = false;
        this.i = 0;
        this.o = 2000;
        this.s = null;
        this.v = false;
        this.x = 0;
        this.y = 0;
        this.z = false;
        this.A = true;
        this.B = false;
        this.E = false;
        this.J = 0;
        this.K = BdUniqueId.gen();
        this.L = new uz.a(2);
        this.M = null;
        this.R = new v(this);
        this.S = new g0(this);
        this.f1132T = new k0(this);
        this.U = new l0(this);
        this.V = new m0(this, 2921806);
        this.W = new n0(this, 2001399);
        this.X = new o0(this, 2921461);
        this.Y = new p0(this, 2921486);
        this.Z = new c(this);
        this.a0 = new l(this, 2004004);
        this.b0 = new m(this, 2921026);
        this.c0 = new n(this, 2001115);
        this.d0 = new o(this, 0);
        this.e0 = "lastReadReadPositionKey";
        this.f0 = 0;
        this.h0 = new q(this);
        this.i0 = new t(this, 2016569);
        this.j0 = new u(this, 2016488);
        this.k0 = new w(this, 2016553);
        this.l0 = new x(this, 2921547);
        this.m0 = new y(this, 2016331);
        this.n0 = new z(this, 2921746);
        this.o0 = new a0(this);
        this.p0 = new b0(this, 2921381);
        this.q0 = new c0(this);
        this.r0 = new d0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.s0 = new e0(this, 2921414);
        this.t0 = new f0(this, 2921758);
        this.u0 = new h0(this, 2921453);
        this.v0 = new i0(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.w0 = new j0(this, 2921482);
        this.j = tbPageContext;
        this.J = n95.m().n("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.m = personalizePageView;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.S);
        lw6 lw6Var = new lw6();
        this.u = lw6Var;
        lw6Var.d(this.f1132T);
        this.n = o08Var;
        this.q = new b18();
        this.a = n95.m().o("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.R);
        this.p = new ff7();
        p0();
        si9 si9Var = new si9(this.j, this.k);
        this.w = si9Var;
        si9Var.p(2);
        this.w.w(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.b = new fz7(this.d, this.n);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.H = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, vi.g(tbPageContext.getContext(), R.dimen.tbds83)));
        P0();
        this.s0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.s0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.v0.setTag(this.K);
        if (this.v0.getHttpMessageListener() != null) {
            this.v0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.v0.getSocketMessageListener() != null) {
            this.v0.getSocketMessageListener().setSelfListener(true);
        }
        PollingModel pollingModel = new PollingModel(this.n.i(), this.K);
        this.P = pollingModel;
        pollingModel.M0(y55.d);
        this.P.Q0(new a(this));
        MessageManager.getInstance().registerListener(this.v0);
        MessageManager.getInstance().registerListener(this.u0);
        MessageManager.getInstance().registerListener(this.w0);
        MessageManager.getInstance().registerListener(this.t0);
    }

    public final void C0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataRes) == null) {
            this.h = true;
            if (dataRes != null) {
                K0(false, true, true, dataRes);
                q0 q0Var = this.c;
                if (q0Var != null) {
                    q0Var.a(true);
                    z0();
                    return;
                }
                return;
            }
            x0();
        }
    }

    public void D0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.H;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i2);
            }
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null) {
                homePageYoungsterTopView.b();
            }
            tf5 tf5Var = this.Q;
            if (tf5Var != null) {
                tf5Var.w();
            }
        }
    }

    public void I0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z2) == null) && z2) {
            this.n.l();
        }
    }

    public final void L0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, builder) == null) {
            mx5.b(new j(this, builder), null);
        }
    }

    public void T0(dz7 dz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dz7Var) == null) {
            this.O = dz7Var;
            if (dz7Var != null) {
                dz7Var.e(this.d);
                this.O.b().p(this.q0);
            }
        }
    }

    public final void U0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z2) == null) {
            this.g = z2;
        }
    }

    public void V0(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, q0Var) == null) {
            this.c = q0Var;
        }
    }

    public void W0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z2) == null) {
            this.A = z2;
        }
    }

    public final uv5 X(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z2)) == null) {
            String e2 = ml9.e(this.d, z2);
            int Z = Z(z2);
            uv5 uv5Var = new uv5();
            uv5Var.b = e2;
            uv5Var.a = Z;
            return uv5Var;
        }
        return (uv5) invokeZ.objValue;
    }

    public void X0(qw7 qw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, qw7Var) == null) {
            this.t = qw7Var;
            if (qw7Var == null) {
                return;
            }
            qw7Var.setOnTabSelectedListener(new k(this));
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            mx5.b(new p(this, i2), null);
        }
    }

    public void Y0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z2) == null) {
            this.z = z2;
        }
    }

    public final void b0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public final void c0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public void g0(hz7 hz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, hz7Var) == null) {
            mx5.b(new r(this), new s(this, hz7Var));
        }
    }

    public final void o0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_HOMEPAGE_REC_FORUM_CARD_SHOW);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void w0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z2) == null) {
            this.h = true;
            mx5.b(new g(this), new h(this, z2));
        }
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            n95.m().w(i0(), false);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            gz7.b(this.k);
            Y(this.f0);
            ks5 ks5Var = this.s;
            if (ks5Var != null) {
                ks5Var.c();
            }
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            gz7.c(this.k);
        }
    }

    public si9 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.w;
        }
        return (si9) invokeV.objValue;
    }

    public cp9 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.N;
        }
        return (cp9) invokeV.objValue;
    }

    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            ay9 ay9Var = new ay9("new_index", null);
            this.r = ay9Var;
            ay9Var.d();
        }
    }

    public final boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return r0(true);
        }
        return invokeV.booleanValue;
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return n95.m().i(i0(), true);
        }
        return invokeV.booleanValue;
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            update(false);
        }
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            g0(this.h0);
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            h18.c().b(new f(this));
        }
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            ss5.b().q(System.currentTimeMillis() - ss5.b().c());
        }
    }

    public void B0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.z = z2;
            qw7 qw7Var = this.t;
            if (qw7Var != null) {
                qw7Var.f(z2);
            }
            si9 si9Var = this.w;
            if (si9Var == null) {
                return;
            }
            si9Var.r(!z2);
            ThreadCardViewHolder h02 = h0();
            boolean z3 = false;
            if (h02 != null && h02.a() != null) {
                z3 = h02.a().p(new uz.a(8, Boolean.valueOf(z2)));
            }
            if (!z3) {
                if (z2) {
                    this.w.y();
                } else if (this.A) {
                    this.w.n(this.x, this.y, this.v, true);
                }
            }
            if (!z2) {
                if (this.N == null) {
                    cp9 cp9Var = new cp9();
                    this.N = cp9Var;
                    cp9Var.h(this.U);
                }
                this.N.g();
            }
            tf5 tf5Var = this.Q;
            if (tf5Var != null) {
                tf5Var.q();
            }
        }
    }

    public int Z(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z2)) == null) {
            List<vn> list = this.d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.d.size()) {
                    vn vnVar = (vn) yo8.d(this.d, i4);
                    if ((vnVar instanceof oo6) && (i3 = ((oo6) vnVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((vnVar instanceof r08) && vnVar.getType() != AdvertAppInfo.y) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    vn vnVar2 = (vn) yo8.d(this.d, size);
                    if ((vnVar2 instanceof oo6) && (i2 = ((oo6) vnVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((vnVar2 instanceof r08) && vnVar2.getType() != AdvertAppInfo.y) {
                        return i4;
                    }
                }
            }
            return this.d.size();
        }
        return invokeZ.intValue;
    }

    public void update(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z2) == null) {
            ow7.d().j(System.currentTimeMillis(), 1);
            this.f = 1;
            this.E = true;
            cp9 cp9Var = this.N;
            if (cp9Var != null) {
                cp9Var.e();
            }
            this.P.C0("live,level,icon,festival_info,live_follow_second_floor,member_broadcast,activity_broadcast,live_index_second_floor");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            wg.a().postDelayed(this.Z, 300000L);
            if (this.d.size() == 0 && !s0()) {
                if (!this.h) {
                    w0(z2);
                    return;
                } else {
                    x0();
                    return;
                }
            }
            x0();
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            si9 si9Var = this.w;
            if (si9Var != null) {
                si9Var.h();
            }
            ff7 ff7Var = this.p;
            if (ff7Var != null) {
                ff7Var.e();
            }
            fz7 fz7Var = this.b;
            if (fz7Var != null) {
                fz7Var.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.g0);
            }
            PollingModel pollingModel = this.P;
            if (pollingModel != null) {
                pollingModel.onDestroy();
            }
            if (this.Z != null) {
                wg.a().removeCallbacks(this.Z);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.t0);
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            si9 si9Var = this.w;
            if (si9Var != null && !this.z && this.A) {
                si9Var.n(this.x, this.y, this.v, true);
            }
            if (!this.B) {
                return;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
            if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                boolean z2 = this.C;
                if (z2) {
                    lw9.g().h(this.G, false);
                    if (r0(false)) {
                        a1(3, this.i);
                    } else if (this.D > 0) {
                        a1(2, this.i);
                    }
                } else if (!z2 && this.i == 0) {
                    a1(2, 0);
                }
            }
            this.B = false;
            this.C = false;
            this.D = 0;
            if (this.E) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.E = false;
            cp9 cp9Var = this.N;
            if (cp9Var != null) {
                cp9Var.d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void F0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        DataRes.Builder builder;
        int i3;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) == null) {
            DataRes dataRes2 = dataRes;
            if (z2) {
                kz7.a();
            }
            b18 b18Var = this.q;
            if (b18Var != null && b18Var.s() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
                if (dataRes2 == null) {
                    DataRes.Builder builder2 = new DataRes.Builder();
                    builder2.thread_list = new ArrayList();
                    dataRes2 = builder2.build(false);
                }
                if (dataRes2.thread_list != null) {
                    List<ThreadInfo> f2 = this.q.f();
                    dataRes2.thread_list.addAll(f2);
                    if (f2 != null) {
                        f2.clear();
                    }
                    z4 = true;
                    builder = this.e;
                    if (builder == null && (list = builder.thread_list) != null) {
                        i3 = list.size();
                    } else {
                        i3 = 0;
                    }
                    if (z2 && i2 == 0 && dataRes2 != null && ListUtils.isEmpty(dataRes2.thread_list)) {
                        q0 q0Var = this.c;
                        if (q0Var != null) {
                            q0Var.c();
                        }
                        U0(false);
                        ah.e(new d(this));
                        return;
                    }
                    if (this.M != null) {
                        DataRes.Builder builder3 = new DataRes.Builder(dataRes2);
                        builder3.thread_list.add(0, this.M);
                        dataRes2 = builder3.build(false);
                        DataRes.Builder builder4 = this.e;
                        if (builder4 != null && !ListUtils.isEmpty(builder4.thread_list)) {
                            Iterator<ThreadInfo> it = this.e.thread_list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ThreadInfo next = it.next();
                                if (next != null && (l2 = next.tid) != null && this.M.tid != null && l2.longValue() == this.M.tid.longValue()) {
                                    this.e.thread_list.remove(next);
                                    break;
                                }
                            }
                        }
                        this.M = null;
                    }
                    if ((!z4 || i2 == 0) && dataRes2 != null && K0(true, z2, z3, dataRes2)) {
                        A0();
                        if (this.c != null) {
                            n95 m2 = n95.m();
                            m2.A("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            this.c.a(false);
                        }
                        this.B = true;
                        this.C = z2;
                        this.D = i3;
                        b1();
                    } else {
                        this.B = false;
                        if (this.d.size() > 0) {
                            q0 q0Var2 = this.c;
                            if (q0Var2 != null) {
                                q0Var2.onError(1, str);
                            }
                        } else {
                            q0 q0Var3 = this.c;
                            if (q0Var3 != null) {
                                q0Var3.onError(2, str);
                            }
                        }
                    }
                    U0(false);
                    ah.e(new e(this));
                }
            }
            z4 = false;
            builder = this.e;
            if (builder == null) {
            }
            i3 = 0;
            if (z2) {
            }
            if (this.M != null) {
            }
            if (!z4) {
            }
            A0();
            if (this.c != null) {
            }
            this.B = true;
            this.C = z2;
            this.D = i3;
            b1();
            U0(false);
            ah.e(new e(this));
        }
    }

    public void G0(int i2) {
        int i3;
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            ay9 ay9Var = this.r;
            if (ay9Var != null) {
                i3 = ay9Var.b(i2);
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.r.c(i2);
            }
        }
    }

    public final List<Integer> j0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                vn item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof y08) {
                    y08 y08Var = (y08) item;
                    if (!z2) {
                        i2 = i4;
                    }
                    z2 = true;
                    i3 = i4;
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (ListUtils.getCount(this.d) < this.q.h() - 40) {
                return;
            }
            List<vn> list = null;
            d18 e2 = this.q.e(true, this.e, null, 1);
            int i2 = 0;
            if (e2 != null) {
                list = e2.a;
                int i3 = e2.c;
                e2.c = 0;
                i2 = i3;
            }
            if (list != null) {
                this.d.clear();
                this.d.addAll(list);
                this.n.A(new LinkedList(this.d), i2);
            }
        }
    }

    public final void R0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || (builder = this.e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        int i2 = 0;
        if (list != null && list.size() > 50) {
            builder2.thread_list = builder2.thread_list.subList(0, 50);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        if (list2 != null) {
            i2 = list2.size();
        }
        a0(builder2, i2);
        mx5.b(new i(this, builder2), null);
    }

    public final void b1() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048609, this) != null) || (builder = this.e) == null) {
            return;
        }
        DataRes.Builder builder2 = new DataRes.Builder(builder.build(true));
        List<ThreadInfo> list = builder2.thread_list;
        int i2 = 0;
        if (list != null && list.size() > 30) {
            builder2.thread_list = builder2.thread_list.subList(0, 30);
        }
        List<ThreadInfo> list2 = builder2.thread_list;
        if (list2 != null) {
            i2 = list2.size();
        }
        a0(builder2, i2);
        b0(builder2);
        c0(builder2);
        L0(builder2);
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            Iterator<vn> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof y08) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            b1();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> j02 = j0(bdTypeRecyclerView);
                int intValue = j02.get(0).intValue();
                int intValue2 = j02.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.k.removeItemList(intValue, intValue2);
                }
            }
        }
    }

    public void y0() {
        int i2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            if (t0()) {
                ow7.d().j(0L, 1);
            } else if (this.c != null) {
                J0();
                this.f++;
                U0(true);
                DataRes.Builder builder = this.e;
                if (builder != null && (list = builder.thread_list) != null) {
                    i2 = list.size();
                } else {
                    i2 = 0;
                }
                this.c.d(this.f, i2, X(false), 0);
            }
        }
    }

    public final boolean K0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        int size;
        List<vn> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.J == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || q0())) {
                    R0();
                    this.e = null;
                }
            } else if (z3 && q0()) {
                this.e = null;
            }
            if (z3) {
                size = 0;
            } else {
                size = this.d.size();
            }
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.d.clear();
            if (z2 && h66.i().o(AbsDataRecorder.Scene.RECOMMEND)) {
                h66.i().g(AbsDataRecorder.Scene.RECOMMEND).b();
            }
            d18 e2 = this.q.e(z2, this.e, builder, !z3 ? 1 : 0);
            if (e2 != null) {
                list = e2.a;
                this.i = e2.b;
                i2 = e2.c;
                e2.c = 0;
            } else {
                list = null;
                i2 = 0;
            }
            if (list != null) {
                this.d.addAll(list);
                W(list, size);
                Q0(!z3 ? 1 : 0, list, size);
                if (this.E) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.e == null) {
                this.e = builder;
                this.b.j(builder.thread_list);
            }
            if (this.d.size() != 0) {
                if (z2 && o56.k().l(AbsDataRecorder.Scene.RECOMMEND)) {
                    o56.k().g(AbsDataRecorder.Scene.RECOMMEND).b();
                }
                if (z3) {
                    if (dataRes.live_answer != null) {
                        z08 z08Var = new z08();
                        this.F = z08Var;
                        z08Var.c(dataRes.live_answer);
                        this.e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.F = null;
                        this.e.live_answer = null;
                    }
                    this.e.float_info = dataRes.float_info;
                }
                long o2 = n95.m().o("key_maintab_banner_close_time", 0L);
                if (this.F != null && !StringHelper.isTaday(o2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.d.add(0, this.F);
                }
                LinkedList linkedList = new LinkedList(this.d);
                o08 o08Var = this.n;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                o08Var.t(z5);
                this.n.A(linkedList, i2);
                si9 si9Var = this.w;
                if (si9Var != null && this.A) {
                    si9Var.n(this.x, this.y, this.v, true);
                }
                z5 = true;
            }
            ow7.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e3 = ow7.d().e(1);
            int i3 = (e3 > 0L ? 1 : (e3 == 0L ? 0 : -1));
            if (i3 > 0) {
                ow7.d().k(System.currentTimeMillis() - e3, 1);
                ow7.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                r5a.h(blockPopInfo);
            }
            w35 w35Var = new w35();
            w35Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, w35Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                ss5.b().D(System.currentTimeMillis() - e3);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public void M0(int i2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) && !ListUtils.isEmpty(this.d) && this.d.size() > i2 && i2 >= 0 && i2 >= 0 && i3 >= 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i2 < this.d.size() && i2 <= i3) {
                if (this.d.get(i2).getType().getId() == ThreadData.TYPE_VIDEO_ALA_ONLIVE.getId() && (threadData = (ThreadData) this.d.get(i2)) != null && threadData.getThreadAlaInfo() != null) {
                    arrayList.add(Long.valueOf(threadData.getThreadAlaInfo().live_id));
                    arrayList2.add(threadData);
                }
                i2++;
            }
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new LiveRoomClosedQueryMessage(arrayList, arrayList2));
        }
    }

    public void O0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.G = bdUniqueId;
        CustomMessageListener customMessageListener = this.a0;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.a0);
        }
        CustomMessageListener customMessageListener2 = this.W;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.W);
        }
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        this.c0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.c0);
        this.d0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.d0);
        MessageManager.getInstance().registerListener(2001336, this.d0);
        this.b0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.b0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        this.k0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k0);
        this.l0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l0);
        this.m0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.m0);
        this.n0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.n0);
        si9 si9Var = this.w;
        if (si9Var != null) {
            si9Var.u(bdUniqueId);
        }
        this.b.i(bdUniqueId);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.p0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.p0);
        this.r0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.r0);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
        this.V.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.V);
    }

    public void Q0(int i2, List<vn> list, int i3) {
        ay9 ay9Var;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) != null) || (ay9Var = this.r) == null) {
            return;
        }
        if (i2 == 0) {
            ay9Var.d();
        }
        if (list != null && !list.isEmpty()) {
            int[] iArr = ay9.e;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
                if ((list.get(i7) instanceof oo6) && (i6 = i6 + 1) == i4 - 1) {
                    int i8 = i7 + 1;
                    if (i3 < i8) {
                        this.r.a(i4, i8);
                    }
                    i5++;
                }
            }
        }
    }

    public final void W(List<vn> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, list, i2) == null) {
            Set<vn> a2 = ml9.a(list, this.f, "HOME");
            if (a2.size() > 0) {
                lw9.g().c(this.G, jw9.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
                String currentDay = UtilHelper.getCurrentDay();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    String str = "";
                    String s2 = n95.m().s("activity_prize_feed_text_time", "");
                    boolean z2 = true;
                    if (!StringUtils.isNull(s2)) {
                        String[] split = s2.split("@");
                        if (split != null && split.length == 2) {
                            String str2 = split[0];
                            String[] split2 = split[1].split(",");
                            if (!StringUtils.isNull(str2) && split2.length != 0) {
                                if (str2.equals(currentDay)) {
                                    List<String> asList = Arrays.asList(split2);
                                    if (!asList.contains(currentAccount)) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(currentDay);
                                        sb.append("@");
                                        for (String str3 : asList) {
                                            sb.append(str3);
                                            sb.append(",");
                                        }
                                        sb.append(currentAccount);
                                        str = sb.toString();
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    str = currentDay + "@" + currentAccount;
                                }
                            } else {
                                str = currentDay + "@" + currentAccount;
                            }
                        } else {
                            str = currentDay + "@" + currentAccount;
                        }
                    } else {
                        str = currentDay + "@" + currentAccount;
                    }
                    if (z2) {
                        a1(4, 0);
                        n95.m().B("activity_prize_feed_text_time", str);
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final w95.i k0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        qw7 qw7Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!this.B || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || u0()) {
                return null;
            }
            int i2 = this.i;
            boolean z2 = this.C;
            if (z2) {
                lw9.g().h(this.G, false);
                if (r0(false)) {
                    c2 = 3;
                } else if (this.D <= 0) {
                    c2 = 0;
                }
                if (this.t != null) {
                    this.p.f();
                }
                qw7Var = this.t;
                if (qw7Var == null && qw7Var.getCurrentTabType() != 1) {
                    this.p.d();
                    return null;
                }
                if (c2 != 2) {
                    if (i2 > 0) {
                        str = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i2));
                    } else {
                        str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
                    }
                } else if (c2 == 3) {
                    str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
                } else if (c2 == 4) {
                    str = TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText();
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str) && BdNetTypeUtil.isNetWorkAvailable()) {
                    if (c2 == 4) {
                        this.o = 1000;
                    } else {
                        this.o = 0;
                    }
                    return new w95.i(str, this.o);
                }
            } else if (z2 || i2 != 0) {
                return null;
            } else {
                i2 = 0;
            }
            c2 = 2;
            if (this.t != null) {
            }
            qw7Var = this.t;
            if (qw7Var == null) {
            }
            if (c2 != 2) {
            }
            return TextUtils.isEmpty(str) ? null : null;
        }
        return (w95.i) invokeV.objValue;
    }

    public final void a0(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048606, this, builder, i2) != null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = nl9.b(next);
                if (b2 < 0) {
                    it.remove();
                } else if (b2 < i2 + i3 + 1) {
                    i3++;
                } else {
                    it.remove();
                }
            } else {
                it.remove();
            }
        }
        builder.banner_list = builder2.build(false);
    }

    public final List<Integer> n0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                vn item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof oo6) {
                    oo6 oo6Var = (oo6) item;
                    if (oo6Var.getThreadData() != null && oo6Var.getThreadData().getTid().equals(str)) {
                        if (!z2) {
                            i2 = i4;
                        }
                        z2 = true;
                        i3 = i4;
                    }
                }
            }
            arrayList.add(Integer.valueOf(i2));
            arrayList.add(Integer.valueOf(i3));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public final void a1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048607, this, i2, i3) != null) || u0()) {
            return;
        }
        if (this.t != null) {
            this.p.f();
        }
        qw7 qw7Var = this.t;
        if (qw7Var != null && qw7Var.getCurrentTabType() != 1) {
            this.p.d();
            return;
        }
        String str = null;
        if (i2 == 2) {
            if (i3 > 0) {
                str = String.format(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_return), Integer.valueOf(i3));
            } else {
                str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_nodata);
            }
        } else if (i2 == 3) {
            str = TbadkCoreApplication.getInst().getString(R.string.recommend_frs_refresh_cache_invalid);
        } else if (i2 == 4) {
            str = TbadkCoreApplication.getInst().getActivityPrizeData().getFeedText();
        }
        if (TextUtils.isEmpty(str) || !BdNetTypeUtil.isNetWorkAvailable()) {
            return;
        }
        if (i2 == 4) {
            this.o = 3000;
        } else {
            this.o = 2000;
        }
        SmartBubbleAnimatedView smartBubbleAnimatedView = this.H;
        smartBubbleAnimatedView.a = str;
        smartBubbleAnimatedView.b = this.o;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        qw7 qw7Var2 = this.t;
        if (qw7Var2 != null) {
            FrameLayout frameLayout = qw7Var2.getFrameLayout();
            frameLayout.removeView(this.H);
            frameLayout.addView(this.H, layoutParams);
            this.H.g();
        }
    }

    public final void c1(long j2, boolean z2) {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z2)}) == null) && (builder = this.e) != null && !ListUtils.isEmpty(builder.thread_list) && !ListUtils.isEmpty(this.d)) {
            for (vn vnVar : this.d) {
                if (vnVar instanceof oo6) {
                    oo6 oo6Var = (oo6) vnVar;
                    if (oo6Var.n && j2 == oo6Var.getThreadData().getFid() && z2 != oo6Var.getThreadData().getForumData().f()) {
                        oo6Var.getThreadData().getForumData().n(z2);
                    }
                }
            }
            b18 b18Var = this.q;
            if (b18Var != null) {
                b18Var.C(j2, z2);
            }
            boolean z3 = false;
            for (int i2 = 0; i2 < this.e.thread_list.size(); i2++) {
                ThreadInfo threadInfo = this.e.thread_list.get(i2);
                if (threadInfo != null && threadInfo.forum_info != null && j2 == threadInfo.fid.longValue() && z2 != threadInfo.forum_info.is_liked.intValue()) {
                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                    SimpleForum.Builder builder3 = new SimpleForum.Builder(builder2.forum_info);
                    builder3.is_liked = Integer.valueOf(z2 ? 1 : 0);
                    builder2.forum_info = builder3.build(true);
                    this.e.thread_list.set(i2, builder2.build(true));
                    z3 = true;
                }
            }
            if (z3) {
                b1();
            }
        }
    }

    public void d0(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, l2) == null) && (builder = this.e) != null && (list = builder.thread_list) != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                    builder2.top_agree_post = null;
                    list.set(i2, builder2.build(true));
                    b1();
                    K0(false, true, false, this.e.build(true));
                    return;
                }
            }
        }
    }

    public final boolean r0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048626, this, z2)) == null) {
            n95 m2 = n95.m();
            long o2 = m2.o("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            if (o2 != 0) {
                if (Math.abs(System.currentTimeMillis() - o2) > this.a) {
                    return true;
                }
                return false;
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public final void f0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048614, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (builder = this.e) != null && ListUtils.getCount(builder.thread_list) != 0 && ListUtils.getCount(this.d) != 0) {
            JSONObject jSONObject = (JSONObject) customResponsedMessage.getData();
            String optString = jSONObject.optString("tid");
            if (StringUtils.isNull(optString)) {
                String optString2 = jSONObject.optString("liveid");
                if (this.k != null && !TextUtils.isEmpty(optString2)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= this.k.getCount()) {
                            break;
                        }
                        vn item = this.k.getItem(i2);
                        if (item instanceof vo6) {
                            vo6 vo6Var = (vo6) item;
                            if (vo6Var.getThreadData() != null && vo6Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(vo6Var.getThreadData().getThreadAlaInfo().live_id))) {
                                optString = vo6Var.getThreadData().getTid();
                                break;
                            }
                        }
                        i2++;
                    }
                    if (StringUtils.isNull(optString)) {
                        return;
                    }
                } else {
                    return;
                }
            }
            Iterator<vn> it = this.d.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                vn next = it.next();
                if (next instanceof oo6) {
                    oo6 oo6Var = (oo6) next;
                    if (oo6Var.getThreadData() != null && oo6Var.getThreadData().getTid() != null) {
                        if (oo6Var.getThreadData().getTid().equals(optString)) {
                            it.remove();
                            z2 = true;
                        } else if (z2) {
                            c18.b(this.d);
                            break;
                        }
                    }
                }
            }
            DataRes.Builder builder2 = this.e;
            if (builder2 != null && builder2.thread_list != null) {
                long g2 = tg.g(optString, 0L);
                int i3 = 0;
                while (true) {
                    if (i3 < this.e.thread_list.size()) {
                        ThreadInfo threadInfo = this.e.thread_list.get(i3);
                        if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                            k18.d(threadInfo.tid.longValue(), i3, this.e.thread_list, this.d);
                            this.e.thread_list.remove(i3);
                            b1();
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                BdTypeRecyclerView bdTypeRecyclerView = this.k;
                if (bdTypeRecyclerView != null) {
                    List<Integer> n02 = n0(optString, bdTypeRecyclerView);
                    int intValue = n02.get(0).intValue();
                    int intValue2 = n02.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.k.removeItemList(intValue, intValue2);
                    }
                }
            }
        }
    }

    public final ThreadCardViewHolder h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            si9 si9Var = this.w;
            if (si9Var != null && si9Var.j() != null && (this.w.j().getTag() instanceof ThreadCardViewHolder)) {
                return (ThreadCardViewHolder) this.w.j().getTag();
            }
            return null;
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }
}
