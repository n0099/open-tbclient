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
            a cEx = com.baidu.tieba.sdk.login.a.cEu().cEx();
            a.C0601a c0601a = new a.C0601a();
            if (cEx != null) {
                c0601a.Is(cEx.bduss);
                c0601a.Iq(cEx.userName);
                c0601a.Ir(cEx.nickName);
                c0601a.Ip(cEx.userId);
                c0601a.Iu(cEx.portrait);
                c0601a.Bq(cEx.sex);
            }
            c0601a.Br(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0601a.It(optJSONObject.optString("tbs"));
            }
            AccountData cEC = c0601a.cEC();
            TbadkCoreApplication.setCurrentAccount(cEC, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.pr().putString("ala_account_user_tbs", cEC.getTbs());
        }
    }
}
