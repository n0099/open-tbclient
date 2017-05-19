package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends gs {
    private TextView efJ;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.efJ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gs
    protected void a(e eVar) {
        this.efJ = (TextView) this.mRootView.findViewById(w.h.icon_push);
        this.efJ.setVisibility(8);
    }

    public void hQ(boolean z) {
        if (this.efJ != null) {
            if (z) {
                this.efJ.setText(w.l.push);
                com.baidu.tbadk.core.util.aq.i(this.efJ, w.g.push_text_selector);
                com.baidu.tbadk.core.util.aq.j(this.efJ, w.g.push_bg_selector);
                this.efJ.setClickable(true);
            } else {
                this.efJ.setText(w.l.already_push);
                com.baidu.tbadk.core.util.aq.j(this.efJ, w.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aq.i(this.efJ, w.e.cp_cont_d);
                this.efJ.setClickable(false);
            }
            this.efJ.setVisibility(0);
        }
    }

    public void H(com.baidu.tbadk.core.data.bk bkVar) {
        if (bkVar != null && bkVar.rS() != null) {
            int status = bkVar.rS().getStatus();
            if (status == 1) {
                hQ(true);
            } else if (status == 2) {
                hQ(false);
            }
        }
    }

    public TextView aIH() {
        return this.efJ;
    }
}
