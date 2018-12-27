package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private ImageView fSA;
    private RelativeLayout fSx;
    private TextView fSy;
    private TextView fSz;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fSx = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fSy = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fSz = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fSA = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fSx.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fSA.setOnClickListener(onClickListener);
    }

    public void sN(String str) {
        this.fSz.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fSx, e.f.bg_rec_comment);
        al.c(this.fSy, e.d.cp_cont_c, 1);
        al.c(this.fSz, e.d.cp_cont_e, 1);
        al.c(this.fSA, e.f.recommend_pb_share_selector);
    }
}
