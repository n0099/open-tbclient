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
            a dbc = com.baidu.tieba.sdk.login.a.daZ().dbc();
            a.C0733a c0733a = new a.C0733a();
            if (dbc != null) {
                c0733a.Mo(dbc.bduss);
                c0733a.Mm(dbc.userName);
                c0733a.Mn(dbc.nickName);
                c0733a.Ml(dbc.userId);
                c0733a.Mq(dbc.portrait);
                c0733a.DM(dbc.sex);
            }
            c0733a.DN(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0733a.Mp(optJSONObject.optString("tbs"));
            }
            AccountData dbh = c0733a.dbh();
            TbadkCoreApplication.setCurrentAccount(dbh, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.vf().putString("ala_account_user_tbs", dbh.getTbs());
        }
    }
}
