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
public class rw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q18 a;
    public boolean b;

    public rw7() {
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
        this.a = new q18();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final lw7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q18 q18Var = this.a;
            if (q18Var != null && !ListUtils.isEmpty(q18Var.a)) {
                for (wn wnVar : this.a.a) {
                    if (wnVar instanceof lw7) {
                        return (lw7) wnVar;
                    }
                }
            }
            return null;
        }
        return (lw7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public q18 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                lw7 lw7Var = new lw7();
                lw7Var.d(userFollowLive);
                linkedList.add(0, lw7Var);
                lw7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    lw7 b = b();
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
                        if (kw7.f(concernData)) {
                            kw7 kw7Var = new kw7();
                            if (concernData.recom_user_list.size() >= 4) {
                                kw7Var.d(concernData.recom_user_list);
                                kw7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                kw7Var.h(z2);
                                linkedList.add(kw7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = op9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                op9.f().h("CONCERN", arrayList);
                q18 q18Var = this.a;
                q18Var.a = linkedList;
                return q18Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            op9.f().h("CONCERN", arrayList);
            q18 q18Var2 = this.a;
            q18Var2.a = linkedList;
            return q18Var2;
        }
        return (q18) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (kw7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!gv7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && kw7.f(concernData2)) {
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
        to6 bp6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((bp6.X(threadData) || cp6.P(threadData) || dp6.X(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (dp6.X(threadData)) {
                    bp6Var = new dp6(threadData);
                } else if (cp6.P(threadData)) {
                    bp6Var = new cp6(threadData);
                } else {
                    bp6Var = new bp6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    bp6Var.a = threadData;
                }
                bp6Var.g = threadData.getTid();
                if (bp6.X(threadData)) {
                    bp6Var.F("1");
                } else if (cp6.P(threadData)) {
                    bp6Var.F("2");
                }
                bp6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && bp6Var.getThreadData() != null && bp6Var.getThreadData().getAuthor() != null) {
                    if (!bp6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        s18.r(bp6Var);
                        s18.o(threadData);
                    } else {
                        s18.t(bp6Var);
                    }
                } else if (bp6Var instanceof dp6) {
                    s18.t(bp6Var);
                } else {
                    s18.t(bp6Var);
                }
                bp6Var.a.insertItemToTitleOrAbstractText();
                if (bp6Var instanceof bp6) {
                    if (threadData.isBJHNormalThreadType()) {
                        s18.u(bp6Var);
                    } else if (threadData.picCount() == 1) {
                        s18.w(bp6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        bp6Var.j = imageWidthAndHeight[0];
                        bp6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        s18.v(bp6Var);
                    } else {
                        s18.x(bp6Var);
                    }
                } else if (bp6Var instanceof cp6) {
                    s18.y(bp6Var);
                }
                if (bp6Var instanceof dp6) {
                    s18.z(bp6Var);
                }
                if (threadData.getItem() != null) {
                    s18.A(bp6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        s18.D(bp6Var);
                    } else {
                        s18.B(bp6Var);
                    }
                }
                s18.q(bp6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    s18.s(bp6Var);
                }
                s18.p(bp6Var);
                bp6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                bp6Var.position = i;
                arrayList.add(bp6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    s18.o(threadData);
                }
                if (threadData.isShareThread) {
                    bp6 bp6Var2 = new bp6();
                    bp6Var2.a = threadData;
                    bp6Var2.position = i;
                    arrayList.add(bp6Var2);
                } else if (cp6.P(threadData)) {
                    cp6 cp6Var = new cp6(threadData);
                    cp6Var.g = threadData.getTid();
                    if (concernData != null) {
                        cp6Var.E(concernData.source.intValue());
                    }
                    if (cp6Var.isValid()) {
                        arrayList.add(cp6Var);
                    }
                } else if (ap6.X(threadData)) {
                    ap6 ap6Var = new ap6(threadData);
                    ap6Var.g = threadData.getTid();
                    ap6Var.F("3");
                    if (ap6Var.isValid()) {
                        arrayList.add(ap6Var);
                    }
                } else if (wo6.X(threadData) && threadData.isBJHArticleThreadType()) {
                    wo6 wo6Var = new wo6(threadData);
                    wo6Var.position = i;
                    arrayList.add(wo6Var);
                } else {
                    bp6 bp6Var3 = new bp6();
                    bp6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    bp6Var3.F(str);
                    bp6Var3.position = i;
                    if (concernData != null) {
                        bp6Var3.E(concernData.source.intValue());
                    }
                    if (bp6Var3.a != null && bp6Var3.isValid() && !StringUtils.isNull(bp6Var3.a.getId()) && !"0".equals(bp6Var3.a.getTid())) {
                        arrayList.add(bp6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
