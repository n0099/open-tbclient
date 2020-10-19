package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.model.message.ShareReportHttpResponseMessage;
import com.baidu.tieba.model.message.ShareReportNetMessage;
import com.baidu.tieba.model.message.ShareReportSocketResponseMessage;
/* loaded from: classes.dex */
public class ShareReportModel extends BdBaseModel {
    public ShareReportModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        cCG();
    }

    private void cCG() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SHARE_REPORT, ShareReportSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_SHARE_REPORT, 1003363, TbConfig.URL_SHARE_REPORT, ShareReportHttpResponseMessage.class, false, false, false, false);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void s(String str, String str2, int i) {
        ShareReportNetMessage shareReportNetMessage = new ShareReportNetMessage();
        shareReportNetMessage.setFid(com.baidu.adp.lib.f.b.toLong(str, 0L));
        shareReportNetMessage.setTid(com.baidu.adp.lib.f.b.toLong(str2, 0L));
        shareReportNetMessage.setFrom(i);
        sendMessage(shareReportNetMessage);
    }
}
