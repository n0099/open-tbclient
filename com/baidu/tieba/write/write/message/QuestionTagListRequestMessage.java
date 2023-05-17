package com.baidu.tieba.write.write.message;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class QuestionTagListRequestMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CATEGORY = "first_category";
    public static final String KEY_NUM = "rn";
    public static final String KEY_PAGE = "pn";
    public static final String KEY_SEARCH_WORDS = "search_words";
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuestionTagListRequestMessage() {
        super(CmdConfigHttp.CMD_QUESTION_THREAD_TAG_LIST);
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
        addParam("rn", 50);
    }

    public QuestionTagListRequestMessage setCategory(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null) {
                str = "";
            }
            addParam(KEY_CATEGORY, str);
            return this;
        }
        return (QuestionTagListRequestMessage) invokeL.objValue;
    }

    public QuestionTagListRequestMessage setPage(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            addParam("pn", i);
            return this;
        }
        return (QuestionTagListRequestMessage) invokeI.objValue;
    }

    public QuestionTagListRequestMessage setSearchWords(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                addParam(KEY_SEARCH_WORDS, str);
            }
            return this;
        }
        return (QuestionTagListRequestMessage) invokeL.objValue;
    }
}
