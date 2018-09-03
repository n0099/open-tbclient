package com.baidu.tieba.pb.chosen.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class f {
    private RelativeLayout fse;
    private TextView fsf;
    private TextView fsg;
    private ImageView fsh;
    private View rootView;

    public f(View view) {
        this.rootView = view;
        this.fse = (RelativeLayout) view.findViewById(f.g.chosen_pb_reply_text);
        this.fsf = (TextView) view.findViewById(f.g.chosen_pb_reply_comment);
        this.fsg = (TextView) view.findViewById(f.g.chosen_pb_reply_number);
        this.fsh = (ImageView) view.findViewById(f.g.chosen_pb_reply_share);
    }

    public void E(View.OnClickListener onClickListener) {
        this.fse.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void F(View.OnClickListener onClickListener) {
        this.fsh.setOnClickListener(onClickListener);
    }

    public void ra(String str) {
        this.fsg.setText(str);
    }

    public void onChangeSkinType() {
        am.i(this.rootView, f.C0146f.bg_rec_lick);
        am.i(this.fse, f.C0146f.bg_rec_comment);
        am.c(this.fsf, f.d.cp_cont_c, 1);
        am.c(this.fsg, f.d.cp_cont_e, 1);
        am.c(this.fsh, f.C0146f.recommend_pb_share_selector);
    }
}
