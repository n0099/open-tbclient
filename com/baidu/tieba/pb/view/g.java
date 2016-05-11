package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.b {
    final /* synthetic */ PbInterviewStatusView dsp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbInterviewStatusView pbInterviewStatusView) {
        this.dsp = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        CountDownTimer countDownTimer2;
        countDownTimer = this.dsp.dsl;
        if (countDownTimer != null) {
            countDownTimer2 = this.dsp.dsl;
            countDownTimer2.cancel();
        }
        aVar2 = this.dsp.dsi;
        aVar2.dismiss();
    }
}
