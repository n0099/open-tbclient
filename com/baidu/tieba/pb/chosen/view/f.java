package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private TextView hIA;
    private TextView hIB;
    private ImageView hIC;
    private RelativeLayout hIz;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hIz = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hIA = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hIB = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hIC = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void M(View.OnClickListener onClickListener) {
        this.hIz.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hIC.setOnClickListener(onClickListener);
    }

    public void AB(String str) {
        this.hIB.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.hIz, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.hIA, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.hIB, R.color.cp_cont_e, 1);
        am.setImageResource(this.hIC, R.drawable.recommend_pb_share_selector);
    }
}
