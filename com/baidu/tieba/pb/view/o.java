package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView exP;
    private final /* synthetic */ PbActivity exQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.exP = pbInterviewStatusView;
        this.exQ = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.exP.exD;
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
        ay ayVar = new ay("c11106");
        str = this.exP.QF;
        TiebaStatic.log(ayVar.ab("obj_id", str));
        this.exP.exM = false;
        textView = this.exP.exA;
        textView.setText(this.exQ.getPageContext().getPageActivity().getString(t.j.interview_live_start));
        textView2 = this.exP.exA;
        textView2.setTextSize(0, k.e(this.exQ.getPageContext().getPageActivity(), t.e.fontsize24));
        imageView = this.exP.exB;
        imageView.setVisibility(0);
        view = this.exP.exG;
        view.setVisibility(8);
        imageView2 = this.exP.exF;
        imageView2.setVisibility(0);
        frameLayout = this.exP.exC;
        frameLayout.setVisibility(8);
        this.exP.setClickable(true);
        this.exP.exN = true;
    }
}
