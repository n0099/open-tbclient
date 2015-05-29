package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
/* loaded from: classes.dex */
class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity buJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.buJ = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.b bVar2;
        com.baidu.tbadk.coreExtra.relationship.b bVar3;
        long hD;
        long j;
        String str;
        com.baidu.tbadk.coreExtra.relationship.b bVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.buJ.brL = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.buJ.brL;
            if (bVar != null) {
                UserData userData = null;
                msglistModel = this.buJ.mListModel;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.buJ.mListModel;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.buJ.buH;
                String userName = userData.getUserName();
                bVar2 = this.buJ.brL;
                floatingPersonalChatView.a(userName, bVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.buJ;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.buJ;
                bVar3 = this.buJ.brL;
                hD = floatingPersonalChatActivity2.hD(bb.n(bVar3.getTime()));
                floatingPersonalChatActivity.brK = hD;
                j = this.buJ.brK;
                if (j != 0) {
                    handler = this.buJ.mHandler;
                    runnable = this.buJ.brP;
                    j2 = this.buJ.brK;
                    handler.postDelayed(runnable, j2);
                }
                com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f WD = FloatingPersonalChatActivityStatic.WD();
                str = this.buJ.brM;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                bVar4 = this.buJ.brL;
                WD.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m411getInst().getAlarmManager().pn();
        }
    }
}
