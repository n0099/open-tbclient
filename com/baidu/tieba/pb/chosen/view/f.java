package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hjv;
    private TextView hjw;
    private TextView hjx;
    private ImageView hjy;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hjv = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.hjw = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.hjx = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.hjy = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void H(View.OnClickListener onClickListener) {
        this.hjv.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void I(View.OnClickListener onClickListener) {
        this.hjy.setOnClickListener(onClickListener);
    }

    public void zE(String str) {
        this.hjx.setText(str);
    }

    public void onChangeSkinType() {
        al.k(this.rootView, d.f.bg_rec_lick);
        al.k(this.hjv, d.f.bg_rec_comment);
        al.d(this.hjw, d.C0277d.cp_cont_c, 1);
        al.d(this.hjx, d.C0277d.cp_cont_e, 1);
        al.c(this.hjy, d.f.recommend_pb_share_selector);
    }
}
