package com.baidu.tieba.yuyinala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.b.ag;
import com.baidu.live.b.ah;
import com.baidu.live.b.ai;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.v.a;
/* loaded from: classes4.dex */
public class AlaRedPacketInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(ai.class, AlaSnatchRedPacketActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ah.class, AlaRedPktSendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ag.class, AlaRedPacketSnatchResultActivity.class);
        bJF();
    }

    private static void bJF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2501047, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.yuyinala.AlaRedPacketInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2501047, new com.baidu.tieba.yuyinala.charm.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
