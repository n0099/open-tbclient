package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.b.a;
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
            a cEz = com.baidu.tieba.sdk.login.a.cEw().cEz();
            a.C0601a c0601a = new a.C0601a();
            if (cEz != null) {
                c0601a.Is(cEz.bduss);
                c0601a.Iq(cEz.userName);
                c0601a.Ir(cEz.nickName);
                c0601a.Ip(cEz.userId);
                c0601a.Iu(cEz.portrait);
                c0601a.Bq(cEz.sex);
            }
            c0601a.Br(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0601a.It(optJSONObject.optString("tbs"));
            }
            AccountData cEE = c0601a.cEE();
            TbadkCoreApplication.setCurrentAccount(cEE, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.pr().putString("ala_account_user_tbs", cEE.getTbs());
        }
    }
}
