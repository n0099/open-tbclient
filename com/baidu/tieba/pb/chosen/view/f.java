package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fsl;
    private TextView fsm;
    private TextView fsn;
    private ImageView fso;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fsl = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.fsm = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.fsn = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.fso = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fsl.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fso.setOnClickListener(onClickListener);
    }

    public void qX(String str) {
        this.fsn.setText(str);
    }

    public void onChangeSkinType() {
        am.i(this.rootView, d.f.bg_rec_lick);
        am.i(this.fsl, d.f.bg_rec_comment);
        am.c(this.fsm, d.C0140d.cp_cont_c, 1);
        am.c(this.fsn, d.C0140d.cp_cont_e, 1);
        am.c(this.fso, d.f.recommend_pb_share_selector);
    }
}
