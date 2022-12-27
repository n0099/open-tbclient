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
public class w57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final y57 a;
    public final int b;
    public int c;
    public e67 d;
    public int e;
    public int f;
    public int g;
    public ArrayList<ThreadInfo> h;
    public ArrayList<App> i;
    public Long j;
    public List<xn> k;

    public final int e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048580, this, i, i2)) == null) ? (i2 < 0 || i <= i2) ? i : i - 1 : invokeII.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements Comparator<c66> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(w57 w57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w57Var};
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
        public int compare(c66 c66Var, c66 c66Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c66Var, c66Var2)) == null) {
                if (c66Var != null && c66Var2 != null) {
                    if (c66Var.getPosition() > c66Var2.getPosition()) {
                        return 1;
                    }
                    if (c66Var.getPosition() < c66Var2.getPosition()) {
                        return -1;
                    }
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends tn5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ o56 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(w57 w57Var, int i, String str, o56 o56Var) {
            super(i, str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w57Var, Integer.valueOf(i), str, o56Var};
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
            this.i = o56Var;
        }

        @Override // com.baidu.tieba.tn5, android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = null;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(view2.getContext(), d(), null)));
                o56 o56Var = this.i;
                if (o56Var instanceof w56) {
                    statisticItem = ((w56) o56Var).S();
                } else if (o56Var instanceof x56) {
                    statisticItem = ((x56) o56Var).Q(null);
                }
                TiebaStatic.log(statisticItem);
            }
        }
    }

    public w57() {
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
        this.d = new e67();
        this.e = 0;
        this.j = 0L;
        this.a = new y57();
        this.b = ry4.l().m("home_page_max_thread_count", 300);
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.k = new ArrayList();
    }

    public final r57 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            y57 y57Var = this.a;
            if (y57Var != null && !ListUtils.isEmpty(y57Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof r57) {
                        return (r57) xnVar;
                    }
                }
            }
            return null;
        }
        return (r57) invokeV.objValue;
    }

    public final s57 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            y57 y57Var = this.a;
            if (y57Var != null && !ListUtils.isEmpty(y57Var.a)) {
                for (xn xnVar : this.a.a) {
                    if (xnVar instanceof s57) {
                        return (s57) xnVar;
                    }
                }
            }
            return null;
        }
        return (s57) invokeV.objValue;
    }

    public y57 c(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
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
            z57.c(builder);
            z57.c(builder2);
            s(z, builder, builder2, i);
            List<ThreadInfo> t = t(builder, i, this.b);
            z57.n(builder);
            List<AdvertAppInfo> f = aj8.l().f();
            int i3 = 0;
            if (i != 0 && z && f != null) {
                i2 = f.size();
            } else {
                i2 = 0;
            }
            List<c66> d = z57.d(builder);
            w(d);
            List<xn> i4 = i(builder.thread_list, d, builder2.user_follow_live, i, 0, builder2, i2);
            List<xn> i5 = i(t, new ArrayList(), builder2.user_follow_live, i, 1, null, i2);
            this.d.a(i4);
            x57.c(builder, i4);
            y57 y57Var = this.a;
            y57Var.a = i4;
            if (i5 != null) {
                i3 = i5.size();
            }
            y57Var.c = i3;
            return this.a;
        }
        return (y57) invokeCommon.objValue;
    }

    public List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ArrayList<ThreadInfo> arrayList = this.h;
            if (arrayList != null && !ListUtils.isEmpty(arrayList)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.e > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g(c66 c66Var, List<xn> list, int i, int i2, int i3) {
        ls5 ls5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{c66Var, list, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            AbsDataRecorder g = hs5.i().g(AbsDataRecorder.Scene.RECOMMEND);
            String str = null;
            if (g instanceof ls5) {
                ls5Var = (ls5) g;
            } else {
                ls5Var = null;
            }
            if (c66Var instanceof m57) {
                str = ((m57) c66Var).a.a;
            }
            if (ls5Var != null && !ListUtils.isEmpty(ls5Var.d()) && ls5Var.d().contains(str)) {
                hs5.i().n(list, i + 1, 1);
            } else if (i2 == i3 + 1 && hs5.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                hs5.i().n(list, i + 1, 1);
                if (!StringUtils.isNull(str) && ls5Var != null && ls5Var.d() != null) {
                    ls5Var.d().add(str);
                }
            }
        }
    }

    public void h(List<xn> list, UserFollowLive userFollowLive) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, list, userFollowLive) == null) && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow() && a() == null && list != null && this.a.a != null && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
            r57 r57Var = new r57();
            r57Var.f(userFollowLive);
            list.add(0, r57Var);
            this.a.a.add(0, r57Var);
            r57Var.position = -1;
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
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<xn> i(List<ThreadInfo> list, List<c66> list2, UserFollowLive userFollowLive, int i, int i2, DataRes.Builder builder, int i3) {
        InterceptResult invokeCommon;
        char c;
        int i4;
        List<xn> linkedList;
        r57 a2;
        s57 s57Var;
        boolean z;
        o56 e;
        w56 g;
        ThreadRecommendInfoData threadRecommendInfoData;
        w56 g2;
        w56 g3;
        w56 g4;
        w56 g5;
        int e2;
        z07 z07Var;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{list, list2, userFollowLive, Integer.valueOf(i), Integer.valueOf(i2), builder, Integer.valueOf(i3)})) == null) {
            if (list == null) {
                return null;
            }
            if (builder != null && !ListUtils.isEmpty(builder.thread_list) && builder.active_center != null) {
                ThreadInfo threadInfo = builder.thread_list.get(builder.thread_list.size() - 1);
                if (threadInfo.id.longValue() > 0 && ym4.f().l()) {
                    this.j = threadInfo.id;
                }
            }
            List<xn> arrayList = new ArrayList<>(ListUtils.getCount(list));
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
            if (i2 == 0 && a17.i(builder)) {
                a17 a17Var = new a17();
                a17Var.f(builder.header_card);
                if (ListUtils.add(arrayList, a17Var.getPosition(), a17Var)) {
                    i4 = a17Var.getPosition();
                    a17Var.position = i4;
                    if (builder != null && z07.m(builder.hot_recomforum, -1)) {
                        z07Var = new z07();
                        if (builder.hot_recomforum.floor.intValue() <= 0) {
                            i5 = builder.hot_recomforum.floor.intValue() - 1;
                        } else {
                            i5 = 0;
                        }
                        z07Var.floorPosition = i5;
                        if (z07Var.i(builder.hot_recomforum.tab_list)) {
                            j(z07Var, z07Var.floorPosition, arrayList);
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isPersonalizeFunAdABTest() && v(builder)) {
                        int f = n15.f();
                        e2 = n15.e();
                        if (i == 0) {
                            e2 = n15.a();
                            this.k.clear();
                        }
                        if (i4 >= 0 && e2 > i4) {
                            e2++;
                        }
                        k(e2, f, arrayList);
                    }
                    linkedList = new LinkedList<>();
                    int i6 = 0;
                    for (xn xnVar : arrayList) {
                        boolean z2 = xnVar instanceof ThreadData;
                        if (z2 && ((ThreadData) xnVar).isFunAdPlaceHolder()) {
                            if (v(builder)) {
                                linkedList.add(xnVar);
                                i6++;
                            }
                            c = 0;
                        } else if (z2) {
                            ThreadData threadData2 = (ThreadData) xnVar;
                            if (!TextUtils.isEmpty(threadData2.getLegoCard())) {
                                kt4 kt4Var = new kt4();
                                kt4Var.g(threadData2.getLegoCard());
                                kt4Var.position = i6;
                                linkedList.add(kt4Var);
                            } else if (r87.N(threadData2)) {
                                if (!StringUtils.isNull(threadData2.getTopicModule().topic_name)) {
                                    r87 r87Var = new r87();
                                    r87Var.P(threadData2.getTopicModule());
                                    r87Var.Z = 1;
                                    r87Var.position = i6;
                                    r87Var.Q(threadData2);
                                    r87Var.setSupportType(BaseCardInfo.SupportType.FULL);
                                    linkedList.add(r87Var);
                                }
                            } else if (!w56.W(threadData2) && !x56.R(threadData2) && !y56.W(threadData2)) {
                                if (r56.W(threadData2) && threadData2.isBJHArticleThreadType()) {
                                    r56 r56Var = new r56(threadData2);
                                    r56Var.position = i6;
                                    linkedList.add(r56Var);
                                } else {
                                    o56 e3 = z57.e(threadData2);
                                    if (e3 != null) {
                                        e3.g = threadData2.getTid();
                                        e3.position = i6;
                                    }
                                    if (e3 != null && e3.isValid()) {
                                        linkedList.add(e3);
                                    }
                                }
                            } else {
                                w56 g6 = z57.g(threadData2);
                                if (g6 != null) {
                                    if (threadData2.showCardEnterFourm()) {
                                        if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i6;
                                            z57.t(g6);
                                            linkedList.add(g6);
                                        }
                                    } else {
                                        ThreadData threadData3 = g6.a;
                                        if (threadData3 != null && threadData3.getForumData() != null && !StringUtils.isNull(threadData3.getForumData().b)) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i6;
                                            z57.r(g6);
                                            linkedList.add(g6);
                                            z = true;
                                            e = z57.e(threadData2);
                                            if (e != null) {
                                                e.g = threadData2.getTid();
                                                e.position = i6;
                                                if (e instanceof w56) {
                                                    if (threadData2.isBJHNormalThreadType()) {
                                                        z57.u(e);
                                                    } else if (threadData2.picCount() == 1) {
                                                        z57.w(e);
                                                        int[] imageWidthAndHeight = threadData2.getImageWidthAndHeight();
                                                        e.j = imageWidthAndHeight[c];
                                                        e.k = imageWidthAndHeight[1];
                                                    } else if (threadData2.picCount() >= 2) {
                                                        z57.v(e);
                                                    } else {
                                                        z57.x(e);
                                                    }
                                                } else if (e instanceof x56) {
                                                    z57.y(e);
                                                }
                                            }
                                            if (e instanceof y56) {
                                                z57.z(e);
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
                                            if (threadData2.getItem() != null && (g5 = z57.g(threadData2)) != null) {
                                                g5.g = threadData2.getTid();
                                                g5.position = i6;
                                                z57.A(g5);
                                                if (!w56.W(threadData2)) {
                                                    g5.L("1");
                                                } else if (x56.R(threadData2)) {
                                                    g5.L("2");
                                                }
                                                linkedList.add(g5);
                                            }
                                            if ((ListUtils.isEmpty(threadData2.getLinkDataList()) || !ListUtils.isEmpty(threadData2.getGoodsDataList())) && (g = z57.g(threadData2)) != null) {
                                                g.g = threadData2.getTid();
                                                g.position = i6;
                                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                                    z57.D(g);
                                                } else {
                                                    z57.B(g);
                                                }
                                                linkedList.add(g);
                                            }
                                            threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                            if (threadRecommendInfoData != null && !TextUtils.isEmpty(threadRecommendInfoData.recommendReason) && (g4 = z57.g(threadData2)) != null) {
                                                g4.g = threadData2.getTid();
                                                g4.position = i6;
                                                z57.C(g4);
                                                if (g4.isValid()) {
                                                    linkedList.add(g4);
                                                }
                                            }
                                            if (threadData2.showCardEnterFourm() && (g3 = z57.g(threadData2)) != null) {
                                                g3.g = threadData2.getTid();
                                                g3.position = i6;
                                                z57.q(g3);
                                                if (!w56.W(threadData2)) {
                                                    g3.L("1");
                                                } else if (x56.R(threadData2)) {
                                                    g3.L("2");
                                                }
                                                if (!threadData2.showCardEnterFourm() && !StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                } else if (!StringUtils.isNull(threadData2.getForum_name())) {
                                                    linkedList.add(g3);
                                                }
                                            }
                                            if (threadData2.getTopAgreePost() != null) {
                                                w56 g7 = z57.g(threadData2);
                                                if (g7 != null) {
                                                    g7.g = threadData2.getTid();
                                                    g7.position = i6;
                                                    z57.s(g7);
                                                }
                                                if (g7 != null && g7.isValid()) {
                                                    linkedList.add(g7);
                                                }
                                            }
                                            g2 = z57.g(threadData2);
                                            if (g2 != null) {
                                                g2.g = threadData2.getTid();
                                                g2.position = i6;
                                                z57.p(g2);
                                            }
                                            if (g2 != null && g2.isValid()) {
                                                linkedList.add(g2);
                                            }
                                        } else if (g6.isValid()) {
                                            g6.g = threadData2.getTid();
                                            g6.position = i6;
                                            z57.t(g6);
                                            linkedList.add(g6);
                                        }
                                    }
                                }
                                z = false;
                                e = z57.e(threadData2);
                                if (e != null) {
                                }
                                if (e instanceof y56) {
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
                                    g5.position = i6;
                                    z57.A(g5);
                                    if (!w56.W(threadData2)) {
                                    }
                                    linkedList.add(g5);
                                }
                                if (ListUtils.isEmpty(threadData2.getLinkDataList())) {
                                }
                                g.g = threadData2.getTid();
                                g.position = i6;
                                if (ListUtils.getCount(threadData2.getLinkDataList()) + ListUtils.getCount(threadData2.getGoodsDataList()) != 1) {
                                }
                                linkedList.add(g);
                                threadRecommendInfoData = (ThreadRecommendInfoData) ListUtils.getItem(threadData2.getThreadRecommendInfoDataList(), 0);
                                if (threadRecommendInfoData != null) {
                                    g4.g = threadData2.getTid();
                                    g4.position = i6;
                                    z57.C(g4);
                                    if (g4.isValid()) {
                                    }
                                }
                                if (threadData2.showCardEnterFourm()) {
                                    g3.g = threadData2.getTid();
                                    g3.position = i6;
                                    z57.q(g3);
                                    if (!w56.W(threadData2)) {
                                    }
                                    if (!threadData2.showCardEnterFourm()) {
                                    }
                                    if (!StringUtils.isNull(threadData2.getForum_name())) {
                                    }
                                }
                                if (threadData2.getTopAgreePost() != null) {
                                }
                                g2 = z57.g(threadData2);
                                if (g2 != null) {
                                }
                                if (g2 != null) {
                                    linkedList.add(g2);
                                }
                            }
                            long g8 = xg.g(threadData2.getId(), 0L);
                            if (g8 != 0 && g8 == this.j.longValue()) {
                                if (builder.active_center != null) {
                                    s57Var = new s57();
                                    s57Var.N(builder.active_center);
                                } else {
                                    s57Var = null;
                                }
                                if (s57Var == null) {
                                    s57Var = b();
                                }
                                if (s57Var != null) {
                                    i6++;
                                    s57Var.R = i6;
                                    linkedList.add(s57Var);
                                }
                            }
                            i6++;
                            c = 0;
                        } else {
                            if (xnVar instanceof BaseCardInfo) {
                                linkedList.add(xnVar);
                            } else {
                                linkedList.add(xnVar);
                            }
                            i6++;
                            c = 0;
                        }
                    }
                    if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
                        int i7 = 0;
                        int i8 = 0;
                        for (int i9 = 0; i9 < ListUtils.getCount(list2); i9++) {
                            c66 c66Var = (c66) ListUtils.getItem(list2, i9);
                            if (c66Var != null && i7 < linkedList.size()) {
                                int i10 = i7;
                                while (i10 < linkedList.size() && (!(linkedList.get(i10) instanceof o56) || e(((o56) linkedList.get(i10)).position, i4) + i8 != c66Var.getPosition() - 1)) {
                                    i10++;
                                }
                                if (linkedList.size() > i10 && i10 > 0) {
                                    linkedList.add(i10, c66Var);
                                    int i11 = i8 + 1;
                                    g(c66Var, linkedList, i10, i11, i3);
                                    i7 = i10;
                                    i8 = i11;
                                } else {
                                    i7 = i10;
                                }
                            }
                        }
                        int i12 = 0;
                        int i13 = 0;
                        for (xn xnVar2 : linkedList) {
                            if (xnVar2 instanceof jt4) {
                                ((jt4) xnVar2).setPosition(i13 + 1);
                                i12++;
                            } else if (xnVar2 instanceof BaseCardInfo) {
                                BaseCardInfo baseCardInfo = (BaseCardInfo) xnVar2;
                                int i14 = baseCardInfo.position + i12;
                                baseCardInfo.position = i14;
                                i13 = i14;
                            }
                        }
                    }
                    if (i2 == 0 && UbsABTestHelper.isHomePageRecommendLiveSencondFloorShow()) {
                        if (i != 0 && userFollowLive != null && userFollowLive._switch.intValue() == 1 && !ListUtils.isEmpty(userFollowLive.user_follow_live)) {
                            r57 r57Var = new r57();
                            r57Var.f(userFollowLive);
                            linkedList.add(0, r57Var);
                            r57Var.position = -1;
                        } else if (i == 1 && (a2 = a()) != null) {
                            linkedList.add(0, a2);
                            a2.position = -1;
                        }
                    }
                    AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
                    return linkedList;
                }
            }
            i4 = -1;
            if (builder != null) {
                z07Var = new z07();
                if (builder.hot_recomforum.floor.intValue() <= 0) {
                }
                z07Var.floorPosition = i5;
                if (z07Var.i(builder.hot_recomforum.tab_list)) {
                }
            }
            if (i2 == 0) {
                int f2 = n15.f();
                e2 = n15.e();
                if (i == 0) {
                }
                if (i4 >= 0) {
                    e2++;
                }
                k(e2, f2, arrayList);
            }
            linkedList = new LinkedList<>();
            int i62 = 0;
            while (r4.hasNext()) {
            }
            if (!UbsABTestHelper.isPersonalizeFunAdABTest()) {
            }
            if (i2 == 0) {
                if (i != 0) {
                }
                if (i == 1) {
                    linkedList.add(0, a2);
                    a2.position = -1;
                }
            }
            AbsGroupUbsABTest.setCardInfoUbsABTest(linkedList);
            return linkedList;
        }
        return (List) invokeCommon.objValue;
    }

    public void j(vr4 vr4Var, int i, List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(1048585, this, vr4Var, i, list) != null) || vr4Var == null || list == null || i <= 0) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (list.get(i3) instanceof ThreadData) {
                if (i == i2) {
                    vr4Var.floorPosition = i;
                    ListUtils.add(list, i3, vr4Var);
                    return;
                }
                i2++;
            }
        }
    }

    public final void k(int i, int i2, List<xn> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, list) == null) && !ListUtils.isEmpty(list) && i >= 0 && i2 >= 1) {
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
                        ks8 ks8Var = new ks8();
                        ks8Var.n(true);
                        threadData.funAdData = ks8Var;
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
            if (i3 > 0 && hs5.i().p(AbsDataRecorder.Scene.RECOMMEND)) {
                hs5.i().n(list, i3, 1);
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
    public final void l(List<xn> list, z07 z07Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048587, this, list, z07Var, i) == null) && z07Var != null && !ListUtils.isEmpty(z07Var.f())) {
            int i2 = 0;
            if (list.size() > 0) {
                int i3 = 0;
                while (i3 < list.size() && ((!(list.get(i3) instanceof o56) || ((o56) list.get(i3)).position + 1 != i) && (!(list.get(i3) instanceof jt4) || ((jt4) list.get(i3)).j() + 1 != i))) {
                    i3++;
                }
            }
            int i4 = 0;
            for (xn xnVar : list) {
                if (xnVar instanceof z07) {
                    ((z07) xnVar).position = i2 + 1;
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

    public void m(List<xn> list, kl8 kl8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(1048588, this, list, kl8Var, i) != null) || ListUtils.isEmpty(list) || kl8Var == null || i < 0) {
            return;
        }
        u(list);
        if (i == 0) {
            l(list, z07.c(kl8Var), kl8Var.a);
            return;
        }
        while (i < list.size() && !(list.get(i) instanceof o56) && !(list.get(i) instanceof jt4)) {
            i++;
        }
        if (list.get(i) instanceof o56) {
            l(list, z07.c(kl8Var), ((o56) list.get(i)).position + 2);
        } else if (list.get(i) instanceof jt4) {
            l(list, z07.c(kl8Var), ((jt4) list.get(i)).j() + 2);
        }
    }

    public final void p(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) {
            z57.k(z, builder, builder2, i, this.c, this.f, this.g);
        }
    }

    public final void q(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        List<ThreadInfo> list;
        List<ThreadInfo> list2;
        Long l;
        Long l2;
        Long l3;
        Long l4;
        Long l5;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null && (list = builder.thread_list) != null && (list2 = builder2.thread_list) != null) {
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
                        JSONObject b2 = mk8.b(threadInfo2);
                        if (b2 != null) {
                            arrayList.add(b2);
                        }
                    }
                }
            } else {
                this.d.c(z, list);
                if (o()) {
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
                        JSONObject b3 = mk8.b(threadInfo3);
                        if (b3 != null) {
                            arrayList.add(0, b3);
                        }
                    }
                }
            }
            if (o()) {
                if (!ListUtils.isEmpty(this.i) && builder2.banner_list != null) {
                    int count3 = ListUtils.getCount(list2) + ListUtils.getCount(builder2.banner_list.app);
                    for (int i2 = 0; i2 < this.i.size(); i2++) {
                        App app = this.i.get(i2);
                        if (app != null) {
                            App.Builder builder4 = new App.Builder(app);
                            fi8.c(builder4, count3);
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
            mk8.f().h("HOME", arrayList);
        }
    }

    public final void r(List<ThreadPersonalized> list, List<ThreadPersonalized> list2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, list, list2) == null) && list != null && list2 != null) {
            list.addAll(list2);
        }
    }

    public final void s(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i)}) == null) && builder != null && builder2 != null) {
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
            q(z, builder, builder2, i);
            p(z, builder, builder2, i);
            r(builder.thread_personalized, builder2.thread_personalized);
        }
    }

    public final List<ThreadInfo> t(DataRes.Builder builder, int i, int i2) {
        InterceptResult invokeLII;
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048595, this, builder, i, i2)) == null) {
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

    public final void u(List<xn> list) {
        BaseCardInfo baseCardInfo;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, list) == null) {
            Iterator<xn> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                xn next = it.next();
                if ((next instanceof BaseCardInfo) && (i = (baseCardInfo = (BaseCardInfo) next).position) > 0) {
                    baseCardInfo.position = i - i2;
                }
                if (next instanceof z07) {
                    it.remove();
                    i2++;
                }
            }
        }
    }

    public final boolean v(DataRes.Builder builder) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, builder)) == null) {
            if (builder != null && (num = builder.show_adsense) != null && num.intValue() == 2) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void w(List<c66> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, list) != null) || list == null) {
            return;
        }
        Collections.sort(list, new a(this));
    }
}
