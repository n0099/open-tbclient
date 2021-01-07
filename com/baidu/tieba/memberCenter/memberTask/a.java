package com.baidu.tieba.memberCenter.memberTask;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes9.dex */
public class a {
    private int isFinished;
    private InterfaceC0807a lkl = null;
    private com.baidu.adp.framework.listener.a lkm = new com.baidu.adp.framework.listener.a(1003188, CmdConfigSocket.CMD_FINISH_MEMBER_TASK) { // from class: com.baidu.tieba.memberCenter.memberTask.a.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof FinishMemberTaskHttpResMessage) || (responsedMessage instanceof FinishMemberTaskSocketMessage)) {
                    if (responsedMessage instanceof FinishMemberTaskHttpResMessage) {
                        a.this.isFinished = ((FinishMemberTaskHttpResMessage) responsedMessage).getStatus();
                    } else if (responsedMessage instanceof FinishMemberTaskSocketMessage) {
                        a.this.isFinished = ((FinishMemberTaskSocketMessage) responsedMessage).getStatus();
                    }
                    if (a.this.lkl != null) {
                        a.this.lkl.a(responsedMessage.getError(), responsedMessage.getErrorString(), a.this.isFinished, a.this.scores, a.this.taskId);
                    }
                }
            }
        }
    };
    private int scores;
    private long taskId;

    /* renamed from: com.baidu.tieba.memberCenter.memberTask.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0807a {
        void a(int i, String str, int i2, int i3, long j);
    }

    public a() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FINISH_MEMBER_TASK, FinishMemberTaskSocketMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FINISH_MEMBER_TASK, 1003188, TbConfig.FINISH_MEMBER_TASK, FinishMemberTaskHttpResMessage.class, false, false, false, false);
        MessageManager.getInstance().registerListener(this.lkm);
    }

    public void B(long j, int i) {
        this.taskId = j;
        this.scores = i;
        FinishMemberTaskReqMessage finishMemberTaskReqMessage = new FinishMemberTaskReqMessage();
        finishMemberTaskReqMessage.setTaskId(j);
        MessageManager.getInstance().sendMessage(finishMemberTaskReqMessage);
    }

    public void a(InterfaceC0807a interfaceC0807a) {
        this.lkl = interfaceC0807a;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lkm);
    }
}
