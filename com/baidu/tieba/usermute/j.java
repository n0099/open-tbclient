package com.baidu.tieba.usermute;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.usermute.i;
import com.baidu.tieba.usermute.response.UserMuteCheckHttpResponsedMessage;
import com.baidu.tieba.usermute.response.UserMuteCheckSocketResponsedMessage;
import tbclient.UserMuteCheck.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ i dkK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, int i, int i2) {
        super(i, i2);
        this.dkK = iVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        i.a aVar;
        Object obj;
        i.a aVar2;
        Object obj2;
        if (responsedMessage instanceof UserMuteCheckSocketResponsedMessage) {
            UserMuteCheckSocketResponsedMessage userMuteCheckSocketResponsedMessage = (UserMuteCheckSocketResponsedMessage) responsedMessage;
            aVar2 = this.dkK.dkJ;
            DataRes result = userMuteCheckSocketResponsedMessage.getResult();
            int error = userMuteCheckSocketResponsedMessage.getError();
            String errorString = userMuteCheckSocketResponsedMessage.getErrorString();
            obj2 = this.dkK.mExtra;
            aVar2.a(result, error, errorString, obj2);
        }
        if (responsedMessage instanceof UserMuteCheckHttpResponsedMessage) {
            UserMuteCheckHttpResponsedMessage userMuteCheckHttpResponsedMessage = (UserMuteCheckHttpResponsedMessage) responsedMessage;
            aVar = this.dkK.dkJ;
            DataRes result2 = userMuteCheckHttpResponsedMessage.getResult();
            int error2 = userMuteCheckHttpResponsedMessage.getError();
            String errorString2 = userMuteCheckHttpResponsedMessage.getErrorString();
            obj = this.dkK.mExtra;
            aVar.a(result2, error2, errorString2, obj);
        }
    }
}
