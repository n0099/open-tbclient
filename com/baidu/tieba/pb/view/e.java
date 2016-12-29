package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CountDownTimer {
    private final /* synthetic */ com.baidu.tieba.pb.data.f eck;
    final /* synthetic */ PbInterviewStatusView eky;
    private final /* synthetic */ PbActivity ekz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        super(j, j2);
        this.eky = pbInterviewStatusView;
        this.ekz = pbActivity;
        this.eck = fVar;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.eky.b(this.ekz, this.eck);
    }
}
