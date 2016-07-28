package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends CountDownTimer {
    private final /* synthetic */ h edV;
    final /* synthetic */ PbInterviewStatusView elJ;
    private final /* synthetic */ PbActivity elK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity, h hVar) {
        super(j, j2);
        this.elJ = pbInterviewStatusView;
        this.elK = pbActivity;
        this.edV = hVar;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.elJ.b(this.elK, this.edV);
    }
}
