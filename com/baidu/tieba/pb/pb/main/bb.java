package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements a.b {
    final /* synthetic */ PbActivity dht;
    private final /* synthetic */ boolean dhu;
    private final /* synthetic */ PbLotteryHttpResponseMessage dhv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PbActivity pbActivity, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, boolean z) {
        this.dht = pbActivity;
        this.dhv = pbLotteryHttpResponseMessage;
        this.dhu = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        if (this.dhv.getOrginalMessage().getExtra() instanceof PbLotteryRequestMessage) {
            if (!this.dhu) {
                this.dht.showProgressBar(true, 0, 0);
            } else {
                this.dht.awa();
            }
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) this.dhv.getOrginalMessage().getExtra();
            this.dht.sendMessage(new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), pbLotteryRequestMessage.getForumId(), pbLotteryRequestMessage.getThreadId(), 0, pbLotteryRequestMessage.getActivityId(), pbLotteryRequestMessage.getAwardActId(), pbLotteryRequestMessage.getComponentId()));
        }
        aVar.dismiss();
        dfVar = this.dht.dfV;
        if (dfVar != null) {
            dfVar2 = this.dht.dfV;
            if (dfVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10504");
                dfVar3 = this.dht.dfV;
                com.baidu.tbadk.core.util.aw ac = awVar.ac("fid", dfVar3.getPbData().getForumId());
                dfVar4 = this.dht.dfV;
                TiebaStatic.log(ac.ac("tid", dfVar4.getPbData().getThreadId()).ac("obj_locate", "1"));
            }
        }
    }
}
