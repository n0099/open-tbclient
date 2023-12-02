package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, tva tvaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, tvaVar) != null) || tvaVar == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> tbPageContext = null;
        if (context instanceof BaseActivity) {
            tbPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        if (tbPageContext == null) {
            return;
        }
        uva uvaVar = tvaVar.f;
        if (uvaVar != null) {
            TbAiappsLaunchUtil.launch(uvaVar.b, uvaVar.c, "1191003700000000", uvaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(tvaVar.d)) {
                str = tvaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = tvaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        r68.a(tbPageContext, tvaVar.e);
    }

    public static void c(tva tvaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, tvaVar) != null) || tvaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", tvaVar.g);
        if (tvaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", tvaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        uva uvaVar = tvaVar.f;
        if (uvaVar != null) {
            str = uvaVar.c;
        } else {
            str = tvaVar.d;
        }
        uva uvaVar2 = tvaVar.f;
        if (uvaVar2 != null) {
            String str2 = uvaVar2.a;
        } else {
            String str3 = tvaVar.c;
        }
        statisticItem.param("obj_name", tvaVar.c);
        statisticItem.param("obj_param1", tvaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(tvaVar.i, 1));
    }

    public static void d(tva tvaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, tvaVar) != null) || tvaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", tvaVar.g);
        if (tvaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", tvaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        uva uvaVar = tvaVar.f;
        if (uvaVar != null) {
            str = uvaVar.c;
        } else {
            str = tvaVar.d;
        }
        uva uvaVar2 = tvaVar.f;
        if (uvaVar2 != null) {
            String str2 = uvaVar2.a;
        } else {
            String str3 = tvaVar.c;
        }
        statisticItem.param("obj_name", tvaVar.c);
        statisticItem.param("obj_param1", tvaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(tvaVar.i, 0));
    }
}
