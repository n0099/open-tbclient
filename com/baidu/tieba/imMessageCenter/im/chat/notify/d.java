package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMessageCenterDelegateStatic drl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(ImMessageCenterDelegateStatic imMessageCenterDelegateStatic, int i) {
        super(i);
        this.drl = imMessageCenterDelegateStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        TextView textView;
        int i = 0;
        if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
            RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
            boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
            int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.yG().getMsgChat();
            int msgReplyme = com.baidu.tbadk.coreExtra.messageCenter.a.yG().getMsgReplyme();
            int msgAtme = com.baidu.tbadk.coreExtra.messageCenter.a.yG().getMsgAtme();
            int yN = com.baidu.tbadk.coreExtra.messageCenter.a.yG().yN();
            com.baidu.tbadk.coreExtra.c.e zb = com.baidu.tbadk.coreExtra.messageCenter.a.yG().zb();
            if (zb != null && flag) {
                i = zb.An();
            }
            textView = this.drl.awx;
            ImMessageCenterDelegateStatic.n(textView, (((msgChat - i) + msgReplyme) + msgAtme) - yN);
        }
    }
}
