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
            a cPt = com.baidu.tieba.sdk.login.a.cPq().cPt();
            a.C0663a c0663a = new a.C0663a();
            if (cPt != null) {
                c0663a.Ka(cPt.bduss);
                c0663a.JY(cPt.userName);
                c0663a.JZ(cPt.nickName);
                c0663a.JX(cPt.userId);
                c0663a.Kc(cPt.portrait);
                c0663a.BY(cPt.sex);
            }
            c0663a.BZ(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0663a.Kb(optJSONObject.optString("tbs"));
            }
            AccountData cPy = c0663a.cPy();
            TbadkCoreApplication.setCurrentAccount(cPy, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.tG().putString("ala_account_user_tbs", cPy.getTbs());
        }
    }
}
