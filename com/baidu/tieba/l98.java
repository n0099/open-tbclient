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
public class l98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final xe8 a;
    public boolean b;

    public l98() {
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
        this.a = new xe8();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final g98 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            xe8 xe8Var = this.a;
            if (xe8Var != null && !ListUtils.isEmpty(xe8Var.a)) {
                for (oi oiVar : this.a.a) {
                    if (oiVar instanceof g98) {
                        return (g98) oiVar;
                    }
                }
            }
            return null;
        }
        return (g98) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public xe8 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                g98 g98Var = new g98();
                g98Var.d(userFollowLive);
                linkedList.add(0, g98Var);
                g98Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    g98 b = b();
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
                        if (f98.f(concernData)) {
                            f98 f98Var = new f98();
                            if (concernData.recom_user_list.size() >= 4) {
                                f98Var.d(concernData.recom_user_list);
                                f98Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                f98Var.g(z2);
                                linkedList.add(f98Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = mea.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                mea.f().h("CONCERN", arrayList);
                xe8 xe8Var = this.a;
                xe8Var.a = linkedList;
                return xe8Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            mea.f().h("CONCERN", arrayList);
            xe8 xe8Var2 = this.a;
            xe8Var2.a = linkedList;
            return xe8Var2;
        }
        return (xe8) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (f98.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!z78.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && f98.f(concernData2)) {
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
        fm6 nm6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((nm6.R(threadData) || om6.L(threadData) || pm6.R(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (pm6.R(threadData)) {
                    nm6Var = new pm6(threadData);
                } else if (om6.L(threadData)) {
                    nm6Var = new om6(threadData);
                } else {
                    nm6Var = new nm6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    nm6Var.a = threadData;
                }
                nm6Var.g = threadData.getTid();
                if (nm6.R(threadData)) {
                    nm6Var.E("1");
                } else if (om6.L(threadData)) {
                    nm6Var.E("2");
                }
                nm6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && nm6Var.getThreadData() != null && nm6Var.getThreadData().getAuthor() != null) {
                    if (!nm6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        ze8.t(nm6Var);
                        ze8.q(threadData);
                    } else {
                        ze8.v(nm6Var);
                    }
                } else if (nm6Var instanceof pm6) {
                    ze8.v(nm6Var);
                } else {
                    ze8.v(nm6Var);
                }
                nm6Var.a.insertItemToTitleOrAbstractText();
                if (nm6Var instanceof nm6) {
                    if (threadData.isBJHNormalThreadType()) {
                        ze8.w(nm6Var);
                    } else if (threadData.picCount() == 1) {
                        ze8.y(nm6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        nm6Var.j = imageWidthAndHeight[0];
                        nm6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        ze8.x(nm6Var);
                    } else {
                        ze8.z(nm6Var);
                    }
                } else if (nm6Var instanceof om6) {
                    ze8.A(nm6Var);
                }
                if (nm6Var instanceof pm6) {
                    ze8.B(nm6Var);
                }
                if (threadData.getItem() != null) {
                    ze8.C(nm6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        ze8.F(nm6Var);
                    } else {
                        ze8.D(nm6Var);
                    }
                }
                ze8.s(nm6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    ze8.u(nm6Var);
                }
                ze8.r(nm6Var);
                nm6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                nm6Var.position = i;
                arrayList.add(nm6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    ze8.q(threadData);
                }
                if (threadData.isShareThread) {
                    nm6 nm6Var2 = new nm6();
                    nm6Var2.a = threadData;
                    nm6Var2.position = i;
                    arrayList.add(nm6Var2);
                } else if (om6.L(threadData)) {
                    om6 om6Var = new om6(threadData);
                    om6Var.g = threadData.getTid();
                    if (concernData != null) {
                        om6Var.D(concernData.source.intValue());
                    }
                    if (om6Var.isValid()) {
                        arrayList.add(om6Var);
                    }
                } else if (mm6.R(threadData)) {
                    mm6 mm6Var = new mm6(threadData);
                    mm6Var.g = threadData.getTid();
                    mm6Var.E("3");
                    if (mm6Var.isValid()) {
                        arrayList.add(mm6Var);
                    }
                } else if (im6.R(threadData) && threadData.isBJHArticleThreadType()) {
                    im6 im6Var = new im6(threadData);
                    im6Var.position = i;
                    arrayList.add(im6Var);
                } else {
                    nm6 nm6Var3 = new nm6();
                    nm6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    nm6Var3.E(str);
                    nm6Var3.position = i;
                    if (concernData != null) {
                        nm6Var3.D(concernData.source.intValue());
                    }
                    if (nm6Var3.a != null && nm6Var3.isValid() && !StringUtils.isNull(nm6Var3.a.getId()) && !"0".equals(nm6Var3.a.getTid())) {
                        arrayList.add(nm6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
