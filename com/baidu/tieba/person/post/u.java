package com.baidu.tieba.person.post;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.person.UserPostPageRequestMessage;
import com.baidu.tieba.person.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.person.br;
/* loaded from: classes.dex */
class u extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ t bHQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(t tVar, int i) {
        super(i);
        this.bHQ = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        br brVar;
        if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
            UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
            if (userPostPageSocketResponsedMessage.getOrginalMessage() == null) {
                this.bHQ.b(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
            if (userPostPageRequestMessage.isThread() && (brVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                brVar.a(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
