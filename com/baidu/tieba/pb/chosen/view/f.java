package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f {
    private RelativeLayout jEL;
    private TextView jEM;
    private TextView jEN;
    private ImageView jEO;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.jEL = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.jEM = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.jEN = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.jEO = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void O(View.OnClickListener onClickListener) {
        this.jEL.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void P(View.OnClickListener onClickListener) {
        this.jEO.setOnClickListener(onClickListener);
    }

    public void Jc(String str) {
        this.jEN.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.jEL, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.jEM, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jEN, R.color.cp_cont_e, 1);
        am.setImageResource(this.jEO, R.drawable.recommend_pb_share_selector);
    }
}
