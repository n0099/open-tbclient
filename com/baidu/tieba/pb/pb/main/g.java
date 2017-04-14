package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends gj {
    private TextView eik;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eik = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void a(e eVar) {
        this.eik = (TextView) this.mRootView.findViewById(w.h.icon_push);
        this.eik.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void onChangeSkinType(int i) {
    }

    /* renamed from: if  reason: not valid java name */
    public void m25if(boolean z) {
        if (this.eik != null) {
            if (z) {
                this.eik.setText(w.l.push);
                com.baidu.tbadk.core.util.aq.i(this.eik, w.g.push_text_selector);
                com.baidu.tbadk.core.util.aq.j(this.eik, w.g.push_bg_selector);
                this.eik.setClickable(true);
            } else {
                this.eik.setText(w.l.already_push);
                com.baidu.tbadk.core.util.aq.j(this.eik, w.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aq.i(this.eik, w.e.cp_cont_d);
                this.eik.setClickable(false);
            }
            this.eik.setVisibility(0);
        }
    }

    public void D(com.baidu.tbadk.core.data.bi biVar) {
        if (biVar != null && biVar.sI() != null) {
            int status = biVar.sI().getStatus();
            if (status == 1) {
                m25if(true);
            } else if (status == 2) {
                m25if(false);
            }
        }
    }

    public TextView aKl() {
        return this.eik;
    }
}
