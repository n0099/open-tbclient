package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements a.b {
    private final /* synthetic */ String bWR;
    final /* synthetic */ be cCv;
    private final /* synthetic */ PbLotteryHttpResponseMessage cCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(be beVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cCv = beVar;
        this.cCw = pbLotteryHttpResponseMessage;
        this.bWR = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        cc ccVar;
        PbActivity pbActivity3;
        cc ccVar2;
        PbActivity pbActivity4;
        cc ccVar3;
        PbActivity pbActivity5;
        cc ccVar4;
        aVar.dismiss();
        pbActivity = this.cCv.cCm;
        com.baidu.tbadk.browser.f.B(pbActivity.getActivity(), this.cCw.getLotteryInfo().getLink());
        pbActivity2 = this.cCv.cCm;
        ccVar = pbActivity2.cBG;
        if (ccVar != null) {
            pbActivity3 = this.cCv.cCm;
            ccVar2 = pbActivity3.cBG;
            if (ccVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10505");
                pbActivity4 = this.cCv.cCm;
                ccVar3 = pbActivity4.cBG;
                com.baidu.tbadk.core.util.av ab = avVar.ab(ImageViewerConfig.FORUM_ID, ccVar3.getPbData().getForumId());
                pbActivity5 = this.cCv.cCm;
                ccVar4 = pbActivity5.cBG;
                TiebaStatic.log(ab.ab("tid", ccVar4.getPbData().getThreadId()).ab("uid", this.bWR).ab("obj_locate", "1"));
            }
        }
    }
}
