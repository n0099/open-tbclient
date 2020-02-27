package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f {
    private RelativeLayout iBl;
    private TextView iBm;
    private TextView iBn;
    private ImageView iBo;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.iBl = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.iBm = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.iBn = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.iBo = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void N(View.OnClickListener onClickListener) {
        this.iBl.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void O(View.OnClickListener onClickListener) {
        this.iBo.setOnClickListener(onClickListener);
    }

    public void FH(String str) {
        this.iBn.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.iBl, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.iBm, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.iBn, R.color.cp_cont_e, 1);
        am.setImageResource(this.iBo, R.drawable.recommend_pb_share_selector);
    }
}
