package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes2.dex */
public class al {
    private com.baidu.tieba.c.e eWa;
    private PbFragment lYN;

    public al(PbFragment pbFragment) {
        this.lYN = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003374, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void destroy() {
        if (this.eWa != null) {
            this.eWa.Tz();
        }
    }
}
