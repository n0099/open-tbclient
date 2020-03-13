package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f {
    private TextView iBA;
    private TextView iBB;
    private ImageView iBC;
    private RelativeLayout iBz;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.iBz = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.iBA = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.iBB = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.iBC = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void N(View.OnClickListener onClickListener) {
        this.iBz.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void O(View.OnClickListener onClickListener) {
        this.iBC.setOnClickListener(onClickListener);
    }

    public void FI(String str) {
        this.iBB.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.iBz, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.iBA, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.iBB, R.color.cp_cont_e, 1);
        am.setImageResource(this.iBC, R.drawable.recommend_pb_share_selector);
    }
}
