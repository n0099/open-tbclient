package com.baidu.tieba;

import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
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
import org.json.JSONObject;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.ThreadPersonalized;
import tbclient.Personalized.UserFollowLive;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class x47 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final z47 a;
    public final int b;
    public int c;
    public f57 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<xn> k;

    /* loaded from: classes6.dex */
    public class a implements Comparator<g56> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(x47 x47Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x47Var};
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
        public int compare(g56 g56Var, g56 g56Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, g56Var, g56Var2)) == null) {
                if (g56Var != null && g56Var2 != null) {
                    if (g56Var.getPosition() > g56Var2.getPosition()) {
                        return 1;
                    }
                    if (g56Var.getPosition() < g56Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends xm5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s46 h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(x47 x47Var, int i, String str, s46 s46Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {x47Var, Integer.valueOf(i), str, s46Var};
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
            this.h = s46Var;
        }

        @Override // com.baidu.tieba.xm5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                s46 s46Var = this.h;
                if (s46Var instanceof a56) {
                    statisticItem = ((a56) s46Var).S();
                } else if (s46Var instanceof b56) {
                    statisticItem = ((b56) s46Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public x47() {
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
        this.d = new f57();
        this.e = 0;
        this.j = 0L;
        this.a = new z47();
        this.b = py4.k().l("home_page_max_thread_count", 300);
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final s47 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            z47 z47Var = this.a;
            if (z47Var != null && !ListUtils.isEmpty(z47Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof s47) {
                        return (s47) xnVar;
                    }
                }
            }
            return null;
        }
        return (s47) invokeV.objValue;
    }

    public final t47 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            z47 z47Var = this.a;
            if (z47Var != null && !ListUtils.isEmpty(z47Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof t47) {
                        return (t47) xnVar;
                    }
                }
            }
            return null;
        }
        return (t47) invokeV.objValue;
    }

    public z47 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)})) == null) {
            if (i != 0 && i != 1) {
                return null;
            }
            if (builder == null) {
                builder = new DataRes.Builder();
            }
            if (builder2 == null) {
                builder2 = new DataRes.Builder();
            }
            a57.c(builder);
            a57.c(builder2);
            r(z, builder, builder2, i);
            List<ThreadInfo> s = s(builder, i, this.b);
            a57.n(builder);
            List<AdvertAppInfo> f = gg8.l().f();
            int i3 = 0;
            if (i != 0 && z && f != null) {
                i2 = f.size();
            } else {
                i2 = 0;
            }
            List<g56> d = a57.d(builder);
            v(d);
            List<xn> h = h(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2, i2);
            List<xn> h2 = h(s, new ArrayList(), builder2.user_follow_live, i, 1, null, i2);
            this.d.a(h);
            y47.c(builder, h);
            z47 z47Var = this.a;
            z47Var.a = h;
            if (h2 != null) {
                i3 = h2.size();
            }
            z47Var.c = i3;
            return this.a;
        }
        return (z47) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void f(g56 g56Var, List<xn> list, int i, int i2, int i3) {
        pr5 pr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{g56Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = lr5.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof pr5) {
                pr5Var = (pr5) g;
            } else {
                pr5Var = null;
            }
            if (g56Var instanceof n47) {
                str = ((n47) g56Var).a.a;
            }
            if (pr5Var != null && !ListUtils.isEmpty(pr5Var.d()) && pr5Var.d().contains(str)) {
                lr5.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && lr5.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                lr5.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && pr5Var != null && pr5Var.d() != null) {
                    pr5Var.d().add(str);
                }
            }
        }
    }

    public void g(List<xn> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, list, userFollowLive) == null) && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow() && a() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            s47 s47Var = new s47();
            s47Var.f(userFollowLive);
            list.add(0, s47Var);
            this.a.a.add(0, s47Var);
            s47Var.position = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<xn> h(List<ThreadInfo> list, List<g56> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3) {
        InterceptResult invokeCommon;
        s47 a2;
        t47 t47Var;
        boolean z;
        s46 e;
        a56 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        a56 g2;
        a56 g3;
        a56 g4;
        a56 g5;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3)})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && zm4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<xn> arrayList = new ArrayList<>(ListUtils.getCount(list));
            for (ThreadInfo threadInfo2 : list) {
                ThreadData threadData = new ThreadData();
                AbsGroupUbsABTest.setCardInfoUbsABTest(threadData);
                threadData.isFromHomPage = true;
                threadData.parserProtobuf(threadInfo2);
                arrayList.add(threadData);
            }
            if (builder != null && a07.n(builder.hot_recomforum, -1)) {
                a07 a07Var = new a07();
                if (builder.hot_recomforum.floor.intValue() > 0) {
                    i4 = builder.hot_recomforum.floor.intValue() - 1;
                } else {
                    i4 = 0;
                }
                a07Var.floorPosition = i4;
                if (a07Var.j(builder.hot_recomforum.tab_list)) {
                    i(a07Var, a07Var.floorPosition, arrayList);
                }
            }
            if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && u(builder)) {
                int f = m15.f();
                int e2 = m15.e();
                if (i == 0) {
                    e2 = m15.a();
                    this.k.clear();
                }
                j(e2, f, arrayList);
            }
            List<xn> linkedList = new LinkedList<>();
            int i5 = 0;
            for (xn xnVar : arrayList) {
                boolean z2 = xnVar instanceof ThreadData;
                if (z2 && ((ThreadData) xnVar).isFunAdPlaceHolder()) {
                    if (u(builder)) {
                        linkedList.add(xnVar);
                        i5++;
                    }
                } else if (z2) {
                    ThreadData threadData2 = (ThreadData) xnVar;
                    if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                        it4 it4Var = new it4();
                        it4Var.h(threadData2.getLegoCard());
                        it4Var.position = i5;
                        linkedList.add(it4Var);
                    } else if (s77.N(threadData2)) {
                        if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                            s77 s77Var = new s77();
                            s77Var.P(threadData2.getTopicModule());
                            s77Var.Z = 1;
                            s77Var.position = i5;
                            s77Var.Q(threadData2);
                            s77Var.setSupportType(BaseCardInfo.SupportType.FULL);
                            linkedList.add(s77Var);
                        }
                    } else if (!a56.W(threadData2) && !b56.R(threadData2) && !c56.W(threadData2)) {
                        if (v46.W(threadData2) && threadData2.isBJHArticleThreadType()) {
                            v46 v46Var = new v46(threadData2);
                            v46Var.position = i5;
                            linkedList.add(v46Var);
                        } else {
                            s46 e3 = a57.e(threadData2);
                            if (e3 != null) {
                                e3.g = threadData2.getTid();
                                e3.position = i5;
                            }
                            if (e3 != null && e3.isValid()) {
                                linkedList.add(e3);
                            }
                        }
                    } else {
                        a56 g6 = a57.g(threadData2);
                        if (g6 != null) {
                            if (threadData2.showCardEnterFourm()) {
                                if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i5;
                                    a57.t(g6);
                                    linkedList.add(g6);
                                }
                            } else {
                                ThreadData threadData3 = g6.a;
                                if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i5;
                                    a57.r(g6);
                                    linkedList.add(g6);
                                    z = true;
                                    e = a57.e(threadData2);
                                    if (e != null) {
                                        e.g = threadData2.getTid();
                                        e.position = i5;
                                        if (e instanceof a56) {
                                            if (threadData2.isBJHNormalThreadType()) {
                                                a57.u(e);
                                            } else if (threadData2.picCount() == 1) {
                                                a57.w(e);
                                                int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                e.j = imageWidthAndHeight[0];
                                                e.k = imageWidthAndHeight[1];
                                            } else if (threadData2.picCount() >= 2) {
                                                a57.v(e);
                                            } else {
                                                a57.x(e);
                                            }
                                        } else if (e instanceof b56) {
                                            a57.y(e);
                                        }
                                    }
                                    if (e instanceof c56) {
                                        a57.z(e);
                                    }
                                    if (e != null && e.isValid()) {
                                        e.a.insertItemToTitleOrAbstractText();
                                        if (!threadData2.isUgcThreadType() && threadData2.getAuthor() != null && z) {
                                            String format = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ad), threadData2.getAuthor().getName_show());
                                            SpannableString spannableString = new SpannableString(format);
                                            spannableString.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format.length() - 1, 33);
                                            e.a.insertUsernameIntoTitleOrAbstract(spannableString);
                                        }
                                        linkedList.add(e);
                                    }
                                    if (threadData2.getItem() != null && (g5 = a57.g(threadData2)) != null) {
                                        g5.g = threadData2.getTid();
                                        g5.position = i5;
                                        a57.A(g5);
                                        if (!a56.W(threadData2)) {
                                            g5.L("1");
                                        } else if (b56.R(threadData2)) {
                                            g5.L("2");
                                        }
                                        linkedList.add(g5);
                                    }
                                    if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = a57.g(threadData2)) != null) {
                                        g.g = threadData2.getTid();
                                        g.position = i5;
                                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                            a57.D(g);
                                        } else {
                                            a57.B(g);
                                        }
                                        linkedList.add(g);
                                    }
                                    threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                    if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = a57.g(threadData2)) != null) {
                                        g4.g = threadData2.getTid();
                                        g4.position = i5;
                                        a57.C(g4);
                                        if (g4.isValid()) {
                                            linkedList.add(g4);
                                        }
                                    }
                                    if (threadData2.showCardEnterFourm() && (g3 = a57.g(threadData2)) != null) {
                                        g3.g = threadData2.getTid();
                                        g3.position = i5;
                                        a57.q(g3);
                                        if (!a56.W(threadData2)) {
                                            g3.L("1");
                                        } else if (b56.R(threadData2)) {
                                            g3.L("2");
                                        }
                                        if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                            linkedList.add(g3);
                                        }
                                    }
                                    if (threadData2.getTopAgreePost() != null) {
                                        a56 g7 = a57.g(threadData2);
                                        if (g7 != null) {
                                            g7.g = threadData2.getTid();
                                            g7.position = i5;
                                            a57.s(g7);
                                        }
                                        if (g7 != null && g7.isValid()) {
                                            linkedList.add(g7);
                                        }
                                    }
                                    g2 = a57.g(threadData2);
                                    if (g2 != null) {
                                        g2.g = threadData2.getTid();
                                        g2.position = i5;
                                        a57.p(g2);
                                    }
                                    if (g2 != null && g2.isValid()) {
                                        linkedList.add(g2);
                                    }
                                } else if (g6.isValid()) {
                                    g6.g = threadData2.getTid();
                                    g6.position = i5;
                                    a57.t(g6);
                                    linkedList.add(g6);
                                }
                            }
                        }
                        z = false;
                        e = a57.e(threadData2);
                        if (e != null) {
                        }
                        if (e instanceof c56) {
                        }
                        if (e != null) {
                            e.a.insertItemToTitleOrAbstractText();
                            if (!threadData2.isUgcThreadType()) {
                                String format2 = String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ad), threadData2.getAuthor().getName_show());
                                SpannableString spannableString2 = new SpannableString(format2);
                                spannableString2.setSpan(new b(this, 16, threadData2.getAuthor().getUserId(), e), 0, format2.length() - 1, 33);
                                e.a.insertUsernameIntoTitleOrAbstract(spannableString2);
                            }
                            linkedList.add(e);
                        }
                        if (threadData2.getItem() != null) {
                            g5.g = threadData2.getTid();
                            g5.position = i5;
                            a57.A(g5);
                            if (!a56.W(threadData2)) {
                            }
                            linkedList.add(g5);
                        }
                        if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                        }
                        g.g = threadData2.getTid();
                        g.position = i5;
                        if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                        }
                        linkedList.add(g);
                        threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                        if (threadRecommendInfoData != null) {
                            g4.g = threadData2.getTid();
                            g4.position = i5;
                            a57.C(g4);
                            if (g4.isValid()) {
                            }
                        }
                        if (threadData2.showCardEnterFourm()) {
                            g3.g = threadData2.getTid();
                            g3.position = i5;
                            a57.q(g3);
                            if (!a56.W(threadData2)) {
                            }
                            if (!threadData2.showCardEnterFourm()) {
                            }
                            if (!StringUtils.isNull(threadData2.getForum_name())) {
                            }
                        }
                        if (threadData2.getTopAgreePost() != null) {
                        }
                        g2 = a57.g(threadData2);
                        if (g2 != null) {
                        }
                        if (g2 != null) {
                            linkedList.add(g2);
                        }
                    }
                    long g8 = xg.g(threadData2.getId(), 0L);
                    if (g8 != 0 && g8 == this.j.longValue()) {
                        if (builder.active_center != null) {
                            t47Var = new t47();
                            t47Var.N(builder.active_center);
                        } else {
                            t47Var = null;
                        }
                        if (t47Var == null) {
                            t47Var = b();
                        }
                        if (t47Var != null) {
                            i5++;
                            t47Var.R = i5;
                            linkedList.add(t47Var);
                        }
                    }
                    i5++;
                } else {
                    if (xnVar instanceof BaseCardInfo) {
                        linkedList.add(xnVar);
                    } else {
                        linkedList.add(xnVar);
                    }
                    i5++;
                }
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < ListUtils.getCount(list2); i8++) {
                    g56 g56Var = (g56) ListUtils.getItem(list2, i8);
                    if (g56Var != null && i6 < linkedList.size()) {
                        int i9 = i6;
                        while (i9 < linkedList.size() && (!(linkedList.get(i9) instanceof s46) || ((s46) linkedList.get(i9)).position + i7 != g56Var.getPosition() - 1)) {
                            i9++;
                        }
                        if (linkedList.size() > i9 && i9 > 0) {
                            linkedList.add(i9, g56Var);
                            int i10 = i7 + 1;
                            f(g56Var, linkedList, i9, i10, i3);
                            i6 = i9;
                            i7 = i10;
                        } else {
                            i6 = i9;
                        }
                    }
                }
                int i11 = 0;
                int i12 = 0;
                for (xn xnVar2 : linkedList) {
                    if (xnVar2 instanceof gt4) {
                        ((gt4) xnVar2).setPosition(i11 + 1);
                        i12++;
                    } else if (xnVar2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo = (BaseCardInfo) xnVar2;
                        i11 = baseCardInfo.position + i12;
                        baseCardInfo.position = i11;
                    }
                }
            }
            if (i2 == 0 && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow()) {
                if (i == 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                    s47 s47Var = new s47();
                    s47Var.f(userFollowLive);
                    linkedList.add(0, s47Var);
                    s47Var.position = -1;
                } else if (i == 1 && (a2 = a()) != null) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void i(sr4 sr4Var, int i, List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sr4Var, i, list) != null) || sr4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    sr4Var.floorPosition = i;
                    ListUtils.add(list, i3, sr4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void j(int i, int i2, List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
            ListIterator<xn> listIterator = list.listIterator();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (listIterator.hasNext()) {
                if (i4 == i || (i4 > i && (i4 - i) % i2 == 0)) {
                    if (i5 < this.k.size()) {
                        listIterator.add(this.k.get(i5));
                    } else {
                        ThreadData threadData = new ThreadData();
                        jp8 jp8Var = new jp8();
                        jp8Var.n(true);
                        threadData.funAdData = jp8Var;
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
            if (i3 > 0 && lr5.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                lr5.i().n(list, i3, 1);
            }
        }
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
    public final void k(List<xn> list, a07 a07Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048586, this, list, a07Var, i) == null) && a07Var != null && !ListUtils.isEmpty(a07Var.f())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof s46) || ((s46) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof gt4) || ((gt4) list.get(i3)).i() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (xn xnVar : list) {
                if (xnVar instanceof a07) {
                    ((a07) xnVar).position = i2 + 1;
                    i4++;
                } else if (xnVar instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo = (BaseCardInfo) xnVar;
                    int i5 = baseCardInfo.position + i4;
                    baseCardInfo.position = i5;
                    i2 = i5;
                }
            }
        }
    }

    public void l(List<xn> list, qi8 qi8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048587, this, list, qi8Var, i) != null) || ListUtils.isEmpty(list) || qi8Var == null || i < 0) {
            return;
        }
        t(list);
        if (i == 0) {
            k(list, a07.c(qi8Var), qi8Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof s46) && !(list.get(i) instanceof gt4)) {
            i++;
        }
        if (list.get(i) instanceof s46) {
            k(list, a07.c(qi8Var), ((s46) list.get(i)).position + 2);
        } else if (list.get(i) instanceof gt4) {
            k(list, a07.c(qi8Var), ((gt4) list.get(i)).i() + 2);
        }
    }

    public final void o(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            a57.k(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void p(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
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
                        JSONObject b2 = sh8.b(threadInfo2);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (n()) {
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
                        JSONObject b3 = sh8.b(threadInfo3);
                        if (b3 != null) {
                            arrayList.add(0, b3);
                        }
                    }
                }
            }
            if (n()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            lf8.c(builder4, count3);
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
            sh8.f().h("HOME", arrayList);
        }
    }

    public final void q(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void r(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
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
            p(z, builder, builder2, i);
            o(z, builder, builder2, i);
            q(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final List<ThreadInfo> s(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048594, this, builder, i, i2)) == null) {
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

    public final void t(List<xn> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            Iterator<xn> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if (next instanceof a07) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final boolean u(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, builder)) == null) {
            if (builder != null && (num = builder.show_adsense) != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void v(List<g56> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}
