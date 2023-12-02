package com.baidu.tieba;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.homepage.personalize.bigday.BigdaySwipeRefreshLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.DiscoverHotForum;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
/* loaded from: classes9.dex */
public class za8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public o a;
    public final LinkedList<pi> b;
    public DataRes.Builder c;
    public DataRes.Builder d;
    public DataRes.Builder e;
    public String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public final BdTypeRecyclerView k;
    public final wa8 l;
    public zv6 m;
    public boolean n;
    public final lc8 o;
    public int p;
    public BigdaySwipeRefreshLayout q;
    public int r;
    public List<yx4> s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public RecyclerView.OnScrollListener v;
    public CustomMessageListener w;
    public View.OnTouchListener x;
    public CustomMessageListener y;
    public CustomMessageListener z;

    /* loaded from: classes9.dex */
    public interface o {
        void a(zs5 zs5Var);

        void b();

        void c(boolean z, boolean z2);

        void d(String str, zs5 zs5Var);

        void onError(int i, String str);
    }

    /* loaded from: classes9.dex */
    public class a extends nu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DataRes.Builder a;
        public final /* synthetic */ za8 b;

        public a(za8 za8Var, DataRes.Builder builder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, builder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = za8Var;
            this.a = builder;
        }

        @Override // com.baidu.tieba.nu5
        public Object doInBackground() {
            InterceptResult invokeV;
            DataRes build;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                DataRes.Builder builder = new DataRes.Builder(this.a.build(true));
                e05.k();
                da<byte[]> j = e05.j("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                try {
                    build = builder.build(true);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                if (build != null && !ListUtils.isEmpty(build.thread_info)) {
                    j.g("0", build.toByteArray());
                    za8.U(this.b.f);
                    za8.V(System.currentTimeMillis());
                    return null;
                }
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public final /* synthetic */ za8 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(za8 za8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, Integer.valueOf(i)};
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
            this.f = za8Var;
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
                    this.f.t(customResponsedMessage);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(za8 za8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, Integer.valueOf(i)};
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
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.t(customResponsedMessage);
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(za8 za8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, Integer.valueOf(i)};
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
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.t(customResponsedMessage);
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(za8 za8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, Integer.valueOf(i)};
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
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.s();
        }
    }

    /* loaded from: classes9.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(za8 za8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, Integer.valueOf(i)};
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
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof UpdateAttentionMessage)) {
                return;
            }
            UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
            UpdateAttentionMessage.UpdateAttentionData data = updateAttentionMessage.getData();
            if (data.blockData != null) {
                return;
            }
            if (!data.isSucc) {
                BdToast.makeText(TbadkCoreApplication.getInst().getContext(), updateAttentionMessage.getData().errorString).setIcon(BdToast.ToastIcon.FAILURE).setDuration(3000).show();
            } else if (data.isAttention) {
            } else {
                Iterator it = this.a.b.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof um6) && ThreadCardUtils.isTargetUser(((um6) next).getThreadData(), data.toUid)) {
                        it.remove();
                    }
                }
                yga.c(this.a.b);
                this.a.s.clear();
                if (this.a.b.size() >= 9) {
                    za8 za8Var = this.a;
                    za8Var.X(za8Var.b);
                    this.a.l.d();
                    if (this.a.a != null) {
                        this.a.a.c(false, false);
                    }
                } else {
                    this.a.F();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(za8 za8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, Integer.valueOf(i)};
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
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long) && this.a.c != null && this.a.c.hot_recomforum != null && !ListUtils.isEmpty(this.a.c.hot_recomforum.tab_list)) {
                long longValue = ((Long) customResponsedMessage.getData()).longValue();
                DiscoverHotForum.Builder builder = new DiscoverHotForum.Builder(this.a.c.hot_recomforum);
                if (customResponsedMessage.getCmd() == 2001335) {
                    z = true;
                } else {
                    z = false;
                }
                if (!ya8.c(builder, longValue, z)) {
                    return;
                }
                this.a.c.hot_recomforum = builder.build(true);
                this.a.P(new DataRes.Builder(this.a.c.build(true)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        public h(za8 za8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = za8Var;
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i) == null) && i == 0) {
                em6.b().c();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
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

    /* loaded from: classes9.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(za8 za8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var, Integer.valueOf(i)};
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
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.c != null && !dg9.e(this.a.b)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                yga.d(str, this.a.b);
                yga.d(str, this.a.c.app_list);
                yga.d(str, this.a.s);
                yga.p(this.a.b);
                if (this.a.l != null) {
                    this.a.l.j(new ArrayList(this.a.b));
                }
                za8 za8Var = this.a;
                za8Var.r(za8Var.b);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.a.n)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        public j(za8 za8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = za8Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                if (this.a.m != null) {
                    this.a.m.c(motionEvent);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class k extends nu5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k(za8 za8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e05.k();
                e05.g("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class l implements st5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        public l(za8 za8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) {
                return;
            }
            this.a.K(null);
        }
    }

    /* loaded from: classes9.dex */
    public class m extends nu5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m(za8 za8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nu5
        /* renamed from: a */
        public DataRes doInBackground() {
            InterceptResult invokeV;
            byte[] bArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                e05.k();
                da<byte[]> j = e05.j("tb.concern_page_all", TbadkCoreApplication.getCurrentAccount());
                if (j != null && (bArr = j.get("0")) != null && bArr.length != 0) {
                    try {
                        return (DataRes) new Wire(new Class[0]).parseFrom(bArr, DataRes.class);
                    } catch (IOException e) {
                        BdLog.e(e);
                    }
                }
                return null;
            }
            return (DataRes) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class n implements st5<DataRes> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ za8 a;

        public n(za8 za8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {za8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = za8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.st5
        /* renamed from: a */
        public void onReturnDataInUI(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dataRes) != null) {
                return;
            }
            this.a.K(dataRes);
        }
    }

    public za8(BdPageContext<?> bdPageContext, BdTypeRecyclerView bdTypeRecyclerView, wa8 wa8Var, BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext, bdTypeRecyclerView, wa8Var, bigdaySwipeRefreshLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = new LinkedList<>();
        this.h = false;
        this.i = false;
        this.j = false;
        this.n = false;
        this.r = 0;
        this.s = new ArrayList();
        this.t = new f(this, 2001115);
        this.u = new g(this, 0);
        this.v = new h(this);
        this.w = new i(this, 2016331);
        this.x = new j(this);
        this.y = new b(this, 2921547);
        this.z = new c(this, 2016488);
        this.A = new d(this, 2016553);
        this.B = new e(this, 2921425);
        this.k = bdTypeRecyclerView;
        bdTypeRecyclerView.setOnTouchListener(this.x);
        this.m = new zv6();
        this.o = new lc8();
        this.l = wa8Var;
        bdTypeRecyclerView.setOnScrollListener(this.v);
        this.q = bigdaySwipeRefreshLayout;
        S(false);
    }

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), false);
        }
        return invokeV.booleanValue;
    }

    public static boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!UbsABTestHelper.isConcernForumCardShow() || SharedPrefHelper.getInstance().getInt("key_home_concern_all_status", 0) != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), "");
        }
        return (String) invokeV.objValue;
    }

    public static String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), "");
        }
        return (String) invokeV.objValue;
    }

    public static long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            return SharedPrefHelper.getInstance().getLong(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), 0L);
        }
        return invokeV.longValue;
    }

    public final boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            zs5 q = q(true);
            o oVar = this.a;
            if (oVar != null) {
                oVar.a(q);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !C() && this.g) {
            zs5 q = q(false);
            if (this.a != null) {
                W(true);
                this.a.d(this.f, q);
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.l.f();
        }
    }

    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            F();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.c = new DataRes.Builder(this.d.build(true));
        }
    }

    public void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (I() && !this.i) {
                E();
            } else {
                F();
            }
        }
    }

    public final void c0() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048598, this) != null) || (builder = this.e) == null) {
            return;
        }
        P(builder);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.d = new DataRes.Builder(this.c.build(true));
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public static void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_loaded"), z);
        }
    }

    public static void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_key"), str);
        }
    }

    public static void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_nextpage_update_key"), str);
        }
    }

    public static void V(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j2) == null) {
            SharedPrefHelper.getInstance().putLong(SharedPrefHelper.getSharedPrefKeyWithAccount("key_home_concern_all_status_cache_time"), j2);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public final void K(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dataRes) == null) {
            this.i = true;
            S(true);
            if (dataRes != null) {
                if (O(false, true, dataRes)) {
                    o oVar = this.a;
                    if (oVar != null) {
                        oVar.c(false, true);
                        return;
                    }
                    return;
                }
                F();
                return;
            }
            F();
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && z) {
            this.l.d();
        }
    }

    public final void P(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, builder) != null) || !I()) {
            return;
        }
        ru5.b(new a(this, builder), null);
    }

    public final void W(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.h = z;
        }
    }

    public final void X(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, list) == null) {
            this.l.j(list);
        }
    }

    public void Y(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, oVar) == null) {
            this.a = oVar;
        }
    }

    public void Z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.n = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921517, Boolean.valueOf(this.n)));
        }
    }

    public final zs5 q(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            String e2 = yga.e(this.b, z);
            zs5 zs5Var = new zs5();
            zs5Var.b = e2;
            return zs5Var;
        }
        return (zs5) invokeZ.objValue;
    }

    public final void r(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            jja.f().i("CONCERN", yga.b(list));
        }
    }

    public final int u(boolean z) {
        InterceptResult invokeZ;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048605, this, z)) == null) {
            if (this.o.b && z) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            pi piVar = (pi) ListUtils.getItem(this.b, i2);
            if (piVar instanceof BaseCardInfo) {
                return ((BaseCardInfo) piVar).position - 1;
            }
            return -1;
        }
        return invokeZ.intValue;
    }

    public void A(ThreadData threadData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, threadData, z) == null) {
            threadData.setFromConcern(true);
            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
            DataRes.Builder builder = this.c;
            if ((builder == null || ListUtils.getCount(builder.thread_info) <= 0) && ListUtils.getCount(this.b) <= 1) {
                this.b.clear();
            }
            List<pi> f2 = this.o.f(threadData, u(z), null);
            if (this.o.b && z) {
                this.b.addAll(1, f2);
            } else {
                this.b.addAll(0, f2);
            }
            this.l.j(this.b);
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long x = x();
            long j2 = currentTimeMillis - x;
            if (x != 0 && j2 <= 86400000) {
                ru5.b(new m(this), new n(this));
            } else {
                ru5.b(new k(this), new l(this));
            }
        }
    }

    public final List<pi> H(boolean z, DataRes.Builder builder, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), builder, Boolean.valueOf(z2)})) == null) {
            if (this.c == null) {
                this.c = new DataRes.Builder();
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            zh8 c2 = this.o.c(z, this.c, builder, !z2 ? 1 : 0);
            if (c2 == null) {
                return null;
            }
            return c2.a;
        }
        return (List) invokeCommon.objValue;
    }

    public void M(boolean z, DataRes dataRes, int i2, String str) {
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), dataRes, Integer.valueOf(i2), str}) == null) {
            W(false);
            if (i2 == 0 && dataRes != null && O(true, z, dataRes)) {
                o oVar2 = this.a;
                if (oVar2 != null) {
                    oVar2.c(z, false);
                }
                if (z) {
                    c0();
                }
            } else if (i2 == 0 && ListUtils.getCount(this.b) == 0 && (oVar = this.a) != null) {
                oVar.b();
                BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout = this.q;
                if (bigdaySwipeRefreshLayout != null) {
                    bigdaySwipeRefreshLayout.setRefreshing(false);
                    return;
                }
                return;
            } else if (this.b.size() > 0) {
                o oVar3 = this.a;
                if (oVar3 != null) {
                    oVar3.onError(1, str);
                }
            } else {
                o oVar4 = this.a;
                if (oVar4 != null) {
                    oVar4.onError(2, str);
                }
            }
            BigdaySwipeRefreshLayout bigdaySwipeRefreshLayout2 = this.q;
            if (bigdaySwipeRefreshLayout2 != null) {
                bigdaySwipeRefreshLayout2.setRefreshing(false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean O(boolean z, boolean z2, DataRes dataRes) {
        InterceptResult invokeCommon;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dataRes})) == null) {
            if (dataRes == null) {
                return false;
            }
            if (z2) {
                i2 = 1;
            } else {
                i2 = this.r + 1;
            }
            this.r = i2;
            if (i2 == 1) {
                i3 = 0;
            } else {
                i3 = dg9.i(this.b);
            }
            this.f = dataRes.page_tag;
            this.e = new DataRes.Builder(dataRes);
            if (I()) {
                T(this.f);
            }
            LinkedList linkedList = new LinkedList();
            DataRes.Builder builder = new DataRes.Builder(dataRes);
            this.p = builder.user_tips_type.intValue();
            if (dataRes.req_unix != null) {
                SharedPrefHelper.getInstance().putLong(SharedPrefHelper.getSharedPrefKeyWithAccount("concern_data_res_request_time"), dataRes.req_unix.longValue());
            }
            List<pi> H = H(z, builder, z2);
            y(H, builder, i3);
            this.j = false;
            if (H != null && TbadkCoreApplication.isLogin()) {
                if (ListUtils.isEmpty(H) || (ListUtils.getCount(H) == 1 && (ListUtils.getItem(H, 0) instanceof fc8))) {
                    int i5 = this.p;
                    if (3 == i5) {
                        hc8 hc8Var = new hc8();
                        hc8Var.e = hc8.f;
                        hc8Var.a = 3;
                        H.add(hc8Var);
                        this.j = true;
                    } else if (2 == i5) {
                        hc8 hc8Var2 = new hc8();
                        hc8Var2.a = builder.user_tips_type.intValue();
                        hc8Var2.b = builder.user_tips;
                        if (builder.user_tips_type.intValue() == 4) {
                            hc8Var2.c = true;
                        } else {
                            hc8Var2.d = true;
                        }
                        if (I() && ((i4 = hc8Var2.a) == 2 || i4 == 3)) {
                            if (linkedList.size() > 0) {
                                hc8Var2.a = 0;
                                z4 = false;
                                if (z4) {
                                    linkedList.add(hc8Var2);
                                }
                            } else {
                                hc8Var2.b = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f04cb);
                            }
                        }
                        z4 = true;
                        if (z4) {
                        }
                    }
                }
                linkedList.addAll(H);
            }
            if (builder.has_more.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.g = z3;
            if (ListUtils.isEmpty(linkedList)) {
                if (!this.b.isEmpty()) {
                    Iterator<pi> it = this.b.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    this.l.j(this.b);
                }
                return false;
            }
            this.b.clear();
            this.b.addAll(linkedList);
            if (z2) {
                DataRes.Builder builder2 = this.c;
                builder2.page_tag = dataRes.page_tag;
                builder2.has_more = dataRes.has_more;
                builder2.user_list = dataRes.user_list;
                builder2.user_tips_type = dataRes.user_tips_type;
                builder2.user_tips = dataRes.user_tips;
                builder2.last_tips = dataRes.last_tips;
            }
            DataRes.Builder builder3 = this.c;
            builder3.banner_user_story = dataRes.banner_user_story;
            builder3.banner_follow_live = dataRes.banner_follow_live;
            builder3.user_follow_live = dataRes.user_follow_live;
            builder3.hot_recomforum = dataRes.hot_recomforum;
            builder3.top_tips = dataRes.top_tips;
            builder3.top_user_info = dataRes.top_user_info;
            int i6 = this.p;
            if (i6 == 2 || i6 == 3) {
                DataRes.Builder builder4 = this.c;
                builder4.user_tips_type = dataRes.user_tips_type;
                builder4.user_tips = dataRes.user_tips;
            }
            this.l.j(this.b);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void a0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.z.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.z);
            this.A.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.A);
            this.B.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.B);
            this.t.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.t);
            this.y.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.y);
            this.u.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(2001335, this.u);
            MessageManager.getInstance().registerListener(2001336, this.u);
            this.w.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.w);
        }
    }

    public final List<yx4> d0(List<yx4> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (yx4 yx4Var : list) {
                if (yx4Var instanceof AdvertAppInfo) {
                    arrayList.add(new wm6((AdvertAppInfo) yx4Var));
                } else if (yx4Var instanceof wm6) {
                    arrayList.add((wm6) yx4Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void s() {
        DataRes.Builder builder;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (builder = this.c) != null && ListUtils.getCount(builder.thread_info) != 0 && ListUtils.getCount(this.b) != 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.b.size()) {
                    break;
                } else if (this.b.get(i2) instanceof fc8) {
                    this.b.remove(i2);
                    wa8 wa8Var = this.l;
                    if (wa8Var != null) {
                        wa8Var.j(this.b);
                    }
                } else {
                    i2++;
                }
            }
            for (int i3 = 0; i3 < this.c.thread_info.size(); i3++) {
                if (fc8.f(this.c.thread_info.get(i3))) {
                    this.c.thread_info.remove(i3);
                    c0();
                    return;
                }
            }
        }
    }

    public final void t(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        ThreadInfo threadInfo;
        Long l2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048604, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof JSONObject) && (builder = this.c) != null && ListUtils.getCount(builder.thread_info) != 0 && ListUtils.getCount(this.b) != 0) {
            String optString = ((JSONObject) customResponsedMessage.getData()).optString("tid");
            if (StringUtils.isNull(optString)) {
                return;
            }
            Iterator<pi> it = this.b.iterator();
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                pi next = it.next();
                if (next instanceof um6) {
                    um6 um6Var = (um6) next;
                    if (um6Var.getThreadData() != null && um6Var.getThreadData().getTid() != null) {
                        if (um6Var.getThreadData().getTid().equals(optString)) {
                            it.remove();
                            z = true;
                        } else if (z) {
                            wa8 wa8Var = this.l;
                            if (wa8Var != null) {
                                wa8Var.j(this.b);
                            }
                        }
                    }
                }
            }
            long j2 = JavaTypesHelper.toLong(optString, 0L);
            for (int i2 = 0; i2 < this.c.thread_info.size(); i2++) {
                ConcernData concernData = this.c.thread_info.get(i2);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && (l2 = threadInfo.tid) != null && l2.longValue() == j2) {
                    this.c.thread_info.remove(i2);
                    c0();
                    return;
                }
            }
        }
    }

    public final void y(List<pi> list, DataRes.Builder builder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048606, this, list, builder, i2) == null) {
            List<yx4> d0 = d0(yga.h(builder.app_list, "CONCERN"));
            if (this.c == null) {
                this.c = new DataRes.Builder();
            }
            if (dg9.e(this.c.app_list)) {
                this.c.app_list = new ArrayList();
            }
            this.c.app_list.addAll(builder.app_list);
            if (this.r == 1 || i2 == 0) {
                this.s.clear();
            }
            d0.addAll(this.s);
            if (!dg9.e(d0)) {
                this.s = yga.i(d0, list, i2);
            }
            yga.p(list);
            yga.a(list, this.r, "CONCERN");
            r(list);
        }
    }
}
