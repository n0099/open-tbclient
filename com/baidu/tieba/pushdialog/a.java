package com.baidu.tieba.pushdialog;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogReqNetMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class a {
    private PushDialogActivity gBk;
    private long taskId;
    private String tid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PushDialogActivity pushDialogActivity) {
        this.gBk = pushDialogActivity;
        this.gBk.registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_PUSH_DIALOG_DATA, 309614) { // from class: com.baidu.tieba.pushdialog.a.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage instanceof PushDialogHttpResMsg) {
                    a.this.a((PushDialogHttpResMsg) responsedMessage);
                } else if (responsedMessage instanceof PushDialogSocketResMsg) {
                    a.this.a((PushDialogSocketResMsg) responsedMessage);
                }
            }
        });
        Intent intent = this.gBk.getIntent();
        if (intent != null) {
            this.tid = intent.getStringExtra("thread_id");
            this.taskId = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.tid)) {
                this.gBk.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadData() {
        long d = com.baidu.adp.lib.g.b.d(this.tid, 0L);
        if (d == 0) {
            if (this.gBk != null) {
                this.gBk.a(false, null);
                return;
            }
            return;
        }
        PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
        pushDialogReqNetMsg.setTask_id(this.taskId);
        pushDialogReqNetMsg.setTid(d);
        MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushDialogSocketResMsg pushDialogSocketResMsg) {
        if (this.gBk != null) {
            this.gBk.a(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushDialogHttpResMsg pushDialogHttpResMsg) {
        if (this.gBk != null) {
            this.gBk.a(pushDialogHttpResMsg.getError() == 0, pushDialogHttpResMsg.getData());
        }
    }

    public String getTid() {
        return this.tid;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getTaskId() {
        return this.taskId;
    }
}
