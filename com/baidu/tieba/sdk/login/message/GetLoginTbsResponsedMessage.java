package com.baidu.tieba.sdk.login.message;

import com.baidu.live.c;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.c.a;
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
            a dbd = com.baidu.tieba.sdk.login.a.dba().dbd();
            a.C0733a c0733a = new a.C0733a();
            if (dbd != null) {
                c0733a.Mo(dbd.bduss);
                c0733a.Mm(dbd.userName);
                c0733a.Mn(dbd.nickName);
                c0733a.Ml(dbd.userId);
                c0733a.Mq(dbd.portrait);
                c0733a.DM(dbd.sex);
            }
            c0733a.DN(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0733a.Mp(optJSONObject.optString("tbs"));
            }
            AccountData dbi = c0733a.dbi();
            TbadkCoreApplication.setCurrentAccount(dbi, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.vf().putString("ala_account_user_tbs", dbi.getTbs());
        }
    }
}
