package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.b.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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
            a cCU = com.baidu.tieba.sdk.login.a.cCR().cCU();
            a.C0594a c0594a = new a.C0594a();
            if (cCU != null) {
                c0594a.Ie(cCU.bduss);
                c0594a.Ic(cCU.userName);
                c0594a.Id(cCU.nickName);
                c0594a.Ib(cCU.userId);
                c0594a.Ig(cCU.portrait);
                c0594a.Bh(cCU.sex);
            }
            c0594a.Bi(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0594a.If(optJSONObject.optString("tbs"));
            }
            AccountData cCZ = c0594a.cCZ();
            TbadkCoreApplication.setCurrentAccount(cCZ, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.oJ().putString("ala_account_user_tbs", cCZ.getTbs());
        }
    }
}
