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
            a dDC = com.baidu.tieba.sdk.login.a.dDz().dDC();
            a.C0858a c0858a = new a.C0858a();
            if (dDC != null) {
                c0858a.Rk(dDC.bduss);
                c0858a.Ri(dDC.userName);
                c0858a.Rj(dDC.nickName);
                c0858a.Rh(dDC.userId);
                c0858a.Rm(dDC.portrait);
                c0858a.HX(dDC.sex);
            }
            c0858a.HY(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0858a.Rl(optJSONObject.optString("tbs"));
            }
            AccountData dDH = c0858a.dDH();
            TbadkCoreApplication.setCurrentAccount(dDH, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.xf().putString("ala_account_user_tbs", dDH.getTbs());
        }
    }
}
