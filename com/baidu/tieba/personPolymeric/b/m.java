package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ h ePZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h hVar, int i) {
        super(i);
        this.ePZ = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        String errorString;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
            if (StringUtils.isNull(socketResponsedMessage.getErrorString())) {
                tbPageContext2 = this.ePZ.GO;
                errorString = tbPageContext2.getResources().getString(r.j.neterror);
            } else {
                errorString = socketResponsedMessage.getErrorString();
            }
            tbPageContext = this.ePZ.GO;
            tbPageContext.showToast(errorString);
        }
    }
}
