package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m {
    private TextView bpB;
    private RelativeLayout cfR;
    private TextView cfS;
    private ImageView cfT;
    private View rootView;

    public m(View view) {
        this.rootView = view;
        this.cfR = (RelativeLayout) view.findViewById(i.f.chosen_pb_reply_text);
        this.bpB = (TextView) view.findViewById(i.f.chosen_pb_reply_comment);
        this.cfS = (TextView) view.findViewById(i.f.chosen_pb_reply_number);
        this.cfT = (ImageView) view.findViewById(i.f.chosen_pb_reply_share);
    }

    public void z(View.OnClickListener onClickListener) {
        this.cfR.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void A(View.OnClickListener onClickListener) {
        this.cfT.setOnClickListener(onClickListener);
    }

    public void jF(String str) {
        this.cfS.setText(str);
    }

    public void tc() {
        am.i(this.rootView, i.e.bg_rec_lick);
        am.i(this.cfR, i.e.bg_rec_comment);
        am.b(this.bpB, i.c.cp_cont_c, 1);
        am.b(this.cfS, i.c.cp_cont_e, 1);
        am.c(this.cfT, i.e.recommend_pb_share_selector);
    }
}
