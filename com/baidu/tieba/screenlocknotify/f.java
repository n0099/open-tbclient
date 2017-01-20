package com.baidu.tieba.screenlocknotify;

import android.view.View;
import com.baidu.tbadk.core.atomData.InterviewLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ScreenLockActivity screenLockActivity) {
        this.this$0 = screenLockActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        s item;
        if (this.this$0.eZL.getCount() > 0 && (item = this.this$0.eZL.getItem(0)) != null) {
            TiebaStatic.log(new ar("c11704").g(PbActivityConfig.KEY_MSG_ID, item.msgId / 100).g(InterviewLiveActivityConfig.KEY_TASK_ID, item.taskId));
        }
        this.this$0.finish();
        i.baB().eZY.baG();
    }
}
