package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class f {
    private RelativeLayout jnf;
    private TextView jng;
    private TextView jnh;
    private ImageView jni;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.jnf = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.jng = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.jnh = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.jni = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void O(View.OnClickListener onClickListener) {
        this.jnf.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void P(View.OnClickListener onClickListener) {
        this.jni.setOnClickListener(onClickListener);
    }

    public void Hp(String str) {
        this.jnh.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.jnf, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.jng, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.jnh, R.color.cp_cont_e, 1);
        am.setImageResource(this.jni, R.drawable.recommend_pb_share_selector);
    }
}
