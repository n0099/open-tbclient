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
public class wp7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, yaa yaaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, yaaVar) != null) || yaaVar == null) {
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
        zaa zaaVar = yaaVar.f;
        if (zaaVar != null) {
            TbAiappsLaunchUtil.launch(zaaVar.b, zaaVar.c, "1191003700000000", zaaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(yaaVar.d)) {
                str = yaaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = yaaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        gt7.a(tbPageContext, yaaVar.e);
    }

    public static void c(yaa yaaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, yaaVar) != null) || yaaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", yaaVar.g);
        if (yaaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", yaaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        zaa zaaVar = yaaVar.f;
        if (zaaVar != null) {
            str = zaaVar.c;
        } else {
            str = yaaVar.d;
        }
        zaa zaaVar2 = yaaVar.f;
        if (zaaVar2 != null) {
            String str2 = zaaVar2.a;
        } else {
            String str3 = yaaVar.c;
        }
        statisticItem.param("obj_name", yaaVar.c);
        statisticItem.param("obj_param1", yaaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(yaaVar.i, 1));
    }

    public static void d(yaa yaaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, yaaVar) != null) || yaaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", yaaVar.g);
        if (yaaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", yaaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        zaa zaaVar = yaaVar.f;
        if (zaaVar != null) {
            str = zaaVar.c;
        } else {
            str = yaaVar.d;
        }
        zaa zaaVar2 = yaaVar.f;
        if (zaaVar2 != null) {
            String str2 = zaaVar2.a;
        } else {
            String str3 = yaaVar.c;
        }
        statisticItem.param("obj_name", yaaVar.c);
        statisticItem.param("obj_param1", yaaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(yaaVar.i, 0));
    }
}
