package com.baidu.tieba.quickWebView.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
/* loaded from: classes.dex */
public class QuickWebViewHttpResMsg extends TbHttpResponsedMessage {
    private String result;

    public String getResult() {
        return this.result;
    }

    public QuickWebViewHttpResMsg() {
        super(CmdConfigHttp.CMD_WEB_HTTP_PROXY);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        this.result = parseToString(bArr);
        this.result = quote(this.result);
    }

    public static String quote(String str) {
        if (str == null || str.length() == 0) {
            return "\"\"";
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 4);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                case '\\':
                    sb.append('\\');
                    sb.append(charAt);
                    break;
                case '\'':
                    sb.append("\\'");
                    break;
                case '/':
                    sb.append('\\');
                    sb.append(charAt);
                    break;
                default:
                    if (charAt < ' ') {
                        String str2 = "000" + Integer.toHexString(charAt);
                        sb.append("\\u" + str2.substring(str2.length() - 4));
                        break;
                    } else {
                        sb.append(charAt);
                        break;
                    }
            }
        }
        return sb.toString();
    }
}
