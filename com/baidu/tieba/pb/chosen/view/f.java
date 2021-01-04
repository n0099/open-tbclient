package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private RelativeLayout lFA;
    private TextView lFB;
    private TextView lFC;
    private ImageView lFD;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lFA = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lFB = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lFC = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lFD = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lFA.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void T(View.OnClickListener onClickListener) {
        this.lFD.setOnClickListener(onClickListener);
    }

    public void PA(String str) {
        this.lFC.setText(str);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ao.setBackgroundResource(this.lFA, R.drawable.bg_rec_comment);
        ao.setViewTextColor(this.lFB, R.color.CAM_X0108, 1);
        ao.setViewTextColor(this.lFC, R.color.CAM_X0110, 1);
        ao.setImageResource(this.lFD, R.drawable.recommend_pb_share_selector);
    }
}
