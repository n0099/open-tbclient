package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.DiscoverHotForum;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
import tbclient.Personalized.TagStruct;
import tbclient.ThreadInfo;
/* loaded from: classes6.dex */
public class k48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, jn6Var) == null) {
            ((tn6) jn6Var).t = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void B(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, jn6Var) == null) {
            jn6Var.u = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, jn6Var) == null) {
            jn6Var.z = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return pw9.b(app);
        }
        return invokeL.intValue;
    }

    public static vy7 g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            vy7 vy7Var = new vy7();
            vy7Var.Y(threadData.getClickBackCard());
            vy7Var.setTid(threadData.getTid());
            return vy7Var;
        }
        return (vy7) invokeL.objValue;
    }

    public static rn6 h(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, threadData)) == null) {
            rn6 rn6Var = new rn6();
            rn6Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return rn6Var;
        }
        return (rn6) invokeL.objValue;
    }

    public static AdvertAppInfo m(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, app)) == null) {
            r38 r38Var = new r38();
            r38Var.d(app);
            return r38Var.c();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void s(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, jn6Var) == null) {
            jn6Var.n = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void v(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, jn6Var) == null) {
            ((rn6) jn6Var).o = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, jn6Var) == null) {
            ((rn6) jn6Var).q = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, jn6Var) == null) {
            ((rn6) jn6Var).p = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, jn6Var) == null) {
            ((rn6) jn6Var).r = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, null, jn6Var) == null) {
            ((sn6) jn6Var).s = true;
            jn6Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void C(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, jn6Var) == null) {
            if (jn6Var instanceof rn6) {
                ((rn6) jn6Var).w = true;
            } else if (jn6Var instanceof sn6) {
                ((sn6) jn6Var).w = true;
            } else if (jn6Var instanceof qn6) {
                ((qn6) jn6Var).w = true;
            }
            jn6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void E(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jn6Var) == null) {
            if (jn6Var instanceof rn6) {
                ((rn6) jn6Var).v = true;
            } else if (jn6Var instanceof sn6) {
                ((sn6) jn6Var).v = true;
            } else if (jn6Var instanceof qn6) {
                ((qn6) jn6Var).v = true;
            }
            jn6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void a(List<App> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, list) == null) && list != null && list.size() > 1) {
            int size = list.size() - 1;
            while (true) {
                int i = size - 1;
                if (i > 0) {
                    int f = f(list.get(size));
                    int f2 = f(list.get(i));
                    if (f <= 0 || f - f2 < 3) {
                        ListUtils.remove(list, size);
                    }
                    size--;
                } else {
                    return;
                }
            }
        }
    }

    public static void q(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, jn6Var) == null) {
            if (jn6Var instanceof tn6) {
                ((tn6) jn6Var).A = true;
            } else if (jn6Var instanceof rn6) {
                ((rn6) jn6Var).A = true;
            } else if (jn6Var instanceof sn6) {
                ((sn6) jn6Var).A = true;
            } else if (jn6Var instanceof qn6) {
                ((qn6) jn6Var).A = true;
            }
            jn6Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void u(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, jn6Var) == null) {
            if (jn6Var instanceof tn6) {
                ((tn6) jn6Var).m = true;
            } else if (jn6Var instanceof rn6) {
                ((rn6) jn6Var).m = true;
            } else if (jn6Var instanceof sn6) {
                ((sn6) jn6Var).m = true;
            } else if (jn6Var instanceof qn6) {
                ((qn6) jn6Var).m = true;
            }
            jn6Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void F(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, builder) == null) && builder != null && !ListUtils.isEmpty(builder.app)) {
            for (int i = 0; i < builder.app.size(); i++) {
                App app = builder.app.get(i);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    builder2.pos = Integer.valueOf(pw9.b(app));
                    App build = builder2.build(false);
                    builder.app.remove(i);
                    builder.app.add(i, build);
                }
            }
        }
    }

    public static void c(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, null, builder) != null) || builder == null) {
            return;
        }
        if (builder.thread_list == null) {
            builder.thread_list = new LinkedList();
        }
        if (builder.card_forum == null) {
            builder.card_forum = new LinkedList();
        }
        if (builder.card_topic == null) {
            builder.card_topic = new LinkedList();
        }
        if (builder.resource_list == null) {
            builder.resource_list = new LinkedList();
        }
        if (builder.thread_personalized == null) {
            builder.thread_personalized = new LinkedList();
        }
        if (builder.interestion == null) {
            builder.interestion = new LinkedList();
        }
        if (builder.card_god == null) {
            builder.card_god = new LinkedList();
        }
    }

    public static void p(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + TbadkCoreApplication.getInst().getString(R.string.send_post) + "   " + TbadkCoreApplication.getInst().getString(R.string.repley_when) + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }

    public static void r(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, jn6Var) == null) {
            if (jn6Var != null && jn6Var.getThreadData() != null && jn6Var.getThreadData().isFromHomPage && jn6Var.getThreadData().isWorksInfo()) {
                return;
            }
            if (jn6Var instanceof rn6) {
                ((rn6) jn6Var).x = true;
            } else if (jn6Var instanceof sn6) {
                ((sn6) jn6Var).x = true;
            } else if (jn6Var instanceof qn6) {
                ((qn6) jn6Var).x = true;
            }
            jn6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void b(int i, List<App> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(65543, null, i, list) == null) && list != null) {
            int i2 = 0;
            Iterator<App> it = list.iterator();
            while (it.hasNext()) {
                App next = it.next();
                if (next != null) {
                    int b = pw9.b(next);
                    if (b <= 0) {
                        it.remove();
                        az9.h(m(next), 1, 23);
                    } else {
                        int i3 = i + i2 + 1;
                        if (b <= i3) {
                            i2++;
                        } else {
                            it.remove();
                            az9.i(m(next), 1, 2, b, i3);
                        }
                    }
                } else {
                    it.remove();
                }
            }
        }
    }

    public static List<xn6> d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, builder)) == null) {
            u38 u38Var = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    t38 t38Var = new t38();
                    t38Var.c(resource);
                    linkedList.add(t38Var);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && s38.h(cardForum.card_type.intValue()) && u38Var == null) {
                        u38Var = new u38();
                        u38Var.l(cardForum);
                        if (u38Var.i()) {
                            linkedList.add(u38Var);
                        }
                    }
                }
            }
            List<AdvertAppInfo> g = lx9.m().g();
            if (g != null) {
                g.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    r38 r38Var = new r38();
                    r38Var.d(app);
                    if (g != null && (advertAppInfo = r38Var.a) != null) {
                        advertAppInfo.isFromHomPage = true;
                        g.add(advertAppInfo);
                    }
                    AdvertAppInfo c = r38Var.c();
                    if (c == null) {
                        az9.h(r38Var.c(), 1, 100);
                    } else {
                        int h = c.h();
                        if (h != 0) {
                            az9.h(r38Var.c(), 1, h);
                            if (h != 28 && h != 31) {
                                c.c = -1001;
                            }
                        }
                        if (r38Var.getPosition() <= 0) {
                            az9.h(r38Var.c(), 1, 23);
                            c.c = -1001;
                        }
                        if (c.e()) {
                            try {
                                if (TextUtils.isEmpty(c.q)) {
                                    az9.h(r38Var.c(), 1, 26);
                                } else if (vaa.b(TbadkCoreApplication.getInst().getContext(), c.q) && z16.a().o()) {
                                    az9.h(r38Var.c(), 1, 3);
                                }
                            } catch (Exception unused) {
                                az9.h(r38Var.c(), 1, 100);
                            }
                        }
                        linkedList.add(r38Var);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static jn6 e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.isShareThread) {
                rn6 rn6Var = new rn6();
                rn6Var.a = threadData;
                return rn6Var;
            } else if (tn6.R(threadData)) {
                return new tn6(threadData);
            } else {
                if (qn6.R(threadData)) {
                    return new qn6(threadData);
                }
                if (!rn6.R(threadData) && !rn6.S(threadData)) {
                    if (!sn6.L(threadData)) {
                        return null;
                    }
                    return new sn6(threadData);
                }
                rn6 rn6Var2 = new rn6();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                rn6Var2.a = threadData;
                return rn6Var2;
            }
        }
        return (jn6) invokeL.objValue;
    }

    public static void t(jn6 jn6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, null, jn6Var) == null) && jn6Var != null && jn6Var.getThreadData() != null && jn6Var.getThreadData().getTopAgreePost() != null && jn6Var.getThreadData().getTopAgreePost().r() != null && jn6Var.getThreadData().getTopAgreePost().r().getUserId() != null) {
            if (jn6Var instanceof rn6) {
                ((rn6) jn6Var).y = true;
            } else if (jn6Var instanceof sn6) {
                ((sn6) jn6Var).y = true;
            } else if (jn6Var instanceof qn6) {
                ((qn6) jn6Var).y = true;
            }
            jn6Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void i(BannerList.Builder builder, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65550, null, builder, i) == null) && builder != null && builder.app != null) {
            for (int i2 = 0; i2 < builder.app.size(); i2++) {
                App app = builder.app.get(i2);
                if (app != null) {
                    App.Builder builder2 = new App.Builder(app);
                    pw9.c(builder2, i);
                    App build = builder2.build(false);
                    builder.app.remove(i2);
                    builder.app.add(i2, build);
                }
            }
        }
    }

    public static BannerList j(boolean z, BannerList bannerList, BannerList bannerList2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            if (i4 <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (bannerList2 != null && bannerList2.app != null) {
                if (builder.app == null) {
                    builder.app = new LinkedList();
                }
                b(i, builder.app);
                int i5 = i2 + i3;
                BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
                if (builder2.app == null) {
                    builder2.app = new LinkedList();
                }
                if (z) {
                    F(builder2);
                }
                List<App> list = builder2.app;
                if (list != null) {
                    Iterator<App> it = list.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        App next = it.next();
                        if (next != null) {
                            int b = pw9.b(next);
                            if (b <= 0) {
                                it.remove();
                                az9.h(m(next), 1, 23);
                            } else {
                                int i7 = i4 + i6 + 1;
                                if (b <= i7) {
                                    i6++;
                                } else {
                                    it.remove();
                                    az9.i(m(next), 1, 2, b, i7);
                                }
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
                i(builder2, i5);
                List<App> list2 = builder2.app;
                if (list2 != null) {
                    builder.app.addAll(list2);
                }
                return builder.build(false);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void l(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2, int i3, int i4) {
        int i5;
        List<TagStruct> list;
        List<Resource> list2;
        List<CardTopic> list3;
        List<CardForum> list4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && builder2 != null && builder != null) {
            List<CardForum> list5 = builder2.card_forum;
            if (list5 != null && (list4 = builder.card_forum) != null) {
                list4.addAll(list5);
            }
            List<CardTopic> list6 = builder2.card_topic;
            if (list6 != null && (list3 = builder.card_topic) != null) {
                list3.addAll(list6);
            }
            List<Resource> list7 = builder2.resource_list;
            if (list7 != null && (list2 = builder.resource_list) != null) {
                list2.addAll(list7);
            }
            if (i == 0) {
                builder.banner_list = k(z, builder.banner_list, builder2.banner_list, i2);
            } else {
                List<ThreadInfo> list8 = builder.thread_list;
                if (list8 != null) {
                    i5 = list8.size();
                } else {
                    i5 = 0;
                }
                builder.banner_list = j(z, builder.banner_list, builder2.banner_list, i5, i3, i4, i2);
            }
            if (builder.age_sex == null) {
                builder.age_sex = builder2.age_sex;
                if (builder2.age_sex != null) {
                    SharedPrefHelper.getInstance().putBoolean("has_requested_new_user_guide", true);
                }
            }
            if (builder2.interestion != null && builder != null && (list = builder.interestion) != null && list.size() == 0) {
                builder.interestion.addAll(builder2.interestion);
            }
            List<CardGod> list9 = builder2.card_god;
            if (list9 != null) {
                builder.card_god.addAll(list9);
            }
            DiscoverHotForum discoverHotForum = builder2.hot_recomforum;
            if (discoverHotForum != null) {
                builder.hot_recomforum = discoverHotForum;
            }
        }
    }

    public static BannerList k(boolean z, BannerList bannerList, BannerList bannerList2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i)})) == null) {
            if (i <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (z) {
                F(builder2);
            }
            List<App> list = builder2.app;
            if (list != null) {
                Iterator<App> it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int b = pw9.b(next);
                        if (b <= 0) {
                            it.remove();
                            az9.h(m(next), 1, 23);
                        } else {
                            int i3 = i + i2 + 1;
                            if (b <= i3) {
                                i2++;
                            } else {
                                it.remove();
                                az9.i(m(next), 1, 2, b, i3);
                            }
                        }
                    } else {
                        it.remove();
                    }
                }
            } else {
                i2 = 0;
            }
            int i4 = i2 + i;
            if (i4 <= 0) {
                return builder.build(false);
            }
            i(builder, i4);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                builder.app.addAll(0, list2);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void n(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List<App> list;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65555, null, builder) != null) || builder == null) {
            return;
        }
        int count = ListUtils.getCount(builder.thread_list);
        BannerList bannerList = builder.banner_list;
        if (bannerList != null && bannerList.app != null && (list = (builder2 = new BannerList.Builder(bannerList)).app) != null) {
            a(list);
            for (int size = builder2.app.size() - 1; size >= 0; size--) {
                App app = builder2.app.get(size);
                r38 r38Var = new r38();
                r38Var.d(app);
                if (app != null) {
                    i = pw9.b(app);
                } else {
                    i = -1;
                }
                if (i < 0) {
                    az9.h(r38Var.c(), 1, 33);
                    builder2.app.remove(size);
                } else {
                    int i2 = count + size;
                    if (i > i2) {
                        az9.i(r38Var.B(), 1, 2, i, i2);
                        builder2.app.remove(size);
                    } else {
                        AdvertAppInfo c = r38Var.c();
                        if (c == null) {
                            az9.h(r38Var.c(), 1, 100);
                            builder2.app.remove(size);
                        } else {
                            int h = c.h();
                            if (h != 0) {
                                az9.h(r38Var.c(), 1, h);
                                builder2.app.remove(size);
                            }
                        }
                    }
                }
            }
            if (builder2.app.size() != builder.banner_list.app.size()) {
                builder.banner_list = builder2.build(false);
            }
        }
    }

    public static void o(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, builder) == null) {
            n(builder);
            if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && ListUtils.getCount(builder.thread_list) != 0) {
                int count = ListUtils.getCount(builder.thread_list);
                for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                    if (builder.card_forum.get(size).position.longValue() > count) {
                        builder.card_forum.remove(size);
                    }
                }
                for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                    if (builder.card_topic.get(size2).position.intValue() > count) {
                        builder.card_topic.remove(size2);
                    }
                }
                for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                    if (builder.resource_list.get(size3).position.longValue() > count) {
                        builder.resource_list.remove(size3);
                    }
                }
                for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                    if (builder.card_god.get(size4).position.intValue() > count) {
                        builder.card_god.remove(size4);
                    }
                }
            }
        }
    }
}
