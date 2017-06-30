package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eLH;
    private final /* synthetic */ PbActivity eLI;
    private final /* synthetic */ TextView eLJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbActivity pbActivity) {
        super(j, j2);
        this.eLH = pbInterviewStatusView;
        this.eLJ = textView;
        this.eLI = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.eLJ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.eLH.eLA;
        if (aVar != null) {
            aVar2 = this.eLH.eLA;
            aVar2.dismiss();
        }
        if (this.eLI != null) {
            this.eLI.aOa();
        }
    }
}
