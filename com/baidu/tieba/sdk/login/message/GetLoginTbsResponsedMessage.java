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
            a cPu = com.baidu.tieba.sdk.login.a.cPr().cPu();
            a.C0663a c0663a = new a.C0663a();
            if (cPu != null) {
                c0663a.Ka(cPu.bduss);
                c0663a.JY(cPu.userName);
                c0663a.JZ(cPu.nickName);
                c0663a.JX(cPu.userId);
                c0663a.Kc(cPu.portrait);
                c0663a.BY(cPu.sex);
            }
            c0663a.BZ(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0663a.Kb(optJSONObject.optString("tbs"));
            }
            AccountData cPz = c0663a.cPz();
            TbadkCoreApplication.setCurrentAccount(cPz, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.tG().putString("ala_account_user_tbs", cPz.getTbs());
        }
    }
}
