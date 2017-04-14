package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalChatActivity dhj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.dhj = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        MsglistModel msglistModel;
        AbsMsglistView absMsglistView;
        com.baidu.tbadk.coreExtra.relationship.b bVar2;
        com.baidu.tbadk.coreExtra.relationship.b bVar3;
        long j;
        String str;
        com.baidu.tbadk.coreExtra.relationship.b bVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.dhj.dha = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.dhj.dha;
            if (bVar != null) {
                msglistModel = this.dhj.cOu;
                UserData user = ((PersonalMsglistModel) msglistModel).getUser();
                if (user != null) {
                    absMsglistView = this.dhj.cOt;
                    String userName = user.getUserName();
                    bVar2 = this.dhj.dha;
                    absMsglistView.refreshPersonalHeadFooter(userName, bVar2);
                    PersonalChatActivity personalChatActivity = this.dhj;
                    PersonalChatActivity personalChatActivity2 = this.dhj;
                    bVar3 = this.dhj.dha;
                    personalChatActivity.dgZ = personalChatActivity2.kX(au.o(bVar3.getTime()));
                    j = this.dhj.dgZ;
                    if (j != 0) {
                        handler = this.dhj.mHandler;
                        runnable = this.dhj.dhe;
                        j2 = this.dhj.dgZ;
                        handler.postDelayed(runnable, j2);
                    }
                    com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e aud = PersonalChatActivityStatic.aud();
                    str = this.dhj.dhb;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    bVar4 = this.dhj.dha;
                    aud.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkCoreApplication.m9getInst().getAlarmManager().ob();
        }
    }
}
