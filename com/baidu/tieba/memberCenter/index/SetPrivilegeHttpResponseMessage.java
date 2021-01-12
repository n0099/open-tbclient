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
        private String leb = null;
        private String lec = null;
        private String led = null;
        private boolean lee = false;

        public a() {
        }

        public void parserJson(JSONObject jSONObject) throws Exception {
            if (jSONObject != null) {
                this.errorCode = jSONObject.optInt("error_code");
                this.errorMsg = jSONObject.optString("error_msg");
                this.leb = jSONObject.optString("field_text");
                this.lec = jSONObject.optString("left_button");
                this.led = jSONObject.optString("right_button");
                if (this.errorCode == 0) {
                    if (StringUtils.isNull(this.leb)) {
                        this.lee = true;
                    } else {
                        this.lee = false;
                    }
                } else if (this.errorCode == 2270014) {
                    this.lee = false;
                } else {
                    this.lee = false;
                }
            }
        }
    }
}
