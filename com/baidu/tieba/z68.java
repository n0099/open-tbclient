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
public class z68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<yn> list) {
        wca wcaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<yn> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                yn next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof a86)) {
                    it.remove();
                }
                if (next instanceof c68) {
                    advertAppInfo = ((c68) next).c();
                } else if (next instanceof l35) {
                    l35 l35Var = (l35) next;
                    if (l35Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) l35Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (wcaVar = ((ThreadData) next).funAdData) != null && wcaVar.i()) {
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

    public static void b(List<yn> list, DataRes.Builder builder, p48 p48Var, z58 z58Var) {
        wca wcaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, p48Var, z58Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<yn> it = list.iterator();
                while (it.hasNext()) {
                    yn next = it.next();
                    if (!(next instanceof c68) && !(next instanceof l35) && !(next instanceof a86)) {
                        if ((next instanceof ThreadData) && (wcaVar = ((ThreadData) next).funAdData) != null) {
                            wcaVar.p(true);
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
                if (p48Var != null) {
                    p48Var.a(builder3);
                }
            }
            if (z58Var != null) {
                z58Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, p48 p48Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, p48Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(yx9.a(app))) {
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
            if (p48Var != null) {
                p48Var.a(builder3);
            }
        }
    }
}
