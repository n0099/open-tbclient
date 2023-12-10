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
/* loaded from: classes8.dex */
public class wda {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948268117, "Lcom/baidu/tieba/wda;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948268117, "Lcom/baidu/tieba/wda;");
                return;
            }
        }
        c();
        b();
    }

    public static void a(HttpMessage httpMessage, hea heaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, httpMessage, heaVar) == null) && httpMessage != null && heaVar != null) {
            httpMessage.addParam("tid", heaVar.c);
            httpMessage.addParam("fid", heaVar.d);
            httpMessage.addParam(TiebaStatic.Params.OBJ_TO, heaVar.g);
            httpMessage.addParam("obj_id", heaVar.k);
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM3, heaVar.h);
            httpMessage.addParam("obj_source", heaVar.f);
            httpMessage.addParam("obj_locate", heaVar.a);
            httpMessage.addParam("obj_param1", heaVar.i);
            if (!StringUtils.isNull(heaVar.n)) {
                httpMessage.addParam(TiebaStatic.Params.TOPIC_TYPE, heaVar.n);
            }
            if (!StringUtils.isNull(heaVar.p)) {
                httpMessage.addParam(TiebaStatic.Params.IS_VERTICAL, heaVar.p);
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

    public static void d(long j, String str, hea heaVar, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), str, heaVar, str2, Long.valueOf(j2)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_PLAY_DURATION_STATISTICS);
            httpMessage.addParam(TiebaStatic.Params.OBJ_DURATION, j);
            httpMessage.addParam("obj_type", str);
            httpMessage.addParam("playduration", j2);
            if (heaVar != null) {
                httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, heaVar.m);
            }
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            a(httpMessage, heaVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public static void e(String str, String str2, String str3, hea heaVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, str2, str3, heaVar, Integer.valueOf(i)}) == null) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.PB_PLAY_STATISTICS_CMD);
            httpMessage.addParam(VideoFinishResult.KEY_VIDEO_MD5, str);
            httpMessage.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            httpMessage.addParam(TiebaStatic.Params.OBJ_PARAM2, str2);
            httpMessage.addParam("obj_type", str3);
            if (TbSingleton.getInstance().getPcdnConfigData() != null && TbSingleton.getInstance().getPcdnConfigData().c()) {
                httpMessage.addParam("pcdn_state", i);
            }
            a(httpMessage, heaVar);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }
}
