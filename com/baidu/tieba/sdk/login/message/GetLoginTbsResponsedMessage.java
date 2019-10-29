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
            a chQ = com.baidu.tieba.sdk.login.a.chN().chQ();
            a.C0510a c0510a = new a.C0510a();
            if (chQ != null) {
                c0510a.Dh(chQ.bduss);
                c0510a.Df(chQ.userName);
                c0510a.Dg(chQ.nickName);
                c0510a.De(chQ.userId);
                c0510a.Dj(chQ.portrait);
                c0510a.yI(chQ.sex);
            }
            c0510a.yJ(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0510a.Di(optJSONObject.optString("tbs"));
            }
            AccountData chV = c0510a.chV();
            TbadkCoreApplication.setCurrentAccount(chV, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.np().putString("ala_account_user_tbs", chV.getTbs());
        }
    }
}
