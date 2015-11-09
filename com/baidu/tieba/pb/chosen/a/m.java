package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m {
    private TextView bqq;
    private RelativeLayout cgE;
    private TextView cgF;
    private ImageView cgG;
    private View rootView;

    public m(View view) {
        this.rootView = view;
        this.cgE = (RelativeLayout) view.findViewById(i.f.chosen_pb_reply_text);
        this.bqq = (TextView) view.findViewById(i.f.chosen_pb_reply_comment);
        this.cgF = (TextView) view.findViewById(i.f.chosen_pb_reply_number);
        this.cgG = (ImageView) view.findViewById(i.f.chosen_pb_reply_share);
    }

    public void z(View.OnClickListener onClickListener) {
        this.cgE.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void A(View.OnClickListener onClickListener) {
        this.cgG.setOnClickListener(onClickListener);
    }

    public void jH(String str) {
        this.cgF.setText(str);
    }

    public void tc() {
        an.i(this.rootView, i.e.bg_rec_lick);
        an.i(this.cgE, i.e.bg_rec_comment);
        an.b(this.bqq, i.c.cp_cont_c, 1);
        an.b(this.cgF, i.c.cp_cont_e, 1);
        an.c(this.cgG, i.e.recommend_pb_share_selector);
    }
}
