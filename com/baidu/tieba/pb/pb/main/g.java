package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends gf {
    private TextView emB;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.emB = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void a(e eVar) {
        this.emB = (TextView) this.mRootView.findViewById(t.g.icon_push);
        this.emB.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void onChangeSkinType(int i) {
    }

    public void hT(boolean z) {
        if (this.emB != null) {
            if (z) {
                this.emB.setText(t.j.push);
                com.baidu.tbadk.core.util.av.j((View) this.emB, t.f.push_text_selector);
                com.baidu.tbadk.core.util.av.k(this.emB, t.f.push_bg_selector);
                this.emB.setClickable(true);
            } else {
                this.emB.setText(t.j.already_push);
                com.baidu.tbadk.core.util.av.k(this.emB, t.f.label_bg_gray80);
                com.baidu.tbadk.core.util.av.j((View) this.emB, t.d.cp_cont_d);
                this.emB.setClickable(false);
            }
            this.emB.setVisibility(0);
        }
    }

    public void s(com.baidu.tbadk.core.data.bg bgVar) {
        if (bgVar != null && bgVar.rT() != null) {
            int status = bgVar.rT().getStatus();
            if (status == 1) {
                hT(true);
            } else if (status == 2) {
                hT(false);
            }
        }
    }

    public TextView aMA() {
        return this.emB;
    }
}
