package com.baidu.tieba.pb.pb.main;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class HideChudianPostResponseMessage extends JsonHttpResponsedMessage {
    private int errorCode;
    private String errorMessage;
    private int resultFlag;
    private long templateId;

    public int getResultFlag() {
        return this.resultFlag;
    }

    public long getTemplateId() {
        return this.templateId;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public HideChudianPostResponseMessage(int i) {
        super(i);
        this.errorCode = -1;
        this.errorMessage = null;
        this.resultFlag = -1;
        this.templateId = -1L;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            if (isSuccess()) {
                this.resultFlag = jSONObject.optInt(FrsActivityConfig.FLAG);
                this.templateId = jSONObject.optLong("template_id");
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMessage = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            }
        }
    }
}
