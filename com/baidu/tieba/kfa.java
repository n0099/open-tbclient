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
import com.baidu.tieba.lb7;
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
/* loaded from: classes7.dex */
public final class kfa extends lb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes d;
    public final List<za7<?>> e;
    public int f;
    public final Map<String, gb7> g;
    public final Map<String, String> h;
    public ThreadInfo i;
    public final jfa j;
    public boolean k;
    public BdUniqueId l;
    public final NetMessageListener m;
    public final ifa n;

    /* loaded from: classes7.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kfa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kfa kfaVar) {
            super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kfaVar};
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
            this.a = kfaVar;
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
                    this.a.K(dataRes, z, false);
                    this.a.S(dataRes, z);
                }
                lb7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ifa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ kfa a;

        public b(kfa kfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kfaVar;
        }

        @Override // com.baidu.tieba.ifa
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
                this.a.i(false);
                this.a.b().d = 0;
                this.a.d = dataRes;
                this.a.K(dataRes, true, true);
                lb7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kfa(Context context) {
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
        this.j = new jfa();
        this.m = new a(this);
        N();
        MessageManager.getInstance().registerListener(this.m);
        O();
        s();
        M();
        this.n = new b(this);
    }

    public final void C(ih5 event) {
        boolean z;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, event) == null) {
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
                za7 za7Var = (za7) obj2;
                if (za7Var instanceof v47) {
                    v47 v47Var = (v47) za7Var;
                    if (Intrinsics.areEqual(event.a(), v47Var.c.m())) {
                        Map<String, Object> a2 = v47Var.c.a();
                        if (a2 != null) {
                            obj = a2.get("click_back_card");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof ClickBackCard) {
                            k98 k98Var = new k98();
                            k98Var.Y((ClickBackCard) obj);
                            k98Var.g = v47Var.c.m();
                            if (k98.U0.c(k98Var)) {
                                G(new ab7(k98Var, "recommend_topic_card"), i2);
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

    public final void p(List<? extends za7<?>> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, list) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (za7<?> za7Var : list) {
                if (za7Var.b() instanceof AdvertAppInfo) {
                    Object b2 = za7Var.b();
                    if (b2 != null) {
                        arrayList.add((oi) b2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            Set<oi> a2 = bca.a(arrayList, this.f, "HOME");
            if (a2.size() > 0) {
                wpa.g().c(this.l, tpa.g("a002", "common_fill", true, a2.size()));
            }
        }
    }

    public final boolean u(String str) {
        InterceptResult invokeL;
        BannerList bannerList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (bannerList = this.d.banner_list) != null && !bannerList.app.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.d.banner_list.app);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(str, cca.a((App) it.next()))) {
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

    public final boolean w(String str) {
        InterceptResult invokeL;
        e57<?> e57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            Iterator<za7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                za7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof v47) && (e57Var = ((v47) next).c) != null) {
                    if (Intrinsics.areEqual(str, e57Var.m())) {
                        it.remove();
                        z = true;
                    }
                } else if (next instanceof ab7) {
                    ab7 ab7Var = (ab7) next;
                    if (ab7Var.b() instanceof k98) {
                        Object b2 = ab7Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((k98) b2).g)) {
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

    public final void E(Object data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, data) == null) {
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
            b().d(obj);
        }
    }

    public final void v(String tid) {
        lb7.a d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            boolean w = w(tid);
            x(tid);
            if (w && (d = d()) != null) {
                d.a(b());
            }
        }
    }

    public final void D(za7<?> za7Var, Map<String, ? extends ThreadData> map) {
        v47 v47Var;
        e57<?> e57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, za7Var, map) == null) && (za7Var instanceof v47) && (e57Var = (v47Var = (v47) za7Var).c) != null) {
            String m = e57Var.m();
            if (!TextUtils.isEmpty(m)) {
                v47Var.c.s(map.get(m));
            }
        }
    }

    public final void A() {
        ThreadInfo threadInfo;
        Long l;
        za7<?> za7Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (threadInfo = this.i) == null) {
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
        w(String.valueOf(l));
        i87 i87Var = r67.a().get("fake_wall");
        ThreadData threadData = new ThreadData();
        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
        threadData.isFromHomPage = true;
        threadData.parserProtobuf(this.i);
        if (i87Var != null) {
            za7Var = i87Var.b(threadData);
        } else {
            za7Var = null;
        }
        if (za7Var != null) {
            b().a.add(0, za7Var);
        }
        this.i = null;
    }

    public final void B(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        lb7.a d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null) {
            List<za7<?>> list = b().a;
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
                boolean t = t(str);
                u(str);
                if (t && (d = d()) != null) {
                    d.a(b());
                }
            }
        }
    }

    public final void L(boolean z) {
        rfa rfaVar;
        qfa qfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            gb7 gb7Var = this.g.get("card_pei_wan_show");
            sfa sfaVar = null;
            if (gb7Var instanceof rfa) {
                rfaVar = (rfa) gb7Var;
            } else {
                rfaVar = null;
            }
            if (rfaVar != null) {
                rfaVar.d(!z);
            }
            gb7 gb7Var2 = this.g.get("card_pei_wan_click");
            if (gb7Var2 instanceof qfa) {
                qfaVar = (qfa) gb7Var2;
            } else {
                qfaVar = null;
            }
            if (qfaVar != null) {
                qfaVar.d(!z);
            }
            gb7 gb7Var3 = this.g.get("voice_pei_wan_click");
            if (gb7Var3 instanceof sfa) {
                sfaVar = (sfa) gb7Var3;
            }
            if (sfaVar != null) {
                sfaVar.d(!z);
            }
        }
    }

    public final Map<String, ThreadData> r(List<ThreadInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, list)) == null) {
            HashMap hashMap = new HashMap();
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && list != null) {
                for (ThreadInfo threadInfo : list) {
                    if (threadInfo != null) {
                        ThreadData threadData = new ThreadData();
                        threadData.isFromHomPage = true;
                        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                        threadData.parserProtobuf(threadInfo);
                        if (I(threadData)) {
                            hashMap.put(threadData.tid, threadData);
                        }
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public final boolean t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            Iterator<za7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                za7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next instanceof za7) {
                    za7<?> za7Var = next;
                    if (za7Var.b() instanceof AdvertAppInfo) {
                        Object b2 = za7Var.b();
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

    public final void y(List<za7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (za7<?> za7Var : list) {
                if (za7Var != null) {
                    String a2 = za7Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "templateData.layout");
                    if (Intrinsics.areEqual("browse_location", a2) || Intrinsics.areEqual("recommend_banner", a2) || Intrinsics.areEqual("ala_live_attention", a2)) {
                        arrayList.add(za7Var);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void F(boolean z, List<za7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048581, this, z, list) == null) {
            int f = r75.f();
            int e = r75.e();
            int i = 0;
            if (!z && !b().a.isEmpty()) {
                int size = b().a.size() - 1;
                int i2 = 0;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (Intrinsics.areEqual(q27.a(), b().a.get(size).a())) {
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
                e = r75.a();
            }
            if (!ListUtils.isEmpty(list) && e >= 0 && f >= 1) {
                ListIterator<za7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i == e || (i > e && (i - e) % f == 0)) {
                        sra sraVar = new sra();
                        sraVar.n(true);
                        listIterator.add(new k27(new i27(sraVar, false, null, 6, null), q27.a()));
                    }
                    listIterator.next();
                    i++;
                }
            }
        }
    }

    public final void H(DataRes dataRes, List<za7<?>> list) {
        BannerList bannerList;
        List<App> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, dataRes, list) == null) && (bannerList = dataRes.banner_list) != null && (list2 = bannerList.app) != null) {
            int i = 0;
            for (App app : list2) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                if (advertAppInfo.l == null) {
                    nea.h(advertAppInfo, 1, 100);
                } else {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        nea.h(advertAppInfo, 1, h);
                    } else {
                        if (advertAppInfo.e()) {
                            try {
                                if (TextUtils.isEmpty(advertAppInfo.q)) {
                                    nea.h(advertAppInfo, 1, 26);
                                } else if (yqa.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && sz5.a().o()) {
                                    nea.h(advertAppInfo, 1, 3);
                                }
                            } catch (Exception unused) {
                                nea.h(advertAppInfo, 1, 100);
                            }
                        }
                        int i2 = advertAppInfo.position + i;
                        if (i2 >= 0 && list.size() >= i2) {
                            i++;
                            list.add(i2, new k27(advertAppInfo, m27.e(advertAppInfo.b, advertAppInfo.c)));
                        }
                    }
                }
            }
        }
    }

    public void G(za7<?> za7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, za7Var, i) == null) && za7Var != null && i >= 0 && b().a.size() >= i) {
            b().a.add(i, za7Var);
            lb7.a d = d();
            if (d != null) {
                d.a(b());
            }
        }
    }

    public final boolean I(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, threadData)) == null) {
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

    public final void q(List<za7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            hfa.a.b();
            c57 a2 = hfa.a.a();
            i87 i87Var = r67.a().get("browse_location");
            if (i87Var != null) {
                za7<?> templateData = i87Var.b(a2);
                Intrinsics.checkNotNullExpressionValue(templateData, "templateData");
                list.add(0, templateData);
            }
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.f = 1;
            MessageManager.getInstance().sendMessage(z(1, 0, null, 1, 0));
        }
    }

    @Override // com.baidu.tieba.lb7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    @Override // com.baidu.tieba.lb7
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && !e()) {
            i(true);
            if (this.k) {
                J();
            } else {
                this.j.c(this.n);
            }
        }
    }

    @Override // com.baidu.tieba.lb7
    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && !e()) {
            i(true);
            int i = this.f + 1;
            this.f = i;
            MessageManager.getInstance().sendMessage(z(2, 0, null, i, 0));
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.h.put("page_from", "recommend");
        }
    }

    public final void K(Message message, boolean z, boolean z2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{message, Boolean.valueOf(z), Boolean.valueOf(z2)}) != null) || !(message instanceof DataRes)) {
            return;
        }
        if (z && !z2) {
            this.e.clear();
            List<za7<?>> list = this.e;
            List<za7<?>> list2 = b().a;
            Intrinsics.checkNotNullExpressionValue(list2, "feedData.dataList");
            list.addAll(list2);
            y(this.e);
            q(this.e);
            b().a.clear();
        }
        DataRes dataRes = (DataRes) message;
        PageData pageData = dataRes.page_data;
        if (pageData != null && !ListUtils.isEmpty(pageData.feed_list)) {
            L(z2);
            y57 b2 = b();
            if (z && !z2) {
                i = dataRes.page_data.feed_list.size();
            } else {
                i = 0;
            }
            b2.b = i;
            Map<String, ThreadData> r = r(dataRes.thread_list);
            List<LayoutFactory> list3 = dataRes.page_data.feed_list;
            List<za7<?>> arrayList = new ArrayList<>();
            try {
                for (LayoutFactory layoutFactory : list3) {
                    if (layoutFactory != null) {
                        i87 i87Var = r67.a().get(layoutFactory.layout);
                        if (i87Var != null) {
                            if (i87Var instanceof fb7) {
                                ((fb7) i87Var).d(this.g);
                            }
                            if (i87Var instanceof ca7) {
                                ((ca7) i87Var).a(this.h);
                            }
                            if (i87Var instanceof p67) {
                                ((p67) i87Var).c(z2);
                            }
                            za7<?> b3 = i87Var.b(layoutFactory);
                            D(b3, r);
                            if (b3 != null) {
                                arrayList.add(b3);
                            }
                        } else if (Intrinsics.areEqual("template_stub_hot_card", layoutFactory.layout)) {
                            if (i98.l(new DataRes.Builder((DataRes) message))) {
                                i98 i98Var = new i98();
                                i98Var.i(((DataRes) message).hot_card);
                                arrayList.add(new ab7<>(i98Var, "template_stub_hot_card"));
                            }
                        } else if (Intrinsics.areEqual("template_stub_recommend_forums", layoutFactory.layout)) {
                            if (RecommendBarCardModel.t(((DataRes) message).hot_recomforum, -1)) {
                                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                                if (recommendBarCardModel.n(((DataRes) message).hot_recomforum.tab_list)) {
                                    arrayList.add(new ab7<>(new s27(new c77(recommendBarCardModel)), "recommend_bar_layout"));
                                }
                            }
                        } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                            if (((DataRes) message).header_card != null) {
                                o6b o6bVar = new o6b();
                                o6bVar.g(((DataRes) message).header_card);
                                if (u6b.p(o6bVar, false)) {
                                    u6b u6bVar = new u6b();
                                    u6bVar.n(1);
                                    u6bVar.h(o6bVar);
                                    arrayList.add(new ab7<>(u6bVar, "template_stub_head_card"));
                                }
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                A();
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live)) {
                    bm6 bm6Var = new bm6(null, ((DataRes) message).user_follow_live.user_follow_live, "recommend");
                    c77 c77Var = new c77();
                    c77Var.a = bm6Var;
                    b().a.add(0, new ab7(new s27(c77Var), "ala_live_attention"));
                }
                if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                    H((DataRes) message, arrayList);
                } else if (R((DataRes) message)) {
                    F(z, arrayList);
                }
                b().a.addAll(arrayList);
                p(arrayList);
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
                    i87 i87Var2 = r67.a().get("recommend_banner");
                    Intrinsics.checkNotNull(i87Var2);
                    za7<?> b4 = i87Var2.b(((DataRes) message).live_answer);
                    if (b4 != null) {
                        b().a.add(0, b4);
                    }
                }
                int size2 = b().a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    za7<?> za7Var = b().a.get(i2);
                    if (za7Var instanceof o67) {
                        ((o67) za7Var).setPosition(i2);
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

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            HashMap<String, i87> a2 = r67.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("ala_live_attention", new vo6());
            HashMap<String, i87> a3 = r67.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getItemDataMap()");
            a3.put("fake_wall", new wo6());
            HashMap<String, i87> a4 = r67.a();
            Intrinsics.checkNotNullExpressionValue(a4, "getItemDataMap()");
            a4.put("recommend_banner", new xo6());
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, cra.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.g.put(PageInfo.KEY, new yga());
            this.g.put("head_click_selector1", new wfa());
            this.g.put("head_click_selector2", new xfa());
            this.g.put("head_click_selector3", new yfa());
            this.g.put("head_click_selector4", new zfa());
            this.g.put("head_click_selector5", new aga());
            this.g.put("head_click_selector6", new bga());
            Map<String, gb7> map = this.g;
            ega egaVar = new ega();
            egaVar.d("2");
            map.put("common_click_for_user_head", egaVar);
            Map<String, gb7> map2 = this.g;
            ega egaVar2 = new ega();
            egaVar2.d("9");
            map2.put("common_click_for_forum_head", egaVar2);
            Map<String, gb7> map3 = this.g;
            ega egaVar3 = new ega();
            egaVar3.d("3");
            map3.put("image_click4", egaVar3);
            Map<String, gb7> map4 = this.g;
            ega egaVar4 = new ega();
            egaVar4.d("4");
            map4.put("video_click", egaVar4);
            Map<String, gb7> map5 = this.g;
            ega egaVar5 = new ega();
            egaVar5.d("1");
            map5.put("live_click2", egaVar5);
            Map<String, gb7> map6 = this.g;
            ega egaVar6 = new ega();
            egaVar6.d("1");
            map6.put("comment_btn_click", egaVar6);
            Map<String, gb7> map7 = this.g;
            vfa vfaVar = new vfa();
            vfaVar.b("2");
            map7.put("forum_reco_post_click_for_user_head", vfaVar);
            Map<String, gb7> map8 = this.g;
            vfa vfaVar2 = new vfa();
            vfaVar2.b("9");
            map8.put("forum_reco_post_click_for_forum_head", vfaVar2);
            Map<String, gb7> map9 = this.g;
            vfa vfaVar3 = new vfa();
            vfaVar3.b("3");
            map9.put("image_click5", vfaVar3);
            Map<String, gb7> map10 = this.g;
            vfa vfaVar4 = new vfa();
            vfaVar4.b("4");
            map10.put("video_click2", vfaVar4);
            Map<String, gb7> map11 = this.g;
            vfa vfaVar5 = new vfa();
            vfaVar5.b("1");
            map11.put("live_click3", vfaVar5);
            Map<String, gb7> map12 = this.g;
            vfa vfaVar6 = new vfa();
            vfaVar6.b("1");
            map12.put("comment_btn_click2", vfaVar6);
            this.g.put("comment_btn_click3", new wga());
            this.g.put("image_click", new jga());
            Map<String, gb7> map13 = this.g;
            zga zgaVar = new zga();
            zgaVar.f(true);
            map13.put("image_click2", zgaVar);
            Map<String, gb7> map14 = this.g;
            tga tgaVar = new tga();
            tgaVar.f("1");
            map14.put("image_click3", tgaVar);
            this.g.put("image_click_selector1", new iga());
            this.g.put("user_head_click", new rp6(1));
            this.g.put("video_user_head_click", new gha());
            this.g.put("live_user_head_click", new mga());
            this.g.put("forum_head_click", new ufa());
            this.g.put("forum_head_rec_forum_click", new uga());
            this.g.put("enter_forum_btn_click", new gp6("1"));
            this.g.put("head_local_stat_info", new cga());
            this.g.put("rich_text_topic_click", new pp6());
            Map<String, gb7> map15 = this.g;
            op6 op6Var = new op6();
            op6Var.b("1");
            map15.put("rich_text_item_click", op6Var);
            this.g.put("rich_text_video_topic_click", new qp6());
            this.g.put("live_click", new lga());
            Map<String, gb7> map16 = this.g;
            tga tgaVar2 = new tga();
            tgaVar2.f("2");
            map16.put("voice_btn_click", tgaVar2);
            this.g.put("reply_user_head_click1", new tfa());
            this.g.put("reply_user_name_click1", new tfa());
            this.g.put("reply_card_click1", new tfa());
            this.g.put("reply_user_head_click2", new zga());
            this.g.put("reply_user_name_click2", new zga());
            this.g.put("reply_card_click2", new zga());
            this.g.put("head_user_follow", new bha());
            this.g.put("head_user_unfollow", new dha());
            this.g.put("card_pei_wan_show", new rfa());
            this.g.put("card_pei_wan_click", new qfa());
            this.g.put("voice_pei_wan_click", new sfa());
            this.g.put("bottom_comment_click_selector1", new ofa());
            this.g.put("bottom_share_click_selector1", new pfa());
            this.g.put("bottom_agree_click_selector1", new nfa());
            Map<String, gb7> map17 = this.g;
            rga rgaVar = new rga();
            rgaVar.b("5");
            map17.put("live_mix_card_forum_head_click", rgaVar);
            Map<String, gb7> map18 = this.g;
            rga rgaVar2 = new rga();
            rgaVar2.b("4");
            map18.put("live_mix_card_person_head_click", rgaVar2);
            Map<String, gb7> map19 = this.g;
            rga rgaVar3 = new rga();
            rgaVar3.b("1");
            map19.put("live_mix_card_live_image_click", rgaVar3);
            Map<String, gb7> map20 = this.g;
            rga rgaVar4 = new rga();
            rgaVar4.b("3");
            map20.put("live_mix_card_video_image_click", rgaVar4);
            Map<String, gb7> map21 = this.g;
            rga rgaVar5 = new rga();
            rgaVar5.b("2");
            map21.put("live_mix_card_normal_image_click", rgaVar5);
            Map<String, gb7> map22 = this.g;
            rga rgaVar6 = new rga();
            rgaVar6.b("6");
            map22.put("live_mix_card_share_click", rgaVar6);
            Map<String, gb7> map23 = this.g;
            rga rgaVar7 = new rga();
            rgaVar7.b("7");
            map23.put("live_mix_card_comment_click", rgaVar7);
            Map<String, gb7> map24 = this.g;
            rga rgaVar8 = new rga();
            rgaVar8.b("8");
            map24.put("live_mix_card_agree_click", rgaVar8);
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
                        cca.c(builder4, i);
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

    public final boolean x(String str) {
        InterceptResult invokeL;
        PageData pageData;
        FeedLayout feedLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str) && (pageData = this.d.page_data) != null && pageData.feed_list != null) {
                ArrayList arrayList = new ArrayList();
                for (LayoutFactory layoutFactory : this.d.page_data.feed_list) {
                    d57 d57Var = new d57();
                    if (layoutFactory != null && (feedLayout = layoutFactory.feed) != null) {
                        d57Var.b(da7.a.a(feedLayout.business_info));
                        if (Intrinsics.areEqual(str, d57Var.a().get("thread_id"))) {
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

    public final RecPersonalizeRequest z(int i, int i2, ms5 ms5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ms5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setIsNewFeed(1);
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            if (ms5Var != null) {
                recPersonalizeRequest.setPreAdThreadCount(ms5Var.a);
                recPersonalizeRequest.setAdFloorInfo(ms5Var.b);
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
}
