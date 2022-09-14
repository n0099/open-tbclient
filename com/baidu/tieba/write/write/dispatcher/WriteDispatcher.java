package com.baidu.tieba.write.write.dispatcher;

import android.content.Context;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tieba.kf8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class WriteDispatcher implements kf8 {
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

    @Override // com.baidu.tieba.kf8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) || jSONObject == null || context == null) {
            return;
        }
        WriteActivityConfig statisticFrom = WriteActivityConfig.newInstance(context).setType(9).setTopicId(jSONObject.optString("topicId")).setFrom("topic_detail").setCallFrom("1").setEnableAudio(jSONObject.optInt("enabledSendVoiceThread") == 1).setStatisticFrom(jSONObject.optInt("entranceType"));
        statisticFrom.setTitle("#" + jSONObject.optString("topicName") + "#").send();
    }
}
