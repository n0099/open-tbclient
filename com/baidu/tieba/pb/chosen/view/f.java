package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f {
    private RelativeLayout kUh;
    private TextView kUi;
    private TextView kUj;
    private ImageView kUk;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.kUh = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.kUi = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.kUj = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.kUk = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.kUh.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void R(View.OnClickListener onClickListener) {
        this.kUk.setOnClickListener(onClickListener);
    }

    public void OB(String str) {
        this.kUj.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.kUh, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.kUi, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.kUj, R.color.cp_cont_e, 1);
        ap.setImageResource(this.kUk, R.drawable.recommend_pb_share_selector);
    }
}
