package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class g extends hl {
    private TextView euj;

    public g(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.euj = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.hl
    protected void a(e eVar) {
        this.euj = (TextView) this.mRootView.findViewById(w.h.icon_push);
        this.euj.setVisibility(8);
    }

    public void iA(boolean z) {
        if (this.euj != null) {
            if (z) {
                this.euj.setText(w.l.push);
                com.baidu.tbadk.core.util.as.i(this.euj, w.g.push_text_selector);
                com.baidu.tbadk.core.util.as.j(this.euj, w.g.push_bg_selector);
                this.euj.setClickable(true);
            } else {
                this.euj.setText(w.l.already_push);
                com.baidu.tbadk.core.util.as.j(this.euj, w.g.label_bg_gray80);
                com.baidu.tbadk.core.util.as.i(this.euj, w.e.cp_cont_d);
                this.euj.setClickable(false);
            }
            this.euj.setVisibility(0);
        }
    }

    public void P(com.baidu.tbadk.core.data.bm bmVar) {
        if (bmVar != null && bmVar.rL() != null) {
            int status = bmVar.rL().getStatus();
            if (status == 1) {
                iA(true);
            } else if (status == 2) {
                iA(false);
            }
        }
    }

    public TextView aNt() {
        return this.euj;
    }
}
