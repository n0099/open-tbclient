package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.view.s;
import com.baidu.tbadk.coreExtra.message.ResponseFriendListMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ SelectFriendActivity bte;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SelectFriendActivity selectFriendActivity, int i) {
        super(i);
        this.bte = selectFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        s sVar;
        s sVar2;
        if (TbadkCoreApplication.m411getInst().getIntentClass(AddressListActivityConfig.class) == null && (httpResponsedMessage instanceof ResponseFriendListMessage)) {
            LinkedList<com.baidu.tbadk.coreExtra.relationship.a> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
            if (friendList == null) {
                friendList = new LinkedList<>();
            }
            if (friendList.size() > 0) {
                sVar2 = this.bte.mNoDataView;
                sVar2.setVisibility(8);
                this.bte.btb.setContacts(friendList);
                this.bte.btb.notifyDataSetChanged();
                return;
            }
            sVar = this.bte.mNoDataView;
            sVar.setVisibility(0);
        }
    }
}
