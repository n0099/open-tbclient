package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ PbInterviewStatusView eCk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbInterviewStatusView pbInterviewStatusView) {
        this.eCk = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        com.baidu.tbadk.core.dialog.a aVar3;
        CountDownTimer countDownTimer2;
        countDownTimer = this.eCk.eCg;
        if (countDownTimer != null) {
            countDownTimer2 = this.eCk.eCg;
            countDownTimer2.cancel();
        }
        aVar2 = this.eCk.eCd;
        if (aVar2 != null) {
            aVar3 = this.eCk.eCd;
            aVar3.dismiss();
        }
    }
}
