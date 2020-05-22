package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f {
    private RelativeLayout jDF;
    private TextView jDG;
    private TextView jDH;
    private ImageView jDI;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.jDF = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.jDG = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.jDH = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.jDI = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void O(View.OnClickListener onClickListener) {
        this.jDF.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void P(View.OnClickListener onClickListener) {
        this.jDI.setOnClickListener(onClickListener);
    }

    public void Jb(String str) {
        this.jDH.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.jDF, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.jDG, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jDH, R.color.cp_cont_e, 1);
        am.setImageResource(this.jDI, R.drawable.recommend_pb_share_selector);
    }
}
