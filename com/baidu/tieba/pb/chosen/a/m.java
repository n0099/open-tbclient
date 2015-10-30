package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m {
    private TextView bpM;
    private RelativeLayout cgc;
    private TextView cgd;
    private ImageView cge;
    private View rootView;

    public m(View view) {
        this.rootView = view;
        this.cgc = (RelativeLayout) view.findViewById(i.f.chosen_pb_reply_text);
        this.bpM = (TextView) view.findViewById(i.f.chosen_pb_reply_comment);
        this.cgd = (TextView) view.findViewById(i.f.chosen_pb_reply_number);
        this.cge = (ImageView) view.findViewById(i.f.chosen_pb_reply_share);
    }

    public void z(View.OnClickListener onClickListener) {
        this.cgc.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void A(View.OnClickListener onClickListener) {
        this.cge.setOnClickListener(onClickListener);
    }

    public void jF(String str) {
        this.cgd.setText(str);
    }

    public void sZ() {
        an.i(this.rootView, i.e.bg_rec_lick);
        an.i(this.cgc, i.e.bg_rec_comment);
        an.b(this.bpM, i.c.cp_cont_c, 1);
        an.b(this.cgd, i.c.cp_cont_e, 1);
        an.c(this.cge, i.e.recommend_pb_share_selector);
    }
}
