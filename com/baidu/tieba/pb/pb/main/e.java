package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends ao {
    private TextView eHO;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eHO = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ao
    protected void a(c cVar) {
        this.eHO = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eHO.setVisibility(8);
    }

    public void iY(boolean z) {
        if (this.eHO != null) {
            if (z) {
                this.eHO.setText(d.l.push);
                com.baidu.tbadk.core.util.aj.i(this.eHO, d.g.push_text_selector);
                com.baidu.tbadk.core.util.aj.j(this.eHO, d.g.push_bg_selector);
                this.eHO.setClickable(true);
            } else {
                this.eHO.setText(d.l.already_push);
                com.baidu.tbadk.core.util.aj.j(this.eHO, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.aj.i(this.eHO, d.e.cp_cont_d);
                this.eHO.setClickable(false);
            }
            this.eHO.setVisibility(0);
        }
    }

    public void aa(bj bjVar) {
        if (bjVar != null && bjVar.rV() != null) {
            int status = bjVar.rV().getStatus();
            if (status == 1) {
                iY(true);
            } else if (status == 2) {
                iY(false);
            }
        }
    }

    public TextView aQh() {
        return this.eHO;
    }
}
