package com.baidu.tieba.imMessageCenter.mention;

import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ z cyD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(z zVar, int i) {
        super(i);
        this.cyD = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.mvc.f.a.b DK;
        if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
            RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
            boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
            for (int i = 0; i < 3; i++) {
                com.baidu.tbadk.mvc.f.a.a ke = this.cyD.ke(i);
                if ((ke instanceof k) && (DK = ke.DK()) != null && DK.DO() != null && (DK.DO().view instanceof TextView)) {
                    TextView textView = (TextView) DK.DO().view;
                    int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.xi().getMsgChat();
                    com.baidu.tbadk.coreExtra.d.e xD = com.baidu.tbadk.coreExtra.messageCenter.a.xi().xD();
                    this.cyD.r(textView, msgChat - ((xD == null || !flag) ? 0 : xD.yN()));
                }
            }
        }
    }
}
