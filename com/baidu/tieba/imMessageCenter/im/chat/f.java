package com.baidu.tieba.imMessageCenter.im.chat;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
/* loaded from: classes.dex */
class f extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonalChatActivity brU;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PersonalChatActivity personalChatActivity, int i, boolean z) {
        super(i, z);
        this.brU = personalChatActivity;
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
            this.brU.brL = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.brU.brL;
            if (bVar != null) {
                msglistModel = this.brU.mListModel;
                UserData user = ((PersonalMsglistModel) msglistModel).getUser();
                if (user != null) {
                    absMsglistView = this.brU.mListView;
                    String userName = user.getUserName();
                    bVar2 = this.brU.brL;
                    absMsglistView.refreshPersonalHeadFooter(userName, bVar2);
                    PersonalChatActivity personalChatActivity = this.brU;
                    PersonalChatActivity personalChatActivity2 = this.brU;
                    bVar3 = this.brU.brL;
                    personalChatActivity.brK = personalChatActivity2.hD(bb.n(bVar3.getTime()));
                    j = this.brU.brK;
                    if (j != 0) {
                        handler = this.brU.mHandler;
                        runnable = this.brU.brP;
                        j2 = this.brU.brK;
                        handler.postDelayed(runnable, j2);
                    }
                    com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f Vr = PersonalChatActivityStatic.Vr();
                    str = this.brU.brM;
                    String str2 = String.valueOf(str) + "&" + user.getUserId();
                    bVar4 = this.brU.brL;
                    Vr.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
                } else {
                    return;
                }
            }
            TbadkCoreApplication.m411getInst().getAlarmManager().pn();
        }
    }
}
