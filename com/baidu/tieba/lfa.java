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
import com.baidu.tieba.mb7;
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
public final class lfa extends mb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes d;
    public final List<ab7<?>> e;
    public int f;
    public final Map<String, hb7> g;
    public final Map<String, String> h;
    public ThreadInfo i;
    public final kfa j;
    public boolean k;
    public BdUniqueId l;
    public final NetMessageListener m;
    public final jfa n;

    /* loaded from: classes7.dex */
    public static final class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lfa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(lfa lfaVar) {
            super(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, 309264);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
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
            this.a = lfaVar;
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
                mb7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements jfa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lfa a;

        public b(lfa lfaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lfaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lfaVar;
        }

        @Override // com.baidu.tieba.jfa
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
                mb7.a d = this.a.d();
                if (d != null) {
                    d.a(this.a.b());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lfa(Context context) {
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
        this.j = new kfa();
        this.m = new a(this);
        N();
        MessageManager.getInstance().registerListener(this.m);
        O();
        s();
        M();
        this.n = new b(this);
    }

    public final void C(jh5 event) {
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
                ab7 ab7Var = (ab7) obj2;
                if (ab7Var instanceof w47) {
                    w47 w47Var = (w47) ab7Var;
                    if (Intrinsics.areEqual(event.a(), w47Var.c.m())) {
                        Map<String, Object> a2 = w47Var.c.a();
                        if (a2 != null) {
                            obj = a2.get("click_back_card");
                        } else {
                            obj = null;
                        }
                        if (obj instanceof ClickBackCard) {
                            l98 l98Var = new l98();
                            l98Var.Y((ClickBackCard) obj);
                            l98Var.g = w47Var.c.m();
                            if (l98.U0.c(l98Var)) {
                                G(new bb7(l98Var, "recommend_topic_card"), i2);
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

    public final void p(List<? extends ab7<?>> list) {
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
            for (ab7<?> ab7Var : list) {
                if (ab7Var.b() instanceof AdvertAppInfo) {
                    Object b2 = ab7Var.b();
                    if (b2 != null) {
                        arrayList.add((oi) b2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.adp.widget.ListView.IAdapterData");
                    }
                }
            }
            Set<oi> a2 = cca.a(arrayList, this.f, "HOME");
            if (a2.size() > 0) {
                xpa.g().c(this.l, upa.g("a002", "common_fill", true, a2.size()));
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
                    if (Intrinsics.areEqual(str, dca.a((App) it.next()))) {
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
        f57<?> f57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            Iterator<ab7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                ab7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if ((next instanceof w47) && (f57Var = ((w47) next).c) != null) {
                    if (Intrinsics.areEqual(str, f57Var.m())) {
                        it.remove();
                        z = true;
                    }
                } else if (next instanceof bb7) {
                    bb7 bb7Var = (bb7) next;
                    if (bb7Var.b() instanceof l98) {
                        Object b2 = bb7Var.b();
                        if (b2 != null) {
                            if (Intrinsics.areEqual(str, ((l98) b2).g)) {
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
        mb7.a d;
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

    public final void D(ab7<?> ab7Var, Map<String, ? extends ThreadData> map) {
        w47 w47Var;
        f57<?> f57Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ab7Var, map) == null) && (ab7Var instanceof w47) && (f57Var = (w47Var = (w47) ab7Var).c) != null) {
            String m = f57Var.m();
            if (!TextUtils.isEmpty(m)) {
                w47Var.c.s(map.get(m));
            }
        }
    }

    public final void A() {
        ThreadInfo threadInfo;
        Long l;
        ab7<?> ab7Var;
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
        j87 j87Var = s67.a().get("fake_wall");
        ThreadData threadData = new ThreadData();
        AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
        threadData.isFromHomPage = true;
        threadData.parserProtobuf(this.i);
        if (j87Var != null) {
            ab7Var = j87Var.b(threadData);
        } else {
            ab7Var = null;
        }
        if (ab7Var != null) {
            b().a.add(0, ab7Var);
        }
        this.i = null;
    }

    public final void B(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        mb7.a d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) && customResponsedMessage != null) {
            List<ab7<?>> list = b().a;
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
        sfa sfaVar;
        rfa rfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            hb7 hb7Var = this.g.get("card_pei_wan_show");
            tfa tfaVar = null;
            if (hb7Var instanceof sfa) {
                sfaVar = (sfa) hb7Var;
            } else {
                sfaVar = null;
            }
            if (sfaVar != null) {
                sfaVar.d(!z);
            }
            hb7 hb7Var2 = this.g.get("card_pei_wan_click");
            if (hb7Var2 instanceof rfa) {
                rfaVar = (rfa) hb7Var2;
            } else {
                rfaVar = null;
            }
            if (rfaVar != null) {
                rfaVar.d(!z);
            }
            hb7 hb7Var3 = this.g.get("voice_pei_wan_click");
            if (hb7Var3 instanceof tfa) {
                tfaVar = (tfa) hb7Var3;
            }
            if (tfaVar != null) {
                tfaVar.d(!z);
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
            Iterator<ab7<?>> it = b().a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                ab7<?> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
                if (next instanceof ab7) {
                    ab7<?> ab7Var = next;
                    if (ab7Var.b() instanceof AdvertAppInfo) {
                        Object b2 = ab7Var.b();
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

    public final void y(List<ab7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, list) == null) {
            ArrayList arrayList = new ArrayList();
            for (ab7<?> ab7Var : list) {
                if (ab7Var != null) {
                    String a2 = ab7Var.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "templateData.layout");
                    if (Intrinsics.areEqual("browse_location", a2) || Intrinsics.areEqual("recommend_banner", a2) || Intrinsics.areEqual("ala_live_attention", a2)) {
                        arrayList.add(ab7Var);
                    }
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final void F(boolean z, List<ab7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048581, this, z, list) == null) {
            int f = s75.f();
            int e = s75.e();
            int i = 0;
            if (!z && !b().a.isEmpty()) {
                int size = b().a.size() - 1;
                int i2 = 0;
                if (size >= 0) {
                    while (true) {
                        int i3 = size - 1;
                        if (Intrinsics.areEqual(r27.a(), b().a.get(size).a())) {
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
                e = s75.a();
            }
            if (!ListUtils.isEmpty(list) && e >= 0 && f >= 1) {
                ListIterator<ab7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i == e || (i > e && (i - e) % f == 0)) {
                        tra traVar = new tra();
                        traVar.n(true);
                        listIterator.add(new l27(new j27(traVar, false, null, 6, null), r27.a()));
                    }
                    listIterator.next();
                    i++;
                }
            }
        }
    }

    public final void H(DataRes dataRes, List<ab7<?>> list) {
        BannerList bannerList;
        List<App> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, dataRes, list) == null) && (bannerList = dataRes.banner_list) != null && (list2 = bannerList.app) != null) {
            int i = 0;
            for (App app : list2) {
                AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                advertAppInfo.l(app);
                if (advertAppInfo.l == null) {
                    oea.h(advertAppInfo, 1, 100);
                } else {
                    int h = advertAppInfo.h();
                    if (h != 0) {
                        oea.h(advertAppInfo, 1, h);
                    } else {
                        if (advertAppInfo.e()) {
                            try {
                                if (TextUtils.isEmpty(advertAppInfo.q)) {
                                    oea.h(advertAppInfo, 1, 26);
                                } else if (zqa.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && tz5.a().o()) {
                                    oea.h(advertAppInfo, 1, 3);
                                }
                            } catch (Exception unused) {
                                oea.h(advertAppInfo, 1, 100);
                            }
                        }
                        int i2 = advertAppInfo.position + i;
                        if (i2 >= 0 && list.size() >= i2) {
                            i++;
                            list.add(i2, new l27(advertAppInfo, n27.e(advertAppInfo.b, advertAppInfo.c)));
                        }
                    }
                }
            }
        }
    }

    public void G(ab7<?> ab7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, ab7Var, i) == null) && ab7Var != null && i >= 0 && b().a.size() >= i) {
            b().a.add(i, ab7Var);
            mb7.a d = d();
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

    public final void q(List<ab7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            ifa.a.b();
            d57 a2 = ifa.a.a();
            j87 j87Var = s67.a().get("browse_location");
            if (j87Var != null) {
                ab7<?> templateData = j87Var.b(a2);
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

    @Override // com.baidu.tieba.mb7
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }

    @Override // com.baidu.tieba.mb7
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

    @Override // com.baidu.tieba.mb7
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
            List<ab7<?>> list = this.e;
            List<ab7<?>> list2 = b().a;
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
            z57 b2 = b();
            if (z && !z2) {
                i = dataRes.page_data.feed_list.size();
            } else {
                i = 0;
            }
            b2.b = i;
            Map<String, ThreadData> r = r(dataRes.thread_list);
            List<LayoutFactory> list3 = dataRes.page_data.feed_list;
            List<ab7<?>> arrayList = new ArrayList<>();
            try {
                for (LayoutFactory layoutFactory : list3) {
                    if (layoutFactory != null) {
                        j87 j87Var = s67.a().get(layoutFactory.layout);
                        if (j87Var != null) {
                            if (j87Var instanceof gb7) {
                                ((gb7) j87Var).d(this.g);
                            }
                            if (j87Var instanceof da7) {
                                ((da7) j87Var).a(this.h);
                            }
                            if (j87Var instanceof q67) {
                                ((q67) j87Var).c(z2);
                            }
                            ab7<?> b3 = j87Var.b(layoutFactory);
                            D(b3, r);
                            if (b3 != null) {
                                arrayList.add(b3);
                            }
                        } else if (Intrinsics.areEqual("template_stub_hot_card", layoutFactory.layout)) {
                            if (j98.l(new DataRes.Builder((DataRes) message))) {
                                j98 j98Var = new j98();
                                j98Var.i(((DataRes) message).hot_card);
                                arrayList.add(new bb7<>(j98Var, "template_stub_hot_card"));
                            }
                        } else if (Intrinsics.areEqual("template_stub_recommend_forums", layoutFactory.layout)) {
                            if (RecommendBarCardModel.t(((DataRes) message).hot_recomforum, -1)) {
                                RecommendBarCardModel recommendBarCardModel = new RecommendBarCardModel();
                                if (recommendBarCardModel.n(((DataRes) message).hot_recomforum.tab_list)) {
                                    arrayList.add(new bb7<>(new t27(new d77(recommendBarCardModel)), "recommend_bar_layout"));
                                }
                            }
                        } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                            if (((DataRes) message).header_card != null) {
                                p6b p6bVar = new p6b();
                                p6bVar.g(((DataRes) message).header_card);
                                if (v6b.p(p6bVar, false)) {
                                    v6b v6bVar = new v6b();
                                    v6bVar.n(1);
                                    v6bVar.h(p6bVar);
                                    arrayList.add(new bb7<>(v6bVar, "template_stub_head_card"));
                                }
                            }
                        } else {
                            BdLog.e("no layout for " + layoutFactory.layout);
                        }
                    }
                }
                A();
                if (z && ((DataRes) message).user_follow_live != null && !ListUtils.isEmpty(((DataRes) message).user_follow_live.user_follow_live)) {
                    cm6 cm6Var = new cm6(null, ((DataRes) message).user_follow_live.user_follow_live, "recommend");
                    d77 d77Var = new d77();
                    d77Var.a = cm6Var;
                    b().a.add(0, new bb7(new t27(d77Var), "ala_live_attention"));
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
                    j87 j87Var2 = s67.a().get("recommend_banner");
                    Intrinsics.checkNotNull(j87Var2);
                    ab7<?> b4 = j87Var2.b(((DataRes) message).live_answer);
                    if (b4 != null) {
                        b().a.add(0, b4);
                    }
                }
                int size2 = b().a.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    ab7<?> ab7Var = b().a.get(i2);
                    if (ab7Var instanceof p67) {
                        ((p67) ab7Var).setPosition(i2);
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
            HashMap<String, j87> a2 = s67.a();
            Intrinsics.checkNotNullExpressionValue(a2, "getItemDataMap()");
            a2.put("ala_live_attention", new wo6());
            HashMap<String, j87> a3 = s67.a();
            Intrinsics.checkNotNullExpressionValue(a3, "getItemDataMap()");
            a3.put("fake_wall", new xo6());
            HashMap<String, j87> a4 = s67.a();
            Intrinsics.checkNotNullExpressionValue(a4, "getItemDataMap()");
            a4.put("recommend_banner", new yo6());
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_RECOMMEND_PERSONALIZE, dra.a(TbConfig.RECOMMEND_HOME_PAGE_ADDRESS, 309264));
            tbHttpMessageTask.setIsNeedAddCommenParam(true);
            tbHttpMessageTask.setResponsedClass(RecPersonalizeHttpResponse.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.g.put(PageInfo.KEY, new zga());
            this.g.put("head_click_selector1", new xfa());
            this.g.put("head_click_selector2", new yfa());
            this.g.put("head_click_selector3", new zfa());
            this.g.put("head_click_selector4", new aga());
            this.g.put("head_click_selector5", new bga());
            this.g.put("head_click_selector6", new cga());
            Map<String, hb7> map = this.g;
            fga fgaVar = new fga();
            fgaVar.d("2");
            map.put("common_click_for_user_head", fgaVar);
            Map<String, hb7> map2 = this.g;
            fga fgaVar2 = new fga();
            fgaVar2.d("9");
            map2.put("common_click_for_forum_head", fgaVar2);
            Map<String, hb7> map3 = this.g;
            fga fgaVar3 = new fga();
            fgaVar3.d("3");
            map3.put("image_click4", fgaVar3);
            Map<String, hb7> map4 = this.g;
            fga fgaVar4 = new fga();
            fgaVar4.d("4");
            map4.put("video_click", fgaVar4);
            Map<String, hb7> map5 = this.g;
            fga fgaVar5 = new fga();
            fgaVar5.d("1");
            map5.put("live_click2", fgaVar5);
            Map<String, hb7> map6 = this.g;
            fga fgaVar6 = new fga();
            fgaVar6.d("1");
            map6.put("comment_btn_click", fgaVar6);
            Map<String, hb7> map7 = this.g;
            wfa wfaVar = new wfa();
            wfaVar.b("2");
            map7.put("forum_reco_post_click_for_user_head", wfaVar);
            Map<String, hb7> map8 = this.g;
            wfa wfaVar2 = new wfa();
            wfaVar2.b("9");
            map8.put("forum_reco_post_click_for_forum_head", wfaVar2);
            Map<String, hb7> map9 = this.g;
            wfa wfaVar3 = new wfa();
            wfaVar3.b("3");
            map9.put("image_click5", wfaVar3);
            Map<String, hb7> map10 = this.g;
            wfa wfaVar4 = new wfa();
            wfaVar4.b("4");
            map10.put("video_click2", wfaVar4);
            Map<String, hb7> map11 = this.g;
            wfa wfaVar5 = new wfa();
            wfaVar5.b("1");
            map11.put("live_click3", wfaVar5);
            Map<String, hb7> map12 = this.g;
            wfa wfaVar6 = new wfa();
            wfaVar6.b("1");
            map12.put("comment_btn_click2", wfaVar6);
            this.g.put("comment_btn_click3", new xga());
            this.g.put("image_click", new kga());
            Map<String, hb7> map13 = this.g;
            aha ahaVar = new aha();
            ahaVar.f(true);
            map13.put("image_click2", ahaVar);
            Map<String, hb7> map14 = this.g;
            uga ugaVar = new uga();
            ugaVar.f("1");
            map14.put("image_click3", ugaVar);
            this.g.put("image_click_selector1", new jga());
            this.g.put("user_head_click", new sp6(1));
            this.g.put("video_user_head_click", new hha());
            this.g.put("live_user_head_click", new nga());
            this.g.put("forum_head_click", new vfa());
            this.g.put("forum_head_rec_forum_click", new vga());
            this.g.put("enter_forum_btn_click", new hp6("1"));
            this.g.put("head_local_stat_info", new dga());
            this.g.put("rich_text_topic_click", new qp6());
            Map<String, hb7> map15 = this.g;
            pp6 pp6Var = new pp6();
            pp6Var.b("1");
            map15.put("rich_text_item_click", pp6Var);
            this.g.put("rich_text_video_topic_click", new rp6());
            this.g.put("live_click", new mga());
            Map<String, hb7> map16 = this.g;
            uga ugaVar2 = new uga();
            ugaVar2.f("2");
            map16.put("voice_btn_click", ugaVar2);
            this.g.put("reply_user_head_click1", new ufa());
            this.g.put("reply_user_name_click1", new ufa());
            this.g.put("reply_card_click1", new ufa());
            this.g.put("reply_user_head_click2", new aha());
            this.g.put("reply_user_name_click2", new aha());
            this.g.put("reply_card_click2", new aha());
            this.g.put("head_user_follow", new cha());
            this.g.put("head_user_unfollow", new eha());
            this.g.put("card_pei_wan_show", new sfa());
            this.g.put("card_pei_wan_click", new rfa());
            this.g.put("voice_pei_wan_click", new tfa());
            this.g.put("bottom_comment_click_selector1", new pfa());
            this.g.put("bottom_share_click_selector1", new qfa());
            this.g.put("bottom_agree_click_selector1", new ofa());
            Map<String, hb7> map17 = this.g;
            sga sgaVar = new sga();
            sgaVar.b("5");
            map17.put("live_mix_card_forum_head_click", sgaVar);
            Map<String, hb7> map18 = this.g;
            sga sgaVar2 = new sga();
            sgaVar2.b("4");
            map18.put("live_mix_card_person_head_click", sgaVar2);
            Map<String, hb7> map19 = this.g;
            sga sgaVar3 = new sga();
            sgaVar3.b("1");
            map19.put("live_mix_card_live_image_click", sgaVar3);
            Map<String, hb7> map20 = this.g;
            sga sgaVar4 = new sga();
            sgaVar4.b("3");
            map20.put("live_mix_card_video_image_click", sgaVar4);
            Map<String, hb7> map21 = this.g;
            sga sgaVar5 = new sga();
            sgaVar5.b("2");
            map21.put("live_mix_card_normal_image_click", sgaVar5);
            Map<String, hb7> map22 = this.g;
            sga sgaVar6 = new sga();
            sgaVar6.b("6");
            map22.put("live_mix_card_share_click", sgaVar6);
            Map<String, hb7> map23 = this.g;
            sga sgaVar7 = new sga();
            sgaVar7.b("7");
            map23.put("live_mix_card_comment_click", sgaVar7);
            Map<String, hb7> map24 = this.g;
            sga sgaVar8 = new sga();
            sgaVar8.b("8");
            map24.put("live_mix_card_agree_click", sgaVar8);
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
                        dca.c(builder4, i);
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
                    e57 e57Var = new e57();
                    if (layoutFactory != null && (feedLayout = layoutFactory.feed) != null) {
                        e57Var.b(ea7.a.a(feedLayout.business_info));
                        if (Intrinsics.areEqual(str, e57Var.a().get("thread_id"))) {
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

    public final RecPersonalizeRequest z(int i, int i2, ns5 ns5Var, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), ns5Var, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            RecPersonalizeRequest recPersonalizeRequest = new RecPersonalizeRequest();
            recPersonalizeRequest.setIsNewFeed(1);
            recPersonalizeRequest.setLoadType(i);
            recPersonalizeRequest.setThreadCount(i2);
            if (ns5Var != null) {
                recPersonalizeRequest.setPreAdThreadCount(ns5Var.a);
                recPersonalizeRequest.setAdFloorInfo(ns5Var.b);
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
