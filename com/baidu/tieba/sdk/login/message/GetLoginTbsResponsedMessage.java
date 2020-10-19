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
            a dxd = com.baidu.tieba.sdk.login.a.dxa().dxd();
            a.C0811a c0811a = new a.C0811a();
            if (dxd != null) {
                c0811a.Rh(dxd.bduss);
                c0811a.Rf(dxd.userName);
                c0811a.Rg(dxd.nickName);
                c0811a.Re(dxd.userId);
                c0811a.Rj(dxd.portrait);
                c0811a.HM(dxd.sex);
            }
            c0811a.HN(1);
            if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI)) != null) {
                c0811a.Ri(optJSONObject.optString("tbs"));
            }
            AccountData dxi = c0811a.dxi();
            TbadkCoreApplication.setCurrentAccount(dxi, TbadkCoreApplication.getInst().getApp().getApplicationContext());
            c.AZ().putString("ala_account_user_tbs", dxi.getTbs());
        }
    }
}
