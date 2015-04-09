package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.PersonalMsglistModel;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.ResponsePersonalLbsInfoMessage;
/* loaded from: classes.dex */
class s extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ FloatingPersonalChatActivity brX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(FloatingPersonalChatActivity floatingPersonalChatActivity, int i, boolean z) {
        super(i, z);
        this.brX = floatingPersonalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tbadk.coreExtra.relationship.b bVar;
        MsglistModel msglistModel;
        FloatingPersonalChatView floatingPersonalChatView;
        com.baidu.tbadk.coreExtra.relationship.b bVar2;
        com.baidu.tbadk.coreExtra.relationship.b bVar3;
        long ha;
        long j;
        String str;
        com.baidu.tbadk.coreExtra.relationship.b bVar4;
        Handler handler;
        Runnable runnable;
        long j2;
        MsglistModel msglistModel2;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205101 && !socketResponsedMessage.hasError() && (socketResponsedMessage instanceof ResponsePersonalLbsInfoMessage)) {
            this.brX.bpf = ((ResponsePersonalLbsInfoMessage) socketResponsedMessage).getLbsInfo();
            bVar = this.brX.bpf;
            if (bVar != null) {
                UserData userData = null;
                msglistModel = this.brX.mListModel;
                if (msglistModel instanceof PersonalMsglistModel) {
                    msglistModel2 = this.brX.mListModel;
                    userData = ((PersonalMsglistModel) msglistModel2).getUser();
                }
                if (userData == null) {
                    return;
                }
                floatingPersonalChatView = this.brX.brV;
                String userName = userData.getUserName();
                bVar2 = this.brX.bpf;
                floatingPersonalChatView.a(userName, bVar2);
                FloatingPersonalChatActivity floatingPersonalChatActivity = this.brX;
                FloatingPersonalChatActivity floatingPersonalChatActivity2 = this.brX;
                bVar3 = this.brX.bpf;
                ha = floatingPersonalChatActivity2.ha(bd.m(bVar3.getTime()));
                floatingPersonalChatActivity.bpe = ha;
                j = this.brX.bpe;
                if (j != 0) {
                    handler = this.brX.mHandler;
                    runnable = this.brX.bpj;
                    j2 = this.brX.bpe;
                    handler.postDelayed(runnable, j2);
                }
                com.baidu.tieba.imMessageCenter.im.chat.personaltalk.f Vm = FloatingPersonalChatActivityStatic.Vm();
                str = this.brX.bpg;
                String str2 = String.valueOf(str) + "&" + userData.getUserId();
                bVar4 = this.brX.bpf;
                Vm.a(str2, new com.baidu.tieba.imMessageCenter.im.chat.personaltalk.a(bVar4, System.currentTimeMillis()));
            }
            TbadkCoreApplication.m411getInst().getAlarmManager().oN();
        }
    }
}
