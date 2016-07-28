package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView elJ;
    private final /* synthetic */ PbActivity elK;
    private final /* synthetic */ TextView elL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbActivity pbActivity) {
        super(j, j2);
        this.elJ = pbInterviewStatusView;
        this.elL = textView;
        this.elK = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.elL.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.elJ.elC;
        if (aVar != null) {
            aVar2 = this.elJ.elC;
            aVar2.dismiss();
        }
        if (this.elK != null) {
            this.elK.aIm();
        }
    }
}
