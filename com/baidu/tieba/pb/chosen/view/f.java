package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fIP;
    private TextView fIQ;
    private TextView fIR;
    private ImageView fIS;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fIP = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fIQ = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fIR = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fIS = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fIP.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fIS.setOnClickListener(onClickListener);
    }

    public void sh(String str) {
        this.fIR.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fIP, e.f.bg_rec_comment);
        al.c(this.fIQ, e.d.cp_cont_c, 1);
        al.c(this.fIR, e.d.cp_cont_e, 1);
        al.c(this.fIS, e.f.recommend_pb_share_selector);
    }
}
