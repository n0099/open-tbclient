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
/* loaded from: classes8.dex */
public class zn7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, hz9 hz9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, hz9Var) != null) || hz9Var == null) {
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
        iz9 iz9Var = hz9Var.f;
        if (iz9Var != null) {
            s86.b(iz9Var.b, iz9Var.c, "1191003700000000", iz9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(hz9Var.d)) {
                str = hz9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = hz9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        er7.a(tbPageContext, hz9Var.e);
    }

    public static void c(hz9 hz9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, hz9Var) != null) || hz9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", hz9Var.g);
        if (hz9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", hz9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        iz9 iz9Var = hz9Var.f;
        if (iz9Var != null) {
            str = iz9Var.c;
        } else {
            str = hz9Var.d;
        }
        iz9 iz9Var2 = hz9Var.f;
        if (iz9Var2 != null) {
            String str2 = iz9Var2.a;
        } else {
            String str3 = hz9Var.c;
        }
        statisticItem.param("obj_name", hz9Var.c);
        statisticItem.param("obj_param1", hz9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(hz9Var.i, 1));
    }

    public static void d(hz9 hz9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, hz9Var) != null) || hz9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", hz9Var.g);
        if (hz9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", hz9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        iz9 iz9Var = hz9Var.f;
        if (iz9Var != null) {
            str = iz9Var.c;
        } else {
            str = hz9Var.d;
        }
        iz9 iz9Var2 = hz9Var.f;
        if (iz9Var2 != null) {
            String str2 = iz9Var2.a;
        } else {
            String str3 = hz9Var.c;
        }
        statisticItem.param("obj_name", hz9Var.c);
        statisticItem.param("obj_param1", hz9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(hz9Var.i, 0));
    }
}
