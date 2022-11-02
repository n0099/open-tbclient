package com.baidu.tieba;

import android.content.Context;
import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class s07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, threadData)) == null) {
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

    public static void b(rr4 rr4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{rr4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && rr4Var != null && rr4Var.getThreadData() != null && context != null) {
            ThreadData threadData = rr4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (rr4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(rr4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                vi6.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            k36.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(g46 g46Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, g46Var, i) != null) || g46Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem w = g46Var.w("c13488", true);
        if (w != null) {
            if (g46Var.getThreadData() != null) {
                ThreadData threadData = g46Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().X() == null && threadData.getTopAgreePost().n0() == null)) {
                    i2 = 0;
                }
                w.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    w.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            w.param("obj_type", i);
            TiebaStatic.log(w);
        }
    }

    public static void d(g46 g46Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, g46Var, i) == null) && g46Var != null && g46Var.getThreadData() != null && p46.R(g46Var.a) && (w = g46Var.w("c13494", true)) != null) {
            w.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(w);
        }
    }

    public static void e(g46 g46Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, g46Var, i) == null) && g46Var != null && p46.R(g46Var.a) && (w = g46Var.w("c13495", true)) != null) {
            w.param("obj_type", i);
            TiebaStatic.log(w);
        }
    }

    public static void f(g46 g46Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, g46Var, i) == null) && g46Var != null && g46Var.getThreadData() != null && (w = g46Var.w("c13496", true)) != null) {
            w.param("obj_type", i);
            TiebaStatic.log(w);
        }
    }
}
