package com.baidu.tieba.write.dispatcher;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.ShareFriendActivityConfig;
import com.baidu.tieba.to9;
import com.baidu.tieba.write.transmit.ShareFriendActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ShareFriendDispatcher implements to9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ShareFriendDispatcher() {
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

    @Override // com.baidu.tieba.to9
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            Intent intent = new Intent();
            intent.putExtra(ShareFriendActivityConfig.FROM_MESSAGE_TAB, true);
            intent.setClass(context, ShareFriendActivity.class);
            context.startActivity(intent);
        }
    }
}
