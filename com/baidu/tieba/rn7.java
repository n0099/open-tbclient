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
public class rn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, px9 px9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, px9Var) != null) || px9Var == null) {
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
        qx9 qx9Var = px9Var.f;
        if (qx9Var != null) {
            n86.b(qx9Var.b, qx9Var.c, "1191003700000000", qx9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(px9Var.d)) {
                str = px9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = px9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        wq7.a(tbPageContext, px9Var.e);
    }

    public static void c(px9 px9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, px9Var) != null) || px9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", px9Var.g);
        if (px9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", px9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        qx9 qx9Var = px9Var.f;
        if (qx9Var != null) {
            str = qx9Var.c;
        } else {
            str = px9Var.d;
        }
        qx9 qx9Var2 = px9Var.f;
        if (qx9Var2 != null) {
            String str2 = qx9Var2.a;
        } else {
            String str3 = px9Var.c;
        }
        statisticItem.param("obj_name", px9Var.c);
        statisticItem.param("obj_param1", px9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(px9Var.i, 1));
    }

    public static void d(px9 px9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, px9Var) != null) || px9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", px9Var.g);
        if (px9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", px9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        qx9 qx9Var = px9Var.f;
        if (qx9Var != null) {
            str = qx9Var.c;
        } else {
            str = px9Var.d;
        }
        qx9 qx9Var2 = px9Var.f;
        if (qx9Var2 != null) {
            String str2 = qx9Var2.a;
        } else {
            String str3 = px9Var.c;
        }
        statisticItem.param("obj_name", px9Var.c);
        statisticItem.param("obj_param1", px9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(px9Var.i, 0));
    }
}
