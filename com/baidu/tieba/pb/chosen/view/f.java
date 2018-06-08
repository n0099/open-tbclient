package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fof;
    private TextView fog;
    private TextView foh;
    private ImageView foi;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fof = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.fog = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.foh = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.foi = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fof.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void E(View.OnClickListener onClickListener) {
        this.foi.setOnClickListener(onClickListener);
    }

    public void rf(String str) {
        this.foh.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, d.f.bg_rec_lick);
        al.i(this.fof, d.f.bg_rec_comment);
        al.c(this.fog, d.C0141d.cp_cont_c, 1);
        al.c(this.foh, d.C0141d.cp_cont_e, 1);
        al.c(this.foi, d.f.recommend_pb_share_selector);
    }
}
