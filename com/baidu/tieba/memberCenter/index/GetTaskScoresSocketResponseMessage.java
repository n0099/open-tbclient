package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.AddTaskScores.AddTaskScoresResIdl;
import tbclient.AddTaskScores.DataRes;
import tbclient.Error;
/* loaded from: classes3.dex */
public class GetTaskScoresSocketResponseMessage extends SocketResponsedMessage {
    public int isFinished;
    public int scores;
    public int taskId;
    public long userId;

    public GetTaskScoresSocketResponseMessage() {
        super(309367);
        this.scores = 0;
        this.isFinished = 0;
    }

    public int getIsFinished() {
        return this.isFinished;
    }

    public int getScores() {
        return this.scores;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setTaskId(int i) {
        this.taskId = i;
    }

    public void setUserId(long j) {
        this.userId = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        AddTaskScoresResIdl addTaskScoresResIdl = (AddTaskScoresResIdl) new Wire(new Class[0]).parseFrom(bArr, AddTaskScoresResIdl.class);
        if (addTaskScoresResIdl == null) {
            return;
        }
        Error error = addTaskScoresResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(addTaskScoresResIdl.error.usermsg);
        }
        DataRes dataRes = addTaskScoresResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.scores = dataRes.scores.intValue();
        this.isFinished = addTaskScoresResIdl.data.is_finish.intValue();
        if (getOrginalMessage() == null || getOrginalMessage().getExtra() == null) {
            return;
        }
        GetTaskScoresRequestMessage getTaskScoresRequestMessage = (GetTaskScoresRequestMessage) getOrginalMessage().getExtra();
        this.userId = getTaskScoresRequestMessage.getUserId();
        this.taskId = getTaskScoresRequestMessage.getTaskId();
    }
}
