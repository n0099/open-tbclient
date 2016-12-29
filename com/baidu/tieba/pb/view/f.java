package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eky;
    private final /* synthetic */ PbActivity ekz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.eky = pbInterviewStatusView;
        this.ekz = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.eky.ekm;
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
        at atVar = new at("c11106");
        str = this.eky.Rc;
        TiebaStatic.log(atVar.ab("obj_id", str));
        this.eky.ekv = false;
        textView = this.eky.ekj;
        textView.setText(this.ekz.getPageContext().getPageActivity().getString(r.j.interview_live_start));
        textView2 = this.eky.ekj;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.e(this.ekz.getPageContext().getPageActivity(), r.e.fontsize24));
        imageView = this.eky.ekk;
        imageView.setVisibility(0);
        view = this.eky.ekp;
        view.setVisibility(8);
        imageView2 = this.eky.eko;
        imageView2.setVisibility(0);
        frameLayout = this.eky.ekl;
        frameLayout.setVisibility(8);
        this.eky.setClickable(true);
        this.eky.ekw = true;
    }
}
