package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends ar {
    private TextView eIA;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eIA = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(c cVar) {
        this.eIA = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eIA.setVisibility(8);
    }

    public void iX(boolean z) {
        if (this.eIA != null) {
            if (z) {
                this.eIA.setText(d.l.push);
                com.baidu.tbadk.core.util.ai.i(this.eIA, d.g.push_text_selector);
                com.baidu.tbadk.core.util.ai.j(this.eIA, d.g.push_bg_selector);
                this.eIA.setClickable(true);
            } else {
                this.eIA.setText(d.l.already_push);
                com.baidu.tbadk.core.util.ai.j(this.eIA, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.ai.i(this.eIA, d.e.cp_cont_d);
                this.eIA.setClickable(false);
            }
            this.eIA.setVisibility(0);
        }
    }

    public void V(bl blVar) {
        if (blVar != null && blVar.sa() != null) {
            int status = blVar.sa().getStatus();
            if (status == 1) {
                iX(true);
            } else if (status == 2) {
                iX(false);
            }
        }
    }

    public TextView aQJ() {
        return this.eIA;
    }
}
