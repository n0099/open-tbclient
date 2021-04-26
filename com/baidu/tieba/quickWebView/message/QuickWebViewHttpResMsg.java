package com.baidu.tieba.quickWebView.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
/* loaded from: classes3.dex */
public class QuickWebViewHttpResMsg extends TbHttpResponsedMessage {
    public String result;

    public QuickWebViewHttpResMsg() {
        super(CmdConfigHttp.CMD_WEB_HTTP_PROXY);
    }

    public static String quote(String str) {
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

    public String getResult() {
        return this.result;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        super.decodeInBackGround(i2, bArr);
        String parseToString = parseToString(bArr);
        this.result = parseToString;
        this.result = quote(parseToString);
    }
}
