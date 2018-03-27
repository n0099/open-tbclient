package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fHb;
    private TextView fHc;
    private TextView fHd;
    private ImageView fHe;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fHb = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.fHc = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.fHd = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.fHe = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void C(View.OnClickListener onClickListener) {
        this.fHb.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fHe.setOnClickListener(onClickListener);
    }

    public void qi(String str) {
        this.fHd.setText(str);
    }

    public void onChangeSkinType() {
        aj.s(this.rootView, d.f.bg_rec_lick);
        aj.s(this.fHb, d.f.bg_rec_comment);
        aj.e(this.fHc, d.C0141d.cp_cont_c, 1);
        aj.e(this.fHd, d.C0141d.cp_cont_e, 1);
        aj.c(this.fHe, d.f.recommend_pb_share_selector);
    }
}
