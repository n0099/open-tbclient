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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.Userlike.ConcernData;
import tbclient.Userlike.DataRes;
import tbclient.Userlike.UserFollowLive;
/* loaded from: classes4.dex */
public class iy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final e37 a;
    public boolean b;

    public iy6() {
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
        this.a = new e37();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final ey6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e37 e37Var = this.a;
            if (e37Var != null && !ListUtils.isEmpty(e37Var.a)) {
                for (eo eoVar : this.a.a) {
                    if (eoVar instanceof ey6) {
                        return (ey6) eoVar;
                    }
                }
            }
            return null;
        }
        return (ey6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public e37 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                ey6 ey6Var = new ey6();
                ey6Var.f(userFollowLive);
                linkedList.add(0, ey6Var);
                ey6Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    ey6 b = b();
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
                        if (gy6.n(builder.hot_recomforum, i2)) {
                            gy6 gy6Var = new gy6();
                            if (gy6Var.j(builder.hot_recomforum.tab_list)) {
                                gy6Var.position = i2;
                                linkedList.add(gy6Var);
                                i2++;
                            }
                        }
                        if (dy6.j(concernData)) {
                            dy6 dy6Var = new dy6();
                            if (concernData.recom_user_list.size() >= 4) {
                                dy6Var.f(concernData.recom_user_list);
                                dy6Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                dy6Var.l(z2);
                                linkedList.add(dy6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = xf8.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                xf8.f().h("CONCERN", arrayList);
                e37 e37Var = this.a;
                e37Var.a = linkedList;
                return e37Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            xf8.f().h("CONCERN", arrayList);
            e37 e37Var2 = this.a;
            e37Var2.a = linkedList;
            return e37Var2;
        }
        return (e37) invokeCommon.objValue;
    }

    public final void d(boolean z, List list, List list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    ConcernData concernData = (ConcernData) it.next();
                    if (dy6.j(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!ax6.H()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && dy6.j(concernData2)) {
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
        List list;
        List list2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && (list = builder.thread_info) != null && (list2 = builder2.thread_info) != null) {
            d(z, list, list2, i);
            builder.hot_recomforum = builder2.hot_recomforum;
        }
    }

    public List f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        w26 e36Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((e36.W(threadData) || f36.R(threadData) || g36.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (g36.W(threadData)) {
                    e36Var = new g36(threadData);
                } else if (f36.R(threadData)) {
                    e36Var = new f36(threadData);
                } else {
                    e36Var = new e36();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    e36Var.a = threadData;
                }
                e36Var.g = threadData.getTid();
                if (e36.W(threadData)) {
                    e36Var.L("1");
                } else if (f36.R(threadData)) {
                    e36Var.L("2");
                }
                e36Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && e36Var.getThreadData() != null && e36Var.getThreadData().getAuthor() != null) {
                    if (!e36Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        f37.r(e36Var);
                        f37.o(threadData);
                    } else {
                        f37.t(e36Var);
                    }
                } else if (e36Var instanceof g36) {
                    f37.t(e36Var);
                } else {
                    f37.t(e36Var);
                }
                e36Var.a.insertItemToTitleOrAbstractText();
                if (e36Var instanceof e36) {
                    if (threadData.isBJHNormalThreadType()) {
                        f37.u(e36Var);
                    } else if (threadData.picCount() == 1) {
                        f37.w(e36Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        e36Var.j = imageWidthAndHeight[0];
                        e36Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        f37.v(e36Var);
                    } else {
                        f37.x(e36Var);
                    }
                } else if (e36Var instanceof f36) {
                    f37.y(e36Var);
                }
                if (e36Var instanceof g36) {
                    f37.z(e36Var);
                }
                if (threadData.getItem() != null) {
                    f37.A(e36Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        f37.D(e36Var);
                    } else {
                        f37.B(e36Var);
                    }
                }
                f37.q(e36Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    f37.s(e36Var);
                }
                f37.p(e36Var);
                e36Var.setSupportType(BaseCardInfo.SupportType.TOP);
                e36Var.position = i;
                arrayList.add(e36Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    f37.o(threadData);
                }
                if (threadData.isShareThread) {
                    e36 e36Var2 = new e36();
                    e36Var2.a = threadData;
                    e36Var2.position = i;
                    arrayList.add(e36Var2);
                } else if (f36.R(threadData)) {
                    f36 f36Var = new f36(threadData);
                    f36Var.g = threadData.getTid();
                    if (concernData != null) {
                        f36Var.K(concernData.source.intValue());
                    }
                    if (f36Var.isValid()) {
                        arrayList.add(f36Var);
                    }
                } else if (d36.W(threadData)) {
                    d36 d36Var = new d36(threadData);
                    d36Var.g = threadData.getTid();
                    d36Var.L("3");
                    if (d36Var.isValid()) {
                        arrayList.add(d36Var);
                    }
                } else if (z26.W(threadData) && threadData.isBJHArticleThreadType()) {
                    z26 z26Var = new z26(threadData);
                    z26Var.position = i;
                    arrayList.add(z26Var);
                } else {
                    e36 e36Var3 = new e36();
                    e36Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    e36Var3.L(str);
                    e36Var3.position = i;
                    if (concernData != null) {
                        e36Var3.K(concernData.source.intValue());
                    }
                    if (e36Var3.a != null && e36Var3.isValid() && !StringUtils.isNull(e36Var3.a.getId()) && !"0".equals(e36Var3.a.getTid())) {
                        arrayList.add(e36Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
