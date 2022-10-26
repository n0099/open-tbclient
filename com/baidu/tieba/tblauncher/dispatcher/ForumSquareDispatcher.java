package com.baidu.tieba.tblauncher.dispatcher;

import android.content.Context;
import android.net.Uri;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tieba.jg8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ForumSquareDispatcher implements jg8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String url = "com.baidu.tieba://unidispatch/forumsquare?";
    public transient /* synthetic */ FieldHolder $fh;

    public ForumSquareDispatcher() {
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

    @Override // com.baidu.tieba.jg8
    public void dispatch(JSONObject jSONObject, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) && jSONObject != null && context != null) {
            ForumSquareActivityConfig forumSquareActivityConfig = new ForumSquareActivityConfig(context);
            forumSquareActivityConfig.setUri(Uri.parse("com.baidu.tieba://unidispatch/forumsquare?tab_name=" + jSONObject.optString("tabName")));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, forumSquareActivityConfig));
        }
    }
}
