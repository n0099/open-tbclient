package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends as {
    private TextView fKj;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fKj = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fKj = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fKj.setVisibility(8);
    }

    public void kq(boolean z) {
        if (this.fKj != null) {
            if (z) {
                this.fKj.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fKj, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fKj, e.f.push_bg_selector);
                this.fKj.setClickable(true);
            } else {
                this.fKj.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fKj, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fKj, e.d.cp_cont_d);
                this.fKj.setClickable(false);
            }
            this.fKj.setVisibility(0);
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
        return this.fKj;
    }
}
