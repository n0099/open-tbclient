package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout frZ;
    private TextView fsa;
    private TextView fsb;
    private ImageView fsc;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.frZ = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.fsa = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.fsb = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.fsc = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void G(View.OnClickListener onClickListener) {
        this.frZ.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fsc.setOnClickListener(onClickListener);
    }

    public void re(String str) {
        this.fsb.setText(str);
    }

    public void onChangeSkinType() {
        am.i(this.rootView, d.f.bg_rec_lick);
        am.i(this.frZ, d.f.bg_rec_comment);
        am.c(this.fsa, d.C0142d.cp_cont_c, 1);
        am.c(this.fsb, d.C0142d.cp_cont_e, 1);
        am.c(this.fsc, d.f.recommend_pb_share_selector);
    }
}
