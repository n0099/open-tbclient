package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes22.dex */
public class av {
    private PbFragment lOU;
    private com.baidu.tieba.d.e lOV;

    public av(PbFragment pbFragment) {
        this.lOU = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003374, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void destroy() {
        if (this.lOV != null) {
            this.lOV.UG();
        }
    }
}
