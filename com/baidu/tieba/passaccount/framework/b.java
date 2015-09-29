package com.baidu.tieba.passaccount.framework;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.passaccount.a.g;
/* loaded from: classes.dex */
class b implements CustomMessageTask.CustomRunnable<Activity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.coreExtra.a.c> run(CustomMessage<Activity> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PASS_MANAGER, g.aee());
    }
}
