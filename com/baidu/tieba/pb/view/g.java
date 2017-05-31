package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eCk;
    private final /* synthetic */ PbActivity eCl;
    private final /* synthetic */ com.baidu.tieba.pb.data.f eqk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        super(j, j2);
        this.eCk = pbInterviewStatusView;
        this.eCl = pbActivity;
        this.eqk = fVar;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.eCk.b(this.eCl, this.eqk);
    }
}
