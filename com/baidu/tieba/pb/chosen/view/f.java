package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f {
    private RelativeLayout kwq;
    private TextView kwr;
    private TextView kws;
    private ImageView kwt;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.kwq = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.kwr = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.kws = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.kwt = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.kwq.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void R(View.OnClickListener onClickListener) {
        this.kwt.setOnClickListener(onClickListener);
    }

    public void Nj(String str) {
        this.kws.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.kwq, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.kwr, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.kws, R.color.cp_cont_e, 1);
        ap.setImageResource(this.kwt, R.drawable.recommend_pb_share_selector);
    }
}
