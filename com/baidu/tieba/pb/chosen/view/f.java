package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private RelativeLayout lJH;
    private TextView lJI;
    private TextView lJJ;
    private ImageView lJK;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lJH = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lJI = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lJJ = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lJK = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lJH.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void T(View.OnClickListener onClickListener) {
        this.lJK.setOnClickListener(onClickListener);
    }

    public void Pj(String str) {
        this.lJJ.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lJH, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lJI, R.color.CAM_X0108, 1);
        ap.setViewTextColor(this.lJJ, R.color.CAM_X0110, 1);
        ap.setImageResource(this.lJK, R.drawable.recommend_pb_share_selector);
    }
}
