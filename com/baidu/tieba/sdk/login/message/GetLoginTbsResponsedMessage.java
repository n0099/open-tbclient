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
            a dCN = com.baidu.tieba.sdk.login.a.dCK().dCN();
            a.C0841a c0841a = new a.C0841a();
            if (dCN != null) {
                c0841a.RX(dCN.bduss);
                c0841a.RV(dCN.userName);
                c0841a.RW(dCN.nickName);
                c0841a.RU(dCN.userId);
                c0841a.RZ(dCN.portrait);
                c0841a.Is(dCN.sex);
            }
            c0841a.It(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0841a.RY(optJSONObject.optString("tbs"));
            }
            AccountData dCS = c0841a.dCS();
            TbadkCoreApplication.setCurrentAccount(dCS, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.AZ().putString("ala_account_user_tbs", dCS.getTbs());
        }
    }
}
