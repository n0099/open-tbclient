package com.baidu.tieba.sdk.login.message;

import com.baidu.live.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.c.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetLoginTbsResponsedMessage extends JsonHttpResponsedMessage {
    public GetLoginTbsResponsedMessage() {
        super(1003402);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            a dHt = com.baidu.tieba.sdk.login.a.dHq().dHt();
            a.C0842a c0842a = new a.C0842a();
            if (dHt != null) {
                c0842a.Ss(dHt.bduss);
                c0842a.Sq(dHt.userName);
                c0842a.Sr(dHt.nickName);
                c0842a.Sp(dHt.userId);
                c0842a.Su(dHt.portrait);
                c0842a.JE(dHt.sex);
            }
            c0842a.JF(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0842a.St(optJSONObject.optString("tbs"));
            }
            AccountData dHy = c0842a.dHy();
            TbadkCoreApplication.setCurrentAccount(dHy, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.Ba().putString("ala_account_user_tbs", dHy.getTbs());
        }
    }
}
