package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e extends au {
    private TextView fuX;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fuX = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.au
    protected void a(d dVar) {
        this.fuX = (TextView) this.mRootView.findViewById(d.g.icon_push);
        this.fuX.setVisibility(8);
    }

    public void jy(boolean z) {
        if (this.fuX != null) {
            if (z) {
                this.fuX.setText(d.j.push);
                com.baidu.tbadk.core.util.am.h(this.fuX, d.f.push_text_selector);
                com.baidu.tbadk.core.util.am.i(this.fuX, d.f.push_bg_selector);
                this.fuX.setClickable(true);
            } else {
                this.fuX.setText(d.j.already_push);
                com.baidu.tbadk.core.util.am.i(this.fuX, d.f.label_bg_gray80);
                com.baidu.tbadk.core.util.am.h(this.fuX, d.C0140d.cp_cont_d);
                this.fuX.setClickable(false);
            }
            this.fuX.setVisibility(0);
        }
    }

    public void aj(bb bbVar) {
        if (bbVar != null && bbVar.vE() != null) {
            int status = bbVar.vE().getStatus();
            if (status == 1) {
                jy(true);
            } else if (status == 2) {
                jy(false);
            }
        }
    }

    public TextView baE() {
        return this.fuX;
    }
}
