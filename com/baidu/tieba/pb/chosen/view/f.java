package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f {
    private RelativeLayout iBn;
    private TextView iBo;
    private TextView iBp;
    private ImageView iBq;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.iBn = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.iBo = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.iBp = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.iBq = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void N(View.OnClickListener onClickListener) {
        this.iBn.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void O(View.OnClickListener onClickListener) {
        this.iBq.setOnClickListener(onClickListener);
    }

    public void FH(String str) {
        this.iBp.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.iBn, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.iBo, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.iBp, R.color.cp_cont_e, 1);
        am.setImageResource(this.iBq, R.drawable.recommend_pb_share_selector);
    }
}
