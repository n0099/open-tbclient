package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f extends at {
    private TextView fHm;

    public f(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fHm = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.at
    protected void a(d dVar) {
        this.fHm = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fHm.setVisibility(8);
    }

    public void jK(boolean z) {
        if (this.fHm != null) {
            if (z) {
                this.fHm.setText(d.j.push);
                com.baidu.tbadk.core.util.aj.r(this.fHm, d.f.push_text_selector);
                com.baidu.tbadk.core.util.aj.s(this.fHm, d.f.push_bg_selector);
                this.fHm.setClickable(true);
            } else {
                this.fHm.setText(d.j.already_push);
                com.baidu.tbadk.core.util.aj.s(this.fHm, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.r(this.fHm, d.C0108d.cp_cont_d);
                this.fHm.setClickable(false);
            }
            this.fHm.setVisibility(0);
        }
    }

    public void W(bd bdVar) {
        if (bdVar != null && bdVar.zo() != null) {
            int status = bdVar.zo().getStatus();
            if (status == 1) {
                jK(true);
            } else if (status == 2) {
                jK(false);
            }
        }
    }

    public TextView bag() {
        return this.fHm;
    }
}
