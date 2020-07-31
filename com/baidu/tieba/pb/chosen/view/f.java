package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f {
    private RelativeLayout kgV;
    private TextView kgW;
    private TextView kgX;
    private ImageView kgY;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.kgV = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.kgW = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.kgX = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.kgY = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void P(View.OnClickListener onClickListener) {
        this.kgV.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.kgY.setOnClickListener(onClickListener);
    }

    public void Kq(String str) {
        this.kgX.setText(str);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ao.setBackgroundResource(this.kgV, R.drawable.bg_rec_comment);
        ao.setViewTextColor(this.kgW, R.color.cp_cont_c, 1);
        ao.setViewTextColor(this.kgX, R.color.cp_cont_e, 1);
        ao.setImageResource(this.kgY, R.drawable.recommend_pb_share_selector);
    }
}
