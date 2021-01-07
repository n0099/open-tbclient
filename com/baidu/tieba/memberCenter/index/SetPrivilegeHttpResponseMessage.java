package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class SetPrivilegeHttpResponseMessage extends JsonHttpResponsedMessage {
    public a resultData;

    public SetPrivilegeHttpResponseMessage() {
        super(1003152);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.resultData = new a();
            try {
                this.resultData.parserJson(jSONObject);
            } catch (Exception e) {
                this.resultData = null;
                BdLog.e(e.getMessage());
            }
        }
    }

    public a getResultData() {
        return this.resultData;
    }

    /* loaded from: classes9.dex */
    public class a {
        private int errorCode;
        private String errorMsg = null;
        private String liH = null;
        private String liI = null;
        private String liJ = null;
        private boolean liK = false;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                this.liH = jSONObject.optString("field_text");
                this.liI = jSONObject.optString("left_button");
                this.liJ = jSONObject.optString("right_button");
                if (this.errorCode == 0) {
                    if (StringUtils.isNull(this.liH)) {
                        this.liK = true;
                    } else {
                        this.liK = false;
                    }
                } else if (this.errorCode == 2270014) {
                    this.liK = false;
                } else {
                    this.liK = false;
                }
            }
        }
    }
}
