package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hAS;
    private TextView hAT;
    private TextView hAU;
    private ImageView hAV;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hAS = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hAT = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hAU = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hAV = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hAS.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void K(View.OnClickListener onClickListener) {
        this.hAV.setOnClickListener(onClickListener);
    }

    public void AW(String str) {
        this.hAU.setText(str);
    }

    public void onChangeSkinType() {
        al.k(this.rootView, R.drawable.bg_rec_lick);
        al.k(this.hAS, R.drawable.bg_rec_comment);
        al.f(this.hAT, R.color.cp_cont_c, 1);
        al.f(this.hAU, R.color.cp_cont_e, 1);
        al.c(this.hAV, (int) R.drawable.recommend_pb_share_selector);
    }
}
