package com.baidu.tieba.quickWebView.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class QuickWebViewHttpResMsg extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String result;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickWebViewHttpResMsg() {
        super(CmdConfigHttp.CMD_WEB_HTTP_PROXY);
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

    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.result;
        }
        return (String) invokeV.objValue;
    }

    public static String quote(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && str.length() != 0) {
                int length = str.length();
                StringBuilder sb = new StringBuilder(length + 4);
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt != '\f') {
                        if (charAt != '\r') {
                            if (charAt != '\"') {
                                if (charAt != '\'') {
                                    if (charAt != '/') {
                                        if (charAt != '\\') {
                                            switch (charAt) {
                                                case '\b':
                                                    sb.append("\\b");
                                                    continue;
                                                case '\t':
                                                    sb.append("\\t");
                                                    continue;
                                                case '\n':
                                                    sb.append("\\n");
                                                    continue;
                                                default:
                                                    if (charAt < ' ') {
                                                        String str2 = "000" + Integer.toHexString(charAt);
                                                        sb.append("\\u" + str2.substring(str2.length() - 4));
                                                        continue;
                                                    } else {
                                                        sb.append(charAt);
                                                        break;
                                                    }
                                            }
                                        }
                                    } else {
                                        sb.append('\\');
                                        sb.append(charAt);
                                    }
                                } else {
                                    sb.append("\\'");
                                }
                            }
                            sb.append('\\');
                            sb.append(charAt);
                        } else {
                            sb.append("\\r");
                        }
                    } else {
                        sb.append("\\f");
                    }
                }
                return sb.toString();
            }
            return "\"\"";
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.decodeInBackGround(i, bArr);
            String parseToString = parseToString(bArr);
            this.result = parseToString;
            this.result = quote(parseToString);
        }
    }
}
