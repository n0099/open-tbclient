package com.baidu.tieba.sdk.login.message;

import com.baidu.live.d;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AccountData;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tieba.sdk.c.a;
import com.baidu.tieba.sdk.login.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
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
            a dFT = com.baidu.tieba.sdk.login.a.dFQ().dFT();
            a.C0863a c0863a = new a.C0863a();
            if (dFT != null) {
                c0863a.Sr(dFT.bduss);
                c0863a.Sp(dFT.userName);
                c0863a.Sq(dFT.nickName);
                c0863a.So(dFT.userId);
                c0863a.St(dFT.portrait);
                c0863a.Ir(dFT.sex);
            }
            c0863a.Is(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0863a.Ss(optJSONObject.optString("tbs"));
            }
            AccountData dFY = c0863a.dFY();
            TbadkCoreApplication.setCurrentAccount(dFY, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.xc().putString("ala_account_user_tbs", dFY.getTbs());
        }
    }
}
