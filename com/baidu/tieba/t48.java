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
/* loaded from: classes8.dex */
public class t48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<ym> list) {
        pba pbaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<ym> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                ym next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof i56)) {
                    it.remove();
                }
                if (next instanceof s38) {
                    advertAppInfo = ((s38) next).c();
                } else if (next instanceof j25) {
                    j25 j25Var = (j25) next;
                    if (j25Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) j25Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (pbaVar = ((ThreadData) next).funAdData) != null && pbaVar.i()) {
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

    public static void b(List<ym> list, DataRes.Builder builder, d28 d28Var, p38 p38Var) {
        pba pbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, d28Var, p38Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<ym> it = list.iterator();
                while (it.hasNext()) {
                    ym next = it.next();
                    if (!(next instanceof s38) && !(next instanceof j25) && !(next instanceof i56)) {
                        if ((next instanceof ThreadData) && (pbaVar = ((ThreadData) next).funAdData) != null) {
                            pbaVar.p(true);
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
                if (d28Var != null) {
                    d28Var.a(builder3);
                }
            }
            if (p38Var != null) {
                p38Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, d28 d28Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, d28Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(qw9.a(app))) {
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
            if (d28Var != null) {
                d28Var.a(builder3);
            }
        }
    }
}
