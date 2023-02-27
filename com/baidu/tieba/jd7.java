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
public class jd7 {
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

    public static void b(zx4 zx4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{zx4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && zx4Var != null && zx4Var.getThreadData() != null && context != null) {
            ThreadData threadData = zx4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (zx4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(zx4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                av6.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            jf6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(eg6 eg6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, eg6Var, i) != null) || eg6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem r = eg6Var.r("c13488", true);
        if (r != null) {
            if (eg6Var.getThreadData() != null) {
                ThreadData threadData = eg6Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().Z() == null && threadData.getTopAgreePost().q0() == null)) {
                    i2 = 0;
                }
                r.param("obj_name", i2);
                if (threadData.getAuthor() != null) {
                    r.param(TiebaStatic.Params.AB_TYPE, threadData.getAuthor().hadConcerned() ? 1 : 0);
                }
            }
            r.param("obj_type", i);
            TiebaStatic.log(r);
        }
    }

    public static void d(eg6 eg6Var, int i) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, eg6Var, i) == null) && eg6Var != null && eg6Var.getThreadData() != null && ng6.R(eg6Var.a) && (r = eg6Var.r("c13494", true)) != null) {
            r.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(r);
        }
    }

    public static void e(eg6 eg6Var, int i) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, eg6Var, i) == null) && eg6Var != null && ng6.R(eg6Var.a) && (r = eg6Var.r("c13495", true)) != null) {
            r.param("obj_type", i);
            TiebaStatic.log(r);
        }
    }

    public static void f(eg6 eg6Var, int i) {
        StatisticItem r;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, eg6Var, i) == null) && eg6Var != null && eg6Var.getThreadData() != null && (r = eg6Var.r("c13496", true)) != null) {
            r.param("obj_type", i);
            TiebaStatic.log(r);
        }
    }
}
