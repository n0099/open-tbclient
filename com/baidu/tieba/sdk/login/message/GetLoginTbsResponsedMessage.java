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
            a cCW = com.baidu.tieba.sdk.login.a.cCT().cCW();
            a.C0594a c0594a = new a.C0594a();
            if (cCW != null) {
                c0594a.Ie(cCW.bduss);
                c0594a.Ic(cCW.userName);
                c0594a.Id(cCW.nickName);
                c0594a.Ib(cCW.userId);
                c0594a.Ig(cCW.portrait);
                c0594a.Bh(cCW.sex);
            }
            c0594a.Bi(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0594a.If(optJSONObject.optString("tbs"));
            }
            AccountData cDb = c0594a.cDb();
            TbadkCoreApplication.setCurrentAccount(cDb, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.oJ().putString("ala_account_user_tbs", cDb.getTbs());
        }
    }
}
