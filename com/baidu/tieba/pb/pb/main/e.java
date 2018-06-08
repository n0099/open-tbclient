package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends at {
    private TextView fqT;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fqT = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.at
    protected void a(d dVar) {
        this.fqT = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fqT.setVisibility(8);
    }

    public void jC(boolean z) {
        if (this.fqT != null) {
            if (z) {
                this.fqT.setText(d.k.push);
                com.baidu.tbadk.core.util.al.h(this.fqT, d.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fqT, d.f.push_bg_selector);
                this.fqT.setClickable(true);
            } else {
                this.fqT.setText(d.k.already_push);
                com.baidu.tbadk.core.util.al.i(this.fqT, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fqT, d.C0141d.cp_cont_d);
                this.fqT.setClickable(false);
            }
            this.fqT.setVisibility(0);
        }
    }

    public void ad(bd bdVar) {
        if (bdVar != null && bdVar.vF() != null) {
            int status = bdVar.vF().getStatus();
            if (status == 1) {
                jC(true);
            } else if (status == 2) {
                jC(false);
            }
        }
    }

    public TextView bbE() {
        return this.fqT;
    }
}
