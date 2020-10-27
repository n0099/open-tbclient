package com.baidu.tieba.sdk.login.message;

import com.baidu.live.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.c.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
            a dAl = com.baidu.tieba.sdk.login.a.dAi().dAl();
            a.C0826a c0826a = new a.C0826a();
            if (dAl != null) {
                c0826a.RG(dAl.bduss);
                c0826a.RE(dAl.userName);
                c0826a.RF(dAl.nickName);
                c0826a.RD(dAl.userId);
                c0826a.RI(dAl.portrait);
                c0826a.If(dAl.sex);
            }
            c0826a.Ig(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0826a.RH(optJSONObject.optString("tbs"));
            }
            AccountData dAq = c0826a.dAq();
            TbadkCoreApplication.setCurrentAccount(dAq, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.AZ().putString("ala_account_user_tbs", dAq.getTbs());
        }
    }
}
