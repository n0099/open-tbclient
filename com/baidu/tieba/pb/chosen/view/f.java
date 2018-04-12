package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fbG;
    private TextView fbH;
    private TextView fbI;
    private ImageView fbJ;
    private View rootView;

    public f(View view2) {
        this.rootView = view2;
        this.fbG = (RelativeLayout) view2.findViewById(d.g.chosen_pb_reply_text);
        this.fbH = (TextView) view2.findViewById(d.g.chosen_pb_reply_comment);
        this.fbI = (TextView) view2.findViewById(d.g.chosen_pb_reply_number);
        this.fbJ = (ImageView) view2.findViewById(d.g.chosen_pb_reply_share);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fbG.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fbJ.setOnClickListener(onClickListener);
    }

    public void qo(String str) {
        this.fbI.setText(str);
    }

    public void onChangeSkinType() {
        ak.i(this.rootView, d.f.bg_rec_lick);
        ak.i(this.fbG, d.f.bg_rec_comment);
        ak.c(this.fbH, d.C0126d.cp_cont_c, 1);
        ak.c(this.fbI, d.C0126d.cp_cont_e, 1);
        ak.c(this.fbJ, d.f.recommend_pb_share_selector);
    }
}
