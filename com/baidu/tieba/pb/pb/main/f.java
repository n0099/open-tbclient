package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends aq {
    private TextView eKd;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eKd = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(d dVar) {
        this.eKd = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.eKd.setVisibility(8);
    }

    public void iL(boolean z) {
        if (this.eKd != null) {
            if (z) {
                this.eKd.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.i(this.eKd, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eKd, d.f.push_bg_selector);
                this.eKd.setClickable(true);
            } else {
                this.eKd.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eKd, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eKd, d.C0080d.cp_cont_d);
                this.eKd.setClickable(false);
            }
            this.eKd.setVisibility(0);
        }
    }

    public void V(bh bhVar) {
        if (bhVar != null && bhVar.rO() != null) {
            int status = bhVar.rO().getStatus();
            if (status == 1) {
                iL(true);
            } else if (status == 2) {
                iL(false);
            }
        }
    }

    public TextView aRm() {
        return this.eKd;
    }
}
