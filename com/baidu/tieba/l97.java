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
public class l97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final he7 a;
    public boolean b;

    public l97() {
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
        this.a = new he7();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final g97 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            he7 he7Var = this.a;
            if (he7Var != null && !ListUtils.isEmpty(he7Var.a)) {
                for (Cdo cdo : this.a.a) {
                    if (cdo instanceof g97) {
                        return (g97) cdo;
                    }
                }
            }
            return null;
        }
        return (g97) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public he7 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                g97 g97Var = new g97();
                g97Var.f(userFollowLive);
                linkedList.add(0, g97Var);
                g97Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    g97 b = b();
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
                        if (i97.m(builder.hot_recomforum, i2)) {
                            i97 i97Var = new i97();
                            if (i97Var.i(builder.hot_recomforum.tab_list)) {
                                i97Var.position = i2;
                                linkedList.add(i97Var);
                                i2++;
                            }
                        }
                        if (f97.i(concernData)) {
                            f97 f97Var = new f97();
                            if (concernData.recom_user_list.size() >= 4) {
                                f97Var.f(concernData.recom_user_list);
                                f97Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                f97Var.k(z2);
                                linkedList.add(f97Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = ys8.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                ys8.f().h("CONCERN", arrayList);
                he7 he7Var = this.a;
                he7Var.a = linkedList;
                return he7Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            ys8.f().h("CONCERN", arrayList);
            he7 he7Var2 = this.a;
            he7Var2.a = linkedList;
            return he7Var2;
        }
        return (he7) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (f97.i(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!b87.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && f97.i(concernData2)) {
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

    public List<Cdo> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        sd6 ae6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((ae6.W(threadData) || be6.R(threadData) || ce6.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (ce6.W(threadData)) {
                    ae6Var = new ce6(threadData);
                } else if (be6.R(threadData)) {
                    ae6Var = new be6(threadData);
                } else {
                    ae6Var = new ae6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    ae6Var.a = threadData;
                }
                ae6Var.g = threadData.getTid();
                if (ae6.W(threadData)) {
                    ae6Var.L("1");
                } else if (be6.R(threadData)) {
                    ae6Var.L("2");
                }
                ae6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && ae6Var.getThreadData() != null && ae6Var.getThreadData().getAuthor() != null) {
                    if (!ae6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        ie7.r(ae6Var);
                        ie7.o(threadData);
                    } else {
                        ie7.t(ae6Var);
                    }
                } else if (ae6Var instanceof ce6) {
                    ie7.t(ae6Var);
                } else {
                    ie7.t(ae6Var);
                }
                ae6Var.a.insertItemToTitleOrAbstractText();
                if (ae6Var instanceof ae6) {
                    if (threadData.isBJHNormalThreadType()) {
                        ie7.u(ae6Var);
                    } else if (threadData.picCount() == 1) {
                        ie7.w(ae6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        ae6Var.j = imageWidthAndHeight[0];
                        ae6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        ie7.v(ae6Var);
                    } else {
                        ie7.x(ae6Var);
                    }
                } else if (ae6Var instanceof be6) {
                    ie7.y(ae6Var);
                }
                if (ae6Var instanceof ce6) {
                    ie7.z(ae6Var);
                }
                if (threadData.getItem() != null) {
                    ie7.A(ae6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        ie7.D(ae6Var);
                    } else {
                        ie7.B(ae6Var);
                    }
                }
                ie7.q(ae6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    ie7.s(ae6Var);
                }
                ie7.p(ae6Var);
                ae6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                ae6Var.position = i;
                arrayList.add(ae6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    ie7.o(threadData);
                }
                if (threadData.isShareThread) {
                    ae6 ae6Var2 = new ae6();
                    ae6Var2.a = threadData;
                    ae6Var2.position = i;
                    arrayList.add(ae6Var2);
                } else if (be6.R(threadData)) {
                    be6 be6Var = new be6(threadData);
                    be6Var.g = threadData.getTid();
                    if (concernData != null) {
                        be6Var.K(concernData.source.intValue());
                    }
                    if (be6Var.isValid()) {
                        arrayList.add(be6Var);
                    }
                } else if (zd6.W(threadData)) {
                    zd6 zd6Var = new zd6(threadData);
                    zd6Var.g = threadData.getTid();
                    zd6Var.L("3");
                    if (zd6Var.isValid()) {
                        arrayList.add(zd6Var);
                    }
                } else if (vd6.W(threadData) && threadData.isBJHArticleThreadType()) {
                    vd6 vd6Var = new vd6(threadData);
                    vd6Var.position = i;
                    arrayList.add(vd6Var);
                } else {
                    ae6 ae6Var3 = new ae6();
                    ae6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    ae6Var3.L(str);
                    ae6Var3.position = i;
                    if (concernData != null) {
                        ae6Var3.K(concernData.source.intValue());
                    }
                    if (ae6Var3.a != null && ae6Var3.isValid() && !StringUtils.isNull(ae6Var3.a.getId()) && !"0".equals(ae6Var3.a.getTid())) {
                        arrayList.add(ae6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
