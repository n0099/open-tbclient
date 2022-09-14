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
public class sq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, bm8 bm8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, bm8Var) == null) || bm8Var == null) {
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
        cm8 cm8Var = bm8Var.f;
        if (cm8Var != null) {
            zq5.b(cm8Var.b, cm8Var.c, "1191003700000000", cm8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(bm8Var.d)) {
                str = bm8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = bm8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        ss6.a(tbPageContext, bm8Var.e);
    }

    public static void c(bm8 bm8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, bm8Var) == null) || bm8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", bm8Var.g);
        statisticItem.param("obj_type", bm8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", bm8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        cm8 cm8Var = bm8Var.f;
        String str = cm8Var != null ? cm8Var.c : bm8Var.d;
        cm8 cm8Var2 = bm8Var.f;
        if (cm8Var2 != null) {
            String str2 = cm8Var2.a;
        } else {
            String str3 = bm8Var.c;
        }
        statisticItem.param("obj_name", bm8Var.c);
        statisticItem.param("obj_param1", bm8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(bm8Var.i, 1));
    }

    public static void d(bm8 bm8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, bm8Var) == null) || bm8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", bm8Var.g);
        statisticItem.param("obj_type", bm8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", bm8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        cm8 cm8Var = bm8Var.f;
        String str = cm8Var != null ? cm8Var.c : bm8Var.d;
        cm8 cm8Var2 = bm8Var.f;
        if (cm8Var2 != null) {
            String str2 = cm8Var2.a;
        } else {
            String str3 = bm8Var.c;
        }
        statisticItem.param("obj_name", bm8Var.c);
        statisticItem.param("obj_param1", bm8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(bm8Var.i, 0));
    }
}
