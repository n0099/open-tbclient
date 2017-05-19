package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ PbInterviewStatusView etW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbInterviewStatusView pbInterviewStatusView) {
        this.etW = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        CountDownTimer countDownTimer2;
        countDownTimer = this.etW.etS;
        if (countDownTimer != null) {
            countDownTimer2 = this.etW.etS;
            countDownTimer2.cancel();
        }
        aVar2 = this.etW.etP;
        if (aVar2 != null) {
            aVar3 = this.etW.etP;
            aVar3.dismiss();
        }
    }
}
