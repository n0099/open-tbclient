package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.b.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
            a cBQ = com.baidu.tieba.sdk.login.a.cBN().cBQ();
            a.C0589a c0589a = new a.C0589a();
            if (cBQ != null) {
                c0589a.HU(cBQ.bduss);
                c0589a.HS(cBQ.userName);
                c0589a.HT(cBQ.nickName);
                c0589a.HR(cBQ.userId);
                c0589a.HW(cBQ.portrait);
                c0589a.Bc(cBQ.sex);
            }
            c0589a.Bd(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0589a.HV(optJSONObject.optString("tbs"));
            }
            AccountData cBV = c0589a.cBV();
            TbadkCoreApplication.setCurrentAccount(cBV, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.oI().putString("ala_account_user_tbs", cBV.getTbs());
        }
    }
}
