package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes9.dex */
public class ak {
    private PbFragment iPp;
    private com.baidu.tieba.c.d iPq;

    public ak(PbFragment pbFragment) {
        this.iPp = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003374, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void destroy() {
        if (this.iPq != null) {
            this.iPq.zG();
        }
    }
}
