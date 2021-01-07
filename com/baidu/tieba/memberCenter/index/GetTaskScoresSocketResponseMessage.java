package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import tbclient.AddTaskScores.AddTaskScoresResIdl;
/* loaded from: classes9.dex */
public class GetTaskScoresSocketResponseMessage extends SocketResponsedMessage {
    private int isFinished;
    private int scores;
    private int taskId;
    private long userId;

    public GetTaskScoresSocketResponseMessage() {
        super(CmdConfigSocket.CMD_GET_TASK_SCORES);
        this.scores = 0;
        this.isFinished = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddTaskScoresResIdl addTaskScoresResIdl = (AddTaskScoresResIdl) new Wire(new Class[0]).parseFrom(bArr, AddTaskScoresResIdl.class);
        if (addTaskScoresResIdl != null) {
            if (addTaskScoresResIdl.error != null) {
                setError(addTaskScoresResIdl.error.errorno.intValue());
                setErrorString(addTaskScoresResIdl.error.usermsg);
            }
            if (addTaskScoresResIdl.data != null) {
                this.scores = addTaskScoresResIdl.data.scores.intValue();
                this.isFinished = addTaskScoresResIdl.data.is_finish.intValue();
                if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                    GetTaskScoresRequestMessage getTaskScoresRequestMessage = (GetTaskScoresRequestMessage) getOrginalMessage().getExtra();
                    this.userId = getTaskScoresRequestMessage.getUserId();
                    this.taskId = getTaskScoresRequestMessage.getTaskId();
                }
            }
        }
    }

    public int getScores() {
        return this.scores;
    }

    public int getIsFinished() {
        return this.isFinished;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }
}
