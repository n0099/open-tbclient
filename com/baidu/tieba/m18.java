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
/* loaded from: classes6.dex */
public class m18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p68 a;
    public boolean b;

    public m18() {
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
        this.a = new p68();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final h18 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            p68 p68Var = this.a;
            if (p68Var != null && !ListUtils.isEmpty(p68Var.a)) {
                for (yn ynVar : this.a.a) {
                    if (ynVar instanceof h18) {
                        return (h18) ynVar;
                    }
                }
            }
            return null;
        }
        return (h18) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public p68 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                h18 h18Var = new h18();
                h18Var.d(userFollowLive);
                linkedList.add(0, h18Var);
                h18Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    h18 b = b();
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
                        if (g18.f(concernData)) {
                            g18 g18Var = new g18();
                            if (concernData.recom_user_list.size() >= 4) {
                                g18Var.d(concernData.recom_user_list);
                                g18Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                g18Var.g(z2);
                                linkedList.add(g18Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = i0a.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                i0a.f().h("CONCERN", arrayList);
                p68 p68Var = this.a;
                p68Var.a = linkedList;
                return p68Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            i0a.f().h("CONCERN", arrayList);
            p68 p68Var2 = this.a;
            p68Var2.a = linkedList;
            return p68Var2;
        }
        return (p68) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (g18.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!b08.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && g18.f(concernData2)) {
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

    public List<yn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        cq6 kq6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((kq6.X(threadData) || lq6.N(threadData) || mq6.X(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (mq6.X(threadData)) {
                    kq6Var = new mq6(threadData);
                } else if (lq6.N(threadData)) {
                    kq6Var = new lq6(threadData);
                } else {
                    kq6Var = new kq6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    kq6Var.a = threadData;
                }
                kq6Var.g = threadData.getTid();
                if (kq6.X(threadData)) {
                    kq6Var.E("1");
                } else if (lq6.N(threadData)) {
                    kq6Var.E("2");
                }
                kq6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && kq6Var.getThreadData() != null && kq6Var.getThreadData().getAuthor() != null) {
                    if (!kq6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        r68.s(kq6Var);
                        r68.p(threadData);
                    } else {
                        r68.u(kq6Var);
                    }
                } else if (kq6Var instanceof mq6) {
                    r68.u(kq6Var);
                } else {
                    r68.u(kq6Var);
                }
                kq6Var.a.insertItemToTitleOrAbstractText();
                if (kq6Var instanceof kq6) {
                    if (threadData.isBJHNormalThreadType()) {
                        r68.v(kq6Var);
                    } else if (threadData.picCount() == 1) {
                        r68.x(kq6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        kq6Var.j = imageWidthAndHeight[0];
                        kq6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        r68.w(kq6Var);
                    } else {
                        r68.y(kq6Var);
                    }
                } else if (kq6Var instanceof lq6) {
                    r68.z(kq6Var);
                }
                if (kq6Var instanceof mq6) {
                    r68.A(kq6Var);
                }
                if (threadData.getItem() != null) {
                    r68.B(kq6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        r68.E(kq6Var);
                    } else {
                        r68.C(kq6Var);
                    }
                }
                r68.r(kq6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    r68.t(kq6Var);
                }
                r68.q(kq6Var);
                kq6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                kq6Var.position = i;
                arrayList.add(kq6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    r68.p(threadData);
                }
                if (threadData.isShareThread) {
                    kq6 kq6Var2 = new kq6();
                    kq6Var2.a = threadData;
                    kq6Var2.position = i;
                    arrayList.add(kq6Var2);
                } else if (lq6.N(threadData)) {
                    lq6 lq6Var = new lq6(threadData);
                    lq6Var.g = threadData.getTid();
                    if (concernData != null) {
                        lq6Var.D(concernData.source.intValue());
                    }
                    if (lq6Var.isValid()) {
                        arrayList.add(lq6Var);
                    }
                } else if (jq6.X(threadData)) {
                    jq6 jq6Var = new jq6(threadData);
                    jq6Var.g = threadData.getTid();
                    jq6Var.E("3");
                    if (jq6Var.isValid()) {
                        arrayList.add(jq6Var);
                    }
                } else if (fq6.X(threadData) && threadData.isBJHArticleThreadType()) {
                    fq6 fq6Var = new fq6(threadData);
                    fq6Var.position = i;
                    arrayList.add(fq6Var);
                } else {
                    kq6 kq6Var3 = new kq6();
                    kq6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    kq6Var3.E(str);
                    kq6Var3.position = i;
                    if (concernData != null) {
                        kq6Var3.D(concernData.source.intValue());
                    }
                    if (kq6Var3.a != null && kq6Var3.isValid() && !StringUtils.isNull(kq6Var3.a.getId()) && !"0".equals(kq6Var3.a.getTid())) {
                        arrayList.add(kq6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
