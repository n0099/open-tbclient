package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fGW;
    private TextView fGX;
    private TextView fGY;
    private ImageView fGZ;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fGW = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.fGX = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.fGY = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.fGZ = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void C(View.OnClickListener onClickListener) {
        this.fGW.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fGZ.setOnClickListener(onClickListener);
    }

    public void qi(String str) {
        this.fGY.setText(str);
    }

    public void onChangeSkinType() {
        aj.s(this.rootView, d.f.bg_rec_lick);
        aj.s(this.fGW, d.f.bg_rec_comment);
        aj.e(this.fGX, d.C0140d.cp_cont_c, 1);
        aj.e(this.fGY, d.C0140d.cp_cont_e, 1);
        aj.c(this.fGZ, d.f.recommend_pb_share_selector);
    }
}
