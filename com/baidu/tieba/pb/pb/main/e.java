package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends ao {
    private TextView eGU;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eGU = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(c cVar) {
        this.eGU = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eGU.setVisibility(8);
    }

    public void iX(boolean z) {
        if (this.eGU != null) {
            if (z) {
                this.eGU.setText(d.l.push);
                com.baidu.tbadk.core.util.aj.i(this.eGU, d.g.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eGU, d.g.push_bg_selector);
                this.eGU.setClickable(true);
            } else {
                this.eGU.setText(d.l.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eGU, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eGU, d.e.cp_cont_d);
                this.eGU.setClickable(false);
            }
            this.eGU.setVisibility(0);
        }
    }

    public void aa(bj bjVar) {
        if (bjVar != null && bjVar.rV() != null) {
            int status = bjVar.rV().getStatus();
            if (status == 1) {
                iX(true);
            } else if (status == 2) {
                iX(false);
            }
        }
    }

    public TextView aPW() {
        return this.eGU;
    }
}
