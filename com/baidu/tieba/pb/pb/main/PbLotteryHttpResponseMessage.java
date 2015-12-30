package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.n;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class PbLotteryHttpResponseMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.pb.a.a mLotteryInfo;

    public PbLotteryHttpResponseMessage() {
        super(CmdConfigHttp.PB_LOTTERY_HTTP_CMD);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("award_info");
                if (optJSONObject != null) {
                    this.mLotteryInfo = new com.baidu.tieba.pb.a.a();
                    this.mLotteryInfo.parseJson(optJSONObject);
                    return;
                }
                return;
            } catch (Exception e) {
                BdLog.e(e.toString());
                return;
            }
        }
        setError(-1);
        setErrorString(TbadkCoreApplication.m411getInst().getString(n.j.lottery_failed));
    }

    public com.baidu.tieba.pb.a.a getLotteryInfo() {
        return this.mLotteryInfo;
    }
}
