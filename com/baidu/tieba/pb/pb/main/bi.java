package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements a.b {
    final /* synthetic */ bc cjW;
    private final /* synthetic */ PbLotteryHttpResponseMessage cjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bc bcVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        this.cjW = bcVar;
        this.cjX = pbLotteryHttpResponseMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        aVar.dismiss();
        pbActivity = this.cjW.cjN;
        com.baidu.tbadk.browser.g.B(pbActivity.getActivity(), this.cjX.getLotteryInfo().getLink());
    }
}
