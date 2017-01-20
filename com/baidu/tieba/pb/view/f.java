package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView eut;
    private final /* synthetic */ PbActivity euu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.eut = pbInterviewStatusView;
        this.euu = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.eut.euh;
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
        ar arVar = new ar("c11106");
        str = this.eut.Ql;
        TiebaStatic.log(arVar.ab("obj_id", str));
        this.eut.euq = false;
        textView = this.eut.eue;
        textView.setText(this.euu.getPageContext().getPageActivity().getString(r.l.interview_live_start));
        textView2 = this.eut.eue;
        textView2.setTextSize(0, com.baidu.adp.lib.util.k.e(this.euu.getPageContext().getPageActivity(), r.f.fontsize24));
        imageView = this.eut.euf;
        imageView.setVisibility(0);
        view = this.eut.euk;
        view.setVisibility(8);
        imageView2 = this.eut.euj;
        imageView2.setVisibility(0);
        frameLayout = this.eut.eug;
        frameLayout.setVisibility(8);
        this.eut.setClickable(true);
        this.eut.eur = true;
    }
}
