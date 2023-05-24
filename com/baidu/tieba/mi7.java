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
/* loaded from: classes6.dex */
public class mi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, yq9 yq9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, yq9Var) != null) || yq9Var == null) {
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
        zq9 zq9Var = yq9Var.f;
        if (zq9Var != null) {
            h46.b(zq9Var.b, zq9Var.c, "1191003700000000", zq9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(yq9Var.d)) {
                str = yq9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = yq9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        rl7.a(tbPageContext, yq9Var.e);
    }

    public static void c(yq9 yq9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, yq9Var) != null) || yq9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", yq9Var.g);
        if (yq9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", yq9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        zq9 zq9Var = yq9Var.f;
        if (zq9Var != null) {
            str = zq9Var.c;
        } else {
            str = yq9Var.d;
        }
        zq9 zq9Var2 = yq9Var.f;
        if (zq9Var2 != null) {
            String str2 = zq9Var2.a;
        } else {
            String str3 = yq9Var.c;
        }
        statisticItem.param("obj_name", yq9Var.c);
        statisticItem.param("obj_param1", yq9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(yq9Var.i, 1));
    }

    public static void d(yq9 yq9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, yq9Var) != null) || yq9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", yq9Var.g);
        if (yq9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", yq9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        zq9 zq9Var = yq9Var.f;
        if (zq9Var != null) {
            str = zq9Var.c;
        } else {
            str = yq9Var.d;
        }
        zq9 zq9Var2 = yq9Var.f;
        if (zq9Var2 != null) {
            String str2 = zq9Var2.a;
        } else {
            String str3 = yq9Var.c;
        }
        statisticItem.param("obj_name", yq9Var.c);
        statisticItem.param("obj_param1", yq9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(yq9Var.i, 0));
    }
}
