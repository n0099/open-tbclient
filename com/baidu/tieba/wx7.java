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
public class wx7 {
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

    public static void b(i15 i15Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{i15Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && i15Var != null && i15Var.getThreadData() != null && context != null) {
            ThreadData threadData = i15Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (i15Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(i15Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                od7.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            xn6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(to6 to6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, to6Var, i) != null) || to6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem n = to6Var.n("c13488", true);
        if (n != null) {
            if (to6Var.getThreadData() != null) {
                ThreadData threadData = to6Var.getThreadData();
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

    public static void d(to6 to6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, to6Var, i) == null) && to6Var != null && to6Var.getThreadData() != null && cp6.P(to6Var.a) && (n = to6Var.n("c13494", true)) != null) {
            n.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(n);
        }
    }

    public static void e(to6 to6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, to6Var, i) == null) && to6Var != null && cp6.P(to6Var.a) && (n = to6Var.n("c13495", true)) != null) {
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }

    public static void f(to6 to6Var, int i) {
        StatisticItem n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, to6Var, i) == null) && to6Var != null && to6Var.getThreadData() != null && (n = to6Var.n("c13496", true)) != null) {
            n.param("obj_type", i);
            TiebaStatic.log(n);
        }
    }
}
