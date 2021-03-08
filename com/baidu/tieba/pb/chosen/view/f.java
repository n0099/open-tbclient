package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class f {
    private RelativeLayout lLX;
    private TextView lLY;
    private TextView lLZ;
    private ImageView lMa;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lLX = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lLY = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lLZ = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lMa = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void T(View.OnClickListener onClickListener) {
        this.lLX.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void U(View.OnClickListener onClickListener) {
        this.lMa.setOnClickListener(onClickListener);
    }

    public void Pq(String str) {
        this.lLZ.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lLX, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lLY, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.lLZ, R.color.CAM_X0110, 1);
        ap.setImageResource(this.lMa, R.drawable.recommend_pb_share_selector);
    }
}
