package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.support.v4.app.Fragment;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.imMessageCenter.InvokeNewImMessageCenterFragmentConfig;
import com.baidu.tieba.imMessageCenter.mention.bd;
/* loaded from: classes.dex */
class q implements CustomMessageTask.CustomRunnable<InvokeNewImMessageCenterFragmentConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Fragment> run(CustomMessage<InvokeNewImMessageCenterFragmentConfig> customMessage) {
        if (customMessage == null) {
            return null;
        }
        bd bdVar = new bd();
        bdVar.jx(InvokeNewImMessageCenterFragmentConfig.currentPageType);
        return new CustomResponsedMessage<>(CmdConfigCustom.IM_NEW_MESSAGE_CENTER_FRAGMENT, bdVar);
    }
}
