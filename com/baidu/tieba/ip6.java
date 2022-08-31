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
/* loaded from: classes4.dex */
public class ip6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, nk8 nk8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, nk8Var) == null) || nk8Var == null) {
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
        ok8 ok8Var = nk8Var.f;
        if (ok8Var != null) {
            no5.b(ok8Var.b, ok8Var.c, "1191003700000000", ok8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(nk8Var.d)) {
                str = nk8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = nk8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        hr6.a(tbPageContext, nk8Var.e);
    }

    public static void c(nk8 nk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, nk8Var) == null) || nk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", nk8Var.g);
        statisticItem.param("obj_type", nk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", nk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ok8 ok8Var = nk8Var.f;
        String str = ok8Var != null ? ok8Var.c : nk8Var.d;
        ok8 ok8Var2 = nk8Var.f;
        if (ok8Var2 != null) {
            String str2 = ok8Var2.a;
        } else {
            String str3 = nk8Var.c;
        }
        statisticItem.param("obj_name", nk8Var.c);
        statisticItem.param("obj_param1", nk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(nk8Var.i, 1));
    }

    public static void d(nk8 nk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, nk8Var) == null) || nk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", nk8Var.g);
        statisticItem.param("obj_type", nk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", nk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ok8 ok8Var = nk8Var.f;
        String str = ok8Var != null ? ok8Var.c : nk8Var.d;
        ok8 ok8Var2 = nk8Var.f;
        if (ok8Var2 != null) {
            String str2 = ok8Var2.a;
        } else {
            String str3 = nk8Var.c;
        }
        statisticItem.param("obj_name", nk8Var.c);
        statisticItem.param("obj_param1", nk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(nk8Var.i, 0));
    }
}
