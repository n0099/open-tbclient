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
public class yg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, vo9 vo9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, vo9Var) != null) || vo9Var == null) {
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
        wo9 wo9Var = vo9Var.f;
        if (wo9Var != null) {
            v26.b(wo9Var.b, wo9Var.c, "1191003700000000", wo9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(vo9Var.d)) {
                str = vo9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = vo9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        dk7.a(tbPageContext, vo9Var.e);
    }

    public static void c(vo9 vo9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, vo9Var) != null) || vo9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", vo9Var.g);
        if (vo9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", vo9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        wo9 wo9Var = vo9Var.f;
        if (wo9Var != null) {
            str = wo9Var.c;
        } else {
            str = vo9Var.d;
        }
        wo9 wo9Var2 = vo9Var.f;
        if (wo9Var2 != null) {
            String str2 = wo9Var2.a;
        } else {
            String str3 = vo9Var.c;
        }
        statisticItem.param("obj_name", vo9Var.c);
        statisticItem.param("obj_param1", vo9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(vo9Var.i, 1));
    }

    public static void d(vo9 vo9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, vo9Var) != null) || vo9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", vo9Var.g);
        if (vo9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", vo9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        wo9 wo9Var = vo9Var.f;
        if (wo9Var != null) {
            str = wo9Var.c;
        } else {
            str = vo9Var.d;
        }
        wo9 wo9Var2 = vo9Var.f;
        if (wo9Var2 != null) {
            String str2 = wo9Var2.a;
        } else {
            String str3 = vo9Var.c;
        }
        statisticItem.param("obj_name", vo9Var.c);
        statisticItem.param("obj_param1", vo9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(vo9Var.i, 0));
    }
}
