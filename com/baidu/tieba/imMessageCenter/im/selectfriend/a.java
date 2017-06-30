package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.view.y;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import java.util.LinkedList;
/* loaded from: classes2.dex */
class a extends HttpMessageListener {
    final /* synthetic */ SelectFriendActivity dtk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SelectFriendActivity selectFriendActivity, int i) {
        super(i);
        this.dtk = selectFriendActivity;
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
                yVar2 = this.dtk.mNoDataView;
                yVar2.setVisibility(8);
                this.dtk.dtf.setContacts(friendList);
                this.dtk.dtf.notifyDataSetChanged();
                return;
            }
            yVar = this.dtk.mNoDataView;
            yVar.setVisibility(0);
        }
    }
}
