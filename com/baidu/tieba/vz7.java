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
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.qw6;
import com.baidu.tieba.r18;
import com.baidu.tieba.uq9;
import com.baidu.tieba.vz;
import com.baidu.tieba.x95;
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
/* loaded from: classes8.dex */
public class vz7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public m18 F;
    public BdUniqueId G;
    public SmartBubbleAnimatedView H;
    public HomePageYoungsterTopView I;
    public int J;
    public BdUniqueId K;
    public vz.a L;
    public ThreadInfo M;
    public uq9 N;
    public qz7 O;
    public PollingModel P;
    public yf5 Q;
    public RecyclerView.OnScrollListener R;
    public View.OnTouchListener S;

    /* renamed from: T  reason: collision with root package name */
    public qw6.b f1185T;
    public final uq9.b U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;
    public final CustomMessageListener Y;
    public final Runnable Z;
    public final long a;
    public CustomMessageListener a0;
    public final sz7 b;
    public CustomMessageListener b0;
    public q0 c;
    public CustomMessageListener c0;
    public final List<wn> d;
    public CustomMessageListener d0;
    public DataRes.Builder e;
    public String e0;
    public int f;
    public int f0;
    public boolean g;
    public Runnable g0;
    public boolean h;
    public uz7 h0;
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
    public final b18 n;
    public CustomMessageListener n0;
    public int o;
    public rz7 o0;
    public kf7 p;
    public CustomMessageListener p0;
    public final o18 q;
    public final r18.c q0;
    public sz9 r;
    public jb r0;
    public ps5 s;
    public CustomMessageListener s0;
    public dx7 t;
    public CustomMessageListener t0;
    public qw6 u;
    public CustomMessageListener u0;
    public boolean v;
    public final jb v0;
    public wj9 w;
    public CustomMessageListener w0;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes8.dex */
    public interface q0 {
        void a(boolean z);

        void b(int i, zv5 zv5Var, int i2);

        void c();

        void d(int i, int i2, zv5 zv5Var, int i3);

        void onError(int i, String str);
    }

    /* loaded from: classes8.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* loaded from: classes8.dex */
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
        public e0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<wn> h = this.a.n.h();
                if (!ListUtils.isEmpty(h)) {
                    for (wn wnVar : h) {
                        if (wnVar instanceof bp6) {
                            bp6 bp6Var = (bp6) wnVar;
                            if (bp6Var.j != 0 && (threadData = bp6Var.a) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                bp6Var.j = imageWidthAndHeight[0];
                                bp6Var.k = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                xg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements rw5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ vz7 b;

        /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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

        public h(vz7 vz7Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vz7Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rw5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                if (dataRes != null) {
                    u18.c().h(new a(this));
                }
                if (this.a && !u18.c().e()) {
                    Looper.myQueue().addIdleHandler(new b(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements uz7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* loaded from: classes8.dex */
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

        public q(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.baidu.tieba.uz7
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

    /* loaded from: classes8.dex */
    public class a implements PollingModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public a(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
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

    /* loaded from: classes8.dex */
    public class a0 implements rz7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public a0(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.baidu.tieba.rz7
        public void a(DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, builder) != null) {
                return;
            }
            this.a.M0(builder);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public b(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, customMessage)) != null) {
                return (CustomResponsedMessage) invokeL.objValue;
            }
            ThreadCardViewHolder i0 = this.a.i0();
            if (i0 != null && i0.a() != null) {
                return new CustomResponsedMessage<>(2016323, Boolean.valueOf(i0.a().p(new vz.a(6))));
            }
            return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
        }
    }

    /* loaded from: classes8.dex */
    public class b0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder i0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (i0 = this.a.i0()) != null && i0.a() != null) {
                    i0.a().p(new vz.a(3));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
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

    /* loaded from: classes8.dex */
    public class c0 implements r18.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        @Override // com.baidu.tieba.r18.c
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c0(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.baidu.tieba.r18.c
        public void a(k18 k18Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, k18Var) == null) && this.a.k != null && this.a.q != null && this.a.q.p(this.a.d, k18Var, this.a.k.getFirstVisiblePosition(), this.a.k.getLastVisiblePosition()) && this.a.O != null) {
                this.a.n.z(this.a.d);
                this.a.O.c();
                if (k18Var != null && !TextUtils.isEmpty(k18Var.a())) {
                    this.a.p0(k18Var.a());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public d(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d0 extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(vz7 vz7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = vz7Var;
        }

        @Override // com.baidu.tieba.jb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            u48 u48Var;
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
            for (wn wnVar : this.a.d) {
                if ((wnVar instanceof t48) && (u48Var = ((t48) wnVar).X) != null && j2 == u48Var.b) {
                    u48Var.c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public e(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a.l == null) {
                return;
            }
            x95.i l0 = this.a.l0();
            if (this.a.l.u() && l0 != null && !PermissionUtil.isBrowseMode()) {
                this.a.l.z(l0);
            } else {
                this.a.l.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public f(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                if (this.a.e != null && this.a.e.thread_list != null && !this.a.r0()) {
                    i = this.a.e.thread_list.size();
                } else {
                    i = 0;
                }
                this.a.c.b(i, this.a.Y(true), 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921758) {
                if (customResponsedMessage.getData() == null) {
                    this.a.Y0(null);
                } else if (customResponsedMessage.getData() instanceof dx7) {
                    this.a.Y0((dx7) customResponsedMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends nx5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public g(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nx5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes a = u18.c().a();
                this.a.D0(a);
                return a;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public g0(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
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

    /* loaded from: classes8.dex */
    public class h0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof v35)) {
                v35 v35Var = (v35) customResponsedMessage.getData();
                if (v35Var.a != 1) {
                    return;
                }
                int l = wi.l(TbadkCoreApplication.getInst());
                int j = wi.j(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.a.K);
                requestGetMyPostNetMessage.setParams(ug.g(v35Var.c, 0L), 0L, 0L, l, j, f, i);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i extends nx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ vz7 b;

        public i(vz7 vz7Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vz7Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.nx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                c55.d();
                try {
                    c55.c("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class i0 extends jb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(vz7 vz7Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = vz7Var;
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

    /* loaded from: classes8.dex */
    public class j extends nx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ vz7 b;

        public j(vz7 vz7Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vz7Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.nx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                c55.d();
                try {
                    c55.c("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && j28.a()) {
                vz7 vz7Var = this.a;
                vz7Var.Q = zf5.i(vz7Var.j, DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE, 0L);
                if (this.a.Q != null) {
                    im9.e().h(DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public k(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.s
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.t.d(i) != 1 && this.a.p != null) {
                this.a.p.d();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k0 implements qw6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        @Override // com.baidu.tieba.qw6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.qw6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public k0(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.baidu.tieba.qw6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                this.a.v = false;
            }
        }

        @Override // com.baidu.tieba.qw6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
                this.a.v = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData) && this.a.e != null && ListUtils.getCount(this.a.e.thread_list) != 0 && (threadData = (ThreadData) customResponsedMessage.getData()) != null && threadData.getPraise() != null && threadData.getId() != null && ListUtils.getCount(this.a.e.thread_list) != 0) {
                for (int i = 0; i < this.a.e.thread_list.size(); i++) {
                    ThreadInfo threadInfo = this.a.e.thread_list.get(i);
                    if (threadInfo != null && threadInfo.id.longValue() == ug.g(threadData.getId(), -1L)) {
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

    /* loaded from: classes8.dex */
    public class l0 implements uq9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        @Override // com.baidu.tieba.uq9.b
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public l0(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        @Override // com.baidu.tieba.uq9.b
        public void a(xq9 xq9Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, xq9Var) == null) && this.a.k != null && this.a.q != null) {
                this.a.q.r(this.a.d, xq9Var, this.a.k.getFirstVisiblePosition());
                this.a.n.z(this.a.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
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

    /* loaded from: classes8.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof so6)) {
                so6 so6Var = (so6) customResponsedMessage.getData();
                this.a.d1(so6Var.a(), so6Var.b());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.a.e != null && !ListUtils.isEmpty(this.a.e.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().c)) {
                    b28.b(this.a.e, updateAttentionMessage, this.a.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
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

    /* loaded from: classes8.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
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
                if (!fv7.c(builder, longValue, z)) {
                    return;
                }
                this.a.e.hot_recomforum = builder.build(true);
                this.a.M0(new DataRes.Builder(this.a.e.build(true)));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || this.a.k == null) {
                return;
            }
            this.a.f0();
        }
    }

    /* loaded from: classes8.dex */
    public class p extends nx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ vz7 b;

        public p(vz7 vz7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = vz7Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.nx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                c55.d();
                we<String> f = c55.f(this.b.e0, TbadkCoreApplication.getCurrentAccount());
                if (f != null) {
                    f.e(this.b.e0, Integer.toString(this.a), com.heytap.mcssdk.constant.a.g);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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

    /* loaded from: classes8.dex */
    public class r extends nx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        public r(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nx5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                c55.d();
                we<String> f = c55.f(this.a.e0, TbadkCoreApplication.getCurrentAccount());
                if (f != null) {
                    return f.get(this.a.e0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements rw5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uz7 a;

        public s(vz7 vz7Var, uz7 uz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, uz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rw5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            uz7 uz7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (uz7Var = this.a) != null) {
                uz7Var.a(ug.e(str, 0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F != null) {
                TbSingleton.getInstance().isAddBanner = false;
                this.a.d.remove(this.a.F);
                this.a.n.z(new ArrayList(this.a.d));
                o95.p().H("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.g0(customResponsedMessage);
                if (this.a.w != null && this.a.A) {
                    this.a.w.n(this.a.x, this.a.y, this.a.v, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class v extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public final /* synthetic */ vz7 d;

        public v(vz7 vz7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = vz7Var;
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
                    this.d.H0(i3);
                }
                if (this.c && this.a != i) {
                    this.a = i;
                    this.d.H0(i);
                }
                this.d.f0 = i;
                this.d.x = i;
                this.d.y = i3;
                ThreadCardViewHolder i0 = this.d.i0();
                if (i0 != null && i0.a() != null) {
                    i0.a().p(this.d.L);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (this.d.s == null) {
                    this.d.s = new ps5();
                    this.d.s.a(1005);
                    this.d.s.e = 1;
                }
                if (i == 0) {
                    tz7.b(this.d.k);
                    this.d.s.e();
                    eo6.b().d(true);
                    i56.c().h("page_recommend", "show_");
                    dy9.g().h(this.d.G, false);
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

    /* loaded from: classes8.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.g0(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ vz7 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.f = vz7Var;
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
                    this.f.g0(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.e != null && ListUtils.getCount(this.a.e.thread_list) != 0) {
                String str = (String) customResponsedMessage.getData();
                a28.a(str, this.a.d);
                a28.c(str, this.a.e, this.a.o0);
                if (this.a.n != null) {
                    TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                    this.a.n.z(new ArrayList(this.a.d));
                }
                if (this.a.w != null && this.a.A) {
                    this.a.w.n(this.a.x, this.a.y, this.a.v, true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vz7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(vz7 vz7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vz7Var, Integer.valueOf(i)};
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
            this.a = vz7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                a28.b(this.a.d, this.a.e, this.a.o0, this.a.n);
            }
        }
    }

    public vz7(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, b18 b18Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout, PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, b18Var, bigdaySwipeRefreshLayout, personalizePageView};
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
        this.L = new vz.a(2);
        this.M = null;
        this.R = new v(this);
        this.S = new g0(this);
        this.f1185T = new k0(this);
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
        this.J = o95.p().q("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.m = personalizePageView;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.S);
        qw6 qw6Var = new qw6();
        this.u = qw6Var;
        qw6Var.d(this.f1185T);
        this.n = b18Var;
        this.q = new o18();
        this.a = o95.p().r("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.R);
        this.p = new kf7();
        q0();
        wj9 wj9Var = new wj9(this.j, this.k);
        this.w = wj9Var;
        wj9Var.p(2);
        this.w.w(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.b = new sz7(this.d, this.n);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.H = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, wi.g(tbPageContext.getContext(), R.dimen.tbds83)));
        Q0();
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
        pollingModel.M0(z55.d);
        this.P.Q0(new a(this));
        MessageManager.getInstance().registerListener(this.v0);
        MessageManager.getInstance().registerListener(this.u0);
        MessageManager.getInstance().registerListener(this.w0);
        MessageManager.getInstance().registerListener(this.t0);
    }

    public final void D0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) {
            this.h = true;
            if (dataRes != null) {
                L0(false, true, true, dataRes);
                q0 q0Var = this.c;
                if (q0Var != null) {
                    q0Var.a(true);
                    A0();
                    return;
                }
                return;
            }
            y0();
        }
    }

    public void E0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.H;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i2);
            }
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null) {
                homePageYoungsterTopView.b();
            }
            yf5 yf5Var = this.Q;
            if (yf5Var != null) {
                yf5Var.w();
            }
        }
    }

    public void J0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z2) == null) && z2) {
            this.n.l();
        }
    }

    public final void M0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, builder) == null) {
            rx5.b(new j(this, builder), null);
        }
    }

    public void U0(qz7 qz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, qz7Var) == null) {
            this.O = qz7Var;
            if (qz7Var != null) {
                qz7Var.e(this.d);
                this.O.b().p(this.q0);
            }
        }
    }

    public final void V0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z2) == null) {
            this.g = z2;
        }
    }

    public void W0(q0 q0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, q0Var) == null) {
            this.c = q0Var;
        }
    }

    public void X0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z2) == null) {
            this.A = z2;
        }
    }

    public final zv5 Y(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z2)) == null) {
            String e2 = en9.e(this.d, z2);
            int a02 = a0(z2);
            zv5 zv5Var = new zv5();
            zv5Var.b = e2;
            zv5Var.a = a02;
            return zv5Var;
        }
        return (zv5) invokeZ.objValue;
    }

    public void Y0(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, dx7Var) == null) {
            this.t = dx7Var;
            if (dx7Var == null) {
                return;
            }
            dx7Var.setOnTabSelectedListener(new k(this));
        }
    }

    public void Z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            rx5.b(new p(this, i2), null);
        }
    }

    public void Z0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z2) == null) {
            this.z = z2;
        }
    }

    public final void c0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public final void d0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public void h0(uz7 uz7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, uz7Var) == null) {
            rx5.b(new r(this), new s(this, uz7Var));
        }
    }

    public final void p0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_HOMEPAGE_REC_FORUM_CARD_SHOW);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void x0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            this.h = true;
            rx5.b(new g(this), new h(this, z2));
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            xs5.b().q(System.currentTimeMillis() - xs5.b().c());
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            o95.p().A(j0(), false);
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            tz7.b(this.k);
            Z(this.f0);
            ps5 ps5Var = this.s;
            if (ps5Var != null) {
                ps5Var.c();
            }
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            tz7.c(this.k);
        }
    }

    public wj9 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.w;
        }
        return (wj9) invokeV.objValue;
    }

    public uq9 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.N;
        }
        return (uq9) invokeV.objValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            sz9 sz9Var = new sz9("new_index", null);
            this.r = sz9Var;
            sz9Var.d();
        }
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return s0(true);
        }
        return invokeV.booleanValue;
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return o95.p().l(j0(), true);
        }
        return invokeV.booleanValue;
    }

    public final boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            update(false);
        }
    }

    public final boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            h0(this.h0);
        }
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            u18.c().b(new f(this));
        }
    }

    public void C0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z2) == null) {
            this.z = z2;
            dx7 dx7Var = this.t;
            if (dx7Var != null) {
                dx7Var.f(z2);
            }
            wj9 wj9Var = this.w;
            if (wj9Var == null) {
                return;
            }
            wj9Var.r(!z2);
            ThreadCardViewHolder i02 = i0();
            boolean z3 = false;
            if (i02 != null && i02.a() != null) {
                z3 = i02.a().p(new vz.a(8, Boolean.valueOf(z2)));
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
                    uq9 uq9Var = new uq9();
                    this.N = uq9Var;
                    uq9Var.h(this.U);
                }
                this.N.g();
            }
            yf5 yf5Var = this.Q;
            if (yf5Var != null) {
                yf5Var.q();
            }
        }
    }

    public int a0(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z2)) == null) {
            List<wn> list = this.d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.d.size()) {
                    wn wnVar = (wn) sp8.d(this.d, i4);
                    if ((wnVar instanceof to6) && (i3 = ((to6) wnVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((wnVar instanceof e18) && wnVar.getType() != AdvertAppInfo.y) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    wn wnVar2 = (wn) sp8.d(this.d, size);
                    if ((wnVar2 instanceof to6) && (i2 = ((to6) wnVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((wnVar2 instanceof e18) && wnVar2.getType() != AdvertAppInfo.y) {
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
            bx7.d().j(System.currentTimeMillis(), 1);
            this.f = 1;
            this.E = true;
            uq9 uq9Var = this.N;
            if (uq9Var != null) {
                uq9Var.e();
            }
            this.P.C0("live,level,icon,festival_info,live_follow_second_floor,member_broadcast,activity_broadcast,live_index_second_floor");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            xg.a().postDelayed(this.Z, 300000L);
            if (this.d.size() == 0 && !t0()) {
                if (!this.h) {
                    x0(z2);
                    return;
                } else {
                    y0();
                    return;
                }
            }
            y0();
        }
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            wj9 wj9Var = this.w;
            if (wj9Var != null) {
                wj9Var.h();
            }
            kf7 kf7Var = this.p;
            if (kf7Var != null) {
                kf7Var.e();
            }
            sz7 sz7Var = this.b;
            if (sz7Var != null) {
                sz7Var.h();
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
                xg.a().removeCallbacks(this.Z);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.t0);
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            wj9 wj9Var = this.w;
            if (wj9Var != null && !this.z && this.A) {
                wj9Var.n(this.x, this.y, this.v, true);
            }
            if (!this.B) {
                return;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
            if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                boolean z2 = this.C;
                if (z2) {
                    dy9.g().h(this.G, false);
                    if (s0(false)) {
                        b1(3, this.i);
                    } else if (this.D > 0) {
                        b1(2, this.i);
                    }
                } else if (!z2 && this.i == 0) {
                    b1(2, 0);
                }
            }
            this.B = false;
            this.C = false;
            this.D = 0;
            if (this.E) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.E = false;
            uq9 uq9Var = this.N;
            if (uq9Var != null) {
                uq9Var.d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        DataRes.Builder builder;
        int i3;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) == null) {
            DataRes dataRes2 = dataRes;
            if (z2) {
                xz7.a();
            }
            o18 o18Var = this.q;
            if (o18Var != null && o18Var.s() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
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
                        V0(false);
                        bh.e(new d(this));
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
                    if ((!z4 || i2 == 0) && dataRes2 != null && L0(true, z2, z3, dataRes2)) {
                        B0();
                        if (this.c != null) {
                            o95 p2 = o95.p();
                            p2.H("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            this.c.a(false);
                        }
                        this.B = true;
                        this.C = z2;
                        this.D = i3;
                        c1();
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
                    V0(false);
                    bh.e(new e(this));
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
            B0();
            if (this.c != null) {
            }
            this.B = true;
            this.C = z2;
            this.D = i3;
            c1();
            V0(false);
            bh.e(new e(this));
        }
    }

    public void H0(int i2) {
        int i3;
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            sz9 sz9Var = this.r;
            if (sz9Var != null) {
                i3 = sz9Var.b(i2);
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.r.c(i2);
            }
        }
    }

    public final List<Integer> k0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                wn item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof l18) {
                    l18 l18Var = (l18) item;
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

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (ListUtils.getCount(this.d) < this.q.h() - 40) {
                return;
            }
            List<wn> list = null;
            q18 e2 = this.q.e(true, this.e, null, 1);
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

    public final void S0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (builder = this.e) == null) {
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
        b0(builder2, i2);
        rx5.b(new i(this, builder2), null);
    }

    public final void c1() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048610, this) != null) || (builder = this.e) == null) {
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
        b0(builder2, i2);
        c0(builder2);
        d0(builder2);
        M0(builder2);
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            Iterator<wn> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof l18) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            c1();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> k02 = k0(bdTypeRecyclerView);
                int intValue = k02.get(0).intValue();
                int intValue2 = k02.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.k.removeItemList(intValue, intValue2);
                }
            }
        }
    }

    public void z0() {
        int i2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            if (u0()) {
                bx7.d().j(0L, 1);
            } else if (this.c != null) {
                K0();
                this.f++;
                V0(true);
                DataRes.Builder builder = this.e;
                if (builder != null && (list = builder.thread_list) != null) {
                    i2 = list.size();
                } else {
                    i2 = 0;
                }
                this.c.d(this.f, i2, Y(false), 0);
            }
        }
    }

    public final boolean L0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        int size;
        List<wn> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.J == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || r0())) {
                    S0();
                    this.e = null;
                }
            } else if (z3 && r0()) {
                this.e = null;
            }
            if (z3) {
                size = 0;
            } else {
                size = this.d.size();
            }
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.d.clear();
            if (z2 && m66.i().o(AbsDataRecorder.Scene.RECOMMEND)) {
                m66.i().g(AbsDataRecorder.Scene.RECOMMEND).b();
            }
            q18 e2 = this.q.e(z2, this.e, builder, !z3 ? 1 : 0);
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
                X(list, size);
                R0(!z3 ? 1 : 0, list, size);
                if (this.E) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.e == null) {
                this.e = builder;
                this.b.j(builder.thread_list);
            }
            if (this.d.size() != 0) {
                if (z2 && t56.k().l(AbsDataRecorder.Scene.RECOMMEND)) {
                    t56.k().g(AbsDataRecorder.Scene.RECOMMEND).b();
                }
                if (z3) {
                    if (dataRes.live_answer != null) {
                        m18 m18Var = new m18();
                        this.F = m18Var;
                        m18Var.c(dataRes.live_answer);
                        this.e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.F = null;
                        this.e.live_answer = null;
                    }
                    this.e.float_info = dataRes.float_info;
                }
                long r2 = o95.p().r("key_maintab_banner_close_time", 0L);
                if (this.F != null && !StringHelper.isTaday(r2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.d.add(0, this.F);
                }
                LinkedList linkedList = new LinkedList(this.d);
                b18 b18Var = this.n;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                b18Var.t(z5);
                this.n.A(linkedList, i2);
                wj9 wj9Var = this.w;
                if (wj9Var != null && this.A) {
                    wj9Var.n(this.x, this.y, this.v, true);
                }
                z5 = true;
            }
            bx7.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e3 = bx7.d().e(1);
            int i3 = (e3 > 0L ? 1 : (e3 == 0L ? 0 : -1));
            if (i3 > 0) {
                bx7.d().k(System.currentTimeMillis() - e3, 1);
                bx7.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                i7a.h(blockPopInfo);
            }
            x35 x35Var = new x35();
            x35Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, x35Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                xs5.b().D(System.currentTimeMillis() - e3);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public void N0(int i2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048589, this, i2, i3) == null) && !ListUtils.isEmpty(this.d) && this.d.size() > i2 && i2 >= 0 && i2 >= 0 && i3 >= 0) {
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

    public void P0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, bdUniqueId) != null) || bdUniqueId == null) {
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
        wj9 wj9Var = this.w;
        if (wj9Var != null) {
            wj9Var.u(bdUniqueId);
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

    public void R0(int i2, List<wn> list, int i3) {
        sz9 sz9Var;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) != null) || (sz9Var = this.r) == null) {
            return;
        }
        if (i2 == 0) {
            sz9Var.d();
        }
        if (list != null && !list.isEmpty()) {
            int[] iArr = sz9.e;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
                if ((list.get(i7) instanceof to6) && (i6 = i6 + 1) == i4 - 1) {
                    int i8 = i7 + 1;
                    if (i3 < i8) {
                        this.r.a(i4, i8);
                    }
                    i5++;
                }
            }
        }
    }

    public final void X(List<wn> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, list, i2) == null) {
            Set<wn> a2 = en9.a(list, this.f, "HOME");
            if (a2.size() > 0) {
                dy9.g().c(this.G, by9.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
                String currentDay = UtilHelper.getCurrentDay();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    String str = "";
                    String w2 = o95.p().w("activity_prize_feed_text_time", "");
                    boolean z2 = true;
                    if (!StringUtils.isNull(w2)) {
                        String[] split = w2.split("@");
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
                        b1(4, 0);
                        o95.p().J("activity_prize_feed_text_time", str);
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
    public final x95.i l0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        dx7 dx7Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (!this.B || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || v0()) {
                return null;
            }
            int i2 = this.i;
            boolean z2 = this.C;
            if (z2) {
                dy9.g().h(this.G, false);
                if (s0(false)) {
                    c2 = 3;
                } else if (this.D <= 0) {
                    c2 = 0;
                }
                if (this.t != null) {
                    this.p.f();
                }
                dx7Var = this.t;
                if (dx7Var == null && dx7Var.getCurrentTabType() != 1) {
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
                    return new x95.i(str, this.o);
                }
            } else if (z2 || i2 != 0) {
                return null;
            } else {
                i2 = 0;
            }
            c2 = 2;
            if (this.t != null) {
            }
            dx7Var = this.t;
            if (dx7Var == null) {
            }
            if (c2 != 2) {
            }
            return TextUtils.isEmpty(str) ? null : null;
        }
        return (x95.i) invokeV.objValue;
    }

    public final void b0(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048607, this, builder, i2) != null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = fn9.b(next);
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

    public final List<Integer> o0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048623, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                wn item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof to6) {
                    to6 to6Var = (to6) item;
                    if (to6Var.getThreadData() != null && to6Var.getThreadData().getTid().equals(str)) {
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

    public final void b1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048608, this, i2, i3) != null) || v0()) {
            return;
        }
        if (this.t != null) {
            this.p.f();
        }
        dx7 dx7Var = this.t;
        if (dx7Var != null && dx7Var.getCurrentTabType() != 1) {
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
        dx7 dx7Var2 = this.t;
        if (dx7Var2 != null) {
            FrameLayout frameLayout = dx7Var2.getFrameLayout();
            frameLayout.removeView(this.H);
            frameLayout.addView(this.H, layoutParams);
            this.H.g();
        }
    }

    public final void d1(long j2, boolean z2) {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z2)}) == null) && (builder = this.e) != null && !ListUtils.isEmpty(builder.thread_list) && !ListUtils.isEmpty(this.d)) {
            for (wn wnVar : this.d) {
                if (wnVar instanceof to6) {
                    to6 to6Var = (to6) wnVar;
                    if (to6Var.n && j2 == to6Var.getThreadData().getFid() && z2 != to6Var.getThreadData().getForumData().f()) {
                        to6Var.getThreadData().getForumData().n(z2);
                    }
                }
            }
            o18 o18Var = this.q;
            if (o18Var != null) {
                o18Var.C(j2, z2);
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
                c1();
            }
        }
    }

    public void e0(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048613, this, l2) == null) && (builder = this.e) != null && (list = builder.thread_list) != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                    builder2.top_agree_post = null;
                    list.set(i2, builder2.build(true));
                    c1();
                    L0(false, true, false, this.e.build(true));
                    return;
                }
            }
        }
    }

    public final boolean s0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z2)) == null) {
            o95 p2 = o95.p();
            long r2 = p2.r("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            if (r2 != 0) {
                if (Math.abs(System.currentTimeMillis() - r2) > this.a) {
                    return true;
                }
                return false;
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public final void g0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048615, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (builder = this.e) != null && ListUtils.getCount(builder.thread_list) != 0 && ListUtils.getCount(this.d) != 0) {
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
                        wn item = this.k.getItem(i2);
                        if (item instanceof ap6) {
                            ap6 ap6Var = (ap6) item;
                            if (ap6Var.getThreadData() != null && ap6Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(ap6Var.getThreadData().getThreadAlaInfo().live_id))) {
                                optString = ap6Var.getThreadData().getTid();
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
            Iterator<wn> it = this.d.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                wn next = it.next();
                if (next instanceof to6) {
                    to6 to6Var = (to6) next;
                    if (to6Var.getThreadData() != null && to6Var.getThreadData().getTid() != null) {
                        if (to6Var.getThreadData().getTid().equals(optString)) {
                            it.remove();
                            z2 = true;
                        } else if (z2) {
                            p18.b(this.d);
                            break;
                        }
                    }
                }
            }
            DataRes.Builder builder2 = this.e;
            if (builder2 != null && builder2.thread_list != null) {
                long g2 = ug.g(optString, 0L);
                int i3 = 0;
                while (true) {
                    if (i3 < this.e.thread_list.size()) {
                        ThreadInfo threadInfo = this.e.thread_list.get(i3);
                        if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                            x18.d(threadInfo.tid.longValue(), i3, this.e.thread_list, this.d);
                            this.e.thread_list.remove(i3);
                            c1();
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                BdTypeRecyclerView bdTypeRecyclerView = this.k;
                if (bdTypeRecyclerView != null) {
                    List<Integer> o02 = o0(optString, bdTypeRecyclerView);
                    int intValue = o02.get(0).intValue();
                    int intValue2 = o02.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.k.removeItemList(intValue, intValue2);
                    }
                }
            }
        }
    }

    public final ThreadCardViewHolder i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            wj9 wj9Var = this.w;
            if (wj9Var != null && wj9Var.j() != null && (this.w.j().getTag() instanceof ThreadCardViewHolder)) {
                return (ThreadCardViewHolder) this.w.j().getTag();
            }
            return null;
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }
}
