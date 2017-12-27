package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends at {
    private TextView fFr;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fFr = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.at
    protected void a(d dVar) {
        this.fFr = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fFr.setVisibility(8);
    }

    public void jF(boolean z) {
        if (this.fFr != null) {
            if (z) {
                this.fFr.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.r(this.fFr, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.s(this.fFr, d.f.push_bg_selector);
                this.fFr.setClickable(true);
            } else {
                this.fFr.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.s(this.fFr, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.r(this.fFr, d.C0108d.cp_cont_d);
                this.fFr.setClickable(false);
            }
            this.fFr.setVisibility(0);
        }
    }

    public void W(be beVar) {
        if (beVar != null && beVar.zs() != null) {
            int status = beVar.zs().getStatus();
            if (status == 1) {
                jF(true);
            } else if (status == 2) {
                jF(false);
            }
        }
    }

    public TextView aZX() {
        return this.fFr;
    }
}
