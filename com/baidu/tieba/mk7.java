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
public class mk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(eg6 eg6Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, eg6Var, statisticItem) == null) && eg6Var != null && eg6Var.getThreadData() != null && statisticItem != null) {
            if (eg6Var.getThreadData().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = eg6Var.getThreadData().getBaijiahaoData();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 3);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData.oriUgcNid);
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData.oriUgcVid);
                return;
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, 1);
        }
    }

    public static boolean b(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadData)) == null) {
            if (threadData == null || threadData.isShareThread) {
                return false;
            }
            int i = threadData.threadType;
            if (i != 0 && i != 11 && i != 40 && !threadData.isUgcThreadType()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void c(zx4 zx4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{zx4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && zx4Var != null && zx4Var.getThreadData() != null && context != null) {
            ThreadData threadData = zx4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_video_tab");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (zx4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(zx4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                av6.update(threadData);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            jf6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void d(eg6 eg6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, eg6Var) == null) && eg6Var != null && (r = eg6Var.r("c13583", true)) != null) {
            a(eg6Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void e(eg6 eg6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, eg6Var) == null) && eg6Var != null && (r = eg6Var.r("c13584", true)) != null) {
            a(eg6Var, r);
            r.param(TiebaStatic.Params.OBJ_FLOOR, eg6Var.position + 1);
            TiebaStatic.log(r);
        }
    }

    public static void f(eg6 eg6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, eg6Var) == null) && eg6Var != null && (r = eg6Var.r("c13585", true)) != null) {
            a(eg6Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void g(eg6 eg6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, eg6Var) == null) && eg6Var != null && (r = eg6Var.r("c13586", true)) != null) {
            a(eg6Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void h(eg6 eg6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, eg6Var) == null) && eg6Var != null && (r = eg6Var.r("c13587", true)) != null) {
            a(eg6Var, r);
            TiebaStatic.log(r);
        }
    }
}
