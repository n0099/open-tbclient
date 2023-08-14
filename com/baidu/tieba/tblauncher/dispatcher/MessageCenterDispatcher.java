package com.baidu.tieba.tblauncher.dispatcher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.t1a;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class MessageCenterDispatcher implements t1a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String url = "com.baidu.tieba://unidispatch/messageCenter";
    public transient /* synthetic */ FieldHolder $fh;

    public MessageCenterDispatcher() {
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

    @Override // com.baidu.tieba.t1a
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            Intent intent = new Intent();
            Uri parse = Uri.parse(url);
            intent.setClass(context, MainTabActivity.class);
            intent.setData(parse);
            intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            intent.addFlags(603979776);
            context.startActivity(intent);
        }
    }
}
