package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
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
            a dek = com.baidu.tieba.sdk.login.a.deh().dek();
            a.C0743a c0743a = new a.C0743a();
            if (dek != null) {
                c0743a.MW(dek.bduss);
                c0743a.MU(dek.userName);
                c0743a.MV(dek.nickName);
                c0743a.MT(dek.userId);
                c0743a.MY(dek.portrait);
                c0743a.Ei(dek.sex);
            }
            c0743a.Ej(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0743a.MX(optJSONObject.optString("tbs"));
            }
            AccountData dep = c0743a.dep();
            TbadkCoreApplication.setCurrentAccount(dep, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.vf().putString("ala_account_user_tbs", dep.getTbs());
        }
    }
}
