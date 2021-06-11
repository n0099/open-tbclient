package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SetPrivilegeHttpResponseMessage extends JsonHttpResponsedMessage {
    public a resultData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f18322a;

        /* renamed from: b  reason: collision with root package name */
        public String f18323b = null;

        public a(SetPrivilegeHttpResponseMessage setPrivilegeHttpResponseMessage) {
        }

        public void a(JSONObject jSONObject) throws Exception {
            if (jSONObject == null) {
                return;
            }
            this.f18322a = jSONObject.optInt("error_code");
            jSONObject.optString("error_msg");
            this.f18323b = jSONObject.optString("field_text");
            jSONObject.optString("left_button");
            jSONObject.optString("right_button");
            if (this.f18322a == 0) {
                StringUtils.isNull(this.f18323b);
            }
        }
    }

    public SetPrivilegeHttpResponseMessage() {
        super(CmdConfigHttp.CMD_SET_PRIVILEGE);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        a aVar = new a(this);
        this.resultData = aVar;
        try {
            aVar.a(jSONObject);
        } catch (Exception e2) {
            this.resultData = null;
            BdLog.e(e2.getMessage());
        }
    }

    public a getResultData() {
        return this.resultData;
    }
}
