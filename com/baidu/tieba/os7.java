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
public class os7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<hn> list) {
        ql9 ql9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<hn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                hn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof vz5)) {
                    it.remove();
                }
                if (next instanceof vr7) {
                    advertAppInfo = ((vr7) next).c();
                } else if (next instanceof ay4) {
                    ay4 ay4Var = (ay4) next;
                    if (ay4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ay4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (ql9Var = ((ThreadData) next).funAdData) != null && ql9Var.i()) {
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

    public static void b(List<hn> list, DataRes.Builder builder, hq7 hq7Var, sr7 sr7Var) {
        ql9 ql9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, hq7Var, sr7Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<hn> it = list.iterator();
                while (it.hasNext()) {
                    hn next = it.next();
                    if (!(next instanceof vr7) && !(next instanceof ay4) && !(next instanceof vz5)) {
                        if ((next instanceof ThreadData) && (ql9Var = ((ThreadData) next).funAdData) != null) {
                            ql9Var.p(true);
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
                if (hq7Var != null) {
                    hq7Var.a(builder3);
                }
            }
            if (sr7Var != null) {
                sr7Var.y(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, hq7 hq7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, hq7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(aa9.a(app))) {
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
            if (hq7Var != null) {
                hq7Var.a(builder3);
            }
        }
    }
}
