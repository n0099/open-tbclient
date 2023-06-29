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
public class ww7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final v18 a;
    public boolean b;

    public ww7() {
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
        this.a = new v18();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final qw7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            v18 v18Var = this.a;
            if (v18Var != null && !ListUtils.isEmpty(v18Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof qw7) {
                        return (qw7) xnVar;
                    }
                }
            }
            return null;
        }
        return (qw7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v18 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                qw7 qw7Var = new qw7();
                qw7Var.d(userFollowLive);
                linkedList.add(0, qw7Var);
                qw7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    qw7 b = b();
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
                        if (pw7.f(concernData)) {
                            pw7 pw7Var = new pw7();
                            if (concernData.recom_user_list.size() >= 4) {
                                pw7Var.d(concernData.recom_user_list);
                                pw7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                pw7Var.h(z2);
                                linkedList.add(pw7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = au9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                au9.f().h("CONCERN", arrayList);
                v18 v18Var = this.a;
                v18Var.a = linkedList;
                return v18Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            au9.f().h("CONCERN", arrayList);
            v18 v18Var2 = this.a;
            v18Var2.a = linkedList;
            return v18Var2;
        }
        return (v18) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (pw7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!lv7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && pw7.f(concernData2)) {
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

    public List<xn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        yo6 gp6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((gp6.X(threadData) || hp6.P(threadData) || ip6.X(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (ip6.X(threadData)) {
                    gp6Var = new ip6(threadData);
                } else if (hp6.P(threadData)) {
                    gp6Var = new hp6(threadData);
                } else {
                    gp6Var = new gp6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    gp6Var.a = threadData;
                }
                gp6Var.g = threadData.getTid();
                if (gp6.X(threadData)) {
                    gp6Var.F("1");
                } else if (hp6.P(threadData)) {
                    gp6Var.F("2");
                }
                gp6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && gp6Var.getThreadData() != null && gp6Var.getThreadData().getAuthor() != null) {
                    if (!gp6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        x18.r(gp6Var);
                        x18.o(threadData);
                    } else {
                        x18.t(gp6Var);
                    }
                } else if (gp6Var instanceof ip6) {
                    x18.t(gp6Var);
                } else {
                    x18.t(gp6Var);
                }
                gp6Var.a.insertItemToTitleOrAbstractText();
                if (gp6Var instanceof gp6) {
                    if (threadData.isBJHNormalThreadType()) {
                        x18.u(gp6Var);
                    } else if (threadData.picCount() == 1) {
                        x18.w(gp6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        gp6Var.j = imageWidthAndHeight[0];
                        gp6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        x18.v(gp6Var);
                    } else {
                        x18.x(gp6Var);
                    }
                } else if (gp6Var instanceof hp6) {
                    x18.y(gp6Var);
                }
                if (gp6Var instanceof ip6) {
                    x18.z(gp6Var);
                }
                if (threadData.getItem() != null) {
                    x18.A(gp6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        x18.D(gp6Var);
                    } else {
                        x18.B(gp6Var);
                    }
                }
                x18.q(gp6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    x18.s(gp6Var);
                }
                x18.p(gp6Var);
                gp6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                gp6Var.position = i;
                arrayList.add(gp6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    x18.o(threadData);
                }
                if (threadData.isShareThread) {
                    gp6 gp6Var2 = new gp6();
                    gp6Var2.a = threadData;
                    gp6Var2.position = i;
                    arrayList.add(gp6Var2);
                } else if (hp6.P(threadData)) {
                    hp6 hp6Var = new hp6(threadData);
                    hp6Var.g = threadData.getTid();
                    if (concernData != null) {
                        hp6Var.E(concernData.source.intValue());
                    }
                    if (hp6Var.isValid()) {
                        arrayList.add(hp6Var);
                    }
                } else if (fp6.X(threadData)) {
                    fp6 fp6Var = new fp6(threadData);
                    fp6Var.g = threadData.getTid();
                    fp6Var.F("3");
                    if (fp6Var.isValid()) {
                        arrayList.add(fp6Var);
                    }
                } else if (bp6.X(threadData) && threadData.isBJHArticleThreadType()) {
                    bp6 bp6Var = new bp6(threadData);
                    bp6Var.position = i;
                    arrayList.add(bp6Var);
                } else {
                    gp6 gp6Var3 = new gp6();
                    gp6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    gp6Var3.F(str);
                    gp6Var3.position = i;
                    if (concernData != null) {
                        gp6Var3.E(concernData.source.intValue());
                    }
                    if (gp6Var3.a != null && gp6Var3.isValid() && !StringUtils.isNull(gp6Var3.a.getId()) && !"0".equals(gp6Var3.a.getTid())) {
                        arrayList.add(gp6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
