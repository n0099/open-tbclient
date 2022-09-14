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
public class oy6 {
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
            return i == 0 || i == 11 || i == 40 || threadData.isUgcThreadType();
        }
        return invokeL.booleanValue;
    }

    public static void b(lq4 lq4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{lq4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) || lq4Var == null || lq4Var.getThreadData() == null || context == null) {
            return;
        }
        ThreadData threadData = lq4Var.getThreadData();
        PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
        createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
        createFromThreadCfg.setFrom("from_game_video");
        createFromThreadCfg.setForumName(threadData.getForum_name());
        createFromThreadCfg.setStartFrom(i);
        createFromThreadCfg.setVideoOriginArea(rect);
        if (lq4Var.getPbInputLocate() != null) {
            createFromThreadCfg.addLocateParam(lq4Var.getPbInputLocate());
        }
        if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
            createFromThreadCfg.setNeedPreLoad(true);
            rg6.update(threadData);
        }
        createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
        createFromThreadCfg.setJumpGodReply(z);
        g16.a(threadData.getTid());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
    }

    public static void c(c26 c26Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65538, null, c26Var, i) == null) || c26Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem w = c26Var.w("c13488", true);
        if (w != null) {
            if (c26Var.getThreadData() != null) {
                ThreadData threadData = c26Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().W() == null && threadData.getTopAgreePost().l0() == null)) {
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

    public static void d(c26 c26Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, c26Var, i) == null) || c26Var == null || c26Var.getThreadData() == null || !l26.R(c26Var.a) || (w = c26Var.w("c13494", true)) == null) {
            return;
        }
        w.param("obj_type", i);
        TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
        TiebaStatic.log(w);
    }

    public static void e(c26 c26Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, c26Var, i) == null) || c26Var == null || !l26.R(c26Var.a) || (w = c26Var.w("c13495", true)) == null) {
            return;
        }
        w.param("obj_type", i);
        TiebaStatic.log(w);
    }

    public static void f(c26 c26Var, int i) {
        StatisticItem w;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65541, null, c26Var, i) == null) || c26Var == null || c26Var.getThreadData() == null || (w = c26Var.w("c13496", true)) == null) {
            return;
        }
        w.param("obj_type", i);
        TiebaStatic.log(w);
    }
}
