package com.baidu.tieba.pushdialog;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pushdialog.data.PushDialogHttpResMsg;
import com.baidu.tieba.pushdialog.data.PushDialogReqNetMsg;
import com.baidu.tieba.pushdialog.data.PushDialogSocketResMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a {
    private PushDialogActivity kFD;
    private long taskId;
    private String tid;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PushDialogActivity pushDialogActivity) {
        this.kFD = pushDialogActivity;
        this.kFD.registerListener(new com.baidu.adp.framework.listener.a(1003412, 309614) { // from class: com.baidu.tieba.pushdialog.a.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage instanceof PushDialogHttpResMsg) {
                    a.this.a((PushDialogHttpResMsg) responsedMessage);
                } else if (responsedMessage instanceof PushDialogSocketResMsg) {
                    a.this.a((PushDialogSocketResMsg) responsedMessage);
                }
            }
        });
        Intent intent = this.kFD.getIntent();
        if (intent != null) {
            this.tid = intent.getStringExtra("thread_id");
            this.taskId = intent.getLongExtra("task_id", 0L);
            if (StringUtils.isNull(this.tid)) {
                this.kFD.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadData() {
        long j = com.baidu.adp.lib.f.b.toLong(this.tid, 0L);
        if (j == 0) {
            if (this.kFD != null) {
                this.kFD.a(false, null);
                return;
            }
            return;
        }
        PushDialogReqNetMsg pushDialogReqNetMsg = new PushDialogReqNetMsg();
        pushDialogReqNetMsg.setTask_id(this.taskId);
        pushDialogReqNetMsg.setTid(j);
        MessageManager.getInstance().sendMessage(pushDialogReqNetMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushDialogSocketResMsg pushDialogSocketResMsg) {
        if (this.kFD != null) {
            this.kFD.a(!pushDialogSocketResMsg.hasError(), pushDialogSocketResMsg.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PushDialogHttpResMsg pushDialogHttpResMsg) {
        if (this.kFD != null) {
            this.kFD.a(pushDialogHttpResMsg.getError() == 0, pushDialogHttpResMsg.getData());
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
