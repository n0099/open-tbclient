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
import com.baidu.tieba.ez6;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.h3a;
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
import com.baidu.tieba.sa5;
import com.baidu.tieba.xz;
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
public class t48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public k68 F;
    public BdUniqueId G;
    public SmartBubbleAnimatedView H;
    public HomePageYoungsterTopView I;
    public int J;
    public BdUniqueId K;
    public xz.a L;
    public ThreadInfo M;
    public h3a N;
    public o48 O;
    public Object P;
    public RecyclerView.OnScrollListener Q;
    public View.OnTouchListener R;
    public ez6.b S;

    /* renamed from: T  reason: collision with root package name */
    public final h3a.b f1167T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;
    public final Runnable Y;
    public CustomMessageListener Z;
    public final long a;
    public CustomMessageListener a0;
    public final q48 b;
    public CustomMessageListener b0;
    public n0 c;
    public CustomMessageListener c0;
    public final List<yn> d;
    public String d0;
    public DataRes.Builder e;
    public int e0;
    public int f;
    public Runnable f0;
    public boolean g;
    public s48 g0;
    public boolean h;
    public CustomMessageListener h0;
    public int i;
    public CustomMessageListener i0;
    public final TbPageContext<?> j;
    public CustomMessageListener j0;
    public final BdTypeRecyclerView k;
    public CustomMessageListener k0;
    public final BigdaySwipeRefreshLayout l;
    public CustomMessageListener l0;
    public final PersonalizePageView m;
    public p48 m0;
    public final z58 n;
    public CustomMessageListener n0;
    public int o;
    public kb o0;
    public vj7 p;
    public CustomMessageListener p0;
    public final n68 q;
    public CustomMessageListener q0;
    public pca r;
    public CustomMessageListener r0;
    public yt5 s;
    public final kb s0;
    public b28 t;
    public ez6 u;
    public boolean v;
    public pu9 w;
    public int x;
    public int y;
    public boolean z;

    /* loaded from: classes8.dex */
    public interface n0 {
        void a(boolean z);

        void b(int i, ix5 ix5Var, int i2);

        void c();

        void d(int i, int i2, ix5 ix5Var, int i3);

        void onError(int i, String str);
    }

    /* loaded from: classes8.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c0 a;

            public a(c0 c0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.n.n();
                    if (!this.a.a.z && this.a.a.A) {
                        this.a.a.w.n(this.a.a.x, this.a.a.y, this.a.a.v, true);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<yn> k = this.a.n.k();
                if (!ListUtils.isEmpty(k)) {
                    for (yn ynVar : k) {
                        if (ynVar instanceof kq6) {
                            kq6 kq6Var = (kq6) ynVar;
                            if (kq6Var.j != 0 && (threadData = kq6Var.a) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                kq6Var.j = imageWidthAndHeight[0];
                                kq6Var.k = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                zg.a().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements ay5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ t48 b;

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
                    this.a.b.m.a1();
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
                            this.a.b.m.a1();
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

        public h(t48 t48Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t48Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ay5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                if (dataRes != null) {
                    t68.c().h(new a(this));
                }
                if (this.a && !t68.c().e()) {
                    Looper.myQueue().addIdleHandler(new b(this));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements s48 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

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

        public q(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // com.baidu.tieba.s48
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.f0 == null) {
                    this.a.f0 = new a(this, i);
                }
                this.a.k.removeCallbacks(this.a.f0);
                this.a.k.post(this.a.f0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a extends ou6<rl5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t48 t48Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ou6
        public void onEvent(@NonNull rl5 rl5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rl5Var) == null) && this.b.k != null && this.b.q != null && this.b.n != null && StringUtils.isNotNull(rl5Var.a())) {
                l18 l18Var = new l18();
                l18Var.setTid(rl5Var.a());
                if (this.b.q.s(this.b.d, l18Var)) {
                    this.b.n.B(this.b.d);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder c0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (c0 = this.a.c0()) != null && c0.b() != null) {
                    c0.b().p(new xz.a(3));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public b(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ThreadCardViewHolder c0 = this.a.c0();
                if (c0 != null && c0.b() != null) {
                    return new CustomResponsedMessage<>(2016323, Boolean.valueOf(c0.b().p(new xz.a(6))));
                }
                return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b0 extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(t48 t48Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = t48Var;
        }

        @Override // com.baidu.tieba.kb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            u98 u98Var;
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
            for (yn ynVar : this.a.d) {
                if ((ynVar instanceof t98) && (u98Var = ((t98) ynVar).X) != null && j2 == u98Var.b) {
                    u98Var.c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
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
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public d(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
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
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921758) {
                if (customResponsedMessage.getData() == null) {
                    this.a.W0(null);
                } else if (customResponsedMessage.getData() instanceof b28) {
                    this.a.W0((b28) customResponsedMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public e(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                sa5.i f0 = this.a.f0();
                if (this.a.l.u() && f0 != null && !PermissionUtil.isBrowseMode()) {
                    this.a.l.z(f0);
                } else {
                    this.a.l.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof g45)) {
                g45 g45Var = (g45) customResponsedMessage.getData();
                if (g45Var.a != 1) {
                    return;
                }
                int l = yi.l(TbadkCoreApplication.getInst());
                int j = yi.j(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.a.K);
                requestGetMyPostNetMessage.setParams(wg.g(g45Var.c, 0L), 0L, 0L, l, j, f, i);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public f(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                if (this.a.e != null && this.a.e.thread_list != null && !this.a.p0()) {
                    i = this.a.e.thread_list.size();
                } else {
                    i = 0;
                }
                this.a.c.b(i, this.a.S(true), 0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f0 extends kb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(t48 t48Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = t48Var;
        }

        @Override // com.baidu.tieba.kb
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
                if (getMyPostResIdl == null || (dataRes = getMyPostResIdl.data) == null || (threadInfo = dataRes.thread_info) == null) {
                    return;
                }
                this.a.M = threadInfo;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g extends wy5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public g(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wy5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes a = t68.c().a();
                this.a.B0(a);
                return a;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public g0(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
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
    public class h0 implements ez6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        @Override // com.baidu.tieba.ez6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.ez6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public h0(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // com.baidu.tieba.ez6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.a.v = false;
        }

        @Override // com.baidu.tieba.ez6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) != null) {
                return;
            }
            this.a.v = true;
        }
    }

    /* loaded from: classes8.dex */
    public class i extends wy5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ t48 b;

        public i(t48 t48Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t48Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                o55.e();
                try {
                    o55.d("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
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
    public class i0 implements h3a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        @Override // com.baidu.tieba.h3a.b
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public i0(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // com.baidu.tieba.h3a.b
        public void a(k3a k3aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, k3aVar) == null) && this.a.k != null && this.a.q != null) {
                this.a.q.r(this.a.d, k3aVar, this.a.k.getFirstVisiblePosition());
                this.a.n.B(this.a.d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j extends wy5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ t48 b;

        public j(t48 t48Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t48Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                o55.e();
                try {
                    o55.d("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
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
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof bq6)) {
                bq6 bq6Var = (bq6) customResponsedMessage.getData();
                this.a.b1(bq6Var.a(), bq6Var.b());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements ScrollFragmentTabHost.s {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public k(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
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
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
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
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData) && this.a.e != null && ListUtils.getCount(this.a.e.thread_list) != 0 && (threadData = (ThreadData) customResponsedMessage.getData()) != null && threadData.getPraise() != null && threadData.getId() != null && ListUtils.getCount(this.a.e.thread_list) != 0) {
                for (int i = 0; i < this.a.e.thread_list.size(); i++) {
                    ThreadInfo threadInfo = this.a.e.thread_list.get(i);
                    if (threadInfo != null && threadInfo.id.longValue() == wg.g(threadData.getId(), -1L)) {
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
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.k != null) {
                this.a.Z();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
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
                    this.a.n.B(new ArrayList(this.a.d));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.a.e != null && !ListUtils.isEmpty(this.a.e.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().c)) {
                    a78.b(this.a.e, updateAttentionMessage, this.a.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
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
                if (a08.c(builder, longValue, z)) {
                    this.a.e.hot_recomforum = builder.build(true);
                    this.a.K0(new DataRes.Builder(this.a.e.build(true)));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p extends wy5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ t48 b;

        public p(t48 t48Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = t48Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.wy5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                o55.e();
                ye<String> g = o55.g(this.b.d0, TbadkCoreApplication.getCurrentAccount());
                if (g != null) {
                    g.e(this.b.d0, Integer.toString(this.a), com.heytap.mcssdk.constant.a.g);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class r extends wy5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public r(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wy5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                o55.e();
                ye<String> g = o55.g(this.a.d0, TbadkCoreApplication.getCurrentAccount());
                if (g != null) {
                    return g.get(this.a.d0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements ay5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s48 a;

        public s(t48 t48Var, s48 s48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, s48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ay5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            s48 s48Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (s48Var = this.a) != null) {
                s48Var.a(wg.e(str, 0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F != null) {
                TbSingleton.getInstance().isAddBanner = false;
                this.a.d.remove(this.a.F);
                this.a.n.B(new ArrayList(this.a.d));
                da5.p().H("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.a0(customResponsedMessage);
            if (this.a.w != null && this.a.A) {
                this.a.w.n(this.a.x, this.a.y, this.a.v, true);
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
        public final /* synthetic */ t48 d;

        public v(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = t48Var;
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
                    this.d.F0(i3);
                }
                if (this.c && this.a != i) {
                    this.a = i;
                    this.d.F0(i);
                }
                this.d.e0 = i;
                this.d.x = i;
                this.d.y = i3;
                ThreadCardViewHolder c0 = this.d.c0();
                if (c0 != null && c0.b() != null) {
                    c0.b().p(this.d.L);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (this.d.s == null) {
                    this.d.s = new yt5();
                    this.d.s.a(1005);
                    this.d.s.e = 1;
                }
                if (i == 0) {
                    r48.b(this.d.k);
                    this.d.s.e();
                    np6.b().d(true);
                    r66.c().h("page_recommend", "show_");
                    aba.g().h(this.d.G, false);
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
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.a0(customResponsedMessage);
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
        public final /* synthetic */ t48 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.f = t48Var;
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
                    this.f.a0(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(t48 t48Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var, Integer.valueOf(i)};
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
            this.a = t48Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                z68.b(this.a.d, this.a.e, this.a.m0, this.a.n);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class z implements p48 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t48 a;

        public z(t48 t48Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t48Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t48Var;
        }

        @Override // com.baidu.tieba.p48
        public void a(DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, builder) != null) {
                return;
            }
            this.a.K0(builder);
        }
    }

    public t48(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, z58 z58Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout, PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, z58Var, bigdaySwipeRefreshLayout, personalizePageView};
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
        this.L = new xz.a(2);
        this.M = null;
        this.P = new Object();
        this.Q = new v(this);
        this.R = new g0(this);
        this.S = new h0(this);
        this.f1167T = new i0(this);
        this.U = new j0(this, 2921806);
        this.V = new k0(this, 2001399);
        this.W = new l0(this, 2921461);
        this.X = new m0(this, 2921486);
        this.Y = new c(this);
        this.Z = new l(this, 2004004);
        this.a0 = new m(this, 2921026);
        this.b0 = new n(this, 2001115);
        this.c0 = new o(this, 0);
        this.d0 = "lastReadReadPositionKey";
        this.e0 = 0;
        this.g0 = new q(this);
        this.h0 = new t(this, 2016569);
        this.i0 = new u(this, 2016488);
        this.j0 = new w(this, 2016553);
        this.k0 = new x(this, 2921547);
        this.l0 = new y(this, 2921746);
        this.m0 = new z(this);
        this.n0 = new a0(this, 2921381);
        this.o0 = new b0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.p0 = new c0(this, 2921414);
        this.q0 = new d0(this, 2921758);
        this.r0 = new e0(this, 2921453);
        this.s0 = new f0(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.j = tbPageContext;
        this.J = da5.p().q("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.m = personalizePageView;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.R);
        ez6 ez6Var = new ez6();
        this.u = ez6Var;
        ez6Var.d(this.S);
        this.n = z58Var;
        this.q = new n68();
        this.a = da5.p().r("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.Q);
        this.p = new vj7();
        o0();
        pu9 pu9Var = new pu9(this.j, this.k);
        this.w = pu9Var;
        pu9Var.p(2);
        this.w.w(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.b = new q48(this.d, this.n);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.H = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, yi.g(tbPageContext.getContext(), R.dimen.tbds83)));
        O0();
        this.p0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.p0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.s0.setTag(this.K);
        if (this.s0.getHttpMessageListener() != null) {
            this.s0.getHttpMessageListener().setSelfListener(true);
        }
        if (this.s0.getSocketMessageListener() != null) {
            this.s0.getSocketMessageListener().setSelfListener(true);
        }
        lu6.b().a(this.P, new a(this, rl5.class));
        MessageManager.getInstance().registerListener(this.s0);
        MessageManager.getInstance().registerListener(this.r0);
        MessageManager.getInstance().registerListener(this.q0);
    }

    public static void n0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_HOMEPAGE_REC_FORUM_CARD_SHOW);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void B0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            this.h = true;
            if (dataRes != null) {
                J0(false, true, true, dataRes);
                n0 n0Var = this.c;
                if (n0Var != null) {
                    n0Var.a(true);
                    y0();
                    return;
                }
                return;
            }
            w0();
        }
    }

    public void C0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SmartBubbleAnimatedView smartBubbleAnimatedView = this.H;
            if (smartBubbleAnimatedView != null) {
                smartBubbleAnimatedView.e(i2);
            }
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null) {
                homePageYoungsterTopView.b();
            }
        }
    }

    public void H0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048583, this, z2) == null) && z2) {
            this.n.n();
        }
    }

    public final void K0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, builder) == null) {
            az5.b(new j(this, builder), null);
        }
    }

    public final ix5 S(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z2)) == null) {
            String e2 = xx9.e(this.d, z2);
            int U = U(z2);
            ix5 ix5Var = new ix5();
            ix5Var.b = e2;
            ix5Var.a = U;
            return ix5Var;
        }
        return (ix5) invokeZ.objValue;
    }

    public void S0(o48 o48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, o48Var) == null) {
            this.O = o48Var;
            if (o48Var != null) {
                o48Var.f(this.d);
            }
        }
    }

    public void T(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            az5.b(new p(this, i2), null);
        }
    }

    public final void T0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z2) == null) {
            this.g = z2;
        }
    }

    public void U0(n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, n0Var) == null) {
            this.c = n0Var;
        }
    }

    public void V0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z2) == null) {
            this.A = z2;
        }
    }

    public final void W(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public void W0(b28 b28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, b28Var) == null) {
            this.t = b28Var;
            if (b28Var == null) {
                return;
            }
            b28Var.setOnTabSelectedListener(new k(this));
        }
    }

    public final void X(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public void X0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z2) == null) {
            this.z = z2;
        }
    }

    public void b0(s48 s48Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, s48Var) == null) {
            az5.b(new r(this), new s(this, s48Var));
        }
    }

    public final void v0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z2) == null) {
            this.h = true;
            az5.b(new g(this), new h(this, z2));
        }
    }

    public void A0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) {
            this.z = z2;
            b28 b28Var = this.t;
            if (b28Var != null) {
                b28Var.f(z2);
            }
            pu9 pu9Var = this.w;
            if (pu9Var == null) {
                return;
            }
            pu9Var.r(!z2);
            ThreadCardViewHolder c02 = c0();
            boolean z3 = false;
            if (c02 != null && c02.b() != null) {
                z3 = c02.b().p(new xz.a(8, Boolean.valueOf(z2)));
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
                    h3a h3aVar = new h3a();
                    this.N = h3aVar;
                    h3aVar.h(this.f1167T);
                }
                this.N.g();
            }
        }
    }

    public int U(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z2)) == null) {
            List<yn> list = this.d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.d.size()) {
                    yn ynVar = (yn) g09.d(this.d, i4);
                    if ((ynVar instanceof cq6) && (i3 = ((cq6) ynVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((ynVar instanceof c68) && ynVar.getType() != AdvertAppInfo.z) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    yn ynVar2 = (yn) g09.d(this.d, size);
                    if ((ynVar2 instanceof cq6) && (i2 = ((cq6) ynVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((ynVar2 instanceof c68) && ynVar2.getType() != AdvertAppInfo.z) {
                        return i4;
                    }
                }
            }
            return this.d.size();
        }
        return invokeZ.intValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            pu9 pu9Var = this.w;
            if (pu9Var != null) {
                pu9Var.h();
            }
            vj7 vj7Var = this.p;
            if (vj7Var != null) {
                vj7Var.e();
            }
            q48 q48Var = this.b;
            if (q48Var != null) {
                q48Var.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.f0);
            }
            if (this.Y != null) {
                zg.a().removeCallbacks(this.Y);
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.p0);
            MessageManager.getInstance().unRegisterListener(this.r0);
            MessageManager.getInstance().unRegisterListener(this.s0);
            MessageManager.getInstance().unRegisterListener(this.q0);
            lu6.b().unregister(this.P);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            pu9 pu9Var = this.w;
            if (pu9Var != null && !this.z && this.A) {
                pu9Var.n(this.x, this.y, this.v, true);
            }
            if (!this.B) {
                return;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
            if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                boolean z2 = this.C;
                if (z2) {
                    aba.g().h(this.G, false);
                    if (q0(false)) {
                        Z0(3, this.i);
                    } else if (this.D > 0) {
                        Z0(2, this.i);
                    }
                } else if (!z2 && this.i == 0) {
                    Z0(2, 0);
                }
            }
            this.B = false;
            this.C = false;
            this.D = 0;
            if (this.E) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.E = false;
            h3a h3aVar = this.N;
            if (h3aVar != null) {
                h3aVar.d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        DataRes.Builder builder;
        int i3;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) == null) {
            DataRes dataRes2 = dataRes;
            if (z2) {
                v48.a();
            }
            n68 n68Var = this.q;
            if (n68Var != null && n68Var.t() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
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
                        n0 n0Var = this.c;
                        if (n0Var != null) {
                            n0Var.c();
                        }
                        T0(false);
                        dh.g(new d(this));
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
                    if ((!z4 || i2 == 0) && dataRes2 != null && J0(true, z2, z3, dataRes2)) {
                        z0();
                        if (this.c != null) {
                            da5 p2 = da5.p();
                            p2.H("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            this.c.a(false);
                        }
                        this.B = true;
                        this.C = z2;
                        this.D = i3;
                        a1();
                    } else {
                        this.B = false;
                        if (this.d.size() > 0) {
                            n0 n0Var2 = this.c;
                            if (n0Var2 != null) {
                                n0Var2.onError(1, str);
                            }
                        } else {
                            n0 n0Var3 = this.c;
                            if (n0Var3 != null) {
                                n0Var3.onError(2, str);
                            }
                        }
                    }
                    T0(false);
                    dh.g(new e(this));
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
            z0();
            if (this.c != null) {
            }
            this.B = true;
            this.C = z2;
            this.D = i3;
            a1();
            T0(false);
            dh.g(new e(this));
        }
    }

    public void F0(int i2) {
        int i3;
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            pca pcaVar = this.r;
            if (pcaVar != null) {
                i3 = pcaVar.b(i2);
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.r.c(i2);
            }
        }
    }

    public final List<Integer> e0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                yn item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof j68) {
                    j68 j68Var = (j68) item;
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

    public void m0(@NonNull rl5 rl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, rl5Var) == null) && this.k != null && this.q != null && this.n != null && StringUtils.isNotNull(rl5Var.a())) {
            l18 l18Var = new l18();
            l18Var.setTid(rl5Var.a());
            if (this.q.s(this.d, l18Var)) {
                this.n.B(this.d);
            }
        }
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            r48.b(this.k);
            T(this.e0);
            yt5 yt5Var = this.s;
            if (yt5Var != null) {
                yt5Var.c();
            }
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new b(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            r48.c(this.k);
        }
    }

    public pu9 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.w;
        }
        return (pu9) invokeV.objValue;
    }

    public h3a h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.N;
        }
        return (h3a) invokeV.objValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            pca pcaVar = new pca("new_index", null);
            this.r = pcaVar;
            pcaVar.d();
        }
    }

    public final boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return q0(true);
        }
        return invokeV.booleanValue;
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return da5.p().l(d0(), true);
        }
        return invokeV.booleanValue;
    }

    public final boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            b0(this.g0);
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            update(false);
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            t68.c().b(new f(this));
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            gu5.b().q(System.currentTimeMillis() - gu5.b().c());
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            da5.p().A(d0(), false);
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (ListUtils.getCount(this.d) < this.q.h() - 40) {
                return;
            }
            List<yn> list = null;
            p68 e2 = this.q.e(true, this.e, null, 1);
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
                this.n.C(new LinkedList(this.d), i2);
            }
        }
    }

    public final void Q0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || (builder = this.e) == null) {
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
        V(builder2, i2);
        az5.b(new i(this, builder2), null);
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            Iterator<yn> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof j68) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            a1();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> e02 = e0(bdTypeRecyclerView);
                int intValue = e02.get(0).intValue();
                int intValue2 = e02.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.k.removeItemList(intValue, intValue2);
                }
            }
        }
    }

    public final void a1() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048612, this) != null) || (builder = this.e) == null) {
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
        V(builder2, i2);
        W(builder2);
        X(builder2);
        K0(builder2);
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048624, this) == null) && this.k != null && this.q != null && this.n != null) {
            UserFollowLive.Builder builder = new UserFollowLive.Builder();
            builder._switch = 1;
            builder.user_follow_live = TbSingleton.getInstance().getLiveIndexSecondFloor();
            this.q.l(this.d, builder.build(true));
            this.n.B(this.d);
            pu9 pu9Var = this.w;
            if (pu9Var != null && this.A) {
                pu9Var.n(this.x, this.y, this.v, true);
            }
        }
    }

    public void x0() {
        int i2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            if (s0()) {
                z18.d().j(0L, 1);
            } else if (this.c != null) {
                I0();
                this.f++;
                T0(true);
                DataRes.Builder builder = this.e;
                if (builder != null && (list = builder.thread_list) != null) {
                    i2 = list.size();
                } else {
                    i2 = 0;
                }
                this.c.d(this.f, i2, S(false), 0);
            }
        }
    }

    public final boolean J0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        int size;
        List<yn> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.J == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || p0())) {
                    Q0();
                    this.e = null;
                }
            } else if (z3 && p0()) {
                this.e = null;
            }
            if (z3) {
                size = 0;
            } else {
                size = this.d.size();
            }
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.d.clear();
            if (z2 && v76.i().o(AbsDataRecorder.Scene.RECOMMEND)) {
                v76.i().g(AbsDataRecorder.Scene.RECOMMEND).b();
            }
            p68 e2 = this.q.e(z2, this.e, builder, !z3 ? 1 : 0);
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
                R(list, size);
                P0(!z3 ? 1 : 0, list, size);
                if (this.E) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.e == null) {
                this.e = builder;
                this.b.j(builder.thread_list);
            }
            if (this.d.size() != 0) {
                if (z2 && c76.k().l(AbsDataRecorder.Scene.RECOMMEND)) {
                    c76.k().g(AbsDataRecorder.Scene.RECOMMEND).b();
                }
                if (z3) {
                    if (dataRes.live_answer != null) {
                        k68 k68Var = new k68();
                        this.F = k68Var;
                        k68Var.c(dataRes.live_answer);
                        this.e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.F = null;
                        this.e.live_answer = null;
                    }
                    this.e.float_info = dataRes.float_info;
                }
                long r2 = da5.p().r("key_maintab_banner_close_time", 0L);
                if (this.F != null && !StringHelper.isTaday(r2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.d.add(0, this.F);
                }
                LinkedList linkedList = new LinkedList(this.d);
                z58 z58Var = this.n;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                z58Var.v(z5);
                this.n.C(linkedList, i2);
                pu9 pu9Var = this.w;
                if (pu9Var != null && this.A) {
                    pu9Var.n(this.x, this.y, this.v, true);
                }
                z5 = true;
            }
            z18.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e3 = z18.d().e(1);
            int i3 = (e3 > 0L ? 1 : (e3 == 0L ? 0 : -1));
            if (i3 > 0) {
                z18.d().k(System.currentTimeMillis() - e3, 1);
                z18.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                lka.h(blockPopInfo);
            }
            i45 i45Var = new i45();
            i45Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, i45Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                gu5.b().D(System.currentTimeMillis() - e3);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public void L0(int i2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) && !ListUtils.isEmpty(this.d) && this.d.size() > i2 && i2 >= 0 && i2 >= 0 && i3 >= 0) {
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

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r2 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
        if (r2 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        r3 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Integer> i0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            int i2 = 0;
            boolean z2 = false;
            int i3 = -1;
            int i4 = -1;
            while (i2 < bdTypeRecyclerView.getCount()) {
                yn item = bdTypeRecyclerView.getItem(i2);
                if (item instanceof l18) {
                    if (!str.equals(((l18) item).getTid())) {
                        i2++;
                    }
                } else {
                    if (item instanceof cq6) {
                        cq6 cq6Var = (cq6) item;
                        if (cq6Var.getThreadData() != null && cq6Var.getThreadData().getTid().equals(str)) {
                        }
                    }
                    i2++;
                }
                i4 = i2;
                z2 = true;
                i2++;
            }
            arrayList.add(Integer.valueOf(i3));
            arrayList.add(Integer.valueOf(i4));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public void N0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.G = bdUniqueId;
        CustomMessageListener customMessageListener = this.Z;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
        }
        CustomMessageListener customMessageListener2 = this.V;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.V);
        }
        this.W.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.W);
        this.b0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.b0);
        this.c0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.c0);
        MessageManager.getInstance().registerListener(2001336, this.c0);
        this.a0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.a0);
        this.i0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.i0);
        this.j0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j0);
        this.k0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.k0);
        this.l0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.l0);
        pu9 pu9Var = this.w;
        if (pu9Var != null) {
            pu9Var.u(bdUniqueId);
        }
        this.b.i(bdUniqueId);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.h0);
        this.n0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.n0);
        this.o0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.o0);
        this.X.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.X);
        this.U.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.U);
    }

    public void P0(int i2, List<yn> list, int i3) {
        pca pcaVar;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) != null) || (pcaVar = this.r) == null) {
            return;
        }
        if (i2 == 0) {
            pcaVar.d();
        }
        if (list != null && !list.isEmpty()) {
            int[] iArr = pca.e;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
                if ((list.get(i7) instanceof cq6) && (i6 = i6 + 1) == i4 - 1) {
                    int i8 = i7 + 1;
                    if (i3 < i8) {
                        this.r.a(i4, i8);
                    }
                    i5++;
                }
            }
        }
    }

    public final void R(List<yn> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, list, i2) == null) {
            Set<yn> a2 = xx9.a(list, this.f, "HOME");
            if (a2.size() > 0) {
                aba.g().c(this.G, yaa.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public final void V(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048601, this, builder, i2) != null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = yx9.b(next);
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

    public void Y(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048607, this, l2) == null) && (builder = this.e) != null && (list = builder.thread_list) != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                    builder2.top_agree_post = null;
                    list.set(i2, builder2.build(true));
                    a1();
                    J0(false, true, false, this.e.build(true));
                    return;
                }
            }
        }
    }

    public void j0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048622, this, customResponsedMessage) == null) && customResponsedMessage != null && (builder = this.e) != null && ListUtils.getCount(builder.thread_list) != 0) {
            String str = (String) customResponsedMessage.getData();
            z68.a(str, this.d);
            z68.c(str, this.e, this.m0);
            if (this.n != null) {
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                this.n.B(new ArrayList(this.d));
            }
            pu9 pu9Var = this.w;
            if (pu9Var != null && this.A) {
                pu9Var.n(this.x, this.y, this.v, true);
            }
        }
    }

    public void k0(i68 i68Var) {
        BdTypeRecyclerView bdTypeRecyclerView;
        n68 n68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, i68Var) == null) && (bdTypeRecyclerView = this.k) != null && (n68Var = this.q) != null && n68Var.p(this.d, i68Var, bdTypeRecyclerView.getFirstVisiblePosition(), this.k.getLastVisiblePosition()) && this.O != null) {
            this.n.B(this.d);
            this.O.c();
            if (i68Var != null && !TextUtils.isEmpty(i68Var.a())) {
                n0(i68Var.a());
            }
        }
    }

    public final boolean q0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048628, this, z2)) == null) {
            da5 p2 = da5.p();
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

    public void update(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z2) == null) {
            z18.d().j(System.currentTimeMillis(), 1);
            this.f = 1;
            this.E = true;
            h3a h3aVar = this.N;
            if (h3aVar != null) {
                h3aVar.e();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            zg.a().postDelayed(this.Y, 300000L);
            if (this.d.size() == 0 && !r0()) {
                if (!this.h) {
                    v0(z2);
                    return;
                } else {
                    w0();
                    return;
                }
            }
            w0();
        }
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
                String currentDay = UtilHelper.getCurrentDay();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    String str = "";
                    String w2 = da5.p().w("activity_prize_feed_text_time", "");
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
                        Z0(4, 0);
                        da5.p().J("activity_prize_feed_text_time", str);
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
    public final sa5.i f0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        b28 b28Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (!this.B || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || t0()) {
                return null;
            }
            int i2 = this.i;
            boolean z2 = this.C;
            if (z2) {
                aba.g().h(this.G, false);
                if (q0(false)) {
                    c2 = 3;
                } else if (this.D <= 0) {
                    c2 = 0;
                }
                if (this.t != null) {
                    this.p.f();
                }
                b28Var = this.t;
                if (b28Var == null && b28Var.getCurrentTabType() != 1) {
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
                    return new sa5.i(str, this.o);
                }
            } else if (z2 || i2 != 0) {
                return null;
            } else {
                i2 = 0;
            }
            c2 = 2;
            if (this.t != null) {
            }
            b28Var = this.t;
            if (b28Var == null) {
            }
            if (c2 != 2) {
            }
            return TextUtils.isEmpty(str) ? null : null;
        }
        return (sa5.i) invokeV.objValue;
    }

    public final void Z0(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048610, this, i2, i3) != null) || t0()) {
            return;
        }
        if (this.t != null) {
            this.p.f();
        }
        b28 b28Var = this.t;
        if (b28Var != null && b28Var.getCurrentTabType() != 1) {
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
        b28 b28Var2 = this.t;
        if (b28Var2 != null) {
            FrameLayout frameLayout = b28Var2.getFrameLayout();
            frameLayout.removeView(this.H);
            frameLayout.addView(this.H, layoutParams);
            this.H.g();
        }
    }

    public final void a0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        String tid;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (builder = this.e) != null && ListUtils.getCount(builder.thread_list) != 0 && ListUtils.getCount(this.d) != 0) {
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
                        yn item = this.k.getItem(i2);
                        if (item instanceof jq6) {
                            jq6 jq6Var = (jq6) item;
                            if (jq6Var.getThreadData() != null && jq6Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(jq6Var.getThreadData().getThreadAlaInfo().live_id))) {
                                optString = jq6Var.getThreadData().getTid();
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
            Iterator<yn> it = this.d.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                yn next = it.next();
                if (next instanceof cq6) {
                    cq6 cq6Var = (cq6) next;
                    boolean z3 = next instanceof l18;
                    if (z3 || (cq6Var.getThreadData() != null && cq6Var.getThreadData().getTid() != null)) {
                        if (z3) {
                            tid = ((l18) next).getTid();
                        } else {
                            tid = cq6Var.getThreadData().getTid();
                        }
                        if (tid.equals(optString)) {
                            it.remove();
                            z2 = true;
                        } else if (z2) {
                            o68.b(this.d);
                            break;
                        }
                    }
                }
            }
            DataRes.Builder builder2 = this.e;
            if (builder2 != null && builder2.thread_list != null) {
                long g2 = wg.g(optString, 0L);
                int i3 = 0;
                while (true) {
                    if (i3 < this.e.thread_list.size()) {
                        ThreadInfo threadInfo = this.e.thread_list.get(i3);
                        if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == g2) {
                            w68.d(threadInfo.tid.longValue(), i3, this.e.thread_list, this.d);
                            this.e.thread_list.remove(i3);
                            a1();
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                BdTypeRecyclerView bdTypeRecyclerView = this.k;
                if (bdTypeRecyclerView != null) {
                    List<Integer> i02 = i0(optString, bdTypeRecyclerView);
                    int intValue = i02.get(0).intValue();
                    int intValue2 = i02.get(1).intValue();
                    if (intValue != -1 && intValue2 != -1) {
                        this.k.removeItemList(intValue, intValue2);
                    }
                }
            }
        }
    }

    public final void b1(long j2, boolean z2) {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z2)}) == null) && (builder = this.e) != null && !ListUtils.isEmpty(builder.thread_list) && !ListUtils.isEmpty(this.d)) {
            for (yn ynVar : this.d) {
                if (ynVar instanceof cq6) {
                    cq6 cq6Var = (cq6) ynVar;
                    if (cq6Var.n && j2 == cq6Var.getThreadData().getFid() && z2 != cq6Var.getThreadData().getForumData().f()) {
                        cq6Var.getThreadData().getForumData().n(z2);
                    }
                }
            }
            n68 n68Var = this.q;
            if (n68Var != null) {
                n68Var.E(j2, z2);
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
                a1();
            }
        }
    }

    public final ThreadCardViewHolder c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            pu9 pu9Var = this.w;
            if (pu9Var != null && pu9Var.j() != null && (this.w.j().getTag() instanceof ThreadCardViewHolder)) {
                return (ThreadCardViewHolder) this.w.j().getTag();
            }
            return null;
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }
}
