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
public class ns7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, eca ecaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, ecaVar) != null) || ecaVar == null) {
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
        fca fcaVar = ecaVar.f;
        if (fcaVar != null) {
            ba6.b(fcaVar.b, fcaVar.c, "1191003700000000", fcaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(ecaVar.d)) {
                str = ecaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = ecaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        xv7.a(tbPageContext, ecaVar.e);
    }

    public static void c(eca ecaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, ecaVar) != null) || ecaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", ecaVar.g);
        if (ecaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", ecaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        fca fcaVar = ecaVar.f;
        if (fcaVar != null) {
            str = fcaVar.c;
        } else {
            str = ecaVar.d;
        }
        fca fcaVar2 = ecaVar.f;
        if (fcaVar2 != null) {
            String str2 = fcaVar2.a;
        } else {
            String str3 = ecaVar.c;
        }
        statisticItem.param("obj_name", ecaVar.c);
        statisticItem.param("obj_param1", ecaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ecaVar.i, 1));
    }

    public static void d(eca ecaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ecaVar) != null) || ecaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", ecaVar.g);
        if (ecaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", ecaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        fca fcaVar = ecaVar.f;
        if (fcaVar != null) {
            str = fcaVar.c;
        } else {
            str = ecaVar.d;
        }
        fca fcaVar2 = ecaVar.f;
        if (fcaVar2 != null) {
            String str2 = fcaVar2.a;
        } else {
            String str3 = ecaVar.c;
        }
        statisticItem.param("obj_name", ecaVar.c);
        statisticItem.param("obj_param1", ecaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ecaVar.i, 0));
    }
}
