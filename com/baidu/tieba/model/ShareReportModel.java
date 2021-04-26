package com.baidu.tieba.model;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.model.message.ShareReportHttpResponseMessage;
import com.baidu.tieba.model.message.ShareReportNetMessage;
import com.baidu.tieba.model.message.ShareReportSocketResponseMessage;
import d.a.c.e.m.b;
import d.a.j0.d3.d0.a;
/* loaded from: classes3.dex */
public class ShareReportModel extends BdBaseModel {
    public ShareReportModel(TbPageContext tbPageContext) {
        super(tbPageContext);
        s();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public final void s() {
        a.h(309480, ShareReportSocketResponseMessage.class, false, false);
        a.c(309480, CmdConfigHttp.CMD_SHARE_REPORT, TbConfig.URL_SHARE_REPORT, ShareReportHttpResponseMessage.class, false, false, false, false);
    }

    public void t(String str, String str2, int i2) {
        ShareReportNetMessage shareReportNetMessage = new ShareReportNetMessage();
        shareReportNetMessage.setFid(b.f(str, 0L));
        shareReportNetMessage.setTid(b.f(str2, 0L));
        shareReportNetMessage.setFrom(i2);
        sendMessage(shareReportNetMessage);
    }
}
