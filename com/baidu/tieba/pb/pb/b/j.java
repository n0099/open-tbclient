package com.baidu.tieba.pb.pb.b;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLotteryHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.cw;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements a.b {
    final /* synthetic */ a dhT;
    private final /* synthetic */ PbLotteryHttpResponseMessage dhW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        this.dhT = aVar;
        this.dhW = pbLotteryHttpResponseMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        PbActivity pbActivity3;
        aVar.dismiss();
        pbActivity = this.dhT.dhQ;
        cw awx = pbActivity.awx();
        if (!((awx != null) & (awx.getPbData() != null)) || awx.getPbData().avE() == null || StringUtils.isNull(awx.getPbData().avE().getTitle())) {
            pbActivity2 = this.dhT.dhQ;
            com.baidu.tbadk.browser.f.t(pbActivity2.getActivity(), this.dhW.getLotteryInfo().avy().getLink());
        } else {
            pbActivity3 = this.dhT.dhQ;
            com.baidu.tbadk.browser.f.c(pbActivity3.getActivity(), awx.getPbData().avE().getTitle(), this.dhW.getLotteryInfo().avy().getLink());
        }
        if (awx != null && awx.getPbData() != null) {
            TiebaStatic.log(new aw("c10506").ac("fid", awx.getPbData().getForumId()).ac("tid", awx.getPbData().getThreadId()).ac("obj_locate", "1"));
        }
    }
}
