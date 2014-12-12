package com.baidu.tieba.person.post;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.person.UserPostPageRequestMessage;
import com.baidu.tieba.person.UserPostPageSocketResponsedMessage;
import com.baidu.tieba.person.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ k bHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k kVar, int i) {
        super(i);
        this.bHG = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        br brVar;
        br brVar2;
        if (socketResponsedMessage instanceof UserPostPageSocketResponsedMessage) {
            UserPostPageSocketResponsedMessage userPostPageSocketResponsedMessage = (UserPostPageSocketResponsedMessage) socketResponsedMessage;
            if (userPostPageSocketResponsedMessage.getOrginalMessage() == null) {
                brVar2 = this.bHG.bHn;
                brVar2.a(null, false);
                return;
            }
            UserPostPageRequestMessage userPostPageRequestMessage = (UserPostPageRequestMessage) userPostPageSocketResponsedMessage.getOrginalMessage().getExtra();
            if (!userPostPageRequestMessage.isThread() && (brVar = userPostPageRequestMessage.getmCallbackWeakReference().get()) != null) {
                brVar.a(userPostPageSocketResponsedMessage.getPersonPostModel(), userPostPageRequestMessage.isReset());
            }
        }
    }
}
