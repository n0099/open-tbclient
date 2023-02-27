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
/* loaded from: classes5.dex */
public class mh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<Cdo> list) {
        u59 u59Var;
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
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof jz5)) {
                    it.remove();
                }
                if (next instanceof sg7) {
                    advertAppInfo = ((sg7) next).c();
                } else if (next instanceof pz4) {
                    pz4 pz4Var = (pz4) next;
                    if (pz4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) pz4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (u59Var = ((ThreadData) next).funAdData) != null && u59Var.i()) {
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

    public static void b(List<Cdo> list, DataRes.Builder builder, ef7 ef7Var, pg7 pg7Var) {
        u59 u59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, ef7Var, pg7Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<Cdo> it = list.iterator();
                while (it.hasNext()) {
                    Cdo next = it.next();
                    if (!(next instanceof sg7) && !(next instanceof pz4) && !(next instanceof jz5)) {
                        if ((next instanceof ThreadData) && (u59Var = ((ThreadData) next).funAdData) != null) {
                            u59Var.p(true);
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
                if (ef7Var != null) {
                    ef7Var.a(builder3);
                }
            }
            if (pg7Var != null) {
                pg7Var.y(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, ef7 ef7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, ef7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(hv8.a(app))) {
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
            if (ef7Var != null) {
                ef7Var.a(builder3);
            }
        }
    }
}
