package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eGF;
    private final /* synthetic */ PbActivity eGG;
    private final /* synthetic */ TextView eGH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbActivity pbActivity) {
        super(j, j2);
        this.eGF = pbInterviewStatusView;
        this.eGH = textView;
        this.eGG = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.eGH.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eGF.eGy;
        if (aVar != null) {
            aVar2 = this.eGF.eGy;
            aVar2.dismiss();
        }
        if (this.eGG != null) {
            this.eGG.aPB();
        }
    }
}
