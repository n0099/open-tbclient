package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fHr;
    private TextView fHs;
    private TextView fHt;
    private ImageView fHu;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fHr = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fHs = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fHt = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fHu = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fHr.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fHu.setOnClickListener(onClickListener);
    }

    public void sg(String str) {
        this.fHt.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fHr, e.f.bg_rec_comment);
        al.c(this.fHs, e.d.cp_cont_c, 1);
        al.c(this.fHt, e.d.cp_cont_e, 1);
        al.c(this.fHu, e.f.recommend_pb_share_selector);
    }
}
