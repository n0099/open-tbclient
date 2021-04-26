package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.i0.r.l.c;
import d.a.j0.r1.g.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseMemberPrivilegeMessage extends JsonHttpResponsedMessage {
    public a mData;

    public ResponseMemberPrivilegeMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
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
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        a.e eVar;
        AccountData currentAccountObj;
        super.afterDispatchInBackGround(i2, (int) bArr);
        a aVar = this.mData;
        if (aVar == null || (eVar = aVar.f59707a) == null || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null || eVar == null || currentAccountObj.getID() == null || !currentAccountObj.getID().equals(eVar.f59721a)) {
            return;
        }
        a.b bVar = eVar.f59724d;
        if (bVar != null && bVar.f59714b > bVar.f59715c && !StringUtils.isNull(bVar.f59716d)) {
            currentAccountObj.setMemberIconUrl(bVar.f59716d);
        } else {
            currentAccountObj.setMemberIconUrl(null);
        }
        c.g(currentAccountObj);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
    }
}
