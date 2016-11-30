package com.baidu.tieba.imMessageCenter.mention;

import android.widget.TextView;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.RequestUpdateForumMask;
import com.baidu.tbadk.core.message.ResponseUpdateForumMask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ z dzD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(z zVar, int i) {
        super(i);
        this.dzD = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.mvc.f.a.b Fr;
        if ((socketResponsedMessage instanceof ResponseUpdateForumMask) && (socketResponsedMessage.getOrginalMessage() instanceof RequestUpdateForumMask)) {
            RequestUpdateForumMask requestUpdateForumMask = (RequestUpdateForumMask) socketResponsedMessage.getOrginalMessage();
            boolean flag = requestUpdateForumMask != null ? requestUpdateForumMask.getFlag() : false;
            for (int i = 0; i < 3; i++) {
                com.baidu.tbadk.mvc.f.a.a mE = this.dzD.mE(i);
                if ((mE instanceof k) && (Fr = mE.Fr()) != null && Fr.Fv() != null && (Fr.Fv().view instanceof TextView)) {
                    TextView textView = (TextView) Fr.Fv().view;
                    int msgChat = com.baidu.tbadk.coreExtra.messageCenter.a.yK().getMsgChat();
                    com.baidu.tbadk.coreExtra.d.e zf = com.baidu.tbadk.coreExtra.messageCenter.a.yK().zf();
                    this.dzD.r(textView, msgChat - ((zf == null || !flag) ? 0 : zf.Aq()));
                }
            }
        }
    }
}
