package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f {
    private RelativeLayout lAs;
    private TextView lAt;
    private TextView lAu;
    private ImageView lAv;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lAs = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lAt = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lAu = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lAv = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.lAs.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void R(View.OnClickListener onClickListener) {
        this.lAv.setOnClickListener(onClickListener);
    }

    public void PU(String str) {
        this.lAu.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lAs, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lAt, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.lAu, R.color.CAM_X0110, 1);
        ap.setImageResource(this.lAv, R.drawable.recommend_pb_share_selector);
    }
}
