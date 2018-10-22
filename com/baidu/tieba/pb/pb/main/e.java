package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends as {
    private TextView fKk;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fKk = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fKk = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fKk.setVisibility(8);
    }

    public void kq(boolean z) {
        if (this.fKk != null) {
            if (z) {
                this.fKk.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fKk, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fKk, e.f.push_bg_selector);
                this.fKk.setClickable(true);
            } else {
                this.fKk.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fKk, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fKk, e.d.cp_cont_d);
                this.fKk.setClickable(false);
            }
            this.fKk.setVisibility(0);
        }
    }

    public void ak(bb bbVar) {
        if (bbVar != null && bbVar.yQ() != null) {
            int status = bbVar.yQ().getStatus();
            if (status == 1) {
                kq(true);
            } else if (status == 2) {
                kq(false);
            }
        }
    }

    public TextView bgl() {
        return this.fKk;
    }
}
