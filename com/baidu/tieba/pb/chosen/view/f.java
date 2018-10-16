package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fHq;
    private TextView fHr;
    private TextView fHs;
    private ImageView fHt;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fHq = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fHr = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fHs = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fHt = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fHq.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fHt.setOnClickListener(onClickListener);
    }

    public void sg(String str) {
        this.fHs.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fHq, e.f.bg_rec_comment);
        al.c(this.fHr, e.d.cp_cont_c, 1);
        al.c(this.fHs, e.d.cp_cont_e, 1);
        al.c(this.fHt, e.f.recommend_pb_share_selector);
    }
}
