package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements a.b {
    final /* synthetic */ bc cjW;
    private final /* synthetic */ PbLotteryHttpResponseMessage cjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bc bcVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        this.cjW = bcVar;
        this.cjX = pbLotteryHttpResponseMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        if (this.cjX.getOrginalMessage() instanceof PbLotteryRequestMessage) {
            pbActivity = this.cjW.cjN;
            pbActivity.showProgressBar(true, 0, 0);
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) this.cjX.getOrginalMessage();
            PbLotteryRequestMessage pbLotteryRequestMessage2 = new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), 0, pbLotteryRequestMessage.getActivityId(), pbLotteryRequestMessage.getAwardActId(), pbLotteryRequestMessage.getComponentId());
            pbActivity2 = this.cjW.cjN;
            pbActivity2.sendMessage(pbLotteryRequestMessage2);
        }
        aVar.dismiss();
    }
}
