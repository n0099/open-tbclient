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
            a dHC = com.baidu.tieba.sdk.login.a.dHz().dHC();
            a.C0858a c0858a = new a.C0858a();
            if (dHC != null) {
                c0858a.SJ(dHC.bduss);
                c0858a.SH(dHC.userName);
                c0858a.SI(dHC.nickName);
                c0858a.SG(dHC.userId);
                c0858a.SL(dHC.portrait);
                c0858a.JK(dHC.sex);
            }
            c0858a.JL(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0858a.SK(optJSONObject.optString("tbs"));
            }
            AccountData dHH = c0858a.dHH();
            TbadkCoreApplication.setCurrentAccount(dHH, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.BM().putString("ala_account_user_tbs", dHH.getTbs());
        }
    }
}
