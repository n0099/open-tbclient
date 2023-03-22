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
/* loaded from: classes6.dex */
public class tl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(sf6 sf6Var, StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, sf6Var, statisticItem) == null) && sf6Var != null && sf6Var.getThreadData() != null && statisticItem != null) {
            if (sf6Var.getThreadData().getBaijiahaoData() != null) {
                BaijiahaoData baijiahaoData = sf6Var.getThreadData().getBaijiahaoData();
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

    public static void c(hw4 hw4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{hw4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && hw4Var != null && hw4Var.getThreadData() != null && context != null) {
            ThreadData threadData = hw4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, "video_tab", 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_video_tab");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (hw4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(hw4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && b(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                fw6.update(threadData);
            }
            createFromThreadCfg.setVideo_source("video_tab");
            createFromThreadCfg.setJumpGodReply(z);
            xe6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void d(sf6 sf6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, sf6Var) == null) && sf6Var != null && (r = sf6Var.r("c13583", true)) != null) {
            a(sf6Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void e(sf6 sf6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sf6Var) == null) && sf6Var != null && (r = sf6Var.r("c13584", true)) != null) {
            a(sf6Var, r);
            r.param(TiebaStatic.Params.OBJ_FLOOR, sf6Var.position + 1);
            TiebaStatic.log(r);
        }
    }

    public static void f(sf6 sf6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, sf6Var) == null) && sf6Var != null && (r = sf6Var.r("c13585", true)) != null) {
            a(sf6Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void g(sf6 sf6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, sf6Var) == null) && sf6Var != null && (r = sf6Var.r("c13586", true)) != null) {
            a(sf6Var, r);
            TiebaStatic.log(r);
        }
    }

    public static void h(sf6 sf6Var) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, sf6Var) == null) && sf6Var != null && (r = sf6Var.r("c13587", true)) != null) {
            a(sf6Var, r);
            TiebaStatic.log(r);
        }
    }
}
