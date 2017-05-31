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
public class h extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eCk;
    private final /* synthetic */ PbActivity eCl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.eCk = pbInterviewStatusView;
        this.eCl = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.eCk.eBY;
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
        str = this.eCk.UX;
        TiebaStatic.log(asVar.Z("obj_id", str));
        this.eCk.eCh = false;
        textView = this.eCk.eBV;
        textView.setText(this.eCl.getPageContext().getPageActivity().getString(w.l.interview_live_start));
        textView2 = this.eCk.eBV;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eCl.getPageContext().getPageActivity(), w.f.fontsize24));
        imageView = this.eCk.eBW;
        imageView.setVisibility(0);
        view = this.eCk.eCb;
        view.setVisibility(8);
        imageView2 = this.eCk.eCa;
        imageView2.setVisibility(0);
        frameLayout = this.eCk.eBX;
        frameLayout.setVisibility(8);
        this.eCk.setClickable(true);
        this.eCk.eCi = true;
    }
}
