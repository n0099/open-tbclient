package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.memberCenter.memberprivilege.a;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class ResponseMemberPrivilegeMessage extends JsonHttpResponsedMessage {
    public a mData;

    public ResponseMemberPrivilegeMessage(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mData = new a();
            this.mData.parseJson(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        super.afterDispatchInBackGround(i, (int) bArr);
        if (this.mData != null && this.mData.lro != null) {
            a.e eVar = this.mData.lro;
            AccountData currentAccountObj = TbadkApplication.getCurrentAccountObj();
            if (currentAccountObj != null && eVar != null && currentAccountObj.getID() != null && currentAccountObj.getID().equals(eVar.mId)) {
                a.b bVar = eVar.lrz;
                if (bVar != null && bVar.lrr > bVar.lrs && !StringUtils.isNull(bVar.lrt)) {
                    currentAccountObj.setMemberIconUrl(bVar.lrt);
                } else {
                    currentAccountObj.setMemberIconUrl(null);
                }
                com.baidu.tbadk.core.a.b.b(currentAccountObj);
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_INFO_CHANGED));
            }
        }
    }
}
