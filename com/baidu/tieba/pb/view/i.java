package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eyn;
    private final /* synthetic */ PbActivity eyo;
    private final /* synthetic */ TextView eyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbActivity pbActivity) {
        super(j, j2);
        this.eyn = pbInterviewStatusView;
        this.eyp = textView;
        this.eyo = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.eyp.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eyn.eyf;
        if (aVar != null) {
            aVar2 = this.eyn.eyf;
            aVar2.dismiss();
        }
        if (this.eyo != null) {
            this.eyo.aLO();
        }
    }
}
