package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.task.TbSocketMessageTask;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.net.zan.ChosenPbZanHttpResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenPbZanSocketResponse;
import com.baidu.tieba.pb.chosen.net.zan.ChosenZanNetMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class kv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kv9() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
        b();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CHOSEN_PB_PRAISE, wva.a(TbConfig.FINE_PB_PRAISE, 309095));
            tbHttpMessageTask.setResponsedClass(ChosenPbZanHttpResponse.class);
            messageManager.registerTask(tbHttpMessageTask);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TbSocketMessageTask tbSocketMessageTask = new TbSocketMessageTask(309095);
            tbSocketMessageTask.setResponsedClass(ChosenPbZanSocketResponse.class);
            tbSocketMessageTask.setNeedAck(true);
            tbSocketMessageTask.setNeedCompress(false);
            MessageManager.getInstance().registerTask(tbSocketMessageTask);
        }
    }

    public void c(PbChosenActivity pbChosenActivity, long j, long j2, long j3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{pbChosenActivity, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i)}) == null) {
            ChosenZanNetMessage chosenZanNetMessage = new ChosenZanNetMessage();
            chosenZanNetMessage.setExcId(j);
            chosenZanNetMessage.setAction(i);
            chosenZanNetMessage.setThreadId(j2);
            chosenZanNetMessage.setPostId(j3);
            pbChosenActivity.sendMessage(chosenZanNetMessage);
        }
    }
}
