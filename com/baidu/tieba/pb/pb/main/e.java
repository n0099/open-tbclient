package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class e extends as {
    private TextView fCI;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fCI = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fCI = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fCI.setVisibility(8);
    }

    public void jZ(boolean z) {
        if (this.fCI != null) {
            if (z) {
                this.fCI.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fCI, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fCI, e.f.push_bg_selector);
                this.fCI.setClickable(true);
            } else {
                this.fCI.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fCI, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fCI, e.d.cp_cont_d);
                this.fCI.setClickable(false);
            }
            this.fCI.setVisibility(0);
        }
    }

    public void ak(bb bbVar) {
        if (bbVar != null && bbVar.wH() != null) {
            int status = bbVar.wH().getStatus();
            if (status == 1) {
                jZ(true);
            } else if (status == 2) {
                jZ(false);
            }
        }
    }

    public TextView bcZ() {
        return this.fCI;
    }
}
