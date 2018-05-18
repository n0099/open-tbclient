package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fcK;
    private TextView fcL;
    private TextView fcM;
    private ImageView fcN;
    private View rootView;

    public f(View view2) {
        this.rootView = view2;
        this.fcK = (RelativeLayout) view2.findViewById(d.g.chosen_pb_reply_text);
        this.fcL = (TextView) view2.findViewById(d.g.chosen_pb_reply_comment);
        this.fcM = (TextView) view2.findViewById(d.g.chosen_pb_reply_number);
        this.fcN = (ImageView) view2.findViewById(d.g.chosen_pb_reply_share);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fcK.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fcN.setOnClickListener(onClickListener);
    }

    public void qr(String str) {
        this.fcM.setText(str);
    }

    public void onChangeSkinType() {
        ak.i(this.rootView, d.f.bg_rec_lick);
        ak.i(this.fcK, d.f.bg_rec_comment);
        ak.c(this.fcL, d.C0126d.cp_cont_c, 1);
        ak.c(this.fcM, d.C0126d.cp_cont_e, 1);
        ak.c(this.fcN, d.f.recommend_pb_share_selector);
    }
}
