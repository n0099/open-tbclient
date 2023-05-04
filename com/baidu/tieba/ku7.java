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
public class ku7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<in> list) {
        np9 np9Var;
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
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof x06)) {
                    it.remove();
                }
                if (next instanceof rt7) {
                    advertAppInfo = ((rt7) next).c();
                } else if (next instanceof ry4) {
                    ry4 ry4Var = (ry4) next;
                    if (ry4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ry4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (np9Var = ((ThreadData) next).funAdData) != null && np9Var.i()) {
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

    public static void b(List<in> list, DataRes.Builder builder, ds7 ds7Var, ot7 ot7Var) {
        np9 np9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, ds7Var, ot7Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<in> it = list.iterator();
                while (it.hasNext()) {
                    in next = it.next();
                    if (!(next instanceof rt7) && !(next instanceof ry4) && !(next instanceof x06)) {
                        if ((next instanceof ThreadData) && (np9Var = ((ThreadData) next).funAdData) != null) {
                            np9Var.p(true);
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
                if (ds7Var != null) {
                    ds7Var.a(builder3);
                }
            }
            if (ot7Var != null) {
                ot7Var.y(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, ds7 ds7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, ds7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(ed9.a(app))) {
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
            if (ds7Var != null) {
                ds7Var.a(builder3);
            }
        }
    }
}
