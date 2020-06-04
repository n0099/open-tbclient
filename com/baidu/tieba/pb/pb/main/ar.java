package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes9.dex */
public class ar {
    private PbFragment jRZ;
    private com.baidu.tieba.c.d jSa;

    public ar(PbFragment pbFragment) {
        this.jRZ = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003374, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void destroy() {
        if (this.jSa != null) {
            this.jSa.Gu();
        }
    }
}
