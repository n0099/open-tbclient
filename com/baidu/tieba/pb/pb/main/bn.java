package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn implements a.b {
    final /* synthetic */ bh cGg;
    private final /* synthetic */ PbLotteryHttpResponseMessage cGh;
    private final /* synthetic */ String caQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bh bhVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage, String str) {
        this.cGg = bhVar;
        this.cGh = pbLotteryHttpResponseMessage;
        this.caQ = str;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        cf cfVar;
        PbActivity pbActivity3;
        cf cfVar2;
        PbActivity pbActivity4;
        cf cfVar3;
        PbActivity pbActivity5;
        cf cfVar4;
        aVar.dismiss();
        pbActivity = this.cGg.cFS;
        com.baidu.tbadk.browser.f.B(pbActivity.getActivity(), this.cGh.getLotteryInfo().getLink());
        pbActivity2 = this.cGg.cFS;
        cfVar = pbActivity2.cFl;
        if (cfVar != null) {
            pbActivity3 = this.cGg.cFS;
            cfVar2 = pbActivity3.cFl;
            if (cfVar2.getPbData() != null) {
                com.baidu.tbadk.core.util.av avVar = new com.baidu.tbadk.core.util.av("c10505");
                pbActivity4 = this.cGg.cFS;
                cfVar3 = pbActivity4.cFl;
                com.baidu.tbadk.core.util.av aa = avVar.aa(ImageViewerConfig.FORUM_ID, cfVar3.getPbData().getForumId());
                pbActivity5 = this.cGg.cFS;
                cfVar4 = pbActivity5.cFl;
                TiebaStatic.log(aa.aa("tid", cfVar4.getPbData().getThreadId()).aa("uid", this.caQ).aa("obj_locate", "1"));
            }
        }
    }
}
