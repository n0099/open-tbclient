package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView dsp;
    private final /* synthetic */ PbActivity dsq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.dsp = pbInterviewStatusView;
        this.dsq = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.dsp.dsd;
        textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        String str;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        View view;
        ImageView imageView2;
        FrameLayout frameLayout;
        aw awVar = new aw("c11106");
        str = this.dsp.NS;
        TiebaStatic.log(awVar.ac("obj_id", str));
        this.dsp.dsm = false;
        textView = this.dsp.dsa;
        textView.setText(this.dsq.getPageContext().getPageActivity().getString(t.j.interview_live_start));
        textView2 = this.dsp.dsa;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.c(this.dsq.getPageContext().getPageActivity(), t.e.fontsize24));
        imageView = this.dsp.dsb;
        imageView.setVisibility(0);
        view = this.dsp.dsg;
        view.setVisibility(8);
        imageView2 = this.dsp.dsf;
        imageView2.setVisibility(0);
        frameLayout = this.dsp.dsc;
        frameLayout.setVisibility(8);
        this.dsp.setClickable(true);
        this.dsp.dsn = true;
    }
}
