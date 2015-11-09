package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalChatActivity bKb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.bKb = personalChatActivity;
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
            this.bKb.bJS = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.bKb.bJS;
            if (bVar != null) {
                msglistModel = this.bKb.mListModel;
                UserData user = ((PersonalMsglistModel) msglistModel).getUser();
                if (user != null) {
                    absMsglistView = this.bKb.mListView;
                    String userName = user.getUserName();
                    bVar2 = this.bKb.bJS;
                    absMsglistView.refreshPersonalHeadFooter(userName, bVar2);
                    PersonalChatActivity personalChatActivity = this.bKb;
                    PersonalChatActivity personalChatActivity2 = this.bKb;
                    bVar3 = this.bKb.bJS;
                    personalChatActivity.bJR = personalChatActivity2.iv(as.l(bVar3.getTime()));
                    j = this.bKb.bJR;
                    if (j != 0) {
                        handler = this.bKb.mHandler;
                        runnable = this.bKb.bJW;
                        j2 = this.bKb.bJR;
                        handler.postDelayed(runnable, j2);
                    }
                    com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e Ya = PersonalChatActivityStatic.Ya();
                    str = this.bKb.bJT;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    bVar4 = this.bKb.bJS;
                    Ya.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkCoreApplication.m411getInst().getAlarmManager().qf();
        }
    }
}
