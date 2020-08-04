package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f {
    private RelativeLayout kgX;
    private TextView kgY;
    private TextView kgZ;
    private ImageView kha;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.kgX = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.kgY = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.kgZ = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.kha = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void P(View.OnClickListener onClickListener) {
        this.kgX.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.kha.setOnClickListener(onClickListener);
    }

    public void Kq(String str) {
        this.kgZ.setText(str);
    }

    public void onChangeSkinType() {
        ao.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ao.setBackgroundResource(this.kgX, R.drawable.bg_rec_comment);
        ao.setViewTextColor(this.kgY, R.color.cp_cont_c, 1);
        ao.setViewTextColor(this.kgZ, R.color.cp_cont_e, 1);
        ao.setImageResource(this.kha, R.drawable.recommend_pb_share_selector);
    }
}
