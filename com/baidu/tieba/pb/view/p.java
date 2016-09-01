package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ PbInterviewStatusView exP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbInterviewStatusView pbInterviewStatusView) {
        this.exP = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        CountDownTimer countDownTimer2;
        countDownTimer = this.exP.exL;
        if (countDownTimer != null) {
            countDownTimer2 = this.exP.exL;
            countDownTimer2.cancel();
        }
        aVar2 = this.exP.exI;
        aVar2.dismiss();
    }
}
