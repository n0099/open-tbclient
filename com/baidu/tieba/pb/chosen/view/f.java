package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fzO;
    private TextView fzP;
    private TextView fzQ;
    private ImageView fzR;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fzO = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fzP = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fzQ = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fzR = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fzO.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fzR.setOnClickListener(onClickListener);
    }

    public void rG(String str) {
        this.fzQ.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fzO, e.f.bg_rec_comment);
        al.c(this.fzP, e.d.cp_cont_c, 1);
        al.c(this.fzQ, e.d.cp_cont_e, 1);
        al.c(this.fzR, e.f.recommend_pb_share_selector);
    }
}
