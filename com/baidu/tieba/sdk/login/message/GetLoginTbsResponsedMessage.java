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
            a dFL = com.baidu.tieba.sdk.login.a.dFI().dFL();
            a.C0861a c0861a = new a.C0861a();
            if (dFL != null) {
                c0861a.Sf(dFL.bduss);
                c0861a.Sd(dFL.userName);
                c0861a.Se(dFL.nickName);
                c0861a.Sc(dFL.userId);
                c0861a.Sh(dFL.portrait);
                c0861a.Ir(dFL.sex);
            }
            c0861a.Is(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0861a.Sg(optJSONObject.optString("tbs"));
            }
            AccountData dFQ = c0861a.dFQ();
            TbadkCoreApplication.setCurrentAccount(dFQ, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.xc().putString("ala_account_user_tbs", dFQ.getTbs());
        }
    }
}
