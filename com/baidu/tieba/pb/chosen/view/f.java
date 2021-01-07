package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private TextView lFA;
    private TextView lFB;
    private ImageView lFC;
    private RelativeLayout lFz;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lFz = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lFA = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lFB = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lFC = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void S(View.OnClickListener onClickListener) {
        this.lFz.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void T(View.OnClickListener onClickListener) {
        this.lFC.setOnClickListener(onClickListener);
    }

    public void Pz(String str) {
        this.lFB.setText(str);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ao.setBackgroundResource(this.lFz, R.drawable.bg_rec_comment);
        ao.setViewTextColor(this.lFA, R.color.CAM_X0108, 1);
        ao.setViewTextColor(this.lFB, R.color.CAM_X0110, 1);
        ao.setImageResource(this.lFC, R.drawable.recommend_pb_share_selector);
    }
}
