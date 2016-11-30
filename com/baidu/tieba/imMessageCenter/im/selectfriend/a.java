package com.baidu.tieba.imMessageCenter.im.selectfriend;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.view.w;
import com.baidu.tieba.imMessageCenter.ResponseFriendListMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ SelectFriendActivity dyz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(SelectFriendActivity selectFriendActivity, int i) {
        super(i);
        this.dyz = selectFriendActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        w wVar;
        w wVar2;
        if (TbadkCoreApplication.m9getInst().getIntentClass(AddressListActivityConfig.class) == null && (httpResponsedMessage instanceof ResponseFriendListMessage)) {
            LinkedList<com.baidu.tbadk.coreExtra.relationship.a> friendList = ((ResponseFriendListMessage) httpResponsedMessage).getFriendList();
            if (friendList == null) {
                friendList = new LinkedList<>();
            }
            if (friendList.size() > 0) {
                wVar2 = this.dyz.mNoDataView;
                wVar2.setVisibility(8);
                this.dyz.dyw.setContacts(friendList);
                this.dyz.dyw.notifyDataSetChanged();
                return;
            }
            wVar = this.dyz.mNoDataView;
            wVar.setVisibility(0);
        }
    }
}
