package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ PbInterviewStatusView ezW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbInterviewStatusView pbInterviewStatusView) {
        this.ezW = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        CountDownTimer countDownTimer2;
        countDownTimer = this.ezW.ezS;
        if (countDownTimer != null) {
            countDownTimer2 = this.ezW.ezS;
            countDownTimer2.cancel();
        }
        aVar2 = this.ezW.ezP;
        aVar2.dismiss();
    }
}
