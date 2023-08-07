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
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, xaa xaaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, xaaVar) != null) || xaaVar == null) {
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
        yaa yaaVar = xaaVar.f;
        if (yaaVar != null) {
            TbAiappsLaunchUtil.launch(yaaVar.b, yaaVar.c, "1191003700000000", yaaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(xaaVar.d)) {
                str = xaaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = xaaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        ft7.a(tbPageContext, xaaVar.e);
    }

    public static void c(xaa xaaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, xaaVar) != null) || xaaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", xaaVar.g);
        if (xaaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", xaaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        yaa yaaVar = xaaVar.f;
        if (yaaVar != null) {
            str = yaaVar.c;
        } else {
            str = xaaVar.d;
        }
        yaa yaaVar2 = xaaVar.f;
        if (yaaVar2 != null) {
            String str2 = yaaVar2.a;
        } else {
            String str3 = xaaVar.c;
        }
        statisticItem.param("obj_name", xaaVar.c);
        statisticItem.param("obj_param1", xaaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(xaaVar.i, 1));
    }

    public static void d(xaa xaaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, xaaVar) != null) || xaaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", xaaVar.g);
        if (xaaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", xaaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        yaa yaaVar = xaaVar.f;
        if (yaaVar != null) {
            str = yaaVar.c;
        } else {
            str = xaaVar.d;
        }
        yaa yaaVar2 = xaaVar.f;
        if (yaaVar2 != null) {
            String str2 = yaaVar2.a;
        } else {
            String str3 = xaaVar.c;
        }
        statisticItem.param("obj_name", xaaVar.c);
        statisticItem.param("obj_param1", xaaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(xaaVar.i, 0));
    }
}
