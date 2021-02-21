package com.baidu.tieba.recommendlist;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recommendlist.model.AlaRecommendLiveResponseMessage;
/* loaded from: classes11.dex */
public class RecommendListInitialize {
    static {
        dEX();
        dEY();
    }

    private static void dEX() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913223, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.recommendlist.RecommendListInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.y.a> run(CustomMessage<TbPageContext> customMessage) {
                if (customMessage.getData() != null) {
                    return new CustomResponsedMessage<>(2913223, new a(customMessage.getData()));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void dEY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021193, TbConfig.SERVER_ADDRESS + "ala/follow/followedAnthor");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaRecommendLiveResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
