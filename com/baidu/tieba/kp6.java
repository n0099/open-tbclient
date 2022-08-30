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
public class kp6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, pk8 pk8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, pk8Var) == null) || pk8Var == null) {
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
        qk8 qk8Var = pk8Var.f;
        if (qk8Var != null) {
            po5.b(qk8Var.b, qk8Var.c, "1191003700000000", qk8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(pk8Var.d)) {
                str = pk8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = pk8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        jr6.a(tbPageContext, pk8Var.e);
    }

    public static void c(pk8 pk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, pk8Var) == null) || pk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", pk8Var.g);
        statisticItem.param("obj_type", pk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", pk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        qk8 qk8Var = pk8Var.f;
        String str = qk8Var != null ? qk8Var.c : pk8Var.d;
        qk8 qk8Var2 = pk8Var.f;
        if (qk8Var2 != null) {
            String str2 = qk8Var2.a;
        } else {
            String str3 = pk8Var.c;
        }
        statisticItem.param("obj_name", pk8Var.c);
        statisticItem.param("obj_param1", pk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(pk8Var.i, 1));
    }

    public static void d(pk8 pk8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, pk8Var) == null) || pk8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", pk8Var.g);
        statisticItem.param("obj_type", pk8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", pk8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        qk8 qk8Var = pk8Var.f;
        String str = qk8Var != null ? qk8Var.c : pk8Var.d;
        qk8 qk8Var2 = pk8Var.f;
        if (qk8Var2 != null) {
            String str2 = qk8Var2.a;
        } else {
            String str3 = pk8Var.c;
        }
        statisticItem.param("obj_name", pk8Var.c);
        statisticItem.param("obj_param1", pk8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(pk8Var.i, 0));
    }
}
