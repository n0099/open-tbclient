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
            a dHu = com.baidu.tieba.sdk.login.a.dHr().dHu();
            a.C0875a c0875a = new a.C0875a();
            if (dHu != null) {
                c0875a.Sr(dHu.bduss);
                c0875a.Sp(dHu.userName);
                c0875a.Sq(dHu.nickName);
                c0875a.So(dHu.userId);
                c0875a.St(dHu.portrait);
                c0875a.JE(dHu.sex);
            }
            c0875a.JF(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0875a.Ss(optJSONObject.optString("tbs"));
            }
            AccountData dHz = c0875a.dHz();
            TbadkCoreApplication.setCurrentAccount(dHz, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.Ba().putString("ala_account_user_tbs", dHz.getTbs());
        }
    }
}
