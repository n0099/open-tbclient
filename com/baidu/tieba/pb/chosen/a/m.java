package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class m {
    private RelativeLayout caM;
    private TextView caN;
    private TextView caO;
    private ImageView caP;
    private View rootView;

    public m(View view) {
        this.rootView = view;
        this.caM = (RelativeLayout) view.findViewById(i.f.chosen_pb_reply_text);
        this.caN = (TextView) view.findViewById(i.f.chosen_pb_reply_comment);
        this.caO = (TextView) view.findViewById(i.f.chosen_pb_reply_number);
        this.caP = (ImageView) view.findViewById(i.f.chosen_pb_reply_share);
    }

    public void y(View.OnClickListener onClickListener) {
        this.caM.setOnClickListener(onClickListener);
    }

    public void setVisible(boolean z) {
        this.rootView.setVisibility(z ? 0 : 8);
    }

    public void z(View.OnClickListener onClickListener) {
        this.caP.setOnClickListener(onClickListener);
    }

    public void jn(String str) {
        this.caO.setText(str);
    }

    public void tf() {
        al.h(this.rootView, i.e.bg_rec_lick);
        al.h(this.caM, i.e.bg_rec_comment);
        al.b(this.caN, i.c.cp_cont_c, 1);
        al.b(this.caO, i.c.cp_cont_e, 1);
        al.c(this.caP, i.e.recommend_pb_share_selector);
    }
}
