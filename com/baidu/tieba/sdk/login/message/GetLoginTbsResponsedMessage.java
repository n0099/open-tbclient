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
            a cWx = com.baidu.tieba.sdk.login.a.cWu().cWx();
            a.C0716a c0716a = new a.C0716a();
            if (cWx != null) {
                c0716a.LM(cWx.bduss);
                c0716a.LK(cWx.userName);
                c0716a.LL(cWx.nickName);
                c0716a.LJ(cWx.userId);
                c0716a.LO(cWx.portrait);
                c0716a.CI(cWx.sex);
            }
            c0716a.CJ(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0716a.LN(optJSONObject.optString("tbs"));
            }
            AccountData cWC = c0716a.cWC();
            TbadkCoreApplication.setCurrentAccount(cWC, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.uN().putString("ala_account_user_tbs", cWC.getTbs());
        }
    }
}
