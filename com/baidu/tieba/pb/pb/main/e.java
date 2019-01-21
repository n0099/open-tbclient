package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends as {
    private TextView fWp;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fWp = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fWp = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fWp.setVisibility(8);
    }

    public void kH(boolean z) {
        if (this.fWp != null) {
            if (z) {
                this.fWp.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fWp, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fWp, e.f.push_bg_selector);
                this.fWp.setClickable(true);
            } else {
                this.fWp.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fWp, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fWp, e.d.cp_cont_d);
                this.fWp.setClickable(false);
            }
            this.fWp.setVisibility(0);
        }
    }

    public void ak(bb bbVar) {
        if (bbVar != null && bbVar.Ao() != null) {
            int status = bbVar.Ao().getStatus();
            if (status == 1) {
                kH(true);
            } else if (status == 2) {
                kH(false);
            }
        }
    }

    public TextView biO() {
        return this.fWp;
    }
}
