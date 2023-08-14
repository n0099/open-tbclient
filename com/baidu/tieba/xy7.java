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
public class xy7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final j48 a;
    public boolean b;

    public xy7() {
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
        this.a = new j48();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final sy7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            j48 j48Var = this.a;
            if (j48Var != null && !ListUtils.isEmpty(j48Var.a)) {
                for (ym ymVar : this.a.a) {
                    if (ymVar instanceof sy7) {
                        return (sy7) ymVar;
                    }
                }
            }
            return null;
        }
        return (sy7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j48 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                sy7 sy7Var = new sy7();
                sy7Var.d(userFollowLive);
                linkedList.add(0, sy7Var);
                sy7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    sy7 b = b();
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
                        if (ry7.f(concernData)) {
                            ry7 ry7Var = new ry7();
                            if (concernData.recom_user_list.size() >= 4) {
                                ry7Var.d(concernData.recom_user_list);
                                ry7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                ry7Var.g(z2);
                                linkedList.add(ry7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = az9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                az9.f().h("CONCERN", arrayList);
                j48 j48Var = this.a;
                j48Var.a = linkedList;
                return j48Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            az9.f().h("CONCERN", arrayList);
            j48 j48Var2 = this.a;
            j48Var2.a = linkedList;
            return j48Var2;
        }
        return (j48) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (ry7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!mx7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && ry7.f(concernData2)) {
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
        kn6 sn6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((sn6.R(threadData) || tn6.L(threadData) || un6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (un6.R(threadData)) {
                    sn6Var = new un6(threadData);
                } else if (tn6.L(threadData)) {
                    sn6Var = new tn6(threadData);
                } else {
                    sn6Var = new sn6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    sn6Var.a = threadData;
                }
                sn6Var.g = threadData.getTid();
                if (sn6.R(threadData)) {
                    sn6Var.E("1");
                } else if (tn6.L(threadData)) {
                    sn6Var.E("2");
                }
                sn6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && sn6Var.getThreadData() != null && sn6Var.getThreadData().getAuthor() != null) {
                    if (!sn6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        l48.s(sn6Var);
                        l48.p(threadData);
                    } else {
                        l48.u(sn6Var);
                    }
                } else if (sn6Var instanceof un6) {
                    l48.u(sn6Var);
                } else {
                    l48.u(sn6Var);
                }
                sn6Var.a.insertItemToTitleOrAbstractText();
                if (sn6Var instanceof sn6) {
                    if (threadData.isBJHNormalThreadType()) {
                        l48.v(sn6Var);
                    } else if (threadData.picCount() == 1) {
                        l48.x(sn6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        sn6Var.j = imageWidthAndHeight[0];
                        sn6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        l48.w(sn6Var);
                    } else {
                        l48.y(sn6Var);
                    }
                } else if (sn6Var instanceof tn6) {
                    l48.z(sn6Var);
                }
                if (sn6Var instanceof un6) {
                    l48.A(sn6Var);
                }
                if (threadData.getItem() != null) {
                    l48.B(sn6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        l48.E(sn6Var);
                    } else {
                        l48.C(sn6Var);
                    }
                }
                l48.r(sn6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    l48.t(sn6Var);
                }
                l48.q(sn6Var);
                sn6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                sn6Var.position = i;
                arrayList.add(sn6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    l48.p(threadData);
                }
                if (threadData.isShareThread) {
                    sn6 sn6Var2 = new sn6();
                    sn6Var2.a = threadData;
                    sn6Var2.position = i;
                    arrayList.add(sn6Var2);
                } else if (tn6.L(threadData)) {
                    tn6 tn6Var = new tn6(threadData);
                    tn6Var.g = threadData.getTid();
                    if (concernData != null) {
                        tn6Var.D(concernData.source.intValue());
                    }
                    if (tn6Var.isValid()) {
                        arrayList.add(tn6Var);
                    }
                } else if (rn6.R(threadData)) {
                    rn6 rn6Var = new rn6(threadData);
                    rn6Var.g = threadData.getTid();
                    rn6Var.E("3");
                    if (rn6Var.isValid()) {
                        arrayList.add(rn6Var);
                    }
                } else if (nn6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    nn6 nn6Var = new nn6(threadData);
                    nn6Var.position = i;
                    arrayList.add(nn6Var);
                } else {
                    sn6 sn6Var3 = new sn6();
                    sn6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    sn6Var3.E(str);
                    sn6Var3.position = i;
                    if (concernData != null) {
                        sn6Var3.D(concernData.source.intValue());
                    }
                    if (sn6Var3.a != null && sn6Var3.isValid() && !StringUtils.isNull(sn6Var3.a.getId()) && !"0".equals(sn6Var3.a.getTid())) {
                        arrayList.add(sn6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
