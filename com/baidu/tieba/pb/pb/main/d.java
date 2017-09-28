package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d extends ao {
    private TextView eBi;

    public d(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eBi = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(b bVar) {
        this.eBi = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eBi.setVisibility(8);
    }

    public void iJ(boolean z) {
        if (this.eBi != null) {
            if (z) {
                this.eBi.setText(d.l.push);
                com.baidu.tbadk.core.util.aj.i(this.eBi, d.g.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eBi, d.g.push_bg_selector);
                this.eBi.setClickable(true);
            } else {
                this.eBi.setText(d.l.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eBi, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eBi, d.e.cp_cont_d);
                this.eBi.setClickable(false);
            }
            this.eBi.setVisibility(0);
        }
    }

    public void V(bh bhVar) {
        if (bhVar != null && bhVar.rP() != null) {
            int status = bhVar.rP().getStatus();
            if (status == 1) {
                iJ(true);
            } else if (status == 2) {
                iJ(false);
            }
        }
    }

    public TextView aOb() {
        return this.eBi;
    }
}
