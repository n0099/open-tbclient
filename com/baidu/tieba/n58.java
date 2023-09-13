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
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.tieba.b8a;
import com.baidu.tieba.frs.SmartBubbleAnimatedView;
import com.baidu.tieba.fz6;
import com.baidu.tieba.homepage.BlessHttpResponseMessage;
import com.baidu.tieba.homepage.BlessSocketResponseMessage;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.HomePageStatic;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.tieba.homepage.personalize.view.HomePageYoungsterTopView;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.m5a;
import com.baidu.tieba.message.RequestBlessMessage;
import com.baidu.tieba.z95;
import com.baidu.tieba.zy;
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
/* loaded from: classes7.dex */
public class n58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public int D;
    public boolean E;
    public h78 F;
    public BdUniqueId G;
    public SmartBubbleAnimatedView H;
    public HomePageYoungsterTopView I;
    public int J;
    public BdUniqueId K;
    public zy.a L;
    public ThreadInfo M;
    public b8a N;
    public i58 O;
    public Object P;
    public k5a Q;
    public boolean R;
    public f78 S;

    /* renamed from: T  reason: collision with root package name */
    public BdAsyncTask<Void, Void, DataRes> f1136T;
    public RecyclerView.OnScrollListener U;
    public View.OnTouchListener V;
    public fz6.b W;
    public final b8a.b X;
    public final CustomMessageListener Y;
    public final CustomMessageListener Z;
    public final long a;
    public final CustomMessageListener a0;
    public final k58 b;
    public final CustomMessageListener b0;
    public n0 c;
    public final m5a.a c0;
    public final List<cn> d;
    public final Runnable d0;
    public DataRes.Builder e;
    public CustomMessageListener e0;
    public int f;
    public CustomMessageListener f0;
    public boolean g;
    public CustomMessageListener g0;
    public boolean h;
    public CustomMessageListener h0;
    public int i;
    public String i0;
    public final TbPageContext<?> j;
    public int j0;
    public final BdTypeRecyclerView k;
    public Runnable k0;
    public final BigdaySwipeRefreshLayout l;
    public m58 l0;
    public final PersonalizePageView m;
    public CustomMessageListener m0;
    public final v68 n;
    public CustomMessageListener n0;
    public int o;
    public CustomMessageListener o0;
    public ck7 p;
    public CustomMessageListener p0;
    public final n78 q;
    public CustomMessageListener q0;
    public jha r;
    public j58 r0;
    public at5 s;
    public CustomMessageListener s0;
    public t28 t;
    public NetMessageListener t0;
    public fz6 u;
    public CustomMessageListener u0;
    public boolean v;
    public CustomMessageListener v0;
    public fz9 w;
    public CustomMessageListener w0;
    public int x;
    public final HttpMessageListener x0;
    public int y;
    public boolean z;

    /* loaded from: classes7.dex */
    public interface n0 {
        void a(boolean z);

        void b(int i, kw5 kw5Var, int i2);

        void c();

        void d(int i, int i2, kw5 kw5Var, int i3);

        void onError(int i, String str);
    }

    /* loaded from: classes7.dex */
    public class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* loaded from: classes7.dex */
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
        public c0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<cn> k = this.a.n.k();
                if (!ListUtils.isEmpty(k)) {
                    for (cn cnVar : k) {
                        if (cnVar instanceof cq6) {
                            cq6 cq6Var = (cq6) cnVar;
                            if (cq6Var.j != 0 && (threadData = cq6Var.a) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                cq6Var.j = imageWidthAndHeight[0];
                                cq6Var.k = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                SafeHandler.getInst().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends BdAsyncTask<Void, Void, DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ n58 b;

        /* loaded from: classes7.dex */
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
                    this.a.b.m.b1();
                }
            }
        }

        /* loaded from: classes7.dex */
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
                            this.a.b.m.b1();
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

        public h(n58 n58Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n58Var;
            this.a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public DataRes doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                DataRes a2 = t78.c().a();
                this.b.H0(a2);
                return a2;
            }
            return (DataRes) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
                super.onPostExecute(dataRes);
                if (dataRes != null) {
                    t78.c().h(new a(this));
                }
                if (this.a && !t78.c().e()) {
                    Looper.myQueue().addIdleHandler(new b(this));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements m58 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* loaded from: classes7.dex */
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

        public q(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // com.baidu.tieba.m58
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a.k0 == null) {
                    this.a.k0 = new a(this, i);
                }
                this.a.k.removeCallbacks(this.a.k0);
                this.a.k.post(this.a.k0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a extends ku6<kl5> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n58 n58Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, cls};
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
            this.b = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ku6
        public void onEvent(@NonNull kl5 kl5Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kl5Var) == null) && this.b.k != null && this.b.q != null && this.b.n != null && StringUtils.isNotNull(kl5Var.a())) {
                c28 c28Var = new c28();
                c28Var.setTid(kl5Var.a());
                if (this.b.q.v(this.b.d, c28Var)) {
                    this.b.n.B(this.b.d);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadCardViewHolder f0;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24 && (f0 = this.a.f0()) != null && f0.a() != null) {
                    f0.a().p(new zy.a(3));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements m5a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        @Override // com.baidu.tieba.m5a.a
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // com.baidu.tieba.m5a.a
        public void a(@NonNull f78 f78Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, f78Var) == null) && this.a.k != null && this.a.q != null && this.a.n != null && f78Var.isValid()) {
                DefaultLog.getInstance().i("RecentForumLog", "触发数据请求成功回调");
                if (this.a.Q.b() < 2) {
                    DefaultLog.getInstance().i("RecentForumLog", "最近逛的吧接口后返回，需要等待直播数据返回");
                    this.a.S = f78Var;
                    return;
                }
                this.a.S = null;
                DefaultLog.getInstance().i("RecentForumLog", "最近逛的吧接口后返回，开始插入最近逛的吧模快");
                this.a.q.s(this.a.d, f78Var, this.a.R);
                this.a.n.B(this.a.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b0 extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b0(n58 n58Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = n58Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            long j2;
            fa8 fa8Var;
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
            for (cn cnVar : this.a.d) {
                if ((cnVar instanceof ea8) && (fa8Var = ((ea8) cnVar).X) != null && j2 == fa8Var.b) {
                    fa8Var.c = j;
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public c(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                ThreadCardViewHolder f0 = this.a.f0();
                if (f0 != null && f0.a() != null) {
                    return new CustomResponsedMessage<>(2016323, Boolean.valueOf(f0.a().p(new zy.a(6))));
                }
                return new CustomResponsedMessage<>(2016323, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
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

    /* loaded from: classes7.dex */
    public class d0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921758) {
                if (customResponsedMessage.getData() == null) {
                    this.a.f1(null);
                } else if (customResponsedMessage.getData() instanceof t28) {
                    this.a.f1((t28) customResponsedMessage.getData());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public e(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                this.a.l.setRefreshing(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof o35)) {
                o35 o35Var = (o35) customResponsedMessage.getData();
                if (o35Var.a != 1) {
                    return;
                }
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst());
                int equipmentHeight = BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst());
                float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i = 2;
                } else {
                    i = 1;
                }
                RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                requestGetMyPostNetMessage.setTag(this.a.K);
                requestGetMyPostNetMessage.setParams(JavaTypesHelper.toLong(o35Var.c, 0L), 0L, 0L, equipmentWidth, equipmentHeight, f, i);
                requestGetMyPostNetMessage.setBFrom("push");
                MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public f(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l != null) {
                z95.i j0 = this.a.j0();
                if (this.a.l.u() && j0 != null && !PermissionUtil.isBrowseMode()) {
                    this.a.l.z(j0);
                } else {
                    this.a.l.setRefreshing(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f0 extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GetMyPostResIdl getMyPostResIdl;
            tbclient.GetMyPost.DataRes dataRes;
            ThreadInfo threadInfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage instanceof GetMyPostHttpResponseMessage) {
                    getMyPostResIdl = ((GetMyPostHttpResponseMessage) httpResponsedMessage).getResponseData();
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

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public g(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                if (this.a.e != null && this.a.e.thread_list != null && !this.a.v0()) {
                    i = this.a.e.thread_list.size();
                } else {
                    i = 0;
                }
                this.a.c.b(i, this.a.V(true), 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g0 implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public g0(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
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

    /* loaded from: classes7.dex */
    public class h0 implements fz6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        @Override // com.baidu.tieba.fz6.b
        public void c(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            }
        }

        @Override // com.baidu.tieba.fz6.b
        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

        public h0(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // com.baidu.tieba.fz6.b
        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(1048576, this, i, i2) != null) {
                return;
            }
            this.a.v = false;
        }

        @Override // com.baidu.tieba.fz6.b
        public void b(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) != null) {
                return;
            }
            this.a.v = true;
        }
    }

    /* loaded from: classes7.dex */
    public class i extends xx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ n58 b;

        public i(n58 n58Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n58Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.xx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                x45.k();
                try {
                    x45.j("tb.rec_old_data", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class i0 implements b8a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        @Override // com.baidu.tieba.b8a.b
        public void onFail() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public i0(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // com.baidu.tieba.b8a.b
        public void a(e8a e8aVar) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, e8aVar) == null) && this.a.k != null && this.a.q != null) {
                this.a.q.u(this.a.d, e8aVar, this.a.k.getFirstVisiblePosition());
                this.a.n.B(this.a.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends xx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ n58 b;

        public j(n58 n58Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n58Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.xx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                this.b.b.g(builder.thread_list);
                x45.k();
                try {
                    x45.j("tb.rec_frs_update", TbadkCoreApplication.getCurrentAccount()).g("0", builder.build(true).toByteArray());
                    return null;
                } catch (Exception e) {
                    BdLog.e(e);
                    return null;
                }
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class j0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof tp6)) {
                tp6 tp6Var = (tp6) customResponsedMessage.getData();
                this.a.k1(tp6Var.a(), tp6Var.b());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements ScrollFragmentTabHost.t {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public k(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost.t
        public void a(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048576, this, i) == null) && this.a.t.d(i) != 1 && this.a.p != null) {
                this.a.p.d();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
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

    /* loaded from: classes7.dex */
    public class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof ThreadData) && this.a.e != null && ListUtils.getCount(this.a.e.thread_list) != 0 && (threadData = (ThreadData) customResponsedMessage.getData()) != null && threadData.getPraise() != null && threadData.getId() != null && ListUtils.getCount(this.a.e.thread_list) != 0) {
                for (int i = 0; i < this.a.e.thread_list.size(); i++) {
                    ThreadInfo threadInfo = this.a.e.thread_list.get(i);
                    if (threadInfo != null && threadInfo.id.longValue() == JavaTypesHelper.toLong(threadData.getId(), -1L)) {
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

    /* loaded from: classes7.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.k != null) {
                this.a.c0();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
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

    /* loaded from: classes7.dex */
    public class m0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m0(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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

    /* loaded from: classes7.dex */
    public class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage) && this.a.e != null && !ListUtils.isEmpty(this.a.e.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    b88.b(this.a.e, updateAttentionMessage, this.a.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
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
                if (q08.c(builder, longValue, z)) {
                    this.a.e.hot_recomforum = builder.build(true);
                    this.a.Q0(new DataRes.Builder(this.a.e.build(true)));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class p extends xx5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ n58 b;

        public p(n58 n58Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = n58Var;
            this.a = i;
        }

        @Override // com.baidu.tieba.xx5
        public Object doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                x45.k();
                oe<String> m = x45.m(this.b.i0, TbadkCoreApplication.getCurrentAccount());
                if (m != null) {
                    m.e(this.b.i0, Integer.toString(this.a), com.heytap.mcssdk.constant.a.g);
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class r extends xx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public r(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xx5
        public String doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                x45.k();
                oe<String> m = x45.m(this.a.i0, TbadkCoreApplication.getCurrentAccount());
                if (m != null) {
                    return m.get(this.a.i0);
                }
                return null;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s implements cx5<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m58 a;

        public s(n58 n58Var, m58 m58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, m58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.cx5
        /* renamed from: a */
        public void onReturnDataInUI(String str) {
            m58 m58Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (m58Var = this.a) != null) {
                m58Var.a(JavaTypesHelper.toInt(str, 0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.F != null) {
                TbSingleton.getInstance().isAddBanner = false;
                this.a.d.remove(this.a.F);
                this.a.n.B(new ArrayList(this.a.d));
                SharedPrefHelper.getInstance().putLong("key_maintab_banner_close_time", System.currentTimeMillis());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.d0(customResponsedMessage);
            if (this.a.w != null && this.a.A) {
                this.a.w.n(this.a.x, this.a.y, this.a.v, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class v extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public boolean c;
        public final /* synthetic */ n58 d;

        public v(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = n58Var;
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
                    this.d.L0(i3);
                }
                if (this.c && this.a != i) {
                    this.a = i;
                    this.d.L0(i);
                }
                this.d.j0 = i;
                this.d.x = i;
                this.d.y = i3;
                ThreadCardViewHolder f0 = this.d.f0();
                if (f0 != null && f0.a() != null) {
                    f0.a().p(this.d.L);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) {
                if (this.d.s == null) {
                    this.d.s = new at5();
                    this.d.s.a(1005);
                    this.d.s.e = 1;
                }
                if (i == 0) {
                    l58.b(this.d.k);
                    this.d.s.e();
                    ep6.b().d(true);
                    m56.c().h("page_recommend", "show_");
                    vfa.g().h(this.d.G, false);
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

    /* loaded from: classes7.dex */
    public class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.d0(customResponsedMessage);
        }
    }

    /* loaded from: classes7.dex */
    public class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ n58 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.f = n58Var;
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
                    this.f.d0(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(n58 n58Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var, Integer.valueOf(i)};
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
            this.a = n58Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                a88.b(this.a.d, this.a.e, this.a.r0, this.a.n);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class z implements j58 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n58 a;

        public z(n58 n58Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n58Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n58Var;
        }

        @Override // com.baidu.tieba.j58
        public void a(DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, builder) != null) {
                return;
            }
            this.a.Q0(builder);
        }
    }

    public n58(TbPageContext<?> tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, v68 v68Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout, PersonalizePageView personalizePageView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, v68Var, bigdaySwipeRefreshLayout, personalizePageView};
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
        this.L = new zy.a(2);
        this.M = null;
        this.P = new Object();
        this.R = false;
        this.U = new v(this);
        this.V = new g0(this);
        this.W = new h0(this);
        this.X = new i0(this);
        this.Y = new j0(this, 2921806);
        this.Z = new k0(this, 2001399);
        this.a0 = new l0(this, 2921461);
        this.b0 = new m0(this, 2921486);
        this.c0 = new b(this);
        this.d0 = new d(this);
        this.e0 = new l(this, 2004004);
        this.f0 = new m(this, 2921026);
        this.g0 = new n(this, 2001115);
        this.h0 = new o(this, 0);
        this.i0 = "lastReadReadPositionKey";
        this.j0 = 0;
        this.l0 = new q(this);
        this.m0 = new t(this, 2016569);
        this.n0 = new u(this, 2016488);
        this.o0 = new w(this, 2016553);
        this.p0 = new x(this, 2921547);
        this.q0 = new y(this, 2921746);
        this.r0 = new z(this);
        this.s0 = new a0(this, 2921381);
        this.t0 = new b0(this, CmdConfigHttp.CMD_TOPIC_BLESS, 309085);
        this.u0 = new c0(this, 2921414);
        this.v0 = new d0(this, 2921758);
        this.w0 = new e0(this, 2921453);
        this.x0 = new f0(this, CmdConfigHttp.CMD_GET_MY_POST);
        this.j = tbPageContext;
        this.J = SharedPrefHelper.getInstance().getInt("key_personalized_refresh_type", 0);
        this.l = bigdaySwipeRefreshLayout;
        this.m = personalizePageView;
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.V);
        fz6 fz6Var = new fz6();
        this.u = fz6Var;
        fz6Var.d(this.W);
        this.n = v68Var;
        this.q = new n78(this);
        this.a = SharedPrefHelper.getInstance().getLong("recommend_frs_cache_time", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT) * 1000;
        bdTypeRecyclerView.setOnScrollListener(this.U);
        this.p = new ck7();
        u0();
        fz9 fz9Var = new fz9(this.j, this.k);
        this.w = fz9Var;
        fz9Var.p(2);
        this.w.w(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        this.b = new k58(this.d, this.n);
        SmartBubbleAnimatedView smartBubbleAnimatedView = new SmartBubbleAnimatedView(tbPageContext.getContext());
        this.H = smartBubbleAnimatedView;
        smartBubbleAnimatedView.setLayoutParams(new FrameLayout.LayoutParams(-1, BdUtilHelper.getDimens(tbPageContext.getContext(), R.dimen.tbds83)));
        V0();
        this.u0.setTag(this.j.getUniqueId());
        MessageManager.getInstance().registerListener(this.u0);
        if (MessageManager.getInstance().findTask(CmdConfigHttp.CMD_GET_MY_POST) == null) {
            HomePageStatic.a();
        }
        this.x0.setTag(this.K);
        this.x0.setSelfListener(true);
        hu6.b().a(this.P, new a(this, kl5.class));
        k5a k5aVar = new k5a(k5a.c);
        this.Q = k5aVar;
        k5aVar.a().f(this.c0);
        MessageManager.getInstance().registerListener(this.x0);
        MessageManager.getInstance().registerListener(this.w0);
        MessageManager.getInstance().registerListener(this.v0);
    }

    public static void t0(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, null, str) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_HOMEPAGE_REC_FORUM_CARD_SHOW);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            TiebaStatic.log(statisticItem);
        }
    }

    public final void B0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z2) == null) {
            this.h = true;
            h hVar = new h(this, z2);
            this.f1136T = hVar;
            hVar.execute(new Void[0]);
        }
    }

    public final void H0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            this.h = true;
            if (dataRes != null) {
                P0(false, true, true, dataRes);
                n0 n0Var = this.c;
                if (n0Var != null) {
                    n0Var.a(true);
                    E0();
                    return;
                }
                return;
            }
            C0();
        }
    }

    public void I0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
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

    public void N0(boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z2) == null) && z2) {
            this.n.n();
        }
    }

    public final void Q0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, builder) == null) {
            by5.b(new j(this, builder), null);
        }
    }

    public final kw5 V(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z2)) == null) {
            String e2 = l2a.e(this.d, z2);
            int X = X(z2);
            kw5 kw5Var = new kw5();
            kw5Var.b = e2;
            kw5Var.a = X;
            return kw5Var;
        }
        return (kw5) invokeZ.objValue;
    }

    public void W(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            by5.b(new p(this, i2), null);
        }
    }

    public final void Z(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, builder) == null) {
            builder.user_follow_live = null;
        }
    }

    public void Z0(i58 i58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, i58Var) == null) {
            this.O = i58Var;
            if (i58Var != null) {
                i58Var.f(this.d);
            }
        }
    }

    public final void a0(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, builder) == null) {
            builder.active_center = null;
        }
    }

    public void a1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.R = z2;
        }
    }

    public final void b1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z2) == null) {
            this.g = z2;
        }
    }

    public void c1(n0 n0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, n0Var) == null) {
            this.c = n0Var;
        }
    }

    public void d1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.A = z2;
        }
    }

    public void e0(m58 m58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, m58Var) == null) {
            by5.b(new r(this), new s(this, m58Var));
        }
    }

    public void e1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.Q.e(i2);
        }
    }

    public void f1(t28 t28Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, t28Var) == null) {
            this.t = t28Var;
            if (t28Var == null) {
                return;
            }
            t28Var.setOnTabSelectedListener(new k(this));
        }
    }

    public void g1(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z2) == null) {
            this.z = z2;
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e0(this.l0);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            t78.c().b(new g(this));
        }
    }

    public void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ht5.a().p(System.currentTimeMillis() - ht5.a().b());
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SharedPrefHelper.getInstance().putBoolean(h0(), false);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l58.b(this.k);
            W(this.j0);
            at5 at5Var = this.s;
            if (at5Var != null) {
                at5Var.c();
            }
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (this.R) {
                DefaultLog.getInstance().i("RecentForumLog", "刷新最近逛的吧，正在展示直播不刷新");
                return;
            }
            sba.a().e(true);
            this.Q.d();
        }
    }

    public final void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016323, new c(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            l58.c(this.k);
        }
    }

    public f78 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.S;
        }
        return (f78) invokeV.objValue;
    }

    public fz9 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.w;
        }
        return (fz9) invokeV.objValue;
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.Q.b();
        }
        return invokeV.intValue;
    }

    public b8a m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.N;
        }
        return (b8a) invokeV.objValue;
    }

    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            jha jhaVar = new jha("new_index", null);
            this.r = jhaVar;
            jhaVar.d();
        }
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            update(false);
        }
    }

    public final boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return w0(true);
        }
        return invokeV.booleanValue;
    }

    public final boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return SharedPrefHelper.getInstance().getBoolean(h0(), true);
        }
        return invokeV.booleanValue;
    }

    public final boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public final boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            HomePageYoungsterTopView homePageYoungsterTopView = this.I;
            if (homePageYoungsterTopView != null && homePageYoungsterTopView.getVisibility() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void D0() {
        int i2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (y0()) {
                r28.d().j(0L, 1);
            } else if (this.c != null) {
                O0();
                this.f++;
                b1(true);
                DataRes.Builder builder = this.e;
                if (builder != null && (list = builder.thread_list) != null) {
                    i2 = list.size();
                } else {
                    i2 = 0;
                }
                this.c.d(this.f, i2, V(false), 0);
            }
        }
    }

    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (ListUtils.getCount(this.d) < this.q.i() - 40) {
                return;
            }
            List<cn> list = null;
            p78 f2 = this.q.f(true, this.e, null, 1);
            int i2 = 0;
            if (f2 != null) {
                list = f2.a;
                int i3 = f2.c;
                f2.c = 0;
                i2 = i3;
            }
            if (list != null) {
                this.d.clear();
                this.d.addAll(list);
                this.n.C(new LinkedList(this.d), i2);
            }
        }
    }

    public final void X0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048603, this) != null) || (builder = this.e) == null) {
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
        Y(builder2, i2);
        by5.b(new i(this, builder2), null);
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            Iterator<cn> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next() instanceof g78) {
                    it.remove();
                    break;
                }
            }
            DataRes.Builder builder = this.e;
            if (builder == null) {
                return;
            }
            builder.active_center = null;
            j1();
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                List<Integer> i02 = i0(bdTypeRecyclerView);
                int intValue = i02.get(0).intValue();
                int intValue2 = i02.get(1).intValue();
                if (intValue != -1 && intValue2 != -1) {
                    this.k.removeItemList(intValue, intValue2);
                }
            }
        }
    }

    public final void j1() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048627, this) != null) || (builder = this.e) == null) {
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
        Y(builder2, i2);
        Z(builder2);
        a0(builder2);
        Q0(builder2);
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.R = false;
            if (this.Q.b() > 0 && this.k != null && this.q != null && this.n != null && this.S.isValid()) {
                DefaultLog.getInstance().i("RecentForumLog", "Loop接口返回失败，开始插入最近逛的吧模快");
                this.q.s(this.d, this.S, this.R);
                this.n.B(this.d);
            }
            k5a k5aVar = this.Q;
            k5aVar.e(k5aVar.b() + 1);
        }
    }

    public void G0(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z2) == null) {
            this.z = z2;
            t28 t28Var = this.t;
            if (t28Var != null) {
                t28Var.f(z2);
            }
            fz9 fz9Var = this.w;
            if (fz9Var == null) {
                return;
            }
            fz9Var.r(!z2);
            ThreadCardViewHolder f02 = f0();
            boolean z3 = false;
            if (f02 != null && f02.a() != null) {
                z3 = f02.a().p(new zy.a(8, Boolean.valueOf(z2)));
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
                    b8a b8aVar = new b8a();
                    this.N = b8aVar;
                    b8aVar.h(this.X);
                }
                this.N.g();
            }
        }
    }

    public int X(boolean z2) {
        InterceptResult invokeZ;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z2)) == null) {
            List<cn> list = this.d;
            int i4 = 0;
            if (list == null || list.size() == 0) {
                return 0;
            }
            int i5 = -1;
            if (z2) {
                int i6 = 0;
                while (i4 < this.d.size()) {
                    cn cnVar = (cn) i39.d(this.d, i4);
                    if ((cnVar instanceof up6) && (i3 = ((up6) cnVar).position) != i5) {
                        i6++;
                        i5 = i3;
                    }
                    if ((cnVar instanceof y68) && cnVar.getType() != AdvertAppInfo.z) {
                        return i6;
                    }
                    i4++;
                }
            } else {
                for (int size = this.d.size() - 1; size >= 0; size--) {
                    cn cnVar2 = (cn) i39.d(this.d, size);
                    if ((cnVar2 instanceof up6) && (i2 = ((up6) cnVar2).position) != i5) {
                        i4++;
                        i5 = i2;
                    }
                    if ((cnVar2 instanceof y68) && cnVar2.getType() != AdvertAppInfo.z) {
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
        if (interceptable == null || interceptable.invokeZ(1048640, this, z2) == null) {
            r28.d().j(System.currentTimeMillis(), 1);
            this.f = 1;
            this.E = true;
            b8a b8aVar = this.N;
            if (b8aVar != null) {
                b8aVar.e();
            }
            this.R = false;
            this.Q.e(0);
            sba.a().e(true);
            DefaultLog.getInstance().i("RecentForumLog", "刷新请求数据");
            this.Q.d();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921725, Boolean.FALSE));
            SafeHandler.getInst().postDelayed(this.d0, 300000L);
            if (this.d.size() == 0 && !x0()) {
                if (!this.h) {
                    B0(z2);
                    return;
                } else {
                    C0();
                    return;
                }
            }
            C0();
        }
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            fz9 fz9Var = this.w;
            if (fz9Var != null) {
                fz9Var.h();
            }
            ck7 ck7Var = this.p;
            if (ck7Var != null) {
                ck7Var.e();
            }
            k58 k58Var = this.b;
            if (k58Var != null) {
                k58Var.h();
            }
            BdTypeRecyclerView bdTypeRecyclerView = this.k;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.removeCallbacks(this.k0);
            }
            if (this.d0 != null) {
                SafeHandler.getInst().removeCallbacks(this.d0);
            }
            k5a k5aVar = this.Q;
            if (k5aVar != null) {
                k5aVar.c();
            }
            BdAsyncTask<Void, Void, DataRes> bdAsyncTask = this.f1136T;
            if (bdAsyncTask != null) {
                bdAsyncTask.cancel();
            }
            MessageManager.getInstance().unRegisterTask(2016323);
            MessageManager.getInstance().unRegisterListener(this.u0);
            MessageManager.getInstance().unRegisterListener(this.w0);
            MessageManager.getInstance().unRegisterListener(this.x0);
            MessageManager.getInstance().unRegisterListener(this.v0);
            hu6.b().unregister(this.P);
        }
    }

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            fz9 fz9Var = this.w;
            if (fz9Var != null && !this.z && this.A) {
                fz9Var.n(this.x, this.y, this.v, true);
            }
            if (!this.B) {
                return;
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.l;
            if (bigdaySwipeRefreshLayout != null && !bigdaySwipeRefreshLayout.u()) {
                boolean z2 = this.C;
                if (z2) {
                    vfa.g().h(this.G, false);
                    if (w0(false)) {
                        i1(3, this.i);
                    } else if (this.D > 0) {
                        i1(2, this.i);
                    }
                } else if (!z2 && this.i == 0) {
                    i1(2, 0);
                }
            }
            this.B = false;
            this.C = false;
            this.D = 0;
            if (this.E) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
            }
            this.E = false;
            b8a b8aVar = this.N;
            if (b8aVar != null) {
                b8aVar.d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K0(boolean z2, boolean z3, DataRes dataRes, int i2, String str) {
        boolean z4;
        DataRes.Builder builder;
        int i3;
        Long l2;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), dataRes, Integer.valueOf(i2), str}) == null) {
            DataRes dataRes2 = dataRes;
            if (z2) {
                p58.a();
            }
            n78 n78Var = this.q;
            if (n78Var != null && n78Var.w() && !z2 && (dataRes2 == null || ListUtils.isEmpty(dataRes2.thread_list))) {
                if (dataRes2 == null) {
                    DataRes.Builder builder2 = new DataRes.Builder();
                    builder2.thread_list = new ArrayList();
                    dataRes2 = builder2.build(false);
                }
                if (dataRes2.thread_list != null) {
                    List<ThreadInfo> g2 = this.q.g();
                    dataRes2.thread_list.addAll(g2);
                    if (g2 != null) {
                        g2.clear();
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
                        b1(false);
                        mg.g(new e(this));
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
                    if ((!z4 || i2 == 0) && dataRes2 != null && P0(true, z2, z3, dataRes2)) {
                        F0();
                        if (this.c != null) {
                            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                            sharedPrefHelper.putLong("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            this.c.a(false);
                        }
                        this.B = true;
                        this.C = z2;
                        this.D = i3;
                        j1();
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
                    b1(false);
                    mg.g(new f(this));
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
            F0();
            if (this.c != null) {
            }
            this.B = true;
            this.C = z2;
            this.D = i3;
            j1();
            b1(false);
            mg.g(new f(this));
        }
    }

    public void L0(int i2) {
        int i3;
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            jha jhaVar = this.r;
            if (jhaVar != null) {
                i3 = jhaVar.b(i2);
            } else {
                i3 = -1;
            }
            if (i3 >= 0 && (bdTypeRecyclerView = this.k) != null && bdTypeRecyclerView.getData() != null && this.k.getData().size() > i2) {
                this.r.c(i2);
            }
        }
    }

    public final List<Integer> i0(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            boolean z2 = false;
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < bdTypeRecyclerView.getCount(); i4++) {
                cn item = bdTypeRecyclerView.getItem(i4);
                if (item instanceof g78) {
                    g78 g78Var = (g78) item;
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

    public void s0(@NonNull kl5 kl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, kl5Var) == null) && this.k != null && this.q != null && this.n != null && StringUtils.isNotNull(kl5Var.a())) {
            c28 c28Var = new c28();
            c28Var.setTid(kl5Var.a());
            if (this.q.v(this.d, c28Var)) {
                this.n.B(this.d);
            }
        }
    }

    public final boolean P0(boolean z2, boolean z3, boolean z4, DataRes dataRes) {
        InterceptResult invokeCommon;
        int size;
        List<cn> list;
        int i2;
        BlockPopInfo blockPopInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), dataRes})) == null) {
            boolean z5 = false;
            if (dataRes == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.J == 1) {
                if (z3 && (dataRes.thread_list.size() >= 6 || v0())) {
                    X0();
                    this.e = null;
                }
            } else if (z3 && v0()) {
                this.e = null;
            }
            if (z3) {
                size = 0;
            } else {
                size = this.d.size();
            }
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.d.clear();
            if (z2 && q66.i().o(AbsDataRecorder.Scene.RECOMMEND)) {
                q66.i().g(AbsDataRecorder.Scene.RECOMMEND).b();
            }
            p78 f2 = this.q.f(z2, this.e, builder, !z3 ? 1 : 0);
            if (f2 != null) {
                list = f2.a;
                this.i = f2.b;
                i2 = f2.c;
                f2.c = 0;
            } else {
                list = null;
                i2 = 0;
            }
            if (list != null) {
                this.d.addAll(list);
                U(list, size);
                W0(!z3 ? 1 : 0, list, size);
                if (this.E) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016524));
                }
            }
            if (this.e == null) {
                this.e = builder;
                this.b.j(builder.thread_list);
            }
            if (this.d.size() != 0) {
                if (z2 && x56.k().l(AbsDataRecorder.Scene.RECOMMEND)) {
                    x56.k().g(AbsDataRecorder.Scene.RECOMMEND).b();
                }
                if (z3) {
                    if (dataRes.live_answer != null) {
                        h78 h78Var = new h78();
                        this.F = h78Var;
                        h78Var.c(dataRes.live_answer);
                        this.e.live_answer = dataRes.live_answer;
                    } else if (z2) {
                        this.F = null;
                        this.e.live_answer = null;
                    }
                    this.e.float_info = dataRes.float_info;
                }
                long j2 = SharedPrefHelper.getInstance().getLong("key_maintab_banner_close_time", 0L);
                if (this.F != null && !StringHelper.isTaday(j2)) {
                    TbSingleton.getInstance().isAddBanner = true;
                    this.d.add(0, this.F);
                }
                LinkedList linkedList = new LinkedList(this.d);
                v68 v68Var = this.n;
                Integer num = dataRes.is_new_url;
                if (num != null && num.intValue() == 1) {
                    z5 = true;
                }
                v68Var.v(z5);
                this.n.C(linkedList, i2);
                fz9 fz9Var = this.w;
                if (fz9Var != null && this.A) {
                    fz9Var.n(this.x, this.y, this.v, true);
                }
                z5 = true;
            }
            r28.d().i(System.currentTimeMillis() - currentTimeMillis, 1);
            long e2 = r28.d().e(1);
            int i3 = (e2 > 0L ? 1 : (e2 == 0L ? 0 : -1));
            if (i3 > 0) {
                r28.d().k(System.currentTimeMillis() - e2, 1);
                r28.d().j(0L, 1);
            }
            Anti anti = dataRes.anti;
            if (anti != null && (blockPopInfo = anti.block_pop_info) != null) {
                ypa.h(blockPopInfo);
            }
            q35 q35Var = new q35();
            q35Var.a(dataRes.recom_post_topic);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921333, q35Var));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921543, null));
            if (!z2 && i3 > 0) {
                ht5.a().C(System.currentTimeMillis() - e2);
            }
            return z5;
        }
        return invokeCommon.booleanValue;
    }

    public void R0(int i2, int i3) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) && !ListUtils.isEmpty(this.d) && this.d.size() > i2 && i2 >= 0 && i2 >= 0 && i3 >= 0) {
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
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r2 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        if (r2 == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        r3 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Integer> n0(String str, BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048632, this, str, bdTypeRecyclerView)) == null) {
            ArrayList arrayList = new ArrayList(2);
            int i2 = 0;
            boolean z2 = false;
            int i3 = -1;
            int i4 = -1;
            while (i2 < bdTypeRecyclerView.getCount()) {
                cn item = bdTypeRecyclerView.getItem(i2);
                if (item instanceof c28) {
                    if (!str.equals(((c28) item).getTid())) {
                        i2++;
                    }
                } else if (item instanceof hq6) {
                    if (!str.equals(((hq6) item).getTid())) {
                        i2++;
                    }
                } else {
                    if (item instanceof up6) {
                        up6 up6Var = (up6) item;
                        if (up6Var.getThreadData() != null && up6Var.getThreadData().getTid().equals(str)) {
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

    public final void U(List<cn> list, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048596, this, list, i2) == null) {
            Set<cn> a2 = l2a.a(list, this.f, "HOME");
            if (a2.size() > 0) {
                vfa.g().c(this.G, sfa.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public void U0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, bdUniqueId) != null) || bdUniqueId == null) {
            return;
        }
        this.G = bdUniqueId;
        CustomMessageListener customMessageListener = this.e0;
        if (customMessageListener != null) {
            customMessageListener.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.e0);
        }
        CustomMessageListener customMessageListener2 = this.Z;
        if (customMessageListener2 != null) {
            customMessageListener2.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.Z);
        }
        this.a0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.a0);
        this.g0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.g0);
        this.h0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(2001335, this.h0);
        MessageManager.getInstance().registerListener(2001336, this.h0);
        this.f0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f0);
        this.n0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.n0);
        this.o0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.o0);
        this.p0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.p0);
        this.q0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.q0);
        fz9 fz9Var = this.w;
        if (fz9Var != null) {
            fz9Var.u(bdUniqueId);
        }
        this.b.i(bdUniqueId);
        this.m0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.m0);
        this.s0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.s0);
        this.t0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.t0);
        this.b0.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.b0);
        this.Y.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.Y);
    }

    public void W0(int i2, List<cn> list, int i3) {
        jha jhaVar;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), list, Integer.valueOf(i3)}) != null) || (jhaVar = this.r) == null) {
            return;
        }
        if (i2 == 0) {
            jhaVar.d();
        }
        if (list != null && !list.isEmpty()) {
            int[] iArr = jha.e;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < list.size() && i5 < iArr.length && (i4 = iArr[i5]) >= 0; i7++) {
                if ((list.get(i7) instanceof up6) && (i6 = i6 + 1) == i4 - 1) {
                    int i8 = i7 + 1;
                    if (i3 < i8) {
                        this.r.a(i4, i8);
                    }
                    i5++;
                }
            }
        }
    }

    public final void Y(DataRes.Builder builder, int i2) {
        BannerList bannerList;
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048604, this, builder, i2) != null) || builder == null || (bannerList = builder.banner_list) == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        Iterator<App> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b2 = m2a.b(next);
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

    public void b0(Long l2) {
        DataRes.Builder builder;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048610, this, l2) == null) && (builder = this.e) != null && (list = builder.thread_list) != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ThreadInfo threadInfo = list.get(i2);
                if (threadInfo.tid.equals(l2) && threadInfo.top_agree_post != null) {
                    ThreadInfo.Builder builder2 = new ThreadInfo.Builder(threadInfo);
                    builder2.top_agree_post = null;
                    list.set(i2, builder2.build(true));
                    j1();
                    P0(false, true, false, this.e.build(true));
                    return;
                }
            }
        }
    }

    public void o0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, customResponsedMessage) == null) && customResponsedMessage != null && (builder = this.e) != null && ListUtils.getCount(builder.thread_list) != 0) {
            String str = (String) customResponsedMessage.getData();
            a88.a(str, this.d);
            a88.c(str, this.e, this.r0);
            if (this.n != null) {
                TbSingleton.getInstance().mIsForceLayoutMaintab = true;
                this.n.B(new ArrayList(this.d));
            }
            fz9 fz9Var = this.w;
            if (fz9Var != null && this.A) {
                fz9Var.n(this.x, this.y, this.v, true);
            }
        }
    }

    public void p0(e78 e78Var) {
        BdTypeRecyclerView bdTypeRecyclerView;
        n78 n78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, e78Var) == null) && (bdTypeRecyclerView = this.k) != null && (n78Var = this.q) != null && n78Var.r(this.d, e78Var, bdTypeRecyclerView.getFirstVisiblePosition(), this.k.getLastVisiblePosition()) && this.O != null) {
            this.n.B(this.d);
            this.O.c();
            if (e78Var != null && !TextUtils.isEmpty(e78Var.a())) {
                t0(e78Var.a());
            }
        }
    }

    public final boolean w0(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048642, this, z2)) == null) {
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            long j2 = sharedPrefHelper.getLong("recommend_frs_refresh_time" + TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j2 != 0) {
                if (Math.abs(System.currentTimeMillis() - j2) > this.a) {
                    return true;
                }
                return false;
            }
            return z2;
        }
        return invokeZ.booleanValue;
    }

    public final void d0(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        Long l2;
        String tid;
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
                        cn item = this.k.getItem(i2);
                        if (item instanceof bq6) {
                            bq6 bq6Var = (bq6) item;
                            if (bq6Var.getThreadData() != null && bq6Var.getThreadData().getThreadAlaInfo() != null && optString2.equals(String.valueOf(bq6Var.getThreadData().getThreadAlaInfo().live_id))) {
                                optString = bq6Var.getThreadData().getTid();
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
            Iterator<cn> it = this.d.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                cn next = it.next();
                if (next instanceof up6) {
                    up6 up6Var = (up6) next;
                    boolean z3 = next instanceof c28;
                    if (z3 || (up6Var.getThreadData() != null && up6Var.getThreadData().getTid() != null)) {
                        if (z3) {
                            tid = ((c28) next).getTid();
                        } else {
                            tid = up6Var.getThreadData().getTid();
                        }
                        if (tid.equals(optString)) {
                            it.remove();
                            z2 = true;
                        }
                    }
                } else if (next instanceof hq6) {
                    hq6 hq6Var = (hq6) next;
                    if (hq6Var.getTid() != null && hq6Var.getTid().equals(optString)) {
                        it.remove();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                o78.b(this.d);
            }
            DataRes.Builder builder2 = this.e;
            if (builder2 != null && builder2.thread_list != null) {
                long j2 = JavaTypesHelper.toLong(optString, 0L);
                int i3 = 0;
                while (true) {
                    if (i3 < this.e.thread_list.size()) {
                        ThreadInfo threadInfo = this.e.thread_list.get(i3);
                        if (threadInfo != null && (l2 = threadInfo.tid) != null && l2.longValue() == j2) {
                            w78.d(threadInfo.tid.longValue(), i3, this.e.thread_list, this.d);
                            this.e.thread_list.remove(i3);
                            j1();
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

    public final ThreadCardViewHolder f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            fz9 fz9Var = this.w;
            if (fz9Var != null && fz9Var.j() != null && (this.w.j().getTag() instanceof ThreadCardViewHolder)) {
                return (ThreadCardViewHolder) this.w.j().getTag();
            }
            return null;
        }
        return (ThreadCardViewHolder) invokeV.objValue;
    }

    public final String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return "key_rec_pfirst_load_" + TbadkCoreApplication.getCurrentAccount() + "_" + TbConfig.getVersion();
        }
        return (String) invokeV.objValue;
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            ActivityPrizeData activityPrizeData = TbadkCoreApplication.getInst().getActivityPrizeData();
            if (activityPrizeData.isSwitchTurn() && !StringUtils.isNull(activityPrizeData.getFeedText())) {
                String currentDay = UtilHelper.getCurrentDay();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (!StringUtils.isNull(currentAccount)) {
                    String str = "";
                    String string = SharedPrefHelper.getInstance().getString("activity_prize_feed_text_time", "");
                    boolean z2 = true;
                    if (!StringUtils.isNull(string)) {
                        String[] split = string.split("@");
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
                        i1(4, 0);
                        SharedPrefHelper.getInstance().putString("activity_prize_feed_text_time", str);
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
    public final z95.i j0() {
        InterceptResult invokeV;
        BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout;
        char c2;
        t28 t28Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (!this.B || (bigdaySwipeRefreshLayout = this.l) == null || !bigdaySwipeRefreshLayout.u() || z0()) {
                return null;
            }
            int i2 = this.i;
            boolean z2 = this.C;
            if (z2) {
                vfa.g().h(this.G, false);
                if (w0(false)) {
                    c2 = 3;
                } else if (this.D <= 0) {
                    c2 = 0;
                }
                if (this.t != null) {
                    this.p.f();
                }
                t28Var = this.t;
                if (t28Var == null && t28Var.getCurrentTabType() != 1) {
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
                    return new z95.i(str, this.o);
                }
            } else if (z2 || i2 != 0) {
                return null;
            } else {
                i2 = 0;
            }
            c2 = 2;
            if (this.t != null) {
            }
            t28Var = this.t;
            if (t28Var == null) {
            }
            if (c2 != 2) {
            }
            return TextUtils.isEmpty(str) ? null : null;
        }
        return (z95.i) invokeV.objValue;
    }

    public final void i1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeII(1048625, this, i2, i3) != null) || z0()) {
            return;
        }
        if (this.t != null) {
            this.p.f();
        }
        t28 t28Var = this.t;
        if (t28Var != null && t28Var.getCurrentTabType() != 1) {
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
        t28 t28Var2 = this.t;
        if (t28Var2 != null) {
            FrameLayout frameLayout = t28Var2.getFrameLayout();
            frameLayout.removeView(this.H);
            frameLayout.addView(this.H, layoutParams);
            this.H.g();
        }
    }

    public final void k1(long j2, boolean z2) {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z2)}) == null) && (builder = this.e) != null && !ListUtils.isEmpty(builder.thread_list) && !ListUtils.isEmpty(this.d)) {
            for (cn cnVar : this.d) {
                if (cnVar instanceof up6) {
                    up6 up6Var = (up6) cnVar;
                    if (up6Var.n && j2 == up6Var.getThreadData().getFid() && z2 != up6Var.getThreadData().getForumData().f()) {
                        up6Var.getThreadData().getForumData().o(z2);
                    }
                }
            }
            n78 n78Var = this.q;
            if (n78Var != null) {
                n78Var.I(j2, z2);
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
                j1();
            }
        }
    }

    public void q0() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            DefaultLog.getInstance().i("RecentForumLog", "Loop接口返回");
            if (this.k != null && this.q != null && this.n != null) {
                UserFollowLive.Builder builder = new UserFollowLive.Builder();
                builder._switch = 1;
                builder.user_follow_live = TbSingleton.getInstance().getLiveIndexSecondFloor();
                UserFollowLive build = builder.build(true);
                this.q.n(this.d, build);
                if (build._switch.intValue() == 1 && !ListUtils.isEmpty(build.user_follow_live)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.R = z2;
                if (this.Q.b() > 0 && this.S != null) {
                    DefaultLog.getInstance().i("RecentForumLog", "Loop接口返回成功，开始插入最近逛的吧模快");
                    this.q.s(this.d, this.S, this.R);
                }
                this.n.B(this.d);
                fz9 fz9Var = this.w;
                if (fz9Var != null && this.A) {
                    fz9Var.n(this.x, this.y, this.v, true);
                }
            }
            k5a k5aVar = this.Q;
            k5aVar.e(k5aVar.b() + 1);
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("RecentForumLog", "Loop口返回, 等待值：" + this.Q.b());
        }
    }
}
