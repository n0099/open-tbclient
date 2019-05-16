package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hAO;
    private TextView hAP;
    private TextView hAQ;
    private ImageView hAR;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hAO = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hAP = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hAQ = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hAR = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void J(View.OnClickListener onClickListener) {
        this.hAO.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void K(View.OnClickListener onClickListener) {
        this.hAR.setOnClickListener(onClickListener);
    }

    public void AU(String str) {
        this.hAQ.setText(str);
    }

    public void onChangeSkinType() {
        al.k(this.rootView, R.drawable.bg_rec_lick);
        al.k(this.hAO, R.drawable.bg_rec_comment);
        al.f(this.hAP, R.color.cp_cont_c, 1);
        al.f(this.hAQ, R.color.cp_cont_e, 1);
        al.c(this.hAR, (int) R.drawable.recommend_pb_share_selector);
    }
}
