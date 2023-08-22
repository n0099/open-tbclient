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
public class s08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e68 a;
    public boolean b;

    public s08() {
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
        this.a = new e68();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final n08 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e68 e68Var = this.a;
            if (e68Var != null && !ListUtils.isEmpty(e68Var.a)) {
                for (bn bnVar : this.a.a) {
                    if (bnVar instanceof n08) {
                        return (n08) bnVar;
                    }
                }
            }
            return null;
        }
        return (n08) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e68 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                n08 n08Var = new n08();
                n08Var.d(userFollowLive);
                linkedList.add(0, n08Var);
                n08Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    n08 b = b();
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
                        if (m08.f(concernData)) {
                            m08 m08Var = new m08();
                            if (concernData.recom_user_list.size() >= 4) {
                                m08Var.d(concernData.recom_user_list);
                                m08Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                m08Var.g(z2);
                                linkedList.add(m08Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = f3a.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                f3a.f().h("CONCERN", arrayList);
                e68 e68Var = this.a;
                e68Var.a = linkedList;
                return e68Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            f3a.f().h("CONCERN", arrayList);
            e68 e68Var2 = this.a;
            e68Var2.a = linkedList;
            return e68Var2;
        }
        return (e68) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (m08.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!hz7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && m08.f(concernData2)) {
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

    public List<bn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        ro6 zo6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((zo6.R(threadData) || ap6.L(threadData) || bp6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (bp6.R(threadData)) {
                    zo6Var = new bp6(threadData);
                } else if (ap6.L(threadData)) {
                    zo6Var = new ap6(threadData);
                } else {
                    zo6Var = new zo6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    zo6Var.a = threadData;
                }
                zo6Var.g = threadData.getTid();
                if (zo6.R(threadData)) {
                    zo6Var.E("1");
                } else if (ap6.L(threadData)) {
                    zo6Var.E("2");
                }
                zo6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && zo6Var.getThreadData() != null && zo6Var.getThreadData().getAuthor() != null) {
                    if (!zo6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        g68.s(zo6Var);
                        g68.p(threadData);
                    } else {
                        g68.u(zo6Var);
                    }
                } else if (zo6Var instanceof bp6) {
                    g68.u(zo6Var);
                } else {
                    g68.u(zo6Var);
                }
                zo6Var.a.insertItemToTitleOrAbstractText();
                if (zo6Var instanceof zo6) {
                    if (threadData.isBJHNormalThreadType()) {
                        g68.v(zo6Var);
                    } else if (threadData.picCount() == 1) {
                        g68.x(zo6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        zo6Var.j = imageWidthAndHeight[0];
                        zo6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        g68.w(zo6Var);
                    } else {
                        g68.y(zo6Var);
                    }
                } else if (zo6Var instanceof ap6) {
                    g68.z(zo6Var);
                }
                if (zo6Var instanceof bp6) {
                    g68.A(zo6Var);
                }
                if (threadData.getItem() != null) {
                    g68.B(zo6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        g68.E(zo6Var);
                    } else {
                        g68.C(zo6Var);
                    }
                }
                g68.r(zo6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    g68.t(zo6Var);
                }
                g68.q(zo6Var);
                zo6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                zo6Var.position = i;
                arrayList.add(zo6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    g68.p(threadData);
                }
                if (threadData.isShareThread) {
                    zo6 zo6Var2 = new zo6();
                    zo6Var2.a = threadData;
                    zo6Var2.position = i;
                    arrayList.add(zo6Var2);
                } else if (ap6.L(threadData)) {
                    ap6 ap6Var = new ap6(threadData);
                    ap6Var.g = threadData.getTid();
                    if (concernData != null) {
                        ap6Var.D(concernData.source.intValue());
                    }
                    if (ap6Var.isValid()) {
                        arrayList.add(ap6Var);
                    }
                } else if (yo6.R(threadData)) {
                    yo6 yo6Var = new yo6(threadData);
                    yo6Var.g = threadData.getTid();
                    yo6Var.E("3");
                    if (yo6Var.isValid()) {
                        arrayList.add(yo6Var);
                    }
                } else if (uo6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    uo6 uo6Var = new uo6(threadData);
                    uo6Var.position = i;
                    arrayList.add(uo6Var);
                } else {
                    zo6 zo6Var3 = new zo6();
                    zo6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    zo6Var3.E(str);
                    zo6Var3.position = i;
                    if (concernData != null) {
                        zo6Var3.D(concernData.source.intValue());
                    }
                    if (zo6Var3.a != null && zo6Var3.isValid() && !StringUtils.isNull(zo6Var3.a.getId()) && !"0".equals(zo6Var3.a.getTid())) {
                        arrayList.add(zo6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
