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
public class lc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zh8 a;
    public boolean b;

    public lc8() {
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
        this.a = new zh8();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final gc8 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            zh8 zh8Var = this.a;
            if (zh8Var != null && !ListUtils.isEmpty(zh8Var.a)) {
                for (pi piVar : this.a.a) {
                    if (piVar instanceof gc8) {
                        return (gc8) piVar;
                    }
                }
            }
            return null;
        }
        return (gc8) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zh8 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                gc8 gc8Var = new gc8();
                gc8Var.d(userFollowLive);
                linkedList.add(0, gc8Var);
                gc8Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    gc8 b = b();
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
                        if (fc8.f(concernData)) {
                            fc8 fc8Var = new fc8();
                            if (concernData.recom_user_list.size() >= 4) {
                                fc8Var.d(concernData.recom_user_list);
                                fc8Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                fc8Var.g(z2);
                                linkedList.add(fc8Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = jja.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                jja.f().h("CONCERN", arrayList);
                zh8 zh8Var = this.a;
                zh8Var.a = linkedList;
                return zh8Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            jja.f().h("CONCERN", arrayList);
            zh8 zh8Var2 = this.a;
            zh8Var2.a = linkedList;
            return zh8Var2;
        }
        return (zh8) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (fc8.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!za8.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && fc8.f(concernData2)) {
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

    public List<pi> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        um6 dn6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((dn6.R(threadData) || en6.L(threadData) || fn6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (fn6.R(threadData)) {
                    dn6Var = new fn6(threadData);
                } else if (en6.L(threadData)) {
                    dn6Var = new en6(threadData);
                } else {
                    dn6Var = new dn6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    dn6Var.a = threadData;
                }
                dn6Var.g = threadData.getTid();
                if (dn6.R(threadData)) {
                    dn6Var.E("1");
                } else if (en6.L(threadData)) {
                    dn6Var.E("2");
                }
                dn6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && dn6Var.getThreadData() != null && dn6Var.getThreadData().getAuthor() != null) {
                    if (!dn6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        bi8.t(dn6Var);
                        bi8.q(threadData);
                    } else {
                        bi8.v(dn6Var);
                    }
                } else if (dn6Var instanceof fn6) {
                    bi8.v(dn6Var);
                } else {
                    bi8.v(dn6Var);
                }
                dn6Var.a.insertItemToTitleOrAbstractText();
                if (dn6Var instanceof dn6) {
                    if (threadData.isBJHNormalThreadType()) {
                        bi8.w(dn6Var);
                    } else if (threadData.picCount() == 1) {
                        bi8.y(dn6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        dn6Var.j = imageWidthAndHeight[0];
                        dn6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        bi8.x(dn6Var);
                    } else {
                        bi8.z(dn6Var);
                    }
                } else if (dn6Var instanceof en6) {
                    bi8.A(dn6Var);
                }
                if (dn6Var instanceof fn6) {
                    bi8.B(dn6Var);
                }
                if (threadData.getItem() != null) {
                    bi8.C(dn6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        bi8.F(dn6Var);
                    } else {
                        bi8.D(dn6Var);
                    }
                }
                bi8.s(dn6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    bi8.u(dn6Var);
                }
                bi8.r(dn6Var);
                dn6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                dn6Var.position = i;
                arrayList.add(dn6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    bi8.q(threadData);
                }
                if (threadData.isShareThread) {
                    dn6 dn6Var2 = new dn6();
                    dn6Var2.a = threadData;
                    dn6Var2.position = i;
                    arrayList.add(dn6Var2);
                } else if (en6.L(threadData)) {
                    en6 en6Var = new en6(threadData);
                    en6Var.g = threadData.getTid();
                    if (concernData != null) {
                        en6Var.D(concernData.source.intValue());
                    }
                    if (en6Var.isValid()) {
                        arrayList.add(en6Var);
                    }
                } else if (cn6.R(threadData)) {
                    cn6 cn6Var = new cn6(threadData);
                    cn6Var.g = threadData.getTid();
                    cn6Var.E("3");
                    if (cn6Var.isValid()) {
                        arrayList.add(cn6Var);
                    }
                } else if (xm6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    xm6 xm6Var = new xm6(threadData);
                    xm6Var.position = i;
                    arrayList.add(xm6Var);
                } else {
                    dn6 dn6Var3 = new dn6();
                    dn6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    dn6Var3.E(str);
                    dn6Var3.position = i;
                    if (concernData != null) {
                        dn6Var3.D(concernData.source.intValue());
                    }
                    if (dn6Var3.a != null && dn6Var3.isValid() && !StringUtils.isNull(dn6Var3.a.getId()) && !"0".equals(dn6Var3.a.getTid())) {
                        arrayList.add(dn6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
