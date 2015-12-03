package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l {
    private TextView bAN;
    private RelativeLayout czb;
    private TextView czc;
    private ImageView czd;
    private View rootView;

    public l(View view) {
        this.rootView = view;
        this.czb = (RelativeLayout) view.findViewById(n.f.chosen_pb_reply_text);
        this.bAN = (TextView) view.findViewById(n.f.chosen_pb_reply_comment);
        this.czc = (TextView) view.findViewById(n.f.chosen_pb_reply_number);
        this.czd = (ImageView) view.findViewById(n.f.chosen_pb_reply_share);
    }

    public void z(View.OnClickListener onClickListener) {
        this.czb.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void A(View.OnClickListener onClickListener) {
        this.czd.setOnClickListener(onClickListener);
    }

    public void kw(String str) {
        this.czc.setText(str);
    }

    public void tH() {
        as.i(this.rootView, n.e.bg_rec_lick);
        as.i(this.czb, n.e.bg_rec_comment);
        as.b(this.bAN, n.c.cp_cont_c, 1);
        as.b(this.czc, n.c.cp_cont_e, 1);
        as.c(this.czd, n.e.recommend_pb_share_selector);
    }
}
