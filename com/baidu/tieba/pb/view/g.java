package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ PbInterviewStatusView exQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbInterviewStatusView pbInterviewStatusView) {
        this.exQ = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        CountDownTimer countDownTimer2;
        countDownTimer = this.exQ.exM;
        if (countDownTimer != null) {
            countDownTimer2 = this.exQ.exM;
            countDownTimer2.cancel();
        }
        aVar2 = this.exQ.exJ;
        aVar2.dismiss();
    }
}
