package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f {
    private RelativeLayout lAu;
    private TextView lAv;
    private TextView lAw;
    private ImageView lAx;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lAu = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lAv = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lAw = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lAx = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.lAu.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void R(View.OnClickListener onClickListener) {
        this.lAx.setOnClickListener(onClickListener);
    }

    public void PU(String str) {
        this.lAw.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lAu, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lAv, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.lAw, R.color.CAM_X0110, 1);
        ap.setImageResource(this.lAx, R.drawable.recommend_pb_share_selector);
    }
}
