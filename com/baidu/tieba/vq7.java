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
/* loaded from: classes8.dex */
public class vq7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final qv7 a;
    public boolean b;

    public vq7() {
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
        this.a = new qv7();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final pq7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            qv7 qv7Var = this.a;
            if (qv7Var != null && !ListUtils.isEmpty(qv7Var.a)) {
                for (rn rnVar : this.a.a) {
                    if (rnVar instanceof pq7) {
                        return (pq7) rnVar;
                    }
                }
            }
            return null;
        }
        return (pq7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public qv7 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                pq7 pq7Var = new pq7();
                pq7Var.d(userFollowLive);
                linkedList.add(0, pq7Var);
                pq7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    pq7 b = b();
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
                        if (rq7.i(builder.hot_recomforum, i2)) {
                            rq7 rq7Var = new rq7();
                            if (rq7Var.f(builder.hot_recomforum.tab_list)) {
                                rq7Var.position = i2;
                                linkedList.add(rq7Var);
                                i2++;
                            }
                        }
                        if (oq7.f(concernData)) {
                            oq7 oq7Var = new oq7();
                            if (concernData.recom_user_list.size() >= 4) {
                                oq7Var.d(concernData.recom_user_list);
                                oq7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                oq7Var.h(z2);
                                linkedList.add(oq7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = kh9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                kh9.f().h("CONCERN", arrayList);
                qv7 qv7Var = this.a;
                qv7Var.a = linkedList;
                return qv7Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            kh9.f().h("CONCERN", arrayList);
            qv7 qv7Var2 = this.a;
            qv7Var2.a = linkedList;
            return qv7Var2;
        }
        return (qv7) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (oq7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!kp7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && oq7.f(concernData2)) {
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
        dk6 lk6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((lk6.W(threadData) || mk6.P(threadData) || nk6.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (nk6.W(threadData)) {
                    lk6Var = new nk6(threadData);
                } else if (mk6.P(threadData)) {
                    lk6Var = new mk6(threadData);
                } else {
                    lk6Var = new lk6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    lk6Var.a = threadData;
                }
                lk6Var.g = threadData.getTid();
                if (lk6.W(threadData)) {
                    lk6Var.F("1");
                } else if (mk6.P(threadData)) {
                    lk6Var.F("2");
                }
                lk6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && lk6Var.getThreadData() != null && lk6Var.getThreadData().getAuthor() != null) {
                    if (!lk6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        rv7.r(lk6Var);
                        rv7.o(threadData);
                    } else {
                        rv7.t(lk6Var);
                    }
                } else if (lk6Var instanceof nk6) {
                    rv7.t(lk6Var);
                } else {
                    rv7.t(lk6Var);
                }
                lk6Var.a.insertItemToTitleOrAbstractText();
                if (lk6Var instanceof lk6) {
                    if (threadData.isBJHNormalThreadType()) {
                        rv7.u(lk6Var);
                    } else if (threadData.picCount() == 1) {
                        rv7.w(lk6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        lk6Var.j = imageWidthAndHeight[0];
                        lk6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        rv7.v(lk6Var);
                    } else {
                        rv7.x(lk6Var);
                    }
                } else if (lk6Var instanceof mk6) {
                    rv7.y(lk6Var);
                }
                if (lk6Var instanceof nk6) {
                    rv7.z(lk6Var);
                }
                if (threadData.getItem() != null) {
                    rv7.A(lk6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        rv7.D(lk6Var);
                    } else {
                        rv7.B(lk6Var);
                    }
                }
                rv7.q(lk6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    rv7.s(lk6Var);
                }
                rv7.p(lk6Var);
                lk6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                lk6Var.position = i;
                arrayList.add(lk6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    rv7.o(threadData);
                }
                if (threadData.isShareThread) {
                    lk6 lk6Var2 = new lk6();
                    lk6Var2.a = threadData;
                    lk6Var2.position = i;
                    arrayList.add(lk6Var2);
                } else if (mk6.P(threadData)) {
                    mk6 mk6Var = new mk6(threadData);
                    mk6Var.g = threadData.getTid();
                    if (concernData != null) {
                        mk6Var.E(concernData.source.intValue());
                    }
                    if (mk6Var.isValid()) {
                        arrayList.add(mk6Var);
                    }
                } else if (kk6.W(threadData)) {
                    kk6 kk6Var = new kk6(threadData);
                    kk6Var.g = threadData.getTid();
                    kk6Var.F("3");
                    if (kk6Var.isValid()) {
                        arrayList.add(kk6Var);
                    }
                } else if (gk6.W(threadData) && threadData.isBJHArticleThreadType()) {
                    gk6 gk6Var = new gk6(threadData);
                    gk6Var.position = i;
                    arrayList.add(gk6Var);
                } else {
                    lk6 lk6Var3 = new lk6();
                    lk6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    lk6Var3.F(str);
                    lk6Var3.position = i;
                    if (concernData != null) {
                        lk6Var3.E(concernData.source.intValue());
                    }
                    if (lk6Var3.a != null && lk6Var3.isValid() && !StringUtils.isNull(lk6Var3.a.getId()) && !"0".equals(lk6Var3.a.getTid())) {
                        arrayList.add(lk6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
