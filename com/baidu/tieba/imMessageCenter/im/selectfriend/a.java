package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ SelectFriendActivity dlP;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SelectFriendActivity selectFriendActivity, int i) {
        super(i);
        this.dlP = selectFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        y yVar;
        y yVar2;
        if (TbadkCoreApplication.m9getInst().getIntentClass(AddressListActivityConfig.class) == null && (httpResponsedMessage instanceof ResponseFriendListMessage)) {
            LinkedList<com.baidu.tbadk.coreExtra.relationship.a> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
            if (friendList == null) {
                friendList = new LinkedList<>();
            }
            if (friendList.size() > 0) {
                yVar2 = this.dlP.mNoDataView;
                yVar2.setVisibility(8);
                this.dlP.dlL.setContacts(friendList);
                this.dlP.dlL.notifyDataSetChanged();
                return;
            }
            yVar = this.dlP.mNoDataView;
            yVar.setVisibility(0);
        }
    }
}
