package com.baidu.tieba.pb.pb.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.b {
    final /* synthetic */ a dhT;
    private final /* synthetic */ boolean dhV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, boolean z) {
        this.dhT = aVar;
        this.dhV = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        boolean z;
        PbActivity pbActivity2;
        aVar.dismiss();
        if (this.dhV) {
            this.dhT.awl();
        }
        pbActivity = this.dhT.dhQ;
        cw awu = pbActivity.awu();
        if (awu != null) {
            com.baidu.tieba.pb.data.e pbData = awu.getPbData();
            if (pbData.avA() != null && pbData.avB() != null && pbData.avB().qU() != null && pbData.avB().qU().size() > 0 && pbData.avB().qU().get(0) != null) {
                String id = pbData.avA().getId();
                String id2 = pbData.avB().getId();
                int activityId = pbData.avB().qU().get(0).getActivityId();
                int ov = pbData.avB().qU().get(0).ov();
                int ow = pbData.avB().qU().get(0).ow();
                z = this.dhT.mIsSenior;
                PbLotteryRequestMessage pbLotteryRequestMessage = new PbLotteryRequestMessage(TbadkCoreApplication.getCurrentAccount(), TbadkCoreApplication.getCurrentAccountName(), id, id2, 1, activityId, ov, ow, z);
                if (!this.dhV) {
                    pbActivity2 = this.dhT.dhQ;
                    pbActivity2.showProgressBar(true, 0, 0);
                }
                this.dhT.sendMessage(pbLotteryRequestMessage);
            }
            if (awu != null && awu.getPbData() != null) {
                TiebaStatic.log(new aw("c10398").ac("fid", awu.getPbData().getForumId()).ac("tid", awu.getPbData().getThreadId()).ac("is_like", "1"));
            }
        }
    }
}
