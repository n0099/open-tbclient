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
public class wy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final i48 a;
    public boolean b;

    public wy7() {
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
        this.a = new i48();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final ry7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            i48 i48Var = this.a;
            if (i48Var != null && !ListUtils.isEmpty(i48Var.a)) {
                for (ym ymVar : this.a.a) {
                    if (ymVar instanceof ry7) {
                        return (ry7) ymVar;
                    }
                }
            }
            return null;
        }
        return (ry7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public i48 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                ry7 ry7Var = new ry7();
                ry7Var.d(userFollowLive);
                linkedList.add(0, ry7Var);
                ry7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    ry7 b = b();
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
                        if (qy7.f(concernData)) {
                            qy7 qy7Var = new qy7();
                            if (concernData.recom_user_list.size() >= 4) {
                                qy7Var.d(concernData.recom_user_list);
                                qy7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                qy7Var.g(z2);
                                linkedList.add(qy7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = zy9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                zy9.f().h("CONCERN", arrayList);
                i48 i48Var = this.a;
                i48Var.a = linkedList;
                return i48Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            zy9.f().h("CONCERN", arrayList);
            i48 i48Var2 = this.a;
            i48Var2.a = linkedList;
            return i48Var2;
        }
        return (i48) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (qy7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!lx7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && qy7.f(concernData2)) {
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

    public List<ym> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        jn6 rn6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((rn6.R(threadData) || sn6.L(threadData) || tn6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (tn6.R(threadData)) {
                    rn6Var = new tn6(threadData);
                } else if (sn6.L(threadData)) {
                    rn6Var = new sn6(threadData);
                } else {
                    rn6Var = new rn6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    rn6Var.a = threadData;
                }
                rn6Var.g = threadData.getTid();
                if (rn6.R(threadData)) {
                    rn6Var.E("1");
                } else if (sn6.L(threadData)) {
                    rn6Var.E("2");
                }
                rn6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && rn6Var.getThreadData() != null && rn6Var.getThreadData().getAuthor() != null) {
                    if (!rn6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        k48.s(rn6Var);
                        k48.p(threadData);
                    } else {
                        k48.u(rn6Var);
                    }
                } else if (rn6Var instanceof tn6) {
                    k48.u(rn6Var);
                } else {
                    k48.u(rn6Var);
                }
                rn6Var.a.insertItemToTitleOrAbstractText();
                if (rn6Var instanceof rn6) {
                    if (threadData.isBJHNormalThreadType()) {
                        k48.v(rn6Var);
                    } else if (threadData.picCount() == 1) {
                        k48.x(rn6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        rn6Var.j = imageWidthAndHeight[0];
                        rn6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        k48.w(rn6Var);
                    } else {
                        k48.y(rn6Var);
                    }
                } else if (rn6Var instanceof sn6) {
                    k48.z(rn6Var);
                }
                if (rn6Var instanceof tn6) {
                    k48.A(rn6Var);
                }
                if (threadData.getItem() != null) {
                    k48.B(rn6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        k48.E(rn6Var);
                    } else {
                        k48.C(rn6Var);
                    }
                }
                k48.r(rn6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    k48.t(rn6Var);
                }
                k48.q(rn6Var);
                rn6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                rn6Var.position = i;
                arrayList.add(rn6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    k48.p(threadData);
                }
                if (threadData.isShareThread) {
                    rn6 rn6Var2 = new rn6();
                    rn6Var2.a = threadData;
                    rn6Var2.position = i;
                    arrayList.add(rn6Var2);
                } else if (sn6.L(threadData)) {
                    sn6 sn6Var = new sn6(threadData);
                    sn6Var.g = threadData.getTid();
                    if (concernData != null) {
                        sn6Var.D(concernData.source.intValue());
                    }
                    if (sn6Var.isValid()) {
                        arrayList.add(sn6Var);
                    }
                } else if (qn6.R(threadData)) {
                    qn6 qn6Var = new qn6(threadData);
                    qn6Var.g = threadData.getTid();
                    qn6Var.E("3");
                    if (qn6Var.isValid()) {
                        arrayList.add(qn6Var);
                    }
                } else if (mn6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    mn6 mn6Var = new mn6(threadData);
                    mn6Var.position = i;
                    arrayList.add(mn6Var);
                } else {
                    rn6 rn6Var3 = new rn6();
                    rn6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    rn6Var3.E(str);
                    rn6Var3.position = i;
                    if (concernData != null) {
                        rn6Var3.D(concernData.source.intValue());
                    }
                    if (rn6Var3.a != null && rn6Var3.isValid() && !StringUtils.isNull(rn6Var3.a.getId()) && !"0".equals(rn6Var3.a.getTid())) {
                        arrayList.add(rn6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
