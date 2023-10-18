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
public class n28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<yh> list) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<yh> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                yh next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof f16)) {
                    it.remove();
                }
                if (next instanceof l18) {
                    advertAppInfo = ((l18) next).c();
                } else if (next instanceof cx4) {
                    cx4 cx4Var = (cx4) next;
                    if (cx4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) cx4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (neaVar = ((ThreadData) next).funAdData) != null && neaVar.i()) {
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

    public static void b(List<yh> list, DataRes.Builder builder, wz7 wz7Var, i18 i18Var) {
        nea neaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, wz7Var, i18Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<yh> it = list.iterator();
                while (it.hasNext()) {
                    yh next = it.next();
                    if (!(next instanceof l18) && !(next instanceof cx4) && !(next instanceof f16)) {
                        if ((next instanceof ThreadData) && (neaVar = ((ThreadData) next).funAdData) != null) {
                            neaVar.p(true);
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
                if (wz7Var != null) {
                    wz7Var.a(builder3);
                }
            }
            if (i18Var != null) {
                i18Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, wz7 wz7Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, wz7Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(xy9.a(app))) {
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
            if (wz7Var != null) {
                wz7Var.a(builder3);
            }
        }
    }
}
