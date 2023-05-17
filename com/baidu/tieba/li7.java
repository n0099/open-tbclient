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
public class li7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, xq9 xq9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, xq9Var) != null) || xq9Var == null) {
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
        yq9 yq9Var = xq9Var.f;
        if (yq9Var != null) {
            h46.b(yq9Var.b, yq9Var.c, "1191003700000000", yq9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(xq9Var.d)) {
                str = xq9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = xq9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        ql7.a(tbPageContext, xq9Var.e);
    }

    public static void c(xq9 xq9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, xq9Var) != null) || xq9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", xq9Var.g);
        if (xq9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", xq9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        yq9 yq9Var = xq9Var.f;
        if (yq9Var != null) {
            str = yq9Var.c;
        } else {
            str = xq9Var.d;
        }
        yq9 yq9Var2 = xq9Var.f;
        if (yq9Var2 != null) {
            String str2 = yq9Var2.a;
        } else {
            String str3 = xq9Var.c;
        }
        statisticItem.param("obj_name", xq9Var.c);
        statisticItem.param("obj_param1", xq9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(xq9Var.i, 1));
    }

    public static void d(xq9 xq9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, xq9Var) != null) || xq9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", xq9Var.g);
        if (xq9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", xq9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        yq9 yq9Var = xq9Var.f;
        if (yq9Var != null) {
            str = yq9Var.c;
        } else {
            str = xq9Var.d;
        }
        yq9 yq9Var2 = xq9Var.f;
        if (yq9Var2 != null) {
            String str2 = yq9Var2.a;
        } else {
            String str3 = xq9Var.c;
        }
        statisticItem.param("obj_name", xq9Var.c);
        statisticItem.param("obj_param1", xq9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(xq9Var.i, 0));
    }
}
