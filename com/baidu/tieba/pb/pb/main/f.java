package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends at {
    private TextView fGR;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fGR = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.at
    protected void a(d dVar) {
        this.fGR = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fGR.setVisibility(8);
    }

    public void jI(boolean z) {
        if (this.fGR != null) {
            if (z) {
                this.fGR.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.r(this.fGR, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.s(this.fGR, d.f.push_bg_selector);
                this.fGR.setClickable(true);
            } else {
                this.fGR.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.s(this.fGR, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.r(this.fGR, d.C0107d.cp_cont_d);
                this.fGR.setClickable(false);
            }
            this.fGR.setVisibility(0);
        }
    }

    public void W(bd bdVar) {
        if (bdVar != null && bdVar.zn() != null) {
            int status = bdVar.zn().getStatus();
            if (status == 1) {
                jI(true);
            } else if (status == 2) {
                jI(false);
            }
        }
    }

    public TextView bab() {
        return this.fGR;
    }
}
