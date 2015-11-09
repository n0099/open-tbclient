package com.baidu.tieba.pb.pb.main;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements a.b {
    final /* synthetic */ bc cjW;
    private final /* synthetic */ PbLotteryHttpResponseMessage cjX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bc bcVar, PbLotteryHttpResponseMessage pbLotteryHttpResponseMessage) {
        this.cjW = bcVar;
        this.cjX = pbLotteryHttpResponseMessage;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbActivity pbActivity;
        ca caVar;
        PbActivity pbActivity2;
        ca caVar2;
        PbActivity pbActivity3;
        PbActivity pbActivity4;
        ca caVar3;
        PbActivity pbActivity5;
        ca caVar4;
        PbActivity pbActivity6;
        PbActivity pbActivity7;
        ca caVar5;
        aVar.dismiss();
        pbActivity = this.cjW.cjN;
        caVar = pbActivity.cjj;
        boolean z = caVar != null;
        pbActivity2 = this.cjW.cjN;
        caVar2 = pbActivity2.cjj;
        if (z & (caVar2.getPbData() != null)) {
            pbActivity4 = this.cjW.cjN;
            caVar3 = pbActivity4.cjj;
            if (caVar3.getPbData().afh() != null) {
                pbActivity5 = this.cjW.cjN;
                caVar4 = pbActivity5.cjj;
                if (!StringUtils.isNull(caVar4.getPbData().afh().getTitle())) {
                    pbActivity6 = this.cjW.cjN;
                    Activity activity = pbActivity6.getActivity();
                    pbActivity7 = this.cjW.cjN;
                    caVar5 = pbActivity7.cjj;
                    com.baidu.tbadk.browser.g.f(activity, caVar5.getPbData().afh().getTitle(), this.cjX.getLotteryInfo().getLink());
                    return;
                }
            }
        }
        pbActivity3 = this.cjW.cjN;
        com.baidu.tbadk.browser.g.B(pbActivity3.getActivity(), this.cjX.getLotteryInfo().getLink());
    }
}
