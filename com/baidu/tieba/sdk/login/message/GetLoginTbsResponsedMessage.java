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
            a dpF = com.baidu.tieba.sdk.login.a.dpC().dpF();
            a.C0796a c0796a = new a.C0796a();
            if (dpF != null) {
                c0796a.PT(dpF.bduss);
                c0796a.PR(dpF.userName);
                c0796a.PS(dpF.nickName);
                c0796a.PQ(dpF.userId);
                c0796a.PV(dpF.portrait);
                c0796a.GF(dpF.sex);
            }
            c0796a.GG(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0796a.PU(optJSONObject.optString("tbs"));
            }
            AccountData dpK = c0796a.dpK();
            TbadkCoreApplication.setCurrentAccount(dpK, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.AD().putString("ala_account_user_tbs", dpK.getTbs());
        }
    }
}
