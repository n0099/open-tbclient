package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
import com.baidu.tieba.imMessageCenter.im.model.PersonalMsglistModel;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity cfW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.cfW = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.b bVar2;
        com.baidu.tbadk.coreExtra.relationship.b bVar3;
        long jd;
        long j;
        String str;
        com.baidu.tbadk.coreExtra.relationship.b bVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.cfW.ccX = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.cfW.ccX;
            if (bVar != null) {
                UserData userData = null;
                msglistModel = this.cfW.mListModel;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.cfW.mListModel;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.cfW.cfU;
                String userName = userData.getUserName();
                bVar2 = this.cfW.ccX;
                floatingPersonalChatView.a(userName, bVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.cfW;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.cfW;
                bVar3 = this.cfW.ccX;
                jd = floatingPersonalChatActivity2.jd(ax.r(bVar3.getTime()));
                floatingPersonalChatActivity.ccW = jd;
                j = this.cfW.ccW;
                if (j != 0) {
                    handler = this.cfW.mHandler;
                    runnable = this.cfW.cdb;
                    j2 = this.cfW.ccW;
                    handler.postDelayed(runnable, j2);
                }
                com.baidu.tieba.imMessageCenter.im.chat.personaltalk.e adB = FloatingPersonalChatActivityStatic.adB();
                str = this.cfW.ccY;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                bVar4 = this.cfW.ccX;
                adB.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m411getInst().getAlarmManager().pK();
        }
    }
}
