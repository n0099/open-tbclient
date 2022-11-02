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
public class vs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, go8 go8Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, go8Var) != null) || go8Var == null) {
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
        ho8 ho8Var = go8Var.f;
        if (ho8Var != null) {
            ct5.b(ho8Var.b, ho8Var.c, "1191003700000000", ho8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(go8Var.d)) {
                str = go8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = go8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        vu6.a(tbPageContext, go8Var.e);
    }

    public static void c(go8 go8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, go8Var) != null) || go8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", go8Var.g);
        if (go8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", go8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ho8 ho8Var = go8Var.f;
        if (ho8Var != null) {
            str = ho8Var.c;
        } else {
            str = go8Var.d;
        }
        ho8 ho8Var2 = go8Var.f;
        if (ho8Var2 != null) {
            String str2 = ho8Var2.a;
        } else {
            String str3 = go8Var.c;
        }
        statisticItem.param("obj_name", go8Var.c);
        statisticItem.param("obj_param1", go8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(go8Var.i, 1));
    }

    public static void d(go8 go8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, go8Var) != null) || go8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", go8Var.g);
        if (go8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", go8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ho8 ho8Var = go8Var.f;
        if (ho8Var != null) {
            str = ho8Var.c;
        } else {
            str = go8Var.d;
        }
        ho8 ho8Var2 = go8Var.f;
        if (ho8Var2 != null) {
            String str2 = ho8Var2.a;
        } else {
            String str3 = go8Var.c;
        }
        statisticItem.param("obj_name", go8Var.c);
        statisticItem.param("obj_param1", go8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(go8Var.i, 0));
    }
}
