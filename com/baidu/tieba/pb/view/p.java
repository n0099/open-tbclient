package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tbadk.core.dialog.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.b {
    final /* synthetic */ PbInterviewStatusView dZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbInterviewStatusView pbInterviewStatusView) {
        this.dZh = pbInterviewStatusView;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        CountDownTimer countDownTimer;
        com.baidu.tbadk.core.dialog.a aVar2;
        CountDownTimer countDownTimer2;
        countDownTimer = this.dZh.dZd;
        if (countDownTimer != null) {
            countDownTimer2 = this.dZh.dZd;
            countDownTimer2.cancel();
        }
        aVar2 = this.dZh.dZa;
        aVar2.dismiss();
    }
}
