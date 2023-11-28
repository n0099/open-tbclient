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
public class v28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, uva uvaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, uvaVar) != null) || uvaVar == null) {
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
        vva vvaVar = uvaVar.f;
        if (vvaVar != null) {
            TbAiappsLaunchUtil.launch(vvaVar.b, vvaVar.c, "1191003700000000", vvaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(uvaVar.d)) {
                str = uvaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = uvaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        n68.a(tbPageContext, uvaVar.e);
    }

    public static void c(uva uvaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, uvaVar) != null) || uvaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", uvaVar.g);
        if (uvaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", uvaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        vva vvaVar = uvaVar.f;
        if (vvaVar != null) {
            str = vvaVar.c;
        } else {
            str = uvaVar.d;
        }
        vva vvaVar2 = uvaVar.f;
        if (vvaVar2 != null) {
            String str2 = vvaVar2.a;
        } else {
            String str3 = uvaVar.c;
        }
        statisticItem.param("obj_name", uvaVar.c);
        statisticItem.param("obj_param1", uvaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(uvaVar.i, 1));
    }

    public static void d(uva uvaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, uvaVar) != null) || uvaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", uvaVar.g);
        if (uvaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", uvaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        vva vvaVar = uvaVar.f;
        if (vvaVar != null) {
            str = vvaVar.c;
        } else {
            str = uvaVar.d;
        }
        vva vvaVar2 = uvaVar.f;
        if (vvaVar2 != null) {
            String str2 = vvaVar2.a;
        } else {
            String str3 = uvaVar.c;
        }
        statisticItem.param("obj_name", uvaVar.c);
        statisticItem.param("obj_param1", uvaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(uvaVar.i, 0));
    }
}
