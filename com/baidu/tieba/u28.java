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
/* loaded from: classes8.dex */
public class u28 {
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

    public static void b(t15 t15Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{t15Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && t15Var != null && t15Var.getThreadData() != null && context != null) {
            ThreadData threadData = t15Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (t15Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(t15Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                zh7.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            gp6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(cq6 cq6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, cq6Var, i) != null) || cq6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem n = cq6Var.n("c13488", true);
        if (n != null) {
            if (cq6Var.getThreadData() != null) {
                ThreadData threadData = cq6Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().e0() == null && threadData.getTopAgreePost().w0() == null)) {
                    i2 = 0;
                }
                n.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    n.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }

    public static void d(cq6 cq6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, cq6Var, i) == null) && cq6Var != null && cq6Var.getThreadData() != null && lq6.N(cq6Var.a) && (n = cq6Var.n("c13494", true)) != null) {
            n.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(n);
        }
    }

    public static void e(cq6 cq6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, cq6Var, i) == null) && cq6Var != null && lq6.N(cq6Var.a) && (n = cq6Var.n("c13495", true)) != null) {
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }

    public static void f(cq6 cq6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, cq6Var, i) == null) && cq6Var != null && cq6Var.getThreadData() != null && (n = cq6Var.n("c13496", true)) != null) {
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }
}
