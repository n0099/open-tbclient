package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f {
    private RelativeLayout lAU;
    private TextView lAV;
    private TextView lAW;
    private ImageView lAX;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lAU = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lAV = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lAW = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lAX = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lAU.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void T(View.OnClickListener onClickListener) {
        this.lAX.setOnClickListener(onClickListener);
    }

    public void Or(String str) {
        this.lAW.setText(str);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ao.setBackgroundResource(this.lAU, R.drawable.bg_rec_comment);
        ao.setViewTextColor(this.lAV, R.color.CAM_X0108, 1);
        ao.setViewTextColor(this.lAW, R.color.CAM_X0110, 1);
        ao.setImageResource(this.lAX, R.drawable.recommend_pb_share_selector);
    }
}
