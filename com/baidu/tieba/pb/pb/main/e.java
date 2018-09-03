package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class e extends au {
    private TextView fuQ;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fuQ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.au
    protected void a(d dVar) {
        this.fuQ = (TextView) this.mRootView.findViewById(f.g.icon_push);
        this.fuQ.setVisibility(8);
    }

    public void jy(boolean z) {
        if (this.fuQ != null) {
            if (z) {
                this.fuQ.setText(f.j.push);
                com.baidu.tbadk.core.util.am.h(this.fuQ, f.C0146f.push_text_selector);
                com.baidu.tbadk.core.util.am.i(this.fuQ, f.C0146f.push_bg_selector);
                this.fuQ.setClickable(true);
            } else {
                this.fuQ.setText(f.j.already_push);
                com.baidu.tbadk.core.util.am.i(this.fuQ, f.C0146f.label_bg_gray80);
                com.baidu.tbadk.core.util.am.h(this.fuQ, f.d.cp_cont_d);
                this.fuQ.setClickable(false);
            }
            this.fuQ.setVisibility(0);
        }
    }

    public void aj(bb bbVar) {
        if (bbVar != null && bbVar.vD() != null) {
            int status = bbVar.vD().getStatus();
            if (status == 1) {
                jy(true);
            } else if (status == 2) {
                jy(false);
            }
        }
    }

    public TextView baz() {
        return this.fuQ;
    }
}
