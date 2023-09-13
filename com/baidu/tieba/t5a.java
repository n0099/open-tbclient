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
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeHttpResponse;
import com.baidu.tieba.homepage.personalize.data.RecPersonalizeRequest;
import com.baidu.tieba.yc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
/* loaded from: classes8.dex */
public final class t5a extends yc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes d;
    public final List<pc7<?>> e;
    public int f;
    public final Map<String, tc7> g;
    public final Map<String, String> h;
    public ThreadInfo i;
    public final s5a j;
    public boolean k;
    public BdUniqueId l;
    public final NetMessageListener m;
    public final r5a n;

    /* loaded from: classes8.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t5a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t5a t5aVar) {
            super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t5aVar};
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
            this.a = t5aVar;
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
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.f(false);
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
                this.a.a().d = responsedMessage.getError();
                this.a.a().e = responsedMessage.getErrorString();
            } else {
                this.a.a().d = 0;
                DataRes dataRes = null;
                if (responsedMessage instanceof RecPersonalizeHttpResponse) {
                    dataRes = ((RecPersonalizeHttpResponse) responsedMessage).getResultData();
                }
                this.a.L(dataRes, z, false);
                this.a.S(dataRes, z);
            }
            yc7.a c = this.a.c();
            if (c != null) {
                c.a(this.a.a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements r5a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t5a a;

        public b(t5a t5aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t5aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t5aVar;
        }

        @Override // com.baidu.tieba.r5a
        public void a(DataRes dataRes) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataRes) == null) {
                Intrinsics.checkNotNullParameter(dataRes, "dataRes");
                this.a.k = true;
                PageData pageData = dataRes.page_data;
                if (pageData == null || ListUtils.isEmpty(pageData.feed_list)) {
                    this.a.J();
                    return;
                }
                this.a.f(false);
                this.a.a().d = 0;
                this.a.d = dataRes;
                this.a.L(dataRes, true, true);
                yc7.a c = this.a.c();
                if (c != null) {
                    c.a(this.a.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t5a(Context context) {
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
        this.j = new s5a();
        this.m = new a(this);
        N();
        MessageManager.getInstance().registerListener(this.m);
        O();
        q();
        this.n = new b(this);
    }

    public final void B(kl5 event) {
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
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
            for (Object obj2 : b()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                pc7 pc7Var = (pc7) obj2;
                if (pc7Var instanceof b87) {
                    b87 b87Var = (b87) pc7Var;
                    if (Intrinsics.areEqual(event.a(), b87Var.c.g())) {
                        Map<String, Object> a2 = b87Var.c.a();
                        if (a2 != null) {
                            obj = a2.get("click_back_card");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof ClickBackCard) {
                            c28 c28Var = new c28();
                            c28Var.Y((ClickBackCard) obj);
                            c28Var.g = b87Var.c.g();
                            if (c28.U0.c(c28Var)) {
                                F(new qc7(c28Var, "recommend_topic_card"), i2);
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

    public final void n(List<? extends pc7<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (pc7<?> pc7Var : list) {
                if (pc7Var.b() instanceof AdvertAppInfo) {
                    Object b2 = pc7Var.b();
                    if (b2 != null) {
                        arrayList.add((cn) b2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            Set<cn> a2 = l2a.a(arrayList, this.f, "HOME");
            if (a2.size() > 0) {
                vfa.g().c(this.l, sfa.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        BannerList bannerList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (bannerList = this.d.banner_list) != null && !bannerList.app.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.d.banner_list.app);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(str, m2a.a((App) it.next()))) {
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    BannerList.Builder builder = new BannerList.Builder(this.d.banner_list);
                    builder.app = arrayList;
                    DataRes.Builder builder2 = new DataRes.Builder(this.d);
                    builder2.banner_list = builder.build(true);
                    this.j.g(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        g87<?> g87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Iterator<pc7<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                pc7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof b87) && (g87Var = ((b87) next).c) != null) {
                    if (Intrinsics.areEqual(str, g87Var.g())) {
                        it.remove();
                        z = true;
                    }
                } else if (next instanceof qc7) {
                    qc7 qc7Var = (qc7) next;
                    if (qc7Var.b() instanceof c28) {
                        Object b2 = qc7Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((c28) b2).g)) {
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

    public final void D(Object data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (data instanceof ThreadInfo) {
                this.i = (ThreadInfo) data;
            }
        }
    }

    public final void Q(BdUniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, uniqueId) == null) {
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            this.l = uniqueId;
        }
    }

    public final boolean R(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, dataRes)) == null) {
            Integer num = dataRes.show_adsense;
            if (num != null && num != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void T(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, obj) == null) && obj != null) {
            a().d(obj);
        }
    }

    public final void t(String tid) {
        yc7.a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            boolean u = u(tid);
            v(tid);
            if (u && (c = c()) != null) {
                c.a(a());
            }
        }
    }

    public final void C(pc7<?> pc7Var, Map<String, ? extends ThreadData> map) {
        b87 b87Var;
        g87<?> g87Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pc7Var, map) == null) && (pc7Var instanceof b87) && (g87Var = (b87Var = (b87) pc7Var).c) != null) {
            String g = g87Var.g();
            if (!TextUtils.isEmpty(g)) {
                b87Var.c.j(map.get(g));
            }
        }
    }

    public final void A(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        yc7.a c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
            List<pc7<?>> list = a().a;
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
                boolean r = r(str);
                s(str);
                if (r && (c = c()) != null) {
                    c.a(a());
                }
            }
        }
    }

    public final void M(boolean z) {
        x5a x5aVar;
        w5a w5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            tc7 tc7Var = this.g.get("card_pei_wan_show");
            y5a y5aVar = null;
            if (tc7Var instanceof x5a) {
                x5aVar = (x5a) tc7Var;
            } else {
                x5aVar = null;
            }
            if (x5aVar != null) {
                x5aVar.d(!z);
            }
            tc7 tc7Var2 = this.g.get("card_pei_wan_click");
            if (tc7Var2 instanceof w5a) {
                w5aVar = (w5a) tc7Var2;
            } else {
                w5aVar = null;
            }
            if (w5aVar != null) {
                w5aVar.d(!z);
            }
            tc7 tc7Var3 = this.g.get("voice_pei_wan_click");
            if (tc7Var3 instanceof y5a) {
                y5aVar = (y5a) tc7Var3;
            }
            if (y5aVar != null) {
                y5aVar.d(!z);
            }
        }
    }

    public final Map<String, ThreadData> p(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ThreadInfo threadInfo : list) {
                    if (threadInfo != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.isFromHomPage = true;
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(threadInfo);
                        if (H(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            Iterator<pc7<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                pc7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next instanceof pc7) {
                    pc7<?> pc7Var = next;
                    if (pc7Var.b() instanceof AdvertAppInfo) {
                        Object b2 = pc7Var.b();
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

    public final void x(List<pc7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (pc7<?> pc7Var : list) {
                if (pc7Var != null) {
                    String a2 = pc7Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "templateData.layout");
                    if (Intrinsics.areEqual("browse_location", a2) || Intrinsics.areEqual("recommend_banner", a2) || Intrinsics.areEqual("ala_live_attention", a2)) {
                        arrayList.add(pc7Var);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void E(boolean z, List<pc7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, list) == null) {
            int f = kc5.f();
            int e = kc5.e();
            int i = 0;
            if (!z && !a().a.isEmpty()) {
                int size = a().a.size() - 1;
                int i2 = 0;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (Intrinsics.areEqual(nna.a(), a().a.get(size).a())) {
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
                e = kc5.a();
            }
            if (!ListUtils.isEmpty(list) && e >= 0 && f >= 1) {
                ListIterator<pc7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i == e || (i > e && (i - e) % f == 0)) {
                        rha rhaVar = new rha();
                        rhaVar.n(true);
                        listIterator.add(new qc7(new ls6(rhaVar, null, 2, null), nna.a()));
                    }
                    listIterator.next();
                    i++;
                }
            }
        }
    }

    public final void G(DataRes dataRes, List<pc7<?>> list) {
        BannerList bannerList;
        List<App> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, dataRes, list) == null) && (bannerList = dataRes.banner_list) != null && (list2 = bannerList.app) != null) {
            int i = 0;
            for (App app : list2) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                if (advertAppInfo.l == null) {
                    x4a.h(advertAppInfo, 1, 100);
                } else {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        x4a.h(advertAppInfo, 1, h);
                    } else {
                        if (advertAppInfo.e()) {
                            try {
                                if (TextUtils.isEmpty(advertAppInfo.q)) {
                                    x4a.h(advertAppInfo, 1, 26);
                                } else if (xga.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && o36.a().o()) {
                                    x4a.h(advertAppInfo, 1, 3);
                                }
                            } catch (Exception unused) {
                                x4a.h(advertAppInfo, 1, 100);
                            }
                        }
                        int i2 = advertAppInfo.position + i;
                        if (i2 >= 0 && list.size() >= i2) {
                            i++;
                            list.add(i2, new qc7(advertAppInfo, kna.d(advertAppInfo.b, advertAppInfo.c)));
                        }
                    }
                }
            }
        }
    }

    public void F(pc7<?> pc7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, pc7Var, i) == null) && pc7Var != null && i >= 0 && a().a.size() >= i) {
            a().a.add(i, pc7Var);
            yc7.a c = c();
            if (c != null) {
                c.a(a());
            }
        }
    }

    public final boolean H(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
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

    public final void P(JSONObject data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, data) == null) {
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

    public final void o(List<pc7<?>> list) {
        ea7 ea7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            q5a.a.b();
            e87 a2 = q5a.a.a();
            if (a2.d > 0 && (ea7Var = i97.a().get("browse_location")) != null) {
                pc7<?> templateData = ea7Var.b(a2);
                Intrinsics.checkNotNullExpressionValue(templateData, "templateData");
                list.add(0, templateData);
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && !d()) {
            f(true);
            if (this.k) {
                J();
            } else {
                this.j.c(this.n);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f = 1;
            MessageManager.getInstance().sendMessage(y(1, 0, null, 1, 0));
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && !d()) {
            f(true);
            int i = this.f + 1;
            this.f = i;
            MessageManager.getInstance().sendMessage(y(2, 0, null, i, 0));
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.h.put("page_from", "recommend");
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    public final void L(Message message, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{message, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !(message instanceof DataRes)) {
            return;
        }
        if (z && !z2) {
            this.e.clear();
            List<pc7<?>> list = this.e;
            List<pc7<?>> list2 = a().a;
            Intrinsics.checkNotNullExpressionValue(list2, "feedData.dataList");
            list.addAll(list2);
            x(this.e);
            o(this.e);
            a().a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            M(z2);
            t87 a2 = a();
            if (z && !z2) {
                i = dataRes.page_data.feed_list.size();
            } else {
                i = 0;
            }
            a2.b = i;
            Map<String, ThreadData> p = p(dataRes.thread_list);
            List<LayoutFactory> list3 = dataRes.page_data.feed_list;
            List<pc7<?>> arrayList = new ArrayList<>();
            try {
                for (LayoutFactory layoutFactory : list3) {
                    if (layoutFactory != null) {
                        ea7 ea7Var = i97.a().get(layoutFactory.layout);
                        if (ea7Var != null) {
                            if (ea7Var instanceof sc7) {
                                ((sc7) ea7Var).d(this.g);
                            }
                            if (ea7Var instanceof tb7) {
                                ((tb7) ea7Var).a(this.h);
                            }
                            if (ea7Var instanceof g97) {
                                ((g97) ea7Var).c(z2);
                            }
                            pc7<?> b2 = ea7Var.b(layoutFactory);
                            C(b2, p);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                        } else if (Intrinsics.areEqual("template_stub_hot_card", layoutFactory.layout)) {
                            if (a28.l(new DataRes.Builder((DataRes) message))) {
                                a28 a28Var = new a28();
                                a28Var.i(((DataRes) message).hot_card);
                                arrayList.add(new qc7<>(a28Var, "template_stub_hot_card"));
                            }
                        } else if (Intrinsics.areEqual("template_stub_recommend_forums", layoutFactory.layout)) {
                            if (RecommendBarCardModel.t(((DataRes) message).hot_recomforum, -1)) {
                                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                                if (recommendBarCardModel.m(((DataRes) message).hot_recomforum.tab_list)) {
                                    arrayList.add(new qc7<>(new b67(new p97(recommendBarCardModel)), "recommend_bar_layout"));
                                }
                            }
                        } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                            if (((DataRes) message).header_card != null) {
                                bxa bxaVar = new bxa();
                                bxaVar.f(((DataRes) message).header_card);
                                if (exa.i(bxaVar, false)) {
                                    exa exaVar = new exa();
                                    exaVar.g(1);
                                    exaVar.d(bxaVar);
                                    arrayList.add(new qc7<>(exaVar, "template_stub_head_card"));
                                }
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                z();
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live)) {
                    qp6 qp6Var = new qp6(null, ((DataRes) message).user_follow_live.user_follow_live, "recommend");
                    p97 p97Var = new p97();
                    p97Var.a = qp6Var;
                    a().a.add(0, new qc7(new b67(p97Var), "ala_live_attention"));
                }
                if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                    G((DataRes) message, arrayList);
                } else if (R((DataRes) message)) {
                    E(z, arrayList);
                }
                a().a.addAll(arrayList);
                n(arrayList);
                Integer num = ((DataRes) message).fresh_ctrl_num;
                Intrinsics.checkNotNullExpressionValue(num, "recommendDataRes.fresh_ctrl_num");
                if (num.intValue() > 0) {
                    int size = a().a.size();
                    Integer num2 = ((DataRes) message).fresh_ctrl_num;
                    Intrinsics.checkNotNullExpressionValue(num2, "recommendDataRes.fresh_ctrl_num");
                    if (size > num2.intValue()) {
                        a().a.addAll(this.e);
                        this.e.clear();
                    }
                }
                if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong("key_maintab_banner_close_time", 0L))) {
                    TbSingleton.getInstance().isAddBanner = true;
                }
                if (z && ((DataRes) message).live_answer != null && TbSingleton.getInstance().isAddBanner) {
                    ea7 ea7Var2 = i97.a().get("recommend_banner");
                    Intrinsics.checkNotNull(ea7Var2);
                    pc7<?> b3 = ea7Var2.b(((DataRes) message).live_answer);
                    if (b3 != null) {
                        a().a.add(0, b3);
                    }
                }
                int size2 = a().a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    pc7<?> pc7Var = a().a.get(i2);
                    if (pc7Var instanceof f97) {
                        ((f97) pc7Var).setPosition(i2);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (GlobalBuildConfig.isDebug()) {
                    System.exit(0);
                }
            }
            a().c = true;
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, bha.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.g.put(PageInfo.KEY, new a7a());
            this.g.put("head_click_selector1", new c6a());
            this.g.put("head_click_selector2", new d6a());
            this.g.put("head_click_selector3", new e6a());
            this.g.put("head_click_selector4", new f6a());
            this.g.put("head_click_selector5", new g6a());
            Map<String, tc7> map = this.g;
            j6a j6aVar = new j6a();
            j6aVar.d("2");
            map.put("common_click_for_user_head", j6aVar);
            Map<String, tc7> map2 = this.g;
            j6a j6aVar2 = new j6a();
            j6aVar2.d("9");
            map2.put("common_click_for_forum_head", j6aVar2);
            Map<String, tc7> map3 = this.g;
            j6a j6aVar3 = new j6a();
            j6aVar3.d("3");
            map3.put("image_click4", j6aVar3);
            Map<String, tc7> map4 = this.g;
            j6a j6aVar4 = new j6a();
            j6aVar4.d("4");
            map4.put("video_click", j6aVar4);
            Map<String, tc7> map5 = this.g;
            j6a j6aVar5 = new j6a();
            j6aVar5.d("1");
            map5.put("live_click2", j6aVar5);
            Map<String, tc7> map6 = this.g;
            j6a j6aVar6 = new j6a();
            j6aVar6.d("1");
            map6.put("comment_btn_click", j6aVar6);
            Map<String, tc7> map7 = this.g;
            b6a b6aVar = new b6a();
            b6aVar.b("2");
            map7.put("forum_reco_post_click_for_user_head", b6aVar);
            Map<String, tc7> map8 = this.g;
            b6a b6aVar2 = new b6a();
            b6aVar2.b("9");
            map8.put("forum_reco_post_click_for_forum_head", b6aVar2);
            Map<String, tc7> map9 = this.g;
            b6a b6aVar3 = new b6a();
            b6aVar3.b("3");
            map9.put("image_click5", b6aVar3);
            Map<String, tc7> map10 = this.g;
            b6a b6aVar4 = new b6a();
            b6aVar4.b("4");
            map10.put("video_click2", b6aVar4);
            Map<String, tc7> map11 = this.g;
            b6a b6aVar5 = new b6a();
            b6aVar5.b("1");
            map11.put("live_click3", b6aVar5);
            Map<String, tc7> map12 = this.g;
            b6a b6aVar6 = new b6a();
            b6aVar6.b("1");
            map12.put("comment_btn_click2", b6aVar6);
            this.g.put("comment_btn_click3", new y6a());
            this.g.put("image_click", new n6a());
            Map<String, tc7> map13 = this.g;
            b7a b7aVar = new b7a();
            b7aVar.f(true);
            map13.put("image_click2", b7aVar);
            Map<String, tc7> map14 = this.g;
            v6a v6aVar = new v6a();
            v6aVar.f("1");
            map14.put("image_click3", v6aVar);
            this.g.put("user_head_click", new mt6(1));
            this.g.put("video_user_head_click", new i7a());
            this.g.put("live_user_head_click", new q6a());
            this.g.put("forum_head_click", new a6a());
            this.g.put("forum_head_rec_forum_click", new w6a());
            this.g.put("enter_forum_btn_click", new bt6("1"));
            this.g.put("head_local_stat_info", new h6a());
            this.g.put("rich_text_topic_click", new kt6());
            Map<String, tc7> map15 = this.g;
            jt6 jt6Var = new jt6();
            jt6Var.b("1");
            map15.put("rich_text_item_click", jt6Var);
            this.g.put("rich_text_video_topic_click", new lt6());
            this.g.put("live_click", new p6a());
            Map<String, tc7> map16 = this.g;
            v6a v6aVar2 = new v6a();
            v6aVar2.f("2");
            map16.put("voice_btn_click", v6aVar2);
            this.g.put("reply_user_head_click1", new z5a());
            this.g.put("reply_user_name_click1", new z5a());
            this.g.put("reply_card_click1", new z5a());
            this.g.put("reply_user_head_click2", new b7a());
            this.g.put("reply_user_name_click2", new b7a());
            this.g.put("reply_card_click2", new b7a());
            this.g.put("head_user_follow", new d7a());
            this.g.put("head_user_unfollow", new f7a());
            this.g.put("card_pei_wan_show", new x5a());
            this.g.put("card_pei_wan_click", new w5a());
            this.g.put("voice_pei_wan_click", new y5a());
        }
    }

    public final void S(DataRes dataRes, boolean z) {
        PageData pageData;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, dataRes, z) == null) {
            if (z) {
                this.j.e();
            }
            if (dataRes == null) {
                return;
            }
            if (z) {
                this.d = dataRes;
                this.j.g(new DataRes.Builder(dataRes));
                this.j.f();
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
                        m2a.c(builder4, i);
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
                this.j.g(builder);
            }
        }
    }

    public final boolean v(String str) {
        InterceptResult invokeL;
        PageData pageData;
        FeedLayout feedLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (pageData = this.d.page_data) != null && pageData.feed_list != null) {
                ArrayList arrayList = new ArrayList();
                for (LayoutFactory layoutFactory : this.d.page_data.feed_list) {
                    f87 f87Var = new f87();
                    if (layoutFactory != null && (feedLayout = layoutFactory.feed) != null) {
                        f87Var.b(ub7.a.a(feedLayout.business_info));
                        if (Intrinsics.areEqual(str, f87Var.a().get("thread_id"))) {
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
                    this.j.g(builder2);
                    DataRes build = builder2.build(true);
                    Intrinsics.checkNotNullExpressionValue(build, "dataResBuilder.build(true)");
                    this.d = build;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public final RecPersonalizeRequest y(int i, int i2, kw5 kw5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), kw5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setIsNewFeed(1);
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            if (kw5Var != null) {
                recPersonalizeRequest.setPreAdThreadCount(kw5Var.a);
                recPersonalizeRequest.setAdFloorInfo(kw5Var.b);
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

    public final void z() {
        ThreadInfo threadInfo;
        Long l;
        pc7<?> pc7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048608, this) != null) || (threadInfo = this.i) == null) {
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
        u(String.valueOf(l));
        ea7 ea7Var = i97.a().get("fake_wall");
        ThreadData threadData = new ThreadData();
        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
        threadData.isFromHomPage = true;
        threadData.parserProtobuf(this.i);
        if (ea7Var != null) {
            pc7Var = ea7Var.b(threadData);
        } else {
            pc7Var = null;
        }
        if (pc7Var != null) {
            a().a.add(0, pc7Var);
        }
        this.i = null;
    }
}
