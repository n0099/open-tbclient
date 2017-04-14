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
    final /* synthetic */ PbInterviewStatusView evV;
    private final /* synthetic */ PbActivity evW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.evV = pbInterviewStatusView;
        this.evW = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.evV.evJ;
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
        str = this.evV.VP;
        TiebaStatic.log(asVar.aa("obj_id", str));
        this.evV.evS = false;
        textView = this.evV.evG;
        textView.setText(this.evW.getPageContext().getPageActivity().getString(w.l.interview_live_start));
        textView2 = this.evV.evG;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.g(this.evW.getPageContext().getPageActivity(), w.f.fontsize24));
        imageView = this.evV.evH;
        imageView.setVisibility(0);
        view = this.evV.evM;
        view.setVisibility(8);
        imageView2 = this.evV.evL;
        imageView2.setVisibility(0);
        frameLayout = this.evV.evI;
        frameLayout.setVisibility(8);
        this.evV.setClickable(true);
        this.evV.evT = true;
    }
}
