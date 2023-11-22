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
public abstract class sh7<T> implements nh7<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract rh7 e(Object obj);

    public abstract List<LayoutFactory> f(Object obj);

    public sh7() {
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

    @Override // com.baidu.tieba.nh7
    public List<ab7<?>> c(Object originData, z57 feedData, Map<String, String> schemaLocalInfo, boolean z) {
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
                j87 j87Var = s67.a().get(layoutFactory.layout);
                boolean z2 = false;
                if (j87Var != null) {
                    if (j87Var instanceof da7) {
                        ((da7) j87Var).a(schemaLocalInfo);
                    }
                    if (j87Var instanceof q67) {
                        ((q67) j87Var).c(z);
                    }
                    if ((j87Var instanceof h87) && (originData instanceof DataRes)) {
                        h87 h87Var = (h87) j87Var;
                        DataRes dataRes = (DataRes) originData;
                        Integer num = dataRes.forum.is_like;
                        if (num != null && num.intValue() == 1) {
                            z2 = true;
                        }
                        h87Var.c(z2);
                        FrsBottom frsBottom = dataRes.frs_bottom;
                        if (frsBottom != null && (frsBottomSmartBgColor = frsBottom.frs_smart_bg_color) != null) {
                            str = frsBottomSmartBgColor.tag_color;
                        } else {
                            str = null;
                        }
                        if (str == null) {
                            str = "#FF2B87FF";
                        }
                        h87Var.d(str);
                    }
                    ab7<?> b = j87Var.b(layoutFactory);
                    if (b != null) {
                        arrayList.add(b);
                    }
                } else if (Intrinsics.areEqual("template_stub_head_card", layoutFactory.layout)) {
                    if ((originData instanceof DataRes) && (headerCard = ((DataRes) originData).header_card) != null) {
                        p6b p6bVar = new p6b();
                        p6bVar.f(headerCard);
                        if (v6b.p(p6bVar, false)) {
                            v6b v6bVar = new v6b();
                            v6bVar.n(2);
                            v6bVar.h(p6bVar);
                            arrayList.add(new bb7(v6bVar, "template_stub_head_card"));
                        }
                    }
                } else {
                    BdLog.e("no layout for " + layoutFactory.layout);
                }
            }
            rh7 e = e(originData);
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
                    oea.h(advertAppInfo, 1, 26);
                    return true;
                } else if (zqa.b(TbadkCoreApplication.getInst().getContext(), advertAppInfo.q) && tz5.a().o()) {
                    oea.h(advertAppInfo, 1, 3);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception unused) {
                oea.h(advertAppInfo, 1, 100);
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void g(z57 z57Var, List<ab7<?>> list, BannerList bannerList, int i, List<AdMixFloor> list2) {
        T t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{z57Var, list, bannerList, Integer.valueOf(i), list2}) == null) && i != -1) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (y58.d()) {
                            h(z57Var, list);
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
                h(z57Var, list);
                return;
            }
            j(bannerList, list);
        }
    }

    public final void h(z57 z57Var, List<ab7<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, z57Var, list) == null) {
            int h = r58.m().h();
            int i = r58.m().i() - 1;
            int size = z57Var.a.size() - 1;
            int i2 = 0;
            int i3 = 0;
            if (size >= 0) {
                while (true) {
                    int i4 = size - 1;
                    if (Intrinsics.areEqual(r27.a(), z57Var.a.get(size).a()) || (z57Var.a.get(size).b() instanceof AdvertAppInfo)) {
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
                ListIterator<ab7<?>> listIterator = list.listIterator();
                while (listIterator.hasNext()) {
                    if (i2 == i || (i2 > i && (i2 - i) % h == 0)) {
                        tra traVar = new tra();
                        traVar.n(true);
                        listIterator.add(new l27(new j27(traVar, false, null, 6, null), r27.a()));
                    }
                    listIterator.next();
                    i2++;
                }
            }
        }
    }

    public final void i(List<AdMixFloor> list, List<ab7<?>> list2) {
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
                        tra traVar = new tra();
                        traVar.n(true);
                        list2.add(new l27(new j27(traVar, false, null, 6, null), r27.a()));
                        i++;
                    }
                }
            }
        }
    }

    public final void j(BannerList bannerList, List<ab7<?>> list) {
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
                        oea.h(advertAppInfo, 1, 100);
                    } else {
                        int h = advertAppInfo.h();
                        if (h != 0) {
                            oea.h(advertAppInfo, 1, h);
                        } else if (!advertAppInfo.e() || !d(advertAppInfo)) {
                            int i2 = advertAppInfo.position + i;
                            if (i2 >= 0 && list.size() >= i2) {
                                i++;
                                if (advertAppInfo.b()) {
                                    list.add(i2, new bb7(advertAppInfo, n27.c()));
                                } else {
                                    list.add(i2, new l27(advertAppInfo, n27.e(advertAppInfo.b, advertAppInfo.c)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
