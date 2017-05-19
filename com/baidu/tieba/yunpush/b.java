package com.baidu.tieba.yunpush;

import android.content.Intent;
import android.os.IBinder;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.pushservice.PushServiceUtil;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
class b implements CustomMessageTask.CustomRunnable<Intent> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<IBinder> run(CustomMessage<Intent> customMessage) {
        if (customMessage == null || customMessage.getData() == null) {
            return null;
        }
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PUSH_PUSHSERVICE_ONBIND, PushServiceUtil.getInstance().onBind(customMessage.getData()));
    }
}
