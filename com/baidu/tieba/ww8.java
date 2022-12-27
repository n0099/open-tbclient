package com.baidu.tieba;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ww8 extends HttpMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ww8(MainTabActivity mainTabActivity) {
        super(CmdConfigHttp.CMD_HTTP_SHARE_CONTENT_TO_CHAT_GROUP);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(Message<?> message, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048576, this, message, str, z) == null) {
            int i = 4;
            if (message instanceof HttpMessage) {
                HttpMessage httpMessage = (HttpMessage) message;
                if (httpMessage.getParams() != null) {
                    Object obj = httpMessage.getParams().get(GroupInfoData.SHARE_KEY_TYPE);
                    if (obj instanceof String) {
                        i = rm9.b((String) obj, 4);
                    }
                }
            }
            hg7.a(str, z, i, 2, true);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
            return;
        }
        JsonHttpResponsedMessage jsonHttpResponsedMessage = (JsonHttpResponsedMessage) httpResponsedMessage;
        if (jsonHttpResponsedMessage.getError() != 0) {
            a(httpResponsedMessage.getOrginalMessage(), ld7.a(jsonHttpResponsedMessage.getError(), jsonHttpResponsedMessage.getErrorString()), false);
        } else {
            a(httpResponsedMessage.getOrginalMessage(), TbadkCoreApplication.getInst().getResources().getString(R.string.share_success), true);
        }
    }
}
