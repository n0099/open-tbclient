package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.play.PlayStatisticsResponseMessage;
import com.baidu.tieba.tbadkCore.videoupload.VideoFinishResult;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948075638, "Lcom/baidu/tieba/pv9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948075638, "Lcom/baidu/tieba/pv9;");
                return;
            }
        }
        c();
        b();
    }

    public static void a(HttpMessage httpMessage, aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, httpMessage, aw9Var) == null) && httpMessage != null && aw9Var != null) {
            httpMessage.addParam("tid", aw9Var.c);
            httpMessage.addParam("fid", aw9Var.d);
            httpMessage.addParam(TiebaStatic.Params.OBJ_TO, aw9Var.g);
            httpMessage.addParam("obj_id", aw9Var.k);
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM3, aw9Var.h);
            httpMessage.addParam("obj_source", aw9Var.f);
            httpMessage.addParam("obj_locate", aw9Var.a);
            httpMessage.addParam("obj_param1", aw9Var.i);
            if (!StringUtils.isNull(aw9Var.n)) {
                httpMessage.addParam(TiebaStatic.Params.TOPIC_TYPE, aw9Var.n);
            }
            if (!StringUtils.isNull(aw9Var.p)) {
                httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, aw9Var.p);
            }
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_DURATION_STATISTICS);
            tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.PB_PLAY_STATISTICS_CMD, TbConfig.SERVER_ADDRESS + TbConfig.URL_PLAY_STATISTICS);
            tbHttpMessageTask.setResponsedClass(PlayStatisticsResponseMessage.class);
            tbHttpMessageTask.setIsNeedTbs(true);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public static void d(long j, String str, aw9 aw9Var, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), str, aw9Var, str2, Long.valueOf(j2)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS);
            httpMessage.addParam(TiebaStatic.Params.OBJ_DURATION, j);
            httpMessage.addParam("obj_type", str);
            httpMessage.addParam("playduration", j2);
            if (aw9Var != null) {
                httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, aw9Var.m);
            }
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            a(httpMessage, aw9Var);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void e(String str, String str2, String str3, aw9 aw9Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, aw9Var, Integer.valueOf(i)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
            httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, str);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            httpMessage.addParam("obj_type", str3);
            if (TbSingleton.getInstance().getPcdnConfigData() != null && TbSingleton.getInstance().getPcdnConfigData().c()) {
                httpMessage.addParam("pcdn_state", i);
            }
            a(httpMessage, aw9Var);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
