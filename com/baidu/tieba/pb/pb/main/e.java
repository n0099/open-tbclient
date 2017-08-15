package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends ar {
    private TextView eIy;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eIy = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ar
    protected void a(c cVar) {
        this.eIy = (TextView) this.mRootView.findViewById(d.h.icon_push);
        this.eIy.setVisibility(8);
    }

    public void iX(boolean z) {
        if (this.eIy != null) {
            if (z) {
                this.eIy.setText(d.l.push);
                com.baidu.tbadk.core.util.ai.i(this.eIy, d.g.push_text_selector);
                com.baidu.tbadk.core.util.ai.j(this.eIy, d.g.push_bg_selector);
                this.eIy.setClickable(true);
            } else {
                this.eIy.setText(d.l.already_push);
                com.baidu.tbadk.core.util.ai.j(this.eIy, d.g.label_bg_gray80);
                com.baidu.tbadk.core.util.ai.i(this.eIy, d.e.cp_cont_d);
                this.eIy.setClickable(false);
            }
            this.eIy.setVisibility(0);
        }
    }

    public void V(bl blVar) {
        if (blVar != null && blVar.rZ() != null) {
            int status = blVar.rZ().getStatus();
            if (status == 1) {
                iX(true);
            } else if (status == 2) {
                iX(false);
            }
        }
    }

    public TextView aQO() {
        return this.eIy;
    }
}
