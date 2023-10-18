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
public class qw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c28 a;
    public boolean b;

    public qw7() {
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
        this.a = new c28();
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
            c28 c28Var = this.a;
            if (c28Var != null && !ListUtils.isEmpty(c28Var.a)) {
                for (yh yhVar : this.a.a) {
                    if (yhVar instanceof lw7) {
                        return (lw7) yhVar;
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
    public c28 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                                kw7Var.g(z2);
                                linkedList.add(kw7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = h1a.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                h1a.f().h("CONCERN", arrayList);
                c28 c28Var = this.a;
                c28Var.a = linkedList;
                return c28Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            h1a.f().h("CONCERN", arrayList);
            c28 c28Var2 = this.a;
            c28Var2.a = linkedList;
            return c28Var2;
        }
        return (c28) invokeCommon.objValue;
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
                if (!ev7.I()) {
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

    public List<yh> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        jk6 rk6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((rk6.R(threadData) || sk6.L(threadData) || tk6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (tk6.R(threadData)) {
                    rk6Var = new tk6(threadData);
                } else if (sk6.L(threadData)) {
                    rk6Var = new sk6(threadData);
                } else {
                    rk6Var = new rk6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    rk6Var.a = threadData;
                }
                rk6Var.g = threadData.getTid();
                if (rk6.R(threadData)) {
                    rk6Var.E("1");
                } else if (sk6.L(threadData)) {
                    rk6Var.E("2");
                }
                rk6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && rk6Var.getThreadData() != null && rk6Var.getThreadData().getAuthor() != null) {
                    if (!rk6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        e28.t(rk6Var);
                        e28.q(threadData);
                    } else {
                        e28.v(rk6Var);
                    }
                } else if (rk6Var instanceof tk6) {
                    e28.v(rk6Var);
                } else {
                    e28.v(rk6Var);
                }
                rk6Var.a.insertItemToTitleOrAbstractText();
                if (rk6Var instanceof rk6) {
                    if (threadData.isBJHNormalThreadType()) {
                        e28.w(rk6Var);
                    } else if (threadData.picCount() == 1) {
                        e28.y(rk6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        rk6Var.j = imageWidthAndHeight[0];
                        rk6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        e28.x(rk6Var);
                    } else {
                        e28.z(rk6Var);
                    }
                } else if (rk6Var instanceof sk6) {
                    e28.A(rk6Var);
                }
                if (rk6Var instanceof tk6) {
                    e28.B(rk6Var);
                }
                if (threadData.getItem() != null) {
                    e28.C(rk6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        e28.F(rk6Var);
                    } else {
                        e28.D(rk6Var);
                    }
                }
                e28.s(rk6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    e28.u(rk6Var);
                }
                e28.r(rk6Var);
                rk6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                rk6Var.position = i;
                arrayList.add(rk6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    e28.q(threadData);
                }
                if (threadData.isShareThread) {
                    rk6 rk6Var2 = new rk6();
                    rk6Var2.a = threadData;
                    rk6Var2.position = i;
                    arrayList.add(rk6Var2);
                } else if (sk6.L(threadData)) {
                    sk6 sk6Var = new sk6(threadData);
                    sk6Var.g = threadData.getTid();
                    if (concernData != null) {
                        sk6Var.D(concernData.source.intValue());
                    }
                    if (sk6Var.isValid()) {
                        arrayList.add(sk6Var);
                    }
                } else if (qk6.R(threadData)) {
                    qk6 qk6Var = new qk6(threadData);
                    qk6Var.g = threadData.getTid();
                    qk6Var.E("3");
                    if (qk6Var.isValid()) {
                        arrayList.add(qk6Var);
                    }
                } else if (mk6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    mk6 mk6Var = new mk6(threadData);
                    mk6Var.position = i;
                    arrayList.add(mk6Var);
                } else {
                    rk6 rk6Var3 = new rk6();
                    rk6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    rk6Var3.E(str);
                    rk6Var3.position = i;
                    if (concernData != null) {
                        rk6Var3.D(concernData.source.intValue());
                    }
                    if (rk6Var3.a != null && rk6Var3.isValid() && !StringUtils.isNull(rk6Var3.a.getId()) && !"0".equals(rk6Var3.a.getTid())) {
                        arrayList.add(rk6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
