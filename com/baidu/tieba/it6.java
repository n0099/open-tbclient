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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class it6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, so8 so8Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, so8Var) != null) || so8Var == null) {
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
        to8 to8Var = so8Var.f;
        if (to8Var != null) {
            pt5.b(to8Var.b, to8Var.c, "1191003700000000", to8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(so8Var.d)) {
                str = so8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = so8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        hv6.a(tbPageContext, so8Var.e);
    }

    public static void c(so8 so8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, so8Var) != null) || so8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", so8Var.g);
        if (so8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", so8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        to8 to8Var = so8Var.f;
        if (to8Var != null) {
            str = to8Var.c;
        } else {
            str = so8Var.d;
        }
        to8 to8Var2 = so8Var.f;
        if (to8Var2 != null) {
            String str2 = to8Var2.a;
        } else {
            String str3 = so8Var.c;
        }
        statisticItem.param("obj_name", so8Var.c);
        statisticItem.param("obj_param1", so8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(so8Var.i, 1));
    }

    public static void d(so8 so8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, so8Var) != null) || so8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", so8Var.g);
        if (so8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", so8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        to8 to8Var = so8Var.f;
        if (to8Var != null) {
            str = to8Var.c;
        } else {
            str = so8Var.d;
        }
        to8 to8Var2 = so8Var.f;
        if (to8Var2 != null) {
            String str2 = to8Var2.a;
        } else {
            String str3 = so8Var.c;
        }
        statisticItem.param("obj_name", so8Var.c);
        statisticItem.param("obj_param1", so8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(so8Var.i, 0));
    }
}
