package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMessageCenterDelegateStatic ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, int i) {
        super(i);
        this.ctz = imMessageCenterDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        TextView textView;
        int i = 0;
        if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
            RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
            boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
            int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgChat();
            int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgReplyme();
            int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgAtme();
            int xp = com.baidu.tbadk.coreExtra.messageCenter.a.xi().xp();
            com.baidu.tbadk.coreExtra.d.e xD = com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD();
            if (xD != null && flag) {
                i = xD.yN();
            }
            textView = this.ctz.amh;
            ImMessageCenterDelegateStatic.r(textView, (((msgChat - i) + msgReplyme) + msgAtme) - xp);
        }
    }
}
