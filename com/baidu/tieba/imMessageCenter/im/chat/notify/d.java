package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMessageCenterDelegateStatic djS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, int i) {
        super(i);
        this.djS = imMessageCenterDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        TextView textView;
        int i = 0;
        if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
            RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
            boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
            int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgChat();
            int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgReplyme();
            int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.zj().getMsgAtme();
            int zq = com.baidu.tbadk.coreExtra.messageCenter.a.zj().zq();
            com.baidu.tbadk.coreExtra.c.e zE = com.baidu.tbadk.coreExtra.messageCenter.a.zj().zE();
            if (zE != null && flag) {
                i = zE.AO();
            }
            textView = this.djS.avG;
            ImMessageCenterDelegateStatic.o(textView, (((msgChat - i) + msgReplyme) + msgAtme) - zq);
        }
    }
}
