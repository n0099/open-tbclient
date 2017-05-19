package com.baidu.tieba.yunpush;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.pushservice.CommandService;
import com.baidu.android.pushservice.PushServiceUtil;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
class j implements CustomMessageTask.CustomRunnable<CommandService.OnStartCommandData> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<CommandService.OnStartCommandData> customMessage) {
        if (customMessage == null || customMessage.getData() == null) {
            return null;
        }
        CommandService.OnStartCommandData data = customMessage.getData();
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONSTARTCOMMAND, Integer.valueOf(PushServiceUtil.getInstance().onStartCommand(data.intent, data.flags, data.startId)));
    }
}
