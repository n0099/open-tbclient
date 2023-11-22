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
public class m98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ye8 a;
    public boolean b;

    public m98() {
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
        this.a = new ye8();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final h98 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ye8 ye8Var = this.a;
            if (ye8Var != null && !ListUtils.isEmpty(ye8Var.a)) {
                for (oi oiVar : this.a.a) {
                    if (oiVar instanceof h98) {
                        return (h98) oiVar;
                    }
                }
            }
            return null;
        }
        return (h98) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ye8 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                h98 h98Var = new h98();
                h98Var.d(userFollowLive);
                linkedList.add(0, h98Var);
                h98Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    h98 b = b();
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
                        if (g98.f(concernData)) {
                            g98 g98Var = new g98();
                            if (concernData.recom_user_list.size() >= 4) {
                                g98Var.d(concernData.recom_user_list);
                                g98Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                g98Var.g(z2);
                                linkedList.add(g98Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = nea.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                nea.f().h("CONCERN", arrayList);
                ye8 ye8Var = this.a;
                ye8Var.a = linkedList;
                return ye8Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            nea.f().h("CONCERN", arrayList);
            ye8 ye8Var2 = this.a;
            ye8Var2.a = linkedList;
            return ye8Var2;
        }
        return (ye8) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (g98.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!a88.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && g98.f(concernData2)) {
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

    public List<oi> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        gm6 om6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((om6.R(threadData) || pm6.L(threadData) || qm6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (qm6.R(threadData)) {
                    om6Var = new qm6(threadData);
                } else if (pm6.L(threadData)) {
                    om6Var = new pm6(threadData);
                } else {
                    om6Var = new om6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    om6Var.a = threadData;
                }
                om6Var.g = threadData.getTid();
                if (om6.R(threadData)) {
                    om6Var.E("1");
                } else if (pm6.L(threadData)) {
                    om6Var.E("2");
                }
                om6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && om6Var.getThreadData() != null && om6Var.getThreadData().getAuthor() != null) {
                    if (!om6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        af8.t(om6Var);
                        af8.q(threadData);
                    } else {
                        af8.v(om6Var);
                    }
                } else if (om6Var instanceof qm6) {
                    af8.v(om6Var);
                } else {
                    af8.v(om6Var);
                }
                om6Var.a.insertItemToTitleOrAbstractText();
                if (om6Var instanceof om6) {
                    if (threadData.isBJHNormalThreadType()) {
                        af8.w(om6Var);
                    } else if (threadData.picCount() == 1) {
                        af8.y(om6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        om6Var.j = imageWidthAndHeight[0];
                        om6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        af8.x(om6Var);
                    } else {
                        af8.z(om6Var);
                    }
                } else if (om6Var instanceof pm6) {
                    af8.A(om6Var);
                }
                if (om6Var instanceof qm6) {
                    af8.B(om6Var);
                }
                if (threadData.getItem() != null) {
                    af8.C(om6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        af8.F(om6Var);
                    } else {
                        af8.D(om6Var);
                    }
                }
                af8.s(om6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    af8.u(om6Var);
                }
                af8.r(om6Var);
                om6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                om6Var.position = i;
                arrayList.add(om6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    af8.q(threadData);
                }
                if (threadData.isShareThread) {
                    om6 om6Var2 = new om6();
                    om6Var2.a = threadData;
                    om6Var2.position = i;
                    arrayList.add(om6Var2);
                } else if (pm6.L(threadData)) {
                    pm6 pm6Var = new pm6(threadData);
                    pm6Var.g = threadData.getTid();
                    if (concernData != null) {
                        pm6Var.D(concernData.source.intValue());
                    }
                    if (pm6Var.isValid()) {
                        arrayList.add(pm6Var);
                    }
                } else if (nm6.R(threadData)) {
                    nm6 nm6Var = new nm6(threadData);
                    nm6Var.g = threadData.getTid();
                    nm6Var.E("3");
                    if (nm6Var.isValid()) {
                        arrayList.add(nm6Var);
                    }
                } else if (jm6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    jm6 jm6Var = new jm6(threadData);
                    jm6Var.position = i;
                    arrayList.add(jm6Var);
                } else {
                    om6 om6Var3 = new om6();
                    om6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    om6Var3.E(str);
                    om6Var3.position = i;
                    if (concernData != null) {
                        om6Var3.D(concernData.source.intValue());
                    }
                    if (om6Var3.a != null && om6Var3.isValid() && !StringUtils.isNull(om6Var3.a.getId()) && !"0".equals(om6Var3.a.getTid())) {
                        arrayList.add(om6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
