package com.baidu.tieba.sdk.login.message;

import com.baidu.live.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.c.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
            a dGb = com.baidu.tieba.sdk.login.a.dFY().dGb();
            a.C0869a c0869a = new a.C0869a();
            if (dGb != null) {
                c0869a.Sx(dGb.bduss);
                c0869a.Sv(dGb.userName);
                c0869a.Sw(dGb.nickName);
                c0869a.Su(dGb.userId);
                c0869a.Sz(dGb.portrait);
                c0869a.Iv(dGb.sex);
            }
            c0869a.Iw(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0869a.Sy(optJSONObject.optString("tbs"));
            }
            AccountData dGg = c0869a.dGg();
            TbadkCoreApplication.setCurrentAccount(dGg, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.xf().putString("ala_account_user_tbs", dGg.getTbs());
        }
    }
}
