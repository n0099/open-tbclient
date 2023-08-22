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
public class rr7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, gfa gfaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, gfaVar) != null) || gfaVar == null) {
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
        hfa hfaVar = gfaVar.f;
        if (hfaVar != null) {
            TbAiappsLaunchUtil.launch(hfaVar.b, hfaVar.c, "1191003700000000", hfaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(gfaVar.d)) {
                str = gfaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = gfaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        bv7.a(tbPageContext, gfaVar.e);
    }

    public static void c(gfa gfaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, gfaVar) != null) || gfaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", gfaVar.g);
        if (gfaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", gfaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        hfa hfaVar = gfaVar.f;
        if (hfaVar != null) {
            str = hfaVar.c;
        } else {
            str = gfaVar.d;
        }
        hfa hfaVar2 = gfaVar.f;
        if (hfaVar2 != null) {
            String str2 = hfaVar2.a;
        } else {
            String str3 = gfaVar.c;
        }
        statisticItem.param("obj_name", gfaVar.c);
        statisticItem.param("obj_param1", gfaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(gfaVar.i, 1));
    }

    public static void d(gfa gfaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, gfaVar) != null) || gfaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", gfaVar.g);
        if (gfaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", gfaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        hfa hfaVar = gfaVar.f;
        if (hfaVar != null) {
            str = hfaVar.c;
        } else {
            str = gfaVar.d;
        }
        hfa hfaVar2 = gfaVar.f;
        if (hfaVar2 != null) {
            String str2 = hfaVar2.a;
        } else {
            String str3 = gfaVar.c;
        }
        statisticItem.param("obj_name", gfaVar.c);
        statisticItem.param("obj_param1", gfaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(gfaVar.i, 0));
    }
}
