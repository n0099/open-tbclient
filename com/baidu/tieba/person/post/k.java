package com.baidu.tieba.person.post;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.person.PersonPostModel;
import com.baidu.tieba.person.UserPostPageRequestMessage;
import com.baidu.tieba.person.UserPostPageSocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ i clg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, int i) {
        super(i);
        this.clg = iVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        PersonPostModel.a aVar;
        PersonPostModel.a aVar2;
        if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
            UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
            if (userPostPageSocketResponsedMessage.getOrginalMessage() == null) {
                aVar2 = this.clg.ckN;
                aVar2.a(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
            if (!userPostPageRequestMessage.isThread() && (aVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                aVar.a(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
