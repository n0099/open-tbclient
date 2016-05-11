package com.baidu.tieba.pb.pb.b;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.PbLotteryRequestMessage;
import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements a.b {
    final /* synthetic */ a dhT;
    private final /* synthetic */ boolean dhV;
    private final /* synthetic */ PbLotteryHttpResponseMessage dhW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, boolean z) {
        this.dhT = aVar;
        this.dhW = pbLotteryHttpResponseMessage;
        this.dhV = z;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        boolean z;
        if (this.dhW.getOrginalMessage().getExtra() instanceof PbLotteryRequestMessage) {
            if (!this.dhV) {
                pbActivity2 = this.dhT.dhQ;
                pbActivity2.showProgressBar(true, 0, 0);
            } else {
                this.dhT.awl();
            }
            PbLotteryRequestMessage pbLotteryRequestMessage = (PbLotteryRequestMessage) this.dhW.getOrginalMessage().getExtra();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
            String forumId = pbLotteryRequestMessage.getForumId();
            String threadId = pbLotteryRequestMessage.getThreadId();
            long activityId = pbLotteryRequestMessage.getActivityId();
            long awardActId = pbLotteryRequestMessage.getAwardActId();
            long componentId = pbLotteryRequestMessage.getComponentId();
            z = this.dhT.mIsSenior;
            this.dhT.sendMessage(new PbLotteryRequestMessage(currentAccount, currentAccountName, forumId, threadId, 0, activityId, awardActId, componentId, z));
        }
        aVar.dismiss();
        pbActivity = this.dhT.dhQ;
        cw awu = pbActivity.awu();
        if (awu != null && awu.getPbData() != null) {
            TiebaStatic.log(new aw("c10504").ac("fid", awu.getPbData().getForumId()).ac("tid", awu.getPbData().getThreadId()).ac("obj_locate", "1"));
        }
    }
}
