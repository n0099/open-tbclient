package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView dsp;
    private final /* synthetic */ PbActivity dsq;
    private final /* synthetic */ TextView dsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbActivity pbActivity) {
        super(j, j2);
        this.dsp = pbInterviewStatusView;
        this.dsr = textView;
        this.dsq = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.dsr.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.dsp.dsi;
        if (aVar != null) {
            aVar2 = this.dsp.dsi;
            aVar2.dismiss();
        }
        if (this.dsq != null) {
            this.dsq.awS();
        }
    }
}
