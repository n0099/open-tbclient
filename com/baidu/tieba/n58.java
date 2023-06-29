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
/* loaded from: classes7.dex */
public class n58 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(yo6 yo6Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, yo6Var, statisticItem) == null) && yo6Var != null && yo6Var.getThreadData() != null && statisticItem != null) {
            if (yo6Var.getThreadData().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = yo6Var.getThreadData().getBaijiahaoData();
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

    public static void c(l15 l15Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{l15Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && l15Var != null && l15Var.getThreadData() != null && context != null) {
            ThreadData threadData = l15Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_video_tab");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (l15Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(l15Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                td7.update(threadData);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            co6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void d(yo6 yo6Var) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, yo6Var) == null) && yo6Var != null && (n = yo6Var.n("c13583", true)) != null) {
            a(yo6Var, n);
            TiebaStatic.log(n);
        }
    }

    public static void e(yo6 yo6Var) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yo6Var) == null) && yo6Var != null && (n = yo6Var.n("c13584", true)) != null) {
            a(yo6Var, n);
            n.param(TiebaStatic.Params.OBJ_FLOOR, yo6Var.position + 1);
            TiebaStatic.log(n);
        }
    }

    public static void f(yo6 yo6Var) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, yo6Var) == null) && yo6Var != null && (n = yo6Var.n("c13585", true)) != null) {
            a(yo6Var, n);
            TiebaStatic.log(n);
        }
    }

    public static void g(yo6 yo6Var) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, yo6Var) == null) && yo6Var != null && (n = yo6Var.n("c13586", true)) != null) {
            a(yo6Var, n);
            TiebaStatic.log(n);
        }
    }

    public static void h(yo6 yo6Var) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, yo6Var) == null) && yo6Var != null && (n = yo6Var.n("c13587", true)) != null) {
            a(yo6Var, n);
            TiebaStatic.log(n);
        }
    }
}
