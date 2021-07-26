package com.baidu.tieba.memberCenter.memberprivilege;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.l.c;
import d.a.q0.v1.g.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseMemberPrivilegeMessage extends JsonHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseMemberPrivilegeMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, jSONObject) == null) {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                a aVar = new a();
                this.mData = aVar;
                aVar.a(jSONObject);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        a.e eVar;
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
            a aVar = this.mData;
            if (aVar == null || (eVar = aVar.f65832a) == null || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null || eVar == null || currentAccountObj.getID() == null || !currentAccountObj.getID().equals(eVar.f65846a)) {
                return;
            }
            a.b bVar = eVar.f65849d;
            if (bVar != null && bVar.f65839b > bVar.f65840c && !StringUtils.isNull(bVar.f65841d)) {
                currentAccountObj.setMemberIconUrl(bVar.f65841d);
            } else {
                currentAccountObj.setMemberIconUrl(null);
            }
            c.g(currentAccountObj);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
        }
    }
}
