package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hHY;
    private TextView hHZ;
    private TextView hIa;
    private ImageView hIb;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hHY = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hHZ = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hIa = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hIb = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hHY.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void M(View.OnClickListener onClickListener) {
        this.hIb.setOnClickListener(onClickListener);
    }

    public void BJ(String str) {
        this.hIa.setText(str);
    }

    public void onChangeSkinType() {
        am.k(this.rootView, R.drawable.bg_rec_lick);
        am.k(this.hHY, R.drawable.bg_rec_comment);
        am.f(this.hHZ, R.color.cp_cont_c, 1);
        am.f(this.hIa, R.color.cp_cont_e, 1);
        am.c(this.hIb, (int) R.drawable.recommend_pb_share_selector);
    }
}
