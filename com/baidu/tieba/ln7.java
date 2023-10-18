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
/* loaded from: classes7.dex */
public class ln7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, vda vdaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, vdaVar) != null) || vdaVar == null) {
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
        wda wdaVar = vdaVar.f;
        if (wdaVar != null) {
            TbAiappsLaunchUtil.launch(wdaVar.b, wdaVar.c, "1191003700000000", wdaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(vdaVar.d)) {
                str = vdaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = vdaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        xq7.a(tbPageContext, vdaVar.e);
    }

    public static void c(vda vdaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, vdaVar) != null) || vdaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", vdaVar.g);
        if (vdaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", vdaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        wda wdaVar = vdaVar.f;
        if (wdaVar != null) {
            str = wdaVar.c;
        } else {
            str = vdaVar.d;
        }
        wda wdaVar2 = vdaVar.f;
        if (wdaVar2 != null) {
            String str2 = wdaVar2.a;
        } else {
            String str3 = vdaVar.c;
        }
        statisticItem.param("obj_name", vdaVar.c);
        statisticItem.param("obj_param1", vdaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(vdaVar.i, 1));
    }

    public static void d(vda vdaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, vdaVar) != null) || vdaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", vdaVar.g);
        if (vdaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", vdaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        wda wdaVar = vdaVar.f;
        if (wdaVar != null) {
            str = wdaVar.c;
        } else {
            str = vdaVar.d;
        }
        wda wdaVar2 = vdaVar.f;
        if (wdaVar2 != null) {
            String str2 = wdaVar2.a;
        } else {
            String str3 = vdaVar.c;
        }
        statisticItem.param("obj_name", vdaVar.c);
        statisticItem.param("obj_param1", vdaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(vdaVar.i, 0));
    }
}
