package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fTu;
    private TextView fTv;
    private TextView fTw;
    private ImageView fTx;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fTu = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fTv = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fTw = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fTx = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fTu.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fTx.setOnClickListener(onClickListener);
    }

    public void td(String str) {
        this.fTw.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fTu, e.f.bg_rec_comment);
        al.c(this.fTv, e.d.cp_cont_c, 1);
        al.c(this.fTw, e.d.cp_cont_e, 1);
        al.c(this.fTx, e.f.recommend_pb_share_selector);
    }
}
