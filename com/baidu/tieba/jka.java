package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.DBTableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.PageInfo;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ec7;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.ClickBackCard;
import tbclient.FeedLayout;
import tbclient.LayoutFactory;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.PageData;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public final class jka extends ec7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes d;
    public final List<sb7<?>> e;
    public int f;
    public final Map<String, zb7> g;
    public final Map<String, String> h;
    public ThreadInfo i;
    public final ika j;
    public boolean k;
    public BdUniqueId l;
    public a m;
    public final NetMessageListener n;
    public final hka o;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z);
    }

    /* loaded from: classes6.dex */
    public static final class b<T> implements Comparator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t, t2)) == null) {
                return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((AdvertAppInfo) t).position), Integer.valueOf(((AdvertAppInfo) t2).position));
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jka a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(jka jkaVar) {
            super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jkaVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (((com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest) r0).getLoadType() == 1) goto L13;
         */
        @Override // com.baidu.adp.framework.listener.NetMessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.i(false);
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() != null) {
                    Object extra = responsedMessage.getOrginalMessage().getExtra();
                    if (extra instanceof RecPersonalizeRequest) {
                        z = true;
                    }
                }
                z = false;
                if (responsedMessage.getError() != 0) {
                    this.a.b().d = responsedMessage.getError();
                    this.a.b().e = responsedMessage.getErrorString();
                } else {
                    this.a.b().d = 0;
                    DataRes dataRes = null;
                    if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                        dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                    }
                    this.a.M(dataRes, z, false);
                    this.a.V(dataRes, z);
                }
                ec7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements hka {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jka a;

        public d(jka jkaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jkaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jkaVar;
        }

        @Override // com.baidu.tieba.hka
        public void a(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                Intrinsics.checkNotNullParameter(dataRes, "dataRes");
                this.a.k = true;
                PageData pageData = dataRes.page_data;
                if (pageData == null || ListUtils.isEmpty(pageData.feed_list)) {
                    this.a.L();
                    return;
                }
                this.a.i(false);
                this.a.b().d = 0;
                this.a.d = dataRes;
                this.a.M(dataRes, true, true);
                ec7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
                a A = this.a.A();
                if (A != null) {
                    A.a(this.a.j.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jka(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        DataRes build = new DataRes.Builder().build(true);
        Intrinsics.checkNotNullExpressionValue(build, "Builder().build(true)");
        this.d = build;
        this.e = new ArrayList();
        this.f = 1;
        this.g = new HashMap();
        this.h = new HashMap();
        this.j = new ika();
        this.n = new c(this);
        P();
        MessageManager.getInstance().registerListener(this.n);
        Q();
        t();
        O();
        this.o = new d(this);
    }

    public final void E(sh5 event) {
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            int i = 0;
            if (event.a().length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
            for (Object obj2 : c()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                sb7 sb7Var = (sb7) obj2;
                if (sb7Var instanceof n57) {
                    n57 n57Var = (n57) sb7Var;
                    if (Intrinsics.areEqual(event.a(), n57Var.c.m())) {
                        Map<String, Object> a2 = n57Var.c.a();
                        if (a2 != null) {
                            obj = a2.get("click_back_card");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof ClickBackCard) {
                            lc8 lc8Var = new lc8();
                            lc8Var.Y((ClickBackCard) obj);
                            lc8Var.g = n57Var.c.m();
                            if (lc8.U0.c(lc8Var)) {
                                I(new tb7(lc8Var, "recommend_topic_card"), i2);
                                return;
                            }
                            return;
                        }
                    } else {
                        continue;
                    }
                }
                i = i2;
            }
        }
    }

    public final void q(List<? extends sb7<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (sb7<?> sb7Var : list) {
                if (sb7Var.b() instanceof AdvertAppInfo) {
                    Object b2 = sb7Var.b();
                    if (b2 != null) {
                        arrayList.add((pi) b2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            Set<pi> a2 = zga.a(arrayList, this.f, "HOME");
            if (a2.size() > 0) {
                qua.g().c(this.l, nua.g("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        BannerList bannerList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (bannerList = this.d.banner_list) != null && !bannerList.app.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.d.banner_list.app);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(str, aha.a((App) it.next()))) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    BannerList.Builder builder = new BannerList.Builder(this.d.banner_list);
                    builder.app = arrayList;
                    DataRes.Builder builder2 = new DataRes.Builder(this.d);
                    builder2.banner_list = builder.build(true);
                    this.j.f(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean x(String str) {
        InterceptResult invokeL;
        w57<?> w57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            Iterator<sb7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                sb7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof n57) && (w57Var = ((n57) next).c) != null) {
                    if (Intrinsics.areEqual(str, w57Var.m())) {
                        it.remove();
                        z = true;
                    }
                } else if (next instanceof tb7) {
                    tb7 tb7Var = (tb7) next;
                    if (tb7Var.b() instanceof lc8) {
                        Object b2 = tb7Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((lc8) b2).g)) {
                                it.remove();
                                z = true;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.homepage.concern.data.RecommendTopicCardData");
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final void G(Object data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof ThreadInfo) {
                this.i = (ThreadInfo) data;
            }
        }
    }

    public final void S(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.m = aVar;
        }
    }

    public final void T(BdUniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, uniqueId) == null) {
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            this.l = uniqueId;
        }
    }

    public final boolean U(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, dataRes)) == null) {
            Integer num = dataRes.show_adsense;
            if (num != null && num != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void W(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, obj) == null) && obj != null) {
            b().d(obj);
        }
    }

    public final void w(String tid) {
        ec7.a d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            boolean x = x(tid);
            y(tid);
            if (x && (d2 = d()) != null) {
                d2.a(b());
            }
        }
    }

    public final void F(sb7<?> sb7Var, Map<String, ? extends ThreadData> map) {
        n57 n57Var;
        w57<?> w57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, sb7Var, map) == null) && (sb7Var instanceof n57) && (w57Var = (n57Var = (n57) sb7Var).c) != null) {
            String m = w57Var.m();
            if (!TextUtils.isEmpty(m)) {
                n57Var.c.s(map.get(m));
            }
        }
    }

    public final a A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return (a) invokeV.objValue;
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f = 1;
            MessageManager.getInstance().sendMessage(B(1, 0, null, 1, 0));
        }
    }

    @Override // com.baidu.tieba.ec7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
        }
    }

    @Override // com.baidu.tieba.ec7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && !e()) {
            i(true);
            if (this.k) {
                L();
            } else {
                this.j.b(this.o);
            }
        }
    }

    @Override // com.baidu.tieba.ec7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && !e()) {
            i(true);
            int i = this.f + 1;
            this.f = i;
            MessageManager.getInstance().sendMessage(B(2, 0, null, i, 0));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.h.put("page_from", "recommend");
        }
    }

    public final RecPersonalizeRequest B(int i, int i2, zs5 zs5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), zs5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setIsNewFeed(1);
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            if (zs5Var != null) {
                recPersonalizeRequest.setPreAdThreadCount(zs5Var.a);
                recPersonalizeRequest.setAdFloorInfo(zs5Var.b);
            }
            recPersonalizeRequest.setPn(i3);
            recPersonalizeRequest.setSuggestCount(i4);
            recPersonalizeRequest.setNeedForumlist(0);
            recPersonalizeRequest.setSourceFrom(TbSingleton.getInstance().getInvokeSource());
            if (!TextUtils.isEmpty(TbSingleton.getInstance().getPushTid())) {
                String pushTid = TbSingleton.getInstance().getPushTid();
                TbSingleton.getInstance().setPushTid(null);
                long j = JavaTypesHelper.toLong(pushTid, -1L);
                if (j != -1) {
                    recPersonalizeRequest.setPushTid(j);
                }
            }
            return recPersonalizeRequest;
        }
        return (RecPersonalizeRequest) invokeCommon.objValue;
    }

    public final void C() {
        ThreadInfo threadInfo;
        Long l;
        sb7<?> sb7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || (threadInfo = this.i) == null) {
            return;
        }
        if (threadInfo != null) {
            try {
                l = threadInfo.tid;
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    throw e;
                }
            }
        } else {
            l = null;
        }
        x(String.valueOf(l));
        a97 a97Var = j77.a().get("fake_wall");
        ThreadData threadData = new ThreadData();
        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
        threadData.isFromHomPage = true;
        threadData.parserProtobuf(this.i);
        if (a97Var != null) {
            sb7Var = a97Var.b(threadData);
        } else {
            sb7Var = null;
        }
        if (sb7Var != null) {
            b().a.add(0, sb7Var);
        }
        this.i = null;
    }

    public final void D(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        ec7.a d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, customResponsedMessage) == null) && customResponsedMessage != null) {
            List<sb7<?>> list = b().a;
            boolean z2 = false;
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String str = (String) customResponsedMessage.getData();
                if ((str == null || str.length() == 0) ? true : true) {
                    return;
                }
                boolean u = u(str);
                v(str);
                if (u && (d2 = d()) != null) {
                    d2.a(b());
                }
            }
        }
    }

    public final void N(boolean z) {
        qka qkaVar;
        pka pkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            zb7 zb7Var = this.g.get("card_pei_wan_show");
            rka rkaVar = null;
            if (zb7Var instanceof qka) {
                qkaVar = (qka) zb7Var;
            } else {
                qkaVar = null;
            }
            if (qkaVar != null) {
                qkaVar.d(!z);
            }
            zb7 zb7Var2 = this.g.get("card_pei_wan_click");
            if (zb7Var2 instanceof pka) {
                pkaVar = (pka) zb7Var2;
            } else {
                pkaVar = null;
            }
            if (pkaVar != null) {
                pkaVar.d(!z);
            }
            zb7 zb7Var3 = this.g.get("voice_pei_wan_click");
            if (zb7Var3 instanceof rka) {
                rkaVar = (rka) zb7Var3;
            }
            if (rkaVar != null) {
                rkaVar.d(!z);
            }
        }
    }

    public final Map<String, ThreadData> s(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ThreadInfo threadInfo : list) {
                    if (threadInfo != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.isFromHomPage = true;
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(threadInfo);
                        if (K(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            Iterator<sb7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                sb7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next instanceof sb7) {
                    sb7<?> sb7Var = next;
                    if (sb7Var.b() instanceof AdvertAppInfo) {
                        Object b2 = sb7Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((AdvertAppInfo) b2).a)) {
                                it.remove();
                                z = true;
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.core.data.AdvertAppInfo");
                        }
                    } else {
                        continue;
                    }
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final void z(List<sb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (sb7<?> sb7Var : list) {
                if (sb7Var != null) {
                    String a2 = sb7Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "templateData.layout");
                    if (Intrinsics.areEqual("browse_location", a2) || Intrinsics.areEqual("recommend_banner", a2) || Intrinsics.areEqual("ala_live_attention", a2)) {
                        arrayList.add(sb7Var);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void H(boolean z, List<sb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048583, this, z, list) == null) {
            int f = b85.f();
            int e = b85.e();
            int i = 0;
            if (!z && !b().a.isEmpty()) {
                int size = b().a.size() - 1;
                int i2 = 0;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (Intrinsics.areEqual(g37.a(), b().a.get(size).a())) {
                            break;
                        }
                        i2++;
                        if (i3 < 0) {
                            break;
                        }
                        size = i3;
                    }
                }
                if (i2 <= f) {
                    e = f - i2;
                }
            } else {
                e = b85.a();
            }
            if (!ListUtils.isEmpty(list) && e >= 0 && f >= 1) {
                ListIterator<sb7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i == e || (i > e && (i - e) % f == 0)) {
                        lwa lwaVar = new lwa();
                        lwaVar.n(true);
                        listIterator.add(new a37(new y27(lwaVar, z27.d(), false, 4, null), g37.a()));
                    }
                    listIterator.next();
                    i++;
                }
            }
        }
    }

    public void I(sb7<?> sb7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, sb7Var, i) == null) && sb7Var != null && i >= 0 && b().a.size() >= i) {
            b().a.add(i, sb7Var);
            ec7.a d2 = d();
            if (d2 != null) {
                d2.a(b());
            }
        }
    }

    public final void J(DataRes dataRes, List<sb7<?>> list) {
        BannerList bannerList;
        List<App> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, dataRes, list) == null) && (bannerList = dataRes.banner_list) != null && (list2 = bannerList.app) != null) {
            Intrinsics.checkNotNullExpressionValue(list2, "recommendDataRes.banner_list.app");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            for (App app : list2) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                arrayList.add(advertAppInfo);
            }
            for (AdvertAppInfo advertAppInfo2 : CollectionsKt___CollectionsKt.sortedWith(arrayList, new b())) {
                if (advertAppInfo2.l == null) {
                    lja.h(advertAppInfo2, 1, 100);
                } else {
                    int h = advertAppInfo2.h();
                    if (h != 0) {
                        lja.h(advertAppInfo2, 1, h);
                    } else {
                        if (advertAppInfo2.e()) {
                            try {
                                if (TextUtils.isEmpty(advertAppInfo2.q)) {
                                    lja.h(advertAppInfo2, 1, 26);
                                } else if (sva.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo2.q) && e06.a().o()) {
                                    lja.h(advertAppInfo2, 1, 3);
                                }
                            } catch (Exception unused) {
                                lja.h(advertAppInfo2, 1, 100);
                            }
                        }
                        int i = advertAppInfo2.position - 1;
                        advertAppInfo2.position = i;
                        if (i >= 0 && list.size() >= i) {
                            list.add(i, new a37(advertAppInfo2, c37.e(advertAppInfo2.b, advertAppInfo2.c)));
                        } else {
                            zga.n(advertAppInfo2);
                        }
                    }
                }
            }
        }
    }

    public final void V(DataRes dataRes, boolean z) {
        PageData pageData;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048597, this, dataRes, z) == null) {
            if (z) {
                this.j.d();
            }
            if (dataRes == null) {
                return;
            }
            if (z) {
                this.d = dataRes;
                this.j.f(new DataRes.Builder(dataRes));
                this.j.e();
                return;
            }
            DataRes.Builder builder = new DataRes.Builder(this.d);
            PageData.Builder builder2 = new PageData.Builder(this.d.page_data);
            if (builder2.feed_list != null && (pageData = dataRes.page_data) != null && !ListUtils.isEmpty(pageData.feed_list) && builder2.feed_list.size() + dataRes.page_data.feed_list.size() < 30) {
                List<LayoutFactory> list2 = builder2.feed_list;
                List<LayoutFactory> list3 = dataRes.page_data.feed_list;
                Intrinsics.checkNotNullExpressionValue(list3, "dataRes.page_data.feed_list");
                list2.addAll(list3);
                builder.page_data = builder2.build(true);
                BannerList bannerList = dataRes.banner_list;
                if (bannerList != null && !ListUtils.isEmpty(bannerList.app)) {
                    int i = 0;
                    PageData pageData2 = this.d.page_data;
                    if (pageData2 != null && (list = pageData2.feed_list) != null) {
                        i = 0 + list.size();
                    }
                    BannerList.Builder builder3 = new BannerList.Builder(this.d.banner_list);
                    ArrayList arrayList = new ArrayList();
                    for (App app : dataRes.banner_list.app) {
                        App.Builder builder4 = new App.Builder(app);
                        aha.c(builder4, i);
                        App build = builder4.build(true);
                        Intrinsics.checkNotNullExpressionValue(build, "appBuilder.build(true)");
                        arrayList.add(build);
                    }
                    List<App> list4 = builder3.app;
                    if (list4 == null) {
                        builder3.app = arrayList;
                    } else {
                        list4.addAll(arrayList);
                    }
                    builder.banner_list = builder3.build(true);
                }
                DataRes build2 = builder.build(true);
                Intrinsics.checkNotNullExpressionValue(build2, "builder.build(true)");
                this.d = build2;
                this.j.f(builder);
            }
        }
    }

    public final boolean K(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, threadData)) == null) {
            if (threadData == null || threadData.isShareThread || threadData.itemData != null || threadData.itemStarData != null) {
                return false;
            }
            int i = threadData.threadType;
            if (i != 0 && i != 11 && i != 40) {
                return threadData.isUgcThreadType();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void R(JSONObject data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(data);
            httpMessage.addParam("dislike", jSONArray.toString());
            httpMessage.addParam("dislike_from", DBTableDefine.GroupInfoColumns.COLUMN_GROUP_HOMEPAGE);
            httpMessage.setTag(this.l);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public final void r(List<sb7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, list) == null) {
            gka.a.b();
            u57 a2 = gka.a.a();
            a97 a97Var = j77.a().get("browse_location");
            if (a97Var != null) {
                sb7<?> templateData = a97Var.b(a2);
                Intrinsics.checkNotNullExpressionValue(templateData, "templateData");
                list.add(0, templateData);
            }
        }
    }

    public final void M(Message message, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{message, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !(message instanceof DataRes)) {
            return;
        }
        if (z && !z2) {
            this.e.clear();
            List<sb7<?>> list = this.e;
            List<sb7<?>> list2 = b().a;
            Intrinsics.checkNotNullExpressionValue(list2, "feedData.dataList");
            list.addAll(list2);
            z(this.e);
            r(this.e);
            b().a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            N(z2);
            q67 b2 = b();
            if (z && !z2) {
                i = dataRes.page_data.feed_list.size();
            } else {
                i = 0;
            }
            b2.b = i;
            Map<String, ThreadData> s = s(dataRes.thread_list);
            List<LayoutFactory> list3 = dataRes.page_data.feed_list;
            List<sb7<?>> arrayList = new ArrayList<>();
            try {
                for (LayoutFactory layoutFactory : list3) {
                    if (layoutFactory != null) {
                        a97 a97Var = j77.a().get(layoutFactory.layout);
                        if (a97Var instanceof u87) {
                            ((u87) a97Var).j();
                        }
                        if (a97Var != null) {
                            if (a97Var instanceof yb7) {
                                ((yb7) a97Var).d(this.g);
                            }
                            if (a97Var instanceof va7) {
                                ((va7) a97Var).a(this.h);
                            }
                            if (a97Var instanceof h77) {
                                ((h77) a97Var).c(z2);
                            }
                            sb7<?> b3 = a97Var.b(layoutFactory);
                            F(b3, s);
                            if (b3 != null) {
                                arrayList.add(b3);
                            }
                        } else if (Intrinsics.areEqual("template_stub_hot_card", layoutFactory.layout)) {
                            if (jc8.l(new DataRes.Builder((DataRes) message))) {
                                jc8 jc8Var = new jc8();
                                jc8Var.k(((DataRes) message).hot_card);
                                arrayList.add(new tb7<>(jc8Var, "template_stub_hot_card"));
                            }
                        } else if (Intrinsics.areEqual("template_stub_recommend_forums", layoutFactory.layout)) {
                            if (RecommendBarCardModel.t(((DataRes) message).hot_recomforum, -1)) {
                                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                                if (recommendBarCardModel.n(((DataRes) message).hot_recomforum.tab_list)) {
                                    arrayList.add(new tb7<>(new i37(new u77(recommendBarCardModel)), "recommend_bar_layout"));
                                }
                            }
                        } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                            if (((DataRes) message).header_card != null) {
                                lbb lbbVar = new lbb();
                                lbbVar.g(((DataRes) message).header_card);
                                if (rbb.p(lbbVar, false)) {
                                    rbb rbbVar = new rbb();
                                    rbbVar.n(1);
                                    rbbVar.h(lbbVar);
                                    arrayList.add(new tb7<>(rbbVar, "template_stub_head_card"));
                                }
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                C();
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live)) {
                    qm6 qm6Var = new qm6(null, ((DataRes) message).user_follow_live.user_follow_live, "recommend");
                    u77 u77Var = new u77();
                    u77Var.a = qm6Var;
                    b().a.add(0, new tb7(new i37(u77Var), "ala_live_attention"));
                }
                if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                    J((DataRes) message, arrayList);
                } else if (U((DataRes) message)) {
                    H(z, arrayList);
                }
                b().a.addAll(arrayList);
                q(arrayList);
                Integer num = ((DataRes) message).fresh_ctrl_num;
                Intrinsics.checkNotNullExpressionValue(num, "recommendDataRes.fresh_ctrl_num");
                if (num.intValue() > 0) {
                    int size = b().a.size();
                    Integer num2 = ((DataRes) message).fresh_ctrl_num;
                    Intrinsics.checkNotNullExpressionValue(num2, "recommendDataRes.fresh_ctrl_num");
                    if (size > num2.intValue()) {
                        b().a.addAll(this.e);
                        this.e.clear();
                    }
                }
                if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong("key_maintab_banner_close_time", 0L))) {
                    TbSingleton.getInstance().isAddBanner = true;
                }
                if (z && ((DataRes) message).live_answer != null && TbSingleton.getInstance().isAddBanner) {
                    a97 a97Var2 = j77.a().get("recommend_banner");
                    Intrinsics.checkNotNull(a97Var2);
                    sb7<?> b4 = a97Var2.b(((DataRes) message).live_answer);
                    if (b4 != null) {
                        b().a.add(0, b4);
                    }
                }
                int size2 = b().a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    sb7<?> sb7Var = b().a.get(i2);
                    if (sb7Var instanceof g77) {
                        ((g77) sb7Var).setPosition(i2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    System.exit(0);
                }
            }
            b().c = true;
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            HashMap<String, a97> a2 = j77.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("ala_live_attention", new kp6());
            HashMap<String, a97> a3 = j77.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getItemDataMap()");
            a3.put("fake_wall", new lp6());
            HashMap<String, a97> a4 = j77.a();
            Intrinsics.checkNotNullExpressionValue(a4, "getItemDataMap()");
            a4.put("recommend_banner", new mp6());
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, wva.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.g.put(PageInfo.KEY, new xla());
            this.g.put("head_click_selector1", new vka());
            this.g.put("head_click_selector2", new wka());
            this.g.put("head_click_selector3", new xka());
            this.g.put("head_click_selector4", new yka());
            this.g.put("head_click_selector5", new zka());
            this.g.put("head_click_selector6", new ala());
            Map<String, zb7> map = this.g;
            dla dlaVar = new dla();
            dlaVar.d("2");
            map.put("common_click_for_user_head", dlaVar);
            Map<String, zb7> map2 = this.g;
            dla dlaVar2 = new dla();
            dlaVar2.d("9");
            map2.put("common_click_for_forum_head", dlaVar2);
            Map<String, zb7> map3 = this.g;
            dla dlaVar3 = new dla();
            dlaVar3.d("3");
            map3.put("image_click4", dlaVar3);
            Map<String, zb7> map4 = this.g;
            dla dlaVar4 = new dla();
            dlaVar4.d("4");
            map4.put("video_click", dlaVar4);
            Map<String, zb7> map5 = this.g;
            dla dlaVar5 = new dla();
            dlaVar5.d("1");
            map5.put("live_click2", dlaVar5);
            Map<String, zb7> map6 = this.g;
            dla dlaVar6 = new dla();
            dlaVar6.d("1");
            map6.put("comment_btn_click", dlaVar6);
            Map<String, zb7> map7 = this.g;
            uka ukaVar = new uka();
            ukaVar.b("2");
            map7.put("forum_reco_post_click_for_user_head", ukaVar);
            Map<String, zb7> map8 = this.g;
            uka ukaVar2 = new uka();
            ukaVar2.b("9");
            map8.put("forum_reco_post_click_for_forum_head", ukaVar2);
            Map<String, zb7> map9 = this.g;
            uka ukaVar3 = new uka();
            ukaVar3.b("3");
            map9.put("image_click5", ukaVar3);
            Map<String, zb7> map10 = this.g;
            uka ukaVar4 = new uka();
            ukaVar4.b("4");
            map10.put("video_click2", ukaVar4);
            Map<String, zb7> map11 = this.g;
            uka ukaVar5 = new uka();
            ukaVar5.b("1");
            map11.put("live_click3", ukaVar5);
            Map<String, zb7> map12 = this.g;
            uka ukaVar6 = new uka();
            ukaVar6.b("1");
            map12.put("comment_btn_click2", ukaVar6);
            this.g.put("comment_btn_click3", new vla());
            this.g.put("image_click", new ila());
            Map<String, zb7> map13 = this.g;
            yla ylaVar = new yla();
            ylaVar.f(true);
            map13.put("image_click2", ylaVar);
            Map<String, zb7> map14 = this.g;
            sla slaVar = new sla();
            slaVar.f("1");
            map14.put("image_click3", slaVar);
            this.g.put("image_click_selector1", new hla());
            this.g.put("user_head_click", new gq6(1));
            this.g.put("video_user_head_click", new fma());
            this.g.put("live_user_head_click", new lla());
            this.g.put("forum_head_click", new tka());
            this.g.put("forum_head_rec_forum_click", new tla());
            this.g.put("enter_forum_btn_click", new vp6("1"));
            this.g.put("head_local_stat_info", new bla());
            this.g.put("rich_text_topic_click", new eq6());
            Map<String, zb7> map15 = this.g;
            dq6 dq6Var = new dq6();
            dq6Var.b("1");
            map15.put("rich_text_item_click", dq6Var);
            this.g.put("rich_text_video_topic_click", new fq6());
            this.g.put("live_click", new kla());
            Map<String, zb7> map16 = this.g;
            sla slaVar2 = new sla();
            slaVar2.f("2");
            map16.put("voice_btn_click", slaVar2);
            this.g.put("reply_user_head_click1", new ska());
            this.g.put("reply_user_name_click1", new ska());
            this.g.put("reply_card_click1", new ska());
            this.g.put("reply_user_head_click2", new yla());
            this.g.put("reply_user_name_click2", new yla());
            this.g.put("reply_card_click2", new yla());
            this.g.put("head_user_follow", new ama());
            this.g.put("head_user_unfollow", new cma());
            this.g.put("card_pei_wan_show", new qka());
            this.g.put("card_pei_wan_click", new pka());
            this.g.put("voice_pei_wan_click", new rka());
            this.g.put("bottom_comment_click_selector1", new nka());
            this.g.put("bottom_share_click_selector1", new oka());
            this.g.put("bottom_agree_click_selector1", new mka());
            Map<String, zb7> map17 = this.g;
            qla qlaVar = new qla();
            qlaVar.b("5");
            map17.put("live_mix_card_forum_head_click", qlaVar);
            Map<String, zb7> map18 = this.g;
            qla qlaVar2 = new qla();
            qlaVar2.b("4");
            map18.put("live_mix_card_person_head_click", qlaVar2);
            Map<String, zb7> map19 = this.g;
            qla qlaVar3 = new qla();
            qlaVar3.b("1");
            map19.put("live_mix_card_live_image_click", qlaVar3);
            Map<String, zb7> map20 = this.g;
            qla qlaVar4 = new qla();
            qlaVar4.b("3");
            map20.put("live_mix_card_video_image_click", qlaVar4);
            Map<String, zb7> map21 = this.g;
            qla qlaVar5 = new qla();
            qlaVar5.b("2");
            map21.put("live_mix_card_normal_image_click", qlaVar5);
            Map<String, zb7> map22 = this.g;
            qla qlaVar6 = new qla();
            qlaVar6.b("6");
            map22.put("live_mix_card_share_click", qlaVar6);
            Map<String, zb7> map23 = this.g;
            qla qlaVar7 = new qla();
            qlaVar7.b("7");
            map23.put("live_mix_card_comment_click", qlaVar7);
            Map<String, zb7> map24 = this.g;
            qla qlaVar8 = new qla();
            qlaVar8.b("8");
            map24.put("live_mix_card_agree_click", qlaVar8);
        }
    }

    public final boolean y(String str) {
        InterceptResult invokeL;
        PageData pageData;
        FeedLayout feedLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (pageData = this.d.page_data) != null && pageData.feed_list != null) {
                ArrayList arrayList = new ArrayList();
                for (LayoutFactory layoutFactory : this.d.page_data.feed_list) {
                    v57 v57Var = new v57();
                    if (layoutFactory != null && (feedLayout = layoutFactory.feed) != null) {
                        v57Var.b(wa7.a.a(feedLayout.business_info));
                        if (Intrinsics.areEqual(str, v57Var.a().get("thread_id"))) {
                            z = true;
                        } else {
                            arrayList.add(layoutFactory);
                        }
                    } else {
                        arrayList.add(layoutFactory);
                    }
                }
                if (z) {
                    PageData.Builder builder = new PageData.Builder(this.d.page_data);
                    builder.feed_list = arrayList;
                    DataRes.Builder builder2 = new DataRes.Builder(this.d);
                    builder2.page_data = builder.build(true);
                    this.j.f(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
