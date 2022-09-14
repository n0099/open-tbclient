package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes4.dex */
public class j27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, c26Var) == null) {
            c26Var.u = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void B(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, c26Var) == null) {
            if (c26Var instanceof k26) {
                ((k26) c26Var).w = true;
            } else if (c26Var instanceof l26) {
                ((l26) c26Var).w = true;
            } else if (c26Var instanceof j26) {
                ((j26) c26Var).w = true;
            }
            c26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void C(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, c26Var) == null) {
            c26Var.z = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void D(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, c26Var) == null) {
            if (c26Var instanceof k26) {
                ((k26) c26Var).v = true;
            } else if (c26Var instanceof l26) {
                ((l26) c26Var).v = true;
            } else if (c26Var instanceof j26) {
                ((j26) c26Var).v = true;
            }
            c26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
        }
    }

    public static void E(BannerList.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, builder) == null) || builder == null || ListUtils.isEmpty(builder.app)) {
            return;
        }
        for (int i = 0; i < builder.app.size(); i++) {
            App app = builder.app.get(i);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                builder2.pos = Integer.valueOf(rc8.b(app));
                App build = builder2.build(false);
                builder.app.remove(i);
                builder.app.add(i, build);
            }
        }
    }

    public static void a(List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, list) == null) || list == null || list.size() <= 1) {
            return;
        }
        int size = list.size() - 1;
        while (true) {
            int i = size - 1;
            if (i <= 0) {
                return;
            }
            int f = f(list.get(size));
            int f2 = f(list.get(i));
            if (f <= 0 || f - f2 < 3) {
                ListUtils.remove(list, size);
            }
            size--;
        }
    }

    public static void b(int i, List<App> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65542, null, i, list) == null) || list == null) {
            return;
        }
        int i2 = 0;
        Iterator<App> it = list.iterator();
        while (it.hasNext()) {
            App next = it.next();
            if (next != null) {
                int b = rc8.b(next);
                if (b <= 0) {
                    it.remove();
                    ze8.h(l(next), 1, 23);
                } else {
                    int i3 = i + i2 + 1;
                    if (b <= i3) {
                        i2++;
                    } else {
                        it.remove();
                        ze8.i(l(next), 1, 2, b, i3);
                    }
                }
            } else {
                it.remove();
            }
        }
    }

    public static void c(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, builder) == null) || builder == null) {
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

    public static List<q26> d(DataRes.Builder builder) {
        InterceptResult invokeL;
        List<App> list;
        AdvertAppInfo advertAppInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, builder)) == null) {
            z17 z17Var = null;
            if (builder == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            List<Resource> list2 = builder.resource_list;
            if (list2 != null) {
                for (Resource resource : list2) {
                    y17 y17Var = new y17();
                    y17Var.c(resource);
                    linkedList.add(y17Var);
                }
            }
            List<CardForum> list3 = builder.card_forum;
            if (list3 != null) {
                for (CardForum cardForum : list3) {
                    if (cardForum != null && x17.n(cardForum.card_type.intValue()) && z17Var == null) {
                        z17Var = new z17();
                        z17Var.s(cardForum);
                        if (z17Var.r()) {
                            linkedList.add(z17Var);
                        }
                    }
                }
            }
            List<AdvertAppInfo> f = md8.l().f();
            if (f != null) {
                f.clear();
            }
            BannerList bannerList = builder.banner_list;
            if (bannerList != null && (list = bannerList.app) != null) {
                for (App app : list) {
                    w17 w17Var = new w17();
                    w17Var.f(app);
                    if (f != null && (advertAppInfo = w17Var.a) != null) {
                        advertAppInfo.isFromHomPage = true;
                        f.add(advertAppInfo);
                    }
                    AdvertAppInfo c = w17Var.c();
                    if (c == null) {
                        ze8.h(w17Var.c(), 1, 100);
                    } else {
                        int n = c.n();
                        if (n != 0) {
                            ze8.h(w17Var.c(), 1, n);
                            if (n != 28 && n != 31) {
                                c.c = -1001;
                            }
                        }
                        if (w17Var.getPosition() <= 0) {
                            ze8.h(w17Var.c(), 1, 23);
                            c.c = -1001;
                        }
                        if (c.h()) {
                            try {
                                if (TextUtils.isEmpty(c.p)) {
                                    ze8.h(w17Var.c(), 1, 26);
                                } else if (zl8.b(TbadkCoreApplication.getInst().getContext(), c.p) && gm5.a().p()) {
                                    ze8.h(w17Var.c(), 1, 3);
                                }
                            } catch (Exception unused) {
                                ze8.h(w17Var.c(), 1, 100);
                            }
                        }
                        linkedList.add(w17Var);
                    }
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public static c26 e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            if (threadData.isShareThread) {
                k26 k26Var = new k26();
                k26Var.a = threadData;
                return k26Var;
            } else if (m26.W(threadData)) {
                return new m26(threadData);
            } else {
                if (j26.W(threadData)) {
                    return new j26(threadData);
                }
                if (!k26.W(threadData) && !k26.X(threadData)) {
                    if (l26.R(threadData)) {
                        return new l26(threadData);
                    }
                    return null;
                }
                k26 k26Var2 = new k26();
                threadData.isLinkThread();
                threadData.isSmartAppThreadType();
                if (!threadData.isLinkThread() && !threadData.isSmartAppThreadType()) {
                    threadData.isGodThread();
                }
                k26Var2.a = threadData;
                return k26Var2;
            }
        }
        return (c26) invokeL.objValue;
    }

    public static int f(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, app)) == null) {
            if (app == null) {
                return -1;
            }
            return rc8.b(app);
        }
        return invokeL.intValue;
    }

    public static k26 g(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, threadData)) == null) {
            k26 k26Var = new k26();
            k26Var.a = threadData;
            threadData.isLinkThread();
            if (!threadData.isLinkThread()) {
                threadData.isGodThread();
            }
            return k26Var;
        }
        return (k26) invokeL.objValue;
    }

    public static void h(BannerList.Builder builder, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65548, null, builder, i) == null) || builder == null || builder.app == null) {
            return;
        }
        for (int i2 = 0; i2 < builder.app.size(); i2++) {
            App app = builder.app.get(i2);
            if (app != null) {
                App.Builder builder2 = new App.Builder(app);
                rc8.c(builder2, i);
                App build = builder2.build(false);
                builder.app.remove(i2);
                builder.app.add(i2, build);
            }
        }
    }

    public static BannerList i(boolean z, BannerList bannerList, BannerList bannerList2, int i, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
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
                    E(builder2);
                }
                List<App> list = builder2.app;
                if (list != null) {
                    Iterator<App> it = list.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        App next = it.next();
                        if (next != null) {
                            int b = rc8.b(next);
                            if (b <= 0) {
                                it.remove();
                                ze8.h(l(next), 1, 23);
                            } else {
                                int i7 = i4 + i6 + 1;
                                if (b <= i7) {
                                    i6++;
                                } else {
                                    it.remove();
                                    ze8.i(l(next), 1, 2, b, i7);
                                }
                            }
                        } else {
                            it.remove();
                        }
                    }
                }
                h(builder2, i5);
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

    public static BannerList j(boolean z, BannerList bannerList, BannerList bannerList2, int i) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), bannerList, bannerList2, Integer.valueOf(i)})) == null) {
            if (i <= 0) {
                return bannerList;
            }
            BannerList.Builder builder = new BannerList.Builder(bannerList);
            if (builder.app == null) {
                builder.app = new LinkedList();
            }
            BannerList.Builder builder2 = new BannerList.Builder(bannerList2);
            if (z) {
                E(builder2);
            }
            List<App> list = builder2.app;
            if (list != null) {
                Iterator<App> it = list.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    App next = it.next();
                    if (next != null) {
                        int b = rc8.b(next);
                        if (b <= 0) {
                            it.remove();
                            ze8.h(l(next), 1, 23);
                        } else {
                            int i3 = i + i2 + 1;
                            if (b <= i3) {
                                i2++;
                            } else {
                                it.remove();
                                ze8.i(l(next), 1, 2, b, i3);
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
            h(builder, i4);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                builder.app.addAll(0, list2);
            }
            return builder.build(false);
        }
        return (BannerList) invokeCommon.objValue;
    }

    public static void k(boolean z, DataRes.Builder builder, DataRes.Builder builder2, int i, int i2, int i3, int i4) {
        List<TagStruct> list;
        List<Resource> list2;
        List<CardTopic> list3;
        List<CardForum> list4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Boolean.valueOf(z), builder, builder2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) || builder2 == null || builder == null) {
            return;
        }
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
            builder.banner_list = j(z, builder.banner_list, builder2.banner_list, i2);
        } else {
            List<ThreadInfo> list8 = builder.thread_list;
            builder.banner_list = i(z, builder.banner_list, builder2.banner_list, list8 != null ? list8.size() : 0, i3, i4, i2);
        }
        if (builder.age_sex == null) {
            builder.age_sex = builder2.age_sex;
            if (builder2.age_sex != null) {
                bx4.k().u("has_requested_new_user_guide", true);
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

    public static AdvertAppInfo l(App app) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, app)) == null) {
            w17 w17Var = new w17();
            w17Var.f(app);
            return w17Var.c();
        }
        return (AdvertAppInfo) invokeL.objValue;
    }

    public static void m(DataRes.Builder builder) {
        BannerList.Builder builder2;
        List<App> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, builder) == null) || builder == null) {
            return;
        }
        int count = ListUtils.getCount(builder.thread_list);
        BannerList bannerList = builder.banner_list;
        if (bannerList == null || bannerList.app == null || (list = (builder2 = new BannerList.Builder(bannerList)).app) == null) {
            return;
        }
        a(list);
        for (int size = builder2.app.size() - 1; size >= 0; size--) {
            App app = builder2.app.get(size);
            w17 w17Var = new w17();
            w17Var.f(app);
            int b = app != null ? rc8.b(app) : -1;
            if (b < 0) {
                ze8.h(w17Var.c(), 1, 33);
                builder2.app.remove(size);
            } else {
                int i = count + size;
                if (b > i) {
                    ze8.i(w17Var.p(), 1, 2, b, i);
                    builder2.app.remove(size);
                } else {
                    AdvertAppInfo c = w17Var.c();
                    if (c == null) {
                        ze8.h(w17Var.c(), 1, 100);
                        builder2.app.remove(size);
                    } else {
                        int n = c.n();
                        if (n != 0) {
                            ze8.h(w17Var.c(), 1, n);
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

    public static void n(DataRes.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, builder) == null) {
            m(builder);
            if (builder == null || builder.card_forum == null || builder.card_topic == null || builder.resource_list == null || ListUtils.getCount(builder.thread_list) == 0) {
                return;
            }
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

    public static void o(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, threadData) == null) {
            String lengthLimitName = threadData.getLengthLimitName();
            String formatTimeForHomeC = StringHelper.getFormatTimeForHomeC(threadData.getLast_time_int() * 1000);
            if (!TextUtils.isEmpty(lengthLimitName) && !TextUtils.isEmpty(formatTimeForHomeC)) {
                lengthLimitName = lengthLimitName + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f112c) + "   " + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0ffc) + formatTimeForHomeC;
            }
            threadData.setThreadExtendInfo(lengthLimitName);
        }
    }

    public static void p(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, c26Var) == null) {
            if (c26Var instanceof m26) {
                ((m26) c26Var).A = true;
            } else if (c26Var instanceof k26) {
                ((k26) c26Var).A = true;
            } else if (c26Var instanceof l26) {
                ((l26) c26Var).A = true;
            } else if (c26Var instanceof j26) {
                ((j26) c26Var).A = true;
            }
            c26Var.setSupportType(BaseCardInfo.SupportType.BOTTOM);
        }
    }

    public static void q(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, c26Var) == null) {
            if (c26Var == null || c26Var.getThreadData() == null || !c26Var.getThreadData().isFromHomPage || !c26Var.getThreadData().isWorksInfo()) {
                if (c26Var instanceof k26) {
                    ((k26) c26Var).x = true;
                } else if (c26Var instanceof l26) {
                    ((l26) c26Var).x = true;
                } else if (c26Var instanceof j26) {
                    ((j26) c26Var).x = true;
                }
                c26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
            }
        }
    }

    public static void r(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, c26Var) == null) {
            c26Var.n = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void s(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65559, null, c26Var) == null) || c26Var == null || c26Var.getThreadData() == null || c26Var.getThreadData().getTopAgreePost() == null || c26Var.getThreadData().getTopAgreePost().s() == null || c26Var.getThreadData().getTopAgreePost().s().getUserId() == null) {
            return;
        }
        if (c26Var instanceof k26) {
            ((k26) c26Var).y = true;
        } else if (c26Var instanceof l26) {
            ((l26) c26Var).y = true;
        } else if (c26Var instanceof j26) {
            ((j26) c26Var).y = true;
        }
        c26Var.setSupportType(BaseCardInfo.SupportType.EXTEND);
    }

    public static void t(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, c26Var) == null) {
            if (c26Var instanceof m26) {
                ((m26) c26Var).m = true;
            } else if (c26Var instanceof k26) {
                ((k26) c26Var).m = true;
            } else if (c26Var instanceof l26) {
                ((l26) c26Var).m = true;
            } else if (c26Var instanceof j26) {
                ((j26) c26Var).m = true;
            }
            c26Var.setSupportType(BaseCardInfo.SupportType.TOP);
        }
    }

    public static void u(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, c26Var) == null) {
            ((k26) c26Var).o = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void v(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, c26Var) == null) {
            ((k26) c26Var).q = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void w(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, c26Var) == null) {
            ((k26) c26Var).p = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void x(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, c26Var) == null) {
            ((k26) c26Var).r = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void y(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, c26Var) == null) {
            ((l26) c26Var).s = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }

    public static void z(c26 c26Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, c26Var) == null) {
            ((m26) c26Var).t = true;
            c26Var.setSupportType(BaseCardInfo.SupportType.CONTENT);
        }
    }
}
