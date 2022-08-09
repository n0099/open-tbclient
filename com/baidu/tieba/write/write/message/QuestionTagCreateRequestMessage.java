package com.baidu.tieba.write.write.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class QuestionTagCreateRequestMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_FORUM_ID = "forum_id";
    public static final String KEY_NAME = "name";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionTagCreateRequestMessage() {
        super(CmdConfigHttp.CMD_QUESTION_THREAD_CREATE_TAG);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    public QuestionTagCreateRequestMessage setForumId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            addParam("forum_id", str);
            return this;
        }
        return (QuestionTagCreateRequestMessage) invokeL.objValue;
    }

    public QuestionTagCreateRequestMessage setName(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            addParam("name", str);
            return this;
        }
        return (QuestionTagCreateRequestMessage) invokeL.objValue;
    }
}
