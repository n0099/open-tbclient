package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class l {
    private TextView bIC;
    private RelativeLayout cCH;
    private TextView cCI;
    private ImageView cCJ;
    private View rootView;

    public l(View view) {
        this.rootView = view;
        this.cCH = (RelativeLayout) view.findViewById(n.g.chosen_pb_reply_text);
        this.bIC = (TextView) view.findViewById(n.g.chosen_pb_reply_comment);
        this.cCI = (TextView) view.findViewById(n.g.chosen_pb_reply_number);
        this.cCJ = (ImageView) view.findViewById(n.g.chosen_pb_reply_share);
    }

    public void z(View.OnClickListener onClickListener) {
        this.cCH.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void A(View.OnClickListener onClickListener) {
        this.cCJ.setOnClickListener(onClickListener);
    }

    public void kt(String str) {
        this.cCI.setText(str);
    }

    public void tr() {
        as.i(this.rootView, n.f.bg_rec_lick);
        as.i(this.cCH, n.f.bg_rec_comment);
        as.b(this.bIC, n.d.cp_cont_c, 1);
        as.b(this.cCI, n.d.cp_cont_e, 1);
        as.c(this.cCJ, n.f.recommend_pb_share_selector);
    }
}
