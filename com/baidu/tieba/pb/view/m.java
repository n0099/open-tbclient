package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eGF;
    private final /* synthetic */ PbActivity eGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.eGF = pbInterviewStatusView;
        this.eGG = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.eGF.eGt;
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
        av avVar = new av("c11106");
        str = this.eGF.Rf;
        TiebaStatic.log(avVar.ab("obj_id", str));
        this.eGF.eGC = false;
        textView = this.eGF.eGq;
        textView.setText(this.eGG.getPageContext().getPageActivity().getString(r.j.interview_live_start));
        textView2 = this.eGF.eGq;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.e(this.eGG.getPageContext().getPageActivity(), r.e.fontsize24));
        imageView = this.eGF.eGr;
        imageView.setVisibility(0);
        view = this.eGF.eGw;
        view.setVisibility(8);
        imageView2 = this.eGF.eGv;
        imageView2.setVisibility(0);
        frameLayout = this.eGF.eGs;
        frameLayout.setVisibility(8);
        this.eGF.setClickable(true);
        this.eGF.eGD = true;
    }
}
