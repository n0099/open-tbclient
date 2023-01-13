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
public class vx6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, ow8 ow8Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, ow8Var) != null) || ow8Var == null) {
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
        pw8 pw8Var = ow8Var.f;
        if (pw8Var != null) {
            ev5.b(pw8Var.b, pw8Var.c, "1191003700000000", pw8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(ow8Var.d)) {
                str = ow8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = ow8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        xz6.a(tbPageContext, ow8Var.e);
    }

    public static void c(ow8 ow8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, ow8Var) != null) || ow8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", ow8Var.g);
        if (ow8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", ow8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        pw8 pw8Var = ow8Var.f;
        if (pw8Var != null) {
            str = pw8Var.c;
        } else {
            str = ow8Var.d;
        }
        pw8 pw8Var2 = ow8Var.f;
        if (pw8Var2 != null) {
            String str2 = pw8Var2.a;
        } else {
            String str3 = ow8Var.c;
        }
        statisticItem.param("obj_name", ow8Var.c);
        statisticItem.param("obj_param1", ow8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ow8Var.i, 1));
    }

    public static void d(ow8 ow8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ow8Var) != null) || ow8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", ow8Var.g);
        if (ow8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", ow8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        pw8 pw8Var = ow8Var.f;
        if (pw8Var != null) {
            str = pw8Var.c;
        } else {
            str = ow8Var.d;
        }
        pw8 pw8Var2 = ow8Var.f;
        if (pw8Var2 != null) {
            String str2 = pw8Var2.a;
        } else {
            String str3 = ow8Var.c;
        }
        statisticItem.param("obj_name", ow8Var.c);
        statisticItem.param("obj_param1", ow8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ow8Var.i, 0));
    }
}
