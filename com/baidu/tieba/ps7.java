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
public class ps7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<in> list) {
        yl9 yl9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<in> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                in next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof wz5)) {
                    it.remove();
                }
                if (next instanceof wr7) {
                    advertAppInfo = ((wr7) next).c();
                } else if (next instanceof by4) {
                    by4 by4Var = (by4) next;
                    if (by4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) by4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (yl9Var = ((ThreadData) next).funAdData) != null && yl9Var.i()) {
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

    public static void b(List<in> list, DataRes.Builder builder, iq7 iq7Var, tr7 tr7Var) {
        yl9 yl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, iq7Var, tr7Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<in> it = list.iterator();
                while (it.hasNext()) {
                    in next = it.next();
                    if (!(next instanceof wr7) && !(next instanceof by4) && !(next instanceof wz5)) {
                        if ((next instanceof ThreadData) && (yl9Var = ((ThreadData) next).funAdData) != null) {
                            yl9Var.p(true);
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
                if (iq7Var != null) {
                    iq7Var.a(builder3);
                }
            }
            if (tr7Var != null) {
                tr7Var.y(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, iq7 iq7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, iq7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(ia9.a(app))) {
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
            if (iq7Var != null) {
                iq7Var.a(builder3);
            }
        }
    }
}
