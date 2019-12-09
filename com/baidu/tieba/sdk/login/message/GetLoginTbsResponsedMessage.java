package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.b.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
            a chO = com.baidu.tieba.sdk.login.a.chL().chO();
            a.C0505a c0505a = new a.C0505a();
            if (chO != null) {
                c0505a.Dh(chO.bduss);
                c0505a.Df(chO.userName);
                c0505a.Dg(chO.nickName);
                c0505a.De(chO.userId);
                c0505a.Dj(chO.portrait);
                c0505a.yH(chO.sex);
            }
            c0505a.yI(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0505a.Di(optJSONObject.optString("tbs"));
            }
            AccountData chT = c0505a.chT();
            TbadkCoreApplication.setCurrentAccount(chT, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.np().putString("ala_account_user_tbs", chT.getTbs());
        }
    }
}
