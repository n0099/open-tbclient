package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.AdMixFloor;
import tbclient.App;
import tbclient.BannerList;
import tbclient.FrsBottomSmartBgColor;
import tbclient.FrsPage.DataRes;
import tbclient.FrsPage.FrsBottom;
import tbclient.FrsPage.HeaderCard;
import tbclient.LayoutFactory;
/* loaded from: classes8.dex */
public abstract class rh7<T> implements mh7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract qh7 e(Object obj);

    public abstract List<LayoutFactory> f(Object obj);

    public rh7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.mh7
    public List<za7<?>> c(Object originData, y57 feedData, Map<String, String> schemaLocalInfo, boolean z) {
        InterceptResult invokeCommon;
        String str;
        FrsBottomSmartBgColor frsBottomSmartBgColor;
        HeaderCard headerCard;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{originData, feedData, schemaLocalInfo, Boolean.valueOf(z)})) == null) {
            Intrinsics.checkNotNullParameter(originData, "originData");
            Intrinsics.checkNotNullParameter(feedData, "feedData");
            Intrinsics.checkNotNullParameter(schemaLocalInfo, "schemaLocalInfo");
            List<LayoutFactory> f = f(originData);
            ArrayList arrayList = new ArrayList();
            for (LayoutFactory layoutFactory : f) {
                i87 i87Var = r67.a().get(layoutFactory.layout);
                boolean z2 = false;
                if (i87Var != null) {
                    if (i87Var instanceof ca7) {
                        ((ca7) i87Var).a(schemaLocalInfo);
                    }
                    if (i87Var instanceof p67) {
                        ((p67) i87Var).c(z);
                    }
                    if ((i87Var instanceof g87) && (originData instanceof DataRes)) {
                        g87 g87Var = (g87) i87Var;
                        DataRes dataRes = (DataRes) originData;
                        Integer num = dataRes.forum.is_like;
                        if (num != null && num.intValue() == 1) {
                            z2 = true;
                        }
                        g87Var.c(z2);
                        FrsBottom frsBottom = dataRes.frs_bottom;
                        if (frsBottom != null && (frsBottomSmartBgColor = frsBottom.frs_smart_bg_color) != null) {
                            str = frsBottomSmartBgColor.tag_color;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "#FF2B87FF";
                        }
                        g87Var.d(str);
                    }
                    za7<?> b = i87Var.b(layoutFactory);
                    if (b != null) {
                        arrayList.add(b);
                    }
                } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                    if ((originData instanceof DataRes) && (headerCard = ((DataRes) originData).header_card) != null) {
                        o6b o6bVar = new o6b();
                        o6bVar.f(headerCard);
                        if (u6b.p(o6bVar, false)) {
                            u6b u6bVar = new u6b();
                            u6bVar.n(2);
                            u6bVar.h(o6bVar);
                            arrayList.add(new ab7(u6bVar, "template_stub_head_card"));
                        }
                    }
                } else {
                    BdLog.e("no layout for " + layoutFactory.layout);
                }
            }
            qh7 e = e(originData);
            g(feedData, arrayList, e.c(), e.b(), e.a());
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public final boolean d(AdvertAppInfo advertAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, advertAppInfo)) == null) {
            try {
                if (TextUtils.isEmpty(advertAppInfo.q)) {
                    nea.h(advertAppInfo, 1, 26);
                    return true;
                } else if (yqa.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && sz5.a().o()) {
                    nea.h(advertAppInfo, 1, 3);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception unused) {
                nea.h(advertAppInfo, 1, 100);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g(y57 y57Var, List<za7<?>> list, BannerList bannerList, int i, List<AdMixFloor> list2) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{y57Var, list, bannerList, Integer.valueOf(i), list2}) == null) && i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (x58.d()) {
                            h(y57Var, list);
                            return;
                        } else {
                            j(bannerList, list);
                            return;
                        }
                    } else if (list2 != null) {
                        Iterator<T> it = list2.iterator();
                        if (it.hasNext()) {
                            t = it.next();
                            Integer num = ((AdMixFloor) t).ad_type;
                            Intrinsics.checkNotNullExpressionValue(num, "it.ad_type");
                            int intValue = num.intValue();
                            if (intValue != 1) {
                                if (intValue == 2) {
                                    i(list2, list);
                                }
                            } else {
                                j(bannerList, list);
                            }
                        } else {
                            t = null;
                        }
                        AdMixFloor adMixFloor = (AdMixFloor) t;
                        return;
                    } else {
                        return;
                    }
                }
                h(y57Var, list);
                return;
            }
            j(bannerList, list);
        }
    }

    public final void h(y57 y57Var, List<za7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, y57Var, list) == null) {
            int h = q58.m().h();
            int i = q58.m().i() - 1;
            int size = y57Var.a.size() - 1;
            int i2 = 0;
            int i3 = 0;
            if (size >= 0) {
                while (true) {
                    int i4 = size - 1;
                    if (Intrinsics.areEqual(q27.a(), y57Var.a.get(size).a()) || (y57Var.a.get(size).b() instanceof AdvertAppInfo)) {
                        break;
                    }
                    i3++;
                    if (i4 < 0) {
                        break;
                    }
                    size = i4;
                }
            }
            if (i3 <= h) {
                i = h - i3;
            }
            if (!ListUtils.isEmpty(list) && i >= 0 && h >= 1) {
                ListIterator<za7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i2 == i || (i2 > i && (i2 - i) % h == 0)) {
                        sra sraVar = new sra();
                        sraVar.n(true);
                        listIterator.add(new k27(new i27(sraVar, false, null, 6, null), q27.a()));
                    }
                    listIterator.next();
                    i2++;
                }
            }
        }
    }

    public final void i(List<AdMixFloor> list, List<za7<?>> list2) {
        boolean z;
        boolean z2;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            if (list != null && !list.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            int i = 0;
            for (AdMixFloor adMixFloor : list) {
                if (adMixFloor != null && (num = adMixFloor.ad_type) != null && num.intValue() == 2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Integer num2 = adMixFloor.floor_num;
                    Intrinsics.checkNotNullExpressionValue(num2, "mixFloor.floor_num");
                    int intValue = (num2.intValue() + i) - 1;
                    if (intValue >= 0 && intValue <= list2.size()) {
                        sra sraVar = new sra();
                        sraVar.n(true);
                        list2.add(new k27(new i27(sraVar, false, null, 6, null), q27.a()));
                        i++;
                    }
                }
            }
        }
    }

    public final void j(BannerList bannerList, List<za7<?>> list) {
        List<App> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bannerList, list) == null) {
            if (bannerList != null) {
                list2 = bannerList.app;
            } else {
                list2 = null;
            }
            if (list2 != null) {
                int i = 0;
                for (App app : bannerList.app) {
                    AdvertAppInfo advertAppInfo = new AdvertAppInfo();
                    advertAppInfo.l(app);
                    if (advertAppInfo.l == null) {
                        nea.h(advertAppInfo, 1, 100);
                    } else {
                        int h = advertAppInfo.h();
                        if (h != 0) {
                            nea.h(advertAppInfo, 1, h);
                        } else if (!advertAppInfo.e() || !d(advertAppInfo)) {
                            int i2 = advertAppInfo.position + i;
                            if (i2 >= 0 && list.size() >= i2) {
                                i++;
                                if (advertAppInfo.b()) {
                                    list.add(i2, new ab7(advertAppInfo, m27.c()));
                                } else {
                                    list.add(i2, new k27(advertAppInfo, m27.e(advertAppInfo.b, advertAppInfo.c)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
