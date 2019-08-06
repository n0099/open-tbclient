package com.baidu.tieba.pb.pb.report;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes4.dex */
public class b {
    private BdUniqueId mTag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_UEG_REPORT, TbConfig.SERVER_ADDRESS + TbConfig.URL_UEG_REPORT);
        tbHttpMessageTask.setResponsedClass(UEGReportResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Cn(String str) {
        UEGReportRequestMessage uEGReportRequestMessage = new UEGReportRequestMessage();
        uEGReportRequestMessage.setTag(this.mTag);
        uEGReportRequestMessage.setPid(str);
        MessageManager.getInstance().sendMessage(uEGReportRequestMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uW(String str) {
        UEGReportRequestMessage uEGReportRequestMessage = new UEGReportRequestMessage();
        uEGReportRequestMessage.setTag(this.mTag);
        uEGReportRequestMessage.setTUid(str);
        MessageManager.getInstance().sendMessage(uEGReportRequestMessage);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        this.mTag = bdUniqueId;
    }
}
