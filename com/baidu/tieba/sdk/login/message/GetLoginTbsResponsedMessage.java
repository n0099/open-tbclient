package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.c.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
            a cWN = com.baidu.tieba.sdk.login.a.cWK().cWN();
            a.C0717a c0717a = new a.C0717a();
            if (cWN != null) {
                c0717a.LN(cWN.bduss);
                c0717a.LL(cWN.userName);
                c0717a.LM(cWN.nickName);
                c0717a.LK(cWN.userId);
                c0717a.LP(cWN.portrait);
                c0717a.CK(cWN.sex);
            }
            c0717a.CL(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0717a.LO(optJSONObject.optString("tbs"));
            }
            AccountData cWS = c0717a.cWS();
            TbadkCoreApplication.setCurrentAccount(cWS, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.uN().putString("ala_account_user_tbs", cWS.getTbs());
        }
    }
}
