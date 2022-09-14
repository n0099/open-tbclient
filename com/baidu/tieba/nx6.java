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
/* loaded from: classes5.dex */
public class nx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i27 a;
    public boolean b;

    public nx6() {
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
        this.a = new i27();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final jx6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i27 i27Var = this.a;
            if (i27Var != null && !ListUtils.isEmpty(i27Var.a)) {
                for (Cdo cdo : this.a.a) {
                    if (cdo instanceof jx6) {
                        return (jx6) cdo;
                    }
                }
            }
            return null;
        }
        return (jx6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i27 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i == 0 || i == 1) {
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
                    jx6 jx6Var = new jx6();
                    jx6Var.f(userFollowLive);
                    linkedList.add(0, jx6Var);
                    jx6Var.position = -1;
                    this.b = true;
                } else {
                    if (i == 1) {
                        jx6 b = b();
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
                            if (lx6.n(builder.hot_recomforum, i2)) {
                                lx6 lx6Var = new lx6();
                                if (lx6Var.j(builder.hot_recomforum.tab_list)) {
                                    lx6Var.position = i2;
                                    linkedList.add(lx6Var);
                                    i2++;
                                }
                            }
                            if (ix6.j(concernData)) {
                                ix6 ix6Var = new ix6();
                                if (concernData.recom_user_list.size() >= 4) {
                                    ix6Var.f(concernData.recom_user_list);
                                    ix6Var.position = i2;
                                    ix6Var.l(builder.thread_info.size() > 1);
                                    linkedList.add(ix6Var);
                                }
                            } else {
                                ThreadData threadData = new ThreadData();
                                threadData.setFromConcern(true);
                                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                                threadData.parserProtobuf(concernData.thread_list);
                                JSONObject b2 = ye8.b(concernData.thread_list);
                                if (b2 != null) {
                                    arrayList.add(b2);
                                }
                                linkedList.addAll(f(threadData, i2, concernData));
                            }
                            i2++;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    ye8.f().h("CONCERN", arrayList);
                    i27 i27Var = this.a;
                    i27Var.a = linkedList;
                    return i27Var;
                }
                i2 = 1;
                while (r11.hasNext()) {
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                ye8.f().h("CONCERN", arrayList);
                i27 i27Var2 = this.a;
                i27Var2.a = linkedList;
                return i27Var2;
            }
            return null;
        }
        return (i27) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) || list == null || list2 == null) {
            return;
        }
        int count = ListUtils.getCount(list);
        if (i == 1) {
            for (ConcernData concernData : list2) {
                if (ix6.j(concernData)) {
                    list.add(concernData);
                } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                    list.add(concernData);
                }
            }
        } else {
            if (!fw6.H()) {
                list.clear();
            }
            for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                if (concernData2 != null && ix6.j(concernData2)) {
                    list.add(0, concernData2);
                } else if (concernData2 != null && (threadInfo = concernData2.thread_list) != null && threadInfo.tid != null) {
                    list.add(0, concernData2);
                }
            }
        }
        this.a.b = ListUtils.getCount(list) - count;
    }

    public final void e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ConcernData> list;
        List<ConcernData> list2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) || (list = builder.thread_info) == null || (list2 = builder2.thread_info) == null) {
            return;
        }
        d(z, list, list2, i);
        builder.hot_recomforum = builder2.hot_recomforum;
    }

    public List<Cdo> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        c26 k26Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            if ((k26.W(threadData) || l26.R(threadData) || m26.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (m26.W(threadData)) {
                    k26Var = new m26(threadData);
                } else if (l26.R(threadData)) {
                    k26Var = new l26(threadData);
                } else {
                    k26Var = new k26();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    k26Var.a = threadData;
                }
                k26Var.g = threadData.getTid();
                if (k26.W(threadData)) {
                    k26Var.L("1");
                } else if (l26.R(threadData)) {
                    k26Var.L("2");
                }
                k26Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && k26Var.getThreadData() != null && k26Var.getThreadData().getAuthor() != null) {
                    if (!k26Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        j27.r(k26Var);
                        j27.o(threadData);
                    } else {
                        j27.t(k26Var);
                    }
                } else if (k26Var instanceof m26) {
                    j27.t(k26Var);
                } else {
                    j27.t(k26Var);
                }
                k26Var.a.insertItemToTitleOrAbstractText();
                if (k26Var instanceof k26) {
                    if (threadData.isBJHNormalThreadType()) {
                        j27.u(k26Var);
                    } else if (threadData.picCount() == 1) {
                        j27.w(k26Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        k26Var.j = imageWidthAndHeight[0];
                        k26Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        j27.v(k26Var);
                    } else {
                        j27.x(k26Var);
                    }
                } else if (k26Var instanceof l26) {
                    j27.y(k26Var);
                }
                if (k26Var instanceof m26) {
                    j27.z(k26Var);
                }
                if (threadData.getItem() != null) {
                    j27.A(k26Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        j27.D(k26Var);
                    } else {
                        j27.B(k26Var);
                    }
                }
                j27.q(k26Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    j27.s(k26Var);
                }
                j27.p(k26Var);
                k26Var.setSupportType(BaseCardInfo.SupportType.TOP);
                k26Var.position = i;
                arrayList.add(k26Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    j27.o(threadData);
                }
                if (threadData.isShareThread) {
                    k26 k26Var2 = new k26();
                    k26Var2.a = threadData;
                    k26Var2.position = i;
                    arrayList.add(k26Var2);
                } else if (l26.R(threadData)) {
                    l26 l26Var = new l26(threadData);
                    l26Var.g = threadData.getTid();
                    if (concernData != null) {
                        l26Var.K(concernData.source.intValue());
                    }
                    if (l26Var.isValid()) {
                        arrayList.add(l26Var);
                    }
                } else if (j26.W(threadData)) {
                    j26 j26Var = new j26(threadData);
                    j26Var.g = threadData.getTid();
                    j26Var.L("3");
                    if (j26Var.isValid()) {
                        arrayList.add(j26Var);
                    }
                } else if (f26.W(threadData) && threadData.isBJHArticleThreadType()) {
                    f26 f26Var = new f26(threadData);
                    f26Var.position = i;
                    arrayList.add(f26Var);
                } else {
                    k26 k26Var3 = new k26();
                    k26Var3.a = threadData;
                    k26Var3.L(threadData.isLinkThread() ? "4" : "1");
                    k26Var3.position = i;
                    if (concernData != null) {
                        k26Var3.K(concernData.source.intValue());
                    }
                    if (k26Var3.a != null && k26Var3.isValid() && !StringUtils.isNull(k26Var3.a.getId()) && !"0".equals(k26Var3.a.getTid())) {
                        arrayList.add(k26Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
