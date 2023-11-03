package com.baidu.tieba.immessagecenter.mention.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.ReplyMeActivityConfig;
import com.baidu.tieba.immessagecenter.mention.reply.ReplyMeActivity;
import com.baidu.tieba.qha;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ReplyMeDispatcher implements qha {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ReplyMeDispatcher() {
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

    @Override // com.baidu.tieba.qha
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            String optString = jSONObject.optString(ReplyMeActivityConfig.KEY_NAV_TITLE);
            String optString2 = jSONObject.optString(ReplyMeActivityConfig.KEY_FROM);
            Intent intent = new Intent();
            intent.setClass(context, ReplyMeActivity.class);
            intent.putExtra(ReplyMeActivityConfig.KEY_NAV_TITLE, optString);
            intent.putExtra(ReplyMeActivityConfig.KEY_FROM, optString2);
            context.startActivity(intent);
        }
    }
}
