package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class f {
    private RelativeLayout izq;
    private TextView izr;
    private TextView izs;
    private ImageView izt;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.izq = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.izr = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.izs = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.izt = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void M(View.OnClickListener onClickListener) {
        this.izq.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void N(View.OnClickListener onClickListener) {
        this.izt.setOnClickListener(onClickListener);
    }

    public void Fs(String str) {
        this.izs.setText(str);
    }

    public void onChangeSkinType() {
        am.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        am.setBackgroundResource(this.izq, R.drawable.bg_rec_comment);
        am.setViewTextColor(this.izr, R.color.cp_cont_c, 1);
        am.setViewTextColor(this.izs, R.color.cp_cont_e, 1);
        am.setImageResource(this.izt, R.drawable.recommend_pb_share_selector);
    }
}
