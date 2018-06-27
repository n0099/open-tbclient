package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends au {
    private TextView fuM;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fuM = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.au
    protected void a(d dVar) {
        this.fuM = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fuM.setVisibility(8);
    }

    public void jM(boolean z) {
        if (this.fuM != null) {
            if (z) {
                this.fuM.setText(d.k.push);
                com.baidu.tbadk.core.util.am.h(this.fuM, d.f.push_text_selector);
                com.baidu.tbadk.core.util.am.i(this.fuM, d.f.push_bg_selector);
                this.fuM.setClickable(true);
            } else {
                this.fuM.setText(d.k.already_push);
                com.baidu.tbadk.core.util.am.i(this.fuM, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.am.h(this.fuM, d.C0142d.cp_cont_d);
                this.fuM.setClickable(false);
            }
            this.fuM.setVisibility(0);
        }
    }

    public void ai(bc bcVar) {
        if (bcVar != null && bcVar.vP() != null) {
            int status = bcVar.vP().getStatus();
            if (status == 1) {
                jM(true);
            } else if (status == 2) {
                jM(false);
            }
        }
    }

    public TextView bcl() {
        return this.fuM;
    }
}
