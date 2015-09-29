package com.baidu.tieba.tblauncher;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
/* loaded from: classes.dex */
class am implements CustomMessageTask.CustomRunnable<Integer> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
        if (customMessage != null && (customMessage instanceof NewMsgArriveRequestMessage)) {
            int intValue = ((NewMsgArriveRequestMessage) customMessage).getData().intValue();
            if (intValue == 2) {
                MainTabActivity.dbS = true;
            }
            return new NewMsgArriveResponsedMessage(intValue);
        }
        return null;
    }
}
