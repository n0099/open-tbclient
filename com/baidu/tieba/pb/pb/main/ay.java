package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements a.b {
    final /* synthetic */ PbActivity dht;
    private final /* synthetic */ boolean dhu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(PbActivity pbActivity, boolean z) {
        this.dht = pbActivity;
        this.dhu = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        df dfVar;
        df dfVar2;
        df dfVar3;
        df dfVar4;
        aVar.dismiss();
        if (this.dhu) {
            this.dht.awa();
        }
        com.baidu.tieba.pb.data.e pbData = this.dht.awj().getPbData();
        if (pbData.avu() != null && pbData.avv() != null && pbData.avv().tw() != null && pbData.avv().tw().size() > 0 && pbData.avv().tw().get(0) != null) {
            PbLotteryRequestMessage pbLotteryRequestMessage = new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), pbData.avu().getId(), pbData.avv().getId(), 1, pbData.avv().tw().get(0).getActivityId(), pbData.avv().tw().get(0).qY(), pbData.avv().tw().get(0).qZ());
            if (!this.dhu) {
                this.dht.showProgressBar(true, 0, 0);
            }
            this.dht.sendMessage(pbLotteryRequestMessage);
        }
        dfVar = this.dht.dfV;
        if (dfVar != null) {
            dfVar2 = this.dht.dfV;
            if (dfVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.aw awVar = new com.baidu.tbadk.core.util.aw("c10398");
                dfVar3 = this.dht.dfV;
                com.baidu.tbadk.core.util.aw ac = awVar.ac("fid", dfVar3.getPbData().getForumId());
                dfVar4 = this.dht.dfV;
                TiebaStatic.log(ac.ac("tid", dfVar4.getPbData().getThreadId()).ac("is_like", "1"));
            }
        }
    }
}
