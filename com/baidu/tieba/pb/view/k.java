package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eCk;
    private final /* synthetic */ PbActivity eCl;
    private final /* synthetic */ TextView eCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbActivity pbActivity) {
        super(j, j2);
        this.eCk = pbInterviewStatusView;
        this.eCm = textView;
        this.eCl = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.eCm.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eCk.eCd;
        if (aVar != null) {
            aVar2 = this.eCk.eCd;
            aVar2.dismiss();
        }
        if (this.eCl != null) {
            this.eCl.aKd();
        }
    }
}
