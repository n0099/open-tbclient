package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class e extends as {
    private TextView fLJ;

    public e(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.fLJ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.as
    protected void a(d dVar) {
        this.fLJ = (TextView) this.mRootView.findViewById(e.g.icon_push);
        this.fLJ.setVisibility(8);
    }

    public void kB(boolean z) {
        if (this.fLJ != null) {
            if (z) {
                this.fLJ.setText(e.j.push);
                com.baidu.tbadk.core.util.al.h(this.fLJ, e.f.push_text_selector);
                com.baidu.tbadk.core.util.al.i(this.fLJ, e.f.push_bg_selector);
                this.fLJ.setClickable(true);
            } else {
                this.fLJ.setText(e.j.already_push);
                com.baidu.tbadk.core.util.al.i(this.fLJ, e.f.label_bg_gray80);
                com.baidu.tbadk.core.util.al.h(this.fLJ, e.d.cp_cont_d);
                this.fLJ.setClickable(false);
            }
            this.fLJ.setVisibility(0);
        }
    }

    public void ak(bb bbVar) {
        if (bbVar != null && bbVar.yX() != null) {
            int status = bbVar.yX().getStatus();
            if (status == 1) {
                kB(true);
            } else if (status == 2) {
                kB(false);
            }
        }
    }

    public TextView bfI() {
        return this.fLJ;
    }
}
