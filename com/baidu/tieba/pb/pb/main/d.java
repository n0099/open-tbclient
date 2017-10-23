package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends ao {
    private TextView eAU;

    public d(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eAU = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(b bVar) {
        this.eAU = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eAU.setVisibility(8);
    }

    public void iI(boolean z) {
        if (this.eAU != null) {
            if (z) {
                this.eAU.setText(d.l.push);
                com.baidu.tbadk.core.util.aj.i(this.eAU, d.g.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eAU, d.g.push_bg_selector);
                this.eAU.setClickable(true);
            } else {
                this.eAU.setText(d.l.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eAU, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eAU, d.e.cp_cont_d);
                this.eAU.setClickable(false);
            }
            this.eAU.setVisibility(0);
        }
    }

    public void V(bh bhVar) {
        if (bhVar != null && bhVar.rI() != null) {
            int status = bhVar.rI().getStatus();
            if (status == 1) {
                iI(true);
            } else if (status == 2) {
                iI(false);
            }
        }
    }

    public TextView aNW() {
        return this.eAU;
    }
}
