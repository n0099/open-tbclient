package com.baidu.tieba.pb.pb.main;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class ApplyCopyThreadResponseMessage extends JsonHttpResponsedMessage {
    private int errorCode;
    private String errorMessage;
    private String success_remind;
    private String tid_typedesc;

    public String getTid() {
        return this.tid_typedesc;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getRemindMessage() {
        return this.success_remind;
    }

    public ApplyCopyThreadResponseMessage(int i) {
        super(i);
        this.errorCode = 0;
        this.errorMessage = null;
        this.tid_typedesc = null;
        this.success_remind = null;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (isSuccess()) {
            JSONObject optJSONObject = jSONObject.optJSONObject(BdStatsConstant.StatsType.ERROR);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                this.tid_typedesc = optJSONObject2.optString("tid_typedesc");
                this.success_remind = optJSONObject2.optString("success_remind");
            }
            if (optJSONObject != null) {
                this.errorCode = optJSONObject.optInt("errorno");
                this.errorMessage = optJSONObject.optString(BaseJsonData.TAG_ERRMSG);
            }
        }
    }
}
