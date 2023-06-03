package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.group.AbsGroupUbsABTest;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.ThreadRecommendInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class z08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final b18 a;
    public final int b;
    public int c;
    public i18 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<vn> k;

    public final int g(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements Comparator<ap6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(z08 z08Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z08Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(ap6 ap6Var, ap6 ap6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, ap6Var, ap6Var2)) == null) {
                if (ap6Var != null && ap6Var2 != null) {
                    if (ap6Var.getPosition() > ap6Var2.getPosition()) {
                        return 1;
                    }
                    if (ap6Var.getPosition() < ap6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends p16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mo6 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(z08 z08Var, int i, String str, mo6 mo6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z08Var, Integer.valueOf(i), str, mo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = mo6Var;
        }

        @Override // com.baidu.tieba.p16, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                mo6 mo6Var = this.j;
                if (mo6Var instanceof uo6) {
                    statisticItem = ((uo6) mo6Var).R();
                } else if (mo6Var instanceof vo6) {
                    statisticItem = ((vo6) mo6Var).M(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public z08() {
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
        this.c = 0;
        this.d = new i18();
        this.e = 0;
        this.j = 0L;
        this.a = new b18();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = l95.m().n("home_page_max_thread_count", 300);
        }
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final boolean A(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, builder)) == null) {
            if (builder == null || (num = builder.show_adsense) == null || num.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void B(List<ap6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }

    public void C(long j, boolean z) {
        b18 b18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (b18Var = this.a) != null && !ListUtils.isEmpty(b18Var.a)) {
            for (vn vnVar : this.a.a) {
                if (vnVar instanceof mo6) {
                    mo6 mo6Var = (mo6) vnVar;
                    if (mo6Var.n && j == mo6Var.getThreadData().getFid() && z != mo6Var.getThreadData().getForumData().f()) {
                        mo6Var.getThreadData().getForumData().n(z);
                    }
                }
            }
        }
    }

    public final void a(List<vn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            int i = 0;
            int i2 = 0;
            for (vn vnVar : list) {
                if (vnVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) vnVar;
                    if (recommendBarCardModel.i()) {
                        recommendBarCardModel.position = i2 + 1;
                        i++;
                    }
                }
                if (vnVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) vnVar;
                    i2 = baseCardInfo.position + i;
                    baseCardInfo.position = i2;
                }
            }
        }
    }

    public final void z(List<vn> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            Iterator<vn> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                vn next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if ((next instanceof RecommendBarCardModel) && !((RecommendBarCardModel) next).i()) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final u08 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b18 b18Var = this.a;
            if (b18Var != null && !ListUtils.isEmpty(b18Var.a)) {
                for (vn vnVar : this.a.a) {
                    if (vnVar instanceof u08) {
                        return (u08) vnVar;
                    }
                }
            }
            return null;
        }
        return (u08) invokeV.objValue;
    }

    public final w08 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            b18 b18Var = this.a;
            if (b18Var != null && !ListUtils.isEmpty(b18Var.a)) {
                for (vn vnVar : this.a.a) {
                    if (vnVar instanceof w08) {
                        return (w08) vnVar;
                    }
                }
            }
            return null;
        }
        return (w08) invokeV.objValue;
    }

    @Nullable
    public final List<RecommendBarCardModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b18 b18Var = this.a;
            if (b18Var != null && !ListUtils.isEmpty(b18Var.a)) {
                ArrayList arrayList = new ArrayList();
                for (vn vnVar : this.a.a) {
                    if (vnVar instanceof RecommendBarCardModel) {
                        RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) vnVar;
                        if (recommendBarCardModel.i()) {
                            arrayList.add(recommendBarCardModel);
                        }
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public b18 e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            d18.c(builder);
            d18.c(builder2);
            x(z, builder, builder2, i);
            List<ThreadInfo> y = y(builder, i, this.b);
            d18.n(builder);
            List<AdvertAppInfo> f = em9.l().f();
            int i3 = 0;
            if (i != 0 && z && f != null) {
                i2 = f.size();
            } else {
                i2 = 0;
            }
            List<ap6> d = d18.d(builder);
            B(d);
            List<vn> m = m(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2, i2);
            List<vn> m2 = m(y, new ArrayList(), builder2.user_follow_live, i, 1, null, i2);
            this.d.a(m);
            a18.c(builder, m);
            b18 b18Var = this.a;
            b18Var.a = m;
            if (m2 != null) {
                i3 = m2.size();
            }
            b18Var.c = i3;
            return this.a;
        }
        return (b18) invokeCommon.objValue;
    }

    public List<ThreadInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int i(int i, @NonNull List<vn> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, list, str)) == null) {
            return n18.a(i, list, str);
        }
        return invokeILL.intValue;
    }

    public final int j(@NonNull String str, @NonNull List<vn> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                vn vnVar = list.get(i);
                if (vnVar instanceof mo6) {
                    mo6 mo6Var = (mo6) vnVar;
                    if (mo6Var.getThreadData() != null && !TextUtils.isEmpty(mo6Var.getThreadData().getTid()) && str.equals(mo6Var.getThreadData().getTid())) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void l(List<vn> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, userFollowLive) == null) && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow() && b() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            u08 u08Var = new u08();
            u08Var.d(userFollowLive);
            list.add(0, u08Var);
            this.a.a.add(0, u08Var);
            u08Var.position = -1;
        }
    }

    public final void k(ap6 ap6Var, List<vn> list, int i, int i2, int i3) {
        j66 j66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{ap6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = f66.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof j66) {
                j66Var = (j66) g;
            } else {
                j66Var = null;
            }
            if (ap6Var instanceof p08) {
                str = ((p08) ap6Var).a.a;
            }
            if (j66Var != null && !ListUtils.isEmpty(j66Var.d()) && j66Var.d().contains(str)) {
                f66.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && f66.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                f66.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && j66Var != null && j66Var.d() != null) {
                    j66Var.d().add(str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<vn> m(List<ThreadInfo> list, List<ap6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        List<vn> linkedList;
        u08 b2;
        List<RecommendBarCardModel> c2;
        int i5;
        w08 w08Var;
        boolean z;
        mo6 e;
        uo6 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        uo6 g2;
        uo6 g3;
        uo6 g4;
        uo6 g5;
        int e2;
        RecommendBarCardModel recommendBarCardModel;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3)})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && su4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<vn> arrayList = new ArrayList<>(ListUtils.getCount(list));
            Iterator<ThreadInfo> it = list.iterator();
            while (true) {
                c = 0;
                if (!it.hasNext()) {
                    break;
                }
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(it.next());
                arrayList.add(threadData);
            }
            if (i2 == 0 && cw7.k(builder)) {
                cw7 cw7Var = new cw7();
                cw7Var.h(builder.header_card);
                if (ListUtils.add(arrayList, cw7Var.getPosition(), cw7Var)) {
                    i4 = cw7Var.getPosition();
                    cw7Var.position = i4;
                    if (builder != null && RecommendBarCardModel.s(builder.hot_recomforum, -1)) {
                        recommendBarCardModel = new RecommendBarCardModel();
                        if (builder.hot_recomforum.floor.intValue() <= 0) {
                            i6 = builder.hot_recomforum.floor.intValue() - 1;
                        } else {
                            i6 = 0;
                        }
                        recommendBarCardModel.floorPosition = i6;
                        if (recommendBarCardModel.l(builder.hot_recomforum.tab_list)) {
                            n(recommendBarCardModel, recommendBarCardModel.floorPosition, arrayList);
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && A(builder)) {
                        int f = hc5.f();
                        e2 = hc5.e();
                        if (i == 0) {
                            e2 = hc5.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e2 > i4) {
                            e2++;
                        }
                        o(e2, f, arrayList);
                    }
                    linkedList = new LinkedList<>();
                    int i7 = 0;
                    for (vn vnVar : arrayList) {
                        boolean z2 = vnVar instanceof ThreadData;
                        if (z2 && ((ThreadData) vnVar).isFunAdPlaceHolder()) {
                            if (A(builder)) {
                                linkedList.add(vnVar);
                                i7++;
                            }
                            c = 0;
                        } else if (z2) {
                            ThreadData threadData2 = (ThreadData) vnVar;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                x25 x25Var = new x25();
                                x25Var.e(threadData2.getLegoCard());
                                x25Var.position = i7;
                                linkedList.add(x25Var);
                            } else if (b48.J(threadData2)) {
                                if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    b48 b48Var = new b48();
                                    b48Var.L(threadData2.getTopicModule());
                                    b48Var.Z = 1;
                                    b48Var.position = i7;
                                    b48Var.M(threadData2);
                                    b48Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(b48Var);
                                }
                            } else if (!uo6.X(threadData2) && !vo6.P(threadData2) && !wo6.X(threadData2)) {
                                if (po6.X(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    po6 po6Var = new po6(threadData2);
                                    po6Var.position = i7;
                                    linkedList.add(po6Var);
                                } else {
                                    mo6 e3 = d18.e(threadData2);
                                    if (e3 != null) {
                                        e3.g = threadData2.getTid();
                                        e3.position = i7;
                                    }
                                    if (e3 != null && e3.isValid()) {
                                        linkedList.add(e3);
                                    }
                                }
                            } else {
                                uo6 g6 = d18.g(threadData2);
                                if (g6 != null) {
                                    if (threadData2.showCardEnterFourm()) {
                                        if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i7;
                                            d18.t(g6);
                                            linkedList.add(g6);
                                        }
                                    } else {
                                        ThreadData threadData3 = g6.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i7;
                                            d18.r(g6);
                                            linkedList.add(g6);
                                            z = true;
                                            e = d18.e(threadData2);
                                            if (e != null) {
                                                e.g = threadData2.getTid();
                                                e.position = i7;
                                                if (e instanceof uo6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        d18.u(e);
                                                    } else if (threadData2.picCount() == 1) {
                                                        d18.w(e);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        e.j = imageWidthAndHeight[c];
                                                        e.k = imageWidthAndHeight[1];
                                                    } else if (threadData2.picCount() >= 2) {
                                                        d18.v(e);
                                                    } else {
                                                        d18.x(e);
                                                    }
                                                } else if (e instanceof vo6) {
                                                    d18.y(e);
                                                }
                                            }
                                            if (e instanceof wo6) {
                                                d18.z(e);
                                            }
                                            if (e != null && e.isValid()) {
                                                e.a.insertItemToTitleOrAbstractText();
                                                if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z) {
                                                    String string = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                                    Object[] objArr = new Object[1];
                                                    objArr[c] = threadData2.getAuthor().getName_show();
                                                    String format = String.format(string, objArr);
                                                    SpannableString spannableString = new SpannableString(format);
                                                    spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format.length() - 1, 33);
                                                    e.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                                }
                                                linkedList.add(e);
                                            }
                                            if (threadData2.getItem() != null && (g5 = d18.g(threadData2)) != null) {
                                                g5.g = threadData2.getTid();
                                                g5.position = i7;
                                                d18.A(g5);
                                                if (!uo6.X(threadData2)) {
                                                    g5.F("1");
                                                } else if (vo6.P(threadData2)) {
                                                    g5.F("2");
                                                }
                                                linkedList.add(g5);
                                            }
                                            if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = d18.g(threadData2)) != null) {
                                                g.g = threadData2.getTid();
                                                g.position = i7;
                                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                                    d18.D(g);
                                                } else {
                                                    d18.B(g);
                                                }
                                                linkedList.add(g);
                                            }
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = d18.g(threadData2)) != null) {
                                                g4.g = threadData2.getTid();
                                                g4.position = i7;
                                                d18.C(g4);
                                                if (g4.isValid()) {
                                                    linkedList.add(g4);
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm() && (g3 = d18.g(threadData2)) != null) {
                                                g3.g = threadData2.getTid();
                                                g3.position = i7;
                                                d18.q(g3);
                                                if (!uo6.X(threadData2)) {
                                                    g3.F("1");
                                                } else if (vo6.P(threadData2)) {
                                                    g3.F("2");
                                                }
                                                if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                                uo6 g7 = d18.g(threadData2);
                                                if (g7 != null) {
                                                    g7.g = threadData2.getTid();
                                                    g7.position = i7;
                                                    d18.s(g7);
                                                }
                                                if (g7 != null && g7.isValid()) {
                                                    linkedList.add(g7);
                                                }
                                            }
                                            g2 = d18.g(threadData2);
                                            if (g2 != null) {
                                                g2.g = threadData2.getTid();
                                                g2.position = i7;
                                                d18.p(g2);
                                            }
                                            if (g2 != null && g2.isValid()) {
                                                linkedList.add(g2);
                                            }
                                        } else if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i7;
                                            d18.t(g6);
                                            linkedList.add(g6);
                                        }
                                    }
                                }
                                z = false;
                                e = d18.e(threadData2);
                                if (e != null) {
                                }
                                if (e instanceof wo6) {
                                }
                                if (e != null) {
                                    e.a.insertItemToTitleOrAbstractText();
                                    if (!threadData2.isUgcThreadType()) {
                                        String string2 = TbadkCoreApplication.getInst().getString(R.string.at_username);
                                        Object[] objArr2 = new Object[1];
                                        objArr2[c] = threadData2.getAuthor().getName_show();
                                        String format2 = String.format(string2, objArr2);
                                        SpannableString spannableString2 = new SpannableString(format2);
                                        spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format2.length() - 1, 33);
                                        e.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                                    }
                                    linkedList.add(e);
                                }
                                if (threadData2.getItem() != null) {
                                    g5.g = threadData2.getTid();
                                    g5.position = i7;
                                    d18.A(g5);
                                    if (!uo6.X(threadData2)) {
                                    }
                                    linkedList.add(g5);
                                }
                                if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                }
                                g.g = threadData2.getTid();
                                g.position = i7;
                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                }
                                linkedList.add(g);
                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                if (threadRecommendInfoData != null) {
                                    g4.g = threadData2.getTid();
                                    g4.position = i7;
                                    d18.C(g4);
                                    if (g4.isValid()) {
                                    }
                                }
                                if (threadData2.showCardEnterFourm()) {
                                    g3.g = threadData2.getTid();
                                    g3.position = i7;
                                    d18.q(g3);
                                    if (!uo6.X(threadData2)) {
                                    }
                                    if (!threadData2.showCardEnterFourm()) {
                                    }
                                    if (!StringUtils.isNull(threadData2.getForum_name())) {
                                    }
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                g2 = d18.g(threadData2);
                                if (g2 != null) {
                                }
                                if (g2 != null) {
                                    linkedList.add(g2);
                                }
                            }
                            long g8 = tg.g(threadData2.getId(), 0L);
                            if (g8 != 0 && g8 == this.j.longValue()) {
                                if (builder.active_center != null) {
                                    w08Var = new w08();
                                    w08Var.J(builder.active_center);
                                } else {
                                    w08Var = null;
                                }
                                if (w08Var == null) {
                                    w08Var = d();
                                }
                                if (w08Var != null) {
                                    i7++;
                                    w08Var.R = i7;
                                    linkedList.add(w08Var);
                                }
                            }
                            i7++;
                            c = 0;
                        } else {
                            if (vnVar instanceof BaseCardInfo) {
                                linkedList.add(vnVar);
                            } else {
                                linkedList.add(vnVar);
                            }
                            i7++;
                            c = 0;
                        }
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i8 = 0;
                        int i9 = 0;
                        for (int i10 = 0; i10 < ListUtils.getCount(list2); i10++) {
                            ap6 ap6Var = (ap6) ListUtils.getItem(list2, i10);
                            if (ap6Var != null && i8 < linkedList.size()) {
                                int i11 = i8;
                                while (i11 < linkedList.size() && (!(linkedList.get(i11) instanceof mo6) || g(((mo6) linkedList.get(i11)).position, i4) + i9 != ap6Var.getPosition() - 1)) {
                                    i11++;
                                }
                                if (linkedList.size() > i11 && i11 > 0) {
                                    linkedList.add(i11, ap6Var);
                                    int i12 = i9 + 1;
                                    k(ap6Var, linkedList, i11, i12, i3);
                                    i8 = i11;
                                    i9 = i12;
                                } else {
                                    i8 = i11;
                                }
                            }
                        }
                        int i13 = 0;
                        int i14 = 0;
                        for (vn vnVar2 : linkedList) {
                            if (vnVar2 instanceof w25) {
                                ((w25) vnVar2).setPosition(i14 + 1);
                                i13++;
                            } else if (vnVar2 instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) vnVar2;
                                int i15 = baseCardInfo.position + i13;
                                baseCardInfo.position = i15;
                                i14 = i15;
                            }
                        }
                    }
                    if (i2 == 0 && i == 1) {
                        c2 = c();
                        if (!ListUtils.isEmpty(c2)) {
                            for (RecommendBarCardModel recommendBarCardModel2 : c2) {
                                String e4 = recommendBarCardModel2.e();
                                if (!TextUtils.isEmpty(e4) && (i5 = i(j(e4, linkedList), linkedList, e4)) >= 0 && i5 <= linkedList.size()) {
                                    linkedList.add(i5, recommendBarCardModel2);
                                    a(linkedList);
                                }
                            }
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow()) {
                        if (i != 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                            u08 u08Var = new u08();
                            u08Var.d(userFollowLive);
                            linkedList.add(0, u08Var);
                            u08Var.position = -1;
                        } else if (i == 1 && (b2 = b()) != null) {
                            linkedList.add(0, b2);
                            b2.position = -1;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    return linkedList;
                }
            }
            i4 = -1;
            if (builder != null) {
                recommendBarCardModel = new RecommendBarCardModel();
                if (builder.hot_recomforum.floor.intValue() <= 0) {
                }
                recommendBarCardModel.floorPosition = i6;
                if (recommendBarCardModel.l(builder.hot_recomforum.tab_list)) {
                }
            }
            if (i2 == 0) {
                int f2 = hc5.f();
                e2 = hc5.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e2++;
                }
                o(e2, f2, arrayList);
            }
            linkedList = new LinkedList<>();
            int i72 = 0;
            while (r4.hasNext()) {
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
            }
            if (i2 == 0) {
                c2 = c();
                if (!ListUtils.isEmpty(c2)) {
                }
            }
            if (i2 == 0) {
                if (i != 0) {
                }
                if (i == 1) {
                    linkedList.add(0, b2);
                    b2.position = -1;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void n(f15 f15Var, int i, List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048592, this, f15Var, i, list) != null) || f15Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    f15Var.floorPosition = i;
                    ListUtils.add(list, i3, f15Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void o(int i, int i2, List<vn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048593, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<vn> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        cy9 cy9Var = new cy9();
                        cy9Var.n(true);
                        threadData.funAdData = cy9Var;
                        listIterator.add(threadData);
                        this.k.add(threadData);
                    }
                    i5++;
                    if (i3 == 0) {
                        i3 = i4 + 1;
                    }
                }
                listIterator.next();
                i4++;
            }
            if (i3 > 0 && f66.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                f66.i().n(list, i3, 1);
            }
        }
    }

    public void r(List<vn> list, ap9 ap9Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048596, this, list, ap9Var, i) != null) || ListUtils.isEmpty(list) || ap9Var == null || i < 0) {
            return;
        }
        z(list);
        if (i == 0) {
            q(list, RecommendBarCardModel.d(ap9Var), ap9Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof mo6) && !(list.get(i) instanceof w25)) {
            i++;
        }
        if (list.get(i) instanceof mo6) {
            q(list, RecommendBarCardModel.d(ap9Var), ((mo6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof w25) {
            q(list, RecommendBarCardModel.d(ap9Var), ((w25) list.get(i)).r() + 2);
        }
    }

    public boolean p(List<vn> list, v08 v08Var, int i, int i2) {
        InterceptResult invokeLLII;
        RecommendBarCardModel c;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048594, this, list, v08Var, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || v08Var == null || TextUtils.isEmpty(v08Var.b()) || i < 0 || i >= list.size() || i2 < 0 || i2 < i || i2 >= list.size() || (c = RecommendBarCardModel.c(v08Var)) == null || (i3 = i(j(v08Var.b(), list), list, v08Var.b())) < 0 || i3 > list.size() || i3 <= i) {
                return false;
            }
            c.m(v08Var.b());
            c.o(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
            list.add(i3, c);
            this.a.a.add(i3, c);
            a(list);
            return true;
        }
        return invokeLLII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r5.size() <= r0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r5.add(r0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
        r5.add(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(List<vn> list, RecommendBarCardModel recommendBarCardModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048595, this, list, recommendBarCardModel, i) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.h())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof mo6) || ((mo6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof w25) || ((w25) list.get(i3)).r() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (vn vnVar : list) {
                if (vnVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel2 = (RecommendBarCardModel) vnVar;
                    if (!recommendBarCardModel2.i()) {
                        recommendBarCardModel2.position = i4 + 1;
                        i2++;
                    }
                }
                if (vnVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) vnVar;
                    i4 = baseCardInfo.position + i2;
                    baseCardInfo.position = i4;
                }
            }
        }
    }

    public final void u(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            d18.k(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void v(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
            this.f = ListUtils.getCount(list);
            BannerList bannerList = builder.banner_list;
            if (bannerList != null) {
                this.g = ListUtils.getCount(bannerList.app);
            } else {
                this.g = 0;
            }
            int count = ListUtils.getCount(list) + ListUtils.getCount(this.h);
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (ThreadInfo threadInfo : list) {
                if (threadInfo != null && !TextUtils.isEmpty(threadInfo.lego_card)) {
                    hashSet2.add(threadInfo.lego_card);
                } else if (threadInfo != null && (l5 = threadInfo.tid) != null) {
                    hashSet.add(l5);
                }
            }
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            Iterator<ThreadInfo> it = this.h.iterator();
            while (it.hasNext()) {
                ThreadInfo next = it.next();
                if (next != null && !TextUtils.isEmpty(next.lego_card)) {
                    hashSet4.add(next.lego_card);
                } else if (next != null && (l4 = next.tid) != null) {
                    hashSet3.add(l4);
                }
            }
            if (i == 1) {
                if (!ListUtils.isEmpty(list2)) {
                    this.d.b((ThreadInfo) ListUtils.getItem(list2, 0));
                }
                for (ThreadInfo threadInfo2 : list2) {
                    if (threadInfo2 != null && !TextUtils.isEmpty(threadInfo2.lego_card)) {
                        if (!hashSet2.contains(threadInfo2.lego_card) && !hashSet4.contains(threadInfo2.lego_card)) {
                            list.add(threadInfo2);
                        }
                    } else if (threadInfo2 != null && (l3 = threadInfo2.tid) != null && !hashSet.contains(l3) && !hashSet3.contains(threadInfo2.tid)) {
                        list.add(threadInfo2);
                        JSONObject b2 = rn9.b(threadInfo2);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (t()) {
                    BannerList bannerList2 = builder.banner_list;
                    if (bannerList2 != null && !ListUtils.isEmpty(bannerList2.app)) {
                        this.i.addAll(0, builder.banner_list.app);
                        BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                        builder3.app = new LinkedList();
                        builder.banner_list = builder3.build(false);
                    }
                    this.h.addAll(0, list);
                    list.clear();
                    hashSet.clear();
                    hashSet2.clear();
                    if (ListUtils.getCount(this.h) > this.b) {
                        for (int size = this.h.size() - 1; size >= this.b; size--) {
                            this.h.remove(size);
                        }
                    }
                    hashSet3.clear();
                    hashSet4.clear();
                    Iterator<ThreadInfo> it2 = this.h.iterator();
                    while (it2.hasNext()) {
                        ThreadInfo next2 = it2.next();
                        if (next2 != null && !TextUtils.isEmpty(next2.lego_card)) {
                            hashSet4.add(next2.lego_card);
                        } else if (next2 != null && (l2 = next2.tid) != null) {
                            hashSet3.add(l2);
                        }
                    }
                }
                for (int count2 = ListUtils.getCount(list2) - 1; count2 >= 0; count2--) {
                    ThreadInfo threadInfo3 = (ThreadInfo) ListUtils.getItem(list2, count2);
                    if (threadInfo3 != null && !TextUtils.isEmpty(threadInfo3.lego_card)) {
                        if (!hashSet2.contains(threadInfo3.lego_card) && !hashSet4.contains(threadInfo3.lego_card)) {
                            list.add(0, threadInfo3);
                        }
                    } else if (threadInfo3 != null && (l = threadInfo3.tid) != null && ((!hashSet.contains(l) && !hashSet3.contains(threadInfo3.tid)) || threadInfo3.is_highlight.intValue() == 1)) {
                        list.add(0, threadInfo3);
                        JSONObject b3 = rn9.b(threadInfo3);
                        if (b3 != null) {
                            arrayList.add(0, b3);
                        }
                    }
                }
            }
            if (t()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            il9.c(builder4, count3);
                            App build = builder4.build(false);
                            this.i.remove(i2);
                            this.i.add(i2, build);
                        }
                    }
                }
                if (ListUtils.getCount(list) >= this.e) {
                    list.addAll(this.h);
                    this.h.clear();
                    BannerList.Builder builder5 = new BannerList.Builder(builder.banner_list);
                    if (builder5.app == null) {
                        builder5.app = new LinkedList();
                    }
                    builder5.app.addAll(this.i);
                    builder.banner_list = builder5.build(false);
                    this.i.clear();
                }
            }
            int count4 = (ListUtils.getCount(list) + ListUtils.getCount(this.h)) - count;
            this.a.b = count4;
            this.c = count4;
            rn9.f().h("HOME", arrayList);
        }
    }

    public final void w(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048601, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void x(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
            Integer num = builder2.fresh_ctrl_num;
            if (num != null && num.intValue() > 0) {
                i2 = builder2.fresh_ctrl_num.intValue();
            } else {
                i2 = 0;
            }
            this.e = i2;
            int i3 = this.b;
            if (i2 > i3) {
                i2 = i3;
            }
            this.e = i2;
            v(z, builder, builder2, i);
            u(z, builder, builder2, i);
            w(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final List<ThreadInfo> y(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048603, this, builder, i, i2)) == null) {
            ArrayList arrayList = new ArrayList();
            if (builder != null && (list = builder.thread_list) != null) {
                if (i == 1) {
                    for (int count = ((ListUtils.getCount(list) - i2) + 30) - 1; count >= 30; count--) {
                        if (list.size() > count) {
                            arrayList.add(list.remove(count));
                        }
                    }
                } else {
                    for (int count2 = ListUtils.getCount(list) - 1; count2 >= i2; count2--) {
                        list.remove(count2);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLII.objValue;
    }
}
