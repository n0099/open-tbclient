package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hjI;
    private TextView hjJ;
    private TextView hjK;
    private ImageView hjL;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hjI = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.hjJ = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.hjK = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.hjL = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void H(View.OnClickListener onClickListener) {
        this.hjI.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void I(View.OnClickListener onClickListener) {
        this.hjL.setOnClickListener(onClickListener);
    }

    public void zF(String str) {
        this.hjK.setText(str);
    }

    public void onChangeSkinType() {
        al.k(this.rootView, d.f.bg_rec_lick);
        al.k(this.hjI, d.f.bg_rec_comment);
        al.d(this.hjJ, d.C0277d.cp_cont_c, 1);
        al.d(this.hjK, d.C0277d.cp_cont_e, 1);
        al.c(this.hjL, d.f.recommend_pb_share_selector);
    }
}
