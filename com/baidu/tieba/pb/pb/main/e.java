package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends at {
    private TextView fes;

    public e(BaseActivity baseActivity, View view2) {
        super(baseActivity, view2);
        this.fes = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.at
    protected void a(d dVar) {
        this.fes = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fes.setVisibility(8);
    }

    public void jv(boolean z) {
        if (this.fes != null) {
            if (z) {
                this.fes.setText(d.k.push);
                com.baidu.tbadk.core.util.ak.h(this.fes, d.f.push_text_selector);
                com.baidu.tbadk.core.util.ak.i(this.fes, d.f.push_bg_selector);
                this.fes.setClickable(true);
            } else {
                this.fes.setText(d.k.already_push);
                com.baidu.tbadk.core.util.ak.i(this.fes, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.ak.h(this.fes, d.C0126d.cp_cont_d);
                this.fes.setClickable(false);
            }
            this.fes.setVisibility(0);
        }
    }

    public void ab(bd bdVar) {
        if (bdVar != null && bdVar.sj() != null) {
            int status = bdVar.sj().getStatus();
            if (status == 1) {
                jv(true);
            } else if (status == 2) {
                jv(false);
            }
        }
    }

    public TextView aWI() {
        return this.fes;
    }
}
