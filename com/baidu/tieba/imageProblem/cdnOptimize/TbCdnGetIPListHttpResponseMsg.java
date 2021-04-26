package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class TbCdnGetIPListHttpResponseMsg extends JsonHttpResponsedMessage {
    public TbCdnIpListData ipListData;

    public TbCdnGetIPListHttpResponseMsg(int i2) {
        super(i2);
        this.ipListData = new TbCdnIpListData();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.ipListData.parseJson(jSONObject);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }
}
