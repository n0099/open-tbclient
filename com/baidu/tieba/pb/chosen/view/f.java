package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class f {
    private RelativeLayout lgG;
    private TextView lgH;
    private TextView lgI;
    private ImageView lgJ;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.lgG = (RelativeLayout) view.findViewById(R.id.chosen_pb_reply_text);
        this.lgH = (TextView) view.findViewById(R.id.chosen_pb_reply_comment);
        this.lgI = (TextView) view.findViewById(R.id.chosen_pb_reply_number);
        this.lgJ = (ImageView) view.findViewById(R.id.chosen_pb_reply_share);
    }

    public void Q(View.OnClickListener onClickListener) {
        this.lgG.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void R(View.OnClickListener onClickListener) {
        this.lgJ.setOnClickListener(onClickListener);
    }

    public void OZ(String str) {
        this.lgI.setText(str);
    }

    public void onChangeSkinType() {
        ap.setBackgroundResource(this.rootView, R.drawable.bg_rec_lick);
        ap.setBackgroundResource(this.lgG, R.drawable.bg_rec_comment);
        ap.setViewTextColor(this.lgH, R.color.cp_cont_c, 1);
        ap.setViewTextColor(this.lgI, R.color.cp_cont_e, 1);
        ap.setImageResource(this.lgJ, R.drawable.recommend_pb_share_selector);
    }
}
