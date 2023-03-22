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
public class ri7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<gn> list) {
        zb9 zb9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<gn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                gn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof py5)) {
                    it.remove();
                }
                if (next instanceof yh7) {
                    advertAppInfo = ((yh7) next).c();
                } else if (next instanceof yx4) {
                    yx4 yx4Var = (yx4) next;
                    if (yx4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) yx4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (zb9Var = ((ThreadData) next).funAdData) != null && zb9Var.i()) {
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

    public static void b(List<gn> list, DataRes.Builder builder, kg7 kg7Var, vh7 vh7Var) {
        zb9 zb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, kg7Var, vh7Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<gn> it = list.iterator();
                while (it.hasNext()) {
                    gn next = it.next();
                    if (!(next instanceof yh7) && !(next instanceof yx4) && !(next instanceof py5)) {
                        if ((next instanceof ThreadData) && (zb9Var = ((ThreadData) next).funAdData) != null) {
                            zb9Var.p(true);
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
                if (kg7Var != null) {
                    kg7Var.a(builder3);
                }
            }
            if (vh7Var != null) {
                vh7Var.y(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, kg7 kg7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, kg7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(k09.a(app))) {
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
            if (kg7Var != null) {
                kg7Var.a(builder3);
            }
        }
    }
}
