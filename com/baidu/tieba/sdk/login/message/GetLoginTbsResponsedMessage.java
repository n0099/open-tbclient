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
            a dts = com.baidu.tieba.sdk.login.a.dtp().dts();
            a.C0793a c0793a = new a.C0793a();
            if (dts != null) {
                c0793a.Qt(dts.bduss);
                c0793a.Qr(dts.userName);
                c0793a.Qs(dts.nickName);
                c0793a.Qq(dts.userId);
                c0793a.Qv(dts.portrait);
                c0793a.Hg(dts.sex);
            }
            c0793a.Hh(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0793a.Qu(optJSONObject.optString("tbs"));
            }
            AccountData dtx = c0793a.dtx();
            TbadkCoreApplication.setCurrentAccount(dtx, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.AR().putString("ala_account_user_tbs", dtx.getTbs());
        }
    }
}
