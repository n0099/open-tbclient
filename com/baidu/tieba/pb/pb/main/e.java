package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends ar {
    private TextView eFr;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eFr = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(c cVar) {
        this.eFr = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eFr.setVisibility(8);
    }

    public void iU(boolean z) {
        if (this.eFr != null) {
            if (z) {
                this.eFr.setText(d.l.push);
                com.baidu.tbadk.core.util.ai.i(this.eFr, d.g.push_text_selector);
                com.baidu.tbadk.core.util.ai.j(this.eFr, d.g.push_bg_selector);
                this.eFr.setClickable(true);
            } else {
                this.eFr.setText(d.l.already_push);
                com.baidu.tbadk.core.util.ai.j(this.eFr, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.ai.i(this.eFr, d.e.cp_cont_d);
                this.eFr.setClickable(false);
            }
            this.eFr.setVisibility(0);
        }
    }

    public void V(bl blVar) {
        if (blVar != null && blVar.rP() != null) {
            int status = blVar.rP().getStatus();
            if (status == 1) {
                iU(true);
            } else if (status == 2) {
                iU(false);
            }
        }
    }

    public TextView aPW() {
        return this.eFr;
    }
}
