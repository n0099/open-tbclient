package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fGL;
    private TextView fGM;
    private TextView fGN;
    private ImageView fGO;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fGL = (RelativeLayout) view.findViewById(d.g.chosen_pb_reply_text);
        this.fGM = (TextView) view.findViewById(d.g.chosen_pb_reply_comment);
        this.fGN = (TextView) view.findViewById(d.g.chosen_pb_reply_number);
        this.fGO = (ImageView) view.findViewById(d.g.chosen_pb_reply_share);
    }

    public void C(View.OnClickListener onClickListener) {
        this.fGL.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void D(View.OnClickListener onClickListener) {
        this.fGO.setOnClickListener(onClickListener);
    }

    public void qi(String str) {
        this.fGN.setText(str);
    }

    public void onChangeSkinType() {
        aj.s(this.rootView, d.f.bg_rec_lick);
        aj.s(this.fGL, d.f.bg_rec_comment);
        aj.e(this.fGM, d.C0141d.cp_cont_c, 1);
        aj.e(this.fGN, d.C0141d.cp_cont_e, 1);
        aj.c(this.fGO, d.f.recommend_pb_share_selector);
    }
}
