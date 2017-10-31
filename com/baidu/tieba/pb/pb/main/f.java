package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class f extends aq {
    private TextView eJJ;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eJJ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.aq
    protected void a(d dVar) {
        this.eJJ = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.eJJ.setVisibility(8);
    }

    public void iF(boolean z) {
        if (this.eJJ != null) {
            if (z) {
                this.eJJ.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.i(this.eJJ, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eJJ, d.f.push_bg_selector);
                this.eJJ.setClickable(true);
            } else {
                this.eJJ.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eJJ, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eJJ, d.C0080d.cp_cont_d);
                this.eJJ.setClickable(false);
            }
            this.eJJ.setVisibility(0);
        }
    }

    public void V(bh bhVar) {
        if (bhVar != null && bhVar.rO() != null) {
            int status = bhVar.rO().getStatus();
            if (status == 1) {
                iF(true);
            } else if (status == 2) {
                iF(false);
            }
        }
    }

    public TextView aRe() {
        return this.eJJ;
    }
}
