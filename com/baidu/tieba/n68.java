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
import tbclient.Personalized.HeaderCard;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes7.dex */
public class n68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p68 a;
    public final int b;
    public int c;
    public w68 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<yn> k;

    public final int g(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes7.dex */
    public class a implements Comparator<qq6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n68 n68Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n68Var};
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
        public int compare(qq6 qq6Var, qq6 qq6Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, qq6Var, qq6Var2)) == null) {
                if (qq6Var != null && qq6Var2 != null) {
                    if (qq6Var.getPosition() > qq6Var2.getPosition()) {
                        return 1;
                    }
                    if (qq6Var.getPosition() < qq6Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends f36 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cq6 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n68 n68Var, int i, String str, cq6 cq6Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n68Var, Integer.valueOf(i), str, cq6Var};
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
            this.l = cq6Var;
        }

        @Override // com.baidu.tieba.f36, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), f(), null)));
                cq6 cq6Var = this.l;
                if (cq6Var instanceof kq6) {
                    statisticItem = ((kq6) cq6Var).R();
                } else if (cq6Var instanceof lq6) {
                    statisticItem = ((lq6) cq6Var).M(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public n68() {
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
        this.d = new w68();
        this.e = 0;
        this.j = 0L;
        this.a = new p68();
        if (UbsABTestHelper.disableHomeMaxThreadCount()) {
            this.b = LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        } else {
            this.b = da5.p().q("home_page_max_thread_count", 300);
        }
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final List<ThreadInfo> A(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, builder, i, i2)) == null) {
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

    public final void B(List<yn> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            Iterator<yn> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                yn next = it.next();
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

    public final void a(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            int i = 0;
            int i2 = 0;
            for (yn ynVar : list) {
                if (ynVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) ynVar;
                    if (recommendBarCardModel.i()) {
                        recommendBarCardModel.position = i2 + 1;
                        i++;
                    }
                }
                if (ynVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) ynVar;
                    i2 = baseCardInfo.position + i;
                    baseCardInfo.position = i2;
                }
            }
        }
    }

    public final boolean C(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, builder)) == null) {
            if (builder == null || (num = builder.show_adsense) == null || num.intValue() != 1) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void D(List<qq6> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }

    public void E(long j, boolean z) {
        p68 p68Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) && (p68Var = this.a) != null && !ListUtils.isEmpty(p68Var.a)) {
            for (yn ynVar : this.a.a) {
                if (ynVar instanceof cq6) {
                    cq6 cq6Var = (cq6) ynVar;
                    if (cq6Var.n && j == cq6Var.getThreadData().getFid() && z != cq6Var.getThreadData().getForumData().f()) {
                        cq6Var.getThreadData().getForumData().n(z);
                    }
                }
            }
        }
    }

    public boolean s(List<yn> list, l18 l18Var) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, list, l18Var)) == null) {
            if (list != null && this.a.a != null && l18Var != null && StringUtils.isNotNull(l18Var.getTid())) {
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        break;
                    }
                    yn ynVar = list.get(i3);
                    if (ynVar instanceof kq6) {
                        kq6 kq6Var = (kq6) ynVar;
                        if (kq6Var.getThreadData() != null && StringUtils.isNotNull(kq6Var.getThreadData().getTid()) && kq6Var.getThreadData().getTid().equals(l18Var.getTid())) {
                            l18Var.e0(kq6Var.getThreadData().getClickBackCard());
                            i2 = i3;
                            break;
                        }
                    }
                    i3++;
                }
                if (u(list, l18Var) || !l18.f0(l18Var) || (i = i(i2, list, l18Var.getTid())) < 0) {
                    return false;
                }
                list.add(i, l18Var);
                this.a.a.add(i, l18Var);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final h68 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            p68 p68Var = this.a;
            if (p68Var != null && !ListUtils.isEmpty(p68Var.a)) {
                for (yn ynVar : this.a.a) {
                    if (ynVar instanceof h68) {
                        return (h68) ynVar;
                    }
                }
            }
            return null;
        }
        return (h68) invokeV.objValue;
    }

    public final j68 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            p68 p68Var = this.a;
            if (p68Var != null && !ListUtils.isEmpty(p68Var.a)) {
                for (yn ynVar : this.a.a) {
                    if (ynVar instanceof j68) {
                        return (j68) ynVar;
                    }
                }
            }
            return null;
        }
        return (j68) invokeV.objValue;
    }

    @Nullable
    public final List<RecommendBarCardModel> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            p68 p68Var = this.a;
            if (p68Var != null && !ListUtils.isEmpty(p68Var.a)) {
                ArrayList arrayList = new ArrayList();
                for (yn ynVar : this.a.a) {
                    if (ynVar instanceof RecommendBarCardModel) {
                        RecommendBarCardModel recommendBarCardModel = (RecommendBarCardModel) ynVar;
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

    public p68 e(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            r68.c(builder);
            r68.c(builder2);
            z(z, builder, builder2, i);
            List<ThreadInfo> A = A(builder, i, this.b);
            r68.o(builder);
            List<AdvertAppInfo> g = uy9.m().g();
            int i3 = 0;
            if (i != 0 && z && g != null) {
                i2 = g.size();
            } else {
                i2 = 0;
            }
            List<qq6> d = r68.d(builder);
            D(d);
            List<yn> m = m(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2, i2);
            List<yn> m2 = m(A, new ArrayList(), builder2.user_follow_live, i, 1, null, i2);
            this.d.a(m);
            o68.c(builder, m);
            p68 p68Var = this.a;
            p68Var.a = m;
            if (m2 != null) {
                i3 = m2.size();
            }
            p68Var.c = i3;
            return this.a;
        }
        return (p68) invokeCommon.objValue;
    }

    public List<ThreadInfo> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int i(int i, @NonNull List<yn> list, @NonNull String str) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048589, this, i, list, str)) == null) {
            return b78.a(i, list, str);
        }
        return invokeILL.intValue;
    }

    public final int j(@NonNull String str, @NonNull List<yn> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, list)) == null) {
            for (int i = 0; i < list.size(); i++) {
                yn ynVar = list.get(i);
                if (ynVar instanceof cq6) {
                    cq6 cq6Var = (cq6) ynVar;
                    if (cq6Var.getThreadData() != null && !TextUtils.isEmpty(cq6Var.getThreadData().getTid()) && str.equals(cq6Var.getThreadData().getTid())) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }

    public void l(List<yn> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, list, userFollowLive) == null) && b() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            h68 h68Var = new h68();
            h68Var.d(userFollowLive);
            list.add(0, h68Var);
            this.a.a.add(0, h68Var);
            h68Var.position = -1;
        }
    }

    public final void k(qq6 qq6Var, List<yn> list, int i, int i2, int i3) {
        z76 z76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{qq6Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = v76.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof z76) {
                z76Var = (z76) g;
            } else {
                z76Var = null;
            }
            if (qq6Var instanceof c68) {
                str = ((c68) qq6Var).a.a;
            }
            if (z76Var != null && !ListUtils.isEmpty(z76Var.d()) && z76Var.d().contains(str)) {
                v76.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && v76.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                v76.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && z76Var != null && z76Var.d() != null) {
                    z76Var.d().add(str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<yn> m(List<ThreadInfo> list, List<qq6> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        h68 b2;
        List<RecommendBarCardModel> c2;
        int i5;
        j68 j68Var;
        boolean z;
        cq6 e;
        kq6 h;
        ThreadRecommendInfoData threadRecommendInfoData;
        kq6 h2;
        l18 g;
        kq6 h3;
        kq6 h4;
        kq6 h5;
        int e2;
        RecommendBarCardModel recommendBarCardModel;
        int i6;
        j18 j18Var;
        int d;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3)})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && pu4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<yn> arrayList = new ArrayList<>(ListUtils.getCount(list));
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
            pra praVar = new pra();
            if (builder != null && (headerCard = builder.header_card) != null) {
                praVar.f(headerCard);
            }
            if (i2 == 0 && sra.i(praVar, false)) {
                sra sraVar = new sra();
                sraVar.g(1);
                sraVar.d(praVar);
                if (ListUtils.add(arrayList, sraVar.getPosition(), sraVar)) {
                    int position = sraVar.getPosition();
                    sraVar.position = position;
                    i4 = position;
                    if (i2 == 0 && j18.k(builder)) {
                        j18Var = new j18();
                        j18Var.i(builder.hot_card);
                        d = j18Var.d() - 1;
                        if (d >= 0 && ListUtils.add(arrayList, d, j18Var)) {
                            j18Var.position = d;
                        }
                    }
                    if (builder != null && RecommendBarCardModel.t(builder.hot_recomforum, -1)) {
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
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && C(builder)) {
                        int f = fd5.f();
                        e2 = fd5.e();
                        if (i == 0) {
                            e2 = fd5.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e2 > i4) {
                            e2++;
                        }
                        o(e2, f, arrayList);
                    }
                    List<yn> linkedList = new LinkedList<>();
                    int i7 = 0;
                    for (yn ynVar : arrayList) {
                        boolean z2 = ynVar instanceof ThreadData;
                        if (z2 && ((ThreadData) ynVar).isFunAdPlaceHolder()) {
                            if (C(builder)) {
                                linkedList.add(ynVar);
                                i7++;
                            }
                            c = 0;
                        } else if (z2) {
                            ThreadData threadData2 = (ThreadData) ynVar;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                l35 l35Var = new l35();
                                l35Var.e(threadData2.getLegoCard());
                                l35Var.position = i7;
                                linkedList.add(l35Var);
                            } else if (t98.J(threadData2)) {
                                if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    t98 t98Var = new t98();
                                    t98Var.L(threadData2.getTopicModule());
                                    t98Var.Z = 1;
                                    t98Var.position = i7;
                                    t98Var.M(threadData2);
                                    t98Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(t98Var);
                                }
                            } else if (!kq6.X(threadData2) && !lq6.N(threadData2) && !mq6.X(threadData2)) {
                                if (fq6.X(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    fq6 fq6Var = new fq6(threadData2);
                                    fq6Var.position = i7;
                                    linkedList.add(fq6Var);
                                } else {
                                    cq6 e3 = r68.e(threadData2);
                                    if (e3 != null) {
                                        e3.g = threadData2.getTid();
                                        e3.position = i7;
                                    }
                                    if (e3 != null && e3.isValid()) {
                                        linkedList.add(e3);
                                    }
                                }
                            } else {
                                kq6 h6 = r68.h(threadData2);
                                if (h6 != null) {
                                    if (threadData2.showCardEnterFourm()) {
                                        if (h6.isValid()) {
                                            h6.g = threadData2.getTid();
                                            h6.position = i7;
                                            r68.u(h6);
                                            linkedList.add(h6);
                                        }
                                    } else {
                                        ThreadData threadData3 = h6.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            h6.g = threadData2.getTid();
                                            h6.position = i7;
                                            r68.s(h6);
                                            linkedList.add(h6);
                                            z = true;
                                            e = r68.e(threadData2);
                                            if (e != null) {
                                                e.g = threadData2.getTid();
                                                e.position = i7;
                                                if (e instanceof kq6) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        r68.v(e);
                                                    } else if (threadData2.picCount() == 1) {
                                                        r68.x(e);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        e.j = imageWidthAndHeight[c];
                                                        e.k = imageWidthAndHeight[1];
                                                    } else if (threadData2.picCount() >= 2) {
                                                        r68.w(e);
                                                    } else {
                                                        r68.y(e);
                                                    }
                                                } else if (e instanceof lq6) {
                                                    r68.z(e);
                                                }
                                            }
                                            if (e instanceof mq6) {
                                                r68.A(e);
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
                                            if (threadData2.getItem() != null && (h5 = r68.h(threadData2)) != null) {
                                                h5.g = threadData2.getTid();
                                                h5.position = i7;
                                                r68.B(h5);
                                                if (!kq6.X(threadData2)) {
                                                    h5.E("1");
                                                } else if (lq6.N(threadData2)) {
                                                    h5.E("2");
                                                }
                                                linkedList.add(h5);
                                            }
                                            if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (h = r68.h(threadData2)) != null) {
                                                h.g = threadData2.getTid();
                                                h.position = i7;
                                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                                    r68.E(h);
                                                } else {
                                                    r68.C(h);
                                                }
                                                linkedList.add(h);
                                            }
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (h4 = r68.h(threadData2)) != null) {
                                                h4.g = threadData2.getTid();
                                                h4.position = i7;
                                                r68.D(h4);
                                                if (h4.isValid()) {
                                                    linkedList.add(h4);
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm() && (h3 = r68.h(threadData2)) != null) {
                                                h3.g = threadData2.getTid();
                                                h3.position = i7;
                                                r68.r(h3);
                                                if (!kq6.X(threadData2)) {
                                                    h3.E("1");
                                                } else if (lq6.N(threadData2)) {
                                                    h3.E("2");
                                                }
                                                if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(h3);
                                                } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(h3);
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                                kq6 h7 = r68.h(threadData2);
                                                if (h7 != null) {
                                                    h7.g = threadData2.getTid();
                                                    h7.position = i7;
                                                    r68.t(h7);
                                                }
                                                if (h7 != null && h7.isValid()) {
                                                    linkedList.add(h7);
                                                }
                                            }
                                            h2 = r68.h(threadData2);
                                            if (h2 != null) {
                                                h2.g = threadData2.getTid();
                                                h2.position = i7;
                                                r68.q(h2);
                                            }
                                            if (h2 != null && h2.isValid()) {
                                                linkedList.add(h2);
                                            }
                                            g = r68.g(threadData2);
                                            if (g != null && l18.d0(g) && u(this.a.a, g) && !u(linkedList, g)) {
                                                g.g = threadData2.getTid();
                                                linkedList.add(g);
                                            }
                                        } else if (h6.isValid()) {
                                            h6.g = threadData2.getTid();
                                            h6.position = i7;
                                            r68.u(h6);
                                            linkedList.add(h6);
                                        }
                                    }
                                }
                                z = false;
                                e = r68.e(threadData2);
                                if (e != null) {
                                }
                                if (e instanceof mq6) {
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
                                    h5.g = threadData2.getTid();
                                    h5.position = i7;
                                    r68.B(h5);
                                    if (!kq6.X(threadData2)) {
                                    }
                                    linkedList.add(h5);
                                }
                                if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                }
                                h.g = threadData2.getTid();
                                h.position = i7;
                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                }
                                linkedList.add(h);
                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                if (threadRecommendInfoData != null) {
                                    h4.g = threadData2.getTid();
                                    h4.position = i7;
                                    r68.D(h4);
                                    if (h4.isValid()) {
                                    }
                                }
                                if (threadData2.showCardEnterFourm()) {
                                    h3.g = threadData2.getTid();
                                    h3.position = i7;
                                    r68.r(h3);
                                    if (!kq6.X(threadData2)) {
                                    }
                                    if (!threadData2.showCardEnterFourm()) {
                                    }
                                    if (!StringUtils.isNull(threadData2.getForum_name())) {
                                    }
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                h2 = r68.h(threadData2);
                                if (h2 != null) {
                                }
                                if (h2 != null) {
                                    linkedList.add(h2);
                                }
                                g = r68.g(threadData2);
                                if (g != null) {
                                    g.g = threadData2.getTid();
                                    linkedList.add(g);
                                }
                            }
                            long g2 = wg.g(threadData2.getId(), 0L);
                            if (g2 != 0 && g2 == this.j.longValue()) {
                                if (builder.active_center != null) {
                                    j68Var = new j68();
                                    j68Var.J(builder.active_center);
                                } else {
                                    j68Var = null;
                                }
                                if (j68Var == null) {
                                    j68Var = d();
                                }
                                if (j68Var != null) {
                                    i7++;
                                    j68Var.R = i7;
                                    linkedList.add(j68Var);
                                }
                            }
                            i7++;
                            c = 0;
                        } else {
                            if (ynVar instanceof BaseCardInfo) {
                                linkedList.add(ynVar);
                            } else {
                                linkedList.add(ynVar);
                            }
                            i7++;
                            c = 0;
                        }
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i8 = 0;
                        int i9 = 0;
                        for (int i10 = 0; i10 < ListUtils.getCount(list2); i10++) {
                            qq6 qq6Var = (qq6) ListUtils.getItem(list2, i10);
                            if (qq6Var != null && i8 < linkedList.size()) {
                                int i11 = i8;
                                while (i11 < linkedList.size() && (!(linkedList.get(i11) instanceof cq6) || g(((cq6) linkedList.get(i11)).position, i4) + i9 != qq6Var.getPosition() - 1)) {
                                    i11++;
                                }
                                if (linkedList.size() > i11 && i11 > 0) {
                                    linkedList.add(i11, qq6Var);
                                    int i12 = i9 + 1;
                                    k(qq6Var, linkedList, i11, i12, i3);
                                    i8 = i11;
                                    i9 = i12;
                                } else {
                                    i8 = i11;
                                }
                            }
                        }
                        int i13 = 0;
                        int i14 = 0;
                        for (yn ynVar2 : linkedList) {
                            if (ynVar2 instanceof k35) {
                                ((k35) ynVar2).setPosition(i14 + 1);
                                i13++;
                            } else if (ynVar2 instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) ynVar2;
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
                            h68 h68Var = new h68();
                            h68Var.d(userFollowLive);
                            linkedList.add(0, h68Var);
                            h68Var.position = -1;
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
                j18Var = new j18();
                j18Var.i(builder.hot_card);
                d = j18Var.d() - 1;
                if (d >= 0) {
                    j18Var.position = d;
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
                int f3 = fd5.f();
                e2 = fd5.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e2++;
                }
                o(e2, f3, arrayList);
            }
            List<yn> linkedList2 = new LinkedList<>();
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

    public void n(t15 t15Var, int i, List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048594, this, t15Var, i, list) != null) || t15Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    t15Var.floorPosition = i;
                    ListUtils.add(list, i3, t15Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void o(int i, int i2, List<yn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048595, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<yn> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        wca wcaVar = new wca();
                        wcaVar.n(true);
                        threadData.funAdData = wcaVar;
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
            if (i3 > 0 && v76.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                v76.i().n(list, i3, 1);
            }
        }
    }

    public void r(List<yn> list, k3a k3aVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048598, this, list, k3aVar, i) != null) || ListUtils.isEmpty(list) || k3aVar == null || i < 0) {
            return;
        }
        B(list);
        if (i == 0) {
            q(list, RecommendBarCardModel.e(k3aVar), k3aVar.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof cq6) && !(list.get(i) instanceof k35)) {
            i++;
        }
        if (list.get(i) instanceof cq6) {
            q(list, RecommendBarCardModel.e(k3aVar), ((cq6) list.get(i)).position + 2);
        } else if (list.get(i) instanceof k35) {
            q(list, RecommendBarCardModel.e(k3aVar), ((k35) list.get(i)).s() + 2);
        }
    }

    public boolean p(List<yn> list, i68 i68Var, int i, int i2) {
        InterceptResult invokeLLII;
        RecommendBarCardModel d;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048596, this, list, i68Var, i, i2)) == null) {
            if (ListUtils.isEmpty(list) || i68Var == null || TextUtils.isEmpty(i68Var.b()) || i < 0 || i >= list.size() || i2 < 0 || i2 < i || i2 >= list.size() || (d = RecommendBarCardModel.d(i68Var)) == null || (i3 = i(j(i68Var.b(), list), list, i68Var.b())) < 0 || i3 > list.size() || i3 <= i) {
                return false;
            }
            d.n(i68Var.b());
            d.p(RecommendBarCardModel.RecDataSource.FORUMBACKCONCERN);
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
    public final void q(List<yn> list, RecommendBarCardModel recommendBarCardModel, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048597, this, list, recommendBarCardModel, i) == null) && recommendBarCardModel != null && !ListUtils.isEmpty(recommendBarCardModel.h())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof cq6) || ((cq6) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof k35) || ((k35) list.get(i3)).s() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (yn ynVar : list) {
                if (ynVar instanceof RecommendBarCardModel) {
                    RecommendBarCardModel recommendBarCardModel2 = (RecommendBarCardModel) ynVar;
                    if (!recommendBarCardModel2.i()) {
                        recommendBarCardModel2.position = i4 + 1;
                        i2++;
                    }
                }
                if (ynVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) ynVar;
                    i4 = baseCardInfo.position + i2;
                    baseCardInfo.position = i4;
                }
            }
        }
    }

    public final boolean u(List<yn> list, l18 l18Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, list, l18Var)) == null) {
            if (this.a != null && !ListUtils.isEmpty(list)) {
                for (yn ynVar : list) {
                    if ((ynVar instanceof l18) && ((l18) ynVar).getTid().equals(l18Var.getTid())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void w(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            r68.l(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void x(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
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
                        JSONObject b2 = i0a.b(threadInfo2);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (v()) {
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
                        JSONObject b3 = i0a.b(threadInfo3);
                        if (b3 != null) {
                            arrayList.add(0, b3);
                        }
                    }
                }
            }
            if (v()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            yx9.c(builder4, count3);
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
            i0a.f().h("HOME", arrayList);
        }
    }

    public final void y(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048605, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void z(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
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
            x(z, builder, builder2, i);
            w(z, builder, builder2, i);
            y(builder.thread_personalized, builder2.thread_personalized);
        }
    }
}
