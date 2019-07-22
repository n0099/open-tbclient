package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hHg;
    private TextView hHh;
    private TextView hHi;
    private ImageView hHj;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hHg = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hHh = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hHi = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hHj = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hHg.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void M(View.OnClickListener onClickListener) {
        this.hHj.setOnClickListener(onClickListener);
    }

    public void BI(String str) {
        this.hHi.setText(str);
    }

    public void onChangeSkinType() {
        am.k(this.rootView, R.drawable.bg_rec_lick);
        am.k(this.hHg, R.drawable.bg_rec_comment);
        am.f(this.hHh, R.color.cp_cont_c, 1);
        am.f(this.hHi, R.color.cp_cont_e, 1);
        am.c(this.hHj, (int) R.drawable.recommend_pb_share_selector);
    }
}
