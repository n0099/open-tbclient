package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private RelativeLayout lJV;
    private TextView lJW;
    private TextView lJX;
    private ImageView lJY;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lJV = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lJW = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lJX = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lJY = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lJV.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void T(View.OnClickListener onClickListener) {
        this.lJY.setOnClickListener(onClickListener);
    }

    public void Pk(String str) {
        this.lJX.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lJV, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lJW, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.lJX, R.color.CAM_X0110, 1);
        ap.setImageResource(this.lJY, R.drawable.recommend_pb_share_selector);
    }
}
