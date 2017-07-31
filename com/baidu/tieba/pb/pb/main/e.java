package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends ar {
    private TextView eGE;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eGE = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(c cVar) {
        this.eGE = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eGE.setVisibility(8);
    }

    public void iU(boolean z) {
        if (this.eGE != null) {
            if (z) {
                this.eGE.setText(d.l.push);
                com.baidu.tbadk.core.util.ai.i(this.eGE, d.g.push_text_selector);
                com.baidu.tbadk.core.util.ai.j(this.eGE, d.g.push_bg_selector);
                this.eGE.setClickable(true);
            } else {
                this.eGE.setText(d.l.already_push);
                com.baidu.tbadk.core.util.ai.j(this.eGE, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.ai.i(this.eGE, d.e.cp_cont_d);
                this.eGE.setClickable(false);
            }
            this.eGE.setVisibility(0);
        }
    }

    public void V(bl blVar) {
        if (blVar != null && blVar.rZ() != null) {
            int status = blVar.rZ().getStatus();
            if (status == 1) {
                iU(true);
            } else if (status == 2) {
                iU(false);
            }
        }
    }

    public TextView aQh() {
        return this.eGE;
    }
}
