package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g extends gb {
    private TextView dYE;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.dYE = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gb
    protected void a(e eVar) {
        this.dYE = (TextView) this.mRootView.findViewById(r.g.icon_push);
        this.dYE.setVisibility(8);
    }

    @Override // com.baidu.tieba.pb.pb.main.gb
    protected void onChangeSkinType(int i) {
    }

    public void ia(boolean z) {
        if (this.dYE != null) {
            if (z) {
                this.dYE.setText(r.j.push);
                com.baidu.tbadk.core.util.ar.j((View) this.dYE, r.f.push_text_selector);
                com.baidu.tbadk.core.util.ar.k(this.dYE, r.f.push_bg_selector);
                this.dYE.setClickable(true);
            } else {
                this.dYE.setText(r.j.already_push);
                com.baidu.tbadk.core.util.ar.k(this.dYE, r.f.label_bg_gray80);
                com.baidu.tbadk.core.util.ar.j((View) this.dYE, r.d.cp_cont_d);
                this.dYE.setClickable(false);
            }
            this.dYE.setVisibility(0);
        }
    }

    public void A(com.baidu.tbadk.core.data.bg bgVar) {
        if (bgVar != null && bgVar.rY() != null) {
            int status = bgVar.rY().getStatus();
            if (status == 1) {
                ia(true);
            } else if (status == 2) {
                ia(false);
            }
        }
    }

    public TextView aIW() {
        return this.dYE;
    }
}
