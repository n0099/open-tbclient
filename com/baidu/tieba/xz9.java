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
import com.baidu.tieba.ea7;
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
public final class xz9 extends ea7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes d;
    public final List<v97<?>> e;
    public int f;
    public final Map<String, z97> g;
    public final Map<String, String> h;
    public ThreadInfo i;
    public final wz9 j;
    public boolean k;
    public BdUniqueId l;
    public final NetMessageListener m;
    public final vz9 n;

    /* loaded from: classes8.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(xz9 xz9Var) {
            super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
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
            this.a = xz9Var;
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
                this.a.R(dataRes, z);
            }
            ea7.a c = this.a.c();
            if (c != null) {
                c.a(this.a.a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements vz9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xz9 a;

        public b(xz9 xz9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xz9Var;
        }

        @Override // com.baidu.tieba.vz9
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
                ea7.a c = this.a.c();
                if (c != null) {
                    c.a(this.a.a());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xz9(Context context) {
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
        this.j = new wz9();
        this.m = new a(this);
        M();
        MessageManager.getInstance().registerListener(this.m);
        N();
        q();
        this.n = new b(this);
    }

    public final void B(dk5 event) {
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
                v97 v97Var = (v97) obj2;
                if (v97Var instanceof i57) {
                    i57 i57Var = (i57) v97Var;
                    if (Intrinsics.areEqual(event.a(), i57Var.c.g())) {
                        Map<String, Object> a2 = i57Var.c.a();
                        if (a2 != null) {
                            obj = a2.get("click_back_card");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof ClickBackCard) {
                            wy7 wy7Var = new wy7();
                            wy7Var.Y((ClickBackCard) obj);
                            wy7Var.g = i57Var.c.g();
                            if (wy7.U0.c(wy7Var)) {
                                F(new w97(wy7Var, "recommend_topic_card"), i2);
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

    public final void n(List<? extends v97<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (v97<?> v97Var : list) {
                if (v97Var.b() instanceof AdvertAppInfo) {
                    Object b2 = v97Var.b();
                    if (b2 != null) {
                        arrayList.add((ym) b2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            Set<ym> a2 = pw9.a(arrayList, this.f, "HOME");
            if (a2.size() > 0) {
                u9a.g().c(this.l, s9a.e("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public final boolean s(String str) {
        InterceptResult invokeL;
        BannerList bannerList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (bannerList = this.d.banner_list) != null && !bannerList.app.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.d.banner_list.app);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(str, qw9.a((App) it.next()))) {
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
        n57<?> n57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            Iterator<v97<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                v97<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof i57) && (n57Var = ((i57) next).c) != null) {
                    if (Intrinsics.areEqual(str, n57Var.g())) {
                        it.remove();
                        z = true;
                    }
                } else if (next instanceof w97) {
                    w97 w97Var = (w97) next;
                    if (w97Var.b() instanceof wy7) {
                        Object b2 = w97Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((wy7) b2).g)) {
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

    public final void P(BdUniqueId uniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, uniqueId) == null) {
            Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
            this.l = uniqueId;
        }
    }

    public final boolean Q(DataRes dataRes) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, dataRes)) == null) {
            Integer num = dataRes.show_adsense;
            if (num != null && num != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void S(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, obj) == null) && obj != null) {
            a().d(obj);
        }
    }

    public final void t(String tid) {
        ea7.a c;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            boolean u = u(tid);
            v(tid);
            if (u && (c = c()) != null) {
                c.a(a());
            }
        }
    }

    public final void C(v97<?> v97Var, Map<String, ? extends ThreadData> map) {
        i57 i57Var;
        n57<?> n57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, v97Var, map) == null) && (v97Var instanceof i57) && (n57Var = (i57Var = (i57) v97Var).c) != null) {
            String g = n57Var.g();
            if (!TextUtils.isEmpty(g)) {
                i57Var.c.j(map.get(g));
            }
        }
    }

    public final void A(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        ea7.a c;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
            List<v97<?>> list = a().a;
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

    public final Map<String, ThreadData> p(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, list)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            Iterator<v97<?>> it = a().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                v97<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next instanceof v97) {
                    v97<?> v97Var = next;
                    if (v97Var.b() instanceof AdvertAppInfo) {
                        Object b2 = v97Var.b();
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

    public final void x(List<v97<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (v97<?> v97Var : list) {
                if (v97Var != null) {
                    String a2 = v97Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "templateData.layout");
                    if (Intrinsics.areEqual("browse_location", a2) || Intrinsics.areEqual("recommend_banner", a2) || Intrinsics.areEqual("ala_live_attention", a2)) {
                        arrayList.add(v97Var);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void E(boolean z, List<v97<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048580, this, z, list) == null) {
            int f = tb5.f();
            int e = tb5.e();
            int i = 0;
            if (!z && !a().a.isEmpty()) {
                int size = a().a.size() - 1;
                int i2 = 0;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (Intrinsics.areEqual(kha.a(), a().a.get(size).a())) {
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
                e = tb5.a();
            }
            if (!ListUtils.isEmpty(list) && e >= 0 && f >= 1) {
                ListIterator<v97<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i == e || (i > e && (i - e) % f == 0)) {
                        pba pbaVar = new pba();
                        pbaVar.n(true);
                        listIterator.add(new w97(new yp6(pbaVar, null, 2, null), kha.a()));
                    }
                    listIterator.next();
                    i++;
                }
            }
        }
    }

    public final void G(DataRes dataRes, List<v97<?>> list) {
        BannerList bannerList;
        List<App> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, dataRes, list) == null) && (bannerList = dataRes.banner_list) != null && (list2 = bannerList.app) != null) {
            int i = 0;
            for (App app : list2) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                if (advertAppInfo.l == null) {
                    bz9.h(advertAppInfo, 1, 100);
                } else {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        bz9.h(advertAppInfo, 1, h);
                    } else {
                        if (advertAppInfo.e()) {
                            try {
                                if (TextUtils.isEmpty(advertAppInfo.q)) {
                                    bz9.h(advertAppInfo, 1, 26);
                                } else if (waa.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && a26.a().o()) {
                                    bz9.h(advertAppInfo, 1, 3);
                                }
                            } catch (Exception unused) {
                                bz9.h(advertAppInfo, 1, 100);
                            }
                        }
                        int i2 = advertAppInfo.position + i;
                        if (i2 >= 0 && list.size() >= i2) {
                            i++;
                            list.add(i2, new w97(advertAppInfo, hha.d(advertAppInfo.b, advertAppInfo.c)));
                        }
                    }
                }
            }
        }
    }

    public void F(v97<?> v97Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048581, this, v97Var, i) == null) && v97Var != null && i >= 0 && a().a.size() >= i) {
            a().a.add(i, v97Var);
            ea7.a c = c();
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

    public final void O(JSONObject data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, data) == null) {
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

    public final void o(List<v97<?>> list) {
        l77 l77Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            uz9.a.b();
            l57 a2 = uz9.a.a();
            if (a2.d > 0 && (l77Var = p67.a().get("browse_location")) != null) {
                v97<?> templateData = l77Var.b(a2);
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
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.h.put("page_from", "recommend");
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
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
            List<v97<?>> list = this.e;
            List<v97<?>> list2 = a().a;
            Intrinsics.checkNotNullExpressionValue(list2, "feedData.dataList");
            list.addAll(list2);
            x(this.e);
            o(this.e);
            a().a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            a67 a2 = a();
            if (z && !z2) {
                i = dataRes.page_data.feed_list.size();
            } else {
                i = 0;
            }
            a2.b = i;
            Map<String, ThreadData> p = p(dataRes.thread_list);
            List<LayoutFactory> list3 = dataRes.page_data.feed_list;
            List<v97<?>> arrayList = new ArrayList<>();
            try {
                for (LayoutFactory layoutFactory : list3) {
                    if (layoutFactory != null) {
                        l77 l77Var = p67.a().get(layoutFactory.layout);
                        if (l77Var != null) {
                            if (l77Var instanceof y97) {
                                ((y97) l77Var).d(this.g);
                            }
                            if (l77Var instanceof z87) {
                                ((z87) l77Var).a(this.h);
                            }
                            if (l77Var instanceof n67) {
                                ((n67) l77Var).c(z2);
                            }
                            v97<?> b2 = l77Var.b(layoutFactory);
                            C(b2, p);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                        } else if (Intrinsics.areEqual("template_stub_hot_card", layoutFactory.layout)) {
                            if (uy7.l(new DataRes.Builder((DataRes) message))) {
                                uy7 uy7Var = new uy7();
                                uy7Var.i(((DataRes) message).hot_card);
                                arrayList.add(new w97<>(uy7Var, "template_stub_hot_card"));
                            }
                        } else if (Intrinsics.areEqual("template_stub_recommend_forums", layoutFactory.layout)) {
                            if (RecommendBarCardModel.t(((DataRes) message).hot_recomforum, -1)) {
                                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                                if (recommendBarCardModel.m(((DataRes) message).hot_recomforum.tab_list)) {
                                    arrayList.add(new w97<>(new j37(new w67(recommendBarCardModel)), "recommend_bar_layout"));
                                }
                            }
                        } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                            if (((DataRes) message).header_card != null) {
                                uqa uqaVar = new uqa();
                                uqaVar.f(((DataRes) message).header_card);
                                if (xqa.i(uqaVar, false)) {
                                    xqa xqaVar = new xqa();
                                    xqaVar.g(1);
                                    xqaVar.d(uqaVar);
                                    arrayList.add(new w97<>(xqaVar, "template_stub_head_card"));
                                }
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                z();
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live)) {
                    gn6 gn6Var = new gn6(null, ((DataRes) message).user_follow_live.user_follow_live, "recommend");
                    w67 w67Var = new w67();
                    w67Var.a = gn6Var;
                    a().a.add(0, new w97(new j37(w67Var), "ala_live_attention"));
                }
                if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                    G((DataRes) message, arrayList);
                } else if (Q((DataRes) message)) {
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
                    l77 l77Var2 = p67.a().get("recommend_banner");
                    Intrinsics.checkNotNull(l77Var2);
                    v97<?> b3 = l77Var2.b(((DataRes) message).live_answer);
                    if (b3 != null) {
                        a().a.add(0, b3);
                    }
                }
                int size2 = a().a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    v97<?> v97Var = a().a.get(i2);
                    if (v97Var instanceof m67) {
                        ((m67) v97Var).setPosition(i2);
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

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, aba.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.g.put(PageInfo.KEY, new b1a());
            this.g.put("head_click_selector1", new d0a());
            this.g.put("head_click_selector2", new e0a());
            this.g.put("head_click_selector3", new f0a());
            this.g.put("head_click_selector4", new g0a());
            this.g.put("head_click_selector5", new h0a());
            Map<String, z97> map = this.g;
            k0a k0aVar = new k0a();
            k0aVar.d("2");
            map.put("common_click_for_user_head", k0aVar);
            Map<String, z97> map2 = this.g;
            k0a k0aVar2 = new k0a();
            k0aVar2.d("9");
            map2.put("common_click_for_forum_head", k0aVar2);
            Map<String, z97> map3 = this.g;
            k0a k0aVar3 = new k0a();
            k0aVar3.d("3");
            map3.put("image_click4", k0aVar3);
            Map<String, z97> map4 = this.g;
            k0a k0aVar4 = new k0a();
            k0aVar4.d("4");
            map4.put("video_click", k0aVar4);
            Map<String, z97> map5 = this.g;
            k0a k0aVar5 = new k0a();
            k0aVar5.d("1");
            map5.put("live_click2", k0aVar5);
            Map<String, z97> map6 = this.g;
            k0a k0aVar6 = new k0a();
            k0aVar6.d("1");
            map6.put("comment_btn_click", k0aVar6);
            Map<String, z97> map7 = this.g;
            c0a c0aVar = new c0a();
            c0aVar.b("2");
            map7.put("forum_reco_post_click_for_user_head", c0aVar);
            Map<String, z97> map8 = this.g;
            c0a c0aVar2 = new c0a();
            c0aVar2.b("9");
            map8.put("forum_reco_post_click_for_forum_head", c0aVar2);
            Map<String, z97> map9 = this.g;
            c0a c0aVar3 = new c0a();
            c0aVar3.b("3");
            map9.put("image_click5", c0aVar3);
            Map<String, z97> map10 = this.g;
            c0a c0aVar4 = new c0a();
            c0aVar4.b("4");
            map10.put("video_click2", c0aVar4);
            Map<String, z97> map11 = this.g;
            c0a c0aVar5 = new c0a();
            c0aVar5.b("1");
            map11.put("live_click3", c0aVar5);
            Map<String, z97> map12 = this.g;
            c0a c0aVar6 = new c0a();
            c0aVar6.b("1");
            map12.put("comment_btn_click2", c0aVar6);
            this.g.put("comment_btn_click3", new z0a());
            this.g.put("image_click", new o0a());
            Map<String, z97> map13 = this.g;
            c1a c1aVar = new c1a();
            c1aVar.f(true);
            map13.put("image_click2", c1aVar);
            Map<String, z97> map14 = this.g;
            w0a w0aVar = new w0a();
            w0aVar.f("1");
            map14.put("image_click3", w0aVar);
            this.g.put("user_head_click", new zq6(1));
            this.g.put("video_user_head_click", new j1a());
            this.g.put("live_user_head_click", new r0a());
            this.g.put("forum_head_click", new b0a());
            this.g.put("forum_head_rec_forum_click", new x0a());
            this.g.put("enter_forum_btn_click", new oq6("1"));
            this.g.put("head_local_stat_info", new i0a());
            this.g.put("rich_text_topic_click", new xq6());
            Map<String, z97> map15 = this.g;
            wq6 wq6Var = new wq6();
            wq6Var.b("1");
            map15.put("rich_text_item_click", wq6Var);
            this.g.put("rich_text_video_topic_click", new yq6());
            this.g.put("live_click", new q0a());
            Map<String, z97> map16 = this.g;
            w0a w0aVar2 = new w0a();
            w0aVar2.f("2");
            map16.put("voice_btn_click", w0aVar2);
            this.g.put("reply_user_head_click1", new a0a());
            this.g.put("reply_user_name_click1", new a0a());
            this.g.put("reply_card_click1", new a0a());
            this.g.put("reply_user_head_click2", new c1a());
            this.g.put("reply_user_name_click2", new c1a());
            this.g.put("reply_card_click2", new c1a());
            this.g.put("head_user_follow", new e1a());
            this.g.put("head_user_unfollow", new g1a());
        }
    }

    public final void R(DataRes dataRes, boolean z) {
        PageData pageData;
        List<LayoutFactory> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, dataRes, z) == null) {
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
                        qw9.c(builder4, i);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (pageData = this.d.page_data) != null && pageData.feed_list != null) {
                ArrayList arrayList = new ArrayList();
                for (LayoutFactory layoutFactory : this.d.page_data.feed_list) {
                    m57 m57Var = new m57();
                    if (layoutFactory != null && (feedLayout = layoutFactory.feed) != null) {
                        m57Var.b(a97.a.a(feedLayout.business_info));
                        if (Intrinsics.areEqual(str, m57Var.a().get("thread_id"))) {
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

    public final RecPersonalizeRequest y(int i, int i2, xu5 xu5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), xu5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setIsNewFeed(1);
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            if (xu5Var != null) {
                recPersonalizeRequest.setPreAdThreadCount(xu5Var.a);
                recPersonalizeRequest.setAdFloorInfo(xu5Var.b);
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
        v97<?> v97Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048607, this) != null) || (threadInfo = this.i) == null) {
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
        l77 l77Var = p67.a().get("fake_wall");
        ThreadData threadData = new ThreadData();
        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
        threadData.isFromHomPage = true;
        threadData.parserProtobuf(this.i);
        if (l77Var != null) {
            v97Var = l77Var.b(threadData);
        } else {
            v97Var = null;
        }
        if (v97Var != null) {
            a().a.add(0, v97Var);
        }
        this.i = null;
    }
}
