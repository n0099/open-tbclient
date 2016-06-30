package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView dZh;
    private final /* synthetic */ PbActivity dZi;
    private final /* synthetic */ TextView dZj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbActivity pbActivity) {
        super(j, j2);
        this.dZh = pbInterviewStatusView;
        this.dZj = textView;
        this.dZi = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        this.dZj.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.baidu.tbadk.core.dialog.a aVar;
        com.baidu.tbadk.core.dialog.a aVar2;
        aVar = this.dZh.dZa;
        if (aVar != null) {
            aVar2 = this.dZh.dZa;
            aVar2.dismiss();
        }
        if (this.dZi != null) {
            this.dZi.aFb();
        }
    }
}
