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
public class ln7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fs7 a;
    public boolean b;

    public ln7() {
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
        this.a = new fs7();
    }

    public static void a(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, builder) == null) && builder != null && builder.thread_info == null) {
            builder.thread_info = new LinkedList();
        }
    }

    public final fn7 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            fs7 fs7Var = this.a;
            if (fs7Var != null && !ListUtils.isEmpty(fs7Var.a)) {
                for (hn hnVar : this.a.a) {
                    if (hnVar instanceof fn7) {
                        return (fn7) hnVar;
                    }
                }
            }
            return null;
        }
        return (fn7) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public fs7 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
                fn7 fn7Var = new fn7();
                fn7Var.d(userFollowLive);
                linkedList.add(0, fn7Var);
                fn7Var.position = -1;
                this.b = true;
            } else {
                if (i == 1) {
                    fn7 b = b();
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
                        if (hn7.i(builder.hot_recomforum, i2)) {
                            hn7 hn7Var = new hn7();
                            if (hn7Var.f(builder.hot_recomforum.tab_list)) {
                                hn7Var.position = i2;
                                linkedList.add(hn7Var);
                                i2++;
                            }
                        }
                        if (en7.f(concernData)) {
                            en7 en7Var = new en7();
                            if (concernData.recom_user_list.size() >= 4) {
                                en7Var.d(concernData.recom_user_list);
                                en7Var.position = i2;
                                if (builder.thread_info.size() > 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                en7Var.h(z2);
                                linkedList.add(en7Var);
                            }
                        } else {
                            ThreadData threadData = new ThreadData();
                            threadData.setFromConcern(true);
                            AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                            threadData.parserProtobuf(concernData.thread_list);
                            JSONObject b2 = ic9.b(concernData.thread_list);
                            if (b2 != null) {
                                arrayList.add(b2);
                            }
                            linkedList.addAll(f(threadData, i2, concernData));
                        }
                        i2++;
                    }
                }
                AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                ic9.f().h("CONCERN", arrayList);
                fs7 fs7Var = this.a;
                fs7Var.a = linkedList;
                return fs7Var;
            }
            i2 = 1;
            while (r11.hasNext()) {
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            ic9.f().h("CONCERN", arrayList);
            fs7 fs7Var2 = this.a;
            fs7Var2.a = linkedList;
            return fs7Var2;
        }
        return (fs7) invokeCommon.objValue;
    }

    public final void d(boolean z, List<ConcernData> list, List<ConcernData> list2, int i) {
        ThreadInfo threadInfo;
        ThreadInfo threadInfo2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), list, list2, Integer.valueOf(i)}) == null) && list != null && list2 != null) {
            int count = ListUtils.getCount(list);
            if (i == 1) {
                for (ConcernData concernData : list2) {
                    if (en7.f(concernData)) {
                        list.add(concernData);
                    } else if (concernData != null && (threadInfo2 = concernData.thread_list) != null && threadInfo2.tid != null) {
                        list.add(concernData);
                    }
                }
            } else {
                if (!am7.I()) {
                    list.clear();
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ConcernData concernData2 = (ConcernData) ListUtils.getItem(list2, count2);
                    if (concernData2 != null && en7.f(concernData2)) {
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

    public List<hn> f(ThreadData threadData, int i, ConcernData concernData) {
        InterceptResult invokeLIL;
        eh6 mh6Var;
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048580, this, threadData, i, concernData)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = "1";
            if ((mh6.W(threadData) || nh6.R(threadData) || oh6.W(threadData)) && threadData.getType() != ThreadData.TYPE_SHARE_THREAD) {
                if (oh6.W(threadData)) {
                    mh6Var = new oh6(threadData);
                } else if (nh6.R(threadData)) {
                    mh6Var = new nh6(threadData);
                } else {
                    mh6Var = new mh6();
                    threadData.isLinkThread();
                    threadData.isSmartAppThreadType();
                    if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                        threadData.isGodThread();
                    }
                    mh6Var.a = threadData;
                }
                mh6Var.g = threadData.getTid();
                if (mh6.W(threadData)) {
                    mh6Var.H("1");
                } else if (nh6.R(threadData)) {
                    mh6Var.H("2");
                }
                mh6Var.B = true;
                if (UbsABTestHelper.isConcernForumCardShow() && mh6Var.getThreadData() != null && mh6Var.getThreadData().getAuthor() != null) {
                    if (!mh6Var.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                        gs7.r(mh6Var);
                        gs7.o(threadData);
                    } else {
                        gs7.t(mh6Var);
                    }
                } else if (mh6Var instanceof oh6) {
                    gs7.t(mh6Var);
                } else {
                    gs7.t(mh6Var);
                }
                mh6Var.a.insertItemToTitleOrAbstractText();
                if (mh6Var instanceof mh6) {
                    if (threadData.isBJHNormalThreadType()) {
                        gs7.u(mh6Var);
                    } else if (threadData.picCount() == 1) {
                        gs7.w(mh6Var);
                        int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                        mh6Var.j = imageWidthAndHeight[0];
                        mh6Var.k = imageWidthAndHeight[1];
                    } else if (threadData.picCount() >= 2) {
                        gs7.v(mh6Var);
                    } else {
                        gs7.x(mh6Var);
                    }
                } else if (mh6Var instanceof nh6) {
                    gs7.y(mh6Var);
                }
                if (mh6Var instanceof oh6) {
                    gs7.z(mh6Var);
                }
                if (threadData.getItem() != null) {
                    gs7.A(mh6Var);
                }
                if (!ListUtils.isEmpty(threadData.getLinkDataList()) || !ListUtils.isEmpty(threadData.getGoodsDataList())) {
                    if (ListUtils.getCount(threadData.getLinkDataList()) + ListUtils.getCount(threadData.getGoodsDataList()) == 1) {
                        gs7.D(mh6Var);
                    } else {
                        gs7.B(mh6Var);
                    }
                }
                gs7.q(mh6Var);
                if (concernData != null && (threadInfo = concernData.thread_list) != null && threadInfo.top_agree_post != null) {
                    gs7.s(mh6Var);
                }
                gs7.p(mh6Var);
                mh6Var.setSupportType(BaseCardInfo.SupportType.TOP);
                mh6Var.position = i;
                arrayList.add(mh6Var);
            } else {
                if (UbsABTestHelper.isConcernForumCardShow() && threadData.getThreadData() != null && threadData.getThreadData().getAuthor() != null && !threadData.getThreadData().getAuthor().hadConcerned() && !ThreadCardUtils.isSelf(threadData)) {
                    gs7.o(threadData);
                }
                if (threadData.isShareThread) {
                    mh6 mh6Var2 = new mh6();
                    mh6Var2.a = threadData;
                    mh6Var2.position = i;
                    arrayList.add(mh6Var2);
                } else if (nh6.R(threadData)) {
                    nh6 nh6Var = new nh6(threadData);
                    nh6Var.g = threadData.getTid();
                    if (concernData != null) {
                        nh6Var.G(concernData.source.intValue());
                    }
                    if (nh6Var.isValid()) {
                        arrayList.add(nh6Var);
                    }
                } else if (lh6.W(threadData)) {
                    lh6 lh6Var = new lh6(threadData);
                    lh6Var.g = threadData.getTid();
                    lh6Var.H("3");
                    if (lh6Var.isValid()) {
                        arrayList.add(lh6Var);
                    }
                } else if (hh6.W(threadData) && threadData.isBJHArticleThreadType()) {
                    hh6 hh6Var = new hh6(threadData);
                    hh6Var.position = i;
                    arrayList.add(hh6Var);
                } else {
                    mh6 mh6Var3 = new mh6();
                    mh6Var3.a = threadData;
                    if (threadData.isLinkThread()) {
                        str = "4";
                    }
                    mh6Var3.H(str);
                    mh6Var3.position = i;
                    if (concernData != null) {
                        mh6Var3.G(concernData.source.intValue());
                    }
                    if (mh6Var3.a != null && mh6Var3.isValid() && !StringUtils.isNull(mh6Var3.a.getId()) && !"0".equals(mh6Var3.a.getTid())) {
                        arrayList.add(mh6Var3);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLIL.objValue;
    }
}
