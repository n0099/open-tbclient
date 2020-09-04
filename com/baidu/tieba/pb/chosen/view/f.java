package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class f {
    private ImageView kwA;
    private RelativeLayout kwx;
    private TextView kwy;
    private TextView kwz;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.kwx = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.kwy = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.kwz = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.kwA = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.kwx.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void R(View.OnClickListener onClickListener) {
        this.kwA.setOnClickListener(onClickListener);
    }

    public void Nk(String str) {
        this.kwz.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.kwx, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.kwy, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.kwz, R.color.cp_cont_e, 1);
        ap.setImageResource(this.kwA, R.drawable.recommend_pb_share_selector);
    }
}
