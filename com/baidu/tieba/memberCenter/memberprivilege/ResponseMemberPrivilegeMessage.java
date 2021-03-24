package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.h0.r.l.c;
import d.b.i0.q1.g.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
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
            a aVar = new a();
            this.mData = aVar;
            aVar.a(jSONObject);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        a.e eVar;
        AccountData currentAccountObj;
        super.afterDispatchInBackGround(i, (int) bArr);
        a aVar = this.mData;
        if (aVar == null || (eVar = aVar.f59439a) == null || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null || eVar == null || currentAccountObj.getID() == null || !currentAccountObj.getID().equals(eVar.f59453a)) {
            return;
        }
        a.b bVar = eVar.f59456d;
        if (bVar != null && bVar.f59446b > bVar.f59447c && !StringUtils.isNull(bVar.f59448d)) {
            currentAccountObj.setMemberIconUrl(bVar.f59448d);
        } else {
            currentAccountObj.setMemberIconUrl(null);
        }
        c.g(currentAccountObj);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
    }
}
