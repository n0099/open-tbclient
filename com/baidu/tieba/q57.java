package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(c26 c26Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, c26Var, statisticItem) == null) || c26Var == null || c26Var.getThreadData() == null || statisticItem == null) {
            return;
        }
        if (c26Var.getThreadData().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = c26Var.getThreadData().getBaijiahaoData();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData.oriUgcVid);
            return;
        }
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
    }

    public static boolean b(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            return i == 0 || i == 11 || i == 40 || threadData.isUgcThreadType();
        }
        return invokeL.booleanValue;
    }

    public static void c(lq4 lq4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{lq4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || lq4Var == null || lq4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = lq4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_video_tab");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (lq4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(lq4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            rg6.update(threadData);
        }
        createFromThreadCfg.setVideo_source("video_tab");
        createFromThreadCfg.setJumpGodReply(z);
        g16.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void d(c26 c26Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, c26Var) == null) || c26Var == null || (w = c26Var.w("c13583", true)) == null) {
            return;
        }
        a(c26Var, w);
        TiebaStatic.log(w);
    }

    public static void e(c26 c26Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, c26Var) == null) || c26Var == null || (w = c26Var.w("c13584", true)) == null) {
            return;
        }
        a(c26Var, w);
        w.param(TiebaStatic.Params.OBJ_FLOOR, c26Var.position + 1);
        TiebaStatic.log(w);
    }

    public static void f(c26 c26Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, c26Var) == null) || c26Var == null || (w = c26Var.w("c13585", true)) == null) {
            return;
        }
        a(c26Var, w);
        TiebaStatic.log(w);
    }

    public static void g(c26 c26Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, c26Var) == null) || c26Var == null || (w = c26Var.w("c13586", true)) == null) {
            return;
        }
        a(c26Var, w);
        TiebaStatic.log(w);
    }

    public static void h(c26 c26Var) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, c26Var) == null) || c26Var == null || (w = c26Var.w("c13587", true)) == null) {
            return;
        }
        a(c26Var, w);
        TiebaStatic.log(w);
    }
}
