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
public class od7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ii7 a;
    public boolean b;

    public od7() {
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
        this.a = new ii7();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final id7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ii7 ii7Var = this.a;
            if (ii7Var != null && !ListUtils.isEmpty(ii7Var.a)) {
                for (gn gnVar : this.a.a) {
                    if (gnVar instanceof id7) {
                        return (id7) gnVar;
                    }
                }
            }
            return null;
        }
        return (id7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ii7 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                id7 id7Var = new id7();
                id7Var.f(userFollowLive);
                linkedList.add(0, id7Var);
                id7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    id7 b = b();
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
                        if (kd7.k(builder.hot_recomforum, i2)) {
                            kd7 kd7Var = new kd7();
                            if (kd7Var.h(builder.hot_recomforum.tab_list)) {
                                kd7Var.position = i2;
                                linkedList.add(kd7Var);
                                i2++;
                            }
                        }
                        if (hd7.h(concernData)) {
                            hd7 hd7Var = new hd7();
                            if (concernData.recom_user_list.size() >= 4) {
                                hd7Var.f(concernData.recom_user_list);
                                hd7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                hd7Var.i(z2);
                                linkedList.add(hd7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = r29.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                r29.f().h("CONCERN", arrayList);
                ii7 ii7Var = this.a;
                ii7Var.a = linkedList;
                return ii7Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            r29.f().h("CONCERN", arrayList);
            ii7 ii7Var2 = this.a;
            ii7Var2.a = linkedList;
            return ii7Var2;
        }
        return (ii7) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (hd7.h(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!dc7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && hd7.h(concernData2)) {
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

    public List<gn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        sf6 ag6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((ag6.W(threadData) || bg6.R(threadData) || cg6.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (cg6.W(threadData)) {
                    ag6Var = new cg6(threadData);
                } else if (bg6.R(threadData)) {
                    ag6Var = new bg6(threadData);
                } else {
                    ag6Var = new ag6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    ag6Var.a = threadData;
                }
                ag6Var.g = threadData.getTid();
                if (ag6.W(threadData)) {
                    ag6Var.I("1");
                } else if (bg6.R(threadData)) {
                    ag6Var.I("2");
                }
                ag6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && ag6Var.getThreadData() != null && ag6Var.getThreadData().getAuthor() != null) {
                    if (!ag6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        ji7.r(ag6Var);
                        ji7.o(threadData);
                    } else {
                        ji7.t(ag6Var);
                    }
                } else if (ag6Var instanceof cg6) {
                    ji7.t(ag6Var);
                } else {
                    ji7.t(ag6Var);
                }
                ag6Var.a.insertItemToTitleOrAbstractText();
                if (ag6Var instanceof ag6) {
                    if (threadData.isBJHNormalThreadType()) {
                        ji7.u(ag6Var);
                    } else if (threadData.picCount() == 1) {
                        ji7.w(ag6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        ag6Var.j = imageWidthAndHeight[0];
                        ag6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        ji7.v(ag6Var);
                    } else {
                        ji7.x(ag6Var);
                    }
                } else if (ag6Var instanceof bg6) {
                    ji7.y(ag6Var);
                }
                if (ag6Var instanceof cg6) {
                    ji7.z(ag6Var);
                }
                if (threadData.getItem() != null) {
                    ji7.A(ag6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        ji7.D(ag6Var);
                    } else {
                        ji7.B(ag6Var);
                    }
                }
                ji7.q(ag6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    ji7.s(ag6Var);
                }
                ji7.p(ag6Var);
                ag6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                ag6Var.position = i;
                arrayList.add(ag6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    ji7.o(threadData);
                }
                if (threadData.isShareThread) {
                    ag6 ag6Var2 = new ag6();
                    ag6Var2.a = threadData;
                    ag6Var2.position = i;
                    arrayList.add(ag6Var2);
                } else if (bg6.R(threadData)) {
                    bg6 bg6Var = new bg6(threadData);
                    bg6Var.g = threadData.getTid();
                    if (concernData != null) {
                        bg6Var.G(concernData.source.intValue());
                    }
                    if (bg6Var.isValid()) {
                        arrayList.add(bg6Var);
                    }
                } else if (zf6.W(threadData)) {
                    zf6 zf6Var = new zf6(threadData);
                    zf6Var.g = threadData.getTid();
                    zf6Var.I("3");
                    if (zf6Var.isValid()) {
                        arrayList.add(zf6Var);
                    }
                } else if (vf6.W(threadData) && threadData.isBJHArticleThreadType()) {
                    vf6 vf6Var = new vf6(threadData);
                    vf6Var.position = i;
                    arrayList.add(vf6Var);
                } else {
                    ag6 ag6Var3 = new ag6();
                    ag6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    ag6Var3.I(str);
                    ag6Var3.position = i;
                    if (concernData != null) {
                        ag6Var3.G(concernData.source.intValue());
                    }
                    if (ag6Var3.a != null && ag6Var3.isValid() && !StringUtils.isNull(ag6Var3.a.getId()) && !"0".equals(ag6Var3.a.getTid())) {
                        arrayList.add(ag6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
