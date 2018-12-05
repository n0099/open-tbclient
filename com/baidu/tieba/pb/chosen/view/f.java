package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fPF;
    private TextView fPG;
    private TextView fPH;
    private ImageView fPI;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fPF = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fPG = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fPH = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fPI = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fPF.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fPI.setOnClickListener(onClickListener);
    }

    public void sK(String str) {
        this.fPH.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fPF, e.f.bg_rec_comment);
        al.c(this.fPG, e.d.cp_cont_c, 1);
        al.c(this.fPH, e.d.cp_cont_e, 1);
        al.c(this.fPI, e.f.recommend_pb_share_selector);
    }
}
