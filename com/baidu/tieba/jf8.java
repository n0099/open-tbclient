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
public class jf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, List<oi> list) {
        tra traVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, str, list) == null) && list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Iterator<oi> it = list.iterator();
            int i = 0;
            AdvertAppInfo advertAppInfo = null;
            int i2 = 0;
            int i3 = 0;
            while (it.hasNext()) {
                i++;
                oi next = it.next();
                if ((i2 + 1 == i || i3 + 1 == i) && (next instanceof a36)) {
                    it.remove();
                }
                if (next instanceof he8) {
                    advertAppInfo = ((he8) next).c();
                } else if (next instanceof ux4) {
                    ux4 ux4Var = (ux4) next;
                    if (ux4Var.c() instanceof AdvertAppInfo.ILegoAdvert) {
                        advertAppInfo = ((AdvertAppInfo.ILegoAdvert) ux4Var.c()).getAdvertAppInfo();
                    }
                } else if ((next instanceof ThreadData) && (traVar = ((ThreadData) next).funAdData) != null && traVar.i()) {
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

    public static void b(List<oi> list, DataRes.Builder builder, sc8 sc8Var, ee8 ee8Var) {
        tra traVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65537, null, list, builder, sc8Var, ee8Var) == null) {
            if (list != null && list.size() > 0) {
                Iterator<oi> it = list.iterator();
                while (it.hasNext()) {
                    oi next = it.next();
                    if (!(next instanceof he8) && !(next instanceof ux4) && !(next instanceof a36)) {
                        if ((next instanceof ThreadData) && (traVar = ((ThreadData) next).funAdData) != null) {
                            traVar.p(true);
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
                if (sc8Var != null) {
                    sc8Var.a(builder3);
                }
            }
            if (ee8Var != null) {
                ee8Var.B(list);
            }
        }
    }

    public static void c(String str, DataRes.Builder builder, sc8 sc8Var) {
        BannerList bannerList;
        List<App> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, builder, sc8Var) == null) && !TextUtils.isEmpty(str) && builder != null && (bannerList = builder.banner_list) != null && (list = bannerList.app) != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (App app : builder.banner_list.app) {
                if (app != null && str.equals(dca.a(app))) {
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
            if (sc8Var != null) {
                sc8Var.a(builder3);
            }
        }
    }
}
