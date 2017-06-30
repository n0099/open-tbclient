package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.w;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eLH;
    private final /* synthetic */ PbActivity eLI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.eLH = pbInterviewStatusView;
        this.eLI = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.eLH.eLv;
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
        au auVar = new au("c11106");
        str = this.eLH.UW;
        TiebaStatic.log(auVar.Z("obj_id", str));
        this.eLH.eLE = false;
        textView = this.eLH.eLs;
        textView.setText(this.eLI.getPageContext().getPageActivity().getString(w.l.interview_live_start));
        textView2 = this.eLH.eLs;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.g(this.eLI.getPageContext().getPageActivity(), w.f.fontsize24));
        imageView = this.eLH.eLt;
        imageView.setVisibility(0);
        view = this.eLH.eLy;
        view.setVisibility(8);
        imageView2 = this.eLH.eLx;
        imageView2.setVisibility(0);
        frameLayout = this.eLH.eLu;
        frameLayout.setVisibility(8);
        this.eLH.setClickable(true);
        this.eLH.eLF = true;
    }
}
