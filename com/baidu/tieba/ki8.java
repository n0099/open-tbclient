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
/* loaded from: classes7.dex */
public class ki8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<pi> list) {
        kwa kwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<pi> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                pi next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof l36)) {
                    it.remove();
                }
                if (next instanceof ih8) {
                    advertAppInfo = ((ih8) next).c();
                } else if (next instanceof zx4) {
                    zx4 zx4Var = (zx4) next;
                    if (zx4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) zx4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (kwaVar = ((ThreadData) next).funAdData) != null && kwaVar.i()) {
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

    public static void b(List<pi> list, DataRes.Builder builder, sf8 sf8Var, fh8 fh8Var) {
        kwa kwaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, sf8Var, fh8Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<pi> it = list.iterator();
                while (it.hasNext()) {
                    pi next = it.next();
                    if (!(next instanceof ih8) && !(next instanceof zx4) && !(next instanceof l36)) {
                        if ((next instanceof ThreadData) && (kwaVar = ((ThreadData) next).funAdData) != null) {
                            kwaVar.p(true);
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
                if (sf8Var != null) {
                    sf8Var.a(builder3);
                }
            }
            if (fh8Var != null) {
                fh8Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, sf8 sf8Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, sf8Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(zga.a(app))) {
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
            if (sf8Var != null) {
                sf8Var.a(builder3);
            }
        }
    }
}
