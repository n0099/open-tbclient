package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eGF;
    private final /* synthetic */ PbActivity eGG;
    private final /* synthetic */ h exS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity, h hVar) {
        super(j, j2);
        this.eGF = pbInterviewStatusView;
        this.eGG = pbActivity;
        this.exS = hVar;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.eGF.b(this.eGG, this.exS);
    }
}
