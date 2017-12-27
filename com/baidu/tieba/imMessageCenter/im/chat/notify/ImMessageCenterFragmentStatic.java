package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import com.baidu.tieba.imMessageCenter.mention.g;
/* loaded from: classes2.dex */
public class ImMessageCenterFragmentStatic {
    static {
        aKU();
    }

    private static void aKU() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT, new CustomMessageTask.CustomRunnable<InvokeNewImMessageCenterFragmentConfig>() { // from class: com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterFragmentStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<Fragment> run(CustomMessage<InvokeNewImMessageCenterFragmentConfig> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT, new g());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
