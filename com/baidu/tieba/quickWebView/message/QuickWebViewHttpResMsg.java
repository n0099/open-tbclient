package com.baidu.tieba.quickWebView.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String quote(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return "\"\"";
            }
            int length = str.length();
            StringBuilder sb = new StringBuilder(length + 4);
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '\f') {
                    sb.append("\\f");
                } else if (charAt != '\r') {
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
                                            if (charAt >= ' ') {
                                                sb.append(charAt);
                                                break;
                                            } else {
                                                String str2 = "000" + Integer.toHexString(charAt);
                                                sb.append("\\u" + str2.substring(str2.length() - 4));
                                                continue;
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
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.result : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.decodeInBackGround(i2, bArr);
            String parseToString = parseToString(bArr);
            this.result = parseToString;
            this.result = quote(parseToString);
        }
    }
}
