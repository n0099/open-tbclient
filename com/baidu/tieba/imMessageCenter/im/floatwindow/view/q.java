package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.bMS = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.b bVar2;
        com.baidu.tbadk.coreExtra.relationship.b bVar3;
        long iv;
        long j;
        String str;
        com.baidu.tbadk.coreExtra.relationship.b bVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.bMS.bJS = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.bMS.bJS;
            if (bVar != null) {
                UserData userData = null;
                msglistModel = this.bMS.mListModel;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.bMS.mListModel;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.bMS.bMQ;
                String userName = userData.getUserName();
                bVar2 = this.bMS.bJS;
                floatingPersonalChatView.a(userName, bVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.bMS;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.bMS;
                bVar3 = this.bMS.bJS;
                iv = floatingPersonalChatActivity2.iv(as.l(bVar3.getTime()));
                floatingPersonalChatActivity.bJR = iv;
                j = this.bMS.bJR;
                if (j != 0) {
                    handler = this.bMS.mHandler;
                    runnable = this.bMS.bJW;
                    j2 = this.bMS.bJR;
                    handler.postDelayed(runnable, j2);
                }
                com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e Zm = FloatingPersonalChatActivityStatic.Zm();
                str = this.bMS.bJT;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                bVar4 = this.bMS.bJS;
                Zm.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m411getInst().getAlarmManager().qf();
        }
    }
}
