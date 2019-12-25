package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f {
    private RelativeLayout ivM;
    private TextView ivN;
    private TextView ivO;
    private ImageView ivP;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.ivM = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.ivN = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.ivO = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.ivP = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void N(View.OnClickListener onClickListener) {
        this.ivM.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void O(View.OnClickListener onClickListener) {
        this.ivP.setOnClickListener(onClickListener);
    }

    public void Fi(String str) {
        this.ivO.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.ivM, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.ivN, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.ivO, R.color.cp_cont_e, 1);
        am.setImageResource(this.ivP, R.drawable.recommend_pb_share_selector);
    }
}
