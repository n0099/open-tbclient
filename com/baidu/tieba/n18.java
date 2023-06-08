package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class n18 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<vn> list) {
        hy9 hy9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<vn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                vn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof m66)) {
                    it.remove();
                }
                if (next instanceof r08) {
                    advertAppInfo = ((r08) next).c();
                } else if (next instanceof z25) {
                    z25 z25Var = (z25) next;
                    if (z25Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) z25Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (hy9Var = ((ThreadData) next).funAdData) != null && hy9Var.i()) {
                    it.remove();
                    i3 = i;
                }
                if (advertAppInfo != null && str.equals(advertAppInfo.a)) {
                    it.remove();
                    advertAppInfo = null;
                    i2 = i;
                }
            }
        }
    }

    public static void b(List<vn> list, DataRes.Builder builder, ez7 ez7Var, o08 o08Var) {
        hy9 hy9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, ez7Var, o08Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<vn> it = list.iterator();
                while (it.hasNext()) {
                    vn next = it.next();
                    if (!(next instanceof r08) && !(next instanceof z25) && !(next instanceof m66)) {
                        if ((next instanceof ThreadData) && (hy9Var = ((ThreadData) next).funAdData) != null) {
                            hy9Var.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                }
            }
            if (builder != null && ListUtils.getCount(builder.thread_list) > 0) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                List<App> list2 = builder2.app;
                if (list2 != null) {
                    list2.clear();
                }
                builder.banner_list = builder2.build(false);
                DataRes.Builder builder3 = new DataRes.Builder(builder.build(true));
                builder3.banner_list = builder2.build(true);
                if (ez7Var != null) {
                    ez7Var.a(builder3);
                }
            }
            if (o08Var != null) {
                o08Var.z(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, ez7 ez7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, ez7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(nl9.a(app))) {
                    arrayList.add(app);
                }
            }
            BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
            List<App> list2 = builder2.app;
            if (list2 != null) {
                list2.removeAll(arrayList);
            }
            builder.banner_list = builder2.build(false);
            DataRes.Builder builder3 = new DataRes.Builder(builder.build(true));
            builder3.banner_list = builder2.build(true);
            if (ez7Var != null) {
                ez7Var.a(builder3);
            }
        }
    }
}
