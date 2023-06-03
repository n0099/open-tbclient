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
/* loaded from: classes7.dex */
public class pn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, kx9 kx9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, kx9Var) != null) || kx9Var == null) {
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
        lx9 lx9Var = kx9Var.f;
        if (lx9Var != null) {
            l86.b(lx9Var.b, lx9Var.c, "1191003700000000", lx9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(kx9Var.d)) {
                str = kx9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = kx9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        uq7.a(tbPageContext, kx9Var.e);
    }

    public static void c(kx9 kx9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, kx9Var) != null) || kx9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", kx9Var.g);
        if (kx9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", kx9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        lx9 lx9Var = kx9Var.f;
        if (lx9Var != null) {
            str = lx9Var.c;
        } else {
            str = kx9Var.d;
        }
        lx9 lx9Var2 = kx9Var.f;
        if (lx9Var2 != null) {
            String str2 = lx9Var2.a;
        } else {
            String str3 = kx9Var.c;
        }
        statisticItem.param("obj_name", kx9Var.c);
        statisticItem.param("obj_param1", kx9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(kx9Var.i, 1));
    }

    public static void d(kx9 kx9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, kx9Var) != null) || kx9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", kx9Var.g);
        if (kx9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", kx9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        lx9 lx9Var = kx9Var.f;
        if (lx9Var != null) {
            str = lx9Var.c;
        } else {
            str = kx9Var.d;
        }
        lx9 lx9Var2 = kx9Var.f;
        if (lx9Var2 != null) {
            String str2 = lx9Var2.a;
        } else {
            String str3 = kx9Var.c;
        }
        statisticItem.param("obj_name", kx9Var.c);
        statisticItem.param("obj_param1", kx9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(kx9Var.i, 0));
    }
}
