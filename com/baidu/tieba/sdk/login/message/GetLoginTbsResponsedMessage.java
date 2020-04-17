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
            a cPw = com.baidu.tieba.sdk.login.a.cPt().cPw();
            a.C0642a c0642a = new a.C0642a();
            if (cPw != null) {
                c0642a.JX(cPw.bduss);
                c0642a.JV(cPw.userName);
                c0642a.JW(cPw.nickName);
                c0642a.JU(cPw.userId);
                c0642a.JZ(cPw.portrait);
                c0642a.BY(cPw.sex);
            }
            c0642a.BZ(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0642a.JY(optJSONObject.optString("tbs"));
            }
            AccountData cPB = c0642a.cPB();
            TbadkCoreApplication.setCurrentAccount(cPB, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.tH().putString("ala_account_user_tbs", cPB.getTbs());
        }
    }
}
