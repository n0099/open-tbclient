package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserFollowLive;
/* loaded from: classes7.dex */
public class uq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final pv7 a;
    public boolean b;

    public uq7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.a = new pv7();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final oq7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            pv7 pv7Var = this.a;
            if (pv7Var != null && !ListUtils.isEmpty(pv7Var.a)) {
                for (rn rnVar : this.a.a) {
                    if (rnVar instanceof oq7) {
                        return (oq7) rnVar;
                    }
                }
            }
            return null;
        }
        return (oq7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public pv7 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            a(builder);
            a(builder2);
            e(z, builder, builder2, i);
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            UserFollowLive userFollowLive = builder2.user_follow_live;
            if (i == 0 && userFollowLive != null && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                oq7 oq7Var = new oq7();
                oq7Var.d(userFollowLive);
                linkedList.add(0, oq7Var);
                oq7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    oq7 b = b();
                    if (b != null) {
                        linkedList.add(0, b);
                        b.position = -1;
                        this.b = true;
                    }
                } else {
                    this.b = false;
                }
                i2 = 0;
                for (ConcernData concernData : builder.thread_info) {
                    if (concernData != null) {
                        if (qq7.i(builder.hot_recomforum, i2)) {
                            qq7 qq7Var = new qq7();
                            if (qq7Var.f(builder.hot_recomforum.tab_list)) {
                                qq7Var.position = i2;
                                linkedList.add(qq7Var);
                                i2++;
                            }
                        }
                        if (nq7.f(concernData)) {
                            nq7 nq7Var = new nq7();
                            if (concernData.recom_user_list.size() >= 4) {
                                nq7Var.d(concernData.recom_user_list);
                                nq7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                nq7Var.h(z2);
                                linkedList.add(nq7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = jh9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                jh9.f().h("CONCERN", arrayList);
                pv7 pv7Var = this.a;
                pv7Var.a = linkedList;
                return pv7Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            jh9.f().h("CONCERN", arrayList);
            pv7 pv7Var2 = this.a;
            pv7Var2.a = linkedList;
            return pv7Var2;
        }
        return (pv7) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (nq7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!jp7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && nq7.f(concernData2)) {
                        list.add(0, concernData2);
                    } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                        list.add(0, concernData2);
                    }
                }
            }
            this.a.b = ListUtils.getCount(list) - count;
        }
    }

    public final void e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && (list = builder.thread_info) != null && (list2 = builder2.thread_info) != null) {
            d(z, list, list2, i);
            builder.hot_recomforum = builder2.hot_recomforum;
        }
    }

    public List<rn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        ck6 kk6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((kk6.W(threadData) || lk6.P(threadData) || mk6.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (mk6.W(threadData)) {
                    kk6Var = new mk6(threadData);
                } else if (lk6.P(threadData)) {
                    kk6Var = new lk6(threadData);
                } else {
                    kk6Var = new kk6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    kk6Var.a = threadData;
                }
                kk6Var.g = threadData.getTid();
                if (kk6.W(threadData)) {
                    kk6Var.F("1");
                } else if (lk6.P(threadData)) {
                    kk6Var.F("2");
                }
                kk6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && kk6Var.getThreadData() != null && kk6Var.getThreadData().getAuthor() != null) {
                    if (!kk6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        qv7.r(kk6Var);
                        qv7.o(threadData);
                    } else {
                        qv7.t(kk6Var);
                    }
                } else if (kk6Var instanceof mk6) {
                    qv7.t(kk6Var);
                } else {
                    qv7.t(kk6Var);
                }
                kk6Var.a.insertItemToTitleOrAbstractText();
                if (kk6Var instanceof kk6) {
                    if (threadData.isBJHNormalThreadType()) {
                        qv7.u(kk6Var);
                    } else if (threadData.picCount() == 1) {
                        qv7.w(kk6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        kk6Var.j = imageWidthAndHeight[0];
                        kk6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        qv7.v(kk6Var);
                    } else {
                        qv7.x(kk6Var);
                    }
                } else if (kk6Var instanceof lk6) {
                    qv7.y(kk6Var);
                }
                if (kk6Var instanceof mk6) {
                    qv7.z(kk6Var);
                }
                if (threadData.getItem() != null) {
                    qv7.A(kk6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        qv7.D(kk6Var);
                    } else {
                        qv7.B(kk6Var);
                    }
                }
                qv7.q(kk6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    qv7.s(kk6Var);
                }
                qv7.p(kk6Var);
                kk6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                kk6Var.position = i;
                arrayList.add(kk6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    qv7.o(threadData);
                }
                if (threadData.isShareThread) {
                    kk6 kk6Var2 = new kk6();
                    kk6Var2.a = threadData;
                    kk6Var2.position = i;
                    arrayList.add(kk6Var2);
                } else if (lk6.P(threadData)) {
                    lk6 lk6Var = new lk6(threadData);
                    lk6Var.g = threadData.getTid();
                    if (concernData != null) {
                        lk6Var.E(concernData.source.intValue());
                    }
                    if (lk6Var.isValid()) {
                        arrayList.add(lk6Var);
                    }
                } else if (jk6.W(threadData)) {
                    jk6 jk6Var = new jk6(threadData);
                    jk6Var.g = threadData.getTid();
                    jk6Var.F("3");
                    if (jk6Var.isValid()) {
                        arrayList.add(jk6Var);
                    }
                } else if (fk6.W(threadData) && threadData.isBJHArticleThreadType()) {
                    fk6 fk6Var = new fk6(threadData);
                    fk6Var.position = i;
                    arrayList.add(fk6Var);
                } else {
                    kk6 kk6Var3 = new kk6();
                    kk6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    kk6Var3.F(str);
                    kk6Var3.position = i;
                    if (concernData != null) {
                        kk6Var3.E(concernData.source.intValue());
                    }
                    if (kk6Var3.a != null && kk6Var3.isValid() && !StringUtils.isNull(kk6Var3.a.getId()) && !"0".equals(kk6Var3.a.getTid())) {
                        arrayList.add(kk6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
