package com.baidu.tieba.memberCenter.index;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.DoDailyTask.ButtonItem;
import tbclient.DoDailyTask.DoDailyTaskResIdl;
/* loaded from: classes9.dex */
public class DoDailyTaskSocketResponseMessage extends SocketResponsedMessage {
    public List<ButtonItem> buttonItems;
    public String content;
    public int isFinished;
    public int needDialog;
    public long taskId;
    public String title;
    public long userId;

    public DoDailyTaskSocketResponseMessage() {
        super(CmdConfigSocket.CMD_DO_DAILY_TASK);
        this.needDialog = 0;
        this.isFinished = 0;
        this.title = "";
        this.content = "";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        DoDailyTaskResIdl doDailyTaskResIdl = (DoDailyTaskResIdl) new Wire(new Class[0]).parseFrom(bArr, DoDailyTaskResIdl.class);
        if (doDailyTaskResIdl != null) {
            if (doDailyTaskResIdl.error != null) {
                setError(doDailyTaskResIdl.error.errorno.intValue());
                setErrorString(doDailyTaskResIdl.error.errmsg);
            }
            if (doDailyTaskResIdl.data != null) {
                this.title = doDailyTaskResIdl.data.ret_data.dialog.title;
                this.content = doDailyTaskResIdl.data.ret_data.dialog.content;
                this.buttonItems = doDailyTaskResIdl.data.ret_data.dialog.button;
                this.needDialog = doDailyTaskResIdl.data.ret_data.need_dialog.intValue();
                this.isFinished = doDailyTaskResIdl.data.ret_data.task_info.is_finish.intValue();
                if (getOrginalMessage() != null && getOrginalMessage().getExtra() != null) {
                    DoDailyTaskRequestMessage doDailyTaskRequestMessage = (DoDailyTaskRequestMessage) getOrginalMessage().getExtra();
                    this.userId = doDailyTaskRequestMessage.getUserId();
                    this.taskId = doDailyTaskRequestMessage.getTaskId();
                }
            }
        }
    }
}
