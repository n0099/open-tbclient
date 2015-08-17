package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m {
    private RelativeLayout bZS;
    private TextView bZT;
    private TextView bZU;
    private ImageView bZV;
    private View rootView;

    public m(View view) {
        this.rootView = view;
        this.bZS = (RelativeLayout) view.findViewById(i.f.chosen_pb_reply_text);
        this.bZT = (TextView) view.findViewById(i.f.chosen_pb_reply_comment);
        this.bZU = (TextView) view.findViewById(i.f.chosen_pb_reply_number);
        this.bZV = (ImageView) view.findViewById(i.f.chosen_pb_reply_share);
    }

    public void z(View.OnClickListener onClickListener) {
        this.bZS.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void A(View.OnClickListener onClickListener) {
        this.bZV.setOnClickListener(onClickListener);
    }

    public void jf(String str) {
        this.bZU.setText(str);
    }

    public void ta() {
        al.i(this.rootView, i.e.bg_rec_lick);
        al.i(this.bZS, i.e.bg_rec_comment);
        al.b(this.bZT, i.c.cp_cont_c, 1);
        al.b(this.bZU, i.c.cp_cont_e, 1);
        al.c(this.bZV, i.e.recommend_pb_share_selector);
    }
}
