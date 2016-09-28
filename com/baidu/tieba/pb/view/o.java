package com.baidu.tieba.pb.view;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView ezW;
    private final /* synthetic */ PbActivity ezX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.ezW = pbInterviewStatusView;
        this.ezX = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.ezW.ezK;
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
        ax axVar = new ax("c11106");
        str = this.ezW.QJ;
        TiebaStatic.log(axVar.ab("obj_id", str));
        this.ezW.ezT = false;
        textView = this.ezW.ezH;
        textView.setText(this.ezX.getPageContext().getPageActivity().getString(r.j.interview_live_start));
        textView2 = this.ezW.ezH;
        textView2.setTextSize(0, k.e(this.ezX.getPageContext().getPageActivity(), r.e.fontsize24));
        imageView = this.ezW.ezI;
        imageView.setVisibility(0);
        view = this.ezW.ezN;
        view.setVisibility(8);
        imageView2 = this.ezW.ezM;
        imageView2.setVisibility(0);
        frameLayout = this.ezW.ezJ;
        frameLayout.setVisibility(8);
        this.ezW.setClickable(true);
        this.ezW.ezU = true;
    }
}
