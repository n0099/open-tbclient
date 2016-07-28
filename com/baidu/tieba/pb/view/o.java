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
import com.baidu.tieba.u;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends CountDownTimer {
    final /* synthetic */ PbInterviewStatusView elJ;
    private final /* synthetic */ PbActivity elK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbActivity pbActivity) {
        super(j, j2);
        this.elJ = pbInterviewStatusView;
        this.elK = pbActivity;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        textView = this.elJ.elx;
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
        str = this.elJ.NX;
        TiebaStatic.log(ayVar.ab("obj_id", str));
        this.elJ.elG = false;
        textView = this.elJ.elu;
        textView.setText(this.elK.getPageContext().getPageActivity().getString(u.j.interview_live_start));
        textView2 = this.elJ.elu;
        textView2.setTextSize(0, k.c(this.elK.getPageContext().getPageActivity(), u.e.fontsize24));
        imageView = this.elJ.elv;
        imageView.setVisibility(0);
        view = this.elJ.elA;
        view.setVisibility(8);
        imageView2 = this.elJ.elz;
        imageView2.setVisibility(0);
        frameLayout = this.elJ.elw;
        frameLayout.setVisibility(8);
        this.elJ.setClickable(true);
        this.elJ.elH = true;
    }
}
