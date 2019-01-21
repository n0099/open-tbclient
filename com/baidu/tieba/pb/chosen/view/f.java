package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fTv;
    private TextView fTw;
    private TextView fTx;
    private ImageView fTy;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fTv = (RelativeLayout) view.findViewById(e.g.chosen_pb_reply_text);
        this.fTw = (TextView) view.findViewById(e.g.chosen_pb_reply_comment);
        this.fTx = (TextView) view.findViewById(e.g.chosen_pb_reply_number);
        this.fTy = (ImageView) view.findViewById(e.g.chosen_pb_reply_share);
    }

    public void G(View.OnClickListener onClickListener) {
        this.fTv.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void H(View.OnClickListener onClickListener) {
        this.fTy.setOnClickListener(onClickListener);
    }

    public void td(String str) {
        this.fTx.setText(str);
    }

    public void onChangeSkinType() {
        al.i(this.rootView, e.f.bg_rec_lick);
        al.i(this.fTv, e.f.bg_rec_comment);
        al.c(this.fTw, e.d.cp_cont_c, 1);
        al.c(this.fTx, e.d.cp_cont_e, 1);
        al.c(this.fTy, e.f.recommend_pb_share_selector);
    }
}
