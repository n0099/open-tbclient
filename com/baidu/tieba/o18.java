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
/* loaded from: classes7.dex */
public class o18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final q18 a;
    public final int b;
    public int c;
    public x18 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<wn> k;

    public final int g(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Comparator<hp6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(o18 o18Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o18Var};
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
        public int compare(hp6 hp6Var, hp6 hp6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hp6Var, hp6Var2)) == null) {
                if (hp6Var != null && hp6Var2 != null) {
                    if (hp6Var.getPosition() > hp6Var2.getPosition()) {
                        return 1;
                    }
                    if (hp6Var.getPosition() < hp6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends w16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ to6 j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(o18 o18Var, int i, String str, to6 to6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o18Var, Integer.valueOf(i), str, to6Var};
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
            this.j = to6Var;
        }

        @Override // com.baidu.tieba.w16, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                to6 to6Var = this.j;
                if (to6Var instanceof bp6) {
                    statisticItem = ((bp6) to6Var).R();
                } else if (to6Var instanceof cp6) {
                    statisticItem = ((cp6) to6Var).M(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public o18() {
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
        this.d = new x18();
        this.e = 0;
        this.j = 0L;
        this.a = new q18();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = o95.p().q("home_page_max_thread_count", 300);
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

    public final void B(List<hp6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }

    public void C(long j, boolean z) {
        q18 q18Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (q18Var = this.a) != null && !ListUtils.isEmpty(q18Var.a)) {
            for (wn wnVar : this.a.a) {
                if (wnVar instanceof to6) {
                    to6 to6Var = (to6) wnVar;
                    if (to6Var.n && j == to6Var.getThreadData().getFid() && z != to6Var.getThreadData().getForumData().f()) {
                        to6Var.getThreadData().getForumData().n(z);
                    }
                }
            }
        }
    }

    public final void a(List<wn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
            int i = 0;
            int i2 = 0;
            for (wn wnVar : list) {
                if (wnVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) wnVar;
                    if (recommendBarCardModel.k()) {
                        recommendBarCardModel.position = i2 + 1;
                        i++;
                    }
                }
                if (wnVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) wnVar;
                    i2 = baseCardInfo.position + i;
                    baseCardInfo.position = i2;
                }
            }
        }
    }

    public final void z(List<wn> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, list) == null) {
            Iterator<wn> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                wn next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if ((next instanceof RecommendBarCardModel) && !((RecommendBarCardModel) next).k()) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final j18 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q18 q18Var = this.a;
            if (q18Var != null && !ListUtils.isEmpty(q18Var.a)) {
                for (wn wnVar : this.a.a) {
                    if (wnVar instanceof j18) {
                        return (j18) wnVar;
                    }
                }
            }
            return null;
        }
        return (j18) invokeV.objValue;
    }

    public final l18 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q18 q18Var = this.a;
            if (q18Var != null && !ListUtils.isEmpty(q18Var.a)) {
                for (wn wnVar : this.a.a) {
                    if (wnVar instanceof l18) {
                        return (l18) wnVar;
                    }
                }
            }
            return null;
        }
        return (l18) invokeV.objValue;
    }

    @Nullable
    public final List<RecommendBarCardModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            q18 q18Var = this.a;
            if (q18Var != null && !ListUtils.isEmpty(q18Var.a)) {
                ArrayList arrayList = new ArrayList();
                for (wn wnVar : this.a.a) {
                    if (wnVar instanceof RecommendBarCardModel) {
                        RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) wnVar;
                        if (recommendBarCardModel.k()) {
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

    public q18 e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
            s18.c(builder);
            s18.c(builder2);
            x(z, builder, builder2, i);
            List<ThreadInfo> y = y(builder, i, this.b);
            s18.n(builder);
            List<AdvertAppInfo> f = bo9.l().f();
            int i3 = 0;
            if (i != 0 && z && f != null) {
                i2 = f.size();
            } else {
                i2 = 0;
            }
            List<hp6> d = s18.d(builder);
            B(d);
            List<wn> m = m(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2, i2);
            List<wn> m2 = m(y, new ArrayList(), builder2.user_follow_live, i, 1, null, i2);
            this.d.a(m);
            p18.c(builder, m);
            q18 q18Var = this.a;
            q18Var.a = m;
            if (m2 != null) {
                i3 = m2.size();
            }
            q18Var.c = i3;
            return this.a;
        }
        return (q18) invokeCommon.objValue;
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

    public final int i(int i, @NonNull List<wn> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048587, this, i, list, str)) == null) {
            return c28.a(i, list, str);
        }
        return invokeILL.intValue;
    }

    public final int j(@NonNull String str, @NonNull List<wn> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                wn wnVar = list.get(i);
                if (wnVar instanceof to6) {
                    to6 to6Var = (to6) wnVar;
                    if (to6Var.getThreadData() != null && !TextUtils.isEmpty(to6Var.getThreadData().getTid()) && str.equals(to6Var.getThreadData().getTid())) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void l(List<wn> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048590, this, list, userFollowLive) == null) && b() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            j18 j18Var = new j18();
            j18Var.d(userFollowLive);
            list.add(0, j18Var);
            this.a.a.add(0, j18Var);
            j18Var.position = -1;
        }
    }

    public final void k(hp6 hp6Var, List<wn> list, int i, int i2, int i3) {
        q66 q66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{hp6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = m66.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof q66) {
                q66Var = (q66) g;
            } else {
                q66Var = null;
            }
            if (hp6Var instanceof e18) {
                str = ((e18) hp6Var).a.a;
            }
            if (q66Var != null && !ListUtils.isEmpty(q66Var.d()) && q66Var.d().contains(str)) {
                m66.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && m66.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                m66.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && q66Var != null && q66Var.d() != null) {
                    q66Var.d().add(str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<wn> m(List<ThreadInfo> list, List<hp6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        j18 b2;
        List<RecommendBarCardModel> c2;
        int i5;
        l18 l18Var;
        boolean z;
        to6 e;
        bp6 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        bp6 g2;
        bp6 g3;
        bp6 g4;
        bp6 g5;
        int e2;
        RecommendBarCardModel recommendBarCardModel;
        int i6;
        pw7 pw7Var;
        int d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3)})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && tu4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<wn> arrayList = new ArrayList<>(ListUtils.getCount(list));
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
            if (i2 == 0 && nw7.k(builder)) {
                nw7 nw7Var = new nw7();
                nw7Var.h(builder.header_card);
                if (ListUtils.add(arrayList, nw7Var.getPosition(), nw7Var)) {
                    i4 = nw7Var.getPosition();
                    nw7Var.position = i4;
                    if (i2 == 0 && pw7.k(builder)) {
                        pw7Var = new pw7();
                        pw7Var.i(builder.hot_card);
                        d = pw7Var.d() - 1;
                        if (d >= 0 && ListUtils.add(arrayList, d, pw7Var)) {
                            pw7Var.position = d;
                        }
                    }
                    if (builder != null && RecommendBarCardModel.u(builder.hot_recomforum, -1)) {
                        recommendBarCardModel = new RecommendBarCardModel();
                        if (builder.hot_recomforum.floor.intValue() <= 0) {
                            i6 = builder.hot_recomforum.floor.intValue() - 1;
                        } else {
                            i6 = 0;
                        }
                        recommendBarCardModel.floorPosition = i6;
                        if (recommendBarCardModel.m(builder.hot_recomforum.tab_list)) {
                            n(recommendBarCardModel, recommendBarCardModel.floorPosition, arrayList);
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && A(builder)) {
                        int f = kc5.f();
                        e2 = kc5.e();
                        if (i == 0) {
                            e2 = kc5.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e2 > i4) {
                            e2++;
                        }
                        o(e2, f, arrayList);
                    }
                    List<wn> linkedList = new LinkedList<>();
                    int i7 = 0;
                    for (wn wnVar : arrayList) {
                        boolean z2 = wnVar instanceof ThreadData;
                        if (z2 && ((ThreadData) wnVar).isFunAdPlaceHolder()) {
                            if (A(builder)) {
                                linkedList.add(wnVar);
                                i7++;
                            }
                            c = 0;
                        } else if (z2) {
                            ThreadData threadData2 = (ThreadData) wnVar;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                a35 a35Var = new a35();
                                a35Var.e(threadData2.getLegoCard());
                                a35Var.position = i7;
                                linkedList.add(a35Var);
                            } else if (t48.J(threadData2)) {
                                if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    t48 t48Var = new t48();
                                    t48Var.L(threadData2.getTopicModule());
                                    t48Var.Z = 1;
                                    t48Var.position = i7;
                                    t48Var.M(threadData2);
                                    t48Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(t48Var);
                                }
                            } else if (!bp6.X(threadData2) && !cp6.P(threadData2) && !dp6.X(threadData2)) {
                                if (wo6.X(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    wo6 wo6Var = new wo6(threadData2);
                                    wo6Var.position = i7;
                                    linkedList.add(wo6Var);
                                } else {
                                    to6 e3 = s18.e(threadData2);
                                    if (e3 != null) {
                                        e3.g = threadData2.getTid();
                                        e3.position = i7;
                                    }
                                    if (e3 != null && e3.isValid()) {
                                        linkedList.add(e3);
                                    }
                                }
                            } else {
                                bp6 g6 = s18.g(threadData2);
                                if (g6 != null) {
                                    if (threadData2.showCardEnterFourm()) {
                                        if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i7;
                                            s18.t(g6);
                                            linkedList.add(g6);
                                        }
                                    } else {
                                        ThreadData threadData3 = g6.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i7;
                                            s18.r(g6);
                                            linkedList.add(g6);
                                            z = true;
                                            e = s18.e(threadData2);
                                            if (e != null) {
                                                e.g = threadData2.getTid();
                                                e.position = i7;
                                                if (e instanceof bp6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        s18.u(e);
                                                    } else if (threadData2.picCount() == 1) {
                                                        s18.w(e);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        e.j = imageWidthAndHeight[c];
                                                        e.k = imageWidthAndHeight[1];
                                                    } else if (threadData2.picCount() >= 2) {
                                                        s18.v(e);
                                                    } else {
                                                        s18.x(e);
                                                    }
                                                } else if (e instanceof cp6) {
                                                    s18.y(e);
                                                }
                                            }
                                            if (e instanceof dp6) {
                                                s18.z(e);
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
                                            if (threadData2.getItem() != null && (g5 = s18.g(threadData2)) != null) {
                                                g5.g = threadData2.getTid();
                                                g5.position = i7;
                                                s18.A(g5);
                                                if (!bp6.X(threadData2)) {
                                                    g5.F("1");
                                                } else if (cp6.P(threadData2)) {
                                                    g5.F("2");
                                                }
                                                linkedList.add(g5);
                                            }
                                            if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = s18.g(threadData2)) != null) {
                                                g.g = threadData2.getTid();
                                                g.position = i7;
                                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                                    s18.D(g);
                                                } else {
                                                    s18.B(g);
                                                }
                                                linkedList.add(g);
                                            }
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = s18.g(threadData2)) != null) {
                                                g4.g = threadData2.getTid();
                                                g4.position = i7;
                                                s18.C(g4);
                                                if (g4.isValid()) {
                                                    linkedList.add(g4);
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm() && (g3 = s18.g(threadData2)) != null) {
                                                g3.g = threadData2.getTid();
                                                g3.position = i7;
                                                s18.q(g3);
                                                if (!bp6.X(threadData2)) {
                                                    g3.F("1");
                                                } else if (cp6.P(threadData2)) {
                                                    g3.F("2");
                                                }
                                                if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                                bp6 g7 = s18.g(threadData2);
                                                if (g7 != null) {
                                                    g7.g = threadData2.getTid();
                                                    g7.position = i7;
                                                    s18.s(g7);
                                                }
                                                if (g7 != null && g7.isValid()) {
                                                    linkedList.add(g7);
                                                }
                                            }
                                            g2 = s18.g(threadData2);
                                            if (g2 != null) {
                                                g2.g = threadData2.getTid();
                                                g2.position = i7;
                                                s18.p(g2);
                                            }
                                            if (g2 != null && g2.isValid()) {
                                                linkedList.add(g2);
                                            }
                                        } else if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i7;
                                            s18.t(g6);
                                            linkedList.add(g6);
                                        }
                                    }
                                }
                                z = false;
                                e = s18.e(threadData2);
                                if (e != null) {
                                }
                                if (e instanceof dp6) {
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
                                    s18.A(g5);
                                    if (!bp6.X(threadData2)) {
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
                                    s18.C(g4);
                                    if (g4.isValid()) {
                                    }
                                }
                                if (threadData2.showCardEnterFourm()) {
                                    g3.g = threadData2.getTid();
                                    g3.position = i7;
                                    s18.q(g3);
                                    if (!bp6.X(threadData2)) {
                                    }
                                    if (!threadData2.showCardEnterFourm()) {
                                    }
                                    if (!StringUtils.isNull(threadData2.getForum_name())) {
                                    }
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                g2 = s18.g(threadData2);
                                if (g2 != null) {
                                }
                                if (g2 != null) {
                                    linkedList.add(g2);
                                }
                            }
                            long g8 = ug.g(threadData2.getId(), 0L);
                            if (g8 != 0 && g8 == this.j.longValue()) {
                                if (builder.active_center != null) {
                                    l18Var = new l18();
                                    l18Var.J(builder.active_center);
                                } else {
                                    l18Var = null;
                                }
                                if (l18Var == null) {
                                    l18Var = d();
                                }
                                if (l18Var != null) {
                                    i7++;
                                    l18Var.R = i7;
                                    linkedList.add(l18Var);
                                }
                            }
                            i7++;
                            c = 0;
                        } else {
                            if (wnVar instanceof BaseCardInfo) {
                                linkedList.add(wnVar);
                            } else {
                                linkedList.add(wnVar);
                            }
                            i7++;
                            c = 0;
                        }
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i8 = 0;
                        int i9 = 0;
                        for (int i10 = 0; i10 < ListUtils.getCount(list2); i10++) {
                            hp6 hp6Var = (hp6) ListUtils.getItem(list2, i10);
                            if (hp6Var != null && i8 < linkedList.size()) {
                                int i11 = i8;
                                while (i11 < linkedList.size() && (!(linkedList.get(i11) instanceof to6) || g(((to6) linkedList.get(i11)).position, i4) + i9 != hp6Var.getPosition() - 1)) {
                                    i11++;
                                }
                                if (linkedList.size() > i11 && i11 > 0) {
                                    linkedList.add(i11, hp6Var);
                                    int i12 = i9 + 1;
                                    k(hp6Var, linkedList, i11, i12, i3);
                                    i8 = i11;
                                    i9 = i12;
                                } else {
                                    i8 = i11;
                                }
                            }
                        }
                        int i13 = 0;
                        int i14 = 0;
                        for (wn wnVar2 : linkedList) {
                            if (wnVar2 instanceof z25) {
                                ((z25) wnVar2).setPosition(i14 + 1);
                                i13++;
                            } else if (wnVar2 instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) wnVar2;
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
                                String f2 = recommendBarCardModel2.f();
                                if (!TextUtils.isEmpty(f2) && (i5 = i(j(f2, linkedList), linkedList, f2)) >= 0 && i5 <= linkedList.size()) {
                                    linkedList.add(i5, recommendBarCardModel2);
                                    a(linkedList);
                                }
                            }
                        }
                    }
                    if (i2 == 0) {
                        if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                            j18 j18Var = new j18();
                            j18Var.d(userFollowLive);
                            linkedList.add(0, j18Var);
                            j18Var.position = -1;
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
            if (i2 == 0) {
                pw7Var = new pw7();
                pw7Var.i(builder.hot_card);
                d = pw7Var.d() - 1;
                if (d >= 0) {
                    pw7Var.position = d;
                }
            }
            if (builder != null) {
                recommendBarCardModel = new RecommendBarCardModel();
                if (builder.hot_recomforum.floor.intValue() <= 0) {
                }
                recommendBarCardModel.floorPosition = i6;
                if (recommendBarCardModel.m(builder.hot_recomforum.tab_list)) {
                }
            }
            if (i2 == 0) {
                int f3 = kc5.f();
                e2 = kc5.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e2++;
                }
                o(e2, f3, arrayList);
            }
            List<wn> linkedList2 = new LinkedList<>();
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
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList2);
            return linkedList2;
        }
        return (List) invokeCommon.objValue;
    }

    public void n(i15 i15Var, int i, List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048592, this, i15Var, i, list) != null) || i15Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    i15Var.floorPosition = i;
                    ListUtils.add(list, i3, i15Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void o(int i, int i2, List<wn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048593, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<wn> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        zz9 zz9Var = new zz9();
                        zz9Var.n(true);
                        threadData.funAdData = zz9Var;
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
            if (i3 > 0 && m66.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                m66.i().n(list, i3, 1);
            }
        }
    }

    public void r(List<wn> list, xq9 xq9Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048596, this, list, xq9Var, i) != null) || ListUtils.isEmpty(list) || xq9Var == null || i < 0) {
            return;
        }
        z(list);
        if (i == 0) {
            q(list, RecommendBarCardModel.e(xq9Var), xq9Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof to6) && !(list.get(i) instanceof z25)) {
            i++;
        }
        if (list.get(i) instanceof to6) {
            q(list, RecommendBarCardModel.e(xq9Var), ((to6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof z25) {
            q(list, RecommendBarCardModel.e(xq9Var), ((z25) list.get(i)).r() + 2);
        }
    }

    public boolean p(List<wn> list, k18 k18Var, int i, int i2) {
        InterceptResult invokeLLII;
        RecommendBarCardModel d;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048594, this, list, k18Var, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || k18Var == null || TextUtils.isEmpty(k18Var.b()) || i < 0 || i >= list.size() || i2 < 0 || i2 < i || i2 >= list.size() || (d = RecommendBarCardModel.d(k18Var)) == null || (i3 = i(j(k18Var.b(), list), list, k18Var.b())) < 0 || i3 > list.size() || i3 <= i) {
                return false;
            }
            d.n(k18Var.b());
            d.q(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
            list.add(i3, d);
            this.a.a.add(i3, d);
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
    public final void q(List<wn> list, RecommendBarCardModel recommendBarCardModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048595, this, list, recommendBarCardModel, i) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.i())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof to6) || ((to6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof z25) || ((z25) list.get(i3)).r() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (wn wnVar : list) {
                if (wnVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel2 = (RecommendBarCardModel) wnVar;
                    if (!recommendBarCardModel2.k()) {
                        recommendBarCardModel2.position = i4 + 1;
                        i2++;
                    }
                }
                if (wnVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) wnVar;
                    i4 = baseCardInfo.position + i2;
                    baseCardInfo.position = i4;
                }
            }
        }
    }

    public final void u(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            s18.k(z, builder, builder2, i, this.c, this.f, this.g);
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
                        JSONObject b2 = op9.b(threadInfo2);
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
                        JSONObject b3 = op9.b(threadInfo3);
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
                            fn9.c(builder4, count3);
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
            op9.f().h("HOME", arrayList);
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
