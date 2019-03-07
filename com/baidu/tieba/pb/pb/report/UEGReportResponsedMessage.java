package com.baidu.tieba.pb.pb.report;

import android.text.TextUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class UEGReportResponsedMessage extends TbHttpResponsedMessage {
    private String url;

    public UEGReportResponsedMessage() {
        super(CmdConfigHttp.CMD_UEG_REPORT);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        String parseToString = parseToString(bArr);
        if (!TextUtils.isEmpty(parseToString)) {
            JSONObject jSONObject = new JSONObject(parseToString);
            setError(jSONObject.optInt("errno", -1));
            setErrorString(jSONObject.optString("errmsg"));
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.url = optJSONObject.optString("url");
            }
        }
    }

    public String getUrl() {
        return this.url;
    }
}
