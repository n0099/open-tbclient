package com.baidu.tieba.person.post;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.UserPostPageRequestMessage;
import com.baidu.tieba.person.UserPostPageSocketResponsedMessage;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ p clq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.clq = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonPostModel.a aVar;
        if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
            UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
            if (userPostPageSocketResponsedMessage.getOrginalMessage() == null) {
                this.clq.b(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
            if (userPostPageRequestMessage.isThread() && (aVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                aVar.a(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
