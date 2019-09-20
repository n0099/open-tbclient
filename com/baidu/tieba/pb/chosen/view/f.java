package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hJU;
    private TextView hJV;
    private TextView hJW;
    private ImageView hJX;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hJU = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hJV = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hJW = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hJX = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void L(View.OnClickListener onClickListener) {
        this.hJU.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void M(View.OnClickListener onClickListener) {
        this.hJX.setOnClickListener(onClickListener);
    }

    public void Ci(String str) {
        this.hJW.setText(str);
    }

    public void onChangeSkinType() {
        am.k(this.rootView, R.drawable.bg_rec_lick);
        am.k(this.hJU, R.drawable.bg_rec_comment);
        am.f(this.hJV, R.color.cp_cont_c, 1);
        am.f(this.hJW, R.color.cp_cont_e, 1);
        am.c(this.hJX, (int) R.drawable.recommend_pb_share_selector);
    }
}
