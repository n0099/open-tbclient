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
public class qe7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<Cdo> list) {
        i29 i29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<Cdo> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                Cdo next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof sx5)) {
                    it.remove();
                }
                if (next instanceof wd7) {
                    advertAppInfo = ((wd7) next).c();
                } else if (next instanceof iy4) {
                    iy4 iy4Var = (iy4) next;
                    if (iy4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) iy4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (i29Var = ((ThreadData) next).funAdData) != null && i29Var.i()) {
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

    public static void b(List<Cdo> list, DataRes.Builder builder, ic7 ic7Var, td7 td7Var) {
        i29 i29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, ic7Var, td7Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<Cdo> it = list.iterator();
                while (it.hasNext()) {
                    Cdo next = it.next();
                    if (!(next instanceof wd7) && !(next instanceof iy4) && !(next instanceof sx5)) {
                        if ((next instanceof ThreadData) && (i29Var = ((ThreadData) next).funAdData) != null) {
                            i29Var.p(true);
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
                if (ic7Var != null) {
                    ic7Var.a(builder3);
                }
            }
            if (td7Var != null) {
                td7Var.y(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, ic7 ic7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, ic7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(vr8.a(app))) {
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
            if (ic7Var != null) {
                ic7Var.a(builder3);
            }
        }
    }
}
