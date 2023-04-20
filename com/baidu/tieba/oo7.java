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
public class oo7 {
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

    public static void b(kw4 kw4Var, Context context, int i, boolean z, Rect rect) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{kw4Var, context, Integer.valueOf(i), Boolean.valueOf(z), rect}) == null) && kw4Var != null && kw4Var.getThreadData() != null && context != null) {
            ThreadData threadData = kw4Var.getThreadData();
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(context).createFromThreadCfg(threadData, null, ImageViewerConfig.FROM_GAME_VIDEO, 18003, true, false, false);
            createFromThreadCfg.setForumId(String.valueOf(threadData.getFid()));
            createFromThreadCfg.setFrom("from_game_video");
            createFromThreadCfg.setForumName(threadData.getForum_name());
            createFromThreadCfg.setStartFrom(i);
            createFromThreadCfg.setVideoOriginArea(rect);
            if (kw4Var.getPbInputLocate() != null) {
                createFromThreadCfg.addLocateParam(kw4Var.getPbInputLocate());
            }
            if (TbSingleton.getInstance().isPbPreloadSwitchOn() && a(threadData)) {
                createFromThreadCfg.setNeedPreLoad(true);
                a57.update(threadData);
            }
            createFromThreadCfg.setVideo_source(ImageViewerConfig.FROM_GAME_VIDEO);
            createFromThreadCfg.setJumpGodReply(z);
            kg6.a(threadData.getTid());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }

    public static void c(fh6 fh6Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65538, null, fh6Var, i) != null) || fh6Var == null) {
            return;
        }
        int i2 = 1;
        StatisticItem o = fh6Var.o("c13488", true);
        if (o != null) {
            if (fh6Var.getThreadData() != null) {
                ThreadData threadData = fh6Var.getThreadData();
                if (threadData.getTopAgreePost() == null || (threadData.getTopAgreePost().a0() == null && threadData.getTopAgreePost().r0() == null)) {
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

    public static void d(fh6 fh6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, fh6Var, i) == null) && fh6Var != null && fh6Var.getThreadData() != null && oh6.R(fh6Var.a) && (o = fh6Var.o("c13494", true)) != null) {
            o.param("obj_type", i);
            TbSingleton.getInstance().setCurrentClickTime(System.currentTimeMillis());
            TiebaStatic.log(o);
        }
    }

    public static void e(fh6 fh6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, fh6Var, i) == null) && fh6Var != null && oh6.R(fh6Var.a) && (o = fh6Var.o("c13495", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }

    public static void f(fh6 fh6Var, int i) {
        StatisticItem o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, fh6Var, i) == null) && fh6Var != null && fh6Var.getThreadData() != null && (o = fh6Var.o("c13496", true)) != null) {
            o.param("obj_type", i);
            TiebaStatic.log(o);
        }
    }
}
