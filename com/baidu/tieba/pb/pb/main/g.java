package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends gj {
    private TextView ekA;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.ekA = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void a(e eVar) {
        this.ekA = (TextView) this.mRootView.findViewById(w.h.icon_push);
        this.ekA.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void onChangeSkinType(int i) {
    }

    public void ip(boolean z) {
        if (this.ekA != null) {
            if (z) {
                this.ekA.setText(w.l.push);
                com.baidu.tbadk.core.util.aq.i(this.ekA, w.g.push_text_selector);
                com.baidu.tbadk.core.util.aq.j(this.ekA, w.g.push_bg_selector);
                this.ekA.setClickable(true);
            } else {
                this.ekA.setText(w.l.already_push);
                com.baidu.tbadk.core.util.aq.j(this.ekA, w.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aq.i(this.ekA, w.e.cp_cont_d);
                this.ekA.setClickable(false);
            }
            this.ekA.setVisibility(0);
        }
    }

    public void D(com.baidu.tbadk.core.data.bi biVar) {
        if (biVar != null && biVar.sI() != null) {
            int status = biVar.sI().getStatus();
            if (status == 1) {
                ip(true);
            } else if (status == 2) {
                ip(false);
            }
        }
    }

    public TextView aLm() {
        return this.ekA;
    }
}
