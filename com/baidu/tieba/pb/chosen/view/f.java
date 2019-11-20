package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class f {
    private RelativeLayout hHI;
    private TextView hHJ;
    private TextView hHK;
    private ImageView hHL;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.hHI = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.hHJ = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.hHK = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.hHL = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void M(View.OnClickListener onClickListener) {
        this.hHI.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void N(View.OnClickListener onClickListener) {
        this.hHL.setOnClickListener(onClickListener);
    }

    public void AB(String str) {
        this.hHK.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.hHI, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.hHJ, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.hHK, R.color.cp_cont_e, 1);
        am.setImageResource(this.hHL, R.drawable.recommend_pb_share_selector);
    }
}
