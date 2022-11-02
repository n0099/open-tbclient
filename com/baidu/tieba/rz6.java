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
public class rz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final o47 a;
    public boolean b;

    public rz6() {
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
        this.a = new o47();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final nz6 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            o47 o47Var = this.a;
            if (o47Var != null && !ListUtils.isEmpty(o47Var.a)) {
                for (wn wnVar : this.a.a) {
                    if (wnVar instanceof nz6) {
                        return (nz6) wnVar;
                    }
                }
            }
            return null;
        }
        return (nz6) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public o47 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                nz6 nz6Var = new nz6();
                nz6Var.f(userFollowLive);
                linkedList.add(0, nz6Var);
                nz6Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    nz6 b = b();
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
                        if (pz6.n(builder.hot_recomforum, i2)) {
                            pz6 pz6Var = new pz6();
                            if (pz6Var.j(builder.hot_recomforum.tab_list)) {
                                pz6Var.position = i2;
                                linkedList.add(pz6Var);
                                i2++;
                            }
                        }
                        if (mz6.j(concernData)) {
                            mz6 mz6Var = new mz6();
                            if (concernData.recom_user_list.size() >= 4) {
                                mz6Var.f(concernData.recom_user_list);
                                mz6Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                mz6Var.l(z2);
                                linkedList.add(mz6Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = hh8.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                hh8.f().h("CONCERN", arrayList);
                o47 o47Var = this.a;
                o47Var.a = linkedList;
                return o47Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            hh8.f().h("CONCERN", arrayList);
            o47 o47Var2 = this.a;
            o47Var2.a = linkedList;
            return o47Var2;
        }
        return (o47) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (mz6.j(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!jy6.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && mz6.j(concernData2)) {
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

    public List<wn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        g46 o46Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((o46.W(threadData) || p46.R(threadData) || q46.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (q46.W(threadData)) {
                    o46Var = new q46(threadData);
                } else if (p46.R(threadData)) {
                    o46Var = new p46(threadData);
                } else {
                    o46Var = new o46();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    o46Var.a = threadData;
                }
                o46Var.g = threadData.getTid();
                if (o46.W(threadData)) {
                    o46Var.L("1");
                } else if (p46.R(threadData)) {
                    o46Var.L("2");
                }
                o46Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && o46Var.getThreadData() != null && o46Var.getThreadData().getAuthor() != null) {
                    if (!o46Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        p47.r(o46Var);
                        p47.o(threadData);
                    } else {
                        p47.t(o46Var);
                    }
                } else if (o46Var instanceof q46) {
                    p47.t(o46Var);
                } else {
                    p47.t(o46Var);
                }
                o46Var.a.insertItemToTitleOrAbstractText();
                if (o46Var instanceof o46) {
                    if (threadData.isBJHNormalThreadType()) {
                        p47.u(o46Var);
                    } else if (threadData.picCount() == 1) {
                        p47.w(o46Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        o46Var.j = imageWidthAndHeight[0];
                        o46Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        p47.v(o46Var);
                    } else {
                        p47.x(o46Var);
                    }
                } else if (o46Var instanceof p46) {
                    p47.y(o46Var);
                }
                if (o46Var instanceof q46) {
                    p47.z(o46Var);
                }
                if (threadData.getItem() != null) {
                    p47.A(o46Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        p47.D(o46Var);
                    } else {
                        p47.B(o46Var);
                    }
                }
                p47.q(o46Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    p47.s(o46Var);
                }
                p47.p(o46Var);
                o46Var.setSupportType(BaseCardInfo.SupportType.TOP);
                o46Var.position = i;
                arrayList.add(o46Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    p47.o(threadData);
                }
                if (threadData.isShareThread) {
                    o46 o46Var2 = new o46();
                    o46Var2.a = threadData;
                    o46Var2.position = i;
                    arrayList.add(o46Var2);
                } else if (p46.R(threadData)) {
                    p46 p46Var = new p46(threadData);
                    p46Var.g = threadData.getTid();
                    if (concernData != null) {
                        p46Var.K(concernData.source.intValue());
                    }
                    if (p46Var.isValid()) {
                        arrayList.add(p46Var);
                    }
                } else if (n46.W(threadData)) {
                    n46 n46Var = new n46(threadData);
                    n46Var.g = threadData.getTid();
                    n46Var.L("3");
                    if (n46Var.isValid()) {
                        arrayList.add(n46Var);
                    }
                } else if (j46.W(threadData) && threadData.isBJHArticleThreadType()) {
                    j46 j46Var = new j46(threadData);
                    j46Var.position = i;
                    arrayList.add(j46Var);
                } else {
                    o46 o46Var3 = new o46();
                    o46Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    o46Var3.L(str);
                    o46Var3.position = i;
                    if (concernData != null) {
                        o46Var3.K(concernData.source.intValue());
                    }
                    if (o46Var3.a != null && o46Var3.isValid() && !StringUtils.isNull(o46Var3.a.getId()) && !"0".equals(o46Var3.a.getTid())) {
                        arrayList.add(o46Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
