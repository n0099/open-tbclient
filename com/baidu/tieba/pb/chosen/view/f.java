package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f {
    private RelativeLayout lmC;
    private TextView lmD;
    private TextView lmE;
    private ImageView lmF;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lmC = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lmD = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lmE = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lmF = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void R(View.OnClickListener onClickListener) {
        this.lmC.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lmF.setOnClickListener(onClickListener);
    }

    public void Pq(String str) {
        this.lmE.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lmC, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lmD, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.lmE, R.color.cp_cont_e, 1);
        ap.setImageResource(this.lmF, R.drawable.recommend_pb_share_selector);
    }
}
