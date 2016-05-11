package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends ft {
    private TextView dik;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.dik = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ft
    protected void a(e eVar) {
        this.dik = (TextView) this.mRootView.findViewById(t.g.icon_push);
        this.dik.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.ft
    protected void onChangeSkinType(int i) {
    }

    public void gt(boolean z) {
        if (this.dik != null) {
            if (z) {
                this.dik.setText(t.j.push);
                com.baidu.tbadk.core.util.at.j((View) this.dik, t.f.push_text_selector);
                com.baidu.tbadk.core.util.at.k(this.dik, t.f.push_bg_selector);
                this.dik.setClickable(true);
            } else {
                this.dik.setText(t.j.already_push);
                com.baidu.tbadk.core.util.at.k(this.dik, t.f.label_bg_gray80);
                com.baidu.tbadk.core.util.at.j((View) this.dik, t.d.cp_cont_d);
                this.dik.setClickable(false);
            }
            this.dik.setVisibility(0);
        }
    }

    public void m(com.baidu.tbadk.core.data.ax axVar) {
        if (axVar != null && axVar.rc() != null) {
            int status = axVar.rc().getStatus();
            if (status == 1) {
                gt(true);
            } else if (status == 2) {
                gt(false);
            }
        }
    }

    public TextView awq() {
        return this.dik;
    }
}
