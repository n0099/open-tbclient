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
/* loaded from: classes9.dex */
public class xd8 {
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

    public static void b(fw4 fw4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{fw4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && fw4Var != null && fw4Var.getThreadData() != null && context != null) {
            ThreadData threadData = fw4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (fw4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(fw4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                hs7.e(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            xl6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(um6 um6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, um6Var, i) != null) || um6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem o = um6Var.o("c13488", true);
        if (o != null) {
            if (um6Var.getThreadData() != null) {
                ThreadData threadData = um6Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().f0() == null && threadData.getTopAgreePost().y0() == null)) {
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

    public static void d(um6 um6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, um6Var, i) == null) && um6Var != null && um6Var.getThreadData() != null && en6.L(um6Var.a) && (o = um6Var.o("c13494", true)) != null) {
            o.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(o);
        }
    }

    public static void e(um6 um6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, um6Var, i) == null) && um6Var != null && en6.L(um6Var.a) && (o = um6Var.o("c13495", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }

    public static void f(um6 um6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, um6Var, i) == null) && um6Var != null && um6Var.getThreadData() != null && (o = um6Var.o("c13496", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }
}
