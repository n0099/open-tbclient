package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends as {
    private TextView fVr;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fVr = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fVr = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fVr.setVisibility(8);
    }

    public void kH(boolean z) {
        if (this.fVr != null) {
            if (z) {
                this.fVr.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fVr, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fVr, e.f.push_bg_selector);
                this.fVr.setClickable(true);
            } else {
                this.fVr.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fVr, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fVr, e.d.cp_cont_d);
                this.fVr.setClickable(false);
            }
            this.fVr.setVisibility(0);
        }
    }

    public void ak(bb bbVar) {
        if (bbVar != null && bbVar.Ab() != null) {
            int status = bbVar.Ab().getStatus();
            if (status == 1) {
                kH(true);
            } else if (status == 2) {
                kH(false);
            }
        }
    }

    public TextView bik() {
        return this.fVr;
    }
}
