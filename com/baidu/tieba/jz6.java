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
/* loaded from: classes4.dex */
public class jz6 {
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

    public static void b(ar4 ar4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{ar4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && ar4Var != null && ar4Var.getThreadData() != null && context != null) {
            ThreadData threadData = ar4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (ar4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(ar4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                lh6.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            a26.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(w26 w26Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, w26Var, i) != null) || w26Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem w = w26Var.w("c13488", true);
        if (w != null) {
            if (w26Var.getThreadData() != null) {
                ThreadData threadData = w26Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().X() == null && threadData.getTopAgreePost().m0() == null)) {
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

    public static void d(w26 w26Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, w26Var, i) == null) && w26Var != null && w26Var.getThreadData() != null && f36.R(w26Var.a) && (w = w26Var.w("c13494", true)) != null) {
            w.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(w);
        }
    }

    public static void e(w26 w26Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, w26Var, i) == null) && w26Var != null && f36.R(w26Var.a) && (w = w26Var.w("c13495", true)) != null) {
            w.param("obj_type", i);
            TiebaStatic.log(w);
        }
    }

    public static void f(w26 w26Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, w26Var, i) == null) && w26Var != null && w26Var.getThreadData() != null && (w = w26Var.w("c13496", true)) != null) {
            w.param("obj_type", i);
            TiebaStatic.log(w);
        }
    }
}
