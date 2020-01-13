package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes7.dex */
public class an {
    private PbFragment iMg;
    private com.baidu.tieba.c.d iMh;

    public an(PbFragment pbFragment) {
        this.iMg = pbFragment;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003374, TbConfig.SERVER_ADDRESS + TbConfig.SUBMIT_SHOW_PB_TIPS);
        tbHttpMessageTask.setResponsedClass(SubmitPbShowTipHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void destroy() {
        if (this.iMh != null) {
            this.iMh.xg();
        }
    }
}
