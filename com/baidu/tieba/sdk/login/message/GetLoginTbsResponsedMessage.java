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
            a cEU = com.baidu.tieba.sdk.login.a.cER().cEU();
            a.C0602a c0602a = new a.C0602a();
            if (cEU != null) {
                c0602a.It(cEU.bduss);
                c0602a.Ir(cEU.userName);
                c0602a.Is(cEU.nickName);
                c0602a.Iq(cEU.userId);
                c0602a.Iv(cEU.portrait);
                c0602a.By(cEU.sex);
            }
            c0602a.Bz(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0602a.Iu(optJSONObject.optString("tbs"));
            }
            AccountData cEZ = c0602a.cEZ();
            TbadkCoreApplication.setCurrentAccount(cEZ, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.pw().putString("ala_account_user_tbs", cEZ.getTbs());
        }
    }
}
