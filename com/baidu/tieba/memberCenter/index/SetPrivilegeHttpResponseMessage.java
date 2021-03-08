package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    public class a {
        private int errorCode;
        private String errorMsg = null;
        private String loz = null;
        private String loA = null;
        private String loB = null;
        private boolean loC = false;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                this.loz = jSONObject.optString("field_text");
                this.loA = jSONObject.optString("left_button");
                this.loB = jSONObject.optString("right_button");
                if (this.errorCode == 0) {
                    if (StringUtils.isNull(this.loz)) {
                        this.loC = true;
                    } else {
                        this.loC = false;
                    }
                } else if (this.errorCode == 2270014) {
                    this.loC = false;
                } else {
                    this.loC = false;
                }
            }
        }
    }
}
