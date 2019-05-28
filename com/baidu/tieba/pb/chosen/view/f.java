package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hAR;
    private TextView hAS;
    private TextView hAT;
    private ImageView hAU;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hAR = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hAS = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hAT = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hAU = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hAR.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void K(View.OnClickListener onClickListener) {
        this.hAU.setOnClickListener(onClickListener);
    }

    public void AU(String str) {
        this.hAT.setText(str);
    }

    public void onChangeSkinType() {
        al.k(this.rootView, R.drawable.bg_rec_lick);
        al.k(this.hAR, R.drawable.bg_rec_comment);
        al.f(this.hAS, R.color.cp_cont_c, 1);
        al.f(this.hAT, R.color.cp_cont_e, 1);
        al.c(this.hAU, (int) R.drawable.recommend_pb_share_selector);
    }
}
