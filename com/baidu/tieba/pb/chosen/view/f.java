package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fbD;
    private TextView fbE;
    private TextView fbF;
    private ImageView fbG;
    private View rootView;

    public f(View view2) {
        this.rootView = view2;
        this.fbD = (RelativeLayout) view2.findViewById(d.g.chosen_pb_reply_text);
        this.fbE = (TextView) view2.findViewById(d.g.chosen_pb_reply_comment);
        this.fbF = (TextView) view2.findViewById(d.g.chosen_pb_reply_number);
        this.fbG = (ImageView) view2.findViewById(d.g.chosen_pb_reply_share);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fbD.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fbG.setOnClickListener(onClickListener);
    }

    public void qo(String str) {
        this.fbF.setText(str);
    }

    public void onChangeSkinType() {
        ak.i(this.rootView, d.f.bg_rec_lick);
        ak.i(this.fbD, d.f.bg_rec_comment);
        ak.c(this.fbE, d.C0126d.cp_cont_c, 1);
        ak.c(this.fbF, d.C0126d.cp_cont_e, 1);
        ak.c(this.fbG, d.f.recommend_pb_share_selector);
    }
}
