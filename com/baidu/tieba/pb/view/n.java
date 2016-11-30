package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements a.b {
    final /* synthetic */ PbInterviewStatusView eGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbInterviewStatusView pbInterviewStatusView) {
        this.eGF = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        CountDownTimer countDownTimer2;
        countDownTimer = this.eGF.eGB;
        if (countDownTimer != null) {
            countDownTimer2 = this.eGF.eGB;
            countDownTimer2.cancel();
        }
        aVar2 = this.eGF.eGy;
        aVar2.dismiss();
    }
}
