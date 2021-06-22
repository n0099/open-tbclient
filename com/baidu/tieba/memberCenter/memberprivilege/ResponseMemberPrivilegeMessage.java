package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.r.l.c;
import d.a.o0.s1.g.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
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
        if (aVar == null || (eVar = aVar.f64391a) == null || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null || eVar == null || currentAccountObj.getID() == null || !currentAccountObj.getID().equals(eVar.f64405a)) {
            return;
        }
        a.b bVar = eVar.f64408d;
        if (bVar != null && bVar.f64398b > bVar.f64399c && !StringUtils.isNull(bVar.f64400d)) {
            currentAccountObj.setMemberIconUrl(bVar.f64400d);
        } else {
            currentAccountObj.setMemberIconUrl(null);
        }
        c.g(currentAccountObj);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
    }
}
