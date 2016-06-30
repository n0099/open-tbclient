package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.dbp = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.b bVar2;
        com.baidu.tbadk.coreExtra.relationship.b bVar3;
        long lk;
        long j;
        String str;
        com.baidu.tbadk.coreExtra.relationship.b bVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.dbp.cYo = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.dbp.cYo;
            if (bVar != null) {
                UserData userData = null;
                msglistModel = this.dbp.cFR;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.dbp.cFR;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.dbp.dbn;
                String userName = userData.getUserName();
                bVar2 = this.dbp.cYo;
                floatingPersonalChatView.a(userName, bVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.dbp;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.dbp;
                bVar3 = this.dbp.cYo;
                lk = floatingPersonalChatActivity2.lk(ba.x(bVar3.getTime()));
                floatingPersonalChatActivity.cYn = lk;
                j = this.dbp.cYn;
                if (j != 0) {
                    handler = this.dbp.mHandler;
                    runnable = this.dbp.cYs;
                    j2 = this.dbp.cYn;
                    handler.postDelayed(runnable, j2);
                }
                com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e asA = FloatingPersonalChatActivityStatic.asA();
                str = this.dbp.cYp;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                bVar4 = this.dbp.cYo;
                asA.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m9getInst().getAlarmManager().mH();
        }
    }
}
