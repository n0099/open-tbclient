package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.c.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
            a dpC = com.baidu.tieba.sdk.login.a.dpz().dpC();
            a.C0796a c0796a = new a.C0796a();
            if (dpC != null) {
                c0796a.PT(dpC.bduss);
                c0796a.PR(dpC.userName);
                c0796a.PS(dpC.nickName);
                c0796a.PQ(dpC.userId);
                c0796a.PV(dpC.portrait);
                c0796a.GF(dpC.sex);
            }
            c0796a.GG(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0796a.PU(optJSONObject.optString("tbs"));
            }
            AccountData dpH = c0796a.dpH();
            TbadkCoreApplication.setCurrentAccount(dpH, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.AD().putString("ala_account_user_tbs", dpH.getTbs());
        }
    }
}
