package com.baidu.tieba.yuyinala;

import android.content.Context;
import com.baidu.live.ab.a;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.d.ah;
import com.baidu.live.d.ai;
import com.baidu.live.d.aj;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class AlaRedPacketInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(aj.class, AlaSnatchRedPacketActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ai.class, AlaRedPktSendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(ah.class, AlaRedPacketSnatchResultActivity.class);
        bNQ();
    }

    private static void bNQ() {
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
