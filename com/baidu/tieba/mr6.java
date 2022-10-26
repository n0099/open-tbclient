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
/* loaded from: classes5.dex */
public class mr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, xm8 xm8Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, xm8Var) != null) || xm8Var == null) {
            return;
        }
        TbPageContext tbPageContext = null;
        if (context instanceof BaseActivity) {
            tbPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        if (tbPageContext == null) {
            return;
        }
        ym8 ym8Var = xm8Var.f;
        if (ym8Var != null) {
            tr5.b(ym8Var.b, ym8Var.c, "1191003700000000", ym8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(xm8Var.d)) {
                str = xm8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = xm8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        mt6.a(tbPageContext, xm8Var.e);
    }

    public static void c(xm8 xm8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, xm8Var) != null) || xm8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", xm8Var.g);
        if (xm8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", xm8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ym8 ym8Var = xm8Var.f;
        if (ym8Var != null) {
            str = ym8Var.c;
        } else {
            str = xm8Var.d;
        }
        ym8 ym8Var2 = xm8Var.f;
        if (ym8Var2 != null) {
            String str2 = ym8Var2.a;
        } else {
            String str3 = xm8Var.c;
        }
        statisticItem.param("obj_name", xm8Var.c);
        statisticItem.param("obj_param1", xm8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(xm8Var.i, 1));
    }

    public static void d(xm8 xm8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, xm8Var) != null) || xm8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", xm8Var.g);
        if (xm8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", xm8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ym8 ym8Var = xm8Var.f;
        if (ym8Var != null) {
            str = ym8Var.c;
        } else {
            str = xm8Var.d;
        }
        ym8 ym8Var2 = xm8Var.f;
        if (ym8Var2 != null) {
            String str2 = ym8Var2.a;
        } else {
            String str3 = xm8Var.c;
        }
        statisticItem.param("obj_name", xm8Var.c);
        statisticItem.param("obj_param1", xm8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(xm8Var.i, 0));
    }
}
