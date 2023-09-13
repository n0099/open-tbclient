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
/* loaded from: classes7.dex */
public class o38 {
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

    public static void b(b15 b15Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{b15Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && b15Var != null && b15Var.getThreadData() != null && context != null) {
            ThreadData threadData = b15Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (b15Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(b15Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                gi7.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            xo6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(up6 up6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, up6Var, i) != null) || up6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem o = up6Var.o("c13488", true);
        if (o != null) {
            if (up6Var.getThreadData() != null) {
                ThreadData threadData = up6Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().f0() == null && threadData.getTopAgreePost().x0() == null)) {
                    i2 = 0;
                }
                o.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    o.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }

    public static void d(up6 up6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, up6Var, i) == null) && up6Var != null && up6Var.getThreadData() != null && dq6.L(up6Var.a) && (o = up6Var.o("c13494", true)) != null) {
            o.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(o);
        }
    }

    public static void e(up6 up6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, up6Var, i) == null) && up6Var != null && dq6.L(up6Var.a) && (o = up6Var.o("c13495", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }

    public static void f(up6 up6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, up6Var, i) == null) && up6Var != null && up6Var.getThreadData() != null && (o = up6Var.o("c13496", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }
}
