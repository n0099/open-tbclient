package com.baidu.tieba.yuyinala.person.hosttabpanel;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.yuyinala.person.hosttabpanel.message.AlaNewHostTabHttpResponseMessage;
/* loaded from: classes4.dex */
public class AlaHostTabInitialize {
    static {
        registerTask();
    }

    private static void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1031072, TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoWithRecord");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(false);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(false);
        tbHttpMessageTask.setResponsedClass(AlaNewHostTabHttpResponseMessage.class);
        MessageManager.getInstance().unRegisterTask(1031072);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
