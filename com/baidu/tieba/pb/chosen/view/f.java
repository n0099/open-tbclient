package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f {
    private RelativeLayout lmS;
    private TextView lmT;
    private TextView lmU;
    private ImageView lmV;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lmS = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lmT = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lmU = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lmV = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.lmS.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void R(View.OnClickListener onClickListener) {
        this.lmV.setOnClickListener(onClickListener);
    }

    public void OM(String str) {
        this.lmU.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lmS, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lmT, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.lmU, R.color.CAM_X0110, 1);
        ap.setImageResource(this.lmV, R.drawable.recommend_pb_share_selector);
    }
}
