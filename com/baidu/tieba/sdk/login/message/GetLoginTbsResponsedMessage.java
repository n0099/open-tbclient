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
            a dHD = com.baidu.tieba.sdk.login.a.dHA().dHD();
            a.C0858a c0858a = new a.C0858a();
            if (dHD != null) {
                c0858a.SJ(dHD.bduss);
                c0858a.SH(dHD.userName);
                c0858a.SI(dHD.nickName);
                c0858a.SG(dHD.userId);
                c0858a.SL(dHD.portrait);
                c0858a.JK(dHD.sex);
            }
            c0858a.JL(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0858a.SK(optJSONObject.optString("tbs"));
            }
            AccountData dHI = c0858a.dHI();
            TbadkCoreApplication.setCurrentAccount(dHI, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.BM().putString("ala_account_user_tbs", dHI.getTbs());
        }
    }
}
