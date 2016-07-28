package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ PbInterviewStatusView elJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbInterviewStatusView pbInterviewStatusView) {
        this.elJ = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        CountDownTimer countDownTimer2;
        countDownTimer = this.elJ.elF;
        if (countDownTimer != null) {
            countDownTimer2 = this.elJ.elF;
            countDownTimer2.cancel();
        }
        aVar2 = this.elJ.elC;
        aVar2.dismiss();
    }
}
