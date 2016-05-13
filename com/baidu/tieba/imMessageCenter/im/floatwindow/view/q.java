package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity cvZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.cvZ = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.b bVar2;
        com.baidu.tbadk.coreExtra.relationship.b bVar3;
        long jR;
        long j;
        String str;
        com.baidu.tbadk.coreExtra.relationship.b bVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.cvZ.csY = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.cvZ.csY;
            if (bVar != null) {
                UserData userData = null;
                msglistModel = this.cvZ.caH;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.cvZ.caH;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.cvZ.cvX;
                String userName = userData.getUserName();
                bVar2 = this.cvZ.csY;
                floatingPersonalChatView.a(userName, bVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.cvZ;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.cvZ;
                bVar3 = this.cvZ.csY;
                jR = floatingPersonalChatActivity2.jR(ay.w(bVar3.getTime()));
                floatingPersonalChatActivity.csX = jR;
                j = this.cvZ.csX;
                if (j != 0) {
                    handler = this.cvZ.mHandler;
                    runnable = this.cvZ.ctc;
                    j2 = this.cvZ.csX;
                    handler.postDelayed(runnable, j2);
                }
                com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e akm = FloatingPersonalChatActivityStatic.akm();
                str = this.cvZ.csZ;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                bVar4 = this.cvZ.csY;
                akm.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m11getInst().getAlarmManager().mM();
        }
    }
}
