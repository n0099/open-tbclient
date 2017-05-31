package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements CustomMessageTask.CustomRunnable<Void> {
    final /* synthetic */ MainTabActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MainTabActivity mainTabActivity) {
        this.this$0 = mainTabActivity;
    }

    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
        this.this$0.bjK();
        return null;
    }
}
