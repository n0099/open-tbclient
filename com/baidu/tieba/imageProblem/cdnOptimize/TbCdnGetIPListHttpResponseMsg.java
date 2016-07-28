package com.baidu.tieba.imageProblem.cdnOptimize;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TbCdnGetIPListHttpResponseMsg extends JsonHttpResponsedMessage {
    public TbCdnIpListData ipListData;

    public TbCdnGetIPListHttpResponseMsg(int i) {
        super(i);
        this.ipListData = new TbCdnIpListData();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            try {
                this.ipListData.parseJson(jSONObject);
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }
}
