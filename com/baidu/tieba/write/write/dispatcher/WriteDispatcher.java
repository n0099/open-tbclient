package com.baidu.tieba.write.write.dispatcher;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tieba.ay8;
import com.baidu.tieba.kl9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WriteDispatcher implements ay8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WriteDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.ay8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            boolean z = true;
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) TbadkCoreApplication.getInst(), true)));
                return;
            }
            WriteActivityConfig newInstance = WriteActivityConfig.newInstance(context);
            if (!StringUtils.isNull(jSONObject.optString("dynamicThreadParams"))) {
                newInstance.setType(15).setCallFrom("2").setDynamicParams(jSONObject.optString("dynamicThreadParams")).setStatisticFrom(jSONObject.optInt("entranceType")).send();
            } else if (jSONObject.optInt("entranceType") == 1) {
                newInstance.setType(9).setCallFrom("2").setFrom("main_tab").setStatisticFrom(jSONObject.optInt("entranceType")).setFromArticle(kl9.m).send();
            } else {
                WriteActivityConfig callFrom = newInstance.setType(9).setTopicId(jSONObject.optString("topicId")).setFrom("topic_detail").setCallFrom("1");
                if (jSONObject.optInt("enabledSendVoiceThread") != 1) {
                    z = false;
                }
                WriteActivityConfig statisticFrom = callFrom.setEnableAudio(z).setStatisticFrom(jSONObject.optInt("entranceType"));
                statisticFrom.setTitle("#" + jSONObject.optString("topicName") + "#").send();
            }
        }
    }
}
