package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends as {
    private TextView fSz;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fSz = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fSz = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fSz.setVisibility(8);
    }

    public void kE(boolean z) {
        if (this.fSz != null) {
            if (z) {
                this.fSz.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fSz, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fSz, e.f.push_bg_selector);
                this.fSz.setClickable(true);
            } else {
                this.fSz.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fSz, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fSz, e.d.cp_cont_d);
                this.fSz.setClickable(false);
            }
            this.fSz.setVisibility(0);
        }
    }

    public void ak(bb bbVar) {
        if (bbVar != null && bbVar.Ab() != null) {
            int status = bbVar.Ab().getStatus();
            if (status == 1) {
                kE(true);
            } else if (status == 2) {
                kE(false);
            }
        }
    }

    public TextView bhz() {
        return this.fSz;
    }
}
