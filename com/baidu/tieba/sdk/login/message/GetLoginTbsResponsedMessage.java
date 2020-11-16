package com.baidu.tieba.sdk.login.message;

import com.baidu.live.d;
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
            a dCr = com.baidu.tieba.sdk.login.a.dCo().dCr();
            a.C0843a c0843a = new a.C0843a();
            if (dCr != null) {
                c0843a.Rv(dCr.bduss);
                c0843a.Rt(dCr.userName);
                c0843a.Ru(dCr.nickName);
                c0843a.Rs(dCr.userId);
                c0843a.Rx(dCr.portrait);
                c0843a.IT(dCr.sex);
            }
            c0843a.IU(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0843a.Rw(optJSONObject.optString("tbs"));
            }
            AccountData dCw = c0843a.dCw();
            TbadkCoreApplication.setCurrentAccount(dCw, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            d.Aq().putString("ala_account_user_tbs", dCw.getTbs());
        }
    }
}
