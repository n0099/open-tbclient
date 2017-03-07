package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView exQ;
    private final /* synthetic */ PbActivity exR;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.exQ = pbInterviewStatusView;
        this.exR = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.exQ.exE;
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
        as asVar = new as("c11106");
        str = this.exQ.Vy;
        TiebaStatic.log(asVar.Z("obj_id", str));
        this.exQ.exN = false;
        textView = this.exQ.exB;
        textView.setText(this.exR.getPageContext().getPageActivity().getString(w.l.interview_live_start));
        textView2 = this.exQ.exB;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.g(this.exR.getPageContext().getPageActivity(), w.f.fontsize24));
        imageView = this.exQ.exC;
        imageView.setVisibility(0);
        view = this.exQ.exH;
        view.setVisibility(8);
        imageView2 = this.exQ.exG;
        imageView2.setVisibility(0);
        frameLayout = this.exQ.exD;
        frameLayout.setVisibility(8);
        this.exQ.setClickable(true);
        this.exQ.exO = true;
    }
}
