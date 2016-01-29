package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class l {
    private View azA;
    private RelativeLayout cJm;
    private TextView cJn;
    private TextView cJo;
    private ImageView cJp;

    public l(View view) {
        this.azA = view;
        this.cJm = (RelativeLayout) view.findViewById(t.g.chosen_pb_reply_text);
        this.cJn = (TextView) view.findViewById(t.g.chosen_pb_reply_comment);
        this.cJo = (TextView) view.findViewById(t.g.chosen_pb_reply_number);
        this.cJp = (ImageView) view.findViewById(t.g.chosen_pb_reply_share);
    }

    public void F(View.OnClickListener onClickListener) {
        this.cJm.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.azA.setVisibility(z ? 0 : 8);
    }

    public void G(View.OnClickListener onClickListener) {
        this.cJp.setOnClickListener(onClickListener);
    }

    public void kw(String str) {
        this.cJo.setText(str);
    }

    public void uv() {
        ar.k(this.azA, t.f.bg_rec_lick);
        ar.k(this.cJm, t.f.bg_rec_comment);
        ar.b(this.cJn, t.d.cp_cont_c, 1);
        ar.b(this.cJo, t.d.cp_cont_e, 1);
        ar.c(this.cJp, t.f.recommend_pb_share_selector);
    }
}
