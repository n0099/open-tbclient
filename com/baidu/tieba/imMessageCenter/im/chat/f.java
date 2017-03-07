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
    final /* synthetic */ PersonalChatActivity diK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.diK = personalChatActivity;
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
            this.diK.diB = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.diK.diB;
            if (bVar != null) {
                msglistModel = this.diK.cPX;
                UserData user = ((PersonalMsglistModel) msglistModel).getUser();
                if (user != null) {
                    absMsglistView = this.diK.cPW;
                    String userName = user.getUserName();
                    bVar2 = this.diK.diB;
                    absMsglistView.refreshPersonalHeadFooter(userName, bVar2);
                    PersonalChatActivity personalChatActivity = this.diK;
                    PersonalChatActivity personalChatActivity2 = this.diK;
                    bVar3 = this.diK.diB;
                    personalChatActivity.diA = personalChatActivity2.kR(au.o(bVar3.getTime()));
                    j = this.diK.diA;
                    if (j != 0) {
                        handler = this.diK.mHandler;
                        runnable = this.diK.diF;
                        j2 = this.diK.diA;
                        handler.postDelayed(runnable, j2);
                    }
                    com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e auk = PersonalChatActivityStatic.auk();
                    str = this.diK.diC;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    bVar4 = this.diK.diB;
                    auk.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkCoreApplication.m9getInst().getAlarmManager().nE();
        }
    }
}
