package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.ShareReportHttpResponseMessage;
import com.baidu.tieba.model.message.ShareReportNetMessage;
import com.baidu.tieba.model.message.ShareReportSocketResponseMessage;
/* loaded from: classes.dex */
public class ShareReportModel extends BdBaseModel {
    public ShareReportModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        aBU();
    }

    private void aBU() {
        com.baidu.tieba.tbadkCore.a.a.a(309480, ShareReportSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309480, CmdConfigHttp.CMD_SHARE_REPORT, TbConfig.URL_SHARE_REPORT, ShareReportHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void i(String str, String str2, int i) {
        ShareReportNetMessage shareReportNetMessage = new ShareReportNetMessage();
        shareReportNetMessage.setFid(com.baidu.adp.lib.g.b.c(str, 0L));
        shareReportNetMessage.setTid(com.baidu.adp.lib.g.b.c(str2, 0L));
        shareReportNetMessage.setFrom(i);
        sendMessage(shareReportNetMessage);
    }
}
